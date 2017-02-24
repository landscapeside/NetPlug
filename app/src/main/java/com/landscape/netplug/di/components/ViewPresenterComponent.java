package com.landscape.netplug.di.components;

import com.landscape.netplug.NetPlugApp;
import com.landscape.netplug.di.modules.AppModule;
import com.landscape.netplug.di.modules.ViewPresenterModule;
import com.landscape.netplug.di.scope.HomeScope;
import com.landscape.netplug.ui.activity.MainActivity;
import dagger.Component;

/**
 * @author shun.jiang (494326656@qq.com)
 */

@HomeScope @Component(dependencies = AppComponent.class,modules = { ViewPresenterModule.class }) public interface ViewPresenterComponent {
  void inject(MainActivity mainActivity);
}
