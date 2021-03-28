package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.Format;

public class AF implements Parcelable.Creator<Format> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final Format createFromParcel(Parcel parcel) {
        return new Format(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final Format[] newArray(int i) {
        return new Format[i];
    }
}
