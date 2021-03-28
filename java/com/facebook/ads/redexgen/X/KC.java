package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class KC {
    public static byte[] A0F;
    public static String[] A0G;
    public int A00;
    @Nullable
    public AdExperienceType A01;
    public AnonymousClass8H A02;
    public EnumC0498Jp A03;
    public EnumC0500Js A04;
    @Nullable
    public LH A05;
    @Nullable
    public String A06;
    public String A07;
    @Nullable
    public String A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final AdPlacementType A0C = this.A03.A03();
    public final C0505Jx A0D;
    @Nullable
    public final String A0E;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{-38, -68, -52, -49, -22, -48, -29, -37, -48, -35, -44, -48, -39, -50, -48, -22, -33, -28, -37, -48, -91, -88, -61, -74, -87, -76, -77, -74, -72, -83, -78, -85, -61, -89, -77, -78, -86, -83, -85, -61, -80, -91, -73, -72, -61, -71, -76, -88, -91, -72, -87, -61, -72, -83, -79, -87, 19, 26, 21, 48, 26, 21, 10, 17, 12, 39, 28, 17, 21, 13, 39, 28, 23, 19, 13, 22, -31, -22, -25, -29, -20, -14, -3, -16, -29, -17, -13, -29, -15, -14, -3, -25, -30, -29, -17, -16, -16, -31, -72, -71, -63, -61, -45, -75, -72, -45, -67, -72, -49, -30, -34, -36, -53, -23, -46, -45, -40, -34, -35, 14, 11, 15, 13, 14, 26, -15, -20, -18, -23, -5, -10, -8, -13, 17, -8, -2, -13, -7, -65, -55, -43, -61, -53, -62, -54, -65, -43, -73, -70, -43, -69, -50, -58, -69, -56, -65, -69, -60, -71, -69, -2, -6, 18, 5, -8, 6, 7, 5, -4, -10, 7, -8, -9, -11, -4, -12, 6, -24, -21, -6, 6, -7, -20, -8, -4, -20, -6, -5, -20, -21, -39, -43, -54, -52, -50, -42, -50, -41, -35, -24, -46, -51, 24, 20, 9, 11, 13, 21, 13, 22, 28, 39, 28, 33, 24, 13, -84, -97, -85, -81, -97, -83, -82, -71, -82, -93, -89, -97, -56, -55, -74, -72, -64, -44, -55, -57, -74, -72, -70, 41, 26, 34, 37, 33, 22, 41, 26, 52, 30, 25, 29, 14, 28, 29, 40, 22, 24, 13, 14, -46, -60, -65, -49, -61};
    }

    public static void A02() {
        A0G = new String[]{"D9utVieqpHmzq", "1reJ20tywIkt8c03XFg68iFkPgUpcQh9", "1hiVgm3FzyAWthqubctijKn7iSl8t7OZ", "2MGbhVYWK6vnLzanQZMPK5FLJbU6N2Mg", "tHlP6Jv5sj70nCQXOaNATx3kiWqPf1Tp", "kSrICwDX6P2QTtBsWrInLj9wi3Ca9feR", "Z5GcmA6HHHf7tKUPWv2sbOMAsuTj15Gl", "CZogAanemwBaq"};
    }

    public KC(AnonymousClass8H r2, String str, @Nullable LH lh, EnumC0500Js js, @Nullable String str2, int i, boolean z, boolean z2, C0505Jx jx, @Nullable String str3, @Nullable String str4, @Nullable AdExperienceType adExperienceType) {
        this.A02 = r2;
        this.A07 = str;
        this.A05 = lh;
        this.A04 = js;
        this.A0E = str2;
        this.A00 = i;
        this.A0B = z;
        this.A09 = z2;
        this.A0D = jx;
        this.A03 = EnumC0498Jp.A00(js);
        this.A08 = str3;
        this.A06 = str4;
        this.A01 = adExperienceType;
    }

    private void A03(Map<String, String> params, String str, String str2) {
        params.put(str, str2);
    }

    public final int A04() {
        return this.A00;
    }

    public final EnumC0498Jp A05() {
        return this.A03;
    }

    public final EnumC0500Js A06() {
        return this.A04;
    }

    @Nullable
    public final LH A07() {
        return this.A05;
    }

    public final String A08() {
        return this.A07;
    }

    public final Map<String, String> A09(Map<String, String> map) {
        String A002;
        HashMap hashMap = new HashMap(map);
        A03(hashMap, A00(125, 4, 81), C01535f.A00().A03());
        if (C01535f.A00().A04()) {
            A002 = A00(0, 1, 83);
        } else {
            A002 = A00(1, 1, 52);
        }
        A03(hashMap, A00(129, 9, 91), A002);
        A03(hashMap, A00(93, 5, 73), String.valueOf(this.A09));
        A03(hashMap, A00(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 12, 50), this.A07);
        if (this.A0C != AdPlacementType.UNKNOWN) {
            A03(hashMap, A00(202, 14, 113), this.A0C.toString().toLowerCase());
        }
        LH lh = this.A05;
        if (lh != null) {
            A03(hashMap, A00(259, 5, 36), String.valueOf(lh.A01()));
            A03(hashMap, A00(119, 6, 111), String.valueOf(this.A05.A00()));
        }
        EnumC0500Js js = this.A04;
        if (js != null) {
            A03(hashMap, A00(239, 11, 126), String.valueOf(js.A03()));
        }
        boolean z = this.A0B;
        String[] strArr = A0G;
        if (strArr[1].charAt(22) == strArr[3].charAt(22)) {
            String[] strArr2 = A0G;
            strArr2[1] = "IzDezfH0vo2hFBj3g0HaogFvU1PF9PgW";
            strArr2[3] = "07eFZyxYDfzIdCogAj5SagFmNdTPnXPY";
            if (z) {
                String A003 = A00(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, 9, 114);
                String A004 = A00(1, 1, 52);
                String[] strArr3 = A0G;
                if (strArr3[7].length() == strArr3[0].length()) {
                    String[] strArr4 = A0G;
                    strArr4[5] = "fhkQkDUQCs0vTSuMh05aUEfBswduYuq5";
                    strArr4[5] = "fhkQkDUQCs0vTSuMh05aUEfBswduYuq5";
                    A03(hashMap, A003, A004);
                }
            }
            String str = this.A0E;
            if (str != null) {
                A03(hashMap, A00(98, 10, 29), str);
            }
            int i = this.A00;
            if (i != 0) {
                A03(hashMap, A00(173, 17, 80), String.valueOf(i));
            }
            boolean z2 = this.A0A;
            if (z2) {
                A03(hashMap, A00(138, 22, 31), String.valueOf(z2));
            }
            A03(hashMap, A00(160, 13, 92), String.valueOf(C0536Lf.A03(this.A02)));
            A03(hashMap, A00(JfifUtil.MARKER_SOI, 12, 3), LW.A05(System.currentTimeMillis()));
            if (this.A0D.A07() && this.A0D.A05() != null) {
                A03(hashMap, A00(56, 6, 122), this.A0D.A05());
            }
            String A062 = this.A0D.A06();
            if (!TextUtils.isEmpty(A062)) {
                A03(hashMap, A00(62, 14, 113), A062);
            }
            String str2 = this.A08;
            if (str2 != null) {
                A03(hashMap, A00(228, 11, 30), str2);
            }
            A03(hashMap, A00(76, 17, 71), UUID.randomUUID().toString());
            A03(hashMap, A00(20, 36, 13), LW.A06(AnonymousClass23.A00(this.A02.A00())));
            String str3 = this.A06;
            if (str3 != null) {
                A03(hashMap, A00(108, 11, 51), str3);
            }
            AdExperienceType adExperienceType = this.A01;
            if (adExperienceType != null) {
                String adExperienceType2 = adExperienceType.getAdExperienceType();
                if (A0G[5].length() == 32) {
                    String[] strArr5 = A0G;
                    strArr5[1] = "oug9irQjulGDcN1zjjec1oFwPujMP8yb";
                    strArr5[3] = "P1fPvVUp9X55Q5Xl2H8DBdFxzWSw3WjN";
                    A03(hashMap, A00(2, 18, 52), adExperienceType2);
                }
            }
            return hashMap;
        }
        throw new RuntimeException();
    }
}
