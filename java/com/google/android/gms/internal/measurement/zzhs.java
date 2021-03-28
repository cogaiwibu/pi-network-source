package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum zzhs {
    DOUBLE(0, zzhu.SCALAR, zzil.DOUBLE),
    FLOAT(1, zzhu.SCALAR, zzil.FLOAT),
    INT64(2, zzhu.SCALAR, zzil.LONG),
    UINT64(3, zzhu.SCALAR, zzil.LONG),
    INT32(4, zzhu.SCALAR, zzil.INT),
    FIXED64(5, zzhu.SCALAR, zzil.LONG),
    FIXED32(6, zzhu.SCALAR, zzil.INT),
    BOOL(7, zzhu.SCALAR, zzil.BOOLEAN),
    STRING(8, zzhu.SCALAR, zzil.STRING),
    MESSAGE(9, zzhu.SCALAR, zzil.MESSAGE),
    BYTES(10, zzhu.SCALAR, zzil.BYTE_STRING),
    UINT32(11, zzhu.SCALAR, zzil.INT),
    ENUM(12, zzhu.SCALAR, zzil.ENUM),
    SFIXED32(13, zzhu.SCALAR, zzil.INT),
    SFIXED64(14, zzhu.SCALAR, zzil.LONG),
    SINT32(15, zzhu.SCALAR, zzil.INT),
    SINT64(16, zzhu.SCALAR, zzil.LONG),
    GROUP(17, zzhu.SCALAR, zzil.MESSAGE),
    DOUBLE_LIST(18, zzhu.VECTOR, zzil.DOUBLE),
    FLOAT_LIST(19, zzhu.VECTOR, zzil.FLOAT),
    INT64_LIST(20, zzhu.VECTOR, zzil.LONG),
    UINT64_LIST(21, zzhu.VECTOR, zzil.LONG),
    INT32_LIST(22, zzhu.VECTOR, zzil.INT),
    FIXED64_LIST(23, zzhu.VECTOR, zzil.LONG),
    FIXED32_LIST(24, zzhu.VECTOR, zzil.INT),
    BOOL_LIST(25, zzhu.VECTOR, zzil.BOOLEAN),
    STRING_LIST(26, zzhu.VECTOR, zzil.STRING),
    MESSAGE_LIST(27, zzhu.VECTOR, zzil.MESSAGE),
    BYTES_LIST(28, zzhu.VECTOR, zzil.BYTE_STRING),
    UINT32_LIST(29, zzhu.VECTOR, zzil.INT),
    ENUM_LIST(30, zzhu.VECTOR, zzil.ENUM),
    SFIXED32_LIST(31, zzhu.VECTOR, zzil.INT),
    SFIXED64_LIST(32, zzhu.VECTOR, zzil.LONG),
    SINT32_LIST(33, zzhu.VECTOR, zzil.INT),
    SINT64_LIST(34, zzhu.VECTOR, zzil.LONG),
    DOUBLE_LIST_PACKED(35, zzhu.PACKED_VECTOR, zzil.DOUBLE),
    FLOAT_LIST_PACKED(36, zzhu.PACKED_VECTOR, zzil.FLOAT),
    INT64_LIST_PACKED(37, zzhu.PACKED_VECTOR, zzil.LONG),
    UINT64_LIST_PACKED(38, zzhu.PACKED_VECTOR, zzil.LONG),
    INT32_LIST_PACKED(39, zzhu.PACKED_VECTOR, zzil.INT),
    FIXED64_LIST_PACKED(40, zzhu.PACKED_VECTOR, zzil.LONG),
    FIXED32_LIST_PACKED(41, zzhu.PACKED_VECTOR, zzil.INT),
    BOOL_LIST_PACKED(42, zzhu.PACKED_VECTOR, zzil.BOOLEAN),
    UINT32_LIST_PACKED(43, zzhu.PACKED_VECTOR, zzil.INT),
    ENUM_LIST_PACKED(44, zzhu.PACKED_VECTOR, zzil.ENUM),
    SFIXED32_LIST_PACKED(45, zzhu.PACKED_VECTOR, zzil.INT),
    SFIXED64_LIST_PACKED(46, zzhu.PACKED_VECTOR, zzil.LONG),
    SINT32_LIST_PACKED(47, zzhu.PACKED_VECTOR, zzil.INT),
    SINT64_LIST_PACKED(48, zzhu.PACKED_VECTOR, zzil.LONG),
    GROUP_LIST(49, zzhu.VECTOR, zzil.MESSAGE),
    MAP(50, zzhu.MAP, zzil.VOID);
    
    private static final zzhs[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzil zzaz;
    private final int zzba;
    private final zzhu zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    private zzhs(int i, zzhu zzhu, zzil zzil) {
        int i2;
        this.zzba = i;
        this.zzbb = zzhu;
        this.zzaz = zzil;
        int i3 = zzhv.zza[zzhu.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzbc = zzil.zza();
        } else if (i3 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = zzil.zza();
        }
        this.zzbd = (zzhu != zzhu.SCALAR || (i2 = zzhv.zzb[zzil.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        zzhs[] values = values();
        zzbe = new zzhs[values.length];
        for (zzhs zzhs : values) {
            zzbe[zzhs.zzba] = zzhs;
        }
    }
}
