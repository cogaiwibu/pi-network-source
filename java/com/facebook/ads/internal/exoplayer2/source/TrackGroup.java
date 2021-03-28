package com.facebook.ads.internal.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.redexgen.X.C0395Fl;
import com.facebook.ads.redexgen.X.I1;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static String[] A03;
    public static final Parcelable.Creator<TrackGroup> CREATOR = new C0395Fl();
    public int A00;
    public final int A01;
    public final Format[] A02;

    public static void A00() {
        A03 = new String[]{"uF1MaBjHqfaou024Qot33eYqIFU5JpvL", "e11WN2XHHVFyFb3tGbHyOnuTBXVrxID3", "sRFhiACxeNyk2ofGCUEzfsyXhtnOr6n1", "WOmDa", "B4eB5pbJ0Ea0X4wV3enRun3SeiDmty6A", "wkOrnjHBm7RpnZhD1xCNjmxcOEtiASyA", "Mmr4xD9J4DRMn7KtjO4WF7k", "AppkpJNXRVMekBVT0dKI7wy"};
    }

    static {
        A00();
    }

    public TrackGroup(Parcel parcel) {
        this.A01 = parcel.readInt();
        this.A02 = new Format[this.A01];
        for (int i = 0; i < this.A01; i++) {
            this.A02[i] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format... formatArr) {
        boolean z;
        if (formatArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A02 = formatArr;
        this.A01 = formatArr.length;
    }

    public final int A01(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.A02;
            if (i >= formatArr.length) {
                return -1;
            }
            Format format2 = formatArr[i];
            String[] strArr = A03;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[3] = "gOIjn";
            strArr2[3] = "gOIjn";
            if (format == format2) {
                return i;
            }
            i++;
        }
    }

    public final Format A02(int i) {
        return this.A02[i];
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.A01 != trackGroup.A01 || !Arrays.equals(this.A02, trackGroup.A02)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        return this.A00;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A01);
        for (int i2 = 0; i2 < this.A01; i2++) {
            parcel.writeParcelable(this.A02[i2], 0);
        }
    }
}
