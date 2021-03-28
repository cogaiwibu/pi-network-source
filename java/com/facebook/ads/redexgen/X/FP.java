package com.facebook.ads.redexgen.X;

public class FP implements Runnable {
    public final /* synthetic */ FT A00;
    public final /* synthetic */ FW A01;

    public FP(FT ft, FW fw) {
        this.A00 = ft;
        this.A01 = fw;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.AAh(this.A00.A00, this.A00.A01);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
