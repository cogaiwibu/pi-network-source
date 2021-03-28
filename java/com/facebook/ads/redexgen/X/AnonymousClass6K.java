package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.OrientationEventListener;

/* renamed from: com.facebook.ads.redexgen.X.6K  reason: invalid class name */
public class AnonymousClass6K extends OrientationEventListener {
    public final /* synthetic */ long A00;
    public final /* synthetic */ AnonymousClass6L A01;
    public final /* synthetic */ C01946v A02;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnonymousClass6K(AnonymousClass6L r1, Context context, int i, long j, C01946v r6) {
        super(context, i);
        this.A01 = r1;
        this.A00 = j;
        this.A02 = r6;
    }

    public final void onOrientationChanged(int i) {
        this.A01.A00.A02(new WV(this.A00, this.A02, i), AnonymousClass6I.A0A);
    }
}
