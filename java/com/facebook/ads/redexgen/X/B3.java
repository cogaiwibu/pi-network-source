package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface B3 {
    public static final ByteBuffer A00 = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean A47(int i, int i2, int i3) throws B2;

    ByteBuffer A6a();

    int A6b();

    int A6c();

    int A6d();

    boolean A7V();

    boolean A7Z();

    void ABu();

    void ABv(ByteBuffer byteBuffer);

    void flush();

    void reset();
}
