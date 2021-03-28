package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Bn  reason: case insensitive filesystem */
public class RunnableC0302Bn implements Runnable {
    public final /* synthetic */ C0306Br A00;
    public final /* synthetic */ Bs A01;
    public final /* synthetic */ Exception A02;

    public RunnableC0302Bn(C0306Br br, Bs bs, Exception exc) {
        this.A00 = br;
        this.A01 = bs;
        this.A02 = exc;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A9S(this.A02);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
