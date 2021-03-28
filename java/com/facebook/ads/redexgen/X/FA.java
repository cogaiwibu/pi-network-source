package com.facebook.ads.redexgen.X;

public class FA implements Runnable {
    public final /* synthetic */ C0292Az A00;

    public FA(C0292Az az) {
        this.A00 = az;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A09();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
