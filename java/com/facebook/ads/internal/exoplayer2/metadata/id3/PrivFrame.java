package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.ED;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static byte[] A02;
    public static final Parcelable.Creator<PrivFrame> CREATOR = new ED();
    public final String A00;
    public final byte[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{61, 39, 104, 112, 105, 98, 117, 58, 114, 112, 107, 116};
    }

    static {
        A01();
    }

    public PrivFrame(Parcel parcel) {
        super(A00(8, 4, 97));
        this.A00 = parcel.readString();
        this.A01 = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super(A00(8, 4, 97));
        this.A00 = str;
        this.A01 = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        if (!C0466Ig.A0h(this.A00, privFrame.A00) || !Arrays.equals(this.A01, privFrame.A01)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = 17 * 31;
        String str = this.A00;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return ((i2 + i) * 31) + Arrays.hashCode(this.A01);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 68) + this.A00;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A01);
    }
}
