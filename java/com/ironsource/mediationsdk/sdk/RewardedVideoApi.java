package com.ironsource.mediationsdk.sdk;

import android.app.Activity;

public interface RewardedVideoApi {
    void initRewardedVideo(Activity activity, String str, String str2);

    boolean isRewardedVideoAvailable();

    void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener);

    void showRewardedVideo(String str);
}
