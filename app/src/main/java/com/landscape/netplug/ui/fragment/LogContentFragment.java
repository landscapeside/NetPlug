package com.landscape.netplug.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.landscape.mvp.BaseFragment;
import com.landscape.netplug.R;
import com.landscape.netplug.mvp.view.LogContentView;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class LogContentFragment extends BaseFragment implements LogContentView {
  @Override protected int layoutRes() {
    return R.layout.fragment_log_content;
  }

  @Override protected void onReady(@Nullable Bundle savedInstanceState) {

  }
}
