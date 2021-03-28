package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.E9;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05;
    public static final Parcelable.Creator<GeobFrame> CREATOR = new E9();
    public final String A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A05;
            if (strArr[3].charAt(14) != strArr[4].charAt(14)) {
                String[] strArr2 = A05;
                strArr2[3] = "S35uTAl8blKCIA6RDoKwUWKuPnlgGmXm";
                strArr2[4] = "SsAAbyTQ3GSJA95JV1WqS3o9zGFFtLED";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 18);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A04 = new byte[]{111, 99, 39, 38, 48, 32, 49, 42, 51, 55, 42, 44, 45, 126, 118, 122, 60, 51, 54, 63, 52, 59, 55, 63, 103, 41, 51, 126, 122, 126, 118, 71, 106, 99, 118, 46, 104, 106, 96, 109};
    }

    public static void A02() {
        A05 = new String[]{"p5UgAckTjmiGwIEIp83kIoPYrYx51Hw3", "97Kf", "57iypjQefLkAX1Pf2WMG90QuGpxdZgI9", "MH86n39kjy3It9ArXMcOY1qRtEydqyVj", "czNdDpNwjYz3LUV8hemm9Bag6a1DUht2", "5z2r5SqfWorFCf0GfnerHo5X3AOsS9gQ", "7Yq0Z", "aSTQxqZrOCwJPjy2PBAUJaSPZ7cz8UJW"};
    }

    static {
        A02();
        A01();
    }

    public GeobFrame(Parcel parcel) {
        super(A00(36, 4, 61));
        this.A02 = parcel.readString();
        this.A01 = parcel.readString();
        this.A00 = parcel.readString();
        this.A03 = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(A00(36, 4, 61));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A03 = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (com.facebook.ads.redexgen.X.C0466Ig.A0h(r5.A02, r6.A02) != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008a, code lost:
        if (com.facebook.ads.redexgen.X.C0466Ig.A0h(r5.A02, r6.A02) != false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int result;
        int i = 17 * 31;
        String str = this.A02;
        int i2 = 0;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        int i3 = (i + result) * 31;
        String str2 = this.A01;
        int hashCode = i3 + (str2 != null ? str2.hashCode() : 0);
        if (A05[1].length() != 4) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "5eDn8afHXDuGLumtwhVuBGsgGShhwGUa";
        strArr[4] = "hfSsrwL4qnCDd3h6Kdz3LdbJUMkhTjAD";
        int i4 = hashCode * 31;
        String str3 = this.A00;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((i4 + i2) * 31) + Arrays.hashCode(this.A03);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(25, 11, 1) + this.A02 + A00(14, 11, 72) + this.A01 + A00(0, 14, 81) + this.A00;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
