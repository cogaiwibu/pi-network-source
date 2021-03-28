package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.Arrays;

public final class DU {
    public static String[] A0I;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public DT A06 = new DT();
    public DT A07 = new DT();
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public byte[] A0B = new byte[128];
    public final SparseArray<IK> A0C = new SparseArray<>();
    public final SparseArray<IL> A0D = new SparseArray<>();
    public final CW A0E;
    public final IR A0F = new IR(this.A0B, 0, 0);
    public final boolean A0G;
    public final boolean A0H;

    static {
        A00();
    }

    public static void A00() {
        A0I = new String[]{"4oBn500ONSa7zUcj69ZejwliI7fNkQe9", "sao3", "S05M", "dUQbnZGK3vs92wXndxl51oc8w6Wzg5UK", "r2dYBwwJ6wCRp20YpqJDniAkemsUTuNE", "fcxFuh", "wirhT", "AIyirGzN48rHG0XGibSi5d9zNx7vdYO1"};
    }

    public DU(CW cw, boolean z, boolean z2) {
        this.A0E = cw;
        this.A0G = z;
        this.A0H = z2;
        A02();
    }

    private void A01(int i) {
        boolean z = this.A0A;
        this.A0E.ACf(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i, null);
    }

    public final void A02() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A03();
    }

    public final void A03(long j, int i) {
        boolean z = false;
        if (this.A01 == 9 || (this.A0H && (this.A07.A01(this.A06)))) {
            if (this.A09) {
                A01(i + ((int) (j - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        boolean z2 = this.A0A;
        int i2 = this.A01;
        if (i2 == 5 || (this.A0G && i2 == 1 && this.A07.A06())) {
            z = true;
        }
        this.A0A = z2 | z;
    }

    public final void A04(long j, int i, long j2) {
        this.A01 = i;
        this.A03 = j2;
        this.A02 = j;
        if (!this.A0G || this.A01 != 1) {
            if (this.A0H) {
                int i2 = this.A01;
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            } else {
                return;
            }
        }
        DT dt = this.A06;
        this.A06 = this.A07;
        this.A07 = dt;
        this.A07.A03();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A05(IK ik) {
        this.A0C.append(ik.A00, ik);
    }

    public final void A06(IL il) {
        this.A0D.append(il.A05, il);
    }

    /* JADX INFO: Multiple debug info for r1v31 com.facebook.ads.redexgen.X.IK: [D('picParameterSetId' int), D('ppsData' com.facebook.ads.redexgen.X.IK), D('deltaPicOrderCnt0' int)] */
    public final void A07(byte[] bArr, int readLength, int i) {
        boolean z;
        if (this.A08) {
            int i2 = i - readLength;
            byte[] bArr2 = this.A0B;
            int length = bArr2.length;
            int i3 = this.A00;
            if (length < i3 + i2) {
                this.A0B = Arrays.copyOf(bArr2, (i3 + i2) * 2);
            }
            System.arraycopy(bArr, readLength, this.A0B, this.A00, i2);
            this.A00 += i2;
            this.A0F.A09(this.A0B, 0, this.A00);
            if (this.A0F.A0C(8)) {
                this.A0F.A07();
                int deltaPicOrderCnt1 = this.A0F.A06(2);
                this.A0F.A08(5);
                if (this.A0F.A0A()) {
                    this.A0F.A05();
                    if (this.A0F.A0A()) {
                        int A052 = this.A0F.A05();
                        if (!this.A0H) {
                            this.A08 = false;
                            this.A07.A04(A052);
                        } else if (this.A0F.A0A()) {
                            int A053 = this.A0F.A05();
                            String[] strArr = A0I;
                            if (strArr[0].charAt(5) != strArr[3].charAt(5)) {
                                String[] strArr2 = A0I;
                                strArr2[6] = "2v7XO";
                                strArr2[6] = "2v7XO";
                                if (this.A0C.indexOfKey(A053) < 0) {
                                    this.A08 = false;
                                    return;
                                }
                                IK ppsData = this.A0C.get(A053);
                                IL il = this.A0D.get(ppsData.A01);
                                if (il.A09) {
                                    if (this.A0F.A0C(2)) {
                                        this.A0F.A08(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.A0F.A0C(il.A01)) {
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    boolean z4 = false;
                                    int A062 = this.A0F.A06(il.A01);
                                    if (!il.A08) {
                                        if (this.A0F.A0C(1)) {
                                            z2 = this.A0F.A0B();
                                            if (!z2) {
                                                String[] strArr3 = A0I;
                                                if (strArr3[2].length() == strArr3[1].length()) {
                                                    String[] strArr4 = A0I;
                                                    strArr4[4] = "qwcYbvbtciQlsge07t8jnpQbFFEGYRzL";
                                                    strArr4[4] = "qwcYbvbtciQlsge07t8jnpQbFFEGYRzL";
                                                }
                                            } else if (this.A0F.A0C(1)) {
                                                z4 = this.A0F.A0B();
                                                z3 = true;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    if (this.A01 == 5) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    int i4 = 0;
                                    if (z) {
                                        if (this.A0F.A0A()) {
                                            IR ir = this.A0F;
                                            if (A0I[5].length() != 32) {
                                                String[] strArr5 = A0I;
                                                strArr5[0] = "CUn0EGRMZuaxcZmcWt6bm8g2eSLscmSu";
                                                strArr5[3] = "AO4oaRrhS9J5INJLsqTeqW6rWo7URvM3";
                                                i4 = ir.A05();
                                            } else {
                                                throw new RuntimeException();
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (il.A04 != 0) {
                                        int picOrderCntLsb = il.A04;
                                        if (A0I[7].charAt(28) != 'l') {
                                            String[] strArr6 = A0I;
                                            strArr6[7] = "MOrewcskpOrth27AIRJiHCsaXTOPbZzW";
                                            strArr6[7] = "MOrewcskpOrth27AIRJiHCsaXTOPbZzW";
                                            if (picOrderCntLsb == 1 && !il.A07) {
                                                if (this.A0F.A0A()) {
                                                    i7 = this.A0F.A04();
                                                    if (ppsData.A02 && !z2) {
                                                        if (this.A0F.A0A()) {
                                                            i8 = this.A0F.A04();
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            throw new RuntimeException();
                                        }
                                    } else if (this.A0F.A0C(il.A03)) {
                                        IR ir2 = this.A0F;
                                        int i9 = il.A03;
                                        if (A0I[7].charAt(28) != 108) {
                                            String[] strArr7 = A0I;
                                            strArr7[4] = "13MW05H83xonKdXxuFb2nSy24rNhSBqM";
                                            strArr7[4] = "13MW05H83xonKdXxuFb2nSy24rNhSBqM";
                                            i5 = ir2.A06(i9);
                                            if (ppsData.A02 && !z2) {
                                                if (this.A0F.A0A()) {
                                                    i6 = this.A0F.A04();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    } else {
                                        return;
                                    }
                                    this.A07.A05(il, deltaPicOrderCnt1, A052, A062, A053, z2, z3, z4, z, i4, i5, i6, i7, i8);
                                    this.A08 = false;
                                    return;
                                }
                                return;
                            }
                            throw new RuntimeException();
                        }
                    }
                }
            }
        }
    }

    public final boolean A08() {
        return this.A0H;
    }
}
