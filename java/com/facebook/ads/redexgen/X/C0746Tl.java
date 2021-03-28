package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;

/* renamed from: com.facebook.ads.redexgen.X.Tl  reason: case insensitive filesystem */
public class C0746Tl implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0746Tl(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A02 != null) {
            return this.A00.A0G(ActivityManager.isRunningInTestHarness());
        }
        return this.A00.A08(EnumC01926t.A07);
    }
}
