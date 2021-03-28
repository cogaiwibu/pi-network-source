package com.facebook.ads.redexgen.X;

public class QF implements Runnable {
    public final /* synthetic */ QG A00;

    public QF(QG qg) {
        this.A00 = qg;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A00();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
