package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum zzln {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzgp.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzln(Object obj) {
        this.zzj = obj;
    }
}
