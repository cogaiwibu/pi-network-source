package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;

public final class AM {
    public static String[] A0C;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public AK A04;
    public AK A05;
    public AK A06;
    public AbstractC0276Aj A07;
    public Object A08;
    public boolean A09;
    public final C0274Ah A0A = new C0274Ah();
    public final C0275Ai A0B = new C0275Ai();

    static {
        A08();
    }

    /* JADX WARNING: Error to parse debug info: 22 in method: com.facebook.ads.redexgen.X.AM.A02(int, long, long):com.facebook.ads.redexgen.X.AL, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:127)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    private AL A02(int i, long j, long j2) {
        FG fg = new FG(i, j2);
        this.A07.A0A(fg.A02, this.A0A);
        int A042 = this.A0A.A04(j);
        long A092 = A042 == -1 ? Long.MIN_VALUE : this.A0A.A09(A042);
        boolean A0B2 = A0B(fg, A092);
        return new AL(fg, j, A092, -9223372036854775807L, A092 == Long.MIN_VALUE ? this.A0A.A07() : A092, A0B2, A0C(fg, A0B2));
    }

    public static void A08() {
        A0C = new String[]{"L0u3smBC6U6OaYtXppAd31iOC3v5Qhxz", "mD", "DMmTpdJrujAgbmCwwmXMokmpSOB8XVVu", "Fa0SCWKpXCwAFqaC3HE", "LFAAfAeIJjtENyizMXbJJCIXxkMYQ2BS", "EOXOixXcPNGoqbhwUMphXmxbz6TL9K", "ydRMenJrqCbsHYuDZ17G4nGASKkEf2si", "4zZeHgY0eMzISLpxtPc37pmrQXWGSxn"};
    }

    /* JADX INFO: Multiple debug info for r0v8 int: [D('holderWindowIndex' int), D('indexOfHolderInTimeline' int)] */
    private long A00(int i) {
        int oldFrontPeriodIndex;
        Object obj = this.A07.A0B(i, this.A0A, true).A03;
        int i2 = this.A0A.A00;
        Object obj2 = this.A08;
        if (!(obj2 == null || (oldFrontPeriodIndex = this.A07.A05(obj2)) == -1 || this.A07.A0A(oldFrontPeriodIndex, this.A0A).A00 != i2)) {
            return this.A03;
        }
        for (AK A0F = A0F(); A0F != null; A0F = A0F.A01) {
            if (A0F.A09.equals(obj)) {
                return A0F.A02.A04.A03;
            }
        }
        for (AK A0F2 = A0F(); A0F2 != null; A0F2 = A0F2.A01) {
            int A052 = this.A07.A05(A0F2.A09);
            if (A052 != -1 && this.A07.A0A(A052, this.A0A).A00 == i2) {
                return A0F2.A02.A04.A03;
            }
        }
        long j = this.A02;
        this.A02 = 1 + j;
        return j;
    }

    private AL A01(int i, int i2, int i3, long durationUs, long j) {
        long j2;
        FG fg = new FG(i, i2, i3, j);
        boolean A0B2 = A0B(fg, Long.MIN_VALUE);
        boolean A0C2 = A0C(fg, A0B2);
        long A0A2 = this.A07.A0A(fg.A02, this.A0A).A0A(fg.A00, fg.A01);
        if (i3 == this.A0A.A02(i2)) {
            j2 = this.A0A.A06();
        } else {
            j2 = 0;
        }
        return new AL(fg, j2, Long.MIN_VALUE, durationUs, A0A2, A0B2, A0C2);
    }

    /* JADX INFO: Multiple debug info for r1v1 com.facebook.ads.redexgen.X.FG: [D('currentPeriodId' com.facebook.ads.redexgen.X.FG), D('nextPeriodIndex' int)] */
    @Nullable
    private AL A03(AK ak, long j) {
        long j2;
        AL al = ak.A02;
        if (al.A06) {
            int A042 = this.A07.A04(al.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            if (A042 == -1) {
                return null;
            }
            int i = this.A07.A0B(A042, this.A0A, true).A00;
            Object obj = this.A0A.A03;
            long j3 = al.A04.A03;
            if (this.A07.A0C(i, this.A0B).A00 == A042) {
                Pair<Integer, Long> A092 = this.A07.A09(this.A0B, this.A0A, i, -9223372036854775807L, Math.max(0L, (ak.A08() + al.A01) - j));
                if (A092 == null) {
                    return null;
                }
                A042 = ((Integer) A092.first).intValue();
                j2 = ((Long) A092.second).longValue();
                if (ak.A01 == null || !ak.A01.A09.equals(obj)) {
                    j3 = this.A02;
                    this.A02 = j3 + 1;
                } else {
                    j3 = ak.A01.A02.A04.A03;
                }
            } else {
                j2 = 0;
            }
            return A06(A07(A042, j2, j3), j2, j2);
        }
        FG currentPeriodId = al.A04;
        this.A07.A0A(currentPeriodId.A02, this.A0A);
        if (currentPeriodId.A02()) {
            int adGroupIndex = currentPeriodId.A00;
            int A012 = this.A0A.A01(adGroupIndex);
            if (A012 == -1) {
                return null;
            }
            int adCountInCurrentAdGroup = this.A0A.A03(adGroupIndex, currentPeriodId.A01);
            if (adCountInCurrentAdGroup >= A012) {
                return A02(currentPeriodId.A02, al.A00, currentPeriodId.A03);
            }
            if (!this.A0A.A0E(adGroupIndex, adCountInCurrentAdGroup)) {
                return null;
            }
            return A01(currentPeriodId.A02, adGroupIndex, adCountInCurrentAdGroup, al.A00, currentPeriodId.A03);
        }
        long j4 = al.A02;
        if (A0C[6].charAt(23) != 'A') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[1] = "6G";
        strArr[1] = "6G";
        if (j4 != Long.MIN_VALUE) {
            int A052 = this.A0A.A05(al.A02);
            if (A052 == -1) {
                return A02(currentPeriodId.A02, al.A02, currentPeriodId.A03);
            }
            int A022 = this.A0A.A02(A052);
            if (!this.A0A.A0E(A052, A022)) {
                return null;
            }
            return A01(currentPeriodId.A02, A052, A022, al.A02, currentPeriodId.A03);
        }
        int A002 = this.A0A.A00();
        if (A002 == 0) {
            return null;
        }
        int i2 = A002 - 1;
        if (this.A0A.A09(i2) != Long.MIN_VALUE || this.A0A.A0D(i2)) {
            return null;
        }
        int adGroupCount = this.A0A.A02(i2);
        if (!this.A0A.A0E(i2, adGroupCount)) {
            return null;
        }
        return A01(currentPeriodId.A02, i2, adGroupCount, this.A0A.A07(), currentPeriodId.A03);
    }

    private AL A04(AL al, FG fg) {
        long A072;
        long j = al.A03;
        long endPositionUs = al.A02;
        boolean A0B2 = A0B(fg, endPositionUs);
        boolean A0C2 = A0C(fg, A0B2);
        this.A07.A0A(fg.A02, this.A0A);
        if (fg.A02()) {
            A072 = this.A0A.A0A(fg.A00, fg.A01);
        } else if (A0C[2].charAt(30) != 'V') {
            throw new RuntimeException();
        } else {
            String[] strArr = A0C;
            strArr[2] = "zTzAUiYM1BrQqeObFTyCKDEgqKKR2HVC";
            strArr[2] = "zTzAUiYM1BrQqeObFTyCKDEgqKKR2HVC";
            A072 = endPositionUs == Long.MIN_VALUE ? this.A0A.A07() : endPositionUs;
        }
        return new AL(fg, j, endPositionUs, al.A00, A072, A0B2, A0C2);
    }

    private AL A05(AO ao) {
        return A06(ao.A04, ao.A01, ao.A02);
    }

    private AL A06(FG fg, long j, long j2) {
        this.A07.A0A(fg.A02, this.A0A);
        if (!fg.A02()) {
            return A02(fg.A02, j2, fg.A03);
        }
        if (!this.A0A.A0E(fg.A00, fg.A01)) {
            return null;
        }
        return A01(fg.A02, fg.A00, fg.A01, j, fg.A03);
    }

    private FG A07(int i, long j, long j2) {
        this.A07.A0A(i, this.A0A);
        int A052 = this.A0A.A05(j);
        if (A052 == -1) {
            return new FG(i, j2);
        }
        return new FG(i, A052, this.A0A.A02(A052), j2);
    }

    private boolean A09() {
        AK A0F = A0F();
        if (A0F == null) {
            return true;
        }
        while (true) {
            int A042 = this.A07.A04(A0F.A02.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            while (A0F.A01 != null && !A0F.A02.A06) {
                A0F = A0F.A01;
            }
            if (A042 == -1 || A0F.A01 == null || A0F.A01.A02.A04.A02 != A042) {
                boolean A0T = A0T(A0F);
                A0F.A02 = A04(A0F.A02, A0F.A02.A04);
            } else {
                A0F = A0F.A01;
            }
        }
        boolean A0T2 = A0T(A0F);
        A0F.A02 = A04(A0F.A02, A0F.A02.A04);
        if (!A0T2) {
            return true;
        }
        boolean A0Q = A0Q();
        if (A0C[7].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[3] = "GuDKwHudSgXHMcEdzJg";
        strArr[5] = "TrxgVcYEVqGsLQMDNrMk5TDxlvQhmk";
        if (!A0Q) {
            return true;
        }
        return false;
    }

    private boolean A0A(AK ak, AL al) {
        AL al2 = ak.A02;
        return al2.A03 == al.A03 && al2.A02 == al.A02 && al2.A04.equals(al.A04);
    }

    private boolean A0B(FG fg, long j) {
        boolean z;
        int A002 = this.A07.A0A(fg.A02, this.A0A).A00();
        if (A002 == 0) {
            return true;
        }
        int i = A002 - 1;
        boolean A022 = fg.A02();
        if (this.A0A.A09(i) == Long.MIN_VALUE) {
            int postrollAdCount = this.A0A.A01(i);
            if (postrollAdCount == -1) {
                return false;
            }
            if (A022 && fg.A00 == i && fg.A01 == postrollAdCount - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (A022 || this.A0A.A02(i) != postrollAdCount) {
                return false;
            }
            return true;
        } else if (A022 || j != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean A0C(FG fg, boolean z) {
        return !this.A07.A0C(this.A07.A0A(fg.A02, this.A0A).A00, this.A0B).A08 && this.A07.A0G(fg.A02, this.A0A, this.A0B, this.A01, this.A09) && z;
    }

    public final AK A0D() {
        AK ak = this.A05;
        if (ak != null) {
            if (ak == this.A06) {
                this.A06 = ak.A01;
            }
            this.A05.A0E();
            this.A00--;
            if (this.A00 == 0) {
                this.A04 = null;
                this.A08 = this.A05.A09;
                this.A03 = this.A05.A02.A04.A03;
            }
            this.A05 = this.A05.A01;
        } else {
            AK ak2 = this.A04;
            this.A05 = ak2;
            this.A06 = ak2;
        }
        return this.A05;
    }

    public final AK A0E() {
        AK ak = this.A06;
        I1.A04((ak == null || ak.A01 == null) ? false : true);
        if (A0C[7].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "7koWfuH1ta1EVLUWQFGgmnLKJoN2uwxl";
        strArr[0] = "1LlHzPavDhI1SmiN1gPMgWkfsuEkohyV";
        this.A06 = this.A06.A01;
        return this.A06;
    }

    public final AK A0F() {
        return A0Q() ? this.A05 : this.A04;
    }

    public final AK A0G() {
        return this.A04;
    }

    public final AK A0H() {
        return this.A05;
    }

    public final AK A0I() {
        return this.A06;
    }

    @Nullable
    public final AL A0J(long j, AO ao) {
        AK ak = this.A04;
        if (ak == null) {
            return A05(ao);
        }
        return A03(ak, j);
    }

    public final AL A0K(AL al, int i) {
        return A04(al, al.A04.A01(i));
    }

    public final AbstractC0907Zu A0L(AbstractC0270Ac[] acArr, HB hb, HE he, FI fi, Object obj, AL al) {
        long A082;
        AK ak = this.A04;
        if (ak == null) {
            A082 = al.A03;
        } else {
            A082 = ak.A08() + this.A04.A02.A01;
        }
        AK ak2 = new AK(acArr, A082, hb, he, fi, obj, al);
        if (this.A04 != null) {
            I1.A04(A0Q());
            this.A04.A01 = ak2;
        }
        this.A08 = null;
        this.A04 = ak2;
        this.A00++;
        return ak2.A08;
    }

    public final FG A0M(int i, long j) {
        return A07(i, j, A00(i));
    }

    public final void A0N(long j) {
        AK ak = this.A04;
        if (ak != null) {
            ak.A0H(j);
        }
    }

    public final void A0O(AbstractC0276Aj aj) {
        this.A07 = aj;
    }

    public final void A0P(boolean z) {
        Object obj;
        AK A0F = A0F();
        if (A0F != null) {
            if (z) {
                obj = A0F.A09;
            } else {
                obj = null;
            }
            this.A08 = obj;
            this.A03 = A0F.A02.A04.A03;
            A0F.A0E();
            A0T(A0F);
        } else if (!z) {
            this.A08 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0Q() {
        return this.A05 != null;
    }

    public final boolean A0R() {
        AK ak = this.A04;
        return ak == null || (!ak.A02.A05 && this.A04.A0I() && this.A04.A02.A01 != -9223372036854775807L && this.A00 < 100);
    }

    public final boolean A0S(int i) {
        this.A01 = i;
        return A09();
    }

    public final boolean A0T(AK ak) {
        boolean z;
        if (ak != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        boolean z2 = false;
        this.A04 = ak;
        while (ak.A01 != null) {
            ak = ak.A01;
            if (ak == this.A06) {
                this.A06 = this.A05;
                z2 = true;
            }
            ak.A0E();
            this.A00--;
        }
        this.A04.A01 = null;
        return z2;
    }

    public final boolean A0U(AbstractC0907Zu zu) {
        AK ak = this.A04;
        return ak != null && ak.A08 == zu;
    }

    public final boolean A0V(FG fg, long j) {
        int i = fg.A02;
        AK ak = null;
        for (AK A0F = A0F(); A0F != null; A0F = A0F.A01) {
            if (ak == null) {
                A0F.A02 = A0K(A0F.A02, i);
            } else {
                if (i != -1) {
                    Object obj = A0F.A09;
                    if (A0C[2].charAt(30) != 'V') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0C;
                    strArr[4] = "cRCq0i1JCmFgPvSHr0NI30IAvGtOkPUO";
                    strArr[0] = "aqPjT6JpLbsnsfh6iIpVbm4IivKwupA2";
                    if (obj.equals(this.A07.A0B(i, this.A0A, true).A03)) {
                        AL A032 = A03(ak, j);
                        if (A032 == null) {
                            return true ^ A0T(ak);
                        }
                        A0F.A02 = A0K(A0F.A02, i);
                        if (!A0A(A0F, A032)) {
                            return true ^ A0T(ak);
                        }
                    }
                }
                return true ^ A0T(ak);
            }
            if (A0F.A02.A06) {
                i = this.A07.A04(i, this.A0A, this.A0B, this.A01, this.A09);
            }
            ak = A0F;
        }
        return true;
    }

    public final boolean A0W(boolean z) {
        this.A09 = z;
        return A09();
    }
}
