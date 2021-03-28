package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.sync.SyncClientBundleRequestType;
import com.facebook.ads.sync.SyncModifiableBundle;
import com.facebook.ads.sync.SyncModuleImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.ads.redexgen.X.Fi  reason: case insensitive filesystem */
public final class C0392Fi implements QN {
    public static byte[] A0A;
    public static String[] A0B;
    @VisibleForTesting
    public final Runnable A00;
    public final AnonymousClass8U A01;
    public final AbstractC0646Pm A02;
    public final QG A03 = new QG(this);
    public final QL A04;
    public final QM A05;
    public final String A06;
    public final List<QR> A07 = new ArrayList();
    public final Map<QC, AnonymousClass48> A08 = new HashMap();
    public final Map<QC, C0402Fu> A09 = new HashMap();

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0A = new byte[]{101, -82, -72, 101, -73, -86, -72, -71, -73, -82, -88, -71, -86, -87, 115, 101, -104, -80, -82, -75, -75, -82, -77, -84, 101, -72, -66, -77, -88, -46, -16, -3, -3, -2, 3, -81, -14, 1, -12, -16, 3, -12, -81, 2, -12, 1, 5, -12, 1, -81, -15, 4, -3, -13, -5, -12, -81, 6, -8, 3, -9, -81, -3, -2, -3, -68, 2, -12, 1, 5, -12, 1, -81, -2, 6, -3, -12, -13, -81, -15, 4, -3, -13, -5, -12, -81, -40, -45, -53, -24, -5, -24, -89, -9, -7, -10, -22, -20, -6, -6, -16, -11, -18, -89, -10, -9, -5, -16, -10, -11, -89, -80, -43, -35, -56, -45, -48, -53, -121, -39, -52, -51, -39, -52, -38, -49, -121, -37, -48, -44, -52, -95, -121, -116, -53, -44, -21, -3, -90, -7, -21, -8, -4, -21, -8, -77, -11, -3, -12, -21, -22, -90, -24, -5, -12, -22, -14, -21, -90, -23, -8, -21, -25, -6, -21, -22, -64, -90, -85, -7, -74, -36, -47, -58, -53, -43, -46, -47, -52, -35, -60, -41, -52, -46, -47, -125, -43, -56, -44, -40, -56, -42, -41, -125, -41, -46, -125, -120, -42, -99, 109, -120, -42, -101, -63, -74, -85, -80, -70, -73, -74, -79, -62, -87, -68, -79, -73, -74, 104, -70, -83, -69, -72, -73, -74, -69, -83, -126, 82, 109, -69, -88, -50, -61, -72, -67, -57, -60, -61, -66, -49, -74, -55, -66, -60, -61, 117, -57, -54, -61, 117, -69, -74, -66, -63, -70, -71, -112, 117, -69, -60, -57, -72, -66, -61, -68, 117, -66, -61, 117, 122, -71, 117, -56, -70, -72, -60, -61, -71, -56, -127, -108, -115, -125, -117, -124, -110, -102, -90, -91, -85, -100, -81, -85, -106, -109, -90, -109, -120, -117, -112, -119, -121, -108, -110, -108, -117, -112, -106, -79, -94, -70, -83, -80, -94, -91, 126, -37, -50, -49, -37, -50, -36, -47, -45, -58, -46, -42, -58, -44, -43, -40, -53, -39, -42, -43, -44, -39, -53, -32, -51, -34, -45, -47, -32, -53, -34, -47, -46, -34, -47, -33, -44, -53, -33};
    }

    public static void A06() {
        A0B = new String[]{"5Oiv1GLvIq7zEHzIHOTPzi3kaYzi9CKu", "OYJ8Vha7o3AKqeq5fQgjy4YAYzCEKBrH", "4fHxCa0vWIAizdOtLSYViH6HX8wZM136", "7SeobKfCaIBp1RCtBr0PVzHsRPnznuT1", "fOxTiSwrZex6", "3vZIMeafrjOpHP1eiyT8MHuy7IIJRNdQ", "XI5vdZH0G6FndxBvW8fNBqRq2FpLqBJ1", "pJZH6qXQIaEu24ksEJ9XliOUqsc1pAkZ"};
    }

    public C0392Fi(AnonymousClass8U r2, AbstractC0646Pm pm, String str, QM qm, QL ql) {
        this.A01 = r2;
        this.A02 = pm;
        this.A06 = str;
        this.A05 = qm;
        this.A04 = ql;
    }

    public static int A00(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getJSONObject(A01(317, 7, 88)).getInt(A01(339, 16, 91));
        if (i > 0) {
            return i;
        }
        throw new JSONException(String.format(Locale.US, A01(111, 24, 86), Integer.valueOf(i)));
    }

    private Set<QQ> A02(JSONObject responseObject) throws JSONException {
        HashSet hashSet = new HashSet();
        JSONObject jSONObject = responseObject.getJSONObject(A01(331, 8, 85));
        JSONObject jSONObject2 = responseObject.getJSONObject(A01(280, 7, 14));
        for (C0402Fu fu : this.A09.values()) {
            int i = QP.A01[QV.A00(jSONObject.getString(fu.A6M().A04())).ordinal()];
            if (i == 1) {
                hashSet.add(new C01143r(fu, jSONObject2.getJSONObject(fu.A6M().A04()).getJSONObject(A01(294, 4, 33)), jSONObject2.getJSONObject(fu.A6M().A04()).optJSONObject(A01(298, 11, 17))));
            } else if (i == 2) {
                hashSet.add(new AnonymousClass3Y(fu));
            } else {
                throw new AssertionError();
            }
        }
        for (AnonymousClass48 r2 : this.A08.values()) {
            int i2 = QP.A00[QI.A00(jSONObject.getString(r2.A6M().A04())).ordinal()];
            if (i2 == 1) {
                hashSet.add(new AnonymousClass47(r2));
            } else if (i2 == 2) {
                hashSet.add(new AnonymousClass3X(r2));
            } else {
                throw new AssertionError();
            }
        }
        return hashSet;
    }

    private JSONObject A03(Map<QB, QU> map, Map<AbstractC0401Ft, QH> map2, Map<AbstractC0401Ft, JSONObject> map3, Map<AbstractC0401Ft, JSONObject> map4) throws JSONException {
        String A012;
        JSONObject bundleData = new JSONObject();
        for (Map.Entry<QB, QU> entry : map.entrySet()) {
            bundleData.put(entry.getKey().A6M().A04(), entry.getValue().A02());
        }
        for (Map.Entry<AbstractC0401Ft, QH> entry2 : map2.entrySet()) {
            bundleData.put(entry2.getKey().A6M().A04(), entry2.getValue().A03());
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<QB, QU>> it = map.entrySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            A012 = A01(298, 11, 17);
            if (!hasNext) {
                break;
            }
            Map.Entry<QB, QU> next = it.next();
            if (next.getValue() == QU.A04) {
                JSONObject jSONObject2 = new JSONObject();
                QB key = next.getKey();
                jSONObject.put(key.A6M().A04(), jSONObject2);
                if (next.getKey().A6M().A05()) {
                    jSONObject2.put(A012, key.A6I());
                } else {
                    jSONObject2.put(A012, JSONObject.NULL);
                }
                jSONObject.put(key.A6M().A04(), jSONObject2);
            }
        }
        for (Map.Entry<AbstractC0401Ft, QH> entry3 : map2.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            AbstractC0401Ft key2 = entry3.getKey();
            jSONObject3.put(A012, map4.get(entry3.getKey()));
            if (entry3.getValue() == QH.A05) {
                jSONObject3.put(A01(294, 4, 33), map3.get(key2));
                jSONObject.put(key2.A6M().A04(), jSONObject3);
            } else {
                String A042 = key2.A6M().A04();
                String[] strArr = A0B;
                if (strArr[1].charAt(20) != strArr[6].charAt(20)) {
                    String[] strArr2 = A0B;
                    strArr2[5] = "j6hI8A69HBwx3QyEu85lNgwu8aXeWQ7U";
                    strArr2[5] = "j6hI8A69HBwx3QyEu85lNgwu8aXeWQ7U";
                    jSONObject.put(A042, jSONObject3);
                } else {
                    throw new RuntimeException();
                }
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry<String, String> entry4 : this.A05.A6A().entrySet()) {
            if (entry4.getValue() != null) {
                jSONObject4.put(entry4.getKey(), entry4.getValue());
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put(A01(324, 7, 80), bundleData);
        jSONObject5.put(A01(280, 7, 14), jSONObject);
        jSONObject5.put(A01(287, 7, 38), jSONObject4);
        return jSONObject5;
    }

    /* JADX INFO: Multiple debug info for r2v0 java.util.Map<com.facebook.ads.redexgen.X.Ft, org.json.JSONObject>: [D('waitForResponse' java.util.concurrent.CountDownLatch), D('data' java.util.concurrent.atomic.AtomicReference<org.json.JSONObject>)] */
    /* JADX INFO: Multiple debug info for r3v2 java.util.concurrent.atomic.AtomicReference: [D('failureContainer' java.util.concurrent.atomic.AtomicReference<java.lang.Throwable>), D('listener' com.facebook.ads.redexgen.X.QR)] */
    /* JADX INFO: Multiple debug info for r0v32 java.util.Set<com.facebook.ads.redexgen.X.QQ>: [D('syncRequest' org.json.JSONObject), D('responses' java.util.Set<com.facebook.ads.sync.SyncModuleImpl$BundleResponse>)] */
    /* JADX INFO: Multiple debug info for r0v41 com.facebook.ads.redexgen.X.QQ: [D('responses' java.util.Set<com.facebook.ads.sync.SyncModuleImpl$BundleResponse>), D('response' com.facebook.ads.redexgen.X.QQ)] */
    private void A04() throws Throwable {
        Map<SyncModifiableBundle, SyncClientBundleRequestType> clientBundleRequests = new HashMap<>();
        Map<SyncModifiableBundle, JSONObject> clientBundleData = new HashMap<>();
        Map<SyncModifiableBundle, JSONObject> clientBundleFingerprint = new HashMap<>();
        Map<AbstractC0401Ft, JSONObject> hashMap = new HashMap<>();
        synchronized (this) {
            Iterator<C0402Fu> it = this.A09.values().iterator();
            while (it.hasNext()) {
                SyncModifiableBundle syncModifiableBundle = (C0402Fu) it.next();
                if (syncModifiableBundle.A7i()) {
                    clientBundleRequests.put(syncModifiableBundle, QU.A04);
                } else {
                    clientBundleRequests.put(syncModifiableBundle, QU.A03);
                }
            }
            AtomicReference<JSONObject> atomicReference = new AtomicReference<>();
            AtomicReference<JSONObject> atomicReference2 = new AtomicReference<>();
            Iterator<AnonymousClass48> it2 = this.A08.values().iterator();
            while (it2.hasNext()) {
                SyncModifiableBundle syncModifiableBundle2 = (AnonymousClass48) it2.next();
                if (syncModifiableBundle2.A7i()) {
                    if (syncModifiableBundle2.A08(atomicReference, atomicReference2)) {
                        clientBundleData.put(syncModifiableBundle2, QH.A05);
                        clientBundleFingerprint.put(syncModifiableBundle2, atomicReference.get());
                    } else {
                        clientBundleData.put(syncModifiableBundle2, QH.A04);
                    }
                    hashMap.put(syncModifiableBundle2, atomicReference2.get());
                }
            }
            Iterator<QR> it3 = this.A07.iterator();
            if (it3.hasNext()) {
                it3.next();
                throw null;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference3 = new AtomicReference();
        AtomicReference<Throwable> failureContainer = new AtomicReference<>();
        JSONObject A032 = A03(clientBundleRequests, clientBundleData, clientBundleFingerprint, hashMap);
        String.format(Locale.US, A01(170, 33, 82), this.A06, A032.toString(2));
        AbstractC0646Pm pm = this.A02;
        String str = this.A06;
        pm.ABe(str, (A01(309, 8, 48) + URLEncoder.encode(A032.toString())).getBytes(), new C0398Fq(this, atomicReference3, failureContainer, countDownLatch));
        while (true) {
            long count = countDownLatch.getCount();
            if (A0B[5].charAt(3) != 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[4] = "9Vx4r4uQ95Y8";
            strArr[4] = "9Vx4r4uQ95Y8";
            if (count > 0) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                }
            } else {
                synchronized (this) {
                    if (failureContainer.get() == null) {
                        Set<SyncModuleImpl.BundleResponse> responses = A02((JSONObject) atomicReference3.get());
                        HashMap hashMap2 = new HashMap();
                        HashMap hashMap3 = new HashMap();
                        Iterator<SyncModuleImpl.BundleResponse> it4 = responses.iterator();
                        while (it4.hasNext()) {
                            ((QQ) it4.next()).A3P(hashMap2, hashMap3);
                        }
                        this.A03.A04(A00((JSONObject) atomicReference3.get()));
                        Iterator<QR> it5 = this.A07.iterator();
                        if (it5.hasNext()) {
                            it5.next();
                            throw null;
                        }
                    } else {
                        throw failureContainer.get();
                    }
                }
                return;
            }
        }
    }

    public static void A07(String str, AtomicReference<JSONObject> atomicReference, AtomicReference<Throwable> atomicReference2) {
        String.format(Locale.US, A01(203, 28, 55), str);
        try {
            atomicReference.set((JSONObject) new JSONTokener(str).nextValue());
        } catch (ClassCastException | JSONException e) {
            atomicReference2.set(e);
        }
    }

    private synchronized void A09(Throwable th) {
        Iterator<QR> it = this.A07.iterator();
        if (it.hasNext()) {
            it.next();
            new HashMap();
            new HashMap();
            throw null;
        }
        String[] strArr = A0B;
        if (strArr[7].charAt(21) != strArr[0].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0B;
        strArr2[1] = "jOM2sC9axZtdiRuTC4uiooC1eDwAnM4L";
        strArr2[6] = "oYYGFZG36lntZdV46ZffLgIrsbHURGKH";
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A0A() {
        if (this.A01.A7j()) {
            String str = A01(88, 23, 118) + this.A01.A5y().A08() + A01(0, 29, 52);
            A09(new QT());
        } else {
            try {
                A04();
            } catch (Throwable th) {
                String.format(Locale.US, A01(231, 49, 68), Integer.valueOf(this.A04.A01()));
                A09(th);
                this.A03.A04(this.A04.A01());
            }
        }
        Runnable runnable = this.A00;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.facebook.ads.redexgen.X.QN
    public final synchronized QB A4N(QC qc) {
        if (qc.A03() != QE.A03) {
            throw new IllegalArgumentException(A01(29, 59, 126));
        } else if (this.A09.containsKey(qc)) {
            return this.A09.get(qc);
        } else {
            C0402Fu fu = new C0402Fu(qc);
            this.A09.put(qc, fu);
            Iterator<QR> it = this.A07.iterator();
            if (it.hasNext()) {
                it.next();
                throw null;
            }
            String.format(Locale.US, A01(135, 35, 117), qc);
            return fu;
        }
    }

    @Override // com.facebook.ads.redexgen.X.QN
    public final void A59() {
        this.A03.A03();
    }
}
