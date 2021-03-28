package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.4X  reason: invalid class name */
public abstract class AnonymousClass4X {
    public static byte[] A0I;
    public static String[] A0J;
    public static final List<Object> A0K = Collections.EMPTY_LIST;
    public int A00 = -1;
    public int A01 = -1;
    @VisibleForTesting
    public int A02 = -1;
    public int A03 = -1;
    public int A04 = -1;
    public long A05 = -1;
    public AnonymousClass4X A06 = null;
    public AnonymousClass4X A07 = null;
    public ES A08;
    public WeakReference<ES> A09;
    public List<Object> A0A = null;
    public List<Object> A0B = null;
    public int A0C;
    public int A0D = 0;
    public int A0E = 0;
    public AnonymousClass4N A0F = null;
    public boolean A0G = false;
    public final View A0H;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 42);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0I = new byte[]{120, 49, 60, 101, 89, 16, 30, 23, 22, 11, 28, 29, 107, 34, 37, 61, 42, 39, 34, 47, 9, 71, 70, 9, 89, 72, 91, 76, 71, 93, 20, 90, 91, 64, 20, 70, 81, 87, 77, 87, 88, 85, 86, 88, 81, 28, 123, 43, 52, 40, 50, 47, 50, 52, 53, 102, 114, 32, 55, 63, 61, 36, 55, 54, 18, 65, 81, 64, 83, 66, 18, 25, 77, 84, 73, 125, 92, 77, 88, 90, 81, 92, 93, 58, 111, 116, 120, 117, 111, 116, 126, 100, 49, 42, 32, 33, 34, 45, 42, 33, 32, 100, 37, 32, 37, 52, 48, 33, 54, 100, 52, 43, 55, 45, 48, 45, 43, 42, 41, 124, 121, 109, 104, 125, 108, 81, 22, 26, 85, 86, 94, 106, 85, 73, 7, 76, 64, 16, 44, 16, 15, 19, 90, 96, 95, 83, 65, 69, 122, 118, 100, 91, 124, ByteCompanionObject.MAX_VALUE, 119, 118, 97, 104, 118, 76, 89, 89, 76, 78, 69, 72, 73, 126, 78, 95, 76, 93, 112, 95, 103, 108, 101, 106, 99, 97, 87, 103, 118, 101, 116, 89, 48, 42, 11, 60, 58, 32, 58, 53, 56, 59, 53, 60, 121, 61, 60, 58, 43, 60, 52, 60, 55, 45, 60, 61, 121, 59, 60, 53, 54, 46, 121, 105, 99, 121, 44, 55, 52, 56, 45, 58, 49, 60, 61, 121, 41, 56, 48, 43, 121, 54, 63, 121, 42, 60, 45, 16, 42, 11, 60, 58, 32, 56, 59, 53, 60, 113, 112, 121, 58, 56, 53, 53, 42, 121, 63, 54, 43, 121, 31, 2, 19, 27, 32, 31, 19, 1, 86, 27, 23, 15, 86, 24, 25, 2, 86, 20, 19, 86, 24, 3, 26, 26, 19};
        String[] strArr = A0J;
        if (strArr[5].charAt(21) != strArr[1].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[5] = "ATZarWDBMn8zDwozKxOA19Yjdj8cqMYP";
        strArr2[1] = "9Y2h7opSRjFz5DGljetO79QOLWaAi3pM";
    }

    public static void A05() {
        A0J = new String[]{"RjjM", "koSvj4DxhDjUOCe4EMKks9dnOG3CuiGu", "aGHSBrQSfGZtxcbyILmCKrnGyIhpjEzu", "3xCBACovNHKuv2JvT7we0utPzpikn", "cVLYlYPRz01pIgpGABaAmbt5GOW22sRw", "rNQ6SroUNOr34Wm88sisB9VlrwVLSnji", "gjKr", "5vAD1AgEgb1ZXBUPAvYh"};
    }

    static {
        A05();
        A04();
    }

    public AnonymousClass4X(View view) {
        if (view != null) {
            this.A0H = view;
            return;
        }
        throw new IllegalArgumentException(A02(264, 24, 92));
    }

    private void A03() {
        if (this.A0A == null) {
            this.A0A = new ArrayList();
            this.A0B = Collections.unmodifiableList(this.A0A);
        }
    }

    /* access modifiers changed from: private */
    public void A08(ES es) {
        this.A0E = AnonymousClass2u.A00(this.A0H);
        es.A22(this, 4);
    }

    /* access modifiers changed from: private */
    public void A09(ES es) {
        es.A22(this, this.A0E);
        this.A0E = 0;
    }

    /* access modifiers changed from: private */
    public boolean A0A() {
        return (this.A0C & 16) == 0 && AnonymousClass2u.A0F(this.A0H);
    }

    /* access modifiers changed from: private */
    public boolean A0B() {
        return (this.A0C & 16) != 0;
    }

    private final boolean A0C() {
        return (this.A0C & 512) != 0 || A0c();
    }

    public final int A0H() {
        ES es = this.A08;
        if (es == null) {
            return -1;
        }
        return es.A1E(this);
    }

    public final int A0I() {
        return this.A00;
    }

    public final int A0J() {
        int i = this.A04;
        return i == -1 ? this.A03 : i;
    }

    public final int A0K() {
        return this.A01;
    }

    public final long A0L() {
        return this.A05;
    }

    public final List<Object> A0M() {
        if ((this.A0C & 1024) != 0) {
            return A0K;
        }
        List<Object> list = this.A0A;
        if (list != null) {
            int size = list.size();
            if (A0J[2].charAt(8) != 'd') {
                String[] strArr = A0J;
                strArr[5] = "2DcmVbWbN7IXAuYZB7QLz9ixHDr4nD2H";
                strArr[1] = "B34awafHihlIJm5KsMjOG9HfWfhHTq0p";
                if (size != 0) {
                    return this.A0B;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return A0K;
    }

    public final void A0N() {
        this.A01 = -1;
        this.A04 = -1;
    }

    public final void A0O() {
        List<Object> list = this.A0A;
        if (list != null) {
            list.clear();
        }
        this.A0C &= -1025;
    }

    public final void A0P() {
        this.A0C &= -33;
    }

    public final void A0Q() {
        this.A0C &= -257;
    }

    public final void A0R() {
        this.A0C = 0;
        this.A03 = -1;
        this.A01 = -1;
        this.A05 = -1;
        this.A04 = -1;
        this.A0D = 0;
        this.A06 = null;
        this.A07 = null;
        A0O();
        this.A0E = 0;
        this.A02 = -1;
        ES.A0u(this);
    }

    public final void A0S() {
        if (this.A01 == -1) {
            this.A01 = this.A03;
        }
    }

    public final void A0T() {
        this.A0F.A0d(this);
    }

    public final void A0U(int i) {
        this.A0C |= i;
    }

    public final void A0V(int i, int i2) {
        this.A0C = (this.A0C & (i2 ^ -1)) | (i & i2);
    }

    public final void A0W(int i, int i2, boolean z) {
        A0U(8);
        A0X(i2, z);
        this.A03 = i;
    }

    public final void A0X(int i, boolean z) {
        if (this.A01 == -1) {
            this.A01 = this.A03;
        }
        if (this.A04 == -1) {
            this.A04 = this.A03;
        }
        if (z) {
            this.A04 += i;
        }
        this.A03 += i;
        if (this.A0H.getLayoutParams() != null) {
            ((AnonymousClass4G) this.A0H.getLayoutParams()).A01 = true;
        }
    }

    public final void A0Y(AnonymousClass4N r1, boolean z) {
        this.A0F = r1;
        this.A0G = z;
    }

    public final void A0Z(Object obj) {
        if (obj == null) {
            A0U(1024);
        } else if ((1024 & this.A0C) == 0) {
            A03();
            this.A0A.add(obj);
        }
    }

    public final void A0a(boolean z) {
        int i = this.A0D;
        this.A0D = z ? i - 1 : i + 1;
        if (A0J[4].charAt(7) != 'R') {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[7] = "l8mjsSEKM";
        strArr[7] = "l8mjsSEKM";
        int i2 = this.A0D;
        if (i2 < 0) {
            this.A0D = 0;
            Log.e(A02(143, 4, 28), A02(186, 78, 115) + this);
        } else if (!z && i2 == 1) {
            int i3 = this.A0C | 16;
            String[] strArr2 = A0J;
            if (strArr2[5].charAt(21) != strArr2[1].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0J;
            strArr3[2] = "drml3nLoX5pQWQBc32bzozsnTExNEnJK";
            strArr3[2] = "drml3nLoX5pQWQBc32bzozsnTExNEnJK";
            this.A0C = i3;
        } else if (z && this.A0D == 0) {
            this.A0C &= -17;
        }
    }

    public final boolean A0b() {
        return (this.A0C & 1) != 0;
    }

    public final boolean A0c() {
        return (this.A0C & 4) != 0;
    }

    public final boolean A0d() {
        return (this.A0C & 8) != 0;
    }

    public final boolean A0e() {
        return this.A0F != null;
    }

    public final boolean A0f() {
        return (this.A0C & 256) != 0;
    }

    public final boolean A0g() {
        return (this.A0C & 2) != 0;
    }

    public final boolean A0h() {
        return (this.A0C & 2) != 0;
    }

    public final boolean A0i() {
        return (this.A0C & 128) != 0;
    }

    public final boolean A0j() {
        return (this.A0C & 32) != 0;
    }

    public final boolean A0k() {
        return (this.A0C & 16) == 0 && !AnonymousClass2u.A0F(this.A0H);
    }

    public final boolean A0l(int i) {
        return (this.A0C & i) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b4, code lost:
        if (r4.getParent() == null) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01e3, code lost:
        if (r4.getParent() == null) goto L_0x01b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 486
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass4X.toString():java.lang.String");
    }
}
