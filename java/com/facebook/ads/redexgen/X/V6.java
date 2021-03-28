package com.facebook.ads.redexgen.X;

import android.provider.Settings;
import java.util.Arrays;

public class V6 implements AbstractC01816i {
    public static byte[] A01;
    public final /* synthetic */ V7 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 2);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-77, -93, -78, -91, -91, -82, -97, -94, -78, -87, -89, -88, -76, -82, -91, -77, -77};
    }

    public V6(V7 v7) {
        this.A00 = v7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        V7 v7 = this.A00;
        return v7.A04(((float) Settings.System.getInt(v7.A00, A00(0, 17, 62), -1)) / 255.0f);
    }
}
