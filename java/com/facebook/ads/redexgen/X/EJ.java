package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceNullCommand;

public class EJ implements Parcelable.Creator<SpliceNullCommand> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final SpliceNullCommand createFromParcel(Parcel parcel) {
        return new SpliceNullCommand();
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final SpliceNullCommand[] newArray(int i) {
        return new SpliceNullCommand[i];
    }
}
