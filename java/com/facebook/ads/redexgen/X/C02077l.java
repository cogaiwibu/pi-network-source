package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7l  reason: invalid class name and case insensitive filesystem */
public class C02077l extends AbstractC0506Jy {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C02057i A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 90);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {74, 94, 79, 66, 68};
        if (A02[4].length() != 16) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "gxAB8m8awSLzC5VQ45NFPzppUrTsIZFp";
        strArr[0] = "gxAB8m8awSLzC5VQ45NFPzppUrTsIZFp";
        A01 = bArr;
    }

    public static void A02() {
        A02 = new String[]{"3T8L8cxvDKNdHoEU8ndZ6FAxHol6AQmj", "T9d9jeRvA6TPkjlyE6ANkunwJ", "ZZYtC1qzWr9Z64iPtzSxbZEtAt5IIjlM", "LskUfs4Yi749bFjDIqQWoA2BC0G", "rATJhvtsPzynSvx3", "X5OC7Y9E", "WElhmvPz", "o0UdQ4xy8VrknzG9L7EyZnB"};
    }

    public C02077l(C02057i r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A03 */
    public final void A04(C02147t r5) {
        ((AudioManager) this.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 113))).abandonAudioFocus(C02057i.A03(this.A00) == null ? null : (AudioManager.OnAudioFocusChangeListener) C02057i.A03(this.A00).get());
        String[] strArr = A02;
        if (strArr[5].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "auSH";
        strArr2[7] = "auSH";
    }
}
