package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.1K  reason: invalid class name */
public final class AnonymousClass1K {
    public static byte[] A06;
    public static String[] A07;
    public int A00;
    public int A01;
    public int A02 = 0;
    public long A03;
    public String A04;
    public LinkedList<Integer> A05 = new LinkedList<>();

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 106);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{70, 27, 12, 109, 60, 8, 31, 11, 15, 31, 20, 25, 3, 90, 57, 27, 10, 10, 19, 20, 29, 90, 62, 27, 14, 27, 64, 90, 20, 21, 20, 31, 90, 51, 20, 14, 31, 29, 31, 8, 90, 21, 25, 25, 15, 8, 8, 31, 20, 25, 31, 1, 11, 9, 24, 53, 62, 51, 34, 41, 32, 36, 53, 52, 15, 57, 52, 55, 59, 59, 45, 42, 42, 61, 54, 59, 61, 43, 119, 98, 117, 110, 104, 99, 57, 46, 52, 53, 30, 46, 34, 34, 52, 51, 51, 36, 47, 34, 36, 30, 50, 36, 34, 50, 102, 113, 107, 106, 65, 110, 123, 108, 119, 113, 122, 34, 27};
    }

    public static void A03() {
        A07 = new String[]{"Du56ltgKKs1OVAX5", "GkTmjkH3MPiTFcKSZdtZeP", "KEGdoxZZnAdDUnYCV96i9ePmYlw0nVcs", "eeVVi2jaa6aVR", "fQADRcl3z4I9sbyUvoxt9O6e4jXdGtkI", "3SSpimwT8orOGywmbz8JxKLw4xXAqR", "PizR3LI8tsUKIk44MqfkEczppTSirtIQ", "PpMlGdJ0WRh5qmood9xHloOk"};
    }

    public AnonymousClass1K(String str) {
        this.A04 = str;
    }

    private void A01() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        while (!this.A05.isEmpty() && this.A05.peekFirst() != null && currentTimeMillis - ((long) this.A05.peekFirst().intValue()) >= ((long) this.A00)) {
            this.A05.removeFirst();
        }
    }

    public final void A04(int i) {
        this.A02 = i;
    }

    public final void A05(int i, int i2, long j) {
        this.A00 = i;
        this.A01 = i2;
        this.A03 = j;
    }

    public final void A06(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.get(i) instanceof Integer) {
                this.A05.addLast((Integer) jSONArray.get(i));
            } else {
                throw new JSONException(A00(4, 47, 16));
            }
        }
    }

    public final void A07(boolean z) {
        if (z) {
            this.A05.addLast(Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        }
        A01();
    }

    public final boolean A08() {
        return ((long) this.A05.size()) >= this.A03;
    }

    public final boolean A09() {
        return (System.currentTimeMillis() / 1000) - ((long) this.A02) <= ((long) this.A01);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A00(115, 1, 51));
        sb.append(A00(55, 12, 58));
        String A002 = A00(1, 1, 75);
        sb.append(A002);
        sb.append(this.A04);
        String A003 = A00(0, 1, 0);
        sb.append(A003);
        sb.append(A00(78, 6, 109));
        sb.append(A002);
        sb.append(this.A00);
        sb.append(A003);
        sb.append(A00(104, 11, 116));
        sb.append(A002);
        sb.append(this.A01);
        sb.append(A003);
        sb.append(A00(52, 3, 2));
        sb.append(A002);
        sb.append(this.A03);
        sb.append(A003);
        sb.append(A00(84, 20, 43));
        sb.append(A002);
        sb.append(this.A02);
        sb.append(A003);
        sb.append(A00(67, 11, 50));
        sb.append(A00(2, 2, 92));
        Iterator<Integer> it = this.A05.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A07[1].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[7] = "ktnl640oaPGPfDqOI7";
            strArr[7] = "ktnl640oaPGPfDqOI7";
            if (hasNext) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(A003);
                }
            } else {
                sb.append(A00(51, 1, 54));
                sb.append(A00(116, 1, 12));
                return sb.toString();
            }
        }
    }
}
