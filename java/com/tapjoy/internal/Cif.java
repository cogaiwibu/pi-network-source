package com.tapjoy.internal;

import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* renamed from: com.tapjoy.internal.if  reason: invalid class name */
public final class Cif {
    private final byte[] a = new byte[256];
    private ByteBuffer b;
    private ie c;
    private int d = 0;

    public final Cif a(byte[] bArr) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.b = null;
            Arrays.fill(this.a, (byte) 0);
            this.c = new ie();
            this.d = 0;
            ByteBuffer asReadOnlyBuffer = wrap.asReadOnlyBuffer();
            this.b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.b = null;
            this.c.b = 2;
        }
        return this;
    }

    public final ie a() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (h()) {
            return this.c;
        } else {
            d();
            if (!h()) {
                b();
                if (this.c.c < 0) {
                    this.c.b = 1;
                }
            }
            return this.c;
        }
    }

    private void b() {
        boolean z = false;
        while (!z && !h() && this.c.c <= Integer.MAX_VALUE) {
            int g = g();
            if (g == 33) {
                int g2 = g();
                if (g2 == 1) {
                    e();
                } else if (g2 == 249) {
                    this.c.d = new id();
                    g();
                    int g3 = g();
                    this.c.d.g = (g3 & 28) >> 2;
                    if (this.c.d.g == 0) {
                        this.c.d.g = 1;
                    }
                    this.c.d.f = (g3 & 1) != 0;
                    short s = this.b.getShort();
                    if (s < 2) {
                        s = 10;
                    }
                    this.c.d.i = s * 10;
                    this.c.d.h = g();
                    g();
                } else if (g2 == 254) {
                    e();
                } else if (g2 != 255) {
                    e();
                } else {
                    f();
                    String str = "";
                    for (int i = 0; i < 11; i++) {
                        str = str + ((char) this.a[i]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        c();
                    } else {
                        e();
                    }
                }
            } else if (g == 44) {
                if (this.c.d == null) {
                    this.c.d = new id();
                }
                this.c.d.a = this.b.getShort();
                this.c.d.b = this.b.getShort();
                this.c.d.c = this.b.getShort();
                this.c.d.d = this.b.getShort();
                int g4 = g();
                boolean z2 = (g4 & 128) != 0;
                int pow = (int) Math.pow(2.0d, (double) ((g4 & 7) + 1));
                this.c.d.e = (g4 & 64) != 0;
                if (z2) {
                    this.c.d.k = a(pow);
                } else {
                    this.c.d.k = null;
                }
                this.c.d.j = this.b.position();
                g();
                e();
                if (!h()) {
                    this.c.c++;
                    this.c.e.add(this.c.d);
                }
            } else if (g != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void c() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE);
                if (this.c.m == 0) {
                    this.c.m = -1;
                }
            }
            if (this.d <= 0) {
                return;
            }
        } while (!h());
    }

    private void d() {
        boolean z = false;
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) g());
        }
        if (!str.startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        this.c.f = this.b.getShort();
        this.c.g = this.b.getShort();
        int g = g();
        ie ieVar = this.c;
        if ((g & 128) != 0) {
            z = true;
        }
        ieVar.h = z;
        this.c.i = 2 << (g & 7);
        this.c.j = g();
        this.c.k = g();
        if (this.c.h && !h()) {
            ie ieVar2 = this.c;
            ieVar2.a = a(ieVar2.i);
            ie ieVar3 = this.c;
            ieVar3.l = ieVar3.a[this.c.j];
        }
    }

    private int[] a(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & UByte.MAX_VALUE;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & UByte.MAX_VALUE;
                int i8 = i6 + 1;
                int i9 = i2 + 1;
                iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & UByte.MAX_VALUE);
                i3 = i8;
                i2 = i9;
            }
        } catch (BufferUnderflowException unused) {
            this.c.b = 1;
        }
        return iArr;
    }

    private void e() {
        int g;
        do {
            try {
                g = g();
                this.b.position(this.b.position() + g);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (g > 0);
    }

    private int f() {
        int g = g();
        this.d = g;
        int i = 0;
        if (g > 0) {
            int i2 = 0;
            while (i < this.d) {
                try {
                    i2 = this.d - i;
                    this.b.get(this.a, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    Integer.valueOf(i);
                    Integer.valueOf(i2);
                    Integer.valueOf(this.d);
                    this.c.b = 1;
                }
            }
        }
        return i;
    }

    private int g() {
        try {
            return this.b.get() & UByte.MAX_VALUE;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private boolean h() {
        return this.c.b != 0;
    }
}
