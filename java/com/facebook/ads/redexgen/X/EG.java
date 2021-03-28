package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.scte35.PrivateCommand;

public class EG implements Parcelable.Creator<PrivateCommand> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final PrivateCommand createFromParcel(Parcel parcel) {
        return new PrivateCommand(parcel, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final PrivateCommand[] newArray(int i) {
        return new PrivateCommand[i];
    }
}
