package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3L  reason: invalid class name */
public final class AnonymousClass3L {
    public static final AnonymousClass3K A01;
    public final Object A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A01 = new EW();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A01 = new C0364Ee();
        } else {
            A01 = new SP();
        }
    }

    public AnonymousClass3L() {
        this.A00 = A01.A8a(this);
    }

    public AnonymousClass3L(Object obj) {
        this.A00 = obj;
    }

    @Nullable
    public final AnonymousClass3J A00(int i) {
        return null;
    }

    @Nullable
    public final AnonymousClass3J A01(int i) {
        return null;
    }

    public final Object A02() {
        return this.A00;
    }

    @Nullable
    public final List<AnonymousClass3J> A03(String str, int i) {
        return null;
    }

    public final boolean A04(int i, int i2, Bundle bundle) {
        return false;
    }
}
