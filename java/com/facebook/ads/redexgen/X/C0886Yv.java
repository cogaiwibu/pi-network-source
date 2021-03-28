package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* renamed from: com.facebook.ads.redexgen.X.Yv  reason: case insensitive filesystem */
public final class C0886Yv implements DQ {
    public static byte[] A0H;
    public static String[] A0I;
    public static final byte[] A0J = {73, 68, 51};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public CW A07;
    public CW A08;
    public CW A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final IP A0D;
    public final IQ A0E;
    public final String A0F;
    public final boolean A0G;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) - 49);
            if (A0I[4].charAt(1) != 'n') {
                throw new RuntimeException();
            }
            String[] strArr = A0I;
            strArr[4] = "bnluMaXE1Uw3b3JGoNOZfy6HcCqjlXqz";
            strArr[4] = "bnluMaXE1Uw3b3JGoNOZfy6HcCqjlXqz";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0H = new byte[]{-120, 124, -66, -47, -48, 124, -67, -49, -49, -47, -55, -59, -54, -61, 124, -99, -99, -97, 124, -88, -97, -118, -118, -83, -67, -68, -101, -82, -86, -83, -82, -69, -18, 15, 30, 15, 13, 30, 15, 14, -54, 11, 31, 14, 19, 25, -54, 25, 12, 20, 15, 13, 30, -54, 30, 35, 26, 15, -28, -54, -26, -11, -11, -15, -18, -24, -26, -7, -18, -12, -13, -76, -18, -23, -72, 16, 36, 19, 24, 30, -34, 28, 31, -29, 16, -36, 27, 16, 35, 28};
    }

    public static void A07() {
        A0I = new String[]{"wge6vcbYVd2LlwU9IzXxO7y1yc7Npjql", "e4ah1", "HxlECSCujzZIBhcakhB8llOPpIPg4jPi", "c3jgZ7razfwrLoite54T", "YnWTxT53I9VC0eKuEFoJi1GxqSMOrSIM", "mGJBSiyG9M2YGViPKeXmqCjoZalx0YC5", "VtpTHv8dn8NrwXo7ikKBEmVWKD8j4YCX", "dqOZRsMzwGVkln1A4hbisIXuNnIWGGSy"};
    }

    static {
        A07();
        A06();
    }

    public C0886Yv(boolean z) {
        this(z, null);
    }

    public C0886Yv(boolean z, String str) {
        this.A0D = new IP(new byte[7]);
        this.A0E = new IQ(Arrays.copyOf(A0J, 10));
        A03();
        this.A0G = z;
        this.A0F = str;
    }

    private void A01() throws AN {
        this.A0D.A08(0);
        if (!this.A0C) {
            int A052 = this.A0D.A05(2) + 1;
            if (A052 != 2) {
                Log.w(A00(22, 10, 24), A00(32, 28, 121) + A052 + A00(0, 22, 43));
                A052 = 2;
            }
            int A053 = this.A0D.A05(4);
            this.A0D.A09(1);
            byte[] A082 = I5.A08(A052, A053, this.A0D.A05(3));
            Pair<Integer, Integer> A032 = I5.A03(A082);
            Format A072 = Format.A07(this.A0A, A00(75, 15, 126), null, -1, -1, ((Integer) A032.second).intValue(), ((Integer) A032.first).intValue(), Collections.singletonList(A082), null, 0, this.A0F);
            this.A05 = 1024000000 / ((long) A072.A0C);
            this.A09.A5A(A072);
            this.A0C = true;
        } else {
            IP ip = this.A0D;
            String[] strArr = A0I;
            if (strArr[3].length() != strArr[1].length()) {
                String[] strArr2 = A0I;
                strArr2[4] = "gnfbeCT7ETb0BF6eGTwxRLZIMNoo6eBq";
                strArr2[4] = "gnfbeCT7ETb0BF6eGTwxRLZIMNoo6eBq";
                ip.A09(10);
            } else {
                throw new RuntimeException();
            }
        }
        this.A0D.A09(4);
        int A054 = (this.A0D.A05(13) - 2) - 5;
        if (this.A0B) {
            A054 -= 2;
        }
        CW cw = this.A09;
        long j = this.A05;
        if (A0I[0].charAt(1) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0I;
        strArr3[5] = "DPeEZCdjnoP4QwMjUw7HIDON5EObNWtY";
        strArr3[6] = "TWt76gMmW2EkEQM2OhdsBT8X6vSrq3Ij";
        A08(cw, j, 0, A054);
    }

    private void A02() {
        this.A08.ACe(this.A0E, 10);
        this.A0E.A0Z(6);
        A08(this.A08, 0, 10, this.A0E.A0E() + 10);
    }

    private void A03() {
        this.A03 = 0;
        this.A00 = 0;
        this.A01 = 256;
    }

    private void A04() {
        this.A03 = 2;
        this.A00 = 0;
    }

    private void A05() {
        this.A03 = 1;
        this.A00 = A0J.length;
        this.A02 = 0;
        this.A0E.A0Z(0);
    }

    private void A08(CW cw, long j, int i, int i2) {
        this.A03 = 3;
        this.A00 = i;
        this.A07 = cw;
        this.A04 = j;
        this.A02 = i2;
    }

    /* JADX INFO: Multiple debug info for r9v0 com.facebook.ads.redexgen.X.IQ: [D('data' int), D('position' int)] */
    private void A09(IQ iq) {
        boolean z;
        byte[] bArr = iq.A00;
        int position = iq.A07();
        int A082 = iq.A08();
        while (position < A082) {
            int i = position + 1;
            int i2 = bArr[position] & UByte.MAX_VALUE;
            if (this.A01 != 512 || i2 < 240 || i2 == 255) {
                int i3 = this.A01;
                int i4 = i3 | i2;
                if (i4 == 329) {
                    this.A01 = 768;
                } else if (i4 == 511) {
                    this.A01 = 512;
                } else if (i4 == 836) {
                    this.A01 = 1024;
                } else if (i4 == 1075) {
                    A05();
                    iq.A0Z(i);
                    return;
                } else if (i3 != 256) {
                    this.A01 = 256;
                    position = i - 1;
                }
                position = i;
            } else {
                if ((i2 & 1) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.A0B = z;
                A04();
                iq.A0Z(i);
                return;
            }
        }
        iq.A0Z(position);
    }

    private void A0A(IQ iq) {
        int min = Math.min(iq.A05(), this.A02 - this.A00);
        this.A07.ACe(iq, min);
        this.A00 += min;
        int i = this.A00;
        int i2 = this.A02;
        if (i == i2) {
            this.A07.ACf(this.A06, 1, i2, 0, null);
            this.A06 += this.A04;
            A03();
        }
    }

    private boolean A0B(IQ iq, byte[] bArr, int i) {
        int min = Math.min(iq.A05(), i - this.A00);
        iq.A0d(bArr, this.A00, min);
        this.A00 += min;
        return this.A00 == i;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) throws AN {
        int i;
        while (iq.A05() > 0) {
            int i2 = this.A03;
            if (i2 == 0) {
                A09(iq);
            } else if (i2 != 1) {
                String[] strArr = A0I;
                if (strArr[5].charAt(25) != strArr[6].charAt(25)) {
                    String[] strArr2 = A0I;
                    strArr2[5] = "9CqnxzaEQimEcBf5cSINZxdBysafSxdF";
                    strArr2[6] = "zLp55t2V8ycwykcXwXcmLQHdTFNUXCiS";
                    if (i2 == 2) {
                        if (this.A0B) {
                            i = 7;
                        } else {
                            i = 5;
                        }
                        boolean A0B2 = A0B(iq, this.A0D.A00, i);
                        if (A0I[0].charAt(1) == 'g') {
                            String[] strArr3 = A0I;
                            strArr3[3] = "PBSyuwIG2tPzzgRnoBM9";
                            strArr3[1] = "owzwp";
                            if (!A0B2) {
                            }
                        } else if (!A0B2) {
                        }
                        A01();
                    } else if (i2 == 3) {
                        A0A(iq);
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (A0B(iq, this.A0E.A00, 10)) {
                A02();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A0A = de.A05();
        this.A09 = cm.ADY(de.A04(), 1);
        if (this.A0G) {
            de.A06();
            this.A08 = cm.ADY(de.A04(), 4);
            this.A08.A5A(Format.A0B(de.A05(), A00(60, 15, 84), null, -1, null));
            return;
        }
        this.A08 = new YF();
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        this.A06 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        A03();
    }
}
