package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.zzv;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzk extends zzv {
    private final long zza;
    private final long zzb;
    private final zzq zzc;
    private final int zzd;
    private final String zze;
    private final List<zzt> zzf;
    private final zzaa zzg;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza extends zzv.zza {
        private Long zza;
        private Long zzb;
        private zzq zzc;
        private Integer zzd;
        private String zze;
        private List<zzt> zzf;
        private zzaa zzg;

        zza() {
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(long j) {
            this.zza = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zzb(long j) {
            this.zzb = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(zzq zzq) {
            this.zzc = zzq;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(int i) {
            this.zzd = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(String str) {
            this.zze = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(List<zzt> list) {
            this.zzf = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv.zza zza(zzaa zzaa) {
            this.zzg = zzaa;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzv.zza
        public zzv zza() {
            String str = "";
            if (this.zza == null) {
                str = str + " requestTimeMs";
            }
            if (this.zzb == null) {
                str = str + " requestUptimeMs";
            }
            if (this.zzd == null) {
                str = str + " logSource";
            }
            if (str.isEmpty()) {
                return new zzk(this.zza.longValue(), this.zzb.longValue(), this.zzc, this.zzd.intValue(), this.zze, this.zzf, this.zzg, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ zzk(long j, long j2, zzq zzq, int i, String str, List list, zzaa zzaa, zzj zzj) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = zzq;
        this.zzd = i;
        this.zze = str;
        this.zzf = list;
        this.zzg = zzaa;
    }

    public boolean equals(Object obj) {
        zzq zzq;
        String str;
        List<zzt> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzv)) {
            return false;
        }
        zzk zzk = (zzk) ((zzv) obj);
        if (this.zza == zzk.zza && this.zzb == zzk.zzb && ((zzq = this.zzc) != null ? zzq.equals(zzk.zzc) : zzk.zzc == null) && this.zzd == zzk.zzd && ((str = this.zze) != null ? str.equals(zzk.zze) : zzk.zze == null) && ((list = this.zzf) != null ? list.equals(zzk.zzf) : zzk.zzf == null)) {
            zzaa zzaa = this.zzg;
            if (zzaa == null) {
                if (zzk.zzg == null) {
                    return true;
                }
            } else if (zzaa.equals(zzk.zzg)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        zzq zzq = this.zzc;
        int i2 = 0;
        int hashCode = (((i ^ (zzq == null ? 0 : zzq.hashCode())) * 1000003) ^ this.zzd) * 1000003;
        String str = this.zze;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<zzt> list = this.zzf;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        zzaa zzaa = this.zzg;
        if (zzaa != null) {
            i2 = zzaa.hashCode();
        }
        return hashCode3 ^ i2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.zza + ", requestUptimeMs=" + this.zzb + ", clientInfo=" + this.zzc + ", logSource=" + this.zzd + ", logSourceName=" + this.zze + ", logEvents=" + this.zzf + ", qosTier=" + this.zzg + "}";
    }

    public zzq zzb() {
        return this.zzc;
    }

    public List<zzt> zzc() {
        return this.zzf;
    }

    public int zzd() {
        return this.zzd;
    }

    public String zze() {
        return this.zze;
    }

    public long zzf() {
        return this.zza;
    }

    public long zzg() {
        return this.zzb;
    }
}
