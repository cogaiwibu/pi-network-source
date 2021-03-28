package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Uo  reason: case insensitive filesystem */
public class C0775Uo implements AbstractC01816i {
    public final /* synthetic */ C0785Uy A00;

    public C0775Uo(C0785Uy uy) {
        this.A00 = uy;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC01926t.A05);
        }
        return this.A00.A09(Build.VERSION.BASE_OS);
    }
}
