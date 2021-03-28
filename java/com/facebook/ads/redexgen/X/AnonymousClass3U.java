package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.EdgeEffect;

/* renamed from: com.facebook.ads.redexgen.X.3U  reason: invalid class name */
public final class AnonymousClass3U {
    public static final AnonymousClass3T A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new SR();
        } else {
            A00 = new AnonymousClass3T();
        }
    }

    public static void A00(EdgeEffect edgeEffect, float f, float f2) {
        A00.A00(edgeEffect, f, f2);
    }
}
