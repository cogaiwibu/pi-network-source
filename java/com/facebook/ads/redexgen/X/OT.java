package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Map;

public final class OT extends FrameLayout {
    public static final int A07 = ((int) (C0535Le.A01 * 16.0f));
    public C02559n A00;
    @Nullable
    public AnonymousClass7w A01;
    public HS A02;
    public C01997a A03;
    public AnonymousClass7B A04;
    public final C0820Wh A05;
    public final JL A06;

    public OT(C0820Wh wh, JL jl) {
        super(wh);
        this.A06 = jl;
        this.A05 = wh;
        setUpView(wh);
    }

    public final void A01() {
        this.A00.A0b(true, 10);
    }

    public final void A02() {
        AnonymousClass7w r0 = this.A01;
        if (r0 != null) {
            r0.A0h();
            this.A01 = null;
        }
    }

    public final void A03(AnonymousClass9K r2) {
        this.A00.getEventBus().A06(r2);
    }

    public final void A04(JE je, String str, Map<String, String> extraParams) {
        A02();
        this.A01 = new AnonymousClass7w(this.A05, je, this.A00, str, extraParams);
    }

    public final void A05(EnumC0626Os os) {
        this.A00.A0Y(os, 13);
    }

    public final boolean A06() {
        return this.A00.A0h();
    }

    @VisibleForTesting
    public C0532Lb getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A03.setImage(str);
    }

    private void setUpPlugins(C0820Wh wh) {
        this.A00.A0U();
        this.A03 = new C01997a(wh);
        this.A00.A0Z(this.A03);
        this.A02 = new HS(wh, this.A06);
        this.A00.A0Z(new C02057i(wh));
        this.A00.A0Z(this.A02);
        this.A04 = new AnonymousClass7B(wh, true, this.A06);
        this.A00.A0Z(this.A04);
        this.A00.A0Z(new HU(this.A04, P4.A03, true, true));
        if (this.A00.A0d()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i = A07;
            layoutParams.setMargins(i, i, i, i);
            this.A02.setLayoutParams(layoutParams);
            this.A00.addView(this.A02);
        }
    }

    private void setUpVideo(C0820Wh wh) {
        this.A00 = new C02559n(wh);
        this.A00.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        C0535Le.A0N(this.A00);
        addView(this.A00);
        setOnClickListener(new OS(this));
    }

    private void setUpView(C0820Wh wh) {
        setUpVideo(wh);
        setUpPlugins(wh);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f) {
        this.A00.setVolume(f);
        this.A02.A0A();
    }
}
