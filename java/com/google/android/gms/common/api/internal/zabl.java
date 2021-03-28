package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zabl implements Runnable {
    private final /* synthetic */ zabm zajd;

    zabl(zabm zabm) {
        this.zajd = zabm;
    }

    public final void run() {
        this.zajd.zaiq.zais.disconnect();
    }
}
