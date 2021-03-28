package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Jp  reason: case insensitive filesystem */
public enum EnumC0498Jp {
    A06,
    A02,
    A03,
    A04,
    A05;
    
    public static byte[] A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{14, 13, 26, 26, 17, 30, 8, 13, 19, 4, 17, 18, 19, 8, 19, 8, 0, 11, -58, -71, -52, -63, -50, -67, -18, -31, -13, -35, -18, -32, -31, -32, -5, -14, -27, -32, -31, -21, -34, -41, -44, -41, -40, -32, -41};
    }

    /* access modifiers changed from: public */
    static {
        A02();
    }

    public static EnumC0498Jp A00(EnumC0500Js js) {
        switch (C0497Jo.A01[js.ordinal()]) {
            case 1:
                return A04;
            case 2:
            case 3:
            case 4:
            case 5:
                return A02;
            case 6:
            case 7:
            case 8:
            case 9:
                return A03;
            case 10:
                return A05;
            default:
                return A06;
        }
    }

    public final AdPlacementType A03() {
        int i = C0497Jo.A00[ordinal()];
        if (i == 1) {
            return AdPlacementType.INTERSTITIAL;
        }
        if (i == 2) {
            return AdPlacementType.BANNER;
        }
        if (i == 3) {
            return AdPlacementType.NATIVE;
        }
        if (i != 4) {
            return AdPlacementType.UNKNOWN;
        }
        return AdPlacementType.REWARDED_VIDEO;
    }
}
