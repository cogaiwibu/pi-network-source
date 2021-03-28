package com.facebook.ads.redexgen.X;

import android.view.OrientationEventListener;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.6L  reason: invalid class name */
public final class AnonymousClass6L {
    @Nullable
    public static OrientationEventListener A02;
    public static String[] A03;
    public final AnonymousClass6J A00;
    public final EnumC01856m A01;

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"ciYSwpO57ig7", "AgXvWM7vBAP276b3F", "h3L2uX2266ICJ0F8mxeOzYeo", "sn1Bi96p4g3FJ3lBwfTgs4qOj566", "nEyUaJreiz", "9f6cxckTFidZYnVMHRSclm", "9nbfinSPxnf3N791gNAhDrqxfgbV", "EACetWGUN5dpVn0xkHaZeeKDOZ"};
    }

    public AnonymousClass6L(AnonymousClass6J r1, EnumC01856m r2) {
        this.A00 = r1;
        this.A01 = r2;
    }

    public final synchronized void A02() {
        if (A02 != null) {
            A02.disable();
            A02 = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0006, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass6L.A03;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r2[7].length() == r2[1].length()) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass6L.A03;
        r2[7] = "WLHhaS1yyOUNNZKQvAoQ3Zw3xj";
        r2[1] = "prMYx6h4YCDadOhBb";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void A03(android.content.Context r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            android.view.OrientationEventListener r0 = com.facebook.ads.redexgen.X.AnonymousClass6L.A02     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x002b
            monitor-exit(r8)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass6L.A03
            r0 = 7
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L_0x0025
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass6L.A03
            java.lang.String r1 = "WLHhaS1yyOUNNZKQvAoQ3Zw3xj"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "prMYx6h4YCDadOhBb"
            r0 = 1
            r2[r0] = r1
            return
        L_0x0025:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x002b:
            long r5 = android.os.SystemClock.elapsedRealtime()
            r3 = r9
            if (r3 != 0) goto L_0x003b
            java.lang.String r2 = ""
        L_0x0034:
            com.facebook.ads.redexgen.X.6m r1 = r8.A01
            com.facebook.ads.redexgen.X.6m r0 = com.facebook.ads.redexgen.X.EnumC01856m.A0G
            if (r1 != r0) goto L_0x0042
            goto L_0x0040
        L_0x003b:
            java.lang.String r2 = r3.getPackageName()
            goto L_0x0034
        L_0x0040:
            r7 = 0
            goto L_0x0047
        L_0x0042:
            com.facebook.ads.redexgen.X.6v r7 = new com.facebook.ads.redexgen.X.6v
            r7.<init>(r2)
        L_0x0047:
            com.facebook.ads.redexgen.X.6K r1 = new com.facebook.ads.redexgen.X.6K
            r4 = 3
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r7)
            com.facebook.ads.redexgen.X.AnonymousClass6L.A02 = r1
            android.view.OrientationEventListener r0 = com.facebook.ads.redexgen.X.AnonymousClass6L.A02
            r0.enable()
            monitor-exit(r8)
            return
        L_0x0057:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass6L.A03(android.content.Context):void");
    }
}
