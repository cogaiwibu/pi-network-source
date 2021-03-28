package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.EE;
import java.util.Arrays;

public final class TextInformationFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03;
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new EE();
    public final String A00;
    public final String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-66, -92, -6, -27, -16, -7, -23, -63};
    }

    public static void A02() {
        A03 = new String[]{"MWTcxeBG8bsFouaAzduEAAsFnNrCbH4S", "TMvfMv7bLasDA2p", "2F4JtsaJlxza1f1R5FT2E7jLDARFY2", "kZ1nXe", "K0", "Nhv", "FupI2YzCY2CNTP", "xd9z0ZjxleShvjlpQTWKxehcTRh34hYU"};
    }

    static {
        A02();
        A01();
    }

    public TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.readString();
        this.A01 = parcel.readString();
    }

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.A00 = str2;
        this.A01 = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (super.A00.equals(((Id3Frame) textInformationFrame).A00)) {
            boolean A0h = C0466Ig.A0h(this.A00, textInformationFrame.A00);
            String[] strArr = A03;
            if (strArr[6].length() != strArr[5].length()) {
                String[] strArr2 = A03;
                strArr2[0] = "NUyLGY6c98DzuB2hwNhLwgueoQfkovra";
                strArr2[7] = "68BFtnvNUVid3aPwudNpvIsh4Gz74lHo";
                if (!A0h || !C0466Ig.A0h(this.A01, textInformationFrame.A01)) {
                    return false;
                }
                return true;
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        int result;
        int hashCode = ((17 * 31) + super.A00.hashCode()) * 31;
        String str = this.A00;
        int i = 0;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        int i2 = (hashCode + result) * 31;
        String str2 = this.A01;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 95) + this.A01;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
