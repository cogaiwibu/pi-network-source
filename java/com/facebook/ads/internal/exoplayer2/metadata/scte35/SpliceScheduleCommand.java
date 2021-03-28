package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.EK;
import com.facebook.ads.redexgen.X.EM;
import com.facebook.ads.redexgen.X.IQ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static String[] A01;
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new EK();
    public final List<EM> A00;

    public static void A01() {
        A01 = new String[]{"it7lS", "DDMagQqfA6bdQNmcbGVHnHFBEyEyV1CV", "yj1Kd0vDyL1u2mFRENQtUt5M23mLahBX", "Jtl9O", "DzPPQsDVYOU8bWKOfUnj4CDUSnJ2WnBZ", "jfx4iKnVrCrKgyd9K0RyokJ5bMLL728G", "aEdAaZwrqc10hFo35SyTbuIH90C1HKve", "av2CnTBgmmUyqozc6FxJU9F0Qf7BUN36"};
    }

    static {
        A01();
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(EM.A00(parcel));
        }
        this.A00 = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, EK ek) {
        this(parcel);
    }

    public SpliceScheduleCommand(List<EM> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand A00(IQ iq) {
        int A0F = iq.A0F();
        ArrayList arrayList = new ArrayList(A0F);
        for (int i = 0; i < A0F; i++) {
            arrayList.add(EM.A02(iq));
            if (A01[1].charAt(15) != 'W') {
                String[] strArr = A01;
                strArr[6] = "d2FIwqylvh7iXAJnxNkaidieKhP3pOaB";
                strArr[4] = "dE1dCXJBgr8GZeSYP1l3R34BwUsmGXNG";
            } else {
                throw new RuntimeException();
            }
        }
        return new SpliceScheduleCommand(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.A00.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A00.get(i2).A05(parcel);
        }
    }
}
