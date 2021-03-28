package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzmy;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzfn implements Runnable {
    private final /* synthetic */ zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzfk zzc;

    zzfn(zzfk zzfk, zzd zzd, ServiceConnection serviceConnection) {
        this.zzc = zzfk;
        this.zza = zzd;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzfl zzfl = this.zzc.zza;
        String zza2 = zzfk.zza(this.zzc);
        zzd zzd = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzfl.zza(zza2, zzd);
        zzfl.zza.zzp().zzc();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfl.zza.zzq().zzh().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfl.zza.zzq().zze().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfl.zza.zzq().zzw().zza("InstallReferrer API result", string);
                    zzkv zzh = zzfl.zza.zzh();
                    String valueOf = String.valueOf(string);
                    Bundle zza4 = zzh.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza4 == null) {
                        zzfl.zza.zzq().zze().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza4.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfl.zza.zzq().zze().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfl.zza.zzb().zzi.zza()) {
                            zzfl.zza.zzq().zzw().zza("Install Referrer campaign has already been logged");
                        } else if (!zzmy.zzb() || !zzfl.zza.zza().zza(zzas.zzbs) || zzfl.zza.zzaa()) {
                            zzfl.zza.zzb().zzi.zza(j);
                            zzfl.zza.zzq().zzw().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza4.putString("_cis", "referrer API");
                            zzfl.zza.zzg().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zza4);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfl.zza.zzm(), serviceConnection);
        }
    }
}
