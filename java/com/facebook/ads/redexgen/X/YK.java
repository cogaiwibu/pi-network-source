package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
import kotlin.jvm.internal.ByteCompanionObject;

public final class YK extends CY {
    public static byte[] A03;
    public static String[] A04;
    public static final int[] A05 = {5512, 11025, 22050, 44100};
    public int A00;
    public boolean A01;
    public boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{77, 121, 104, 101, 99, 44, 106, 99, 126, 97, 109, 120, 44, 98, 99, 120, 44, ByteCompanionObject.MAX_VALUE, 121, 124, 124, 99, 126, 120, 105, 104, 54, 44, 99, 119, 102, 107, 109, 45, 101, 53, 51, 51, 47, 99, 110, 99, 117, 16, 4, 21, 24, 30, 94, 22, 70, 64, 64, 92, 28, 29, 16, 6, 49, 37, 52, 57, 63, ByteCompanionObject.MAX_VALUE, 61, 32, 100, 49, 125, 60, 49, 36, 61, 38, 50, 35, 46, 40, 104, 42, 55, 34, 32};
    }

    public static void A02() {
        A04 = new String[]{"Es", "iHC9pRtfoWLcycijntiJYXN2", "TuGPNLSlit", "098OJ58R6u", "VNifGSmWt2UpuuC8pFHITdWilQmWPSdD", "nPBEvfeprzzMECJ3xuyevnTK", "FVZwpUplP67oS0xaMKq2ljUJ3jrVNcvU", "q6VKpvb2t6NLzvXLeBGroGgfRiC5SSnv"};
    }

    static {
        A02();
        A01();
    }

    public YK(CW cw) {
        super(cw);
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final void A0C(IQ iq, long j) throws AN {
        if (this.A00 == 2) {
            int A052 = iq.A05();
            super.A00.ACe(iq, A052);
            super.A00.ACf(j, 1, A052, 0, null);
            return;
        }
        int A0F = iq.A0F();
        if (A0F == 0) {
            boolean z = this.A01;
            String[] strArr = A04;
            if (strArr[7].charAt(9) != strArr[6].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "UGwyap6YoK";
            strArr2[3] = "84lnx1SX4s";
            if (!z) {
                byte[] bArr = new byte[iq.A05()];
                iq.A0d(bArr, 0, bArr.length);
                Pair<Integer, Integer> A032 = I5.A03(bArr);
                super.A00.A5A(Format.A07(null, A00(58, 15, 95), null, -1, -1, ((Integer) A032.second).intValue(), ((Integer) A032.first).intValue(), Collections.singletonList(bArr), null, 0, null));
                this.A01 = true;
                return;
            }
        }
        if (this.A00 != 10 || A0F == 1) {
            int A053 = iq.A05();
            super.A00.ACe(iq, A053);
            super.A00.ACf(j, 1, A053, 0, null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0079, code lost:
        if (r6 == 8) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00be, code lost:
        if (r6 == 8) goto L_0x007b;
     */
    @Override // com.facebook.ads.redexgen.X.CY
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A0D(com.facebook.ads.redexgen.X.IQ r17) throws com.facebook.ads.redexgen.X.YO {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YK.A0D(com.facebook.ads.redexgen.X.IQ):boolean");
    }
}
