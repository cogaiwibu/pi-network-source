package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.85  reason: invalid class name */
public final class AnonymousClass85 extends QZ {
    public static byte[] A0K;
    public static String[] A0L;
    @Nullable
    public AbstractC0596No A00;
    @Nullable
    public EnumC0626Os A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final AbstractC01474z A08 = new P7(this);
    public final C0612Oe A09;
    public final C0532Lb A0A;
    public final AnonymousClass7w A0B;
    public final K4 A0C = new AnonymousClass87(this);
    public final K2 A0D = new AnonymousClass86(this);
    public final AbstractC0506Jy A0E = new AnonymousClass8A(this);
    public final AbstractC0494Jk A0F = new AnonymousClass8D(this);
    public final JH A0G = new AnonymousClass8e(this);
    public final AbstractC0464Ie A0H = new AnonymousClass88(this);
    public final HS A0I;
    public final H2 A0J;

    static {
        A09();
        A08();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0K = new byte[]{-3, 21, 7, 5, 21, -1, -38, -51, -56, -55, -45};
    }

    public static void A09() {
        A0L = new String[]{"Mriq29lS8vjEPztqvg4mnlhqPa1pf4jw", "J0ebGdEZD5oKohgNzUxMA3JiHaSF4bRJ", "IT9tvlYp44pYwsfxgtsksFS", "El43mrOkb3qqMjbYlNbneDDC3riKbt8u", "SsyQgLhJr8BA6K4Jeu0226NIXlotTSUK", "5pKSfcHcmxRzGJ6MCKbxSHPk9j0pnkgf", "vZ9Xs81YGHnjRjGsoTeSsIOHxP", "Y9Sammkz"};
    }

    public AnonymousClass85(C0820Wh wh, AbstractC0558Mb mb, JE je, AnonymousClass16 r11, AnonymousClass7H r12, M6 m6) {
        super(wh, mb, je, r11, r12, m6);
        boolean z;
        boolean z2 = false;
        this.A06 = false;
        this.A07 = false;
        this.A05 = false;
        this.A03 = false;
        this.A0A = new C0532Lb(super.A03);
        this.A0A.setFunnelLoggingHandler(super.A05);
        this.A0A.getEventBus().A04(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
        this.A0B = new AnonymousClass7w(super.A03, super.A04, this.A0A, super.A01.A0Q());
        this.A09 = new C0612Oe(super.A03, super.A09, super.A01.A0V(), m6);
        this.A0I = new HS(super.A03, super.A05);
        this.A0J = new H2(super.A03);
        A07();
        this.A0A.setVideoURI(super.A02.A0M(super.A01.A0M().A0E().A08()));
        A05();
        if (super.A01.A0M().A0E().A03() <= 0) {
            z = true;
        } else {
            z = false;
        }
        this.A04 = z;
        if (super.A01.A0M().A0L() && super.A01.A0M().A0E().A02() > 0) {
            z2 = true;
        }
        this.A02 = z2;
        C0535Le.A0P(this, super.A01.A0L().A01().A07(true));
    }

    private AbstractC0596No A00(int i) {
        return C0597Np.A00(new C0599Nr(super.A03, super.A04, super.A08, super.A01, this.A0A, super.A0A, super.A06).A0D(super.A07.getToolbarHeight()).A0F(super.A07).A0C(i).A0E(this.A0I).A0G(this.A0J).A0H(), null, true);
    }

    private void A04() {
        this.A0A.postDelayed(new P5(this), (long) J8.A0I(super.A03));
    }

    private void A05() {
        this.A0A.postDelayed(new P0(this), (long) J8.A0J(super.A03));
    }

    private void A06() {
        this.A04 = true;
        AbstractC0596No no = this.A00;
        if (no != null) {
            no.A0Z();
        }
    }

    /* JADX INFO: Multiple debug info for r5v0 'this'  com.facebook.ads.redexgen.X.85: [D('touchPlayPausePlugin' com.facebook.ads.redexgen.X.7B), D('placeholderImagePlugin' com.facebook.ads.redexgen.X.7a)] */
    private void A07() {
        this.A0A.A0Z(this.A0J);
        this.A0A.A0Z(this.A0I);
        if (!TextUtils.isEmpty(super.A01.A0M().A0E().A07())) {
            C01997a r1 = new C01997a(super.A03);
            this.A0A.A0Z(r1);
            r1.setImage(super.A01.A0M().A0E().A07());
        }
        AnonymousClass7B r4 = new AnonymousClass7B(super.A03, true, super.A05);
        this.A0A.A0Z(r4);
        this.A0A.A0Z(new HU(r4, P4.A03, true));
        this.A0A.A0Z(new AnonymousClass7R(super.A03));
    }

    /* access modifiers changed from: private */
    public void A0E(AnonymousClass7v r5, boolean z) {
        if (!this.A05) {
            this.A05 = true;
            if (!this.A04) {
                A06();
            }
            AbstractC0596No no = this.A00;
            if (A0L[6].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A0L;
            strArr[1] = "skYYV88BTcDGkk1Ge0IaKZH0HqJ76mgM";
            strArr[1] = "skYYV88BTcDGkk1Ge0IaKZH0HqJ76mgM";
            if (no != null) {
                no.A0K(r5);
            }
            super.A07.setToolbarActionMode(getCloseButtonStyle());
            super.A07.setToolbarActionMessage(A03(0, 0, 25));
            A0I(z);
        }
    }

    /* access modifiers changed from: private */
    public void A0F(C02137s r5) {
        if (this.A0A.getState() == EnumC0638Pe.A02 && J8.A0w(super.A03)) {
            this.A0A.postDelayed(new P8(this, r5), 5000);
        }
    }

    /* access modifiers changed from: private */
    public void A0G(C02137s r7) {
        int A002 = r7.A00();
        float min = ((float) A002) / Math.min(((float) super.A01.A0M().A0E().A03()) * 1000.0f, (float) this.A0A.getDuration());
        super.A07.setProgress(100.0f * min);
        if (min >= 1.0f && !this.A04) {
            A06();
            super.A07.setToolbarActionMode(getCloseButtonStyle());
        }
        if (this.A02) {
            int A022 = super.A01.A0M().A0E().A02() - (A002 / 1000);
            if (A022 > 0) {
                AnonymousClass16 r3 = super.A01;
                String[] strArr = A0L;
                if (strArr[2].length() != strArr[7].length()) {
                    String[] strArr2 = A0L;
                    strArr2[0] = "PXM0w4DTcyhv6xVVxlaJPbpxowOdlGPl";
                    strArr2[4] = "ZagmJHoPVKqTZKI94Zh80WtjAbW4VeCE";
                    super.A07.setToolbarActionMessage(r3.A0P().A00().replace(A03(0, 6, 74), String.valueOf(A022)));
                    return;
                }
                throw new RuntimeException();
            }
            super.A07.setToolbarActionMessage(A03(0, 0, 25));
            A0I(false);
        }
    }

    /* access modifiers changed from: private */
    public void A0H(String str) {
        int i = 0;
        int i2 = 0;
        C0532Lb lb = this.A0A;
        if (lb != null) {
            i = lb.getCurrentPositionInMillis();
            i2 = this.A0A.getDuration();
        }
        super.A03.A04().A82(A03(6, 5, 12), C02248i.A2B, new C02258j(str));
        if (J8.A0x(super.A03)) {
            A0E(new AnonymousClass7v(i, i2), false);
            return;
        }
        M6 m6 = super.A08;
        if (A0L[3].charAt(0) != 'z') {
            String[] strArr = A0L;
            strArr[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
            strArr[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
            m6.A3s(super.A09.A6C());
            super.A08.A3s(super.A09.A67());
            return;
        }
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass85.A0L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r2[2].length() == r2[7].length()) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        r2 = com.facebook.ads.redexgen.X.AnonymousClass85.A0L;
        r2[6] = "pCCqOlrdcXyBK9Nv0jyTBmGbmh";
        r2[6] = "pCCqOlrdcXyBK9Nv0jyTBmGbmh";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void A0I(boolean r6) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.A0I(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final void A0R() {
        float f;
        C0535Le.A0O(this.A00);
        C0535Le.A0O(super.A07);
        C0532Lb lb = this.A0A;
        if (super.A01.A0M().A0E().A09()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        lb.setVolume(f);
        this.A0A.A0Y(EnumC0626Os.A03, 20);
        AbstractC0596No no = this.A00;
        if (no != null && this.A02) {
            no.A0Y();
        }
        AbstractC0596No no2 = this.A00;
        if (no2 != null && !this.A04) {
            no2.A0a();
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final void A0T(AnonymousClass51 r5) {
        boolean z;
        r5.A0L(this.A08);
        this.A00 = A00(r5.A0I().getResources().getConfiguration().orientation);
        addView(this.A00, QZ.A0D);
        addView(super.A07, new FrameLayout.LayoutParams(-1, super.A07.getToolbarHeight()));
        C0535Le.A0K(this.A00);
        C0535Le.A0K(super.A07);
        AbstractC0596No no = this.A00;
        if (no == null || !no.A0c()) {
            z = false;
        } else {
            z = true;
        }
        setUpFullscreenMode(z);
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final boolean A0U() {
        AbstractC0596No no = this.A00;
        return no != null && no.A0d(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAO(boolean z) {
        if (!this.A0A.A0f()) {
            this.A01 = this.A0A.getVideoStartReason();
            this.A03 = z;
            this.A0A.A0b(false, 13);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAl(boolean z) {
        if (!this.A0A.A0g() && !this.A05 && this.A0A.getState() != EnumC0638Pe.A06 && this.A01 != null) {
            if (!this.A03 || z) {
                C0532Lb lb = this.A0A;
                EnumC0626Os os = this.A01;
                String[] strArr = A0L;
                if (strArr[0].charAt(8) != strArr[4].charAt(8)) {
                    String[] strArr2 = A0L;
                    strArr2[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
                    strArr2[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
                    lb.A0Y(os, 19);
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    private int getCloseButtonStyle() {
        AbstractC0596No no = this.A00;
        if (no != null) {
            return no.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.QZ, com.facebook.ads.redexgen.X.M7
    public final void onDestroy() {
        super.onDestroy();
        AbstractC0596No no = this.A00;
        if (no != null) {
            no.A0W();
        }
        C0532Lb lb = this.A0A;
        if (lb != null) {
            if (!this.A05) {
                lb.A0X(EnumC0622Oo.A03);
            }
            this.A0A.getEventBus().A05(this.A0G, this.A0F, this.A0E, this.A0H, this.A0C, this.A0D);
            this.A0A.A0S();
        }
        this.A0B.A0h();
    }
}
