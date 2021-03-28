package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7m  reason: invalid class name and case insensitive filesystem */
public class C02087m extends K4 {
    public static byte[] A01;
    public final /* synthetic */ C02057i A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-26, -6, -23, -18, -12};
    }

    public C02087m(C02057i r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A04(AnonymousClass7v r5) {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        AudioManager audioManager = (AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 67));
        if (C02057i.A03(this.A00) == null) {
            onAudioFocusChangeListener = null;
        } else {
            onAudioFocusChangeListener = (AudioManager.OnAudioFocusChangeListener) C02057i.A03(this.A00).get();
        }
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }
}
