package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.SpliceScheduleCommand;

public class EK implements Parcelable.Creator<SpliceScheduleCommand> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final SpliceScheduleCommand createFromParcel(Parcel parcel) {
        return new SpliceScheduleCommand(parcel, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final SpliceScheduleCommand[] newArray(int i) {
        return new SpliceScheduleCommand[i];
    }
}
