package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.TimeSignalCommand;

public class EN implements Parcelable.Creator<TimeSignalCommand> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final TimeSignalCommand createFromParcel(Parcel parcel) {
        return new TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final TimeSignalCommand[] newArray(int i) {
        return new TimeSignalCommand[i];
    }
}
