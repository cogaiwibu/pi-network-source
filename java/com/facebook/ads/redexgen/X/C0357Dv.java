package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;

/* renamed from: com.facebook.ads.redexgen.X.Dv  reason: case insensitive filesystem */
public class C0357Dv implements Parcelable.Creator<Metadata> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final Metadata createFromParcel(Parcel parcel) {
        return new Metadata(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final Metadata[] newArray(int i) {
        return new Metadata[0];
    }
}
