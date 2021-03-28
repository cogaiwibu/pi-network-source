package com.facebook.ads.redexgen.X;

public class B9 implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ BA A01;

    public B9(BA ba, int i) {
        this.A01 = ba;
        this.A00 = i;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A01.A8y(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
