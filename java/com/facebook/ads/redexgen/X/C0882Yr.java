package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Yr  reason: case insensitive filesystem */
public final class C0882Yr implements CK {
    public static byte[] A04;
    public static String[] A05;
    public static final CN A06 = new C0881Yq();
    public static final int A07 = C0466Ig.A08(A00(0, 3, 127));
    public boolean A00;
    public final long A01;
    public final C0883Ys A02;
    public final IQ A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{15, 2, 117};
    }

    public static void A02() {
        A05 = new String[]{"P5w0t5YmbfCx1ojda5KKDsEMO6jqUmnr", "UdOatSKcJailVD", "", "xAiF", "epl8GGi5jyNsT2QZHjLNLopZqyhNzplR", "TY8pRi4pa4JcG30Kuv61m", "fOMFGQDuqjq2usuY2YJ2oGF", "ObZwfJQfEiVxl"};
    }

    static {
        A02();
        A01();
    }

    public C0882Yr() {
        this(0);
    }

    public C0882Yr(long j) {
        this.A01 = j;
        this.A02 = new C0883Ys();
        this.A03 = new IQ(2786);
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A02.A4U(cm, new C0340De(0, 1));
        cm.A4w();
        cm.ACk(new YH(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        int read = cl.read(this.A03.A00, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.A03.A0Z(0);
        this.A03.A0Y(read);
        if (!this.A00) {
            this.A02.ABW(this.A01, true);
            this.A00 = true;
        }
        this.A02.A48(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A00 = false;
        this.A02.ACi();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        IQ iq = new IQ(10);
        int i = 0;
        while (true) {
            cl.ABZ(iq.A00, 0, 10);
            if (A05[7].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "IuOldmz1qGC5b";
            strArr[5] = "IuOldmz1qGC5b";
            iq.A0Z(0);
            if (iq.A0H() != A07) {
                cl.ACa();
                cl.A3M(i);
                int validFramesCount = i;
                int i2 = 0;
                while (true) {
                    cl.ABZ(iq.A00, 0, 5);
                    iq.A0Z(0);
                    if (iq.A0J() != 2935) {
                        i2 = 0;
                        cl.ACa();
                        validFramesCount++;
                        if (validFramesCount - i >= 8192) {
                            return false;
                        }
                        cl.A3M(validFramesCount);
                    } else {
                        i2++;
                        if (A05[5].length() != 29) {
                            String[] strArr2 = A05;
                            strArr2[3] = "a4rI";
                            strArr2[6] = "EnE3h5gngskpWhoTVRGnZEO";
                            if (i2 >= 4) {
                                return true;
                            }
                        } else if (i2 >= 4) {
                            return true;
                        }
                        int A052 = C0285As.A05(iq.A00);
                        if (A052 == -1) {
                            return false;
                        }
                        cl.A3M(A052 - 5);
                    }
                }
            } else {
                iq.A0a(3);
                int A0E = iq.A0E();
                i += A0E + 10;
                cl.A3M(A0E);
            }
        }
    }
}
