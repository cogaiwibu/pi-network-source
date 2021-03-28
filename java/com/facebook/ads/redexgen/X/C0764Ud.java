package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Ud  reason: case insensitive filesystem */
public class C0764Ud implements AbstractC01816i {
    public final /* synthetic */ C0785Uy A00;

    public C0764Ud(C0785Uy uy) {
        this.A00 = uy;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A09(Build.SERIAL);
        }
        return this.A00.A09(Build.getSerial());
    }
}
