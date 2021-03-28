package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Xl  reason: case insensitive filesystem */
public final class C0850Xl implements B3 {
    public static String[] A08;
    public int A00 = -1;
    public int A01 = -1;
    public ByteBuffer A02 = B3.A00;
    public ByteBuffer A03 = B3.A00;
    public boolean A04;
    public boolean A05;
    @Nullable
    public int[] A06;
    @Nullable
    public int[] A07;

    static {
        A00();
    }

    public static void A00() {
        A08 = new String[]{"hI95CJvP", "e7uFmzv8JlxhzV9w6wWiWm3C", "0BfqaNpqjs7ROgqNLFdYFDMF2kIE2JVl", "01nBjZj9wdoXPRYWJREYdbIjHTCf93fz", "xbIGt4PZ2jMEHXqvTGNBXf5J", "qzrNEKfdD0Je3OCcD1S0Cr1qEsV7v9mi", "0sM3QN", "C1cp7SniMnLQ2eyeNR7DTGSoW6Un2OTz"};
    }

    public final void A01(@Nullable int[] iArr) {
        this.A07 = iArr;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A47(int i, int i2, int i3) throws B2 {
        boolean z;
        boolean z2;
        boolean z3 = !Arrays.equals(this.A07, this.A06);
        this.A06 = this.A07;
        if (this.A06 == null) {
            this.A04 = false;
            return z3;
        } else if (i3 == 2) {
            if (!z3 && this.A01 == i) {
                int i4 = this.A00;
                String[] strArr = A08;
                if (strArr[6].length() != strArr[0].length()) {
                    String[] strArr2 = A08;
                    strArr2[6] = "gVI3SL";
                    strArr2[0] = "1HQF1tqI";
                    if (i4 == i2) {
                        return false;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            this.A01 = i;
            this.A00 = i2;
            if (i2 != this.A06.length) {
                z = true;
            } else {
                z = false;
            }
            this.A04 = z;
            int i5 = 0;
            while (true) {
                int[] iArr = this.A06;
                if (i5 >= iArr.length) {
                    return true;
                }
                int i6 = iArr[i5];
                if (i6 < i2) {
                    boolean z4 = this.A04;
                    if (i6 != i5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.A04 = z4 | z2;
                    i5++;
                } else {
                    throw new B2(i, i2, i3);
                }
            }
        } else {
            throw new B2(i, i2, i3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final ByteBuffer A6a() {
        ByteBuffer byteBuffer = this.A03;
        this.A03 = B3.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6b() {
        int[] iArr = this.A06;
        return iArr == null ? this.A00 : iArr.length;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6c() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6d() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7V() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7Z() {
        return this.A05 && this.A03 == B3.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABu() {
        this.A05 = true;
    }

    /* JADX INFO: Multiple debug info for r0v14 int: [D('channelIndex' int), D('frameCount' int)] */
    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABv(ByteBuffer byteBuffer) {
        boolean z;
        if (this.A06 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        int outputSize = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = this.A06.length * ((limit - outputSize) / (this.A00 * 2)) * 2;
        if (this.A02.capacity() < length) {
            this.A02 = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        while (outputSize < limit) {
            for (int frameCount : this.A06) {
                this.A02.putShort(byteBuffer.getShort((frameCount * 2) + outputSize));
            }
            outputSize += this.A00 * 2;
        }
        byteBuffer.position(limit);
        this.A02.flip();
        this.A03 = this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void flush() {
        this.A03 = B3.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void reset() {
        flush();
        this.A02 = B3.A00;
        this.A00 = -1;
        this.A01 = -1;
        this.A06 = null;
        this.A07 = null;
        this.A04 = false;
    }
}
