package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class YJ implements CK {
    public static byte[] A07;
    public static String[] A08;
    public static final CN A09 = new YI();
    public static final int A0A = A0E[8];
    public static final byte[] A0B = C0466Ig.A0j(A03(12, 6, 27));
    public static final byte[] A0C = C0466Ig.A0j(A03(18, 9, 50));
    public static final int[] A0D = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    public static final int[] A0E = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public int A00;
    public int A01;
    public long A02;
    public CW A03;
    public boolean A04;
    public boolean A05;
    public final byte[] A06 = new byte[1];

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{68, 2, 22, 5, 9, 1, 68, 16, 29, 20, 1, 68, 110, 108, 12, 0, 31, 71, 71, 69, 37, 41, 54, 73, 51, 38, 110, 19, 63, 37, 60, 52, 112, 62, 63, 36, 112, 54, 57, 62, 52, 112, 17, 29, 2, 112, 56, 53, 49, 52, 53, 34, 126, 118, 83, 83, 90, 88, 94, 83, 31, 126, 114, 109, 31, 66, 101, 125, 106, 103, 98, 111, 43, 123, 106, 111, 111, 98, 101, 108, 43, 105, 98, ByteCompanionObject.MAX_VALUE, 120, 43, 109, 100, 121, 43, 109, 121, 106, 102, 110, 43, 99, 110, 106, 111, 110, 121, 43, 100, 104, 11, 30, 117, 97, 112, 125, 123, 59, 39, 115, 100, 100, 79, 91, 74, 71, 65, 1, 79, 67, 92, 3, 89, 76};
    }

    public static void A06() {
        A08 = new String[]{"kwIa2qvFZnh4ugx7FyhwbqYesuLHzW8H", "4Dgc9JYMaZvt2hrxHtp57hAkJrlRZ5uW", "jO6V5", "R3", "Im86Iu6D0MRlrMkG5DQfIyJ6juGc2Tk5", "YTnYWq927V90IgLbpCGbNLebKXRpsTKS", "IVlYalVTOJIVyjwO93zz99ctNlNH9y3g", "4VmeTfaP7iXdbh5q2O9S939ewelN7CTt"};
    }

    static {
        A06();
        A05();
    }

    private int A00(int i) throws AN {
        if (!A08(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append(A03(53, 12, 105));
            sb.append(this.A05 ? A03(105, 2, 10) : A03(103, 2, 124));
            sb.append(A03(0, 12, 50));
            sb.append(i);
            throw new AN(sb.toString());
        } else if (!this.A05) {
            return A0D[i];
        } else {
            int[] iArr = A0E;
            if (A08[1].charAt(23) != 'y') {
                String[] strArr = A08;
                strArr[2] = "ixm0r";
                strArr[2] = "ixm0r";
                return iArr[i];
            }
            throw new RuntimeException();
        }
    }

    private int A01(CL cl) throws IOException, InterruptedException {
        cl.ACa();
        cl.ABZ(this.A06, 0, 1);
        byte b = this.A06[0];
        if ((b & 131) <= 0) {
            return A00((b >> 3) & 15);
        }
        throw new AN(A03(65, 38, 93) + ((int) b));
    }

    /* JADX INFO: Multiple debug info for r12v0 'this'  com.facebook.ads.redexgen.X.YJ: [D('e' java.io.EOFException), D('bytesAppended' int)] */
    private int A02(CL cl) throws IOException, InterruptedException {
        if (this.A00 == 0) {
            try {
                this.A01 = A01(cl);
                this.A00 = this.A01;
            } catch (EOFException unused) {
                return -1;
            }
        }
        int ACd = this.A03.ACd(cl, this.A00, true);
        if (ACd == -1) {
            return -1;
        }
        this.A00 -= ACd;
        if (this.A00 > 0) {
            return 0;
        }
        CW cw = this.A03;
        long j = this.A02;
        String[] strArr = A08;
        if (strArr[4].charAt(15) != strArr[5].charAt(15)) {
            String[] strArr2 = A08;
            strArr2[2] = "25B6f";
            strArr2[2] = "25B6f";
            cw.ACf(j, 1, this.A01, 0, null);
            this.A02 += 20000;
            return 0;
        }
        throw new RuntimeException();
    }

    private void A04() {
        String A032;
        int i;
        if (!this.A04) {
            this.A04 = true;
            if (this.A05) {
                A032 = A03(117, 12, 120);
            } else {
                A032 = A03(107, 10, 66);
            }
            if (this.A05) {
                i = 16000;
            } else {
                i = 8000;
            }
            this.A03.A5A(Format.A06(null, A032, null, -1, A0A, 1, i, -1, null, null, 0, null));
        }
    }

    private boolean A07(int i) {
        return !this.A05 && (i < 12 || i > 14);
    }

    private boolean A08(int i) {
        return i >= 0 && i <= 15 && (A09(i) || A07(i));
    }

    private boolean A09(int i) {
        return this.A05 && (i < 10 || i > 13);
    }

    private boolean A0A(CL cl) throws IOException, InterruptedException {
        if (A0B(cl, A0B)) {
            this.A05 = false;
            cl.ADG(A0B.length);
            return true;
        } else if (!A0B(cl, A0C)) {
            return false;
        } else {
            this.A05 = true;
            cl.ADG(A0C.length);
            return true;
        }
    }

    private boolean A0B(CL cl, byte[] bArr) throws IOException, InterruptedException {
        cl.ACa();
        byte[] bArr2 = new byte[bArr.length];
        cl.ABZ(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        cm.ACk(new YH(-9223372036854775807L));
        this.A03 = cm.ADY(0, 1);
        cm.A4w();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        if (cl.A6m() != 0 || A0A(cl)) {
            A04();
            return A02(cl);
        }
        throw new AN(A03(27, 26, 6));
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A02 = 0;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return A0A(cl);
    }
}
