package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.ChapterFrame;

public class E6 implements Parcelable.Creator<ChapterFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final ChapterFrame createFromParcel(Parcel parcel) {
        return new ChapterFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final ChapterFrame[] newArray(int i) {
        return new ChapterFrame[i];
    }
}
