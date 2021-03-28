package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VP implements AbstractC01886p<String> {
    public static byte[] A01;
    public static String[] A02;
    public final Map<String, String> A00;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{96, -74, 116, 35, -29};
    }

    public static void A04() {
        A02 = new String[]{"a0vPx9r", "g6urVoqpDzgarLiHPisYP6lg0a1Qsxi7", "0D95gUzv3ykjkUAaNmvS0PMqJMmLe", "FmsqkIGDIxf1pyhk8KrqJDmLtRXh", "VdLzyHL", "Y0U6bkGUHGFfKGq4XniOfCVYQx4Des4Z", "CuvTUYqsdTaVr4XM9Y5z36A2N9cPvqqS", "uyYe2wlLl6RVS9ukoAhHAdIguTPHvaGb"};
    }

    public VP(Enumeration<InetAddress> enumeration) {
        this.A00 = A01(enumeration);
    }

    public /* synthetic */ VP(Enumeration enumeration, VO vo) {
        this(enumeration);
    }

    public static Map<String, String> A01(Enumeration<InetAddress> enumeration) {
        String A002;
        HashMap hashMap = new HashMap();
        while (enumeration.hasMoreElements()) {
            InetAddress nextElement = enumeration.nextElement();
            if (!(nextElement instanceof Inet4Address)) {
                boolean z = nextElement instanceof Inet6Address;
                if (A02[5].charAt(2) != 'I') {
                    String[] strArr = A02;
                    strArr[0] = "Gz9fwzC";
                    strArr[4] = "ybYvLhq";
                    if (!z) {
                        continue;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            String hostAddress = nextElement.getHostAddress();
            if (nextElement instanceof Inet4Address) {
                if (A02[6].charAt(24) != 'i') {
                    String[] strArr2 = A02;
                    strArr2[1] = "2FnSkM3RXE8ViMwKPYtNPOmsjhf021fL";
                    strArr2[7] = "CXfbTdSUzlrlHA9c2DxJWpFugzDpw8Hh";
                    A002 = A00(1, 2, 11);
                } else {
                    A002 = A00(1, 2, 11);
                }
            } else if (A02[2].length() != 29) {
                throw new RuntimeException();
            } else {
                String[] strArr3 = A02;
                strArr3[5] = "FRlIOdImLcKdb9WRfG0MH6oacSxD1nRF";
                strArr3[5] = "FRlIOdImLcKdb9WRfG0MH6oacSxD1nRF";
                A002 = A00(3, 2, 120);
            }
            boolean contains = hostAddress.contains(A00(0, 1, 6));
            String[] strArr4 = A02;
            if (strArr4[1].charAt(27) != strArr4[7].charAt(27)) {
                String[] strArr5 = A02;
                strArr5[5] = "trbotCFTtTb6ytC4d3Dugjdfr0hOKtvS";
                strArr5[5] = "trbotCFTtTb6ytC4d3Dugjdfr0hOKtvS";
                if (contains) {
                    hostAddress = hostAddress.substring(0, hostAddress.indexOf(37));
                }
                hashMap.put(A002, hostAddress);
            } else {
                throw new RuntimeException();
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final JSONObject ADW(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        boolean z = false;
        for (Map.Entry<String, String> entry : this.A00.entrySet()) {
            if (entry.getKey() != null && !entry.getKey().isEmpty() && entry.getValue() != null && !entry.getValue().isEmpty()) {
                z = true;
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (z) {
            return jSONObject.put(str, jSONObject2);
        }
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01886p
    public final boolean A7a(Object obj) {
        VP vp = (VP) obj;
        Map<String, String> map = this.A00;
        if (map != null) {
            Map<String, String> map2 = vp.A00;
            if (A02[3].length() != 23) {
                String[] strArr = A02;
                strArr[0] = "yfFtf6a";
                strArr[4] = "R3xveNN";
                if (map2 != null) {
                    if (map.size() != vp.A00.size()) {
                        return false;
                    }
                    Iterator<Map.Entry<String, String>> newInetAddressIterator = vp.A00.entrySet().iterator();
                    for (Map.Entry<String, String> entry : this.A00.entrySet()) {
                        Map.Entry<String, String> next = newInetAddressIterator.next();
                        if (entry == null || next == null) {
                            if (entry == null && next == null) {
                                return true;
                            }
                            return false;
                        } else if (entry.getKey() != null && !entry.getKey().equals(next.getKey())) {
                            return false;
                        } else {
                            if (!(entry.getValue() == null || entry.getValue().equals(next.getValue()))) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        if (this.A00 == null && vp.A00 == null) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01886p
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final int ADC() {
        int i = 0;
        for (Map.Entry<String, String> entry : this.A00.entrySet()) {
            int length = entry.getKey().length();
            String value = entry.getValue();
            if (A02[6].charAt(24) != 'i') {
                String[] strArr = A02;
                strArr[3] = "05271w6tHpnBYDqabX5nc55hVF5X";
                strArr[3] = "05271w6tHpnBYDqabX5nc55hVF5X";
                i += length + value.length();
            } else {
                throw new RuntimeException();
            }
        }
        return i;
    }
}
