package com.facebook.ads.redexgen.X;

public class B4 implements Runnable {
    public final /* synthetic */ BA A00;
    public final /* synthetic */ C0297Be A01;

    public B4(BA ba, C0297Be be) {
        this.A00 = ba;
        this.A01 = be;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A01.A8w(this.A01);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
