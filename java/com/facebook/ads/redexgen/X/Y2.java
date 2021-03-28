package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession;
import com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.drm.DrmSession;
import com.facebook.ads.redexgen.X.C5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public final class Y2<T extends C5> implements C4<T>, Bl<T> {
    public static byte[] A0D;
    public static String[] A0E;
    public int A00;
    public Looper A01;
    public byte[] A02;
    public final int A03;
    public final C0306Br A04;
    public final CB<T> A05;
    public final CF A06;
    public final HashMap<String, String> A07;
    public final List<C0864Xz<T>> A08;
    public final List<C0864Xz<T>> A09;
    public final UUID A0A;
    public final boolean A0B;
    public volatile Y2<T>.MediaDrmHandler A0C;

    static {
        A04();
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0D = new byte[]{74, 107, 104, 111, 123, 98, 122, 74, 124, 99, 93, 107, 125, 125, 103, 97, 96, 67, 105, 124, 9, 63, 32, 4, 35, 36, 57, 9, 44, 57, 44, 109, 34, 35, 33, 52, 109, 46, 34, 35, 57, 44, 36, 35, 62, 109, 46, 34, 32, 32, 34, 35, 109, 29, 30, 30, 5, 109, 30, 46, 37, 40, 32, 40, 9, 44, 57, 44, 99, 109, 12, 62, 62, 56, 32, 36, 35, 42, 109, 62, 56, 61, 61, 34, 63, 57, 109, 43, 34, 63, 119, 109, 109, 108, 109, 63, 120, 121, 120, 104, 10, 12, 7, 10, 49, 55, 60, 33};
    }

    public static void A04() {
        A0E = new String[]{"0jHq0iWGhsIySlQoDiDGup3biHh1u6", "i2l5O7Dt7qLUzCpPXTMvAA2Zo4KmgWR2", "WWWB5", "5af5rLtbMnzIwH5Nva3tIodv6", "N1ag4SyeR1bkHrLLU69ntDAZG70pDTMe", "aZncB9cokv9961OmHq", "gIBDsbvLQEgXIogWiAeZHaFgFZc1jweS", "Prja9buVBy0glhaqAx1SHba3MELDXzlR"};
    }

    public static DrmInitData.SchemeData A00(DrmInitData drmInitData, UUID uuid, boolean z) {
        int version;
        ArrayList arrayList = new ArrayList(drmInitData.A01);
        int i = 0;
        while (true) {
            boolean z2 = false;
            if (i < drmInitData.A01) {
                DrmInitData.SchemeData A022 = drmInitData.A02(i);
                boolean A032 = A022.A03(uuid);
                if (A0E[0].length() != 30) {
                    break;
                }
                String[] strArr = A0E;
                strArr[2] = "V0Q9eaLMfBF3CEdW";
                strArr[2] = "V0Q9eaLMfBF3CEdW";
                if (A032 || (C02669y.A01.equals(uuid) && A022.A03(C02669y.A02))) {
                    z2 = true;
                }
                if (z2 && (A022.A04 != null || z)) {
                    arrayList.add(A022);
                }
                i++;
            } else if (arrayList.isEmpty()) {
                return null;
            } else {
                if (C02669y.A05.equals(uuid)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(i2);
                        if (schemeData.A02()) {
                            version = D3.A00(schemeData.A04);
                        } else {
                            version = -1;
                        }
                        if (C0466Ig.A02 < 23 && version == 0) {
                            return schemeData;
                        }
                        if (C0466Ig.A02 >= 23 && version == 1) {
                            return schemeData;
                        }
                    }
                }
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(0);
                if (A0E[6].charAt(29) == 'w') {
                    String[] strArr2 = A0E;
                    strArr2[7] = "QMUEyZuv57oImxraVf5zIpun0ErJkPMX";
                    strArr2[7] = "QMUEyZuv57oImxraVf5zIpun0ErJkPMX";
                    return schemeData2;
                }
            }
        }
        throw new RuntimeException();
    }

    public final void A05(Handler handler, Bs bs) {
        this.A04.A03(handler, bs);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0059 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v22, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v23, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.X.C4
    public final C3<T> A2Q(Looper looper, DrmInitData drmInitData) {
        boolean z;
        C0864Xz<T> xz;
        Looper looper2 = this.A01;
        if (looper2 == null || looper2 == looper) {
            z = true;
        } else {
            z = false;
        }
        I1.A04(z);
        if (this.A09.isEmpty()) {
            this.A01 = looper;
            if (this.A0C == null) {
                this.A0C = new HandlerC0308Bu(this, looper);
            }
        }
        DrmInitData.SchemeData schemeData = null;
        C0864Xz<T> xz2 = (C0864Xz<T>) false;
        if (this.A02 == null && (schemeData = A00(drmInitData, this.A0A, false)) == null) {
            DefaultDrmSessionManager<T> bv = new Bv(this.A0A);
            this.A04.A04(bv);
            return new Y3(new C1(bv));
        }
        if (this.A0B) {
            if (A0E[6].charAt(29) == 'w') {
                String[] strArr = A0E;
                strArr[7] = "2tfSkouS8gaRHNrU7OMeTyiBrWH6VnUA";
                strArr[7] = "2tfSkouS8gaRHNrU7OMeTyiBrWH6VnUA";
                byte[] bArr = xz2;
                if (schemeData != null) {
                    bArr = (C0864Xz<T>) schemeData.A04;
                }
                DefaultDrmSession<T> session = this.A09.iterator();
                while (true) {
                    if (!session.hasNext()) {
                        xz = null;
                        break;
                    }
                    C0864Xz<T> next = session.next();
                    if (next.A0N(bArr)) {
                        xz = next;
                        break;
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } else {
            xz = xz2;
            if (!this.A09.isEmpty()) {
                C0864Xz<T> xz3 = this.A09.get(0);
                if (A0E[0].length() != 30) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[5] = "NYlDF58TVUPxDFfWvHrOlngI";
                strArr2[5] = "NYlDF58TVUPxDFfWvHrOlngI";
                xz = xz3;
            }
        }
        if (xz == null) {
            xz = new C0864Xz<>(this.A0A, this.A05, this, schemeData, this.A00, this.A02, this.A07, this.A06, looper, this.A04, this.A03);
            this.A09.add(xz);
        }
        xz.A0H();
        return xz;
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final boolean A3x(@NonNull DrmInitData drmInitData) {
        if (this.A02 != null) {
            return true;
        }
        DrmInitData.SchemeData A002 = A00(drmInitData, this.A0A, true);
        if (A0E[2].length() != 25) {
            String[] strArr = A0E;
            strArr[2] = "f9Fo7yPZ7tYjgWekbXY";
            strArr[2] = "f9Fo7yPZ7tYjgWekbXY";
            if (A002 == null) {
                if (drmInitData.A01 != 1 || !drmInitData.A02(0).A03(C02669y.A02)) {
                    return false;
                }
                Log.w(A01(0, 20, 43), (String) (A01(20, 72, 104) + this.A0A));
            }
            DefaultDrmSessionManager<T> defaultDrmSessionManager = drmInitData.A02;
            if (defaultDrmSessionManager == null || A01(100, 4, 76).equals(defaultDrmSessionManager)) {
                return true;
            }
            if ((A01(92, 4, 43).equals(defaultDrmSessionManager) || A01(96, 4, 62).equals(defaultDrmSessionManager) || A01(104, 4, 119).equals(defaultDrmSessionManager)) && C0466Ig.A02 < 25) {
                return false;
            }
            return true;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.Bl
    public final void AAe() {
        for (C0864Xz<T> session : this.A08) {
            session.A0I();
        }
        this.A08.clear();
    }

    @Override // com.facebook.ads.redexgen.X.Bl
    public final void AAf(Exception exc) {
        for (T t : this.A08) {
            t.A0L(exc);
        }
        List<C0864Xz<T>> list = this.A08;
        String[] strArr = A0E;
        if (strArr[4].charAt(7) != strArr[1].charAt(7)) {
            String[] strArr2 = A0E;
            strArr2[3] = "LfmgySfdwng";
            strArr2[3] = "LfmgySfdwng";
            list.clear();
            return;
        }
        throw new RuntimeException<>();
    }

    @Override // com.facebook.ads.redexgen.X.Bl
    public final void ABs(C0864Xz<T> xz) {
        this.A08.add(xz);
        if (this.A08.size() == 1) {
            xz.A0J();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4
    public final void ACJ(C3<T> c3) {
        if (!(c3 instanceof Y3)) {
            DrmSession<T> drmSession = (C0864Xz) c3;
            if (drmSession.A0M()) {
                this.A09.remove(drmSession);
                if (this.A08.size() > 1 && this.A08.get(0) == drmSession) {
                    this.A08.get(1).A0J();
                }
                this.A08.remove(drmSession);
            }
        }
    }
}
