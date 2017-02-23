package com.landscape.netplug;

import android.app.Application;
import com.landscape.netplug.di.components.AppComponent;
import com.landscape.netplug.di.components.DaggerAppComponent;
import com.landscape.netplug.di.modules.AppModule;
import com.landscape.netplug.log.LumberYard;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class NetPlugApp extends Application {

  @Inject LumberYard lumberYard;

  AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    appComponent.inject(this);

    lumberYard.cleanUp();
    Timber.plant(lumberYard.tree());
  }
}
