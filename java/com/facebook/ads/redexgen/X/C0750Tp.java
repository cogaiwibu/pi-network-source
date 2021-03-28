package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Tp  reason: case insensitive filesystem */
public class C0750Tp implements AbstractC01816i {
    public final /* synthetic */ U7 A00;

    public C0750Tp(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        U7 u7 = this.A00;
        return u7.A05(u7.A01.category);
    }
}
