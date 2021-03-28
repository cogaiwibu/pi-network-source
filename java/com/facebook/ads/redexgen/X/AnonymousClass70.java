package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.70  reason: invalid class name */
public class AnonymousClass70 implements Runnable {
    public final /* synthetic */ AnonymousClass71 A00;

    public AnonymousClass70(AnonymousClass71 r1) {
        this.A00 = r1;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A03();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
