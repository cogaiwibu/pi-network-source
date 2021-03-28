package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Bm  reason: case insensitive filesystem */
public class RunnableC0301Bm implements Runnable {
    public final /* synthetic */ C0306Br A00;
    public final /* synthetic */ Bs A01;

    public RunnableC0301Bm(C0306Br br, Bs bs) {
        this.A00 = br;
        this.A01 = bs;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A9P();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
