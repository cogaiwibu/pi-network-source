package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzcq extends zzdp {
    private final Context zza;
    private final zzec<zzdy<zzdd>> zzb;

    zzcq(Context context, @Nullable zzec<zzdy<zzdd>> zzec) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzec;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdp
    @Nullable
    public final zzec<zzdy<zzdd>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        zzec<zzdy<zzdd>> zzec;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdp) {
            zzdp zzdp = (zzdp) obj;
            return this.zza.equals(zzdp.zza()) && ((zzec = this.zzb) != null ? zzec.equals(zzdp.zzb()) : zzdp.zzb() == null);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzec<zzdy<zzdd>> zzec = this.zzb;
        return hashCode ^ (zzec == null ? 0 : zzec.hashCode());
    }
}
