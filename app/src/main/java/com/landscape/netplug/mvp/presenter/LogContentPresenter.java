package com.landscape.netplug.mvp.presenter;

import android.os.Bundle;
import com.landscape.mvp.BaseActivity;
import com.landscape.mvp.BasePresenter;
import com.landscape.mvp.presenter.ActivityPresenter;
import com.landscape.mvp.presenter.RxPresenter;
import com.landscape.netplug.mvp.view.LogContentView;
import com.utils.behavior.FragmentsUtils;
import javax.inject.Inject;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentPresenter extends ActivityPresenter<LogContentView> {

  @Inject public LogContentPresenter() {

  }

  @Override protected void attachToActivity(BaseActivity activity) {

  }
}
