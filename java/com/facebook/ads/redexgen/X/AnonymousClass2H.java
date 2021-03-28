package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Trace;

/* renamed from: com.facebook.ads.redexgen.X.2H  reason: invalid class name */
public final class AnonymousClass2H {
    public static void A00() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void A01(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
