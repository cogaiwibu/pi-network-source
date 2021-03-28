package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.40  reason: invalid class name */
public class AnonymousClass40 implements Runnable {
    public final /* synthetic */ ES A00;

    public AnonymousClass40(ES es) {
        this.A00 = es;
    }

    public final void run() {
        if (this.A00.A0D && !this.A00.isLayoutRequested()) {
            if (!this.A00.A0F) {
                this.A00.requestLayout();
            } else if (this.A00.A0I) {
                this.A00.A0J = true;
            } else {
                this.A00.A1K();
            }
        }
    }
}
