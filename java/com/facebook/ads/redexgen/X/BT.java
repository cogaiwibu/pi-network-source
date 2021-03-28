package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class BT {
    public static byte[] A00;
    public static String[] A01;
    public static final int[] A02 = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    public static final int[] A03 = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    public static final int[] A04 = {64, 112, 128, JfifUtil.MARKER_SOFn, 224, 256, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 23);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{119, 99, 114, ByteCompanionObject.MAX_VALUE, 121, 57, 96, 120, 114, 56, 114, 98, 101};
    }

    public static void A07() {
        A01 = new String[]{"LkGuYUivH3Ie1Im5DPbpjiI8Q8YTXvDH", "1PwPqA1AQPAmdWryNsV6sN6X26rPkCjW", "ZqXwAcmmJts9Z3eghrFogO2ZvZ2KPTjy", "VVFX", "itVzmaW23y4JHLkTkKw9c3", "4is91i25oXLwO1hEL45hwpUW49QZoS4h", "3tDKTkvCK0hS9Fm4lJL5mZYVdrHZzDGh", "0qkAcrqD1J7f8hfbi9Oz77lQGDa0et74"};
    }

    static {
        A07();
        A06();
    }

    public static int A00(ByteBuffer byteBuffer) {
        int i;
        int nblks = byteBuffer.position();
        byte b = byteBuffer.get(nblks);
        if (b == -2) {
            i = ((byteBuffer.get(nblks + 5) & 1) << 6) | ((byteBuffer.get(nblks + 4) & 252) >> 2);
        } else if (b == -1) {
            i = ((byteBuffer.get(nblks + 4) & 7) << 4) | ((byteBuffer.get(nblks + 7) & 60) >> 2);
        } else if (b != 31) {
            i = ((byteBuffer.get(nblks + 4) & 1) << 6) | ((byteBuffer.get(nblks + 5) & 252) >> 2);
        } else {
            i = ((byteBuffer.get(nblks + 5) & 7) << 4) | ((byteBuffer.get(nblks + 6) & 60) >> 2);
        }
        return (i + 1) * 32;
    }

    public static int A01(byte[] bArr) {
        int i;
        int fsize = 0;
        byte b = bArr[0];
        if (b == -2) {
            i = (((bArr[4] & 3) << 12) | ((bArr[7] & UByte.MAX_VALUE) << 4) | ((bArr[6] & 240) >> 4)) + 1;
        } else if (b == -1) {
            i = (((bArr[7] & 3) << 12) | ((bArr[6] & UByte.MAX_VALUE) << 4) | ((bArr[9] & 60) >> 2)) + 1;
            fsize = 1;
        } else if (b != 31) {
            i = (((bArr[5] & 3) << 12) | ((bArr[6] & UByte.MAX_VALUE) << 4) | ((bArr[7] & 240) >> 4)) + 1;
        } else {
            i = (((bArr[6] & 3) << 12) | ((bArr[7] & UByte.MAX_VALUE) << 4) | ((bArr[8] & 60) >> 2)) + 1;
            fsize = 1;
        }
        return fsize != 0 ? (i * 16) / 14 : i;
    }

    public static int A02(byte[] bArr) {
        int i;
        byte b = bArr[0];
        if (b == -2) {
            i = ((bArr[5] & 1) << 6) | ((bArr[4] & 252) >> 2);
        } else if (A01[4].length() != 20) {
            String[] strArr = A01;
            strArr[2] = "EqLnRlbAIvqb7JmhHHjyb9MWmtPppsRr";
            strArr[7] = "wqmF86kNtSHy9CpxzvQffLVgP6PIYafb";
            if (b == -1) {
                i = ((bArr[4] & 7) << 4) | ((bArr[7] & 60) >> 2);
            } else if (b != 31) {
                i = ((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2);
            } else {
                i = ((bArr[5] & 7) << 4) | ((bArr[6] & 60) >> 2);
            }
        } else {
            throw new RuntimeException();
        }
        int i2 = (i + 1) * 32;
        String[] strArr2 = A01;
        if (strArr2[2].charAt(1) != strArr2[7].charAt(1)) {
            return i2;
        }
        String[] strArr3 = A01;
        strArr3[1] = "0BUMWBHFUBXEmf7IWFiBpaLqqarBLbVJ";
        strArr3[6] = "IXHZH24RcLqKyQXeo23FKYJCWT4dHCob";
        return i2;
    }

    /* JADX INFO: Multiple debug info for r2v0 int[]: [D('amode' int), D('rate' int)] */
    public static Format A03(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i;
        int bitrate;
        IP A042 = A04(bArr);
        A042.A09(60);
        int i2 = A02[A042.A05(6)];
        int i3 = A03[A042.A05(4)];
        int rate = A042.A05(5);
        int[] iArr = A04;
        if (rate >= iArr.length) {
            i = -1;
        } else {
            i = (iArr[rate] * 1000) / 2;
        }
        A042.A09(10);
        if (A042.A05(2) > 0) {
            bitrate = 1;
        } else {
            bitrate = 0;
        }
        return Format.A07(str, A05(0, 13, 1), null, i, -1, i2 + bitrate, i3, null, drmInitData, 0, str2);
    }

    public static IP A04(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new IP(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (A09(copyOf)) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte temp = copyOf[i];
                copyOf[i] = copyOf[i + 1];
                copyOf[i + 1] = temp;
            }
        }
        IP ip = new IP(copyOf);
        if (copyOf[0] == 31) {
            IP frameBits = new IP(copyOf);
            while (true) {
                int A022 = frameBits.A02();
                if (A01[5].charAt(2) != 'T') {
                    String[] strArr = A01;
                    strArr[4] = "1c365Ndi9m7qeJPJDL";
                    strArr[4] = "1c365Ndi9m7qeJPJDL";
                    if (A022 < 16) {
                        break;
                    }
                    frameBits.A09(2);
                    ip.A0B(frameBits.A05(14), 14);
                } else {
                    throw new RuntimeException();
                }
            }
        }
        ip.A0C(copyOf);
        return ip;
    }

    public static boolean A08(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static boolean A09(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
