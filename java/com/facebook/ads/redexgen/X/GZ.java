package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.util.SparseArray;
import java.util.Arrays;

public final class GZ {
    public static byte[] A07;
    public static String[] A08;
    public static final byte[] A09 = {0, 7, 8, 15};
    public static final byte[] A0A = {0, 119, -120, -1};
    public static final byte[] A0B = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final GR A04;
    public final GS A05;
    public final GY A06;

    public static String A09(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] - i3) - 74);
            String[] strArr = A08;
            if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[1] = "o838eL9fL";
            strArr2[5] = "J6qCpr7RcsAqb79Ub3PrHCSZxMucifP";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-109, -80, -61, -80, 111, -75, -72, -76, -69, -77, 111, -69, -76, -67, -74, -61, -73, 111, -76, -57, -78, -76, -76, -77, -62, 111, -69, -72, -68, -72, -61, -16, 34, 14, -4, 13, 30, 31, 17, 30};
    }

    public static void A0B() {
        A08 = new String[]{"0rGqU9QbqgRhw9xCYiy2ikjdJF0tZxW0", "O5zJjRmwn", "Zuwvbdj2tlT5lxRkpa9deVxz18dZQdtj", "3cu9YvSu9oYTgNu7SXt0BZa9RO8c3dJe", "fSpgVoQESo9i788g3Yt2BRpnP7rxN0lE", "PNJ5rPmEA0nUP9bGeJM8wQu7KuAYrDy", "AGqKR696jXLUBqkrCQSQW886irj6NtRI", "IRr9cxFu4Mtz1eOchhtcqFpk7Zjv6sDY"};
    }

    static {
        A0B();
        A0A();
    }

    public GZ(int i, int i2) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new GS(719, 575, 0, 719, 0, 575);
        this.A04 = new GR(0, A0G(), A0H(), A0I());
        this.A06 = new GY(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(IP ip, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int i3 = i;
        boolean z = false;
        do {
            int runLength = 0;
            int A052 = ip.A05(2);
            if (A052 != 0) {
                runLength = 1;
            } else {
                boolean A0G = ip.A0G();
                String[] strArr = A08;
                if (strArr[6].charAt(3) != strArr[3].charAt(3)) {
                    String[] strArr2 = A08;
                    strArr2[1] = "NWJ2j8DR8";
                    strArr2[5] = "tuFwEgjWv5QsbV2rgY7O01mW2P3xd0b";
                    if (A0G) {
                        runLength = ip.A05(3) + 3;
                        A052 = ip.A05(2);
                    } else if (ip.A0G()) {
                        runLength = 1;
                        A052 = 0;
                    } else {
                        int A053 = ip.A05(2);
                        if (A053 == 0) {
                            z = true;
                            A052 = 0;
                        } else if (A053 == 1) {
                            runLength = 2;
                            A052 = 0;
                        } else if (A053 == 2) {
                            runLength = ip.A05(4) + 12;
                            A052 = ip.A05(2);
                        } else if (A053 != 3) {
                            A052 = 0;
                        } else {
                            int A054 = ip.A05(8);
                            String[] strArr3 = A08;
                            if (strArr3[1].length() != strArr3[5].length()) {
                                String[] strArr4 = A08;
                                strArr4[7] = "aK1SAaExMssx18Id1roywrSfe1Et1yGa";
                                strArr4[7] = "aK1SAaExMssx18Id1roywrSfe1Et1yGa";
                                runLength = A054 + 29;
                                A052 = ip.A05(2);
                            } else {
                                String[] strArr5 = A08;
                                strArr5[1] = "EWrEb5ztJ";
                                strArr5[5] = "osfW1bR5YMm4TxT0YESgxQn9EHcmZGy";
                                runLength = A054 + 12;
                                A052 = ip.A05(2);
                            }
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            if (runLength != 0) {
                byte b = A052;
                if (paint != null) {
                    if (bArr != null) {
                        b = bArr[A052];
                    }
                    paint.setColor(iArr[b == 1 ? 1 : 0]);
                    canvas.drawRect((float) i3, (float) i2, (float) (i3 + runLength), (float) (i2 + 1), paint);
                }
            }
            i3 += runLength;
        } while (!z);
        return i3;
    }

    public static int A02(IP ip, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int runLength = i;
        boolean z = false;
        do {
            int clutIndex = 0;
            int A052 = ip.A05(4);
            if (A052 != 0) {
                clutIndex = 1;
            } else if (!ip.A0G()) {
                int A053 = ip.A05(3);
                if (A053 != 0) {
                    clutIndex = A053 + 2;
                    A052 = 0;
                } else {
                    z = true;
                    A052 = 0;
                }
            } else if (!ip.A0G()) {
                clutIndex = ip.A05(2) + 4;
                A052 = ip.A05(4);
            } else {
                int A054 = ip.A05(2);
                if (A054 == 0) {
                    clutIndex = 1;
                    A052 = 0;
                } else if (A054 == 1) {
                    clutIndex = 2;
                    A052 = 0;
                } else if (A054 == 2) {
                    clutIndex = ip.A05(4) + 9;
                    A052 = ip.A05(4);
                } else if (A054 != 3) {
                    A052 = 0;
                } else {
                    clutIndex = ip.A05(8) + 25;
                    A052 = ip.A05(4);
                }
            }
            if (clutIndex != 0) {
                byte b = A052;
                if (paint != null) {
                    if (bArr != null) {
                        b = bArr[A052];
                    }
                    paint.setColor(iArr[b == 1 ? 1 : 0]);
                    canvas.drawRect((float) runLength, (float) i2, (float) (runLength + clutIndex), (float) (i2 + 1), paint);
                }
            }
            runLength += clutIndex;
        } while (!z);
        return runLength;
    }

    public static int A03(IP ip, int[] iArr, byte[] bArr, int i, int peek, Paint paint, Canvas canvas) {
        int A052;
        int runLength = i;
        boolean z = false;
        do {
            int A053 = ip.A05(8);
            if (A053 != 0) {
                A052 = 1;
            } else if (!ip.A0G()) {
                A052 = ip.A05(7);
                if (A052 != 0) {
                    A053 = 0;
                } else {
                    z = true;
                    A052 = 0;
                    A053 = 0;
                }
            } else {
                A052 = ip.A05(7);
                A053 = ip.A05(8);
                String[] strArr = A08;
                if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[7] = "oE62i0kU0YacGkvCLxgFzKdMfiudOn3o";
                strArr2[7] = "oE62i0kU0YacGkvCLxgFzKdMfiudOn3o";
            }
            if (A052 != 0) {
                byte b = A053;
                if (paint != null) {
                    if (bArr != null) {
                        b = bArr[A053];
                    }
                    paint.setColor(iArr[b == 1 ? 1 : 0]);
                    canvas.drawRect((float) runLength, (float) peek, (float) (runLength + A052), (float) (peek + 1), paint);
                }
            }
            runLength += A052;
            String[] strArr3 = A08;
            if (strArr3[1].length() != strArr3[5].length()) {
                String[] strArr4 = A08;
                strArr4[6] = "jmdilAXdKLha38CDbN17xGIpmuplWnFc";
                strArr4[3] = "1PNl1axnrexK2c7Nxi5CJrHaXY90XFpd";
            } else {
                throw new RuntimeException();
            }
        } while (!z);
        return runLength;
    }

    /* JADX INFO: Multiple debug info for r2v0 int: [D('y' int), D('cr' int)] */
    /* JADX INFO: Multiple debug info for r15v3 'remainingLength'  int: [D('clutId' int), D('remainingLength' int)] */
    public static GR A04(IP ip, int i) {
        int[] iArr;
        int A052;
        int remainingLength;
        int A053;
        int cb;
        int b = 8;
        int A054 = ip.A05(8);
        ip.A09(8);
        int i2 = i - 2;
        int[] clutEntries8Bit = A0G();
        int[] A0H = A0H();
        int[] A0I = A0I();
        while (i2 > 0) {
            int r = ip.A05(b);
            int t = ip.A05(b);
            int cr = i2 - 2;
            if ((t & 128) != 0) {
                iArr = clutEntries8Bit;
            } else if ((t & 64) != 0) {
                iArr = A0H;
            } else {
                iArr = A0I;
            }
            if ((t & 1) != 0) {
                A052 = ip.A05(b);
                remainingLength = ip.A05(b);
                A053 = ip.A05(b);
                cb = ip.A05(b);
                i2 = cr - 4;
            } else {
                A052 = ip.A05(6) << 2;
                remainingLength = ip.A05(4) << 4;
                A053 = ip.A05(4) << 4;
                cb = ip.A05(2) << 6;
                i2 = cr - 2;
            }
            if (A052 == 0) {
                remainingLength = 0;
                A053 = 0;
                cb = 255;
            }
            iArr[r] = A00((byte) (255 - (cb & 255)), C0466Ig.A06((int) (((double) A052) + (((double) (remainingLength - 128)) * 1.402d)), 0, 255), C0466Ig.A06((int) ((((double) A052) - (((double) (A053 - 128)) * 0.34414d)) - (((double) (remainingLength - 128)) * 0.71414d)), 0, 255), C0466Ig.A06((int) (((double) A052) + (((double) (A053 - 128)) * 1.772d)), 0, 255));
            b = 8;
        }
        return new GR(A054, clutEntries8Bit, A0H, A0I);
    }

    /* JADX INFO: Multiple debug info for r7v0 com.facebook.ads.redexgen.X.IP: [D('displayWindowFlag' boolean), D('height' int)] */
    public static GS A05(IP ip) {
        int verticalPositionMinimum;
        int width;
        int verticalPositionMaximum;
        int height;
        ip.A09(4);
        boolean A0G = ip.A0G();
        ip.A09(3);
        int A052 = ip.A05(16);
        int A053 = ip.A05(16);
        if (A0G) {
            verticalPositionMinimum = ip.A05(16);
            verticalPositionMaximum = ip.A05(16);
            width = ip.A05(16);
            height = ip.A05(16);
        } else {
            verticalPositionMinimum = 0;
            width = 0;
            verticalPositionMaximum = A052;
            height = A053;
        }
        return new GS(A052, A053, verticalPositionMinimum, verticalPositionMaximum, width, height);
    }

    /* JADX INFO: Multiple debug info for r8v0 com.facebook.ads.redexgen.X.IP: [D('bottomFieldDataLength' int), D('numberOfCodes' int)] */
    public static GT A06(IP ip) {
        int objectCodingMethod = ip.A05(16);
        ip.A09(4);
        int A052 = ip.A05(2);
        boolean A0G = ip.A0G();
        ip.A09(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (A052 == 1) {
            ip.A09(ip.A05(8) * 16);
        } else if (A052 == 0) {
            int A053 = ip.A05(16);
            int objectId = ip.A05(16);
            String[] strArr = A08;
            if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "pcqe5F2CDJi5oBWvBkq2zbdYSROcg8Hm";
            strArr2[2] = "pcqe5F2CDJi5oBWvBkq2zbdYSROcg8Hm";
            if (A053 > 0) {
                bArr = new byte[A053];
                ip.A0F(bArr, 0, A053);
            }
            if (objectId > 0) {
                bArr2 = new byte[objectId];
                ip.A0F(bArr2, 0, objectId);
            } else {
                bArr2 = bArr;
            }
        }
        return new GT(objectCodingMethod, A0G, bArr, bArr2);
    }

    public static GU A07(IP ip, int timeoutSecs) {
        int remainingLength = ip.A05(8);
        int A052 = ip.A05(4);
        int A053 = ip.A05(2);
        ip.A09(2);
        int regionHorizontalAddress = timeoutSecs - 2;
        SparseArray sparseArray = new SparseArray();
        while (regionHorizontalAddress > 0) {
            int A054 = ip.A05(8);
            ip.A09(8);
            regionHorizontalAddress -= 6;
            sparseArray.put(A054, new GV(ip.A05(16), ip.A05(16)));
        }
        return new GU(remainingLength, A052, A053, sparseArray);
    }

    /* JADX INFO: Multiple debug info for r23v0 int: [D('foregroundPixelCode' int), D('remainingLength' int)] */
    public static GW A08(IP ip, int i) {
        int i2 = 8;
        int A052 = ip.A05(8);
        ip.A09(4);
        boolean A0G = ip.A0G();
        ip.A09(3);
        int A053 = ip.A05(16);
        int A054 = ip.A05(16);
        int A055 = ip.A05(3);
        int A056 = ip.A05(3);
        ip.A09(2);
        int id = ip.A05(8);
        int A057 = ip.A05(8);
        int width = ip.A05(4);
        int height = ip.A05(2);
        ip.A09(2);
        int pixelCode8Bit = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (pixelCode8Bit > 0) {
            int pixelCode4Bit = ip.A05(16);
            int pixelCode2Bit = ip.A05(2);
            int remainingLength = ip.A05(2);
            int objectHorizontalPosition = ip.A05(12);
            ip.A09(4);
            int objectVerticalPosition = ip.A05(12);
            pixelCode8Bit -= 6;
            int remainingLength2 = 0;
            int objectType = 0;
            if (pixelCode2Bit == 1 || pixelCode2Bit == 2) {
                remainingLength2 = ip.A05(i2);
                objectType = ip.A05(i2);
                pixelCode8Bit -= 2;
                if (A08[2].charAt(23) != 111) {
                    String[] strArr = A08;
                    strArr[4] = "2juIiSC4ZxHJWLrTtxN2ANki5argYjtZ";
                    strArr[0] = "MWq7TNsVs7aXK0A5Gh22llfb9AkLnJo6";
                } else {
                    throw new RuntimeException();
                }
            }
            sparseArray.put(pixelCode4Bit, new GX(pixelCode2Bit, remainingLength, objectHorizontalPosition, objectVerticalPosition, remainingLength2, objectType));
            i2 = 8;
        }
        return new GW(A052, A0G, A053, A054, A055, A056, id, A057, width, height, sparseArray);
    }

    public static void A0C(GT gt, GR gr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = gr.A03;
        } else if (i == 2) {
            iArr = gr.A02;
        } else {
            iArr = gr.A01;
        }
        A0E(gt.A03, iArr, i, i2, i3, paint, canvas);
        A0E(gt.A02, iArr, i, i2, i3 + 1, paint, canvas);
    }

    public static void A0D(IP ip, GY gy) {
        int dataFieldLimit = ip.A05(8);
        int A052 = ip.A05(16);
        int A053 = ip.A05(16);
        int A032 = ip.A03() + A053;
        if (A053 * 8 > ip.A02()) {
            Log.w(A09(31, 9, 98), A09(0, 31, 5));
            ip.A09(ip.A02());
            return;
        }
        switch (dataFieldLimit) {
            case 16:
                if (A052 == gy.A03) {
                    GU gu = gy.A01;
                    GU A072 = A07(ip, A053);
                    if (A072.A00 == 0) {
                        if (!(gu == null || gu.A02 == A072.A02)) {
                            gy.A01 = A072;
                            break;
                        }
                    } else {
                        gy.A01 = A072;
                        gy.A08.clear();
                        gy.A06.clear();
                        gy.A07.clear();
                        break;
                    }
                }
                break;
            case 17:
                GU gu2 = gy.A01;
                if (A052 == gy.A03 && gu2 != null) {
                    GW A082 = A08(ip, A053);
                    if (gu2.A00 == 0) {
                        A082.A00(gy.A08.get(A082.A03));
                    }
                    gy.A08.put(A082.A03, A082);
                    break;
                }
            case 18:
                if (A052 != gy.A03) {
                    if (A052 == gy.A02) {
                        GR A042 = A04(ip, A053);
                        gy.A04.put(A042.A00, A042);
                        break;
                    }
                } else {
                    GR A043 = A04(ip, A053);
                    gy.A06.put(A043.A00, A043);
                    break;
                }
                break;
            case 19:
                if (A052 != gy.A03) {
                    if (A052 == gy.A02) {
                        GT A062 = A06(ip);
                        gy.A05.put(A062.A00, A062);
                        break;
                    }
                } else {
                    GT A063 = A06(ip);
                    gy.A07.put(A063.A00, A063);
                    break;
                }
                break;
            case 20:
                if (A052 == gy.A03) {
                    gy.A00 = A05(ip);
                    break;
                }
                break;
        }
        ip.A0A(A032 - ip.A03());
    }

    /* JADX INFO: Multiple debug info for r13v1 'line'  int: [D('clutMapTable4ToX' byte[]), D('clutMapTable2ToX' byte[])] */
    public static void A0E(byte[] bArr, int[] iArr, int i, int column, int i2, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int line = i2;
        IP ip = new IP(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] bArr4 = null;
        int dataType = column;
        while (ip.A02() != 0) {
            int A052 = ip.A05(8);
            if (A052 != 240) {
                switch (A052) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArr4 == null ? A0A : bArr4;
                        } else if (i == 2) {
                            bArr3 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                        } else {
                            bArr3 = null;
                        }
                        dataType = A01(ip, iArr, bArr3, dataType, line, paint, canvas);
                        ip.A06();
                        continue;
                    case 17:
                        if (i != 3) {
                            bArr2 = null;
                            String[] strArr = A08;
                            if (strArr[4].charAt(19) != strArr[0].charAt(19)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[2] = "ywEr7H1ZkU3fUIk8F5vLu65dTGZjfu1h";
                            strArr2[2] = "ywEr7H1ZkU3fUIk8F5vLu65dTGZjfu1h";
                        } else if (0 == 0) {
                            bArr2 = A0B;
                        } else {
                            bArr2 = null;
                        }
                        dataType = A02(ip, iArr, bArr2, dataType, line, paint, canvas);
                        ip.A06();
                        continue;
                    case 18:
                        dataType = A03(ip, iArr, null, dataType, line, paint, canvas);
                        continue;
                    default:
                        String[] strArr3 = A08;
                        if (strArr3[1].length() != strArr3[5].length()) {
                            String[] strArr4 = A08;
                            strArr4[6] = "nnJuFIsGV5CjoI7UJHQ2Bk6wbONoIcvD";
                            strArr4[3] = "B7N9QxouVzPbBX96zhiMkNdTz6ghfWa9";
                            switch (A052) {
                                case 32:
                                    clutMapTable2To8 = A0F(4, 4, ip);
                                    continue;
                                case 33:
                                    bArr4 = A0F(4, 8, ip);
                                    continue;
                                case 34:
                                    bArr4 = A0F(16, 8, ip);
                                    continue;
                                default:
                                    continue;
                            }
                        } else {
                            throw new RuntimeException();
                        }
                }
            } else {
                dataType = column;
                if (A08[2].charAt(23) != 'o') {
                    String[] strArr5 = A08;
                    strArr5[6] = "9tyozG4lbSXUGnB14yX0PwlmOZMu8mKn";
                    strArr5[3] = "zB65tdLGIFDHc3IIcHjCnZN0WwQ6SUlQ";
                    line += 2;
                } else {
                    line += 2;
                }
            }
        }
    }

    public static byte[] A0F(int i, int i2, IP ip) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ip.A05(i2);
        }
        return bArr;
    }

    public static int[] A0G() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] A0H() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i6 = 1; i6 < iArr.length; i6++) {
            if (i6 < 8) {
                if ((i6 & 1) != 0) {
                    i3 = 255;
                } else {
                    i3 = 0;
                }
                if ((i6 & 2) != 0) {
                    i4 = 255;
                } else {
                    i4 = 0;
                }
                if ((i6 & 4) != 0) {
                    i5 = 255;
                } else {
                    i5 = 0;
                }
                iArr[i6] = A00(255, i3, i4, i5);
            } else {
                int i7 = 127;
                if ((i6 & 1) != 0) {
                    i = 127;
                } else {
                    i = 0;
                }
                if ((i6 & 2) != 0) {
                    i2 = 127;
                } else {
                    i2 = 0;
                }
                if ((i6 & 4) == 0) {
                    i7 = 0;
                }
                iArr[i6] = A00(255, i, i2, i7);
            }
        }
        return iArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x016a, code lost:
        if (r9 != 0) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x016d, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0192, code lost:
        if (r7 != 0) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01db, code lost:
        if (r7 != 0) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01de, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        if (r10 != 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b3, code lost:
        if (r10 != 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b6, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e6, code lost:
        if ((r4 & 16) != 0) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0115, code lost:
        if ((r4 & 16) != 0) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0118, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0150, code lost:
        if (r9 != 0) goto L_0x0152;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] A0I() {
        /*
        // Method dump skipped, instructions count: 497
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GZ.A0I():int[]");
    }

    /* JADX INFO: Multiple debug info for r2v7 com.facebook.ads.redexgen.X.GS: [D('cueBitmap' android.graphics.Bitmap), D('regionComposition' com.facebook.ads.redexgen.X.GW), D('dataBitArray' com.facebook.ads.redexgen.X.IP)] */
    /* JADX INFO: Multiple debug info for r1v21 com.facebook.ads.redexgen.X.GW: [D('color' int), D('regionObjects' android.util.SparseArray<com.facebook.ads.internal.exoplayer2.text.dvb.DvbParser$RegionObject>), D('regionId' int), D('baseVerticalAddress' int), D('pageRegions' android.util.SparseArray<com.facebook.ads.internal.exoplayer2.text.dvb.DvbParser$PageRegion>), D('clipRight' int)] */
    /* JADX INFO: Multiple debug info for r4v4 int: [D('clutDefinition' com.facebook.ads.redexgen.X.GR), D('objectId' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0121, code lost:
        if (r14 == null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x014e, code lost:
        if (r14 == null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01b8, code lost:
        if (r1.A0A == false) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01bd, code lost:
        if (r1.A01 != 3) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01bf, code lost:
        r9 = r14.A03[r1.A07];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c5, code lost:
        r20.A03.setColor(r9);
        r20.A01.drawRect((float) r4, (float) r3, (float) (r1.A08 + r4), (float) (r1.A02 + r3), r20.A03);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0218, code lost:
        if (r1.A01 != 2) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x021a, code lost:
        r9 = r14.A02[r1.A06];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0221, code lost:
        r11 = r14.A01;
        r10 = com.facebook.ads.redexgen.X.GZ.A08;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0235, code lost:
        if (r10[4].charAt(19) == r10[0].charAt(19)) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0237, code lost:
        r9 = r11[r1.A05];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x023c, code lost:
        r10 = com.facebook.ads.redexgen.X.GZ.A08;
        r10[1] = "SK7qwpqeD";
        r10[5] = "H8yQ2FZGH97VM0iLZGupvWVfM60nEcr";
        r9 = r11[r1.A05];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0258, code lost:
        if (r14 == null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0296, code lost:
        if (r14 == null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02a2, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.facebook.ads.redexgen.X.GF> A0J(byte[] r21, int r22) {
        /*
        // Method dump skipped, instructions count: 681
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GZ.A0J(byte[], int):java.util.List");
    }

    public final void A0K() {
        this.A06.A00();
    }
}
