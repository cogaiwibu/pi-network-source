package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import java.util.HashMap;
import java.util.Map;

public class CallbackThrottler {
    private static final String MEDIATION = "mediation";
    private static final CallbackThrottler instance = new CallbackThrottler();
    private int mISDelayLoadFailureNotificationInSeconds;
    private Map<String, Boolean> mIsWaitingForInvocation = new HashMap();
    private Map<String, Long> mLastInvoked = new HashMap();
    private InterstitialListener mListener = null;

    public static synchronized CallbackThrottler getInstance() {
        CallbackThrottler callbackThrottler;
        synchronized (CallbackThrottler.class) {
            callbackThrottler = instance;
        }
        return callbackThrottler;
    }

    private CallbackThrottler() {
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mListener = interstitialListener;
    }

    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        synchronized (this) {
            onInterstitialAdLoadFailedInternal(MEDIATION, ironSourceError);
        }
    }

    public void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError) {
        synchronized (this) {
            onInterstitialAdLoadFailedInternal(str, ironSourceError);
        }
    }

    public boolean hasPendingInvocation() {
        boolean hasPendingInvocationInternal;
        synchronized (this) {
            hasPendingInvocationInternal = hasPendingInvocationInternal(MEDIATION);
        }
        return hasPendingInvocationInternal;
    }

    private boolean hasPendingInvocationInternal(String str) {
        if (!TextUtils.isEmpty(str) && this.mIsWaitingForInvocation.containsKey(str)) {
            return this.mIsWaitingForInvocation.get(str).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void invokeCallback(String str, IronSourceError ironSourceError) {
        this.mLastInvoked.put(str, Long.valueOf(System.currentTimeMillis()));
        InterstitialListener interstitialListener = this.mListener;
        if (interstitialListener != null) {
            interstitialListener.onInterstitialAdLoadFailed(ironSourceError);
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
            logger.log(ironSourceTag, "onInterstitialAdLoadFailed(" + ironSourceError.toString() + ")", 1);
        }
    }

    private void onInterstitialAdLoadFailedInternal(final String str, final IronSourceError ironSourceError) {
        if (!hasPendingInvocationInternal(str)) {
            if (!this.mLastInvoked.containsKey(str)) {
                invokeCallback(str, ironSourceError);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mLastInvoked.get(str).longValue();
            if (currentTimeMillis > ((long) (this.mISDelayLoadFailureNotificationInSeconds * 1000))) {
                invokeCallback(str, ironSourceError);
                return;
            }
            this.mIsWaitingForInvocation.put(str, true);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.ironsource.mediationsdk.CallbackThrottler.AnonymousClass1 */

                public void run() {
                    CallbackThrottler.this.invokeCallback(str, ironSourceError);
                    CallbackThrottler.this.mIsWaitingForInvocation.put(str, false);
                }
            }, ((long) (this.mISDelayLoadFailureNotificationInSeconds * 1000)) - currentTimeMillis);
        }
    }

    public void setDelayLoadFailureNotificationInSeconds(int i) {
        this.mISDelayLoadFailureNotificationInSeconds = i;
    }
}
