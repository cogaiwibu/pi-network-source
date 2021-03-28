package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WU extends AbstractC01966x<HashMap<String, Integer>> {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-44};
        if (A01[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "SxUYlD3A0WMAhXB5PTE";
        strArr[5] = "SxUYlD3A0WMAhXB5PTE";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"Nq1Kb9TOHvzWwANjwVGizSKF", "JWM4IVLufHQSkDOJGyecwcJ9XG51cvJk", "QEyZFLJTZNzdsjJkYvljVioyRUG2XSKd", "n7SG", "D5E01LJ4kvbqK2OQmpgiuXTPXhrvg0RI", "iCSdHB", "iogVWxzO6MdlKqT6F77t9UC3cqMLTkpE", "gUxLojtchnnArKauALgqkHsSrkkPr"};
    }

    public WU(long j, @Nullable C01946v r9, HashMap<String, Integer> signalValues) {
        super(j, r9, signalValues, EnumC01956w.A07);
    }

    /* JADX INFO: Multiple debug info for r0v10 java.lang.String: [D('keySize' int), D('key' java.lang.String)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        int i = 0;
        for (String key : ((HashMap) A08()).keySet()) {
            i += key.getBytes().length;
        }
        return (((HashMap) A08()).size() * 4) + i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = (HashMap) A08();
        Set<String> keySet = hashMap.keySet();
        JSONObject jSONObject2 = new JSONObject();
        for (String str : keySet) {
            jSONObject2.put(str, hashMap.get(str));
        }
        jSONObject.put(A00(0, 1, 13), jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    @SuppressLint({"Nullable Dereference"})
    public final boolean A0B(AbstractC01966x<HashMap<String, Integer>> r10) {
        if (A08() != null) {
            HashMap<String, Integer> A08 = r10.A08();
            if (A01[6].charAt(14) != 'I') {
                String[] strArr = A01;
                strArr[1] = "ZRsxwV5SobJQ5cDwe7XAzXaVJFGFHkOZ";
                strArr[1] = "ZRsxwV5SobJQ5cDwe7XAzXaVJFGFHkOZ";
                if (A08 != null) {
                    if (((HashMap) A08()).size() != ((HashMap) r10.A08()).size()) {
                        return false;
                    }
                    HashMap<String, Integer> A082 = r10.A08();
                    HashMap hashMap = (HashMap) A08();
                    Iterator<String> it = A082.keySet().iterator();
                    Iterator<String> prevSignalValueKeys = hashMap.keySet().iterator();
                    while (it.hasNext() && prevSignalValueKeys.hasNext()) {
                        String newSignalValueKey = it.next();
                        String next = prevSignalValueKeys.next();
                        if (!newSignalValueKey.equals(next) || !A082.containsKey(newSignalValueKey) || !hashMap.containsKey(next) || !A082.get(newSignalValueKey).equals(hashMap.get(next))) {
                            return false;
                        }
                        while (it.hasNext()) {
                            String newSignalValueKey2 = it.next();
                            String next2 = prevSignalValueKeys.next();
                            return false;
                        }
                    }
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        if (A08() == null && r10.A08() == null) {
            return true;
        }
        return false;
    }
}
