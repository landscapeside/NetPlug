package com.landscape.mvp.presenter;

import android.os.Bundle;
import com.landscape.mvp.BasePresenter;
import com.landscape.mvp.BaseView;
import rx.subscriptions.CompositeSubscription;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
  protected final CompositeSubscription subscriptions = new CompositeSubscription();
  protected T baseView;

  @Override public void attach(T view) {
    baseView = view;
  }

  @Override public void restoreInstanceState(Bundle savedInstanceState) {

  }

  @Override public void saveInstanceState(Bundle outState) {

  }

  @Override public void detach() {
    subscriptions.clear();
    baseView = null;
  }
}
