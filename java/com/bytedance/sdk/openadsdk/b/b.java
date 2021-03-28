package com.bytedance.sdk.openadsdk.b;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.b.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.g.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AdEventDispatcher */
public class b<T> {
    private g<T> a;
    private Handler b;
    private AtomicBoolean c;

    public b(e<T> eVar, k<T> kVar, g.b bVar, g.a aVar) {
        this.a = new g<>(eVar, kVar, bVar, aVar);
        this.c = new AtomicBoolean(false);
    }

    b() {
    }

    public synchronized void a() {
        if ((this.c == null || !this.c.get()) && this.a.getLooper() == null) {
            if (this.c != null && !this.c.getAndSet(true)) {
                this.a.start();
                Handler handler = new Handler(this.a.getLooper(), this.a);
                this.b = handler;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 5;
                this.b.sendMessage(obtainMessage);
            }
        }
    }

    public void a(T t) {
        l.b("ReportEvent", "execute dispatchEvent method ,mStart=" + this.c);
        if (this.c.get()) {
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = t;
            this.b.sendMessage(obtainMessage);
            l.b("ReportEvent", "execute dispatchEvent method ,sendMessage(msg)->MSG_DISPATCH_EVENT ");
        }
    }
}
