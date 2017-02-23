package com.landscape.mvp.presenter;

import com.landscape.mvp.BaseActivity;
import com.landscape.mvp.BaseView;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public abstract class ActivityPresenter<T extends BaseView> extends RxPresenter<T> {

  protected abstract void attachToActivity(BaseActivity activity);

}
