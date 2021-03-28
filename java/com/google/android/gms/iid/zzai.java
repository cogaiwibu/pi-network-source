package com.google.android.gms.iid;

public abstract class zzai {
    private static zzai zzdd;

    public abstract zzaj<Boolean> zzd(String str, boolean z);

    public static synchronized zzai zzy() {
        zzai zzai;
        synchronized (zzai.class) {
            if (zzdd == null) {
                zzdd = new zzac();
            }
            zzai = zzdd;
        }
        return zzai;
    }
}
