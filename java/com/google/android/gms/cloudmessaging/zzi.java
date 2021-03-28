package com.google.android.gms.cloudmessaging;

import android.os.Handler;
import android.os.Message;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class zzi implements Handler.Callback {
    private final zzf zza;

    zzi(zzf zzf) {
        this.zza = zzf;
    }

    public final boolean handleMessage(Message message) {
        return this.zza.zza(message);
    }
}
