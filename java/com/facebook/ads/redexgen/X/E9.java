package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame;

public class E9 implements Parcelable.Creator<GeobFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final GeobFrame createFromParcel(Parcel parcel) {
        return new GeobFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final GeobFrame[] newArray(int i) {
        return new GeobFrame[i];
    }
}
