package com.landscape.mvp.presenter;

import android.os.Bundle;
import com.landscape.mvp.BasePresenter;
import com.landscape.mvp.BaseView;
import com.trello.rxlifecycle.android.FragmentEvent;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public abstract class RxPresenter<V extends BaseView> implements BasePresenter<V> {
  protected final CompositeSubscription subscriptions = new CompositeSubscription();
  protected V baseView;

  @Override public void attach(V view) {
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

  protected Observable.Transformer<FragmentEvent,FragmentEvent> subscribeLifeTrans(final FragmentEvent lifeEvent) {
    return new Observable.Transformer<FragmentEvent, FragmentEvent>() {
      @Override
      public Observable<FragmentEvent> call(Observable<FragmentEvent> source) {
        return source.takeFirst(new Func1<FragmentEvent, Boolean>() {
          @Override public Boolean call(FragmentEvent event) {
            return event.equals(lifeEvent);
          }
        });
      }
    };
  }

  protected <T> Observable.Transformer<T,T> schedulerTrans() {
    return new Observable.Transformer<T, T>() {
      @Override public Observable<T> call(Observable<T> tObservable) {
        return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
      }
    };
  }
}
