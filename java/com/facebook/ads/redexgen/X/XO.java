package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class XO implements AnonymousClass9O {
    public static byte[] A03;
    public static final String A04 = XO.class.getSimpleName();
    public final C0821Wi A00;
    public final AnonymousClass9Z<JB> A01;
    public final AnonymousClass9Z<JB> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 70);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{102, 100, 43, 34, 100, 48, 61, 52, 33, 126, 100, 24, 61, 28, 47, 60, 55, 45, 10, 45, 54, 43, 56, 62, 60, 11, 60, 58, 54, 43, 61, 29, 56, 45, 56, 59, 56, 42, 60, 105, 72, 65, 72, 89, 72, 73, 13, 72, 91, 72, 67, 89, 23, 13, 15, 66, 101, 109, 104, 97, 96, 36, 112, 107, 36, 103, 104, 97, 101, 118, 36, 97, 114, 97, 106, 112, 119, 36, 119, 112, 107, 118, 101, 99, 97, 97, 70, 78, 75, 66, 67, 7, 83, 72, 7, 67, 66, 84, 66, 85, 78, 70, 75, 78, 93, 66, 7, 70, 73, 7, 66, 81, 66, 73, 83, 7, 65, 85, 72, 74, 7, 67, 70, 83, 70, 69, 70, 84, 66, 7, 107, 76, 68, 65, 72, 73, 13, 89, 66, 13, 64, 66, 91, 72, 13, 72, 91, 72, 67, 89, 94, 13, 75, 95, 66, 64, 13, 68, 67, 0, 75, 65, 68, 74, 69, 89, 13, 94, 89, 66, 95, 76, 74, 72, 13, 79, 76, 78, 70, 13, 89, 66, 13, 72, 91, 72, 67, 89, 94, 13, 73, 76, 89, 76, 79, 76, 94, 72, 118, 81, 89, 92, 85, 84, 16, 68, 95, 16, 64, 81, 66, 67, 85, 16, 81, 94, 16, 85, 70, 85, 94, 68, 16, 86, 66, 95, 93, 16, 89, 94, 29, 86, 92, 89, 87, 88, 68, 16, 67, 68, 95, 66, 81, 87, 85, 123, 92, 84, 81, 88, 89, 29, 73, 82, 29, 79, 88, 92, 89, 29, 73, 85, 88, 29, 83, 72, 80, 95, 88, 79, 29, 82, 91, 29, 88, 75, 88, 83, 73, 78, 29, 91, 79, 82, 80, 29, 89, 92, 73, 92, 95, 92, 78, 88, 12, 43, 35, 38, 47, 46, 106, 62, 37, 106, 57, 47, 56, 35, 43, 38, 35, 48, 47, 106, 43, 46, 106, 47, 60, 47, 36, 62, 105, 78, 70, 76, 73, 71, 72, 84, 13, 97, 68, 101, 86, 69, 78, 84, 115, 84, 79, 82, 65, 71, 69, 114, 69, 67, 79, 82, 68, 100, 65, 84, 65, 66, 65, 83, 69, 56, 15, 9, 5, 24, 14, 74, 14, 11, 30, 11, 8, 11, 25, 15, 74, 12, 11, 3, 6, 31, 24, 15, 74, 5, 9, 9, 31, 24, 24, 15, 14, 74, 29, 2, 15, 4, 74, 24, 15, 11, 14, 3, 4, 13, 74, 15, 28, 15, 4, 30, 25, 68, 61, 40, 40, 57, 49, 44, 40, 28, 25, 12, 25, 47, 34, 95, 72, 78, 66, 95, 73, 114, 73, 76, 89, 76, 79, 76, 94, 72, 65, 87, 65, 65, 91, 93, 92, 109, 91, 86, 46, 56, 46, 46, 52, 50, 51, 2, 41, 52, 48, 56, 100, 121, 125, 117, 49, 42, 46, 32, 43, 88, 85, 92, 73, 12, 23, 18, 23, 22, 14, 23};
    }

    static {
        A03();
    }

    public XO(C0821Wi wi) throws IOException {
        this.A00 = wi;
        this.A01 = new XW(AnonymousClass9W.A00(A00(11, 28, 31), wi), new XM(this));
        this.A02 = new XW(AnonymousClass9W.A00(A00(322, 37, 102), wi), new XN(this));
    }

    private List<JSONObject> A01(List<JSONObject> list, byte[] bArr, int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (i2 == 0) {
                break;
            }
            try {
                list.add(A02(bArr, i, i2));
            } catch (JSONException e) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(A04, A00(85, 45, 97), e);
                }
                A05(C02248i.A21, e);
            }
            i += i2;
        }
        return list;
    }

    public static JSONObject A02(byte[] bArr, int i, int i2) throws JSONException {
        return new JSONObject(new String(Arrays.copyOfRange(bArr, i, i + i2)));
    }

    /* access modifiers changed from: private */
    public void A04(int i, String str) {
        C02258j r4 = new C02258j(str);
        r4.A03(1);
        this.A00.A04().A83(A00(425, 15, 107), i, r4);
    }

    private void A05(int i, Throwable th) {
        this.A00.A04().A82(A00(425, 15, 107), i, new C02258j(th));
    }

    public static byte[] A07(String str, JB jb) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(423, 2, 0), str);
            jSONObject.put(A00(466, 5, 3), jb.A09());
            jSONObject.put(A00(471, 4, 106), jb.A07().toString());
            jSONObject.put(A00(462, 4, 86), LW.A02(jb.A05()));
            jSONObject.put(A00(450, 12, 27), LW.A02(jb.A04()));
            jSONObject.put(A00(440, 10, 116), jb.A08());
            jSONObject.put(A00(419, 4, 62), new JSONObject(jb.A0A()));
            jSONObject.put(A00(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 7, 26), 0);
        } catch (JSONException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(294, 28, 12), e);
            }
        }
        return jSONObject.toString().getBytes();
    }

    public static byte[] A09(JSONObject jSONObject) {
        return jSONObject.toString().getBytes();
    }

    public final int A0A() {
        try {
            return this.A01.A6p();
        } catch (C02509i e) {
            if (!BuildConfigApi.isDebug()) {
                return 0;
            }
            Log.e(A04, A00(245, 49, 123), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0 A[Catch:{ 9i -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int A0B(int r13, java.util.Set<java.lang.String> r14, java.util.Set<java.lang.String> r15) {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XO.A0B(int, java.util.Set, java.util.Set):int");
    }

    /* JADX INFO: Multiple debug info for r0v7 com.facebook.ads.redexgen.X.9Y: [D('lastFetch' com.facebook.ads.redexgen.X.9Y), D('events' java.util.List<org.json.JSONObject>)] */
    public final List<JSONObject> A0C(int i) {
        boolean z = false;
        if (i == -1) {
            z = true;
            i = 30;
        }
        int[] iArr = new int[i];
        byte[] bArr = new byte[(i * 1000)];
        List<JSONObject> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        try {
            AnonymousClass9Y lastFetch = this.A01.A53(bArr, iArr);
            linkedList2.add(lastFetch);
            int A54 = lastFetch.A54();
            linkedList = A01(linkedList, bArr, iArr);
            while (lastFetch.A8T() && (A54 < i || z)) {
                if (z) {
                    Arrays.fill(iArr, 0);
                } else {
                    iArr = new int[(i - A54)];
                }
                lastFetch = this.A01.A53(bArr, iArr);
                linkedList2.add(lastFetch);
                linkedList = A01(linkedList, bArr, iArr);
            }
            for (JSONObject jSONObject : linkedList) {
                this.A02.ADQ(A09(jSONObject));
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                ((AnonymousClass9Y) it.next()).A4f();
            }
        } catch (C02509i e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(359, 53, 44), e);
            }
            A05(C02248i.A1y, e);
        }
        return linkedList;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9O
    public final void A40() {
        try {
            this.A01.clear();
            this.A02.clear();
        } catch (C02509i e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(55, 30, 66), e);
            }
            A05(C02248i.A1v, e);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9O
    public final void ADv(JB jb, AnonymousClass9L<String> r6) {
        C0537Lg.A00(ExecutorC0540Lj.A07, new AnonymousClass9P(jb, r6, this.A01, this.A00), new Void[0]);
    }
}
