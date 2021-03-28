package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GN {
    public static byte[] A0M;
    public static String[] A0N;
    public static final int A0O = A01(0, 0, 0, 0);
    public static final int A0P = A01(2, 2, 2, 0);
    public static final int A0Q = A01(0, 0, 0, 3);
    public static final int[] A0R;
    public static final int[] A0S = {0, 0, 0, 0, 0, 3, 3};
    public static final int[] A0T = {0, 1, 2, 3, 4, 3, 4};
    public static final int[] A0U;
    public static final int[] A0V = {0, 0, 0, 0, 0, 2, 0};
    public static final int[] A0W = {0, 0, 0, 0, 0, 0, 2};
    public static final int[] A0X = {3, 3, 3, 3, 3, 3, 1};
    public static final boolean[] A0Y = {false, false, false, true, true, true, false};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final SpannableStringBuilder A0K = new SpannableStringBuilder();
    public final List<SpannableString> A0L = new ArrayList();

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] ^ i3) ^ 47;
            String[] strArr = A0N;
            if (strArr[1].charAt(25) != strArr[0].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[7] = "EGk9np7aMhyDNRiub589ymbWmiZaYsnv";
            strArr2[5] = "MoHjhkGHxknM09OundQuhqQ3IVB6xBhn";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0M = new byte[]{87, 108, 103, 122, 114, 103, 97, 118, 103, 102, 34, 104, 119, 113, 118, 107, 100, 107, 97, 99, 118, 107, 109, 108, 34, 116, 99, 110, 119, 103, 56, 34};
    }

    public static void A05() {
        A0N = new String[]{"GlVHckn51Vanl7Vih5Esv8zIqIMxBgkG", "Gu0mdIpKDUd91D8731Vgkf2rQInnPX0q", "LYxm1SmSDrFGckkqyRDu581qL7t4zqdr", "wLzi90m5JnQ3vlsc62fZXtuMGM726oCo", "LMTGU1aow53O5naV", "g0ywSDs0rh9PJAouvJPa5HkBHtmUXg07", "15rANKJrnjVxjOAN", "gGGCjWA2OtQnSQFuntVJeMpfRqk0w0Oj"};
    }

    static {
        A05();
        A04();
        int i = A0O;
        int i2 = A0Q;
        A0U = new int[]{i, i2, i, i, i2, i, i};
        A0R = new int[]{i, i, i, i, i, i2, i2};
    }

    public GN() {
        A09();
    }

    public static int A00(int i, int i2, int i3) {
        return A01(i, i2, i3, 0);
    }

    public static int A01(int i, int i2, int alpha, int i3) {
        int i4;
        int i5 = 0;
        I1.A00(i, 0, 4);
        I1.A00(i2, 0, 4);
        I1.A00(alpha, 0, 4);
        I1.A00(i3, 0, 4);
        if (i3 == 0 || i3 == 1) {
            i4 = 255;
        } else if (i3 == 2) {
            i4 = 127;
        } else if (i3 != 3) {
            i4 = 255;
        } else {
            i4 = 0;
        }
        int i6 = i > 1 ? 255 : 0;
        int i7 = i2 > 1 ? 255 : 0;
        if (alpha > 1) {
            i5 = 255;
        }
        return Color.argb(i4, i6, i7, i5);
    }

    private final SpannableString A02() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A0K);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.A06 != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.A06, length, 33);
            }
            if (this.A0C != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.A0C, length, 33);
            }
            if (this.A04 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.A03), this.A04, length, 33);
            }
            if (this.A02 != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.A01), this.A02, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.ads.redexgen.X.C0926aD A06() {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GN.A06():com.facebook.ads.redexgen.X.aD");
    }

    public final void A07() {
        int length = this.A0K.length();
        if (length > 0) {
            this.A0K.delete(length - 1, length);
        }
    }

    public final void A08() {
        this.A0L.clear();
        this.A0K.clear();
        this.A06 = -1;
        this.A0C = -1;
        this.A04 = -1;
        this.A02 = -1;
        this.A0A = 0;
    }

    public final void A09() {
        A08();
        this.A0G = false;
        this.A0J = false;
        this.A09 = 4;
        this.A0H = false;
        this.A0D = 0;
        this.A05 = 0;
        this.A00 = 0;
        this.A0B = 15;
        this.A0I = true;
        this.A07 = 0;
        this.A0F = 0;
        this.A08 = 0;
        int i = A0O;
        this.A0E = i;
        this.A03 = A0P;
        this.A01 = i;
    }

    public final void A0A(char c) {
        if (c == '\n') {
            this.A0L.add(A02());
            this.A0K.clear();
            if (this.A06 != -1) {
                this.A06 = 0;
            }
            if (this.A0C != -1) {
                this.A0C = 0;
            }
            if (this.A04 != -1) {
                this.A04 = 0;
            }
            if (this.A02 != -1) {
                this.A02 = 0;
            }
            while (true) {
                boolean z = this.A0I;
                if (A0N[3].charAt(24) != '0') {
                    String[] strArr = A0N;
                    strArr[7] = "aB8IqMkBKAtMJJQueiQkJXGZRWNVG1wc";
                    strArr[5] = "HNBMfcg7Bwld4TPuQ9QkuhinF76Nerqg";
                    if ((z && this.A0L.size() >= this.A0B) || this.A0L.size() >= 15) {
                        this.A0L.remove(0);
                    } else {
                        return;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        } else {
            this.A0K.append(c);
        }
    }

    public final void A0B(int i, int i2) {
        if (this.A0A != i) {
            A0A('\n');
        }
        this.A0A = i;
    }

    public final void A0C(int i, int i2, int i3) {
        int i4;
        int i5;
        if (!(this.A04 == -1 || (i5 = this.A03) == i)) {
            this.A0K.setSpan(new ForegroundColorSpan(i5), this.A04, this.A0K.length(), 33);
        }
        if (i != A0P) {
            this.A04 = this.A0K.length();
            this.A03 = i;
        }
        if (!(this.A02 == -1 || (i4 = this.A01) == i2)) {
            this.A0K.setSpan(new BackgroundColorSpan(i4), this.A02, this.A0K.length(), 33);
        }
        if (i2 != A0O) {
            this.A02 = this.A0K.length();
            String[] strArr = A0N;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[6] = "OSAarCZoTwMbWIGA";
            strArr2[4] = "WpQvoscifbPqGooX";
            this.A01 = i2;
        }
    }

    public final void A0D(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
        if (this.A06 != -1) {
            if (!z) {
                this.A0K.setSpan(new StyleSpan(2), this.A06, this.A0K.length(), 33);
                this.A06 = -1;
            }
        } else if (z) {
            this.A06 = this.A0K.length();
        }
        if (this.A0C != -1) {
            if (!z2) {
                this.A0K.setSpan(new UnderlineSpan(), this.A0C, this.A0K.length(), 33);
                this.A0C = -1;
            }
        } else if (z2) {
            this.A0C = this.A0K.length();
        }
    }

    public final void A0E(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        this.A0E = i;
        this.A07 = i6;
    }

    public final void A0F(boolean z) {
        this.A0J = z;
    }

    public final void A0G(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.A0G = true;
        this.A0J = z;
        this.A0I = z2;
        this.A09 = i;
        this.A0H = z4;
        this.A0D = i2;
        this.A05 = i3;
        this.A00 = i6;
        if (this.A0B != i4 + 1) {
            this.A0B = i4 + 1;
            while (true) {
                if (z2) {
                    int size = this.A0L.size();
                    String[] strArr = A0N;
                    if (strArr[7].charAt(15) != strArr[5].charAt(15)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0N;
                    strArr2[7] = "EXpWdjiBi1mKPV7ugtu9QNhbKu2j8WKd";
                    strArr2[5] = "slA42LvVtkzyGudujTr9E5uQpxev7D1e";
                    if (size >= this.A0B) {
                        continue;
                        this.A0L.remove(0);
                    }
                }
                if (this.A0L.size() < 15) {
                    break;
                }
                this.A0L.remove(0);
            }
        }
        if (!(i7 == 0 || this.A0F == i7)) {
            this.A0F = i7;
            int windowStyleIdIndex = i7 - 1;
            A0E(A0U[windowStyleIdIndex], A0Q, A0Y[windowStyleIdIndex], 0, A0W[windowStyleIdIndex], A0X[windowStyleIdIndex], A0V[windowStyleIdIndex]);
        }
        if (i8 != 0 && this.A08 != i8) {
            this.A08 = i8;
            int penStyleIdIndex = i8 - 1;
            A0D(0, 1, 1, false, false, A0S[penStyleIdIndex], A0T[penStyleIdIndex]);
            A0C(A0P, A0R[penStyleIdIndex], A0O);
        }
    }

    public final boolean A0H() {
        return this.A0G;
    }

    public final boolean A0I() {
        return !A0H() || (this.A0L.isEmpty() && this.A0K.length() == 0);
    }

    public final boolean A0J() {
        return this.A0J;
    }
}
