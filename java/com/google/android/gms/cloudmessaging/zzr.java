package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zzr {
    private final Context zza;
    private int zzb;
    private int zzc = 0;

    public zzr(Context context) {
        this.zza = context;
    }

    public final synchronized int zza() {
        if (this.zzc != 0) {
            return this.zzc;
        }
        PackageManager packageManager = this.zza.getPackageManager();
        if (Wrappers.packageManager(this.zza).checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.zzc = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.zzc = 2;
            } else {
                this.zzc = 1;
            }
            return this.zzc;
        }
        this.zzc = 2;
        return 2;
    }

    public final synchronized int zzb() {
        PackageInfo zza2;
        if (this.zzb == 0 && (zza2 = zza("com.google.android.gms")) != null) {
            this.zzb = zza2.versionCode;
        }
        return this.zzb;
    }

    private final PackageInfo zza(String str) {
        try {
            return Wrappers.packageManager(this.zza).getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("Metadata", sb.toString());
            return null;
        }
    }
}
