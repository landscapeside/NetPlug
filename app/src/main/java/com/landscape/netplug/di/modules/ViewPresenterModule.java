package com.landscape.netplug.di.modules;

import android.content.Context;
import com.landscape.netplug.di.scope.HomeScope;
import com.landscape.netplug.mvp.presenter.LogContentPresenter;
import com.landscape.suit.datasource.SuitDataSource;
import dagger.Module;
import dagger.Provides;

/**
 * @author shun.jiang (494326656@qq.com)
 */
@Module
public class ViewPresenterModule {
  @Provides @HomeScope SuitDataSource provideSuitDataSource(Context context) {
    return new SuitDataSource(context);
  }
}
