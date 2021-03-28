package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.ApicFrame;

public class E4 implements Parcelable.Creator<ApicFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final ApicFrame createFromParcel(Parcel parcel) {
        return new ApicFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final ApicFrame[] newArray(int i) {
        return new ApicFrame[i];
    }
}
