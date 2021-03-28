package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.common.statfs.StatFsHelper;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Js  reason: case insensitive filesystem */
public enum EnumC0500Js {
    A08(0),
    A0C(4),
    A0A(5),
    A0B(6),
    A09(7),
    A0F(100),
    A0D(101),
    A0G(102),
    A0E(103),
    A06(200),
    A05(500),
    A04(201),
    A07(StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB),
    A03(300);
    
    public static byte[] A01;
    public final int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-109, -104, -99, -98, -100, -113, -117, -105, -87, -96, -109, -114, -113, -103, -55, -68, -49, -60, -47, -64, -38, -83, -80, -85, -92, -105, -86, -97, -84, -101, -75, -104, -105, -92, -92, -101, -88, -49, -62, -43, -54, -41, -58, -32, -42, -49, -52, -49, -48, -40, -49, -55, -68, -50, -72, -55, -69, -68, -69, -42, -51, -64, -69, -68, -58, -62, -69, -72, -69, -68, -60, -69, -53, -71, -74, -54, -67, -71, -53, -45, -74, -75, -62, -62, -71, -58, -45, -90, -87, -92, -24, -42, -45, -25, -38, -42, -24, -16, -45, -46, -33, -33, -42, -29, -16, -58, -63, -50, -68, -71, -51, -64, -68, -50, -42, -71, -72, -59, -59, -68, -55, -42, -80, -89, -19, -37, -40, -20, -33, -37, -19, -11, -40, -41, -28, -28, -37, -24, -11, -30, -37, -35, -41, -39, -17, -85, -103, -106, -86, -99, -103, -85, -77, -99, -94, -88, -103, -90, -89, -88, -99, -88, -99, -107, -96, -77, -100, -93, -90, -99, -82, -93, -94, -88, -107, -96, -69, -87, -90, -70, -83, -87, -69, -61, -83, -78, -72, -87, -74, -73, -72, -83, -72, -83, -91, -80, -61, -72, -91, -90, -80, -87, -72, -80, -98, -101, -81, -94, -98, -80, -72, -94, -89, -83, -98, -85, -84, -83, -94, -83, -94, -102, -91, -72, -82, -89, -92, -89, -88, -80, -89, -109, -127, 126, -110, -123, -127, -109, -101, -123, -118, -112, -127, -114, -113, -112, -123, -112, -123, 125, -120, -101, -110, -127, -114, -112, -123, ByteCompanionObject.MAX_VALUE, 125, -120};
    }

    /* access modifiers changed from: public */
    static {
        A02();
    }

    /* access modifiers changed from: public */
    EnumC0500Js(int i) {
        this.A00 = i;
    }

    @Nullable
    public static EnumC0500Js A00(int i) {
        EnumC0500Js[] values = values();
        for (EnumC0500Js js : values) {
            if (js.A00 == i) {
                return js;
            }
        }
        return null;
    }

    public final int A03() {
        return this.A00;
    }
}
