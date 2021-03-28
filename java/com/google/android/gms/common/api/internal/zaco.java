package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaco implements zacq {
    private final /* synthetic */ zacp zala;

    zaco(zacp zacp) {
        this.zala = zacp;
    }

    @Override // com.google.android.gms.common.api.internal.zacq
    public final void zab(BasePendingResult<?> basePendingResult) {
        this.zala.zald.remove(basePendingResult);
        basePendingResult.zal();
    }
}
