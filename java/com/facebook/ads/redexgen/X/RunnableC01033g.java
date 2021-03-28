package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.ads.redexgen.X.3g  reason: invalid class name and case insensitive filesystem */
public class RunnableC01033g implements Runnable {
    public final /* synthetic */ EV A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC01033g(EV ev, ArrayList arrayList) {
        this.A00 = ev;
        this.A01 = arrayList;
    }

    public final void run() {
        Iterator it = this.A01.iterator();
        while (it.hasNext()) {
            this.A00.A0a((AnonymousClass4X) it.next());
        }
        this.A01.clear();
        this.A00.A01.remove(this.A01);
    }
}
