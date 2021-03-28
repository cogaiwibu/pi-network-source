package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Od  reason: case insensitive filesystem */
public final class C0611Od {
    public static String[] A06;
    public static final int A07 = ((int) (C0535Le.A01 * 72.0f));
    public static final int A08 = ((int) (C0535Le.A01 * 8.0f));
    public static final int A09 = ((int) (C0535Le.A01 * 4.0f));
    public final AnonymousClass17 A00;
    public final AnonymousClass1G A01;
    public final AnonymousClass1J A02;
    public final AnonymousClass1Q A03;
    public final C0820Wh A04;
    public final JL A05;

    public static void A02() {
        A06 = new String[]{"67PC1vS7qkP", "IjFo3BG6VwtzNtFBLMxB3hm7uxcMitzp", "CicRHWg02u8tYTVNboa", "Lc1HqPOOGgkkm0o4iF185HVfJQb2Oy4J", "rfUiy7qGv2cTTJD", "veTQu7RBhk0w6DuY7Y8JViB1PkIKs", "nFnk8VxBkehLa6QhTm5QccOE2IAl", "l0nPd7gOfqjUiTZVoVDHfvPfOU4VPF8e"};
    }

    static {
        A02();
    }

    public C0611Od(C0820Wh wh, JE je, AnonymousClass16 r5) {
        this.A04 = wh;
        this.A05 = new JL(r5.A0Q(), je);
        this.A00 = r5.A0L();
        this.A01 = r5.A0M().A0F();
        this.A03 = r5.A0O();
        this.A02 = r5.A0M().A0H();
    }

    private View A00() {
        ES es = new ES(this.A04);
        es.setLayoutManager(new SW(this.A04, 0, false));
        es.setAdapter(new NW(this.A04, this.A02.A00(), A09));
        return es;
    }

    private View A01(@Nullable View$OnClickListenerC0827Wo wo) {
        C0593Nl nl = new C0593Nl(this.A04, this.A00.A01(), true, false, false);
        nl.A02(this.A01.A06(), this.A01.A01(), null, false, true);
        nl.setAlignment(17);
        C0587Nf nf = new C0587Nf(this.A04);
        C0535Le.A0P(nf, 0);
        nf.setRadius(50);
        new AsyncTaskC0831Ws(nf, this.A04).A05().A08(this.A03.A01());
        LinearLayout linearLayout = new LinearLayout(this.A04);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i = A07;
        linearLayout.addView(nf, new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A08;
        layoutParams.setMargins(0, i2, 0, i2);
        linearLayout.addView(nl, layoutParams);
        if (wo != null) {
            C0535Le.A0M(wo);
            linearLayout.addView(wo, layoutParams);
            if (TextUtils.isEmpty(wo.getText())) {
                C0535Le.A0K(wo);
            }
        }
        return linearLayout;
    }

    public final Pair<EnumC0610Oc, View> A03(@Nullable View$OnClickListenerC0827Wo wo) {
        View A002;
        EnumC0610Oc A042 = A04();
        if (C0609Ob.A00[A042.ordinal()] != 1) {
            A002 = A01(wo);
        } else {
            A002 = A00();
        }
        JN.A04(A002, this.A05, JK.A0S);
        return new Pair<>(A042, A002);
    }

    public final EnumC0610Oc A04() {
        if (!this.A02.A00().isEmpty()) {
            return EnumC0610Oc.A04;
        }
        EnumC0610Oc oc = EnumC0610Oc.A03;
        String[] strArr = A06;
        if (strArr[3].charAt(8) != strArr[7].charAt(8)) {
            String[] strArr2 = A06;
            strArr2[4] = "qwlEjiYhEcV8j1J";
            strArr2[4] = "qwlEjiYhEcV8j1J";
            return oc;
        }
        throw new RuntimeException();
    }
}
