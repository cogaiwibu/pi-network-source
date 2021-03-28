package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bk  reason: case insensitive filesystem */
public class HandlerC0300Bk extends Handler {
    public final /* synthetic */ C0864Xz A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerC0300Bk(C0864Xz xz, Looper looper) {
        super(looper);
        this.A00 = xz;
    }

    public final void handleMessage(Message message) {
        if (!KU.A02(this)) {
            try {
                Pair pair = (Pair) message.obj;
                Object obj = pair.first;
                Object obj2 = pair.second;
                int i = message.what;
                if (i == 0) {
                    this.A00.A0C(obj, obj2);
                } else if (i == 1) {
                    this.A00.A0B(obj, obj2);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
