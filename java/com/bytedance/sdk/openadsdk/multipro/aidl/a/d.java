package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FullScreenVideoListenerManagerImpl */
public class d extends a {
    private static RemoteCallbackList<IFullScreenVideoAdInteractionListener> a;
    private static volatile d b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerFullVideoListener(IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IFullScreenVideoAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        a = remoteCallbackList;
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        this.c.set(true);
        notifyAll();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeFullVideoCallback(String str) throws RemoteException {
        a(str);
    }

    private synchronized void a(String str) {
        if (!this.c.get()) {
            try {
                l.b("MultiProcess", "FullScreenVideoListenerManagerImpl.......executeMultiProcessCallback  waiting……");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            if ("recycleRes".equals(str)) {
                b();
                return;
            }
            if (a != null) {
                int beginBroadcast = a.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    IFullScreenVideoAdInteractionListener broadcastItem = a.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        if ("onAdShow".equals(str)) {
                            l.b("MultiProcess", "FullScreenVideoListenerManagerImpl.......METHOD_AD_SHOW");
                            broadcastItem.onAdShow();
                        } else if ("onAdClose".equals(str)) {
                            broadcastItem.onAdClose();
                        } else if ("onVideoComplete".equals(str)) {
                            broadcastItem.onVideoComplete();
                        } else if ("onSkippedVideo".equals(str)) {
                            broadcastItem.onSkippedVideo();
                        } else if ("onAdVideoBarClick".equals(str)) {
                            broadcastItem.onAdVideoBarClick();
                        }
                    }
                }
                a.finishBroadcast();
            }
        } catch (Throwable th) {
            l.b("MultiProcess", "MultiProcess : the IFullScreenVideoAdInteractionListener method " + str + " throws Exception :", th);
        }
    }

    private void b() {
        try {
            if (a != null) {
                int beginBroadcast = a.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    IFullScreenVideoAdInteractionListener broadcastItem = a.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        ((a) broadcastItem).a();
                    }
                }
                a.finishBroadcast();
                a.kill();
                a = null;
            }
        } catch (Throwable unused) {
        }
    }
}
