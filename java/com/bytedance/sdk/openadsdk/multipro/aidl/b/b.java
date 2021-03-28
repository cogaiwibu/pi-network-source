package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* compiled from: RewardVideoListenerImpl */
public class b extends IRewardAdInteractionListener.Stub {
    private TTRewardVideoAd.RewardAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public b(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.a = rewardAdInteractionListener;
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

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass1 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass2 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass3 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass4 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass5 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onVideoError();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str) throws RemoteException {
        b().post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.multipro.aidl.b.b.AnonymousClass6 */

            public void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardVerify(z, i, str);
                }
            }
        });
    }
}
