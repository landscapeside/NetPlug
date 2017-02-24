package com.landscape.netplug.ui.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import com.landscape.mvp.BaseActivity;
import com.landscape.netplug.Injector;
import com.landscape.netplug.R;
import com.landscape.netplug.di.components.DaggerViewPresenterComponent;
import com.landscape.netplug.log.LumberYard;
import com.landscape.netplug.mvp.presenter.LogContentPresenter;
import com.landscape.netplug.mvp.presenter.SuitManagerPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject LogContentPresenter logContentPresenter;
  @Inject SuitManagerPresenter suitManagerPresenter;

  @Override protected int layoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onPrepare(@Nullable Bundle savedInstanceState) {
    DaggerViewPresenterComponent.builder()
        .appComponent(Injector.obtain(getApplicationContext()))
        .build()
        .inject(this);
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {
    logContentPresenter.attachToActivity(this);
    suitManagerPresenter.attachToActivity(this);
  }
}
