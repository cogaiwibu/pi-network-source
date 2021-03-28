package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class AR extends AbstractC0940aR {
    public static byte[] A02;
    public static String[] A03;
    public static final int[] A04 = new int[0];
    @Nullable
    public final H7 A00;
    public final AtomicReference<DefaultTrackSelector$Parameters> A01;

    public static String A0C(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 92);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        if (A03[6].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "oTI";
        strArr[6] = "oTI";
        A02 = new byte[]{-26, -33, -43};
    }

    public static void A0F() {
        A03 = new String[]{"1W0E1A", "gmqFy6ZQaP5ka1WITOse6lKCqSKhRNov", "yPEYbIXQTZij2dUvfHyn6qa5Z66I89l5", "Xhoxo0MeXbgag07m9diWTgmUhgioDUlF", "BIkkp", "x2Y7ova5yP2MY4Z3NAONKiEwX", "ON8", "BctZyAj3hw00k98sEs0CoZ2k5"};
    }

    static {
        A0F();
        A0E();
    }

    public AR() {
        this(null);
    }

    public AR(@Nullable H7 h7) {
        this.A00 = h7;
        this.A01 = new AtomicReference<>(DefaultTrackSelector$Parameters.A0J);
    }

    public static int A00(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static int A01(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static int A03(TrackGroup trackGroup, int[] iArr, int i, @Nullable String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            Integer num = list.get(i6);
            if (A03[2].charAt(31) != 'o') {
                String[] strArr = A03;
                strArr[7] = "3Iv8b3o73oRbqkF65Z5c5dFgz";
                strArr[5] = "e7BsWd0zc9qEfvrmMSkcTfHGf";
                int intValue = num.intValue();
                if (A0M(trackGroup.A02(intValue), str, iArr[intValue], i, i2, i3, i4)) {
                    i5++;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return i5;
    }

    public static int A04(TrackGroup trackGroup, int[] iArr, C0432Gy gy) {
        int i = 0;
        for (int i2 = 0; i2 < trackGroup.A01; i2++) {
            if (A0K(trackGroup.A02(i2), iArr[i2], gy)) {
                i++;
            }
        }
        return i;
    }

    public static Point A05(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        if (z) {
            boolean z3 = true;
            if (i3 > i4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i <= i2) {
                z3 = false;
            }
            if (z2 != z3) {
                i = i2;
                i2 = i;
            }
        }
        int tempViewportWidth = i3 * i2;
        int i5 = i4 * i;
        if (A03[2].charAt(31) != 'o') {
            String[] strArr = A03;
            strArr[6] = "nfw";
            strArr[6] = "nfw";
            if (tempViewportWidth >= i5) {
                return new Point(i, C0466Ig.A04(i * i4, i3));
            }
            return new Point(C0466Ig.A04(i2 * i3, i4), i2);
        }
        throw new RuntimeException();
    }

    @Nullable
    private final H8 A06(int i, TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws A4 {
        boolean z;
        TrackGroup trackGroup = null;
        int trackIndex = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = trackGroupArray.A01;
            if (A03[3].charAt(2) != 'E') {
                String[] strArr = A03;
                strArr[3] = "VerUiBJDpf251zcJKkmQW7r5SVlKN9oM";
                strArr[3] = "VerUiBJDpf251zcJKkmQW7r5SVlKN9oM";
                if (i3 < i4) {
                    TrackGroup A022 = trackGroupArray.A02(i3);
                    int[] iArr2 = iArr[i3];
                    for (int i5 = 0; i5 < A022.A01; i5++) {
                        if (A0I(iArr2[i5], defaultTrackSelector$Parameters.A0B)) {
                            int i6 = 1;
                            if ((A022.A02(i5).A0D & 1) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                i6 = 2;
                            }
                            if (A0I(iArr2[i5], false)) {
                                i6 += 1000;
                            }
                            if (i6 > i2) {
                                trackGroup = A022;
                                trackIndex = i5;
                                i2 = i6;
                            }
                        }
                    }
                    i3++;
                } else if (trackGroup == null) {
                    return null;
                } else {
                    return new AQ(trackGroup, trackIndex);
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Nullable
    public static H8 A07(TrackGroupArray trackGroupArray, int[][] iArr, int requiredAdaptiveSupport, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, H7 h7) throws A4 {
        int i;
        boolean z;
        if (defaultTrackSelector$Parameters.A0A) {
            i = 24;
        } else {
            i = 16;
        }
        if (!defaultTrackSelector$Parameters.A09 || (requiredAdaptiveSupport & i) == 0) {
            z = false;
        } else {
            z = true;
        }
        for (int i2 = 0; i2 < trackGroupArray.A01; i2++) {
            TrackGroup A022 = trackGroupArray.A02(i2);
            int[] A0P = A0P(A022, iArr[i2], z, i, defaultTrackSelector$Parameters.A03, defaultTrackSelector$Parameters.A02, defaultTrackSelector$Parameters.A01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            if (A0P.length > 0) {
                return ((H7) I1.A01(h7)).A4T(A022, A0P);
            }
        }
        return null;
    }

    @Nullable
    private final H8 A08(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable H7 h7) throws A4 {
        int trackIndex = -1;
        int i2 = -1;
        C0433Gz trackScore = null;
        for (int i3 = 0; i3 < trackGroupArray.A01; i3++) {
            TrackGroup A022 = trackGroupArray.A02(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < A022.A01; i4++) {
                if (A0I(iArr2[i4], defaultTrackSelector$Parameters.A0B)) {
                    C0433Gz gz = new C0433Gz(A022.A02(i4), defaultTrackSelector$Parameters, iArr2[i4]);
                    if (trackScore == null || gz.compareTo(trackScore) > 0) {
                        i2 = i3;
                        trackIndex = i4;
                        trackScore = gz;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        TrackGroup A023 = trackGroupArray.A02(i2);
        if (!defaultTrackSelector$Parameters.A0D && h7 != null) {
            int[] A0O = A0O(A023, iArr[i2], defaultTrackSelector$Parameters.A09);
            if (A0O.length > 0) {
                return h7.A4T(A023, A0O);
            }
        }
        return new AQ(A023, trackIndex);
    }

    @Nullable
    private final H8 A09(TrackGroupArray trackGroupArray, int[][] iArr, int i, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable H7 h7) throws A4 {
        H8 h8 = null;
        if (!defaultTrackSelector$Parameters.A0D && h7 != null) {
            h8 = A07(trackGroupArray, iArr, i, defaultTrackSelector$Parameters, h7);
        }
        if (h8 == null) {
            return A0A(trackGroupArray, iArr, defaultTrackSelector$Parameters);
        }
        return h8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        if (r3 <= r2) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cf, code lost:
        if (r1 <= r20.A01) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (r1 <= r20.A01) goto L_0x00d1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00d8 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.redexgen.X.H8 A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r18, int[][] r19, com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters r20) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AR.A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray, int[][], com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.facebook.ads.redexgen.X.H8");
    }

    @Nullable
    private final H8 A0B(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws A4 {
        boolean z;
        int i;
        int i2;
        TrackGroup trackGroup = null;
        int i3 = 0;
        int trackIndex = 0;
        for (int i4 = 0; i4 < trackGroupArray.A01; i4++) {
            TrackGroup A022 = trackGroupArray.A02(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < A022.A01; i5++) {
                if (A0I(iArr2[i5], defaultTrackSelector$Parameters.A0B)) {
                    Format A023 = A022.A02(i5);
                    int i6 = A023.A0D & (defaultTrackSelector$Parameters.A00 ^ -1);
                    boolean z2 = true;
                    if ((i6 & 1) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if ((i6 & 2) == 0) {
                        z2 = false;
                    }
                    boolean A0L = A0L(A023, defaultTrackSelector$Parameters.A08);
                    if (A0L || (defaultTrackSelector$Parameters.A0E && A0J(A023))) {
                        if (z) {
                            i2 = 8;
                        } else if (!z2) {
                            i2 = 6;
                        } else {
                            i2 = 4;
                        }
                        i = i2 + (A0L ? 1 : 0);
                    } else if (z) {
                        i = 3;
                    } else if (!z2) {
                        continue;
                    } else if (A0L(A023, defaultTrackSelector$Parameters.A07)) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    if (A0I(iArr2[i5], false)) {
                        i += 1000;
                    }
                    if (i > trackIndex) {
                        trackGroup = A022;
                        i3 = i5;
                        if (A03[6].length() != 3) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[2] = "ytO6VNlSXI4nyu5127ZVkMBSWij4cMOM";
                        strArr[2] = "ytO6VNlSXI4nyu5127ZVkMBSWij4cMOM";
                        trackIndex = i;
                    } else {
                        continue;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new AQ(trackGroup, i3);
    }

    public static List<Integer> A0D(TrackGroup trackGroup, int i, int maxVideoPixelsToRetain, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.A01);
        for (int i2 = 0; i2 < trackGroup.A01; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (i == Integer.MAX_VALUE || maxVideoPixelsToRetain == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < trackGroup.A01; i4++) {
            Format A022 = trackGroup.A02(i4);
            if (A022.A0F > 0) {
                int i5 = A022.A08;
                if (A03[3].charAt(2) != 'E') {
                    String[] strArr = A03;
                    strArr[2] = "kSz4FX5ZHsEkHeXGD1Cn3cbmsF2hLdtD";
                    strArr[2] = "kSz4FX5ZHsEkHeXGD1Cn3cbmsF2hLdtD";
                    if (i5 > 0) {
                        Point A05 = A05(z, i, maxVideoPixelsToRetain, A022.A0F, A022.A08);
                        int i6 = A022.A0F * A022.A08;
                        if (A022.A0F >= ((int) (((float) A05.x) * 0.98f)) && A022.A08 >= ((int) (((float) A05.y) * 0.98f)) && i6 < i3) {
                            i3 = i6;
                        }
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int A0F = trackGroup.A02(((Integer) arrayList.get(size)).intValue()).A0F();
                if (A0F == -1 || A0F > i3) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public static void A0G(TrackGroup trackGroup, int[] iArr, int trackIndex, @Nullable String str, int i, int i2, int i3, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!A0M(trackGroup.A02(intValue), str, iArr[intValue], trackIndex, i, i2, i3)) {
                list.remove(size);
            }
        }
    }

    public static void A0H(H6 h6, int[][][] iArr, C0271Ad[] adArr, H8[] h8Arr, int rendererType) {
        boolean z;
        if (rendererType != 0) {
            int i = -1;
            int i2 = -1;
            if (A03[1].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "rTjwD";
            strArr[0] = "uX38vm";
            boolean z2 = true;
            int i3 = 0;
            while (true) {
                z = true;
                if (i3 >= h6.A00()) {
                    break;
                }
                int A012 = h6.A01(i3);
                H8 h8 = h8Arr[i3];
                if ((A012 == 1 || A012 == 2) && h8 != null && A0N(iArr[i3], h6.A02(i3), h8)) {
                    if (A012 == 1) {
                        if (i != -1) {
                            z2 = false;
                            break;
                        }
                        i = i3;
                    } else if (i2 != -1) {
                        z2 = false;
                        break;
                    } else {
                        i2 = i3;
                    }
                }
                i3++;
            }
            if (i == -1 || i2 == -1) {
                z = false;
            }
            boolean z3 = z2 & z;
            if (A03[3].charAt(2) != 'E') {
                String[] strArr2 = A03;
                strArr2[4] = "aY4hR";
                strArr2[0] = "2v7HMH";
                if (!z3) {
                    return;
                }
            } else if (!z3) {
                return;
            }
            C0271Ad ad = new C0271Ad(rendererType);
            adArr[i] = ad;
            adArr[i2] = ad;
        }
    }

    public static boolean A0I(int i, boolean z) {
        int maskedSupport = i & 7;
        return maskedSupport == 4 || (z && maskedSupport == 3);
    }

    public static boolean A0J(Format format) {
        return TextUtils.isEmpty(format.A0N) || A0L(format, A0C(0, 3, 21));
    }

    public static boolean A0K(Format format, int i, C0432Gy gy) {
        if (!A0I(i, false) || format.A05 != gy.A00 || format.A0C != gy.A01) {
            return false;
        }
        if (gy.A02 == null || TextUtils.equals(gy.A02, format.A0O)) {
            return true;
        }
        return false;
    }

    public static boolean A0L(Format format, @Nullable String str) {
        return str != null && TextUtils.equals(str, C0466Ig.A0L(format.A0N));
    }

    public static boolean A0M(Format format, @Nullable String str, int i, int i2, int i3, int i4, int i5) {
        if (!A0I(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !C0466Ig.A0h(format.A0O, str)) {
            return false;
        }
        if (format.A0F != -1 && format.A0F > i3) {
            return false;
        }
        if (format.A08 != -1 && format.A08 > i4) {
            return false;
        }
        if (format.A04 != -1) {
            int i6 = format.A04;
            if (A03[2].charAt(31) != 'o') {
                String[] strArr = A03;
                strArr[2] = "FNCbzyr7QyRP3SA06TqNXuxS80zpa9Bi";
                strArr[2] = "FNCbzyr7QyRP3SA06TqNXuxS80zpa9Bi";
                if (i6 <= i5) {
                    return true;
                }
                return false;
            }
            throw new RuntimeException();
        }
        return true;
    }

    public static boolean A0N(int[][] iArr, TrackGroupArray trackGroupArray, H8 h8) {
        if (h8 == null) {
            return false;
        }
        int A012 = trackGroupArray.A01(h8.A78());
        if (A03[2].charAt(31) != 'o') {
            String[] strArr = A03;
            strArr[1] = "tyUFTMgWRFIbU9oMa0yVOFtav5LFL8C4";
            strArr[1] = "tyUFTMgWRFIbU9oMa0yVOFtav5LFL8C4";
            for (int i = 0; i < h8.length(); i++) {
                if ((iArr[A012][h8.A6O(i)] & 32) != 32) {
                    return false;
                }
            }
            if (A03[2].charAt(31) != 'o') {
                String[] strArr2 = A03;
                strArr2[4] = "AvWfp";
                strArr2[0] = "jnm8oH";
                return true;
            }
            String[] strArr3 = A03;
            strArr3[3] = "hBflC2WcQfSqXI4XtpzFNLmvHBtesKLi";
            strArr3[3] = "hBflC2WcQfSqXI4XtpzFNLmvHBtesKLi";
            return true;
        }
        throw new RuntimeException();
    }

    public static int[] A0O(TrackGroup trackGroup, int[] iArr, boolean z) {
        String str;
        int A042;
        int i = 0;
        C0432Gy gy = null;
        HashSet hashSet = new HashSet();
        int configurationCount = 0;
        while (true) {
            if (configurationCount < trackGroup.A01) {
                Format A022 = trackGroup.A02(configurationCount);
                int i2 = A022.A05;
                int i3 = A022.A0C;
                if (z) {
                    str = null;
                } else {
                    str = A022.A0O;
                }
                C0432Gy gy2 = new C0432Gy(i2, i3, str);
                String[] strArr = A03;
                if (strArr[4].length() == strArr[0].length()) {
                    break;
                }
                String[] strArr2 = A03;
                strArr2[6] = "SWl";
                strArr2[6] = "SWl";
                if (hashSet.add(gy2) && (A042 = A04(trackGroup, iArr, gy2)) > i) {
                    gy = gy2;
                    i = A042;
                }
                configurationCount++;
            } else if (i <= 1) {
                return A04;
            } else {
                int[] adaptiveIndices = new int[i];
                if (A03[1].charAt(3) == 'F') {
                    String[] strArr3 = A03;
                    strArr3[2] = "ndqJYBN4kzCrcISGfJ6gLQAVvTseYRAq";
                    strArr3[2] = "ndqJYBN4kzCrcISGfJ6gLQAVvTseYRAq";
                    int index = 0;
                    for (int i4 = 0; i4 < trackGroup.A01; i4++) {
                        if (A0K(trackGroup.A02(i4), iArr[i4], (C0432Gy) I1.A01(gy))) {
                            adaptiveIndices[index] = i4;
                            index++;
                        }
                    }
                    return adaptiveIndices;
                }
            }
        }
        throw new RuntimeException();
    }

    public static int[] A0P(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int trackIndex, int i4, int i5, boolean z2) {
        int A032;
        if (trackGroup.A01 < 2) {
            return A04;
        }
        List<Integer> A0D = A0D(trackGroup, i4, i5, z2);
        if (A0D.size() < 2) {
            return A04;
        }
        String str = null;
        if (!z) {
            HashSet hashSet = new HashSet();
            int i6 = 0;
            for (int selectedMimeTypeTrackCount = 0; selectedMimeTypeTrackCount < A0D.size(); selectedMimeTypeTrackCount++) {
                String str2 = trackGroup.A02(A0D.get(selectedMimeTypeTrackCount).intValue()).A0O;
                if (hashSet.add(str2) && (A032 = A03(trackGroup, iArr, i, str2, i2, i3, trackIndex, A0D)) > i6) {
                    if (A03[3].charAt(2) != 'E') {
                        String[] strArr = A03;
                        strArr[7] = "YYn4Z0UW1tJYYEwj5MQ7L1Rhi";
                        strArr[5] = "BvRHCOG0R11gnbm1vcetrlVSM";
                        str = str2;
                        i6 = A032;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
        A0G(trackGroup, iArr, i, str, i2, i3, trackIndex, A0D);
        return A0D.size() < 2 ? A04 : C0466Ig.A0k(A0D);
    }

    private final H8[] A0Q(H6 h6, int[][][] iArr, int[] iArr2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws A4 {
        H7 h7;
        boolean z;
        int A002 = h6.A00();
        H8[] h8Arr = new H8[A002];
        boolean seenVideoRendererWithMappedTracks = false;
        int i = 0;
        for (int i2 = 0; i2 < A002; i2++) {
            int A012 = h6.A01(i2);
            if (A03[2].charAt(31) != 'o') {
                String[] strArr = A03;
                strArr[2] = "HeTTodjeOHNf6YJV3Oi2xZW4zDR7myJi";
                strArr[2] = "HeTTodjeOHNf6YJV3Oi2xZW4zDR7myJi";
                if (2 == A012) {
                    if (i == 0) {
                        z = true;
                        h8Arr[i2] = A09(h6.A02(i2), iArr[i2], iArr2[i2], defaultTrackSelector$Parameters, this.A00);
                        if (h8Arr[i2] != null) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                        z = true;
                    }
                    if (h6.A02(i2).A01 <= 0) {
                        z = false;
                    }
                    seenVideoRendererWithMappedTracks |= z;
                }
            } else {
                throw new RuntimeException();
            }
        }
        boolean z2 = false;
        int i3 = 0;
        if (A03[3].charAt(2) != 'E') {
            String[] strArr2 = A03;
            strArr2[2] = "aVwUyHxCeGesw16VUIJPDtFnHPxsnnXC";
            strArr2[2] = "aVwUyHxCeGesw16VUIJPDtFnHPxsnnXC";
            for (int i4 = 0; i4 < A002; i4++) {
                int A013 = h6.A01(i4);
                if (A013 != 1) {
                    if (A013 != 2) {
                        if (A013 != 3) {
                            h8Arr[i4] = A06(A013, h6.A02(i4), iArr[i4], defaultTrackSelector$Parameters);
                        } else if (i3 == 0) {
                            h8Arr[i4] = A0B(h6.A02(i4), iArr[i4], defaultTrackSelector$Parameters);
                            i3 = h8Arr[i4] != null ? 1 : 0;
                        }
                    }
                } else if (!z2) {
                    TrackGroupArray A022 = h6.A02(i4);
                    int[][] iArr3 = iArr[i4];
                    int i5 = iArr2[i4];
                    if (seenVideoRendererWithMappedTracks) {
                        h7 = null;
                    } else {
                        h7 = this.A00;
                    }
                    h8Arr[i4] = A08(A022, iArr3, i5, defaultTrackSelector$Parameters, h7);
                    if (h8Arr[i4] != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            return h8Arr;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Multiple debug info for r5v0 int: [D('rendererTrackGroups' com.facebook.ads.internal.exoplayer2.source.TrackGroupArray), D('i' int)] */
    /* JADX INFO: Multiple debug info for r4v0 com.facebook.ads.redexgen.X.H8[]: [D('override' com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride), D('forceRendererDisabled' boolean)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0940aR
    public final Pair<C0271Ad[], H8[]> A0X(H6 h6, int[][][] iArr, int[] iArr2) throws A4 {
        boolean z;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.A01.get();
        int i = h6.A00();
        H8[] A0Q = A0Q(h6, iArr, iArr2, defaultTrackSelector$Parameters);
        for (int i2 = 0; i2 < i; i2++) {
            if (defaultTrackSelector$Parameters.A07(i2)) {
                A0Q[i2] = null;
            } else {
                TrackGroupArray A022 = h6.A02(i2);
                if (defaultTrackSelector$Parameters.A08(i2, A022)) {
                    DefaultTrackSelector$SelectionOverride A06 = defaultTrackSelector$Parameters.A06(i2, A022);
                    if (A06 == null) {
                        A0Q[i2] = null;
                    } else if (A06.A01 == 1) {
                        A0Q[i2] = new AQ(A022.A02(A06.A00), A06.A02[0]);
                    } else {
                        A0Q[i2] = ((H7) I1.A01(this.A00)).A4T(A022.A02(A06.A00), A06.A02);
                    }
                }
            }
        }
        C0271Ad[] adArr = new C0271Ad[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (defaultTrackSelector$Parameters.A07(i3) || (h6.A01(i3) != 5 && A0Q[i3] == null)) {
                z = false;
            } else {
                z = true;
            }
            adArr[i3] = z ? C0271Ad.A01 : null;
        }
        A0H(h6, iArr, adArr, A0Q, defaultTrackSelector$Parameters.A04);
        return Pair.create(adArr, A0Q);
    }
}
