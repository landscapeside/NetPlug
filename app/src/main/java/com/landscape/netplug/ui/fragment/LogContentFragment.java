package com.landscape.netplug.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
import rx.functions.Func1;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentFragment extends BaseFragment<LogContentView.LogContentAction> implements LogContentView {

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

  @Override public void clear() {
    logAdapter.clear();
  }

  @Override public void scroll2Top() {
    listLog.smoothScrollToPosition(0);
  }

  @Override public void scroll2Bottom() {
    int count = logAdapter.getCount();
    int position = count - 1;
    if (position > 0) {
      listLog.smoothScrollToPosition(position);
    }
  }

  @Override public Observable<LogContentAction> asClearAction() {
    return userActionObservable().filter(
        logContentAction -> LogContentAction.CLEAR.equals(logContentAction));
  }

  @Override public Observable<LogContentAction> asShareAction() {
    return userActionObservable().filter(
        logContentAction -> LogContentAction.SHARE.equals(logContentAction));
  }

  @Override public Observable<LogContentAction> asScrollUpAction() {
    return userActionObservable().filter(
        logContentAction -> LogContentAction.SCROLL_TOP.equals(logContentAction));
  }

  @Override public Observable<LogContentAction> asScrollBottomAction() {
    return userActionObservable().filter(
        logContentAction -> LogContentAction.SCROLL_BOTTOM.equals(logContentAction));
  }

  @OnClick({R.id.btn_clear,R.id.btn_share,R.id.btn_to_top,R.id.btn_to_bottom})
  public void onBtnAction(View view) {
    actionSubject.onNext(LogContentAction.from(view.getId()));
  }
}
