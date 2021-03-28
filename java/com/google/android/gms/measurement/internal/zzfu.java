package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzml;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzfu implements zzgt {
    private static volatile zzfu zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private AtomicInteger zzah = new AtomicInteger(0);
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzw zzh;
    private final zzab zzi;
    private final zzfc zzj;
    private final zzeq zzk;
    private final zzfr zzl;
    private final zzjx zzm;
    private final zzkv zzn;
    private final zzeo zzo;
    private final Clock zzp;
    private final zzii zzq;
    private final zzhb zzr;
    private final zza zzs;
    private final zzid zzt;
    private zzem zzu;
    private zzir zzv;
    private zzak zzw;
    private zzen zzx;
    private zzfl zzy;
    private boolean zzz = false;

    private zzfu(zzgy zzgy) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzgy);
        zzw zzw2 = new zzw(zzgy.zza);
        this.zzh = zzw2;
        zzeg.zza = zzw2;
        this.zzc = zzgy.zza;
        this.zzd = zzgy.zzb;
        this.zze = zzgy.zzc;
        this.zzf = zzgy.zzd;
        this.zzg = zzgy.zzh;
        this.zzac = zzgy.zze;
        this.zzaf = true;
        zzae zzae2 = zzgy.zzg;
        if (!(zzae2 == null || zzae2.zzg == null)) {
            Object obj = zzae2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzae2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        zzdh.zza(this.zzc);
        this.zzp = DefaultClock.getInstance();
        if (zzgy.zzi != null) {
            j = zzgy.zzi.longValue();
        } else {
            j = this.zzp.currentTimeMillis();
        }
        this.zza = j;
        this.zzi = new zzab(this);
        zzfc zzfc = new zzfc(this);
        zzfc.zzac();
        this.zzj = zzfc;
        zzeq zzeq = new zzeq(this);
        zzeq.zzac();
        this.zzk = zzeq;
        zzkv zzkv = new zzkv(this);
        zzkv.zzac();
        this.zzn = zzkv;
        zzeo zzeo = new zzeo(this);
        zzeo.zzac();
        this.zzo = zzeo;
        this.zzs = new zza(this);
        zzii zzii = new zzii(this);
        zzii.zzw();
        this.zzq = zzii;
        zzhb zzhb = new zzhb(this);
        zzhb.zzw();
        this.zzr = zzhb;
        zzjx zzjx = new zzjx(this);
        zzjx.zzw();
        this.zzm = zzjx;
        zzid zzid = new zzid(this);
        zzid.zzac();
        this.zzt = zzid;
        zzfr zzfr = new zzfr(this);
        zzfr.zzac();
        this.zzl = zzfr;
        if (!(zzgy.zzg == null || zzgy.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzc.getApplicationContext() instanceof Application) {
            zzhb zzg2 = zzg();
            if (zzg2.zzm().getApplicationContext() instanceof Application) {
                Application application = (Application) zzg2.zzm().getApplicationContext();
                if (zzg2.zza == null) {
                    zzg2.zza = new zzhy(zzg2, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzg2.zza);
                    application.registerActivityLifecycleCallbacks(zzg2.zza);
                    zzg2.zzq().zzw().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzq().zzh().zza("Application context is not an Application");
        }
        this.zzl.zza(new zzfw(this, zzgy));
    }

    /* access modifiers changed from: private */
    public final void zza(zzgy zzgy) {
        zzes zzes;
        String str;
        zzp().zzc();
        zzak zzak = new zzak(this);
        zzak.zzac();
        this.zzw = zzak;
        zzen zzen = new zzen(this, zzgy.zzf);
        zzen.zzw();
        this.zzx = zzen;
        zzem zzem = new zzem(this);
        zzem.zzw();
        this.zzu = zzem;
        zzir zzir = new zzir(this);
        zzir.zzw();
        this.zzv = zzir;
        this.zzn.zzad();
        this.zzj.zzad();
        this.zzy = new zzfl(this);
        this.zzx.zzx();
        zzq().zzu().zza("App measurement initialized, version", 33025L);
        zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzaa2 = zzen.zzaa();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzh().zze(zzaa2)) {
                zzes = zzq().zzu();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzes zzu2 = zzq().zzu();
                String valueOf = String.valueOf(zzaa2);
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzes = zzu2;
            }
            zzes.zza(str);
        }
        zzq().zzv().zza("Debug-level message logging enabled");
        if (this.zzag != this.zzah.get()) {
            zzq().zze().zza("Not all components initialized", Integer.valueOf(this.zzag), Integer.valueOf(this.zzah.get()));
        }
        this.zzz = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        if (r10.equals(com.google.android.gms.measurement.internal.zzac.zza) == false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.measurement.zzae r10) {
        /*
        // Method dump skipped, instructions count: 870
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(com.google.android.gms.internal.measurement.zzae):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzh;
    }

    public final zzab zza() {
        return this.zzi;
    }

    public final zzfc zzb() {
        zza((zzgr) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzeq zzc() {
        zzeq zzeq = this.zzk;
        if (zzeq == null || !zzeq.zzaa()) {
            return null;
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzjx zzd() {
        zzb(this.zzm);
        return this.zzm;
    }

    public final zzfl zze() {
        return this.zzy;
    }

    /* access modifiers changed from: package-private */
    public final zzfr zzf() {
        return this.zzl;
    }

    public final zzhb zzg() {
        zzb(this.zzr);
        return this.zzr;
    }

    public final zzkv zzh() {
        zza((zzgr) this.zzn);
        return this.zzn;
    }

    public final zzeo zzi() {
        zza((zzgr) this.zzo);
        return this.zzo;
    }

    public final zzem zzj() {
        zzb(this.zzu);
        return this.zzu;
    }

    private final zzid zzah() {
        zzb(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzc;
    }

    public final boolean zzk() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzn() {
        return this.zzd;
    }

    public final String zzo() {
        return this.zze;
    }

    public final String zzr() {
        return this.zzf;
    }

    public final boolean zzs() {
        return this.zzg;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzp;
    }

    public final zzii zzu() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzir zzv() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzak zzw() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzen zzx() {
        zzb(this.zzx);
        return this.zzx;
    }

    public final zza zzy() {
        zza zza2 = this.zzs;
        if (zza2 != null) {
            return zza2;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfu zza(Context context, zzae zzae2, Long l) {
        if (zzae2 != null && (zzae2.zze == null || zzae2.zzf == null)) {
            zzae2 = new zzae(zzae2.zza, zzae2.zzb, zzae2.zzc, zzae2.zzd, null, null, zzae2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfu.class) {
                if (zzb == null) {
                    zzb = new zzfu(new zzgy(context, zzae2, l));
                }
            }
        } else if (!(zzae2 == null || zzae2.zzg == null || !zzae2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zzb.zza(zzae2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgq zzgq) {
        if (zzgq == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgq.zzaa()) {
            String valueOf = String.valueOf(zzgq.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zzg zzg2) {
        if (zzg2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzg2.zzu()) {
            String valueOf = String.valueOf(zzg2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzgr zzgr) {
        if (zzgr == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final boolean zzz() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzaa() {
        return zzab() == 0;
    }

    public final int zzab() {
        zzp().zzc();
        if (this.zzi.zzf()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (zzml.zzb() && this.zzi.zza(zzas.zzcg) && !zzac()) {
            return 8;
        }
        Boolean zzu2 = zzb().zzu();
        if (zzu2 == null) {
            Boolean zzf2 = this.zzi.zzf("firebase_analytics_collection_enabled");
            if (zzf2 == null) {
                Boolean bool2 = this.zzad;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzi.zza(zzas.zzar) || this.zzac == null || this.zzac.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzf2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzu2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final void zzb(boolean z) {
        zzp().zzc();
        this.zzaf = z;
    }

    public final boolean zzac() {
        zzp().zzc();
        return this.zzaf;
    }

    /* access modifiers changed from: package-private */
    public final void zzad() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgq zzgq) {
        this.zzag++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzg zzg2) {
        this.zzag++;
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        this.zzah.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaf() {
        if (this.zzz) {
            zzp().zzc();
            Boolean bool = this.zzaa;
            if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
                this.zzab = this.zzp.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzh().zzc("android.permission.INTERNET") && zzh().zzc("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfm.zza(this.zzc) && zzkv.zza(this.zzc, false))));
                this.zzaa = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzh().zza(zzx().zzab(), zzx().zzac(), zzx().zzad()) && TextUtils.isEmpty(zzx().zzac())) {
                        z = false;
                    }
                    this.zzaa = Boolean.valueOf(z);
                }
            }
            return this.zzaa.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final void zzag() {
        zzp().zzc();
        zzb(zzah());
        String zzaa2 = zzx().zzaa();
        Pair<String, Boolean> zza2 = zzb().zza(zzaa2);
        if (!this.zzi.zzg().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzah().zzf()) {
            zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzkv zzh2 = zzh();
            zzx();
            URL zza3 = zzh2.zza(33025, zzaa2, (String) zza2.first, zzb().zzt.zza() - 1);
            zzid zzah2 = zzah();
            zzfx zzfx = new zzfx(this);
            zzah2.zzc();
            zzah2.zzab();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzfx);
            zzah2.zzp().zzc(new zzif(zzah2, zzaa2, zza3, null, null, zzfx));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzq().zzh().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzb().zzs.zza(true);
        if (bArr.length == 0) {
            zzq().zzv().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzq().zzv().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkv zzh2 = zzh();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzh2.zzm().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzq().zzh().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zzkv zzh3 = zzh();
            if (!TextUtils.isEmpty(optString) && zzh3.zza(optString, optDouble)) {
                zzh3.zzm().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzq().zze().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
