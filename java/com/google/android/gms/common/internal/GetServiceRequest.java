package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
    private final int version;
    String zzak;
    private int zzdo;
    private final int zzdp;
    private int zzdq;
    IBinder zzdr;
    Scope[] zzds;
    Bundle zzdt;
    Account zzdu;
    Feature[] zzdv;
    Feature[] zzdw;
    private boolean zzdx;

    public GetServiceRequest(int i) {
        this.version = 4;
        this.zzdq = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzdp = i;
        this.zzdx = true;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4) {
        this.version = i;
        this.zzdp = i2;
        this.zzdq = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzak = "com.google.android.gms";
        } else {
            this.zzak = str;
        }
        if (i < 2) {
            this.zzdu = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzdr = iBinder;
            this.zzdu = account;
        }
        this.zzds = scopeArr;
        this.zzdt = bundle;
        this.zzdv = featureArr;
        this.zzdw = featureArr2;
        this.zzdx = z;
        this.zzdo = i4;
    }

    public Bundle getExtraArgs() {
        return this.zzdt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.version);
        SafeParcelWriter.writeInt(parcel, 2, this.zzdp);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdq);
        SafeParcelWriter.writeString(parcel, 4, this.zzak, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzdr, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzds, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzdt, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdu, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzdv, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzdw, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzdx);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
