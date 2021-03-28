package com.facebook.ads.redexgen.X;

public class FB implements Runnable {
    public final /* synthetic */ C0292Az A00;

    public FB(C0292Az az) {
        this.A00 = az;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                if (!(this.A00.A0G)) {
                    this.A00.A08.A9F(this.A00);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
