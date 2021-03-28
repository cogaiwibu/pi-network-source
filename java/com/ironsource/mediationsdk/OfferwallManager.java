package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.StringUtils;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.InternalOfferwallApi;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.OfferwallAdapterApi;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OfferwallManager implements InternalOfferwallApi, InternalOfferwallListener {
    private final String TAG = getClass().getName();
    private OfferwallAdapterApi mAdapter;
    private AtomicBoolean mAtomicShouldPerformInit = new AtomicBoolean(true);
    private String mCurrentPlacementName;
    private AtomicBoolean mIsOfferwallAvailable = new AtomicBoolean(false);
    private InternalOfferwallListener mListenersWrapper;
    private IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private ProviderSettings mProviderSettings;
    private ServerResponseWrapper mServerResponseWrapper;

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void setOfferwallListener(OfferwallListener offerwallListener) {
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void showOfferwall() {
    }

    OfferwallManager() {
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public synchronized void initOfferwall(String str, String str2) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        ironSourceLoggerManager.log(ironSourceTag, this.TAG + ":initOfferwall(appKey: " + str + ", userId: " + str2 + ")", 1);
        ServerResponseWrapper currentServerResponse = IronSourceObject.getInstance().getCurrentServerResponse();
        this.mServerResponseWrapper = currentServerResponse;
        String chooseOfferwallAdapter = chooseOfferwallAdapter(currentServerResponse);
        if (this.mServerResponseWrapper == null) {
            reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
            return;
        }
        ProviderSettings providerSettings = this.mServerResponseWrapper.getProviderSettingsHolder().getProviderSettings(chooseOfferwallAdapter);
        this.mProviderSettings = providerSettings;
        if (providerSettings == null) {
            reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
            return;
        }
        AbstractAdapter startOfferwallAdapter = startOfferwallAdapter(chooseOfferwallAdapter);
        if (startOfferwallAdapter == null) {
            reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", IronSourceConstants.OFFERWALL_AD_UNIT));
            return;
        }
        setCustomParams(startOfferwallAdapter);
        startOfferwallAdapter.setLogListener(this.mLoggerManager);
        OfferwallAdapterApi offerwallAdapterApi = (OfferwallAdapterApi) startOfferwallAdapter;
        this.mAdapter = offerwallAdapterApi;
        offerwallAdapterApi.setInternalOfferwallListener(this);
        this.mAdapter.initOfferwall(str, str2, this.mProviderSettings.getRewardedVideoSettings());
    }

    private String chooseOfferwallAdapter(ServerResponseWrapper serverResponseWrapper) {
        return (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || serverResponseWrapper.getConfigurations().getOfferwallConfigurations() == null || serverResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferWallAdapterName() == null) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : serverResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferWallAdapterName();
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void showOfferwall(String str) {
        String str2 = "OWManager:showOfferwall(" + str + ")";
        try {
            if (!IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getCurrentActiveActivity())) {
                this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError(IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            this.mCurrentPlacementName = str;
            OfferwallPlacement offerwallPlacement = this.mServerResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferwallPlacement(str);
            if (offerwallPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                offerwallPlacement = this.mServerResponseWrapper.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
                if (offerwallPlacement == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 1);
            if (this.mIsOfferwallAvailable != null && this.mIsOfferwallAvailable.get() && this.mAdapter != null) {
                this.mAdapter.showOfferwall(String.valueOf(offerwallPlacement.getPlacementId()), this.mProviderSettings.getRewardedVideoSettings());
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.INTERNAL, str2, e);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public synchronized boolean isOfferwallAvailable() {
        boolean z;
        z = false;
        if (this.mIsOfferwallAvailable != null) {
            z = this.mIsOfferwallAvailable.get();
        }
        return z;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void getOfferwallCredits() {
        OfferwallAdapterApi offerwallAdapterApi = this.mAdapter;
        if (offerwallAdapterApi != null) {
            offerwallAdapterApi.getOfferwallCredits();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InternalOfferwallApi
    public void setInternalOfferwallListener(InternalOfferwallListener internalOfferwallListener) {
        this.mListenersWrapper = internalOfferwallListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public void onOfferwallAvailable(boolean z) {
        onOfferwallAvailable(z, null);
    }

    @Override // com.ironsource.mediationsdk.sdk.InternalOfferwallListener
    public void onOfferwallAvailable(boolean z, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallAvailable(isAvailable: " + z + ")", 1);
        if (z) {
            this.mIsOfferwallAvailable.set(true);
            InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
            if (internalOfferwallListener != null) {
                internalOfferwallListener.onOfferwallAvailable(true);
                return;
            }
            return;
        }
        reportInitFail(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public void onOfferwallOpened() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        int sessionDepth = SessionDepthManager.getInstance().getSessionDepth(0);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (!TextUtils.isEmpty(this.mCurrentPlacementName)) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mCurrentPlacementName);
            }
            mediationAdditionalData.put("sessionDepth", sessionDepth);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(IronSourceConstants.OFFERWALL_OPENED, mediationAdditionalData));
        SessionDepthManager.getInstance().increaseSessionDepth(0);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallShowFailed(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public boolean onOfferwallAdCredited(int i, int i2, boolean z) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            return internalOfferwallListener.onOfferwallAdCredited(i, i2, z);
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        ironSourceLoggerManager.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallListener
    public void onOfferwallClosed() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallClosed();
        }
    }

    private synchronized void reportInitFail(IronSourceError ironSourceError) {
        if (this.mIsOfferwallAvailable != null) {
            this.mIsOfferwallAvailable.set(false);
        }
        if (this.mAtomicShouldPerformInit != null) {
            this.mAtomicShouldPerformInit.set(true);
        }
        if (this.mListenersWrapper != null) {
            this.mListenersWrapper.onOfferwallAvailable(false, ironSourceError);
        }
    }

    private AbstractAdapter startOfferwallAdapter(String str) {
        try {
            IronSourceObject instance = IronSourceObject.getInstance();
            AbstractAdapter offerwallAdapter = instance.getOfferwallAdapter(str);
            if (offerwallAdapter == null) {
                Class<?> cls = Class.forName("com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter");
                offerwallAdapter = (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, String.class).invoke(cls, str);
                if (offerwallAdapter == null) {
                    return null;
                }
            }
            instance.addOWAdapter(offerwallAdapter);
            return offerwallAdapter;
        } catch (Throwable th) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, str + " initialization failed - please verify that required dependencies are in you build path.", 2);
            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager2.logException(ironSourceTag2, this.TAG + ":startOfferwallAdapter", th);
            return null;
        }
    }

    private void setCustomParams(AbstractAdapter abstractAdapter) {
        try {
            String mediationSegment = IronSourceObject.getInstance().getMediationSegment();
            if (mediationSegment != null) {
                abstractAdapter.setMediationSegment(mediationSegment);
            }
            Boolean consent = IronSourceObject.getInstance().getConsent();
            if (consent != null) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
                ironSourceLoggerManager.log(ironSourceTag, "Offerwall | setConsent(consent:" + consent + ")", 1);
                abstractAdapter.setConsent(consent.booleanValue());
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager2.log(ironSourceTag2, ":setCustomParams():" + e.toString(), 3);
        }
    }
}
