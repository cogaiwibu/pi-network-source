package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
@TargetApi(16)
public final class YA extends RelativeLayout implements M7 {
    public static byte[] A0Q;
    public static String[] A0R;
    public static final int A0S = ((int) (C0535Le.A01 * 10.0f));
    public static final int A0T = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0U = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0V = ((int) (C0535Le.A01 * 48.0f));
    public static final int A0W = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0X = AnonymousClass2G.A01(-1, 77);
    public static final int A0Y = ((int) (C0535Le.A01 * 14.0f));
    public static final int A0Z = ((int) (C0535Le.A01 * 64.0f));
    public static final int A0a = ((int) (C0535Le.A01 * 12.0f));
    public static final RelativeLayout.LayoutParams A0b = new RelativeLayout.LayoutParams(-1, -1);
    @Nullable
    public View A00;
    @Nullable
    public RelativeLayout A01;
    @Nullable
    public RelativeLayout A02;
    public Toast A03;
    @Nullable
    public AnonymousClass51 A04;
    @Nullable
    public View$OnClickListenerC0827Wo A05;
    public OY A06;
    public boolean A07;
    public boolean A08;
    public final AnonymousClass16 A09;
    public final AnonymousClass1S A0A;
    public final AbstractC01474z A0B = new ZV(this);
    public final C0820Wh A0C;
    public final JE A0D;
    public final JL A0E;
    public final L4 A0F;
    public final LS A0G;
    public final M6 A0H;
    public final AbstractC0558Mb A0I;
    public final C0611Od A0J;
    public final C0612Oe A0K;
    public final AtomicBoolean A0L = new AtomicBoolean(false);
    public final AtomicBoolean A0M = new AtomicBoolean(false);
    public final boolean A0N;
    public final boolean A0O;
    @VisibleForTesting
    public final M1 A0P;

    public static String A0C(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A0M() {
        A0Q = new byte[]{-110, -97, -94, -70, -84, -86, -70, -92, 4, 13, 10, 4, 12, 0, 16, 19, 10, 8, 10, 15, -77, -65, -67, 126, -74, -79, -77, -75, -78, -65, -65, -69, 126, -79, -76, -61, 126, -71, -66, -60, -75, -62, -61, -60, -71, -60, -71, -79, -68, 126, -77, -68, -71, -77, -69, -75, -76, -11, -6, 0, -15, -2, -1, 0, -11, 0, -11, -19, -8, -55, -68, -49, -60, -47, -64, -70, -66, -57, -60, -66, -58, -43, -47, -58, -56, -54, -46, -54, -45, -39, -65, -78, -60, -82, -65, -79, -78, -79, -84, -61, -74, -79, -78, -68, -80, -98, -101, -81, -94, -98, -80, -104, -100, -91, -94, -100, -92};
    }

    public static void A0N() {
        A0R = new String[]{"57rzzR6raHrat8cHk0n2c9utIvWN6OL8", "vZo4DQACnHxpUIABCEPhLIrXR", "3pKkUgRnbq5D8", "3oPHUcYdGBLGT6sjvwgTS6nCZs8dHXKK", "yMOWmEDq6oq3Yf8aoY", "BRjJ0geTmUVj6Aeo1VqVThKYcHpwhF7A", "bCnfD5Zsza6fNT9UI62TNCVdI9Gt63Qd", "0XbQU4AacrxlEwxF12eBigHvJ8"};
    }

    static {
        A0N();
        A0M();
    }

    public YA(C0820Wh wh, JE je, M6 m6, AnonymousClass16 r8, @Nullable String str, AbstractC0558Mb mb) {
        super(wh);
        this.A0C = wh;
        this.A0H = m6;
        this.A0D = je;
        this.A09 = r8;
        this.A0A = r8.A0M().A0E().A06();
        this.A0E = new JL(this.A09.A0Q(), this.A0D);
        this.A0I = mb;
        this.A0K = new C0612Oe(wh, this.A0I, str, this.A0H);
        this.A0M.set(!this.A0A.A0I());
        this.A0F = new L4(this.A0A.A08(), new C0880Yp(this, null));
        this.A0O = J8.A1f(this.A0C);
        this.A0N = J8.A0g(this.A0C);
        this.A0P = A05();
        this.A0J = new C0611Od(this.A0C, this.A0D, this.A09);
        if (this.A0O) {
            C0594Nm.A00(wh, this, r8.A0M().A0E().A07());
        } else {
            C0535Le.A0P(this, -14473425);
        }
        this.A0G = new LS(this);
        this.A0G.A05(LR.A03);
    }

    private M1 A05() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0C, this.A0H, this.A0E, 0, this.A09.A0E());
        fullScreenAdToolbar.A05(this.A09.A0L().A01(), true);
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A09.A0O(), this.A09.A0Q(), this.A0A.A08(), this.A09.A0P());
        fullScreenAdToolbar.setToolbarListener(new ZT(this));
        return fullScreenAdToolbar;
    }

    @Nullable
    private View$OnClickListenerC0827Wo A08() {
        OY oy = this.A06;
        if (oy == null || oy.getViewabilityChecker() == null || this.A06.getTouchDataRecorder() == null) {
            return null;
        }
        AnonymousClass1H A012 = this.A09.A0L().A01();
        View$OnClickListenerC0827Wo wo = new View$OnClickListenerC0827Wo(this.A0C, A0C(20, 37, 40), A012, this.A0D, this.A0H, this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder());
        C0535Le.A0N(wo);
        wo.setText(this.A09.A0M().A0G().A03());
        wo.setTextSize(14.0f);
        wo.setIncludeFontPadding(false);
        int i = A0S;
        wo.setPadding(i, i, i, i);
        if (!this.A0O) {
            C0535Le.A0Q(wo, 8);
        }
        wo.setOnClickListener(new MH(this));
        return wo;
    }

    private C0593Nl A0A() {
        C0593Nl nl = new C0593Nl(this.A0C, this.A09.A0L().A01(), true, 16, 14, 0);
        nl.A02(this.A09.A0M().A0F().A06(), this.A09.A0M().A0F().A05(), null, false, true);
        TextView descriptionTextView = nl.getDescriptionTextView();
        descriptionTextView.setAlpha(0.8f);
        descriptionTextView.setMaxLines(1);
        descriptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView titleTextView = nl.getTitleTextView();
        titleTextView.setMaxLines(1);
        titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        return nl;
    }

    private void A0F() {
        int i = A0V;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        C0587Nf nf = new C0587Nf(this.A0C);
        C0535Le.A0P(nf, 0);
        C0535Le.A0N(nf);
        AsyncTaskC0831Ws ws = new AsyncTaskC0831Ws(nf, this.A0C);
        int i2 = A0V;
        ws.A06(i2, i2).A08(this.A09.A0O().A01());
        TextView textView = new TextView(this.A0C);
        C0535Le.A0N(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(this.A09.A0L().A01().A06(true));
        textView.setText(this.A09.A0M().A0F().A06());
        textView.setTextSize(16.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        C0589Nh nh = new C0589Nh(this.A0C, A0Y, 5, A0X, -1);
        nh.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A0C);
        textView2.setTextColor(this.A09.A0L().A01().A06(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = A0T;
        LinearLayout linearLayout = new LinearLayout(this.A0C);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0W);
        layoutParams4.topMargin = A0T / 2;
        layoutParams4.addRule(3, textView.getId());
        linearLayout.addView(nh, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = A0T;
        layoutParams5.addRule(1, nf.getId());
        layoutParams5.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(linearLayout, layoutParams4);
        relativeLayout.addView(textView);
        RelativeLayout relativeLayout2 = this.A02;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
            RelativeLayout relativeLayout3 = this.A02;
            if (A0R[4].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0R;
            strArr[4] = "bsFsSO04IJ4eZVQxRT";
            strArr[4] = "bsFsSO04IJ4eZVQxRT";
            relativeLayout3.addView(relativeLayout, layoutParams5);
            this.A02.addView(nf, layoutParams);
        }
        if (TextUtils.isEmpty(this.A09.A0M().A0F().A03())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        nh.setRating(Float.parseFloat(this.A09.A0M().A0F().A03()));
        if (this.A09.A0M().A0F().A02() != null) {
            textView2.setText(A0C(0, 1, 66) + NumberFormat.getNumberInstance().format((long) Integer.parseInt(this.A09.A0M().A0F().A02())) + A0C(1, 1, 78));
        }
    }

    private void A0G() {
        if (this.A0A.A0I()) {
            A0I();
        } else {
            A0J();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.A0G.A05(LR.A04);
        }
    }

    /* access modifiers changed from: private */
    public void A0H() {
        this.A08 = true;
        if (this.A09.A0M().A0L()) {
            this.A0K.A06();
            this.A0H.A3t(this.A0I.A5F(), new AnonymousClass7v(0, 0));
            if (this.A07) {
                boolean z = this.A0O;
                if (A0R[4].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0R;
                strArr[1] = "I0JtICznoezMzS0InHXj65Cim";
                strArr[2] = "YxqOCBuXvZfwM";
                if (!z) {
                    C0583Nb.A03(this.A0C, this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder(), this.A0D, this.A09.A0M().A0G(), this.A09.A0Q());
                }
            }
        }
    }

    private void A0I() {
        OH A0B2 = new OF(this.A0C, this.A09.A0M().A0F(), this.A09.A0O()).A08(this.A09.A0L().A01()).A0A(this.A0A.A0G()).A09(this.A0A.A0E()).A07(2000).A0B();
        JN.A04(A0B2, this.A0E, JK.A0U);
        addView(A0B2, A0b);
        A0B2.A04(new ZU(this));
    }

    /* access modifiers changed from: private */
    public void A0J() {
        C0535Le.A0X(this);
        this.A06.A0C();
        this.A05 = A08();
        this.A01 = new RelativeLayout(getContext());
        C0535Le.A0N(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i = A0U;
        int i2 = A0a;
        layoutParams.setMargins(i, i2, i, i2);
        layoutParams.addRule(12);
        this.A02 = new RelativeLayout(getContext());
        C0535Le.A0N(this.A02);
        if (this.A0N) {
            A0F();
        } else {
            this.A02.addView(A0A(), new RelativeLayout.LayoutParams(-2, -2));
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A0U, 0);
        this.A01.addView(this.A02, layoutParams2);
        View$OnClickListenerC0827Wo wo = this.A05;
        if (wo != null) {
            layoutParams2.addRule(0, wo.getId());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(6, this.A02.getId());
            layoutParams3.addRule(8, this.A02.getId());
            this.A01.addView(this.A05, layoutParams3);
        }
        C0535Le.A0N(this.A0P);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        int i3 = A0U;
        layoutParams5.setMargins(i3, 0, i3, 0);
        layoutParams5.addRule(3, this.A0P.getId());
        layoutParams5.addRule(2, this.A01.getId());
        addView(this.A0P, layoutParams4);
        addView(this.A06, layoutParams5);
        addView(this.A01, layoutParams);
        this.A0F.A08();
    }

    /* access modifiers changed from: private */
    public void A0K() {
        new JL(this.A09.A0Q(), this.A0D).A03(JK.A0n, null);
        this.A0L.set(true);
        C0535Le.A0X(this);
        C0535Le.A0K(this.A06);
        C0535Le.A0d(this.A06, this.A00);
        C0535Le.A0O(this.A0P);
        Pair<EnumC0610Oc, View> A032 = this.A0J.A03(this.A05);
        this.A00 = (View) A032.second;
        int i = MI.A00[((EnumC0610Oc) A032.first).ordinal()];
        if (i == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(0, this.A0P.getToolbarHeight(), 0, 0);
            RelativeLayout relativeLayout = this.A01;
            if (relativeLayout != null) {
                layoutParams.addRule(2, relativeLayout.getId());
            }
            addView(this.A00, layoutParams);
        } else if (i == 2) {
            RelativeLayout relativeLayout2 = this.A01;
            if (relativeLayout2 != null) {
                C0535Le.A0d(relativeLayout2);
            }
            addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* access modifiers changed from: private */
    public void A0L() {
        Toast toast = this.A03;
        if (toast == null || toast.getView().getWindowVisibility() != 0) {
            this.A03 = Toast.makeText(getContext(), this.A0A.A0D(), 1);
            A0O((int) this.A0F.A04());
            this.A03.show();
        }
    }

    /* access modifiers changed from: private */
    public void A0O(int i) {
        C0535Le.A0c(this.A03, this.A0A.A0D().replace(A0C(2, 6, 31), String.valueOf(i)), 49, 0, A0Z);
    }

    /* access modifiers changed from: private */
    public void A0V(boolean z) {
        String A0C2;
        boolean z2;
        HashMap hashMap = new HashMap();
        if (z) {
            A0C2 = A0C(104, 13, 17);
        } else {
            A0C2 = A0C(69, 12, 51);
        }
        hashMap.put(A0C(8, 12, 121), A0C2);
        C0583Nb nb = new C0583Nb(this.A0C, this.A0I.A5i(), this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder(), this.A0D, this.A0H);
        if (this.A0O) {
            nb.A08(this.A09.A0Q(), this.A09.A0M().A0G().A04(), hashMap);
            return;
        }
        boolean z3 = !this.A0F.A05();
        if (!z3) {
            z2 = true;
        } else {
            z2 = false;
        }
        nb.A0A(z2);
        nb.A08(this.A09.A0Q(), this.A09.A0M().A0G().A04(), hashMap);
        if (z3) {
            new Handler(Looper.getMainLooper()).post(new ZL(this));
        }
        this.A07 = true;
    }

    /* access modifiers changed from: private */
    public boolean A0W() {
        if (!this.A09.A0T().equals(A0C(90, 14, 37))) {
            if (this.A09.A0T().equals(A0C(57, 12, 100))) {
                AnonymousClass16 r3 = this.A09;
                if (A0R[4].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0R;
                strArr[0] = "r5y7OBqhAYVA47bIfl4AlIWKO2XfiX80";
                strArr[0] = "r5y7OBqhAYVA47bIfl4AlIWKO2XfiX80";
                if (r3.A0M().A0N()) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void A7r(Intent intent, Bundle bundle, AnonymousClass51 r11) {
        this.A04 = r11;
        this.A04.A0L(this.A0B);
        HashMap hashMap = new HashMap();
        hashMap.put(A0C(81, 9, 61), this.A0I.A6j());
        AnonymousClass1S A062 = this.A09.A0M().A0E().A06();
        if (A062 == null) {
            this.A0H.A3s(this.A0I.A6C());
            this.A0H.A3s(this.A0I.A67());
            return;
        }
        this.A06 = new OY(this.A0C, this.A09, A062, this.A0D, new YB(this, null), hashMap);
        this.A0H.A3L(this, new RelativeLayout.LayoutParams(-1, -1));
        A0G();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAO(boolean z) {
        this.A0F.A07();
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAl(boolean z) {
        if (this.A0M.get() && !this.A0F.A06()) {
            L4 l4 = this.A0F;
            if (A0R[5].charAt(2) != 'm') {
                String[] strArr = A0R;
                strArr[0] = "UQp6GtSKm4mkcrS1rXAjxFqYQJcA6U4M";
                strArr[0] = "UQp6GtSKm4mkcrS1rXAjxFqYQJcA6U4M";
                l4.A08();
                return;
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void ACg(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void onDestroy() {
        this.A0G.A03();
        AnonymousClass51 r1 = this.A04;
        if (r1 != null) {
            r1.A0M(this.A0B);
        }
        if (this.A06 != null) {
            AnonymousClass16 r3 = this.A09;
            if (A0R[0].charAt(29) != 'D') {
                String[] strArr = A0R;
                strArr[0] = "voPpcOtL9PQSCLq1wYvqOCQr8JaLbGKq";
                strArr[0] = "voPpcOtL9PQSCLq1wYvqOCQr8JaLbGKq";
                if (!TextUtils.isEmpty(r3.A0Q())) {
                    this.A0D.A80(this.A09.A0Q(), new NU().A04(this.A06.getViewabilityChecker()).A03(this.A06.getTouchDataRecorder()).A06());
                }
                this.A06.A0D();
            } else {
                throw new RuntimeException();
            }
        }
        this.A0F.A07();
        this.A0P.setToolbarListener(null);
        this.A03 = null;
        this.A04 = null;
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AAl(false);
        } else {
            AAO(false);
        }
    }

    public void setListener(M6 m6) {
    }
}
