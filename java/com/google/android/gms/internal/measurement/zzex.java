package com.google.android.gms.internal.measurement;

import kotlin.UByte;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzex {
    static int zza(int i, int i2, int i3) {
        return (i & (i3 ^ -1)) | (i2 & i3);
    }

    static int zzb(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    static Object zza(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            StringBuilder sb = new StringBuilder(52);
            sb.append("must be power of 2 between 2^1 and 2^30: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= 256) {
            return new byte[i];
        } else {
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
    }

    static int zza(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & UByte.MAX_VALUE;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i] & UShort.MAX_VALUE;
        }
        return ((int[]) obj)[i];
    }

    static void zza(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    static int zza(@NullableDecl Object obj, @NullableDecl Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @NullableDecl Object[] objArr2) {
        int i2;
        int i3;
        int zza = zzez.zza(obj);
        int i4 = zza & i;
        int zza2 = zza(obj3, i4);
        if (zza2 == 0) {
            return -1;
        }
        int i5 = i ^ -1;
        int i6 = zza & i5;
        int i7 = -1;
        while (true) {
            i2 = zza2 - 1;
            i3 = iArr[i2];
            if ((i3 & i5) != i6 || !zzdz.zza(obj, objArr[i2]) || (objArr2 != null && !zzdz.zza(obj2, objArr2[i2]))) {
                int i8 = i3 & i;
                if (i8 == 0) {
                    return -1;
                }
                i7 = i2;
                zza2 = i8;
            }
        }
        int i9 = i3 & i;
        if (i7 == -1) {
            zza(obj3, i4, i9);
        } else {
            iArr[i7] = zza(iArr[i7], i9, i);
        }
        return i2;
    }
}
