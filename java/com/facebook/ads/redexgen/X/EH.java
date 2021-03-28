package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceInsertCommand;

public class EH implements Parcelable.Creator<SpliceInsertCommand> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final SpliceInsertCommand createFromParcel(Parcel parcel) {
        return new SpliceInsertCommand(parcel, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final SpliceInsertCommand[] newArray(int i) {
        return new SpliceInsertCommand[i];
    }
}
