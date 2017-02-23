package com.landscape.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.landscape.mvp.utils.ResValidCheck;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public abstract class BaseFragment extends Fragment {

  protected View rootView;
  private Unbinder unbinder;
  private boolean prepare = false;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (ResValidCheck.isValid(layoutRes())) {
      rootView = inflater.inflate(layoutRes(), container, false);
      unbinder = ButterKnife.bind(this,rootView);
      onPrepare(savedInstanceState);
      return rootView;
    }
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    prepare = true;
    onReady(savedInstanceState);
  }

  protected abstract @LayoutRes int layoutRes();

  protected void onPrepare(@Nullable Bundle savedInstanceState){}

  protected abstract void onReady(@Nullable Bundle savedInstanceState);

  protected void bindMVP(BasePresenter presenter,BaseView view) {
    presenter.attach(view);
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isLazy()) {
      if (getUserVisibleHint() && prepare) {
        onLazyVisible();
      } else {
        onLazyInvisible();
      }
    }
  }

  protected void onLazyVisible() {
  }

  protected void onLazyInvisible() {
  }

  protected boolean isLazy() {
    return false;
  }
}
