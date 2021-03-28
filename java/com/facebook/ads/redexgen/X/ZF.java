package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class ZF implements CK {
    public static byte[] A05;
    public static String[] A06;
    public static final CN A07 = new ZE();
    public int A00;
    public int A01;
    public CM A02;
    public CW A03;
    public ZG A04;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 72);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 67, 17, 68, 95, 67, 84, 82, 94, 86, 95, 88, 75, 84, 85, 17, 70, 80, 71, 17, 89, 84, 80, 85, 84, 67, 31, 107, ByteCompanionObject.MAX_VALUE, 110, 99, 101, 37, 120, 107, 125};
    }

    public static void A02() {
        A06 = new String[]{"TnN98hFrpPh0PRtpc088aNdcZccscvrw", "5aRpZ2NNsZI5w0o7DGq1eAqNryB", "mEVhsrU6MzIr1qyqOlGiN", "yrEmV4s21h7BLFfB7siMTKTjJQry3", "EfBKzRp", "ss80CflBP4AmUjPde3BocO42m8Tqd1M1", "kqV6vinpOYrD", "3vWKjffhrtNYzin5lJ6IQFsZaR1xXQhq"};
    }

    static {
        A02();
        A01();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A02 = cm;
        this.A03 = cm.ADY(0, 1);
        this.A04 = null;
        cm.A4w();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00ae, code lost:
        if (r6 != -1) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e5, code lost:
        if (r6 != -1) goto L_0x00b0;
     */
    @Override // com.facebook.ads.redexgen.X.CK
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ABx(com.facebook.ads.redexgen.X.CL r19, com.facebook.ads.redexgen.X.CR r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZF.ABx(com.facebook.ads.redexgen.X.CL, com.facebook.ads.redexgen.X.CR):int");
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return C0343Dh.A00(cl) != null;
    }
}
