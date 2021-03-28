package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public class RVListenerWrapper {
    private static final RVListenerWrapper sInstance = new RVListenerWrapper();
    private RewardedVideoListener mListener = null;

    public static synchronized RVListenerWrapper getInstance() {
        RVListenerWrapper rVListenerWrapper;
        synchronized (RVListenerWrapper.class) {
            rVListenerWrapper = sInstance;
        }
        return rVListenerWrapper;
    }

    private RVListenerWrapper() {
    }

    private String getPlacementName(Placement placement) {
        return placement == null ? "" : placement.getPlacementName();
    }

    public synchronized void setListener(RewardedVideoListener rewardedVideoListener) {
        this.mListener = rewardedVideoListener;
    }

    public synchronized void onRewardedVideoAdOpened() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass1 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdOpened();
                        RVListenerWrapper.this.log("onRewardedVideoAdOpened()");
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdClosed() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass2 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdClosed();
                        RVListenerWrapper.this.log("onRewardedVideoAdClosed()");
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAvailabilityChanged(final boolean z) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass3 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAvailabilityChanged(z);
                        RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                        rVListenerWrapper.log("onRewardedVideoAvailabilityChanged() available=" + z);
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdStarted() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass4 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdStarted();
                        RVListenerWrapper.this.log("onRewardedVideoAdStarted()");
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdEnded() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass5 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdEnded();
                        RVListenerWrapper.this.log("onRewardedVideoAdEnded()");
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdRewarded(final Placement placement) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass6 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdRewarded(placement);
                        RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                        rVListenerWrapper.log("onRewardedVideoAdRewarded(" + placement + ")");
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdShowFailed(final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass7 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdShowFailed(ironSourceError);
                        RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                        rVListenerWrapper.log("onRewardedVideoAdShowFailed() error=" + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public synchronized void onRewardedVideoAdClicked(final Placement placement) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.RVListenerWrapper.AnonymousClass8 */

                public void run() {
                    synchronized (this) {
                        RVListenerWrapper.this.mListener.onRewardedVideoAdClicked(placement);
                        RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                        rVListenerWrapper.log("onRewardedVideoAdClicked(" + placement + ")");
                    }
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
