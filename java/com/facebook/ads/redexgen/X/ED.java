package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.PrivFrame;

public class ED implements Parcelable.Creator<PrivFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final PrivFrame createFromParcel(Parcel parcel) {
        return new PrivFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final PrivFrame[] newArray(int i) {
        return new PrivFrame[i];
    }
}
