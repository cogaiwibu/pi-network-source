package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.video.ColorInfo;
import com.facebook.ads.internal.exoplayer2.video.DummySurface;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.OneSignalRemoteParams;
import com.tapjoy.TapjoyConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.1y  reason: invalid class name and case insensitive filesystem */
public final class C00711y extends AnonymousClass3S {
    public static boolean A0b;
    public static boolean A0c;
    public static byte[] A0d;
    public static String[] A0e;
    public static final int[] A0f = {1920, 1600, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW, 1280, 960, 854, 640, 540, 480};
    public C0475Ir A00;
    public float A01;
    public float A02;
    public float A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public Surface A0N;
    public Surface A0O;
    public C0474Iq A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public final int A0T;
    public final long A0U;
    public final Context A0V;
    public final C0478Iu A0W = new C0478Iu(this.A0V);
    public final J3 A0X;
    public final boolean A0Y;
    public final long[] A0Z;
    public final long[] A0a;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0e;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[6] = "1g9G5auDmi6BFhp1SUFflSJn2zbmW8bI";
            strArr2[4] = "EQg736KY9Bh9QzgWqQs064uwRmk9hBcX";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 46);
            i4++;
        }
    }

    public static void A0D() {
        A0d = new byte[]{64, 71, 65, 64, 64, 70, 64, 66, 71, 65, 71, 66, 122, 10, 11, 22, 12, 11, 125, 55, 71, 64, 70, 71, 42, 89, 91, 90, 93, 10, 95, 91, 63, 73, 78, 78, 78, 83, 31, 17, 103, 96, 96, 96, 32, 60, 37, 35, 118, 0, 7, 6, 7, 86, 3, 15, 73, 63, 56, 58, 56, 105, 60, 48, 40, 47, 61, 40, 2, 5, 23, 13, 0, 7, 21, 18, 39, 11, 7, 28, 9, 8, 11, 59, 63, 43, 26, 37, 61, 47, 56, 7, 90, 110, 105, 122, 68, 85, 116, 111, 126, 68, 41, 55, 57, 52, 54, 62, 88, 68, 45, 4, 20, 7, 16, 15, 7, 102, 114, 13, 102, 116, 118, 119, 115, 39, 55, 36, 51, 44, 36, 58, 36, 49, 51, 87, 3, 113, 7, 20, 124, 114, 115, 114, 27, 13, 116, 118, 90, 73, 81, 40, 47, 41, 32, 12, 31, 22, 119, 124, 16, 6, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, 106, 70, 77, 76, 74, 9, 68, 72, 81, 9, 91, 76, 90, 70, 69, 92, 93, 64, 70, 71, 9, 72, 77, 67, 92, 90, 93, 76, 77, 9, 93, 70, 19, 9, 108, 64, 66, 70, 64, 124, 30, 19, 99, 96, 98, 101, 94, 87, 78, 92, 90, 68, 90, 40, 68, 75, 105, 116, 46, 39, 62, 44, 42, 52, 37, 4, 31, 14, 5, 12, 21, 7, 1, 31, 16, 50, 41, 45, 24, 17, 8, 26, 28, 2, 15, 60, 36, 2, 5, 69, 118, 101, 114, 83, 116, 97, 114, 95, 83, ByteCompanionObject.MAX_VALUE, 10, 8, 8, 8, 72, 61, 63, 63, 61, 102, 19, 17, 17, 22, 68, 49, 48, 51, 51, 24, 109, 108, 111, 109, 84, 33, 32, 35, 39, 39, 82, 82, 80, 80, 94, 121, 116, 107, 125, 91, 112, 125, 123, 115, 56, 67, 116, 125, ByteCompanionObject.MAX_VALUE, 121, 123, 97, 94, 106, 121, 117, 125, 75, 113, 98, 125, 52, 56, 41, 39, 33, 32, 43, 43, 49, 41, 44, 34, 89, 93, 88, 94, 8, 6, 0, 1, 10, 10, 16, 28, 24, 24, 126, 121, ByteCompanionObject.MAX_VALUE, 118, 15, 1, 7, 6, 13, 13, 23, 27, 31, 31, 121, 126, 122, ByteCompanionObject.MAX_VALUE, 65, 79, 73, 72, 67, 67, 89, 85, 81, 81, 55, 48, 53, 55, 1, 15, 9, 8, 3, 3, 25, 17, 4, 10, 115, 113, 118, 126, 40, 38, 32, 33, 42, 42, 48, 56, 45, 35, 88, 92, 89, 90, 59, 53, 51, 50, 57, 57, 35, 43, 62, 48, 75, 73, 77, 69, 40, 6, 32, 33, 42, 42, 48, 44, 45, 35, 88, 90, 94, 92, 30, 48, 22, 23, 28, 28, 6, 30, 27, 21, 110, 106, 104, 96, 64, 95, 74, 68, 70, 37, 64, 91, 68, 80, 82, 94, 62, 91, 66, 93, 92, 68, 89, 39, 66, 74, 109, 101, 106, 109, 106, 123, 46, 91, 54, 52, 49, 70, 75, 86, 21, 107, 110, 63, 106, 110, 13, 0, 21, 9, 17, 15, 70, 89, 39, 63, 58, 59, 61, 67, 59, 109, 87, 95, 83, 64, 79, 69, 87, 47, 27, 14, 96, 116, 92, 93, 80, 88, 122, 86, 93, 92, 90, 111, 80, 93, 92, 86, 107, 92, 87, 93, 92, 75, 92, 75, 26, 2, 29, 16, 29, 21, 95, 73, 36, 37, 32, 91, 45, 59, 86, 84, 80, 41, 28, 30, 11, 125, 52, 60, 60, 52, 63, 54, 89, 120, 115, 70, 122, 99, 101, 35, 66, 84, 50, 60, 53, 55, 95, 82, 64, 82, 34, 61, 38, 39, 32, 93, 71, 80, 89, 34, 37, 47, 17, 6, 15, 119, 112, 113, 96, 119, 126, 6, 1, 1, 31, 3, 10, 46, 44, 49, 73, 45, 14, 54, 63, 48, 42, 49, 51, 104, 4, 61, 44, 61, 96, 121, 99, 11, 103, 19, 77, 116, 101, 116, 40, 48, 44, 45, 66, 41, 90, 8, 106, 108, 105, 120, 29, 27, 31, 25, 33, 68, 66, 71, 109, 8, 15, 13, 12, 98, 6, 6, 26, 102, 97, 15, 18, 8, 2, 125, 116, 29, 121, 78, 88, 68, 71, 94, 95, 66, 68, 69, 88, 11, 94, 69, 64, 69, 68, 92, 69, 5, 11, 104, 68, 79, 78, 72, 11, 70, 74, 83, 11, 89, 78, 88, 68, 71, 94, 95, 66, 68, 69, 17, 11, 109, 104, 110, 19, 122, 106, 104, 15, 11, 118, 73, 68, 81, 64, 122, 117, 87, 74, 35, 53, 68, 90, 64, 68, 71, 49, 100, 114, 3, 29, 7, 3, 0, 104, 61, 43, 90, 68, 81, 92, 89, 47, 102, 112, 1, 31, 10, 7, 2, ByteCompanionObject.MAX_VALUE, 16, 43, 43, 100, 41, 37, 42, 61, 100, 55, 48, 54, 33, 37, 41, 100, 39, 44, 37, 42, 35, 33, 55, 104, 100, 55, 43, 100, 32, 54, 43, 52, 52, 45, 42, 35, 100, 43, 34, 34, 55, 33, 48, 126, 100, 73, 46, 7, 99, 98, 22, 19, 108, 15, 31, 116, 24, 15, 12, 13, 16, 103, 13, 15, 3, 102, 97, 97, 100, 19, 120, 123, 22, 25, 27, 6, 43, 73, 65, 104, 18, 111, 20, 16, 4, 21, 24, 30, 92, 2, 20, 2, 2, 24, 30, 31, 92, 24, 21, 12, 24, 25, 2, 64, 11, 31, 14, 75, 90, 71, 88, 5, 74, 71, 92, 92, 71, 69, 9, 24, 5, 26, 71, 6, 15, 12, 30, 17, 0, 29, 2, 95, 0, 27, 21, 26, 6, 28, 13, 16, 15, 82, 11, 16, 15, 54, 35, 100, 124, 105, 44, 81, 80, 87, 3, 21, 8, 23, 49, 14, 3, 2, 8, 37, 18, 1, 1, 2, 21, 99, 105, 106, 76, 69, 89, 94, 79, 88, 48, 36, 55, 59, 51, 123, 36, 55, 34, 51, 24, 13, 22, 25, 25, 22, 17, 39, 42, 38, 40, 39, 59, 99, ByteCompanionObject.MAX_VALUE, 104, 84, 110, 62, 61, 102, 103, 84, 111, ByteCompanionObject.MAX_VALUE, 126, 103, 42, 53, 3, 14, 7, 111, 10, 96, 107, 104, 101, 101, 49, 62, 58, 60, 86, 48, 49, 57, 63, 119, 108, 119, 109, 40, 46, 114, 111, 126, 119, 68, 72, 47, 42, 47, 119, 61, 41, 49, 32, 44, 43, 54, 47, 38, 28, 59, 117, 100, 104, 103, 103, 96, 103, 110, 118, 122, 105, 114, 117, 116, 68, 125, 12, 0, 25, 76, 9, 4, 8, 6, 9, 21, 14, 2, 27, 78, 10, 13, 19, 22, 23, 78, 16, 10, 25, 6, 83, 95, 70, 19, 73, 87, 90, 74, 86, 16, 21, 68, 64, 77, 70, ByteCompanionObject.MAX_VALUE, 123, ByteCompanionObject.MAX_VALUE, 119, 89, 86, 90, 86, 67, 95, 107, 108, 102, 110, 105, 100, 112, 118, 90, 99, 119, 53, 54, 53, 72, 89, 86, 93, 84, 84, 103, 92, 48, 33, 46, 37, 44, 44, 31, 36, 44, 101, 116, 123, 112, 121, 121, 74, 113, 102, 96, 113, 126, 117, 124, 124, 79, 116, 100, 78, 76, 87, 81, 76, 87, 74, 71, 107, 124, 117, 124, 120, 106, 124, 86, 108, 109, 105, 108, 109, 91, 108, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, 124, 107, 17, 12, 23, 2, 23, 10, 12, 13, 78, 7, 6, 4, 17, 6, 6, 16, 94, 20, 29, 24, 85, 29, 28, 21, 123, 105, 102, 124, 103, 102, 97, 68, 92, 94, 71, 97, 94, 83, 82, 88, 117, 66, 81, 81, 82, 69, 5, 16, 24, 21, 30, 46, 3, 30, 6, 32, 55, 56, 11, 49, 33, 54, 55, 44, 44, 39, 46, 39, 38, 111, 50, 46, 35, 59, 32, 35, 33, 41, 82, 65, 86, 74, 65, 65, 123, 105, 17, 116, 107, 102, 103, 109, 45, 49, 101, 114, 114, 117, 106, 103, 102, 108, 44, 98, 117, 96, 97, 126, 115, 114, 120, 56, ByteCompanionObject.MAX_VALUE, 114, 97, 116, 102, 121, 116, 117, ByteCompanionObject.MAX_VALUE, 63, 125, 96, 36, 102, 61, 117, 99, 5, 26, 23, 22, 28, 92, 11, 94, 5, 29, 23, 93, 28, 29, 65, 93, 5, 3, 75, 111, 112, 125, 124, 118, 54, 97, 52, 111, 119, 125, 55, 118, 119, 43, 55, 111, 105, 32, 9, 31, 10, 13, 17, 16, 79, 80, 65, 74, 93, 92, 63, 33, 44, 60, 32, 106, 114, 114, 121, 110, 66, 123, 115, 107, 107, 96, 119, 91, 98, 106, 23};
    }

    public static void A0E() {
        A0e = new String[]{"NS8r3iU3bE12Q5c28wyOjILRdJ0J08uI", "UbzRKZURs", "SU7Qb1ICkxq5LQRUjQdAnOKVl0Elt9iK", "HdySUumBIxpTjI6XDfJ50FoXA9Aqq3VK", "W2XidxNDZL2wdlIqJNQqrIQcb8erTCLJ", "pQl30wQXruMBF7LsTdQVlnJoVdVvITHL", "EldsxOw3j9Ew0275hEYEpNzApywAkDlk", "GsoHFPwBx"};
    }

    static {
        A0E();
        A0D();
    }

    public C00711y(Context context, AbstractC0350Do r4, long j, @Nullable C4<Y7> c4, boolean z, @Nullable Handler handler, @Nullable J4 j4, int i) {
        super(2, r4, c4, z);
        this.A0U = j;
        this.A0T = i;
        this.A0V = context.getApplicationContext();
        this.A0X = new J3(handler, j4);
        this.A0Y = A0N();
        this.A0Z = new long[10];
        this.A0a = new long[10];
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0J = -9223372036854775807L;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0F = 1;
        A07();
    }

    public static int A00(C0344Di di, Format format) {
        if (format.A09 == -1) {
            return A01(di, format.A0O, format.A0F, format.A08);
        }
        int totalInitializationDataSize = 0;
        int size = format.A0P.size();
        for (int i = 0; i < size; i++) {
            totalInitializationDataSize += format.A0P.get(i).length;
        }
        int i2 = format.A09 + totalInitializationDataSize;
        if (A0e[5].charAt(17) != 'd') {
            throw new RuntimeException();
        }
        String[] strArr = A0e;
        strArr[6] = "hUEdDcZTQNKRArh2wdU5F4NdxnsUaLHW";
        strArr[4] = "JKTUnCqsCUQLCGuZWmxU63uBYWjDtVyB";
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014d, code lost:
        if (r4 != false) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015c, code lost:
        if (r4 != false) goto L_0x014f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int A01(com.facebook.ads.redexgen.X.C0344Di r11, java.lang.String r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00711y.A01(com.facebook.ads.redexgen.X.Di, java.lang.String, int, int):int");
    }

    /* JADX INFO: Multiple debug info for r8v1 int: [D('longEdgePx' int), D('aspectRatio' float)] */
    public static Point A02(C0344Di di, Format format) throws C0353Dr {
        boolean z;
        int i;
        int i2;
        int i3;
        int longEdgePx = 0;
        if (format.A08 > format.A0F) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = format.A08;
        } else {
            i = format.A0F;
        }
        if (z) {
            i2 = format.A0F;
        } else {
            i2 = format.A08;
        }
        float f = ((float) i2) / ((float) i);
        int[] iArr = A0f;
        int length = iArr.length;
        while (longEdgePx < length) {
            int i4 = iArr[longEdgePx];
            if (A0e[3].charAt(18) != 'r') {
                String[] strArr = A0e;
                strArr[5] = "1BVaGfMRJiqdWLUq8dv8R9mVKG0R6nhL";
                strArr[5] = "1BVaGfMRJiqdWLUq8dv8R9mVKG0R6nhL";
                int i5 = (int) (((float) i4) * f);
                if (i4 <= i || i5 <= i2) {
                    return null;
                }
                if (C0466Ig.A02 >= 21) {
                    if (z) {
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    if (!z) {
                        i4 = i5;
                    }
                    Point A0F2 = di.A0F(i3, i4);
                    if (di.A0I(A0F2.x, A0F2.y, (double) format.A01)) {
                        return A0F2;
                    }
                } else {
                    int A042 = C0466Ig.A04(i4, 16) * 16;
                    int A043 = C0466Ig.A04(i5, 16) * 16;
                    if (A042 * A043 <= C0355Dt.A00()) {
                        int shortEdgePx = z ? A043 : A042;
                        if (!z) {
                            A042 = A043;
                        }
                        return new Point(shortEdgePx, A042);
                    }
                }
                longEdgePx++;
                if (A0e[3].charAt(18) != 'r') {
                    String[] strArr2 = A0e;
                    strArr2[7] = "qOOBmdqjU";
                    strArr2[1] = "w7Tn3xd7M";
                } else {
                    String[] strArr3 = A0e;
                    strArr3[2] = "KAf95qDJkDfWOijmfxtuynNssocKmC3g";
                    strArr3[0] = "h6cBxdrGRvPICzB6Kk67A24HS1YQyhML";
                }
            } else {
                throw new RuntimeException();
            }
        }
        return null;
    }

    @SuppressLint({"InlinedApi"})
    private final MediaFormat A03(Format format, C0474Iq iq, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A05(1094, 4, 60), format.A0O);
        mediaFormat.setInteger(A05(1359, 5, 102), format.A0F);
        mediaFormat.setInteger(A05(971, 6, 97), format.A08);
        C0356Du.A07(mediaFormat, format.A0P);
        C0356Du.A04(mediaFormat, A05(954, 10, 120), format.A01);
        C0356Du.A05(mediaFormat, A05(1180, 16, 77), format.A0B);
        C0356Du.A03(mediaFormat, format.A0J);
        mediaFormat.setInteger(A05(1079, 9, 16), iq.A02);
        mediaFormat.setInteger(A05(IronSourceError.ERROR_DO_RV_LOAD_TIMED_OUT, 10, 79), iq.A00);
        C0356Du.A05(mediaFormat, A05(1065, 14, 77), iq.A01);
        if (C0466Ig.A02 >= 23) {
            mediaFormat.setInteger(A05(1153, 8, 16), 0);
        }
        if (z) {
            mediaFormat.setInteger(A05(875, 8, 67), 0);
        }
        if (i != 0) {
            A0L(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* JADX INFO: Multiple debug info for r10v0 com.facebook.ads.redexgen.X.Di: [D('maxHeight' int), D('maxWidth' int)] */
    private final C0474Iq A04(C0344Di di, Format format, Format[] formatArr) throws C0353Dr {
        boolean z;
        int i = format.A0F;
        int i2 = format.A08;
        int A002 = A00(di, format);
        if (formatArr.length == 1) {
            return new C0474Iq(i, i2, A002);
        }
        boolean z2 = false;
        for (Format format2 : formatArr) {
            if (A0W(di.A03, format, format2)) {
                if (format2.A0F == -1 || format2.A08 == -1) {
                    z = true;
                } else {
                    z = false;
                }
                z2 |= z;
                i = Math.max(i, format2.A0F);
                i2 = Math.max(i2, format2.A08);
                A002 = Math.max(A002, A00(di, format2));
            }
        }
        if (z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(A05(683, 43, 5));
            sb.append(i);
            String A052 = A05(1379, 1, 65);
            sb.append(A052);
            sb.append(i2);
            String sb2 = sb.toString();
            String A053 = A05(522, 23, 23);
            Log.w(A053, sb2);
            Point A022 = A02(di, format);
            if (A022 != null) {
                i = Math.max(i, A022.x);
                i2 = Math.max(i2, A022.y);
                A002 = Math.max(A002, A01(di, format.A0O, i, i2));
                Log.w(A053, A05(164, 34, 7) + i + A052 + i2);
            }
        }
        return new C0474Iq(i, i2, A002);
    }

    private void A06() {
        MediaCodec A1E;
        this.A0R = false;
        if (C0466Ig.A02 >= 23 && this.A0S && (A1E = A1E()) != null) {
            this.A00 = new C0475Ir(this, A1E);
        }
    }

    private void A07() {
        this.A0E = -1;
        this.A0C = -1;
        this.A03 = -1.0f;
        this.A0D = -1;
    }

    private void A08() {
        if (this.A09 > 0) {
            long elapsedMs = SystemClock.elapsedRealtime();
            this.A0X.A02(this.A09, elapsedMs - this.A0H);
            this.A09 = 0;
            this.A0H = elapsedMs;
        }
    }

    private void A09() {
        if (this.A08 != -1 || this.A06 != -1) {
            if (this.A0E != this.A08 || this.A0C != this.A06 || this.A0D != this.A07 || this.A03 != this.A01) {
                J3 j3 = this.A0X;
                String[] strArr = A0e;
                if (strArr[6].charAt(27) != strArr[4].charAt(27)) {
                    String[] strArr2 = A0e;
                    strArr2[2] = "RTvZ5FDjzwdLT6J2ljezTJit2l4QBCCR";
                    strArr2[0] = "8XoC7GroR317PXdtPjLLz1J1MgtvBrxC";
                    j3.A01(this.A08, this.A06, this.A07, this.A01);
                    this.A0E = this.A08;
                    this.A0C = this.A06;
                    this.A0D = this.A07;
                    this.A03 = this.A01;
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    private void A0A() {
        if (this.A0R) {
            this.A0X.A03(this.A0O);
        }
    }

    private void A0B() {
        if (this.A0E != -1 || this.A0C != -1) {
            this.A0X.A01(this.A0E, this.A0C, this.A0D, this.A03);
        }
    }

    private void A0C() {
        long j;
        if (this.A0U > 0) {
            j = SystemClock.elapsedRealtime() + this.A0U;
        } else {
            j = -9223372036854775807L;
        }
        this.A0J = j;
    }

    private final void A0F(int i) {
        super.A0U.A02 += i;
        this.A09 += i;
        this.A05 += i;
        super.A0U.A05 = Math.max(this.A05, super.A0U.A05);
        if (this.A09 >= this.A0T) {
            A08();
        }
    }

    private final void A0G(MediaCodec mediaCodec, int i, long j) {
        C0463Id.A02(A05(930, 15, 73));
        mediaCodec.releaseOutputBuffer(i, false);
        C0463Id.A00();
        A0F(1);
    }

    private final void A0H(MediaCodec mediaCodec, int i, long j) {
        A09();
        C0463Id.A02(A05(1161, 19, 55));
        mediaCodec.releaseOutputBuffer(i, true);
        C0463Id.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1T();
    }

    private final void A0I(MediaCodec mediaCodec, int i, long j) {
        C0463Id.A02(A05(IronSourceConstants.RV_INSTANCE_READY_FALSE, 15, 25));
        mediaCodec.releaseOutputBuffer(i, false);
        C0463Id.A00();
        super.A0U.A08++;
    }

    @TargetApi(21)
    private final void A0J(MediaCodec mediaCodec, int i, long j, long j2) {
        A09();
        C0463Id.A02(A05(1161, 19, 55));
        mediaCodec.releaseOutputBuffer(i, j2);
        C0463Id.A00();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
        super.A0U.A06++;
        this.A05 = 0;
        A1T();
    }

    @TargetApi(23)
    public static void A0K(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    public static void A0L(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(A05(1241, 17, 108), true);
        mediaFormat.setInteger(A05(859, 16, 95), i);
    }

    /* JADX INFO: Multiple debug info for r5v0 'this'  com.facebook.ads.redexgen.X.1y: [D('state' int), D('codecInfo' com.facebook.ads.redexgen.X.Di)] */
    private void A0M(Surface surface) throws A4 {
        if (surface == null) {
            if (this.A0N != null) {
                surface = this.A0N;
            } else {
                C0344Di A1F = A1F();
                if (A1F != null && A0U(A1F)) {
                    this.A0N = DummySurface.A01(this.A0V, A1F.A05);
                    surface = this.A0N;
                }
            }
        }
        if (this.A0O != surface) {
            this.A0O = surface;
            int A70 = A70();
            if (A70 == 1 || A70 == 2) {
                MediaCodec A1E = A1E();
                if (C0466Ig.A02 < 23 || A1E == null || surface == null || this.A0Q) {
                    A1I();
                    A1K();
                } else {
                    A0K(A1E, surface);
                }
            }
            if (surface == null || surface == this.A0N) {
                A07();
                String[] strArr = A0e;
                if (strArr[2].charAt(13) != strArr[0].charAt(13)) {
                    String[] strArr2 = A0e;
                    strArr2[3] = "3kfdRjkwPvYxx8JzUoiB9hf8dQ33bpul";
                    strArr2[3] = "3kfdRjkwPvYxx8JzUoiB9hf8dQ33bpul";
                    A06();
                    return;
                }
                throw new RuntimeException();
            }
            A0B();
            A06();
            if (A70 == 2) {
                A0C();
            }
        } else if (surface != null && surface != this.A0N) {
            A0B();
            A0A();
        }
    }

    public static boolean A0N() {
        if (C0466Ig.A02 <= 22) {
            if (A05(948, 6, 4).equals(C0466Ig.A03)) {
                if (A05(545, 6, 122).equals(C0466Ig.A05)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A0O(long j) {
        return j < -30000;
    }

    public static boolean A0P(long j) {
        return j < -500000;
    }

    private final boolean A0Q(long j, long j2) {
        return A0P(j);
    }

    private final boolean A0R(long j, long j2) {
        return A0O(j);
    }

    private final boolean A0S(long j, long j2) {
        return A0O(j) && j2 > 100000;
    }

    private final boolean A0T(MediaCodec mediaCodec, int i, long j, long j2) throws A4 {
        int A11 = A11(j2);
        if (A11 == 0) {
            return false;
        }
        super.A0U.A03++;
        A0F(this.A04 + A11);
        A1H();
        return true;
    }

    private boolean A0U(C0344Di di) {
        if (C0466Ig.A02 >= 23 && !this.A0S) {
            String str = di.A02;
            if (A0e[5].charAt(17) != 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[6] = "kyWyTgTuit8kBu9eYgHiJLOeDtaawSzk";
            strArr[4] = "zep7axp9udbgCrK2JAqRjKsc1O8PK6En";
            return !A0V(str) && (!di.A05 || DummySurface.A05(this.A0V));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0965, code lost:
        if (r4.equals(A05(64, 4, 71)) != false) goto L_0x0942;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean A0V(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 3170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00711y.A0V(java.lang.String):boolean");
    }

    public static boolean A0W(boolean z, Format format, Format format2) {
        if (format.A0O.equals(format2.A0O) && format.A0B == format2.A0B && (z || (format.A0F == format2.A0F && format.A08 == format2.A08))) {
            ColorInfo colorInfo = format.A0J;
            ColorInfo colorInfo2 = format2.A0J;
            String[] strArr = A0e;
            if (strArr[2].charAt(13) != strArr[0].charAt(13)) {
                String[] strArr2 = A0e;
                strArr2[5] = "SCavqIZfy9E7QicA0dHTliXfXCWB3KSN";
                strArr2[5] = "SCavqIZfy9E7QicA0dHTliXfXCWB3KSN";
                if (C0466Ig.A0h(colorInfo, colorInfo2)) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A14() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0M = -9223372036854775807L;
        this.A0K = -9223372036854775807L;
        this.A0A = 0;
        A07();
        A06();
        this.A0W.A09();
        this.A00 = null;
        this.A0S = false;
        try {
            super.A14();
        } finally {
            super.A0U.A00();
            this.A0X.A05(super.A0U);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A15() {
        super.A15();
        this.A09 = 0;
        this.A0H = SystemClock.elapsedRealtime();
        this.A0L = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A16() {
        this.A0J = -9223372036854775807L;
        A08();
        super.A16();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A17(long j, boolean z) throws A4 {
        super.A17(j, z);
        A06();
        this.A0I = -9223372036854775807L;
        this.A05 = 0;
        this.A0K = -9223372036854775807L;
        int i = this.A0A;
        if (i != 0) {
            long[] jArr = this.A0Z;
            String[] strArr = A0e;
            if (strArr[6].charAt(27) != strArr[4].charAt(27)) {
                String[] strArr2 = A0e;
                strArr2[7] = "7MW3dnHmZ";
                strArr2[1] = "zsetFM6ej";
                this.A0M = jArr[i - 1];
                this.A0A = 0;
            } else {
                throw new RuntimeException();
            }
        }
        if (z) {
            A0C();
        } else {
            this.A0J = -9223372036854775807L;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A18(boolean z) throws A4 {
        boolean z2;
        super.A18(z);
        this.A0G = A13().A00;
        if (this.A0G != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.A0S = z2;
        this.A0X.A06(super.A0U);
        this.A0W.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd
    public final void A19(Format[] formatArr, long j) throws A4 {
        if (this.A0M == -9223372036854775807L) {
            this.A0M = j;
        } else {
            int i = this.A0A;
            String[] strArr = A0e;
            if (strArr[6].charAt(27) != strArr[4].charAt(27)) {
                String[] strArr2 = A0e;
                strArr2[2] = "hJEWxkqVwddaEGRwsPF9GJysu0azMoJ9";
                strArr2[0] = "zdhmDyX7lfpv7BLRFINwBKdWRGj92JIy";
                if (i == this.A0Z.length) {
                    Log.w(A05(522, 23, 23), A05(776, 45, 106) + this.A0Z[this.A0A - 1]);
                } else {
                    this.A0A = i + 1;
                }
                long[] jArr = this.A0Z;
                int i2 = this.A0A;
                jArr[i2 - 1] = j;
                this.A0a[i2 - 1] = this.A0K;
            } else {
                throw new RuntimeException();
            }
        }
        super.A19(formatArr, j);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final int A1C(MediaCodec mediaCodec, C0344Di di, Format format, Format format2) {
        if (!A0W(di.A03, format, format2) || format2.A0F > this.A0P.A02 || format2.A08 > this.A0P.A00 || A00(di, format2) > this.A0P.A01) {
            return 0;
        }
        return format.A0L(format2) ? 1 : 3;
    }

    /* JADX INFO: Multiple debug info for r7v0 java.lang.String: [D('i' int), D('decoderInfo' com.facebook.ads.redexgen.X.Di)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final int A1D(AbstractC0350Do r9, C4<Y7> c4, Format format) throws C0353Dr {
        int i;
        int i2;
        String str = format.A0O;
        int adaptiveSupport = 0;
        if (!IJ.A0C(str)) {
            return 0;
        }
        boolean z = false;
        DrmInitData drmInitData = format.A0H;
        if (drmInitData != null) {
            for (int i3 = 0; i3 < drmInitData.A01; i3++) {
                z |= drmInitData.A02(i3).A03;
            }
        }
        C0344Di A60 = r9.A60(str, z);
        String[] strArr = A0e;
        if (strArr[2].charAt(13) != strArr[0].charAt(13)) {
            String[] strArr2 = A0e;
            strArr2[7] = "kTnRYby1s";
            strArr2[1] = "UL9g0IqkI";
            boolean z2 = true;
            if (A60 == null) {
                if (!z || r9.A60(str, false) == null) {
                    return 1;
                }
                return 2;
            } else if (!AbstractC0313Cd.A0z(c4, drmInitData)) {
                return 2;
            } else {
                boolean A0J2 = A60.A0J(format.A0K);
                if (A0J2 && format.A0F > 0 && format.A08 > 0) {
                    if (C0466Ig.A02 >= 21) {
                        int i4 = format.A0F;
                        int i5 = format.A08;
                        if (A0e[3].charAt(18) != 'r') {
                            String[] strArr3 = A0e;
                            strArr3[6] = "jeBed4IeUvhTWXlMCWkd0HFF16tIjLHF";
                            strArr3[4] = "0qAO2CVMQ14qnLtRtzyjuYZeLu4NiNP0";
                            A0J2 = A60.A0I(i4, i5, (double) format.A01);
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        if (format.A0F * format.A08 > C0355Dt.A00()) {
                            z2 = false;
                        }
                        A0J2 = z2;
                        if (!A0J2) {
                            String str2 = A05(298, 29, 54) + format.A0F + A05(1379, 1, 65) + format.A08 + A05(856, 3, 97) + C0466Ig.A04 + A05(855, 1, 27);
                        }
                    }
                }
                if (A60.A03) {
                    i = 16;
                } else {
                    i = 8;
                }
                if (A60.A06) {
                    adaptiveSupport = 32;
                }
                if (A0J2) {
                    i2 = 4;
                } else {
                    i2 = 3;
                }
                return i | adaptiveSupport | i2;
            }
        } else {
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    @CallSuper
    public final void A1H() throws A4 {
        super.A1H();
        this.A04 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    @CallSuper
    public final void A1I() {
        try {
            super.A1I();
        } finally {
            this.A04 = 0;
            Surface surface = this.A0N;
            if (surface != null) {
                if (this.A0O == surface) {
                    this.A0O = null;
                }
                this.A0N.release();
                this.A0N = null;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    @CallSuper
    public final void A1L(long j) {
        this.A04--;
        while (true) {
            int i = this.A0A;
            if (i != 0 && j >= this.A0a[0]) {
                long[] jArr = this.A0Z;
                this.A0M = jArr[0];
                this.A0A = i - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.A0A);
                long[] jArr2 = this.A0a;
                System.arraycopy(jArr2, 1, jArr2, 0, this.A0A);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bc  */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A1M(android.media.MediaCodec r10, android.media.MediaFormat r11) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00711y.A1M(android.media.MediaCodec, android.media.MediaFormat):void");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1N(Format format) throws A4 {
        super.A1N(format);
        this.A0X.A04(format);
        this.A02 = format.A02;
        this.A0B = format.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    @CallSuper
    public final void A1O(C0861Xw xw) {
        this.A04++;
        this.A0K = Math.max(xw.A00, this.A0K);
        if (C0466Ig.A02 < 23 && this.A0S) {
            A1T();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1P(C0344Di di, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws C0353Dr {
        this.A0P = A04(di, format, A1B());
        MediaFormat A032 = A03(format, this.A0P, this.A0Y, this.A0G);
        if (this.A0O == null) {
            I1.A04(A0U(di));
            Surface surface = this.A0N;
            String[] strArr = A0e;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[6] = "HUdK6ej9G5uy2eoW8HL148MSYBaQJURn";
            strArr2[4] = "oyZJZuVgjRVeIXKioVrHS7OTGib3SAbN";
            if (surface == null) {
                this.A0N = DummySurface.A01(this.A0V, di.A05);
            }
            this.A0O = this.A0N;
        }
        mediaCodec.configure(A032, this.A0O, mediaCrypto, 0);
        if (C0466Ig.A02 >= 23 && this.A0S) {
            this.A00 = new C0475Ir(this, mediaCodec);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final void A1Q(String str, long j, long j2) {
        this.A0X.A07(str, j, j2);
        this.A0Q = A0V(str);
    }

    /* JADX INFO: Multiple debug info for r2v0 long: [D('earlyUs' long), D('unadjustedFrameReleaseTimeNs' long)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final boolean A1R(long unadjustedFrameReleaseTimeNs, long j, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long unadjustedFrameReleaseTimeNs2, boolean z) throws A4 {
        boolean z2;
        if (this.A0I == -9223372036854775807L) {
            this.A0I = unadjustedFrameReleaseTimeNs;
        }
        long unadjustedFrameReleaseTimeNs3 = unadjustedFrameReleaseTimeNs2 - this.A0M;
        if (z) {
            A0I(mediaCodec, i, unadjustedFrameReleaseTimeNs3);
            return true;
        }
        long j2 = unadjustedFrameReleaseTimeNs2 - unadjustedFrameReleaseTimeNs;
        Surface surface = this.A0O;
        Surface surface2 = this.A0N;
        String[] strArr = A0e;
        if (strArr[2].charAt(13) != strArr[0].charAt(13)) {
            String[] strArr2 = A0e;
            strArr2[2] = "tTKgXyDwmZTS9W3DU5UkyT40ENaKbHyT";
            strArr2[0] = "ymAWKg2GShyJej9UBV5xPoPh0gH7RDQq";
            if (surface != surface2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String[] strArr3 = A0e;
                if (strArr3[2].charAt(13) != strArr3[0].charAt(13)) {
                    String[] strArr4 = A0e;
                    strArr4[6] = "Tj6uZUYZuPZ7pCoRyZtHZtCub82IEIjs";
                    strArr4[4] = "wN6Cz1ZftXTKk8PfKKvkhZq0bAWp3Laf";
                    long j3 = elapsedRealtime * 1000;
                    if (A70() == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!this.A0R || (z2 && A0S(j2, j3 - this.A0L))) {
                        if (C0466Ig.A02 >= 21) {
                            long nanoTime = System.nanoTime();
                            String[] strArr5 = A0e;
                            if (strArr5[6].charAt(27) != strArr5[4].charAt(27)) {
                                String[] strArr6 = A0e;
                                strArr6[6] = "oWL9SRYwVyvR2JEBKybOkKnbuF7SsiRC";
                                strArr6[4] = "NzhSZMUYEy5Cfuxee7W6IeInRPwNjtL0";
                                A0J(mediaCodec, i, unadjustedFrameReleaseTimeNs3, nanoTime);
                                return true;
                            }
                            String[] strArr7 = A0e;
                            strArr7[3] = "41VA6FIKazuT7AmZNA03mPvHgUe4JG9W";
                            strArr7[3] = "41VA6FIKazuT7AmZNA03mPvHgUe4JG9W";
                            A0J(mediaCodec, i, unadjustedFrameReleaseTimeNs3, nanoTime);
                            return true;
                        }
                        A0H(mediaCodec, i, unadjustedFrameReleaseTimeNs3);
                        return true;
                    } else if (!z2 || unadjustedFrameReleaseTimeNs == this.A0I) {
                        return false;
                    } else {
                        long nanoTime2 = System.nanoTime();
                        long A082 = this.A0W.A08(unadjustedFrameReleaseTimeNs2, nanoTime2 + ((j2 - (j3 - j)) * 1000));
                        long adjustedReleaseTimeNs = (A082 - nanoTime2) / 1000;
                        if (A0Q(adjustedReleaseTimeNs, j) && A0T(mediaCodec, i, unadjustedFrameReleaseTimeNs3, unadjustedFrameReleaseTimeNs)) {
                            return false;
                        }
                        if (A0R(adjustedReleaseTimeNs, j)) {
                            A0G(mediaCodec, i, unadjustedFrameReleaseTimeNs3);
                            return true;
                        }
                        if (C0466Ig.A02 >= 21) {
                            if (adjustedReleaseTimeNs < 50000) {
                                A0J(mediaCodec, i, unadjustedFrameReleaseTimeNs3, A082);
                                return true;
                            }
                        } else if (adjustedReleaseTimeNs < 30000) {
                            if (adjustedReleaseTimeNs > 11000) {
                                try {
                                    Thread.sleep((adjustedReleaseTimeNs - TapjoyConstants.TIMER_INCREMENT) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            A0H(mediaCodec, i, unadjustedFrameReleaseTimeNs3);
                            return true;
                        }
                        return false;
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (!A0O(j2)) {
                return false;
            } else {
                A0I(mediaCodec, i, unadjustedFrameReleaseTimeNs3);
                return true;
            }
        } else {
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S
    public final boolean A1S(C0344Di di) {
        return this.A0O != null || A0U(di);
    }

    public final void A1T() {
        if (!this.A0R) {
            this.A0R = true;
            this.A0X.A03(this.A0O);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0313Cd, com.facebook.ads.redexgen.X.AZ
    public final void A7H(int i, Object obj) throws A4 {
        if (i == 1) {
            String[] strArr = A0e;
            if (strArr[2].charAt(13) != strArr[0].charAt(13)) {
                String[] strArr2 = A0e;
                strArr2[3] = "M4hKmbj6QiDhWM6pD0tSNqk85KgZRxnW";
                strArr2[3] = "M4hKmbj6QiDhWM6pD0tSNqk85KgZRxnW";
                A0M((Surface) obj);
                return;
            }
            throw new RuntimeException();
        } else if (i == 4) {
            this.A0F = ((Integer) obj).intValue();
            MediaCodec A1E = A1E();
            if (A1E != null) {
                A1E.setVideoScalingMode(this.A0F);
            }
        } else {
            super.A7H(i, obj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3S, com.facebook.ads.redexgen.X.AbstractC0844Xf
    public final boolean A7i() {
        Surface surface;
        if (super.A7i() && (this.A0R || (((surface = this.A0N) != null && this.A0O == surface) || A1E() == null || this.A0S))) {
            this.A0J = -9223372036854775807L;
            if (A0e[5].charAt(17) != 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[7] = "3PsRT4XFV";
            strArr[1] = "WWSFTmL3V";
            return true;
        } else if (this.A0J == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.A0J) {
                return true;
            }
            this.A0J = -9223372036854775807L;
            return false;
        }
    }
}
