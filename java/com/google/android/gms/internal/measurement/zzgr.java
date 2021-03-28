package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzgr implements Comparator<zzgp> {
    zzgr() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzgp zzgp, zzgp zzgp2) {
        zzgp zzgp3 = zzgp;
        zzgp zzgp4 = zzgp2;
        zzgy zzgy = (zzgy) zzgp3.iterator();
        zzgy zzgy2 = (zzgy) zzgp4.iterator();
        while (zzgy.hasNext() && zzgy2.hasNext()) {
            int compare = C$r8$backportedMethods$utility$Integer$2$compare.compare(zzgp.zzb(zzgy.zza()), zzgp.zzb(zzgy2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return C$r8$backportedMethods$utility$Integer$2$compare.compare(zzgp3.zza(), zzgp4.zza());
    }
}
