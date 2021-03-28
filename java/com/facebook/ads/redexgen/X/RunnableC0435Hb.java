package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Hb  reason: case insensitive filesystem */
public final class RunnableC0435Hb implements Runnable {
    public final AbstractC0434Ha A00;

    public RunnableC0435Hb(AbstractC0434Ha ha) {
        this.A00 = ha;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.AA4();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
