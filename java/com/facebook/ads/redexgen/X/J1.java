package com.facebook.ads.redexgen.X;

import android.view.Surface;

public class J1 implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ J3 A01;

    public J1(J3 j3, Surface surface) {
        this.A01 = j3;
        this.A00 = surface;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A01.AAk(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
