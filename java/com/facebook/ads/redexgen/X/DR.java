package com.facebook.ads.redexgen.X;

import com.ironsource.sdk.analytics.omid.OMIDManager;
import java.util.Arrays;

public final class DR {
    public static String[] A04;
    public static final byte[] A05 = {0, 0, 1};
    public int A00;
    public int A01;
    public byte[] A02;
    public boolean A03;

    public static void A00() {
        A04 = new String[]{"fOExADNBYdlDWlbdLr9FKIDbfh2Wb1rp", OMIDManager.OMID_PARTNER_VERSION, "Qt2wlMjRQQ4qWijHKbqrgXlkTG6BMnXX", "0gfrwT7HQoixTXE6fbcieZWPZxWYDLvm", "s1cytPLymz9SSkagkEgBtQdGModclRoX", "i09lyNhAkSqFQiPYURX06", "GTgJRlsu81UpuNTgSBbivcMs7zrnCeeB", "wkZQk9aN3EzwRMfzeUqCcSppBSpZ8xUO"};
    }

    static {
        A00();
    }

    public DR(int i) {
        this.A02 = new byte[i];
    }

    public final void A01() {
        this.A03 = false;
        this.A00 = 0;
        this.A01 = 0;
    }

    public final void A02(byte[] bArr, int i, int i2) {
        if (this.A03) {
            int i3 = i2 - i;
            byte[] bArr2 = this.A02;
            int length = bArr2.length;
            int i4 = this.A00;
            if (length < i4 + i3) {
                this.A02 = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.A02, this.A00, i3);
            this.A00 += i3;
        }
    }

    public final boolean A03(int i, int i2) {
        if (this.A03) {
            this.A00 -= i2;
            int i3 = this.A01;
            String[] strArr = A04;
            if (strArr[7].charAt(17) != strArr[2].charAt(17)) {
                String[] strArr2 = A04;
                strArr2[7] = "emegRlYzfUt2VPGJUiIYNrPqCOpIpCO8";
                strArr2[2] = "fTMWdmHNSPpkmFXnKlnCifd3toy29TVe";
                if (i3 == 0) {
                    if (A04[0].charAt(20) != 'K') {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A04;
                    strArr3[1] = "E";
                    strArr3[1] = "E";
                    if (i == 181) {
                        this.A01 = this.A00;
                    }
                }
                this.A03 = false;
                String[] strArr4 = A04;
                if (strArr4[3].charAt(31) != strArr4[4].charAt(31)) {
                    String[] strArr5 = A04;
                    strArr5[1] = "H";
                    strArr5[1] = "H";
                    return true;
                }
                throw new RuntimeException();
            }
            throw new RuntimeException();
        } else if (i == 179) {
            this.A03 = true;
        }
        byte[] bArr = A05;
        A02(bArr, 0, bArr.length);
        return false;
    }
}
