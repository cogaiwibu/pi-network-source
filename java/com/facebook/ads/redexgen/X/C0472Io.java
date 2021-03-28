package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Io  reason: case insensitive filesystem */
public final class C0472Io {
    public static byte[] A02;
    public static String[] A03;
    public final int A00;
    public final List<byte[]> A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-22, 23, 23, 20, 23, -59, 21, 6, 23, 24, 14, 19, 12, -59, -19, -22, -5, -24, -59, 8, 20, 19, 11, 14, 12};
    }

    public static void A03() {
        A03 = new String[]{"bNwv9DTrsFpr", "zbhYB7daSjPcuvBmkTZuqaAPzZ9zn8h", "FRkSQOtD666PiwdWpMANCzaC3fIlZstE", "hSncHK0YMcK7Os9UUgTo3Hp6GRz3gib", "Da8z6HvdaVwrG586sIxSQ6hlHOkGiutI", "7Q5nL4gzRbsCGic6ITFl05T54duLJG5D", "soaxh0FZrqdNmpGhlM75NEwupCBAn2wQ", "H3bjs2QdHQpI"};
    }

    public C0472Io(List<byte[]> initializationData, int i) {
        this.A01 = initializationData;
        this.A00 = i;
    }

    /* JADX INFO: Multiple debug info for r10v0 int: [D('i' int), D('buffer' byte[])] */
    public static C0472Io A00(IQ iq) throws AN {
        try {
            iq.A0a(21);
            int csdStartPosition = iq.A0F() & 3;
            int i = iq.A0F();
            int numberOfNalUnits = 0;
            int A07 = iq.A07();
            int i2 = 0;
            while (true) {
                String[] strArr = A03;
                if (strArr[7].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[7] = "tNmJvjDEnkcZ";
                strArr2[0] = "FarTxLmaqbLK";
                if (i2 < i) {
                    iq.A0a(1);
                    int A0J = iq.A0J();
                    for (int i3 = 0; i3 < A0J; i3++) {
                        int A0J2 = iq.A0J();
                        numberOfNalUnits += A0J2 + 4;
                        iq.A0a(A0J2);
                    }
                    i2++;
                } else {
                    iq.A0Z(A07);
                    byte[] bArr = new byte[numberOfNalUnits];
                    int i4 = 0;
                    for (int bufferPosition = 0; bufferPosition < i; bufferPosition++) {
                        iq.A0a(1);
                        int i5 = iq.A0J();
                        for (int i6 = 0; i6 < i5; i6++) {
                            int j = iq.A0J();
                            System.arraycopy(IM.A03, 0, bArr, i4, IM.A03.length);
                            int length = i4 + IM.A03.length;
                            System.arraycopy(iq.A00, iq.A07(), bArr, length, j);
                            i4 = length + j;
                            iq.A0a(j);
                        }
                    }
                    return new C0472Io(numberOfNalUnits == 0 ? null : Collections.singletonList(bArr), csdStartPosition + 1);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AN(A01(0, 25, 121), e);
        }
    }
}
