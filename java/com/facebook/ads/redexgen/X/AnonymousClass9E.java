package com.facebook.ads.redexgen.X;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.9E  reason: invalid class name */
public final class AnonymousClass9E {
    public static byte[] A00;
    public static String[] A01;
    public static final SparseIntArray A02 = new SparseIntArray();
    public static final Map<String, Integer> A03 = new HashMap();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{3, -1, -2, 50, 33, 38, 34, 43, 32, 34, 11, 34, 49, 52, 44, 47, 40, -63, -67, -78, -76, -74, -66, -74, -65, -59, -60, -48, -68, -74, -54, -27, -3, -5, 2, 2, -5, 0, -7, -78, -5, 0, -5, 6, -78, -10, 7, -9, -78, 6, 1, -78, -2, -13, -11, -3, -78, 1, -8, -78, -11, 1, 0, 0, -9, -11, 6, -5, 8, -5, 6, 11, -64, 27, 34, 29, 29, 30, 43, 24, 45, 40, 36, 30, 39, 3, 22, 15, 5, 13, 6, 20, -8, 4, 3, 3, -6, -8, 9, -2, 11, -2, 9, 14, 38, 50, 49, 55, 40, 59, 55, -50, -51, -55, -36, -35, -38, -51, -57, -53, -41, -42, -50, -47, -49, 6, 9, 12, 12, -39, -54, -30, -43, -40, -54, -51, -46, -50, -61, -59, -57, -49, -57, -48, -42, -63, -56, -47, -44, -49, -61, -42, -43, 27, 23, 12, 14, 16, 24, 16, 25, 31, 10, 20, 15, 30, 16, 3, 15, 19, 3, 17, 18};
    }

    public static void A03() {
        A01 = new String[]{"PAVmNMJ6hNXqyRqmf1Doke6LQ8aMFdOg", "iuSnr5mIAvkputnHCV42XmFxKij5KqRv", "5f2Rj8D53s9YgCs1y8vFwUZB8s77zEMu", "g9qsOieArYo5RvIYh6PAxBWVjxzJiH5j", "XDam3FbFKbKfc7xmRHTLGW4HsEtQzQza", "fVcqTxqBSVLVjRnvznAg", "FuHpjfTv97DE7Ep9HAA56glTVlKxMjBD", "hFlNuwKsY8ujBQkLvvvenNI3HVRbI8no"};
    }

    static {
        A03();
        A02();
        A02.put(19, 1);
        A02.put(18, 2);
        A02.put(20, 4);
        A02.put(36, 6);
        A02.put(40, 3);
        A02.put(61, 5);
    }

    public static synchronized Integer A00(String str) {
        synchronized (AnonymousClass9E.class) {
            Integer num = A03.get(str);
            if (num == null) {
                return 0;
            }
            return Integer.valueOf(A02.get(num.intValue()));
        }
    }

    /* JADX INFO: Multiple debug info for r2v13 java.util.Iterator<java.lang.String>: [D('payloadContext' org.json.JSONObject), D('keyIterator' java.util.Iterator<java.lang.String>)] */
    /* JADX INFO: Multiple debug info for r0v52 java.lang.String: [D('httpsClient' com.facebook.ads.redexgen.X.Pm), D('placement' java.lang.String)] */
    public static void A04(C0821Wi wi, MultithreadedBundleWrapper multithreadedBundleWrapper) throws JSONException {
        ArrayList<String> stringArrayList;
        NetworkInfo activeNetworkInfo;
        String bidderToken = DynamicLoaderFactory.makeLoader(wi).createBidderTokenProviderApi().getBidderToken(wi);
        ConnectivityManager connectivityManager = (ConnectivityManager) wi.getSystemService(A01(92, 12, 72));
        if (connectivityManager == null || ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting())) {
            AbstractC0646Pm A022 = Q4.A02(false, wi);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(A01(73, 12, 108), bidderToken);
            if (!(multithreadedBundleWrapper == null || (stringArrayList = multithreadedBundleWrapper.getStringArrayList(A01(17, 14, 36))) == null)) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put(A01(153, 13, 94), jSONArray);
            }
            A05(wi, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(A01(136, 17, 21), A01(125, 4, 83));
            jSONObject3.put(A01(111, 14, 27), A01(125, 4, 83));
            jSONObject.put(A01(104, 7, 118), jSONObject2);
            jSONObject.put(A01(166, 7, 81), jSONObject3);
            Q0 q0 = new Q0();
            q0.put(A01(129, 7, 28), jSONObject.toString());
            AbstractC0645Pl ABd = A022.ABd(KJ.A05(wi), q0.A09());
            if (ABd != null && ABd.A74() == 200) {
                String A5U = ABd.A5U();
                if (!TextUtils.isEmpty(A5U)) {
                    JSONObject payload = new JSONObject(A5U).optJSONObject(A01(85, 7, 84));
                    JSONObject optJSONObject = payload.optJSONObject(A01(136, 17, 21));
                    String optString = payload.optString(A01(111, 14, 27));
                    if (!TextUtils.isEmpty(optString)) {
                        J8.A0M(wi).A1m(optString);
                    }
                    HashMap hashMap = new HashMap();
                    Iterator<String> keyIterator = optJSONObject.keys();
                    while (keyIterator.hasNext()) {
                        String next = keyIterator.next();
                        hashMap.put(next, Integer.valueOf(Integer.parseInt(optJSONObject.getString(next))));
                    }
                    String[] strArr = A01;
                    if (strArr[1].charAt(1) != strArr[6].charAt(1)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[5] = "staqUk3OlqofBPoOW92gC9gLz0Qw";
                    strArr2[5] = "staqUk3OlqofBPoOW92gC9gLz0Qw";
                    synchronized (A03) {
                        A03.putAll(hashMap);
                    }
                }
            }
        } else if (BuildConfigApi.isDebug()) {
            Log.e(A01(0, 17, 112), A01(31, 42, 69));
        }
    }

    public static void A05(C0821Wi wi, JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, String> entry : AnonymousClass9C.A00().A01(wi, true).A69().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }
}
