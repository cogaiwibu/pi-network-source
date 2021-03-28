package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;

public class RVDemandOnlyListenerWrapper {
    private static final RVDemandOnlyListenerWrapper sInstance = new RVDemandOnlyListenerWrapper();
    private ISDemandOnlyRewardedVideoListener mListener = null;

    public static RVDemandOnlyListenerWrapper getInstance() {
        return sInstance;
    }

    private RVDemandOnlyListenerWrapper() {
    }

    public void setListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.mListener = iSDemandOnlyRewardedVideoListener;
    }

    public void onRewardedVideoLoadSuccess(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass1 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdLoadSuccess(str);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdLoadSuccess() instanceId=" + str);
                }
            });
        }
    }

    public void onRewardedVideoAdLoadFailed(final String str, final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass2 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdLoadFailed(str, ironSourceError);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdLoadFailed() instanceId=" + str + "error=" + ironSourceError.getErrorMessage());
                }
            });
        }
    }

    public void onRewardedVideoAdOpened(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass3 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdOpened(str);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdOpened() instanceId=" + str);
                }
            });
        }
    }

    public void onRewardedVideoAdClosed(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass4 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdClosed(str);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdClosed() instanceId=" + str);
                }
            });
        }
    }

    public void onRewardedVideoAdShowFailed(final String str, final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass5 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdShowFailed(str, ironSourceError);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdShowFailed() instanceId=" + str + "error=" + ironSourceError.getErrorMessage());
                }
            });
        }
    }

    public void onRewardedVideoAdClicked(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass6 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdClicked(str);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdClicked() instanceId=" + str);
                }
            });
        }
    }

    public void onRewardedVideoAdRewarded(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.AnonymousClass7 */

                public void run() {
                    RVDemandOnlyListenerWrapper.this.mListener.onRewardedVideoAdRewarded(str);
                    RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
                    rVDemandOnlyListenerWrapper.log("onRewardedVideoAdRewarded() instanceId=" + str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void log(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
