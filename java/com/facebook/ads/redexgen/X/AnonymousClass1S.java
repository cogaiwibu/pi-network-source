package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.ironsource.sdk.precache.DownloadManager;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.1S  reason: invalid class name */
public final class AnonymousClass1S implements Serializable {
    public static byte[] A0B = null;
    public static String[] A0C = null;
    public static final AnonymousClass1T A0D = AnonymousClass1T.A03;
    public static final NV A0E = NV.A05;
    public static final long serialVersionUID = -5352540123250859603L;
    public String A00;
    public final int A01;
    public final int A02;
    public final AnonymousClass1T A03;
    public final NV A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            if (A0C[6].charAt(18) != 'U') {
                String[] strArr = A0C;
                strArr[2] = "FjEz07QReKngvCKAACpwo";
                strArr[2] = "FjEz07QReKngvCKAACpwo";
                copyOfRange[i4] = (byte) (i5 ^ 118);
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0B = new byte[]{124, 64, 77, 85, 12, ByteCompanionObject.MAX_VALUE, 88, 67, 94, 73, 12, 91, 69, 64, 64, 12, 77, 89, 88, 67, 65, 77, 88, 69, 79, 77, 64, 64, 85, 12, 67, 92, 73, 66, 12, 69, 66, 12, 119, 95, 73, 79, 95, 113, 95, 65, 118, 100, 114, 97, 119, 118, 119, 51, 67, ByteCompanionObject.MAX_VALUE, 114, 106, 87, 86, 95, 82, 74, 108, 80, 95, 90, 80, 88, 108, 71, 86, 75, 71, 84, 95, 80, 83, 93, 84, 110, 84, 95, 85, 110, 82, 80, 67, 85, 110, 101, 106, 105, 103, 110, 84, 98, 101, ByteCompanionObject.MAX_VALUE, 121, 100, 84, 104, 106, 121, 111, 52, 54, 61, 54, 33, 58, 48, 12, 39, 54, 43, 39, 72, 79, 85, 83, 78, 126, 66, 64, 83, 69, 126, 72, 66, 78, 79, 126, 84, 83, 77, 28, 1, 26, 22, 29, 7, 18, 7, 26, 28, 29, 105, 117, 120, 96, 120, 123, 117, 124, 70, 125, 120, 109, 120, 59, 57, 46, 40, 42, 40, 35, 34, 37, 44, 20, 38, 46, 63, 35, 36, 47, 107, 124, 110, 120, 107, 125, 124, 125, 70, 105, 117, 120, 96, 70, 109, 124, 97, 109, 79, 87, 85, 76, 76, 93, 94, 80, 89, 99, 79, 89, 95, 83, 82, 88, 79, 61, 38, 59, 35, 33, 56, 56, 41, 42, 36, 45, 23, 59, 45, 43, 39, 38, 44, 59, 49, 54, 45, 7, 21, 18, 47, 6, 25, 21, 7, 47, 4, 25, 29, 21, 31, 5, 4, 47, 25, 30, 47, 29, 25, 28, 28, 25, 3, 21, 19, 31, 30, 20, 3};
    }

    public static void A07() {
        A0C = new String[]{"U8UpqfD5GcCjHjfawFZje9GDKAZv", "HUavThSyJs21QkbQiVkA2MVijDNZ2nZM", "IARTRQxD0JaHLqaDLyMBN", "Hsg2CAAgFk1Vd6W6cseJD0UtB0g0pB8N", "UbckorOyb4FxR7xZ8GphAvSWlQBuZ4z3", "t3UgO82iTBj4Je3asj0XN1i1cbfA", "fleIFkN77EtPYIR4IZjCzdODP1NyIKiN", "OPDxW3mvsrdjNTdOIjiPk89aFloqol7I"};
    }

    static {
        A07();
        A06();
    }

    public AnonymousClass1S(String str, String str2, int i, String str3, String str4, NV nv, int i2, boolean z, boolean z2, AnonymousClass1T r10) {
        this.A07 = str;
        this.A06 = str2;
        this.A01 = i;
        this.A08 = str3;
        this.A05 = str4;
        this.A04 = nv;
        this.A02 = i2;
        this.A0A = z;
        this.A09 = z2;
        this.A03 = r10;
    }

    public static int A00(JSONObject jSONObject) {
        String A032 = A03(196, 17, 74);
        if (jSONObject.has(A032)) {
            return jSONObject.optInt(A032);
        }
        return jSONObject.optInt(A03(213, 19, 62), 0);
    }

    @Nullable
    public static AnonymousClass1S A01(JSONObject playableAdDataJson) {
        JSONObject optJSONObject = playableAdDataJson.optJSONObject(A03(148, 13, 111));
        if (optJSONObject == null) {
            return null;
        }
        return new AnonymousClass1S(optJSONObject.optString(A03(232, 3, 50)), optJSONObject.optString(A03(118, 19, 87)), A00(playableAdDataJson), A05(optJSONObject), A04(optJSONObject), A02(optJSONObject), optJSONObject.optInt(A03(235, 32, 6), DownloadManager.OPERATION_TIMEOUT), optJSONObject.optBoolean(A03(89, 17, 125), true), optJSONObject.optBoolean(A03(74, 15, 71)), AnonymousClass1T.A00(optJSONObject.optString(A03(161, 17, 61), A0D.name())));
    }

    public static NV A02(JSONObject jSONObject) {
        return NV.A00(jSONObject.optInt(A03(137, 11, 5), A0E.A04()));
    }

    public static String A04(JSONObject jSONObject) {
        JSONObject genericTextObject = jSONObject.optJSONObject(A03(106, 12, 37));
        String A032 = A03(0, 45, 90);
        return genericTextObject == null ? A032 : genericTextObject.optString(A03(58, 16, 69), A032);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject genericTextObject = jSONObject.optJSONObject(A03(106, 12, 37));
        String A032 = A03(45, 13, 101);
        return genericTextObject == null ? A032 : genericTextObject.optString(A03(178, 18, 111), A032);
    }

    public final int A08() {
        return this.A01;
    }

    public final int A09() {
        return this.A02;
    }

    public final AnonymousClass1T A0A() {
        return this.A03;
    }

    public final NV A0B() {
        return this.A04;
    }

    public final String A0C() {
        return this.A00;
    }

    public final String A0D() {
        return this.A05;
    }

    public final String A0E() {
        return this.A06;
    }

    public final String A0F() {
        return this.A07;
    }

    public final String A0G() {
        return this.A08;
    }

    public final void A0H(String str) {
        this.A00 = str;
    }

    public final boolean A0I() {
        return this.A0A;
    }
}
