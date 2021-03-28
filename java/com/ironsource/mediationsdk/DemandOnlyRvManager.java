package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener;
import com.ironsource.mediationsdk.utils.AuctionSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class DemandOnlyRvManager implements DemandOnlyRvManagerListener {
    private String mAppKey;
    private AuctionSettings mAuctionSettings;
    private ConcurrentHashMap<String, DemandOnlyRvSmash> mSmashes = new ConcurrentHashMap<>();

    DemandOnlyRvManager(List<ProviderSettings> list, RewardedVideoConfigurations rewardedVideoConfigurations, String str, String str2) {
        this.mAppKey = str;
        this.mAuctionSettings = rewardedVideoConfigurations.getRewardedVideoAuctionSettings();
        for (ProviderSettings providerSettings : list) {
            if (providerSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || providerSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(providerSettings, providerSettings.getRewardedVideoSettings(), true);
                if (adapter != null) {
                    this.mSmashes.put(providerSettings.getSubProviderId(), new DemandOnlyRvSmash(str, str2, providerSettings, this, rewardedVideoConfigurations.getRewardedVideoAdaptersSmartLoadTimeout(), adapter));
                }
            } else {
                logInternal("cannot load " + providerSettings.getProviderTypeForReflection());
            }
        }
    }

    public void loadRewardedVideoWithAdm(String str, String str2, boolean z) {
        try {
            if (!this.mSmashes.containsKey(str)) {
                sendMediationEvent(1500, str);
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            DemandOnlyRvSmash demandOnlyRvSmash = this.mSmashes.get(str);
            if (z) {
                if (!demandOnlyRvSmash.isBidder()) {
                    IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm in IAB flow must be called by bidder instances");
                    logInternal(buildLoadFailedError.getErrorMessage());
                    sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, demandOnlyRvSmash);
                    RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, buildLoadFailedError);
                    return;
                }
                AuctionDataUtils.AuctionData auctionDataFromResponse = AuctionDataUtils.getInstance().getAuctionDataFromResponse(AuctionDataUtils.getInstance().decodeAdmResponse(str2));
                AuctionResponseItem auctionResponseItem = AuctionDataUtils.getInstance().getAuctionResponseItem(demandOnlyRvSmash.getInstanceName(), auctionDataFromResponse.getWaterfall());
                if (auctionResponseItem != null) {
                    demandOnlyRvSmash.setDynamicDemandSourceIdByServerData(auctionResponseItem.getServerData());
                    demandOnlyRvSmash.setAuctionId(auctionDataFromResponse.getAuctionId());
                    demandOnlyRvSmash.setGenericParams(auctionDataFromResponse.getGenericParams());
                    sendProviderEvent(1001, demandOnlyRvSmash);
                    demandOnlyRvSmash.loadRewardedVideo(auctionResponseItem.getServerData(), auctionDataFromResponse.getAuctionId(), auctionDataFromResponse.getGenericParams(), auctionResponseItem.getBurls());
                    return;
                }
                IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm invalid enriched adm");
                logInternal(buildLoadFailedError2.getErrorMessage());
                sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, demandOnlyRvSmash);
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, buildLoadFailedError2);
            } else if (!demandOnlyRvSmash.isBidder()) {
                sendProviderEvent(1001, demandOnlyRvSmash);
                demandOnlyRvSmash.loadRewardedVideo("", "", null, null);
            } else {
                IronSourceError buildLoadFailedError3 = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm in non IAB flow must be called by non bidder instances");
                logInternal(buildLoadFailedError3.getErrorMessage());
                sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, demandOnlyRvSmash);
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, buildLoadFailedError3);
            }
        } catch (Exception e) {
            logInternal("loadRewardedVideoWithAdm exception " + e.getMessage());
            RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm exception"));
        }
    }

    public void showRewardedVideo(String str) {
        if (!this.mSmashes.containsKey(str)) {
            sendMediationEvent(1500, str);
            RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdShowFailed(str, ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        DemandOnlyRvSmash demandOnlyRvSmash = this.mSmashes.get(str);
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW, demandOnlyRvSmash);
        demandOnlyRvSmash.showRewardedVideo();
    }

    public boolean isRewardedVideoAvailable(String str) {
        if (!this.mSmashes.containsKey(str)) {
            sendMediationEvent(1500, str);
            return false;
        }
        DemandOnlyRvSmash demandOnlyRvSmash = this.mSmashes.get(str);
        if (demandOnlyRvSmash.isRewardedVideoAvailable()) {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_READY_TRUE, demandOnlyRvSmash);
            return true;
        }
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_READY_FALSE, demandOnlyRvSmash);
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoLoadSuccess(DemandOnlyRvSmash demandOnlyRvSmash, long j) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoLoadSuccess");
        sendProviderEvent(1002, demandOnlyRvSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoLoadSuccess(demandOnlyRvSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError, DemandOnlyRvSmash demandOnlyRvSmash, long j) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdLoadFailed error=" + ironSourceError);
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, demandOnlyRvSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        if (ironSourceError.getErrorCode() == 1058) {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, demandOnlyRvSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        } else {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, demandOnlyRvSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        }
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(demandOnlyRvSmash.getSubProviderId(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdOpened(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdOpened");
        sendProviderEvent(1005, demandOnlyRvSmash);
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdOpened(demandOnlyRvSmash.getSubProviderId());
        if (demandOnlyRvSmash.isBidder()) {
            for (String str : demandOnlyRvSmash.mBUrl) {
                AuctionDataUtils.getInstance().sendResponse("onRewardedVideoAdOpened", demandOnlyRvSmash.getInstanceName(), AuctionDataUtils.getInstance().enrichNotificationURL(str, demandOnlyRvSmash.getInstanceName(), demandOnlyRvSmash.getInstanceType(), demandOnlyRvSmash.mDynamicDemandSourceId, "", "", "", ""));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdClosed(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdClosed");
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_CLOSED, demandOnlyRvSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().getSessionDepth(1))}});
        SessionDepthManager.getInstance().increaseSessionDepth(1);
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdClosed(demandOnlyRvSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdShowFailed error=" + ironSourceError);
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_SHOW_FAILED, demandOnlyRvSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdShowFailed(demandOnlyRvSmash.getSubProviderId(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdClicked(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdClicked");
        sendProviderEvent(1006, demandOnlyRvSmash);
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdClicked(demandOnlyRvSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdVisible(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdVisible");
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_VISIBLE, demandOnlyRvSmash);
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyRvManagerListener
    public void onRewardedVideoAdRewarded(DemandOnlyRvSmash demandOnlyRvSmash) {
        logSmashCallback(demandOnlyRvSmash, "onRewardedVideoAdRewarded");
        Map<String, Object> providerEventData = demandOnlyRvSmash.getProviderEventData();
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().getDynamicUserId())) {
            providerEventData.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceObject.getInstance().getDynamicUserId());
        }
        if (IronSourceObject.getInstance().getRvServerParams() != null) {
            for (String str : IronSourceObject.getInstance().getRvServerParams().keySet()) {
                providerEventData.put("custom_" + str, IronSourceObject.getInstance().getRvServerParams().get(str));
            }
        }
        Placement defaultRewardedVideoPlacement = IronSourceObject.getInstance().getCurrentServerResponse().getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
        if (defaultRewardedVideoPlacement != null) {
            providerEventData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, defaultRewardedVideoPlacement.getPlacementName());
            providerEventData.put(IronSourceConstants.EVENTS_REWARD_NAME, defaultRewardedVideoPlacement.getRewardName());
            providerEventData.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(defaultRewardedVideoPlacement.getRewardAmount()));
        } else {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "defaultPlacement is null", 3);
        }
        EventData eventData = new EventData(1010, new JSONObject(providerEventData));
        eventData.addToAdditionalData(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId("" + Long.toString(eventData.getTimeStamp()) + this.mAppKey + demandOnlyRvSmash.getInstanceName()));
        RewardedVideoEventsManager.getInstance().log(eventData);
        RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdRewarded(demandOnlyRvSmash.getSubProviderId());
    }

    private void sendProviderEvent(int i, DemandOnlyRvSmash demandOnlyRvSmash) {
        sendProviderEvent(i, demandOnlyRvSmash, null);
    }

    private void sendProviderEvent(int i, DemandOnlyRvSmash demandOnlyRvSmash, Object[][] objArr) {
        Map<String, Object> providerEventData = demandOnlyRvSmash.getProviderEventData();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerEventData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, new JSONObject(providerEventData)));
    }

    private void sendMediationEvent(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
        if (str == null) {
            str = "";
        }
        hashMap.put("spId", str);
        RewardedVideoEventsManager.getInstance().log(new EventData(i, new JSONObject(hashMap)));
    }

    private void logInternal(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "DemandOnlyRvManager " + str, 0);
    }

    private void logSmashCallback(DemandOnlyRvSmash demandOnlyRvSmash, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRvManager " + demandOnlyRvSmash.getInstanceName() + " : " + str, 0);
    }
}
