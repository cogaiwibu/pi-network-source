package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;

public class MV implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C0846Xh A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-27, -38, -25, -37, -28, -25, -30, -72, -23, -42, -72, -31, -34, -40, -32};
    }

    public MV(C0846Xh xh) {
        this.A00 = xh;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A04.A3s(A00(0, 15, 9));
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
