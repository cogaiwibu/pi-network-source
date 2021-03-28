package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class ISListenerWrapper {
    private static final ISListenerWrapper sInstance = new ISListenerWrapper();
    private InterstitialListener mListener = null;

    public static synchronized ISListenerWrapper getInstance() {
        ISListenerWrapper iSListenerWrapper;
        synchronized (ISListenerWrapper.class) {
            iSListenerWrapper = sInstance;
        }
        return iSListenerWrapper;
    }

    private ISListenerWrapper() {
    }

    public synchronized void setListener(InterstitialListener interstitialListener) {
        this.mListener = interstitialListener;
    }

    public synchronized InterstitialListener getListener() {
        return this.mListener;
    }

    public synchronized void onInterstitialAdReady() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass1 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdReady();
                        ISListenerWrapper.this.log("onInterstitialAdReady()");
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdLoadFailed(final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass2 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdLoadFailed(ironSourceError);
                        ISListenerWrapper iSListenerWrapper = ISListenerWrapper.this;
                        iSListenerWrapper.log("onInterstitialAdLoadFailed() error=" + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdOpened() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass3 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdOpened();
                        ISListenerWrapper.this.log("onInterstitialAdOpened()");
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdClosed() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass4 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdClosed();
                        ISListenerWrapper.this.log("onInterstitialAdClosed()");
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdShowSucceeded() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass5 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdShowSucceeded();
                        ISListenerWrapper.this.log("onInterstitialAdShowSucceeded()");
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdShowFailed(final IronSourceError ironSourceError) {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass6 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdShowFailed(ironSourceError);
                        ISListenerWrapper iSListenerWrapper = ISListenerWrapper.this;
                        iSListenerWrapper.log("onInterstitialAdShowFailed() error=" + ironSourceError.getErrorMessage());
                    }
                }
            });
        }
    }

    public synchronized void onInterstitialAdClicked() {
        if (this.mListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.ironsource.mediationsdk.ISListenerWrapper.AnonymousClass7 */

                public void run() {
                    synchronized (this) {
                        ISListenerWrapper.this.mListener.onInterstitialAdClicked();
                        ISListenerWrapper.this.log("onInterstitialAdClicked()");
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
