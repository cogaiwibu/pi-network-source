package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class ConnectionTracker {
    private static final Object zzfw = new Object();
    private static volatile ConnectionTracker zzfx;
    private static boolean zzfy = false;
    private final List<String> zzfz = Collections.EMPTY_LIST;
    private final List<String> zzga = Collections.EMPTY_LIST;
    private final List<String> zzgb = Collections.EMPTY_LIST;
    private final List<String> zzgc = Collections.EMPTY_LIST;

    public static ConnectionTracker getInstance() {
        if (zzfx == null) {
            synchronized (zzfw) {
                if (zzfx == null) {
                    zzfx = new ConnectionTracker();
                }
            }
        }
        return zzfx;
    }

    private ConnectionTracker() {
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = ClientLibraryUtils.zzc(context, component.getPackageName());
        }
        if (!z) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }
}
