package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* renamed from: com.facebook.ads.redexgen.X.3A  reason: invalid class name */
public final class AnonymousClass3A {
    public static final AnonymousClass39 A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new C0370Ek();
        } else if (Build.VERSION.SDK_INT >= 19) {
            A00 = new SK();
        } else {
            A00 = new AnonymousClass39();
        }
    }

    public static void A00(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof SE) {
            throw null;
        } else if (i == 0) {
            A00.A03(viewParent, view);
        }
    }

    public static void A01(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof SE) {
            throw null;
        } else if (i5 == 0) {
            A00.A04(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void A02(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof SE) {
            throw null;
        } else if (i3 == 0) {
            A00.A05(viewParent, view, i, i2, iArr);
        }
    }

    public static void A03(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof SE) {
            throw null;
        } else if (i2 == 0) {
            A00.A06(viewParent, view, view2, i);
        }
    }

    public static boolean A04(ViewParent viewParent, View view, float f, float f2) {
        return A00.A07(viewParent, view, f, f2);
    }

    public static boolean A05(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return A00.A08(viewParent, view, f, f2, z);
    }

    public static boolean A06(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof SE) {
            return ((SE) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 == 0) {
            return A00.A09(viewParent, view, view2, i);
        }
        return false;
    }
}
