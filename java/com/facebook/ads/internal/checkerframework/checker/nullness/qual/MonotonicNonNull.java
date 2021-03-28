package com.facebook.ads.internal.checkerframework.checker.nullness.qual;

import com.facebook.ads.internal.checkerframework.framework.qual.MonotonicQualifier;
import com.facebook.ads.internal.checkerframework.framework.qual.SubtypeOf;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SubtypeOf({Nullable.class})
@Target({ElementType.TYPE_USE})
@MonotonicQualifier(NonNull.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MonotonicNonNull {
}
