package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class P5 extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ AnonymousClass85 A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A02;
                strArr2[7] = "csAIefbP6dEHufce3C5MSz";
                strArr2[7] = "csAIefbP6dEHufce3C5MSz";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 117);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A01 = new byte[]{67, 86, 81, 82, 92, 13, 91, 82, 99, 82, 95, 13, 96, 97, 78, 95, 97, 82, 81, 13, 93, 89, 78, 102, 86, 91, 84};
    }

    public static void A03() {
        A02 = new String[]{"aQtlI1Us5cYHMsIV", "ql6TdDFLVKaOF", "ILd0cBh", "B0sTrIURZDTgtQOqZ9wP44Me", "PUGSIMdaF2lm0BEktB", "ig45kctSq2tkP", "eb7l2wEenDPHh06UHeaR81tCSX", "F61vU5UciYvMkd8uRJU0Fm"};
    }

    public P5(AnonymousClass85 r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (!(this.A00.A07)) {
            this.A00.A0H(A00(0, 27, 120));
        }
    }
}
