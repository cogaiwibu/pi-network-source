package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final /* synthetic */ class zzb implements Executor {
    static final Executor zza = new zzb();

    private zzb() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
