package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.facebook.ads.redexgen.X.2h  reason: invalid class name and case insensitive filesystem */
public final class C00802h extends AbstractC0290Ax {
    public static byte[] A02;
    public static final int A03 = C0466Ig.A08(A02(100, 4, 29));
    public static final int A04 = C0466Ig.A08(A02(104, 4, 9));
    public static final int A05 = C0466Ig.A08(A02(108, 4, 74));
    public final C0424Gq A00 = new C0424Gq();
    public final IQ A01 = new IQ();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{1, 38, 27, 39, 37, 40, 36, 29, 44, 29, -40, 5, 40, -20, 15, 29, 26, 46, 44, 44, -40, 12, 39, 40, -40, 4, 29, 46, 29, 36, -40, 26, 39, 48, -40, 32, 29, 25, 28, 29, 42, -40, 30, 39, 45, 38, 28, -26, 43, 80, 69, 81, 79, 82, 78, 71, 86, 71, 2, 88, 86, 86, 2, 69, 87, 71, 2, 68, 81, 90, 2, 74, 71, 67, 70, 71, 84, 2, 72, 81, 87, 80, 70, 16, 16, 51, -9, 26, 40, 37, 57, 55, 55, 7, 40, 38, 50, 39, 40, 53, 3, -12, 12, -1, -14, -13, -13, -26, 54, 52, 52, 35};
    }

    static {
        A03();
    }

    public C00802h() {
        super(A02(84, 16, 77));
    }

    public static GF A00(IQ iq, C0424Gq gq, int payloadLength) throws GH {
        gq.A0F();
        while (payloadLength > 0) {
            if (payloadLength >= 8) {
                int A09 = iq.A09();
                int A092 = iq.A09();
                int i = A09 - 8;
                String A0R = C0466Ig.A0R(iq.A00, iq.A07(), i);
                iq.A0a(i);
                payloadLength = (payloadLength - 8) - i;
                if (A092 == A04) {
                    C0427Gt.A09(A0R, gq);
                } else if (A092 == A03) {
                    C0427Gt.A0D(null, A0R.trim(), gq, Collections.emptyList());
                }
            } else {
                throw new GH(A02(48, 36, 108));
            }
        }
        return gq.A0E();
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0934aL A0d(byte[] bArr, int i, boolean z) throws GH {
        this.A01.A0c(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.A01.A05() > 0) {
            if (this.A01.A05() >= 8) {
                int A09 = this.A01.A09();
                if (this.A01.A09() == A05) {
                    arrayList.add(A00(this.A01, this.A00, A09 - 8));
                } else {
                    this.A01.A0a(A09 - 8);
                }
            } else {
                throw new GH(A02(0, 48, 66));
            }
        }
        return new C0934aL(arrayList);
    }
}
