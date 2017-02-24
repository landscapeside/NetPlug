package com.landscape.netplug.di.modules;

import android.app.Application;
import android.content.Context;
import com.landscape.netplug.NetPlugApp;
import com.landscape.netplug.log.LumberYard;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides application level related collaborators.
 *
 * @author Landscape
 */
@Module(includes = { NetworkModule.class }) public final class AppModule {
  private NetPlugApp application;

  public AppModule(NetPlugApp application) {
    this.application = application;
  }

  @Provides @Singleton Context provideAppContext() {
    return application.getApplicationContext();
  }

  @Provides @Singleton Application provideApp() {
    return application;
  }

  @Provides @Singleton LumberYard provideLumberYard(Application app) {
    return new LumberYard(app);
  }
}
