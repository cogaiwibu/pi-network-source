package com.bytedance.sdk.openadsdk.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler */
public class v extends Handler {
    private final WeakReference<a> a;

    /* compiled from: WeakHandler */
    public interface a {
        void a(Message message);
    }

    public v(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    public v(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
