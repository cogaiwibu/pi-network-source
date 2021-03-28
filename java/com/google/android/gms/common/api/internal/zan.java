package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zan extends zabp {
    private final /* synthetic */ Dialog zaec;
    private final /* synthetic */ zal zaed;

    zan(zal zal, Dialog dialog) {
        this.zaed = zal;
        this.zaec = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabp
    public final void zas() {
        this.zaed.zadl.zao();
        if (this.zaec.isShowing()) {
            this.zaec.dismiss();
        }
    }
}
