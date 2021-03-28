package com.tapjoy.internal;

public final class gi {
    public static final gi a = new gi(0, 0, 0, 0.0d);
    public final long b;
    public final long c;
    public final double d;
    public long e;
    private final long f;

    public gi(long j, long j2, long j3, double d2) {
        this.f = j;
        this.b = j2;
        this.c = j3;
        this.d = d2;
        this.e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            gi giVar = (gi) obj;
            return this.f == giVar.f && this.b == giVar.b && this.c == giVar.c && this.d == giVar.d && this.e == giVar.e;
        }
    }
}
