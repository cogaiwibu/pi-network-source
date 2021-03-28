package com.facebook.ads.redexgen.X;

public final class I7 {
    public static String[] A01;
    public boolean A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"ai2EfOriaTIhqtzLWYXlPleIkpLxWtX3", "8POqEzQt", "C9XS0tRq", "", "AAxD7MG0VtZMRL4EoelO07EezWtzxWUG", "", "6PKYsgscuQ75gJwNEilmQ2c4nRmBzCem", "CYsAdFFV2DQ1VCBuBS7UZ1OMxmR8"};
    }

    public final synchronized void A01() throws InterruptedException {
        while (!this.A00) {
            wait();
        }
    }

    public final synchronized boolean A02() {
        boolean z;
        z = this.A00;
        this.A00 = false;
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r2 = com.facebook.ads.redexgen.X.I7.A01;
        r2[2] = "6xVrNnWg";
        r2[1] = "bGYw6WXz";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0007, code lost:
        r2 = com.facebook.ads.redexgen.X.I7.A01;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r2[2].length() == r2[1].length()) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        throw new java.lang.RuntimeException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean A03() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.A00     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x002c
            r3 = 0
            monitor-exit(r4)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.I7.A01
            r0 = 2
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L_0x001f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x001f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.I7.A01
            java.lang.String r1 = "6xVrNnWg"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "bGYw6WXz"
            r0 = 1
            r2[r0] = r1
            return r3
        L_0x002c:
            r0 = 1
            r4.A00 = r0
            r4.notifyAll()
            monitor-exit(r4)
            return r0
        L_0x0034:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.I7.A03():boolean");
    }
}
