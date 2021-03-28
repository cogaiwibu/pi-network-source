package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.4g  reason: invalid class name and case insensitive filesystem */
public class RunnableC01284g implements Runnable {
    public final /* synthetic */ C01294h A00;

    public RunnableC01284g(C01294h r1) {
        this.A00 = r1;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A05 = 0;
                this.A00.A06 = false;
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
