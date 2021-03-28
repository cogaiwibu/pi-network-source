package com.facebook.ads.redexgen.X;

import java.io.IOException;

public abstract class DG {
    public static String[] A0D;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public CM A06;
    public CW A07;
    public DD A08;
    public DF A09;
    public boolean A0A;
    public boolean A0B;
    public final DB A0C = new DB();

    static {
        A02();
    }

    public static void A02() {
        A0D = new String[]{"vdpx440NSg8M4CnGdydtu5qQkftaFl81", "8FBVTf92WyxNz1PbVx8WfEYVHOwD1jYA", "DKJKTeADHw9YeVFClTVADEpoqL7THNTT", "QMHe7Xu97ps4f3hWTDxnFcitcXlvMrzA", "cT681YGQWd9DutiYQJBSPFEBPfK5r2m4", "EyU4ukvYlXQau4YgIYVQwMEfY7bgqA6h", "DftqlnKuE3jyyUo0DxEITdlkAR2KkpEx", "3J2n16rNLfrexVGozCu5PKnUXiDeYKol"};
    }

    public abstract long A08(IQ iq);

    public abstract boolean A0B(IQ iq, long j, DF df) throws IOException, InterruptedException;

    private int A00(CL cl) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.A0C.A06(cl)) {
                this.A01 = 3;
                return -1;
            }
            this.A03 = cl.A6m() - this.A04;
            z = A0B(this.A0C.A03(), this.A04, this.A09);
            if (z) {
                this.A04 = cl.A6m();
            }
        }
        this.A00 = this.A09.A00.A0C;
        if (!this.A0A) {
            this.A07.A5A(this.A09.A00);
            this.A0A = true;
        }
        if (this.A09.A01 != null) {
            DF df = this.A09;
            String[] strArr = A0D;
            if (strArr[3].charAt(31) != strArr[7].charAt(31)) {
                String[] strArr2 = A0D;
                strArr2[2] = "bh7MBcJSzFDWGWL7bYV4RFdmzZ5DJPtg";
                strArr2[4] = "jbTTtcEVTbmVVWffnqyGAcPkGPEAibSD";
                this.A08 = df.A01;
            } else {
                throw new RuntimeException();
            }
        } else if (cl.A6T() == -1) {
            this.A08 = new C0878Yn();
        } else {
            DC A022 = this.A0C.A02();
            this.A08 = new C0872Yh(this.A04, cl.A6T(), this, A022.A01 + A022.A00, A022.A05);
        }
        this.A09 = null;
        this.A01 = 2;
        this.A0C.A05();
        return 0;
    }

    private int A01(CL cl, CR cr) throws IOException, InterruptedException {
        long ABy = this.A08.ABy(cl);
        if (ABy >= 0) {
            cr.A00 = ABy;
            return 1;
        }
        if (ABy < -1) {
            A09(-(2 + ABy));
        }
        boolean z = this.A0B;
        if (A0D[1].charAt(31) != 'Q') {
            String[] strArr = A0D;
            strArr[6] = "YKdoYyhEaGRVIGwSTWAYioMwjJxRxWbM";
            strArr[6] = "YKdoYyhEaGRVIGwSTWAYioMwjJxRxWbM";
            if (!z) {
                this.A06.ACk(this.A08.A4R());
                this.A0B = true;
            }
            if (this.A03 > 0 || this.A0C.A06(cl)) {
                this.A03 = 0;
                IQ A032 = this.A0C.A03();
                long A082 = A08(A032);
                if (A082 >= 0) {
                    long j = this.A02;
                    if (j + A082 >= this.A05) {
                        long A042 = A04(j);
                        this.A07.ACe(A032, A032.A08());
                        this.A07.ACf(A042, 1, A032.A08(), 0, null);
                        this.A05 = -1;
                    }
                }
                this.A02 += A082;
                return 0;
            }
            this.A01 = 3;
            return -1;
        }
        throw new RuntimeException();
    }

    public final int A03(CL cl, CR cr) throws IOException, InterruptedException {
        int i = this.A01;
        if (i == 0) {
            return A00(cl);
        }
        if (i == 1) {
            cl.ADG((int) this.A04);
            this.A01 = 2;
            return 0;
        } else if (i == 2) {
            int A012 = A01(cl, cr);
            if (A0D[6].charAt(6) != 'm') {
                String[] strArr = A0D;
                strArr[1] = "ecnT7ItXVuTi5H8Gayt4a9jA0qUq5vI3";
                strArr[1] = "ecnT7ItXVuTi5H8Gayt4a9jA0qUq5vI3";
                return A012;
            }
            throw new RuntimeException();
        } else {
            throw new IllegalStateException();
        }
    }

    public final long A04(long j) {
        return (1000000 * j) / ((long) this.A00);
    }

    public final long A05(long j) {
        return (((long) this.A00) * j) / 1000000;
    }

    public final void A06(long j, long j2) {
        this.A0C.A04();
        if (j == 0) {
            A0A(!this.A0B);
        } else if (this.A01 != 0) {
            this.A05 = this.A08.ADN(j2);
            this.A01 = 2;
        }
    }

    public final void A07(CM cm, CW cw) {
        this.A06 = cm;
        this.A07 = cw;
        A0A(true);
    }

    public void A09(long j) {
        this.A02 = j;
    }

    public void A0A(boolean z) {
        if (z) {
            this.A09 = new DF();
            this.A04 = 0;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1;
        this.A02 = 0;
    }
}
