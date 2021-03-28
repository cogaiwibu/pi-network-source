package com.facebook.ads.redexgen.X;

import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;

public final class D8 {
    public static String[] A0J;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public C0327Cr A07;
    public D7 A08;
    public IQ A09;
    public boolean A0A;
    public boolean A0B;
    public int[] A0C;
    public int[] A0D;
    public int[] A0E;
    public long[] A0F;
    public long[] A0G;
    public boolean[] A0H;
    public boolean[] A0I;

    static {
        A00();
    }

    public static void A00() {
        A0J = new String[]{"0EwfBQL8WgkraFIT5", "yqBIkqshgk6o8aGC7JXOfAcvQBpSEoIE", "Pb3yD9oBE", "Sy7y64hwk", "hrTCG", "uTsL", "1ofsGt0E1HxH4l7d5", AppEventsConstants.EVENT_PARAM_VALUE_NO};
    }

    public final long A01(int i) {
        return this.A0F[i] + ((long) this.A0C[i]);
    }

    public final void A02() {
        this.A02 = 0;
        this.A06 = 0;
        this.A0A = false;
        this.A0B = false;
        this.A08 = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r3 < r5) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A03(int r5) {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.IQ r0 = r4.A09
            if (r0 == 0) goto L_0x0023
            int r3 = r0.A08()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.D8.A0J
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 21
            if (r1 == r0) goto L_0x004c
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.D8.A0J
            java.lang.String r1 = "O7sbivaH"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "O7sbivaH"
            r0 = 3
            r2[r0] = r1
            if (r3 >= r5) goto L_0x002a
        L_0x0023:
            com.facebook.ads.redexgen.X.IQ r0 = new com.facebook.ads.redexgen.X.IQ
            r0.<init>(r5)
            r4.A09 = r0
        L_0x002a:
            r4.A01 = r5
            r0 = 1
            r4.A0A = r0
            r4.A0B = r0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.D8.A0J
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 20
            if (r1 == r0) goto L_0x004b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.D8.A0J
            java.lang.String r1 = "ZqBRFK04oxBzllTVeb4xO6w8kHwYHjDg"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "ZqBRFK04oxBzllTVeb4xO6w8kHwYHjDg"
            r0 = 1
            r2[r0] = r1
            return
        L_0x004b:
            return
        L_0x004c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D8.A03(int):void");
    }

    public final void A04(int i, int i2) {
        this.A02 = i;
        this.A00 = i2;
        int[] iArr = this.A0E;
        if (iArr == null || iArr.length < i) {
            this.A0G = new long[i];
            this.A0E = new int[i];
        }
        int[] iArr2 = this.A0D;
        if (iArr2 == null || iArr2.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.A0D = new int[i3];
            this.A0C = new int[i3];
            this.A0F = new long[i3];
            this.A0I = new boolean[i3];
            this.A0H = new boolean[i3];
        }
    }

    public final void A05(CL cl) throws IOException, InterruptedException {
        cl.readFully(this.A09.A00, 0, this.A01);
        this.A09.A0Z(0);
        this.A0B = false;
    }

    public final void A06(IQ iq) {
        iq.A0d(this.A09.A00, 0, this.A01);
        this.A09.A0Z(0);
        this.A0B = false;
    }
}
