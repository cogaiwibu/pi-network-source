package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.aw  reason: case insensitive filesystem */
public final class C0971aw implements HM {
    public static String[] A0L;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public HM A07;
    public C0449Hp A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final HM A0D;
    public final HM A0E;
    public final HM A0F;
    public final AbstractC0445Hl A0G;
    @Nullable
    public final AbstractC0447Hn A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    static {
        A05();
    }

    public static void A05() {
        A0L = new String[]{"xvXnimfZlroovEtMoHYEYdvHQmTptcRb", "VShQwZMBIZykoEi", "P7iiojcQSdjMkPZizdNAiKDH8422CMpJ", "OxKv", "P8zJvNho1beYtiBqU3s9pOljEd8sbOL5", "Bz35mpVTEU3xTv8hVu6cT493QseTsu6A", "YnRJs9xpv2Ig79N4M2dWIXRLqnd73xG0", "iIjgXD4YmMEy6XOGrZ4fgbIBHD"};
    }

    public C0971aw(AbstractC0445Hl hl, HM hm, HM hm2, HK hk, int i, @Nullable AbstractC0447Hn hn) {
        boolean z;
        boolean z2;
        this.A0G = hl;
        this.A0D = hm2;
        boolean z3 = false;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.A0I = z;
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.A0K = z2;
        this.A0J = (i & 4) != 0 ? true : z3;
        this.A0F = hm;
        if (hk != null) {
            this.A0E = new C0966ar(hm, hk);
        } else {
            this.A0E = null;
        }
        this.A0H = hn;
    }

    private int A00(HQ hq) {
        if (this.A0K && this.A0C) {
            return 0;
        }
        if (!this.A0J || hq.A02 != -1) {
            return -1;
        }
        return 1;
    }

    public static Uri A01(AbstractC0445Hl hl, String str, Uri uri) {
        Uri A012 = C0456Hw.A01(hl.A5n(str));
        return A012 == null ? uri : A012;
    }

    private void A02() throws IOException {
        HM hm = this.A07;
        if (hm != null) {
            try {
                hm.close();
            } finally {
                this.A07 = null;
                this.A0A = false;
                C0449Hp hp = this.A08;
                if (hp != null) {
                    this.A0G.ACH(hp);
                    this.A08 = null;
                }
            }
        }
    }

    private void A03() {
        if (this.A0H != null && this.A04 > 0) {
            this.A0G.A5Z();
            throw null;
        }
    }

    private void A04() throws IOException {
        this.A01 = 0;
        if (A0B()) {
            this.A0G.ACu(this.A09, this.A03);
        }
    }

    private void A06(IOException iOException) {
        if (A09() || (iOException instanceof C0443Hj)) {
            this.A0C = true;
        }
    }

    /* JADX INFO: Multiple debug info for r1v6 com.facebook.ads.redexgen.X.Hp: [D('length' long), D('nextDataSource' com.facebook.ads.redexgen.X.HM), D('fileUri' android.net.Uri)] */
    /* JADX INFO: Multiple debug info for r1v8 com.facebook.ads.redexgen.X.Hp: [D('length' long), D('nextDataSource' com.facebook.ads.redexgen.X.HM)] */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c3, code lost:
        if (r4 != -1) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01da, code lost:
        if (r4 != -1) goto L_0x01c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A07(boolean r22) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 547
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0971aw.A07(boolean):void");
    }

    private boolean A08() {
        return this.A07 == this.A0F;
    }

    private boolean A09() {
        return this.A07 == this.A0D;
    }

    private boolean A0A() {
        return !A09();
    }

    private boolean A0B() {
        return this.A07 == this.A0E;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Multiple debug info for r3v1 ??: [D('cause' java.lang.Throwable), D('reason' int)] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    public static boolean A0C(IOException iOException) {
        while (iOException != 0) {
            if ((iOException instanceof HN) && ((HN) iOException).A00 == 0) {
                return true;
            }
            iOException = iOException.getCause();
        }
        if (A0L[5].charAt(13) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[1] = "Fi50x9pU4R4a4ch";
        strArr[1] = "Fi50x9pU4R4a4ch";
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final Uri A7C() {
        return this.A05;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.aw: [D('reason' int), D('e' java.io.IOException)] */
    @Override // com.facebook.ads.redexgen.X.HM
    public final long ABP(HQ hq) throws IOException {
        try {
            this.A09 = C0451Hr.A02(hq);
            this.A06 = hq.A04;
            this.A05 = A01(this.A0G, this.A09, this.A06);
            this.A00 = hq.A00;
            this.A03 = hq.A03;
            this.A0B = A00(hq) != -1;
            boolean z = this.A0B;
            if (hq.A02 != -1 || this.A0B) {
                this.A01 = hq.A02;
            } else {
                this.A01 = this.A0G.A5m(this.A09);
                if (this.A01 != -1) {
                    this.A01 -= hq.A03;
                    if (this.A01 <= 0) {
                        throw new HN(0);
                    }
                }
            }
            A07(false);
            return this.A01;
        } catch (IOException e) {
            A06(e);
            throw e;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A03();
        try {
            A02();
        } catch (IOException e) {
            A06(e);
            throw e;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HM
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            int i3 = (this.A03 > this.A02 ? 1 : (this.A03 == this.A02 ? 0 : -1));
            String[] strArr = A0L;
            if (strArr[4].charAt(0) != strArr[2].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[7] = "DFL6VfCjI9oAtZuqjooU4v3Ar2";
            strArr2[3] = "hOjd";
            if (i3 >= 0) {
                A07(true);
            }
            int read = this.A07.read(bArr, i, i2);
            if (read != -1) {
                if (A09()) {
                    this.A04 += (long) read;
                }
                this.A03 += (long) read;
                if (this.A01 != -1) {
                    this.A01 -= (long) read;
                }
            } else if (this.A0A) {
                A04();
            } else if (this.A01 > 0 || this.A01 == -1) {
                A02();
                A07(false);
                return read(bArr, i, i2);
            }
            return read;
        } catch (IOException e) {
            if (!this.A0A || !A0C(e)) {
                A06(e);
                throw e;
            }
            A04();
            return -1;
        }
    }
}
