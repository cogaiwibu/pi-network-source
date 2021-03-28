package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzac {
    public static final zzac zza = new zzac(null, null);
    private final Boolean zzb;
    private final Boolean zzc;

    public zzac(Boolean bool, Boolean bool2) {
        this.zzb = bool;
        this.zzc = bool2;
    }

    public static boolean zza(int i, int i2) {
        return i <= i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzac)) {
            return false;
        }
        zzac zzac = (zzac) obj;
        if (zza(this.zzb) == zza(zzac.zzb) && zza(this.zzc) == zza(zzac.zzc)) {
            return true;
        }
        return false;
    }

    private static int zza(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    public final int hashCode() {
        return ((zza(this.zzb) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + zza(this.zzc);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ConsentSettings: ");
        sb.append("adStorage=");
        Boolean bool = this.zzb;
        String str2 = "granted";
        if (bool == null) {
            sb.append("uninitialized");
        } else {
            if (bool.booleanValue()) {
                str = str2;
            } else {
                str = "denied";
            }
            sb.append(str);
        }
        sb.append(", analyticsStorage=");
        Boolean bool2 = this.zzc;
        if (bool2 == null) {
            sb.append("uninitialized");
        } else {
            if (!bool2.booleanValue()) {
                str2 = "denied";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String zza(Bundle bundle) {
        String string = bundle.getString("ad_storage");
        if (string != null && zzb(string) == null) {
            return string;
        }
        String string2 = bundle.getString("analytics_storage");
        if (string2 == null || zzb(string2) != null) {
            return null;
        }
        return string2;
    }

    public static zzac zzb(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        return new zzac(zzb(bundle.getString("ad_storage")), zzb(bundle.getString("analytics_storage")));
    }

    public static zzac zza(String str) {
        Boolean bool;
        Boolean bool2 = null;
        if (str != null) {
            Boolean zza2 = str.length() >= 3 ? zza(str.charAt(2)) : null;
            if (str.length() >= 4) {
                bool2 = zza(str.charAt(3));
            }
            bool = bool2;
            bool2 = zza2;
        } else {
            bool = null;
        }
        return new zzac(bool2, bool);
    }

    private static Boolean zzb(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static Boolean zza(char c) {
        if (c == '0') {
            return Boolean.FALSE;
        }
        if (c != '1') {
            return null;
        }
        return Boolean.TRUE;
    }

    private static char zzb(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    public final String zza() {
        return "G1" + zzb(this.zzb) + zzb(this.zzc);
    }

    public final Boolean zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        Boolean bool = this.zzb;
        return bool == null || bool.booleanValue();
    }

    public final Boolean zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        Boolean bool = this.zzc;
        return bool == null || bool.booleanValue();
    }

    public final boolean zza(zzac zzac) {
        if (this.zzb != Boolean.FALSE || zzac.zzb == Boolean.FALSE) {
            return this.zzc == Boolean.FALSE && zzac.zzc != Boolean.FALSE;
        }
        return true;
    }

    private static Boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null) {
            return bool2;
        }
        if (bool2 == null) {
            return bool;
        }
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public final zzac zzb(zzac zzac) {
        return new zzac(zza(this.zzb, zzac.zzb), zza(this.zzc, zzac.zzc));
    }

    public final zzac zzc(zzac zzac) {
        Boolean bool = this.zzb;
        if (bool == null) {
            bool = zzac.zzb;
        }
        Boolean bool2 = this.zzc;
        if (bool2 == null) {
            bool2 = zzac.zzc;
        }
        return new zzac(bool, bool2);
    }
}
