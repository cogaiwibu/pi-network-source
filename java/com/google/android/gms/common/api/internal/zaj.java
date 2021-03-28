package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaj {
    private final ArrayMap<ApiKey<?>, ConnectionResult> zaba = new ArrayMap<>();
    private final ArrayMap<ApiKey<?>, String> zacz = new ArrayMap<>();
    private final TaskCompletionSource<Map<ApiKey<?>, String>> zada = new TaskCompletionSource<>();
    private int zadb;
    private boolean zadc = false;

    public zaj(Iterable<? extends HasApiKey<?>> iterable) {
        Iterator<? extends HasApiKey<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.zaba.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.zadb = this.zaba.keySet().size();
    }

    public final Set<ApiKey<?>> zan() {
        return this.zaba.keySet();
    }

    public final Task<Map<ApiKey<?>, String>> getTask() {
        return this.zada.getTask();
    }

    public final void zaa(ApiKey<?> apiKey, ConnectionResult connectionResult, String str) {
        this.zaba.put(apiKey, connectionResult);
        this.zacz.put(apiKey, str);
        this.zadb--;
        if (!connectionResult.isSuccess()) {
            this.zadc = true;
        }
        if (this.zadb != 0) {
            return;
        }
        if (this.zadc) {
            this.zada.setException(new AvailabilityException(this.zaba));
            return;
        }
        this.zada.setResult(this.zacz);
    }
}
