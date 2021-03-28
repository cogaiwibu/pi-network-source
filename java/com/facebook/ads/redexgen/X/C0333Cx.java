package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;

/* renamed from: com.facebook.ads.redexgen.X.Cx  reason: case insensitive filesystem */
public final class C0333Cx {
    public static String[] A0A;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C0327Cr A04;
    public D6 A05;
    public final CW A06;
    public final D8 A07 = new D8();
    public final IQ A08 = new IQ();
    public final IQ A09 = new IQ(1);

    static {
        A02();
    }

    public static void A02() {
        A0A = new String[]{"3clh", "In2mDQuCVOg3ihkf16hWdIIfuM6sFv5F", "x02l2Vae1akitXdZsfkSin5rPssADgyF", "voDg", "hUzVtg6QDcg3AayaGyy4Y5hfj2RvIx7z", "AYA0HHhZRav1tOhmR967ChnIf", "RG8", "bQ6q4wCv1qa3psjbWrVNO9D1ADq5zdw2"};
    }

    public C0333Cx(CW cw) {
        this.A06 = cw;
    }

    private D7 A00() {
        int i = this.A07.A07.A02;
        if (this.A07.A08 == null) {
            return this.A05.A00(i);
        }
        D8 d8 = this.A07;
        String[] strArr = A0A;
        if (strArr[1].charAt(10) != strArr[4].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[1] = "mhitCTNVD2gTcCiZ9jaRAXWaAA0g9dMw";
        strArr2[4] = "MwiogHOaq0gqmibDd9x4nD1rPGRVV4il";
        return d8.A08;
    }

    /* access modifiers changed from: private */
    public void A01() {
        if (this.A07.A0A) {
            IQ iq = this.A07.A09;
            D7 A002 = A00();
            if (A002.A00 != 0) {
                iq.A0a(A002.A00);
            }
            if (this.A07.A0H[this.A01]) {
                iq.A0a(iq.A0J() * 6);
            }
        }
    }

    public final int A04() {
        IQ iq;
        int length;
        int vectorSize;
        if (!this.A07.A0A) {
            return 0;
        }
        D7 A002 = A00();
        if (A002.A00 != 0) {
            iq = this.A07.A09;
            length = A002.A00;
        } else {
            byte[] bArr = A002.A04;
            String[] strArr = A0A;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "Pfb0S5CneQgYrjeMjOJgtR7T7eyOdr1R";
            strArr2[4] = "zLY8KEVp0MgNhcadjz3HGMWIKnjSbq4p";
            this.A08.A0c(bArr, bArr.length);
            iq = this.A08;
            length = bArr.length;
        }
        boolean z = this.A07.A0H[this.A01];
        byte[] bArr2 = this.A09.A00;
        if (z) {
            vectorSize = 128;
        } else {
            vectorSize = 0;
        }
        bArr2[0] = (byte) (vectorSize | length);
        this.A09.A0Z(0);
        this.A06.ACe(this.A09, 1);
        this.A06.ACe(iq, length);
        if (!z) {
            return length + 1;
        }
        IQ iq2 = this.A07.A09;
        int A0J = iq2.A0J();
        iq2.A0a(-2);
        int i = (A0J * 6) + 2;
        this.A06.ACe(iq2, i);
        return length + 1 + i;
    }

    public final void A05() {
        this.A07.A02();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A06(long j) {
        long A012 = C02669y.A01(j);
        int i = this.A01;
        while (i < this.A07.A00 && this.A07.A01(i) < A012) {
            boolean[] zArr = this.A07.A0I;
            String[] strArr = A0A;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "yYyJ6pNJ0kgjmttu9OhrBT2GfQD0mn7b";
            strArr2[4] = "spdSEizAECgh3deYwyaUKu4kY7nul1tj";
            if (zArr[i]) {
                this.A03 = i;
            }
            i++;
        }
    }

    public final void A07(DrmInitData drmInitData) {
        String str;
        D7 A002 = this.A05.A00(this.A07.A07.A02);
        if (A002 != null) {
            str = A002.A02;
        } else {
            str = null;
        }
        this.A06.A5A(this.A05.A07.A0J(drmInitData.A03(str)));
    }

    public final void A08(D6 d6, C0327Cr cr) {
        this.A05 = (D6) I1.A01(d6);
        this.A04 = (C0327Cr) I1.A01(cr);
        this.A06.A5A(d6.A07);
        A05();
    }

    public final boolean A09() {
        this.A01++;
        this.A00++;
        int i = this.A00;
        int[] iArr = this.A07.A0E;
        int i2 = this.A02;
        if (i != iArr[i2]) {
            return true;
        }
        this.A02 = i2 + 1;
        String[] strArr = A0A;
        if (strArr[2].charAt(8) != strArr[7].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[6] = "24SILmm";
        strArr2[6] = "24SILmm";
        this.A00 = 0;
        return false;
    }
}
