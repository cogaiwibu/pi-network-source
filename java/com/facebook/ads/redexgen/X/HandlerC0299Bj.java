package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm;
import com.ironsource.sdk.precache.DownloadManager;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bj  reason: case insensitive filesystem */
public class HandlerC0299Bj extends Handler {
    public final /* synthetic */ C0864Xz A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerC0299Bj(C0864Xz xz, Looper looper) {
        super(looper);
        this.A00 = xz;
    }

    private long A00(int i) {
        return (long) Math.min((i - 1) * 1000, (int) DownloadManager.OPERATION_TIMEOUT);
    }

    private boolean A01(Message message) {
        boolean z;
        int i;
        if (message.arg1 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (i = message.arg2 + 1) > this.A00.A0D) {
            return false;
        }
        Message obtain = Message.obtain(message);
        obtain.arg2 = i;
        sendMessageDelayed(obtain, A00(i));
        return true;
    }

    public final void A02(int errorCount, Object obj, boolean z) {
        obtainMessage(errorCount, z ? 1 : 0, 0, obj).sendToTarget();
    }

    /* JADX INFO: Multiple debug info for r0v13 android.util.Pair: [D('msg' android.os.Message), D('keyRequest' android.util.Pair<com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm$KeyRequest, java.lang.String>)] */
    public final void handleMessage(Message message) {
        Object e;
        if (!KU.A02(this)) {
            try {
                Object obj = message.obj;
                try {
                    int i = message.what;
                    if (i == 0) {
                        e = this.A00.A0B.executeProvisionRequest(this.A00.A0C, (CA) obj);
                    } else if (i == 1) {
                        Pair<ExoMediaDrm.KeyRequest, String> keyRequest = (Pair) obj;
                        e = this.A00.A0B.executeKeyRequest(this.A00.A0C, (C6) keyRequest.first, (String) keyRequest.second);
                    } else {
                        throw new RuntimeException();
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (A01(message)) {
                        return;
                    }
                }
                this.A00.A0A.obtainMessage(message.what, Pair.create(obj, e)).sendToTarget();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
