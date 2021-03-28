package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.ConsoleLogger;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ApplicationConfigurations;
import com.ironsource.mediationsdk.model.ApplicationCrashReporterSettings;
import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.ApplicationLogger;
import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.Configurations;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.OfferwallConfigurations;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import com.ironsource.mediationsdk.model.ProviderOrder;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.precache.DownloadManager;
import com.onesignal.OSNotificationFormatHelper;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerResponseWrapper {
    public static final String APP_KEY_FIELD = "appKey";
    public static final String RESPONSE_FIELD = "response";
    public static final String USER_ID_FIELD = "userId";
    private final String AB_TESTING = "abt";
    private final String ADAPTER_TIMEOUT_IN_MILLIS_FIELD = "atim";
    private final String ADAPTER_TIMEOUT_IN_SECS_FIELD = "adapterTimeOutInSeconds";
    private final String ADVANCED_LOADING_FIELD = "advancedLoading";
    private final String AD_SOURCE_NAME_FIELD = "adSourceName";
    private final String AD_UNITS_FIELD = "adUnits";
    private final String APPLICATION_FIELD = Constants.ParametersKeys.ORIENTATION_APPLICATION;
    private final String AUCTION_DATA_FIELD = "auctionData";
    private final String AUCTION_DISABLE_LOAD_WHILE_SHOW_SUPPORT_FIELD = "disableLoadWhileShowSupportFor";
    private final String AUCTION_FIELD = "auction";
    private final String AUCTION_PROGRAMMATIC_FIELD = IronSourceConstants.EVENTS_PROGRAMMATIC;
    private final String AUCTION_RETRY_INTERVAL_FIELD = "auctionRetryInterval";
    private final String AUCTION_SAVED_HISTORY_LIMIT_FIELD = "auctionSavedHistory";
    private final String AUCTION_TIMEOUT_FIELD = "auctionTimeout";
    private final String AUCTION_TRIALS_FIELD = IronSourceConstants.AUCTION_TRIALS;
    private final String AUCTION_URL_FIELD = "auctioneerURL";
    private final String BACKFILL_FIELD = "backFill";
    private final String BACKUP_THRESHOLD_FIELD = "backupThreshold";
    private final String BN_FIELD = "banner";
    private final String COMPRESS_AUCTION_REQUEST = "compressAuctionRequest";
    private final String COMPRESS_AUCTION_RESPONSE = "compressAuctionResponse";
    private final String CONFIGURATIONS_FIELD = TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS;
    private final String CONSOLE_FIELD = ConsoleLogger.NAME;
    private final String CRASHREPORTER_ANR_TIMEOUT_FIELD = "timeout";
    private final String CRASHREPORTER_FIELD = "crashReporter";
    private final String CRASHREPORTER_INCLUDE_ANR_FIELD = "includeANR";
    private final String CRASHREPORTER_INCLUDE_KEYS_FIELD = "keysToInclude";
    private final String CRASHREPORTER_KEYWORD_FIELD = "reporterKeyword";
    private final String CRASHREPORTER_URL_FIELD = "reporterURL";
    private final int DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
    private final int DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
    private final boolean DEFAULT_ADVANCED_LOADING = false;
    private final int DEFAULT_ADVANCED_LOADING_AMOUNT = 0;
    private final int DEFAULT_ANR_TIME = DownloadManager.OPERATION_TIMEOUT;
    private final int DEFAULT_AUCTION_SAVED_HISTORY_LIMIT = 15;
    private final String DEFAULT_BANNER_LOAD_REFRESH_INTERVAL = "bannerInterval";
    private final int DEFAULT_BANNER_SMARTLOAD_TIMEOUT = 10000;
    private final int DEFAULT_BN_DELAY_LOAD_FAILURE_TIMEOUT = 3;
    private final int DEFAULT_EXPIRED_DURATION_IN_MINUTES_FIELD = -1;
    private final int DEFAULT_IS_DELAY_LOAD_FAILURE_TIMEOUT = 3;
    private final int DEFAULT_LOG_LEVEL = 3;
    private final int DEFAULT_MANUAL_LOAD_INTERVAL_FIELD = 300;
    private final int DEFAULT_MAX_EVENTS_PER_BATCH = DownloadManager.OPERATION_TIMEOUT;
    private final long DEFAULT_TIMEOUT = TapjoyConstants.TIMER_INCREMENT;
    private final int DEFAULT_TIME_TO_DELETE_WATERFALL_AFTER_AUCTION = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
    private final int DEFAULT_TRIALS = 2;
    private final String DELAY_LOAD_FAILURE = "delayLoadFailure";
    private final String ERROR_KEY = "error";
    private final String EVENTS_FIELD = "events";
    private final String EXPIRED_DURATION_IN_MINUTES_FIELD = "expiredDurationInMinutes";
    private final String GENERIC_PARAMS_FIELD = "genericParams";
    private final String INTEGRATION_FIELD = "integration";
    private final String IS_AUCTION_ON_SHOW_START_FIELD = "isAuctionOnShowStart";
    private final String IS_FIELD = IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    private final String IS_LOAD_WHILE_SHOW_FIELD = "isLoadWhileShow";
    private final String IS_MULTIPLE_INSTANCES_FIELD = "mpis";
    private final String LOGGERS_FIELD = "loggers";
    private final String MANUAL_LOAD_INTERVAL_FIELD = "loadRVInterval";
    private final String MAX_EVENTS_PER_BATCH = "maxEventsPerBatch";
    private final String MAX_NUM_OF_EVENTS_FIELD = "maxNumberOfEvents";
    private final String MIN_TIME_BEFORE_FIRST_AUCTION_FIELD = "minTimeBeforeFirstAuction";
    private final String NON_CONNECTIVITY_EVENTS_FIELD = "nonConnectivityEvents";
    private final String OPT_IN_EVENTS_FIELD = "optIn";
    private final String OPT_OUT_EVENTS_FIELD = "optOut";
    private final String OW_FIELD = "offerwall";
    private final String PLACEMENTS_FIELD = "placements";
    private final String PLACEMENT_ID_FIELD = "placementId";
    private final String PLACEMENT_NAME_FIELD = "placementName";
    private final String PLACEMENT_SETTINGS_CAPPING_FIELD = "capping";
    private final String PLACEMENT_SETTINGS_CAPPING_UNIT_FIELD = "unit";
    private final String PLACEMENT_SETTINGS_CAPPING_VALUE_FIELD = "maxImpressions";
    private final String PLACEMENT_SETTINGS_DELIVERY_FIELD = "delivery";
    private final String PLACEMENT_SETTINGS_ENABLED_FIELD = "enabled";
    private final String PLACEMENT_SETTINGS_IS_DEFAULT_FIELD = "isDefault";
    private final String PLACEMENT_SETTINGS_PACING_FIELD = "pacing";
    private final String PLACEMENT_SETTINGS_PACING_VALUE_FIELD = "numOfSeconds";
    private final String PREMIUM_FIELD = "premium";
    private final String PROVIDER_LOAD_NAME_FIELD = "providerLoadName";
    private final String PROVIDER_ORDER_FIELD = "providerOrder";
    private final String PROVIDER_SETTINGS_FIELD = "providerSettings";
    private final String PUBLISHER_FIELD = "publisher";
    private final String RV_FIELD = "rewardedVideo";
    private final String RV_TIME_TO_DELETE_WATERFALL_AFTER_AUCTION = "timeToDeleteOldWaterfallAfterAuction";
    private final String SDK_TOKEN_GENERIC_PARAMS_FIELD = "tokenGenericParams";
    private final String SDK_TOKEN_OPT_IN_KEYS_FIELD = "optInKeys";
    private final String SEGMENT_FIELD = "segment";
    private final String SEND_EVENTS_TOGGLE_FIELD = "sendEventsToggle";
    private final String SEND_ULTRA_EVENTS_FIELD = "sendUltraEvents";
    private final String SERVER_EVENTS_TYPE = "serverEventsType";
    private final String SERVER_EVENTS_URL_FIELD = "serverEventsURL";
    private final String SERVER_FIELD = "server";
    private final String SMART_LOAD_FIELD = "maxNumOfAdaptersToLoadOnStart";
    private final String SUB_PROVIDER_ID_FIELD = "spId";
    private final String TIME_TO_WAIT_BEFORE_AUCTION_FIELD = "timeToWaitBeforeAuction";
    private final String TIME_TO_WAIT_BEFORE_LOAD_FIELD = "timeToWaitBeforeLoad";
    private final String TOKEN_FIELD = IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY;
    private final String TRIGGER_EVENTS_FIELD = "triggerEvents";
    private final String UUID_ENABLED_FIELD = DeviceStatus.UUID_ENABLED;
    private final String VIRTUAL_ITEM_COUNT_FIELD = "virtualItemCount";
    private final String VIRTUAL_ITEM_NAME_FIELD = "virtualItemName";
    private String mAppKey;
    private Configurations mConfigurations;
    private Context mContext;
    private ProviderOrder mProviderOrder;
    private ProviderSettingsHolder mProviderSettingsHolder;
    private JSONObject mResponse;
    private String mUserId;

    public ServerResponseWrapper(Context context, String str, String str2, String str3) {
        this.mContext = context;
        try {
            if (TextUtils.isEmpty(str3)) {
                this.mResponse = new JSONObject();
            } else {
                this.mResponse = new JSONObject(str3);
            }
            parseProviderSettings();
            parseConfigurations();
            parseProviderOrder();
            this.mAppKey = TextUtils.isEmpty(str) ? "" : str;
            this.mUserId = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e) {
            e.printStackTrace();
            defaultInit();
        }
    }

    public ServerResponseWrapper(ServerResponseWrapper serverResponseWrapper) {
        try {
            this.mContext = serverResponseWrapper.getContext();
            this.mResponse = new JSONObject(serverResponseWrapper.mResponse.toString());
            this.mAppKey = serverResponseWrapper.mAppKey;
            this.mUserId = serverResponseWrapper.mUserId;
            this.mProviderOrder = serverResponseWrapper.getProviderOrder();
            this.mProviderSettingsHolder = serverResponseWrapper.getProviderSettingsHolder();
            this.mConfigurations = serverResponseWrapper.getConfigurations();
        } catch (Exception unused) {
            defaultInit();
        }
    }

    private void defaultInit() {
        this.mResponse = new JSONObject();
        this.mAppKey = "";
        this.mUserId = "";
        this.mProviderOrder = new ProviderOrder();
        this.mProviderSettingsHolder = ProviderSettingsHolder.getProviderSettingsHolder();
        this.mConfigurations = new Configurations();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.mAppKey);
            jSONObject.put("userId", this.mUserId);
            jSONObject.put(RESPONSE_FIELD, this.mResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public boolean isValidResponse() {
        if (!((((this.mResponse != null) && !this.mResponse.has("error")) && this.mProviderOrder != null) && this.mProviderSettingsHolder != null) || this.mConfigurations == null) {
            return false;
        }
        return true;
    }

    public List<IronSource.AD_UNIT> getInitiatedAdUnits() {
        ProviderOrder providerOrder;
        ProviderOrder providerOrder2;
        if (this.mResponse == null || this.mConfigurations == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!(this.mConfigurations.getRewardedVideoConfigurations() == null || (providerOrder2 = this.mProviderOrder) == null || providerOrder2.getRewardedVideoProviderOrder().size() <= 0)) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (!(this.mConfigurations.getInterstitialConfigurations() == null || (providerOrder = this.mProviderOrder) == null || providerOrder.getInterstitialProviderOrder().size() <= 0)) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.mConfigurations.getOfferwallConfigurations() != null) {
            arrayList.add(IronSource.AD_UNIT.OFFERWALL);
        }
        if (this.mConfigurations.getBannerConfigurations() != null) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        return arrayList;
    }

    private void parseProviderOrder() {
        try {
            JSONObject section = getSection(this.mResponse, "providerOrder");
            JSONArray optJSONArray = section.optJSONArray("rewardedVideo");
            JSONArray optJSONArray2 = section.optJSONArray(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            JSONArray optJSONArray3 = section.optJSONArray("banner");
            this.mProviderOrder = new ProviderOrder();
            if (!(optJSONArray == null || getConfigurations() == null || getConfigurations().getRewardedVideoConfigurations() == null)) {
                String backFillProviderName = getConfigurations().getRewardedVideoConfigurations().getBackFillProviderName();
                String premiumProviderName = getConfigurations().getRewardedVideoConfigurations().getPremiumProviderName();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString.equals(backFillProviderName)) {
                        this.mProviderOrder.setRVBackFillProvider(backFillProviderName);
                    } else {
                        if (optString.equals(premiumProviderName)) {
                            this.mProviderOrder.setRVPremiumProvider(premiumProviderName);
                        }
                        this.mProviderOrder.addRewardedVideoProvider(optString);
                        ProviderSettings providerSettings = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(optString);
                        if (providerSettings != null) {
                            providerSettings.setRewardedVideoPriority(i);
                        }
                    }
                }
            }
            if (!(optJSONArray2 == null || getConfigurations() == null || getConfigurations().getInterstitialConfigurations() == null)) {
                String backFillProviderName2 = getConfigurations().getInterstitialConfigurations().getBackFillProviderName();
                String premiumProviderName2 = getConfigurations().getInterstitialConfigurations().getPremiumProviderName();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (optString2.equals(backFillProviderName2)) {
                        this.mProviderOrder.setISBackFillProvider(backFillProviderName2);
                    } else {
                        if (optString2.equals(premiumProviderName2)) {
                            this.mProviderOrder.setISPremiumProvider(premiumProviderName2);
                        }
                        this.mProviderOrder.addInterstitialProvider(optString2);
                        ProviderSettings providerSettings2 = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(optString2);
                        if (providerSettings2 != null) {
                            providerSettings2.setInterstitialPriority(i2);
                        }
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    String optString3 = optJSONArray3.optString(i3);
                    this.mProviderOrder.addBannerProvider(optString3);
                    ProviderSettings providerSettings3 = ProviderSettingsHolder.getProviderSettingsHolder().getProviderSettings(optString3);
                    if (providerSettings3 != null) {
                        providerSettings3.setBannerPriority(i3);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseProviderSettings() {
        try {
            this.mProviderSettingsHolder = ProviderSettingsHolder.getProviderSettingsHolder();
            JSONObject section = getSection(this.mResponse, "providerSettings");
            Iterator<String> keys = section.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = section.optJSONObject(next);
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("mpis", false);
                    String optString = optJSONObject.optString("spId", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    String optString2 = optJSONObject.optString("adSourceName", null);
                    String optString3 = optJSONObject.optString("providerLoadName", next);
                    JSONObject section2 = getSection(optJSONObject, "adUnits");
                    JSONObject section3 = getSection(optJSONObject, Constants.ParametersKeys.ORIENTATION_APPLICATION);
                    JSONObject section4 = getSection(section2, "rewardedVideo");
                    JSONObject section5 = getSection(section2, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                    JSONObject section6 = getSection(section2, "banner");
                    JSONObject mergeJsons = IronSourceUtils.mergeJsons(section4, section3);
                    JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(section5, section3);
                    JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(section6, section3);
                    if (this.mProviderSettingsHolder.containsProviderSettings(next)) {
                        ProviderSettings providerSettings = this.mProviderSettingsHolder.getProviderSettings(next);
                        JSONObject rewardedVideoSettings = providerSettings.getRewardedVideoSettings();
                        JSONObject interstitialSettings = providerSettings.getInterstitialSettings();
                        JSONObject bannerSettings = providerSettings.getBannerSettings();
                        providerSettings.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, mergeJsons));
                        providerSettings.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, mergeJsons2));
                        providerSettings.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, mergeJsons3));
                        providerSettings.setIsMultipleInstances(optBoolean);
                        providerSettings.setSubProviderId(optString);
                        providerSettings.setAdSourceNameForEvents(optString2);
                    } else if (shouldMergeWithDebugSettings(optString3)) {
                        ProviderSettings providerSettings2 = this.mProviderSettingsHolder.getProviderSettings("Mediation");
                        JSONObject rewardedVideoSettings2 = providerSettings2.getRewardedVideoSettings();
                        JSONObject interstitialSettings2 = providerSettings2.getInterstitialSettings();
                        JSONObject bannerSettings2 = providerSettings2.getBannerSettings();
                        ProviderSettings providerSettings3 = new ProviderSettings(next, optString3, section3, IronSourceUtils.mergeJsons(new JSONObject(rewardedVideoSettings2.toString()), mergeJsons), IronSourceUtils.mergeJsons(new JSONObject(interstitialSettings2.toString()), mergeJsons2), IronSourceUtils.mergeJsons(new JSONObject(bannerSettings2.toString()), mergeJsons3));
                        providerSettings3.setIsMultipleInstances(optBoolean);
                        providerSettings3.setSubProviderId(optString);
                        providerSettings3.setAdSourceNameForEvents(optString2);
                        this.mProviderSettingsHolder.addProviderSettings(providerSettings3);
                    } else {
                        ProviderSettings providerSettings4 = new ProviderSettings(next, optString3, section3, mergeJsons, mergeJsons2, mergeJsons3);
                        providerSettings4.setIsMultipleInstances(optBoolean);
                        providerSettings4.setSubProviderId(optString);
                        providerSettings4.setAdSourceNameForEvents(optString2);
                        this.mProviderSettingsHolder.addProviderSettings(providerSettings4);
                    }
                }
            }
            this.mProviderSettingsHolder.fillSubProvidersDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean shouldMergeWithDebugSettings(String str) {
        String lowerCase = StringUtils.toLowerCase(str);
        return this.mProviderSettingsHolder.containsProviderSettings("Mediation") && (StringUtils.toLowerCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME).equals(lowerCase) || StringUtils.toLowerCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME).equals(lowerCase));
    }

    private void parseConfigurations() {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        RewardedVideoConfigurations rewardedVideoConfigurations;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        InterstitialConfigurations interstitialConfigurations;
        String str10;
        String str11;
        String str12;
        JSONObject jSONObject2;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        JSONObject jSONObject3;
        String str20;
        BannerConfigurations bannerConfigurations;
        String str21;
        String str22;
        JSONObject jSONObject4;
        String str23;
        String str24;
        String str25;
        String str26;
        OfferwallConfigurations offerwallConfigurations;
        String str27;
        JSONObject section;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        AuctionSettings auctionSettings;
        AuctionSettings auctionSettings2;
        boolean z;
        int i;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        AuctionSettings auctionSettings3;
        boolean z2;
        int i2;
        int[] iArr13;
        int[] iArr14;
        int[] iArr15;
        int[] iArr16;
        AuctionSettings auctionSettings4;
        try {
            JSONObject section2 = getSection(this.mResponse, TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS);
            JSONObject section3 = getSection(section2, "adUnits");
            JSONObject section4 = getSection(section2, Constants.ParametersKeys.ORIENTATION_APPLICATION);
            JSONObject section5 = getSection(section3, "rewardedVideo");
            JSONObject section6 = getSection(section3, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            JSONObject section7 = getSection(section3, "offerwall");
            JSONObject section8 = getSection(section3, "banner");
            JSONObject section9 = getSection(section4, "events");
            JSONObject section10 = getSection(section4, "loggers");
            JSONObject section11 = getSection(section4, IronSourceConstants.IRONSOURCE_BIDDING_TOKEN_KEY);
            JSONObject section12 = getSection(section4, "segment");
            JSONObject section13 = getSection(section4, "auction");
            JSONObject section14 = getSection(section4, "crashReporter");
            if (section4 != null) {
                IronSourceUtils.saveBooleanToSharedPrefs(this.mContext, DeviceStatus.UUID_ENABLED, section4.optBoolean(DeviceStatus.UUID_ENABLED, true));
            }
            if (section9 != null) {
                String optString = section9.optString("abt");
                if (!TextUtils.isEmpty(optString)) {
                    InterstitialEventsManager.getInstance().setABT(optString);
                    RewardedVideoEventsManager.getInstance().setABT(optString);
                }
            }
            String str28 = "nonConnectivityEvents";
            String str29 = "triggerEvents";
            String str30 = "optIn";
            if (section5 != null) {
                JSONArray optJSONArray = section5.optJSONArray("placements");
                str7 = "placements";
                JSONObject section15 = getSection(section5, "events");
                str6 = "events";
                int intConfigValue = getIntConfigValue(section5, section4, "maxNumOfAdaptersToLoadOnStart", 2);
                str4 = "maxNumOfAdaptersToLoadOnStart";
                int intConfigValue2 = getIntConfigValue(section5, section4, "advancedLoading", 0);
                if (intConfigValue2 > 0) {
                    i2 = intConfigValue2;
                    z2 = true;
                } else {
                    i2 = intConfigValue;
                    z2 = false;
                }
                int intConfigValue3 = getIntConfigValue(section5, section4, "adapterTimeOutInSeconds", 60);
                int intConfigValue4 = getIntConfigValue(section5, section4, "loadRVInterval", 300);
                int intConfigValue5 = getIntConfigValue(section5, section4, "expiredDurationInMinutes", -1);
                JSONObject mergeJsons = IronSourceUtils.mergeJsons(section15, section9);
                boolean optBoolean = mergeJsons.optBoolean("sendUltraEvents", false);
                boolean optBoolean2 = mergeJsons.optBoolean("sendEventsToggle", false);
                String optString2 = mergeJsons.optString("serverEventsURL", "");
                String optString3 = mergeJsons.optString("serverEventsType", "");
                int optInt = mergeJsons.optInt("backupThreshold", -1);
                int optInt2 = mergeJsons.optInt("maxNumberOfEvents", -1);
                int optInt3 = mergeJsons.optInt("maxEventsPerBatch", DownloadManager.OPERATION_TIMEOUT);
                JSONArray optJSONArray2 = mergeJsons.optJSONArray("optOut");
                if (optJSONArray2 != null) {
                    int[] iArr17 = new int[optJSONArray2.length()];
                    str = "maxEventsPerBatch";
                    str5 = "optOut";
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        iArr17[i3] = optJSONArray2.optInt(i3);
                    }
                    iArr13 = iArr17;
                } else {
                    str = "maxEventsPerBatch";
                    str5 = "optOut";
                    iArr13 = null;
                }
                JSONArray optJSONArray3 = mergeJsons.optJSONArray(str30);
                if (optJSONArray3 != null) {
                    int[] iArr18 = new int[optJSONArray3.length()];
                    str30 = str30;
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        iArr18[i4] = optJSONArray3.optInt(i4);
                    }
                    iArr14 = iArr18;
                } else {
                    str30 = str30;
                    iArr14 = null;
                }
                JSONArray optJSONArray4 = mergeJsons.optJSONArray(str29);
                if (optJSONArray4 != null) {
                    int[] iArr19 = new int[optJSONArray4.length()];
                    str29 = str29;
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        iArr19[i5] = optJSONArray4.optInt(i5);
                    }
                    iArr15 = iArr19;
                } else {
                    str29 = str29;
                    iArr15 = null;
                }
                JSONArray optJSONArray5 = mergeJsons.optJSONArray(str28);
                if (optJSONArray5 != null) {
                    int[] iArr20 = new int[optJSONArray5.length()];
                    for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                        iArr20[i6] = optJSONArray5.optInt(i6);
                    }
                    iArr16 = iArr20;
                } else {
                    iArr16 = null;
                }
                ApplicationEvents applicationEvents = new ApplicationEvents(optBoolean, optBoolean2, optString2, optString3, optInt, optInt2, optInt3, iArr13, iArr14, iArr15, iArr16);
                if (section13 != null) {
                    JSONObject section16 = getSection(section13, "rewardedVideo");
                    str28 = str28;
                    str8 = "maxNumberOfEvents";
                    jSONObject = section13;
                    str3 = "backupThreshold";
                    str2 = "serverEventsType";
                    str9 = "serverEventsURL";
                    AuctionSettings auctionSettings5 = new AuctionSettings(section13.optString("auctionData", ""), section13.optString("auctioneerURL", ""), section13.optInt(IronSourceConstants.AUCTION_TRIALS, 2), section13.optInt("auctionSavedHistory", 15), section13.optLong("auctionTimeout", TapjoyConstants.TIMER_INCREMENT), section16.optBoolean(IronSourceConstants.EVENTS_PROGRAMMATIC, false), (long) section16.optInt("minTimeBeforeFirstAuction", 2000), (long) section16.optInt("auctionRetryInterval", HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT), (long) section16.optInt("timeToWaitBeforeAuction", DownloadManager.OPERATION_TIMEOUT), (long) section16.optInt("timeToWaitBeforeLoad", 50), section16.optBoolean("isAuctionOnShowStart", false), section16.optBoolean("isLoadWhileShow", false), section16.optInt("timeToDeleteOldWaterfallAfterAuction", HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT), section13.optBoolean("compressAuctionRequest", false), section13.optBoolean("compressAuctionResponse", false));
                    JSONArray optJSONArray6 = section16.optJSONArray("disableLoadWhileShowSupportFor");
                    if (optJSONArray6 != null) {
                        for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                            auctionSettings5.addLoadWhileShowSupportProvider(optJSONArray6.optString(i7));
                        }
                    }
                    auctionSettings4 = auctionSettings5;
                } else {
                    str9 = "serverEventsURL";
                    str28 = str28;
                    str3 = "backupThreshold";
                    str2 = "serverEventsType";
                    jSONObject = section13;
                    str8 = "maxNumberOfEvents";
                    auctionSettings4 = new AuctionSettings();
                }
                RewardedVideoConfigurations rewardedVideoConfigurations2 = new RewardedVideoConfigurations(i2, z2, intConfigValue3, intConfigValue4, intConfigValue5, applicationEvents, auctionSettings4);
                if (optJSONArray != null) {
                    for (int i8 = 0; i8 < optJSONArray.length(); i8++) {
                        Placement parseSingleRVPlacement = parseSingleRVPlacement(optJSONArray.optJSONObject(i8));
                        if (parseSingleRVPlacement != null) {
                            rewardedVideoConfigurations2.addRewardedVideoPlacement(parseSingleRVPlacement);
                        }
                    }
                }
                String optString4 = section5.optString("backFill");
                if (!TextUtils.isEmpty(optString4)) {
                    rewardedVideoConfigurations2.setBackFillProviderName(optString4);
                }
                String optString5 = section5.optString("premium");
                if (!TextUtils.isEmpty(optString5)) {
                    rewardedVideoConfigurations2.setPremiumProviderName(optString5);
                }
                rewardedVideoConfigurations = rewardedVideoConfigurations2;
            } else {
                str6 = "events";
                str4 = "maxNumOfAdaptersToLoadOnStart";
                str7 = "placements";
                str3 = "backupThreshold";
                str2 = "serverEventsType";
                str = "maxEventsPerBatch";
                str5 = "optOut";
                jSONObject = section13;
                str9 = "serverEventsURL";
                str8 = "maxNumberOfEvents";
                rewardedVideoConfigurations = null;
            }
            if (section6 != null) {
                str16 = str7;
                JSONArray optJSONArray7 = section6.optJSONArray(str16);
                str14 = str6;
                JSONObject section17 = getSection(section6, str14);
                str15 = str4;
                int intConfigValue6 = getIntConfigValue(section6, section4, str15, 2);
                int intConfigValue7 = getIntConfigValue(section6, section4, "advancedLoading", 0);
                if (intConfigValue7 > 0) {
                    i = intConfigValue7;
                    z = true;
                } else {
                    i = intConfigValue6;
                    z = false;
                }
                int intConfigValue8 = getIntConfigValue(section6, section4, "adapterTimeOutInSeconds", 60);
                int intConfigValue9 = getIntConfigValue(section6, section4, "delayLoadFailure", 3);
                JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(section17, section9);
                boolean optBoolean3 = mergeJsons2.optBoolean("sendEventsToggle", false);
                String optString6 = mergeJsons2.optString(str9, "");
                str13 = str2;
                String optString7 = mergeJsons2.optString(str13, "");
                int optInt4 = mergeJsons2.optInt(str3, -1);
                int optInt5 = mergeJsons2.optInt(str8, -1);
                str12 = str9;
                int optInt6 = mergeJsons2.optInt(str, DownloadManager.OPERATION_TIMEOUT);
                str = str;
                JSONArray optJSONArray8 = mergeJsons2.optJSONArray(str5);
                if (optJSONArray8 != null) {
                    str5 = str5;
                    int[] iArr21 = new int[optJSONArray8.length()];
                    str10 = str8;
                    str3 = str3;
                    for (int i9 = 0; i9 < optJSONArray8.length(); i9++) {
                        iArr21[i9] = optJSONArray8.optInt(i9);
                    }
                    iArr9 = iArr21;
                } else {
                    str10 = str8;
                    str5 = str5;
                    str3 = str3;
                    iArr9 = null;
                }
                JSONArray optJSONArray9 = mergeJsons2.optJSONArray(str30);
                if (optJSONArray9 != null) {
                    int[] iArr22 = new int[optJSONArray9.length()];
                    str30 = str30;
                    for (int i10 = 0; i10 < optJSONArray9.length(); i10++) {
                        iArr22[i10] = optJSONArray9.optInt(i10);
                    }
                    iArr10 = iArr22;
                } else {
                    str30 = str30;
                    iArr10 = null;
                }
                JSONArray optJSONArray10 = mergeJsons2.optJSONArray(str29);
                if (optJSONArray10 != null) {
                    int[] iArr23 = new int[optJSONArray10.length()];
                    str29 = str29;
                    for (int i11 = 0; i11 < optJSONArray10.length(); i11++) {
                        iArr23[i11] = optJSONArray10.optInt(i11);
                    }
                    iArr11 = iArr23;
                } else {
                    str29 = str29;
                    iArr11 = null;
                }
                str17 = str28;
                JSONArray optJSONArray11 = mergeJsons2.optJSONArray(str17);
                if (optJSONArray11 != null) {
                    int[] iArr24 = new int[optJSONArray11.length()];
                    for (int i12 = 0; i12 < optJSONArray11.length(); i12++) {
                        iArr24[i12] = optJSONArray11.optInt(i12);
                    }
                    iArr12 = iArr24;
                } else {
                    iArr12 = null;
                }
                ApplicationEvents applicationEvents2 = new ApplicationEvents(false, optBoolean3, optString6, optString7, optInt4, optInt5, optInt6, iArr9, iArr10, iArr11, iArr12);
                if (jSONObject != null) {
                    jSONObject2 = jSONObject;
                    JSONObject section18 = getSection(jSONObject2, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                    str11 = "sendEventsToggle";
                    auctionSettings3 = new AuctionSettings(jSONObject2.optString("auctionData", ""), jSONObject2.optString("auctioneerURL", ""), jSONObject2.optInt(IronSourceConstants.AUCTION_TRIALS, 2), jSONObject2.optInt("auctionSavedHistory", 15), jSONObject2.optLong("auctionTimeout", TapjoyConstants.TIMER_INCREMENT), section18.optBoolean(IronSourceConstants.EVENTS_PROGRAMMATIC, false), (long) section18.optInt("minTimeBeforeFirstAuction", 2000), 0, 0, 0, true, true, 0, jSONObject2.optBoolean("compressAuctionRequest", false), jSONObject2.optBoolean("compressAuctionResponse", false));
                } else {
                    str11 = "sendEventsToggle";
                    jSONObject2 = jSONObject;
                    auctionSettings3 = new AuctionSettings();
                }
                InterstitialConfigurations interstitialConfigurations2 = new InterstitialConfigurations(i, z, intConfigValue8, applicationEvents2, auctionSettings3, intConfigValue9);
                if (optJSONArray7 != null) {
                    for (int i13 = 0; i13 < optJSONArray7.length(); i13++) {
                        InterstitialPlacement parseSingleISPlacement = parseSingleISPlacement(optJSONArray7.optJSONObject(i13));
                        if (parseSingleISPlacement != null) {
                            interstitialConfigurations2.addInterstitialPlacement(parseSingleISPlacement);
                        }
                    }
                }
                String optString8 = section6.optString("backFill");
                if (!TextUtils.isEmpty(optString8)) {
                    interstitialConfigurations2.setBackFillProviderName(optString8);
                }
                String optString9 = section6.optString("premium");
                if (!TextUtils.isEmpty(optString9)) {
                    interstitialConfigurations2.setPremiumProviderName(optString9);
                }
                interstitialConfigurations = interstitialConfigurations2;
            } else {
                str17 = str28;
                str16 = str7;
                str14 = str6;
                str15 = str4;
                str13 = str2;
                str11 = "sendEventsToggle";
                str10 = str8;
                str12 = str9;
                jSONObject2 = jSONObject;
                interstitialConfigurations = null;
            }
            if (section8 != null) {
                JSONArray optJSONArray12 = section8.optJSONArray(str16);
                JSONObject section19 = getSection(section8, str14);
                int intConfigValue10 = getIntConfigValue(section8, section4, str15, 1);
                str20 = str16;
                str21 = str14;
                jSONObject3 = section14;
                long longConfigValue = getLongConfigValue(section8, section4, "atim", TapjoyConstants.TIMER_INCREMENT);
                int intConfigValue11 = getIntConfigValue(section8, section4, "delayLoadFailure", 3);
                int intConfigValue12 = getIntConfigValue(section8, section4, "bannerInterval", 60);
                JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(section19, section9);
                str26 = str11;
                boolean optBoolean4 = mergeJsons3.optBoolean(str26, false);
                str25 = str12;
                str24 = "";
                String optString10 = mergeJsons3.optString(str25, str24);
                String optString11 = mergeJsons3.optString(str13, str24);
                str23 = str3;
                int optInt7 = mergeJsons3.optInt(str23, -1);
                int optInt8 = mergeJsons3.optInt(str10, -1);
                int optInt9 = mergeJsons3.optInt(str, DownloadManager.OPERATION_TIMEOUT);
                JSONArray optJSONArray13 = mergeJsons3.optJSONArray(str5);
                if (optJSONArray13 != null) {
                    jSONObject4 = section4;
                    int[] iArr25 = new int[optJSONArray13.length()];
                    str = str;
                    str5 = str5;
                    for (int i14 = 0; i14 < optJSONArray13.length(); i14++) {
                        iArr25[i14] = optJSONArray13.optInt(i14);
                    }
                    iArr5 = iArr25;
                } else {
                    jSONObject4 = section4;
                    str = str;
                    str5 = str5;
                    iArr5 = null;
                }
                JSONArray optJSONArray14 = mergeJsons3.optJSONArray(str30);
                if (optJSONArray14 != null) {
                    int[] iArr26 = new int[optJSONArray14.length()];
                    str18 = str30;
                    for (int i15 = 0; i15 < optJSONArray14.length(); i15++) {
                        iArr26[i15] = optJSONArray14.optInt(i15);
                    }
                    iArr6 = iArr26;
                } else {
                    str18 = str30;
                    iArr6 = null;
                }
                JSONArray optJSONArray15 = mergeJsons3.optJSONArray(str29);
                if (optJSONArray15 != null) {
                    int[] iArr27 = new int[optJSONArray15.length()];
                    str19 = str29;
                    for (int i16 = 0; i16 < optJSONArray15.length(); i16++) {
                        iArr27[i16] = optJSONArray15.optInt(i16);
                    }
                    iArr7 = iArr27;
                } else {
                    str19 = str29;
                    iArr7 = null;
                }
                JSONArray optJSONArray16 = mergeJsons3.optJSONArray(str17);
                if (optJSONArray16 != null) {
                    int[] iArr28 = new int[optJSONArray16.length()];
                    for (int i17 = 0; i17 < optJSONArray16.length(); i17++) {
                        iArr28[i17] = optJSONArray16.optInt(i17);
                    }
                    iArr8 = iArr28;
                } else {
                    iArr8 = null;
                }
                ApplicationEvents applicationEvents3 = new ApplicationEvents(false, optBoolean4, optString10, optString11, optInt7, optInt8, optInt9, iArr5, iArr6, iArr7, iArr8);
                if (jSONObject2 != null) {
                    JSONObject section20 = getSection(jSONObject2, "banner");
                    if (section20 != null) {
                        str22 = str10;
                        auctionSettings2 = new AuctionSettings(jSONObject2.optString("auctionData", str24), jSONObject2.optString("auctioneerURL", str24), jSONObject2.optInt(IronSourceConstants.AUCTION_TRIALS, 2), jSONObject2.optInt("auctionSavedHistory", 15), jSONObject2.optLong("auctionTimeout", TapjoyConstants.TIMER_INCREMENT), section20.optBoolean(IronSourceConstants.EVENTS_PROGRAMMATIC, false), (long) section20.optInt("minTimeBeforeFirstAuction", 2000), 0, 0, 0, true, true, 0, jSONObject2.optBoolean("compressAuctionRequest", false), jSONObject2.optBoolean("compressAuctionResponse", false));
                    } else {
                        str22 = str10;
                        auctionSettings2 = new AuctionSettings();
                    }
                    auctionSettings = auctionSettings2;
                } else {
                    str22 = str10;
                    auctionSettings = new AuctionSettings();
                }
                BannerConfigurations bannerConfigurations2 = new BannerConfigurations(intConfigValue10, longConfigValue, applicationEvents3, intConfigValue12, auctionSettings, intConfigValue11);
                if (optJSONArray12 != null) {
                    for (int i18 = 0; i18 < optJSONArray12.length(); i18++) {
                        BannerPlacement parseSingleBNPlacement = parseSingleBNPlacement(optJSONArray12.optJSONObject(i18));
                        if (parseSingleBNPlacement != null) {
                            bannerConfigurations2.addBannerPlacement(parseSingleBNPlacement);
                        }
                    }
                }
                bannerConfigurations = bannerConfigurations2;
            } else {
                str20 = str16;
                str24 = "";
                jSONObject4 = section4;
                str21 = str14;
                jSONObject3 = section14;
                str25 = str12;
                str26 = str11;
                str19 = str29;
                str18 = str30;
                str22 = str10;
                str23 = str3;
                bannerConfigurations = null;
            }
            if (section7 != null) {
                str27 = str21;
                JSONObject mergeJsons4 = IronSourceUtils.mergeJsons(getSection(section7, str27), section9);
                boolean optBoolean5 = mergeJsons4.optBoolean(str26, false);
                String optString12 = mergeJsons4.optString(str25, str24);
                String optString13 = mergeJsons4.optString(str13, str24);
                int optInt10 = mergeJsons4.optInt(str23, -1);
                int optInt11 = mergeJsons4.optInt(str22, -1);
                int optInt12 = mergeJsons4.optInt(str, DownloadManager.OPERATION_TIMEOUT);
                JSONArray optJSONArray17 = mergeJsons4.optJSONArray(str5);
                if (optJSONArray17 != null) {
                    int[] iArr29 = new int[optJSONArray17.length()];
                    for (int i19 = 0; i19 < optJSONArray17.length(); i19++) {
                        iArr29[i19] = optJSONArray17.optInt(i19);
                    }
                    iArr = iArr29;
                } else {
                    iArr = null;
                }
                JSONArray optJSONArray18 = mergeJsons4.optJSONArray(str18);
                if (optJSONArray18 != null) {
                    int[] iArr30 = new int[optJSONArray18.length()];
                    for (int i20 = 0; i20 < optJSONArray18.length(); i20++) {
                        iArr30[i20] = optJSONArray18.optInt(i20);
                    }
                    iArr2 = iArr30;
                } else {
                    iArr2 = null;
                }
                JSONArray optJSONArray19 = mergeJsons4.optJSONArray(str19);
                if (optJSONArray19 != null) {
                    int[] iArr31 = new int[optJSONArray19.length()];
                    for (int i21 = 0; i21 < optJSONArray19.length(); i21++) {
                        iArr31[i21] = optJSONArray19.optInt(i21);
                    }
                    iArr3 = iArr31;
                } else {
                    iArr3 = null;
                }
                JSONArray optJSONArray20 = mergeJsons4.optJSONArray(str17);
                if (optJSONArray20 != null) {
                    int[] iArr32 = new int[optJSONArray20.length()];
                    for (int i22 = 0; i22 < optJSONArray20.length(); i22++) {
                        iArr32[i22] = optJSONArray20.optInt(i22);
                    }
                    iArr4 = iArr32;
                } else {
                    iArr4 = null;
                }
                OfferwallConfigurations offerwallConfigurations2 = new OfferwallConfigurations(new ApplicationEvents(false, optBoolean5, optString12, optString13, optInt10, optInt11, optInt12, iArr, iArr2, iArr3, iArr4));
                offerwallConfigurations2.setOfferWallSection(section7);
                JSONArray optJSONArray21 = section7.optJSONArray(str20);
                if (optJSONArray21 != null) {
                    for (int i23 = 0; i23 < optJSONArray21.length(); i23++) {
                        OfferwallPlacement parseSingleOWPlacement = parseSingleOWPlacement(optJSONArray21.optJSONObject(i23));
                        if (parseSingleOWPlacement != null) {
                            offerwallConfigurations2.addOfferwallPlacement(parseSingleOWPlacement);
                        }
                    }
                }
                offerwallConfigurations = offerwallConfigurations2;
            } else {
                str27 = str21;
                offerwallConfigurations = null;
            }
            TokenSettings tokenSettings = new TokenSettings();
            if (section11 != null) {
                JSONArray optJSONArray22 = section11.optJSONArray("optInKeys");
                if (optJSONArray22 != null) {
                    for (int i24 = 0; i24 < optJSONArray22.length(); i24++) {
                        tokenSettings.addOptInKeyParam(optJSONArray22.optString(i24));
                    }
                }
                JSONObject optJSONObject = section11.optJSONObject("tokenGenericParams");
                if (optJSONObject != null) {
                    tokenSettings.setGenericParams(optJSONObject);
                }
            }
            ApplicationLogger applicationLogger = new ApplicationLogger(section10.optInt("server", 3), section10.optInt("publisher", 3), section10.optInt(ConsoleLogger.NAME, 3));
            ApplicationCrashReporterSettings applicationCrashReporterSettings = new ApplicationCrashReporterSettings();
            if (jSONObject3 != null) {
                applicationCrashReporterSettings.setKeyParamsToIncludeInReporter(jSONObject3.optBoolean("enabled", false));
                applicationCrashReporterSettings.setReporterURL(jSONObject3.optString("reporterURL", str24));
                applicationCrashReporterSettings.setReporterKeyword(jSONObject3.optString("reporterKeyword", str24));
                applicationCrashReporterSettings.shouldIncludeANR(jSONObject3.optBoolean("includeANR", false));
                applicationCrashReporterSettings.setDefaultAnrTimeout(jSONObject3.optInt("timeout", DownloadManager.OPERATION_TIMEOUT));
                JSONArray optJSONArray23 = jSONObject3.optJSONArray("keysToInclude");
                if (optJSONArray23 != null) {
                    for (int i25 = 0; i25 < optJSONArray23.length(); i25++) {
                        applicationCrashReporterSettings.addKeyParamToInclude(optJSONArray23.optString(i25));
                    }
                }
            }
            this.mConfigurations = new Configurations(rewardedVideoConfigurations, interstitialConfigurations, offerwallConfigurations, bannerConfigurations, new ApplicationConfigurations(applicationLogger, section12 != null ? new ServerSegmetData(section12.optString("name", str24), section12.optString("id", "-1"), section12.optJSONObject(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)) : null, tokenSettings, jSONObject4.optBoolean("integration", false), applicationCrashReporterSettings));
            JSONObject section21 = getSection(section9, "genericParams");
            if (!(section21 == null || (section = getSection(section21, str27)) == null)) {
                section21.remove(str27);
                Map<String, String> parseJsonToStringMap = IronSourceUtils.parseJsonToStringMap(section);
                RewardedVideoEventsManager.getInstance().setEventGenericParams(parseJsonToStringMap);
                InterstitialEventsManager.getInstance().setEventGenericParams(parseJsonToStringMap);
            }
            if (section21 != null) {
                Map<String, String> parseJsonToStringMap2 = IronSourceUtils.parseJsonToStringMap(section21);
                RewardedVideoEventsManager.getInstance().setBatchParams(parseJsonToStringMap2);
                InterstitialEventsManager.getInstance().setBatchParams(parseJsonToStringMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean getBooleanConfigValue(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return jSONObject2.has(str) ? jSONObject2.optBoolean(str, z) : z;
    }

    private int getIntConfigValue(JSONObject jSONObject, JSONObject jSONObject2, String str, int i) {
        int i2 = 0;
        if (jSONObject.has(str)) {
            i2 = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            i2 = jSONObject2.optInt(str, 0);
        }
        return i2 == 0 ? i : i2;
    }

    private long getLongConfigValue(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        long j2;
        if (jSONObject.has(str)) {
            j2 = jSONObject.optLong(str, 0);
        } else {
            j2 = jSONObject2.has(str) ? jSONObject2.optLong(str, 0) : 0;
        }
        return j2 == 0 ? j : j2;
    }

    private Placement parseSingleRVPlacement(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            String optString2 = jSONObject.optString("virtualItemName", "");
            int optInt2 = jSONObject.optInt("virtualItemCount", -1);
            PlacementAvailabilitySettings placementAvailabilitySettings = getPlacementAvailabilitySettings(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optInt2 > 0) {
                Placement placement = new Placement(optInt, optString, optBoolean, optString2, optInt2, placementAvailabilitySettings);
                if (placementAvailabilitySettings == null) {
                    return placement;
                }
                CappingManager.addCappingInfo(this.mContext, placement);
                return placement;
            }
        }
        return null;
    }

    private InterstitialPlacement parseSingleISPlacement(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            PlacementAvailabilitySettings placementAvailabilitySettings = getPlacementAvailabilitySettings(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                InterstitialPlacement interstitialPlacement = new InterstitialPlacement(optInt, optString, optBoolean, placementAvailabilitySettings);
                if (placementAvailabilitySettings == null) {
                    return interstitialPlacement;
                }
                CappingManager.addCappingInfo(this.mContext, interstitialPlacement);
                return interstitialPlacement;
            }
        }
        return null;
    }

    private OfferwallPlacement parseSingleOWPlacement(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                return new OfferwallPlacement(optInt, optString, optBoolean);
            }
        }
        return null;
    }

    private BannerPlacement parseSingleBNPlacement(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("placementId", -1);
            String optString = jSONObject.optString("placementName", "");
            boolean optBoolean = jSONObject.optBoolean("isDefault", false);
            PlacementAvailabilitySettings placementAvailabilitySettings = getPlacementAvailabilitySettings(jSONObject);
            if (optInt >= 0 && !TextUtils.isEmpty(optString)) {
                BannerPlacement bannerPlacement = new BannerPlacement(optInt, optString, optBoolean, placementAvailabilitySettings);
                if (placementAvailabilitySettings == null) {
                    return bannerPlacement;
                }
                CappingManager.addCappingInfo(this.mContext, bannerPlacement);
                return bannerPlacement;
            }
        }
        return null;
    }

    private PlacementAvailabilitySettings getPlacementAvailabilitySettings(JSONObject jSONObject) {
        PlacementCappingType placementCappingType = null;
        if (jSONObject == null) {
            return null;
        }
        PlacementAvailabilitySettings.PlacementAvailabilitySettingsBuilder placementAvailabilitySettingsBuilder = new PlacementAvailabilitySettings.PlacementAvailabilitySettingsBuilder();
        boolean z = true;
        placementAvailabilitySettingsBuilder.delivery(jSONObject.optBoolean("delivery", true));
        JSONObject optJSONObject = jSONObject.optJSONObject("capping");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("unit");
            if (!TextUtils.isEmpty(optString)) {
                if (PlacementCappingType.PER_DAY.toString().equals(optString)) {
                    placementCappingType = PlacementCappingType.PER_DAY;
                } else if (PlacementCappingType.PER_HOUR.toString().equals(optString)) {
                    placementCappingType = PlacementCappingType.PER_HOUR;
                }
            }
            int optInt = optJSONObject.optInt("maxImpressions", 0);
            placementAvailabilitySettingsBuilder.capping(optJSONObject.optBoolean("enabled", false) && optInt > 0, placementCappingType, optInt);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pacing");
        if (optJSONObject2 != null) {
            int optInt2 = optJSONObject2.optInt("numOfSeconds", 0);
            if (!optJSONObject2.optBoolean("enabled", false) || optInt2 <= 0) {
                z = false;
            }
            placementAvailabilitySettingsBuilder.pacing(z, optInt2);
        }
        return placementAvailabilitySettingsBuilder.build();
    }

    private JSONObject getSection(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public String getRVBackFillProvider() {
        try {
            return this.mProviderOrder.getRVBackFillProvider();
        } catch (Exception e) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVBackFillProvider", e);
            return null;
        }
    }

    public String getRVPremiumProvider() {
        try {
            return this.mProviderOrder.getRVPremiumProvider();
        } catch (Exception e) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVPremiumProvider", e);
            return null;
        }
    }

    public ProviderSettingsHolder getProviderSettingsHolder() {
        return this.mProviderSettingsHolder;
    }

    public ProviderOrder getProviderOrder() {
        return this.mProviderOrder;
    }

    public Configurations getConfigurations() {
        return this.mConfigurations;
    }

    private Context getContext() {
        return this.mContext;
    }
}
