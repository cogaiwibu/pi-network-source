package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zacg implements Runnable {
    private final /* synthetic */ zak zagu;
    private final /* synthetic */ zace zakl;

    zacg(zace zace, zak zak) {
        this.zakl = zace;
        this.zagu = zak;
    }

    public final void run() {
        this.zakl.zac(this.zagu);
    }
}
