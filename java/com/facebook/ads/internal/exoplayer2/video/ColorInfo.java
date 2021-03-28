package com.facebook.ads.internal.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.C0469Ij;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static byte[] A05;
    public static String[] A06;
    public static final Parcelable.Creator<ColorInfo> CREATOR = new C0469Ij();
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final byte[] A04;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-19, -85, -97, -55, -11, -14, -11, -8, -49, -12, -20, -11, -82};
    }

    public static void A02() {
        A06 = new String[]{"6LTz9E6PxNfd1yjVzhLMG0AXlGrFvd", "g4oD2HABgBZNxOm6v94TNRvCSL0", "Vcg4Rp1WFN", "DVXRmMGrt1", "CXzkEdDffw1S8MeEFGiMAFtRu6laAL", "C2PmqNQsuvwNZm6ufAYvQIJ68xM", "hxkONq5gQMazKGo5XTqLdtQMAy1", "IxpIeux1pqqvYV2IkWO9Ty5AWVWd3KZY"};
    }

    static {
        A02();
        A01();
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.A02 = i;
        this.A01 = i2;
        this.A03 = i3;
        this.A04 = bArr;
    }

    public ColorInfo(Parcel parcel) {
        byte[] bArr;
        this.A02 = parcel.readInt();
        this.A01 = parcel.readInt();
        this.A03 = parcel.readInt();
        if (C0466Ig.A0g(parcel)) {
            bArr = parcel.createByteArray();
        } else {
            bArr = null;
        }
        this.A04 = bArr;
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
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.A02 == colorInfo.A02 && this.A01 == colorInfo.A01 && this.A03 == colorInfo.A03) {
            byte[] bArr = this.A04;
            String[] strArr = A06;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[1] = "FPoJHmu1eurYwt6YbGPDUgJDuI3";
            strArr2[5] = "AP5HTcZviEI7eYuKg0K8Yz9GEp4";
            if (Arrays.equals(bArr, colorInfo.A04)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (((((((17 * 31) + this.A02) * 31) + this.A01) * 31) + this.A03) * 31) + Arrays.hashCode(this.A04);
        }
        return this.A00;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A00(3, 10, 8));
        sb.append(this.A02);
        String A002 = A00(1, 2, 1);
        sb.append(A002);
        sb.append(this.A01);
        sb.append(A002);
        sb.append(this.A03);
        sb.append(A002);
        sb.append(this.A04 != null);
        if (A06[6].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "NW0FnN3qftTBh10nmNEpEmdxvFyLQE2D";
        strArr[7] = "NW0FnN3qftTBh10nmNEpEmdxvFyLQE2D";
        sb.append(A00(0, 1, 70));
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        boolean z;
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A01);
        parcel.writeInt(this.A03);
        if (this.A04 != null) {
            z = true;
        } else {
            z = false;
        }
        C0466Ig.A0W(parcel, z);
        byte[] bArr = this.A04;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
