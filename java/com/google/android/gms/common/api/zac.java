package com.google.android.gms.common.api;

import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public abstract class zac {
    private static final Object sLock = new Object();
    private static final Map<Object, zac> zacm = new WeakHashMap();

    public abstract void remove(int i);
}
