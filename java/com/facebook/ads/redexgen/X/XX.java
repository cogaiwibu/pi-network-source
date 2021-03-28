package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public final class XX extends AbstractC0563Mg {
    public static String[] A02;
    public static final int A03 = ((int) (C0535Le.A01 * 8.0f));
    public final RelativeLayout A00 = new RelativeLayout(getContext());
    public final C0820Wh A01;

    public static void A0C() {
        A02 = new String[]{"ixUXsyhysd", "OPv8qP0MhbtkKZTtC7nh2I9a6WHAwpWs", "vXGbyjT4IhQUpn", "fkCzuvVfwHm7OJpjmgBYeP3AajMmrNF6", "BQFEEs7xBV9CwTHtkGRziYqWB8GhQG3x", "ODdJk2", "", "xXrbtEFvrY2"};
    }

    static {
        A0C();
    }

    public XX(C0820Wh wh, JE je, String str, AnonymousClass1Q r7, M7 m7, M6 m6) {
        super(wh, je, str, r7, m7, m6);
        this.A01 = wh;
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        C0535Le.A0P(this.A00, -1728053248);
        this.A00.setOnClickListener(new View$OnClickListenerC0568Ml(this));
    }

    public static RelativeLayout.LayoutParams A0A(boolean z) {
        int i;
        if (z) {
            i = -1;
        } else {
            i = -2;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
        if (A02[7].length() != 30) {
            String[] strArr = A02;
            strArr[2] = "p8zovDyK5QtHis";
            strArr[0] = "GXgRrx0bJv";
            layoutParams.addRule(12);
            return layoutParams;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    private void A0B() {
        if (Build.VERSION.SDK_INT >= 21) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
            C0535Le.A0Z(this, transitionSet);
            return;
        }
        C0535Le.A0X(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0K() {
        AnonymousClass26 A032 = AnonymousClass23.A03(this.A01.A00());
        C0577Mv adChoicesView = new C0577Mv(this.A01);
        adChoicesView.setInfo(EnumC0543Lm.HIDE_AD, AnonymousClass23.A0B(this.A01.A00()), AnonymousClass23.A0A(this.A01.A00()));
        adChoicesView.setOnClickListener(new View$OnClickListenerC0569Mm(this));
        AnonymousClass26 A04 = AnonymousClass23.A04(this.A01.A00());
        C0577Mv mv = new C0577Mv(this.A01);
        mv.setInfo(EnumC0543Lm.REPORT_AD, AnonymousClass23.A0F(this.A01.A00()), AnonymousClass23.A0E(this.A01.A00()));
        mv.setOnClickListener(new View$OnClickListenerC0570Mn(this));
        C0577Mv mv2 = new C0577Mv(this.A01);
        mv2.setInfo(EnumC0543Lm.AD_CHOICES_ICON, AnonymousClass23.A0G(this.A01.A00()), "");
        mv2.setOnClickListener(new View$OnClickListenerC0571Mo(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        int i = A03;
        linearLayout.setPadding(i * 2, i, i * 2, i);
        C0535Le.A0P(linearLayout, -1);
        if (!A032.A05().isEmpty()) {
            linearLayout.addView(adChoicesView, layoutParams);
        }
        if (!A04.A05().isEmpty()) {
            linearLayout.addView(mv, layoutParams);
        }
        linearLayout.addView(mv2, layoutParams);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0L() {
        C0535Le.A0L(this);
        this.A00.removeAllViews();
        C0535Le.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0M(AnonymousClass26 r6, AnonymousClass24 r7) {
        boolean z;
        String A08;
        EnumC0543Lm lm;
        int i;
        String str;
        if (r7 != AnonymousClass24.A04) {
            if (r7 == AnonymousClass24.A05) {
                z = true;
            } else {
                z = false;
            }
            C0561Me me = new C0561Me(this.A01, this.A0A);
            if (z) {
                A08 = AnonymousClass23.A09(this.A01.A00());
            } else {
                A08 = AnonymousClass23.A08(this.A01.A00());
            }
            C0561Me A0F = me.A0I(A08).A0H(AnonymousClass23.A07(this.A01.A00())).A0F(r6.A04());
            if (z) {
                lm = EnumC0543Lm.REPORT_AD;
            } else {
                lm = EnumC0543Lm.HIDE_AD;
            }
            C0561Me A0E = A0F.A0E(lm);
            if (z) {
                i = -552389;
            } else {
                i = -13272859;
            }
            C0561Me A0D = A0E.A0D(i);
            if (this.A09 != null) {
                str = this.A09.A01();
            } else {
                str = "";
            }
            C0562Mf A0M = A0D.A0G(str).A0M();
            C0535Le.A0P(A0M, -1);
            C0535Le.A0X(this);
            this.A00.removeAllViews();
            this.A00.addView(A0M, A0A(true));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0N(AnonymousClass26 r11, AnonymousClass24 r12) {
        boolean z;
        String A0B;
        EnumC0543Lm lm;
        if (r12 == AnonymousClass24.A05) {
            z = true;
        } else {
            z = false;
        }
        C0820Wh wh = this.A01;
        AbstractC0565Mi mi = this.A0A;
        if (z) {
            A0B = AnonymousClass23.A0F(this.A01.A00());
        } else {
            A0B = AnonymousClass23.A0B(this.A01.A00());
        }
        if (z) {
            lm = EnumC0543Lm.REPORT_AD;
        } else {
            lm = EnumC0543Lm.HIDE_AD;
        }
        C0580My my = new C0580My(wh, r11, mi, A0B, lm);
        my.setClickable(true);
        C0535Le.A0P(my, -1);
        int i = A03;
        my.setPadding(i * 2, i, i * 2, i);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(my, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final boolean A0O() {
        return false;
    }
}
