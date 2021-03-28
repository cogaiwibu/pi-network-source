package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Iw  reason: case insensitive filesystem */
public class RunnableC0480Iw implements Runnable {
    public final /* synthetic */ C0297Be A00;
    public final /* synthetic */ J3 A01;

    public RunnableC0480Iw(J3 j3, C0297Be be) {
        this.A01 = j3;
        this.A00 = be;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A01.ABH(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
