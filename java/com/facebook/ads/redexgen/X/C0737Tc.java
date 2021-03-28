package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Tc  reason: case insensitive filesystem */
public class C0737Tc implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0737Tc(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A02 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0747Tm tm = this.A00;
        return tm.A05(tm.A02.getLockTaskModeState());
    }
}
