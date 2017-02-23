package com.landscape.netplug.di.components;

import android.app.Application;
import android.content.Context;
import com.landscape.netplug.NetPlugApp;
import com.landscape.netplug.di.modules.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author shun.jiang (494326656@qq.com)
 */

@Singleton @Component(modules = { AppModule.class }) public interface AppComponent {

  Context appContext();

  Application app();

  void inject(NetPlugApp application);

}
