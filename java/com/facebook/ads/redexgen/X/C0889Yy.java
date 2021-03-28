package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Yy  reason: case insensitive filesystem */
public final class C0889Yy implements DQ {
    public static byte[] A06;
    public static String[] A07;
    public int A00;
    public int A01;
    public long A02;
    public boolean A03;
    public final List<C0337Db> A04;
    public final CW[] A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 76);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{117, 100, 100, 120, 125, 119, 117, 96, 125, 123, 122, 59, 112, 98, 118, 103, 97, 118, 103};
    }

    public static void A02() {
        A07 = new String[]{"Jiy", "2wEJIBTa4RvP8yrIwKSodHRjo9", "akcZBAKpF", "EuZb8kUx1OZ", "XeLxT4hCbfpB8vk3L3qpbFThh9kK", "oaj", "R8TqjunyKtvNfOkCV", "nGIequV"};
    }

    public C0889Yy(List<C0337Db> list) {
        this.A04 = list;
        this.A05 = new CW[list.size()];
    }

    private boolean A03(IQ iq, int i) {
        if (iq.A05() == 0) {
            return false;
        }
        if (iq.A0F() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    /* JADX INFO: Multiple debug info for r0v5 com.facebook.ads.redexgen.X.CW: [D('bytesAvailable' int), D('output' com.facebook.ads.redexgen.X.CW)] */
    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        if (!this.A03) {
            return;
        }
        if (this.A00 != 2 || A03(iq, 32)) {
            if (this.A00 != 1 || A03(iq, 0)) {
                int A072 = iq.A07();
                int A052 = iq.A05();
                CW[] cwArr = this.A05;
                for (CW output : cwArr) {
                    iq.A0Z(A072);
                    output.ACe(iq, A052);
                }
                this.A01 += A052;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        int i = 0;
        while (true) {
            CW[] cwArr = this.A05;
            String[] strArr = A07;
            if (strArr[7].length() != strArr[1].length()) {
                String[] strArr2 = A07;
                strArr2[6] = "6Yign7KSgGvnaQ3UG";
                strArr2[0] = "Q7U";
                if (i < cwArr.length) {
                    C0337Db db = this.A04.get(i);
                    de.A06();
                    CW ADY = cm.ADY(de.A04(), 3);
                    ADY.A5A(Format.A0A(de.A05(), A00(0, 19, 88), null, -1, 0, Collections.singletonList(db.A02), db.A01, null));
                    this.A05[i] = ADY;
                    i++;
                } else {
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
        if (this.A03) {
            for (CW cw : this.A05) {
                cw.ACf(this.A02, 1, this.A01, 0, null);
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        if (z) {
            this.A03 = true;
            this.A02 = j;
            this.A01 = 0;
            this.A00 = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        this.A03 = false;
    }
}
