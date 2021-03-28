package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.ads.redexgen.X.3f  reason: invalid class name and case insensitive filesystem */
public class RunnableC01023f implements Runnable {
    public final /* synthetic */ EV A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC01023f(EV ev, ArrayList arrayList) {
        this.A00 = ev;
        this.A01 = arrayList;
    }

    public final void run() {
        Iterator it = this.A01.iterator();
        while (it.hasNext()) {
            this.A00.A0Z((C01093m) it.next());
        }
        this.A01.clear();
        this.A00.A03.remove(this.A01);
    }
}
