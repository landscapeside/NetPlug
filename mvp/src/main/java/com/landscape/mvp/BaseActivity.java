package com.landscape.mvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.landscape.mvp.utils.ResValidCheck;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (ResValidCheck.isValid(layoutRes())) {
      setContentView(layoutRes());
      onPrepare(savedInstanceState);
      onReady(savedInstanceState);
    }
  }

  protected abstract @LayoutRes int layoutRes();

  protected void onPrepare(@Nullable Bundle savedInstanceState){}

  protected abstract void onReady(@Nullable Bundle savedInstanceState);

  protected void bindMVP(BasePresenter presenter,BaseView view) {
    presenter.attach(view);
  }
}
