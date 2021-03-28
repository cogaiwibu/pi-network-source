package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.facebook.ads.RewardData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Xt  reason: case insensitive filesystem */
public final class C0858Xt extends RelativeLayout implements M7, MQ {
    public static byte[] A0j;
    public static String[] A0k;
    public static final int A0l = ((int) (C0535Le.A01 * 250.0f));
    public static final int A0m = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0n = ((int) (C0535Le.A01 * 10.0f));
    public static final int A0o = ((int) (C0535Le.A01 * 18.0f));
    public static final int A0p = ((int) (C0535Le.A01 * 28.0f));
    public static final int A0q = ((int) (C0535Le.A01 * 16.0f));
    public static final RelativeLayout.LayoutParams A0r = new RelativeLayout.LayoutParams(-1, -1);
    public static final int A0s = ((int) (C0535Le.A01 * 4.0f));
    public static final int A0t = AnonymousClass2G.A01(-1, 77);
    public static final int A0u = AnonymousClass2G.A01(A0t, 90);
    public static final int A0v = ((int) (C0535Le.A01 * 26.0f));
    public static final int A0w = ((int) (C0535Le.A01 * 12.0f));
    public int A00;
    public int A01 = -1;
    @Nullable
    public View A02;
    public View A03;
    @Nullable
    public M1 A04;
    @Nullable
    public M6 A05;
    @Nullable
    public NX A06;
    public C0611Od A07;
    public C0612Oe A08;
    @Nullable
    public C0532Lb A09;
    @Nullable
    public EnumC0626Os A0A;
    public C0442Hi A0B;
    @Nullable
    public HU A0C;
    @Nullable
    public AnonymousClass7B A0D;
    @Nullable
    public C0419Gl A0E;
    public C0414Gg A0F;
    public boolean A0G = false;
    public boolean A0H = false;
    public boolean A0I = false;
    public boolean A0J = false;
    public final int A0K;
    public final Handler A0L = new Handler(Looper.getMainLooper());
    public final Handler A0M = new Handler();
    public final RelativeLayout A0N;
    public final AnonymousClass1H A0O;
    public final RR A0P;
    public final AbstractC01474z A0Q = new Y6(this);
    public final C0820Wh A0R;
    public final JE A0S;
    public final JL A0T;
    public final LS A0U;
    public final LX A0V = new LX();
    public final AnonymousClass7w A0W;
    public final K4 A0X = new C02609s(this);
    public final K2 A0Y = new C02599r(this);
    public final AbstractC0494Jk A0Z = new C02579p(this);
    public final JH A0a = new C02589q(this);
    public final AbstractC0464Ie A0b = new C02569o(this);
    public final HS A0c;
    public final H2 A0d;
    @DoNotStrip
    public final AbstractC0640Pg A0e;
    public final C0641Ph A0f;
    public final AtomicBoolean A0g = new AtomicBoolean(false);
    public final boolean A0h;
    public final boolean A0i;

    public static String A0F(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0j, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 83);
        }
        return new String(copyOfRange);
    }

    public static void A0S() {
        A0j = new byte[]{29, 16, 11, 12, 22};
    }

    public static void A0T() {
        A0k = new String[]{"vsdEBwVgd8xuD4acIyCMTbEVgnYoxSzn", "ksTg5", "PS2LqNPtHz7Bj2TqhJ7TZjs4LL9ATMRr", "qSNvo2HWKXxTUkx77WQBoFZa4uZWek8Z", "kV", "kWwRq1ENXLXBTFEhopAwPvilnneCtOoi", "1j3TsCoxoqnujqaJP1b9vcmgNjtc01PK", "DySaXvgrVXG8E60xfPO0YxcmTr0eS0sa"};
    }

    static {
        A0T();
        A0S();
    }

    public C0858Xt(C0820Wh wh, JE je, C0532Lb lb, M6 m6, RR rr) {
        super(wh);
        float f;
        this.A0R = wh;
        this.A0h = false;
        this.A0i = J8.A1e(this.A0R);
        this.A05 = m6;
        this.A0S = je;
        this.A0P = rr;
        this.A0T = new JL(this.A0P.A0Q(), this.A0S);
        this.A09 = lb;
        this.A09.setFunnelLoggingHandler(this.A0T);
        this.A0O = this.A0P.A0L().A01();
        this.A0N = new RelativeLayout(wh);
        this.A0d = new H2(this.A0R);
        this.A0c = new HS(this.A0R, this.A0T);
        AnonymousClass1C A0E2 = this.A0P.A0M().A0E();
        this.A0K = Math.min(A0E2.A02(), A0E2.A04());
        C0532Lb lb2 = this.A09;
        if (A0E2.A09()) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        lb2.setVolume(f);
        this.A03 = new View(this.A0R);
        C0535Le.A0N(this.A03);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        this.A03.setLayoutParams(layoutParams);
        this.A0e = new Y4(this);
        this.A0f = new C0641Ph(this, 1, new WeakReference(this.A0e), wh);
        this.A0f.A0Y(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
        this.A0W = new AnonymousClass7w(this.A0R, this.A0S, this.A09, this.A0P.A0Q());
        this.A07 = new C0611Od(this.A0R, this.A0S, this.A0P);
        this.A08 = new C0612Oe(this.A0R, new C0841Xc(), this.A0P.A0V(), this.A05);
        new AsyncTaskC0831Ws(this, wh).A08(A0E2.A07());
        this.A09.setVideoProgressReportIntervalMs(rr.A0F());
        this.A09.getEventBus().A04(this.A0X, this.A0Y, this.A0a, this.A0Z, this.A0b);
        wh.A0A().A2q();
        this.A0U = new LS(this);
        this.A0U.A05(LR.A03);
    }

    private void A0H() {
        C0820Wh wh = this.A0R;
        if (wh != null) {
            FrameLayout frameLayout = new FrameLayout(wh);
            frameLayout.setLayoutParams(A0r);
            C0535Le.A0P(frameLayout, 1711276032);
            this.A0N.addView(frameLayout, 0);
        }
    }

    /* access modifiers changed from: private */
    public void A0I() {
        M6 m6 = this.A05;
        if (m6 != null) {
            m6.A3s(EnumC0628Ou.A08.A02());
        }
    }

    private void A0J() {
        NX nx = this.A06;
        if (nx != null) {
            nx.removeAllViews();
            this.A0N.removeView(this.A0d);
            NX nx2 = this.A06;
            nx2.setLayoutParams(nx2.A0C(this.A03));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C0905Zs.A0G);
            layoutParams.addRule(12);
            this.A0N.addView(this.A0d, layoutParams);
        }
    }

    private void A0K() {
        NX nx = this.A06;
        if (nx != null) {
            nx.removeAllViews();
            this.A0N.removeView(this.A0d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C0905Zs.A0H);
            layoutParams.setMargins(0, 0, 0, C0905Zs.A0I);
            this.A06.addView(this.A0d, layoutParams);
            NX nx2 = this.A06;
            nx2.setLayoutParams(nx2.A0C(this.A03));
        }
    }

    /* access modifiers changed from: private */
    public void A0L() {
        this.A0I = true;
        C0535Le.A0X(this.A0N);
        C0532Lb lb = this.A09;
        if (lb != null) {
            lb.A0U();
            this.A09.setVisibility(4);
        }
        M1 m1 = this.A04;
        if (m1 != null) {
            m1.setPageDetailsVisible(false);
            this.A04.setToolbarActionMode(0);
            this.A04.setToolbarActionMessage(A0F(0, 0, 87));
            C0535Le.A0d(this.A09, this.A0c, this.A0d);
            Pair<EnumC0610Oc, View> A032 = this.A07.A03(getCTAButton());
            this.A02 = (View) A032.second;
            int i = ML.A00[((EnumC0610Oc) A032.first).ordinal()];
            if (i == 1) {
                if (J8.A1M(this.A0R) && this.A06 != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    NX nx = this.A06;
                    nx.setLayoutParams(nx.A0B(this.A03));
                    if (getResources().getConfiguration().orientation == 1) {
                        layoutParams.setMargins(0, this.A04.getToolbarHeight(), 0, A0n);
                        layoutParams.addRule(2, this.A06.getId());
                    } else {
                        int i2 = A0n;
                        layoutParams.setMargins(0, i2, 0, i2);
                        layoutParams.addRule(0, this.A03.getId());
                    }
                    this.A0N.addView((View) A032.second, layoutParams);
                } else if (!this.A0i) {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(0, this.A04.getToolbarHeight(), 0, 0);
                    this.A0N.addView((View) A032.second, layoutParams2);
                    NX nx2 = this.A06;
                    if (nx2 != null) {
                        int id = nx2.getId();
                        if (A0k[4].length() != 2) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A0k;
                        strArr[2] = "unAGmyqFwvprojiFSqdEJubKYqzfvtr5";
                        strArr[2] = "unAGmyqFwvprojiFSqdEJubKYqzfvtr5";
                        layoutParams2.addRule(2, id);
                    }
                } else {
                    this.A0N.addView((View) A032.second);
                }
                NX nx3 = this.A06;
                if (nx3 != null) {
                    nx3.setVisibility(0);
                    this.A06.A0E(true);
                }
                A0Q();
                this.A0V.A06();
            } else if (i == 2) {
                C0535Le.A0d(this.A06);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                int i3 = A0q;
                layoutParams3.setMargins(i3, i3, i3, i3);
                this.A0N.addView((View) A032.second, layoutParams3);
                this.A0V.A06();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x017b, code lost:
        if (r4 != false) goto L_0x017d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0M() {
        /*
        // Method dump skipped, instructions count: 601
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0858Xt.A0M():void");
    }

    /* access modifiers changed from: private */
    public void A0N() {
        String A072;
        if (J8.A1Q(this.A0R)) {
            this.A04.A06(this);
            return;
        }
        RewardData A0K2 = this.A0P.A0K();
        if (A0K2 == null) {
            A072 = this.A0P.A0N().A06();
        } else {
            A072 = this.A0P.A0N().A07(A0K2.getCurrency(), A0K2.getQuantity());
        }
        MF mf = new MF(this.A0R, -1, ViewCompat.MEASURED_STATE_MASK, A072, null, this.A0P.A0N().A05(), this.A0P.A0N().A04(), C0544Ln.A00(EnumC0543Lm.REWARD_ICON));
        mf.A02.setOnClickListener(new MJ(this, mf));
        mf.A01.setOnClickListener(new MK(this, mf));
        C0535Le.A0K(this.A0N);
        C0535Le.A0K(this.A04);
        C0535Le.A0P(mf, 1711276032);
        mf.setClickable(true);
        C0532Lb lb = this.A09;
        if (lb != null && !lb.A0g()) {
            this.A09.A0c(false, false, 16);
        }
        addView(mf, new RelativeLayout.LayoutParams(-1, -1));
        mf.bringToFront();
    }

    private void A0O() {
        if (this.A0P.A0M().A0O() && this.A05 != null) {
            OH A0B2 = new OF(this.A0R, this.A0P.A0M().A0F(), this.A0P.A0O()).A08(this.A0P.A0L().A01()).A0B();
            JN.A04(A0B2, this.A0T, JK.A0U);
            this.A05.A3K(A0B2, 1, A0r);
            A0B2.bringToFront();
            A0B2.A04(new Y0(this));
            this.A0R.A0A().A2b();
        }
    }

    /* access modifiers changed from: private */
    public void A0P() {
        C0532Lb lb = this.A09;
        if (lb != null) {
            lb.A0Y(EnumC0626Os.A03, 22);
            postDelayed(new Y9(this), (long) J8.A0I(getContext()));
        }
    }

    private void A0Q() {
        C0611Od od;
        boolean z;
        int i;
        int i2;
        int i3;
        int toolbarHeight;
        if (this.A0i && this.A02 != null && (od = this.A07) != null && od.A04() == EnumC0610Oc.A04) {
            int i4 = -1;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (this.A00 == 2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i = getToolbarHeight();
            } else {
                i = A0n;
            }
            if (!z) {
                i2 = 0;
            } else {
                i2 = A0n;
            }
            layoutParams.setMargins(0, i, 0, i2);
            NW nw = (NW) ((ES) this.A02).getAdapter();
            nw.A08();
            nw.A0G(this.A00, this.A0i);
            NX nx = this.A06;
            if (nx != null) {
                if (z) {
                    nx.A0D(this.A00);
                } else {
                    int id = nx.getId();
                    String[] strArr = A0k;
                    if (strArr[5].charAt(31) != strArr[3].charAt(31)) {
                        String[] strArr2 = A0k;
                        strArr2[0] = "LwDo8VVUwsuJrlNU8QrzJ41vhXhK4VzE";
                        strArr2[7] = "9aOkUkxqZvQgWgLWjLrmfK9aYM0kVuqh";
                        layoutParams.addRule(2, id);
                    } else {
                        throw new RuntimeException();
                    }
                }
                if (!z) {
                    i3 = -1;
                } else {
                    i3 = A0l;
                }
                if (!z) {
                    i4 = -2;
                }
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i4);
                layoutParams2.addRule(12);
                NX nx2 = this.A06;
                int i5 = A0q;
                if (!z) {
                    toolbarHeight = i5;
                } else {
                    toolbarHeight = getToolbarHeight() + i5;
                }
                int i6 = A0q;
                nx2.setPadding(i5, toolbarHeight, i6, i6);
                this.A06.setLayoutParams(layoutParams2);
            }
            this.A02.setLayoutParams(layoutParams);
            this.A02.setOverScrollMode(2);
        }
    }

    /* access modifiers changed from: private */
    public void A0R() {
        int i;
        HS hs = this.A0c;
        if (this.A0g.get()) {
            i = 0;
        } else {
            i = 8;
        }
        hs.setVisibility(i);
        this.A0c.A0A();
    }

    private final void A0U() {
        if (this.A06 != null) {
            this.A0B = new C0442Hi(true);
            C0419Gl gl = this.A0E;
            if (gl != null) {
                this.A0B.A0J(gl);
            }
            AnonymousClass1H A012 = this.A0P.A0L().A01();
            this.A0B.A0J(new C0415Gh(this.A06.getCTAButton(), 300, A012.A08(true), -14934495));
            this.A0B.A0J(new C0420Gm(this.A06.getCTAButton(), 300, C0535Le.A09(A0t, A0u, A0s), C0535Le.A06(A012.A08(true), A0s)));
            this.A0B.A0J(new C0416Gi(this.A06.getExpandableLayout(), IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, false));
            this.A0B.A0I(IronSourceConstants.IS_AUCTION_FAILED);
            this.A0B.A7s(this.A09);
        }
    }

    private final void A0V() {
        C0532Lb lb = this.A09;
        if (lb != null) {
            lb.A0W(2);
            this.A09.A0S();
        }
        C0641Ph ph = this.A0f;
        if (ph != null) {
            ph.A0X();
        }
    }

    /* access modifiers changed from: private */
    public void A0d(AnonymousClass7v r3) {
        if (!this.A0I) {
            this.A08.A06();
            A0L();
            M6 m6 = this.A05;
            if (m6 != null) {
                m6.A3t(EnumC0628Ou.A06.A02(), r3);
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0e(String str) {
        this.A0R.A0A().A2r(str);
        int i = 0;
        int i2 = 0;
        C0532Lb lb = this.A09;
        if (lb != null) {
            i = lb.getCurrentPositionInMillis();
            i2 = this.A09.getDuration();
        }
        A0V();
        this.A0R.A04().A82(A0F(0, 5, 84), C02248i.A2B, new C02258j(str));
        if (J8.A0x(this.A0R)) {
            A0d(new AnonymousClass7v(i, i2));
            return;
        }
        M6 m6 = this.A05;
        if (m6 != null) {
            m6.A3s(EnumC0628Ou.A09.A02());
        }
    }

    /* access modifiers changed from: private */
    public boolean A0f() {
        C0532Lb lb = this.A09;
        return lb != null && lb.getCurrentPositionInMillis() / 1000 >= this.A0P.A0M().A0E().A02();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A7r(Intent intent, Bundle bundle, AnonymousClass51 r7) {
        if (this.A09 != null) {
            M6 m6 = this.A05;
            if (A0k[2].charAt(24) != 'V') {
                String[] strArr = A0k;
                strArr[0] = "e6V6RqcsweZ5TPTb9FgQuQ0pryALZ0j5";
                strArr[7] = "lv4Tf42JMHAUVPcypCqljFxIq3tnjr4p";
                if (m6 != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.A0U.A05(LR.A04);
                    }
                    A0M();
                    r7.A0L(this.A0Q);
                    this.A09.setVideoURI(new AnonymousClass7H(this.A0R).A0M(this.A0P.A0M().A0E().A08()));
                    setUpContentLayoutForVideo(r7.A0I().getResources().getConfiguration().orientation);
                    addView(this.A0N, A0r);
                    M1 m1 = this.A04;
                    if (m1 != null) {
                        C0535Le.A0N(m1);
                        this.A04.A05(this.A0O, true);
                        addView(this.A04, new RelativeLayout.LayoutParams(-1, this.A04.getToolbarHeight()));
                    }
                    this.A05.A3K(this, 0, A0r);
                    A0O();
                    postDelayed(new Y1(this), (long) J8.A0J(getContext()));
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final void A8o() {
        C0532Lb lb = this.A09;
        if (lb != null) {
            EnumC0626Os os = EnumC0626Os.A03;
            if (A0k[6].charAt(1) != 'j') {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[6] = "Tj2Tj3snk4deQrW2TFaqKUqYHOA0aFA3";
            strArr[6] = "Tj2Tj3snk4deQrW2TFaqKUqYHOA0aFA3";
            lb.A0Y(os, 23);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MQ
    public final void A8p() {
        A0L();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAO(boolean z) {
        C0532Lb lb = this.A09;
        if (lb != null && !lb.A0f()) {
            this.A0A = this.A09.getVideoStartReason();
            this.A0H = z;
            C0532Lb lb2 = this.A09;
            if (A0k[1].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[4] = "af";
            strArr[4] = "af";
            lb2.A0b(false, 14);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAl(boolean z) {
        C0532Lb lb = this.A09;
        if (lb != null && !lb.A0g() && !this.A0I && this.A09.getState() != EnumC0638Pe.A06 && this.A0A != null) {
            if (!this.A0H || z) {
                C0532Lb lb2 = this.A09;
                String[] strArr = A0k;
                if (strArr[0].charAt(9) != strArr[7].charAt(9)) {
                    String[] strArr2 = A0k;
                    strArr2[1] = "7lFur";
                    strArr2[1] = "7lFur";
                    lb2.A0Y(this.A0A, 21);
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void ACg(Bundle bundle) {
    }

    @Nullable
    private View$OnClickListenerC0827Wo getCTAButton() {
        if (this.A05 == null) {
            return null;
        }
        View$OnClickListenerC0827Wo wo = new View$OnClickListenerC0827Wo(this.A0R, EnumC0628Ou.A04.A02(), this.A0O, this.A0S, this.A05, this.A0f, this.A0V);
        wo.setRoundedCornersEnabled(true);
        wo.setViewShowsOverMedia(true);
        C0535Le.A0J(1001, wo);
        wo.setCta(this.A0P.A0M().A0G(), this.A0P.A0Q(), new HashMap());
        return wo;
    }

    private int getToolbarHeight() {
        M1 m1 = this.A04;
        return m1 == null ? M1.A00 : m1.getToolbarHeight();
    }

    /* JADX INFO: Multiple debug info for r7v0 android.content.res.Configuration: [D('simpleVideoViewParams' android.widget.RelativeLayout$LayoutParams), D('screenshotParams' android.widget.RelativeLayout$LayoutParams)] */
    public final void onConfigurationChanged(Configuration configuration) {
        C0419Gl gl;
        if (!J8.A1M(this.A0R) || this.A06 == null) {
            NX nx = this.A06;
            if (A0k[1].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A0k;
            strArr[2] = "taNSjGkhdG2DcrPTICkef1XKgKxpKPDd";
            strArr[2] = "taNSjGkhdG2DcrPTICkef1XKgKxpKPDd";
            if (nx != null) {
                nx.A0D(configuration.orientation);
                if (this.A0h && (gl = this.A0E) != null) {
                    gl.A09(this.A06.A09(configuration.orientation));
                }
            }
        } else {
            boolean z = true;
            if (configuration.orientation != 1) {
                z = false;
            }
            if (this.A02 != null && this.A04 != null) {
                this.A06.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                NX nx2 = this.A06;
                nx2.setLayoutParams(nx2.A0B(this.A03));
                if (z) {
                    layoutParams.setMargins(0, this.A04.getToolbarHeight(), 0, A0n);
                    layoutParams.addRule(2, this.A06.getId());
                } else {
                    int i = A0n;
                    layoutParams.setMargins(0, i, 0, i);
                    layoutParams.addRule(0, this.A03.getId());
                }
                this.A02.setLayoutParams(layoutParams);
            } else if (this.A09 != null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                if (z) {
                    A0K();
                    layoutParams2.addRule(13);
                } else {
                    A0J();
                    layoutParams2.addRule(0, this.A03.getId());
                    layoutParams2.setMargins(0, 0, 0, 0);
                }
                this.A09.setLayoutParams(layoutParams2);
            }
        }
        this.A00 = configuration.orientation;
        A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void onDestroy() {
        this.A0U.A03();
        A0V();
        C0532Lb lb = this.A09;
        if (lb != null) {
            lb.getEventBus().A05(this.A0X, this.A0Y, this.A0a, this.A0Z, this.A0b);
        }
        if (!TextUtils.isEmpty(this.A0P.A0Q())) {
            this.A0S.A80(this.A0P.A0Q(), new NU().A04(this.A0f).A03(this.A0V).A06());
        }
        M1 m1 = this.A04;
        if (m1 != null) {
            m1.setToolbarListener(null);
        }
        this.A0W.A0h();
        this.A09 = null;
        this.A06 = null;
        this.A0C = null;
        this.A05 = null;
        this.A0d.A09();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0V.A07(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = this.A06.getExpandableLayout();
        if (expandableLayout != null && this.A0h && z && this.A0E == null) {
            this.A0E = new C0419Gl(expandableLayout, 300, expandableLayout.getHeight(), 0);
            this.A0B.A0J(this.A0E);
            this.A0B.A0H();
        }
    }

    public void setListener(M6 m6) {
    }

    @VisibleForTesting
    public void setServerSideRewardHandler(C0612Oe oe) {
        this.A08 = oe;
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.Xt: [D('simpleVideoViewParams' android.widget.RelativeLayout$LayoutParams), D('detailsLayoutParams' android.widget.RelativeLayout$LayoutParams), D('muteButtonLayoutParams' android.widget.RelativeLayout$LayoutParams)] */
    private void setUpContentLayoutForVideo(int i) {
        this.A0N.removeAllViews();
        A0H();
        if (this.A06 != null) {
            C0820Wh wh = this.A0R;
            if (A0k[2].charAt(24) != 'V') {
                String[] strArr = A0k;
                strArr[5] = "4i2csOaoNdqQlmOU4oeneSGIvSddu1uE";
                strArr[3] = "nuT450uQsQsD47HYSiniJ05GRT2hP0Qn";
                if (J8.A1M(wh)) {
                    this.A0N.addView(this.A03);
                    this.A0d.A0A(-1, A0t);
                    if (i == 1) {
                        A0K();
                        this.A0N.addView(this.A09, A0r);
                    } else {
                        A0J();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(0, this.A03.getId());
                        layoutParams.setMargins(0, 0, 0, 0);
                        this.A0N.addView(this.A09, layoutParams);
                    }
                    this.A0N.addView(this.A06);
                } else {
                    this.A0N.addView(this.A09, A0r);
                    int i2 = -2;
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.A06.A0E(false);
                    C0535Le.A0N(this.A06);
                    this.A06.A0D(i);
                    NX nx = this.A06;
                    int i3 = A0q;
                    nx.setPadding(i3, i3, i3, i3);
                    if (this.A0h) {
                        i2 = A0v;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i2);
                    if (this.A0h) {
                        int i4 = A0q;
                        layoutParams2.setMargins(i4, i4, i4, i4);
                        H2 h2 = this.A0d;
                        int i5 = A0w;
                        h2.setPadding(i5, i5, i5, i5);
                        this.A0d.A0A(-1, A0t);
                    }
                    layoutParams3.addRule(12);
                    this.A0N.addView(this.A0d, layoutParams3);
                    this.A0N.addView(this.A06, layoutParams2);
                }
            } else {
                throw new RuntimeException();
            }
        }
        int i6 = A0p;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i6, i6);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        int i7 = A0n;
        layoutParams4.setMargins(i7, getToolbarHeight() + i7, A0n, A0o);
        this.A0N.addView(this.A0c, layoutParams4);
        A0R();
    }
}
