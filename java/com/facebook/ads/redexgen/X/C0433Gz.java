package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;

/* renamed from: com.facebook.ads.redexgen.X.Gz  reason: case insensitive filesystem */
public final class C0433Gz implements Comparable<C0433Gz> {
    public static String[] A07;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final DefaultTrackSelector$Parameters A06;

    static {
        A00();
    }

    public static void A00() {
        A07 = new String[]{"UOhnAWHUvWrKh39blc2", "rJoZ4rjs3", "mwxErCj8CFXQtRdeT7I", "OMBsSVN1m", "xKR0iM7hb", "rY23JmNnbt4", "7JhRM9", "FTdecT"};
    }

    public C0433Gz(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i) {
        this.A06 = defaultTrackSelector$Parameters;
        int i2 = 0;
        this.A05 = AR.A0I(i, false) ? 1 : 0;
        this.A03 = AR.A0L(format, defaultTrackSelector$Parameters.A07) ? 1 : 0;
        this.A02 = (format.A0D & 1) != 0 ? 1 : i2;
        this.A01 = format.A05;
        this.A04 = format.A0C;
        this.A00 = format.A04;
    }

    /* renamed from: A01 */
    public final int compareTo(C0433Gz gz) {
        int i = this.A05;
        int i2 = gz.A05;
        if (i != i2) {
            return AR.A02(i, i2);
        }
        int i3 = this.A03;
        int i4 = gz.A03;
        if (i3 != i4) {
            return AR.A02(i3, i4);
        }
        int i5 = this.A02;
        int i6 = gz.A02;
        if (i5 != i6) {
            return AR.A02(i5, i6);
        }
        if (this.A06.A0D) {
            return AR.A02(gz.A00, this.A00);
        }
        int i7 = 1;
        if (this.A05 != 1) {
            i7 = -1;
        }
        int i8 = this.A01;
        int i9 = gz.A01;
        String[] strArr = A07;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "q1nzmC2W0";
        strArr2[3] = "q1nzmC2W0";
        if (i8 != i9) {
            return AR.A02(i8, i9) * i7;
        }
        int i10 = this.A04;
        int i11 = gz.A04;
        if (i10 != i11) {
            return AR.A02(i10, i11) * i7;
        }
        return AR.A02(this.A00, gz.A00) * i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0433Gz gz = (C0433Gz) obj;
        if (this.A05 == gz.A05 && this.A03 == gz.A03 && this.A02 == gz.A02 && this.A01 == gz.A01 && this.A04 == gz.A04) {
            int i = this.A00;
            if (A07[5].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[0] = "5gFFNpUtyAKNtlVcilC";
            strArr[2] = "oFDw9vE2Y7jHYxyqfLD";
            if (i == gz.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.A05 * 31) + this.A03) * 31) + this.A02) * 31) + this.A01) * 31) + this.A04) * 31) + this.A00;
    }
}
