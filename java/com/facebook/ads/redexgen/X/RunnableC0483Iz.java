package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Iz  reason: case insensitive filesystem */
public class RunnableC0483Iz implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ J3 A02;

    public RunnableC0483Iz(J3 j3, int i, long j) {
        this.A02 = j3;
        this.A00 = i;
        this.A01 = j;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A02.A01.A9T(this.A00, this.A01);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
