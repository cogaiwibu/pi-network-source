package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* renamed from: com.facebook.ads.redexgen.X.Xu  reason: case insensitive filesystem */
public final class C0859Xu implements B3 {
    public static String[] A0D;
    public float A00 = 1.0f;
    public float A01 = 1.0f;
    public int A02 = -1;
    public int A03 = -1;
    public int A04 = -1;
    public int A05 = -1;
    public long A06;
    public long A07;
    @Nullable
    public BY A08;
    public ByteBuffer A09 = B3.A00;
    public ByteBuffer A0A = B3.A00;
    public ShortBuffer A0B = this.A09.asShortBuffer();
    public boolean A0C;

    static {
        A00();
    }

    public static void A00() {
        A0D = new String[]{"iVI49d2ZLsEdnN", "8nt9Mx90pYcLgm8jwIqfRxnuNB", "N5EnT7xPV04alRStuSSEb4qxGw0ypgBS", "CZFk7KMkAj1VPwfzqXgnV4RMFN6v0v1b", "0r4SPeKqFHrxpG", "Bbc1ECWkbstPDX5EGN6JJHjdPo9FJmAx", "C6RSY0Y2UTdbfyI9HBBCvYbiYc", "niyGYsc3TbIZXUeN92sM43TjCNQsZLKY"};
    }

    public final float A01(float f) {
        float A002 = C0466Ig.A00(f, 0.1f, 8.0f);
        if (this.A00 != A002) {
            this.A00 = A002;
            this.A08 = null;
        }
        flush();
        return A002;
    }

    public final float A02(float f) {
        float A002 = C0466Ig.A00(f, 0.1f, 8.0f);
        if (this.A01 != A002) {
            this.A01 = A002;
            this.A08 = null;
        }
        flush();
        return A002;
    }

    public final long A03(long j) {
        long j2 = this.A07;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return (long) (((double) this.A01) * ((double) j));
        }
        int i = this.A03;
        int i2 = this.A05;
        if (i == i2) {
            return C0466Ig.A0F(j, this.A06, j2);
        }
        return C0466Ig.A0F(j, this.A06 * ((long) i), j2 * ((long) i2));
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A47(int i, int i2, int i3) throws B2 {
        if (i3 == 2) {
            int i4 = this.A04;
            if (i4 == -1) {
                i4 = i;
            }
            if (this.A05 == i && this.A02 == i2 && this.A03 == i4) {
                return false;
            }
            this.A05 = i;
            this.A02 = i2;
            this.A03 = i4;
            this.A08 = null;
            return true;
        }
        throw new B2(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final ByteBuffer A6a() {
        ByteBuffer byteBuffer = this.A0A;
        this.A0A = B3.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6b() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6c() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6d() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7V() {
        if (this.A05 != -1) {
            if (Math.abs(this.A01 - 1.0f) < 0.01f) {
                float abs = Math.abs(this.A00 - 1.0f);
                String[] strArr = A0D;
                if (strArr[6].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "vE55EECrsMoThx";
                strArr2[0] = "BaJHYxULwHsid1";
                if (abs >= 0.01f || this.A03 != this.A05) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7Z() {
        BY by;
        return this.A0C && ((by = this.A08) == null || by.A0I() == 0);
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABu() {
        boolean z;
        if (this.A08 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        this.A08.A0K();
        this.A0C = true;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.Xu: [D('shortBuffer' java.nio.ShortBuffer), D('outputSize' int)] */
    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABv(ByteBuffer byteBuffer) {
        boolean z;
        if (this.A08 != null) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.A06 += (long) remaining;
            this.A08.A0M(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int A0I = this.A08.A0I() * this.A02 * 2;
        if (A0I > 0) {
            if (this.A09.capacity() < A0I) {
                this.A09 = ByteBuffer.allocateDirect(A0I).order(ByteOrder.nativeOrder());
                this.A0B = this.A09.asShortBuffer();
            } else {
                this.A09.clear();
                this.A0B.clear();
            }
            this.A08.A0L(this.A0B);
            this.A07 += (long) A0I;
            this.A09.limit(A0I);
            this.A0A = this.A09;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void flush() {
        if (A7V()) {
            BY by = this.A08;
            if (by == null) {
                this.A08 = new BY(this.A05, this.A02, this.A01, this.A00, this.A03);
            } else {
                by.A0J();
            }
        }
        this.A0A = B3.A00;
        this.A06 = 0;
        this.A07 = 0;
        this.A0C = false;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void reset() {
        this.A01 = 1.0f;
        this.A00 = 1.0f;
        this.A02 = -1;
        this.A05 = -1;
        this.A03 = -1;
        this.A09 = B3.A00;
        this.A0B = this.A09.asShortBuffer();
        this.A0A = B3.A00;
        this.A04 = -1;
        this.A08 = null;
        this.A06 = 0;
        this.A07 = 0;
        this.A0C = false;
    }
}
