package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.E4;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05;
    public static final Parcelable.Creator<ApicFrame> CREATOR = new E4();
    public final int A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[3].charAt(9) != 'e') {
                String[] strArr = A05;
                strArr[1] = "U0HzNilLCgOI3RN2jirONDBwHY";
                strArr[4] = "DGon7n5SS5vHntEocZsPIfG7RL";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 44);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A04 = new byte[]{-73, -85, -17, -16, -2, -18, -3, -12, -5, -1, -12, -6, -7, -56, -67, -93, -16, -20, -16, -24, -41, -4, -13, -24, -64, -114, -99, -106, -112};
    }

    public static void A02() {
        A05 = new String[]{"J1px6UpWvF5yPqg1xQyBufR99ivwtdKC", "Y9JbnkXEyPGkGK2Z8ZyREBK03f", "XSRNj5ze725Mvj6bwVRaYHOprv32A", "UGzvR3ks7TcixYdkI8NPeDNLgobFHvbT", "3kwaED3H67kpOZfw65we0P5Sqd", "HfuaWQrkMfczMxrWeVvr20KZWc8dtg7U", "Gbrcmgsvl5BF3EE3vIXQTh85zLs0xykC", "GjzapeJleImj8soccQ15GwwrlKSw59zl"};
    }

    static {
        A02();
        A01();
    }

    public ApicFrame(Parcel parcel) {
        super(A00(25, 4, 33));
        this.A02 = parcel.readString();
        this.A01 = parcel.readString();
        this.A00 = parcel.readInt();
        this.A03 = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(A00(25, 4, 33));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = i;
        this.A03 = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.A00 == apicFrame.A00 && C0466Ig.A0h(this.A02, apicFrame.A02) && C0466Ig.A0h(this.A01, apicFrame.A01)) {
            boolean equals = Arrays.equals(this.A03, apicFrame.A03);
            String[] strArr = A05;
            if (strArr[0].charAt(17) != strArr[7].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[2] = "qGvH2hpjtdCa624xg8WGpvc5hlw62";
            strArr2[2] = "qGvH2hpjtdCa624xg8WGpvc5hlw62";
            if (equals) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result;
        int i = ((17 * 31) + this.A00) * 31;
        String str = this.A02;
        int i2 = 0;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        int i3 = (i + result) * 31;
        String str2 = this.A01;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i3 + i2) * 31) + Arrays.hashCode(this.A03);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(14, 11, 87) + this.A02 + A00(0, 14, 95) + this.A01;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
