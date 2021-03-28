package com.facebook.ads.redexgen.X;

public class PS implements Runnable {
    public final /* synthetic */ PV A00;

    public PS(PV pv) {
        this.A00 = pv;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A08();
                this.A00.A05.removeCallbacks(this);
                this.A00.A05.postDelayed(this, 250);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
