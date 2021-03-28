package com.facebook.ads.internal.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0396Fn;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static String[] A03;
    public static final TrackGroupArray A04 = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new C0396Fn();
    public int A00;
    public final int A01;
    public final TrackGroup[] A02;

    public static void A00() {
        A03 = new String[]{"VeLcksxMt3PiY9R1rHSQOw59E3uXu3y4", "kDaGCzW6AYC9Vd", "HdQqsudNtb3GwZVdOuSjCK1cvypXuBmO", "TDIIXEFeBXUqvvBrldprlo94jTphz", "vM9bR1K3Ny8GpvAoAGhEbHV75VrlC6x5", "HTKcEQU1qW9AJSOXQnXDctgwMIpv3yeo", "D5FGV12hFTFATb3k1jbs", "Elm4dEdTwW2NF2wr80DoeDRtultkwVxD"};
    }

    static {
        A00();
    }

    public TrackGroupArray(Parcel parcel) {
        this.A01 = parcel.readInt();
        this.A02 = new TrackGroup[this.A01];
        for (int i = 0; i < this.A01; i++) {
            this.A02[i] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.A02 = trackGroupArr;
        this.A01 = trackGroupArr.length;
    }

    public final int A01(TrackGroup trackGroup) {
        for (int i = 0; i < this.A01; i++) {
            if (this.A02[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public final TrackGroup A02(int i) {
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
        if (A03[6].length() != 20) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[0] = "ZPecGmpFZujqBRhyZTNZ1SVkZFgKhO38";
        strArr[5] = "me7cYpsF0CfkBGZ0HsMy9kxuKf6pUD2I";
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        if (this.A01 != trackGroupArray.A01 || !Arrays.equals(this.A02, trackGroupArray.A02)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = Arrays.hashCode(this.A02);
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
