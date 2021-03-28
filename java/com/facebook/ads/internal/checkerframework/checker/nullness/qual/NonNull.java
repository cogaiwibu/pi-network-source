package com.facebook.ads.internal.checkerframework.checker.nullness.qual;

import com.facebook.ads.internal.checkerframework.framework.qual.DefaultFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultInUncheckedCodeFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import com.facebook.ads.internal.checkerframework.framework.qual.QualifierForLiterals;
import com.facebook.ads.internal.checkerframework.framework.qual.SubtypeOf;
import com.facebook.ads.internal.checkerframework.framework.qual.UpperBoundFor;
import com.facebook.ads.redexgen.X.AnonymousClass8B;
import com.facebook.ads.redexgen.X.AnonymousClass8C;
import com.facebook.ads.redexgen.X.EnumC02157x;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SubtypeOf({MonotonicNonNull.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UpperBoundFor(typeKinds = {AnonymousClass8B.A0I, AnonymousClass8B.A0C, AnonymousClass8B.A04, AnonymousClass8B.A06, AnonymousClass8B.A08, AnonymousClass8B.A0B, AnonymousClass8B.A0E, AnonymousClass8B.A0J, AnonymousClass8B.A05})
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({EnumC02157x.A0B})
@DefaultFor({AnonymousClass8C.A05})
@DefaultQualifierInHierarchy
@DefaultInUncheckedCodeFor({AnonymousClass8C.A0E, AnonymousClass8C.A0C})
@Documented
public @interface NonNull {
}
