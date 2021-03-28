package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.facebook.ads.redexgen.X.7C  reason: invalid class name */
public class AnonymousClass7C implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ AnonymousClass7H A01;

    public AnonymousClass7C(AnonymousClass7H r3, AnonymousClass7G r4) {
        this.A01 = r3;
        new Handler(Looper.getMainLooper()).post(new C0818Wf(this, r3, r4));
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* access modifiers changed from: private */
    public void A03(AnonymousClass7G r8) {
        PV A05 = PV.A05(this.A01.A04);
        Uri parse = Uri.parse(r8.A08);
        long j = r8.A00;
        if (j == -1) {
            j = J8.A0L(this.A01.A04);
        }
        A05.A0F(parse, new C0819Wg(this), j);
    }
}
