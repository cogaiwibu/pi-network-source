package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;

/* renamed from: com.facebook.ads.redexgen.X.4P  reason: invalid class name */
public class AnonymousClass4P implements Parcelable.ClassLoaderCreator<RecyclerView$SavedState> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final RecyclerView$SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView$SavedState(parcel, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView$SavedState(parcel, classLoader);
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final RecyclerView$SavedState[] newArray(int i) {
        return new RecyclerView$SavedState[i];
    }
}
