package com.landscape.netplug.mvp.presenter;

import android.support.v4.app.Fragment;
import com.landscape.mvp.BaseActivity;
import com.landscape.mvp.presenter.ActivityPresenter;
import com.landscape.netplug.R;
import com.landscape.netplug.mvp.view.SuitManagerView;
import com.landscape.netplug.ui.fragment.SuitListFragment;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.utils.behavior.FragmentsUtils;
import javax.inject.Inject;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class SuitManagerPresenter extends ActivityPresenter<SuitManagerView> {

  @Inject public SuitManagerPresenter() {
    attach(new SuitListFragment());
  }

  @Override public void attachToActivity(BaseActivity activity) {
    FragmentsUtils.addFragmentToActivity(activity.getSupportFragmentManager(), (Fragment) baseView, R.id.test_suit_container);
  }

  @Override public void onViewAttached(FragmentEvent event) {

  }
}
