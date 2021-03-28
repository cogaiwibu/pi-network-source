package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.id3.CommentFrame;

public class E8 implements Parcelable.Creator<CommentFrame> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final CommentFrame createFromParcel(Parcel parcel) {
        return new CommentFrame(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final CommentFrame[] newArray(int i) {
        return new CommentFrame[i];
    }
}
