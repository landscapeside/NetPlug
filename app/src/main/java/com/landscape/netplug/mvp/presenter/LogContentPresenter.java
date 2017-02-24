package com.landscape.netplug.mvp.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import javax.inject.Inject;
import rx.functions.Action1;

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
}
