package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.b0  reason: case insensitive filesystem */
public final class C0975b0 implements AbstractC0455Hv {
    public static byte[] A02;
    public static String[] A03;
    public static final C0975b0 A04 = new C0975b0(Collections.emptyMap());
    public int A00;
    public final Map<String, byte[]> A01;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[7].length() != strArr[0].length()) {
                String[] strArr2 = A03;
                strArr2[3] = "rKK8X5tVBBDKhSudhE31wx";
                strArr2[3] = "rKK8X5tVBBDKhSudhE31wx";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 62);
                if (A03[2].length() != 16) {
                    String[] strArr3 = A03;
                    strArr3[7] = "FSEtti";
                    strArr3[0] = "";
                    i4 += 0;
                } else {
                    String[] strArr4 = A03;
                    strArr4[5] = "3tkzovd4FYEmOrd3uFeQsH7k2lQqNCGR";
                    strArr4[4] = "QPp8yxf18vRmRgJoVMCalcriT9AA2Yst";
                    i4++;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A03() {
        byte[] bArr = {-121, -84, -76, -97, -86, -89, -94, 94, -76, -97, -86, -77, -93, 94, -79, -89, -72, -93, 120, 94, 11, 31, 28, -41, 42, 32, 49, 28, -41, 38, 29, -41, -36, 42, -41, -33, -36, 27, -32, -41, 32, 42, -41, 30, 41, 28, 24, 43, 28, 41, -41, 43, 31, 24, 37, -41, 36, 24, 47, 32, 36, 44, 36, -41, 24, 35, 35, 38, 46, 28, 27, -15, -41, -36, 27, -31, -32, -46, -71, -60};
        if (A03[3].length() != 22) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "Wq4xFI36yK0vrvDqIYZkxKx0C2M1IMKh";
        strArr[1] = "Wq4xFI36yK0vrvDqIYZkxKx0C2M1IMKh";
        A02 = bArr;
    }

    public static void A04() {
        A03 = new String[]{"", "E0qfI7DZu8nkzGv3MH4nJgqlD44FCDGV", "PylumRpOhcOqV8SE", "Pn3Or3lb8D1PR4hBSIJHER", "QrYBpEt5fxgmrBLneQSlInRulpYQYEG6", "kBYBv8gRMrLmplmIT6dDUsqqwhnWF3zw", "1HLCV5Ojolr5GVwArEzJLOO78iGdJHxw", "UyANx1"};
    }

    static {
        A04();
        A03();
    }

    public C0975b0(Map<String, byte[]> map) {
        this.A01 = Collections.unmodifiableMap(map);
    }

    public static C0975b0 A00(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (A03[6].charAt(12) != 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "zQpUPHnv7TxzcbRfe6tZ6j";
            strArr[3] = "zQpUPHnv7TxzcbRfe6tZ6j";
            if (readInt2 < 0 || readInt2 > 10485760) {
                throw new IOException(A01(0, 20, 0) + readInt2);
            }
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            hashMap.put(readUTF, bArr);
        }
        return new C0975b0(hashMap);
    }

    public static Map<String, byte[]> A02(Map<String, byte[]> map, C0457Hx hx) {
        HashMap hashMap = new HashMap(map);
        A05(hashMap, hx.A05());
        A06(hashMap, hx.A06());
        return hashMap;
    }

    public static void A05(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            hashMap.remove(list.get(i));
        }
    }

    /* JADX INFO: Multiple debug info for r0v2 java.lang.Object: [D('value' java.lang.Object), D('values' java.util.Map<java.lang.String, java.lang.Object>)] */
    public static void A06(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (String str : map.keySet()) {
            byte[] A08 = A08(map.get(str));
            if (A08.length <= 10485760) {
                hashMap.put(str, A08);
            } else {
                throw new IllegalArgumentException(String.format(A01(20, 55, 121), str, Integer.valueOf(A08.length), 10485760));
            }
        }
    }

    /* JADX INFO: Multiple debug info for r0v10 byte[]: [D('otherValue' byte[]), D('otherMetadata' java.util.Map<java.lang.String, byte[]>)] */
    private boolean A07(Map<String, byte[]> map) {
        if (this.A01.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static byte[] A08(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(Charset.forName(A01(75, 5, 78)));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public final C0975b0 A09(C0457Hx hx) {
        Map<String, byte[]> A022 = A02(this.A01, hx);
        if (A07(A022)) {
            return this;
        }
        return new C0975b0(A022);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A01.size());
        for (Map.Entry<String, byte[]> entry : this.A01.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0455Hv
    public final long A5D(String str, long j) {
        if (this.A01.containsKey(str)) {
            return ByteBuffer.wrap(this.A01.get(str)).getLong();
        }
        return j;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0455Hv
    public final String A5E(String str, String str2) {
        if (this.A01.containsKey(str)) {
            return new String(this.A01.get(str), Charset.forName(A01(75, 5, 78)));
        }
        return str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return A07(((C0975b0) obj).A01);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int i = 0;
            Iterator<Map.Entry<String, byte[]>> it = this.A01.entrySet().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                String[] strArr = A03;
                if (strArr[7].length() != strArr[0].length()) {
                    String[] strArr2 = A03;
                    strArr2[3] = "oFmiTb5ocNjXgy8itQp3Jt";
                    strArr2[3] = "oFmiTb5ocNjXgy8itQp3Jt";
                    if (!hasNext) {
                        this.A00 = i;
                        break;
                    }
                    Map.Entry<String, byte[]> next = it.next();
                    i += next.getKey().hashCode() ^ Arrays.hashCode(next.getValue());
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return this.A00;
    }
}
