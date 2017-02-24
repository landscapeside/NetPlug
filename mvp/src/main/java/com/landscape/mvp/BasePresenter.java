package com.landscape.mvp;

import android.os.Bundle;
import com.trello.rxlifecycle.android.FragmentEvent;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 *
 * @author shun.jiang (494326656@qq.com)
 */

public interface BasePresenter<V extends BaseView> {
  /**
   * Method that attach to {@link BaseView}. Each view should invoke this method, so that
   * the presenter can control view.
   */
  void attach(V view);

  /**
   * Method that restore instance state. It should be called in the view's {Activity or Fragment}
   * restoreInstanceState.
   *
   * @param savedInstanceState {@link Bundle}
   */
  void restoreInstanceState(Bundle savedInstanceState);

  /**
   * Method that restore instance state. It should be called in the view's {Activity or Fragment}
   * saveInstanceState.
   *
   * @param outState {@link Bundle}
   */
  void saveInstanceState(Bundle outState);

  /**
   * Method that control the lifecycle of the view. It should be called in the view's
   * (Activity or Fragment) onDestroy() method.
   */
  void detach();

  void onViewAttached(FragmentEvent event);
}
