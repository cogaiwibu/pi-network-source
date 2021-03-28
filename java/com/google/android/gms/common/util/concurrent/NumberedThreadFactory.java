package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.sdk.constants.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class NumberedThreadFactory implements ThreadFactory {
    private final int priority;
    private final ThreadFactory zzih;
    private final String zzij;
    private final AtomicInteger zzik;

    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    private NumberedThreadFactory(String str, int i) {
        this.zzik = new AtomicInteger();
        this.zzih = Executors.defaultThreadFactory();
        this.zzij = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.priority = 0;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.zzih.newThread(new zza(runnable, 0));
        String str = this.zzij;
        int andIncrement = this.zzik.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(Constants.RequestParameters.LEFT_BRACKETS);
        sb.append(andIncrement);
        sb.append(Constants.RequestParameters.RIGHT_BRACKETS);
        newThread.setName(sb.toString());
        return newThread;
    }
}
