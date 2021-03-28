package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.multipro.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AdEventDispatcher4MultiProcess */
public class c extends b<a> {
    private AtomicBoolean a = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.b.b
    public void a() {
        if (!this.a.getAndSet(true)) {
            a.c();
        }
    }

    public void a(a aVar) {
        if (this.a.get()) {
            a.a(aVar.a());
        }
    }
}
