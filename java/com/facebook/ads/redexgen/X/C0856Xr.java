package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* renamed from: com.facebook.ads.redexgen.X.Xr  reason: case insensitive filesystem */
public final class C0856Xr implements B3 {
    public static String[] A06;
    public int A00 = -1;
    public int A01 = 0;
    public int A02 = -1;
    public ByteBuffer A03 = B3.A00;
    public ByteBuffer A04 = B3.A00;
    public boolean A05;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"5utGUnn02b5VIzuc1FLHs1Qqi0fGEzz2", "DaG3Y2wQcTFt6n6rQ7Gr6iJZtSjkgUIR", "I5wcdOmu3UXBpwLMhd1MA2dM71iQzRTS", "a3TfZcOy08z7kq2pPCWxFv40lmZdIopZ", "nCxl35vO69EqZhEDDoDcGzJRz4rMZlE7", "Y5761Ga76B4ReZAKlzLfDyZ1gXjGXB3L", "t1lur4hbWemc11jTFC6OlnNGsbjhQ3VM", "6CnjKSKlGDDfBCJgDd7Ssr26upnReJdk"};
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A47(int i, int i2, int i3) throws B2 {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new B2(i, i2, i3);
        } else if (this.A02 == i && this.A00 == i2 && this.A01 == i3) {
            return false;
        } else {
            this.A02 = i;
            this.A00 = i2;
            this.A01 = i3;
            return true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final ByteBuffer A6a() {
        ByteBuffer byteBuffer = this.A04;
        this.A04 = B3.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6b() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6c() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final int A6d() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7V() {
        int i = this.A01;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final boolean A7Z() {
        return this.A05 && this.A04 == B3.A00;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABu() {
        this.A05 = true;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void ABv(ByteBuffer byteBuffer) {
        int i;
        int size = byteBuffer.position();
        int resampledSize = byteBuffer.limit();
        int i2 = resampledSize - size;
        int i3 = this.A01;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) * 2;
        } else if (i3 == 3) {
            i = i2 * 2;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        int capacity = this.A03.capacity();
        String[] strArr = A06;
        if (strArr[6].charAt(17) == strArr[3].charAt(17)) {
            String[] strArr2 = A06;
            strArr2[2] = "W94yXwDUFyNDAMV4dQ9gRwTb9HKmhar0";
            strArr2[1] = "UxSCLQ06z7wJwwSNZRUXPEmpHaH1zCeE";
            if (capacity < i) {
                this.A03 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
            } else {
                this.A03.clear();
            }
            int i4 = this.A01;
            if (i4 == Integer.MIN_VALUE) {
                while (size < resampledSize) {
                    this.A03.put(byteBuffer.get(size + 1));
                    this.A03.put(byteBuffer.get(size + 2));
                    size += 3;
                }
            } else if (i4 == 3) {
                while (size < resampledSize) {
                    this.A03.put((byte) 0);
                    this.A03.put((byte) ((byteBuffer.get(size) & UByte.MAX_VALUE) - 128));
                    size++;
                }
            } else if (i4 == 1073741824) {
                while (size < resampledSize) {
                    ByteBuffer byteBuffer2 = this.A03;
                    String[] strArr3 = A06;
                    if (strArr3[2].charAt(9) != strArr3[1].charAt(9)) {
                        String[] strArr4 = A06;
                        strArr4[2] = "sfuVTkj8IwDRAmHRKMELNpZyhpVkIKBS";
                        strArr4[1] = "Fl4ka6a0nXkGByMLlkeuhoftQnViDXP0";
                        byteBuffer2.put(byteBuffer.get(size + 2));
                        this.A03.put(byteBuffer.get(size + 3));
                        size += 4;
                    }
                }
            } else {
                throw new IllegalStateException();
            }
            byteBuffer.position(byteBuffer.limit());
            this.A03.flip();
            this.A04 = this.A03;
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void flush() {
        this.A04 = B3.A00;
        this.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.B3
    public final void reset() {
        flush();
        this.A02 = -1;
        this.A00 = -1;
        this.A01 = 0;
        this.A03 = B3.A00;
    }
}
