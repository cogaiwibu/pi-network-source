package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzej<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzeh<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzej(String str, V v, V v2, zzeh<V> zzeh) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzeh;
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzas.zzco.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002f, code lost:
        if (r4.hasNext() == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0031, code lost:
        r0 = (com.google.android.gms.measurement.internal.zzej) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (com.google.android.gms.measurement.internal.zzw.zza() != false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0040, code lost:
        if (r0.zzb == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0042, code lost:
        r1 = r0.zzb.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0059, code lost:
        throw new java.lang.IllegalStateException("Refreshing flag cache must be done on a worker thread.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V zza(V r4) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzej.zza(java.lang.Object):java.lang.Object");
    }
}
