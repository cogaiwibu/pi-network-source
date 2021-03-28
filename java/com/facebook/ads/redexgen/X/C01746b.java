package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.6b  reason: invalid class name and case insensitive filesystem */
public class C01746b extends HashMap<String, Integer> {
    public static byte[] A01;
    public final /* synthetic */ V2 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{123, -13};
    }

    public C01746b(V2 v2) {
        this.A00 = v2;
        put(A00(1, 1, 109), Integer.valueOf(this.A00.A00.A01.widthPixels));
        put(A00(0, 1, 4), Integer.valueOf(this.A00.A00.A01.heightPixels));
    }
}
