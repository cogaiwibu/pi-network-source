package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.InternalFrame;

public class EC implements Parcelable.Creator<InternalFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final InternalFrame createFromParcel(Parcel parcel) {
        return new InternalFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final InternalFrame[] newArray(int i) {
        return new InternalFrame[i];
    }
}
