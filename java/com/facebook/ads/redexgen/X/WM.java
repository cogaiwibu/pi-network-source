package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;

public class WM implements AbstractC01816i {
    public final /* synthetic */ WN A00;

    public WM(WN wn) {
        this.A00 = wn;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A07(AnonymousClass76.A02(TrafficStats.getTotalTxBytes()));
    }
}
