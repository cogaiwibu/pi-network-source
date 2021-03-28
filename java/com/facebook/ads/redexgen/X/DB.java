package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public final class DB {
    public static String[] A05;
    public int A00 = -1;
    public int A01;
    public boolean A02;
    public final DC A03 = new DC();
    public final IQ A04 = new IQ(new byte[65025], 0);

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"YmqCfQGeJdZscNiSsRHgK8Xqwc4qCDQV", "BEVC1cuwi5mxHrGOZ29iGldY3rFRULVC", "DSPc42zLHxXdWx97yn92wynUTyNm", "qbq", "Vn6wbfa2hXyYQug1oukzP6oQFgTa", "a4c", "hss", "EwoauNNUoRbyLKR"};
    }

    private int A00(int i) {
        this.A01 = 0;
        int i2 = 0;
        while (this.A01 + i < this.A03.A02) {
            int[] iArr = this.A03.A09;
            int i3 = this.A01;
            this.A01 = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }

    public final DC A02() {
        return this.A03;
    }

    public final IQ A03() {
        return this.A04;
    }

    public final void A04() {
        this.A03.A03();
        this.A04.A0W();
        this.A00 = -1;
        this.A02 = false;
    }

    public final void A05() {
        if (this.A04.A00.length != 65025) {
            IQ iq = this.A04;
            iq.A00 = Arrays.copyOf(iq.A00, Math.max(65025, this.A04.A08()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c8, code lost:
        if (r7.A03.A09[r3 - 1] != 5) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ee, code lost:
        if (r7.A03.A09[r3 - 1] != 255) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f1, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A06(com.facebook.ads.redexgen.X.CL r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DB.A06(com.facebook.ads.redexgen.X.CL):boolean");
    }
}
