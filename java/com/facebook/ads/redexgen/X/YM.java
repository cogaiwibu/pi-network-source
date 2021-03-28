package com.facebook.ads.redexgen.X;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;
import java.util.Arrays;

public final class YM implements CK {
    public static byte[] A0F;
    public static String[] A0G;
    public static final CN A0H = new YL();
    public static final int A0I = C0466Ig.A08(A01(0, 3, 9));
    public int A00;
    public int A01 = 1;
    public int A02;
    public int A03;
    public long A04 = -9223372036854775807L;
    public long A05;
    public CM A06;
    public YK A07;
    public YP A08;
    public boolean A09;
    public final YN A0A = new YN();
    public final IQ A0B = new IQ(9);
    public final IQ A0C = new IQ(4);
    public final IQ A0D = new IQ();
    public final IQ A0E = new IQ(11);

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0F = new byte[]{-117, -111, -101};
    }

    public static void A04() {
        A0G = new String[]{"F9KwQMNMxiTjkayDhPM6gvDLkPvUNcLn", "Em4FZTw9NeUBCVsnasMEsqdbQrmSbGq", "", "tDq5h6G1X4d5RY1LfaFLZXWqT85DrCya", "B5R7X", "Y", "Zp00UWtElOmikRSXEs37FpNUTZ5eWL9Y", "wqRNyyxlEoRi9"};
    }

    static {
        A04();
        A03();
    }

    private IQ A00(CL cl) throws IOException, InterruptedException {
        if (this.A02 > this.A0D.A06()) {
            IQ iq = this.A0D;
            iq.A0c(new byte[Math.max(iq.A06() * 2, this.A02)], 0);
        } else {
            this.A0D.A0Z(0);
        }
        this.A0D.A0Y(this.A02);
        cl.readFully(this.A0D.A00, 0, this.A02);
        return this.A0D;
    }

    private void A02() {
        long j;
        if (!this.A09) {
            this.A06.ACk(new YH(-9223372036854775807L));
            this.A09 = true;
        }
        if (this.A04 == -9223372036854775807L) {
            if (this.A0A.A0E() == -9223372036854775807L) {
                j = -this.A05;
            } else {
                j = 0;
            }
            this.A04 = j;
        }
    }

    private void A05(CL cl) throws IOException, InterruptedException {
        cl.ADG(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    private boolean A06(CL cl) throws IOException, InterruptedException {
        boolean z;
        boolean hasAudio = false;
        if (!cl.AC2(this.A0B.A00, 0, 9, true)) {
            return false;
        }
        IQ iq = this.A0B;
        if (A0G[4].length() != 15) {
            String[] strArr = A0G;
            strArr[3] = "xxv79KM5VyarLmUhQqEOMlbbyGFtPWOG";
            strArr[6] = "n0W8PrJEyrqWl4lCbLWkK9bcjvpbO2Fn";
            iq.A0Z(0);
            this.A0B.A0a(4);
            int A0F2 = this.A0B.A0F();
            if ((A0F2 & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((A0F2 & 1) != 0) {
                hasAudio = true;
            }
            if (z && this.A07 == null) {
                this.A07 = new YK(this.A06.ADY(8, 1));
            }
            if (hasAudio && this.A08 == null) {
                this.A08 = new YP(this.A06.ADY(9, 2));
            }
            this.A06.A4w();
            this.A00 = (this.A0B.A09() - 9) + 4;
            this.A01 = 2;
            return true;
        }
        throw new RuntimeException();
    }

    private boolean A07(CL cl) throws IOException, InterruptedException {
        boolean z = true;
        if (this.A03 == 8 && this.A07 != null) {
            A02();
            this.A07.A00(A00(cl), this.A04 + this.A05);
        } else if (this.A03 == 9 && this.A08 != null) {
            A02();
            this.A08.A00(A00(cl), this.A04 + this.A05);
        } else if (this.A03 != 18 || this.A09) {
            int i = this.A02;
            if (A0G[4].length() != 15) {
                String[] strArr = A0G;
                strArr[0] = "mShHrd4Vu2jNkvRJUK8UrhhXjzgbGKl1";
                strArr[0] = "mShHrd4Vu2jNkvRJUK8UrhhXjzgbGKl1";
                cl.ADG(i);
                z = false;
            } else {
                throw new RuntimeException();
            }
        } else {
            this.A0A.A00(A00(cl), this.A05);
            long A0E2 = this.A0A.A0E();
            if (A0E2 != -9223372036854775807L) {
                this.A06.ACk(new YH(A0E2));
                this.A09 = true;
            }
        }
        this.A00 = 4;
        this.A01 = 2;
        return z;
    }

    private boolean A08(CL cl) throws IOException, InterruptedException {
        if (!cl.AC2(this.A0E.A00, 0, 11, true)) {
            return false;
        }
        this.A0E.A0Z(0);
        this.A03 = this.A0E.A0F();
        this.A02 = this.A0E.A0H();
        this.A05 = (long) this.A0E.A0H();
        this.A05 = (((long) (this.A0E.A0F() << 24)) | this.A05) * 1000;
        this.A0E.A0a(3);
        this.A01 = 4;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A06 = cm;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        while (true) {
            int i = this.A01;
            if (i != 1) {
                if (i == 2) {
                    A05(cl);
                } else if (A0G[4].length() != 15) {
                    String[] strArr = A0G;
                    strArr[4] = "ncW0XwKX3pgCRaaT";
                    strArr[4] = "ncW0XwKX3pgCRaaT";
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException();
                        } else if (A07(cl)) {
                            if (A0G[0].charAt(18) != 'j') {
                                String[] strArr2 = A0G;
                                strArr2[7] = "5";
                                strArr2[7] = "5";
                                return 0;
                            }
                            String[] strArr3 = A0G;
                            strArr3[7] = "DR5iBP2XCUKx659t";
                            strArr3[7] = "DR5iBP2XCUKx659t";
                            return 0;
                        }
                    } else if (!A08(cl)) {
                        return -1;
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (!A06(cl)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A01 = 1;
        this.A04 = -9223372036854775807L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        cl.ABZ(this.A0C.A00, 0, 3);
        this.A0C.A0Z(0);
        if (this.A0C.A0H() != A0I) {
            return false;
        }
        cl.ABZ(this.A0C.A00, 0, 2);
        this.A0C.A0Z(0);
        if ((this.A0C.A0J() & IronSourceConstants.INTERSTITIAL_DAILY_CAPPED) != 0) {
            return false;
        }
        cl.ABZ(this.A0C.A00, 0, 4);
        this.A0C.A0Z(0);
        int A092 = this.A0C.A09();
        cl.ACa();
        cl.A3M(A092);
        cl.ABZ(this.A0C.A00, 0, 4);
        this.A0C.A0Z(0);
        if (this.A0C.A09() == 0) {
            return true;
        }
        return false;
    }
}
