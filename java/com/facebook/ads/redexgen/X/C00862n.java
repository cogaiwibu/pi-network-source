package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.2n  reason: invalid class name and case insensitive filesystem */
public final class C00862n extends AbstractC0290Ax {
    public static byte[] A01;
    public final GZ A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-83, -33, -53, -83, -50, -52, -40, -51, -50, -37};
    }

    public C00862n(List<byte[]> list) {
        super(A01(0, 10, 61));
        IQ iq = new IQ(list.get(0));
        this.A00 = new GZ(iq.A0J(), iq.A0J());
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final C0928aF A0d(byte[] bArr, int i, boolean z) {
        if (z) {
            this.A00.A0K();
        }
        return new C0928aF(this.A00.A0J(bArr, i));
    }
}
