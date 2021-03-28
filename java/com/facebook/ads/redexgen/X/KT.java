package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;

public final class KT {
    public static void A00(KP kp) {
        new Handler(Looper.getMainLooper()).post(kp);
    }

    public static void A01(KP kp, int i) {
        new Handler(Looper.getMainLooper()).postDelayed(kp, (long) i);
    }
}
