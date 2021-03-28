package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public enum NV {
    A06(0),
    A05(1),
    A04(2);
    
    public static byte[] A01;
    public static String[] A02;
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{46, 35, 44, 38, 49, 33, 35, 50, 39, 77, 82, 79, 73, 79, 92, 84, 73, 102, 125, 96, 99, 118, 112, 122, 117, 122, 118, 119};
    }

    public static void A03() {
        A02 = new String[]{"rZGvvZMI6I", "wpdicw5jfWUP9Cs9nncu65zzvPXSjTXh", "qXEMgnv7Ct425l7In8PWxhOPFYVbEYpB", "dTodKdBY68fO6HNBSU3LN7qZJ4nOCEpk", "Hkjhu", "mY7TKQYFYXm3BBS2pDypGTbdY20sKsEk", "u0FGaDIimXxXG0l3UqPLAtx16Sc8Y059", "GEphX9PDUn8ir5euMIdeMTZrm9gVIFzw"};
    }

    /* access modifiers changed from: public */
    static {
        A03();
        A02();
    }

    /* access modifiers changed from: public */
    NV(int i) {
        this.A00 = i;
    }

    public static NV A00(int i) {
        NV[] values = values();
        for (NV nv : values) {
            if (nv.A00 == i) {
                return nv;
            }
        }
        return A05;
    }

    public final int A04() {
        return this.A00;
    }
}
