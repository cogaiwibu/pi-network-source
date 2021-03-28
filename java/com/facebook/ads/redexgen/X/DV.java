package com.facebook.ads.redexgen.X;

import kotlin.jvm.internal.ByteCompanionObject;

public final class DV {
    public static String[] A0D;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final CW A0C;

    static {
        A00();
    }

    public static void A00() {
        A0D = new String[]{"AytN1i9iULWpAtR2eIfx7QogEUuyUUX4", "EimBg0", "4eNGQSgLmn9gvaK14R8kSqnFmk3YDtSi", "2fyuIcJ7pz76VyZl9SMNa1chyaGQvScm", "P7Bhpggufyl3vqAGq89SAtaTbaXWozcC", "R5XBsX91lZ7HUyZ9KaLj5rOllXZCV26j", "kcg4Z6bP9bO4onTQZ6Z5ctV", "10vbbYYZLuUPLbeNO2JvVvesRy5vOtek"};
    }

    public DV(CW cw) {
        this.A0C = cw;
    }

    private void A01(int i) {
        boolean z = this.A0A;
        this.A0C.ACf(this.A04, z ? 1 : 0, (int) (this.A01 - this.A03), i, null);
    }

    public final void A02() {
        this.A07 = false;
        this.A06 = false;
        this.A05 = false;
        this.A09 = false;
        this.A0B = false;
    }

    public final void A03(long j, int i) {
        if (this.A0B && this.A06) {
            this.A0A = this.A08;
            String[] strArr = A0D;
            if (strArr[1].length() != strArr[6].length()) {
                String[] strArr2 = A0D;
                strArr2[7] = "hh10uoQ2wjGgTUsUevn281NORx98TkB1";
                strArr2[7] = "hh10uoQ2wjGgTUsUevn281NORx98TkB1";
                this.A0B = false;
                return;
            }
            throw new RuntimeException();
        } else if (this.A05 || this.A06) {
            if (this.A09) {
                A01(i + ((int) (j - this.A01)));
            }
            this.A03 = this.A01;
            this.A04 = this.A02;
            this.A09 = true;
            this.A0A = this.A08;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (r10 >= 16) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r10 >= 16) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A04(long r7, int r9, int r10, long r11) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DV.A04(long, int, int, long):void");
    }

    public final void A05(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.A07) {
            int i3 = this.A00;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                if ((bArr[i4] & ByteCompanionObject.MIN_VALUE) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.A06 = z;
                this.A07 = false;
                return;
            }
            int i5 = i3 + (i2 - i);
            if (A0D[0].charAt(24) != 'E') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "OWSyVtAwrfkSOzobpeDsxETSEBQPa9qP";
            strArr[0] = "OWSyVtAwrfkSOzobpeDsxETSEBQPa9qP";
            this.A00 = i5;
        }
    }
}
