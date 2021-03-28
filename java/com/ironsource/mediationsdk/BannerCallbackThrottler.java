package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceError;

public class BannerCallbackThrottler {
    private static BannerCallbackThrottler sInstance;
    private int mBNDelayLoadFailureNotificationInSeconds;
    private boolean mIsWaitingForInvocation = false;
    private long mLastInvoked = 0;

    public static synchronized BannerCallbackThrottler getInstance() {
        BannerCallbackThrottler bannerCallbackThrottler;
        synchronized (BannerCallbackThrottler.class) {
            if (sInstance == null) {
                sInstance = new BannerCallbackThrottler();
            }
            bannerCallbackThrottler = sInstance;
        }
        return bannerCallbackThrottler;
    }

    private BannerCallbackThrottler() {
    }

    public void sendBannerAdLoadFailed(final IronSourceBannerLayout ironSourceBannerLayout, final IronSourceError ironSourceError) {
        synchronized (this) {
            if (!this.mIsWaitingForInvocation) {
                long currentTimeMillis = System.currentTimeMillis() - this.mLastInvoked;
                if (currentTimeMillis > ((long) (this.mBNDelayLoadFailureNotificationInSeconds * 1000))) {
                    invokeCallback(ironSourceBannerLayout, ironSourceError);
                    return;
                }
                this.mIsWaitingForInvocation = true;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.ironsource.mediationsdk.BannerCallbackThrottler.AnonymousClass1 */

                    public void run() {
                        BannerCallbackThrottler.this.invokeCallback(ironSourceBannerLayout, ironSourceError);
                    }
                }, ((long) (this.mBNDelayLoadFailureNotificationInSeconds * 1000)) - currentTimeMillis);
            }
        }
    }

    public boolean hasPendingInvocation() {
        boolean z;
        synchronized (this) {
            z = this.mIsWaitingForInvocation;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeCallback(IronSourceBannerLayout ironSourceBannerLayout, IronSourceError ironSourceError) {
        if (ironSourceBannerLayout != null) {
            this.mLastInvoked = System.currentTimeMillis();
            this.mIsWaitingForInvocation = false;
            ironSourceBannerLayout.sendBannerAdLoadFailed(ironSourceError);
        }
    }

    public void setDelayLoadFailureNotificationInSeconds(int i) {
        this.mBNDelayLoadFailureNotificationInSeconds = i;
    }
}
