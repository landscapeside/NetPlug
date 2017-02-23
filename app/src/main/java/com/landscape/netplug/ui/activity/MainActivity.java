package com.landscape.netplug.ui.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.landscape.mvp.BaseActivity;
import com.landscape.netplug.R;

public class MainActivity extends BaseActivity {

  @Override protected int layoutRes() {
    return R.layout.activity_main;
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {

  }
}
