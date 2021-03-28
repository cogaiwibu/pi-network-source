package com.facebook.ads.redexgen.X;

import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.4i  reason: invalid class name and case insensitive filesystem */
public class C01304i implements Comparator<Thread> {
    public final /* synthetic */ C01314j A00;
    public final /* synthetic */ Thread A01;

    public C01304i(C01314j r1, Thread thread) {
        this.A00 = r1;
        this.A01 = thread;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compare(Thread thread, Thread thread2) {
        if (thread == thread2) {
            return 0;
        }
        Thread thread3 = this.A01;
        if (thread == thread3) {
            return -1;
        }
        if (thread2 == thread3) {
            return 1;
        }
        return thread2.getName().compareTo(thread.getName());
    }
}
