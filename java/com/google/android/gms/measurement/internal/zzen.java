package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzen extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzen(zzfu zzfu, long j) {
        super(zzfu);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzy() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b9 A[Catch:{ IllegalStateException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01da A[Catch:{ IllegalStateException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01dc A[Catch:{ IllegalStateException -> 0x0253 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0236  */
    @Override // com.google.android.gms.measurement.internal.zzg
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzz() {
        /*
        // Method dump skipped, instructions count: 730
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzen.zzz():void");
    }

    /* access modifiers changed from: package-private */
    public final zzn zza(String str) {
        String str2;
        long j;
        Boolean bool;
        zzc();
        String zzaa = zzaa();
        String zzab = zzab();
        zzv();
        String str3 = this.zzb;
        long zzae = (long) zzae();
        zzv();
        String str4 = this.zzd;
        zzv();
        zzc();
        if (this.zzf == 0) {
            this.zzf = this.zzy.zzh().zza(zzm(), zzm().getPackageName());
        }
        long j2 = this.zzf;
        boolean zzaa2 = this.zzy.zzaa();
        boolean z = !zzr().zzq;
        zzc();
        if (!this.zzy.zzaa()) {
            str2 = null;
        } else {
            str2 = zzah();
        }
        zzfu zzfu = this.zzy;
        Long valueOf = Long.valueOf(zzfu.zzb().zzh.zza());
        if (valueOf.longValue() == 0) {
            j = zzfu.zza;
        } else {
            j = Math.min(zzfu.zza, valueOf.longValue());
        }
        int zzaf = zzaf();
        boolean booleanValue = zzs().zzg().booleanValue();
        Boolean zzf2 = zzs().zzf("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzf2 == null || zzf2.booleanValue()).booleanValue();
        zzfc zzr = zzr();
        zzr.zzc();
        boolean z2 = zzr.zzf().getBoolean("deferred_analytics_collection", false);
        String zzac = zzac();
        Boolean zzf3 = zzs().zzf("google_analytics_default_allow_ad_personalization_signals");
        if (zzf3 == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(true ^ zzf3.booleanValue());
        }
        return new zzn(zzaa, zzab, str3, zzae, str4, 33025, j2, str, zzaa2, z, str2, 0, j, zzaf, booleanValue, booleanValue2, z2, zzac, bool, this.zzg, this.zzh, (!zznv.zzb() || !zzs().zza(zzas.zzbi)) ? null : zzad(), (!zzml.zzb() || !zzs().zza(zzas.zzcg)) ? "" : zzr().zzx().zza());
    }

    private final String zzah() {
        if (!zzpg.zzb() || !zzs().zza(zzas.zzbk)) {
            try {
                Class<?> loadClass = zzm().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzm());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzq().zzj().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzq().zzi().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzq().zzw().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzaa() {
        zzv();
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzab() {
        zzv();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzv();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzv();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzae() {
        zzv();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzaf() {
        zzv();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzag() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }
}
