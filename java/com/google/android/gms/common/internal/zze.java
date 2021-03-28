package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public final class zze extends GmsClientSupervisor implements Handler.Callback {
    private final Handler mHandler;
    private final HashMap<GmsClientSupervisor.zza, zzg> zzee = new HashMap<>();
    private final Context zzef;
    private final ConnectionTracker zzeg;
    private final long zzeh;
    private final long zzei;

    zze(Context context) {
        this.zzef = context.getApplicationContext();
        this.mHandler = new zzi(context.getMainLooper(), this);
        this.zzeg = ConnectionTracker.getInstance();
        this.zzeh = 5000;
        this.zzei = 300000;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zza(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzee) {
            zzg zzg = this.zzee.get(zza);
            if (zzg == null) {
                zzg = new zzg(this, zza);
                zzg.zza(serviceConnection, serviceConnection, str);
                zzg.zzf(str);
                this.zzee.put(zza, zzg);
            } else {
                this.mHandler.removeMessages(0, zza);
                if (!zzg.zza(serviceConnection)) {
                    zzg.zza(serviceConnection, serviceConnection, str);
                    int state = zzg.getState();
                    if (state == 1) {
                        serviceConnection.onServiceConnected(zzg.getComponentName(), zzg.getBinder());
                    } else if (state == 2) {
                        zzg.zzf(str);
                    }
                } else {
                    String valueOf = String.valueOf(zza);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zzg.isBound();
        }
        return isBound;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zzb(GmsClientSupervisor.zza zza, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzee) {
            zzg zzg = this.zzee.get(zza);
            if (zzg == null) {
                String valueOf = String.valueOf(zza);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzg.zza(serviceConnection)) {
                zzg.zza(serviceConnection, str);
                if (zzg.zzs()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zza), this.zzeh);
                }
            } else {
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zzee) {
                GmsClientSupervisor.zza zza = (GmsClientSupervisor.zza) message.obj;
                zzg zzg = this.zzee.get(zza);
                if (zzg != null && zzg.zzs()) {
                    if (zzg.isBound()) {
                        zzg.zzg("GmsClientSupervisor");
                    }
                    this.zzee.remove(zza);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zzee) {
                GmsClientSupervisor.zza zza2 = (GmsClientSupervisor.zza) message.obj;
                zzg zzg2 = this.zzee.get(zza2);
                if (zzg2 != null && zzg2.getState() == 3) {
                    String valueOf = String.valueOf(zza2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentName = zzg2.getComponentName();
                    if (componentName == null) {
                        componentName = zza2.getComponentName();
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(zza2.getPackage(), "unknown");
                    }
                    zzg2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
