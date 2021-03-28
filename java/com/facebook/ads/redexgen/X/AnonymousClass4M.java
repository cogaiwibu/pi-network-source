package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.4M  reason: invalid class name */
public class AnonymousClass4M {
    public static String[] A02;
    public SparseArray<AnonymousClass4L> A00 = new SparseArray<>();
    public int A01 = 0;

    static {
        A02();
    }

    public static void A02() {
        A02 = new String[]{"hO0SXlIn7n5HXEBLx", "jESNVpuYnHPlnh4DZ", "CDLwN7DwmtArlNd144q1QIOvLDqs4yZF", "JntNhgZ58kYFXbwiJ6hzeVdvPNGn00kF", "yTsWpbzmHeCmcQEDkb0QkT5J3TV6CkfD", "Lh9pded4Clz2", "gnDNjs3GBImfOnnM5uEQWokXBd1c", "C4tnEN178k9sL9bIxtVolUttiI5dEdE5"};
    }

    private final long A00(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        long j3 = j / 4;
        String[] strArr = A02;
        if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        strArr2[4] = "GTVZcsVJP0WVKaHbsMtSVk9gu6Gyk4Ss";
        return (j3 * 3) + (j2 / 4);
    }

    private AnonymousClass4L A01(int i) {
        AnonymousClass4L r1 = this.A00.get(i);
        if (r1 != null) {
            return r1;
        }
        AnonymousClass4L r12 = new AnonymousClass4L();
        this.A00.put(i, r12);
        return r12;
    }

    private final void A03() {
        for (int i = 0; i < this.A00.size(); i++) {
            this.A00.valueAt(i).A03.clear();
        }
    }

    public final AnonymousClass4X A04(int i) {
        AnonymousClass4L r1 = this.A00.get(i);
        if (r1 == null || r1.A03.isEmpty()) {
            return null;
        }
        ArrayList<AnonymousClass4X> arrayList = r1.A03;
        if (A02[4].charAt(1) != 'T') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "6zOEmNGiTAHU1v9SGa3";
        strArr[6] = "6zOEmNGiTAHU1v9SGa3";
        return arrayList.remove(arrayList.size() - 1);
    }

    public final void A05() {
        this.A01--;
    }

    public final void A06(int i, long j) {
        AnonymousClass4L A012 = A01(i);
        A012.A01 = A00(A012.A01, j);
    }

    public final void A07(int i, long j) {
        AnonymousClass4L A012 = A01(i);
        A012.A02 = A00(A012.A02, j);
    }

    public final void A08(AnonymousClass43 r2) {
        this.A01++;
    }

    public final void A09(AnonymousClass43 r2, AnonymousClass43 r3, boolean z) {
        if (r2 != null) {
            A05();
        }
        if (!z && this.A01 == 0) {
            A03();
        }
        if (r3 != null) {
            A08(r3);
        }
    }

    public final void A0A(AnonymousClass4X r5) {
        int A0I = r5.A0I();
        ArrayList<AnonymousClass4X> arrayList = A01(A0I).A03;
        if (this.A00.get(A0I).A00 > arrayList.size()) {
            r5.A0R();
            String[] strArr = A02;
            if (strArr[3].charAt(9) != strArr[7].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "TnDeXYrDbfmyODeGX";
            strArr2[5] = "ziritv0xfrad";
            arrayList.add(r5);
        }
    }

    public final boolean A0B(int i, long j, long j2) {
        long j3 = A01(i).A01;
        return j3 == 0 || j + j3 < j2;
    }

    public final boolean A0C(int i, long j, long j2) {
        long j3 = A01(i).A02;
        return j3 == 0 || j + j3 < j2;
    }
}
