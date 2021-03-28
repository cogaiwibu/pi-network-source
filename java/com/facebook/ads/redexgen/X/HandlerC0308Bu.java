package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bu  reason: case insensitive filesystem */
public class HandlerC0308Bu extends Handler {
    public final /* synthetic */ Y2 A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerC0308Bu(Y2 y2, Looper looper) {
        super(looper);
        this.A00 = y2;
    }

    public final void handleMessage(Message message) {
        if (!KU.A02(this)) {
            try {
                byte[] bArr = (byte[]) message.obj;
                for (C0864Xz xz : this.A00.A09) {
                    if (xz.A0O(bArr)) {
                        xz.A0K(message.what);
                        return;
                    }
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
