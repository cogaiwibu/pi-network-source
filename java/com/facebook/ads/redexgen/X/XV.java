package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XV implements AnonymousClass9Y {
    public final List<C02459d> A00 = new ArrayList();
    public final boolean A01;
    public final /* synthetic */ XW A02;

    public XV(XW xw, List<AnonymousClass9U> list, boolean z) throws IOException {
        this.A02 = xw;
        this.A01 = z;
        Iterator<AnonymousClass9U> it = list.iterator();
        while (it.hasNext()) {
            RecordFileBasedRecordDatabase<T>.RecordFileBasedFetch recordFileBasedFetch = (AnonymousClass9U) it.next();
            AnonymousClass9T A012 = recordFileBasedFetch.A01();
            this.A00.add(new C02459d(new AnonymousClass9R(recordFileBasedFetch.A00(), A012.A01()), A012.A00() - A012.A01(), A012.A00()));
        }
    }

    public final C02459d A00() {
        return (C02459d) this.A00.get(0);
    }

    public final C02459d A01() {
        List<C02459d> list = this.A00;
        return (C02459d) list.get(list.size() - 1);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9Y
    public final void A4f() throws C02509i {
        this.A02.A04(this);
    }

    /* JADX INFO: Multiple debug info for r0v4 com.facebook.ads.redexgen.X.9d: [D('location' com.facebook.ads.redexgen.X.9d), D('this' com.facebook.ads.internal.eventstorage.record.RecordFileBasedRecordDatabase<T>$RecordFileBasedFetch)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass9Y
    public final synchronized int A54() {
        int i;
        i = 0;
        Iterator<C02459d> it = this.A00.iterator();
        while (it.hasNext()) {
            i += ((C02459d) it.next()).A01;
        }
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9Y
    public final boolean A8T() {
        return this.A01;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        boolean unused = this.A02.A07(this);
    }
}
