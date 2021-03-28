package com.facebook.ads.redexgen.X;

public class B5 implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ BA A02;
    public final /* synthetic */ String A03;

    public B5(BA ba, String str, long j, long j2) {
        this.A02 = ba;
        this.A03 = str;
        this.A01 = j;
        this.A00 = j2;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A02.A01.A8u(this.A03, this.A01, this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
