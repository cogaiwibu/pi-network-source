package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhy implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhb zza;

    private zzhy(zzhb zzhb) {
        this.zza = zzhb;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzq().zzw().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    this.zza.zzh().zza(activity, bundle);
                    return;
                }
                this.zza.zzo();
                this.zza.zzp().zza(new zzib(this, bundle == null, data, zzkv.zza(intent) ? "gs" : "auto", data.getQueryParameter(TapjoyConstants.TJC_REFERRER)));
                this.zza.zzh().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzh().zza(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
        // Method dump skipped, instructions count: 487
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzh().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzh().zzb(activity);
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjz(zzj, zzj.zzl().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjw(zzj, zzj.zzl().elapsedRealtime()));
        this.zza.zzh().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzh().zzb(activity, bundle);
    }

    /* synthetic */ zzhy(zzhb zzhb, zzhc zzhc) {
        this(zzhb);
    }
}
