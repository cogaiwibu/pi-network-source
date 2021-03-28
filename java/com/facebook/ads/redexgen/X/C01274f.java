package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.4f  reason: invalid class name and case insensitive filesystem */
public final class C01274f {
    public static byte[] A02;
    public static String[] A03;
    @VisibleForTesting
    public final S9<AnonymousClass4X, C01254d> A00 = new S9<>();
    @VisibleForTesting
    public final AnonymousClass2J<AnonymousClass4X> A01 = new AnonymousClass2J<>();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 71);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-99, -59, -61, -60, 112, -64, -62, -65, -58, -71, -76, -75, 112, -74, -68, -79, -73, 112, -96, -94, -107, 112, -65, -62, 112, -96, -97, -93, -92};
    }

    public static void A03() {
        A03 = new String[]{"WXpxlTya5H7kpLIT7UUfzIgXOYds4Vfk", "JVDNa5tAOP", "C1CZfaM4quGDjTOWU4x6KBGTC5pPu33J", "VymAVHyd", "K8p7KG0zsDoAf7GmBTiUCUpdPzk9iS4o", "MydLOSuorekD0WEADrXIrTB2aFx1Ufvf", "1zIVUT6Fxq52O6VZbnoN9TsXnO1jN3fj", "z9Q03TMU5lxkReREt3I6AE4mCa6N3G46"};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0073, code lost:
        if ((r6 & 12) == 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        if ((r6 & 12) == 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c8, code lost:
        if (r5 != 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        if (r5 != 0) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.redexgen.X.AnonymousClass4A A00(com.facebook.ads.redexgen.X.AnonymousClass4X r8, int r9) {
        /*
        // Method dump skipped, instructions count: 226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01274f.A00(com.facebook.ads.redexgen.X.4X, int):com.facebook.ads.redexgen.X.4A");
    }

    @Nullable
    public final AnonymousClass4A A04(AnonymousClass4X r2) {
        return A00(r2, 8);
    }

    @Nullable
    public final AnonymousClass4A A05(AnonymousClass4X r2) {
        return A00(r2, 4);
    }

    public final AnonymousClass4X A06(long j) {
        return this.A01.A08(j);
    }

    public final void A07() {
        this.A00.clear();
        this.A01.A09();
    }

    public final void A08() {
        C01254d.A01();
    }

    public final void A09(long j, AnonymousClass4X r4) {
        this.A01.A0B(j, r4);
    }

    public final void A0A(AnonymousClass4X r3) {
        C01254d r1 = this.A00.get(r3);
        if (r1 == null) {
            r1 = C01254d.A00();
            this.A00.put(r3, r1);
        }
        r1.A00 |= 1;
    }

    public final void A0B(AnonymousClass4X r3) {
        C01254d r1 = this.A00.get(r3);
        if (r1 != null) {
            r1.A00 &= -2;
        }
    }

    public final void A0C(AnonymousClass4X r3) {
        int A06 = this.A01.A06() - 1;
        while (true) {
            if (A06 < 0) {
                break;
            } else if (r3 == this.A01.A07(A06)) {
                this.A01.A0A(A06);
                break;
            } else {
                A06--;
            }
        }
        C01254d remove = this.A00.remove(r3);
        if (remove != null) {
            C01254d.A02(remove);
        }
    }

    public final void A0D(AnonymousClass4X r1) {
        A0B(r1);
    }

    public final void A0E(AnonymousClass4X r3, AnonymousClass4A r4) {
        C01254d r1 = this.A00.get(r3);
        if (r1 == null) {
            r1 = C01254d.A00();
            this.A00.put(r3, r1);
        }
        r1.A00 |= 2;
        r1.A02 = r4;
    }

    public final void A0F(AnonymousClass4X r3, AnonymousClass4A r4) {
        C01254d r1 = this.A00.get(r3);
        if (r1 == null) {
            r1 = C01254d.A00();
            this.A00.put(r3, r1);
        }
        r1.A01 = r4;
        r1.A00 |= 8;
    }

    public final void A0G(AnonymousClass4X r3, AnonymousClass4A r4) {
        C01254d r1 = this.A00.get(r3);
        if (r1 == null) {
            r1 = C01254d.A00();
            this.A00.put(r3, r1);
        }
        r1.A02 = r4;
        r1.A00 |= 4;
    }

    public final void A0H(AbstractC01264e r9) {
        for (int size = this.A00.size() - 1; size >= 0; size--) {
            AnonymousClass4X A0A = this.A00.A0A(size);
            C01254d A0B = this.A00.A0B(size);
            if ((A0B.A00 & 3) == 3) {
                r9.ADd(A0A);
            } else if ((A0B.A00 & 1) != 0) {
                if (A0B.A02 == null) {
                    r9.ADd(A0A);
                } else {
                    AnonymousClass4A r7 = A0B.A02;
                    AnonymousClass4A r6 = A0B.A01;
                    if (A03[5].charAt(20) != 'R') {
                        String[] strArr = A03;
                        strArr[1] = "fJVAe19tdP";
                        strArr[3] = "3fJsXDGb";
                        r9.ABp(A0A, r7, r6);
                    } else {
                        throw new RuntimeException();
                    }
                }
            } else if ((A0B.A00 & 14) == 14) {
                r9.ABn(A0A, A0B.A02, A0B.A01);
            } else if ((A0B.A00 & 12) == 12) {
                r9.ABr(A0A, A0B.A02, A0B.A01);
            } else if ((A0B.A00 & 4) != 0) {
                r9.ABp(A0A, A0B.A02, null);
            } else if ((A0B.A00 & 8) != 0) {
                r9.ABn(A0A, A0B.A02, A0B.A01);
            }
            C01254d.A02(A0B);
        }
    }

    public final boolean A0I(AnonymousClass4X r3) {
        C01254d r0 = this.A00.get(r3);
        return (r0 == null || (r0.A00 & 1) == 0) ? false : true;
    }

    public final boolean A0J(AnonymousClass4X r2) {
        C01254d r0 = this.A00.get(r2);
        return (r0 == null || (r0.A00 & 4) == 0) ? false : true;
    }
}
