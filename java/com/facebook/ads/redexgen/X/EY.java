package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.util.ArrayList;
import java.util.Iterator;

public class EY implements Runnable {
    public final /* synthetic */ EZ A00;
    public final /* synthetic */ DownloadAction[] A01;

    public EY(EZ ez, DownloadAction[] downloadActionArr) {
        this.A00 = ez;
        this.A01 = downloadActionArr;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                if (!(this.A00.A00.A03)) {
                    ArrayList arrayList = new ArrayList(this.A00.A00.A0C);
                    this.A00.A00.A0C.clear();
                    for (DownloadAction downloadAction : this.A01) {
                        RunnableC0365Ef unused = this.A00.A00.A02(downloadAction);
                    }
                    this.A00.A00.A02 = true;
                    Iterator it = this.A00.A00.A0D.iterator();
                    while (it.hasNext()) {
                        ((AbstractC0361Eb) it.next()).A9j(this.A00.A00);
                    }
                    if (!arrayList.isEmpty()) {
                        this.A00.A00.A0C.addAll(arrayList);
                        this.A00.A00.A0B();
                    }
                    this.A00.A00.A0A();
                    for (int i = 0; i < this.A00.A00.A0C.size(); i++) {
                        RunnableC0365Ef ef = (RunnableC0365Ef) this.A00.A00.A0C.get(i);
                        if (ef.A06 == 0) {
                            this.A00.A00.A0E(ef);
                        }
                    }
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
