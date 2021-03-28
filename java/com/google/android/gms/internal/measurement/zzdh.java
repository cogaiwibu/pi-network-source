package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzdh<T> {
    private static final Object zza = new Object();
    @Nullable
    private static volatile zzdp zzb = null;
    private static volatile boolean zzc = false;
    private static final AtomicReference<Collection<zzdh<?>>> zzd = new AtomicReference<>();
    private static zzdq zze = new zzdq(zzdj.zza);
    private static final AtomicInteger zzi = new AtomicInteger();
    private final zzdm zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;

    @Deprecated
    public static void zza(Context context) {
        synchronized (zza) {
            zzdp zzdp = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzdp == null || zzdp.zza() != context) {
                zzct.zzc();
                zzdo.zza();
                zzcy.zza();
                zzb = new zzcq(context, zzef.zza((zzec) new zzdg(context)));
                zzi.incrementAndGet();
            }
        }
    }

    static final /* synthetic */ boolean zzd() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zza() {
        zzi.incrementAndGet();
    }

    private zzdh(zzdm zzdm, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzdm.zza != null) {
            this.zzf = zzdm;
            this.zzg = str;
            this.zzh = t;
            this.zzl = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzg);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zzf.zzc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdh.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzdh<Long> zzb(zzdm zzdm, String str, long j, boolean z) {
        return new zzdi(zzdm, str, Long.valueOf(j), true);
    }

    /* access modifiers changed from: private */
    public static zzdh<Boolean> zzb(zzdm zzdm, String str, boolean z, boolean z2) {
        return new zzdl(zzdm, str, Boolean.valueOf(z), true);
    }

    /* access modifiers changed from: private */
    public static zzdh<Double> zzb(zzdm zzdm, String str, double d, boolean z) {
        return new zzdk(zzdm, str, Double.valueOf(-3.0d), true);
    }

    /* access modifiers changed from: private */
    public static zzdh<String> zzb(zzdm zzdm, String str, String str2, boolean z) {
        return new zzdn(zzdm, str, str2, true);
    }

    static final /* synthetic */ zzdy zzb(Context context) {
        new zzdc();
        return zzdc.zza(context);
    }

    /* synthetic */ zzdh(zzdm zzdm, String str, Object obj, boolean z, zzdi zzdi) {
        this(zzdm, str, obj, z);
    }
}
