package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class zzu implements Handler.Callback {
    private final zzt zzcm;

    zzu(zzt zzt) {
        this.zzcm = zzt;
    }

    public final boolean handleMessage(Message message) {
        return this.zzcm.zzd(message);
    }
}
