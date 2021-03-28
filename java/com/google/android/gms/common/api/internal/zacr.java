package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zacr implements IBinder.DeathRecipient, zacq {
    private final WeakReference<BasePendingResult<?>> zalf;
    private final WeakReference<zac> zalg;
    private final WeakReference<IBinder> zalh;

    private zacr(BasePendingResult<?> basePendingResult, zac zac, IBinder iBinder) {
        this.zalg = new WeakReference<>(zac);
        this.zalf = new WeakReference<>(basePendingResult);
        this.zalh = new WeakReference<>(iBinder);
    }

    @Override // com.google.android.gms.common.api.internal.zacq
    public final void zab(BasePendingResult<?> basePendingResult) {
        zabw();
    }

    public final void binderDied() {
        zabw();
    }

    private final void zabw() {
        BasePendingResult<?> basePendingResult = this.zalf.get();
        zac zac = this.zalg.get();
        if (!(zac == null || basePendingResult == null)) {
            zac.remove(basePendingResult.zal().intValue());
        }
        IBinder iBinder = this.zalh.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    /* synthetic */ zacr(BasePendingResult basePendingResult, zac zac, IBinder iBinder, zaco zaco) {
        this(basePendingResult, null, iBinder);
    }
}
