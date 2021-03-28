package com.tapjoy.internal;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;

public final class ek {
    final it a;
    private long b = 0;
    private long c = Long.MAX_VALUE;
    private int d;
    private int e = 2;
    private int f = -1;
    private long g = -1;
    private eg h;

    public ek(it itVar) {
        this.a = itVar;
    }

    public final long a() {
        if (this.e == 2) {
            int i = this.d + 1;
            this.d = i;
            if (i <= 65) {
                long j = this.g;
                this.g = -1;
                this.e = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final void a(long j) {
        if (this.e == 6) {
            int i = this.d - 1;
            this.d = i;
            if (i < 0 || this.g != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.b == this.c || i == 0) {
                this.c = j;
            } else {
                throw new IOException("Expected to end at " + this.c + " but was " + this.b);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public final int b() {
        int i = this.e;
        if (i == 7) {
            this.e = 2;
            return this.f;
        } else if (i == 6) {
            while (this.b < this.c && !this.a.b()) {
                int i2 = i();
                if (i2 != 0) {
                    int i3 = i2 >> 3;
                    this.f = i3;
                    int i4 = i2 & 7;
                    if (i4 == 0) {
                        this.h = eg.VARINT;
                        this.e = 0;
                        return this.f;
                    } else if (i4 == 1) {
                        this.h = eg.FIXED64;
                        this.e = 1;
                        return this.f;
                    } else if (i4 == 2) {
                        this.h = eg.LENGTH_DELIMITED;
                        this.e = 2;
                        int i5 = i();
                        if (i5 < 0) {
                            throw new ProtocolException("Negative length: " + i5);
                        } else if (this.g == -1) {
                            long j = this.c;
                            this.g = j;
                            long j2 = this.b + ((long) i5);
                            this.c = j2;
                            if (j2 <= j) {
                                return this.f;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i4 == 3) {
                        a(i3);
                    } else if (i4 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i4 == 5) {
                        this.h = eg.FIXED32;
                        this.e = 5;
                        return this.f;
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i4);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final eg c() {
        return this.h;
    }

    private void a(int i) {
        while (this.b < this.c && !this.a.b()) {
            int i2 = i();
            if (i2 != 0) {
                int i3 = i2 >> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    this.e = 0;
                    e();
                } else if (i4 == 1) {
                    this.e = 1;
                    g();
                } else if (i4 == 2) {
                    long i5 = (long) i();
                    this.b += i5;
                    this.a.d(i5);
                } else if (i4 == 3) {
                    a(i3);
                } else if (i4 != 4) {
                    if (i4 == 5) {
                        this.e = 5;
                        f();
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i4);
                    }
                } else if (i3 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    public final int d() {
        int i = this.e;
        if (i == 0 || i == 2) {
            int i2 = i();
            b(0);
            return i2;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    private int i() {
        int i;
        this.b++;
        byte c2 = this.a.c();
        if (c2 >= 0) {
            return c2;
        }
        int i2 = c2 & ByteCompanionObject.MAX_VALUE;
        this.b++;
        byte c3 = this.a.c();
        if (c3 >= 0) {
            i = c3 << 7;
        } else {
            i2 |= (c3 & ByteCompanionObject.MAX_VALUE) << 7;
            this.b++;
            byte c4 = this.a.c();
            if (c4 >= 0) {
                i = c4 << 14;
            } else {
                i2 |= (c4 & ByteCompanionObject.MAX_VALUE) << 14;
                this.b++;
                byte c5 = this.a.c();
                if (c5 >= 0) {
                    i = c5 << 21;
                } else {
                    int i3 = i2 | ((c5 & ByteCompanionObject.MAX_VALUE) << 21);
                    this.b++;
                    byte c6 = this.a.c();
                    int i4 = i3 | (c6 << 28);
                    if (c6 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.b++;
                        if (this.a.c() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return i2 | i;
    }

    public final long e() {
        int i = this.e;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.b++;
                byte c2 = this.a.c();
                j |= ((long) (c2 & ByteCompanionObject.MAX_VALUE)) << i2;
                if ((c2 & ByteCompanionObject.MIN_VALUE) == 0) {
                    b(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    public final int f() {
        int i = this.e;
        if (i == 5 || i == 2) {
            this.a.a(4);
            this.b += 4;
            int e2 = this.a.e();
            b(5);
            return e2;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
    }

    public final long g() {
        int i = this.e;
        if (i == 1 || i == 2) {
            this.a.a(8);
            this.b += 8;
            long f2 = this.a.f();
            b(1);
            return f2;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
    }

    private void b(int i) {
        if (this.e == i) {
            this.e = 6;
            return;
        }
        long j = this.b;
        long j2 = this.c;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.c + " but was " + this.b);
        } else if (j == j2) {
            this.c = this.g;
            this.g = -1;
            this.e = 6;
        } else {
            this.e = 7;
        }
    }

    /* access modifiers changed from: package-private */
    public final long h() {
        if (this.e == 2) {
            long j = this.c - this.b;
            this.a.a(j);
            this.e = 6;
            this.b = this.c;
            this.c = this.g;
            this.g = -1;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
    }
}
