package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.zac;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zacp {
    public static final Status zalb = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zalc = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zahd;
    final Set<BasePendingResult<?>> zald = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacq zale = new zaco(this);

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zahd = map;
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult<? extends Result> basePendingResult) {
        this.zald.add(basePendingResult);
        basePendingResult.zaa(this.zale);
    }

    public final void release() {
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.zald.toArray(zalc);
        for (BasePendingResult basePendingResult : basePendingResultArr) {
            zac zac = null;
            basePendingResult.zaa((zacq) null);
            if (basePendingResult.zal() != null) {
                basePendingResult.setResultCallback(null);
                IBinder serviceBrokerBinder = this.zahd.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa(new zacr(basePendingResult, null, serviceBrokerBinder, null));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zaa((zacq) null);
                    basePendingResult.cancel();
                    zac.remove(basePendingResult.zal().intValue());
                } else {
                    zacr zacr = new zacr(basePendingResult, null, serviceBrokerBinder, null);
                    basePendingResult.zaa(zacr);
                    try {
                        serviceBrokerBinder.linkToDeath(zacr, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.cancel();
                        zac.remove(basePendingResult.zal().intValue());
                    }
                }
                this.zald.remove(basePendingResult);
            } else if (basePendingResult.zaq()) {
                this.zald.remove(basePendingResult);
            }
        }
    }

    public final void zabv() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zald.toArray(zalc)) {
            basePendingResult.zab(zalb);
        }
    }
}
