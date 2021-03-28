package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.zzq;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzg extends zzq {
    private final zzq.zzb zza;
    private final zza zzb;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza extends zzq.zza {
        private zzq.zzb zza;
        private zza zzb;

        zza() {
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zza(zzq.zzb zzb2) {
            this.zza = zzb2;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq.zza zza(zza zza2) {
            this.zzb = zza2;
            return this;
        }

        @Override // com.google.android.datatransport.cct.a.zzq.zza
        public zzq zza() {
            return new zzg(this.zza, this.zzb, null);
        }
    }

    /* synthetic */ zzg(zzq.zzb zzb2, zza zza2, zzf zzf) {
        this.zza = zzb2;
        this.zzb = zza2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq.zzb zzb2 = this.zza;
        if (zzb2 != null ? zzb2.equals(((zzg) obj).zza) : ((zzg) obj).zza == null) {
            zza zza2 = this.zzb;
            if (zza2 == null) {
                if (((zzg) obj).zzb == null) {
                    return true;
                }
            } else if (zza2.equals(((zzg) obj).zzb)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        zzq.zzb zzb2 = this.zza;
        int i = 0;
        int hashCode = ((zzb2 == null ? 0 : zzb2.hashCode()) ^ 1000003) * 1000003;
        zza zza2 = this.zzb;
        if (zza2 != null) {
            i = zza2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.zza + ", androidClientInfo=" + this.zzb + "}";
    }

    public zza zzb() {
        return this.zzb;
    }

    public zzq.zzb zzc() {
        return this.zza;
    }
}
