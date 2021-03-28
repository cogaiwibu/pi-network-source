package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzir extends zzg {
    private final zzjl zza;
    private zzei zzb;
    private volatile Boolean zzc;
    private final zzai zzd;
    private final zzke zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzai zzg;

    protected zzir(zzfu zzfu) {
        super(zzfu);
        this.zze = new zzke(zzfu.zzl());
        this.zza = new zzjl(this);
        this.zzd = new zziq(this, zzfu);
        this.zzg = new zzja(this, zzfu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzy() {
        return false;
    }

    public final boolean zzaa() {
        zzc();
        zzv();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        zzc();
        zzv();
        zza(new zzjc(this, zzb(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(boolean z) {
        if (zzml.zzb() && zzs().zza(zzas.zzcg)) {
            zzc();
            zzv();
            if (z) {
                zzi().zzaa();
            }
            if (zzai()) {
                zza(new zzjf(this, zzb(false)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzei zzei, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        zzc();
        zzv();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza2 = zzi().zza(100);
            if (zza2 != null) {
                arrayList.addAll(zza2);
                i = zza2.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        zzei.zza((zzaq) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        zzq().zze().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzku) {
                    try {
                        zzei.zza((zzku) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        zzq().zze().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzz) {
                    try {
                        zzei.zza((zzz) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        zzq().zze().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzq().zze().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzaq zzaq, String str) {
        Preconditions.checkNotNull(zzaq);
        zzc();
        zzv();
        zza(new zzje(this, true, zzi().zza(zzaq), zzaq, zzb(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        zzc();
        zzv();
        zza(new zzjh(this, true, zzi().zza(zzz), new zzz(zzz), zzb(true), zzz));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzz>> atomicReference, String str, String str2, String str3) {
        zzc();
        zzv();
        zza(new zzjg(this, atomicReference, str, str2, str3, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw, String str, String str2) {
        zzc();
        zzv();
        zza(new zzjj(this, str, str2, zzb(false), zzw));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzku>> atomicReference, String str, String str2, String str3, boolean z) {
        zzc();
        zzv();
        zza(new zzji(this, atomicReference, str, str2, str3, z, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw, String str, String str2, boolean z) {
        zzc();
        zzv();
        zza(new zzit(this, str, str2, z, zzb(false), zzw));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzku zzku) {
        zzc();
        zzv();
        zza(new zzis(this, zzi().zza(zzku), zzku, zzb(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzku>> atomicReference, boolean z) {
        zzc();
        zzv();
        zza(new zziv(this, atomicReference, zzb(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzc();
        zzv();
        zzn zzb2 = zzb(false);
        zzi().zzaa();
        zza(new zziu(this, zzb2));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzc();
        zzv();
        zza(new zzix(this, atomicReference, zzb(false)));
    }

    public final void zza(zzw zzw) {
        zzc();
        zzv();
        zza(new zziw(this, zzb(false), zzw));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzc();
        zzv();
        zzn zzb2 = zzb(true);
        zzi().zzab();
        zza(new zziz(this, zzb2));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzij zzij) {
        zzc();
        zzv();
        zza(new zziy(this, zzij));
    }

    public final void zza(Bundle bundle) {
        zzc();
        zzv();
        zza(new zzjb(this, bundle, zzb(false)));
    }

    /* access modifiers changed from: private */
    public final void zzaj() {
        zzc();
        this.zze.zza();
        this.zzd.zza(zzas.zzai.zza(null).longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        zzc();
        zzv();
        if (!zzaa()) {
            if (zzak()) {
                this.zza.zzb();
            } else if (!zzs().zzy()) {
                List<ResolveInfo> queryIntentServices = zzm().getPackageManager().queryIntentServices(new Intent().setClassName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzq().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzaf() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzak() {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzir.zzak():boolean");
    }

    /* access modifiers changed from: protected */
    public final void zza(zzei zzei) {
        zzc();
        Preconditions.checkNotNull(zzei);
        this.zzb = zzei;
        zzaj();
        zzam();
    }

    public final void zzag() {
        zzc();
        zzv();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzm(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzc();
        if (this.zzb != null) {
            this.zzb = null;
            zzq().zzw().zza("Disconnected from device MeasurementService", componentName);
            zzc();
            zzae();
        }
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzc();
        if (zzaa()) {
            zzq().zzw().zza("Inactivity, disconnecting from the service");
            zzag();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzc();
        if (zzaa()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzq().zze().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzae();
        }
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzc();
        zzq().zzw().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable runnable : this.zzf) {
            try {
                runnable.run();
            } catch (Exception e) {
                zzq().zze().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzn zzb(boolean z) {
        return zzf().zza(z ? zzq().zzx() : null);
    }

    public final void zza(zzw zzw, zzaq zzaq, String str) {
        zzc();
        zzv();
        if (zzo().zza(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzq().zzh().zza("Not bundling data. Service unavailable or out of date");
            zzo().zza(zzw, new byte[0]);
            return;
        }
        zza(new zzjd(this, zzaq, str, zzw));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzah() {
        zzc();
        zzv();
        if (zzak() && zzo().zzi() < 200900) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        zzc();
        zzv();
        if (!zzs().zza(zzas.zzci)) {
            return false;
        }
        if (zzak() && zzo().zzi() < zzas.zzcj.zza(null).intValue()) {
            return false;
        }
        return true;
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
