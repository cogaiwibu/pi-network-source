package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public abstract class GmsClientSupervisor {
    private static final Object zzec = new Object();
    private static GmsClientSupervisor zzed;

    /* access modifiers changed from: protected */
    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void zzb(zza zza2, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    public static final class zza {
        private static final Uri zzem = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        private final ComponentName componentName;
        private final String packageName;
        private final String zzej;
        private final int zzek;
        private final boolean zzel;

        public zza(String str, int i) {
            this(str, "com.google.android.gms", 129);
        }

        private zza(String str, String str2, int i) {
            this(str, str2, 129, false);
        }

        public zza(String str, String str2, int i, boolean z) {
            this.zzej = Preconditions.checkNotEmpty(str);
            this.packageName = Preconditions.checkNotEmpty(str2);
            this.componentName = null;
            this.zzek = i;
            this.zzel = z;
        }

        public zza(ComponentName componentName2, int i) {
            this.zzej = null;
            this.packageName = null;
            this.componentName = (ComponentName) Preconditions.checkNotNull(componentName2);
            this.zzek = 129;
            this.zzel = false;
        }

        public final String toString() {
            String str = this.zzej;
            return str == null ? this.componentName.flattenToString() : str;
        }

        public final String getPackage() {
            return this.packageName;
        }

        public final ComponentName getComponentName() {
            return this.componentName;
        }

        public final int zzq() {
            return this.zzek;
        }

        public final Intent zzb(Context context) {
            if (this.zzej == null) {
                return new Intent().setComponent(this.componentName);
            }
            Intent intent = null;
            if (this.zzel) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.zzej);
                Bundle call = context.getContentResolver().call(zzem, "serviceIntentCall", (String) null, bundle);
                if (call != null) {
                    intent = (Intent) call.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf = String.valueOf(this.zzej);
                    Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            if (intent == null) {
                return new Intent(this.zzej).setPackage(this.packageName);
            }
            return intent;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zzej, this.packageName, this.componentName, Integer.valueOf(this.zzek), Boolean.valueOf(this.zzel));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return Objects.equal(this.zzej, zza.zzej) && Objects.equal(this.packageName, zza.packageName) && Objects.equal(this.componentName, zza.componentName) && this.zzek == zza.zzek && this.zzel == zza.zzel;
        }
    }

    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zzec) {
            if (zzed == null) {
                zzed = new zze(context.getApplicationContext());
            }
        }
        return zzed;
    }

    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str, 129), serviceConnection, str2);
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName, 129), serviceConnection, str);
    }

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str, 129), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        zzb(new zza(str, str2, i, z), serviceConnection, str3);
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName, 129), serviceConnection, str);
    }
}
