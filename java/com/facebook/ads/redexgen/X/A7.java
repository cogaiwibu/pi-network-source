package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class A7 extends Handler {
    public final /* synthetic */ C0310Ca A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public A7(C0310Ca ca, Looper looper) {
        super(looper);
        this.A00 = ca;
    }

    public final void handleMessage(Message message) {
        if (!KU.A02(this)) {
            try {
                this.A00.A0B(message);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
