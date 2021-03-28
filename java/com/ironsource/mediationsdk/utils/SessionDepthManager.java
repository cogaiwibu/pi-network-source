package com.ironsource.mediationsdk.utils;

public class SessionDepthManager {
    public static final int BANNER = 3;
    public static final int INTERSTITIAL = 2;
    public static final int NONE = -1;
    public static final int OFFERWALL = 0;
    public static final int REWARDEDVIDEO = 1;
    private static SessionDepthManager mInstance;
    private int mBannerDepth = 1;
    private int mInterstitialDepth = 1;
    private int mOfferwallDepth = 1;
    private int mRewardedVideoDepth = 1;

    public static synchronized SessionDepthManager getInstance() {
        SessionDepthManager sessionDepthManager;
        synchronized (SessionDepthManager.class) {
            if (mInstance == null) {
                mInstance = new SessionDepthManager();
            }
            sessionDepthManager = mInstance;
        }
        return sessionDepthManager;
    }

    public synchronized void increaseSessionDepth(int i) {
        if (i == 0) {
            this.mOfferwallDepth++;
        } else if (i == 1) {
            this.mRewardedVideoDepth++;
        } else if (i == 2) {
            this.mInterstitialDepth++;
        } else if (i == 3) {
            this.mBannerDepth++;
        }
    }

    public synchronized int getSessionDepth(int i) {
        if (i == 0) {
            return this.mOfferwallDepth;
        } else if (i == 1) {
            return this.mRewardedVideoDepth;
        } else if (i == 2) {
            return this.mInterstitialDepth;
        } else if (i != 3) {
            return -1;
        } else {
            return this.mBannerDepth;
        }
    }
}
