package com.ironsource.mediationsdk.sdk;

import android.content.Context;
import com.ironsource.mediationsdk.impressionData.ImpressionDataAPI;
import com.ironsource.mediationsdk.logger.LoggingApi;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Map;

public interface IronSourceInterface extends BaseApi, RewardedVideoApi, InterstitialApi, OfferwallApi, LoggingApi, ImpressionDataAPI {
    void clearRewardedVideoServerParameters();

    String getAdvertiserId(Context context);

    InterstitialPlacement getInterstitialPlacementInfo(String str);

    Placement getRewardedVideoPlacementInfo(String str);

    void removeInterstitialListener();

    void removeOfferwallListener();

    void removeRewardedVideoListener();

    void setAdaptersDebug(boolean z);

    boolean setDynamicUserId(String str);

    void setMediationType(String str);

    void setRewardedVideoServerParameters(Map<String, String> map);

    void shouldTrackNetworkState(Context context, boolean z);
}
