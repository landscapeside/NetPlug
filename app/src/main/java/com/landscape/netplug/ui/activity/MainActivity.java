package com.landscape.netplug.ui.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.landscape.mvp.BaseActivity;
import com.landscape.netplug.R;
import com.landscape.netplug.mvp.presenter.LogContentPresenter;
import com.landscape.netplug.mvp.presenter.SuitManagerPresenter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject LogContentPresenter logContentPresenter;
  @Inject SuitManagerPresenter suitManagerPresenter;

  @Override protected int layoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {

  }
}
