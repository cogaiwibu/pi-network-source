package com.facebook.ads.redexgen.X;

import com.facebook.common.statfs.StatFsHelper;
import java.nio.ShortBuffer;
import java.util.Arrays;

public final class BY {
    public static String[] A0M;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J = (this.A0I * 2);
    public final int A0K;
    public final short[] A0L;

    static {
        A07();
    }

    public static void A07() {
        A0M = new String[]{"ohCL8W0", "KQz7BMIeF4Z94D8gT8Jgt17pY9ay2sPb", "WHqc", "zdEVbBlbYLVxAkbZHAQvOg0x6UERU0KV", "RqBqTDSsJG3NS", "FmAwfgCi2dLCVzfY4ysR6r9BF", "Bq6occebnHk", "mWE0rLrmKK4IIqcH7c7itMEBPX65A8Us"};
    }

    public BY(int i, int i2, float f, float f2, int i3) {
        this.A0H = i;
        this.A0G = i2;
        this.A0F = f;
        this.A0D = f2;
        this.A0E = ((float) i) / ((float) i3);
        this.A0K = i / StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
        this.A0I = i / 65;
        int i4 = this.A0J;
        this.A0L = new short[i4];
        this.A0A = new short[(i4 * i2)];
        this.A0B = new short[(i4 * i2)];
        this.A0C = new short[(i4 * i2)];
    }

    private int A00(int i) {
        int min = Math.min(this.A0J, this.A09);
        A0E(this.A0A, i, min);
        this.A09 -= min;
        return min;
    }

    private int A01(short[] sArr, int i) {
        int minP;
        int A042;
        int i2;
        int i3 = this.A0H;
        if (i3 > 4000) {
            minP = i3 / 4000;
        } else {
            minP = 1;
        }
        if (this.A0G == 1 && minP == 1) {
            A042 = A04(sArr, i, this.A0K, this.A0I);
        } else {
            A0F(sArr, i, minP);
            A042 = A04(this.A0L, 0, this.A0K / minP, this.A0I / minP);
            if (minP != 1) {
                int i4 = A042 * minP;
                int i5 = i4 - (minP * 4);
                int minP2 = (minP * 4) + i4;
                if (i5 < this.A0K) {
                    i5 = this.A0K;
                }
                if (minP2 > this.A0I) {
                    minP2 = this.A0I;
                }
                int i6 = this.A0G;
                if (A0M[2].length() != 4) {
                    throw new RuntimeException();
                }
                String[] strArr = A0M;
                strArr[7] = "JAo85nDeN7hM6ugSVwGhvUnreF2qbK1o";
                strArr[1] = "l4YUjJfL7ivyphsQmVZd9dZE6KXUcfPo";
                if (i6 == 1) {
                    A042 = A04(sArr, i, i5, minP2);
                } else {
                    A0F(sArr, i, 1);
                    if (A0M[2].length() != 4) {
                        A042 = A04(this.A0L, 0, i5, minP2);
                    } else {
                        String[] strArr2 = A0M;
                        strArr2[6] = "Av8EYvFT4XF";
                        strArr2[5] = "OBBgqqBYNHA95X1QZrayaR0nl";
                        A042 = A04(this.A0L, 0, i5, minP2);
                    }
                }
            }
        }
        if (A0G(this.A02, this.A01)) {
            i2 = this.A08;
        } else {
            i2 = A042;
        }
        this.A07 = this.A02;
        this.A08 = A042;
        return i2;
    }

    private int A02(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((((float) i2) * f) / (1.0f - f));
        } else {
            this.A09 = (int) ((((float) i2) * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        this.A0B = A0H(this.A0B, this.A05, i2 + i3);
        int i4 = this.A0G;
        System.arraycopy(sArr, i * i4, this.A0B, this.A05 * i4, i4 * i2);
        A0D(i3, this.A0G, this.A0B, this.A05 + i2, sArr, i + i2, sArr, i);
        this.A05 += i2 + i3;
        return i3;
    }

    private int A03(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (((float) i2) / (f - 1.0f));
        } else {
            this.A09 = (int) ((((float) i2) * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        this.A0B = A0H(this.A0B, this.A05, i3);
        A0D(i3, this.A0G, this.A0B, this.A05, sArr, i, sArr, i + i2);
        this.A05 += i3;
        return i3;
    }

    private int A04(short[] sArr, int minDiff, int maxDiff, int period) {
        int diff = 0;
        int i = 255;
        int i2 = 1;
        int i3 = 0;
        int minDiff2 = minDiff * this.A0G;
        while (maxDiff <= period) {
            int i4 = 0;
            for (int i5 = 0; i5 < maxDiff; i5++) {
                i4 += Math.abs(sArr[minDiff2 + i5] - sArr[(minDiff2 + maxDiff) + i5]);
            }
            if (i4 * diff < i2 * maxDiff) {
                i2 = i4;
                diff = maxDiff;
            }
            if (i4 * i > i3 * maxDiff) {
                i3 = i4;
                i = maxDiff;
            }
            maxDiff++;
        }
        this.A02 = i2 / diff;
        this.A01 = i3 / i;
        return diff;
    }

    private short A05(short[] sArr, int i, int i2, int leftPosition) {
        short s = sArr[i];
        short s2 = sArr[this.A0G + i];
        int i3 = this.A04;
        int i4 = i3 * leftPosition;
        int i5 = (i3 + 1) * leftPosition;
        int width = i5 - (this.A03 * i2);
        int i6 = i5 - i4;
        return (short) (((width * s) + ((i6 - width) * s2)) / i6);
    }

    private void A06() {
        int i = this.A05;
        float f = this.A0F;
        float f2 = this.A0D;
        float f3 = f / f2;
        float f4 = this.A0E * f2;
        if (((double) f3) > 1.00001d || ((double) f3) < 0.99999d) {
            A08(f3);
        } else {
            A0E(this.A0A, 0, this.A00);
            this.A00 = 0;
        }
        if (f4 != 1.0f) {
            A09(f4, i);
        }
    }

    private void A08(float f) {
        if (this.A00 >= this.A0J) {
            int i = this.A00;
            int i2 = 0;
            do {
                if (this.A09 > 0) {
                    i2 += A00(i2);
                } else {
                    int A012 = A01(this.A0A, i2);
                    if (((double) f) > 1.0d) {
                        i2 += A03(this.A0A, i2, f, A012) + A012;
                    } else {
                        i2 += A02(this.A0A, i2, f, A012);
                    }
                }
            } while (this.A0J + i2 <= i);
            A0C(i2);
        }
    }

    private void A09(float f, int i) {
        int i2;
        int i3;
        if (this.A05 != i) {
            int i4 = (int) (((float) this.A0H) / f);
            int i5 = this.A0H;
            while (true) {
                if (i4 <= 16384 && i5 <= 16384) {
                    A0A(i);
                    int i6 = 0;
                    while (true) {
                        int i7 = this.A06;
                        int i8 = i7 - 1;
                        String[] strArr = A0M;
                        if (strArr[7].charAt(13) == strArr[1].charAt(13)) {
                            break;
                        }
                        String[] strArr2 = A0M;
                        strArr2[7] = "S0FZlq4hqR1MtwM4zltGGLcwqbHHLsP7";
                        strArr2[1] = "aAsnKYirvcv97dya3O8NjUmjHgDgPMP0";
                        boolean z = true;
                        if (i6 < i8) {
                            while (true) {
                                i2 = this.A04;
                                int i9 = (i2 + 1) * i4;
                                i3 = this.A03;
                                if (i9 <= i3 * i5) {
                                    break;
                                }
                                this.A0B = A0H(this.A0B, this.A05, 1);
                                int i10 = 0;
                                while (true) {
                                    int i11 = this.A0G;
                                    if (i10 >= i11) {
                                        break;
                                    }
                                    this.A0B[(this.A05 * i11) + i10] = A05(this.A0C, (i11 * i6) + i10, i5, i4);
                                    i10++;
                                }
                                this.A03++;
                                this.A05++;
                            }
                            this.A04 = i2 + 1;
                            if (this.A04 == i5) {
                                this.A04 = 0;
                                if (i3 != i4) {
                                    z = false;
                                }
                                I1.A04(z);
                                this.A03 = 0;
                            }
                            i6++;
                        } else {
                            A0B(i7 - 1);
                            return;
                        }
                    }
                } else {
                    i4 /= 2;
                    if (A0M[0].length() != 7) {
                        break;
                    }
                    String[] strArr3 = A0M;
                    strArr3[0] = "V4vENqc";
                    strArr3[0] = "V4vENqc";
                    i5 /= 2;
                }
            }
            throw new RuntimeException();
        }
    }

    private void A0A(int i) {
        int i2 = this.A05 - i;
        this.A0C = A0H(this.A0C, this.A06, i2);
        short[] sArr = this.A0B;
        int i3 = this.A0G;
        System.arraycopy(sArr, i * i3, this.A0C, this.A06 * i3, i3 * i2);
        this.A05 = i;
        this.A06 += i2;
    }

    private void A0B(int i) {
        if (i != 0) {
            short[] sArr = this.A0C;
            int i2 = this.A0G;
            System.arraycopy(sArr, i * i2, sArr, 0, (this.A06 - i) * i2);
            this.A06 -= i;
        }
    }

    private void A0C(int i) {
        int i2 = this.A00 - i;
        short[] sArr = this.A0A;
        int i3 = this.A0G;
        System.arraycopy(sArr, i * i3, sArr, 0, i3 * i2);
        this.A00 = i2;
    }

    public static void A0D(int i, int o, short[] sArr, int i2, short[] sArr2, int i3, short[] sArr3, int i4) {
        for (int i5 = 0; i5 < o; i5++) {
            int i6 = (i2 * o) + i5;
            int i7 = (i4 * o) + i5;
            int i8 = (i3 * o) + i5;
            for (int i9 = 0; i9 < i; i9++) {
                sArr[i6] = (short) (((sArr2[i8] * (i - i9)) + (sArr3[i7] * i9)) / i);
                i6 += o;
                i8 += o;
                i7 += o;
            }
        }
    }

    private void A0E(short[] sArr, int i, int i2) {
        this.A0B = A0H(this.A0B, this.A05, i2);
        int i3 = this.A0G;
        System.arraycopy(sArr, i * i3, this.A0B, this.A05 * i3, i3 * i2);
        this.A05 += i2;
    }

    private void A0F(short[] sArr, int samplesPerValue, int i) {
        int i2 = this.A0J / i;
        int i3 = this.A0G;
        int i4 = i3 * i;
        int samplesPerValue2 = samplesPerValue * i3;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                i6 += sArr[(i5 * i4) + samplesPerValue2 + i7];
            }
            this.A0L[i5] = (short) (i6 / i4);
        }
    }

    private boolean A0G(int i, int i2) {
        if (i == 0 || this.A08 == 0 || i2 > i * 3 || i * 2 <= this.A07 * 3) {
            return false;
        }
        return true;
    }

    private short[] A0H(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.A0G;
        int i4 = length / i3;
        if (i + i2 <= i4) {
            return sArr;
        }
        return Arrays.copyOf(sArr, i3 * (((i4 * 3) / 2) + i2));
    }

    public final int A0I() {
        return this.A05;
    }

    public final void A0J() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0K() {
        int i = this.A00;
        float f = this.A0F;
        float f2 = this.A0D;
        int i2 = this.A05 + ((int) ((((((float) i) / (f / f2)) + ((float) this.A06)) / (this.A0E * f2)) + 0.5f));
        this.A0A = A0H(this.A0A, this.A00, (this.A0J * 2) + i);
        int i3 = 0;
        while (true) {
            int i4 = this.A0J;
            int i5 = this.A0G;
            if (i3 < i4 * 2 * i5) {
                short[] sArr = this.A0A;
                String[] strArr = A0M;
                if (strArr[7].charAt(13) != strArr[1].charAt(13)) {
                    String[] strArr2 = A0M;
                    strArr2[6] = "8uqTwc5xmM3";
                    strArr2[5] = "8QSOBZmBR7CYVXHwBaCnC4p1f";
                    sArr[(i5 * i) + i3] = 0;
                    i3++;
                } else {
                    throw new RuntimeException();
                }
            } else {
                this.A00 += i4 * 2;
                A06();
                if (this.A05 > i2) {
                    this.A05 = i2;
                }
                this.A00 = 0;
                this.A09 = 0;
                this.A06 = 0;
                return;
            }
        }
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        shortBuffer.put(this.A0B, 0, this.A0G * min);
        this.A05 -= min;
        short[] sArr = this.A0B;
        int i = this.A0G;
        System.arraycopy(sArr, min * i, sArr, 0, this.A05 * i);
    }

    public final void A0M(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.A0G;
        int i2 = remaining / i;
        this.A0A = A0H(this.A0A, this.A00, i2);
        shortBuffer.get(this.A0A, this.A00 * this.A0G, ((i * i2) * 2) / 2);
        this.A00 += i2;
        A06();
    }
}
