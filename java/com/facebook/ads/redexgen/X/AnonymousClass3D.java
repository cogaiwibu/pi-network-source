package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: com.facebook.ads.redexgen.X.3D  reason: invalid class name */
public final class AnonymousClass3D {
    public static final AnonymousClass3C A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new C0369Ej();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A00 = new SL();
        } else {
            A00 = new AnonymousClass3C();
        }
    }

    public static int A00(AccessibilityEvent accessibilityEvent) {
        return A00.A00(accessibilityEvent);
    }

    public static void A01(AccessibilityEvent accessibilityEvent, int i) {
        A00.A01(accessibilityEvent, i);
    }
}
