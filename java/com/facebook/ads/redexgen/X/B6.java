package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

public class B6 implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ BA A01;

    public B6(BA ba, Format format) {
        this.A01 = ba;
        this.A00 = format;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A01.A8x(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
