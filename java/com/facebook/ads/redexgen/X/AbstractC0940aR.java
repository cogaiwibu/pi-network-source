package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;

/* renamed from: com.facebook.ads.redexgen.X.aR  reason: case insensitive filesystem */
public abstract class AbstractC0940aR extends HB {
    public static String[] A01;
    @Nullable
    public H6 A00;

    static {
        A0S();
    }

    public static void A0S() {
        A01 = new String[]{"26JblF4b6dorFS8jU2vwriUxZ0G71mwq", "Xnpi2o2sUEOze", "R71e3dTOAhzB09tZHggtqRTS0V3by", "x11tshWAsx1g8", "baPvwG8wSWpB2aFi4", "NgcUJ4cAOsbj9", "II", "FdNrM275eXYBmZtzCUl1db95x7ONP"};
    }

    public abstract Pair<C0271Ad[], H8[]> A0X(H6 h6, int[][][] iArr, int[] iArr2) throws A4;

    public static int A0R(AbstractC0270Ac[] acArr, TrackGroup trackGroup) throws A4 {
        int rendererIndex = acArr.length;
        int i = 0;
        for (int trackIndex = 0; trackIndex < acArr.length; trackIndex++) {
            AbstractC0270Ac ac = acArr[trackIndex];
            for (int i2 = 0; i2 < trackGroup.A01; i2++) {
                int formatSupportLevel = ac.ADS(trackGroup.A02(i2)) & 7;
                if (formatSupportLevel > i) {
                    rendererIndex = trackIndex;
                    i = formatSupportLevel;
                    if (i == 4) {
                        return rendererIndex;
                    }
                }
            }
        }
        return rendererIndex;
    }

    public static int[] A0T(AbstractC0270Ac ac, TrackGroup trackGroup) throws A4 {
        int[] iArr = new int[trackGroup.A01];
        for (int i = 0; i < trackGroup.A01; i++) {
            iArr[i] = ac.ADS(trackGroup.A02(i));
        }
        return iArr;
    }

    public static int[] A0U(AbstractC0270Ac[] acArr) throws A4 {
        int[] iArr = new int[acArr.length];
        int i = 0;
        while (true) {
            int length = iArr.length;
            String[] strArr = A01;
            if (strArr[4].length() != strArr[5].length()) {
                String[] strArr2 = A01;
                strArr2[0] = "xB4ZDOqJN2K9OUw5kZCJNg4ll7dteaQM";
                strArr2[0] = "xB4ZDOqJN2K9OUw5kZCJNg4ll7dteaQM";
                if (i >= length) {
                    return iArr;
                }
                iArr[i] = acArr[i].ADU();
                i++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HB
    public final HC A0V(AbstractC0270Ac[] acArr, TrackGroupArray trackGroupArray) throws A4 {
        int[] A0T;
        int[] iArr = new int[(acArr.length + 1)];
        TrackGroup[][] trackGroupArr = new TrackGroup[(acArr.length + 1)][];
        int[][][] iArr2 = new int[(acArr.length + 1)][][];
        for (int i = 0; i < trackGroupArr.length; i++) {
            trackGroupArr[i] = new TrackGroup[trackGroupArray.A01];
            iArr2[i] = new int[trackGroupArray.A01][];
        }
        int[] A0U = A0U(acArr);
        for (int i2 = 0; i2 < trackGroupArray.A01; i2++) {
            TrackGroup A02 = trackGroupArray.A02(i2);
            int A0R = A0R(acArr, A02);
            if (A0R == acArr.length) {
                A0T = new int[A02.A01];
            } else {
                A0T = A0T(acArr[A0R], A02);
            }
            int i3 = iArr[A0R];
            trackGroupArr[A0R][i3] = A02;
            iArr2[A0R][i3] = A0T;
            iArr[A0R] = iArr[A0R] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[acArr.length];
        int[] iArr3 = new int[acArr.length];
        for (int i4 = 0; i4 < acArr.length; i4++) {
            int i5 = iArr[i4];
            trackGroupArrayArr[i4] = new TrackGroupArray((TrackGroup[]) C0466Ig.A0l(trackGroupArr[i4], i5));
            iArr2[i4] = (int[][]) C0466Ig.A0l(iArr2[i4], i5);
            iArr3[i4] = acArr[i4].A7A();
        }
        H6 h6 = new H6(iArr3, trackGroupArrayArr, A0U, iArr2, new TrackGroupArray((TrackGroup[]) C0466Ig.A0l(trackGroupArr[acArr.length], iArr[acArr.length])));
        Pair<C0271Ad[], H8[]> A0X = A0X(h6, iArr2, A0U);
        return new HC((C0271Ad[]) A0X.first, (H8[]) A0X.second, h6);
    }

    @Override // com.facebook.ads.redexgen.X.HB
    public final void A0W(Object obj) {
        this.A00 = (H6) obj;
    }
}
