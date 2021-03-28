package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Dg  reason: case insensitive filesystem */
public final class C0342Dg {
    public final int A00;
    public final long A01;

    public C0342Dg(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static C0342Dg A00(CL cl, IQ iq) throws IOException, InterruptedException {
        cl.ABZ(iq.A00, 0, 8);
        iq.A0Z(0);
        return new C0342Dg(iq.A09(), iq.A0L());
    }
}
