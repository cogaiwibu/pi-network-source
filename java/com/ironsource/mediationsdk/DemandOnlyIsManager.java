package com.ironsource.mediationsdk;

import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener;
import com.ironsource.mediationsdk.utils.AuctionSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class DemandOnlyIsManager implements DemandOnlyIsManagerListener {
    private AuctionSettings mAuctionSettings;
    private ConcurrentHashMap<String, DemandOnlyIsSmash> mSmashes = new ConcurrentHashMap<>();

    DemandOnlyIsManager(List<ProviderSettings> list, InterstitialConfigurations interstitialConfigurations, String str, String str2) {
        this.mAuctionSettings = interstitialConfigurations.getInterstitialAuctionSettings();
        for (ProviderSettings providerSettings : list) {
            if (providerSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || providerSettings.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter adapter = AdapterRepository.getInstance().getAdapter(providerSettings, providerSettings.getRewardedVideoSettings(), true);
                if (adapter != null) {
                    this.mSmashes.put(providerSettings.getSubProviderId(), new DemandOnlyIsSmash(str, str2, providerSettings, this, interstitialConfigurations.getInterstitialAdaptersSmartLoadTimeout(), adapter));
                }
            } else {
                logInternal("cannot load " + providerSettings.getProviderTypeForReflection());
            }
        }
    }

    public void loadInterstitialWithAdm(String str, String str2, boolean z) {
        try {
            if (!this.mSmashes.containsKey(str)) {
                sendMediationEvent(IronSourceConstants.IS_INSTANCE_NOT_FOUND, str);
                ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, ErrorBuilder.buildNonExistentInstanceError("Interstitial"));
                return;
            }
            DemandOnlyIsSmash demandOnlyIsSmash = this.mSmashes.get(str);
            if (z) {
                if (!demandOnlyIsSmash.isBidder()) {
                    IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm in IAB flow must be called by bidder instances");
                    logInternal(buildLoadFailedError.getErrorMessage());
                    sendProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_FAILED, demandOnlyIsSmash);
                    ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, buildLoadFailedError);
                    return;
                }
                AuctionDataUtils.AuctionData auctionDataFromResponse = AuctionDataUtils.getInstance().getAuctionDataFromResponse(AuctionDataUtils.getInstance().decodeAdmResponse(str2));
                AuctionResponseItem auctionResponseItem = AuctionDataUtils.getInstance().getAuctionResponseItem(demandOnlyIsSmash.getInstanceName(), auctionDataFromResponse.getWaterfall());
                if (auctionResponseItem != null) {
                    demandOnlyIsSmash.setDynamicDemandSourceIdByServerData(auctionResponseItem.getServerData());
                    demandOnlyIsSmash.setAuctionId(auctionDataFromResponse.getAuctionId());
                    demandOnlyIsSmash.setGenericParams(auctionDataFromResponse.getGenericParams());
                    sendProviderEvent(2002, demandOnlyIsSmash);
                    demandOnlyIsSmash.loadInterstitial(auctionResponseItem.getServerData(), auctionDataFromResponse.getAuctionId(), auctionDataFromResponse.getGenericParams(), auctionResponseItem.getBurls());
                    return;
                }
                IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm invalid enriched adm");
                logInternal(buildLoadFailedError2.getErrorMessage());
                sendProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_FAILED, demandOnlyIsSmash);
                ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, buildLoadFailedError2);
            } else if (!demandOnlyIsSmash.isBidder()) {
                sendProviderEvent(2002, demandOnlyIsSmash);
                demandOnlyIsSmash.loadInterstitial("", "", null, null);
            } else {
                IronSourceError buildLoadFailedError3 = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm in non IAB flow must be called by non bidder instances");
                logInternal(buildLoadFailedError3.getErrorMessage());
                sendProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_FAILED, demandOnlyIsSmash);
                ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, buildLoadFailedError3);
            }
        } catch (Exception unused) {
            IronSourceError buildLoadFailedError4 = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm exception");
            logInternal(buildLoadFailedError4.getErrorMessage());
            ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, buildLoadFailedError4);
        }
    }

    public void showInterstitial(String str) {
        if (!this.mSmashes.containsKey(str)) {
            sendMediationEvent(IronSourceConstants.IS_INSTANCE_NOT_FOUND, str);
            ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdShowFailed(str, ErrorBuilder.buildNonExistentInstanceError("Interstitial"));
            return;
        }
        DemandOnlyIsSmash demandOnlyIsSmash = this.mSmashes.get(str);
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_SHOW, demandOnlyIsSmash);
        demandOnlyIsSmash.showInterstitial();
    }

    public boolean isInterstitialReady(String str) {
        if (!this.mSmashes.containsKey(str)) {
            sendMediationEvent(IronSourceConstants.IS_INSTANCE_NOT_FOUND, str);
            return false;
        }
        DemandOnlyIsSmash demandOnlyIsSmash = this.mSmashes.get(str);
        if (demandOnlyIsSmash.isInterstitialReady()) {
            sendProviderEvent(IronSourceConstants.IS_INSTANCE_READY_TRUE, demandOnlyIsSmash);
            return true;
        }
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_READY_FALSE, demandOnlyIsSmash);
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdReady(DemandOnlyIsSmash demandOnlyIsSmash, long j) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdReady");
        sendProviderEvent(2003, demandOnlyIsSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdReady(demandOnlyIsSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError, DemandOnlyIsSmash demandOnlyIsSmash, long j) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdLoadFailed error=" + ironSourceError.toString());
        if (ironSourceError.getErrorCode() == 1158) {
            sendProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL, demandOnlyIsSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        } else {
            sendProviderEvent(IronSourceConstants.IS_INSTANCE_LOAD_FAILED, demandOnlyIsSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(j)}});
        }
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(demandOnlyIsSmash.getSubProviderId(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdOpened(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdOpened");
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_OPENED, demandOnlyIsSmash);
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdOpened(demandOnlyIsSmash.getSubProviderId());
        if (demandOnlyIsSmash.isBidder()) {
            for (String str : demandOnlyIsSmash.mBUrl) {
                AuctionDataUtils.getInstance().sendResponse("onInterstitialAdOpened", demandOnlyIsSmash.getInstanceName(), AuctionDataUtils.getInstance().enrichNotificationURL(str, demandOnlyIsSmash.getInstanceName(), demandOnlyIsSmash.getInstanceType(), demandOnlyIsSmash.mDynamicDemandSourceId, "", "", "", ""));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdClosed(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdClosed");
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_CLOSED, demandOnlyIsSmash, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(SessionDepthManager.getInstance().getSessionDepth(2))}});
        SessionDepthManager.getInstance().increaseSessionDepth(2);
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdClosed(demandOnlyIsSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError, DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdShowFailed error=" + ironSourceError.toString());
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_SHOW_FAILED, demandOnlyIsSmash, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdShowFailed(demandOnlyIsSmash.getSubProviderId(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdClicked(DemandOnlyIsSmash demandOnlyIsSmash) {
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdClicked");
        sendProviderEvent(2006, demandOnlyIsSmash);
        ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdClicked(demandOnlyIsSmash.getSubProviderId());
    }

    @Override // com.ironsource.mediationsdk.sdk.DemandOnlyIsManagerListener
    public void onInterstitialAdVisible(DemandOnlyIsSmash demandOnlyIsSmash) {
        sendProviderEvent(IronSourceConstants.IS_INSTANCE_VISIBLE, demandOnlyIsSmash);
        logSmashCallback(demandOnlyIsSmash, "onInterstitialAdVisible");
    }

    private void sendProviderEvent(int i, DemandOnlyIsSmash demandOnlyIsSmash) {
        sendProviderEvent(i, demandOnlyIsSmash, null);
    }

    private void sendProviderEvent(int i, DemandOnlyIsSmash demandOnlyIsSmash, Object[][] objArr) {
        Map<String, Object> providerEventData = demandOnlyIsSmash.getProviderEventData();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerEventData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IS sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        InterstitialEventsManager.getInstance().log(new EventData(i, new JSONObject(providerEventData)));
    }

    private void sendMediationEvent(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
        if (str == null) {
            str = "";
        }
        hashMap.put("spId", str);
        InterstitialEventsManager.getInstance().log(new EventData(i, new JSONObject(hashMap)));
    }

    private void logInternal(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "DemandOnlyIsManager " + str, 0);
    }

    private void logSmashCallback(DemandOnlyIsSmash demandOnlyIsSmash, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyIsManager " + demandOnlyIsSmash.getInstanceName() + " : " + str, 0);
    }
}
