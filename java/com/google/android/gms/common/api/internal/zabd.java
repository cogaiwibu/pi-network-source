package com.google.android.gms.common.api.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public abstract class zabd {
    private final zabb zahq;

    protected zabd(zabb zabb) {
        this.zahq = zabb;
    }

    /* access modifiers changed from: protected */
    public abstract void zaal();

    public final void zaa(zabe zabe) {
        zabe.zab(zabe).lock();
        try {
            if (zabe.zac(zabe) == this.zahq) {
                zaal();
                zabe.zab(zabe).unlock();
            }
        } finally {
            zabe.zab(zabe).unlock();
        }
    }
}
