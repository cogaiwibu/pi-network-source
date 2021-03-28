package com.google.android.gms.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.gcm.zzj;

/* access modifiers changed from: package-private */
public final class zzag extends zzj {
    private final /* synthetic */ zzaf zzdc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzaf zzaf, Looper looper) {
        super(looper);
        this.zzdc = zzaf;
    }

    public final void handleMessage(Message message) {
        this.zzdc.zze(message);
    }
}
