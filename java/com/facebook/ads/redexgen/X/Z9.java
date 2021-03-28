package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

public final class Z9 implements DY {
    public static byte[] A03;
    public static String[] A04;
    public CW A00;
    public C0462Ic A01;
    public boolean A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{11, 26, 26, 22, 19, 13, 11, 30, 19, 25, 24, -39, 34, -41, 29, 13, 30, 15, -35, -33};
    }

    public static void A02() {
        A04 = new String[]{"9dIhF2X5qYPGZcPrMQjFeU2FMq4Icb5t", "C7lZKzl2OzNugbLE4QJixcZrlcSgCGI7", "v7kvgcbsYqtq4Ou8B7XlURjv8wkzUozH", "8BzUB2zJ4MAZsKVthH28T9QXZJlG29jD", "wOgdV6BnuyxARX3Rbc0CvFDDXWIKfgjM", "mpBmZ", "f47n1mRwiFyOsV4myeWB5UC2YKJiwKop", "3tKYH9iJUyIyPmbH9Trftcv4NWgUsp5b"};
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A48(IQ iq) {
        if (!this.A02) {
            if (this.A01.A06() != -9223372036854775807L) {
                this.A00.A5A(Format.A02(null, A00(0, 20, 74), this.A01.A06()));
                this.A02 = true;
            } else {
                return;
            }
        }
        int A05 = iq.A05();
        this.A00.ACe(iq, A05);
        CW cw = this.A00;
        if (A04[0].charAt(13) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[0] = "M4wOXnroCREOIcf8T96EgrMDUu9ExHmM";
        strArr[0] = "M4wOXnroCREOIcf8T96EgrMDUu9ExHmM";
        cw.ACf(this.A01.A05(), 1, A05, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A7S(C0462Ic ic, CM cm, C0340De de) {
        this.A01 = ic;
        de.A06();
        this.A00 = cm.ADY(de.A04(), 4);
        this.A00.A5A(Format.A0B(de.A05(), A00(0, 20, 74), null, -1, null));
    }
}
