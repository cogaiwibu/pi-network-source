package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.EF;
import java.util.Arrays;

public final class UrlLinkFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03;
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new EF();
    public final String A00;
    public final String A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[4].charAt(31) != strArr[5].charAt(31)) {
                String[] strArr2 = A03;
                strArr2[4] = "Ytg7Kx5ciTxcBbuwxTwHBhNcXLsKFS2u";
                strArr2[5] = "TL4yJ8wM2eMbRk1FBnProTEIlflGc1M5";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 45);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A02 = new byte[]{-69, -95, -10, -13, -19, -66};
    }

    public static void A02() {
        A03 = new String[]{"K7RxnzjPeOdkr4E7awDWllYcHNZuI9c0", "lXepHslf415JArxV8sfEK4fqkdDxnDOZ", "zMpWBBAelSFSuaQHvpCFzFuKeG8cwMdZ", "r302VQJ2ie6981RfLfu9NzFVyQSaDacI", "33DyIHcKE7zPO0W2W54S0gt5PvHaUO5u", "58MEWeTNhg8nMGusT37cDOvrm2zs5Mnh", "xx8E8fg6Qtq0yUEy7uiNZyUO49Wldq56", "TSvuC"};
    }

    static {
        A02();
        A01();
    }

    public UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.readString();
        this.A01 = parcel.readString();
    }

    public UrlLinkFrame(String str, String str2, String str3) {
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
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (!super.A00.equals(((Id3Frame) urlLinkFrame).A00) || !C0466Ig.A0h(this.A00, urlLinkFrame.A00) || !C0466Ig.A0h(this.A01, urlLinkFrame.A01)) {
            return false;
        }
        return true;
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
        return super.A00 + A00(0, 6, 84) + this.A01;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
