package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfl {
    final zzfu zza;

    zzfl(zzfu zzfu) {
        this.zza = zzfu;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        if (str == null || str.isEmpty()) {
            this.zza.zzq().zzi().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zza.zzp().zzc();
        if (!zza()) {
            this.zza.zzq().zzu().zza("Install Referrer Reporter is not available");
            return;
        }
        zzfk zzfk = new zzfk(this, str);
        this.zza.zzp().zzc();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zza.zzm().getPackageManager();
        if (packageManager == null) {
            this.zza.zzq().zzi().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zza.zzq().zzu().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zza()) {
                this.zza.zzq().zzh().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.zza.zzq().zzw().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zza.zzm(), new Intent(intent), zzfk, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.zza.zzq().zze().zza("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    private final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzm());
            if (packageManager == null) {
                this.zza.zzq().zzw().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zza.zzq().zzw().zza("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(String str, zzd zzd) {
        this.zza.zzp().zzc();
        if (zzd == null) {
            this.zza.zzq().zzh().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza2 = zzd.zza(bundle);
            if (zza2 != null) {
                return zza2;
            }
            this.zza.zzq().zze().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
