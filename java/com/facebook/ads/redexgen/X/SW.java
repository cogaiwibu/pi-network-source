package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import java.util.Arrays;
import java.util.List;

public class SW extends AnonymousClass4F implements AnonymousClass4R {
    public static byte[] A0F;
    public static String[] A0G;
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AbstractC01213z A04;
    public boolean A05;
    public int A06;
    public C01173u A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C01153s A0D;
    public final C01163t A0E;

    static {
        A0X();
        A0W();
    }

    public static String A0U(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A0W() {
        A0F = new byte[]{30, 25, 1, 22, 27, 30, 19, 87, 24, 5, 30, 18, 25, 3, 22, 3, 30, 24, 25, 77};
    }

    public static void A0X() {
        A0G = new String[]{"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    }

    public SW(Context context) {
        this(context, 1, false);
    }

    public SW(Context context, int i, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C01153s(this);
        this.A0E = new C01163t();
        this.A06 = 2;
        A2F(i);
        A0j(z);
        A1W(true);
    }

    private final int A05(int scrolled, AnonymousClass4N r7, AnonymousClass4U r8) {
        int i;
        int i2;
        if (A0X() == 0 || scrolled == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2E();
        if (scrolled > 0) {
            i = 1;
        } else {
            i = -1;
        }
        int abs = Math.abs(scrolled);
        A0a(i, abs, true, r8);
        int A092 = this.A07.A07 + A09(r7, this.A07, r8, false);
        if (A092 < 0) {
            return 0;
        }
        if (abs > A092) {
            i2 = i * A092;
        } else {
            i2 = scrolled;
        }
        this.A04.A0J(-i2);
        this.A07.A04 = i2;
        return i2;
    }

    private int A06(int fixOffset, AnonymousClass4N r7, AnonymousClass4U r8, boolean z) {
        int A072 = this.A04.A07() - fixOffset;
        if (A072 <= 0) {
            return 0;
        }
        int i = -A05(-A072, r7, r8);
        int fixOffset2 = fixOffset + i;
        if (z) {
            int A073 = this.A04.A07();
            if (A0G[0].length() != 7) {
                String[] strArr = A0G;
                strArr[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                strArr[0] = "DiKLRwr5Jced9h1IWYQQBSe";
                int i2 = A073 - fixOffset2;
                if (i2 > 0) {
                    this.A04.A0J(i2);
                    return i2 + i;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return i;
    }

    private int A08(int fixOffset, AnonymousClass4N r5, AnonymousClass4U r6, boolean z) {
        int fixOffset2;
        int A0A2 = fixOffset - this.A04.A0A();
        if (A0A2 <= 0) {
            return 0;
        }
        int i = -A05(A0A2, r5, r6);
        int fixOffset3 = fixOffset + i;
        if (!z || (fixOffset2 = fixOffset3 - this.A04.A0A()) <= 0) {
            return i;
        }
        this.A04.A0J(-fixOffset2);
        return i - fixOffset2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return r7 - r11.A00;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int A09(com.facebook.ads.redexgen.X.AnonymousClass4N r10, com.facebook.ads.redexgen.X.C01173u r11, com.facebook.ads.redexgen.X.AnonymousClass4U r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.SW.A09(com.facebook.ads.redexgen.X.4N, com.facebook.ads.redexgen.X.3u, com.facebook.ads.redexgen.X.4U, boolean):int");
    }

    private int A0A(AnonymousClass4U r8) {
        if (A0X() != 0) {
            A2E();
            return AnonymousClass4Y.A00(r8, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B);
        } else if (A0G[5].length() != 31) {
            throw new RuntimeException();
        } else {
            String[] strArr = A0G;
            strArr[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
            strArr[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
            return 0;
        }
    }

    private int A0B(AnonymousClass4U r9) {
        if (A0X() == 0) {
            return 0;
        }
        A2E();
        return AnonymousClass4Y.A02(r9, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0C(AnonymousClass4U r8) {
        if (A0X() == 0) {
            String[] strArr = A0G;
            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                String[] strArr2 = A0G;
                strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
                strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
                return 0;
            }
            throw new RuntimeException();
        }
        A2E();
        return AnonymousClass4Y.A01(r8, this.A04, A0S(!this.A0B, true), A0R(!this.A0B, true), this, this.A0B);
    }

    private final int A0D(AnonymousClass4U r2) {
        if (r2.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0E() {
        return A0u(this.A05 ? 0 : A0X() - 1);
    }

    private View A0F() {
        return A0u(this.A05 ? A0X() - 1 : 0);
    }

    private final View A0G(int preferredBoundsFlag, int acceptableBoundsFlag) {
        char c;
        int i;
        int i2;
        A2E();
        if (acceptableBoundsFlag > preferredBoundsFlag) {
            c = 1;
        } else {
            c = acceptableBoundsFlag < preferredBoundsFlag ? (char) 65535 : 0;
        }
        if (c == 0) {
            View A0u = A0u(preferredBoundsFlag);
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            strArr2[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return A0u;
        }
        if (this.A04.A0F(A0u(preferredBoundsFlag)) < this.A04.A0A()) {
            i = 16644;
            i2 = 16388;
        } else {
            i = 4161;
            i2 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.A00 == 0) {
            return super.A04.A00(preferredBoundsFlag, acceptableBoundsFlag, i, i2);
        }
        return super.A05.A00(preferredBoundsFlag, acceptableBoundsFlag, i, i2);
    }

    private final View A0H(int acceptableBoundsFlag, int i, boolean z, boolean z2) {
        int i2;
        A2E();
        int i3 = 0;
        if (z) {
            i2 = 24579;
        } else {
            i2 = 320;
        }
        if (z2) {
            i3 = 320;
        }
        int i4 = this.A00;
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        if (i4 == 0) {
            return super.A04.A00(acceptableBoundsFlag, i, i2, i3);
        }
        return super.A05.A00(acceptableBoundsFlag, i, i2, i3);
    }

    private View A0I(AnonymousClass4N r3, AnonymousClass4U r4) {
        return A0G(0, A0X());
    }

    private View A0K(AnonymousClass4N r7, AnonymousClass4U r8) {
        return A2D(r7, r8, 0, A0X(), r8.A03());
    }

    private View A0L(AnonymousClass4N r3, AnonymousClass4U r4) {
        return A0G(A0X() - 1, -1);
    }

    private View A0M(AnonymousClass4N r7, AnonymousClass4U r8) {
        return A2D(r7, r8, A0X() - 1, -1, r8.A03());
    }

    private View A0N(AnonymousClass4N r2, AnonymousClass4U r3) {
        if (this.A05) {
            return A0I(r2, r3);
        }
        return A0L(r2, r3);
    }

    private View A0O(AnonymousClass4N r2, AnonymousClass4U r3) {
        if (this.A05) {
            return A0L(r2, r3);
        }
        return A0I(r2, r3);
    }

    private View A0P(AnonymousClass4N r2, AnonymousClass4U r3) {
        if (this.A05) {
            return A0K(r2, r3);
        }
        return A0M(r2, r3);
    }

    private View A0Q(AnonymousClass4N r2, AnonymousClass4U r3) {
        if (this.A05) {
            return A0M(r2, r3);
        }
        return A0K(r2, r3);
    }

    private View A0R(boolean z, boolean z2) {
        if (this.A05) {
            return A0H(0, A0X(), z, z2);
        }
        return A0H(A0X() - 1, -1, z, z2);
    }

    private View A0S(boolean z, boolean z2) {
        if (this.A05) {
            return A0H(A0X() - 1, -1, z, z2);
        }
        return A0H(0, A0X(), z, z2);
    }

    private final C01173u A0T() {
        return new C01173u();
    }

    private void A0V() {
        if (this.A00 == 1 || !A2K()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
            String[] strArr2 = A0G;
            strArr2[6] = "rvopS3hSB7itRsuyG";
            strArr2[7] = "9RTUShXs4ZXrU4n03";
            this.A05 = z;
            return;
        }
        throw new RuntimeException();
    }

    private void A0Y(int i, int i2) {
        int i3;
        this.A07.A00 = this.A04.A07() - i2;
        C01173u r1 = this.A07;
        if (this.A05) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        r1.A03 = i3;
        C01173u r12 = this.A07;
        r12.A01 = i;
        r12.A05 = 1;
        r12.A06 = i2;
        r12.A07 = Integer.MIN_VALUE;
    }

    private void A0Z(int i, int i2) {
        int i3;
        this.A07.A00 = i2 - this.A04.A0A();
        C01173u r1 = this.A07;
        r1.A01 = i;
        if (this.A05) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        r1.A03 = i3;
        C01173u r12 = this.A07;
        r12.A05 = -1;
        r12.A06 = i2;
        r12.A07 = Integer.MIN_VALUE;
    }

    private void A0a(int i, int i2, boolean z, AnonymousClass4U r9) {
        int A0A2;
        this.A07.A09 = A0k();
        this.A07.A02 = A0D(r9);
        C01173u r2 = this.A07;
        r2.A05 = i;
        int i3 = -1;
        if (i == 1) {
            r2.A02 += this.A04.A08();
            View A0E2 = A0E();
            C01173u r1 = this.A07;
            if (!this.A05) {
                i3 = 1;
            }
            r1.A03 = i3;
            this.A07.A01 = A0q(A0E2) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(A0E2);
            A0A2 = this.A04.A0C(A0E2) - this.A04.A07();
        } else {
            View A0F2 = A0F();
            this.A07.A02 += this.A04.A0A();
            C01173u r12 = this.A07;
            if (this.A05) {
                i3 = 1;
            }
            r12.A03 = i3;
            this.A07.A01 = A0q(A0F2) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(A0F2);
            A0A2 = (-this.A04.A0F(A0F2)) + this.A04.A0A();
        }
        C01173u r13 = this.A07;
        r13.A00 = i2;
        if (z) {
            r13.A00 -= A0A2;
        }
        this.A07.A07 = A0A2;
        if (A0G[0].length() != 7) {
            String[] strArr = A0G;
            strArr[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
            strArr[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
            return;
        }
        throw new RuntimeException();
    }

    private void A0b(C01153s r3) {
        A0Y(r3.A01, r3.A00);
    }

    private void A0c(C01153s r3) {
        A0Z(r3.A01, r3.A00);
    }

    private void A0d(AnonymousClass4N r6, int i) {
        int A0X = A0X();
        if (i >= 0) {
            int A062 = this.A04.A06() - i;
            if (this.A05) {
                for (int i2 = 0; i2 < A0X; i2++) {
                    View A0u = A0u(i2);
                    if (this.A04.A0F(A0u) < A062 || this.A04.A0H(A0u) < A062) {
                        A0f(r6, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = A0X - 1; i3 >= 0; i3--) {
                View A0u2 = A0u(i3);
                if (this.A04.A0F(A0u2) < A062 || this.A04.A0H(A0u2) < A062) {
                    A0f(r6, A0X - 1, i3);
                    return;
                }
            }
        }
    }

    private void A0e(AnonymousClass4N r8, int i) {
        if (i >= 0) {
            String[] strArr = A0G;
            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                String[] strArr2 = A0G;
                strArr2[0] = "66";
                strArr2[0] = "66";
                int A0X = A0X();
                if (this.A05) {
                    for (int i2 = A0X - 1; i2 >= 0; i2--) {
                        View A0u = A0u(i2);
                        if (this.A04.A0C(A0u) <= i) {
                            AbstractC01213z r5 = this.A04;
                            String[] strArr3 = A0G;
                            if (strArr3[6].length() == strArr3[7].length()) {
                                String[] strArr4 = A0G;
                                strArr4[3] = "uDZbJl3GZvnd0";
                                strArr4[3] = "uDZbJl3GZvnd0";
                                if (r5.A0G(A0u) > i) {
                                }
                            } else if (r5.A0G(A0u) > i) {
                            }
                        }
                        A0f(r8, A0X - 1, i2);
                        return;
                    }
                    return;
                }
                for (int i3 = 0; i3 < A0X; i3++) {
                    View A0u2 = A0u(i3);
                    int A0C2 = this.A04.A0C(A0u2);
                    if (A0G[3].length() != 28) {
                        String[] strArr5 = A0G;
                        strArr5[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
                        strArr5[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
                        if (A0C2 > i || this.A04.A0G(A0u2) > i) {
                            A0f(r8, 0, i3);
                            return;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0f(AnonymousClass4N r2, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    A15(i3, r2);
                }
                return;
            }
            while (i > i2) {
                A15(i, r2);
                i--;
            }
        }
    }

    private void A0g(AnonymousClass4N r5, C01173u r6) {
        if (r6.A0B && !r6.A09) {
            int i = r6.A05;
            String[] strArr = A0G;
            if (strArr[6].length() == strArr[7].length()) {
                String[] strArr2 = A0G;
                strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
                strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
                if (i == -1) {
                    int i2 = r6.A07;
                    if (A0G[1].charAt(30) == 'o') {
                        String[] strArr3 = A0G;
                        strArr3[3] = "CiNTyTfZO3PW6tP";
                        strArr3[3] = "CiNTyTfZO3PW6tP";
                        A0d(r5, i2);
                        return;
                    }
                } else {
                    A0e(r5, r6.A07);
                    return;
                }
            }
            throw new RuntimeException();
        }
    }

    private void A0h(AnonymousClass4N r14, AnonymousClass4U r15, int scrapExtraEnd, int scrapExtraEnd2) {
        boolean z;
        if (r15.A08() && A0X() != 0 && !r15.A07() && A27()) {
            int direction = 0;
            int i = 0;
            List<AnonymousClass4X> A0K = r14.A0K();
            int size = A0K.size();
            int A0q = A0q(A0u(0));
            for (int i2 = 0; i2 < size; i2++) {
                AnonymousClass4X r11 = A0K.get(i2);
                if (!r11.A0d()) {
                    char c = 1;
                    if (r11.A0J() < A0q) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.A05) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        direction += this.A04.A0D(r11.A0H);
                    } else {
                        i += this.A04.A0D(r11.A0H);
                    }
                }
            }
            this.A07.A08 = A0K;
            if (direction > 0) {
                A0Z(A0q(A0F()), scrapExtraEnd);
                C01173u r0 = this.A07;
                r0.A02 = direction;
                r0.A00 = 0;
                r0.A04();
                A09(r14, this.A07, r15, false);
            }
            if (i > 0) {
                A0Y(A0q(A0E()), scrapExtraEnd2);
                C01173u r02 = this.A07;
                r02.A02 = i;
                r02.A00 = 0;
                r02.A04();
                A09(r14, this.A07, r15, false);
            }
            this.A07.A08 = null;
        }
    }

    private void A0i(AnonymousClass4N r5, AnonymousClass4U r6, C01153s r7) {
        int i;
        if (!A0m(r6, r7)) {
            boolean A0l = A0l(r5, r6, r7);
            String[] strArr = A0G;
            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                String[] strArr2 = A0G;
                strArr2[3] = "XDJ2jDWhUW9a7iN";
                strArr2[3] = "XDJ2jDWhUW9a7iN";
                if (!A0l) {
                    r7.A02();
                    if (this.A0C) {
                        i = r6.A03() - 1;
                    } else {
                        i = 0;
                    }
                    r7.A01 = i;
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    private final void A0j(boolean z) {
        A23(null);
        if (z != this.A0A) {
            this.A0A = z;
            A0z();
        }
    }

    private final boolean A0k() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0l(AnonymousClass4N r6, AnonymousClass4U r7, C01153s r8) {
        View A0Q;
        int A0A2;
        boolean z = false;
        if (A0X() == 0) {
            return false;
        }
        View A0t = A0t();
        if (A0t != null && r8.A06(A0t, r7)) {
            r8.A05(A0t);
            return true;
        } else if (this.A08 != this.A0C) {
            return false;
        } else {
            if (r8.A02) {
                A0Q = A0P(r6, r7);
            } else {
                A0Q = A0Q(r6, r7);
            }
            if (A0Q == null) {
                return false;
            }
            r8.A04(A0Q);
            if (!r7.A07() && A27()) {
                if (this.A04.A0F(A0Q) >= this.A04.A07() || this.A04.A0C(A0Q) < this.A04.A0A()) {
                    z = true;
                }
                if (z) {
                    if (r8.A02) {
                        A0A2 = this.A04.A07();
                    } else {
                        A0A2 = this.A04.A0A();
                    }
                    r8.A00 = A0A2;
                }
            }
            return true;
        }
    }

    private boolean A0m(AnonymousClass4U r8, C01153s r9) {
        int i;
        int A0F2;
        boolean z = false;
        if (r8.A07() || (i = this.A01) == -1) {
            return false;
        }
        if (i < 0 || i >= r8.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        r9.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            r9.A02 = this.A03.A02;
            if (r9.A02) {
                r9.A00 = this.A04.A07() - this.A03.A00;
            } else {
                r9.A00 = this.A04.A0A() + this.A03.A00;
            }
            return true;
        } else if (this.A02 == Integer.MIN_VALUE) {
            View A1r = A1r(this.A01);
            if (A1r == null) {
                if (A0X() > 0) {
                    boolean z2 = this.A01 < A0q(A0u(0));
                    boolean z3 = this.A05;
                    if (A0G[1].charAt(30) != 'o') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0G;
                    strArr[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                    strArr[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                    if (z2 == z3) {
                        z = true;
                    }
                    r9.A02 = z;
                }
                r9.A02();
            } else if (this.A04.A0D(A1r) > this.A04.A0B()) {
                r9.A02();
                return true;
            } else if (this.A04.A0F(A1r) - this.A04.A0A() < 0) {
                r9.A00 = this.A04.A0A();
                r9.A02 = false;
                return true;
            } else if (this.A04.A07() - this.A04.A0C(A1r) < 0) {
                r9.A00 = this.A04.A07();
                r9.A02 = true;
                return true;
            } else {
                if (r9.A02) {
                    int A0C2 = this.A04.A0C(A1r);
                    AbstractC01213z r5 = this.A04;
                    String[] strArr2 = A0G;
                    if (strArr2[2].charAt(4) != strArr2[4].charAt(4)) {
                        String[] strArr3 = A0G;
                        strArr3[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        strArr3[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                        A0F2 = A0C2 + r5.A05();
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    A0F2 = this.A04.A0F(A1r);
                }
                r9.A00 = A0F2;
            }
            return true;
        } else {
            boolean z4 = this.A05;
            r9.A02 = z4;
            if (z4) {
                r9.A00 = this.A04.A07() - this.A02;
            } else {
                r9.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public int A1i(int i, AnonymousClass4N r4, AnonymousClass4U r5) {
        if (this.A00 == 1) {
            return 0;
        }
        return A05(i, r4, r5);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public int A1j(int i, AnonymousClass4N r6, AnonymousClass4U r7) {
        if (this.A00 == 0) {
            return 0;
        }
        int A052 = A05(i, r6, r7);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[3] = "CDnF1shpb";
        strArr2[3] = "CDnF1shpb";
        return A052;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1k(AnonymousClass4U r2) {
        return A0A(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1l(AnonymousClass4U r2) {
        return A0B(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1m(AnonymousClass4U r2) {
        return A0C(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1n(AnonymousClass4U r2) {
        return A0A(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1o(AnonymousClass4U r2) {
        return A0B(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final int A1p(AnonymousClass4U r2) {
        return A0C(r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final Parcelable A1q() {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            return new LinearLayoutManager$SavedState(linearLayoutManager$SavedState);
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState2 = new LinearLayoutManager$SavedState();
        if (A0X() > 0) {
            A2E();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState2.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View A0E2 = A0E();
                linearLayoutManager$SavedState2.A00 = this.A04.A07() - this.A04.A0C(A0E2);
                linearLayoutManager$SavedState2.A01 = A0q(A0E2);
            } else {
                View A0F2 = A0F();
                linearLayoutManager$SavedState2.A01 = A0q(A0F2);
                linearLayoutManager$SavedState2.A00 = this.A04.A0F(A0F2) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState2.A00();
        }
        return linearLayoutManager$SavedState2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    @Nullable
    public final View A1r(int firstChild) {
        int viewPosition = A0X();
        if (viewPosition == 0) {
            return null;
        }
        int A0q = firstChild - A0q(A0u(0));
        if (A0q >= 0 && A0q < viewPosition) {
            View A0u = A0u(A0q);
            if (A0q(A0u) == firstChild) {
                return A0u;
            }
        }
        return super.A1r(firstChild);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public View A1s(View view, int i, AnonymousClass4N r10, AnonymousClass4U r11) {
        int A2C;
        View A0N;
        View A0E2;
        A0V();
        if (A0X() == 0 || (A2C = A2C(i)) == Integer.MIN_VALUE) {
            return null;
        }
        A2E();
        A2E();
        A0a(A2C, (int) (((float) this.A04.A0B()) * 0.33333334f), false, r11);
        C01173u r1 = this.A07;
        r1.A07 = Integer.MIN_VALUE;
        r1.A0B = false;
        A09(r10, r1, r11, true);
        if (A2C == -1) {
            A0N = A0O(r10, r11);
        } else {
            A0N = A0N(r10, r11);
        }
        if (A2C == -1) {
            A0E2 = A0F();
        } else {
            A0E2 = A0E();
        }
        boolean hasFocusable = A0E2.hasFocusable();
        if (A0G[0].length() != 7) {
            String[] strArr = A0G;
            strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
            strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
            if (!hasFocusable) {
                return A0N;
            }
            if (A0N == null) {
                return null;
            }
            return A0E2;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public AnonymousClass4G A1t() {
        return new AnonymousClass4G(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public void A1u(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0z();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A1v(int i, int i2, AnonymousClass4U r6, AnonymousClass4D r7) {
        int i3;
        if (this.A00 != 0) {
            i = i2;
        }
        if (A0X() != 0 && i != 0) {
            A2E();
            if (i > 0) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            A0a(i3, Math.abs(i), true, r6);
            A2J(r6, this.A07, r7);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A1w(int i, AnonymousClass4D r9) {
        boolean z;
        int i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        int i3 = -1;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            A0V();
            z = this.A05;
            int i4 = this.A01;
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[1] = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM";
            strArr2[1] = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM";
            if (i4 == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.A01;
            }
        } else {
            z = this.A03.A02;
            i2 = this.A03.A01;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i5 = 0; i5 < this.A06 && i2 >= 0 && i2 < i; i5++) {
            r9.A3J(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A1x(Parcelable parcelable) {
        if (parcelable instanceof LinearLayoutManager$SavedState) {
            this.A03 = (LinearLayoutManager$SavedState) parcelable;
            A0z();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A1y(AccessibilityEvent accessibilityEvent) {
        super.A1y(accessibilityEvent);
        if (A0X() > 0) {
            accessibilityEvent.setFromIndex(A29());
            int A2A = A2A();
            if (A0G[3].length() != 28) {
                String[] strArr = A0G;
                strArr[3] = "9E5bhv9RVKulu";
                strArr[3] = "9E5bhv9RVKulu";
                accessibilityEvent.setToIndex(A2A);
                return;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r8 != -1) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x023b, code lost:
        if (r8 != -1) goto L_0x00b0;
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A1z(com.facebook.ads.redexgen.X.AnonymousClass4N r10, com.facebook.ads.redexgen.X.AnonymousClass4U r11) {
        /*
        // Method dump skipped, instructions count: 622
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.SW.A1z(com.facebook.ads.redexgen.X.4N, com.facebook.ads.redexgen.X.4U):void");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public void A20(AnonymousClass4U r2) {
        super.A20(r2);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A21(ES es, AnonymousClass4N r3) {
        super.A21(es, r3);
        if (this.A09) {
            A1J(r3);
            r3.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public void A22(ES es, AnonymousClass4U r4, int i) {
        SX sx = new SX(es.getContext());
        sx.A0B(i);
        A1M(sx);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final void A23(String str) {
        if (this.A03 == null) {
            super.A23(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final boolean A24() {
        if (!(A0Z() == 1073741824 || A0j() == 1073741824)) {
            boolean A1X = A1X();
            if (A0G[0].length() != 7) {
                String[] strArr = A0G;
                strArr[0] = "ZYU5Lu8KJdo1W8";
                strArr[0] = "ZYU5Lu8KJdo1W8";
                if (A1X) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final boolean A25() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public final boolean A26() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4F
    public boolean A27() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A28() {
        View A0H = A0H(0, A0X(), true, false);
        if (A0H == null) {
            return -1;
        }
        return A0q(A0H);
    }

    public final int A29() {
        View A0H = A0H(0, A0X(), false, true);
        if (A0H == null) {
            return -1;
        }
        return A0q(A0H);
    }

    public final int A2A() {
        View A0H = A0H(A0X() - 1, -1, false, true);
        if (A0H == null) {
            return -1;
        }
        return A0q(A0H);
    }

    public final int A2B() {
        return this.A00;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e9 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int A2C(int r8) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.SW.A2C(int):int");
    }

    public View A2D(AnonymousClass4N r8, AnonymousClass4U r9, int boundsEnd, int i, int i2) {
        int i3;
        A2E();
        View view = null;
        View view2 = null;
        int A0A2 = this.A04.A0A();
        int A072 = this.A04.A07();
        if (i > boundsEnd) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        while (boundsEnd != i) {
            View A0u = A0u(boundsEnd);
            int A0q = A0q(A0u);
            if (A0q >= 0 && A0q < i2) {
                if (((AnonymousClass4G) A0u.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = A0u;
                    }
                } else if (this.A04.A0F(A0u) < A072 && this.A04.A0C(A0u) >= A0A2) {
                    return A0u;
                } else {
                    if (view2 == null) {
                        view2 = A0u;
                    }
                }
            }
            boundsEnd += i3;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2E() {
        if (this.A07 == null) {
            this.A07 = A0T();
        }
        if (this.A04 == null) {
            this.A04 = AbstractC01213z.A02(this, this.A00);
        }
    }

    public final void A2F(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(A0U(0, 20, 1) + i);
        } else if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        } else {
            String[] strArr = A0G;
            strArr[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
            strArr[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
            A23(null);
            if (i != this.A00) {
                this.A00 = i;
                this.A04 = null;
                A0z();
            }
        }
    }

    public final void A2G(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0z();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[3] = "tDl3kZGUKMTs";
        strArr[3] = "tDl3kZGUKMTs";
    }

    public void A2H(AnonymousClass4N r1, AnonymousClass4U r2, C01153s r3, int i) {
    }

    public void A2I(AnonymousClass4N r15, AnonymousClass4U r16, C01173u r17, C01163t r18) {
        int top;
        int A0h;
        int A0E2;
        int i;
        int i2;
        int top2;
        View A032 = r17.A03(r15);
        if (A032 == null) {
            r18.A01 = true;
            return;
        }
        AnonymousClass4G r2 = (AnonymousClass4G) A032.getLayoutParams();
        if (r17.A08 == null) {
            boolean z = this.A05;
            if (r17.A05 == -1) {
                top2 = 1;
            } else {
                top2 = 0;
            }
            if (z == top2) {
                A18(A032);
            } else {
                A1A(A032, 0);
            }
        } else {
            boolean z2 = this.A05;
            if (r17.A05 == -1) {
                top = 1;
            } else {
                top = 0;
            }
            if (z2 == top) {
                A17(A032);
            } else {
                A19(A032, 0);
            }
        }
        A1B(A032, 0, 0);
        r18.A00 = this.A04.A0D(A032);
        if (this.A00 == 1) {
            if (A2K()) {
                i2 = A0i() - A0g();
                i = i2 - this.A04.A0E(A032);
            } else {
                i = A0f();
                i2 = this.A04.A0E(A032) + i;
            }
            if (r17.A05 == -1) {
                A0E2 = r17.A06;
                A0h = r17.A06 - r18.A00;
            } else {
                A0h = r17.A06;
                A0E2 = r17.A06 + r18.A00;
            }
        } else {
            A0h = A0h();
            A0E2 = this.A04.A0E(A032) + A0h;
            if (r17.A05 == -1) {
                i2 = r17.A06;
                i = r17.A06 - r18.A00;
            } else {
                i = r17.A06;
                i2 = r17.A06 + r18.A00;
            }
        }
        A1C(A032, i, A0h, i2, A0E2);
        if (r2.A02() || r2.A01()) {
            r18.A03 = true;
        }
        r18.A02 = A032.hasFocusable();
    }

    public void A2J(AnonymousClass4U r4, C01173u r5, AnonymousClass4D r6) {
        int i = r5.A01;
        if (i >= 0 && i < r4.A03()) {
            r6.A3J(i, Math.max(0, r5.A07));
        }
    }

    public final boolean A2K() {
        return A0b() == 1;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4R
    public final PointF A45(int firstChildPos) {
        if (A0X() == 0) {
            return null;
        }
        boolean z = false;
        int i = 1;
        if (firstChildPos < A0q(A0u(0))) {
            z = true;
        }
        if (z != this.A05) {
            i = -1;
        }
        int i2 = this.A00;
        if (A0G[0].length() != 7) {
            String[] strArr = A0G;
            strArr[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
            strArr[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
            if (i2 == 0) {
                return new PointF((float) i, 0.0f);
            }
            return new PointF(0.0f, (float) i);
        }
        throw new RuntimeException();
    }
}
