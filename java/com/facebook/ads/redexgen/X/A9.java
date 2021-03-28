package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

public class A9 implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ CX A00;
    public final /* synthetic */ C0268Aa A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 119);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-20, 31, 22, -9, 19, 8, 32, 12, 25, -16, 20, 23, 19, -16, 21, 27, 12, 25, 21, 8, 19, -30, -5, -14, 5, -3, -14, -16, 1, -14, -15, -83, -14, -1, -1, -4, -1, -83, -15, -14, -7, -10, 3, -14, -1, -10, -5, -12, -83, -6, -14, 0, 0, -18, -12, -14, -83, -4, -5, -83, -14, 5, 1, -14, -1, -5, -18, -7, -83, 1, -11, -1, -14, -18, -15, -69};
    }

    public A9(CX cx, C0268Aa aa) {
        this.A00 = cx;
        this.A01 = aa;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                CX.A0V(this.A00, this.A01);
            } catch (A4 e) {
                Log.e(A00(0, 21, 48), A00(21, 55, 22), e);
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                KU.A00(e2, this);
            }
        }
    }
}
