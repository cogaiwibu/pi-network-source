package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zaam implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final Api<?> mApi;
    private final boolean zaee;
    private final WeakReference<zaak> zago;

    public zaam(zaak zaak, Api<?> api, boolean z) {
        this.zago = new WeakReference<>(zaak);
        this.mApi = api;
        this.zaee = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zaak zaak = this.zago.get();
        if (zaak != null) {
            Preconditions.checkState(Looper.myLooper() == zaak.zafv.zaeh.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaak.zaer.lock();
            try {
                if (zaak.zac((zaak) 0)) {
                    if (!connectionResult.isSuccess()) {
                        zaak.zab(connectionResult, this.mApi, this.zaee);
                    }
                    if (zaak.zaam()) {
                        zaak.zaan();
                    }
                    zaak.zaer.unlock();
                }
            } finally {
                zaak.zaer.unlock();
            }
        }
    }
}
