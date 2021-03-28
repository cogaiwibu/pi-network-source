package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zabc extends zabp {
    private WeakReference<zaaw> zahp;

    zabc(zaaw zaaw) {
        this.zahp = new WeakReference<>(zaaw);
    }

    @Override // com.google.android.gms.common.api.internal.zabp
    public final void zas() {
        zaaw zaaw = this.zahp.get();
        if (zaaw != null) {
            zaaw.resume();
        }
    }
}
