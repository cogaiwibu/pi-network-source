package com.facebook.ads.redexgen.X;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.facebook.ads.redexgen.X.Br  reason: case insensitive filesystem */
public final class C0306Br {
    public final CopyOnWriteArrayList<C0305Bq> A00 = new CopyOnWriteArrayList<>();

    public final void A00() {
        Iterator<C0305Bq> it = this.A00.iterator();
        while (it.hasNext()) {
            C0305Bq handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0301Bm(this, handlerAndListener.A01));
        }
    }

    public final void A01() {
        Iterator<C0305Bq> it = this.A00.iterator();
        while (it.hasNext()) {
            C0305Bq handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0304Bp(this, handlerAndListener.A01));
        }
    }

    public final void A02() {
        Iterator<C0305Bq> it = this.A00.iterator();
        while (it.hasNext()) {
            C0305Bq handlerAndListener = it.next();
            handlerAndListener.A00.post(new RunnableC0303Bo(this, handlerAndListener.A01));
        }
    }

    public final void A03(Handler handler, Bs bs) {
        boolean z;
        if (handler == null || bs == null) {
            z = false;
        } else {
            z = true;
        }
        I1.A03(z);
        this.A00.add(new C0305Bq(handler, bs));
    }

    public final void A04(Exception exc) {
        Iterator<C0305Bq> it = this.A00.iterator();
        while (it.hasNext()) {
            C0305Bq next = it.next();
            next.A00.post(new RunnableC0302Bn(this, next.A01, exc));
        }
    }
}
