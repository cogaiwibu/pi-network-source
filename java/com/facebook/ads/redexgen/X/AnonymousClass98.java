package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.98  reason: invalid class name */
public final class AnonymousClass98 {
    public static HashMap<String, String> A00;
    public static byte[] A01;
    public static String[] A02;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{63, 46, 46, 60, 43, 55, 50, 58, 118, 103, 103, 121, 118, 122, 114, 27, 10, 10, 12, 31, 8, 9, 13, 34, 40, 62, 35, 37, 40, 32, 55, 44, 38, 46, 39, 13, 15, 4, 5, 12, 53, 41, 121, 101, 96, 115, 100, 101, 114, 101, 106, 126, 105, 102, 114, 123, 104, ByteCompanionObject.MAX_VALUE, 126, 100, 98, 99, 1, 23, 1, 1, 27, 29, 28, 13, 27, 22, 53, 58, 48, 38, 59, 61, 48};
    }

    public static void A04() {
        A02 = new String[]{"khEJJSEBeZAj3OAxCgzNidlYCZn1WdrQ", "WigI19L", "nVQbXZzkIzZCm6ed4Wwsa9gCOy", "HTplkKsJZ28QwTvwNKGrQ1qXfC2z", "xAVvuzXwzMicNcIETZjP5vM2paYATPUF", "ZQBu7F3mQUfNW6aD", "dGQdYWCLx", "hFrznfqGyDFETBry94BNLT7Zi42G"};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (com.facebook.ads.redexgen.X.AnonymousClass98.A02[6].length() == 9) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass98.A02;
        r2[4] = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN";
        r2[4] = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.Map<java.lang.String, java.lang.String> A01(com.facebook.ads.redexgen.X.AnonymousClass8H r5) {
        /*
            java.lang.Class<com.facebook.ads.redexgen.X.98> r4 = com.facebook.ads.redexgen.X.AnonymousClass98.class
            monitor-enter(r4)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.facebook.ads.redexgen.X.AnonymousClass98.A00     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0010
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0055 }
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.facebook.ads.redexgen.X.AnonymousClass98.A00     // Catch:{ all -> 0x0055 }
            r1.<init>(r0)     // Catch:{ all -> 0x0055 }
            monitor-exit(r4)
            return r1
        L_0x0010:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.facebook.ads.redexgen.X.AnonymousClass98.A00 = r0
            java.util.HashMap<java.lang.String, java.lang.String> r3 = com.facebook.ads.redexgen.X.AnonymousClass98.A00
            r2 = 29
            r1 = 6
            r0 = 7
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r5.getPackageName()
            r3.put(r1, r0)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.facebook.ads.redexgen.X.AnonymousClass98.A00
            A02(r5, r0)
            java.util.HashMap r3 = new java.util.HashMap
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.facebook.ads.redexgen.X.AnonymousClass98.A00
            r3.<init>(r0)
            monitor-exit(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AnonymousClass98.A02
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 9
            if (r1 == r0) goto L_0x0048
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x0048:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass98.A02
            java.lang.String r1 = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN"
            r0 = 4
            r2[r0] = r1
            return r3
        L_0x0055:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass98.A01(com.facebook.ads.redexgen.X.8H):java.util.Map");
    }

    public static synchronized Map<String, String> A02(AnonymousClass8H r5, Map<String, String> map) {
        synchronized (AnonymousClass98.class) {
            map.put(A00(48, 3, 68), A00(72, 7, 49));
            map.put(A00(51, 11, 72), BuildConfigApi.getVersionName(r5));
            map.put(A00(40, 2, 31), A00(22, 7, 41));
            map.put(A00(42, 6, 83), C02348s.A03);
            C02348s r3 = new C02348s(r5);
            map.put(A00(15, 7, 63), r3.A06());
            map.put(A00(8, 7, 82), r3.A05());
            map.put(A00(0, 8, 27), String.valueOf(r3.A04()));
            map.put(A00(35, 5, 37), r3.A0A());
            map.put(A00(62, 10, 55), r5.A05().A02());
        }
        return map;
    }
}
