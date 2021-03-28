package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.g.l;
import java.util.concurrent.CountDownLatch;

/* compiled from: BinderPool */
public class a {
    private static volatile a c;
    private Context a;
    private IBinderPool b;
    private CountDownLatch d;
    private final Object e = new Object();
    private long f = 0;
    private ServiceConnection g = new ServiceConnection() {
        /* class com.bytedance.sdk.openadsdk.multipro.aidl.a.AnonymousClass1 */

        public void onServiceDisconnected(ComponentName componentName) {
            l.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.b.asBinder().linkToDeath(a.this.h, 0);
            } catch (RemoteException e) {
                l.b("MultiProcess", "onServiceConnected throws :", e);
            }
            a.this.d.countDown();
            l.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f));
        }
    };
    private IBinder.DeathRecipient h = new IBinder.DeathRecipient() {
        /* class com.bytedance.sdk.openadsdk.multipro.aidl.a.AnonymousClass2 */

        public void binderDied() {
            l.d("MultiProcess", "binder died.");
            a.this.b.asBinder().unlinkToDeath(a.this.h, 0);
            a.this.b = null;
            a.this.a();
        }
    };

    private a(Context context) {
        this.a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public IBinder a(int i) {
        try {
            if (this.b != null) {
                return this.b.queryBinder(i);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a() {
        l.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.d = new CountDownLatch(1);
        this.a.bindService(new Intent(this.a, BinderPoolService.class), this.g, 1);
        this.f = System.currentTimeMillis();
        try {
            this.d.await();
        } catch (InterruptedException e2) {
            l.b("MultiProcess", "connectBinderPoolService throws: ", e2);
        }
    }
}
