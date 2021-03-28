package com.google.android.gms.internal.measurement;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgl {
    static int zza(byte[] bArr, int i, zzgo zzgo) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzgo);
        }
        zzgo.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzgo zzgo) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgo.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgo.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgo.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgo.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgo.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzgo zzgo) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzgo.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzgo.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzgo zzgo) throws zzij {
        int zza = zza(bArr, i, zzgo);
        int i2 = zzgo.zza;
        if (i2 < 0) {
            throw zzij.zzb();
        } else if (i2 == 0) {
            zzgo.zzc = "";
            return zza;
        } else {
            zzgo.zzc = new String(bArr, zza, i2, zzia.zza);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzgo zzgo) throws zzij {
        int zza = zza(bArr, i, zzgo);
        int i2 = zzgo.zza;
        if (i2 < 0) {
            throw zzij.zzb();
        } else if (i2 == 0) {
            zzgo.zzc = "";
            return zza;
        } else {
            zzgo.zzc = zzlb.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzgo zzgo) throws zzij {
        int zza = zza(bArr, i, zzgo);
        int i2 = zzgo.zza;
        if (i2 < 0) {
            throw zzij.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzij.zza();
        } else if (i2 == 0) {
            zzgo.zzc = zzgp.zza;
            return zza;
        } else {
            zzgo.zzc = zzgp.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zza(zzkb zzkb, byte[] bArr, int i, int i2, zzgo zzgo) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzgo);
            b2 = zzgo.zza;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzij.zza();
        }
        Object zza = zzkb.zza();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzkb.zza(zza, bArr, i3, i4, zzgo);
        zzkb.zzc(zza);
        zzgo.zzc = zza;
        return i4;
    }

    static int zza(zzkb zzkb, byte[] bArr, int i, int i2, int i3, zzgo zzgo) throws IOException {
        zzjn zzjn = (zzjn) zzkb;
        Object zza = zzjn.zza();
        int zza2 = zzjn.zza(zza, bArr, i, i2, i3, zzgo);
        zzjn.zzc(zza);
        zzgo.zzc = zza;
        return zza2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzig<?> zzig, zzgo zzgo) {
        zzib zzib = (zzib) zzig;
        int zza = zza(bArr, i2, zzgo);
        zzib.zzd(zzgo.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgo);
            if (i != zzgo.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgo);
            zzib.zzd(zzgo.zza);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzig<?> zzig, zzgo zzgo) throws IOException {
        zzib zzib = (zzib) zzig;
        int zza = zza(bArr, i, zzgo);
        int i2 = zzgo.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgo);
            zzib.zzd(zzgo.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzij.zza();
    }

    static int zza(zzkb<?> zzkb, int i, byte[] bArr, int i2, int i3, zzig<?> zzig, zzgo zzgo) throws IOException {
        int zza = zza(zzkb, bArr, i2, i3, zzgo);
        zzig.add(zzgo.zzc);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgo);
            if (i != zzgo.zza) {
                break;
            }
            zza = zza(zzkb, bArr, zza2, i3, zzgo);
            zzig.add(zzgo.zzc);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzks zzks, zzgo zzgo) throws zzij {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzgo);
                zzks.zza(i, Long.valueOf(zzgo.zzb));
                return zzb;
            } else if (i4 == 1) {
                zzks.zza(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzgo);
                int i5 = zzgo.zza;
                if (i5 < 0) {
                    throw zzij.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzks.zza(i, zzgp.zza);
                    } else {
                        zzks.zza(i, zzgp.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzij.zza();
                }
            } else if (i4 == 3) {
                zzks zzb2 = zzks.zzb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzgo);
                    int i8 = zzgo.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzb2, zzgo);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzij.zzg();
                }
                zzks.zza(i, zzb2);
                return i2;
            } else if (i4 == 5) {
                zzks.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzij.zzd();
            }
        } else {
            throw zzij.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzgo zzgo) throws zzij {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzgo);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzgo) + zzgo.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzgo);
                    i6 = zzgo.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzgo);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzij.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzij.zzd();
            }
        } else {
            throw zzij.zzd();
        }
    }
}
