package com.landscape.netplug.mvp.view;

import android.support.annotation.IdRes;
import com.landscape.mvp.BaseView;
import com.landscape.netplug.R;
import com.landscape.netplug.log.LumberYard;
import java.util.List;
import rx.Observable;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public interface LogContentView extends BaseView<LogContentView.LogContentAction> {

  void setLogs(List<LumberYard.Entry> logs);

  void oneLog(LumberYard.Entry entry);

  void clear();

  void scroll2Top();

  void scroll2Bottom();

  Observable<LogContentAction> asClearAction();

  Observable<LogContentAction> asShareAction();

  Observable<LogContentAction> asScrollUpAction();

  Observable<LogContentAction> asScrollBottomAction();

  enum LogContentAction {
    CLEAR(R.id.btn_clear),
    SHARE(R.id.btn_share),
    SCROLL_TOP(R.id.btn_to_top),
    SCROLL_BOTTOM(R.id.btn_to_bottom);

    LogContentAction(@IdRes int resId) {
      this.resId = resId;
    }

    private @IdRes int resId;

    public static LogContentAction from(@IdRes int resId) {
      for (LogContentAction action : values()) {
        if (resId == action.resId) {
          return action;
        }
      }
      return null;
    }
  }
}
