package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.02  reason: invalid class name */
public final class AnonymousClass02<T> {
    @Nullable
    public final T A00;
    @Nullable
    public final Throwable A01;
    public final boolean A02;

    public AnonymousClass02(boolean z, @Nullable T t) {
        this.A02 = z;
        this.A00 = t;
        this.A01 = null;
    }

    public AnonymousClass02(boolean z, @Nullable T result, @Nullable Throwable th) {
        this.A02 = z;
        this.A00 = result;
        this.A01 = th;
    }

    @Nullable
    public final T A00() {
        return this.A00;
    }

    public final boolean A01() {
        return this.A02;
    }
}
