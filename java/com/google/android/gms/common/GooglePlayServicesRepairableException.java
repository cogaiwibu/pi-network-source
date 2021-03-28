package com.google.android.gms.common;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzas;

    public GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.zzas = i;
    }

    public int getConnectionStatusCode() {
        return this.zzas;
    }
}
