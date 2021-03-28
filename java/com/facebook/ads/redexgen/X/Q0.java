package com.facebook.ads.redexgen.X;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Q0 implements Map<String, String> {
    public static byte[] A01;
    public static String[] A02;
    public Map<String, String> A00;

    static {
        A04();
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[0].charAt(17) != '0') {
                String[] strArr = A02;
                strArr[6] = "S05lPw0aRgv2lts";
                strArr[4] = "ULH8g1fEmmBcyVg";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 49);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A03() {
        A01 = new byte[]{-56, -63, -48, -49, -63, -88, -77};
    }

    public static void A04() {
        A02 = new String[]{"PF87FPxaVTPso7PkqBpb9R8ptdrOrcnN", "LLxQm2Zb2cHXH3GFymsIhrLJVNNE7YVf", "GuFHMY1Ngi3Kc2EktfHyZFCwamvVcTYP", "RLQ8yg86xneBytoGnRzJJpBSehxbgMLw", "NMpoE2AaAPP7Vgv", "uWFt37UVBdA9eGMxe0FCLaB7SA4moHLj", "Z5zgjYqznpdx1Id", "YNAb6cApL15ElRgBdI6o6I27RW0RMDqg"};
    }

    public Q0() {
        this.A00 = new HashMap();
    }

    public Q0(Map<String, String> map) {
        this.A00 = map;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final String get(Object obj) {
        return this.A00.get(obj);
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final String remove(Object obj) {
        return this.A00.remove(obj);
    }

    public final Q0 A05(String str, String str2) {
        this.A00.put(str, str2);
        return this;
    }

    public final Q0 A06(Map<? extends String, ? extends String> arg) {
        putAll(arg);
        return this;
    }

    public final String A07() {
        if (this.A00 == null) {
            return A00(0, 0, 66);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.A00.keySet()) {
            if (sb.length() > 0) {
                String[] strArr = A02;
                if (strArr[5].charAt(2) != strArr[2].charAt(2)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "xulkP76phNp8oPrFkycOZ9oAWaaFvsfs";
                strArr2[1] = "xulkP76phNp8oPrFkycOZ9oAWaaFvsfs";
                sb.append(A00(0, 1, 113));
            }
            sb.append(str);
            String str2 = this.A00.get(str);
            if (str2 != null) {
                sb.append(A00(1, 1, 83));
                try {
                    sb.append(URLEncoder.encode(str2, A00(2, 5, 74)));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: A08 */
    public final String put(String str, String str2) {
        return this.A00.put(str, str2);
    }

    public final byte[] A09() {
        byte[] bArr = null;
        try {
            bArr = A07().getBytes(A00(2, 5, 74));
            return bArr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public final void clear() {
        this.A00.clear();
    }

    public final boolean containsKey(Object obj) {
        return this.A00.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.A00.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, String>> entrySet() {
        return this.A00.entrySet();
    }

    public final boolean isEmpty() {
        return this.A00.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.A00.keySet();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends String> map) {
        this.A00.putAll(map);
    }

    public final int size() {
        return this.A00.size();
    }

    @Override // java.util.Map
    public final Collection<String> values() {
        return this.A00.values();
    }
}
