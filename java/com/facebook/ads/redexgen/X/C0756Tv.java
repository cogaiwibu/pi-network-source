package com.facebook.ads.redexgen.X;

import java.io.File;

/* renamed from: com.facebook.ads.redexgen.X.Tv  reason: case insensitive filesystem */
public class C0756Tv implements AbstractC01816i {
    public final /* synthetic */ U7 A00;

    public C0756Tv(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A07(new File(this.A00.A00.getApplicationInfo().publicSourceDir).length());
    }
}
