package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.util.DisplayMetrics;

public final class V7 extends AnonymousClass6Z {
    public ContentResolver A00;
    public DisplayMetrics A01;

    public V7(Context context, C01725z r3) {
        super(context, r3);
        this.A01 = context.getResources().getDisplayMetrics();
        this.A00 = context.getContentResolver();
    }

    public final AbstractC01816i A0H() {
        return new V6(this);
    }

    public final AbstractC01816i A0I() {
        return new V3(this);
    }

    public final AbstractC01816i A0J() {
        return new V4(this);
    }

    public final AbstractC01816i A0K() {
        return new V2(this);
    }

    public final AbstractC01816i A0L() {
        return new V5(this);
    }
}
