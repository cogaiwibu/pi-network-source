package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.9r  reason: invalid class name and case insensitive filesystem */
public class C02599r extends K2 {
    public static byte[] A01;
    public final /* synthetic */ C0858Xt A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-108, -89, -94, -93, -83, -114, -86, -97, -73, ByteCompanionObject.MIN_VALUE, -97, -95, -87, -125, -80, -80, -83, -80};
    }

    public C02599r(C0858Xt xt) {
        this.A00 = xt;
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A04(K3 k3) {
        this.A00.A0e(A00(0, 18, 58));
    }
}
