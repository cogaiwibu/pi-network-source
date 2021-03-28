package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.5q  reason: invalid class name and case insensitive filesystem */
public final class C01635q extends Thread {
    public final long A00;

    public C01635q(long j) {
        this.A00 = j;
        start();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:4|5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        com.facebook.ads.redexgen.X.KU.A00(r0, r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            boolean r0 = com.facebook.ads.redexgen.X.KU.A02(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r2 = r3
        L_0x0008:
            long r0 = r2.A00     // Catch:{ InterruptedException -> 0x000d }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x000d }
        L_0x000d:
            com.facebook.ads.redexgen.X.C01615o.A01()     // Catch:{ all -> 0x0011 }
            goto L_0x0008
        L_0x0011:
            r0 = move-exception
            com.facebook.ads.redexgen.X.KU.A00(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01635q.run():void");
    }
}
