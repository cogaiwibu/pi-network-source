package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Dk  reason: case insensitive filesystem */
public class C0346Dk extends Exception {
    public static byte[] A04;
    public final String A00;
    public final String A01;
    public final String A02;
    public final boolean A03;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{108, 96, 77, 108, 106, 102, 109, 108, 123, 41, 96, 103, 96, 125, 41, 111, 104, 96, 101, 108, 109, 51, 41, 91, 122, 124, 112, 123, 122, 109, 63, 118, 113, 118, 107, 63, 121, 126, 118, 115, 122, 123, 37, 63, 68, 50, 67, 79, 109, 97, 99, 32, 105, 97, 97, 105, 98, 107, 32, 111, 96, 106, 124, 97, 103, 106, 32, 107, 118, 97, 126, 98, 111, 119, 107, 124, 32, 67, 107, 106, 103, 111, 77, 97, 106, 107, 109, 90, 124, 111, 109, 101, 92, 107, 96, 106, 107, 124, 107, 124, 81, 100, 111, 109, 85};
    }

    public C0346Dk(Format format, Throwable th, boolean z, int i) {
        super(A01(23, 22, 74) + i + A01(45, 3, 58) + format, th);
        this.A02 = format.A0O;
        this.A03 = z;
        this.A00 = null;
        this.A01 = A00(i);
    }

    public C0346Dk(Format format, Throwable th, boolean z, String str) {
        super(A01(2, 21, 92) + str + A01(0, 2, 21) + format, th);
        String str2;
        this.A02 = format.A0O;
        this.A03 = z;
        this.A00 = str;
        if (C0466Ig.A02 >= 21) {
            str2 = A02(th);
        } else {
            str2 = null;
        }
        this.A01 = str2;
    }

    public static String A00(int i) {
        String A012;
        if (i < 0) {
            A012 = A01(101, 4, 95);
        } else {
            A012 = A01(0, 0, 105);
        }
        return A01(48, 53, 91) + A012 + Math.abs(i);
    }

    @TargetApi(21)
    public static String A02(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
