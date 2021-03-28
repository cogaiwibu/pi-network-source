package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.4N  reason: invalid class name */
public final class AnonymousClass4N {
    public static byte[] A09;
    public static String[] A0A;
    public int A00 = 2;
    public AnonymousClass4M A01;
    public ArrayList<AnonymousClass4X> A02 = null;
    public int A03 = 2;
    public AnonymousClass4V A04;
    public final ArrayList<AnonymousClass4X> A05 = new ArrayList<>();
    public final ArrayList<AnonymousClass4X> A06 = new ArrayList<>();
    public final List<AnonymousClass4X> A07 = Collections.unmodifiableList(this.A05);
    public final /* synthetic */ ES A08;

    static {
        A06();
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 58);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A09 = new byte[]{-91, -18, -8, -58, -7, -7, -26, -24, -19, -22, -23, -65, -59, -32, 39, 30, 30, 43, 29, 44, -14, -53, -48, -38, -33, -47, -6, 37, 22, 30, -47, 20, 32, 38, 31, 37, -21, -99, -69, -58, -58, -65, -66, 122, -51, -67, -52, -69, -54, 122, -48, -61, -65, -47, 122, -47, -61, -50, -62, 122, -69, -56, 122, -61, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -120, 122, -93, -56, -48, -69, -58, -61, -66, 122, -48, -61, -65, -47, -51, 122, -67, -69, -56, -56, -55, -50, 122, -68, -65, 122, -52, -65, -49, -51, -65, -66, 122, -64, -52, -55, -57, 122, -51, -67, -52, -69, -54, -122, 122, -50, -62, -65, -45, 122, -51, -62, -55, -49, -58, -66, 122, -52, -65, -68, -55, -49, -56, -66, 122, -64, -52, -55, -57, 122, -52, -65, -67, -45, -67, -58, -65, -52, 122, -54, -55, -55, -58, -120, -7, 30, 19, 31, 30, 35, 25, 35, 36, 21, 30, 19, 41, -48, 20, 21, 36, 21, 19, 36, 21, 20, -34, -48, -7, 30, 38, 17, 28, 25, 20, -48, 25, 36, 21, 29, -48, 32, 31, 35, 25, 36, 25, 31, 30, -48, -13, 24, 13, 25, 24, 29, 19, 29, 30, 15, 24, 13, 35, -54, 14, 15, 30, 15, 13, 30, 15, 14, -40, -54, -13, 24, 32, 11, 22, 19, 14, -54, 32, 19, 15, 33, -54, 18, 25, 22, 14, 15, 28, -54, 11, 14, 11, 26, 30, 15, 28, -54, 26, 25, 29, 19, 30, 19, 25, 24, -125, -88, -80, -101, -90, -93, -98, 90, -93, -82, -97, -89, 90, -86, -87, -83, -93, -82, -93, -87, -88, 90, -63, -47, -32, -49, -34, -34, -45, -46, -114, -35, -32, -114, -49, -30, -30, -49, -47, -42, -45, -46, -114, -28, -41, -45, -27, -31, -114, -37, -49, -25, -114, -36, -35, -30, -114, -48, -45, -114, -32, -45, -47, -25, -47, -38, -45, -46, -100, -114, -41, -31, -63, -47, -32, -49, -34, -88, -35, -10, -7, -87, -19, -18, -3, -22, -20, -15, -18, -19, -87, -1, -14, -18, 0, -87, -4, -15, -8, -2, -11, -19, -87, -21, -18, -87, -5, -18, -10, -8, -1, -18, -19, -87, -17, -5, -8, -10, -87, -37, -18, -20, 2, -20, -11, -18, -5, -33, -14, -18, 0, -87, -21, -18, -17, -8, -5, -18, -87, -14, -3, -87, -20, -22, -9, -87, -21, -18, -87, -5, -18, -20, 2, -20, -11, -18, -19, -61, -87, -102, -72, -65, -81, -76, -83, 102, -70, -75, 102, -72, -85, -87, -65, -87, -78, -85, 102, -89, -76, 102, -81, -83, -76, -75, -72, -85, -86, 102, -68, -81, -85, -67, 102, -82, -75, -78, -86, -85, -72, 116, 102, -97, -75, -69, 102, -71, -82, -75, -69, -78, -86, 102, -84, -81, -72, -71, -70, 102, -87, -89, -78, -78, 102, -71, -70, -75, -74, -113, -83, -76, -75, -72, -81, -76, -83, -100, -81, -85, -67, 110, -68, -81, -85, -67, 111, 102, -88, -85, -84, -75, -72, -85, 102, -87, -89, -78, -78, -81, -76, -83, 102, -72, -85, -87, -65, -87, -78, -85, 116, -19, -21, -6, -36, -17, -21, -3, -52, -11, -8, -42, -11, -7, -17, -6, -17, -11, -12, -57, -12, -22, -38, -1, -10, -21, -90, -8, -21, -6, -5, -8, -12, -21, -22, -90, -25, -90, -4, -17, -21, -3, -90, -6, -18, -25, -6, -90, -17, -7, -90, -17, -19, -12, -11, -8, -21, -22, -76, -90, -33, -11, -5, -90, -13, -5, -7, -6, -90, -23, -25, -14, -14, -90, -7, -6, -11, -10, -49, -19, -12, -11, -8, -17, -12, -19, -90, -24, -21, -20, -11, -8, -21, -90, -8, -21, -6, -5, -8, -12, -17, -12, -19, -90, -6, -18, -17, -7, -90, -4, -17, -21, -3, -76, -78, -80, -65, -95, -76, -80, -62, -111, -70, -67, -101, -70, -66, -76, -65, -76, -70, -71, -116, -71, -81, -97, -60, -69, -80, 107, -67, -80, -65, -64, -67, -71, -80, -81, 107, -84, 107, -63, -76, -80, -62, 107, -62, -77, -76, -82, -77, 107, -81, -70, -80, -66, 107, -71, -70, -65, 107, -77, -84, -63, -80, 107, -84, 107, -95, -76, -80, -62, -109, -70, -73, -81, -80, -67, -63, -74, -50, -60, -54, -55, 117, -66, -61, -71, -70, -51, 117, -56, -67, -60, -54, -63, -71, 117, -61, -60, -55, 117, -73, -70, 117, -126, -122, 117, -74, -69, -55, -70, -57, 117, -54, -61, -67, -66, -71, -66, -61, -68, 117, -74, 117, -53, -66, -70, -52, -113, -21, -20, -39, -20, -35, -78};
    }

    public static void A06() {
        A0A = new String[]{"ulA9tMpXJ0Fgz3L6", "kmBp6JcSqPlb9eogqvbvj6g5ppHVaWSS", "klPqAM4BpBJNr6xIOjiQhoS6UO4TrOHS", "7VyM9GgXJuu8YzSYQI3HrMroeBYRJajD", "jF2bnw6E6wYHKm8plX11kYiLrSAbSJmD", "6pBnRch9VxXRPJwtqH0gd323b09mKXXU", "Clk2oRExhn8z5HC1wWkAqM8aEwWEfAA8", "Myq33IQdIYqIzBMhSJhfspyke76FBM0c"};
    }

    public AnonymousClass4N(ES es) {
        this.A08 = es;
    }

    private final View A00(int i, boolean z) {
        return A0J(i, z, Long.MAX_VALUE).A0H;
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.4N: [D('i' int), D('offsetPosition' int)] */
    private final AnonymousClass4X A01(int i) {
        int size;
        int A0E;
        ArrayList<AnonymousClass4X> arrayList = this.A02;
        if (arrayList == null || (size = arrayList.size()) == 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            AnonymousClass4X r1 = this.A02.get(i2);
            if (!r1.A0j() && r1.A0J() == i) {
                r1.A0U(32);
                return r1;
            }
        }
        if (this.A08.A04.A0C() && (A0E = this.A08.A00.A0E(i)) > 0 && A0E < this.A08.A04.A0E()) {
            long A052 = this.A08.A04.A05(A0E);
            for (int i3 = 0; i3 < size; i3++) {
                AnonymousClass4X r3 = this.A02.get(i3);
                if (!r3.A0j() && r3.A0L() == A052) {
                    r3.A0U(32);
                    return r3;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Multiple debug info for r7v0 int: [D('i' int), D('cacheSize' int)] */
    private final AnonymousClass4X A02(int cacheSize, boolean z) {
        View A092;
        int size = this.A05.size();
        for (int i = 0; i < size; i++) {
            AnonymousClass4X r1 = this.A05.get(i);
            if (!r1.A0j() && r1.A0J() == cacheSize && !r1.A0c() && (this.A08.A0s.A09 || !r1.A0d())) {
                r1.A0U(32);
                return r1;
            }
        }
        if (z || (A092 = this.A08.A01.A09(cacheSize)) == null) {
            int size2 = this.A06.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnonymousClass4X r12 = this.A06.get(i2);
                if (!r12.A0c() && r12.A0J() == cacheSize) {
                    if (!z) {
                        this.A06.remove(i2);
                    }
                    return r12;
                }
            }
            return null;
        }
        AnonymousClass4X A0G = ES.A0G(A092);
        this.A08.A01.A0H(A092);
        int A082 = this.A08.A01.A08(A092);
        if (A082 != -1) {
            this.A08.A01.A0D(A082);
            A0X(A092);
            A0G.A0U(8224);
            return A0G;
        }
        throw new IllegalStateException(A04(721, 52, 27) + A0G + this.A08.A1J());
    }

    /* JADX INFO: Multiple debug info for r8v0 long: [D('i' int), D('cacheSize' int)] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ec A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.ads.redexgen.X.AnonymousClass4X A03(long r8, int r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4N.A03(long, int, boolean):com.facebook.ads.redexgen.X.4X");
    }

    private final void A07() {
        for (int i = this.A06.size() - 1; i >= 0; i--) {
            A08(i);
        }
        this.A06.clear();
        if (ES.A1E) {
            this.A08.A02.A03();
        }
    }

    private final void A08(int i) {
        A0e(this.A06.get(i), true);
        this.A06.remove(i);
    }

    private void A09(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                String[] strArr = A0A;
                if (strArr[7].charAt(8) != strArr[6].charAt(8)) {
                    String[] strArr2 = A0A;
                    strArr2[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                    strArr2[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                    A09((ViewGroup) childAt, true);
                } else {
                    throw new RuntimeException();
                }
            }
        }
        if (z) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }
    }

    private void A0A(AnonymousClass4X r3) {
        if (this.A08.A1t()) {
            View view = r3.A0H;
            if (AnonymousClass2u.A00(view) == 0) {
                AnonymousClass2u.A09(view, 1);
            }
            if (!AnonymousClass2u.A0E(view)) {
                r3.A0U(16384);
                AnonymousClass2u.A0A(view, this.A08.A09.A0A());
            }
        }
    }

    private void A0B(AnonymousClass4X r3) {
        if (r3.A0H instanceof ViewGroup) {
            A09((ViewGroup) r3.A0H, false);
        }
    }

    private final void A0C(AnonymousClass4X r2) {
        if (this.A08.A07 != null) {
            throw null;
        }
        AnonymousClass43 r0 = this.A08.A04;
        if (this.A08.A0s != null) {
            this.A08.A0t.A0C(r2);
        }
    }

    private final boolean A0D(AnonymousClass4X r7) {
        if (r7.A0d()) {
            return this.A08.A0s.A07();
        }
        if (r7.A03 < 0 || r7.A03 >= this.A08.A04.A0E()) {
            throw new IndexOutOfBoundsException(A04(205, 60, 112) + r7 + this.A08.A1J());
        } else if (!this.A08.A0s.A07() && this.A08.A04.A04(r7.A03) != r7.A0I()) {
            return false;
        } else {
            if (!this.A08.A04.A0C() || r7.A0L() == this.A08.A04.A05(r7.A03)) {
                return true;
            }
            return false;
        }
    }

    private boolean A0E(AnonymousClass4X r10, int i, int i2, long j) {
        r10.A08 = this.A08;
        int A0I = r10.A0I();
        long nanoTime = this.A08.getNanoTime();
        if (j != Long.MAX_VALUE) {
            AnonymousClass4M r3 = this.A01;
            String[] strArr = A0A;
            if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                String[] strArr2 = A0A;
                strArr2[0] = "We3abAYlnqMpJzTP";
                strArr2[0] = "We3abAYlnqMpJzTP";
                if (!r3.A0B(A0I, nanoTime, j)) {
                    return false;
                }
            } else {
                throw new RuntimeException();
            }
        }
        this.A08.A04.A0B(r10, i);
        this.A01.A06(r10.A0I(), this.A08.getNanoTime() - nanoTime);
        A0A(r10);
        if (!this.A08.A0s.A07()) {
            return true;
        }
        r10.A04 = i2;
        return true;
    }

    public final int A0F() {
        return this.A05.size();
    }

    public final View A0G(int i) {
        return this.A05.get(i).A0H;
    }

    public final View A0H(int i) {
        return A00(i, false);
    }

    public final AnonymousClass4M A0I() {
        if (this.A01 == null) {
            this.A01 = new AnonymousClass4M();
        }
        return this.A01;
    }

    @Nullable
    public final AnonymousClass4X A0J(int i, boolean z, long j) {
        AnonymousClass4G r4;
        ES A0I;
        AnonymousClass4V r0;
        View A002;
        if (i < 0 || i >= this.A08.A0s.A03()) {
            throw new IndexOutOfBoundsException(A04(265, 22, 0) + i + A04(12, 1, 99) + i + A04(23, 14, 119) + this.A08.A0s.A03() + this.A08.A1J());
        }
        boolean fromScrapOrHiddenOrCache = false;
        AnonymousClass4X holder = null;
        boolean z2 = true;
        if (this.A08.A0s.A07()) {
            holder = A01(i);
            if (holder != null) {
                fromScrapOrHiddenOrCache = true;
            } else {
                fromScrapOrHiddenOrCache = false;
            }
        }
        if (holder == null && (holder = A02(i, z)) != null) {
            if (!A0D(holder)) {
                if (!z) {
                    holder.A0U(4);
                    if (holder.A0e()) {
                        this.A08.removeDetachedView(holder.A0H, false);
                        holder.A0T();
                    } else if (holder.A0j()) {
                        holder.A0P();
                    }
                    A0c(holder);
                }
                holder = null;
            } else {
                fromScrapOrHiddenOrCache = true;
            }
        }
        if (holder == null) {
            int A0E = this.A08.A00.A0E(i);
            if (A0E < 0 || A0E >= this.A08.A04.A0E()) {
                throw new IndexOutOfBoundsException(A04(159, 46, 118) + i + A04(13, 8, 126) + A0E + A04(21, 2, 104) + A04(773, 6, 62) + this.A08.A0s.A03() + this.A08.A1J());
            }
            int A042 = this.A08.A04.A04(A0E);
            if (this.A08.A04.A0C() && (holder = A03(this.A08.A04.A05(A0E), A042, z)) != null) {
                holder.A03 = A0E;
                fromScrapOrHiddenOrCache = true;
            }
            if (!(holder != null || (r0 = this.A04) == null || (A002 = r0.A00(this, i, A042)) == null)) {
                holder = this.A08.A1I(A002);
                if (holder == null) {
                    throw new IllegalArgumentException(A04(647, 74, 17) + this.A08.A1J());
                } else if (holder.A0i()) {
                    throw new IllegalArgumentException(A04(534, 113, 76) + this.A08.A1J());
                }
            }
            if (holder == null) {
                AnonymousClass4M A0I2 = A0I();
                String[] strArr = A0A;
                if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                    String[] strArr2 = A0A;
                    strArr2[4] = "3K2bfdY4Lns5cH4Uqi6qZhk44zURNmgZ";
                    strArr2[4] = "3K2bfdY4Lns5cH4Uqi6qZhk44zURNmgZ";
                    holder = A0I2.A04(A042);
                    if (holder != null) {
                        holder.A0R();
                        if (ES.A1C) {
                            A0B(holder);
                        }
                    }
                }
                throw new RuntimeException();
            }
            if (holder == null) {
                long nanoTime = this.A08.getNanoTime();
                if (j != Long.MAX_VALUE && !this.A01.A0C(A042, nanoTime, j)) {
                    return null;
                }
                AnonymousClass43 r7 = this.A08.A04;
                ES es = this.A08;
                String[] strArr3 = A0A;
                if (strArr3[5].charAt(0) != strArr3[3].charAt(0)) {
                    String[] strArr4 = A0A;
                    strArr4[5] = "ofPrqBOY4KV1O5mmTOXtQojU6rRVoJMb";
                    strArr4[3] = "dfUBDtyf096LhSCdUEMmmzbvfUZbBbNe";
                    holder = r7.A06(es, A042);
                    if ((ES.A1E) && (A0I = ES.A0I(holder.A0H)) != null) {
                        holder.A09 = new WeakReference<>(A0I);
                    }
                    this.A01.A07(A042, this.A08.getNanoTime() - nanoTime);
                } else {
                    throw new RuntimeException();
                }
            }
        }
        if (fromScrapOrHiddenOrCache && !this.A08.A0s.A07() && holder.A0l(8192)) {
            holder.A0V(0, 8192);
            if (this.A08.A0s.A0C) {
                this.A08.A1n(holder, this.A08.A05.A08(this.A08.A0s, holder, AnonymousClass4B.A00(holder) | 4096, holder.A0M()));
            }
        }
        boolean z3 = false;
        if (this.A08.A0s.A07() && holder.A0b()) {
            holder.A04 = i;
        } else if (!holder.A0b() || holder.A0h() || holder.A0c()) {
            z3 = A0E(holder, this.A08.A00.A0E(i), i, j);
        }
        ViewGroup.LayoutParams layoutParams = holder.A0H.getLayoutParams();
        if (layoutParams == null) {
            r4 = (AnonymousClass4G) this.A08.generateDefaultLayoutParams();
            holder.A0H.setLayoutParams(r4);
        } else if (!this.A08.checkLayoutParams(layoutParams)) {
            r4 = (AnonymousClass4G) this.A08.generateLayoutParams(layoutParams);
            holder.A0H.setLayoutParams(r4);
        } else {
            if (A0A[0].length() == 16) {
                String[] strArr5 = A0A;
                strArr5[4] = "WeHbAL2DpvJL4iRMn0O7hIhaGbvumhB7";
                strArr5[4] = "WeHbAL2DpvJL4iRMn0O7hIhaGbvumhB7";
                r4 = (AnonymousClass4G) layoutParams;
            }
            throw new RuntimeException();
        }
        r4.A00 = holder;
        if (!fromScrapOrHiddenOrCache || !z3) {
            z2 = false;
        }
        r4.A02 = z2;
        return holder;
    }

    public final List<AnonymousClass4X> A0K() {
        return this.A07;
    }

    public final void A0L() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            this.A06.get(i).A0N();
        }
        int i2 = this.A05.size();
        for (int i3 = 0; i3 < i2; i3++) {
            this.A05.get(i3).A0N();
        }
        ArrayList<AnonymousClass4X> arrayList = this.A02;
        String[] strArr = A0A;
        if (strArr[2].charAt(0) != strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[7] = "w7WcMXH384MQxArKBWq9tfOfmOANhXYh";
        strArr2[6] = "ji6HgViVTGyvfONq8Vqt8Uaju4D1iJHU";
        if (arrayList != null) {
            int changedScrapCount = arrayList.size();
            for (int i4 = 0; i4 < changedScrapCount; i4++) {
                this.A02.get(i4).A0N();
            }
        }
    }

    public final void A0M() {
        this.A05.clear();
        ArrayList<AnonymousClass4X> arrayList = this.A02;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final void A0N() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            AnonymousClass4G r1 = (AnonymousClass4G) this.A06.get(i).A0H.getLayoutParams();
            if (r1 != null) {
                r1.A01 = true;
            }
        }
    }

    public final void A0O() {
        if (this.A08.A04 == null || !this.A08.A04.A0C()) {
            A07();
            return;
        }
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            AnonymousClass4X r3 = this.A06.get(i);
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[2] = "kx9etu5Uswf3mlSSd54JM5SDJxoMGNTv";
            strArr[1] = "kxxNK4Rys8aPJuu822sP3fs8sDM7v1G0";
            if (r3 != null) {
                r3.A0U(6);
                r3.A0Z(null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0P() {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4N.A0P():void");
    }

    public final void A0Q() {
        this.A05.clear();
        A07();
    }

    public final void A0R(int i) {
        this.A03 = i;
        A0P();
    }

    public final void A0S(int i, int i2) {
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnonymousClass4X r1 = this.A06.get(i3);
            if (r1 != null && r1.A03 >= i) {
                r1.A0X(i2, true);
            }
        }
    }

    public final void A0T(int end, int inBetweenOffset) {
        int cachedCount;
        int i;
        int i2;
        if (end < inBetweenOffset) {
            cachedCount = end;
            i = inBetweenOffset;
            i2 = -1;
        } else {
            cachedCount = inBetweenOffset;
            i = end;
            i2 = 1;
        }
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnonymousClass4X r3 = this.A06.get(i3);
            if (r3 != null && r3.A03 >= cachedCount && r3.A03 <= i) {
                int i4 = r3.A03;
                String[] strArr = A0A;
                if (strArr[5].charAt(0) != strArr[3].charAt(0)) {
                    String[] strArr2 = A0A;
                    strArr2[2] = "kvvW4F2OCwdEIl1qwIuxYVFpmp0ugJY5";
                    strArr2[1] = "kzcCp2wTfEGQm2KGuN32b5oIYABnQWPG";
                    if (i4 == end) {
                        r3.A0X(inBetweenOffset - end, false);
                    } else {
                        r3.A0X(i2, false);
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }

    public final void A0U(int cachedCount, int i) {
        int pos;
        int i2 = cachedCount + i;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            AnonymousClass4X r1 = this.A06.get(size);
            if (r1 != null && (pos = r1.A03) >= cachedCount && pos < i2) {
                r1.A0U(2);
                A08(size);
            }
        }
    }

    public final void A0V(int cachedCount, int i, boolean z) {
        int i2 = cachedCount + i;
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            AnonymousClass4X r1 = this.A06.get(size);
            if (r1 != null) {
                if (r1.A03 >= i2) {
                    r1.A0X(-i, z);
                } else if (r1.A03 >= cachedCount) {
                    r1.A0U(8);
                    A08(size);
                }
            }
        }
    }

    public final void A0W(View view) {
        AnonymousClass4X A0G = ES.A0G(view);
        A0G.A0F = null;
        A0G.A0G = false;
        A0G.A0P();
        A0c(A0G);
    }

    public final void A0X(View view) {
        AnonymousClass4X A0G = ES.A0G(view);
        if (A0G.A0l(12) || !A0G.A0g() || this.A08.A21(A0G)) {
            boolean A0c = A0G.A0c();
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[5] = "cscHAR4ImnAFzAxZJ9yqjMNa91RcN8Vb";
            strArr[3] = "pspTzLDNU823NSI2ymIgIumCpfqVQlal";
            if (!A0c || A0G.A0d() || this.A08.A04.A0C()) {
                A0G.A0Y(this, false);
                this.A05.add(A0G);
                return;
            }
            throw new IllegalArgumentException(A04(37, 122, 32) + this.A08.A1J());
        }
        if (this.A02 == null) {
            this.A02 = new ArrayList<>();
        }
        A0G.A0Y(this, true);
        this.A02.add(A0G);
    }

    public final void A0Y(View view) {
        AnonymousClass4X A0G = ES.A0G(view);
        if (A0G.A0f()) {
            this.A08.removeDetachedView(view, false);
        }
        if (A0G.A0e()) {
            A0G.A0T();
        } else if (A0G.A0j()) {
            A0G.A0P();
        }
        A0c(A0G);
    }

    public final void A0Z(AnonymousClass43 r2, AnonymousClass43 r3, boolean z) {
        A0Q();
        A0I().A09(r2, r3, z);
    }

    public final void A0a(AnonymousClass4M r3) {
        AnonymousClass4M r0 = this.A01;
        if (r0 != null) {
            r0.A05();
        }
        this.A01 = r3;
        if (r3 != null) {
            this.A01.A08(this.A08.getAdapter());
        }
    }

    public final void A0b(AnonymousClass4V r1) {
        this.A04 = r1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        if (r5 > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        if (r5 > 0) goto L_0x00c9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0c(com.facebook.ads.redexgen.X.AnonymousClass4X r10) {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4N.A0c(com.facebook.ads.redexgen.X.4X):void");
    }

    public final void A0d(AnonymousClass4X r2) {
        if (r2.A0G) {
            this.A02.remove(r2);
        } else {
            this.A05.remove(r2);
        }
        r2.A0F = null;
        r2.A0G = false;
        r2.A0P();
    }

    public final void A0e(AnonymousClass4X r4, boolean z) {
        ES.A0u(r4);
        if (r4.A0l(16384)) {
            r4.A0V(0, 16384);
            AnonymousClass2u.A0A(r4.A0H, null);
        }
        if (z) {
            A0C(r4);
        }
        r4.A08 = null;
        A0I().A0A(r4);
    }
}
