package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ga  reason: case insensitive filesystem */
public final class C0408Ga {
    public static String[] A09;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final IQ A07 = new IQ();
    public final int[] A08 = new int[256];

    static {
        A00();
    }

    public static void A00() {
        A09 = new String[]{"dgnk6daQ0T87wOoHtyty7iRYaKvd8BzP", "TK3sWG", "r0T7HSyuXxeUz69yLbXIR4BhIiF2UDCf", "E94UIter8sht222SneNEBcgvWBNv8GHv", "qg4jsBrtjCwX7ZbqQAPOhxC1noKxQthL", "J", "sUrKaEkRL4ABh9brwle2ScDHOfoRuahW", "YVc6k2"};
    }

    /* access modifiers changed from: private */
    public void A04(IQ iq, int i) {
        boolean z;
        int A0H;
        if (i >= 4) {
            iq.A0a(3);
            if ((iq.A0F() & 128) != 0) {
                z = true;
            } else {
                z = false;
            }
            int i2 = i - 4;
            if (z) {
                if (i2 >= 7 && (A0H = iq.A0H()) >= 4) {
                    this.A01 = iq.A0J();
                    this.A00 = iq.A0J();
                    this.A07.A0X(A0H - 4);
                    i2 -= 7;
                } else {
                    return;
                }
            }
            int A072 = this.A07.A07();
            int A082 = this.A07.A08();
            if (A072 < A082 && i2 > 0) {
                int bytesToRead = Math.min(i2, A082 - A072);
                iq.A0d(this.A07.A00, A072, bytesToRead);
                this.A07.A0Z(A072 + bytesToRead);
            }
        }
    }

    /* access modifiers changed from: private */
    public void A05(IQ iq, int i) {
        if (i >= 19) {
            this.A05 = iq.A0J();
            this.A04 = iq.A0J();
            iq.A0a(11);
            this.A02 = iq.A0J();
            this.A03 = iq.A0J();
        }
    }

    /* JADX INFO: Multiple debug info for r0v5 int: [D('i' int), D('cb' int)] */
    /* access modifiers changed from: private */
    public void A06(IQ iq, int i) {
        if (i % 5 == 2) {
            iq.A0a(2);
            Arrays.fill(this.A08, 0);
            int i2 = i / 5;
            for (int r = 0; r < i2; r++) {
                int A0F = iq.A0F();
                int A0F2 = iq.A0F();
                int A0F3 = iq.A0F();
                int A0F4 = iq.A0F();
                this.A08[A0F] = (iq.A0F() << 24) | (C0466Ig.A06((int) (((double) A0F2) + (((double) (A0F3 - 128)) * 1.402d)), 0, 255) << 16) | (C0466Ig.A06((int) ((((double) A0F2) - (((double) (A0F4 - 128)) * 0.34414d)) - (((double) (A0F3 - 128)) * 0.71414d)), 0, 255) << 8) | C0466Ig.A06((int) (((double) A0F2) + (((double) (A0F4 - 128)) * 1.772d)), 0, 255);
            }
            this.A06 = true;
        }
    }

    public final GF A07() {
        int A0F;
        int i;
        if (this.A05 == 0 || this.A04 == 0 || this.A01 == 0 || this.A00 == 0 || this.A07.A08() == 0 || this.A07.A07() != this.A07.A08() || !this.A06) {
            return null;
        }
        this.A07.A0Z(0);
        int[] iArr = new int[(this.A01 * this.A00)];
        int i2 = 0;
        while (i2 < iArr.length) {
            int A0F2 = this.A07.A0F();
            if (A0F2 != 0) {
                iArr[i2] = this.A08[A0F2];
                i2++;
            } else {
                int A0F3 = this.A07.A0F();
                if (A0F3 == 0) {
                    continue;
                } else {
                    if ((A0F3 & 64) == 0) {
                        A0F = A0F3 & 63;
                    } else {
                        A0F = ((A0F3 & 63) << 8) | this.A07.A0F();
                    }
                    if ((A0F3 & 128) == 0) {
                        i = 0;
                    } else {
                        int[] iArr2 = this.A08;
                        IQ iq = this.A07;
                        String[] strArr = A09;
                        if (strArr[6].length() != strArr[2].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A09;
                        strArr2[6] = "LobxqobSp0chhe0OZFFwjgoplyKrXQLj";
                        strArr2[2] = "nSlIIcYQrdb8UpaoVkH7kLQAXSG8FoO0";
                        i = iArr2[iq.A0F()];
                    }
                    Arrays.fill(iArr, i2, i2 + A0F, i);
                    i2 += A0F;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, this.A01, this.A00, Bitmap.Config.ARGB_8888);
        int i3 = this.A05;
        int i4 = this.A04;
        return new GF(createBitmap, ((float) this.A02) / ((float) i3), 0, ((float) this.A03) / ((float) i4), 0, ((float) this.A01) / ((float) i3), ((float) this.A00) / ((float) i4));
    }

    public final void A08() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0X(0);
        this.A06 = false;
    }
}
