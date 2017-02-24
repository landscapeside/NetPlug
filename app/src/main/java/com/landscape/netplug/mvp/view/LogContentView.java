package com.landscape.netplug.mvp.view;

import com.landscape.mvp.BaseView;
import com.landscape.netplug.log.LumberYard;
import java.util.List;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public interface LogContentView extends BaseView {

  void setLogs(List<LumberYard.Entry> logs);

  void oneLog(LumberYard.Entry entry);

  enum LogContentAction{
    CLEAR,
    SHARE,
    SCROLL_TOP,
    SCROLL_BOTTOM
  }

}
