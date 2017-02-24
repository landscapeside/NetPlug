package com.landscape.netplug.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.landscape.mvp.BaseFragment;
import com.landscape.netplug.R;
import com.landscape.netplug.log.LogAdapter;
import com.landscape.netplug.log.LumberYard;
import com.landscape.netplug.mvp.view.LogContentView;
import com.trello.rxlifecycle.android.FragmentEvent;
import java.util.List;
import javax.annotation.Nonnull;
import rx.Observable;
import rx.Subscriber;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentFragment extends BaseFragment implements LogContentView {

  LogAdapter logAdapter;

  @BindView(R.id.list_log) ListView listLog;

  @Override protected int layoutRes() {
    return R.layout.fragment_log_content;
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {
    listLog.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
    logAdapter = new LogAdapter(getContext());
    listLog.setAdapter(logAdapter);
  }

  @Override public void setLogs(List<LumberYard.Entry> logs) {
    logAdapter.setLogs(logs);
  }

  @Override public void oneLog(LumberYard.Entry entry) {
    logAdapter.call(entry);
  }

  @Nonnull @Override public Observable<LogContentAction> userActionObservable() {
    return Observable.create(new Observable.OnSubscribe<LogContentAction>() {
      @Override public void call(Subscriber<? super LogContentAction> subscriber) {

      }
    });
  }
}
