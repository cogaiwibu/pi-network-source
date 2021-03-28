package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public final class NG extends C0588Ng {
    public final ImageView A00;
    public final C0820Wh A01;

    public NG(C0820Wh wh) {
        super(wh);
        this.A01 = wh;
        this.A00 = new ImageView(wh);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        AsyncTaskC0831Ws ws = new AsyncTaskC0831Ws(this.A00, this.A01);
        ws.A05();
        ws.A08(str);
    }
}
