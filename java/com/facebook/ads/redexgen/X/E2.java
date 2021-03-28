package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.exoplayer2.metadata.emsg.EventMessage;

public class E2 implements Parcelable.Creator<EventMessage> {
    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final EventMessage createFromParcel(Parcel parcel) {
        return new EventMessage(parcel);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final EventMessage[] newArray(int i) {
        return new EventMessage[i];
    }
}
