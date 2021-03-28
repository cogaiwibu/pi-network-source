package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zax implements OnCompleteListener<Map<ApiKey<?>, String>> {
    private final /* synthetic */ zav zafl;

    private zax(zav zav) {
        this.zafl = zav;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Map<ApiKey<?>, String>> task) {
        this.zafl.zaer.lock();
        try {
            if (this.zafl.zafe) {
                if (task.isSuccessful()) {
                    this.zafl.zaff = new ArrayMap(this.zafl.zaeu.size());
                    for (zaw zaw : this.zafl.zaeu.values()) {
                        this.zafl.zaff.put(zaw.getApiKey(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zafl.zafc) {
                        this.zafl.zaff = new ArrayMap(this.zafl.zaeu.size());
                        for (zaw zaw2 : this.zafl.zaeu.values()) {
                            ApiKey apiKey = zaw2.getApiKey();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult((GoogleApi<? extends Api.ApiOptions>) zaw2);
                            if (this.zafl.zaa(zaw2, connectionResult)) {
                                this.zafl.zaff.put(apiKey, new ConnectionResult(16));
                            } else {
                                this.zafl.zaff.put(apiKey, connectionResult);
                            }
                        }
                    } else {
                        this.zafl.zaff = availabilityException.zaj();
                    }
                    this.zafl.zafi = this.zafl.zaac();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.zafl.zaff = Collections.emptyMap();
                    this.zafl.zafi = new ConnectionResult(8);
                }
                if (this.zafl.zafg != null) {
                    this.zafl.zaff.putAll(this.zafl.zafg);
                    this.zafl.zafi = this.zafl.zaac();
                }
                if (this.zafl.zafi == null) {
                    this.zafl.zaaa();
                    this.zafl.zaab();
                } else {
                    this.zafl.zafe = false;
                    this.zafl.zaex.zac(this.zafl.zafi);
                }
                this.zafl.zaez.signalAll();
                this.zafl.zaer.unlock();
            }
        } finally {
            this.zafl.zaer.unlock();
        }
    }
}
