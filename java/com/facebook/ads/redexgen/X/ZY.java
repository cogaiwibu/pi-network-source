package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

public abstract class ZY extends RelativeLayout implements M7 {
    public static String[] A0D;
    public View A00;
    @Nullable
    public L4 A01;
    @Nullable
    public OH A02;
    public boolean A03 = false;
    public boolean A04 = false;
    public AnonymousClass17 A05;
    public final LS A06;
    public final M6 A07;
    public final RQ A08;
    public final C0820Wh A09;
    public final JE A0A;
    public final JL A0B;
    public final M1 A0C;

    static {
        A0L();
    }

    public static void A0L() {
        A0D = new String[]{"fqT9snXDZkE2N6bIU2twhbCcrvrF5wQR", "W8MK3buqarkLhDixdfnbfGeXuw3i87xB", "M5iWaw3OwwKxChS5bTa9KUrj63pwu1Od", "QKu8TlGQ3D7NsDDaY", "OUnrWL6BanKvWJF", "644mHU9zQQHAcSiNB", "MqQzuM0GD0HqxOL2854PPJvoiao7nama", "mSpdOD621tCilusEUOf234Jx9LR3KzyX"};
    }

    public abstract boolean A0X();

    @ToolbarActionView$ToolbarActionMode
    public abstract int getCloseButtonStyle();

    public ZY(C0820Wh wh, JE je, M6 m6, RQ rq) {
        super(wh);
        this.A09 = wh;
        this.A0A = je;
        this.A07 = m6;
        this.A06 = new LS(this);
        this.A08 = rq;
        this.A0B = new JL(this.A08.A0Q(), this.A0A);
        this.A0C = new FullScreenAdToolbar(this.A09, getAudienceNetworkListener(), this.A0B, 0, this.A08.A0E());
    }

    private AnonymousClass1H A0I(int i) {
        if (i == 1) {
            return this.A05.A01();
        }
        AnonymousClass17 r3 = this.A05;
        if (A0D[2].charAt(7) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        strArr[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        return r3.A00();
    }

    private void A0J() {
        removeAllViews();
        C0535Le.A0M(this);
    }

    private void A0K() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (!A0U() || this.A02 != null) {
            this.A07.A3K(this, 0, layoutParams);
            return;
        }
        this.A04 = true;
        this.A02 = new OF(this.A09, this.A08.A0M().A0F(), this.A08.A0O()).A08(this.A08.A0L().A01()).A0B();
        JN.A04(this.A02, this.A0B, JK.A0U);
        this.A07.A3K(this, 0, layoutParams);
        this.A07.A3K(this.A02, 1, layoutParams);
        this.A02.A04(new C0892Zb(this));
    }

    private void A0M(AnonymousClass1H r4, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0C.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0C.A05(r4, z);
        addView(this.A0C, layoutParams);
    }

    public final void A0P() {
        View view = this.A00;
        if (view != null && (view instanceof AbstractC0596No)) {
            if (A0V()) {
                ((AbstractC0596No) this.A00).A0a();
            } else {
                ((AbstractC0596No) this.A00).A0Z();
            }
        }
    }

    public final void A0Q(int i) {
        this.A01 = new L4(i, new C0891Za(this, i));
        this.A03 = true;
        A0P();
        this.A01.A08();
    }

    public final void A0R(View view, boolean z, int i) {
        int toolbarHeight;
        this.A00 = view;
        this.A06.A05(LR.A03);
        A0J();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (z) {
            toolbarHeight = 0;
        } else {
            toolbarHeight = this.A0C.getToolbarHeight();
        }
        layoutParams.setMargins(0, toolbarHeight, 0, 0);
        addView(view, layoutParams);
        AnonymousClass1H A0I = A0I(i);
        A0M(A0I, z);
        C0535Le.A0P(this, A0I.A07(false));
        if (this.A07 != null) {
            A0K();
            String[] strArr = A0D;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            strArr2[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            if (z && Build.VERSION.SDK_INT >= 19) {
                LS ls = this.A06;
                if (A0D[0].charAt(10) != 'o') {
                    String[] strArr3 = A0D;
                    strArr3[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                    strArr3[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                    ls.A05(LR.A04);
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    public final void A0S(AnonymousClass51 r6) {
        int i;
        this.A06.A04(r6.A0I().getWindow());
        this.A05 = this.A08.A0L();
        AnonymousClass19 r1 = null;
        if (!(this.A08.A0M() == null || this.A08.A0M() == null)) {
            r1 = this.A08.A0M();
        }
        M1 m1 = this.A0C;
        AnonymousClass1Q A0O = this.A08.A0O();
        String A0Q = this.A08.A0Q();
        if (r1 != null) {
            i = r1.A0E().A03();
        } else {
            i = 0;
        }
        m1.setPageDetails(A0O, A0Q, i, this.A08.A0P());
        this.A0C.setToolbarListener(new C0894Zd(this, r6));
    }

    public final void A0T(AnonymousClass51 r5) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new MD(this, this, r5));
        startAnimation(alphaAnimation);
    }

    public final boolean A0U() {
        if (!this.A08.A0W().isEmpty()) {
            boolean A0O = this.A08.A0M().A0O();
            if (A0D[6].charAt(3) != 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            strArr[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            if (A0O) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0V() {
        return this.A03;
    }

    public final boolean A0W() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public void AAO(boolean z) {
        L4 l4 = this.A01;
        if (l4 != null && l4.A06()) {
            this.A01.A07();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public void AAl(boolean z) {
        L4 l4 = this.A01;
        if (l4 != null && !l4.A05()) {
            this.A01.A08();
        }
    }

    public JE getAdEventManager() {
        return this.A0A;
    }

    public M6 getAudienceNetworkListener() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public void onDestroy() {
        this.A06.A03();
        this.A0C.setToolbarListener(null);
        A0J();
    }

    public void setListener(M6 m6) {
    }
}
