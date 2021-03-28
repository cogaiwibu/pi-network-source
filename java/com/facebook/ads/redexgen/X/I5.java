package com.facebook.ads.redexgen.X;

import android.util.Pair;
import java.util.Arrays;

public final class I5 {
    public static byte[] A00;
    public static String[] A01;
    public static final byte[] A02 = {0, 0, 0, 1};
    public static final int[] A03 = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    public static final int[] A04 = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 42);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{5, 62, 35, 37, 32, 32, 63, 34, 36, 53, 52, 112, 49, 37, 52, 57, 63, 112, 63, 50, 58, 53, 51, 36, 112, 36, 41, 32, 53, 106, 112, 116, 79, 82, 84, 81, 81, 78, 83, 85, 68, 69, 1, 68, 81, 98, 78, 79, 71, 72, 70, 27, 1};
    }

    public static void A06() {
        A01 = new String[]{"7xLJJJjcPic97znxr7jYyKVhMaeA1j2E", "qlBokwmGez00tGn8Zoa7EPfSBX4wK2nd", "lNuywCj9LEYUa8avgu1fHofmnBtqXXwP", "QFj1OU4oR8zs4ROIl6ex9DnIWth", "MldRCxmPSCf85WqtCY5KHjt0bBRgqPbR", "RjpHJdGRFnKrV", "xTxTizoIhxSZQJal7HagUNUTtmhMrgov", "oiVBLQsg82rzAXMmQswhUJYEb9MEhzaa"};
    }

    static {
        A06();
        A05();
    }

    public static int A00(IP ip) {
        int A05 = ip.A05(5);
        if (A05 == 31) {
            return ip.A05(6) + 32;
        }
        return A05;
    }

    public static int A01(IP ip) {
        boolean z;
        int A05 = ip.A05(4);
        if (A05 == 15) {
            return ip.A05(24);
        }
        if (A01[3].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "Rl706moC1hxTN";
        strArr[5] = "Rl706moC1hxTN";
        if (A05 < 13) {
            z = true;
        } else {
            z = false;
        }
        I1.A03(z);
        return A04[A05];
    }

    /* JADX INFO: Multiple debug info for r5v2 int: [D('channelCount' int), D('epConfig' int)] */
    public static Pair<Integer, Integer> A02(IP ip, boolean z) throws AN {
        int A002 = A00(ip);
        int channelConfiguration = A01(ip);
        int A05 = ip.A05(4);
        if (A002 == 5 || A002 == 29) {
            channelConfiguration = A01(ip);
            A002 = A00(ip);
            if (A002 == 22) {
                A05 = ip.A05(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (!(A002 == 1 || A002 == 2 || A002 == 3 || A002 == 4 || A002 == 6 || A002 == 7 || A002 == 17)) {
                switch (A002) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new AN(A04(0, 31, 122) + A002);
                }
            }
            A07(ip, A002, A05);
            if (A01[4].charAt(0) != 'c') {
                String[] strArr = A01;
                strArr[7] = "vV2yfuq3D8MlByvyd0FSsWmE07MYRaiH";
                strArr[7] = "vV2yfuq3D8MlByvyd0FSsWmE07MYRaiH";
                switch (A002) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int epConfig = ip.A05(2);
                        if (epConfig == 2 || epConfig == 3) {
                            throw new AN(A04(31, 22, 11) + epConfig);
                        }
                }
            } else {
                throw new RuntimeException();
            }
        }
        int i = A03[A05];
        if (i == -1) {
            z2 = false;
        }
        I1.A03(z2);
        return Pair.create(Integer.valueOf(channelConfiguration), Integer.valueOf(i));
    }

    public static Pair<Integer, Integer> A03(byte[] bArr) throws AN {
        return A02(new IP(bArr), false);
    }

    public static void A07(IP ip, int i, int i2) {
        ip.A09(1);
        if (ip.A0G()) {
            if (A01[5].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "9ZbgWIK1Tjah9N2o7wCOkUZOiekVuClG";
            strArr[6] = "9ZbgWIK1Tjah9N2o7wCOkUZOiekVuClG";
            ip.A09(14);
        }
        boolean A0G = ip.A0G();
        if (i2 != 0) {
            if (i == 6 || i == 20) {
                ip.A09(3);
            }
            if (A0G) {
                if (i == 22) {
                    ip.A09(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    ip.A09(3);
                }
                ip.A09(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[] A08(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] A09(byte[] bArr, int i, int i2) {
        byte[] bArr2 = A02;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, A02.length, i2);
        return bArr3;
    }
}
