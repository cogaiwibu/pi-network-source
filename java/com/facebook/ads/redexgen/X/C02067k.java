package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7k  reason: invalid class name and case insensitive filesystem */
public class C02067k extends AbstractC0494Jk {
    public static byte[] A01;
    public final /* synthetic */ C02057i A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-7, 13, -4, 1, 7};
    }

    public C02067k(C02057i r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A04(C0501Jt jt) {
        if (C02057i.A03(this.A00) == null || C02057i.A03(this.A00).get() == null) {
            C02057i.A04(this.A00, new WeakReference(new P1(this)));
        }
        ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 34))).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) C02057i.A03(this.A00).get(), 3, 1);
    }
}
