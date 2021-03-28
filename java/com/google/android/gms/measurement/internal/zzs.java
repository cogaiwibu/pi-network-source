package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzs {
    private zzcd.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzr zzd;

    private zzs(zzr zzr) {
        this.zzd = zzr;
    }

    /* access modifiers changed from: package-private */
    public final zzcd.zzc zza(String str, zzcd.zzc zzc2) {
        String zzc3 = zzc2.zzc();
        List<zzcd.zze> zza2 = zzc2.zza();
        this.zzd.f_();
        Long l = (Long) zzkr.zzb(zzc2, "_eid");
        boolean z = l != null;
        if (z && zzc3.equals("_ep")) {
            this.zzd.f_();
            zzc3 = (String) zzkr.zzb(zzc2, "_en");
            if (TextUtils.isEmpty(zzc3)) {
                this.zzd.zzq().zzf().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzcd.zzc, Long> zza3 = this.zzd.zzi().zza(str, l);
                if (zza3 == null || zza3.first == null) {
                    this.zzd.zzq().zzf().zza("Extra parameter without existing main event. eventName, eventId", zzc3, l);
                    return null;
                }
                this.zza = (zzcd.zzc) zza3.first;
                this.zzc = ((Long) zza3.second).longValue();
                this.zzd.f_();
                this.zzb = (Long) zzkr.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzaf zzi = this.zzd.zzi();
                zzi.zzc();
                zzi.zzq().zzw().zza("Clearing complex main event info. appId", str);
                try {
                    zzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzi.zzq().zze().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzcd.zze zze : this.zza.zza()) {
                this.zzd.f_();
                if (zzkr.zza(zzc2, zze.zzb()) == null) {
                    arrayList.add(zze);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza2);
                zza2 = arrayList;
            } else {
                this.zzd.zzq().zzf().zza("No unique parameters in main event. eventName", zzc3);
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzc2;
            this.zzd.f_();
            long j2 = 0L;
            Object zzb2 = zzkr.zzb(zzc2, "_epc");
            if (zzb2 != null) {
                j2 = zzb2;
            }
            long longValue = ((Long) j2).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzq().zzf().zza("Complex event with zero extra param count. eventName", zzc3);
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, zzc2);
            }
        }
        return (zzcd.zzc) ((zzhy) ((zzcd.zzc.zza) zzc2.zzbo()).zza(zzc3).zzc().zza(zza2).zzy());
    }

    /* synthetic */ zzs(zzr zzr, zzq zzq) {
        this(zzr);
    }
}
