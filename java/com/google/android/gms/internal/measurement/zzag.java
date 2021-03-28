package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgz;
import com.google.android.gms.measurement.internal.zzig;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class zzag {
    private static volatile zzag zzb;
    private static Boolean zzh;
    private static String zzi;
    private static boolean zzj;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<zzgz, zzd>> zzf;
    private int zzg;
    private boolean zzk;
    private String zzl;
    private volatile zzv zzm;

    public class zzc implements Application.ActivityLifecycleCallbacks {
        zzc() {
            zzag.this = r1;
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzag.this.zza((zzag) new zzbp(this, bundle, activity));
        }

        public final void onActivityStarted(Activity activity) {
            zzag.this.zza((zzag) new zzbo(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzag.this.zza((zzag) new zzbr(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzag.this.zza((zzag) new zzbq(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzag.this.zza((zzag) new zzbt(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzt zzt = new zzt();
            zzag.this.zza((zzag) new zzbs(this, activity, zzt));
            Bundle zzb = zzt.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzag.this.zza((zzag) new zzbu(this, activity));
        }
    }

    public static zzag zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        zzb(zzag zzag) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zza() throws RemoteException;

        public void zzb() {
        }

        zzb(boolean z) {
            zzag.this = r3;
            this.zza = r3.zza.currentTimeMillis();
            this.zzb = r3.zza.elapsedRealtime();
            this.zzc = z;
        }

        public void run() {
            if (zzag.this.zzk) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzag.this.zza((zzag) e, (Exception) false, this.zzc);
                zzb();
            }
        }
    }

    public static zzag zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzag.class) {
                if (zzb == null) {
                    zzb = new zzag(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public static class zza extends zzaa {
        private final zzgw zza;

        zza(zzgw zzgw) {
            this.zza = zzgw;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public static class zzd extends zzaa {
        private final zzgz zza;

        zzd(zzgz zzgz) {
            this.zza = zzgz;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    private zzag(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzi.zza().zza(new zzas(this), zzr.zza);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        boolean z = false;
        if (!(!zze(context) || zzk())) {
            this.zzl = null;
            this.zzk = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzl = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzl = str2;
        }
        zza(new zzaj(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private static boolean zze(Context context) {
        try {
            return zzig.zza(context, "google_app_id") != null;
        } catch (IllegalStateException unused) {
        }
    }

    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private final void zza(zzb zzb2) {
        this.zzd.execute(zzb2);
    }

    public final zzv zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzu.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    public static int zzf(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzg(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    private final void zza(Exception exc, boolean z, boolean z2) {
        this.zzk |= z;
        if (z) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzgw zzgw) {
        zza zza2 = new zza(zzgw);
        if (this.zzm != null) {
            try {
                this.zzm.setEventInterceptor(zza2);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza(new zzbf(this, zza2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4.zzm == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.zzm.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        android.util.Log.w(r4.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        zza(new com.google.android.gms.internal.measurement.zzbl(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzgz r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            int r2 = r2.size()     // Catch:{ all -> 0x0055 }
            if (r1 >= r2) goto L_0x002b
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0055 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = r4.zzc     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            com.google.android.gms.internal.measurement.zzag$zzd r1 = new com.google.android.gms.internal.measurement.zzag$zzd     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0055 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0055 }
            r2.add(r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.measurement.zzv r5 = r4.zzm
            if (r5 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzv r5 = r4.zzm     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r5 = r4.zzc
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzbl r5 = new com.google.android.gms.internal.measurement.zzbl
            r5.<init>(r4, r1)
            r4.zza(r5)
            return
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)
            goto L_0x0059
        L_0x0058:
            throw r5
        L_0x0059:
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzag.zza(com.google.android.gms.measurement.internal.zzgz):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r4.zzm == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.zzm.unregisterOnMeasurementEventListener(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        android.util.Log.w(r4.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        zza(new com.google.android.gms.internal.measurement.zzbk(r4, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzgz r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
            r2 = 0
        L_0x0008:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r3 = r4.zzf     // Catch:{ all -> 0x005c }
            int r3 = r3.size()     // Catch:{ all -> 0x005c }
            if (r2 >= r3) goto L_0x002d
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r3 = r4.zzf     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x005c }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x005c }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x002a
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r5 = r4.zzf     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x005c }
            r1 = r5
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ all -> 0x005c }
            goto L_0x002d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x002d:
            if (r1 != 0) goto L_0x0038
            java.lang.String r5 = r4.zzc     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            return
        L_0x0038:
            java.util.List<android.util.Pair<com.google.android.gms.measurement.internal.zzgz, com.google.android.gms.internal.measurement.zzag$zzd>> r5 = r4.zzf     // Catch:{ all -> 0x005c }
            r5.remove(r1)     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r1.second     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.measurement.zzag$zzd r5 = (com.google.android.gms.internal.measurement.zzag.zzd) r5     // Catch:{ all -> 0x005c }
            monitor-exit(r0)     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.measurement.zzv r0 = r4.zzm
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.measurement.zzv r0 = r4.zzm     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            r0.unregisterOnMeasurementEventListener(r5)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004c }
            return
        L_0x004c:
            java.lang.String r0 = r4.zzc
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x0053:
            com.google.android.gms.internal.measurement.zzbk r0 = new com.google.android.gms.internal.measurement.zzbk
            r0.<init>(r4, r5)
            r4.zza(r0)
            return
        L_0x005c:
            r5 = move-exception
            monitor-exit(r0)
            goto L_0x0060
        L_0x005f:
            throw r5
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzag.zzb(com.google.android.gms.measurement.internal.zzgz):void");
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzbn(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzbm(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza(new zzai(this, bundle));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(new zzal(this, str, str2, bundle));
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzt zzt = new zzt();
        zza(new zzak(this, str, str2, zzt));
        List<Bundle> list = (List) zzt.zza(zzt.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zza(String str) {
        zza(new zzan(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzam(this, activity, str, str2));
    }

    public final void zza(Boolean bool) {
        zza(new zzap(this, bool));
    }

    public final void zzb(Bundle bundle) {
        zza(new zzao(this, bundle));
    }

    public final void zzc(Bundle bundle) {
        zza(new zzar(this, bundle));
    }

    public final void zzb() {
        zza(new zzaq(this));
    }

    public final void zza(long j) {
        zza(new zzat(this, j));
    }

    public final void zzb(String str) {
        zza(new zzav(this, str));
    }

    public final void zzc(String str) {
        zza(new zzau(this, str));
    }

    public final String zzc() {
        zzt zzt = new zzt();
        zza(new zzax(this, zzt));
        return zzt.zza(500);
    }

    public final String zzd() {
        zzt zzt = new zzt();
        zza(new zzaw(this, zzt));
        return zzt.zza(50);
    }

    public final long zze() {
        zzt zzt = new zzt();
        zza(new zzaz(this, zzt));
        Long l = (Long) zzt.zza(zzt.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzt zzt = new zzt();
        zza(new zzay(this, zzt));
        return zzt.zza(500);
    }

    public final String zzg() {
        zzt zzt = new zzt();
        zza(new zzbb(this, zzt));
        return zzt.zza(500);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzt zzt = new zzt();
        zza(new zzba(this, str, str2, z, zzt));
        Bundle zzb2 = zzt.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzbd(this, false, 5, str, obj, null, null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzt zzt = new zzt();
        zza(new zzbc(this, bundle, zzt));
        if (z) {
            return zzt.zzb(5000);
        }
        return null;
    }

    public final int zzd(String str) {
        zzt zzt = new zzt();
        zza(new zzbe(this, str, zzt));
        Integer num = (Integer) zzt.zza(zzt.zzb(TapjoyConstants.TIMER_INCREMENT), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String zzh() {
        zzt zzt = new zzt();
        zza(new zzbh(this, zzt));
        return zzt.zza(120000);
    }

    public final String zzi() {
        return this.zzl;
    }

    public final Object zza(int i) {
        zzt zzt = new zzt();
        zza(new zzbg(this, zzt, i));
        return zzt.zza(zzt.zzb(15000), Object.class);
    }

    public final void zza(boolean z) {
        zza(new zzbj(this, z));
    }

    public final void zzd(Bundle bundle) {
        zza(new zzbi(this, bundle));
    }

    public static void zzh(Context context) {
        synchronized (zzag.class) {
            try {
                if (zzh == null) {
                    if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                        zzh = Boolean.valueOf(zzj);
                        return;
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzi, zzj));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.remove(zzi);
                    edit.apply();
                }
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = Boolean.valueOf(zzj);
            }
        }
    }

    private static boolean zza(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static /* synthetic */ zzv zzc(zzag zzag) {
        return zzag.zzm;
    }
}
