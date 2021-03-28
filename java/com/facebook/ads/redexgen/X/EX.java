package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;

public class EX implements Runnable {
    public final /* synthetic */ ConditionVariable A00;

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.open();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
