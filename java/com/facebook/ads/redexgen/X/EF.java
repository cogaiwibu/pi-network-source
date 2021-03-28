package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.UrlLinkFrame;

public class EF implements Parcelable.Creator<UrlLinkFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final UrlLinkFrame createFromParcel(Parcel parcel) {
        return new UrlLinkFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final UrlLinkFrame[] newArray(int i) {
        return new UrlLinkFrame[i];
    }
}
