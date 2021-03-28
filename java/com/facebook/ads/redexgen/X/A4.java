package com.facebook.ads.redexgen.X;

import java.io.IOException;

public final class A4 extends Exception {
    public final int A00;
    public final int A01;

    public A4(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.A01 = i;
        this.A00 = i2;
    }

    public static A4 A00(IOException iOException) {
        return new A4(0, null, iOException, -1);
    }

    public static A4 A01(Exception exc, int i) {
        return new A4(1, null, exc, i);
    }

    public static A4 A02(RuntimeException runtimeException) {
        return new A4(2, null, runtimeException, -1);
    }
}
