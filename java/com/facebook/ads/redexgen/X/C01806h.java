package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.6h  reason: invalid class name and case insensitive filesystem */
public final class C01806h<T> {
    public final int A00;
    public final int A01;
    public final T A02;

    public C01806h(T bundledSignalMetadataKey, int i, int i2) {
        this.A02 = bundledSignalMetadataKey;
        this.A00 = i;
        this.A01 = i2;
    }

    private boolean A00() {
        int i;
        int i2 = this.A00;
        return i2 > 0 && i2 < 9999 && (i = this.A01) > 0 && i < 10000 && i2 < i;
    }

    public final T A01() {
        return this.A02;
    }

    public final boolean A02() {
        return A00() && Build.VERSION.SDK_INT >= this.A00 && Build.VERSION.SDK_INT < this.A01;
    }
}
