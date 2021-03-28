package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.zza;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzd extends zza {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza extends zza.AbstractC0011zza {
        private Integer zza;
        private String zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private String zzg;
        private String zzh;

        zza() {
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zza(int i) {
            this.zza = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zzb(String str) {
            this.zzh = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zzc(String str) {
            this.zzc = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zzd(String str) {
            this.zzg = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zze(String str) {
            this.zzb = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zzf(String str) {
            this.zzf = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zzg(String str) {
            this.zze = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza.AbstractC0011zza zza(String str) {
            this.zzd = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zza.AbstractC0011zza
        public zza zza() {
            String str = "";
            if (this.zza == null) {
                str = str + " sdkVersion";
            }
            if (str.isEmpty()) {
                return new zzd(this.zza.intValue(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ zzd(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, zzc zzc2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = str7;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        zzd zzd2 = (zzd) ((zza) obj);
        if (this.zza == zzd2.zza && ((str = this.zzb) != null ? str.equals(zzd2.zzb) : zzd2.zzb == null) && ((str2 = this.zzc) != null ? str2.equals(zzd2.zzc) : zzd2.zzc == null) && ((str3 = this.zzd) != null ? str3.equals(zzd2.zzd) : zzd2.zzd == null) && ((str4 = this.zze) != null ? str4.equals(zzd2.zze) : zzd2.zze == null) && ((str5 = this.zzf) != null ? str5.equals(zzd2.zzf) : zzd2.zzf == null) && ((str6 = this.zzg) != null ? str6.equals(zzd2.zzg) : zzd2.zzg == null)) {
            String str7 = this.zzh;
            if (str7 == null) {
                if (zzd2.zzh == null) {
                    return true;
                }
            } else if (str7.equals(zzd2.zzh)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.zza ^ 1000003) * 1000003;
        String str = this.zzb;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.zzc;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.zzd;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.zze;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.zzf;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.zzg;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.zzh;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 ^ i2;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.zza + ", model=" + this.zzb + ", hardware=" + this.zzc + ", device=" + this.zzd + ", product=" + this.zze + ", osBuild=" + this.zzf + ", manufacturer=" + this.zzg + ", fingerprint=" + this.zzh + "}";
    }

    public String zzb() {
        return this.zzd;
    }

    public String zzc() {
        return this.zzh;
    }

    public String zzd() {
        return this.zzc;
    }

    public String zze() {
        return this.zzg;
    }

    public String zzf() {
        return this.zzb;
    }

    public String zzg() {
        return this.zzf;
    }

    public String zzh() {
        return this.zze;
    }

    public int zzi() {
        return this.zza;
    }
}
