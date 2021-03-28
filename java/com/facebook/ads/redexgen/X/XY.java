package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.precache.DownloadManager;
import java.util.Arrays;

public final class XY implements AJ {
    public static byte[] A0A;
    public static String[] A0B;
    public int A00;
    public boolean A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C0947aY A07;
    public final IU A08;
    public final boolean A09;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 24);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{104, -85, -87, -74, -74, -73, -68, 104, -86, -83, 104, -76, -83, -69, -69, 104, -68, -80, -87, -74, 104, -81, -88, -69, -84, -84, -85, -72, -116, -75, -72, -106, -78, -89, -65, -88, -89, -87, -79, -121, -84, -70, -85, -72, -104, -85, -88, -69, -84, -84, -85, -72, -109, -71, -54, -35, -50, -50, -51, -38, -82, -41, -38, -72, -44, -55, -31, -54, -55, -53, -45, -75, -37, -17, -29, -6, -60, -9, -24, -24, -25, -12, -49, -11, -23, -27, -22, -66, -15, -30, -30, -31, -18, -55, -17};
    }

    public static void A03() {
        A0B = new String[]{"ilntiKeCpn72Dx7EE3Rw9hkq75JbKAcA", "wPL2yleQwYX6RVVdEOaHMWHZq50QYzDc", "zjYhmAwspMfnQIz92oeL2kf6IR", "AEUyDf5SOKQlymFmwa942o3bdmA", "6YNynFjnDYQOqc0QM1ycbBp5CCdF169p", "D8", "MEXbIoh", "5uze5Gp41PLyaey5Hs3T"};
    }

    public XY() {
        this(new C0947aY(true, 65536));
    }

    @Deprecated
    public XY(C0947aY aYVar) {
        this(aYVar, 15000, Constants.ControllerParameters.LOAD_RUNTIME, IronSourceConstants.IS_INSTANCE_NOT_FOUND, DownloadManager.OPERATION_TIMEOUT, -1, true);
    }

    @Deprecated
    public XY(C0947aY aYVar, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(aYVar, i, i2, i3, i4, i5, z, null);
    }

    @Deprecated
    public XY(C0947aY aYVar, int i, int i2, int i3, int i4, int i5, boolean z, IU iu) {
        String A012 = A01(21, 1, 103);
        String A013 = A01(54, 19, 80);
        A04(i3, 0, A013, A012);
        String A014 = A01(22, 32, 46);
        A04(i4, 0, A014, A012);
        String A015 = A01(84, 11, 100);
        A04(i, i3, A015, A013);
        A04(i, i4, A015, A014);
        A04(i2, i, A01(73, 11, 106), A015);
        this.A07 = aYVar;
        this.A06 = ((long) i) * 1000;
        this.A05 = ((long) i2) * 1000;
        this.A04 = ((long) i3) * 1000;
        this.A03 = ((long) i4) * 1000;
        this.A02 = i5;
        this.A09 = z;
        this.A08 = iu;
    }

    private final int A00(AbstractC0844Xf[] xfArr, H9 h9) {
        int i = 0;
        for (int i2 = 0; i2 < xfArr.length; i2++) {
            if (h9.A01(i2) != null) {
                i += C0466Ig.A01(xfArr[i2].A7A());
            }
        }
        return i;
    }

    public static void A04(int i, int i2, String str, String str2) {
        boolean z;
        if (i >= i2) {
            z = true;
        } else {
            z = false;
        }
        I1.A05(z, str + A01(0, 21, 48) + str2);
    }

    private void A05(boolean z) {
        this.A00 = 0;
        IU iu = this.A08;
        if (iu != null && this.A01) {
            iu.A03(0);
        }
        this.A01 = false;
        if (z) {
            this.A07.A04();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final HE A5M() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final long A5R() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void AAj() {
        A05(true);
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void AB2() {
        A05(true);
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void AB8(AbstractC0844Xf[] xfArr, TrackGroupArray trackGroupArray, H9 h9) {
        int i = this.A02;
        if (i == -1) {
            i = A00(xfArr, h9);
        }
        this.A00 = i;
        this.A07.A05(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final boolean ACc() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (r3 != r4) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0080, code lost:
        if (r3 != r4) goto L_0x0068;
     */
    @Override // com.facebook.ads.redexgen.X.AJ
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean AD8(long r9, float r11) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XY.AD8(long, float):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final boolean ADB(long j, float f, boolean z) {
        long j2;
        long A0D = C0466Ig.A0D(j, f);
        if (z) {
            j2 = this.A03;
        } else {
            j2 = this.A04;
        }
        if (A0B[6].length() != 13) {
            String[] strArr = A0B;
            strArr[6] = "eSzKm";
            strArr[6] = "eSzKm";
            return j2 <= 0 || A0D >= j2 || (!this.A09 && this.A07.A03() >= this.A00);
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AJ
    public final void onPrepared() {
        A05(false);
    }
}
