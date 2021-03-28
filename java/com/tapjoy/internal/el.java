package com.tapjoy.internal;

public final class el {
    final is a;

    static int a(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    static int a(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    static int b(int i) {
        return (i >> 31) ^ (i << 1);
    }

    static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    static int a(int i, eg egVar) {
        return (i << 3) | egVar.e;
    }

    public el(is isVar) {
        this.a = isVar;
    }

    public final void a(iu iuVar) {
        this.a.b(iuVar);
    }

    public final void c(int i) {
        while ((i & -128) != 0) {
            this.a.e((i & 127) | 128);
            i >>>= 7;
        }
        this.a.e(i);
    }

    public final void c(long j) {
        while ((-128 & j) != 0) {
            this.a.e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.a.e((int) j);
    }

    public final void d(int i) {
        this.a.d(i);
    }

    public final void d(long j) {
        this.a.f(j);
    }
}
