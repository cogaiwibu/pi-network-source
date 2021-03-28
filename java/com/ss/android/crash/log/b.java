package com.ss.android.crash.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ANRHandler */
public final class b extends Handler {
    private final c a;

    public b(c cVar, Looper looper) {
        super(looper);
        this.a = cVar;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 100) {
            this.a.b(100, null);
        } else if (i == 200) {
            this.a.b(200, (String) message.obj);
        }
        super.handleMessage(message);
    }
}
