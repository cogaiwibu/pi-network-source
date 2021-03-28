package com.facebook.ads.redexgen.X;

import android.text.Layout;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Gj  reason: case insensitive filesystem */
public final class C0417Gj {
    public static byte[] A0E;
    public static String[] A0F;
    public float A00;
    public int A01;
    public int A02 = -1;
    public int A03;
    public int A04 = -1;
    public int A05 = -1;
    public int A06 = -1;
    public int A07 = -1;
    public Layout.Alignment A08;
    public String A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final C0417Gj A0D;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0E = new byte[]{-54, -23, -21, -13, -17, -6, -9, -3, -10, -20, -88, -21, -9, -12, -9, -6, -88, -16, -23, -5, -88, -10, -9, -4, -88, -22, -19, -19, -10, -88, -20, -19, -18, -15, -10, -19, -20, -74, -111, -70, -71, -65, 107, -82, -70, -73, -70, -67, 107, -77, -84, -66, 107, -71, -70, -65, 107, -83, -80, -80, -71, 107, -81, -80, -79, -76, -71, -80, -81, 121};
    }

    public static void A03() {
        A0F = new String[]{"2rOgL1VomfnKNDiiRLuB00t6jlAsVhoY", "blpdILmRLbT", "Q9OLsQLUoF7pzn2H7oHAPqzaTlo", "IgUEYrnqH0RZ2n7W3ZHj4VjlBM", "n8fBnn3PQrJSANOZTiJccAVsijjqnybh", "oA8yODG3hMHEtxJpNaiPqvWS7JkBcEtN", "bFjb4zLN3GxOZucD", "uX14XJHhFZ25Rtk0OR0uxRe4gWkBD2Kq"};
    }

    private C0417Gj A00(C0417Gj gj, boolean z) {
        if (gj != null) {
            if (!this.A0C && gj.A0C) {
                A0C(gj.A03);
            }
            if (this.A02 == -1) {
                this.A02 = gj.A02;
            }
            if (this.A05 == -1) {
                this.A05 = gj.A05;
            }
            if (this.A09 == null) {
                this.A09 = gj.A09;
            }
            int i = this.A06;
            String[] strArr = A0F;
            if (strArr[3].length() != strArr[2].length()) {
                String[] strArr2 = A0F;
                strArr2[3] = "GJ9o7fjOWymoLqPdmAP22QCuE8";
                strArr2[2] = "Jy9OzO36lYOLR5YZRxirEWXZRi5";
                if (i == -1) {
                    this.A06 = gj.A06;
                }
                if (this.A07 == -1) {
                    this.A07 = gj.A07;
                }
                if (this.A08 == null) {
                    this.A08 = gj.A08;
                }
                if (this.A04 == -1) {
                    this.A04 = gj.A04;
                    this.A00 = gj.A00;
                }
                if (z) {
                    boolean z2 = this.A0B;
                    if (A0F[0].charAt(7) != 'w') {
                        String[] strArr3 = A0F;
                        strArr3[7] = "6vVTartgCZkYp9tsszmaRxNx1O7KVPUV";
                        strArr3[7] = "6vVTartgCZkYp9tsszmaRxNx1O7KVPUV";
                        if (!z2 && gj.A0B) {
                            A0B(gj.A01);
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return this;
    }

    public final float A04() {
        return this.A00;
    }

    public final int A05() {
        if (this.A0B) {
            return this.A01;
        }
        throw new IllegalStateException(A01(0, 38, 126));
    }

    public final int A06() {
        if (this.A0C) {
            return this.A03;
        }
        throw new IllegalStateException(A01(38, 32, 65));
    }

    public final int A07() {
        return this.A04;
    }

    public final int A08() {
        if (this.A02 == -1 && this.A05 == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.A02 == 1 ? 1 : 0;
        if (this.A05 == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final Layout.Alignment A09() {
        return this.A08;
    }

    public final C0417Gj A0A(float f) {
        this.A00 = f;
        return this;
    }

    public final C0417Gj A0B(int i) {
        this.A01 = i;
        this.A0B = true;
        return this;
    }

    public final C0417Gj A0C(int i) {
        boolean z;
        if (this.A0D == null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A03 = i;
        this.A0C = true;
        return this;
    }

    public final C0417Gj A0D(int i) {
        this.A04 = i;
        return this;
    }

    public final C0417Gj A0E(Layout.Alignment alignment) {
        this.A08 = alignment;
        return this;
    }

    public final C0417Gj A0F(C0417Gj gj) {
        return A00(gj, true);
    }

    public final C0417Gj A0G(String str) {
        boolean z;
        if (this.A0D == null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A09 = str;
        return this;
    }

    public final C0417Gj A0H(String str) {
        this.A0A = str;
        return this;
    }

    public final C0417Gj A0I(boolean z) {
        boolean z2;
        if (this.A0D == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A02 = z ? 1 : 0;
        return this;
    }

    public final C0417Gj A0J(boolean z) {
        boolean z2;
        if (this.A0D == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A05 = z ? 1 : 0;
        return this;
    }

    public final C0417Gj A0K(boolean z) {
        boolean z2;
        if (this.A0D == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A06 = z ? 1 : 0;
        return this;
    }

    public final C0417Gj A0L(boolean z) {
        boolean z2;
        if (this.A0D == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A04(z2);
        this.A07 = z ? 1 : 0;
        if (A0F[7].charAt(17) != 'b') {
            String[] strArr = A0F;
            strArr[5] = "92ha12DsR5eF5zJ1dM6CQDThJYn4roQH";
            strArr[5] = "92ha12DsR5eF5zJ1dM6CQDThJYn4roQH";
            return this;
        }
        throw new RuntimeException();
    }

    public final String A0M() {
        return this.A09;
    }

    public final String A0N() {
        return this.A0A;
    }

    public final boolean A0O() {
        return this.A0B;
    }

    public final boolean A0P() {
        return this.A0C;
    }

    public final boolean A0Q() {
        return this.A06 == 1;
    }

    public final boolean A0R() {
        return this.A07 == 1;
    }
}
