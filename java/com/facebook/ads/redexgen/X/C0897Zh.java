package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Zh  reason: case insensitive filesystem */
public final class C0897Zh implements AbstractC0387Fd {
    public static String[] A03;
    public boolean A00;
    public final AbstractC0387Fd A01;
    public final /* synthetic */ B0 A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"Y0RqBQKF49030hyQzszDurtmlsUicf4U", "tAeRat44Mts19", "EPGGJhXl7bdoeZDT1hnWH0ijeyZXJvPV", "NBArrZMeyPwcwZbguPm4zDdVfStRBHKE", "9Syc9rzKlnhB1gjxfWOFcJRGeL88RA9A", "zPpMUsK8OtHy3XCHJzxzsSjo5boBV7qo", "d", "R"};
    }

    public C0897Zh(B0 b0, AbstractC0387Fd fd) {
        this.A02 = b0;
        this.A01 = fd;
    }

    public final void A01() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0387Fd
    public final boolean A7i() {
        return !this.A02.A04() && this.A01.A7i();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0387Fd
    public final void A8U() throws IOException {
        this.A01.A8U();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r7 == Long.MIN_VALUE) goto L_0x0085;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0387Fd
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int AC0(com.facebook.ads.redexgen.X.AH r12, com.facebook.ads.redexgen.X.C0861Xw r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0897Zh.AC0(com.facebook.ads.redexgen.X.AH, com.facebook.ads.redexgen.X.Xw, boolean):int");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0387Fd
    public final int ADF(long j) {
        if (this.A02.A04()) {
            return -3;
        }
        return this.A01.ADF(j);
    }
}
