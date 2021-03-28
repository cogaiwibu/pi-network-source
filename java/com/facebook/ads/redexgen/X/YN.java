package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class YN extends CY {
    public static byte[] A01;
    public static String[] A02;
    public long A00 = -9223372036854775807L;

    static {
        A0B();
        A0A();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{47, 62, 57, 42, 63, 34, 36, 37, 83, 82, 113, 89, 72, 93, 120, 93, 72, 93};
    }

    public static void A0B() {
        A02 = new String[]{"VtWAGSJcoPK1ZfQIT7kg70", "uvijoF7s18JkyzfLjC52JO", "UbwrKHlSsB9uBr4pHbp3GiHEJPcDIn2y", "M5IiKhc4TX4EBu4m9nlnlg4KrGcCYGid", "uZSF2L4tKNd9pS0dTFbwskwuDNdjgXB", "5", "JxfitwILt0nkPD2n3YPqqh4", "RXlbAzoXPs3VSjVZyf6us5"};
    }

    public YN() {
        super(null);
    }

    public static int A00(IQ iq) {
        return iq.A0F();
    }

    public static Boolean A01(IQ iq) {
        boolean z = true;
        if (iq.A0F() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static Double A02(IQ iq) {
        return Double.valueOf(Double.longBitsToDouble(iq.A0M()));
    }

    public static Object A03(IQ iq, int i) {
        if (i == 0) {
            return A02(iq);
        }
        if (i == 1) {
            return A01(iq);
        }
        if (i == 2) {
            return A05(iq);
        }
        if (i == 3) {
            return A09(iq);
        }
        if (i == 8) {
            HashMap<String, Object> A08 = A08(iq);
            if (A02[5].length() != 0) {
                String[] strArr = A02;
                strArr[7] = "dv1uUJDV50UY3341cCSHZj";
                strArr[6] = "lZLu8OCPwS2vewsoll9LjNz";
                return A08;
            }
        } else if (i == 10) {
            ArrayList<Object> A06 = A06(iq);
            String[] strArr2 = A02;
            if (strArr2[1].length() == strArr2[0].length()) {
                String[] strArr3 = A02;
                strArr3[4] = "2Wm";
                strArr3[4] = "2Wm";
                return A06;
            }
        } else if (i != 11) {
            return null;
        } else {
            return A07(iq);
        }
        throw new RuntimeException();
    }

    public static String A05(IQ iq) {
        int position = iq.A0J();
        int A07 = iq.A07();
        iq.A0a(position);
        return new String(iq.A00, A07, position);
    }

    public static ArrayList<Object> A06(IQ iq) {
        int A0I = iq.A0I();
        ArrayList<Object> arrayList = new ArrayList<>(A0I);
        for (int type = 0; type < A0I; type++) {
            arrayList.add(A03(iq, A00(iq)));
        }
        return arrayList;
    }

    public static Date A07(IQ iq) {
        Date date = new Date((long) A02(iq).doubleValue());
        iq.A0a(2);
        return date;
    }

    public static HashMap<String, Object> A08(IQ iq) {
        int A0I = iq.A0I();
        HashMap<String, Object> hashMap = new HashMap<>(A0I);
        for (int i = 0; i < A0I; i++) {
            hashMap.put(A05(iq), A03(iq, A00(iq)));
        }
        return hashMap;
    }

    public static HashMap<String, Object> A09(IQ iq) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String A05 = A05(iq);
            int A002 = A00(iq);
            if (A02[4].length() != 22) {
                String[] strArr = A02;
                strArr[1] = "V4HwzONZDXYgxClN6ndm7q";
                strArr[0] = "UAxIIFeY73WGzRiRR4AY1i";
                if (A002 == 9) {
                    return hashMap;
                }
                hashMap.put(A05, A03(iq, A002));
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final void A0C(IQ iq, long j) throws AN {
        if (A00(iq) == 2) {
            if (A04(8, 10, 28).equals(A05(iq)) && A00(iq) == 8) {
                Map<String, Object> metadata = A08(iq);
                String A04 = A04(0, 8, 107);
                if (metadata.containsKey(A04)) {
                    double doubleValue = ((Double) metadata.get(A04)).doubleValue();
                    if (doubleValue > 0.0d) {
                        this.A00 = (long) (1000000.0d * doubleValue);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new AN();
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A0D(IQ iq) {
        return true;
    }

    public final long A0E() {
        return this.A00;
    }
}
