package com.tapjoy.internal;

import java.util.Arrays;

final class ja extends iu {
    final transient byte[][] f;
    final transient int[] g;

    ja(ir irVar, int i) {
        super(null);
        je.a(irVar.b, 0, (long) i);
        iy iyVar = irVar.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (iyVar.c != iyVar.b) {
                i3 += iyVar.c - iyVar.b;
                i4++;
                iyVar = iyVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f = new byte[i4][];
        this.g = new int[(i4 * 2)];
        iy iyVar2 = irVar.a;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = iyVar2.a;
            i2 += iyVar2.c - iyVar2.b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.g;
            iArr[i5] = i2;
            iArr[this.f.length + i5] = iyVar2.b;
            iyVar2.d = true;
            i5++;
            iyVar2 = iyVar2.f;
        }
    }

    @Override // com.tapjoy.internal.iu
    public final String a() {
        return e().a();
    }

    @Override // com.tapjoy.internal.iu
    public final String b() {
        return e().b();
    }

    @Override // com.tapjoy.internal.iu
    public final iu a(int i, int i2) {
        return e().a(i, i2);
    }

    @Override // com.tapjoy.internal.iu
    public final byte a(int i) {
        int i2;
        je.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b = b(i);
        if (b == 0) {
            i2 = 0;
        } else {
            i2 = this.g[b - 1];
        }
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        return bArr[b][(i - i2) + iArr[bArr.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    @Override // com.tapjoy.internal.iu
    public final int c() {
        return this.g[this.f.length - 1];
    }

    @Override // com.tapjoy.internal.iu
    public final byte[] d() {
        int[] iArr = this.g;
        byte[][] bArr = this.f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tapjoy.internal.iu
    public final void a(ir irVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            iy iyVar = new iy(this.f[i], i3, (i3 + i4) - i2);
            if (irVar.a == null) {
                iyVar.g = iyVar;
                iyVar.f = iyVar;
                irVar.a = iyVar;
            } else {
                irVar.a.g.a(iyVar);
            }
            i++;
            i2 = i4;
        }
        irVar.b += (long) i2;
    }

    @Override // com.tapjoy.internal.iu
    public final boolean a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            if (b == 0) {
                i4 = 0;
            } else {
                i4 = this.g[b - 1];
            }
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            int[] iArr = this.g;
            byte[][] bArr2 = this.f;
            if (!je.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private iu e() {
        return new iu(d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[RETURN] */
    @Override // com.tapjoy.internal.iu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r12 instanceof com.tapjoy.internal.iu
            r2 = 0
            if (r1 == 0) goto L_0x005d
            com.tapjoy.internal.iu r12 = (com.tapjoy.internal.iu) r12
            int r1 = r12.c()
            int r3 = r11.c()
            if (r1 != r3) goto L_0x005d
            int r1 = r11.c()
            int r3 = r11.c()
            int r3 = r3 - r1
            if (r3 >= 0) goto L_0x0022
        L_0x0020:
            r12 = 0
            goto L_0x005a
        L_0x0022:
            int r3 = r11.b(r2)
            r4 = 0
            r5 = 0
        L_0x0028:
            if (r1 <= 0) goto L_0x0059
            if (r3 != 0) goto L_0x002e
            r6 = 0
            goto L_0x0034
        L_0x002e:
            int[] r6 = r11.g
            int r7 = r3 + -1
            r6 = r6[r7]
        L_0x0034:
            int[] r7 = r11.g
            r7 = r7[r3]
            int r7 = r7 - r6
            int r7 = r7 + r6
            int r7 = r7 - r4
            int r7 = java.lang.Math.min(r1, r7)
            int[] r8 = r11.g
            byte[][] r9 = r11.f
            int r10 = r9.length
            int r10 = r10 + r3
            r8 = r8[r10]
            int r6 = r4 - r6
            int r6 = r6 + r8
            r8 = r9[r3]
            boolean r6 = r12.a(r5, r8, r6, r7)
            if (r6 != 0) goto L_0x0053
            goto L_0x0020
        L_0x0053:
            int r4 = r4 + r7
            int r5 = r5 + r7
            int r1 = r1 - r7
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0059:
            r12 = 1
        L_0x005a:
            if (r12 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ja.equals(java.lang.Object):boolean");
    }

    @Override // com.tapjoy.internal.iu
    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int[] iArr = this.g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    @Override // com.tapjoy.internal.iu
    public final String toString() {
        return e().toString();
    }
}
