package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.C0462Ic;
import com.facebook.ads.redexgen.X.EN;
import com.facebook.ads.redexgen.X.IQ;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new EN();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, EN en) {
        this(j, j2);
    }

    public static long A00(IQ iq, long j) {
        long A0F = (long) iq.A0F();
        if ((128 & A0F) != 0) {
            return ((((1 & A0F) << 32) | iq.A0N()) + j) & 8589934591L;
        }
        return -9223372036854775807L;
    }

    public static TimeSignalCommand A01(IQ iq, long j, C0462Ic ic) {
        long A002 = A00(iq, j);
        return new TimeSignalCommand(A002, ic.A08(A002));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
