package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;

public enum LC {
    A0H(0),
    A0G(1),
    A0F(2),
    A0J(3),
    A0I(4),
    A09(5, NativeAdBase.NativeComponentTag.AD_ICON),
    A0E(6, NativeAdBase.NativeComponentTag.AD_TITLE),
    A08(7, NativeAdBase.NativeComponentTag.AD_COVER_IMAGE),
    A0D(8, NativeAdBase.NativeComponentTag.AD_SUBTITLE),
    A05(9, NativeAdBase.NativeComponentTag.AD_BODY),
    A06(10, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION),
    A0C(11, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT),
    A07(12, NativeAdBase.NativeComponentTag.AD_CHOICES_ICON),
    A0A(13, NativeAdBase.NativeComponentTag.AD_MEDIA),
    A0B(12, NativeAdBase.NativeComponentTag.AD_OPTIONS_VIEW);
    
    public static int A02 = -1593835521;
    public static byte[] A03;
    public final int A00;
    public final NativeAdBase.NativeComponentTag A01;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-9, -4, 2, -13, 0, -4, -17, -6, 13, -17, -14, 13, -16, -3, -14, 7, -81, -76, -70, -85, -72, -76, -89, -78, -59, -89, -86, -59, -87, -89, -78, -78, -59, -70, -75, -59, -89, -87, -70, -81, -75, -76, -116, -111, -105, -120, -107, -111, -124, -113, -94, -124, -121, -94, -122, -117, -110, -116, -122, -120, -106, -94, -116, -122, -110, -111, -56, -51, -45, -60, -47, -51, -64, -53, -34, -64, -61, -34, -62, -50, -43, -60, -47, -34, -56, -52, -64, -58, -60, -53, -48, -42, -57, -44, -48, -61, -50, -31, -61, -58, -31, -53, -59, -47, -48, -58, -53, -47, -62, -49, -53, -66, -55, -36, -66, -63, -36, -54, -62, -63, -58, -66, -105, -100, -94, -109, -96, -100, -113, -102, -83, -113, -110, -83, -99, -98, -94, -105, -99, -100, -95, -83, -92, -105, -109, -91, -28, -23, -17, -32, -19, -23, -36, -25, -6, -36, -33, -6, -18, -22, -34, -28, -36, -25, -6, -34, -22, -23, -17, -32, -13, -17, -60, -55, -49, -64, -51, -55, -68, -57, -38, -68, -65, -38, -50, -48, -67, -49, -60, -49, -57, -64, -8, -3, 3, -12, 1, -3, -16, -5, 14, -16, -13, 14, 3, -8, 3, -5, -12, -96, -91, -85, -100, -87, -91, -104, -93, -74, -104, -89, -96, -74, -85, -90, -90, -74, -93, -90, -82, -22, -17, -11, -26, -13, -17, -30, -19, 0, -17, -16, 0, -28, -19, -22, -28, -20, -70, -65, -59, -74, -61, -65, -78, -67, -48, -65, -64, -48, -59, -78, -72, -5, 0, 6, -9, 4, 0, -13, -2, 17, 0, 7, -2, -2, 17, 8, -5, -9, 9, -48, -43, -37, -52, -39, -43, -56, -45, -26, -34, -39, -42, -43, -50, -26, -37, -56, -50, -26, -54, -45, -56, -38, -38};
    }

    /* access modifiers changed from: public */
    static {
        A02();
    }

    /* access modifiers changed from: public */
    LC(int i) {
        this.A00 = i;
        this.A01 = null;
    }

    /* access modifiers changed from: public */
    LC(int i, NativeAdBase.NativeComponentTag nativeComponentTag) {
        this.A00 = i;
        this.A01 = nativeComponentTag;
    }

    public static LC A00(NativeAdBase.NativeComponentTag nativeComponentTag) {
        LC[] values = values();
        for (LC lc : values) {
            if (lc.A01 == nativeComponentTag) {
                return lc;
            }
        }
        return null;
    }

    public static void A03(View view, NativeAdBase.NativeComponentTag nativeComponentTag) {
        LC A002 = A00(nativeComponentTag);
        if (view != null && A002 != null && Build.VERSION.SDK_INT > 4) {
            view.setTag(A02, nativeComponentTag);
        }
    }

    public static void A04(View view, LC lc) {
        if (view != null && lc != null && Build.VERSION.SDK_INT > 4) {
            view.setTag(A02, lc);
        }
    }

    public final int A05() {
        return this.A00;
    }
}
