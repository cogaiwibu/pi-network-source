package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.5f  reason: invalid class name and case insensitive filesystem */
public final class C01535f {
    public static byte[] A00;
    public static String[] A01;
    public static final AtomicReference<C01515d> A02 = new AtomicReference<>();
    public static final AtomicReference<String> A03 = new AtomicReference<>(A04(0, 0, 68));

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 52);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-98, -90, -95, -100, -84, -77, -94, -81, -81, -90, -95, -94, -95, -97, -88, -97, -84, -93, -99, -20, -25, -23, -28, -30, -14, -7, -24, -11, -11, -20, -25, -24};
    }

    public static void A06() {
        A01 = new String[]{"zJ7sRo3sU3MwvYkxVq5sKXU", "uwqdBBQkb", "sk1pAaPClwmr1DZFuM4XEVJDjMgj4luU", "2DEAuAVf", "LM1sVeBw6DNfIdZzIYsj5hqYQDPEhJFy", "hYSBjzGCwuKpFZFqojmwIwdxMJLMCyYz", "BWOi5Qn34m6VEGTMmYfzcDYeX0GTjOOy", "rscTiGR64sMWr7IEiXLU0M2EjoTwZlLg"};
    }

    static {
        A06();
        A05();
    }

    public static C01515d A00() {
        C01515d r3 = A02.get();
        if (A01[6].charAt(15) == 'M') {
            String[] strArr = A01;
            strArr[3] = "GQnQs3ZS";
            strArr[1] = "yTwJu7KeR";
            C01515d r32 = r3;
            if (r32 != null) {
                return r32;
            }
            C01515d A002 = C01515d.A00();
            String[] strArr2 = A01;
            if (strArr2[3].length() != strArr2[1].length()) {
                String[] strArr3 = A01;
                strArr3[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                strArr3[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                return A002;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L_0x000c;
     */
    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.redexgen.X.C01515d A01(com.facebook.ads.redexgen.X.AnonymousClass8H r5, com.facebook.ads.redexgen.X.C01515d r6) {
        /*
            if (r6 == 0) goto L_0x000c
            java.lang.String r0 = r6.A03()     // Catch:{ all -> 0x0011 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0028
        L_0x000c:
            com.facebook.ads.redexgen.X.5d r0 = com.facebook.ads.redexgen.X.C01585l.A00(r5)     // Catch:{ all -> 0x0011 }
            return r0
        L_0x0011:
            r0 = move-exception
            com.facebook.ads.redexgen.X.8h r5 = r5.A04()
            int r4 = com.facebook.ads.redexgen.X.C02248i.A18
            com.facebook.ads.redexgen.X.8j r3 = new com.facebook.ads.redexgen.X.8j
            r3.<init>(r0)
            r2 = 12
            r1 = 7
            r0 = 6
            java.lang.String r0 = A04(r2, r1, r0)
            r5.A82(r0, r4, r3)
        L_0x0028:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01535f.A01(com.facebook.ads.redexgen.X.8H, com.facebook.ads.redexgen.X.5d):com.facebook.ads.redexgen.X.5d");
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static C01515d A02(AnonymousClass8H r6, C01515d r7, C01525e r8) {
        C01545g r5 = null;
        try {
            if (J7.A07(r6) && (r7 == null || TextUtils.isEmpty(r7.A03()))) {
                r5 = C01555h.A00(r6.getContentResolver());
            }
        } catch (Throwable th) {
            r6.A04().A82(A04(12, 7, 6), C02248i.A1A, new C02258j(th));
        }
        if (!(r5 == null || r5.A01 == null)) {
            A03.set(r5.A01);
            r8.A05(r5.A01);
        }
        if (r7 != null || r5 == null || TextUtils.isEmpty(r5.A00)) {
            return r7;
        }
        return new C01515d(r5.A00, r5.A02, EnumC01505c.A05);
    }

    public static String A03() {
        String attributionId = A03.get();
        if (attributionId == null) {
            return A04(0, 0, 68);
        }
        return attributionId;
    }

    public static void A07(C01525e r2) {
        A02.set(r2.A02());
        A03.set(r2.A03());
    }

    /* JADX INFO: Multiple debug info for r8v0 com.facebook.ads.redexgen.X.8H: [D('attributionStorage' com.facebook.ads.redexgen.X.5e), D('t' java.lang.Throwable)] */
    @SuppressLint({"CatchGeneralException"})
    public static void A08(AnonymousClass8H r8) {
        long j;
        C01515d upToDateAdInfo;
        try {
            C01525e r5 = new C01525e(r8);
            A07(r5);
            if (!A09()) {
                C01515d r1 = A02.get();
                if (r1 == null || TextUtils.isEmpty(r1.A03())) {
                    j = -1;
                } else {
                    j = r1.A01();
                }
                if (j <= 0 || System.currentTimeMillis() - j >= J7.A00(r8)) {
                    if (J7.A08(r8)) {
                        upToDateAdInfo = A01(r8, A02(r8, null, r5));
                    } else {
                        upToDateAdInfo = A02(r8, A01(r8, null), r5);
                    }
                    if (upToDateAdInfo != null && !TextUtils.isEmpty(upToDateAdInfo.A03())) {
                        A02.set(upToDateAdInfo);
                        r5.A04(upToDateAdInfo);
                    }
                }
            }
        } catch (Throwable th) {
            r8.A04().A82(A04(12, 7, 6), C02248i.A19, new C02258j(th));
        }
    }

    public static boolean A09() {
        boolean updated = false;
        if (C0528Kx.A04()) {
            if (A01[0].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "OqjdKmMb";
            strArr[1] = "Sbvi0a9C0";
            String A04 = A04(0, 12, 9);
            if (C0528Kx.A05(A04)) {
                A03.set(C0528Kx.A01(A04));
                updated = true;
            }
        }
        boolean A042 = C0528Kx.A04();
        String[] strArr2 = A01;
        if (strArr2[5].charAt(29) != strArr2[4].charAt(29)) {
            String[] strArr3 = A01;
            strArr3[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            strArr3[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            if (!A042) {
                return updated;
            }
        } else {
            String[] strArr4 = A01;
            strArr4[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            strArr4[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            if (!A042) {
                return updated;
            }
        }
        String A043 = A04(19, 13, 79);
        if (!C0528Kx.A05(A043)) {
            return updated;
        }
        String A012 = C0528Kx.A01(A043);
        AtomicReference<C01515d> atomicReference = A02;
        if (A012 == null) {
            A012 = A04(0, 0, 68);
        }
        atomicReference.set(new C01515d(A012, false, EnumC01505c.A04));
        return true;
    }
}
