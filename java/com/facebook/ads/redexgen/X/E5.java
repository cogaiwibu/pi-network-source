package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.BinaryFrame;

public class E5 implements Parcelable.Creator<BinaryFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final BinaryFrame createFromParcel(Parcel parcel) {
        return new BinaryFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final BinaryFrame[] newArray(int i) {
        return new BinaryFrame[i];
    }
}
