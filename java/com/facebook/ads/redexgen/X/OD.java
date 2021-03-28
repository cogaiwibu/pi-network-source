package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class OD {
    public static byte[] A05;
    public final O7 A00;
    public final String A01;
    public final String A02;
    public final WeakReference<JE> A03;
    public final WeakReference<C0664Qe> A04;

    static {
        A08();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A05 = new byte[]{-52, -8, -2, -11, -19, -87, -9, -8, -3, -87, -7, -22, -5, -4, -18, -87, -4, -18, -5, -1, -18, -5, -87, -10, -18, -4, -4, -22, -16, -18, 14, 59, 59, 56, 59, -23, 57, 42, 59, 60, 50, 55, 48, -23, 19, 28, 24, 23, -23, 50, 55, -23, 57, 56, 60, 61, 22, 46, 60, 60, 42, 48, 46, -23, 7, 27, 26, 14, -15, 11, 31, 62, 74, 72, 72, 60, 73, 63, -30, -11, -15, -17, -34, -36, -31, -34, -15, -34, 12, 27, 20, 20, 11, 18, 5, 26, 31, 22, 11, -23, -18, -27, -38};
    }

    public OD(C0664Qe qe, JE je, O7 o7, String str, String str2) {
        this.A04 = new WeakReference<>(qe);
        this.A03 = new WeakReference<>(je);
        this.A00 = o7;
        this.A01 = str;
        this.A02 = str2;
    }

    public static Map<String, String> A01(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    private void A02() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0M();
        }
    }

    private void A03() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0N();
        }
    }

    private void A04() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0O();
        }
    }

    private void A05() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0Q();
        }
    }

    private void A06() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0R();
        }
    }

    private void A07() {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0S();
        }
    }

    private void A09(OC oc, String str) throws JSONException {
        switch (OB.A00[oc.ordinal()]) {
            case 1:
                A0A(new JSONObject(str));
                return;
            case 2:
                A06();
                return;
            case 3:
                A02();
                return;
            case 4:
                A04();
                return;
            case 5:
                A03();
                return;
            case 6:
                A07();
                return;
            case 7:
                A0B(new JSONObject(str));
                return;
            case 8:
                A0C(new JSONObject(str));
                return;
            case 9:
                if (BuildConfigApi.isDebug()) {
                }
                return;
            case 10:
                A05();
                return;
            default:
                return;
        }
    }

    private void A0A(JSONObject jSONObject) {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            String optString = jSONObject.optString(A00(71, 7, 103));
            if (TextUtils.isEmpty(optString)) {
                qe.A0P();
            } else {
                qe.A0T(optString);
            }
        }
    }

    private void A0B(JSONObject jSONObject) {
        C0664Qe qe = this.A04.get();
        if (qe != null) {
            qe.A0U(A01(jSONObject));
        }
    }

    private void A0C(JSONObject jSONObject) {
        JE je = this.A03.get();
        if (je != null) {
            String optString = jSONObject.optString(A00(88, 11, 50));
            if (!TextUtils.isEmpty(optString)) {
                new JL(this.A02, je).A04(optString, A01(jSONObject));
            }
        }
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.OD: [D('object' org.json.JSONObject), D('e' org.json.JSONException)] */
    @JavascriptInterface
    public void postMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!this.A01.equals(jSONObject.optString(A00(64, 7, 50)))) {
                this.A00.A05(C02248i.A0p, A00(0, 30, 21));
            } else {
                A09(OC.A00(jSONObject.optString(A00(99, 4, 1))), jSONObject.optString(A00(78, 10, 9)));
            }
        } catch (JSONException e) {
            O7 o7 = this.A00;
            int i = C02248i.A0r;
            o7.A05(i, A00(30, 34, 85) + e.getMessage());
        }
    }
}
