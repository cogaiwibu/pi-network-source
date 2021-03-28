package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zziv extends zzit {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziv() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzkz.zzf(obj, j);
        if (list instanceof zziq) {
            obj2 = ((zziq) list).h_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzjv) || !(list instanceof zzig)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzig zzig = (zzig) list;
                if (zzig.zza()) {
                    zzig.i_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzkz.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzir zzir;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zziq) {
                list = new zzir(i);
            } else if (!(zzc instanceof zzjv) || !(zzc instanceof zzig)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzig) zzc).zza(i);
            }
            zzkz.zza(obj, j, list);
            return list;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzkz.zza(obj, j, arrayList);
            zzir = arrayList;
        } else if (zzc instanceof zzku) {
            zzir zzir2 = new zzir(zzc.size() + i);
            zzir2.addAll((zzku) zzc);
            zzkz.zza(obj, j, zzir2);
            zzir = zzir2;
        } else if (!(zzc instanceof zzjv) || !(zzc instanceof zzig)) {
            return zzc;
        } else {
            zzig zzig = (zzig) zzc;
            if (zzig.zza()) {
                return zzc;
            }
            zzig zza2 = zzig.zza(zzc.size() + i);
            zzkz.zza(obj, j, zza2);
            return zza2;
        }
        return zzir;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzkz.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }
}
