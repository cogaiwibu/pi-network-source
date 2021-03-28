package com.facebook.ads.redexgen.X;

public class B7 implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ BA A03;

    public B7(BA ba, int i, long j, long j2) {
        this.A03 = ba;
        this.A00 = i;
        this.A01 = j;
        this.A02 = j2;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A03.A01.A8z(this.A00, this.A01, this.A02);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
