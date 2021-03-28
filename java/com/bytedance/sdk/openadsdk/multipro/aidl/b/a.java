package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* compiled from: FullScreenVideoListenerImpl */
public class a extends IFullScreenVideoAdInteractionListener.Stub {
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.a = fullScreenVideoAdInteractionListener;
    }

    public void a() {
        this.a = null;
        this.b = null;
    }

    private Handler b() {
        Handler handler = this.b;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.b = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass1 */

            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass2 */

            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass3 */

            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass4 */

            public void run() {
                if (a.this.a != null) {
                    a.this.a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.a.AnonymousClass5 */

            public void run() {
                if (a.this.a != null) {
                    a.this.a.onSkippedVideo();
                }
            }
        });
    }
}
