package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* renamed from: com.facebook.ads.redexgen.X.Nm  reason: case insensitive filesystem */
public final class C0594Nm {
    public static final int A00 = AnonymousClass2G.A01(-1, 0);
    public static final int A01 = AnonymousClass2G.A01(ViewCompat.MEASURED_STATE_MASK, 115);

    public static void A00(C0820Wh wh, ViewGroup viewGroup, String str) {
        new AsyncTaskC0831Ws(viewGroup, wh).A08(str);
        View view = new View(wh);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        C0535Le.A0V(view, wh);
        viewGroup.addView(view, 0);
    }
}
