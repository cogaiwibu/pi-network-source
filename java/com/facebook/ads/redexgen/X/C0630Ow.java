package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.Ow  reason: case insensitive filesystem */
public final class C0630Ow extends AnonymousClass4K {
    public static byte[] A0G;
    public static String[] A0H;
    public float A00 = 0.0f;
    public int A01 = -1;
    @Nullable
    public OR A02;
    public List<OQ> A03;
    public boolean A04 = true;
    public boolean A05 = true;
    public boolean A06 = true;
    public boolean A07;
    public final int A08;
    public final SW A09;
    public final AnonymousClass4S A0A;
    public final O3 A0B = new C0632Oy(this);
    public final O4 A0C = new C0631Ox(this);
    public final O5 A0D = new C0633Oz(this);
    public final C0641Ph A0E;
    public final Set<Integer> A0F = new HashSet();

    static {
        A09();
        A08();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 126);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0G = new byte[]{-26, -6, -7, -12, 4, -11, -15, -26, -2, 4, -22, -13, -26, -25, -15, -22, -23, 4, -11, -26, -9, -26, -14, 7, 17, 29, 4, 7, 16, 17, 18, 29, 20, 7, 2, 3, 13, 29, 14, -1, 16, -1, 11, -5, -12, -15, -6, -14, -22, 4, -15, -22, -5, -22, -15, 4, -11, -26, -9, -26, -14};
    }

    public static void A09() {
        A0H = new String[]{"vVts3290hN8iYOphvTtUHsw8p", "g", "QXZRYfiopoOIgyOb", "uRY3EBcOhcPzIFCW", "1yhQGC5wOot73mjsntHrCCOy6H7", "ngPHprqJPXgJBcmGEhNrmzVf2B4dA5Oh", "DCeBbFrEMIUsiq6", "addqTveDrmk"};
    }

    public C0630Ow(AnonymousClass2R r3, int i, List<OQ> list, C0641Ph ph, @Nullable Bundle bundle) {
        this.A09 = r3.getLayoutManager();
        this.A08 = i;
        this.A03 = list;
        this.A0E = ph;
        this.A0A = new SX(r3.getContext());
        r3.A1k(this);
        A0I(bundle);
    }

    @Nullable
    private AbstractC0670Qk A02(int i, int i2) {
        return A03(i, i2, true);
    }

    @Nullable
    private AbstractC0670Qk A03(int i, int i2, boolean isCompletelyVisible) {
        AbstractC0670Qk qk = null;
        while (i <= i2) {
            AbstractC0670Qk qk2 = (AbstractC0670Qk) this.A09.A1r(i);
            if (qk2 == null || qk2.A0j()) {
                return null;
            }
            boolean A0P = A0P(qk2);
            if (qk == null && qk2.A0k() && A0P) {
                Set<Integer> set = this.A0F;
                Integer valueOf = Integer.valueOf(i);
                String[] strArr = A0H;
                if (strArr[6].length() != strArr[7].length()) {
                    String[] strArr2 = A0H;
                    strArr2[0] = "B";
                    strArr2[0] = "B";
                    if (!set.contains(valueOf) && (!isCompletelyVisible || A0R(qk2))) {
                        qk = qk2;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            if (qk2.A0k() && !A0P) {
                A0H(i, false);
            }
            i++;
        }
        return qk;
    }

    /* JADX INFO: Multiple debug info for r0v4 com.facebook.ads.redexgen.X.Qk: [D('firstAutoplayableVideo' com.facebook.ads.redexgen.X.Qk), D('lastVisibleItem' int)] */
    private void A06() {
        AbstractC0670Qk firstAutoplayableVideo;
        if (this.A05 && (firstAutoplayableVideo = A02(this.A09.A29(), this.A09.A2A())) != null) {
            firstAutoplayableVideo.A0f();
        }
    }

    /* access modifiers changed from: private */
    public void A07() {
        int A28 = this.A09.A28();
        if (A28 != -1 && A28 < this.A03.size() - 1) {
            A0D(A28 + 1);
        }
    }

    private void A0A(int i) {
        AbstractC0670Qk qk = (AbstractC0670Qk) this.A09.A1r(i);
        if (qk != null && !A0P(qk)) {
            String[] strArr = A0H;
            if (strArr[6].length() != strArr[7].length()) {
                String[] strArr2 = A0H;
                strArr2[0] = "Vxamqv9qm4zlsVVB8";
                strArr2[0] = "Vxamqv9qm4zlsVVB8";
                A0K(qk, false);
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0B(int i) {
        float f;
        AbstractC0670Qk qk = (AbstractC0670Qk) this.A09.A1r(i);
        if (qk != null) {
            if (A0P(qk)) {
                A0K(qk, true);
            }
            if (A0Q(qk)) {
                O5 o5 = this.A0D;
                if (this.A03.get(((Integer) qk.getTag(-1593835536)).intValue()).A03().A0E().A09()) {
                    f = 0.0f;
                } else {
                    f = 1.0f;
                }
                o5.setVolume(f);
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0C(int i) {
        AbstractC0670Qk A032 = A03(i + 1, this.A09.A2A(), false);
        if (A032 != null) {
            A032.A0f();
            A0D(((Integer) A032.getTag(-1593835536)).intValue());
        }
    }

    private void A0D(int i) {
        this.A0A.A0B(i);
        this.A09.A1M(this.A0A);
    }

    private void A0E(int i, int i2) {
        A0A(i);
        A0A(i2);
    }

    private void A0F(int i, int i2) {
        while (i <= i2) {
            A0B(i);
            i++;
        }
    }

    private void A0G(int recomputeFrom, int i, int i2) {
        if (A0O() && this.A02 != null) {
            int A28 = this.A09.A28();
            if (A28 == -1) {
                A28 = i2 < 0 ? recomputeFrom : i;
            }
            this.A02.AC5(A28);
        }
    }

    /* access modifiers changed from: private */
    public void A0H(int i, boolean z) {
        if (z) {
            this.A0F.add(Integer.valueOf(i));
        } else {
            this.A0F.remove(Integer.valueOf(i));
        }
    }

    private void A0I(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.A00 = bundle.getFloat(A05(43, 18, 39), 0.0f);
            this.A05 = bundle.getBoolean(A05(0, 23, 39), true);
            this.A06 = bundle.getBoolean(A05(23, 20, 64), true);
        }
    }

    public static void A0J(View view, boolean z) {
        float f;
        if (z) {
            f = 1.0f;
        } else {
            f = 0.5f;
        }
        view.setAlpha(f);
    }

    private void A0K(AbstractC0670Qk qk, boolean z) {
        if (A0O()) {
            A0J(qk, z);
        }
        if (!z && qk.A0j()) {
            qk.A0e();
        }
    }

    /* access modifiers changed from: private */
    public boolean A0O() {
        return this.A08 == 1;
    }

    public static boolean A0P(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }

    private boolean A0Q(AbstractC0670Qk qk) {
        if (!this.A06 || !qk.A0k()) {
            return false;
        }
        this.A06 = false;
        return true;
    }

    public static boolean A0R(AbstractC0670Qk qk) {
        return ((int) (qk.getX() + ((float) qk.getWidth()))) <= ((int) (((float) qk.getWidth()) * 1.3f));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4K
    public final void A0V(ES es, int i) {
        super.A0V(es, i);
        if (i == 0) {
            this.A07 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4K
    public final void A0W(ES es, int i, int i2) {
        super.A0W(es, i, i2);
        this.A07 = false;
        if (this.A04) {
            this.A07 = true;
            A06();
            this.A04 = false;
        }
        int A29 = this.A09.A29();
        int A2A = this.A09.A2A();
        A0E(A29, A2A);
        A0F(A29, A2A);
        A0G(A29, A2A, i);
    }

    public final O3 A0X() {
        return this.A0B;
    }

    public final O4 A0Y() {
        return this.A0C;
    }

    public final O5 A0Z() {
        return this.A0D;
    }

    public final void A0a() {
        this.A01 = -1;
        int A29 = this.A09.A29();
        int A2A = this.A09.A2A();
        while (A29 <= A2A && A29 >= 0) {
            AbstractC0670Qk qk = (AbstractC0670Qk) this.A09.A1r(A29);
            if (qk == null || !qk.A0j()) {
                A29++;
            } else {
                this.A01 = A29;
                qk.A0e();
                return;
            }
        }
    }

    public final void A0b() {
        AbstractC0670Qk qk = (AbstractC0670Qk) this.A09.A1r(this.A01);
        if (qk != null && this.A01 >= 0) {
            qk.A0f();
        }
    }

    public final void A0c(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 39), this.A00);
        bundle.putBoolean(A05(0, 23, 39), this.A05);
        bundle.putBoolean(A05(23, 20, 64), this.A06);
    }

    public final void A0d(OR or) {
        this.A02 = or;
    }
}
