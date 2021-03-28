package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.8l  reason: invalid class name and case insensitive filesystem */
public final class C02278l extends QZ {
    @Nullable
    public AbstractC0596No A00;
    public final AbstractC01474z A01 = new QY(this);
    public final AtomicBoolean A02 = new AtomicBoolean(false);
    public final AtomicBoolean A03 = new AtomicBoolean(false);
    public final AtomicBoolean A04 = new AtomicBoolean(false);

    public C02278l(C0820Wh wh, AbstractC0558Mb mb, JE je, AnonymousClass16 r6, AnonymousClass7H r7, M6 m6) {
        super(wh, mb, je, r6, r7, m6);
    }

    private AbstractC0596No A01(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new AsyncTaskC0831Ws(imageView, super.A03).A06(super.A01.A0M().A0E().A00(), super.A01.A0M().A0E().A01()).A07(new QW(this)).A08(super.A01.A0M().A0E().A07());
        return C0597Np.A00(new C0599Nr(super.A03, super.A04, this.A08, super.A01, imageView, this.A0A, this.A06).A0D(this.A07.getToolbarHeight()).A0F(this.A07).A0C(i).A0H(), null, true);
    }

    /* access modifiers changed from: private */
    public void A05() {
        if (this.A03.get() && this.A02.get()) {
            A0Q();
        }
    }

    private void A06(int i) {
        boolean z;
        C0535Le.A0M(this.A00);
        this.A00 = A01(i);
        AnonymousClass1H colors = this.A00.getColors();
        AbstractC0596No no = this.A00;
        boolean z2 = true;
        if (no == null || (!no.A0c() && !(this.A00 instanceof Si))) {
            z = false;
        } else {
            z = true;
        }
        C0535Le.A0P(this, colors.A07(z));
        this.A07.A05(colors, this.A00.A0c());
        addView(this.A00, 0, QZ.A0D);
        AbstractC0596No no2 = this.A00;
        if (no2 == null || !no2.A0c()) {
            z2 = false;
        }
        setUpFullscreenMode(z2);
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final void A0R() {
        C0535Le.A0O(this.A00);
        C0535Le.A0O(this.A07);
        this.A02.set(true);
        A05();
        int A032 = super.A01.A0M().A0E().A03();
        if (A032 > 0) {
            AbstractC0596No no = this.A00;
            if (no != null) {
                no.A0a();
            }
            A0S(A032, new QX(this));
            return;
        }
        this.A04.set(true);
        this.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final void A0T(AnonymousClass51 r5) {
        r5.A0L(this.A01);
        A06(r5.A0I().getResources().getConfiguration().orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        C0535Le.A0K(this.A00);
        C0535Le.A0K(this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final boolean A0U() {
        AbstractC0596No no = this.A00;
        return no != null && no.A0d(false);
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAO(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.M7
    public final void AAl(boolean z) {
    }

    /* access modifiers changed from: private */
    public int getCloseButtonStyle() {
        AbstractC0596No no = this.A00;
        if (no != null) {
            return no.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.QZ
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A01.A0M().A0M()) {
            A06(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QZ, com.facebook.ads.redexgen.X.M7
    public final void onDestroy() {
        AbstractC0596No no = this.A00;
        if (no != null) {
            no.A0W();
        }
        super.onDestroy();
    }
}
