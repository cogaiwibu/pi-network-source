package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ii  reason: case insensitive filesystem */
public final class C0468Ii {
    public static byte[] A05;
    public static String[] A06;
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final List<byte[]> A04;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            String[] strArr = A06;
            if (strArr[2].charAt(1) != strArr[1].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "kNkKJeUYPfq8eMd2tA59MaBH22H8N5Ts";
            strArr2[3] = "kNkKJeUYPfq8eMd2tA59MaBH22H8N5Ts";
            copyOfRange[i4] = (byte) ((b - i3) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{13, 58, 58, 55, 58, -24, 56, 41, 58, 59, 49, 54, 47, -24, 9, 30, 11, -24, 43, 55, 54, 46, 49, 47};
    }

    public static void A03() {
        A06 = new String[]{"6HhNm3cPNapwaqbb", "rETS2R3vEEslStUJRpCBgfLkJK0S9xqh", "MEYGBk1oMmhBWHD5huW8XB9PkOXmJxmW", "Ebyfs41o5airltqaiKadsdL394JDYdET", "45eNA9gLGf59sMGZ1iMI", "", "A0Zue4QITY9ZnpF1VrB6IK97BmW1DYMt", "lY4WeGl5g11cW0QvoH9uVkbc4B0XWsja"};
    }

    public C0468Ii(List<byte[]> initializationData, int i, int i2, int i3, float f) {
        this.A04 = initializationData;
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A00 = f;
    }

    public static C0468Ii A00(IQ iq) throws AN {
        try {
            iq.A0a(4);
            int A0F = (iq.A0F() & 3) + 1;
            if (A0F != 3) {
                ArrayList arrayList = new ArrayList();
                int numSequenceParameterSets = iq.A0F() & 31;
                for (int j = 0; j < numSequenceParameterSets; j++) {
                    arrayList.add(A04(iq));
                }
                int A0F2 = iq.A0F();
                for (int numPictureParameterSets = 0; numPictureParameterSets < A0F2; numPictureParameterSets++) {
                    arrayList.add(A04(iq));
                }
                int i = -1;
                int i2 = -1;
                float f = 1.0f;
                if (A06[4].length() != 27) {
                    String[] strArr = A06;
                    strArr[2] = "yEkjaL4nSOxIxbdygxb0eg7rmaPMv2Rh";
                    strArr[1] = "JEi8k2PtpDNktftvz60xHr0NAbywlG3U";
                    if (numSequenceParameterSets > 0) {
                        IL A062 = IM.A06((byte[]) arrayList.get(0), A0F, ((byte[]) arrayList.get(0)).length);
                        i = A062.A06;
                        i2 = A062.A02;
                        f = A062.A00;
                    }
                    return new C0468Ii(arrayList, A0F, i, i2, f);
                }
                throw new RuntimeException();
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new AN(A01(0, 24, 119), e);
        }
    }

    public static byte[] A04(IQ iq) {
        int offset = iq.A0J();
        int A07 = iq.A07();
        iq.A0a(offset);
        return I5.A09(iq.A00, A07, offset);
    }
}
