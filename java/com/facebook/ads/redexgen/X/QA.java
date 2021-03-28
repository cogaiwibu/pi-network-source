package com.facebook.ads.redexgen.X;

import org.json.JSONArray;

public final class QA {
    public static boolean A00(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Q9 A00 = Q9.A00(jSONArray, i);
            if (!(A00 == Q9.A00(jSONArray2, i) && A00.A06(jSONArray, jSONArray2, i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A02(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            int r1 = r5.length()
            int r0 = r6.length()
            r4 = 0
            if (r1 == r0) goto L_0x000c
            return r4
        L_0x000c:
            java.util.Iterator r3 = r5.keys()
        L_0x0010:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0035
            java.lang.Object r2 = r3.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = r6.has(r2)
            if (r0 != 0) goto L_0x0023
            return r4
        L_0x0023:
            com.facebook.ads.redexgen.X.Q9 r1 = com.facebook.ads.redexgen.X.Q9.A01(r5, r2)
            com.facebook.ads.redexgen.X.Q9 r0 = com.facebook.ads.redexgen.X.Q9.A01(r6, r2)
            if (r1 == r0) goto L_0x002e
            return r4
        L_0x002e:
            boolean r0 = r1.A08(r5, r6, r2)
            if (r0 != 0) goto L_0x0010
            return r4
        L_0x0035:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QA.A02(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
