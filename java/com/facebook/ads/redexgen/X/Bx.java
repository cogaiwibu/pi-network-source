package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;

public class Bx implements Parcelable.Creator<DrmInitData> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final DrmInitData createFromParcel(Parcel parcel) {
        return new DrmInitData(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final DrmInitData[] newArray(int i) {
        return new DrmInitData[i];
    }
}
