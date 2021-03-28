package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zze;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final class zzy extends zze {
    private final /* synthetic */ Rpc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzy(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    public final void handleMessage(Message message) {
        Rpc.zza(this.zza, message);
    }
}
