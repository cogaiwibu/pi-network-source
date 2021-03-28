package com.facebook.ads.redexgen.X;

public class J2 implements Runnable {
    public final /* synthetic */ C0297Be A00;
    public final /* synthetic */ J3 A01;

    public J2(J3 j3, C0297Be be) {
        this.A01 = j3;
        this.A00 = be;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A00();
                this.A01.A01.ABG(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
