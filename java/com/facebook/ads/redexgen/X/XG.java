package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import java.util.Arrays;

public final class XG implements AnonymousClass8J {
    public static XG A05;
    public static byte[] A06;
    public static String[] A07;
    public AnonymousClass0V A00;
    public AnonymousClass8I A01;
    @Nullable
    public AnonymousClass8U A02;
    public AnonymousClass97 A03;
    @Nullable
    public QN A04;

    static {
        A07();
        A06();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[7].length()) {
                break;
            }
            String[] strArr2 = A07;
            strArr2[6] = "Hv2WK1fJh7GnXaP";
            strArr2[7] = "jwUFRNkRPBL5IaL";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            int i5 = copyOfRange[i4] - i3;
            String[] strArr3 = A07;
            if (strArr3[4].charAt(26) != strArr3[0].charAt(26)) {
                break;
            }
            String[] strArr4 = A07;
            strArr4[2] = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG";
            strArr4[3] = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw";
            copyOfRange[i4] = (byte) (i5 - 98);
            i4++;
        }
        throw new RuntimeException();
    }

    public static void A06() {
        A06 = new byte[]{-59, -57, -13, -15, -15, -57, -16, 2, 16, 16, 6, 12, 11, -67, 1, -2, 17, -2, -67, 6, 11, 6, 17, 6, -2, 9, 6, 23, 2, 1, 33, 20, 31, 30, 33, 35, 2, 20, 34, 34, 24, 30, 29, -13, 16, 35, 16, -8, 29, 24, 35, 24, 16, 27, 24, 41, 20, 19};
        if (A07[1].length() != 32) {
            String[] strArr = A07;
            strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
            strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
            return;
        }
        throw new RuntimeException();
    }

    public static void A07() {
        A07 = new String[]{"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    }

    @Nullable
    public static AnonymousClass5X A00(C0821Wi wi, @Nullable QN qn) {
        if (!J8.A13(wi) || qn == null) {
            return null;
        }
        return AnonymousClass5Y.A00().A01(qn);
    }

    public static AnonymousClass8U A01(C0821Wi wi) {
        return AnonymousClass8V.A00().A01(wi);
    }

    public static synchronized XG A02() {
        XG xg;
        String[] strArr = A07;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[2] = "yNOYv8BJbeG1jc93xecDuC4SV0M6ZsAO";
        strArr2[3] = "rgM7W1LhEjhuRpvAxAxTebmxK2ArHzjw";
        synchronized (XG.class) {
            if (A05 == null) {
                A05 = new XG();
            }
            xg = A05;
        }
        return xg;
    }

    @Nullable
    public static AbstractC0646Pm A03(C0821Wi wi) {
        if (!J8.A10(wi)) {
            return null;
        }
        return Q4.A01(wi);
    }

    @Nullable
    public static QN A04(C0821Wi wi, AnonymousClass8U r18, @Nullable AbstractC0646Pm pm) {
        String str = null;
        if (!J8.A1W(wi) || pm == null) {
            return null;
        }
        EnumC0500Js js = EnumC0500Js.A08;
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            str = AdSettings.getTestAdType().getAdTypeString();
        }
        return QO.A00().A01(r18, pm, KJ.A05(wi), new XF(new KC(wi, A05(0, 0, 122), null, js, str, 0, AdSettings.isTestMode(wi), AdSettings.isMixedAudience(), new C0505Jx(), LN.A01(J8.A0H(wi)), null, null), wi), QL.A00().A00());
    }

    public static void A08() {
        String A052 = A05(30, 28, 77);
        if (A07[5].length() != 20) {
            String[] strArr = A07;
            strArr[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
            strArr[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
            K0.A05(A052, A05(6, 24, 59), A05(0, 6, 46));
            return;
        }
        throw new RuntimeException();
    }

    public static void A09(C0821Wi wi, @Nullable AnonymousClass5X r2) {
        if (J8.A13(wi) && r2 != null) {
            AnonymousClass5V.A00().A01(r2, wi);
        }
    }

    public static void A0A(C0821Wi wi, @Nullable QN qn) {
        if (J8.A0f(wi) && qn != null) {
            new C01655s(wi, qn, new C01665t(), DynamicLoaderImpl.getBidderTokenProviderApi());
        }
    }

    public final synchronized AnonymousClass8U A0B(AnonymousClass8H r2) {
        if (this.A02 == null) {
            this.A02 = A01(r2.A00());
        }
        return this.A02;
    }

    @Nullable
    public final synchronized QN A0C() {
        return this.A04;
    }

    public final synchronized void A0D(C0821Wi wi) {
        if (this.A04 == null) {
            this.A02 = A01(wi);
            this.A04 = A04(wi, this.A02, A03(wi));
            A09(wi, A00(wi, this.A04));
            A0A(wi, this.A04);
            if (this.A04 != null) {
                this.A04.A59();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final JE A5H(C0821Wi wi) {
        return C0988bE.A01(wi);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final synchronized AnonymousClass8I A5V(AnonymousClass8H r2) {
        if (this.A01 == null) {
            this.A01 = new XD(this);
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final synchronized AbstractC02238h A5z(AnonymousClass8H r2) {
        return new C0837Wy(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final synchronized AnonymousClass8K A68(AnonymousClass8H r5) {
        XB xb;
        xb = new XB(this, r5);
        String[] strArr = A07;
        if (strArr[4].charAt(26) != strArr[0].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[1] = "2Vt1OUprKjNjnyD3";
        strArr2[1] = "2Vt1OUprKjNjnyD3";
        return xb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (com.facebook.ads.redexgen.X.XG.A07[5].length() == 20) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r2 = com.facebook.ads.redexgen.X.XG.A07;
        r2[4] = "VIV2EvMRfEPiWlvmDKty9fFKFHJul9Yn";
        r2[0] = "0wfCQdIt8NwFYvPKQ0QtM4LE4vJ9WdpV";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        throw new java.lang.RuntimeException();
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.facebook.ads.redexgen.X.AnonymousClass0V A6K(com.facebook.ads.redexgen.X.AnonymousClass8H r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = com.facebook.ads.redexgen.X.J8.A0n(r5)     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x000a
            r0 = 0
            monitor-exit(r4)
            return r0
        L_0x000a:
            com.facebook.ads.redexgen.X.0V r0 = r4.A00
            if (r0 != 0) goto L_0x001d
            com.facebook.ads.redexgen.X.0W r1 = com.facebook.ads.redexgen.X.AnonymousClass0W.A00()
            com.facebook.ads.redexgen.X.XE r0 = new com.facebook.ads.redexgen.X.XE
            r0.<init>(r4, r5)
            com.facebook.ads.redexgen.X.0V r0 = r1.A01(r0)
            r4.A00 = r0
        L_0x001d:
            com.facebook.ads.redexgen.X.0V r3 = r4.A00
            monitor-exit(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.XG.A07
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 20
            if (r1 == r0) goto L_0x003a
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.XG.A07
            java.lang.String r1 = "VIV2EvMRfEPiWlvmDKty9fFKFHJul9Yn"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "0wfCQdIt8NwFYvPKQ0QtM4LE4vJ9WdpV"
            r0 = 0
            r2[r0] = r1
            return r3
        L_0x003a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x0040:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XG.A6K(com.facebook.ads.redexgen.X.8H):com.facebook.ads.redexgen.X.0V");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final synchronized AnonymousClass8L A6r(AnonymousClass8H r2) {
        return new XC(this, r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8J
    public final synchronized AnonymousClass97 A6x() {
        if (this.A03 == null) {
            this.A03 = new AnonymousClass97();
            A08();
        }
        return this.A03;
    }
}
