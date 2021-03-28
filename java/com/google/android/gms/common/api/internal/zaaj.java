package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaaj implements Runnable {
    private final /* synthetic */ zaak zafz;

    zaaj(zaak zaak) {
        this.zafz = zaak;
    }

    public final void run() {
        zaak.zab(this.zafz).cancelAvailabilityErrorNotifications(zaak.zaa(this.zafz));
    }
}
