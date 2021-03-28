package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

/* renamed from: com.facebook.ads.redexgen.X.Qf  reason: case insensitive filesystem */
public class C0665Qf extends NK {
    public final /* synthetic */ C0664Qe A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0665Qf(C0664Qe qe, C0820Wh wh) {
        super(wh);
        this.A00 = qe;
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebChromeClient A0A() {
        return new O9(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebViewClient A0B() {
        return new OA(this.A00, null);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A00.A0B.A07(motionEvent, this, this);
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }
}
