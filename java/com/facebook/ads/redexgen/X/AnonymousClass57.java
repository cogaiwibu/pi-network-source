package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.facebook.ads.redexgen.X.57  reason: invalid class name */
public final class AnonymousClass57 {
    public static AnonymousClass0S A00(Context context, AnonymousClass8J r1) {
        AnonymousClass0V A6K = r1.A6K(A07(context));
        if (A6K != null) {
            return A6K.A8R();
        }
        return new R4();
    }

    public static C0820Wh A01(Activity activity) {
        return new C0820Wh(activity, A08(), A00(activity, A08()));
    }

    public static C0820Wh A02(Context context) {
        return new C0820Wh(context, A08(), new R4());
    }

    public static C0820Wh A03(Context context) {
        return new C0820Wh(context, A08(), A00(context, A08()));
    }

    public static C0820Wh A04(Context context) {
        if (J8.A0l(context)) {
            return new C0820Wh(context, A08(), A00(context, A08()));
        }
        return A02(context);
    }

    public static C0820Wh A05(Context context) {
        return new C0820Wh(context, A08(), A00(context, A08()));
    }

    public static C0331Cv A06(Context context) {
        return new C0331Cv(context, A08(), A08().A6K(A07(context)));
    }

    public static C0821Wi A07(Context context) {
        return new C0821Wi(context, A08());
    }

    public static synchronized AnonymousClass8J A08() {
        XG A02;
        synchronized (AnonymousClass57.class) {
            A02 = XG.A02();
        }
        return A02;
    }
}
