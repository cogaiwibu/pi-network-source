package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;

/* renamed from: com.facebook.ads.redexgen.X.By  reason: case insensitive filesystem */
public class C0309By implements Parcelable.Creator<DrmInitData.SchemeData> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final DrmInitData.SchemeData createFromParcel(Parcel parcel) {
        return new DrmInitData.SchemeData(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final DrmInitData.SchemeData[] newArray(int i) {
        return new DrmInitData.SchemeData[i];
    }
}
