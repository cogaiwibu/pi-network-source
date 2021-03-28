package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;

public final class OZ {
    public static byte[] A09;
    public static String[] A0A;
    public String A00;
    public String A01;
    public final AnonymousClass8H A02;
    public final JE A03;
    public final JL A04 = new JL(this.A06, this.A03);
    public final OY A05;
    public final String A06;
    public final Map<String, String> A07;
    public final boolean A08;

    static {
        A05();
        A04();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-110, -91, -92, -92, -97, -98, -113, -109, -100, -103, -109, -101, ByteCompanionObject.MIN_VALUE, -109, -110, -110, -115, -116, 125, -116, ByteCompanionObject.MAX_VALUE, -117, -125, -112, -103, -113, -118, -114, -116, -99, -113, -118, -98, -109, -102, -94, -118, -96, -101, -59, -42, -59, -50, -44, -65, -59, -40, -44, -46, -63, 123, -116, 123, -124, -118, 117, -118, -113, -122, 123, -46, -52, -40, -48, -54, -41, -38, -52, -49, -110, -117, -100, -117, -110, -123, -119, -107, -109, -106, -110, -117, -102, -117, -122, ByteCompanionObject.MAX_VALUE, -112, ByteCompanionObject.MAX_VALUE, -122, 121, -120, 123, -121, ByteCompanionObject.MAX_VALUE, -40, -63};
    }

    public static void A05() {
        A0A = new String[]{"wShQC8dEdCdDsonD9ckCi5w9U", "b5c2oWnzHv5UWiyt71KIAMilmtcSqC1N", "4oZvc6d7ZwR5AqDgCDxuZ3", "CpRmP5RSNkzg3ZlMUDzKwsVogZKCCIfv", "sNKw3geGf4TvnRH7EsTwjKTQ1PVdzKbr", "vkOXVJfFXuiRjckYDq31YMz3bRLaI4ty", "WCP05eFM3owSSVORqqhL5dWCzqIHotme", "3PgjMBtjqMKuKf4b6dM3cFumw"};
    }

    public OZ(AnonymousClass8H r4, OY oy, JE je, Map<String, String> map, String str) {
        this.A02 = r4;
        this.A05 = oy;
        this.A03 = je;
        this.A07 = map;
        this.A06 = str;
        this.A08 = J8.A1B(oy.getContext());
    }

    private void A01() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(50, 10, 13), A00(60, 9, 98));
        A08(hashMap);
    }

    private void A02() {
        this.A04.A03(JK.A0X, null);
    }

    private void A03() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(50, 10, 13), A00(23, 16, 34));
        A08(hashMap);
    }

    private void A06(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(83, 10, 17), String.valueOf(str));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(50, 10, 13), A00(69, 14, 29));
        hashMap2.put(A00(39, 11, 87), LD.A01(hashMap));
        A08(hashMap2);
    }

    private void A07(String str, float f, float f2) {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(12, 11, 21), str);
        hashMap.put(A00(93, 1, 87), String.valueOf(f));
        hashMap.put(A00(94, 1, 63), String.valueOf(f2));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A00(50, 10, 13), A00(0, 12, 39));
        hashMap2.put(A00(39, 11, 87), LD.A01(hashMap));
        A08(hashMap2);
    }

    private void A08(Map<String, String> map) {
        if (!TextUtils.isEmpty(this.A06)) {
            map.putAll(this.A07);
            map.putAll(C0608Oa.A01(this.A02, this.A00, this.A01));
            this.A03.A8D(this.A06, map);
            if (A0A[2].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[0] = "HxovkwELrWr5bBRZF5CQfpfOo";
            strArr[7] = "TU6dTWUJiKZlmHYRZZZtjyCrH";
        }
    }

    @JavascriptInterface
    public void initializeLogging(String str, String str2) {
        if (this.A08) {
            this.A00 = str;
            this.A01 = str2;
        }
    }

    @JavascriptInterface
    public void logButtonClick(String str, float f, float f2) {
        if (this.A08) {
            A07(str, f, f2);
        }
    }

    @JavascriptInterface
    public void logEndCardShowUp() {
        if (this.A08) {
            A03();
        }
    }

    @JavascriptInterface
    public void logGameLoad() {
        if (this.A08) {
            A01();
        }
    }

    @JavascriptInterface
    public void logLevelComplete(String str) {
        if (this.A08) {
            A06(str);
        }
    }

    @JavascriptInterface
    public void onCTAClick() {
        A02();
        this.A05.A0B();
    }
}
