package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.RewardData;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.16  reason: invalid class name */
public abstract class AnonymousClass16 implements Serializable {
    public static JSONObject A0I = null;
    public static byte[] A0J = null;
    public static String[] A0K = null;
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A01 = 200;
    public int A02;
    public RewardData A03;
    public AnonymousClass17 A04;
    public AnonymousClass1N A05;
    public AnonymousClass1Q A06;
    public AnonymousClass1X A07;
    public String A08;
    public String A09;
    @Nullable
    public String A0A;
    public String A0B;
    public String A0C = A00(0, 0, 70);
    public String A0D;
    public String A0E;
    public boolean A0F;
    public final int A0G;
    public final List<AnonymousClass19> A0H;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 60);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        String[] strArr = A0K;
        if (strArr[2].charAt(14) != strArr[1].charAt(14)) {
            String[] strArr2 = A0K;
            strArr2[5] = "bfB1pGz3pHLReaUGKuLSmGsyYLYBAtW";
            strArr2[5] = "bfB1pGz3pHLReaUGKuLSmGsyYLYBAtW";
            A0J = new byte[]{40, 45, 22, 42, 33, 38, 32, 42, 44, 58, 22, 37, 32, 39, 34, 22, 60, 59, 37, 118, 121, 72, 123, 120, 112, 120, 72, 99, 110, 103, 114, 83, 81, 83, 88, 85, 111, 81, 67, 67, 85, 68, 67, 91, 76, 32, 61, 42, 37, 41, 45, 39, 27, 55, 32, 47, 27, 40, 37, 61, 33, 54, 27, 44, 48, 41, 40, 27, 49, 54, 40, 10, 0, 12, 13, 45, 32, 47, 37, 50, 34, 32, 49, 36, 6, 11, 19, 5, 31, 30, 117, 106, 119, 113, 119, 100, 108, 113, 64, 87, 67, 71, 87, 65, 70, 109, 91, 86, 51, 46, 51, 43, 34, 65, 70, 88, 22, 16, 6, 60, 13, 6, 20, 60, 15, 2, 26, 12, 22, 23, 60, 0, 12, 13, 23, 17, 12, 15, 15, 6, 17, 50, 45, 33, 51, 37, 38, 45, 40, 45, 48, 61, 27, 39, 44, 33, 39, 47, 27, 45, 42, 45, 48, 45, 37, 40, 27, 32, 33, 40, 37, 61, 68, 91, 87, 69, 83, 80, 91, 94, 91, 70, 75, 109, 81, 90, 87, 81, 89, 109, 91, 92, 70, 87, 64, 68, 83, 94};
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A0K = new String[]{"1gqRR9im7tmNjhPy8NnQpjCX4rd8Ielc", "ZkOx7RNEMabKvQ7fgN15WIbWDw11JZFu", "ifeh8sROmLFDdOYqa0sy0eFfj5RHH1gU", "fnDzwAhU6GMUs0cCq2fTQuWEzv5lBJki", "OVtNfYqIZ80xqW4zrHdkYxbTKYgYXHc", "chIpxbYwiAOd1RIHlv8aEwW7ihQHRwI", "GnSiEcQE", "uApEYGhuY9oy1RN675k2bDQ9FUD4oA7y"};
    }

    public abstract int A0I();

    public abstract int A0J();

    public AnonymousClass16(List<AnonymousClass19> list) {
        this.A0H = list;
    }

    private void A03(int i) {
        this.A00 = i;
    }

    private void A04(int i) {
        this.A02 = i;
    }

    private void A05(AnonymousClass17 r1) {
        this.A04 = r1;
    }

    private void A06(AnonymousClass1N r1) {
        this.A05 = r1;
    }

    private final void A07(AnonymousClass1Q r1) {
        this.A06 = r1;
    }

    private void A08(AnonymousClass1X r1) {
        this.A07 = r1;
    }

    private void A09(String str) {
        this.A09 = str;
    }

    private void A0A(String str) {
        this.A0D = str;
    }

    private final void A0B(String str) {
        this.A08 = str;
    }

    private void A0C(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.A09)) {
            this.A0C = jSONObject.toString();
        }
    }

    private void A0D(boolean z) {
        this.A0F = z;
    }

    public final int A0E() {
        return this.A00;
    }

    public final int A0F() {
        return this.A01;
    }

    public final int A0G() {
        return this.A02;
    }

    public final int A0H() {
        return this.A0G;
    }

    @Nullable
    public final RewardData A0K() {
        return this.A03;
    }

    public final AnonymousClass17 A0L() {
        return this.A04;
    }

    public final AnonymousClass19 A0M() {
        return this.A0H.get(0);
    }

    public final AnonymousClass1N A0N() {
        return this.A05;
    }

    public final AnonymousClass1Q A0O() {
        return this.A06;
    }

    public final AnonymousClass1X A0P() {
        return this.A07;
    }

    public final String A0Q() {
        return this.A08;
    }

    public final String A0R() {
        return this.A09;
    }

    @Nullable
    public final String A0S() {
        return this.A0A;
    }

    public final String A0T() {
        return this.A0B;
    }

    public final String A0U() {
        return this.A0D;
    }

    public final String A0V() {
        return this.A0E;
    }

    public final List<AnonymousClass19> A0W() {
        return Collections.unmodifiableList(this.A0H);
    }

    public final JSONObject A0X() {
        return A0I;
    }

    public final JSONObject A0Y() {
        try {
            return new JSONObject(this.A0C);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final void A0Z(int i) {
        this.A01 = i;
    }

    public final void A0a(RewardData rewardData) {
        this.A03 = rewardData;
    }

    public final void A0b(@Nullable String str) {
        this.A0A = str;
    }

    public final void A0c(String str) {
        this.A0B = str;
    }

    public final void A0d(String str) {
        this.A0E = str;
    }

    public final void A0e(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        A0I = jSONObject.optJSONObject(A00(31, 12, 12));
        AnonymousClass1P A062 = new AnonymousClass1P().A06(jSONObject.optString(A00(108, 5, 123)));
        String A002 = A00(71, 4, 95);
        JSONObject optJSONObject = jSONObject.optJSONObject(A002);
        String A003 = A00(0, 0, 70);
        if (optJSONObject != null) {
            str = jSONObject.optJSONObject(A002).optString(A00(113, 3, 8));
        } else {
            str = A003;
        }
        A07(A062.A05(str).A04(jSONObject.optString(A00(0, 19, 117))).A07(AnonymousClass1R.A03(jSONObject)).A08());
        JSONObject optJSONObject2 = jSONObject.optJSONObject(A00(84, 6, 86));
        JSONObject jSONObject3 = null;
        if (optJSONObject2 != null) {
            String A004 = A00(90, 8, 57);
            if (A0K[5].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[2] = "L9OC0yGJthGch16tOTqUcqcE9MnsMaz6";
            strArr[1] = "n6CgIEssquLp46jPM2UWfBhL1rINMjIc";
            jSONObject2 = optJSONObject2.optJSONObject(A004);
        } else {
            jSONObject2 = null;
        }
        AnonymousClass1H A012 = AnonymousClass1H.A01(jSONObject2);
        if (optJSONObject2 != null) {
            jSONObject3 = optJSONObject2.optJSONObject(A00(75, 9, 125));
        }
        A05(new AnonymousClass17(A012, AnonymousClass1H.A01(jSONObject3)));
        A08(AnonymousClass1R.A01(jSONObject));
        A06(AnonymousClass1R.A00(jSONObject));
        A0B(jSONObject.optString(A00(43, 2, 4)));
        A0A(jSONObject.optString(A00(98, 10, 14), A003));
        A09(jSONObject.optString(A00(45, 26, 120), A003));
        A03(jSONObject.optInt(A00(19, 12, 43), 0));
        A0C(jSONObject);
        A04(jSONObject.optInt(A00(141, 31, 120), 0));
        A0Z(jSONObject.optInt(A00(172, 26, 14), 1000));
        A0D(jSONObject.optBoolean(A00(116, 25, 95)));
    }

    public final boolean A0f() {
        return this.A0F;
    }
}
