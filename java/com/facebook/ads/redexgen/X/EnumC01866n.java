package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.6n  reason: invalid class name and case insensitive filesystem */
public enum EnumC01866n {
    A04(0),
    A05(100);
    
    public static byte[] A01;
    public static final Map<Integer, EnumC01866n> A02 = new HashMap();
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-98, -97, -96, -101, -81, -90, -82, -104, -103, -105, -104};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        EnumC01866n[] values = values();
        for (EnumC01866n r2 : values) {
            A02.put(Integer.valueOf(r2.A00), r2);
        }
    }

    /* access modifiers changed from: public */
    EnumC01866n(int i) {
        this.A00 = i;
    }

    public static EnumC01866n A00(int i) {
        EnumC01866n r0 = A02.get(Integer.valueOf(i));
        if (r0 == null) {
            return A04;
        }
        return r0;
    }
}
