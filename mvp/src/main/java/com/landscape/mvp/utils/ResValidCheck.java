package com.landscape.mvp.utils;

import android.support.annotation.AnyRes;

/**
 * @author shun.jiang (494326656@qq.com)
 */

public class ResValidCheck {

  public static boolean isValid(@AnyRes int resId) {
    return resId != 0 && resId != -1;
  }

}
