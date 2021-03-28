package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzii extends zzg {
    protected zzij zza;
    private volatile zzij zzb;
    private zzij zzc;
    private final Map<Activity, zzij> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzij zzg;
    private zzij zzh;
    private boolean zzi;
    private final Object zzj = new Object();
    private zzij zzk;
    private String zzl;

    public zzii(zzfu zzfu) {
        super(zzfu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzy() {
        return false;
    }

    public final zzij zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzas.zzbu) || !z) {
            return this.zza;
        }
        zzij zzij = this.zza;
        return zzij != null ? zzij : this.zzh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        r1 = zzq().zzw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        if (r10 != null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e8, code lost:
        if (r2 != null) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ea, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        r1.zza("Logging screen view with name, class", r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f5, code lost:
        if (r17.zzb != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f7, code lost:
        r1 = r17.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fa, code lost:
        r1 = r17.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fc, code lost:
        r4 = new com.google.android.gms.measurement.internal.zzij(r10, r2, zzo().zzf(), true, r19);
        r17.zzb = r4;
        r17.zzc = r1;
        r17.zzg = r4;
        zzp().zza(new com.google.android.gms.measurement.internal.zzil(r17, r18, r4, r1, zzl().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r18, long r19) {
        /*
        // Method dump skipped, instructions count: 305
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzii.zza(android.os.Bundle, long):void");
    }

    /* access modifiers changed from: private */
    public final void zza(Bundle bundle, zzij zzij, zzij zzij2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zza(zzij, zzij2, j, true, zzo().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc2 = zzkv.zzc(this.zzb.zzb, str2);
            boolean zzc3 = zzkv.zzc(this.zzb.zza, str);
            if (zzc2 && zzc3) {
                zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzij zzij = new zzij(str, str2, zzo().zzf());
                this.zzd.put(activity, zzij);
                zza(activity, zzij, true);
            } else {
                zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzij zzaa() {
        return this.zzb;
    }

    private final void zza(Activity activity, zzij zzij, boolean z) {
        zzij zzij2;
        zzij zzij3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzij.zzb == null) {
            zzij2 = new zzij(zzij.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzij.zzc, zzij.zze, zzij.zzf);
        } else {
            zzij2 = zzij;
        }
        this.zzc = this.zzb;
        this.zzb = zzij2;
        zzp().zza(new zzik(this, zzij2, zzij3, zzl().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    public final void zza(zzij zzij, zzij zzij2, long j, boolean z, Bundle bundle) {
        boolean z2;
        long j2;
        zzij zzij3;
        zzc();
        boolean z3 = false;
        if (zzs().zza(zzas.zzas)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzij3 = this.zza) != null) {
                zza(zzij3, true, j);
            }
            z2 = false;
        }
        if (zzij2 == null || zzij2.zzc != zzij.zzc || !zzkv.zzc(zzij2.zzb, zzij.zzb) || !zzkv.zzc(zzij2.zza, zzij.zza)) {
            z3 = true;
        }
        if (z3) {
            Bundle bundle2 = new Bundle();
            if (zzs().zza(zzas.zzbu)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            zza(zzij, bundle2, true);
            if (zzij2 != null) {
                if (zzij2.zza != null) {
                    bundle2.putString("_pn", zzij2.zza);
                }
                if (zzij2.zzb != null) {
                    bundle2.putString("_pc", zzij2.zzb);
                }
                bundle2.putLong("_pi", zzij2.zzc);
            }
            if (zzs().zza(zzas.zzas) && z2) {
                if (!zznk.zzb() || !zzs().zza(zzas.zzau)) {
                    j2 = zzj().zzb.zzb();
                } else {
                    j2 = zzj().zza(j);
                }
                if (j2 > 0) {
                    zzo().zza(bundle2, j2);
                }
            }
            String str = "auto";
            if (zzs().zza(zzas.zzbu)) {
                if (!zzs().zzh().booleanValue()) {
                    bundle2.putLong("_mst", 1);
                }
                if (zzij.zze) {
                    str = TapjoyConstants.TJC_APP_PLACEMENT;
                }
            }
            if (zzs().zza(zzas.zzbu)) {
                long currentTimeMillis = zzl().currentTimeMillis();
                if (zzij.zze && zzij.zzf != 0) {
                    currentTimeMillis = zzij.zzf;
                }
                zze().zza(str, "_vs", currentTimeMillis, bundle2);
            } else {
                zze().zzb(str, "_vs", bundle2);
            }
        }
        this.zza = zzij;
        if (zzs().zza(zzas.zzbu) && zzij.zze) {
            this.zzh = zzij;
        }
        zzg().zza(zzij);
    }

    /* access modifiers changed from: private */
    public final void zza(zzij zzij, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (zzj().zza(zzij != null && zzij.zzd, z, j) && zzij != null) {
            zzij.zzd = false;
        }
    }

    public static void zza(zzij zzij, Bundle bundle, boolean z) {
        if (bundle != null && zzij != null && (!bundle.containsKey("_sc") || z)) {
            if (zzij.zza != null) {
                bundle.putString("_sn", zzij.zza);
            } else {
                bundle.remove("_sn");
            }
            if (zzij.zzb != null) {
                bundle.putString("_sc", zzij.zzb);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzij.zzc);
        } else if (bundle != null && zzij == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzij zzij) {
        zzc();
        synchronized (this) {
            if (this.zzl == null || this.zzl.equals(str) || zzij != null) {
                this.zzl = str;
                this.zzk = zzij;
            }
        }
    }

    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzij zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzij zzij = this.zzd.get(activity);
        if (zzij == null) {
            zzij zzij2 = new zzij(null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.zzd.put(activity, zzij2);
            zzij = zzij2;
        }
        return (zzs().zza(zzas.zzbu) && this.zzg != null) ? this.zzg : zzij;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zzs().zzh().booleanValue() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzij(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zza(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzs().zza(zzas.zzbt) && zzs().zzh().booleanValue()) {
                        this.zzg = null;
                        zzp().zza(new zzio(this));
                    }
                }
            }
        }
        if (!zzs().zza(zzas.zzbt) || zzs().zzh().booleanValue()) {
            zza(activity, zzd(activity), false);
            zza zzd2 = zzd();
            zzd2.zzp().zza(new zze(zzd2, zzd2.zzl().elapsedRealtime()));
            return;
        }
        this.zzb = this.zzg;
        zzp().zza(new zzin(this));
    }

    public final void zzb(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = zzl().elapsedRealtime();
        if (!zzs().zza(zzas.zzbt) || zzs().zzh().booleanValue()) {
            zzij zzd2 = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzp().zza(new zzip(this, zzd2, elapsedRealtime));
            return;
        }
        this.zzb = null;
        zzp().zza(new zzim(this, elapsedRealtime));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzij zzij;
        if (zzs().zzh().booleanValue() && bundle != null && (zzij = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzij.zzc);
            bundle2.putString("name", zzij.zza);
            bundle2.putString("referrer_name", zzij.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.zzd.remove(activity);
        }
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
