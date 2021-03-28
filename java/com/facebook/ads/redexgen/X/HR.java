package com.facebook.ads.redexgen.X;

public class HR implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ C0948aZ A03;

    public HR(C0948aZ aZVar, int i, long j, long j2) {
        this.A03 = aZVar;
        this.A00 = i;
        this.A02 = j;
        this.A01 = j2;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A03.A07.A90(this.A00, this.A02, this.A01);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
