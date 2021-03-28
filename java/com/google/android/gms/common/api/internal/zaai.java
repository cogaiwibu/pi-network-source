package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaai extends zabd {
    private final /* synthetic */ zaaf zafy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaai(zaaf zaaf, zabb zabb) {
        super(zabb);
        this.zafy = zaaf;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaal() {
        this.zafy.onConnectionSuspended(1);
    }
}
