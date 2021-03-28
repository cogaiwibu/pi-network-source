package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Qk  reason: case insensitive filesystem */
public abstract class AbstractC0670Qk extends AbstractC0596No {
    public static final int A0I = ((int) (C0535Le.A01 * 6.0f));
    public static final int A0J = ((int) (C0535Le.A01 * 1.0f));
    public static final int A0K = ((int) (C0535Le.A01 * 4.0f));
    public RelativeLayout A00;
    public MR A01;
    public O2 A02;
    public C0630Ow A03;
    public OT A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Paint A08;
    public final Path A09 = new Path();
    public final RectF A0A = new RectF();
    public final C0820Wh A0B;
    public final K4 A0C = new C02398x(this);
    public final AbstractC0506Jy A0D = new C02378v(this);
    public final AbstractC0494Jk A0E = new C02388w(this);
    public final JH A0F = new C02368u(this);
    public final I0 A0G = new AnonymousClass9H(this);
    public final String A0H;

    public abstract void A0h(C0820Wh wh);

    public AbstractC0670Qk(C0600Ns ns, boolean z, String str, C0630Ow ow) {
        super(ns, z);
        this.A03 = ow;
        this.A0H = str;
        this.A0B = ns.A05();
        setGravity(17);
        int i = A0J;
        setPadding(i, 0, i, i);
        C0535Le.A0P(this, 0);
        setUpView(this.A0B);
        this.A08 = new Paint();
        this.A08.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.A08.setStyle(Paint.Style.FILL);
        this.A08.setAlpha(16);
        this.A08.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* access modifiers changed from: private */
    public void A01() {
        if (this.A02 != null) {
            if ((A0k() && this.A07) || (!A0k() && this.A06)) {
                this.A02.A8t();
            }
        }
    }

    private void A02(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        C0535Le.A0N(view);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public boolean A0M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0c() {
        return false;
    }

    public final void A0e() {
        if (A0k()) {
            this.A04.A01();
        }
    }

    public final void A0f() {
        if (A0k()) {
            A0g();
            this.A04.A05(EnumC0626Os.A03);
        }
    }

    public final void A0g() {
        float volume = this.A03.A0Z().getVolume();
        if (A0k() && volume != this.A04.getVolume()) {
            this.A04.setVolume(volume);
        }
    }

    public final void A0i(Map<String, String> map) {
        this.A04.A02();
        if (A0k()) {
            this.A04.A04(getAdEventManager(), this.A0H, map);
        }
    }

    public final boolean A0j() {
        return A0k() && this.A04.A06();
    }

    public final boolean A0k() {
        return this.A05;
    }

    public final RelativeLayout getMediaContainer() {
        return this.A00;
    }

    public final OT getVideoView() {
        return this.A04;
    }

    public final void onDraw(Canvas canvas) {
        this.A09.reset();
        this.A0A.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        Path path = this.A09;
        RectF rectF = this.A0A;
        int i = A0I;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        canvas.drawPath(this.A09, this.A08);
        this.A0A.set((float) A0J, 0.0f, (float) (getWidth() - A0J), (float) (getHeight() - A0J));
        Path path2 = this.A09;
        RectF rectF2 = this.A0A;
        int i2 = A0K;
        path2.addRoundRect(rectF2, (float) i2, (float) i2, Path.Direction.CW);
        canvas.clipPath(this.A09);
        super.onDraw(canvas);
    }

    public void setAdTitleAndDescription(String str, String str2) {
        getTitleDescContainer().A02(str, str2, null, true, false);
    }

    public void setCTAInfo(AnonymousClass1I r3, Map<String, String> map) {
        getCtaButton().setCta(r3, this.A0H, map);
    }

    public void setImageUrl(String str) {
        this.A01.setVisibility(0);
        this.A04.setVisibility(8);
        new AsyncTaskC0831Ws(this.A01, this.A0B).A05().A07(new C0671Ql(this, null)).A08(str);
    }

    public void setIsVideo(boolean z) {
        this.A05 = z;
    }

    public void setOnAssetsLoadedListener(O2 o2) {
        this.A02 = o2;
    }

    public void setUpImageView(C0820Wh wh) {
        this.A01 = new MR(wh);
        A02(this.A01);
    }

    public void setUpMediaContainer(C0820Wh wh) {
        this.A00 = new RelativeLayout(wh);
        A02(this.A00);
    }

    public void setUpVideoView(C0820Wh wh) {
        this.A04 = new OT(wh, new JL(this.A0H, getAdEventManager()));
        A02(this.A04);
    }

    private void setUpView(C0820Wh wh) {
        setUpImageView(wh);
        setUpVideoView(wh);
        setUpMediaContainer(wh);
        this.A00.addView(this.A01);
        this.A00.addView(this.A04);
        A0h(wh);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.A04.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.A01.setVisibility(8);
        this.A04.setVisibility(0);
        this.A04.setVideoURI(str);
        this.A04.A03(this.A0G);
        this.A04.A03(this.A0C);
        this.A04.A03(this.A0E);
        this.A04.A03(this.A0D);
        this.A04.A03(this.A0F);
    }
}
