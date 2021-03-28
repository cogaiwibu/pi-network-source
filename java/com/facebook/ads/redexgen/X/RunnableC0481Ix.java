package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ix  reason: case insensitive filesystem */
public class RunnableC0481Ix implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ J3 A02;
    public final /* synthetic */ String A03;

    public RunnableC0481Ix(J3 j3, String str, long j, long j2) {
        this.A02 = j3;
        this.A03 = str;
        this.A01 = j;
        this.A00 = j2;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A02.A01.ABF(this.A03, this.A01, this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
