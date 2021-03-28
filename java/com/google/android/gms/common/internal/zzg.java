package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public final class zzg implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzdl;
    private final Map<ServiceConnection, ServiceConnection> zzep = new HashMap();
    private boolean zzeq;
    private final GmsClientSupervisor.zza zzer;
    private final /* synthetic */ zze zzes;

    public zzg(zze zze, GmsClientSupervisor.zza zza) {
        this.zzes = zze;
        this.zzer = zza;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzes.zzee) {
            this.zzes.mHandler.removeMessages(1, this.zzer);
            this.zzdl = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection serviceConnection : this.zzep.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzes.zzee) {
            this.zzes.mHandler.removeMessages(1, this.zzer);
            this.zzdl = null;
            this.mComponentName = componentName;
            for (ServiceConnection serviceConnection : this.zzep.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zzf(String str) {
        this.mState = 3;
        boolean zza = this.zzes.zzeg.zza(this.zzes.zzef, str, this.zzer.zzb(this.zzes.zzef), this, this.zzer.zzq());
        this.zzeq = zza;
        if (zza) {
            this.zzes.mHandler.sendMessageDelayed(this.zzes.mHandler.obtainMessage(1, this.zzer), this.zzes.zzei);
            return;
        }
        this.mState = 2;
        try {
            this.zzes.zzeg.unbindService(this.zzes.zzef, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzg(String str) {
        this.zzes.mHandler.removeMessages(1, this.zzer);
        this.zzes.zzeg.unbindService(this.zzes.zzef, this);
        this.zzeq = false;
        this.mState = 2;
    }

    public final void zza(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        ConnectionTracker unused = this.zzes.zzeg;
        Context unused2 = this.zzes.zzef;
        this.zzer.zzb(this.zzes.zzef);
        this.zzep.put(serviceConnection, serviceConnection2);
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        ConnectionTracker unused = this.zzes.zzeg;
        Context unused2 = this.zzes.zzef;
        this.zzep.remove(serviceConnection);
    }

    public final boolean isBound() {
        return this.zzeq;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzep.containsKey(serviceConnection);
    }

    public final boolean zzs() {
        return this.zzep.isEmpty();
    }

    public final IBinder getBinder() {
        return this.zzdl;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }
}
