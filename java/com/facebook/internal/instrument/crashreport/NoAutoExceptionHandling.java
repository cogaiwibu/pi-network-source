package com.facebook.internal.instrument.crashreport;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface NoAutoExceptionHandling {
}
