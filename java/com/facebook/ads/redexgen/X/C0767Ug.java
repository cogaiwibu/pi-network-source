package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Ug  reason: case insensitive filesystem */
public class C0767Ug implements AbstractC01816i {
    public final /* synthetic */ C0785Uy A00;

    public C0767Ug(C0785Uy uy) {
        this.A00 = uy;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A07(Build.TIME / 1000);
    }
}
