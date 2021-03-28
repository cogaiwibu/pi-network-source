package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznw;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzfz extends zzel {
    private final zzkl zza;
    private Boolean zzb;
    private String zzc;

    public zzfz(zzkl zzkl) {
        this(zzkl, null);
    }

    private zzfz(zzkl zzkl, String str) {
        Preconditions.checkNotNull(zzkl);
        this.zza = zzkl;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zzb(zzn zzn) {
        zzb(zzn, false);
        zza(new zzgb(this, zzn));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zze(zzn zzn) {
        if (zzml.zzb() && this.zza.zzb().zza(zzas.zzci)) {
            Preconditions.checkNotEmpty(zzn.zza);
            Preconditions.checkNotNull(zzn.zzw);
            zzgj zzgj = new zzgj(this, zzn);
            Preconditions.checkNotNull(zzgj);
            if (this.zza.zzp().zzf()) {
                zzgj.run();
            } else {
                this.zza.zzp().zzb(zzgj);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzaq zzaq, zzn zzn) {
        Preconditions.checkNotNull(zzaq);
        zzb(zzn, false);
        zza(new zzgi(this, zzaq, zzn));
    }

    /* access modifiers changed from: package-private */
    public final zzaq zzb(zzaq zzaq, zzn zzn) {
        boolean z = false;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaq.zza) || zzaq.zzb == null || zzaq.zzb.zza() == 0)) {
            String zzd = zzaq.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                z = true;
            }
        }
        if (!z) {
            return zzaq;
        }
        this.zza.zzq().zzu().zza("Event has been filtered ", zzaq.toString());
        return new zzaq("_cmpx", zzaq.zzb, zzaq.zzc, zzaq.zzd);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzaq zzaq, String str, String str2) {
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzgl(this, zzaq, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final byte[] zza(zzaq zzaq, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaq);
        zza(str, true);
        this.zza.zzq().zzv().zza("Log and bundle. event", this.zza.zzj().zza(zzaq.zza));
        long nanoTime = this.zza.zzl().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzp().zzb(new zzgk(this, zzaq, str)).get();
            if (bArr == null) {
                this.zza.zzq().zze().zza("Log and bundle returned null. appId", zzeq.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzq().zzv().zza("Log and bundle processed. event, size, time_ms", this.zza.zzj().zza(zzaq.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzl().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to log and bundle. appId, event, error", zzeq.zza(str), this.zza.zzj().zza(zzaq.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzku zzku, zzn zzn) {
        Preconditions.checkNotNull(zzku);
        zzb(zzn, false);
        zza(new zzgn(this, zzku, zzn));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(zzn zzn, boolean z) {
        zzb(zzn, false);
        try {
            List<zzkw> list = (List) this.zza.zzp().zza(new zzgm(this, zzn)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkw zzkw : list) {
                if (z || !zzkv.zzd(zzkw.zzc)) {
                    arrayList.add(new zzku(zzkw));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get user properties. appId", zzeq.zza(zzn.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzn zzn) {
        zzb(zzn, false);
        zza(new zzgp(this, zzn));
    }

    private final void zzb(zzn zzn, boolean z) {
        Preconditions.checkNotNull(zzn);
        zza(zzn.zza, false);
        this.zza.zzk().zza(zzn.zzb, zzn.zzr, zzn.zzv);
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzm(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzm()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzq().zze().zza("Measurement Service called with invalid calling package. appId", zzeq.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzm(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.zza.zzq().zze().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzgo(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(Bundle bundle, zzn zzn) {
        if (zznw.zzb() && this.zza.zzb().zza(zzas.zzbz)) {
            zzb(zzn, false);
            zza(new zzfy(this, zzn, bundle));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final String zzc(zzn zzn) {
        zzb(zzn, false);
        return this.zza.zzd(zzn);
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzz zzz, zzn zzn) {
        Preconditions.checkNotNull(zzz);
        Preconditions.checkNotNull(zzz.zzc);
        zzb(zzn, false);
        zzz zzz2 = new zzz(zzz);
        zzz2.zza = zzn.zza;
        zza(new zzga(this, zzz2, zzn));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zza(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        Preconditions.checkNotNull(zzz.zzc);
        zza(zzz.zza, true);
        zza(new zzgd(this, new zzz(zzz)));
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(String str, String str2, boolean z, zzn zzn) {
        zzb(zzn, false);
        try {
            List<zzkw> list = (List) this.zza.zzp().zza(new zzgc(this, zzn, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkw zzkw : list) {
                if (z || !zzkv.zzd(zzkw.zzc)) {
                    arrayList.add(new zzku(zzkw));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to query user properties. appId", zzeq.zza(zzn.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzku> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzkw> list = (List) this.zza.zzp().zza(new zzgf(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzkw zzkw : list) {
                if (z || !zzkv.zzd(zzkw.zzc)) {
                    arrayList.add(new zzku(zzkw));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get user properties as. appId", zzeq.zza(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzz> zza(String str, String str2, zzn zzn) {
        zzb(zzn, false);
        try {
            return (List) this.zza.zzp().zza(new zzge(this, zzn, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final List<zzz> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzp().zza(new zzgh(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzei
    public final void zzd(zzn zzn) {
        zza(zzn.zza, false);
        zza(new zzgg(this, zzn));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzp().zzf()) {
            runnable.run();
        } else {
            this.zza.zzp().zza(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzn zzn, Bundle bundle) {
        this.zza.zze().zza(zzn.zza, bundle);
    }
}
