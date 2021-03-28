package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

public final class IM {
    public static byte[] A00;
    public static int[] A01 = new int[10];
    public static String[] A02;
    public static final byte[] A03 = {0, 0, 0, 1};
    public static final float[] A04 = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object A05 = new Object();

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-4, 15, 26, 3, 28, 23, 34, 3, 34, 23, 26, -41, -16, -25, -6, -14, -25, -27, -10, -25, -26, -94, -29, -11, -14, -25, -27, -10, -31, -12, -29, -10, -21, -15, -31, -21, -26, -27, -94, -8, -29, -18, -9, -25, -68, -94, -9, -22, -27, -26, -16, -80, -30, -9, -28, 7, -6, -11, -10, 0, -64, -7, -10, 7, -12};
    }

    public static void A09() {
        A02 = new String[]{"Oi30oJFxUMFG0gOFP1qEoKnGUzBDTsvx", "3WD4gW2GQkEI5AwBfxSAXddooip3O", "Ouz028YKvSlJVOERB46zGmLFjnusBt99", "zuSd86snyfkH6Kt688AXpDWJmpjjYjYh", "jm5obH6VrXyDYReHZwz8l0mhz55kc4yf", "71eZjkBm8iWWJxdGvDt2NXp", "W8ZvrObejWqz7a9mktO8s2uWHHxOtI0w", "Nv5C13AVolnSAeqab8n4y7TwRlreXIzh"};
    }

    static {
        A09();
        A08();
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    /* JADX INFO: Multiple debug info for r6v1 int: [D('scratchEscapeCount' int), D('escapedPosition' int)] */
    public static int A02(byte[] bArr, int position) {
        int position2;
        synchronized (A05) {
            int i = 0;
            int scratchEscapeCount = 0;
            while (i < position) {
                i = A03(bArr, i, position);
                if (i < position) {
                    if (A01.length <= scratchEscapeCount) {
                        A01 = Arrays.copyOf(A01, A01.length * 2);
                    }
                    A01[scratchEscapeCount] = i;
                    i += 3;
                    scratchEscapeCount++;
                }
            }
            position2 = position - scratchEscapeCount;
            String[] strArr = A02;
            if (strArr[0].charAt(3) != strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "ghc1n9RTDSO0Z4i69kgOEipuot9Zj";
            strArr2[1] = "ghc1n9RTDSO0Z4i69kgOEipuot9Zj";
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < scratchEscapeCount; i4++) {
                int unescapedPosition = A01[i4] - i2;
                System.arraycopy(bArr, i2, bArr, i3, unescapedPosition);
                int i5 = i3 + unescapedPosition;
                int copyLength = i5 + 1;
                bArr[i5] = 0;
                i3 = copyLength + 1;
                bArr[copyLength] = 0;
                i2 += unescapedPosition + 3;
            }
            System.arraycopy(bArr, i2, bArr, i3, position2 - i3);
        }
        return position2;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        if (r11 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r11 != null) goto L_0x004e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int A04(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IM.A04(byte[], int, int, boolean[]):int");
    }

    public static IK A05(byte[] bArr, int i, int i2) {
        IR ir = new IR(bArr, i, i2);
        ir.A08(8);
        int picParameterSetId = ir.A05();
        int A052 = ir.A05();
        ir.A07();
        return new IK(picParameterSetId, A052, ir.A0B());
    }

    /* JADX INFO: Multiple debug info for r0v15 int: [D('picHeightInMapUnits' int), D('frameHeightInMbs' int)] */
    /* JADX INFO: Multiple debug info for r2v8 int: [D('aspectRatioIdc' int), D('frameCroppingFlag' boolean)] */
    /* JADX INFO: Multiple debug info for r0v36 int: [D('picOrderCntLsbLength' int), D('sarHeight' int)] */
    /* JADX WARN: Type inference failed for: r17v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.redexgen.X.IL A06(byte[] r19, int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IM.A06(byte[], int, int):com.facebook.ads.redexgen.X.IL");
    }

    public static void A0A(IR ir, int nextScale) {
        int i = 8;
        int deltaScale = 8;
        for (int i2 = 0; i2 < nextScale; i2++) {
            if (deltaScale != 0) {
                deltaScale = ((ir.A04() + i) + 256) % 256;
            }
            if (deltaScale != 0) {
                i = deltaScale;
            }
        }
    }

    public static void A0B(ByteBuffer byteBuffer) {
        int consecutiveZeros = byteBuffer.position();
        int offset = 0;
        for (int value = 0; value + 1 < consecutiveZeros; value++) {
            int i = byteBuffer.get(value) & UByte.MAX_VALUE;
            if (offset == 3) {
                if (i == 1 && (byteBuffer.get(value + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(value - 3);
                    duplicate.limit(consecutiveZeros);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i == 0) {
                offset++;
            }
            if (i != 0) {
                offset = 0;
            }
        }
        byteBuffer.clear();
        if (A02[1].length() != 29) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "LhexrLoV7v0KAfJEyFTOZZKZaNSS1gs0";
        strArr[4] = "gpIVcqUVkpQz0S61taD9WNDesiV6owqm";
    }

    public static void A0C(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0D(String str, byte b) {
        if (A07(46, 9, 52).equals(str) && (b & 31) == 6) {
            return true;
        }
        if (!A07(55, 10, 68).equals(str) || ((b & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }
}
