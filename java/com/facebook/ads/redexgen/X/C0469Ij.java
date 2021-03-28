package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;

/* renamed from: com.facebook.ads.redexgen.X.Ij  reason: case insensitive filesystem */
public class C0469Ij implements Parcelable.Creator<ColorInfo> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final ColorInfo createFromParcel(Parcel parcel) {
        return new ColorInfo(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final ColorInfo[] newArray(int i) {
        return new ColorInfo[0];
    }
}
