package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzi extends Binder {
    private final zze zzbm;

    zzi(zze zze) {
        this.zzbm = zze;
    }

    public final void zzd(zzg zzg) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.zzbm.zzbb.execute(new zzj(this, zzg));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
