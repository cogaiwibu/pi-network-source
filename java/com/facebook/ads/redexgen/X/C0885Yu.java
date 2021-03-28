package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Yu  reason: case insensitive filesystem */
public final class C0885Yu implements CK {
    public static byte[] A04;
    public static String[] A05;
    public static final CN A06 = new C0884Yt();
    public static final int A07 = C0466Ig.A08(A00(0, 3, 42));
    public boolean A00;
    public final long A01;
    public final C0886Yv A02;
    public final IQ A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{27, 22, 97};
    }

    public static void A02() {
        A05 = new String[]{"6Yd3MlxO6zs0On0JMF5Pwnois3aNTjpE", "MmQBoaYzrmdPmtEAYQ3R1Y6Mcsh6By7B", "7RUBoC8KCwVWfiCX9SWb", "GS41ND25W7ytYawGpGonJQP9IOOENLXr", "lL4oomLzy5vPLaNFQ0K", "J26", "emQAR3GMgLzBn72fJq6a", "GcSIxJRAUXsHB0u2DOmppTTbOqtsj228"};
    }

    static {
        A02();
        A01();
    }

    public C0885Yu() {
        this(0);
    }

    public C0885Yu(long j) {
        this.A01 = j;
        this.A02 = new C0886Yv(true);
        this.A03 = new IQ(200);
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A02.A4U(cm, new C0340De(0, 1));
        cm.A4w();
        cm.ACk(new YH(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        int read = cl.read(this.A03.A00, 0, 200);
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
        IP ip = new IP(iq.A00);
        int validFramesCount = 0;
        while (true) {
            cl.ABZ(iq.A00, 0, 10);
            iq.A0Z(0);
            if (iq.A0H() != A07) {
                break;
            }
            iq.A0a(3);
            int A0E = iq.A0E();
            validFramesCount += A0E + 10;
            cl.A3M(A0E);
        }
        cl.ACa();
        cl.A3M(validFramesCount);
        int i = validFramesCount;
        int i2 = 0;
        if (A05[4].length() != 20) {
            String[] strArr = A05;
            strArr[1] = "mY90xJHLqPMDpFXgmiZe2UkYD68ZyI7P";
            strArr[1] = "mY90xJHLqPMDpFXgmiZe2UkYD68ZyI7P";
            int startPosition = 0;
            while (true) {
                cl.ABZ(iq.A00, 0, 2);
                iq.A0Z(0);
                if ((65526 & iq.A0J()) != 65520) {
                    startPosition = 0;
                    i2 = 0;
                    cl.ACa();
                    i++;
                    if (i - validFramesCount >= 8192) {
                        return false;
                    }
                    cl.A3M(i);
                } else {
                    startPosition++;
                    if (startPosition >= 4 && i2 > 188) {
                        return true;
                    }
                    cl.ABZ(iq.A00, 0, 4);
                    ip.A08(14);
                    int A052 = ip.A05(13);
                    if (A052 <= 6) {
                        return false;
                    }
                    cl.A3M(A052 - 6);
                    i2 += A052;
                }
            }
        } else {
            throw new RuntimeException();
        }
    }
}
