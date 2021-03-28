package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.facebook.ads.redexgen.X.Xs  reason: case insensitive filesystem */
public final class C0857Xs implements B3 {
    public static String[] A0E;
    public int A00;
    public int A01 = -1;
    public int A02;
    public int A03;
    public int A04 = -1;
    public int A05;
    public long A06;
    public ByteBuffer A07 = B3.A00;
    public ByteBuffer A08 = B3.A00;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public byte[] A0C = new byte[0];
    public byte[] A0D = new byte[0];

    static {
        A03();
    }

    public static void A03() {
        A0E = new String[]{"tvm2mqRs7a3ehYHdc1yBQoSNsWCnK", "tOWfSaULM8EnbecBF3SZtCA", "iNgvpQne2", "1AcoT6GEPIUQ3JZIKBz6KhI4GHeuy79P", "lryhUlLd6yxpw4rz006xnThMb", "3cZRB", "VTjWgXugqiR9aqruhTtZOoVTfcJyB76i", "EEKliZG5v6PVzs3xPcyqxwhc3FAivYta"};
    }

    private int A00(long j) {
        return (int) ((((long) this.A04) * j) / 1000000);
    }

    private int A01(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (Math.abs((int) byteBuffer.get(limit)) > 4) {
                int i = this.A00;
                return ((limit / i) * i) + i;
            }
        }
        int position = byteBuffer.position();
        String[] strArr = A0E;
        if (strArr[5].length() != strArr[1].length()) {
            String[] strArr2 = A0E;
            strArr2[5] = "KbmXU";
            strArr2[1] = "sStp2WQndpDzY5UDNElAkrU";
            return position;
        }
        throw new RuntimeException();
    }

    private int A02(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.get(position)) > 4) {
                int i = this.A00;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    private void A04(int i) {
        if (this.A07.capacity() < i) {
            this.A07 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.A07.clear();
        }
        if (i > 0) {
            this.A0A = true;
        }
    }

    private void A05(ByteBuffer byteBuffer) {
        A04(byteBuffer.remaining());
        this.A07.put(byteBuffer);
        this.A07.flip();
        this.A08 = this.A07;
    }

    private void A06(ByteBuffer byteBuffer) {
        int maybeSilenceInputSize = byteBuffer.limit();
        int A022 = A02(byteBuffer);
        int position = A022 - byteBuffer.position();
        byte[] bArr = this.A0C;
        int length = bArr.length;
        int maybeSilenceBufferRemaining = this.A02;
        int i = length - maybeSilenceBufferRemaining;
        if (A022 >= maybeSilenceInputSize || position >= i) {
            int min = Math.min(position, i);
            byteBuffer.limit(byteBuffer.position() + min);
            String[] strArr = A0E;
            if (strArr[0].length() != strArr[2].length()) {
                String[] strArr2 = A0E;
                strArr2[6] = "wWIHZuTOncQcUu5TT4FAsoGOHgVjS7Hw";
                strArr2[3] = "FL1HwHnzDnNmmMdWBTP73LL49pAAT75M";
                byteBuffer.get(this.A0C, this.A02, min);
                this.A02 += min;
                int i2 = this.A02;
                byte[] bArr2 = this.A0C;
                if (i2 == bArr2.length) {
                    if (this.A0A) {
                        A0A(bArr2, this.A03);
                        this.A06 += (long) ((this.A02 - (this.A03 * 2)) / this.A00);
                    } else {
                        this.A06 += (long) ((i2 - this.A03) / this.A00);
                    }
                    A09(byteBuffer, this.A0C, this.A02);
                    this.A02 = 0;
                    this.A05 = 2;
                }
                byteBuffer.limit(maybeSilenceInputSize);
                return;
            }
            throw new RuntimeException();
        }
        A0A(bArr, maybeSilenceBufferRemaining);
        this.A02 = 0;
        this.A05 = 0;
    }

    private void A07(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.A0C.length));
        int A012 = A01(byteBuffer);
        if (A012 == byteBuffer.position()) {
            this.A05 = 1;
        } else {
            byteBuffer.limit(A012);
            A05(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void A08(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int A022 = A02(byteBuffer);
        byteBuffer.limit(A022);
        this.A06 += (long) (byteBuffer.remaining() / this.A00);
        A09(byteBuffer, this.A0D, this.A03);
        if (A022 < limit) {
            A0A(this.A0D, this.A03);
            this.A05 = 0;
            byteBuffer.limit(limit);
        }
    }

    private void A09(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.A03);
        int i2 = this.A03 - min;
        System.arraycopy(bArr, i - i2, this.A0D, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.A0D, i2, min);
    }

    private void A0A(byte[] bArr, int i) {
        A04(i);
        this.A07.put(bArr, 0, i);
        this.A07.flip();
        this.A08 = this.A07;
    }

    public final long A0B() {
        return this.A06;
    }

    public final void A0C(boolean z) {
        this.A09 = z;
        flush();
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A47(int i, int i2, int i3) throws B2 {
        if (i3 == 2) {
            if (this.A04 == i) {
                int i4 = this.A01;
                if (A0E[4].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A0E;
                strArr[0] = "H8XMnFWveFctl2wFWM9cW2gP9UHr1";
                strArr[2] = "PgSQZHBtM";
                if (i4 == i2) {
                    return false;
                }
            }
            this.A04 = i;
            this.A01 = i2;
            this.A00 = i2 * 2;
            return true;
        }
        throw new B2(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final ByteBuffer A6a() {
        ByteBuffer byteBuffer = this.A08;
        this.A08 = B3.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6b() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6c() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6d() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7V() {
        return this.A04 != -1 && this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7Z() {
        return this.A0B && this.A08 == B3.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABu() {
        this.A0B = true;
        int i = this.A02;
        if (i > 0) {
            A0A(this.A0C, i);
        }
        if (!this.A0A) {
            this.A06 += (long) (this.A03 / this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABv(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.A08.hasRemaining()) {
            int i = this.A05;
            if (i != 0) {
                String[] strArr = A0E;
                if (strArr[5].length() != strArr[1].length()) {
                    String[] strArr2 = A0E;
                    strArr2[4] = "AiWUvfGcxq4zga3HVbzIicdLH";
                    strArr2[4] = "AiWUvfGcxq4zga3HVbzIicdLH";
                    if (i == 1) {
                        A06(byteBuffer);
                    } else if (i == 2) {
                        A08(byteBuffer);
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    throw new RuntimeException();
                }
            } else {
                A07(byteBuffer);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void flush() {
        if (A7V()) {
            int A002 = A00(150000) * this.A00;
            if (this.A0C.length != A002) {
                this.A0C = new byte[A002];
            }
            this.A03 = A00(20000) * this.A00;
            int length = this.A0D.length;
            int i = this.A03;
            if (length != i) {
                this.A0D = new byte[i];
            }
        }
        this.A05 = 0;
        this.A08 = B3.A00;
        this.A0B = false;
        this.A06 = 0;
        String[] strArr = A0E;
        if (strArr[5].length() != strArr[1].length()) {
            String[] strArr2 = A0E;
            strArr2[5] = "CYbGl";
            strArr2[1] = "FkXGzwkTO5dsiSfEVL3DvOQ";
            this.A02 = 0;
            this.A0A = false;
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void reset() {
        this.A09 = false;
        flush();
        this.A07 = B3.A00;
        this.A01 = -1;
        this.A04 = -1;
        this.A03 = 0;
        this.A0C = new byte[0];
        this.A0D = new byte[0];
    }
}
