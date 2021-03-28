package com.facebook.ads.redexgen.X;

public class NL implements Runnable {
    public final /* synthetic */ NM A00;
    public final /* synthetic */ NN A01;

    public NL(NM nm, NN nn) {
        this.A00 = nm;
        this.A01 = nn;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A8t();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
