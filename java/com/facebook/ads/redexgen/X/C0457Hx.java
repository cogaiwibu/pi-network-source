package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Hx  reason: case insensitive filesystem */
public final class C0457Hx {
    public static String[] A02;
    public final List<String> A00 = new ArrayList();
    public final Map<String, Object> A01 = new HashMap();

    static {
        A01();
    }

    public static void A01() {
        A02 = new String[]{"Wtk3PbCDBweHk5gehud8YCSUQvC6nwdT", "sCNfoUxWKDpS1RUAZ9HMqXb5hXmFNfsl", "G0Sd6xJJ5dzC67Fn3g26DayECdEiqz7K", "NSE2Gca4KsMRHPK68YKw53X7X1h8nHIG", "XGHGYVKNABmBEqteJ7Uc8xn1n3vNB0mC", "OOR0T5nG4ewoAkig5Bp6LvVgvITCNpR4", "EPz2kWxbcMMvM", "ydI7STvXrHNyhiZlA4K5PEkXlAxdK"};
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    private C0457Hx A00(String str, Object obj) {
        this.A01.put(I1.A01(str), I1.A01(obj));
        this.A00.remove(str);
        return this;
    }

    public final C0457Hx A02(String str) {
        this.A00.add(str);
        this.A01.remove(str);
        return this;
    }

    public final C0457Hx A03(String str, long j) {
        return A00(str, Long.valueOf(j));
    }

    public final C0457Hx A04(String str, String str2) {
        return A00(str, str2);
    }

    public final List<String> A05() {
        return Collections.unmodifiableList(new ArrayList(this.A00));
    }

    public final Map<String, Object> A06() {
        HashMap hashMap = new HashMap(this.A01);
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A02[6].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "Wf4wPrtpL1AEFsgXvSrjN8BWozQaFEDb";
            strArr[4] = "Wf4wPrtpL1AEFsgXvSrjN8BWozQaFEDb";
            if (!hasNext) {
                return Collections.unmodifiableMap(hashMap);
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
    }
}
