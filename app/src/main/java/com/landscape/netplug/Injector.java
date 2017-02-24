package com.landscape.netplug;

import android.content.Context;
import com.landscape.netplug.di.components.AppComponent;

/**
 * @author Landscape
 */
public final class Injector {
  private Injector() {
    throw new AssertionError("No instances.");
  }

  @SuppressWarnings({ "ResourceType", "WrongConstant" }) // Explicitly doing a custom service.
  public static AppComponent obtain(Context context) {
    return ((NetPlugApp)context).getAppComponent();
  }
}
