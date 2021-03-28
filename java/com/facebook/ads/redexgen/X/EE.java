package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.TextInformationFrame;

public class EE implements Parcelable.Creator<TextInformationFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final TextInformationFrame createFromParcel(Parcel parcel) {
        return new TextInformationFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final TextInformationFrame[] newArray(int i) {
        return new TextInformationFrame[i];
    }
}
