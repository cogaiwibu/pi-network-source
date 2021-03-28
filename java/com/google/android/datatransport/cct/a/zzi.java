package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.zzt;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzi extends zzt {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final byte[] zzd;
    private final String zze;
    private final long zzf;
    private final zzy zzg;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza extends zzt.zza {
        private Long zza;
        private Integer zzb;
        private Long zzc;
        private byte[] zzd;
        private String zze;
        private Long zzf;
        private zzy zzg;

        zza() {
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(long j) {
            this.zza = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zzb(long j) {
            this.zzc = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zzc(long j) {
            this.zzf = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(int i) {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(String str) {
            this.zze = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt.zza zza(zzy zzy) {
            this.zzg = zzy;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzt.zza
        public zzt zza() {
            String str = "";
            if (this.zza == null) {
                str = str + " eventTimeMs";
            }
            if (this.zzb == null) {
                str = str + " eventCode";
            }
            if (this.zzc == null) {
                str = str + " eventUptimeMs";
            }
            if (this.zzf == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new zzi(this.zza.longValue(), this.zzb.intValue(), this.zzc.longValue(), this.zzd, this.zze, this.zzf.longValue(), this.zzg, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ zzi(long j, int i, long j2, byte[] bArr, String str, long j3, zzy zzy, zzh zzh) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = j3;
        this.zzg = zzy;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        if (this.zza == zzt.zza()) {
            zzi zzi = (zzi) zzt;
            if (this.zzb == zzi.zzb && this.zzc == zzt.zzb()) {
                byte[] bArr2 = this.zzd;
                if (zzt instanceof zzi) {
                    bArr = zzi.zzd;
                } else {
                    bArr = zzi.zzd;
                }
                if (Arrays.equals(bArr2, bArr) && ((str = this.zze) != null ? str.equals(zzi.zze) : zzi.zze == null) && this.zzf == zzt.zzc()) {
                    zzy zzy = this.zzg;
                    if (zzy == null) {
                        if (zzi.zzg == null) {
                            return true;
                        }
                    } else if (zzy.equals(zzi.zzg)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.zza;
        long j2 = this.zzc;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.zzd)) * 1000003;
        String str = this.zze;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.zzf;
        int i2 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        zzy zzy = this.zzg;
        if (zzy != null) {
            i = zzy.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.zza + ", eventCode=" + this.zzb + ", eventUptimeMs=" + this.zzc + ", sourceExtension=" + Arrays.toString(this.zzd) + ", sourceExtensionJsonProto3=" + this.zze + ", timezoneOffsetSeconds=" + this.zzf + ", networkConnectionInfo=" + this.zzg + "}";
    }

    @Override // com.google.android.datatransport.cct.a.zzt
    public long zza() {
        return this.zza;
    }

    @Override // com.google.android.datatransport.cct.a.zzt
    public long zzb() {
        return this.zzc;
    }

    @Override // com.google.android.datatransport.cct.a.zzt
    public long zzc() {
        return this.zzf;
    }

    public int zzd() {
        return this.zzb;
    }

    public zzy zze() {
        return this.zzg;
    }

    public byte[] zzf() {
        return this.zzd;
    }

    public String zzg() {
        return this.zze;
    }
}
