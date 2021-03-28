package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2g  reason: invalid class name and case insensitive filesystem */
public final class C00792g extends AbstractC0290Ax {
    public static byte[] A05;
    public static String[] A06;
    public final C0418Gk A00 = new C0418Gk();
    public final C0424Gq A01 = new C0424Gq();
    public final C0427Gt A02 = new C0427Gt();
    public final IQ A03 = new IQ();
    public final List<C0422Go> A04 = new ArrayList();

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 113);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{89, 56, 107, 108, 97, 116, 125, 56, 122, 116, 119, 123, 115, 56, 111, 121, 107, 56, 126, 119, 109, 118, 124, 56, 121, 126, 108, 125, 106, 56, 108, 112, 125, 56, 126, 113, 106, 107, 108, 56, 123, 109, 125, 54, 52, 53, 46, 63, 28, 27, 22, 3, 10, 29, 47, 40, 60, 62, 62, 14, 47, 41, 37, 46, 47, 56};
    }

    public static void A04() {
        A06 = new String[]{"CMeD5mXDZDTfb", "fWYAWHkLFKDlflVtn3klkQMszSy2czx5", "00RFRgIDsqiIARLTNA3N6SPhWhBdnLh1", "U8JLQKkyCBG48OlAsiyvwZYOetZ2qreJ", "pY35d7af18sebuviuQ2bLCANBl7hHJuY", "f8ToU2BaHxZg9tVTog2hKPYEgQcC6j0M", "sxXavdrivd5JbbwFv9VJPSRnNTBEZ25u", "aixApfSzl80yG78LfLrSNW905rKMIX1l"};
    }

    public C00792g() {
        super(A02(53, 13, 59));
    }

    public static int A00(IQ iq) {
        int currentInputPosition = -1;
        int i = 0;
        while (currentInputPosition == -1) {
            i = iq.A07();
            String A0Q = iq.A0Q();
            if (A0Q == null) {
                currentInputPosition = 0;
            } else if (A02(48, 5, 62).equals(A0Q)) {
                currentInputPosition = 2;
            } else if (A02(44, 4, 11).startsWith(A0Q)) {
                currentInputPosition = 1;
            } else {
                currentInputPosition = 3;
            }
        }
        iq.A0Z(i);
        String[] strArr = A06;
        if (strArr[1].charAt(4) != strArr[2].charAt(4)) {
            String[] strArr2 = A06;
            strArr2[1] = "wICfUq6cRqM8QSRmpIxw59la3C0B28Gh";
            strArr2[2] = "UCa9DZD1GiApguhXmO9GHmNOpL0AOlSY";
            return currentInputPosition;
        }
        throw new RuntimeException();
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final C0936aN A0d(byte[] bArr, int i, boolean z) throws GH {
        boolean isEmpty;
        this.A03.A0c(bArr, i);
        this.A01.A0F();
        this.A04.clear();
        C0428Gu.A05(this.A03);
        do {
            isEmpty = TextUtils.isEmpty(this.A03.A0Q());
            if (A06[7].charAt(24) != '5') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[4] = "yIxA0yuP9hQGFN4fa3NPu5J4rTDeCvUe";
            strArr[4] = "yIxA0yuP9hQGFN4fa3NPu5J4rTDeCvUe";
        } while (!isEmpty);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int A002 = A00(this.A03);
            if (A002 == 0) {
                return new C0936aN(arrayList);
            }
            if (A002 == 1) {
                A05(this.A03);
            } else if (A06[6].charAt(24) != 'N') {
                throw new RuntimeException();
            } else {
                String[] strArr2 = A06;
                strArr2[4] = "ccU6TSbM8V8OtEl7BaomB3QNW5j0Q6sw";
                strArr2[4] = "ccU6TSbM8V8OtEl7BaomB3QNW5j0Q6sw";
                if (A002 == 2) {
                    boolean isEmpty2 = arrayList.isEmpty();
                    if (A06[0].length() == 13) {
                        String[] strArr3 = A06;
                        strArr3[1] = "RankGpg1WKksvMbJf2r1Mj9i4dXCVfm7";
                        strArr3[2] = "PTwUfk4233EGPZYG7vYxG5zvlLDyWplM";
                        if (!isEmpty2) {
                            break;
                        }
                    } else {
                        String[] strArr4 = A06;
                        strArr4[1] = "YowA8l8uvxZXaVypumJ5yBUyc4sOcAQV";
                        strArr4[2] = "HKbmxYlwqclncAnOAoFTo7zzjR7PE75y";
                        if (!isEmpty2) {
                            break;
                        }
                    }
                    this.A03.A0Q();
                    C0422Go A0F = this.A00.A0F(this.A03);
                    if (A0F != null) {
                        this.A04.add(A0F);
                    }
                } else if (A002 == 3 && this.A02.A0H(this.A03, this.A01, this.A04)) {
                    arrayList.add(this.A01.A0E());
                    this.A01.A0F();
                }
            }
        }
        throw new GH(A02(0, 44, 105));
    }

    public static void A05(IQ iq) {
        do {
        } while (!TextUtils.isEmpty(iq.A0Q()));
    }
}
