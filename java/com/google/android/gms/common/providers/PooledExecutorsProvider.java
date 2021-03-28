package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zzfm;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    public interface PooledExecutorFactory {
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zzfm == null) {
                zzfm = new zza();
            }
            pooledExecutorFactory = zzfm;
        }
        return pooledExecutorFactory;
    }

    private PooledExecutorsProvider() {
    }
}
