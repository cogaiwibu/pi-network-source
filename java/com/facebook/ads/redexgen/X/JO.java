package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JO {
    public static byte[] A00;
    public static final String A01 = JO.class.getSimpleName();
    public static final AtomicBoolean A02 = new AtomicBoolean();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{57, 43, 89, 112, -126, 43, -127, 108, 119, ByteCompanionObject.MIN_VALUE, 112, 69, 43, 96, 111, 92, -127, 118, -123, 120, ByteCompanionObject.MIN_VALUE, 120, -127, -121, 124, -127, 122, 51, 118, -126, -120, -127, -121, 120, -123, 77, 51, 125, -96, -108, -110, -99, 116, -96, -90, -97, -91, -106, -93, -92, -54, -21, -16, -100, -27, -22, -27, -16, -27, -35, -24, -27, -10, -31, -32, -99, 116, 119, 119, 124, -121, 124, -126, -127, 116, ByteCompanionObject.MAX_VALUE, 114, 124, -127, 121, -126, -43, -24, -24, -39, -31, -28, -24, -111, -113, -93, -107, -106, -94, -115, -109, -90, -111, -109, -98, -94, -105, -99, -100, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -69, -66, -78, -80, -69, -50, -78, -66, -60, -67, -61, -76, -63, -62, -103, -106, -87, -106, -42, -25, -42, -33, -27, -28, -49, -46, -58, -60, -49, -62, -58, -46, -40, -47, -41, -56, -43, -42, -121, 120, -112, -125, -122, 120, 123, -95, -94, -113, -111, -103, -94, -96, -113, -111, -109, -124, -122, 115, -123, -118, -127, 118, -37, -35, -54, -36, -31, -40, -51, -57, -53, -41, -52, -51};
    }

    static {
        A02();
    }

    public static void A03(AnonymousClass8H r2) {
        if (!A09(r2) && !A02.getAndSet(true)) {
            ExecutorC0540Lj.A06.execute(new C0990bG(r2));
        }
    }

    public static void A04(AnonymousClass8H r7, AbstractC0646Pm pm, Map<String, ?> map) throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(A01(81, 7, 109), A01(13, 1, 41));
        A07(r7, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A01(176, 7, 10), A01(145, 14, 92));
        hashMap2.put(A01(183, 12, 97), String.valueOf((int) IronSourceConstants.BN_AUCTION_FAILED));
        hashMap2.put(A01(88, 16, 39), A01(14, 1, 55));
        hashMap2.put(A01(166, 10, 39), A01(37, 13, 42));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        hashMap2.put(A01(66, 15, 12), jSONObject.toString());
        A07(r7, hashMap2);
        AnonymousClass97 A05 = r7.A05();
        JSONObject A052 = C02268k.A05(new C02288m(A05.A01(), A05.A02(), hashMap2));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(A052);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(135, 4, 46), new JSONObject(hashMap));
        jSONObject2.put(A01(139, 6, 106), jSONArray);
        Q0 q0 = new Q0();
        q0.put(A01(159, 7, 16), jSONObject2.toString());
        pm.ABe(r7.A03().A6H(), q0.A09(), new C0991bH());
    }

    public static void A06(AnonymousClass8H r6, String str) {
        if (!A09(r6)) {
            if (!A02.get()) {
                r6.A04().A8G(A01(145, 14, 92), IronSourceConstants.BN_AUCTION_SUCCESS, new C02258j(A01(50, 16, 117)));
                return;
            }
            synchronized (JO.class) {
                SharedPreferences sharedPreferences = r6.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(104, 31, 104), r6), 0);
                int i = sharedPreferences.getInt(str, 0) + 1;
                sharedPreferences.edit().putInt(str, i).apply();
                if (BuildConfigApi.isDebug()) {
                    String str2 = A01(15, 22, 12) + str + A01(0, 13, 4) + i;
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r0v2 java.util.Map<java.lang.String, java.lang.String>: [D('shortEvnData' java.util.Map<java.lang.String, java.lang.String>), D('dataMap' java.util.Map<java.lang.String, java.lang.String>)] */
    public static void A07(AnonymousClass8H r0, Map<String, String> map) {
        map.putAll(r0.A02().A4S());
    }

    @VisibleForTesting
    public static boolean A08(double d, int i) {
        if (i <= 0 || d >= 1.0d / ((double) i)) {
            return true;
        }
        return false;
    }

    public static boolean A09(AnonymousClass8H r3) {
        if (BuildConfigApi.isDebug()) {
            return false;
        }
        if (!J9.A0U(r3)) {
            return true;
        }
        return A08(r3.A05().A00(), J9.A0C(r3));
    }
}
