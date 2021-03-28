package com.tapjoy.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.imageutils.JfifUtil;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.UByte;

public final class ir implements is, it, Cloneable {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    iy a;
    long b;

    @Override // com.tapjoy.internal.is
    public final is a() {
        return this;
    }

    @Override // com.tapjoy.internal.jc, com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.tapjoy.internal.jb, java.io.Flushable
    public final void flush() {
    }

    @Override // com.tapjoy.internal.it
    public final boolean b() {
        return this.b == 0;
    }

    @Override // com.tapjoy.internal.it
    public final void a(long j) {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // com.tapjoy.internal.it
    public final byte c() {
        if (this.b != 0) {
            iy iyVar = this.a;
            int i = iyVar.b;
            int i2 = iyVar.c;
            int i3 = i + 1;
            byte b2 = iyVar.a[i];
            this.b--;
            if (i3 == i2) {
                this.a = iyVar.a();
                iz.a(iyVar);
            } else {
                iyVar.b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final int d() {
        if (this.b >= 4) {
            iy iyVar = this.a;
            int i = iyVar.b;
            int i2 = iyVar.c;
            if (i2 - i < 4) {
                return ((c() & UByte.MAX_VALUE) << 24) | ((c() & UByte.MAX_VALUE) << 16) | ((c() & UByte.MAX_VALUE) << 8) | (c() & UByte.MAX_VALUE);
            }
            byte[] bArr = iyVar.a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
            this.b -= 4;
            if (i8 == i2) {
                this.a = iyVar.a();
                iz.a(iyVar);
            } else {
                iyVar.b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.b);
    }

    @Override // com.tapjoy.internal.it
    public final int e() {
        return je.a(d());
    }

    @Override // com.tapjoy.internal.it
    public final iu b(long j) {
        return new iu(g(j));
    }

    @Override // com.tapjoy.internal.it
    public final String c(long j) {
        Charset charset = je.a;
        je.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            iy iyVar = this.a;
            if (((long) iyVar.b) + j > ((long) iyVar.c)) {
                return new String(g(j), charset);
            }
            String str = new String(iyVar.a, iyVar.b, (int) j, charset);
            iyVar.b = (int) (((long) iyVar.b) + j);
            this.b -= j;
            if (iyVar.b == iyVar.c) {
                this.a = iyVar.a();
                iz.a(iyVar);
            }
            return str;
        }
    }

    public final byte[] g() {
        try {
            return g(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    private byte[] g(long j) {
        je.a(this.b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    private void a(byte[] bArr) {
        int i;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            je.a((long) bArr.length, (long) i2, (long) length);
            iy iyVar = this.a;
            if (iyVar == null) {
                i = -1;
            } else {
                i = Math.min(length, iyVar.c - iyVar.b);
                System.arraycopy(iyVar.a, iyVar.b, bArr, i2, i);
                iyVar.b += i;
                this.b -= (long) i;
                if (iyVar.b == iyVar.c) {
                    this.a = iyVar.a();
                    iz.a(iyVar);
                }
            }
            if (i != -1) {
                i2 += i;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // com.tapjoy.internal.it
    public final void d(long j) {
        while (j > 0) {
            iy iyVar = this.a;
            if (iyVar != null) {
                int min = (int) Math.min(j, (long) (iyVar.c - this.a.b));
                long j2 = (long) min;
                this.b -= j2;
                j -= j2;
                this.a.b += min;
                if (this.a.b == this.a.c) {
                    iy iyVar2 = this.a;
                    this.a = iyVar2.a();
                    iz.a(iyVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public final ir b(iu iuVar) {
        if (iuVar != null) {
            iuVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public final ir b(String str) {
        char c2;
        char charAt;
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        } else if (length <= str.length()) {
            int i = 0;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    iy c3 = c(1);
                    byte[] bArr = c3.a;
                    int i2 = c3.c - i;
                    int min = Math.min(length, 8192 - i2);
                    int i3 = i + 1;
                    bArr[i + i2] = (byte) charAt2;
                    while (true) {
                        i = i3;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i4 = (i2 + i) - c3.c;
                            c3.c += i4;
                            this.b += (long) i4;
                        } else {
                            i3 = i + 1;
                            bArr[i + i2] = (byte) charAt;
                        }
                    }
                    int i42 = (i2 + i) - c3.c;
                    c3.c += i42;
                    this.b += (long) i42;
                } else {
                    if (charAt2 < 2048) {
                        e((charAt2 >> 6) | JfifUtil.MARKER_SOFn);
                        e((charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        e((charAt2 >> '\f') | 224);
                        e(((charAt2 >> 6) & 63) | 128);
                        e((charAt2 & '?') | 128);
                    } else {
                        int i5 = i + 1;
                        if (i5 < length) {
                            c2 = str.charAt(i5);
                        } else {
                            c2 = 0;
                        }
                        if (charAt2 > 56319 || c2 < 56320 || c2 > 57343) {
                            e(63);
                            i = i5;
                        } else {
                            int i6 = (((charAt2 & 10239) << 10) | (9215 & c2)) + 65536;
                            e((i6 >> 18) | 240);
                            e(((i6 >> 12) & 63) | 128);
                            e(((i6 >> 6) & 63) | 128);
                            e((i6 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        }
    }

    public final ir a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            je.a((long) bArr.length, 0, j);
            int i3 = i2 + 0;
            while (i < i3) {
                iy c2 = c(1);
                int min = Math.min(i3 - i, 8192 - c2.c);
                System.arraycopy(bArr, i, c2.a, c2.c, min);
                i += min;
                c2.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public final ir e(int i) {
        iy c2 = c(1);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        c2.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    /* renamed from: b */
    public final ir d(int i) {
        int a2 = je.a(i);
        iy c2 = c(4);
        byte[] bArr = c2.a;
        int i2 = c2.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((a2 >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((a2 >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((a2 >>> 8) & 255);
        bArr[i5] = (byte) (a2 & 255);
        c2.c = i5 + 1;
        this.b += 4;
        return this;
    }

    /* renamed from: e */
    public final ir f(long j) {
        long a2 = je.a(j);
        iy c2 = c(8);
        byte[] bArr = c2.a;
        int i = c2.c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((a2 >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((a2 >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((a2 >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((a2 >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((a2 >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((a2 >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((a2 >>> 8) & 255));
        bArr[i8] = (byte) ((int) (a2 & 255));
        c2.c = i8 + 1;
        this.b += 8;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final iy c(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        iy iyVar = this.a;
        if (iyVar == null) {
            iy a2 = iz.a();
            this.a = a2;
            a2.g = a2;
            a2.f = a2;
            return a2;
        }
        iy iyVar2 = iyVar.g;
        return (iyVar2.c + i > 8192 || !iyVar2.e) ? iyVar2.a(iz.a()) : iyVar2;
    }

    @Override // com.tapjoy.internal.jb
    public final void a(ir irVar, long j) {
        iy iyVar;
        if (irVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (irVar != this) {
            je.a(irVar.b, 0, j);
            while (j > 0) {
                int i = 0;
                if (j < ((long) (irVar.a.c - irVar.a.b))) {
                    iy iyVar2 = this.a;
                    iy iyVar3 = iyVar2 != null ? iyVar2.g : null;
                    if (iyVar3 != null && iyVar3.e) {
                        if ((((long) iyVar3.c) + j) - ((long) (iyVar3.d ? 0 : iyVar3.b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            irVar.a.a(iyVar3, (int) j);
                            irVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    iy iyVar4 = irVar.a;
                    int i2 = (int) j;
                    if (i2 <= 0 || i2 > iyVar4.c - iyVar4.b) {
                        throw new IllegalArgumentException();
                    }
                    if (i2 >= 1024) {
                        iyVar = new iy(iyVar4);
                    } else {
                        iyVar = iz.a();
                        System.arraycopy(iyVar4.a, iyVar4.b, iyVar.a, 0, i2);
                    }
                    iyVar.c = iyVar.b + i2;
                    iyVar4.b += i2;
                    iyVar4.g.a(iyVar);
                    irVar.a = iyVar;
                }
                iy iyVar5 = irVar.a;
                long j2 = (long) (iyVar5.c - iyVar5.b);
                irVar.a = iyVar5.a();
                iy iyVar6 = this.a;
                if (iyVar6 == null) {
                    this.a = iyVar5;
                    iyVar5.g = iyVar5;
                    iyVar5.f = iyVar5;
                } else {
                    iy a2 = iyVar6.g.a(iyVar5);
                    if (a2.g == a2) {
                        throw new IllegalStateException();
                    } else if (a2.g.e) {
                        int i3 = a2.c - a2.b;
                        int i4 = 8192 - a2.g.c;
                        if (!a2.g.d) {
                            i = a2.g.b;
                        }
                        if (i3 <= i4 + i) {
                            a2.a(a2.g, i3);
                            a2.a();
                            iz.a(a2);
                        }
                    }
                }
                irVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    @Override // com.tapjoy.internal.jc
    public final long b(ir irVar, long j) {
        if (irVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            irVar.a(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ir)) {
            return false;
        }
        ir irVar = (ir) obj;
        long j = this.b;
        if (j != irVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        iy iyVar = this.a;
        iy iyVar2 = irVar.a;
        int i = iyVar.b;
        int i2 = iyVar2.b;
        while (j2 < this.b) {
            long min = (long) Math.min(iyVar.c - i, iyVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (iyVar.a[i] != iyVar2.a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == iyVar.c) {
                iyVar = iyVar.f;
                i = iyVar.b;
            }
            if (i2 == iyVar2.c) {
                iyVar2 = iyVar2.f;
                i2 = iyVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    public final int hashCode() {
        iy iyVar = this.a;
        if (iyVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = iyVar.c;
            for (int i3 = iyVar.b; i3 < i2; i3++) {
                i = (i * 31) + iyVar.a[i3];
            }
            iyVar = iyVar.f;
        } while (iyVar != this.a);
        return i;
    }

    /* renamed from: h */
    public final ir clone() {
        ir irVar = new ir();
        if (this.b == 0) {
            return irVar;
        }
        iy iyVar = new iy(this.a);
        irVar.a = iyVar;
        iyVar.g = iyVar;
        iyVar.f = iyVar;
        iy iyVar2 = this.a;
        while (true) {
            iyVar2 = iyVar2.f;
            if (iyVar2 != this.a) {
                irVar.a.g.a(new iy(iyVar2));
            } else {
                irVar.b = this.b;
                return irVar;
            }
        }
    }

    @Override // com.tapjoy.internal.it
    public final long f() {
        long j;
        if (this.b >= 8) {
            iy iyVar = this.a;
            int i = iyVar.b;
            int i2 = iyVar.c;
            if (i2 - i < 8) {
                j = ((((long) d()) & 4294967295L) << 32) | (4294967295L & ((long) d()));
            } else {
                byte[] bArr = iyVar.a;
                int i3 = i + 1;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                long j2 = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                long j3 = (((long) bArr[i9]) & 255) | ((((long) bArr[i8]) & 255) << 8) | j2;
                this.b -= 8;
                if (i10 == i2) {
                    this.a = iyVar.a();
                    iz.a(iyVar);
                } else {
                    iyVar.b = i10;
                }
                j = j3;
            }
            return je.a(j);
        }
        throw new IllegalStateException("size < 8: " + this.b);
    }

    public final String toString() {
        iu iuVar;
        long j = this.b;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                iuVar = iu.b;
            } else {
                iuVar = new ja(this, i);
            }
            return iuVar.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }
}
