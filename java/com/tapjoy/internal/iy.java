package com.tapjoy.internal;

/* access modifiers changed from: package-private */
public final class iy {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    iy f;
    iy g;

    iy() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    iy(iy iyVar) {
        this(iyVar.a, iyVar.b, iyVar.c);
        iyVar.d = true;
    }

    iy(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public final iy a() {
        iy iyVar = this.f;
        if (iyVar == this) {
            iyVar = null;
        }
        iy iyVar2 = this.g;
        iyVar2.f = this.f;
        this.f.g = iyVar2;
        this.f = null;
        this.g = null;
        return iyVar;
    }

    public final iy a(iy iyVar) {
        iyVar.g = this;
        iyVar.f = this.f;
        this.f.g = iyVar;
        this.f = iyVar;
        return iyVar;
    }

    public final void a(iy iyVar, int i) {
        if (iyVar.e) {
            int i2 = iyVar.c;
            if (i2 + i > 8192) {
                if (!iyVar.d) {
                    int i3 = iyVar.b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = iyVar.a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        iyVar.c -= iyVar.b;
                        iyVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, iyVar.a, iyVar.c, i);
            iyVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
