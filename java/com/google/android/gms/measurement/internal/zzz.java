package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    public String zza;
    public String zzb;
    public zzku zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public zzaq zzg;
    public long zzh;
    public zzaq zzi;
    public long zzj;
    public zzaq zzk;

    zzz(zzz zzz) {
        Preconditions.checkNotNull(zzz);
        this.zza = zzz.zza;
        this.zzb = zzz.zzb;
        this.zzc = zzz.zzc;
        this.zzd = zzz.zzd;
        this.zze = zzz.zze;
        this.zzf = zzz.zzf;
        this.zzg = zzz.zzg;
        this.zzh = zzz.zzh;
        this.zzi = zzz.zzi;
        this.zzj = zzz.zzj;
        this.zzk = zzz.zzk;
    }

    zzz(String str, String str2, zzku zzku, long j, boolean z, String str3, zzaq zzaq, long j2, zzaq zzaq2, long j3, zzaq zzaq3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzku;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzaq;
        this.zzh = j2;
        this.zzi = zzaq2;
        this.zzj = j3;
        this.zzk = zzaq3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
