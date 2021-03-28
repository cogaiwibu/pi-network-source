package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final /* synthetic */ class zzz implements Executor {
    static final Executor zza = new zzz();

    private zzz() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
