package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import com.facebook.ads.AdError;

public class RW implements AnonymousClass79 {
    public final AnonymousClass1S A00;
    public final AbstractC00531g A01;
    public final AnonymousClass7H A02;
    public final C0820Wh A03;
    public final boolean A04;

    public RW(C0820Wh wh, AbstractC00531g r2, AnonymousClass7H r3, AnonymousClass1S r4, boolean z) {
        this.A03 = wh;
        this.A01 = r2;
        this.A02 = r3;
        this.A00 = r4;
        this.A04 = z;
    }

    public /* synthetic */ RW(C0820Wh wh, AbstractC00531g r2, AnonymousClass7H r3, AnonymousClass1S r4, boolean z, C00521f r6) {
        this(wh, r2, r3, r4, z);
    }

    private void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C00541h(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0F());
    }

    private void A01(boolean z) {
        if (this.A00.A0A() == AnonymousClass1T.A05) {
            A00();
            return;
        }
        String A0F = this.A00.A0F();
        if (z) {
            A0F = this.A02.A0L(this.A00.A0F());
        }
        this.A00.A0H(A0F);
        this.A01.AAS();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A97() {
        if (this.A04) {
            this.A01.AAR(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A9E() {
        A01(true);
    }
}
