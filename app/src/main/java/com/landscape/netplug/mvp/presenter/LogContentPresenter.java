package com.landscape.netplug.mvp.presenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.landscape.mvp.BaseActivity;
import com.landscape.mvp.BasePresenter;
import com.landscape.mvp.presenter.ActivityPresenter;
import com.landscape.mvp.presenter.RxPresenter;
import com.landscape.netplug.R;
import com.landscape.netplug.log.LumberYard;
import com.landscape.netplug.mvp.view.LogContentView;
import com.landscape.netplug.ui.fragment.LogContentFragment;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.utils.behavior.FragmentsUtils;
import com.utils.behavior.Intents;
import java.io.File;
import javax.inject.Inject;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentPresenter extends ActivityPresenter<LogContentView> {

  @Inject LumberYard lumberYard;

  @Inject public LogContentPresenter() {
    attach(new LogContentFragment());
    baseView.delegateLifecycle()
        .compose(subscribeLifeTrans(FragmentEvent.ATTACH))
        .subscribe(this::onViewAttached);
    baseView.asClearAction().subscribe(this::onClear);
    baseView.asShareAction().subscribe(this::onShare);
    baseView.asScrollUpAction().subscribe(this::onScroll2Top);
    baseView.asScrollBottomAction().subscribe(this::onScroll2Bottom);
  }

  @Override public void attachToActivity(BaseActivity activity) {
    FragmentsUtils.addFragmentToActivity(activity.getSupportFragmentManager(), (Fragment) baseView, R.id.log_container);
  }

  @Override public void onViewAttached(FragmentEvent event) {
    baseView.setLogs(lumberYard.bufferedLogs());
    lumberYard.logs()
        .compose(baseView.delegateBindUntilEvent(FragmentEvent.DETACH))
        .compose(schedulerTrans())
        .subscribe(baseView::oneLog);
  }

  private void onClear(LogContentView.LogContentAction action) {
    lumberYard.clear();
    baseView.clear();
  }

  private void onShare(LogContentView.LogContentAction action) {
    lumberYard.save() //
        .subscribeOn(Schedulers.io()) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(new Subscriber<File>() {
          @Override public void onCompleted() {
            // NO-OP.
          }

          @Override public void onError(Throwable e) {
            Toast.makeText(((Fragment)baseView).getContext(), "Couldn't save the logs for sharing.", Toast.LENGTH_SHORT)
                .show();
          }

          @Override public void onNext(File file) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            Intents.maybeStartChooser(((Fragment)baseView).getContext(), sendIntent);
          }
        });
  }

  private void onScroll2Top(LogContentView.LogContentAction action) {
    baseView.scroll2Top();
  }

  private void onScroll2Bottom(LogContentView.LogContentAction action) {
    baseView.scroll2Bottom();
  }
}
