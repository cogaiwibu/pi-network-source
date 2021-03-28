package com.facebook.ads.redexgen.X;

import androidx.core.view.InputDeviceCompat;

public final class Z8 implements AbstractC0341Df {
    public static String[] A06;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final DY A04;
    public final IQ A05 = new IQ(32);

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"kFQyFzcAtW9h", "T9w", "fQaNjl3SJX3d9bVQ", "oZJ95vdSt2TTHBWCj0JXn5a7ndpZ8Bju", "u9yp8kydrxa7", "6VdIrZzllDHdfU7GHzHok5zrzcn9yZKG", "C5", "TRfT7Vv0"};
    }

    public Z8(DY dy) {
        this.A04 = dy;
    }

    /* JADX INFO: Multiple debug info for r8v0 com.facebook.ads.redexgen.X.IQ: [D('tableId' int), D('bodyBytesToRead' int), D('headerBytesToRead' int), D('payloadStartOffset' int)] */
    /* JADX INFO: Multiple debug info for r5v4 byte[]: [D('secondHeaderByte' int), D('bytes' byte[])] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0341Df
    public final void A49(IQ iq, boolean z) {
        int i = -1;
        if (z) {
            i = iq.A07() + iq.A0F();
        }
        boolean z2 = this.A03;
        if (A06[1].length() != 27) {
            String[] strArr = A06;
            strArr[7] = "Nc9T8xtu";
            strArr[7] = "Nc9T8xtu";
            if (z2) {
                if (z) {
                    this.A03 = false;
                    iq.A0Z(i);
                    this.A00 = 0;
                } else {
                    return;
                }
            }
            while (iq.A05() > 0) {
                int i2 = this.A00;
                boolean z3 = true;
                if (i2 < 3) {
                    if (i2 == 0) {
                        int A0F = iq.A0F();
                        iq.A0Z(iq.A07() - 1);
                        if (A06[7].length() != 8) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A06;
                        strArr2[2] = "aJNwIS78aN3JetqFlJ8G";
                        strArr2[2] = "aJNwIS78aN3JetqFlJ8G";
                        if (A0F == 255) {
                            this.A03 = true;
                            return;
                        }
                    }
                    int min = Math.min(iq.A05(), 3 - this.A00);
                    iq.A0d(this.A05.A00, this.A00, min);
                    this.A00 += min;
                    if (this.A00 == 3) {
                        this.A05.A0X(3);
                        this.A05.A0a(1);
                        int A0F2 = this.A05.A0F();
                        int A0F3 = this.A05.A0F();
                        if ((A0F2 & 128) == 0) {
                            z3 = false;
                        }
                        this.A02 = z3;
                        this.A01 = (((A0F2 & 15) << 8) | A0F3) + 3;
                        if (this.A05.A06() < this.A01) {
                            byte[] bytes = this.A05.A00;
                            this.A05.A0X(Math.min((int) InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(this.A01, bytes.length * 2)));
                            System.arraycopy(bytes, 0, this.A05.A00, 0, 3);
                        }
                    }
                } else {
                    int min2 = Math.min(iq.A05(), this.A01 - this.A00);
                    iq.A0d(this.A05.A00, this.A00, min2);
                    this.A00 += min2;
                    int i3 = this.A00;
                    int i4 = this.A01;
                    if (i3 == i4) {
                        boolean z4 = this.A02;
                        if (A06[7].length() != 8) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A06;
                        strArr3[1] = "WscUDiyP9zB";
                        strArr3[1] = "WscUDiyP9zB";
                        if (!z4) {
                            this.A05.A0X(i4);
                        } else if (C0466Ig.A09(this.A05.A00, 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        } else {
                            IQ iq2 = this.A05;
                            int thirdHeaderByte = this.A01 - 4;
                            if (A06[2].length() != 29) {
                                String[] strArr4 = A06;
                                strArr4[3] = "nNiCCranccCPI0NRpeExr6ylwZyZykwG";
                                strArr4[5] = "pfAdcnCCuWORkUPhfNuwqkYYK2fT2IOL";
                                iq2.A0X(thirdHeaderByte);
                            } else {
                                String[] strArr5 = A06;
                                strArr5[2] = "0kjAgxStX";
                                strArr5[2] = "0kjAgxStX";
                                iq2.A0X(thirdHeaderByte);
                            }
                        }
                        this.A04.A48(this.A05);
                        this.A00 = 0;
                    } else {
                        continue;
                    }
                }
            }
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0341Df
    public final void A7S(C0462Ic ic, CM cm, C0340De de) {
        this.A04.A7S(ic, cm, de);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0341Df
    public final void ACi() {
        this.A03 = true;
    }
}
