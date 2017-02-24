package com.landscape.netplug.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.landscape.mvp.BaseFragment;
import com.landscape.netplug.R;
import com.landscape.netplug.mvp.view.SuitManagerView;
import javax.annotation.Nonnull;
import rx.Observable;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class SuitListFragment extends BaseFragment implements SuitManagerView {
  @Override protected int layoutRes() {
    return R.layout.fragment_suit_manager;
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {

  }

  @Nonnull @Override public <T> Observable<T> userActionObservable() {
    return null;
  }
}
