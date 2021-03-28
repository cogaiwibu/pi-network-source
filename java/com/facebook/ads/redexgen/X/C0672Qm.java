package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.Qm  reason: case insensitive filesystem */
public final class C0672Qm extends AbstractC0596No {
    @Nullable
    public static C0672Qm A0O = null;
    public static byte[] A0P;
    public static String[] A0Q;
    public static final int A0R = ((int) (C0535Le.A01 * 4.0f));
    public static final int A0S = AnonymousClass2G.A01(-1, 77);
    public static final int A0T = ((int) (C0535Le.A01 * 26.0f));
    public static final int A0U = ((int) (C0535Le.A01 * 12.0f));
    public static final int A0V = ((int) (C0535Le.A01 * 8.0f));
    public float A00;
    public int A01 = 0;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public View A06;
    public LinearLayout A07;
    public LinearLayout A08;
    public TextView A09;
    public AnonymousClass16 A0A;
    public N9 A0B;
    public NA A0C;
    @Nullable
    public XS A0D;
    public C0600Ns A0E;
    public O1 A0F;
    public boolean A0G = false;
    public boolean A0H;
    public boolean A0I = false;
    public boolean A0J = false;
    public final View A0K;
    public final AbstractC00260f A0L;
    public final JL A0M;
    public final H2 A0N;

    public static String A0A(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0P, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 122);
        }
        return new String(copyOfRange);
    }

    public static void A0M() {
        A0P = new byte[]{36};
    }

    public static void A0N() {
        A0Q = new String[]{"E7d9V", "HfiTPdnQE6JsOHdYoOA4lRNnbQ3", "7AVXCU5oRbsgBqmorHmAVCwb6r5tuTQ8", "hoWzaZbN7yXesQFa", "a3ZYa3", "EXUfJIeYYGyfdCGOPOS2l0on83CPH94Z", "MYJwByDzw5bCUSkxw6qgTJ7WJbI", "X3l5ZIwYV4"};
    }

    static {
        A0N();
        A0M();
    }

    public C0672Qm(C0600Ns ns) {
        super(ns, true);
        this.A0E = ns;
        this.A0A = this.A0E.A04();
        this.A0M = new JL(ns.A04().A0Q(), ns.A06());
        this.A0N = this.A0E.A0A();
        H2 h2 = this.A0N;
        if (h2 != null) {
            C0535Le.A0N(h2);
        }
        this.A0K = this.A0E.A03();
        this.A0L = C00270g.A01(ns.A05(), ns.A06(), ns.A04().A0Q(), Uri.parse(ns.A04().A0M().A0G().A04()), new HashMap(), false, true);
        C0594Nm.A00(ns.A05(), this, ns.A04().A0M().A0E().A07());
        setupLayoutConfiguration(false);
        A0H();
        A0C();
        A0D();
        postDelayed(new SQ(this), 1000);
        A0L();
    }

    private void A0B() {
        int i;
        C0535Le.A0M(this.A08);
        this.A08 = new LinearLayout(this.A0E.A05());
        C0535Le.A0V(this.A08, getAdContextWrapper());
        if (this.A0G) {
            i = this.A02 / 4;
        } else {
            i = this.A02 / 5;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
        layoutParams.addRule(12);
        this.A08.setLayoutParams(layoutParams);
        addView(this.A08, 2);
    }

    private void A0C() {
        C0535Le.A0M(this.A07);
        this.A07 = new LinearLayout(this.A0E.A05());
        this.A07.setOrientation(1);
        C0535Le.A0N(this.A07);
        A0J();
        this.A07.setBackgroundColor(-1);
        addView(this.A07);
    }

    private void A0D() {
        C0535Le.A0M(this.A0B);
        this.A0B = new N9(this.A0E.A05());
        C0535Le.A0N(this.A0B);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.1f;
        this.A0B.setListener(new C0675Qp(this));
        this.A0B.setOnTouchListener(new View$OnTouchListenerC0604Nw(this));
        this.A07.addView(this.A0B, layoutParams);
        C0535Le.A0M(this.A0C);
        this.A0C = new NA(this.A0E.A05(), null, 16842872);
        this.A07.addView(this.A0C, new LinearLayout.LayoutParams(-1, A0R));
    }

    private void A0E() {
        View view = this.A0K;
        if (view != null) {
            C0535Le.A0M(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractC0596No.A0A, AbstractC0596No.A0A);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(AbstractC0596No.A09, this.A05, AbstractC0596No.A09, AbstractC0596No.A09);
            addView(this.A0K, layoutParams);
        }
    }

    private void A0F() {
        H2 h2 = this.A0N;
        if (h2 != null) {
            C0535Le.A0M(h2);
            H2 h22 = this.A0N;
            int i = A0U;
            h22.setPadding(i, i, i, i);
            this.A0N.A0A(-1, A0S);
            this.A0N.setTranslationY(0.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0T);
            if (this.A0H) {
                layoutParams.addRule(8, this.A06.getId());
            } else {
                String[] strArr = A0Q;
                if (strArr[3].length() != strArr[0].length()) {
                    String[] strArr2 = A0Q;
                    strArr2[3] = "zjul6o0OG2Ezis8Q";
                    strArr2[0] = "LmcEL";
                    layoutParams.addRule(12);
                } else {
                    throw new RuntimeException();
                }
            }
            addView(this.A0N, layoutParams);
        }
    }

    private void A0G() {
        boolean z;
        M1 A082 = this.A0E.A08();
        if (A082 != null) {
            if (this.A0H || A082.A07()) {
                z = false;
            } else {
                z = true;
            }
            A082.setPageDetailsVisible(z);
        }
    }

    private void A0H() {
        int i;
        this.A06 = this.A0E.A02();
        C0535Le.A0M(this.A06);
        C0535Le.A0N(this.A06);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        addView(this.A06, 1, layoutParams);
        this.A09 = new TextView(this.A0E.A05());
        C0535Le.A0N(this.A09);
        this.A09.setGravity(17);
        this.A09.setTextColor(getColors().A05(true));
        this.A09.setEllipsize(TextUtils.TruncateAt.END);
        this.A09.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        int i2 = A0V;
        int i3 = i2 / 2;
        if (this.A0N == null) {
            i = i2;
        } else {
            i = A0T;
        }
        layoutParams2.setMargins(i2, i3, i2, i);
        addView(this.A09, layoutParams2);
        C0535Le.A0N(this.A09);
        C0600Ns ns = this.A0E;
        this.A0F = new O1(ns, ns.A04().A0M().A0G().A03(), getColors(), new SJ(this));
        C0535Le.A0J(1001, this.A0F);
        addView(this.A0F);
        A0K();
        A0B();
    }

    /* access modifiers changed from: private */
    public void A0J() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (this.A03 * 4) / 5);
        if (A0e()) {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(12);
            LinearLayout linearLayout = this.A07;
            String[] strArr = A0Q;
            if (strArr[7].length() != strArr[4].length()) {
                String[] strArr2 = A0Q;
                strArr2[7] = "mOqhFUC5R4";
                strArr2[4] = "x2rQdK";
                linearLayout.setLayoutParams(layoutParams);
            } else {
                throw new RuntimeException();
            }
        } else {
            layoutParams.setMargins(0, this.A03 + 1, 0, 0);
        }
        this.A07.setTranslationY(0.0f);
        this.A07.setLayoutParams(layoutParams);
    }

    private void A0K() {
        int i;
        if (this.A0G) {
            i = this.A02 / 4;
        } else {
            int i2 = this.A02;
            String[] strArr = A0Q;
            if (strArr[6].length() == strArr[1].length()) {
                String[] strArr2 = A0Q;
                strArr2[2] = "bVoeq9MG5etfSqxTxXE6PlzRTEtccpLF";
                strArr2[2] = "bVoeq9MG5etfSqxTxXE6PlzRTEtccpLF";
                i = i2 / 5;
            }
            throw new RuntimeException();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
        layoutParams.addRule(14);
        String[] strArr3 = A0Q;
        if (strArr3[6].length() == strArr3[1].length()) {
            String[] strArr4 = A0Q;
            strArr4[6] = "SHdOplU7mObztTib9yLp7cTgFqT";
            strArr4[1] = "8sjFKcaHqREVec5LNIXiQvlIl9H";
            layoutParams.addRule(2, this.A09.getId());
            layoutParams.setMargins(0, 0, 0, 0);
            this.A0F.setLayoutParams(layoutParams);
            return;
        }
        throw new RuntimeException();
    }

    private void A0L() {
        A0F();
        A0E();
        A0G();
    }

    /* access modifiers changed from: private */
    public void A0R(String str) {
        C0535Le.A0M(this.A0D);
        this.A0D = new XS(this.A0E.A05(), new C0674Qo(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 0.9f;
        this.A07.addView(this.A0D, layoutParams);
        this.A0D.loadUrl(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0S(boolean r17) {
        /*
        // Method dump skipped, instructions count: 336
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0672Qm.A0S(boolean):void");
    }

    private void A0T(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        setupLayoutConfiguration(z);
        C0535Le.A0M(this.A06);
        this.A06 = this.A0E.A02();
        C0535Le.A0N(this.A06);
        if (this.A0H) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.A03 / 5);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            A0C();
            A0D();
        }
        this.A06.setTranslationY(0.0f);
        String[] strArr = A0Q;
        if (strArr[3].length() != strArr[0].length()) {
            String[] strArr2 = A0Q;
            strArr2[7] = "FZuJEB1DgE";
            strArr2[4] = "ioAK5D";
            addView(this.A06, 1, layoutParams);
            A0B();
            A0K();
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0W() {
        super.A0W();
        A0O = null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0X() {
        boolean z;
        M1 A082 = this.A0E.A08();
        if (A082 != null) {
            if (A0e() || A082.A07()) {
                z = false;
            } else {
                z = true;
            }
            A082.setPageDetailsVisible(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0Y() {
        if (this.A0E.A08() != null) {
            M1 A082 = this.A0E.A08();
            String[] strArr = A0Q;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[3] = "MMiJw7TNUivh7iTB";
            strArr2[0] = "GEB80";
            A082.setPageDetailsVisible(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0Z() {
        this.A0J = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0a() {
        this.A0J = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0b(AnonymousClass19 r4, String str, double d, @Nullable Bundle bundle) {
        int i;
        super.A0b(r4, str, d, bundle);
        String A052 = r4.A0F().A05();
        if (A052 == null || A052.trim().length() == 0) {
            C0535Le.A0Q(this.A08, 8);
        } else {
            this.A09.setText(A052);
        }
        if (d > 0.0d) {
            this.A01 = (int) (((double) this.A04) / d);
        }
        if (this.A0G) {
            i = this.A02;
        } else {
            i = this.A01;
        }
        this.A01 = i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0c() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0d(boolean z) {
        if (!A0e()) {
            return false;
        }
        A0S(false);
        return true;
    }

    public final boolean A0e() {
        return this.A0H;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        if (A0e()) {
            return 3;
        }
        if (this.A0J) {
            return 2;
        }
        return super.getCloseButtonStyle();
    }

    private String getUrl() {
        return this.A0E.A04().A0M().A0G().A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0T(A0e());
        A0L();
        setupLayoutConfiguration(A0e());
        A0J();
    }

    private void setupLayoutConfiguration(boolean z) {
        boolean z2;
        int toolbarHeight;
        int i = 0;
        if (getResources().getConfiguration().orientation == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.A0G = z2;
        if (this.A0E.A08() == null) {
            toolbarHeight = 0;
        } else {
            toolbarHeight = this.A0E.A08().getToolbarHeight();
        }
        this.A05 = toolbarHeight;
        this.A0H = z;
        this.A02 = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i2 = this.A02;
        if (!this.A0G) {
            i = this.A05;
        }
        this.A03 = i2 + i;
        this.A01 = this.A02;
    }
}
