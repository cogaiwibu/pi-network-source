package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* renamed from: com.facebook.ads.redexgen.X.Iy  reason: case insensitive filesystem */
public class RunnableC0482Iy implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ J3 A01;

    public RunnableC0482Iy(J3 j3, Format format) {
        this.A01 = j3;
        this.A00 = format;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A01.A01.ABJ(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
