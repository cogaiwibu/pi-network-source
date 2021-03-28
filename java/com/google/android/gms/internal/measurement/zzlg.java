package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum zzlg {
    DOUBLE(zzln.DOUBLE, 1),
    FLOAT(zzln.FLOAT, 5),
    INT64(zzln.LONG, 0),
    UINT64(zzln.LONG, 0),
    INT32(zzln.INT, 0),
    FIXED64(zzln.LONG, 1),
    FIXED32(zzln.INT, 5),
    BOOL(zzln.BOOLEAN, 0),
    STRING(zzln.STRING, 2) {
    },
    GROUP(zzln.MESSAGE, 3) {
    },
    MESSAGE(zzln.MESSAGE, 2) {
    },
    BYTES(zzln.BYTE_STRING, 2) {
    },
    UINT32(zzln.INT, 0),
    ENUM(zzln.ENUM, 0),
    SFIXED32(zzln.INT, 5),
    SFIXED64(zzln.LONG, 1),
    SINT32(zzln.INT, 0),
    SINT64(zzln.LONG, 0);
    
    private final zzln zzs;
    private final int zzt;

    private zzlg(zzln zzln, int i) {
        this.zzs = zzln;
        this.zzt = i;
    }

    public final zzln zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzlg(zzln zzln, int i, zzlh zzlh) {
        this(zzln, i);
    }
}
