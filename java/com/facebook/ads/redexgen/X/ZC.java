package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseIntArray;

public class ZC implements DY {
    public static String[] A05;
    public final int A00;
    public final SparseArray<AbstractC0341Df> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();
    public final IP A03 = new IP(new byte[5]);
    public final /* synthetic */ ZD A04;

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"RGyTh4SpGx69CnC3uYB0gmKqWWTNP", "iDg", "j2BD3qxwlCatqD2Ch8dsr4SydA7XKwXL", "m1LAn1cIXYa33UPzElI", "cPJKdoCFMTZnGOgvNAg6pI", "iUx5cAJ8Ufw2U1Fp6uB6P", "qd", "YeOgnvzSUR8"};
    }

    public ZC(ZD zd, int i) {
        this.A04 = zd;
        this.A00 = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        if (r3 == 122) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (r3 == 122) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        if (r3 != 123) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a5, code lost:
        r7 = 138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        if (r3 != 10) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r6 = r13.A0T(3).trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r3 != 89) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r7 = 89;
        r5 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if (r13.A07() >= r10) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        r4 = r13.A0T(3).trim();
        r3 = r13.A0F();
        r1 = new byte[4];
        r13.A0d(r1, 0, 4);
        r5.add(new com.facebook.ads.redexgen.X.C0337Db(r4, r3, r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.redexgen.X.C0338Dc A00(com.facebook.ads.redexgen.X.IQ r13, int r14) {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZC.A00(com.facebook.ads.redexgen.X.IQ, int):com.facebook.ads.redexgen.X.Dc");
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A48(IQ iq) {
        C0462Ic ic;
        int i;
        AbstractC0341Df A4O;
        if (iq.A0F() == 2) {
            if (this.A04.A05 == 1 || this.A04.A05 == 2 || this.A04.A01 == 1) {
                ic = (C0462Ic) this.A04.A0B.get(0);
            } else {
                ic = new C0462Ic(((C0462Ic) this.A04.A0B.get(0)).A04());
                this.A04.A0B.add(ic);
            }
            iq.A0a(2);
            int A0J = iq.A0J();
            int i2 = 5;
            iq.A0a(5);
            iq.A0b(this.A03, 2);
            int i3 = 4;
            this.A03.A09(4);
            int i4 = 12;
            iq.A0a(this.A03.A05(12));
            int programInfoLength = 21;
            if (this.A04.A05 == 2 && this.A04.A03 == null) {
                C0338Dc dc = new C0338Dc(21, null, null, new byte[0]);
                ZD zd = this.A04;
                zd.A03 = zd.A09.A4O(21, dc);
                this.A04.A03.A7S(ic, this.A04.A02, new C0340De(A0J, 21, 8192));
            }
            this.A01.clear();
            this.A02.clear();
            int A052 = iq.A05();
            while (A052 > 0) {
                iq.A0b(this.A03, i2);
                int A053 = this.A03.A05(8);
                this.A03.A09(3);
                int A054 = this.A03.A05(13);
                this.A03.A09(i3);
                int A055 = this.A03.A05(i4);
                C0338Dc A002 = A00(iq, A055);
                if (A053 == 6) {
                    A053 = A002.A00;
                }
                A052 -= A055 + 5;
                if (this.A04.A05 == 2) {
                    i = A053;
                } else {
                    i = A054;
                }
                if (!this.A04.A07.get(i)) {
                    if (this.A04.A05 == 2 && A053 == programInfoLength) {
                        A4O = this.A04.A03;
                    } else {
                        ZD zd2 = this.A04;
                        String[] strArr = A05;
                        if (strArr[0].length() != strArr[1].length()) {
                            String[] strArr2 = A05;
                            strArr2[5] = "uMTX0BK3hwRt9LI9TXEhN";
                            strArr2[7] = "Q6yhhKO6s7v";
                            A4O = zd2.A09.A4O(A053, A002);
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    if (this.A04.A05 != 2 || A054 < this.A02.get(i, 8192)) {
                        SparseIntArray sparseIntArray = this.A02;
                        if (A05[4].length() != 17) {
                            String[] strArr3 = A05;
                            strArr3[3] = "hYuW2ZxScZvjOUyRYzD";
                            strArr3[3] = "hYuW2ZxScZvjOUyRYzD";
                            sparseIntArray.put(i, A054);
                            this.A01.put(i, A4O);
                        } else {
                            throw new RuntimeException();
                        }
                    }
                }
                i2 = 5;
                i3 = 4;
                i4 = 12;
                programInfoLength = 21;
            }
            int size = this.A02.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.A02.keyAt(i5);
                this.A04.A07.put(keyAt, true);
                AbstractC0341Df valueAt = this.A01.valueAt(i5);
                if (valueAt != null) {
                    if (valueAt != this.A04.A03) {
                        valueAt.A7S(ic, this.A04.A02, new C0340De(A0J, keyAt, 8192));
                    }
                    this.A04.A06.put(this.A02.valueAt(i5), valueAt);
                }
            }
            if (this.A04.A05 != 2) {
                int i6 = 0;
                this.A04.A06.remove(this.A00);
                ZD zd3 = this.A04;
                if (zd3.A05 != 1) {
                    i6 = this.A04.A01 - 1;
                }
                zd3.A01 = i6;
                if (this.A04.A01 == 0) {
                    this.A04.A02.A4w();
                    this.A04.A04 = true;
                }
            } else if (!(this.A04.A04)) {
                this.A04.A02.A4w();
                this.A04.A01 = 0;
                this.A04.A04 = true;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A7S(C0462Ic ic, CM cm, C0340De de) {
    }
}
