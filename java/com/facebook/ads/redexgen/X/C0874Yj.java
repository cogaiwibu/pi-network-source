package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Yj  reason: case insensitive filesystem */
public final class C0874Yj extends DG {
    public static byte[] A02;
    public static String[] A03;
    public C0873Yi A00;
    public ID A01;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{6, 18, 3, 14, 8, 72, 1, 11, 6, 4};
    }

    public static void A04() {
        A03 = new String[]{"RjYCDLb2NANzCnedRKoQM0GQ", "QX5lqyT5r1TYXy6sq6A", "sDmzmZu2Epi", "QleORMZQxcHxPLUcnR0aaEPVJ", "tBrVRsKa63H7cOEQm0uGMqa5cwtrVWSW", "PEwzIbtLaNn1pzRcppb", "zVqUyH", "ZIYCsXe3luBjtUiXTHmKPLmA"};
    }

    private int A00(IQ iq) {
        int A0J;
        int i = (iq.A00[2] & UByte.MAX_VALUE) >> 4;
        switch (i) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                iq.A0a(4);
                iq.A0P();
                if (i == 6) {
                    A0J = iq.A0F();
                } else {
                    A0J = iq.A0J();
                }
                iq.A0Z(0);
                return A0J + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static boolean A05(IQ iq) {
        return iq.A05() >= 5 && iq.A0F() == 127 && iq.A0N() == 1179402563;
    }

    public static boolean A06(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final long A08(IQ iq) {
        if (!A06(iq.A00)) {
            return -1;
        }
        int A002 = A00(iq);
        String[] strArr = A03;
        if (strArr[2].length() != strArr[0].length()) {
            String[] strArr2 = A03;
            strArr2[2] = "M0DKrSciZtY";
            strArr2[0] = "bwyyvFLni8GVBC8P6VU38e20";
            return (long) A002;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final void A0A(boolean z) {
        super.A0A(z);
        if (z) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DG
    public final boolean A0B(IQ iq, long j, DF df) throws IOException, InterruptedException {
        byte[] bArr = iq.A00;
        if (this.A01 == null) {
            this.A01 = new ID(bArr, 17);
            byte[] data = Arrays.copyOfRange(bArr, 9, iq.A08());
            data[4] = ByteCompanionObject.MIN_VALUE;
            List singletonList = Collections.singletonList(data);
            df.A00 = Format.A07(null, A02(0, 10, 95), null, -1, this.A01.A00(), this.A01.A01, this.A01.A06, singletonList, null, 0, null);
            return true;
        } else if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
            this.A00 = new C0873Yi(this);
            this.A00.A02(iq);
            return true;
        } else if (!A06(bArr)) {
            return true;
        } else {
            C0873Yi yi = this.A00;
            if (yi != null) {
                yi.A01(j);
                df.A01 = this.A00;
            }
            return false;
        }
    }
}
