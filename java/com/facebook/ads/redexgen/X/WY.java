package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WY<K, V> extends AbstractC01966x<HashMap<K, AbstractC01886p>> {
    public static byte[] A02;
    public static String[] A03;
    public final EnumC01956w A00;
    public final HashMap<K, AbstractC01886p> A01;

    static {
        A04();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 110);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{104};
    }

    public static void A04() {
        A03 = new String[]{"cKuQ341bpQpj1np", "NRRRR4TEAm42mDR", "Q3CZak00lhavTOo6A", "zaO6DFhzYxSygkW1IzlMUY8ES4dk", "HbJVSBx3MNS6tqQ9XVLKo36QU0gI1Znv", "JrCrl10lt1AHnaihPuUoLOH", "SHM67NRdcA0GW9YM4", "2pIXYY"};
    }

    public WY(long j, @Nullable C01946v r9, HashMap<K, AbstractC01886p> hashMap, EnumC01956w r11) {
        super(j, r9, hashMap, EnumC01956w.A0A);
        this.A01 = hashMap;
        this.A00 = r11;
        if (!A05()) {
            throw new UnsupportedOperationException();
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(K k) {
        int i = C01906r.A00[this.A00.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return k.length();
        }
        throw new UnsupportedOperationException();
    }

    private boolean A05() {
        int i = C01906r.A00[this.A00.ordinal()];
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        int i = 0;
        if (A08() == null || ((HashMap) A08()).isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : ((HashMap) A08()).entrySet()) {
            int A002 = i + A00(entry.getKey());
            if (A03[5].length() != 26) {
                String[] strArr = A03;
                strArr[4] = "UsP7Xgcu0nWDAT33HhVsw8aoixo7a0Y1";
                strArr[4] = "UsP7Xgcu0nWDAT33HhVsw8aoixo7a0Y1";
                i = A002 + ((AbstractC01886p) entry.getValue()).ADC();
            } else {
                throw new RuntimeException();
            }
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject mapJsonObject) throws JSONException {
        Set<K> keySet = this.A01.keySet();
        JSONObject jSONObject = new JSONObject();
        for (K k : keySet) {
            AbstractC01886p r4 = this.A01.get(k);
            if (A03[5].length() != 26) {
                String[] strArr = A03;
                strArr[5] = "RtRjz";
                strArr[5] = "RtRjz";
                if (r4 != null) {
                    r4.ADW(k, jSONObject);
                }
            } else {
                throw new RuntimeException();
            }
        }
        mapJsonObject.put(A01(0, 1, 112), jSONObject);
        return mapJsonObject;
    }

    /* JADX INFO: Multiple debug info for r0v22 com.facebook.ads.redexgen.X.6p: [D('newSignal' com.facebook.ads.redexgen.X.6p), D('prevSignal' com.facebook.ads.redexgen.X.6p)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    @SuppressLint({"Nullable Dereference"})
    public final boolean A0B(AbstractC01966x<HashMap<K, AbstractC01886p>> r11) {
        boolean A7a;
        if (A08() == null || r11.A08() == null) {
            if (A08() == null && r11.A08() == null) {
                return true;
            }
            return false;
        } else if (r11.A08().size() != ((HashMap) A08()).size()) {
            return false;
        } else {
            HashMap<K, AbstractC01886p> A08 = r11.A08();
            HashMap hashMap = (HashMap) A08();
            Iterator<K> it = A08.keySet().iterator();
            Iterator<K> it2 = hashMap.keySet().iterator();
            do {
                boolean hasNext = it.hasNext();
                String[] strArr = A03;
                if (strArr[1].length() == strArr[0].length()) {
                    String[] strArr2 = A03;
                    strArr2[1] = "rUsYWVrpG3VWCqr";
                    strArr2[0] = "lLqYbR21ojeq3r6";
                    if (!hasNext || !it2.hasNext()) {
                        return true;
                    }
                    K next = it.next();
                    K next2 = it2.next();
                    if (!next.equals(next2) || !A08.containsKey(next) || !hashMap.containsKey(next2)) {
                        return false;
                    }
                    AbstractC01886p r1 = A08.get(next);
                    AbstractC01886p prevSignal = (AbstractC01886p) hashMap.get(next2);
                    if (r1 != null && prevSignal != null) {
                        A7a = r1.A7a(prevSignal);
                        String[] strArr3 = A03;
                        if (strArr3[7].length() != strArr3[3].length()) {
                            String[] strArr4 = A03;
                            strArr4[6] = "3Jq7wk4KgDHXBRv7A";
                            strArr4[2] = "zXvlpWgAojYXCnWeF";
                        }
                    } else if (r1 == null && prevSignal == null) {
                        return true;
                    } else {
                        return false;
                    }
                }
                throw new RuntimeException();
            } while (A7a);
            return false;
        }
    }
}
