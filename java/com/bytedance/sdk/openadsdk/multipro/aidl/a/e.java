package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.aidl.b.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: RewardAdVideoListenerManagerImpl */
public class e extends a {
    private static RemoteCallbackList<IRewardAdInteractionListener> a;
    private static volatile e b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        l.e("MultiProcess", "RewardAdVideoListenerManagerImpl.......registerRewardListener");
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        a = remoteCallbackList;
        remoteCallbackList.register(iRewardAdInteractionListener);
        this.c.set(true);
        notifyAll();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.a.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, boolean z, int i, String str2) throws RemoteException {
        a(str, z, i, str2);
    }

    private synchronized void a(String str, boolean z, int i, String str2) {
        if (!this.c.get()) {
            try {
                l.b("MultiProcess", "RewardAdVideoListenerManagerImpl.......executeMultiProcessCallback  waiting……");
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
                l.b("MultiProcess", "executeMutilProcessCallback....the size of mListenerList is :" + beginBroadcast);
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    IRewardAdInteractionListener broadcastItem = a.getBroadcastItem(i2);
                    if (broadcastItem != null) {
                        if ("onAdShow".equals(str)) {
                            l.b("MultiProcess", "executeMutilProcessCallback....METHOD_AD_SHOW");
                            broadcastItem.onAdShow();
                        } else if ("onAdClose".equals(str)) {
                            broadcastItem.onAdClose();
                        } else if ("onVideoComplete".equals(str)) {
                            broadcastItem.onVideoComplete();
                        } else if ("onVideoError".equals(str)) {
                            broadcastItem.onVideoError();
                        } else if ("onAdVideoBarClick".equals(str)) {
                            broadcastItem.onAdVideoBarClick();
                        } else if ("onRewardVerify".equals(str)) {
                            broadcastItem.onRewardVerify(z, i, str2);
                        }
                    }
                }
                a.finishBroadcast();
            }
        } catch (Throwable th) {
            l.b("MultiProcess", "MultiProcess : the IFullScreenVideoAdInteractionListener method '" + str + "'  throws Exception :", th);
        }
    }

    private void b() {
        try {
            if (a != null) {
                int beginBroadcast = a.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    IRewardAdInteractionListener broadcastItem = a.getBroadcastItem(i);
                    if (broadcastItem != null) {
                        ((b) broadcastItem).a();
                    }
                }
                a.finishBroadcast();
                a.kill();
                a = null;
            }
        } catch (Throwable th) {
            l.b("MultiProcess", "IRewardAdInteractionListener remove from mListenerList throw Exception : ", th);
        }
    }
}
