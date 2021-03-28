package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.facebook.ads.redexgen.X.3e  reason: invalid class name and case insensitive filesystem */
public class RunnableC01013e implements Runnable {
    public final /* synthetic */ EV A00;
    public final /* synthetic */ ArrayList A01;

    public RunnableC01013e(EV ev, ArrayList arrayList) {
        this.A00 = ev;
        this.A01 = arrayList;
    }

    public final void run() {
        Iterator it = this.A01.iterator();
        while (it.hasNext()) {
            C01103n moveInfo = (C01103n) it.next();
            this.A00.A0b(moveInfo.A04, moveInfo.A00, moveInfo.A01, moveInfo.A02, moveInfo.A03);
        }
        this.A01.clear();
        this.A00.A05.remove(this.A01);
    }
}
