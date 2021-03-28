package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.onesignal.NotificationBundleProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.Dt  reason: case insensitive filesystem */
public final class C0355Dt {
    public static int A00 = -1;
    public static byte[] A01;
    public static String[] A02;
    public static final SparseIntArray A03 = new SparseIntArray();
    public static final SparseIntArray A04 = new SparseIntArray();
    public static final C0344Di A05 = C0344Di.A01(A07(657, 22, 55));
    public static final HashMap<C0352Dq, List<C0344Di>> A06 = new HashMap<>();
    public static final Map<String, Integer> A07 = new HashMap();
    public static final Pattern A08 = Pattern.compile(A07(899, 10, 75));

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 79);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{-73, -65, -87, -79, -17, -22, -14, -11, -18, -19, -87, -3, -8, -87, -6, -2, -18, -5, 2, -87, -20, -22, -7, -22, -21, -14, -11, -14, -3, -14, -18, -4, -78, -115, -59, -73, -40, 10, 10, 12, 4, 0, 5, -2, -47, -73, -40, 29, 15, 13, 31, 28, 15, -46, -83, -58, -62, -58, -27, -43, -67, -67, -65, -64, -31, -33, -21, -32, -31, -18, -22, -40, -36, -41, -37, -105, -123, -119, -124, -119, -10, -28, -23, -29, -25, -78, -96, -91, -97, -92, -18, -31, -31, -37, -35, -107, -120, -120, -126, -123, -11, -24, -24, -30, -24, -53, -66, -66, -71, -66, -75, -69, -62, -77, -77, -75, -74, -41, -43, -31, -42, -41, -28, -16, -10, -3, -18, -6, -1, -5, -17, -15, 18, 16, 28, 17, 18, 31, -80, -74, -67, -70, -67, -96, -79, -46, -48, -36, -47, -46, -33, -76, -70, -63, -57, -32, -29, -45, -38, -28, -75, -42, -44, -32, -43, -42, -29, -77, -50, -42, -39, -46, -47, -115, -31, -36, -115, -34, -30, -46, -33, -26, -115, -48, -36, -47, -46, -48, -115, -7, -30, -29, -31, -55, -78, -77, -76, -70, -93, -89, -94, -4, -27, -23, -25, -93, -116, -112, -111, 10, -13, -6, -14, -71, -94, -87, -92, -16, -39, -32, -34, -5, -26, -29, -10, -28, -34, -48, -66, -69, 18, 3, -6, -47, -62, -68, -86, -81, 11, 41, 48, 49, 52, 43, 48, 41, -30, 47, 35, 46, 40, 49, 52, 47, 39, 38, -30, 3, 24, 5, -30, 37, 49, 38, 39, 37, -30, 53, 54, 52, 43, 48, 41, -4, -30, -36, -6, 1, 2, 5, -4, 1, -6, -77, 0, -12, -1, -7, 2, 5, 0, -8, -9, -77, -37, -40, -23, -42, -77, -10, 2, -9, -8, -10, -77, 6, 7, 5, -4, 1, -6, -51, -77, -34, -61, -60, -62, -78, -105, -104, -103, -24, -51, -47, -52, -82, -109, -105, -107, -17, -44, -40, -39, -70, -97, -90, -98, -66, -93, -86, -91, -81, -108, -101, -103, -42, -67, -70, 4, -21, -18, 32, -93, -115, -121, -21, -43, -46, -37, -56, -65, -15, -34, -40, -62, -59, -88, -71, -38, -40, -28, -39, -38, -25, 7, 31, 30, 35, 27, -3, 41, 30, 31, 29, 6, 35, 45, 46, -38, -5, 10, 3, -38, 30, 35, 30, 40, -31, 46, -38, 38, 35, 45, 46, -38, 45, 31, 29, 47, 44, 31, -38, 30, 31, 29, 41, 30, 31, 44, -38, 32, 41, 44, -12, -38, -28, -4, -5, 0, -8, -38, 6, -5, -4, -6, -20, 11, 0, 3, -91, -68, -49, -52, -54, 119, -120, -121, -10, -21, -7, -10, -16, -21, -44, -1, -4, -38, -77, -79, -68, -110, -87, -36, -35, -46, -45, -41, -110, -91, -91, -89, -110, -88, -55, -57, -45, -56, -55, -42, 25, 23, 34, -8, 15, 66, 67, 56, 57, 61, -8, 11, 32, 13, -8, 14, 47, 45, 57, 46, 47, 60, 21, 19, 30, -12, 11, 62, 63, 52, 53, 57, -12, 7, 28, 9, -12, 10, 43, 41, 53, 42, 43, 56, -12, 57, 43, 41, 59, 56, 43, 3, 1, 12, -30, 1, 8, -1, -30, -11, 9, -8, -3, 3, -30, -8, -7, -9, 3, -8, -7, 6, -30, -11, -11, -9, -20, -22, -11, -53, -22, -15, -24, -53, -34, -14, -31, -26, -20, -53, -31, -30, -32, -20, -31, -30, -17, -53, -31, -16, -19, -34, -32, -48, -38, -40, -29, -71, -40, -33, -42, -71, -52, -32, -49, -44, -38, -71, -49, -48, -50, -38, -49, -48, -35, -71, -35, -52, -30, -23, -25, -14, -56, -19, -33, -35, -56, -25, -22, -51, -56, -34, -1, -3, 9, -2, -1, 12, -61, -63, -52, -94, -57, -71, -73, -94, -43, -43, -41, -94, -40, -39, -41, -89, -91, -80, -122, -85, -99, -101, -122, -50, -56, -112, -122, -68, -67, -69, -43, -45, -34, -76, -19, -11, -11, -19, -14, -21, -76, -8, -25, -3, -76, -22, -21, -23, -11, -22, -21, -8, 24, 22, 33, -9, 58, 44, 56, 54, -9, 42, 62, 45, 50, 56, -9, 45, 46, 44, 56, 45, 46, 59, -9, 42, 42, 44, -87, -89, -78, -120, -53, -67, -55, -57, -120, -69, -49, -66, -61, -55, -120, -66, -65, -67, -55, -66, -65, -52, -120, -57, -54, -115, -84, -86, -75, -117, -50, -64, -52, -54, -117, -45, -58, -63, -62, -52, -117, -63, -62, -64, -52, -63, -62, -49, -117, -45, -51, -107, -51, -67, -89, -86, -82, -63, -67, -83, -105, -102, -97, -79, 33, 17, 36, 1, -1, 5, 1, -33, -30, -28, -9, -21, 3, 1, 8, 8, 1, 6, -1, -72, -5, 7, -4, -3, -5, -72, -20, 5, 2, 5, 6, 14, 5, -73, -40, -19, -38, -73, 3, -4, 13, -4, 3, -47, -73, -78, -53, -56, -53, -52, -44, -53, 125, -98, -77, -96, 125, -51, -49, -52, -61, -58, -55, -62, -105, 125, 23, 48, 45, 48, 49, 57, 48, -30, 10, 7, 24, 5, -30, 46, 39, 56, 39, 46, -30, 53, 54, 52, 43, 48, 41, -4, -30, -30, -5, -8, -5, -4, 4, -5, -83, -43, -46, -29, -48, -83, -3, -1, -4, -13, -10, -7, -14, -83, 0, 1, -1, -10, -5, -12, -57, -83, -37, -20, -28, -14, -16, -20, -2, -48, -8, -10, -34, -39, -62, -10, -2, -59, -61, -66, 11, -31, -38, 34, 54, 37, 42, 48, -16, 38, 34, 36, -12, -56, -36, -53, -48, -42, -106, -52, -56, -54, -102, -108, -47, -42, -54, 38, 59, 40, -10, 9, 30, 11, -38, -15, -65, -32, -24, -12, -15, -4, -6, -6, -44, -47, -30, -99, -7, 7, -12, -62, 7, 3, 9, 17, 2, 25, 13, 30, 21, 26, 17, 24, 32, 17, 13, 32, 32, 52, 54, 51, 56, 51, 57, -30, -48, -36, -30, -28, -35, -42, -52, -70, -57, -51, -56, -52, 15, 1, 14, 14, -3, 10, 11, 27, -41, -42, -55, -60, -59, -49, -113, -63, -42, -61, 25, 12, 15, 15, 8, 57, 44, 47, 47, 40, 38, -11, 7, -6, -3, -3, -10, 1, -3, 6, 4, -41, -62, -53, -55, -47, -62, 55, 34, 47, 44, 35, 41, 49, 34, 51, 30, 43, 40, 37, 45, 30};
    }

    public static void A0B() {
        A02 = new String[]{"PUk6Ycp3IyZuDM2vxEClNB7s", "Cor2Bf7UAjKBCW6KQ3kJAY2", "tBvhUMYEWbjuF5bg8fuW6r", NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON, "", "fIpZ4gAxwncTaI4Qx56KLzmZZ7uUPeai", "EGElOHn6uGhmkRxS9uXWLb9eFH9So4cV", "7k7mDGZCg"};
    }

    static {
        A0B();
        A0A();
        A04.put(66, 1);
        A04.put(77, 2);
        A04.put(88, 4);
        A04.put(100, 8);
        A03.put(10, 1);
        A03.put(11, 4);
        A03.put(12, 8);
        A03.put(13, 16);
        A03.put(20, 32);
        A03.put(21, 64);
        A03.put(22, 128);
        A03.put(30, 256);
        A03.put(31, 512);
        A03.put(32, 1024);
        A03.put(40, 2048);
        A03.put(41, 4096);
        A03.put(42, 8192);
        A03.put(50, 16384);
        A03.put(51, 32768);
        A03.put(52, 65536);
        A07.put(A07(345, 3, 59), 1);
        A07.put(A07(352, 3, 8), 4);
        A07.put(A07(355, 3, 80), 16);
        A07.put(A07(358, 3, 64), 64);
        A07.put(A07(361, 3, 86), 256);
        A07.put(A07(313, 4, 67), 1024);
        A07.put(A07(317, 4, 23), 4096);
        A07.put(A07(321, 4, 77), 16384);
        A07.put(A07(325, 4, 19), 65536);
        A07.put(A07(329, 4, 84), 262144);
        A07.put(A07(333, 4, 31), 1048576);
        A07.put(A07(337, 4, 35), 4194304);
        A07.put(A07(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 4, 20), 16777216);
        A07.put(A07(221, 3, 100), 2);
        A07.put(A07(224, 3, 95), 8);
        A07.put(A07(227, 3, 57), 32);
        A07.put(A07(230, 3, 123), 128);
        A07.put(A07(233, 3, 58), 512);
        A07.put(A07(189, 4, 98), 2048);
        A07.put(A07(193, 4, 50), 8192);
        A07.put(A07(197, 4, 35), 32768);
        A07.put(A07(201, 4, 101), 131072);
        A07.put(A07(205, 4, 12), 524288);
        A07.put(A07(209, 4, 115), 2097152);
        A07.put(A07(213, 4, 34), 8388608);
        A07.put(A07(JfifUtil.MARKER_EOI, 4, 89), 33554432);
    }

    public static int A00() throws C0353Dr {
        int i;
        if (A00 == -1) {
            int i2 = 0;
            C0344Di A062 = A06(A07(1006, 9, 17), false);
            if (A062 != null) {
                MediaCodecInfo.CodecProfileLevel[] A0K = A062.A0K();
                String[] strArr = A02;
                if (strArr[6].charAt(20) != strArr[5].charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "KZ3htwrCZaN4pnqbUvwqLO4F2z8ifUlK";
                strArr2[5] = "b2BkF0yBOqWKoYmDncjILGp6agQJiwPk";
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : A0K) {
                    i2 = Math.max(A01(codecProfileLevel.level), i2);
                }
                if (C0466Ig.A02 >= 21) {
                    i = 345600;
                } else {
                    i = 172800;
                }
                i2 = Math.max(i2, i);
            }
            A00 = i2;
        }
        return A00;
    }

    public static int A01(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        if (r7.equals(A07(953, 4, 29)) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A02(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dt.A02(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00df, code lost:
        if (r0 == -1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0102, code lost:
        if (r0 == -1) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        return new android.util.Pair<>(java.lang.Integer.valueOf(r6), java.lang.Integer.valueOf(r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A03(java.lang.String r11, java.lang.String[] r12) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dt.A03(java.lang.String, java.lang.String[]):android.util.Pair");
    }

    public static Pair<Integer, Integer> A04(String str, String[] strArr) {
        int i;
        int length = strArr.length;
        String A072 = A07(275, 38, 68);
        String A073 = A07(425, 14, 72);
        if (length < 4) {
            Log.w(A073, A072 + str);
            return null;
        }
        Matcher matcher = A08.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(A073, A072 + str);
            return null;
        }
        String group = matcher.group(1);
        if (A07(53, 1, 82).equals(group)) {
            i = 1;
        } else if (A07(54, 1, 44).equals(group)) {
            i = 2;
        } else {
            Log.w(A073, A07(862, 29, 62) + group);
            return null;
        }
        Integer num = A07.get(strArr[3]);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.w(A073, A07(835, 27, 115) + matcher.group(1));
        return null;
    }

    public static C0344Di A05() {
        return A05;
    }

    @Nullable
    public static C0344Di A06(String str, boolean z) throws C0353Dr {
        List<C0344Di> A09 = A09(str, z);
        if (A09.isEmpty()) {
            return null;
        }
        return A09.get(0);
    }

    /* JADX INFO: Multiple debug info for r17v0 java.util.ArrayList<com.facebook.ads.redexgen.X.Di>: [D('secureDecodersExplicit' boolean), D('secure' boolean)] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r18.A01 != r4) goto L_0x004e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[ADDED_TO_REGION, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.facebook.ads.redexgen.X.C0344Di> A08(com.facebook.ads.redexgen.X.C0352Dq r18, com.facebook.ads.redexgen.X.AbstractC0354Ds r19, java.lang.String r20) throws com.facebook.ads.redexgen.X.C0353Dr {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dt.A08(com.facebook.ads.redexgen.X.Dq, com.facebook.ads.redexgen.X.Ds, java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: Multiple debug info for r0v11 java.util.ArrayList<com.facebook.ads.redexgen.X.Di>: [D('eac3Key' com.facebook.ads.redexgen.X.Dq), D('eac3DecoderInfos' java.util.ArrayList<com.facebook.ads.internal.exoplayer2.mediacodec.MediaCodecInfo>)] */
    public static synchronized List<C0344Di> A09(String str, boolean z) throws C0353Dr {
        AbstractC0354Ds zi;
        synchronized (C0355Dt.class) {
            C0352Dq dq = new C0352Dq(str, z);
            List<C0344Di> list = A06.get(dq);
            if (list != null) {
                return list;
            }
            if (C0466Ig.A02 >= 21) {
                zi = new ZJ(z);
            } else {
                zi = new ZI();
            }
            ArrayList<C0344Di> A082 = A08(dq, zi, str);
            if (z && A082.isEmpty() && 21 <= C0466Ig.A02 && C0466Ig.A02 <= 23) {
                zi = new ZI();
                A082 = A08(dq, zi, str);
                if (!A082.isEmpty()) {
                    String A072 = A07(425, 14, 72);
                    Log.w(A072, A07(374, 51, 107) + str + A07(34, 12, 72) + A082.get(0).A02);
                }
            }
            if (A07(922, 14, 24).equals(str)) {
                A082.addAll(A08(new C0352Dq(A07(912, 10, 114), dq.A01), zi, str));
            }
            A0C(A082);
            List<C0344Di> unmodifiableList = Collections.unmodifiableList(A082);
            A06.put(dq, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static void A0C(List<C0344Di> list) {
        if (C0466Ig.A02 < 26 && list.size() > 1) {
            if (A07(583, 25, 60).equals(list.get(0).A02)) {
                int i = 1;
                while (true) {
                    int size = list.size();
                    String[] strArr = A02;
                    if (strArr[2].length() != strArr[3].length()) {
                        String[] strArr2 = A02;
                        strArr2[2] = "0x3TFANg8Ut6JiiOQttPnD";
                        strArr2[3] = NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON;
                        if (i < size) {
                            C0344Di di = list.get(i);
                            if (A07(657, 22, 55).equals(di.A02)) {
                                list.remove(i);
                                list.add(0, di);
                                return;
                            }
                            i++;
                        } else {
                            return;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x036c, code lost:
        if (A07(769, 5, 127).equals(com.facebook.ads.redexgen.X.C0466Ig.A03) != false) goto L_0x036e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x037b, code lost:
        if (r4 < 24) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009b, code lost:
        if (A07(364, 10, 38).equals(r8) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011e, code lost:
        if (r3 != false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012d, code lost:
        if (r3 != false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x022e, code lost:
        if (A07(774, 6, 99).equals(com.facebook.ads.redexgen.X.C0466Ig.A03) != false) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x028c, code lost:
        if (A07(85, 5, 32).equals(com.facebook.ads.redexgen.X.C0466Ig.A03) != false) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ba, code lost:
        if (r4 < 24) goto L_0x02bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0D(android.media.MediaCodecInfo r7, java.lang.String r8, boolean r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 1106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dt.A0D(android.media.MediaCodecInfo, java.lang.String, boolean, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004e, code lost:
        if (A07(439, 8, 8).equals(r3) != false) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0E(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0355Dt.A0E(java.lang.String):boolean");
    }
}
