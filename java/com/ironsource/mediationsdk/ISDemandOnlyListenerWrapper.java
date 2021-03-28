package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;

public class ISDemandOnlyListenerWrapper {
    private static final ISDemandOnlyListenerWrapper sInstance = new ISDemandOnlyListenerWrapper();
    private ISDemandOnlyInterstitialListener mListener = null;

    public static ISDemandOnlyListenerWrapper getInstance() {
        return sInstance;
    }

    private ISDemandOnlyListenerWrapper() {
    }

    public void setListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.mListener = iSDemandOnlyInterstitialListener;
    }

    public ISDemandOnlyInterstitialListener getListener() {
        return this.mListener;
    }

    public void onInterstitialAdReady(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass1 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdReady(str);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdReady() instanceId=" + str);
                }
            });
        }
    }

    public void onInterstitialAdLoadFailed(final String str, final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass2 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdLoadFailed(str, ironSourceError);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdLoadFailed() instanceId=" + str + " error=" + ironSourceError.getErrorMessage());
                }
            });
        }
    }

    public void onInterstitialAdOpened(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass3 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdOpened(str);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdOpened() instanceId=" + str);
                }
            });
        }
    }

    public void onInterstitialAdClosed(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass4 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdClosed(str);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdClosed() instanceId=" + str);
                }
            });
        }
    }

    public void onInterstitialAdShowFailed(final String str, final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass5 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdShowFailed(str, ironSourceError);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdShowFailed() instanceId=" + str + " error=" + ironSourceError.getErrorMessage());
                }
            });
        }
    }

    public void onInterstitialAdClicked(final String str) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.AnonymousClass6 */

                public void run() {
                    ISDemandOnlyListenerWrapper.this.mListener.onInterstitialAdClicked(str);
                    ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
                    iSDemandOnlyListenerWrapper.log("onInterstitialAdClicked() instanceId=" + str);
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
