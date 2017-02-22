package com.landscape.netplug.di.modules;

import com.landscape.netplug.log.HttpLoggingInterceptor;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import timber.log.Timber;

/**
 * Dagger module that provides network related collaborators.
 *
 * @author Landscape
 */
@Module public final class NetworkModule {

  @Provides @Singleton OkHttpClient.Builder provideOkHttpClientBuilder() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS);

    HttpLoggingInterceptor loggingInterceptor =
        new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
          @Override public void log(String message) {
            Timber.i(message);
          }
        });
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    builder.addInterceptor(loggingInterceptor);

    return builder;
  }
}
