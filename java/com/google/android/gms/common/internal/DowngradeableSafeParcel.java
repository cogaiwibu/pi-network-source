package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zzdy = new Object();
    private static ClassLoader zzdz = null;
    private static Integer zzea = null;
    private boolean zzeb = false;

    /* access modifiers changed from: protected */
    public abstract boolean prepareForClientVersion(int i);

    private static ClassLoader zzp() {
        synchronized (zzdy) {
        }
        return null;
    }

    protected static Integer getUnparcelClientVersion() {
        synchronized (zzdy) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDowngrade() {
        return this.zzeb;
    }

    public void setShouldDowngrade(boolean z) {
        this.zzeb = z;
    }

    protected static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }
}
