package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.91  reason: invalid class name */
public final class AnonymousClass91 {
    public static byte[] A0F;
    public static final AdPlacementType A0G = AdPlacementType.UNKNOWN;
    public static final String A0H = AnonymousClass91.class.getSimpleName();
    public int A00 = -1;
    public int A01 = -1;
    public int A02 = 3600;
    public int A03 = 1;
    public int A04 = 0;
    public int A05 = 20;
    public int A06 = 10000;
    public int A07 = 200;
    public int A08 = 0;
    public int A09 = 1000;
    public int A0A = 0;
    public AdPlacementType A0B = A0G;
    public List<C02418z> A0C = null;
    public boolean A0D = false;
    public final long A0E = System.currentTimeMillis();

    /* JADX WARNING: Error to parse debug info: 13 in method: com.facebook.ads.redexgen.X.91.<init>(java.util.Map<java.lang.String, java.lang.String>):void, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:221)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:137)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public AnonymousClass91(Map<String, String> map) {
        char c;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1899431321:
                    if (key.equals(A01(55, 18, 70))) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1561601017:
                    if (key.equals(A01(169, 17, 94))) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -856794442:
                    if (key.equals(A01(263, 26, 68))) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -726276175:
                    if (key.equals(A01(186, 15, 75))) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -634541425:
                    if (key.equals(A01(73, 32, 35))) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -553208868:
                    if (key.equals(A01(46, 9, 62))) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3575610:
                    if (key.equals(A01(201, 4, 104))) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 700812481:
                    if (key.equals(A01(105, 26, 17))) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 858630459:
                    if (key.equals(A01(289, 24, 70))) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 986744879:
                    if (key.equals(A01(205, 27, 35))) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 1085444827:
                    if (key.equals(A01(162, 7, 64))) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1183549815:
                    if (key.equals(A01(232, 31, 93))) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1503616961:
                    if (key.equals(A01(131, 16, 73))) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 2002133996:
                    if (key.equals(A01(147, 15, 73))) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    this.A0B = AdPlacementType.fromString(entry.getValue());
                    break;
                case 1:
                    this.A03 = Integer.parseInt(entry.getValue());
                    break;
                case 2:
                    this.A0A = Integer.parseInt(entry.getValue());
                    break;
                case 3:
                    this.A04 = Integer.parseInt(entry.getValue());
                    break;
                case 4:
                    this.A05 = Integer.parseInt(entry.getValue());
                    break;
                case 5:
                    this.A02 = Integer.parseInt(entry.getValue());
                    break;
                case 6:
                    this.A0D = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case 7:
                    this.A01 = Integer.parseInt(entry.getValue());
                    break;
                case '\b':
                    this.A00 = Integer.parseInt(entry.getValue());
                    break;
                case '\t':
                    this.A08 = Integer.parseInt(entry.getValue());
                    break;
                case '\n':
                    this.A09 = Integer.parseInt(entry.getValue());
                    break;
                case 11:
                    this.A06 = Integer.parseInt(entry.getValue());
                    break;
                case '\f':
                    this.A0C = C02418z.A01(entry.getValue());
                    try {
                        CookieManager instance = CookieManager.getInstance();
                        boolean acceptCookie = instance.acceptCookie();
                        instance.setAcceptCookie(true);
                        for (C02418z r7 : this.A0C) {
                            if (r7.A05()) {
                                instance.setCookie(r7.A01, r7.A00 + A01(24, 1, 3) + r7.A02 + A01(0, 8, 102) + r7.A01 + A01(8, 9, 87) + r7.A04() + A01(17, 7, 72));
                            }
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                            CookieSyncManager.getInstance().startSync();
                        }
                        instance.setAcceptCookie(acceptCookie);
                        break;
                    } catch (Exception e) {
                        Log.w(A0H, A01(25, 21, 59), e);
                        break;
                    }
                case '\r':
                    try {
                        this.A07 = Integer.parseInt(entry.getValue());
                        break;
                    } catch (NumberFormatException unused) {
                        this.A07 = 200;
                        break;
                    }
            }
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{47, 80, 123, 121, 117, 125, 122, 41, 30, 96, 93, 85, 76, 87, 64, 86, 24, 1, 74, 91, 78, 82, 7, 21, 76, 15, 40, 32, 37, 44, 45, 105, 61, 38, 105, 58, 44, 61, 105, 42, 38, 38, 34, 32, 44, 103, 47, 45, 47, 36, 41, 45, 46, 32, 41, 87, 91, 90, 66, 107, 64, 70, 85, 87, 95, 93, 90, 83, 107, 80, 85, 64, 85, 56, 63, 39, 48, 61, 56, 53, 48, 37, 56, 62, 63, 14, 53, 36, 35, 48, 37, 56, 62, 63, 14, 56, 63, 14, 34, 52, 50, 62, 63, 53, 34, 14, 10, 13, 60, 21, 10, 6, 20, 2, 1, 10, 15, 10, 23, 26, 60, 19, 6, 17, 0, 6, 13, 23, 2, 4, 6, 75, 87, 90, 88, 94, 86, 94, 85, 79, 100, 83, 94, 82, 92, 83, 79, 75, 87, 90, 88, 94, 86, 94, 85, 79, 100, 76, 82, 95, 79, 83, 64, 87, 84, 64, 87, 65, 90, 94, 73, 74, 94, 73, 95, 68, 115, 88, 68, 94, 73, 95, 68, 67, 64, 72, 75, 92, 72, 76, 92, 74, 77, 102, 77, 80, 84, 92, 86, 76, 77, 110, 99, 106, ByteCompanionObject.MAX_VALUE, 39, 56, 53, 52, 62, 14, 37, 56, 60, 52, 14, 33, 62, 61, 61, 56, 63, 54, 14, 56, 63, 37, 52, 35, 39, 48, 61, 89, 70, 74, 88, 78, 77, 70, 67, 70, 91, 86, 112, 76, 71, 74, 76, 68, 112, 70, 65, 70, 91, 70, 78, 67, 112, 75, 74, 67, 78, 86, 64, 95, 83, 65, 87, 84, 95, 90, 95, 66, 79, 105, 85, 94, 83, 85, 93, 105, 95, 88, 66, 83, 68, 64, 87, 90, 66, 93, 81, 67, 85, 86, 93, 88, 93, 64, 77, 107, 87, 92, 81, 87, 95, 107, 64, 93, 87, 95, 81, 70};
    }

    static {
        A02();
    }

    public static AnonymousClass91 A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new AnonymousClass91(hashMap);
    }

    public final int A03() {
        return this.A02 * 1000;
    }

    public final int A04() {
        return this.A03;
    }

    public final int A05() {
        return this.A06;
    }

    public final int A06() {
        return this.A07;
    }

    public final int A07() {
        return this.A08;
    }

    public final int A08() {
        return this.A09;
    }

    public final int A09() {
        return this.A0A;
    }

    public final long A0A() {
        return (long) (this.A04 * 1000);
    }

    public final long A0B() {
        return (long) (this.A05 * 1000);
    }

    public final long A0C() {
        return this.A0E;
    }

    public final AdPlacementType A0D() {
        return this.A0B;
    }

    public final boolean A0E() {
        return this.A0D;
    }
}
