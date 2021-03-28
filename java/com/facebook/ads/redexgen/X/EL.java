package com.facebook.ads.redexgen.X;

import android.os.Parcel;

public final class EL {
    public final int A00;
    public final long A01;

    public EL(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public /* synthetic */ EL(int i, long j, EK ek) {
        this(i, j);
    }

    public static EL A00(Parcel parcel) {
        return new EL(parcel.readInt(), parcel.readLong());
    }

    /* access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
