package com.facebook.ads.redexgen.X;

import android.os.SystemClock;

/* renamed from: com.facebook.ads.redexgen.X.Vw  reason: case insensitive filesystem */
public class C0809Vw implements AbstractC01816i {
    public final /* synthetic */ C0810Vx A00;

    public C0809Vw(C0810Vx vx) {
        this.A00 = vx;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A04(((float) SystemClock.uptimeMillis()) / 1000.0f);
    }
}
