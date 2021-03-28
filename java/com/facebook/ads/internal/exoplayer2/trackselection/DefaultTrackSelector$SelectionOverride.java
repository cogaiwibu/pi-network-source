package com.facebook.ads.internal.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.H3;
import java.util.Arrays;

public final class DefaultTrackSelector$SelectionOverride implements Parcelable {
    public static String[] A03;
    public static final Parcelable.Creator<DefaultTrackSelector$SelectionOverride> CREATOR = new H3();
    public final int A00;
    public final int A01;
    public final int[] A02 = new int[this.A01];

    public static void A00() {
        A03 = new String[]{"62zrgE1AyVhL2OprgpABG7xqAbSsB89p", "0bWstYxcHGvZpvpVoegN633tpzW05V6o", "K5ntu9AoknOK681nEb6kBDGoootsVTZa", "J1ali8fWhLhD9U3MVURAA10vPW7kbw5A", "39yYd1UQG2Ds87yjj3zcNOqOMstH4rtR", "HQCWjG2wZBX", "RO8aDAM1voh", "mN3rLaC8OmSJelXP"};
    }

    static {
        A00();
    }

    public DefaultTrackSelector$SelectionOverride(Parcel parcel) {
        this.A00 = parcel.readInt();
        this.A01 = parcel.readByte();
        parcel.readIntArray(this.A02);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        String[] strArr = A03;
        if (strArr[0].charAt(27) != strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[6] = "QZn0RP73rEd";
        strArr2[5] = "RlnWhobh9YU";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride) obj;
        if (this.A00 != defaultTrackSelector$SelectionOverride.A00 || !Arrays.equals(this.A02, defaultTrackSelector$SelectionOverride.A02)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.A00 * 31) + Arrays.hashCode(this.A02);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A02.length);
        parcel.writeIntArray(this.A02);
    }
}
