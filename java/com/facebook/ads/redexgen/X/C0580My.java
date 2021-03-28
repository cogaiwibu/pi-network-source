package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.My  reason: case insensitive filesystem */
public final class C0580My extends LinearLayout {
    public static final int A03 = ((int) (C0535Le.A01 * 40.0f));
    public static final int A04 = ((int) (C0535Le.A01 * 20.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 10.0f));
    public final AnonymousClass26 A00;
    public final C0820Wh A01;
    public final AbstractC0565Mi A02;

    public C0580My(C0820Wh wh, AnonymousClass26 r8, AbstractC0565Mi mi, EnumC0543Lm lm) {
        this(wh, r8, mi, null, lm);
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.My: [D('subHeaderView' android.view.View), D('optionsView' android.view.View)] */
    public C0580My(C0820Wh wh, AnonymousClass26 r9, AbstractC0565Mi mi, @Nullable String str, EnumC0543Lm lm) {
        super(wh);
        this.A01 = wh;
        this.A00 = r9;
        this.A02 = mi;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View A022 = A02(str);
            A022.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            C0535Le.A0P(view, -10459280);
            addView(A022, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(this.A00.A03())) {
            View A012 = A01(lm, this.A00.A03());
            int i = A05;
            A012.setPadding(0, i, 0, i);
            addView(A012, layoutParams);
        }
        View A002 = A00();
        A002.setPadding(0, A05, 0, 0);
        addView(A002, layoutParams);
    }

    private View A00() {
        N4 n4 = new N4(this.A01);
        for (AnonymousClass26 r3 : this.A00.A05()) {
            C0567Mk mk = new C0567Mk(this.A01);
            mk.setData(r3.A04(), null);
            mk.setOnClickListener(new View$OnClickListenerC0579Mx(this, mk, r3));
            n4.addView(mk);
        }
        return n4;
    }

    private View A01(EnumC0543Lm lm, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(C0544Ln.A00(lm));
        TextView textView = new TextView(getContext());
        C0535Le.A0b(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A02(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(C0544Ln.A00(EnumC0543Lm.BACK_ARROW));
        int i = A05;
        imageView.setPadding(0, i, i * 2, i);
        int i2 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        imageView.setOnClickListener(new View$OnClickListenerC0578Mw(this));
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(str);
        C0535Le.A0b(textView, true, 16);
        textView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A03, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
