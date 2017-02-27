package com.landscape.mvp;

import android.support.annotation.NonNull;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.FragmentEvent;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import rx.Observable;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public interface BaseView<A> {

  @Nonnull @CheckReturnValue Observable<FragmentEvent> delegateLifecycle();

  /**
   * Binds a source until a specific event occurs.
   * <p>
   * Intended for use with {@link Observable#compose(Observable.Transformer)}
   *
   * @param event the event that triggers unsubscription
   * @return a reusable {@link Observable.Transformer} which unsubscribes when the event triggers.
   */
  @Nonnull @CheckReturnValue <T> LifecycleTransformer<T> delegateBindUntilEvent(@Nonnull FragmentEvent event);

  /**
   * Binds a source until the next reasonable event occurs.
   * <p>
   * Intended for use with {@link Observable#compose(Observable.Transformer)}
   *
   * @return a reusable {@link Observable.Transformer} which unsubscribes at the correct time.
   */
  @Nonnull @CheckReturnValue <T> LifecycleTransformer<T> delegateBindToLifecycle();

  /**
   * obtain a observable which emit by a series user action on the views
   *
   * @param <T> specify action types
   * @return
   */
  @Nonnull @CheckReturnValue Observable<A> userActionObservable();
}
