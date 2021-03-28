package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public final class DW {
    public static String[] A05;
    public int A00;
    public byte[] A01;
    public boolean A02;
    public boolean A03;
    public final int A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"SH4mzQnZtPKxPlKf", "URF6REnbmZYIKb79", "Y3z4Uu6uKYSt14bgOMkrNryWU1I8M7pC", "Oh4OE6e6dWqkqVraEiAcCMLeCTfZ04Gm", "v1ACOKrY4UH7FiVMLirmPA2shyqDqR5U", "uDUzXgp2odpdT3Hcc9VruLfFOAigPhBZ", "x4DnKz5Y", "xW65fi46BSoc5ty04RtWZW7HfzdvAXLT"};
    }

    public DW(int i, int i2) {
        this.A04 = i;
        this.A01 = new byte[(i2 + 3)];
        this.A01[2] = 1;
    }

    public final void A01() {
        this.A03 = false;
        this.A02 = false;
    }

    public final void A02(int i) {
        boolean z = true;
        I1.A04(!this.A03);
        if (i != this.A04) {
            z = false;
        }
        this.A03 = z;
        boolean z2 = this.A03;
        String[] strArr = A05;
        if (strArr[6].length() != strArr[7].length()) {
            String[] strArr2 = A05;
            strArr2[3] = "eOpOrWRcfGMpq7bOUIBYRy63hHYmgzQm";
            strArr2[3] = "eOpOrWRcfGMpq7bOUIBYRy63hHYmgzQm";
            if (z2) {
                this.A00 = 3;
                this.A02 = false;
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public final void A03(byte[] bArr, int i, int i2) {
        if (this.A03) {
            int i3 = i2 - i;
            byte[] bArr2 = this.A01;
            int length = bArr2.length;
            int i4 = this.A00;
            if (length < i4 + i3) {
                this.A01 = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.A01, this.A00, i3);
            this.A00 += i3;
        }
    }

    public final boolean A04() {
        return this.A02;
    }

    public final boolean A05(int i) {
        if (!this.A03) {
            return false;
        }
        this.A00 -= i;
        this.A03 = false;
        this.A02 = true;
        return true;
    }
}
