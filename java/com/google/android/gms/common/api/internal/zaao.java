package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaao extends zabd {
    private final /* synthetic */ ConnectionResult zagq;
    private final /* synthetic */ zaal zagr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaao(zaal zaal, zabb zabb, ConnectionResult connectionResult) {
        super(zabb);
        this.zagr = zaal;
        this.zagq = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaal() {
        this.zagr.zafz.zae((zaak) this.zagq);
    }
}
