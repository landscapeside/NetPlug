package com.landscape.netplug.di.scope;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should conform to the life of the captcha
 * to be memorized in the correct component.
 *
 * @author Vincent Cheung (coolingfall@gmail.com)
 */
@Scope @Retention(RUNTIME) public @interface HomeScope {
}
