package com.facebook.ads.redexgen.X;

import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.ads.redexgen.X.63  reason: invalid class name */
public class AnonymousClass63 implements Runnable {
    public EnumC01826j A00;
    public final /* synthetic */ TX A01;

    public AnonymousClass63(TX tx, EnumC01826j r2) {
        this.A01 = tx;
        this.A00 = r2;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A04.A04(EnumC01846l.A03, this.A00, null);
                this.A01.A01.A02(this.A01.A02, TimeUnit.SECONDS.toMillis((long) this.A01.A03.A0T()));
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
