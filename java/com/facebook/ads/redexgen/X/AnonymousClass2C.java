package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.facebook.ads.redexgen.X.2C  reason: invalid class name */
public class AnonymousClass2C extends Handler {
    public final /* synthetic */ AnonymousClass2F A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnonymousClass2C(AnonymousClass2F r1, Looper looper) {
        super(looper);
        this.A00 = r1;
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            this.A00.A02();
        }
    }
}
