package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaal extends zaau {
    final /* synthetic */ zaak zafz;
    private final Map<Api.Client, zaam> zagn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaal(zaak zaak, Map<Api.Client, zaam> map) {
        super(zaak, null);
        this.zafz = zaak;
        this.zagn = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaau
    public final void zaal() {
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zafz.zaey);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zagn.keySet()) {
            if (!client.requiresGooglePlayServices() || zaam.zaa(this.zagn.get(client))) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList2;
            int size = arrayList3.size();
            while (i2 < size) {
                Object obj = arrayList3.get(i2);
                i2++;
                i = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj);
                if (i == 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList;
            int size2 = arrayList4.size();
            while (i2 < size2) {
                Object obj2 = arrayList4.get(i2);
                i2++;
                i = googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, (Api.Client) obj2);
                if (i != 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            this.zafz.zafv.zaa(new zaao(this, this.zafz, new ConnectionResult(i, null)));
            return;
        }
        if (this.zafz.zagh && this.zafz.zagf != null) {
            this.zafz.zagf.connect();
        }
        for (Api.Client client2 : this.zagn.keySet()) {
            zaam zaam = this.zagn.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zafz.mContext, client2) == 0) {
                client2.connect(zaam);
            } else {
                this.zafz.zafv.zaa(new zaan(this, this.zafz, zaam));
            }
        }
    }
}
