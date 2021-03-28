package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.Button;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Nd  reason: case insensitive filesystem */
public class C0585Nd extends Button {
    public static final int A0B = ((int) (C0535Le.A01 * 16.0f));
    public static final int A0C = ((int) (C0535Le.A01 * 4.0f));
    public int A00 = 0;
    public int A01 = 0;
    public AnonymousClass1H A02;
    public boolean A03 = false;
    public boolean A04 = true;
    public boolean A05 = false;
    public final float A06;
    public final int A07;
    public final Runnable A08 = new C0825Wm(this);
    public final Runnable A09 = new C0823Wk(this);
    public final Runnable A0A = new C0824Wl(this);

    public C0585Nd(C0820Wh wh, AnonymousClass1H r4) {
        super(wh);
        this.A02 = r4;
        this.A07 = J8.A03(wh);
        this.A06 = J8.A00(wh);
        C0535Le.A0b(this, false, 16);
        setGravity(17);
        A04();
    }

    private void A04() {
        int i;
        AnonymousClass1H r1 = this.A02;
        if (r1 != null) {
            this.A00 = r1.A08(this.A05);
            this.A01 = this.A02.A09(this.A05);
        }
        int i2 = this.A00;
        if (this.A04) {
            i = A0C;
        } else {
            i = 0;
        }
        C0535Le.A0S(this, i2, i);
        setTextColor(this.A01);
    }

    private void A05() {
        if (this.A07 >= 0 && J8.A1M(getContext()) && !this.A03) {
            this.A03 = true;
            if (J8.A1U(getContext()) && Build.VERSION.SDK_INT >= 16) {
                postDelayed(this.A08, (long) this.A07);
            }
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A05();
    }

    public void setRoundedCornersEnabled(boolean z) {
        this.A04 = z;
        A04();
    }

    public void setText(String str) {
        super.setText((CharSequence) str.toUpperCase(Locale.US));
    }

    public void setUpButtonColors(AnonymousClass1H r1) {
        this.A02 = r1;
        A04();
    }

    public void setViewShowsOverMedia(boolean z) {
        this.A05 = z;
        A04();
    }
}
