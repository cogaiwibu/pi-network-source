package com.facebook.ads.redexgen.X;

public class FR implements Runnable {
    public final /* synthetic */ FT A00;
    public final /* synthetic */ FV A01;
    public final /* synthetic */ FW A02;

    public FR(FT ft, FW fw, FV fv) {
        this.A00 = ft;
        this.A02 = fw;
        this.A01 = fv;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A02.A9O(this.A00.A00, this.A00.A01, this.A01);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
