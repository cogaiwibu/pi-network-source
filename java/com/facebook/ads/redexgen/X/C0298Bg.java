package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Bg  reason: case insensitive filesystem */
public class C0298Bg extends Thread {
    public final /* synthetic */ AbstractC0863Xy A00;

    public C0298Bg(AbstractC0863Xy xy) {
        this.A00 = xy;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A0N();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
