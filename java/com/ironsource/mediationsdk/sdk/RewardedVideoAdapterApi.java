package com.ironsource.mediationsdk.sdk;

import org.json.JSONObject;

public interface RewardedVideoAdapterApi {
    void addRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener);

    void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener);

    void initRewardedVideo(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener);

    boolean isRewardedVideoAvailable(JSONObject jSONObject);

    void removeRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener);

    void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener);
}
