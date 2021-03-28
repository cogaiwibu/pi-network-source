package com.facebook.ads.redexgen.X;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

public final class CQ {
    public static byte[] A07;
    public static String[] A08;
    public static final int[] A09 = {32, 64, 96, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 288, 320, 352, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 416, 448};
    public static final int[] A0A = {32, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT};
    public static final int[] A0B = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320};
    public static final int[] A0C = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public static final int[] A0D = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, JfifUtil.MARKER_SOFn, 224, 256};
    public static final int[] A0E = {44100, 48000, 32000};
    public static final String[] A0F = {A01(10, 13, 78), A01(23, 13, 58), A01(0, 10, 33)};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{-25, -5, -22, -17, -11, -75, -13, -10, -21, -19, 20, 40, 23, 28, 34, -30, 32, 35, 24, 26, -32, -1, -28, 0, 20, 3, 8, 14, -50, 12, 15, 4, 6, -52, -21, -47};
    }

    public static void A03() {
        A08 = new String[]{"nifcRfbON53gzILOru2Jo77QmnI", "", "YclbigHQdqatdiMMFtmKc8uyfonoIz5d", "Fd6hY4xBxF4WCtFqE3EitLo6QTPCTd6g", "7NOpBqgVdvht54TmD9wxn6mxDDhXMYkr", "z0qKCLYmn7ETA7vnAfdm8yGWNV", "FyibQKYxxp5WU6WV5DKbmcaitux", "b6Jzn18op"};
    }

    static {
        A03();
        A02();
    }

    public static int A00(int version) {
        int samplingRateIndex;
        int padding;
        int i;
        int i2;
        int samplingRate;
        if ((version & -2097152) != -2097152 || (samplingRateIndex = (version >>> 19) & 3) == 1 || (padding = (version >>> 17) & 3) == 0) {
            return -1;
        }
        int i3 = version >>> 12;
        if (A08[1].length() == 0) {
            String[] strArr = A08;
            strArr[3] = "b2l2aaEsQdCjJRobZM3AI6pzp0fCTcXg";
            strArr[3] = "b2l2aaEsQdCjJRobZM3AI6pzp0fCTcXg";
            int i4 = i3 & 15;
            if (i4 == 0 || i4 == 15 || (i = (version >>> 10) & 3) == 3) {
                return -1;
            }
            int i5 = A0E[i];
            if (samplingRateIndex == 2) {
                i5 /= 2;
            } else if (samplingRateIndex == 0) {
                i5 /= 4;
            }
            int i6 = (version >>> 9) & 1;
            if (padding == 3) {
                if (samplingRateIndex == 3) {
                    samplingRate = A09[i4 - 1];
                } else {
                    samplingRate = A0D[i4 - 1];
                }
                int padding2 = samplingRate * 12000;
                String[] strArr2 = A08;
                if (strArr2[6].length() != strArr2[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A08;
                strArr3[4] = "oe92MVCyaQQCtYlB63NB1CxE35U7HQE5";
                strArr3[2] = "cgh7vNrWE365WSGkm1qsPTYGoGRnPBar";
                return ((padding2 / i5) + i6) * 4;
            }
            if (samplingRateIndex == 3) {
                i2 = padding == 2 ? A0A[i4 - 1] : A0B[i4 - 1];
            } else {
                int[] iArr = A0C;
                String[] strArr4 = A08;
                if (strArr4[6].length() != strArr4[0].length()) {
                    String[] strArr5 = A08;
                    strArr5[7] = "UFIEXEz4g";
                    strArr5[5] = "u6DSTaNAwdJldo1ZeFLEjMNQPO";
                    i2 = iArr[i4 - 1];
                } else {
                    String[] strArr6 = A08;
                    strArr6[3] = "uh43YA7kDZkFV42L4FFbPgJOsOuCYlNO";
                    strArr6[3] = "uh43YA7kDZkFV42L4FFbPgJOsOuCYlNO";
                    i2 = iArr[i4 - 1];
                }
            }
            int i7 = 144000;
            String[] strArr7 = A08;
            if (strArr7[4].charAt(29) != strArr7[2].charAt(29)) {
                String[] strArr8 = A08;
                strArr8[7] = "EFM751Hfm";
                strArr8[5] = "lrmHfueLLigjg4doS9Ay4icuU4";
                if (samplingRateIndex == 3) {
                    return ((144000 * i2) / i5) + i6;
                }
                if (padding == 1) {
                    i7 = 72000;
                }
                return ((i7 * i2) / i5) + i6;
            }
        }
        throw new RuntimeException();
    }

    private void A04(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.A05 = i;
        this.A06 = str;
        this.A02 = i2;
        this.A03 = i3;
        this.A01 = i4;
        this.A00 = i5;
        this.A04 = i6;
    }

    public static boolean A05(int version, CQ cq) {
        int i;
        int bitrate;
        int bitrateIndex;
        int i2;
        int i3;
        int i4;
        int bitrateIndex2;
        int i5;
        if ((version & -2097152) != -2097152 || (i = (version >>> 19) & 3) == 1 || (bitrate = (version >>> 17) & 3) == 0 || (bitrateIndex = (version >>> 12) & 15) == 0 || bitrateIndex == 15 || (i2 = (version >>> 10) & 3) == 3) {
            return false;
        }
        int samplesPerFrame = A0E[i2];
        if (i == 2) {
            samplesPerFrame /= 2;
        } else if (i == 0) {
            samplesPerFrame /= 4;
        }
        int i6 = (version >>> 9) & 1;
        if (bitrate == 3) {
            if (i == 3) {
                int[] iArr = A09;
                int i7 = bitrateIndex - 1;
                if (A08[1].length() != 0) {
                    throw new RuntimeException();
                }
                String[] strArr = A08;
                strArr[1] = "";
                strArr[1] = "";
                bitrateIndex2 = iArr[i7];
            } else {
                bitrateIndex2 = A0D[bitrateIndex - 1];
            }
            i4 = (((bitrateIndex2 * 12000) / samplesPerFrame) + i6) * 4;
            i3 = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else {
            int i8 = 144000;
            if (i == 3) {
                if (bitrate == 2) {
                    bitrateIndex2 = A0A[bitrateIndex - 1];
                } else {
                    bitrateIndex2 = A0B[bitrateIndex - 1];
                }
                i3 = 1152;
                i4 = ((144000 * bitrateIndex2) / samplesPerFrame) + i6;
            } else {
                bitrateIndex2 = A0C[bitrateIndex - 1];
                if (bitrate == 1) {
                    i3 = 576;
                } else {
                    i3 = 1152;
                }
                if (bitrate == 1) {
                    i8 = 72000;
                }
                i4 = ((i8 * bitrateIndex2) / samplesPerFrame) + i6;
            }
        }
        String str = A0F[3 - bitrate];
        if (((version >> 6) & 3) == 3) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        cq.A04(i, str, i4, samplesPerFrame, i5, bitrateIndex2 * 1000, i3);
        return true;
    }
}
