package com.google.android.gms.iid;

import android.content.Intent;

final class zzf implements Runnable {
    private final /* synthetic */ Intent zzbf;
    private final /* synthetic */ Intent zzbg;
    private final /* synthetic */ zze zzbh;

    zzf(zze zze, Intent intent, Intent intent2) {
        this.zzbh = zze;
        this.zzbf = intent;
        this.zzbg = intent2;
    }

    public final void run() {
        this.zzbh.handleIntent(this.zzbf);
        this.zzbh.zzf(this.zzbg);
    }
}
