package com.tapjoy.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public final class bx extends ReferenceQueue {
    public final bw a() {
        return (bw) super.poll();
    }

    @Override // java.lang.ref.ReferenceQueue
    public final /* bridge */ /* synthetic */ Reference poll() {
        return (bw) super.poll();
    }
}
