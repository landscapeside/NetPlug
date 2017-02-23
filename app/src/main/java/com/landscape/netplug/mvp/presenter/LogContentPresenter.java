package com.landscape.netplug.mvp.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.landscape.mvp.BaseActivity;
import com.landscape.mvp.BasePresenter;
import com.landscape.mvp.presenter.ActivityPresenter;
import com.landscape.mvp.presenter.RxPresenter;
import com.landscape.netplug.R;
import com.landscape.netplug.mvp.view.LogContentView;
import com.landscape.netplug.ui.fragment.LogContentFragment;
import com.utils.behavior.FragmentsUtils;
import javax.inject.Inject;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentPresenter extends ActivityPresenter<LogContentView> {

  @Inject public LogContentPresenter() {
    attach(new LogContentFragment());
  }

  @Override protected void attachToActivity(BaseActivity activity) {
    FragmentsUtils.addFragmentToActivity(activity.getSupportFragmentManager(), (Fragment) baseView, R.id.log_container);
  }
}
