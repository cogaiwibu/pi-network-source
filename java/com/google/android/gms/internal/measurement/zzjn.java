package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.FileTreeWalk;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjn<T> implements zzkb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkz.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjr zzo;
    private final zzit zzp;
    private final zzkt<?, ?> zzq;
    private final zzhn<?> zzr;
    private final zzjc zzs;

    private zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjr, zzit zzit, zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjc zzjc) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjj instanceof zzhy;
        this.zzj = z;
        this.zzh = zzhn != null && zzhn.zza(zzjj);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjr;
        this.zzp = zzit;
        this.zzq = zzkt;
        this.zzr = zzhn;
        this.zzg = zzjj;
        this.zzs = zzjc;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzjn<T> zza(Class<T> cls, zzjh zzjh, zzjr zzjr, zzit zzit, zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjc zzjc) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str;
        Object[] objArr;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        int i19;
        Field field2;
        Field field3;
        int i20;
        char charAt2;
        int i21;
        char charAt3;
        int i22;
        char charAt4;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        int i27;
        char charAt9;
        int i28;
        char charAt10;
        int i29;
        char charAt11;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        if (zzjh instanceof zzjz) {
            zzjz zzjz = (zzjz) zzjh;
            int i32 = 0;
            boolean z2 = zzjz.zza() == zzju.zzb;
            String zzd2 = zzjz.zzd();
            int length = zzd2.length();
            if (zzd2.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i = i33 + 1;
                    if (zzd2.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i;
                }
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int charAt14 = zzd2.charAt(i);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = zzd2.charAt(i34);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i35 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i31;
                }
                charAt14 = i35 | (charAt13 << i36);
                i34 = i31;
            }
            if (charAt14 == 0) {
                iArr = zza;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = zzd2.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = zzd2.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i30;
                    }
                    charAt15 = i38 | (charAt12 << i39);
                    i37 = i30;
                }
                int i40 = i37 + 1;
                int charAt16 = zzd2.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = zzd2.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i41 |= (charAt11 & 8191) << i42;
                        i42 += 13;
                        i40 = i29;
                    }
                    charAt16 = i41 | (charAt11 << i42);
                    i40 = i29;
                }
                int i43 = i40 + 1;
                i6 = zzd2.charAt(i40);
                if (i6 >= 55296) {
                    int i44 = i6 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = zzd2.charAt(i43);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i44 |= (charAt10 & 8191) << i45;
                        i45 += 13;
                        i43 = i28;
                    }
                    i6 = i44 | (charAt10 << i45);
                    i43 = i28;
                }
                int i46 = i43 + 1;
                i5 = zzd2.charAt(i43);
                if (i5 >= 55296) {
                    int i47 = i5 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = zzd2.charAt(i46);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i47 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i46 = i27;
                    }
                    i5 = i47 | (charAt9 << i48);
                    i46 = i27;
                }
                int i49 = i46 + 1;
                i4 = zzd2.charAt(i46);
                if (i4 >= 55296) {
                    int i50 = i4 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = zzd2.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i50 |= (charAt8 & 8191) << i51;
                        i51 += 13;
                        i49 = i26;
                    }
                    i4 = i50 | (charAt8 << i51);
                    i49 = i26;
                }
                int i52 = i49 + 1;
                i3 = zzd2.charAt(i49);
                if (i3 >= 55296) {
                    int i53 = i3 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = zzd2.charAt(i52);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i53 |= (charAt7 & 8191) << i54;
                        i54 += 13;
                        i52 = i25;
                    }
                    i3 = i53 | (charAt7 << i54);
                    i52 = i25;
                }
                int i55 = i52 + 1;
                int charAt17 = zzd2.charAt(i52);
                if (charAt17 >= 55296) {
                    int i56 = charAt17 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = zzd2.charAt(i55);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i57;
                        i57 += 13;
                        i55 = i24;
                    }
                    charAt17 = i56 | (charAt6 << i57);
                    i55 = i24;
                }
                int i58 = i55 + 1;
                i2 = zzd2.charAt(i55);
                if (i2 >= 55296) {
                    int i59 = i2 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = zzd2.charAt(i60);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i59 |= (charAt5 & 8191) << i61;
                        i61 += 13;
                        i60 = i23;
                    }
                    i2 = i59 | (charAt5 << i61);
                    i58 = i23;
                }
                i7 = (charAt15 << 1) + charAt16;
                iArr = new int[(i2 + i3 + charAt17)];
                i32 = charAt15;
                i34 = i58;
            }
            Unsafe unsafe = zzb;
            Object[] zze2 = zzjz.zze();
            Class<?> cls2 = zzjz.zzc().getClass();
            int[] iArr2 = new int[(i4 * 3)];
            Object[] objArr2 = new Object[(i4 << 1)];
            int i62 = i2 + i3;
            int i63 = i7;
            int i64 = i2;
            int i65 = i34;
            int i66 = i62;
            int i67 = 0;
            int i68 = 0;
            while (i65 < length) {
                int i69 = i65 + 1;
                int charAt18 = zzd2.charAt(i65);
                if (charAt18 >= 55296) {
                    int i70 = charAt18 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i22 = i71 + 1;
                        charAt4 = zzd2.charAt(i71);
                        i8 = length;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i70 |= (charAt4 & 8191) << i72;
                        i72 += 13;
                        i71 = i22;
                        length = i8;
                    }
                    charAt18 = i70 | (charAt4 << i72);
                    i9 = i22;
                } else {
                    i8 = length;
                    i9 = i69;
                }
                int i73 = i9 + 1;
                int charAt19 = zzd2.charAt(i9);
                if (charAt19 >= 55296) {
                    int i74 = charAt19 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i21 = i75 + 1;
                        charAt3 = zzd2.charAt(i75);
                        i10 = i2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i74 |= (charAt3 & 8191) << i76;
                        i76 += 13;
                        i75 = i21;
                        i2 = i10;
                    }
                    charAt19 = i74 | (charAt3 << i76);
                    i11 = i21;
                } else {
                    i10 = i2;
                    i11 = i73;
                }
                int i77 = charAt19 & 255;
                if ((charAt19 & 1024) != 0) {
                    iArr[i67] = i68;
                    i67++;
                }
                if (i77 >= 51) {
                    int i78 = i11 + 1;
                    int charAt20 = zzd2.charAt(i11);
                    char c = 55296;
                    if (charAt20 >= 55296) {
                        int i79 = charAt20 & 8191;
                        int i80 = 13;
                        while (true) {
                            i20 = i78 + 1;
                            charAt2 = zzd2.charAt(i78);
                            if (charAt2 < c) {
                                break;
                            }
                            i79 |= (charAt2 & 8191) << i80;
                            i80 += 13;
                            i78 = i20;
                            c = 55296;
                        }
                        charAt20 = i79 | (charAt2 << i80);
                        i78 = i20;
                    }
                    int i81 = i77 - 51;
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr2[((i68 / 3) << 1) + 1] = zze2[i63];
                        i63++;
                    } else {
                        if (i81 == 12 && !z2) {
                            objArr2[((i68 / 3) << 1) + 1] = zze2[i63];
                            i63++;
                        }
                        i19 = 1;
                    }
                    int i82 = charAt20 << i19;
                    Object obj = zze2[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zze2[i82] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = zze2[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zze2[i83] = field3;
                    }
                    str = zzd2;
                    i14 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i13 = objectFieldOffset;
                    i12 = i78;
                    i15 = 0;
                } else {
                    int i84 = i63 + 1;
                    Field zza2 = zza(cls2, (String) zze2[i63]);
                    if (i77 == 9 || i77 == 17) {
                        objArr2[((i68 / 3) << 1) + 1] = zza2.getType();
                    } else {
                        if (i77 == 27 || i77 == 49) {
                            i18 = i84 + 1;
                            objArr2[((i68 / 3) << 1) + 1] = zze2[i84];
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr2[((i68 / 3) << 1) + 1] = zze2[i84];
                            }
                        } else if (i77 == 50) {
                            int i85 = i64 + 1;
                            iArr[i64] = i68;
                            int i86 = (i68 / 3) << 1;
                            i18 = i84 + 1;
                            objArr2[i86] = zze2[i84];
                            if ((charAt19 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr2[i86 + 1] = zze2[i18];
                                i64 = i85;
                            } else {
                                i64 = i85;
                            }
                        }
                        i16 = i18;
                        i13 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt19 & 4096) == 4096 || i77 > 17) {
                            str = zzd2;
                            z = z2;
                            objArr = objArr2;
                            i14 = 1048575;
                            i12 = i11;
                            i15 = 0;
                        } else {
                            int i87 = i11 + 1;
                            int charAt21 = zzd2.charAt(i11);
                            if (charAt21 >= 55296) {
                                int i88 = charAt21 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = zzd2.charAt(i87);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i88 |= (charAt & 8191) << i89;
                                    i89 += 13;
                                    i87 = i17;
                                }
                                charAt21 = i88 | (charAt << i89);
                                i87 = i17;
                            }
                            int i90 = (i32 << 1) + (charAt21 / 32);
                            Object obj3 = zze2[i90];
                            str = zzd2;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zze2[i90] = field;
                            }
                            z = z2;
                            objArr = objArr2;
                            i15 = charAt21 % 32;
                            i12 = i87;
                            i14 = (int) unsafe.objectFieldOffset(field);
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = i13;
                            i66++;
                        }
                        i63 = i16;
                    }
                    i16 = i84;
                    i13 = (int) unsafe.objectFieldOffset(zza2);
                    if ((charAt19 & 4096) == 4096) {
                    }
                    str = zzd2;
                    z = z2;
                    objArr = objArr2;
                    i14 = 1048575;
                    i12 = i11;
                    i15 = 0;
                    iArr[i66] = i13;
                    i66++;
                    i63 = i16;
                }
                int i91 = i68 + 1;
                iArr2[i68] = charAt18;
                int i92 = i91 + 1;
                iArr2[i91] = ((charAt19 & 256) != 0 ? 268435456 : 0) | ((charAt19 & 512) != 0 ? 536870912 : 0) | (i77 << 20) | i13;
                int i93 = i92 + 1;
                iArr2[i92] = (i15 << 20) | i14;
                i65 = i12;
                i32 = i32;
                i5 = i5;
                objArr2 = objArr;
                i2 = i10;
                i6 = i6;
                z2 = z;
                i68 = i93;
                length = i8;
                zzd2 = str;
            }
            return new zzjn<>(iArr2, objArr2, i6, i5, zzjz.zzc(), z2, false, iArr, i2, i62, zzjr, zzit, zzkt, zzhn, zzjc);
        }
        ((zzkm) zzjh).zza();
        int i94 = zzju.zzb;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zza(T t) {
        int i;
        int i2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzd2 = zzd(i4);
            int i5 = this.zzc[i4];
            long j = (long) (1048575 & zzd2);
            int i6 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzia.zza(Double.doubleToLongBits(zzkz.zze(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzkz.zzd(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzc(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzkz.zzf(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzf2 = zzkz.zzf(t, j);
                    if (zzf2 != null) {
                        i6 = zzf2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzf3 = zzkz.zzf(t, j);
                    if (zzf3 != null) {
                        i6 = zzf3.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(Double.doubleToLongBits(zzb(t, j)));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzc(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zzkz.zzf(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((Object) t2, i)) {
                            zzkz.zza(t, j, zzkz.zze(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzd(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((Object) t2, i)) {
                            zzkz.zza(t, j, zzkz.zzc(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((Object) t2, i)) {
                            zzkz.zza(t, j, zzkz.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (zza((Object) t2, i)) {
                            zzkz.zza(t, j, zzkz.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((Object) t2, i)) {
                            zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzkd.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (zza(t2, i2, i)) {
                            zzkz.zza(t, j, zzkz.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (zza(t2, i2, i)) {
                            zzkz.zza(t, j, zzkz.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzkd.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzkd.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzf2 = zzkz.zzf(t, zzd2);
            Object zzf3 = zzkz.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzkz.zza(t, zzd2, zzia.zza(zzf2, zzf3));
                zzb((Object) t, i);
            } else if (zzf3 != null) {
                zzkz.zza(t, zzd2, zzf3);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object obj = null;
            if (zza(t, i2, i)) {
                obj = zzkz.zzf(t, j);
            }
            Object zzf2 = zzkz.zzf(t2, j);
            if (obj != null && zzf2 != null) {
                zzkz.zza(t, j, zzia.zza(obj, zzf2));
                zzb(t, i2, i);
            } else if (zzf2 != null) {
                zzkz.zza(t, j, zzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zzb(T t) {
        int i;
        long j;
        int i2;
        int zzb2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int zzb3;
        int i8;
        int i9;
        int i10;
        int i11 = 267386880;
        int i12 = 1048575;
        int i13 = 1;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i14 = 0;
            int i15 = 0;
            while (i14 < this.zzc.length) {
                int zzd2 = zzd(i14);
                int i16 = (zzd2 & i11) >>> 20;
                int i17 = this.zzc[i14];
                long j2 = (long) (zzd2 & 1048575);
                if (i16 >= zzhs.DOUBLE_LIST_PACKED.zza() && i16 <= zzhs.SINT64_LIST_PACKED.zza()) {
                    int i18 = this.zzc[i14 + 2];
                }
                switch (i16) {
                    case 0:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzb(i17, 0.0d);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 1:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzb(i17, 0.0f);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 2:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzd(i17, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 3:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zze(i17, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 4:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzf(i17, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 5:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzg(i17, 0L);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 6:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzi(i17, 0);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 7:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzb(i17, true);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 8:
                        if (zza((Object) t, i14)) {
                            Object zzf2 = zzkz.zzf(t, j2);
                            if (zzf2 instanceof zzgp) {
                                zzb3 = zzhi.zzc(i17, (zzgp) zzf2);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i17, (String) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 9:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzkd.zza(i17, zzkz.zzf(t, j2), zza(i14));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 10:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzc(i17, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 11:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzg(i17, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 12:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzk(i17, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 13:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzj(i17, 0);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 14:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzh(i17, 0L);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 15:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzh(i17, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 16:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzf(i17, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 17:
                        if (zza((Object) t, i14)) {
                            zzb3 = zzhi.zzc(i17, (zzjj) zzkz.zzf(t, j2), zza(i14));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 18:
                        zzb3 = zzkd.zzi(i17, zza(t, j2), false);
                        break;
                    case 19:
                        zzb3 = zzkd.zzh(i17, zza(t, j2), false);
                        break;
                    case 20:
                        zzb3 = zzkd.zza(i17, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        zzb3 = zzkd.zzb(i17, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        zzb3 = zzkd.zze(i17, zza(t, j2), false);
                        break;
                    case 23:
                        zzb3 = zzkd.zzi(i17, zza(t, j2), false);
                        break;
                    case 24:
                        zzb3 = zzkd.zzh(i17, zza(t, j2), false);
                        break;
                    case 25:
                        zzb3 = zzkd.zzj(i17, zza(t, j2), false);
                        break;
                    case 26:
                        zzb3 = zzkd.zza(i17, zza(t, j2));
                        break;
                    case 27:
                        zzb3 = zzkd.zza(i17, zza(t, j2), zza(i14));
                        break;
                    case 28:
                        zzb3 = zzkd.zzb(i17, zza(t, j2));
                        break;
                    case 29:
                        zzb3 = zzkd.zzf(i17, zza(t, j2), false);
                        break;
                    case 30:
                        zzb3 = zzkd.zzd(i17, zza(t, j2), false);
                        break;
                    case 31:
                        zzb3 = zzkd.zzh(i17, zza(t, j2), false);
                        break;
                    case 32:
                        zzb3 = zzkd.zzi(i17, zza(t, j2), false);
                        break;
                    case 33:
                        zzb3 = zzkd.zzg(i17, zza(t, j2), false);
                        break;
                    case 34:
                        zzb3 = zzkd.zzc(i17, zza(t, j2), false);
                        break;
                    case 35:
                        i9 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 36:
                        i9 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 37:
                        i9 = zzkd.zza((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 38:
                        i9 = zzkd.zzb((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 39:
                        i9 = zzkd.zze((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 40:
                        i9 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 41:
                        i9 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 42:
                        i9 = zzkd.zzj((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 43:
                        i9 = zzkd.zzf((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 44:
                        i9 = zzkd.zzd((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 45:
                        i9 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 46:
                        i9 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 47:
                        i9 = zzkd.zzg((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 48:
                        i9 = zzkd.zzc((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            i10 = zzhi.zze(i17);
                            i8 = zzhi.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 49:
                        zzb3 = zzkd.zzb(i17, (List<zzjj>) zza(t, j2), zza(i14));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i17, zzkz.zzf(t, j2), zzb(i14));
                        break;
                    case 51:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzb(i17, 0.0d);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 52:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzb(i17, 0.0f);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 53:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzd(i17, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 54:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zze(i17, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 55:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzf(i17, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 56:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzg(i17, 0L);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 57:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzi(i17, 0);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 58:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzb(i17, true);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 59:
                        if (zza(t, i17, i14)) {
                            Object zzf3 = zzkz.zzf(t, j2);
                            if (zzf3 instanceof zzgp) {
                                zzb3 = zzhi.zzc(i17, (zzgp) zzf3);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i17, (String) zzf3);
                                break;
                            }
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 60:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzkd.zza(i17, zzkz.zzf(t, j2), zza(i14));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 61:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzc(i17, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 62:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzg(i17, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 63:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzk(i17, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 64:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzj(i17, 0);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 65:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzh(i17, 0L);
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 66:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzh(i17, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 67:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzf(i17, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    case 68:
                        if (zza(t, i17, i14)) {
                            zzb3 = zzhi.zzc(i17, (zzjj) zzkz.zzf(t, j2), zza(i14));
                            break;
                        } else {
                            continue;
                            i14 += 3;
                            i11 = 267386880;
                        }
                    default:
                        i14 += 3;
                        i11 = 267386880;
                }
                i15 += zzb3;
                i14 += 3;
                i11 = 267386880;
            }
            return i15 + zza((zzkt) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1048575;
        int i22 = 0;
        while (i19 < this.zzc.length) {
            int zzd3 = zzd(i19);
            int[] iArr = this.zzc;
            int i23 = iArr[i19];
            int i24 = (zzd3 & 267386880) >>> 20;
            if (i24 <= 17) {
                int i25 = iArr[i19 + 2];
                int i26 = i25 & i12;
                i = i13 << (i25 >>> 20);
                if (i26 != i21) {
                    i22 = unsafe2.getInt(t, (long) i26);
                    i21 = i26;
                }
            } else {
                i = 0;
            }
            long j3 = (long) (zzd3 & i12);
            switch (i24) {
                case 0:
                    j = 0;
                    if ((i22 & i) != 0) {
                        i20 += zzhi.zzb(i23, 0.0d);
                        continue;
                        i19 += 3;
                        i12 = 1048575;
                        i13 = 1;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i22 & i) != 0) {
                        i20 += zzhi.zzb(i23, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    j = 0;
                    if ((i & i22) != 0) {
                        i2 = zzhi.zzd(i23, unsafe2.getLong(t, j3));
                        i20 += i2;
                        break;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i & i22) != 0) {
                        i2 = zzhi.zze(i23, unsafe2.getLong(t, j3));
                        i20 += i2;
                        break;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i & i22) != 0) {
                        i2 = zzhi.zzf(i23, unsafe2.getInt(t, j3));
                        i20 += i2;
                        break;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i22 & i) != 0) {
                        i2 = zzhi.zzg(i23, 0L);
                        i20 += i2;
                        break;
                    }
                    break;
                case 6:
                    if ((i22 & i) != 0) {
                        i20 += zzhi.zzi(i23, 0);
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 7:
                    if ((i22 & i) != 0) {
                        i20 += zzhi.zzb(i23, true);
                        j = 0;
                        i19 += 3;
                        i12 = 1048575;
                        i13 = 1;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 8:
                    if ((i22 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzgp) {
                            zzb2 = zzhi.zzc(i23, (zzgp) object);
                        } else {
                            zzb2 = zzhi.zzb(i23, (String) object);
                        }
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 9:
                    if ((i22 & i) != 0) {
                        zzb2 = zzkd.zza(i23, unsafe2.getObject(t, j3), zza(i19));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 10:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzc(i23, (zzgp) unsafe2.getObject(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 11:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzg(i23, unsafe2.getInt(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 12:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzk(i23, unsafe2.getInt(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 13:
                    if ((i22 & i) != 0) {
                        i3 = zzhi.zzj(i23, 0);
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 14:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzh(i23, 0L);
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 15:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzh(i23, unsafe2.getInt(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 16:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzf(i23, unsafe2.getLong(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 17:
                    if ((i22 & i) != 0) {
                        zzb2 = zzhi.zzc(i23, (zzjj) unsafe2.getObject(t, j3), zza(i19));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 18:
                    zzb2 = zzkd.zzi(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 19:
                    i4 = zzkd.zzh(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 20:
                    i4 = zzkd.zza(i23, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 21:
                    i4 = zzkd.zzb(i23, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 22:
                    i4 = zzkd.zze(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 23:
                    i4 = zzkd.zzi(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 24:
                    i4 = zzkd.zzh(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 25:
                    i4 = zzkd.zzj(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 26:
                    zzb2 = zzkd.zza(i23, (List) unsafe2.getObject(t, j3));
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 27:
                    zzb2 = zzkd.zza(i23, (List<?>) ((List) unsafe2.getObject(t, j3)), zza(i19));
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 28:
                    zzb2 = zzkd.zzb(i23, (List) unsafe2.getObject(t, j3));
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 29:
                    zzb2 = zzkd.zzf(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 30:
                    i4 = zzkd.zzd(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 31:
                    i4 = zzkd.zzh(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 32:
                    i4 = zzkd.zzi(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 33:
                    i4 = zzkd.zzg(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 34:
                    i4 = zzkd.zzc(i23, (List) unsafe2.getObject(t, j3), false);
                    i20 += i4;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 35:
                    i7 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 36:
                    i7 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 37:
                    i7 = zzkd.zza((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 38:
                    i7 = zzkd.zzb((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 39:
                    i7 = zzkd.zze((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 40:
                    i7 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 41:
                    i7 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 42:
                    i7 = zzkd.zzj((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 43:
                    i7 = zzkd.zzf((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 44:
                    i7 = zzkd.zzd((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 45:
                    i7 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 46:
                    i7 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 47:
                    i7 = zzkd.zzg((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 48:
                    i7 = zzkd.zzc((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        i6 = zzhi.zze(i23);
                        i5 = zzhi.zzg(i7);
                        i3 = i6 + i5 + i7;
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 49:
                    zzb2 = zzkd.zzb(i23, (List) unsafe2.getObject(t, j3), zza(i19));
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 50:
                    zzb2 = this.zzs.zza(i23, unsafe2.getObject(t, j3), zzb(i19));
                    i20 += zzb2;
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 51:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzb(i23, 0.0d);
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 52:
                    if (zza(t, i23, i19)) {
                        i3 = zzhi.zzb(i23, 0.0f);
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 53:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzd(i23, zze(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 54:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zze(i23, zze(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 55:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzf(i23, zzd(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 56:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzg(i23, 0L);
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 57:
                    if (zza(t, i23, i19)) {
                        i3 = zzhi.zzi(i23, 0);
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 58:
                    if (zza(t, i23, i19)) {
                        i3 = zzhi.zzb(i23, true);
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 59:
                    if (zza(t, i23, i19)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzgp) {
                            zzb2 = zzhi.zzc(i23, (zzgp) object2);
                        } else {
                            zzb2 = zzhi.zzb(i23, (String) object2);
                        }
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 60:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzkd.zza(i23, unsafe2.getObject(t, j3), zza(i19));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 61:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzc(i23, (zzgp) unsafe2.getObject(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 62:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzg(i23, zzd(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 63:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzk(i23, zzd(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 64:
                    if (zza(t, i23, i19)) {
                        i3 = zzhi.zzj(i23, 0);
                        i20 += i3;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 65:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzh(i23, 0L);
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 66:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzh(i23, zzd(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 67:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzf(i23, zze(t, j3));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                case 68:
                    if (zza(t, i23, i19)) {
                        zzb2 = zzhi.zzc(i23, (zzjj) unsafe2.getObject(t, j3), zza(i19));
                        i20 += zzb2;
                    }
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
                default:
                    j = 0;
                    i19 += 3;
                    i12 = 1048575;
                    i13 = 1;
            }
            i19 += 3;
            i12 = 1048575;
            i13 = 1;
        }
        int i27 = 0;
        int zza2 = i20 + zza((zzkt) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zzhr<?> zza3 = this.zzr.zza((Object) t);
        for (int i28 = 0; i28 < zza3.zza.zzc(); i28++) {
            Map.Entry<T, Object> zzb4 = zza3.zza.zzb(i28);
            i27 += zzhr.zza((zzht<?>) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry<T, Object> entry : zza3.zza.zzd()) {
            i27 += zzhr.zza((zzht<?>) entry.getKey(), entry.getValue());
        }
        return zza2 + i27;
    }

    private static <UT, UB> int zza(zzkt<UT, UB> zzkt, T t) {
        return zzkt.zzf(zzkt.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzlm r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2916
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzlm r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzlm):void");
    }

    private final <K, V> void zza(zzlm zzlm, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlm.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkt<UT, UB> zzkt, T t, zzlm zzlm) throws IOException {
        zzkt.zza(zzkt.zzb(t), zzlm);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjy r14, com.google.android.gms.internal.measurement.zzhl r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjy, com.google.android.gms.internal.measurement.zzhl):void");
    }

    private static zzks zze(Object obj) {
        zzhy zzhy = (zzhy) obj;
        zzks zzks = zzhy.zzb;
        if (zzks != zzks.zza()) {
            return zzks;
        }
        zzks zzb2 = zzks.zzb();
        zzhy.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzlg zzlg, Class<?> cls, zzgo zzgo) throws IOException {
        switch (zzjm.zza[zzlg.ordinal()]) {
            case 1:
                int zzb2 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Boolean.valueOf(zzgo.zzb != 0);
                return zzb2;
            case 2:
                return zzgl.zze(bArr, i, zzgo);
            case 3:
                zzgo.zzc = Double.valueOf(zzgl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzgo.zzc = Integer.valueOf(zzgl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzgo.zzc = Long.valueOf(zzgl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzgo.zzc = Float.valueOf(zzgl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzgl.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzgo.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzgo.zzb);
                return zzb3;
            case 14:
                return zzgl.zza(zzjx.zza().zza((Class) cls), bArr, i, i2, zzgo);
            case 15:
                int zza3 = zzgl.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzhb.zze(zzgo.zza));
                return zza3;
            case 16:
                int zzb4 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzhb.zza(zzgo.zzb));
                return zzb4;
            case 17:
                return zzgl.zzd(bArr, i, zzgo);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzgo r30) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzgo zzgo) throws IOException {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object zze2 = this.zzs.zze(zzb2);
            this.zzs.zza(zze2, object);
            unsafe.putObject(t, j, zze2);
            object = zze2;
        }
        zzja<?, ?> zzf2 = this.zzs.zzf(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzgl.zza(bArr, i, zzgo);
        int i4 = zzgo.zza;
        if (i4 < 0 || i4 > i2 - zza3) {
            throw zzij.zza();
        }
        int i5 = i4 + zza3;
        FileTreeWalk.FileTreeWalkIterator.SingleFileState singleFileState = (K) zzf2.zzb;
        FileTreeWalk.FileTreeWalkIterator.SingleFileState singleFileState2 = (V) zzf2.zzd;
        while (zza3 < i5) {
            int i6 = zza3 + 1;
            byte b = bArr[zza3];
            int i7 = b;
            if (b < 0) {
                i6 = zzgl.zza(b, bArr, i6, zzgo);
                i7 = zzgo.zza;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzf2.zzc.zzb()) {
                    zza3 = zza(bArr, i6, i2, zzf2.zzc, zzf2.zzd.getClass(), zzgo);
                    singleFileState2 = (V) zzgo.zzc;
                }
            } else if (i9 == zzf2.zza.zzb()) {
                zza3 = zza(bArr, i6, i2, zzf2.zza, (Class<?>) null, zzgo);
                singleFileState = (K) zzgo.zzc;
            }
            zza3 = zzgl.zza(i7, bArr, i6, i2, zzgo);
        }
        if (zza3 == i5) {
            zza2.put(singleFileState, singleFileState2);
            return i5;
        }
        throw zzij.zzg();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgo zzgo) throws IOException {
        int i9;
        Unsafe unsafe = zzb;
        long j2 = (long) (this.zzc[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzgl.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzgl.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzgo.zzb));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzgl.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzgo.zza));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgl.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgl.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgo.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzgl.zza(bArr, i, zzgo);
                    int i10 = zzgo.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzlb.zza(bArr, zza2, zza2 + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza2, i10, zzia.zza));
                        zza2 += i10;
                    } else {
                        throw zzij.zzh();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzgl.zza(zza(i8), bArr, i, i2, zzgo);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzgl.zze(bArr, i, zzgo);
                    unsafe.putObject(t, j, zzgo.zzc);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzgl.zza(bArr, i, zzgo);
                    int i11 = zzgo.zza;
                    zzif zzc2 = zzc(i8);
                    if (zzc2 == null || zzc2.zza(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza4;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zze(t).zza(i3, Long.valueOf((long) i11));
                    return zza4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzgl.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzhb.zze(zzgo.zza)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzhb.zza(zzgo.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzgl.zza(zza(i8), bArr, i, i2, (i3 & -8) | 4, zzgo);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object2, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzkb zza(int i) {
        int i2 = (i / 3) << 1;
        zzkb zzkb = (zzkb) this.zzd[i2];
        if (zzkb != null) {
            return zzkb;
        }
        zzkb<T> zza2 = zzjx.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03bb, code lost:
        if (r0 == r3) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03fe, code lost:
        if (r0 == r15) goto L_0x0424;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgo r33) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02dc, code lost:
        if (r0 == r4) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0323, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzgo r35) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 966
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzkz.zzf(t, zzd2);
            if (zzf2 != null) {
                zzkz.zza(t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkt<UT, UB> zzkt) {
        zzif zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzkz.zzf(obj, (long) (zzd(i) & 1048575));
        return (zzf2 == null || (zzc2 = zzc(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzs.zza(zzf2), zzc2, ub, zzkt);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzif, UB ub, zzkt<UT, UB> zzkt) {
        zzja<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzif.zza(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzkt.zza();
                }
                zzgx zzc2 = zzgp.zzc(zzjb.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkt.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzkb] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzkb] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(T r19) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzd(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzkb */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkb zzkb) {
        return zzkb.zzd(zzkz.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzlm zzlm) throws IOException {
        if (obj instanceof String) {
            zzlm.zza(i, (String) obj);
        } else {
            zzlm.zza(i, (zzgp) obj);
        }
    }

    private final void zza(Object obj, int i, zzjy zzjy) throws IOException {
        if (zzf(i)) {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzm());
        } else if (this.zzi) {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzl());
        } else {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzkz.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzkz.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzkz.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzkz.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkz.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzkz.zze(t, j2) != 0.0d;
                case 1:
                    return zzkz.zzd(t, j2) != 0.0f;
                case 2:
                    return zzkz.zzb(t, j2) != 0;
                case 3:
                    return zzkz.zzb(t, j2) != 0;
                case 4:
                    return zzkz.zza(t, j2) != 0;
                case 5:
                    return zzkz.zzb(t, j2) != 0;
                case 6:
                    return zzkz.zza(t, j2) != 0;
                case 7:
                    return zzkz.zzc(t, j2);
                case 8:
                    Object zzf2 = zzkz.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgp) {
                        return !zzgp.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzkz.zzf(t, j2) != null;
                case 10:
                    return !zzgp.zza.equals(zzkz.zzf(t, j2));
                case 11:
                    return zzkz.zza(t, j2) != 0;
                case 12:
                    return zzkz.zza(t, j2) != 0;
                case 13:
                    return zzkz.zza(t, j2) != 0;
                case 14:
                    return zzkz.zzb(t, j2) != 0;
                case 15:
                    return zzkz.zza(t, j2) != 0;
                case 16:
                    return zzkz.zzb(t, j2) != 0;
                case 17:
                    return zzkz.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzkz.zza(t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzkz.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzkz.zza(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkz.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzkz.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
