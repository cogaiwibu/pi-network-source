package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.util.Arrays;

public class EZ implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C0368Ei A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-73, -39, -22, -33, -27, -28, -106, -36, -33, -30, -37, -106, -30, -27, -41, -38, -33, -28, -35, -106, -36, -41, -33, -30, -37, -38, -92, -66, -23, -15, -24, -26, -23, -37, -34, -57, -37, -24, -37, -31, -33, -20};
    }

    public EZ(C0368Ei ei) {
        this.A00 = ei;
    }

    public final void run() {
        DownloadAction[] downloadActionArr;
        if (!KU.A02(this)) {
            try {
                downloadActionArr = this.A00.A09.A04(this.A00.A0E);
            } catch (Throwable th) {
                KU.A00(th, this);
                return;
            }
            this.A00.A07.post(new EY(this, downloadActionArr));
        }
    }
}
