package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;

public class BN extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C0853Xo A01;

    public BN(C0853Xo xo, AudioTrack audioTrack) {
        this.A01 = xo;
        this.A00 = audioTrack;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.flush();
                this.A00.release();
                this.A01.A0f.open();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
