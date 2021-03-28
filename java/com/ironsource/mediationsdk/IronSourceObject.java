package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.config.ConfigValidationResult;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.events.SuperLooper;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.ConsoleLogger;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.logger.PublisherLogger;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.IronSourceInterface;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utilities.IronSourcePreconditions;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.GeneralPropertiesWorker;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceTempUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceObject implements IronSourceInterface, MediationInitializer.OnMediationInitializationListener {
    private static boolean mDidSendEncryptionFailEventInSession = false;
    private final String IRONSOURCE_VERSION_STRING;
    private final String IS_DEMAND_ONLY_INIT_WITH_ACTIVITY;
    private final String KEY_INIT_COUNTER;
    private final String TAG;
    private Set<IronSource.AD_UNIT> mAdUnitsToInitialize;
    private String mAppKey;
    private AtomicBoolean mAtomicIsFirstInit;
    private BannerManager mBannerManager;
    private IronSourceBannerLayout mBnLayoutToLoad;
    private String mBnPlacementToLoad;
    private Boolean mConsent;
    private ServerResponseWrapper mCurrentServerResponse;
    private CopyOnWriteArraySet<String> mDemandOnlyIsLoadBeforeInitCompleted;
    private DemandOnlyIsManager mDemandOnlyIsManager;
    private CopyOnWriteArraySet<String> mDemandOnlyRvLoadBeforeInitCompleted;
    private DemandOnlyRvManager mDemandOnlyRvManager;
    private boolean mDidInitBanner;
    private boolean mDidInitInterstitial;
    private boolean mDidInitRewardedVideo;
    private String mDynamicUserId;
    private AtomicBoolean mEventManagersInit;
    private int mInitCounter;
    private InitializationListener mInitListener;
    private boolean mInitSucceeded;
    private List<IronSource.AD_UNIT> mInitiatedAdUnits;
    private InterstitialManager mInterstitialManager;
    private IronSourceSegment mIronSegment;
    private Boolean mIsBnLoadBeforeInitCompleted;
    private boolean mIsBnProgrammatic;
    private boolean mIsDemandOnlyIs;
    private boolean mIsDemandOnlyRv;
    private boolean mIsIsLoadBeforeInitCompleted;
    private boolean mIsIsProgrammatic;
    private boolean mIsRvProgrammatic;
    private ListenersWrapper mListenersWrapper;
    private IronSourceLoggerManager mLoggerManager;
    private String mMediationType;
    private AbstractAdapter mOfferwallAdapter;
    private OfferwallManager mOfferwallManager;
    private ProgBannerManager mProgBannerManager;
    private ProgIsManager mProgIsManager;
    private IProgRvManager mProgRvManager;
    private PublisherLogger mPublisherLogger;
    private Set<IronSource.AD_UNIT> mRequestedAdUnits;
    private RewardedVideoManager mRewardedVideoManager;
    private Map<String, String> mRvServerParams;
    private String mSegment;
    private final Object mServerResponseLocker;
    private String mSessionId;
    private boolean mShouldSendGetInstanceEvent;
    private Boolean mShouldTrackNetworkState;
    private Context mTrackNetworkStateContext;
    private String mUserId;
    private int rvProgrammaticMode;

    public interface IResponseListener {
        void onUnrecoverableError(String str);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialApi
    public void initInterstitial(Activity activity, String str, String str2) {
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void initOfferwall(String str, String str2) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoApi
    public void initRewardedVideo(Activity activity, String str, String str2) {
    }

    /* synthetic */ IronSourceObject(AnonymousClass1 r1) {
        this();
    }

    /* access modifiers changed from: private */
    public static class IronSourceObjectLoader {
        static volatile IronSourceObject INSTANCE = new IronSourceObject(null);

        private IronSourceObjectLoader() {
        }
    }

    public static IronSourceObject getInstance() {
        return IronSourceObjectLoader.INSTANCE;
    }

    private IronSourceObject() {
        this.TAG = getClass().getName();
        this.IRONSOURCE_VERSION_STRING = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:​7.1.1";
        this.IS_DEMAND_ONLY_INIT_WITH_ACTIVITY = "Activity=";
        this.mServerResponseLocker = new Object();
        this.mCurrentServerResponse = null;
        this.mAppKey = null;
        this.mUserId = null;
        this.mSegment = null;
        this.mDynamicUserId = null;
        this.mRvServerParams = null;
        this.mMediationType = null;
        this.mInitSucceeded = false;
        this.mSessionId = null;
        this.mShouldTrackNetworkState = null;
        this.mShouldSendGetInstanceEvent = true;
        this.KEY_INIT_COUNTER = "sessionDepth";
        this.mConsent = null;
        initializeManagers();
        this.mEventManagersInit = new AtomicBoolean();
        this.mAdUnitsToInitialize = new HashSet();
        this.mRequestedAdUnits = new HashSet();
        this.mIsDemandOnlyIs = false;
        this.mIsDemandOnlyRv = false;
        this.mAtomicIsFirstInit = new AtomicBoolean(true);
        this.mInitCounter = 0;
        this.mDidInitRewardedVideo = false;
        this.mDidInitInterstitial = false;
        this.mDidInitBanner = false;
        this.mSessionId = UUID.randomUUID().toString();
        this.mIsBnLoadBeforeInitCompleted = false;
        this.mIsIsLoadBeforeInitCompleted = false;
        this.mBnPlacementToLoad = null;
        this.mProgRvManager = null;
        this.mProgIsManager = null;
        this.mInitListener = null;
        this.mProgBannerManager = null;
        this.mIsRvProgrammatic = false;
        this.mIsIsProgrammatic = false;
        this.mIsBnProgrammatic = false;
        this.mDemandOnlyIsLoadBeforeInitCompleted = new CopyOnWriteArraySet<>();
        this.mDemandOnlyRvLoadBeforeInitCompleted = new CopyOnWriteArraySet<>();
        this.mDemandOnlyIsManager = null;
        this.mDemandOnlyRvManager = null;
        this.mBannerManager = null;
        this.rvProgrammaticMode = 1;
    }

    public void sendInitCompletedEvent(long j) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(isDemandOnlyInit());
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_DURATION, j);
            mediationAdditionalData.put("sessionDepth", this.mInitCounter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(IronSourceConstants.INIT_COMPLETE, mediationAdditionalData));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r7, java.lang.String r8, boolean r9, com.ironsource.mediationsdk.sdk.InitializationListener r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
        // Method dump skipped, instructions count: 464
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.init(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    private void calculateFirstSessionTimestamp() {
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        boolean isInitResponseCached = IronSourceUtils.isInitResponseCached(applicationContext);
        long firstSessionTimestamp = IronSourceUtils.getFirstSessionTimestamp(applicationContext);
        if (!isInitResponseCached && firstSessionTimestamp == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("get first session timestamp = " + currentTimeMillis);
            IronSourceUtils.saveFirstSessionTimestamp(applicationContext, currentTimeMillis);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initISDemandOnly(android.content.Context r9, java.lang.String r10, com.ironsource.mediationsdk.sdk.InitializationListener r11, com.ironsource.mediationsdk.IronSource.AD_UNIT... r12) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.initISDemandOnly(android.content.Context, java.lang.String, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    private void sendAdUnitAlreadyInitializedLog(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private synchronized void attachAdUnits(boolean z, IronSource.AD_UNIT... ad_unitArr) {
        int i = 0;
        for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
            if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mDidInitInterstitial = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                this.mDidInitBanner = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.mDidInitRewardedVideo = true;
            }
        }
        if (MediationInitializer.getInstance().getCurrentInitStatus() == MediationInitializer.EInitStatus.INIT_FAILED) {
            try {
                if (this.mListenersWrapper != null) {
                    int length = ad_unitArr.length;
                    while (i < length) {
                        IronSource.AD_UNIT ad_unit2 = ad_unitArr[i];
                        if (!this.mAdUnitsToInitialize.contains(ad_unit2)) {
                            notifyPublisherAboutInitFailed(ad_unit2, true);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!this.mInitSucceeded) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z);
            int length2 = ad_unitArr.length;
            boolean z2 = false;
            while (i < length2) {
                IronSource.AD_UNIT ad_unit3 = ad_unitArr[i];
                if (!this.mAdUnitsToInitialize.contains(ad_unit3)) {
                    this.mAdUnitsToInitialize.add(ad_unit3);
                    this.mRequestedAdUnits.add(ad_unit3);
                    try {
                        mediationAdditionalData.put(ad_unit3.toString(), true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    z2 = true;
                } else {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                }
                i++;
            }
            if (z2) {
                try {
                    StringBuilder sb = new StringBuilder();
                    String str = ",androidx=" + IronSourceUtils.isAndroidXAvailable();
                    String str2 = ",Activity=" + isActivityExist();
                    if (IronSourceTempUtils.isKotlinLibraryExist()) {
                        sb.append(IronSourceConstants.IS_APP_LANGUAGE_KOTLIN);
                        sb.append(IronSourceTempUtils.testKotlin());
                    } else {
                        sb.append(IronSourceConstants.IS_APP_LANGUAGE_JAVA);
                    }
                    sb.append(str);
                    if (isDemandOnlyInit()) {
                        sb.append(str2);
                    }
                    mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
                    int i2 = this.mInitCounter + 1;
                    this.mInitCounter = i2;
                    mediationAdditionalData.put("sessionDepth", i2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().log(new EventData(14, mediationAdditionalData));
            }
        } else if (this.mInitiatedAdUnits != null) {
            JSONObject mediationAdditionalData2 = IronSourceUtils.getMediationAdditionalData(z);
            boolean z3 = false;
            for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
                if (!this.mAdUnitsToInitialize.contains(ad_unit4)) {
                    this.mAdUnitsToInitialize.add(ad_unit4);
                    this.mRequestedAdUnits.add(ad_unit4);
                    try {
                        mediationAdditionalData2.put(ad_unit4.toString(), true);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    if (this.mInitiatedAdUnits == null || !this.mInitiatedAdUnits.contains(ad_unit4)) {
                        notifyPublisherAboutInitFailed(ad_unit4, false);
                    } else {
                        startAdUnit(ad_unit4);
                    }
                    z3 = true;
                } else {
                    sendAdUnitAlreadyInitializedLog(ad_unit4);
                }
            }
            if (z3) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    String str3 = ",androidx=" + IronSourceUtils.isAndroidXAvailable();
                    String str4 = ",Activity=" + isActivityExist();
                    if (IronSourceTempUtils.isKotlinLibraryExist()) {
                        sb2.append(IronSourceConstants.IS_APP_LANGUAGE_KOTLIN);
                        sb2.append(IronSourceTempUtils.testKotlin());
                    } else {
                        sb2.append(IronSourceConstants.IS_APP_LANGUAGE_JAVA);
                    }
                    sb2.append(str3);
                    if (isDemandOnlyInit()) {
                        sb2.append(str4);
                    }
                    mediationAdditionalData2.put(IronSourceConstants.EVENTS_EXT1, sb2.toString());
                    int i3 = this.mInitCounter + 1;
                    this.mInitCounter = i3;
                    mediationAdditionalData2.put("sessionDepth", i3);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().log(new EventData(14, mediationAdditionalData2));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onInitSuccess(List<IronSource.AD_UNIT> list, boolean z) {
        IronLog.INTERNAL.verbose("");
        try {
            this.mInitiatedAdUnits = list;
            this.mInitSucceeded = true;
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().log(new EventData(114, mediationAdditionalData));
            }
            InterstitialEventsManager.getInstance().triggerEventsSend();
            RewardedVideoEventsManager.getInstance().triggerEventsSend();
            AdapterRepository.getInstance().setInitParams(getIronSourceAppKey(), getIronSourceUserId());
            IronSource.AD_UNIT[] values = IronSource.AD_UNIT.values();
            for (IronSource.AD_UNIT ad_unit : values) {
                if (this.mAdUnitsToInitialize.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        startAdUnit(ad_unit);
                    } else {
                        notifyPublisherAboutInitFailed(ad_unit, false);
                    }
                }
            }
            if (this.mInitListener != null) {
                IronLog.CALLBACK.verbose("onInitializationCompleted");
                this.mInitListener.onInitializationCompleted();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void startAdUnit(IronSource.AD_UNIT ad_unit) {
        int i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT[ad_unit.ordinal()];
        if (i == 1) {
            startRewardedVideo();
        } else if (i == 2) {
            startInterstitial();
        } else if (i == 3) {
            this.mOfferwallManager.initOfferwall(getIronSourceAppKey(), getIronSourceUserId());
        } else if (i == 4) {
            startBanner();
        }
    }

    private void startProgrammaticRv() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().size(); i++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str));
            }
        }
        if (arrayList.size() > 0) {
            if (this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAuctionSettings().getIsLoadWhileShow()) {
                this.mProgRvManager = new LWSProgRvManager(arrayList, this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations(), getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks(), IronsourceObjectPublisherDataHolder.getInstance().getImpressionDataListeners());
            } else {
                this.mProgRvManager = new ProgRvManager(arrayList, this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations(), getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks(), IronsourceObjectPublisherDataHolder.getInstance().getImpressionDataListeners());
            }
            Boolean bool = this.mShouldTrackNetworkState;
            if (bool != null) {
                this.mProgRvManager.shouldTrackNetworkState(this.mTrackNetworkStateContext, bool.booleanValue());
                if (this.mShouldTrackNetworkState.booleanValue()) {
                    this.mRewardedVideoManager.shouldTrackNetworkState(this.mTrackNetworkStateContext, false);
                    return;
                }
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.rvProgrammaticMode);
        addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        sentEventWithRVEventManager(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void startDemandOnlyRv() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().size(); i++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.mDemandOnlyRvLoadBeforeInitCompleted) {
                this.mDemandOnlyRvManager = new DemandOnlyRvManager(arrayList, this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations(), getIronSourceAppKey(), getIronSourceUserId());
            }
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                notifyPublisherAboutInitFailed(IronSource.AD_UNIT.REWARDED_VIDEO, false);
                return;
            }
            Iterator<String> it = this.mDemandOnlyRvLoadBeforeInitCompleted.iterator();
            while (it.hasNext()) {
                this.mDemandOnlyRvManager.loadRewardedVideoWithAdm(it.next(), null, false);
            }
            this.mDemandOnlyRvLoadBeforeInitCompleted.clear();
            return;
        }
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void startRewardedVideo() {
        ProviderSettings providerSettings;
        ProviderSettings providerSettings2;
        ProviderSettings providerSettings3;
        if (this.mIsDemandOnlyRv) {
            startDemandOnlyRv();
            return;
        }
        this.mIsRvProgrammatic = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAuctionSettings().getIsProgrammatic();
        int i = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAuctionSettings().getIsLoadWhileShow() ? 2 : 1;
        this.rvProgrammaticMode = i;
        sentEventWithRVEventManager(IronSourceConstants.TROUBLESHOOTING_RV_FORK, IronSourceUtils.getMediationAdditionalData(false, this.mIsRvProgrammatic, i));
        if (this.mIsRvProgrammatic) {
            startProgrammaticRv();
            return;
        }
        int rewardedVideoAdaptersSmartLoadTimeout = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAdaptersSmartLoadTimeout();
        for (int i2 = 0; i2 < this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().size(); i2++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().get(i2);
            if (!TextUtils.isEmpty(str) && (providerSettings3 = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str)) != null) {
                RewardedVideoSmash rewardedVideoSmash = new RewardedVideoSmash(providerSettings3, rewardedVideoAdaptersSmartLoadTimeout);
                if (validateSmash(rewardedVideoSmash)) {
                    rewardedVideoSmash.setRewardedVideoManagerListener(this.mRewardedVideoManager);
                    rewardedVideoSmash.setProviderPriority(i2 + 1);
                    this.mRewardedVideoManager.addSmashToArray(rewardedVideoSmash);
                }
            }
        }
        if (this.mRewardedVideoManager.mSmashArray.size() > 0) {
            this.mRewardedVideoManager.setIsUltraEventsEnabled(this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().isUltraEventsEnabled());
            this.mRewardedVideoManager.setSmartLoadAmount(this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAdaptersSmartLoadAmount());
            this.mRewardedVideoManager.setManualLoadInterval(this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getManualLoadIntervalInSeconds());
            String rVBackFillProvider = this.mCurrentServerResponse.getRVBackFillProvider();
            if (!TextUtils.isEmpty(rVBackFillProvider) && (providerSettings2 = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(rVBackFillProvider)) != null) {
                RewardedVideoSmash rewardedVideoSmash2 = new RewardedVideoSmash(providerSettings2, rewardedVideoAdaptersSmartLoadTimeout);
                if (validateSmash(rewardedVideoSmash2)) {
                    rewardedVideoSmash2.setRewardedVideoManagerListener(this.mRewardedVideoManager);
                    this.mRewardedVideoManager.setBackfillSmash(rewardedVideoSmash2);
                }
            }
            String rVPremiumProvider = this.mCurrentServerResponse.getRVPremiumProvider();
            if (!TextUtils.isEmpty(rVPremiumProvider) && (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(rVPremiumProvider)) != null) {
                RewardedVideoSmash rewardedVideoSmash3 = new RewardedVideoSmash(providerSettings, rewardedVideoAdaptersSmartLoadTimeout);
                if (validateSmash(rewardedVideoSmash3)) {
                    rewardedVideoSmash3.setRewardedVideoManagerListener(this.mRewardedVideoManager);
                    this.mRewardedVideoManager.setPremiumSmash(rewardedVideoSmash3);
                }
            }
            this.mRewardedVideoManager.setExpiredDurationInMinutes(this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getExpiredDurationInMinutes());
            this.mRewardedVideoManager.initRewardedVideo(getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks());
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, this.rvProgrammaticMode);
        addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        sentEventWithRVEventManager(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void startProgrammaticIs() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().size(); i++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str));
            }
        }
        if (arrayList.size() > 0) {
            ProgIsManager progIsManager = new ProgIsManager(arrayList, this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations(), getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks(), this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getISDelayLoadFailure(), IronsourceObjectPublisherDataHolder.getInstance().getImpressionDataListeners());
            this.mProgIsManager = progIsManager;
            Boolean bool = this.mShouldTrackNetworkState;
            if (bool != null) {
                progIsManager.shouldTrackNetworkState(this.mTrackNetworkStateContext, bool.booleanValue());
                if (this.mShouldTrackNetworkState.booleanValue()) {
                    this.mInterstitialManager.shouldTrackNetworkState(this.mTrackNetworkStateContext, false);
                }
            }
            if (this.mIsIsLoadBeforeInitCompleted) {
                this.mIsIsLoadBeforeInitCompleted = false;
                this.mProgIsManager.loadInterstitial();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void startProgrammaticBn(ArrayList<ProviderSettings> arrayList) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
        this.mProgBannerManager = new ProgBannerManager(arrayList, new BannerData(getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks(), this.mCurrentServerResponse.getConfigurations().getBannerConfigurations()), IronsourceObjectPublisherDataHolder.getInstance().getImpressionDataListeners());
        handleBannerLoadBeforeInit();
    }

    private void startDemandOnlyIs() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().size(); i++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.mDemandOnlyIsLoadBeforeInitCompleted) {
                this.mDemandOnlyIsManager = new DemandOnlyIsManager(arrayList, this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations(), getIronSourceAppKey(), getIronSourceUserId());
            }
            Iterator<String> it = this.mDemandOnlyIsLoadBeforeInitCompleted.iterator();
            while (it.hasNext()) {
                this.mDemandOnlyIsManager.loadInterstitialWithAdm(it.next(), null, false);
            }
            this.mDemandOnlyIsLoadBeforeInitCompleted.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void startInterstitial() {
        ProviderSettings providerSettings;
        if (this.mIsDemandOnlyIs) {
            startDemandOnlyIs();
            return;
        }
        boolean isProgrammatic = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialAuctionSettings().getIsProgrammatic();
        this.mIsIsProgrammatic = isProgrammatic;
        sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_IS_FORK, IronSourceUtils.getMediationAdditionalData(false, isProgrammatic, 1));
        if (this.mIsIsProgrammatic) {
            startProgrammaticIs();
            return;
        }
        int interstitialAdaptersSmartLoadTimeout = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialAdaptersSmartLoadTimeout();
        this.mInterstitialManager.setDelayLoadFailureNotificationInSeconds(this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getISDelayLoadFailure());
        for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().size(); i++) {
            String str = this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().get(i);
            if (!TextUtils.isEmpty(str) && (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str)) != null) {
                InterstitialSmash interstitialSmash = new InterstitialSmash(providerSettings, interstitialAdaptersSmartLoadTimeout);
                if (validateSmash(interstitialSmash)) {
                    interstitialSmash.setInterstitialManagerListener(this.mInterstitialManager);
                    interstitialSmash.setProviderPriority(i + 1);
                    this.mInterstitialManager.addSmashToArray(interstitialSmash);
                }
            }
        }
        if (this.mInterstitialManager.mSmashArray.size() > 0) {
            this.mInterstitialManager.setSmartLoadAmount(this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialAdaptersSmartLoadAmount());
            this.mInterstitialManager.initInterstitial(getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks());
            if (this.mIsIsLoadBeforeInitCompleted) {
                this.mIsIsLoadBeforeInitCompleted = false;
                this.mInterstitialManager.loadInterstitial();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        notifyPublisherAboutInitFailed(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void startBanner() {
        ProviderSettings providerSettings;
        synchronized (this.mIsBnLoadBeforeInitCompleted) {
            this.mIsBnProgrammatic = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerAuctionSettings().getIsProgrammatic();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("mIsBnProgrammatic = " + this.mIsBnProgrammatic);
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("mIsBnLoadBeforeInitCompleted = " + this.mIsBnLoadBeforeInitCompleted);
            sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_BN_FORK, IronSourceUtils.getMediationAdditionalData(false, this.mIsBnProgrammatic, 1));
            ArrayList<ProviderSettings> arrayList = new ArrayList<>();
            for (int i = 0; i < this.mCurrentServerResponse.getProviderOrder().getBannerProviderOrder().size(); i++) {
                String str = this.mCurrentServerResponse.getProviderOrder().getBannerProviderOrder().get(i);
                if (!TextUtils.isEmpty(str) && (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(str)) != null) {
                    arrayList.add(providerSettings);
                }
            }
            if (arrayList.size() <= 0) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, this.mIsBnProgrammatic, 1);
                addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
                sentEventWithISEventManager(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
                notifyPublisherAboutInitFailed(IronSource.AD_UNIT.BANNER, false);
            } else if (this.mIsBnProgrammatic) {
                startProgrammaticBn(arrayList);
            } else {
                this.mBannerManager = new BannerManager(arrayList, getIronSourceAppKey(), IronSourceUtils.getUserIdForNetworks(), this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerAdaptersSmartLoadTimeout(), this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerRefreshInterval(), this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerDelayLoadFailure());
                handleBannerLoadBeforeInit();
            }
        }
    }

    private void handleBannerLoadBeforeInit() {
        if (this.mIsBnLoadBeforeInitCompleted.booleanValue()) {
            this.mIsBnLoadBeforeInitCompleted = false;
            loadBanner(this.mBnLayoutToLoad, this.mBnPlacementToLoad);
            this.mBnLayoutToLoad = null;
            this.mBnPlacementToLoad = null;
        }
    }

    private boolean validateSmash(AbstractSmash abstractSmash) {
        return abstractSmash.getMaxAdsPerIteration() >= 1 && abstractSmash.getMaxAdsPerSession() >= 1;
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onInitFailed(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.mListenersWrapper != null) {
                for (IronSource.AD_UNIT ad_unit : this.mAdUnitsToInitialize) {
                    notifyPublisherAboutInitFailed(ad_unit, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.MediationInitializer.OnMediationInitializationListener
    public void onStillInProgressAfter15Secs() {
        synchronized (this.mIsBnLoadBeforeInitCompleted) {
            if (this.mIsBnLoadBeforeInitCompleted.booleanValue()) {
                this.mIsBnLoadBeforeInitCompleted = false;
                BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mBnLayoutToLoad, new IronSourceError(IronSourceError.ERROR_BN_LOAD_WHILE_LONG_INITIATION, "init had failed"));
                this.mBnLayoutToLoad = null;
                this.mBnPlacementToLoad = null;
            }
        }
        if (this.mIsIsLoadBeforeInitCompleted) {
            this.mIsIsLoadBeforeInitCompleted = false;
            CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        synchronized (this.mDemandOnlyIsLoadBeforeInitCompleted) {
            Iterator<String> it = this.mDemandOnlyIsLoadBeforeInitCompleted.iterator();
            while (it.hasNext()) {
                ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(it.next(), ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.mDemandOnlyIsLoadBeforeInitCompleted.clear();
        }
        synchronized (this.mDemandOnlyRvLoadBeforeInitCompleted) {
            Iterator<String> it2 = this.mDemandOnlyRvLoadBeforeInitCompleted.iterator();
            while (it2.hasNext()) {
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(it2.next(), ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.mDemandOnlyRvLoadBeforeInitCompleted.clear();
        }
    }

    private void notifyPublisherAboutInitFailed(IronSource.AD_UNIT ad_unit, boolean z) {
        int i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT[ad_unit.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        synchronized (this.mIsBnLoadBeforeInitCompleted) {
                            if (this.mIsBnLoadBeforeInitCompleted.booleanValue()) {
                                this.mIsBnLoadBeforeInitCompleted = false;
                                BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mBnLayoutToLoad, new IronSourceError(IronSourceError.ERROR_BN_INIT_FAILED_AFTER_LOAD, "Init had failed"));
                                this.mBnLayoutToLoad = null;
                                this.mBnPlacementToLoad = null;
                            }
                        }
                    }
                } else if (z || isOfferwallConfigurationsReady() || this.mRequestedAdUnits.contains(ad_unit)) {
                    this.mListenersWrapper.onOfferwallAvailable(false);
                }
            } else if (this.mIsDemandOnlyIs) {
                Iterator<String> it = this.mDemandOnlyIsLoadBeforeInitCompleted.iterator();
                while (it.hasNext()) {
                    ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(it.next(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
                }
                this.mDemandOnlyIsLoadBeforeInitCompleted.clear();
            } else if (this.mIsIsLoadBeforeInitCompleted) {
                this.mIsIsLoadBeforeInitCompleted = false;
                CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
        } else if (this.mIsDemandOnlyRv) {
            Iterator<String> it2 = this.mDemandOnlyRvLoadBeforeInitCompleted.iterator();
            while (it2.hasNext()) {
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(it2.next(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.mDemandOnlyRvLoadBeforeInitCompleted.clear();
        } else if (z || isRewardedVideoConfigurationsReady() || this.mRequestedAdUnits.contains(ad_unit)) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(false);
        }
    }

    private void prepareEventManagers(Context context) {
        AtomicBoolean atomicBoolean = this.mEventManagersInit;
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            SuperLooper.getLooper().post(new GeneralPropertiesWorker(context));
            InterstitialEventsManager.getInstance().start(context, this.mIronSegment);
            RewardedVideoEventsManager.getInstance().start(context, this.mIronSegment);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void addOWAdapter(AbstractAdapter abstractAdapter) {
        this.mOfferwallAdapter = abstractAdapter;
    }

    /* access modifiers changed from: package-private */
    public synchronized AbstractAdapter getOfferwallAdapter(String str) {
        try {
            if (this.mOfferwallAdapter != null && this.mOfferwallAdapter.getProviderName().equals(str)) {
                return this.mOfferwallAdapter;
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "getOfferwallAdapter exception: " + e, 1);
        }
        return null;
    }

    private void initializeManagers() {
        this.mLoggerManager = IronSourceLoggerManager.getLogger(0);
        PublisherLogger publisherLogger = new PublisherLogger(null, 1);
        this.mPublisherLogger = publisherLogger;
        this.mLoggerManager.addLogger(publisherLogger);
        this.mListenersWrapper = new ListenersWrapper();
        RewardedVideoManager rewardedVideoManager = new RewardedVideoManager();
        this.mRewardedVideoManager = rewardedVideoManager;
        rewardedVideoManager.setRewardedVideoListener(this.mListenersWrapper);
        InterstitialManager interstitialManager = new InterstitialManager();
        this.mInterstitialManager = interstitialManager;
        interstitialManager.setInterstitialListener(this.mListenersWrapper);
        OfferwallManager offerwallManager = new OfferwallManager();
        this.mOfferwallManager = offerwallManager;
        offerwallManager.setInternalOfferwallListener(this.mListenersWrapper);
    }

    public void onResume(Activity activity) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            ContextProvider.getInstance().onResume(activity);
            if (this.mBannerManager != null) {
                this.mBannerManager.onResume();
            }
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
        }
    }

    public void onPause(Activity activity) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
            if (this.mBannerManager != null) {
                this.mBannerManager.onPause();
            }
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BaseApi
    public void setMediationSegment(String str) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, this.TAG + ":setMediationSegment(segment:" + str + ")", 1);
            ConfigValidationResult configValidationResult = new ConfigValidationResult();
            validateSegment(str, configValidationResult);
            if (configValidationResult.isValid()) {
                this.mSegment = str;
            } else {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.TAG + ":setMediationSegment(segment:" + str + ")", e);
        }
    }

    public void setSegment(IronSourceSegment ironSourceSegment) {
        if (MediationInitializer.getInstance().getCurrentInitStatus() == MediationInitializer.EInitStatus.INIT_IN_PROGRESS || MediationInitializer.getInstance().getCurrentInitStatus() == MediationInitializer.EInitStatus.INITIATED) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Segments must be set prior to Init. Setting a segment after the init will be ignored", 0);
        } else {
            this.mIronSegment = ironSourceSegment;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public boolean setDynamicUserId(String str) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, this.TAG + ":setDynamicUserId(dynamicUserId:" + str + ")", 1);
            ConfigValidationResult configValidationResult = new ConfigValidationResult();
            validateDynamicUserId(str, configValidationResult);
            if (configValidationResult.isValid()) {
                this.mDynamicUserId = str;
                RewardedVideoEventsManager.getInstance().log(new EventData(52, IronSourceUtils.getJsonForUserId(true)));
                return true;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
            return false;
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.TAG + ":setDynamicUserId(dynamicUserId:" + str + ")", e);
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setAdaptersDebug(boolean z) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setAdaptersDebug : " + z, 1);
        AdapterRepository.getInstance().setAdaptersDebug(z);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setMediationType(String str) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, this.TAG + ":setMediationType(mediationType:" + str + ")", 1);
            if (!validateLength(str, 1, 64) || !validateAlphanumeric(str)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            } else {
                this.mMediationType = str;
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.TAG + ":setMediationType(mediationType:" + str + ")", e);
        }
    }

    /* access modifiers changed from: package-private */
    public String getMediationSegment() {
        return this.mSegment;
    }

    /* access modifiers changed from: package-private */
    public String getDynamicUserId() {
        return this.mDynamicUserId;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getRvServerParams() {
        return this.mRvServerParams;
    }

    public String getMediationType() {
        return this.mMediationType;
    }

    public void showRewardedVideo() {
        if (!isRewardedVideoConfigurationsReady()) {
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement defaultRewardedVideoPlacement = getDefaultRewardedVideoPlacement();
        if (defaultRewardedVideoPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"));
            return;
        }
        showRewardedVideo(defaultRewardedVideoPlacement.getPlacementName());
    }

    private Placement getRewardedVideoPlacement(String str) {
        RewardedVideoConfigurations rewardedVideoConfigurations = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations();
        if (rewardedVideoConfigurations != null) {
            return rewardedVideoConfigurations.getRewardedVideoPlacement(str);
        }
        return null;
    }

    private Placement getDefaultRewardedVideoPlacement() {
        RewardedVideoConfigurations rewardedVideoConfigurations = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations();
        if (rewardedVideoConfigurations != null) {
            return rewardedVideoConfigurations.getDefaultRewardedVideoPlacement();
        }
        return null;
    }

    private void showProgrammaticRewardedVideo(String str) {
        Placement rewardedVideoPlacement = getRewardedVideoPlacement(str);
        if (rewardedVideoPlacement == null) {
            rewardedVideoPlacement = getDefaultRewardedVideoPlacement();
        }
        if (rewardedVideoPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(new IronSourceError(1021, "showProgrammaticRewardedVideo error: empty default placement in response"));
            return;
        }
        this.mProgRvManager.showRewardedVideo(rewardedVideoPlacement);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoApi
    public void showRewardedVideo(String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.mIsDemandOnlyRv) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (!isRewardedVideoConfigurationsReady()) {
                this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (!this.mIsRvProgrammatic || this.mProgRvManager == null) {
                Placement placementToShowWithEvent = getPlacementToShowWithEvent(str);
                if (placementToShowWithEvent != null) {
                    this.mRewardedVideoManager.setCurrentPlacement(placementToShowWithEvent);
                    this.mRewardedVideoManager.showRewardedVideo(placementToShowWithEvent.getPlacementName());
                }
            } else {
                showProgrammaticRewardedVideo(str);
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoApi
    public boolean isRewardedVideoAvailable() {
        boolean z;
        Throwable th;
        boolean z2;
        try {
            if (this.mIsDemandOnlyRv) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            if (this.mIsRvProgrammatic) {
                z2 = this.mProgRvManager != null && this.mProgRvManager.isRewardedVideoAvailable();
            } else {
                z2 = this.mRewardedVideoManager.isRewardedVideoAvailable();
            }
            try {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                if (this.mIsRvProgrammatic) {
                    addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.rvProgrammaticMode)}});
                }
                RewardedVideoEventsManager.getInstance().log(new EventData(z2 ? IronSourceConstants.RV_API_HAS_AVAILABILITY_TRUE : IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData));
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isRewardedVideoAvailable():" + z2, 1);
                return z2;
            } catch (Throwable th2) {
                z = z2;
                th = th2;
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager2.log(ironSourceTag2, "isRewardedVideoAvailable():" + z, 1);
                this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable()", th);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            IronSourceLoggerManager ironSourceLoggerManager22 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag22 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager22.log(ironSourceTag22, "isRewardedVideoAvailable():" + z, 1);
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable()", th);
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoApi
    public void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        if (rewardedVideoListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener)", 1);
        }
        this.mListenersWrapper.setRewardedVideoListener(rewardedVideoListener);
        RVListenerWrapper.getInstance().setListener(rewardedVideoListener);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void setRewardedVideoServerParameters(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, this.TAG + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                    this.mRvServerParams = new HashMap(map);
                }
            } catch (Exception e) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.logException(ironSourceTag, this.TAG + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void clearRewardedVideoServerParameters() {
        this.mRvServerParams = null;
    }

    public synchronized void loadISDemandOnlyRewardedVideoWithAdm(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "adm cannot be null", 3);
            RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "adm cannot be null"));
            return;
        }
        loadISDemandOnlyRewardedVideo(activity, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        if (r5.mCurrentServerResponse == null) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011d, code lost:
        if (r5.mCurrentServerResponse.getConfigurations() == null) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0129, code lost:
        if (r5.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations() != null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012c, code lost:
        if (r8 != null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012e, code lost:
        r5.mDemandOnlyRvManager.loadRewardedVideoWithAdm(r7, null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0135, code lost:
        r5.mDemandOnlyRvManager.loadRewardedVideoWithAdm(r7, r8, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x013b, code lost:
        r5.mLoggerManager.log(com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API, "No rewarded video configurations found", 3);
        com.ironsource.mediationsdk.RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdLoadFailed(r7, com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", com.ironsource.mediationsdk.utils.IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0154, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadISDemandOnlyRewardedVideo(android.app.Activity r6, java.lang.String r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 377
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.loadISDemandOnlyRewardedVideo(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public synchronized void showDemandOnlyRewardedVideo(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showISDemandOnlyRewardedVideo() instanceId=" + str, 1);
        try {
            if (!this.mIsDemandOnlyRv) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead", 3);
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
            } else if (this.mDemandOnlyRvManager == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was not initiated", 3);
                RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Rewarded video was not initiated"));
            } else {
                this.mDemandOnlyRvManager.showRewardedVideo(str);
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showISDemandOnlyRewardedVideo", e);
            RVDemandOnlyListenerWrapper.getInstance().onRewardedVideoAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e.getMessage()));
        }
    }

    public synchronized boolean isDemandOnlyRewardedVideoAvailable(String str) {
        return this.mDemandOnlyRvManager != null && this.mDemandOnlyRvManager.isRewardedVideoAvailable(str);
    }

    /* access modifiers changed from: package-private */
    public void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        RVDemandOnlyListenerWrapper.getInstance().setListener(iSDemandOnlyRewardedVideoListener);
    }

    private boolean isRewardedVideoConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations() == null) ? false : true;
    }

    private Placement getPlacementToShowWithEvent(String str) {
        Placement rewardedVideoPlacement = getRewardedVideoPlacement(str);
        if (rewardedVideoPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            rewardedVideoPlacement = getDefaultRewardedVideoPlacement();
            if (rewardedVideoPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String cappingMessage = getCappingMessage(rewardedVideoPlacement.getPlacementName(), CappingManager.isPlacementCapped(ContextProvider.getInstance().getApplicationContext(), rewardedVideoPlacement));
        if (TextUtils.isEmpty(cappingMessage)) {
            return rewardedVideoPlacement;
        }
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, cappingMessage, 1);
        this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildCappedPerPlacementError(cappingMessage));
        return null;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialApi
    public void loadInterstitial() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", 1);
        try {
            if (this.mIsDemandOnlyIs) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
            } else if (!this.mDidInitInterstitial) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
            } else {
                MediationInitializer.EInitStatus currentInitStatus = MediationInitializer.getInstance().getCurrentInitStatus();
                if (currentInitStatus == MediationInitializer.EInitStatus.INIT_FAILED) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                } else if (currentInitStatus == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                    if (MediationInitializer.getInstance().isInProgressMoreThan15Secs()) {
                        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                        CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                        return;
                    }
                    this.mIsIsLoadBeforeInitCompleted = true;
                } else if (this.mCurrentServerResponse == null || this.mCurrentServerResponse.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "No interstitial configurations found", 3);
                    CallbackThrottler.getInstance().onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                } else if (!this.mIsIsProgrammatic) {
                    this.mInterstitialManager.loadInterstitial();
                } else if (this.mProgIsManager == null) {
                    this.mIsIsLoadBeforeInitCompleted = true;
                } else {
                    this.mProgIsManager.loadInterstitial();
                }
            }
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            CallbackThrottler.getInstance().onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, th.getMessage()));
        }
    }

    public void showInterstitial() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showInterstitial()", 1);
        try {
            if (this.mIsDemandOnlyIs) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                this.mListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"));
            } else if (!isInterstitialConfigurationsReady()) {
                this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            } else {
                InterstitialPlacement defaultInterstitialPlacement = getDefaultInterstitialPlacement();
                if (defaultInterstitialPlacement != null) {
                    showInterstitial(defaultInterstitialPlacement.getPlacementName());
                } else {
                    this.mListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(1020, "showInterstitial error: empty default placement in response"));
                }
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e);
            this.mListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialApi
    public void showInterstitial(String str) {
        String str2 = "showInterstitial(" + str + ")";
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.mIsDemandOnlyIs) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                this.mListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"));
            } else if (!isInterstitialConfigurationsReady()) {
                this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            } else if (this.mIsIsProgrammatic) {
                showProgrammaticInterstitial(str);
            } else {
                InterstitialPlacement interstitialPlacementToShowWithEvent = getInterstitialPlacementToShowWithEvent(str);
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                if (interstitialPlacementToShowWithEvent != null) {
                    try {
                        mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, interstitialPlacementToShowWithEvent.getPlacementName());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (!TextUtils.isEmpty(str)) {
                    mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
                }
                InterstitialEventsManager.getInstance().log(new EventData(2100, mediationAdditionalData));
                if (interstitialPlacementToShowWithEvent != null) {
                    this.mInterstitialManager.setCurrentPlacement(interstitialPlacementToShowWithEvent);
                    this.mInterstitialManager.showInterstitial(interstitialPlacementToShowWithEvent.getPlacementName());
                }
            }
        } catch (Exception e2) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.mListenersWrapper.onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e2.getMessage()));
        }
    }

    private InterstitialPlacement getInterstitialPlacement(String str) {
        InterstitialConfigurations interstitialConfigurations = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations();
        if (interstitialConfigurations != null) {
            return interstitialConfigurations.getInterstitialPlacement(str);
        }
        return null;
    }

    private InterstitialPlacement getDefaultInterstitialPlacement() {
        InterstitialConfigurations interstitialConfigurations = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations();
        if (interstitialConfigurations != null) {
            return interstitialConfigurations.getDefaultInterstitialPlacement();
        }
        return null;
    }

    private void showProgrammaticInterstitial(String str) {
        String str2 = null;
        try {
            InterstitialPlacement interstitialPlacement = getInterstitialPlacement(str);
            if (interstitialPlacement == null) {
                interstitialPlacement = getDefaultInterstitialPlacement();
            }
            if (interstitialPlacement != null) {
                str2 = interstitialPlacement.getPlacementName();
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e);
        }
        this.mProgIsManager.showInterstitial(str2);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialApi
    public boolean isInterstitialReady() {
        boolean z;
        Throwable th;
        try {
            if (this.mIsDemandOnlyIs) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            boolean z2 = !this.mIsIsProgrammatic ? !(this.mInterstitialManager == null || !this.mInterstitialManager.isInterstitialReady()) : !(this.mProgIsManager == null || !this.mProgIsManager.isInterstitialReady());
            try {
                InterstitialEventsManager.getInstance().log(new EventData(z2 ? IronSourceConstants.IS_CHECK_READY_TRUE : IronSourceConstants.IS_CHECK_READY_FALSE, IronSourceUtils.getMediationAdditionalData(false, this.mIsIsProgrammatic, 1)));
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isInterstitialReady():" + z2, 1);
                return z2;
            } catch (Throwable th2) {
                z = z2;
                th = th2;
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager2.log(ironSourceTag2, "isInterstitialReady():" + z, 1);
                this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            IronSourceLoggerManager ironSourceLoggerManager22 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag22 = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager22.log(ironSourceTag22, "isInterstitialReady():" + z, 1);
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isInterstitialReady()", th);
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialApi
    public void setInterstitialListener(InterstitialListener interstitialListener) {
        if (interstitialListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener)", 1);
        }
        this.mListenersWrapper.setInterstitialListener(interstitialListener);
        ISListenerWrapper.getInstance().setListener(interstitialListener);
        CallbackThrottler.getInstance().setInterstitialListener(interstitialListener);
    }

    public synchronized void loadISDemandOnlyInterstitialWithAdm(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "adm cannot be null", 3);
            ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "adm cannot be null"));
            return;
        }
        loadDemandOnlyInterstitial(activity, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        if (r6.mCurrentServerResponse == null) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0119, code lost:
        if (r6.mCurrentServerResponse.getConfigurations() == null) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0125, code lost:
        if (r6.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() != null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0128, code lost:
        if (r9 != null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012a, code lost:
        r6.mDemandOnlyIsManager.loadInterstitialWithAdm(r8, null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0131, code lost:
        r6.mDemandOnlyIsManager.loadInterstitialWithAdm(r8, r9, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0137, code lost:
        r6.mLoggerManager.log(com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API, "No interstitial configurations found", 3);
        com.ironsource.mediationsdk.ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdLoadFailed(r8, com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0150, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadDemandOnlyInterstitial(android.app.Activity r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.loadDemandOnlyInterstitial(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public void showDemandOnlyInterstitial(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showISDemandOnlyInterstitial() instanceId=" + str, 1);
        try {
            if (!this.mIsDemandOnlyIs) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
            } else if (this.mDemandOnlyIsManager == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial video was not initiated", 3);
                ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdShowFailed(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Interstitial video was not initiated"));
            } else {
                this.mDemandOnlyIsManager.showInterstitial(str);
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showISDemandOnlyInterstitial", e);
            ISDemandOnlyListenerWrapper.getInstance().onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
        }
    }

    public synchronized boolean isDemandOnlyInterstitialReady(String str) {
        return this.mDemandOnlyIsManager != null && this.mDemandOnlyIsManager.isInterstitialReady(str);
    }

    public void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        ISDemandOnlyListenerWrapper.getInstance().setListener(iSDemandOnlyInterstitialListener);
    }

    private boolean isInterstitialConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() == null) ? false : true;
    }

    private InterstitialPlacement getInterstitialPlacementToShowWithEvent(String str) {
        InterstitialPlacement interstitialPlacement = getInterstitialPlacement(str);
        if (interstitialPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            interstitialPlacement = getDefaultInterstitialPlacement();
            if (interstitialPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String cappingMessage = getCappingMessage(interstitialPlacement.getPlacementName(), getInterstitialCappingStatus(interstitialPlacement.getPlacementName()));
        if (TextUtils.isEmpty(cappingMessage)) {
            return interstitialPlacement;
        }
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, cappingMessage, 1);
        this.mListenersWrapper.setInterstitialPlacement(interstitialPlacement);
        this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildCappedPerPlacementError(cappingMessage));
        return null;
    }

    private boolean isOfferwallConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations() == null) ? false : true;
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void showOfferwall() {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showOfferwall()", 1);
            if (!isOfferwallConfigurationsReady()) {
                this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            OfferwallPlacement defaultOfferwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
            if (defaultOfferwallPlacement != null) {
                showOfferwall(defaultOfferwallPlacement.getPlacementName());
            }
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showOfferwall()", e);
            this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void showOfferwall(String str) {
        String str2 = "showOfferwall(" + str + ")";
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (!isOfferwallConfigurationsReady()) {
                this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            OfferwallPlacement offerwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getOfferwallPlacement(str);
            if (offerwallPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                offerwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
                if (offerwallPlacement == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.mOfferwallManager.showOfferwall(offerwallPlacement.getPlacementName());
        } catch (Exception e) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public boolean isOfferwallAvailable() {
        try {
            if (this.mOfferwallManager != null) {
                return this.mOfferwallManager.isOfferwallAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void getOfferwallCredits() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", 1);
        try {
            this.mOfferwallManager.getOfferwallCredits();
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", th);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.OfferwallApi
    public void setOfferwallListener(OfferwallListener offerwallListener) {
        if (offerwallListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setOfferwallListener(OWListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setOfferwallListener(OWListener)", 1);
        }
        this.mListenersWrapper.setOfferwallListener(offerwallListener);
    }

    @Override // com.ironsource.mediationsdk.logger.LoggingApi
    public void setLogListener(LogListener logListener) {
        if (logListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        this.mPublisherLogger.setLogListener(logListener);
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
    }

    private boolean isBannerConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getBannerConfigurations() == null) ? false : true;
    }

    public IronSourceBannerLayout createBanner(Activity activity, ISBannerSize iSBannerSize) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "createBanner()", 1);
        if (activity == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e7, code lost:
        r1 = r4.mCurrentServerResponse;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e9, code lost:
        if (r1 == null) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ef, code lost:
        if (r1.getConfigurations() == null) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fb, code lost:
        if (r4.mCurrentServerResponse.getConfigurations().getBannerConfigurations() != null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0100, code lost:
        if (r4.mIsBnProgrammatic != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0102, code lost:
        r4.mBannerManager.loadBanner(r5, getBannerPlacement(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010c, code lost:
        r4.mProgBannerManager.loadBanner(r5, getBannerPlacement(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0116, code lost:
        r4.mLoggerManager.log(com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
        com.ironsource.mediationsdk.BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(r5, new com.ironsource.mediationsdk.logger.IronSourceError(com.ironsource.mediationsdk.logger.IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "No banner configurations found"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadBanner(com.ironsource.mediationsdk.IronSourceBannerLayout r5, java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.loadBanner(com.ironsource.mediationsdk.IronSourceBannerLayout, java.lang.String):void");
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        loadBanner(ironSourceBannerLayout, "");
    }

    public void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (this.mIsBnProgrammatic && this.mProgBannerManager != null) {
                this.mProgBannerManager.destroyBanner(ironSourceBannerLayout);
            } else if (this.mBannerManager != null) {
                this.mBannerManager.destroyBanner(ironSourceBannerLayout);
            }
        } catch (Throwable th) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    /* access modifiers changed from: package-private */
    public ServerResponseWrapper getServerResponse(Context context, String str, IResponseListener iResponseListener) {
        synchronized (this.mServerResponseLocker) {
            if (this.mCurrentServerResponse != null) {
                return new ServerResponseWrapper(this.mCurrentServerResponse);
            }
            ServerResponseWrapper connectAndGetServerResponse = connectAndGetServerResponse(context, str, iResponseListener);
            if (connectAndGetServerResponse == null || !connectAndGetServerResponse.isValidResponse()) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Null or invalid response. Trying to get cached response", 0);
                connectAndGetServerResponse = getCachedResponse(context, str);
            }
            if (connectAndGetServerResponse != null) {
                this.mCurrentServerResponse = connectAndGetServerResponse;
                IronSourceUtils.saveLastResponse(context, connectAndGetServerResponse.toString());
                initializeSettingsFromServerResponse(this.mCurrentServerResponse, context);
            }
            InterstitialEventsManager.getInstance().setHasServerResponse(true);
            RewardedVideoEventsManager.getInstance().setHasServerResponse(true);
            return connectAndGetServerResponse;
        }
    }

    private ServerResponseWrapper getCachedResponse(Context context, String str) {
        if (IronSourceUtils.isInitResponseCached(context)) {
            String cachedValueByKeyOfCachedInitResponse = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "appKey");
            String cachedValueByKeyOfCachedInitResponse2 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "userId");
            String cachedValueByKeyOfCachedInitResponse3 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, ServerResponseWrapper.RESPONSE_FIELD);
            if (getIronSourceAppKey() != null && cachedValueByKeyOfCachedInitResponse.equals(getIronSourceAppKey()) && cachedValueByKeyOfCachedInitResponse2.equals(str)) {
                ServerResponseWrapper serverResponseWrapper = new ServerResponseWrapper(context, cachedValueByKeyOfCachedInitResponse, cachedValueByKeyOfCachedInitResponse2, cachedValueByKeyOfCachedInitResponse3);
                IronSourceError buildUsingCachedConfigurationError = ErrorBuilder.buildUsingCachedConfigurationError(cachedValueByKeyOfCachedInitResponse, cachedValueByKeyOfCachedInitResponse2);
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, buildUsingCachedConfigurationError.toString(), 1);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                ironSourceLoggerManager.log(ironSourceTag, buildUsingCachedConfigurationError.toString() + ": " + serverResponseWrapper.toString(), 1);
                RewardedVideoEventsManager.getInstance().log(new EventData(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
                return serverResponseWrapper;
            }
        }
        return null;
    }

    private ServerResponseWrapper connectAndGetServerResponse(Context context, String str, IResponseListener iResponseListener) {
        Exception e;
        ServerResponseWrapper serverResponseWrapper = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String advertiserId = getAdvertiserId(context);
            if (TextUtils.isEmpty(advertiserId)) {
                advertiserId = DeviceStatus.getOrGenerateOnceUniqueIdentifier(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String stringFromURL = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, getIronSourceAppKey(), str, advertiserId, getMediationType(), this.mIronSegment != null ? this.mIronSegment.getSegmentData() : null), iResponseListener);
            if (stringFromURL == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.getSerr() == 1) {
                IronLog.INTERNAL.verbose("encrypt");
                String optString = new JSONObject(stringFromURL).optString(ServerResponseWrapper.RESPONSE_FIELD, null);
                if (TextUtils.isEmpty(optString)) {
                    IronLog.INTERNAL.warning("encryptedResponse is empty - return null");
                    return null;
                }
                stringFromURL = IronSourceAES.decode(IronSourceUtils.KEY, optString);
                if (TextUtils.isEmpty(stringFromURL)) {
                    IronLog.INTERNAL.warning("encoded response invalid - return null");
                    sendEventForDecodingParsingError();
                    return null;
                }
            }
            ServerResponseWrapper serverResponseWrapper2 = new ServerResponseWrapper(context, getIronSourceAppKey(), str, stringFromURL);
            try {
                if (serverResponseWrapper2.isValidResponse()) {
                    return serverResponseWrapper2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e2) {
                e = e2;
                serverResponseWrapper = serverResponseWrapper2;
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.warning("exception = " + e);
                e.printStackTrace();
                return serverResponseWrapper;
            }
        } catch (Exception e3) {
            e = e3;
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.warning("exception = " + e);
            e.printStackTrace();
            return serverResponseWrapper;
        }
    }

    private void sendEventForDecodingParsingError() {
        if (!mDidSendEncryptionFailEventInSession) {
            mDidSendEncryptionFailEventInSession = true;
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            try {
                mediationAdditionalData.put("status", "false");
                mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RewardedVideoEventsManager.getInstance().log(new EventData(114, mediationAdditionalData));
        }
    }

    private void initializeSettingsFromServerResponse(ServerResponseWrapper serverResponseWrapper, Context context) {
        initializeLoggerManager(serverResponseWrapper);
        initializeEventsSettings(serverResponseWrapper, context);
    }

    private void initializeEventsSettings(ServerResponseWrapper serverResponseWrapper, Context context) {
        boolean isEventsEnabled = isRewardedVideoConfigurationsReady() ? serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().isEventsEnabled() : false;
        boolean isEventsEnabled2 = isInterstitialConfigurationsReady() ? serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().isEventsEnabled() : false;
        boolean isEventsEnabled3 = isBannerConfigurationsReady() ? serverResponseWrapper.getConfigurations().getBannerConfigurations().getBannerEventsConfigurations().isEventsEnabled() : false;
        boolean isEventsEnabled4 = isOfferwallConfigurationsReady() ? serverResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferWallEventsConfigurations().isEventsEnabled() : false;
        if (isEventsEnabled) {
            ApplicationEvents rewardedVideoEventsConfigurations = serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations();
            RewardedVideoEventsManager.getInstance().setFormatterType(rewardedVideoEventsConfigurations.getEventsType(), context);
            RewardedVideoEventsManager.getInstance().setEventsUrl(rewardedVideoEventsConfigurations.getEventsURL(), context);
            RewardedVideoEventsManager.getInstance().setMaxNumberOfEvents(rewardedVideoEventsConfigurations.getMaxNumberOfEvents());
            RewardedVideoEventsManager.getInstance().setMaxEventsPerBatch(rewardedVideoEventsConfigurations.getMaxEventsPerBatch());
            RewardedVideoEventsManager.getInstance().setBackupThreshold(rewardedVideoEventsConfigurations.getEventsBackupThreshold());
            RewardedVideoEventsManager.getInstance().setOptOutEvents(rewardedVideoEventsConfigurations.getOptOutEvents(), context);
            RewardedVideoEventsManager.getInstance().setOptInEvents(rewardedVideoEventsConfigurations.getOptInEvents(), context);
            RewardedVideoEventsManager.getInstance().setTriggerEvents(rewardedVideoEventsConfigurations.getTriggerEvents(), context);
            RewardedVideoEventsManager.getInstance().setNonConnectivityEvents(rewardedVideoEventsConfigurations.getNonConnectivityEvents(), context);
            RewardedVideoEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
        } else if (isEventsEnabled4) {
            ApplicationEvents offerWallEventsConfigurations = serverResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferWallEventsConfigurations();
            RewardedVideoEventsManager.getInstance().setFormatterType(offerWallEventsConfigurations.getEventsType(), context);
            RewardedVideoEventsManager.getInstance().setEventsUrl(offerWallEventsConfigurations.getEventsURL(), context);
            RewardedVideoEventsManager.getInstance().setMaxNumberOfEvents(offerWallEventsConfigurations.getMaxNumberOfEvents());
            RewardedVideoEventsManager.getInstance().setMaxEventsPerBatch(offerWallEventsConfigurations.getMaxEventsPerBatch());
            RewardedVideoEventsManager.getInstance().setBackupThreshold(offerWallEventsConfigurations.getEventsBackupThreshold());
            RewardedVideoEventsManager.getInstance().setOptOutEvents(offerWallEventsConfigurations.getOptOutEvents(), context);
            RewardedVideoEventsManager.getInstance().setOptInEvents(offerWallEventsConfigurations.getOptInEvents(), context);
            RewardedVideoEventsManager.getInstance().setTriggerEvents(offerWallEventsConfigurations.getTriggerEvents(), context);
            RewardedVideoEventsManager.getInstance().setNonConnectivityEvents(offerWallEventsConfigurations.getNonConnectivityEvents(), context);
            RewardedVideoEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
        } else {
            RewardedVideoEventsManager.getInstance().setIsEventsEnabled(false);
        }
        if (isEventsEnabled2) {
            ApplicationEvents interstitialEventsConfigurations = serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations();
            InterstitialEventsManager.getInstance().setFormatterType(interstitialEventsConfigurations.getEventsType(), context);
            InterstitialEventsManager.getInstance().setEventsUrl(interstitialEventsConfigurations.getEventsURL(), context);
            InterstitialEventsManager.getInstance().setMaxNumberOfEvents(interstitialEventsConfigurations.getMaxNumberOfEvents());
            InterstitialEventsManager.getInstance().setMaxEventsPerBatch(interstitialEventsConfigurations.getMaxEventsPerBatch());
            InterstitialEventsManager.getInstance().setBackupThreshold(interstitialEventsConfigurations.getEventsBackupThreshold());
            InterstitialEventsManager.getInstance().setOptOutEvents(interstitialEventsConfigurations.getOptOutEvents(), context);
            InterstitialEventsManager.getInstance().setOptInEvents(interstitialEventsConfigurations.getOptInEvents(), context);
            InterstitialEventsManager.getInstance().setTriggerEvents(interstitialEventsConfigurations.getTriggerEvents(), context);
            InterstitialEventsManager.getInstance().setNonConnectivityEvents(interstitialEventsConfigurations.getNonConnectivityEvents(), context);
            InterstitialEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
        } else if (isEventsEnabled3) {
            ApplicationEvents bannerEventsConfigurations = serverResponseWrapper.getConfigurations().getBannerConfigurations().getBannerEventsConfigurations();
            InterstitialEventsManager.getInstance().setFormatterType(bannerEventsConfigurations.getEventsType(), context);
            InterstitialEventsManager.getInstance().setEventsUrl(bannerEventsConfigurations.getEventsURL(), context);
            InterstitialEventsManager.getInstance().setMaxNumberOfEvents(bannerEventsConfigurations.getMaxNumberOfEvents());
            InterstitialEventsManager.getInstance().setMaxEventsPerBatch(bannerEventsConfigurations.getMaxEventsPerBatch());
            InterstitialEventsManager.getInstance().setBackupThreshold(bannerEventsConfigurations.getEventsBackupThreshold());
            InterstitialEventsManager.getInstance().setOptOutEvents(bannerEventsConfigurations.getOptOutEvents(), context);
            InterstitialEventsManager.getInstance().setOptInEvents(bannerEventsConfigurations.getOptInEvents(), context);
            InterstitialEventsManager.getInstance().setTriggerEvents(bannerEventsConfigurations.getTriggerEvents(), context);
            InterstitialEventsManager.getInstance().setNonConnectivityEvents(bannerEventsConfigurations.getNonConnectivityEvents(), context);
            InterstitialEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
        } else {
            InterstitialEventsManager.getInstance().setIsEventsEnabled(false);
        }
    }

    private void initializeLoggerManager(ServerResponseWrapper serverResponseWrapper) {
        this.mPublisherLogger.setDebugLevel(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getLoggerConfigurations().getPublisherLoggerLevel());
        this.mLoggerManager.setLoggerDebugLevel(ConsoleLogger.NAME, serverResponseWrapper.getConfigurations().getApplicationConfigurations().getLoggerConfigurations().getConsoleLoggerLevel());
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void removeRewardedVideoListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        this.mListenersWrapper.setRewardedVideoListener(null);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void removeInterstitialListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        this.mListenersWrapper.setInterstitialListener(null);
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void removeOfferwallListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeOfferwallListener()", 1);
        this.mListenersWrapper.setOfferwallListener(null);
    }

    /* access modifiers changed from: package-private */
    public void setIronSourceUserId(String str, boolean z) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("userId = " + str + ", isFromPublisher = " + z);
        this.mUserId = str;
        if (z) {
            RewardedVideoEventsManager.getInstance().log(new EventData(52, IronSourceUtils.getJsonForUserId(false)));
        }
    }

    public String getIronSourceAppKey() {
        return this.mAppKey;
    }

    public String getIronSourceUserId() {
        return this.mUserId;
    }

    private ConfigValidationResult validateAppKey(String str) {
        ConfigValidationResult configValidationResult = new ConfigValidationResult();
        if (str == null) {
            configValidationResult.setInvalid(new IronSourceError(IronSourceError.ERROR_CODE_INVALID_KEY_VALUE, "Init Fail - appKey is missing"));
        } else if (!validateLength(str, 5, 10)) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "length should be between 5-10 characters"));
        } else if (!validateAlphanumeric(str)) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("appKey", str, "should contain only english characters and numbers"));
        }
        return configValidationResult;
    }

    private void validateSegment(String str, ConfigValidationResult configValidationResult) {
        if (str != null) {
            try {
                if (str.length() > 64) {
                    configValidationResult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
                }
            } catch (Exception unused) {
                configValidationResult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
            }
        }
    }

    private void validateDynamicUserId(String str, ConfigValidationResult configValidationResult) {
        if (!validateLength(str, 1, 128)) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceConstants.SUPERSONIC_CONFIG_NAME, "dynamicUserId is invalid, should be between 1-128 chars in length."));
        }
    }

    private boolean validateLength(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }

    private boolean validateAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public InterstitialPlacement getInterstitialPlacementInfo(String str) {
        try {
            InterstitialPlacement interstitialPlacement = getInterstitialPlacement(str);
            if (interstitialPlacement == null) {
                try {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    interstitialPlacement = getDefaultInterstitialPlacement();
                } catch (Exception unused) {
                    return interstitialPlacement;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + interstitialPlacement, 1);
            return interstitialPlacement;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public Placement getRewardedVideoPlacementInfo(String str) {
        try {
            Placement rewardedVideoPlacement = getRewardedVideoPlacement(str);
            if (rewardedVideoPlacement == null) {
                try {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    rewardedVideoPlacement = getDefaultRewardedVideoPlacement();
                } catch (Exception unused) {
                    return rewardedVideoPlacement;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + rewardedVideoPlacement, 1);
            return rewardedVideoPlacement;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public String getAdvertiserId(Context context) {
        try {
            String[] advertisingIdInfo = DeviceStatus.getAdvertisingIdInfo(context);
            if (advertisingIdInfo.length > 0 && advertisingIdInfo[0] != null) {
                return advertisingIdInfo[0];
            }
        } catch (Exception unused) {
        }
        return "";
    }

    @Override // com.ironsource.mediationsdk.sdk.IronSourceInterface
    public void shouldTrackNetworkState(Context context, boolean z) {
        this.mTrackNetworkStateContext = context;
        this.mShouldTrackNetworkState = Boolean.valueOf(z);
        if (this.mIsIsProgrammatic) {
            ProgIsManager progIsManager = this.mProgIsManager;
            if (progIsManager != null) {
                progIsManager.shouldTrackNetworkState(context, z);
            }
        } else {
            InterstitialManager interstitialManager = this.mInterstitialManager;
            if (interstitialManager != null) {
                interstitialManager.shouldTrackNetworkState(context, z);
            }
        }
        if (this.mIsRvProgrammatic) {
            IProgRvManager iProgRvManager = this.mProgRvManager;
            if (iProgRvManager != null) {
                iProgRvManager.shouldTrackNetworkState(context, z);
                return;
            }
            return;
        }
        RewardedVideoManager rewardedVideoManager = this.mRewardedVideoManager;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.shouldTrackNetworkState(context, z);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isInterstitialPlacementCapped(String str) {
        boolean z = false;
        if (this.mIsDemandOnlyIs) {
            return false;
        }
        if (getInterstitialCappingStatus(str) != CappingManager.ECappingStatus.NOT_CAPPED) {
            z = true;
        }
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.mIsDemandOnlyIs, this.mIsIsProgrammatic, 1);
            try {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
                if (this.mIsIsProgrammatic) {
                    mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                }
            } catch (Exception unused) {
            }
            InterstitialEventsManager.getInstance().log(new EventData(IronSourceConstants.IS_CHECK_CAPPED_TRUE, mediationAdditionalData));
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isRewardedVideoPlacementCapped(String str) {
        int i;
        CappingManager.ECappingStatus rewardedVideoCappingStatus = getRewardedVideoCappingStatus(str);
        boolean z = true;
        if (rewardedVideoCappingStatus == null || !((i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus[rewardedVideoCappingStatus.ordinal()]) == 1 || i == 2 || i == 3)) {
            z = false;
        }
        sendIsCappedEvent(z, str);
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.ironsource.mediationsdk.IronSourceObject$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT;
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        static {
            /*
                com.ironsource.mediationsdk.utils.CappingManager$ECappingStatus[] r0 = com.ironsource.mediationsdk.utils.CappingManager.ECappingStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus = r0
                r1 = 1
                com.ironsource.mediationsdk.utils.CappingManager$ECappingStatus r2 = com.ironsource.mediationsdk.utils.CappingManager.ECappingStatus.CAPPED_PER_DELIVERY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.utils.CappingManager$ECappingStatus r3 = com.ironsource.mediationsdk.utils.CappingManager.ECappingStatus.CAPPED_PER_COUNT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.utils.CappingManager$ECappingStatus r4 = com.ironsource.mediationsdk.utils.CappingManager.ECappingStatus.CAPPED_PER_PACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.mediationsdk.utils.CappingManager$ECappingStatus r5 = com.ironsource.mediationsdk.utils.CappingManager.ECappingStatus.NOT_CAPPED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT = r4
                com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT     // Catch:{ NoSuchFieldError -> 0x004e }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isBannerPlacementCapped(String str) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getBannerConfigurations() == null) {
            return false;
        }
        BannerPlacement bannerPlacement = null;
        try {
            bannerPlacement = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerPlacement(str);
            if (bannerPlacement == null && (bannerPlacement = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getDefaultBannerPlacement()) == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bannerPlacement == null) {
            return false;
        }
        return CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getApplicationContext(), bannerPlacement.getPlacementName());
    }

    private CappingManager.ECappingStatus getInterstitialCappingStatus(String str) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        InterstitialPlacement interstitialPlacement = null;
        try {
            interstitialPlacement = getInterstitialPlacement(str);
            if (interstitialPlacement == null && (interstitialPlacement = getDefaultInterstitialPlacement()) == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (interstitialPlacement == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        return CappingManager.isPlacementCapped(ContextProvider.getInstance().getApplicationContext(), interstitialPlacement);
    }

    private CappingManager.ECappingStatus getRewardedVideoCappingStatus(String str) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null || serverResponseWrapper.getConfigurations() == null || this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations() == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        Placement placement = null;
        try {
            placement = getRewardedVideoPlacement(str);
            if (placement == null && (placement = getDefaultRewardedVideoPlacement()) == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (placement == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        return CappingManager.isPlacementCapped(ContextProvider.getInstance().getApplicationContext(), placement);
    }

    private void sentEventWithISEventManager(int i, JSONObject jSONObject) {
        InterstitialEventsManager.getInstance().log(new EventData(i, jSONObject));
    }

    private void sentEventWithRVEventManager(int i, JSONObject jSONObject) {
        RewardedVideoEventsManager.getInstance().log(new EventData(i, jSONObject));
    }

    private void sendIsCappedEvent(boolean z, String str) {
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.mIsDemandOnlyRv, this.mIsRvProgrammatic, this.rvProgrammaticMode);
            if (str != null) {
                addToDictionary(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PLACEMENT_NAME, str}});
            }
            sentEventWithRVEventManager(IronSourceConstants.RV_API_IS_CAPPED_TRUE, mediationAdditionalData);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isActivityExist() {
        return ContextProvider.getInstance().getCurrentActiveActivity() != null;
    }

    /* access modifiers changed from: package-private */
    public String getCappingMessage(String str, CappingManager.ECappingStatus eCappingStatus) {
        if (eCappingStatus == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus[eCappingStatus.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            return null;
        }
        return "placement " + str + " is capped";
    }

    /* access modifiers changed from: package-private */
    public ServerResponseWrapper getCurrentServerResponse() {
        return this.mCurrentServerResponse;
    }

    /* access modifiers changed from: package-private */
    public void setSegmentListener(SegmentListener segmentListener) {
        ListenersWrapper listenersWrapper = this.mListenersWrapper;
        if (listenersWrapper != null) {
            listenersWrapper.setSegmentListener(segmentListener);
            MediationInitializer.getInstance().setSegmentListener(this.mListenersWrapper);
        }
    }

    /* access modifiers changed from: package-private */
    public HashSet<String> getAllSettingsForProvider(String str, String str2) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null) {
            return new HashSet<>();
        }
        return serverResponseWrapper.getProviderSettingsHolder().getProviderSettingsByReflectionName(str, str2);
    }

    private BannerPlacement getBannerPlacement(String str) {
        BannerConfigurations bannerConfigurations = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations();
        if (bannerConfigurations == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return bannerConfigurations.getDefaultBannerPlacement();
        }
        BannerPlacement bannerPlacement = bannerConfigurations.getBannerPlacement(str);
        if (bannerPlacement != null) {
            return bannerPlacement;
        }
        return bannerConfigurations.getDefaultBannerPlacement();
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public void setConsent(boolean z) {
        this.mConsent = Boolean.valueOf(z);
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setConsent : " + z, 1);
        AdapterRepository.getInstance().setConsent(z);
        if (this.mOfferwallAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag2, "Offerwall | setConsent(consent:" + z + ")", 1);
            this.mOfferwallAdapter.setConsent(z);
        }
        int i = 40;
        if (!z) {
            i = 41;
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, IronSourceUtils.getMediationAdditionalData(false)));
    }

    /* access modifiers changed from: package-private */
    public Boolean getConsent() {
        return this.mConsent;
    }

    private void addToDictionary(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e), 3);
            }
        }
    }

    public void setMetaData(String str, List<String> list) {
        if (MediationInitializer.getInstance().getCurrentInitStatus() == MediationInitializer.EInitStatus.INITIATED) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setMetaData must be called prior to Init. Calling it after init will be ignored", 1);
            RewardedVideoEventsManager.getInstance().log(new EventData(51, IronSourceUtils.getJsonForMetaData(str, list, new ArrayList())));
            return;
        }
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String checkMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String checkMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (checkMetaDataKeyValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataKeyValidity);
        } else if (checkMetaDataValueValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataValueValidity);
        } else {
            MetaData formatMetaData = MetaDataUtils.formatMetaData(str, list);
            String metaDataKey = formatMetaData.getMetaDataKey();
            List<String> metaDataValue = formatMetaData.getMetaDataValue();
            if (MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
                IronsourceObjectPublisherDataHolder.getInstance().setMetaData(metaDataKey, metaDataValue);
            } else {
                AdapterRepository.getInstance().setMetaData(metaDataKey, metaDataValue);
            }
            RewardedVideoEventsManager.getInstance().log(new EventData(50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getISDemandOnlyBiddingData() {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.getISDemandOnlyBiddingData():java.lang.String");
    }

    @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataAPI
    public void addImpressionDataListener(ImpressionDataListener impressionDataListener) {
        if (IronSourcePreconditions.checkNotNull(impressionDataListener, "addImpressionDataListener - listener is null")) {
            IronsourceObjectPublisherDataHolder.getInstance().addImpressionDataListener(impressionDataListener);
            IProgRvManager iProgRvManager = this.mProgRvManager;
            if (iProgRvManager != null) {
                iProgRvManager.addImpressionDataListener(impressionDataListener);
            }
            ProgIsManager progIsManager = this.mProgIsManager;
            if (progIsManager != null) {
                progIsManager.addImpressionDataListener(impressionDataListener);
            }
            ProgBannerManager progBannerManager = this.mProgBannerManager;
            if (progBannerManager != null) {
                progBannerManager.addImpressionDataListener(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataAPI
    public void removeImpressionDataListener(ImpressionDataListener impressionDataListener) {
        if (IronSourcePreconditions.checkNotNull(impressionDataListener, "removeImpressionDataListener - listener is null")) {
            IronsourceObjectPublisherDataHolder.getInstance().removeImpressionDataListener(impressionDataListener);
            IProgRvManager iProgRvManager = this.mProgRvManager;
            if (iProgRvManager != null) {
                iProgRvManager.removeImpressionDataListener(impressionDataListener);
            }
            ProgIsManager progIsManager = this.mProgIsManager;
            if (progIsManager != null) {
                progIsManager.removeImpressionDataListener(impressionDataListener);
            }
            ProgBannerManager progBannerManager = this.mProgBannerManager;
            if (progBannerManager != null) {
                progBannerManager.removeImpressionDataListener(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("remove impression data listener from " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public void removeAllImpressionDataListeners() {
        IronLog.API.info("removing all impression data listeners");
        IronsourceObjectPublisherDataHolder.getInstance().removeAllImpressionDataListeners();
        IProgRvManager iProgRvManager = this.mProgRvManager;
        if (iProgRvManager != null) {
            iProgRvManager.removeAllImpressionDataListeners();
        }
        ProgIsManager progIsManager = this.mProgIsManager;
        if (progIsManager != null) {
            progIsManager.removeAllImpressionDataListeners();
        }
        ProgBannerManager progBannerManager = this.mProgBannerManager;
        if (progBannerManager != null) {
            progBannerManager.removeAllImpressionDataListeners();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isDemandOnlyInit() {
        return this.mIsDemandOnlyRv || this.mIsDemandOnlyIs;
    }
}
