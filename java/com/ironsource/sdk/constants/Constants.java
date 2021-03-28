package com.ironsource.sdk.constants;

import com.ironsource.sdk.data.ISNEnums;

public class Constants {
    public static final int API_VERSION_MANUAL_LOAD = 2;
    public static final int CONTROLLER_DEBUG_MODE = 0;
    public static final String CONVERT_API_VERSION = "apiVersion";
    public static final String CONVERT_DEMAND_SOURCE_ID = "demandSourceId";
    public static final String CONVERT_DEMAND_SOURCE_NAME = "demandSourceName";
    public static final String CONVERT_HEIGHT = "height";
    public static final String CONVERT_INSTANCE_ID = "instanceId";
    public static final String CONVERT_INSTANCE_NAME = "instanceName";
    public static final String CONVERT_IN_APP_BIDDING = "inAppBidding";
    public static final String CONVERT_LABEL = "label";
    public static final String CONVERT_NAME = "name";
    public static final String CONVERT_REWARDED = "rewarded";
    public static final String CONVERT_WIDTH = "width";
    public static final String JAVASCRIPT_INTERFACE_NAME = "Android";
    public static final String JAVASCRIPT_INTERFACE_NAME_GENERATE_TOKEN = "GenerateTokenForMessaging";
    public static final String MOBILE_CONTROLLER_HTML = "mobileController.html";
    public static final String NATIVE_EXCEPTION_BASE_URL = "https://www.supersonicads.com/mobile/sdk5/log?method=";
    public static final String PLACEMENT_ID = "placementId";
    public static final String RESTORED_STATE = "state";
    public static final String SDK_VERSION = "5.94";

    public class RequestParameters {
        public static final String AID = "AID";
        public static final String AMPERSAND = "&";
        public static final String APPLICATION_KEY = "applicationKey";
        public static final String APPLICATION_USER_ID = "applicationUserId";
        public static final String APPLICATION_VERSION_NAME = "appVersion";
        public static final String APP_ORIENTATION = "appOrientation";
        public static final String BATTERY_LEVEL = "batteryLevel";
        public static final String CONNECTION_INFO = "connectionInfo";
        public static final String CONNECTION_TYPE = "connectionType";
        public static final String CONNECTIVITY_STRATEGY = "connectivityStrategy";
        public static final String CONSENT = "consent";
        public static final String CONTROLLER_CONFIG = "controllerConfig";
        public static final String DEBUG = "debug";
        public static final String DEMAND_SOURCE_ID = "demandSourceId";
        public static final String DEMAND_SOURCE_NAME = "demandSourceName";
        public static final String DEVICE_API_LEVEL = "deviceApiLevel";
        public static final String DEVICE_DATA_AIRPLANE_MODE = "airplaneMode";
        public static final String DEVICE_DATA_CHARGING_TYPE = "chargingType";
        public static final String DEVICE_DATA_IS_CHARGING = "isCharging";
        public static final String DEVICE_DATA_SD_CARD_AVAILABLE = "sdCardAvailable";
        public static final String DEVICE_DATA_STAY_ON_WHEN_PLUGGED_IN = "stayOnWhenPluggedIn";
        public static final String DEVICE_DATA_TOTAL_DEVICE_RAM = "totalDeviceRAM";
        public static final String DEVICE_LANGUAGE = "deviceLanguage";
        public static final String DEVICE_MODEL = "deviceModel";
        public static final String DEVICE_OEM = "deviceOEM";
        public static final String DEVICE_ORIENTATION = "deviceOrientation";
        public static final String DEVICE_OS = "deviceOs";
        public static final String DEVICE_OS_VERSION = "deviceOSVersion";
        public static final String DEVICE_OS_VERSION_FULL = "deviceOSVersionFull";
        public static final String DEVICE_SCREEN_SCALE = "deviceScreenScale";
        public static final String DEVICE_SCREEN_SIZE = "deviceScreenSize";
        public static final String DEVICE_VOLUME = "deviceVolume";
        public static final String DISK_FREE_SIZE = "diskFreeSize";
        public static final String DISPLAY_SIZE_HEIGHT = "displaySizeHeight";
        public static final String DISPLAY_SIZE_WIDTH = "displaySizeWidth";
        public static final String DOMAIN = "domain";
        public static final String EQUAL = "=";
        public static final String FIRST_INSTALL_TIME = "firstInstallTime";
        public static final String GDPR_CONSENT_STATUS = "gdprConsentStatus";
        public static final String GOOGLE_PLAY_INSTALLED = "gpi";
        public static final String HAS_VPN = "hasVPN";
        public static final String HEIGHT = "height";
        public static final String IMMERSIVE = "immersiveMode";
        public static final String INSTALLER_PACKAGE_NAME = "installerPackageName";
        public static final String IS_ROOT_DEVICE = "unLocked";
        public static final String IS_SECURED = "isSecured";
        public static final String LAST_UPDATE_TIME = "lastUpdateTime";
        public static final String LEFT_BRACKETS = "[";
        public static final String LOCAL_TIME = "localTime";
        public static final String MOBILE_CARRIER = "mobileCarrier";
        public static final String NETWORK_MCC = "mcc";
        public static final String NETWORK_MNC = "mnc";
        public static final String PACKAGE_NAME = "bundleId";
        public static final String PHONE_TYPE = "phoneType";
        public static final String PROTOCOL = "protocol";
        public static final String RIGHT_BRACKETS = "]";
        public static final String SCREEN_BRIGHTNESS = "screenBrightness";
        public static final String SDK_VERSION = "SDKVersion";
        public static final String SESSION_DEPTH = "sessionDepth";
        public static final String SIM_OPERATOR = "simOperator";
        public static final String TIMEZONE_OFFSET = "timezoneOffset";
        public static final String WIDTH = "width";
        public static final String isLAT = "isLimitAdTrackingEnabled";

        public RequestParameters() {
        }
    }

    public static class JSMethods {
        public static final String ASSET_CACHED = "assetCached";
        public static final String ASSET_CACHED_FAILED = "assetCachedFailed";
        public static final String CONNECTION_INFO_CHANGED = "connectionInfoChanged";
        public static final String DEVICE_STATUS_CHANGED = "deviceStatusChanged";
        public static final String ENGAGE_END = "engageEnd";
        public static final String ENTER_BACKGROUND = "enterBackground";
        public static final String ENTER_FOREGROUND = "enterForeground";
        public static final String FAILED_TO_START_STORE_ACTIVITY = "failedToStartStoreActivity";
        public static final String GET_USER_CREDITS = "getUserCredits";
        public static final String INIT_BANNER = "initBanner";
        public static final String INIT_INTERSTITIAL = "initInterstitial";
        public static final String INIT_OFFERWALL = "initOfferWall";
        public static final String INIT_REWARDED_VIDEO = "initRewardedVideo";
        public static final String INTERCEPTED_URL_TO_STORE = "interceptedUrlToStore";
        public static final String LOAD_BANNER = "loadBanner";
        public static final String LOAD_INTERSTITIAL = "loadInterstitial";
        public static final String NATIVE_NAVIGATION_PRESSED = "nativeNavigationPressed";
        public static final String ON_GENERIC_FUNCTION_FAIL = "onGenericFunctionFail";
        public static final String ON_GET_APPLICATION_INFO_FAIL = "onGetApplicationInfoFail";
        public static final String ON_GET_APPLICATION_INFO_SUCCESS = "onGetApplicationInfoSuccess";
        public static final String ON_GET_CACHED_FILES_MAP_FAIL = "onGetCachedFilesMapFail";
        public static final String ON_GET_CACHED_FILES_MAP_SUCCESS = "onGetCachedFilesMapSuccess";
        public static final String ON_GET_DEVICE_STATUS_FAIL = "onGetDeviceStatusFail";
        public static final String ON_GET_DEVICE_STATUS_SUCCESS = "onGetDeviceStatusSuccess";
        public static final String ON_GET_ORIENTATION_FAIL = "onGetOrientationFail";
        public static final String ON_GET_ORIENTATION_SUCCESS = "onGetOrientationSuccess";
        public static final String ON_GET_USER_CREDITS_FAILED = "onGetUserCreditsFail";
        public static final String ON_INIT_BANNER_FAIL = "onInitBannerFail";
        public static final String ON_INIT_BANNER_SUCCESS = "onInitBannerSuccess";
        public static final String ON_INIT_INTERSTITIAL_FAIL = "onInitInterstitialFail";
        public static final String ON_INIT_INTERSTITIAL_SUCCESS = "onInitInterstitialSuccess";
        public static final String ON_INIT_OFFERWALL_FAIL = "onInitOfferWallFail";
        public static final String ON_INIT_OFFERWALL_SUCCESS = "onInitOfferWallSuccess";
        public static final String ON_INIT_REWARDED_VIDEO_FAIL = "onInitRewardedVideoFail";
        public static final String ON_INIT_REWARDED_VIDEO_SUCCESS = "onInitRewardedVideoSuccess";
        public static final String ON_LOAD_BANNER_FAIL = "onLoadBannerFail";
        public static final String ON_LOAD_BANNER_SUCCESS = "onLoadBannerSuccess";
        public static final String ON_LOAD_INTERSTITIAL_FAIL = "onLoadInterstitialFail";
        public static final String ON_LOAD_INTERSTITIAL_SUCCESS = "onLoadInterstitialSuccess";
        public static final String ON_NATIVE_LIFE_CYCLE_EVENT = "onNativeLifeCycleEvent";
        public static final String ON_SHOW_INTERSTITIAL_FAIL = "onShowInterstitialFail";
        public static final String ON_SHOW_INTERSTITIAL_SUCCESS = "onShowInterstitialSuccess";
        public static final String ON_SHOW_OFFER_WALL_FAIL = "onShowOfferWallFail";
        public static final String ON_SHOW_OFFER_WALL_SUCCESS = "onShowOfferWallSuccess";
        public static final String ON_SHOW_REWARDED_VIDEO_FAIL = "onShowRewardedVideoFail";
        public static final String ON_SHOW_REWARDED_VIDEO_SUCCESS = "onShowRewardedVideoSuccess";
        public static final String ON_UNAUTHORIZED_MESSAGE = "unauthorizedMessage";
        public static final String PAGE_FINISHED = "pageFinished";
        public static final String POST_AD_EVENT_NOTIFICATION_FAIL = "postAdEventNotificationFail";
        public static final String POST_AD_EVENT_NOTIFICATION_SUCCESS = "postAdEventNotificationSuccess";
        public static final String SHOW_INTERSTITIAL = "showInterstitial";
        public static final String SHOW_OFFER_WALL = "showOfferWall";
        public static final String SHOW_REWARDED_VIDEO = "showRewardedVideo";
        public static final String UPDATE_CONSENT_INFO = "updateConsentInfo";
        public static final String VIEWABLE_CHANGE = "viewableChange";
        public String failureCallbackName;
        public String methodName;
        public String successCallbackName;

        public static JSMethods getInitMethodByProduct(ISNEnums.ProductType productType) {
            JSMethods jSMethods = new JSMethods();
            if (productType == ISNEnums.ProductType.RewardedVideo) {
                jSMethods.methodName = INIT_REWARDED_VIDEO;
                jSMethods.successCallbackName = ON_INIT_REWARDED_VIDEO_SUCCESS;
                jSMethods.failureCallbackName = ON_INIT_REWARDED_VIDEO_FAIL;
            } else if (productType == ISNEnums.ProductType.Interstitial) {
                jSMethods.methodName = INIT_INTERSTITIAL;
                jSMethods.successCallbackName = ON_INIT_INTERSTITIAL_SUCCESS;
                jSMethods.failureCallbackName = ON_INIT_INTERSTITIAL_FAIL;
            } else if (productType == ISNEnums.ProductType.OfferWall) {
                jSMethods.methodName = INIT_OFFERWALL;
                jSMethods.successCallbackName = ON_INIT_OFFERWALL_SUCCESS;
                jSMethods.failureCallbackName = ON_INIT_OFFERWALL_FAIL;
            } else if (productType == ISNEnums.ProductType.Banner) {
                jSMethods.methodName = INIT_BANNER;
                jSMethods.successCallbackName = ON_INIT_BANNER_SUCCESS;
                jSMethods.failureCallbackName = ON_INIT_BANNER_FAIL;
            }
            return jSMethods;
        }

        public static JSMethods getShowMethodByProduct(ISNEnums.ProductType productType) {
            JSMethods jSMethods = new JSMethods();
            if (productType == ISNEnums.ProductType.RewardedVideo) {
                jSMethods.methodName = SHOW_REWARDED_VIDEO;
                jSMethods.successCallbackName = ON_SHOW_REWARDED_VIDEO_SUCCESS;
                jSMethods.failureCallbackName = ON_SHOW_REWARDED_VIDEO_FAIL;
            } else if (productType == ISNEnums.ProductType.Interstitial) {
                jSMethods.methodName = SHOW_INTERSTITIAL;
                jSMethods.successCallbackName = ON_SHOW_INTERSTITIAL_SUCCESS;
                jSMethods.failureCallbackName = ON_SHOW_INTERSTITIAL_FAIL;
            } else if (productType == ISNEnums.ProductType.OfferWall) {
                jSMethods.methodName = SHOW_OFFER_WALL;
                jSMethods.successCallbackName = ON_SHOW_OFFER_WALL_SUCCESS;
                jSMethods.failureCallbackName = ON_INIT_OFFERWALL_FAIL;
            }
            return jSMethods;
        }
    }

    public class ForceClosePosition {
        public static final String BOTTOM_LEFT = "bottom-left";
        public static final String BOTTOM_RIGHT = "bottom-right";
        public static final int HEIGHT = 50;
        public static final String TOP_LEFT = "top-left";
        public static final String TOP_RIGHT = "top-right";
        public static final int WIDTH = 50;

        public ForceClosePosition() {
        }
    }

    public class ErrorCodes {
        public static final String CONTROLLER_HTML_DOWNLOAD_TIMEOUT = "controller html - download timeout";
        public static final String CONTROLLER_HTML_FAILED_TO_DOWNLOAD = "controller html - failed to download";
        public static final String CONTROLLER_HTML_FAILED_TO_LOAD = "controller html - failed to load into web-view";
        public static final String CONTROLLER_HTML_WEBVIEW_FAILED_TO_LOAD = "controller html - web-view receivedError on loading";
        public static final String CONTROLLER_JS_FAILED_TO_INITIALIZE = "controller js failed to initialize";
        public static final String EVENT_NAME_DOES_NOT_EXIST = "eventName does not exist";
        public static final String FAILED_TO_RETRIEVE_CONNECTION_INFO = "failed to retrieve connection info";
        public static final String FILE_NOT_EXIST_CODE = "1";
        public static final String FILE_NOT_EXIST_MSG = "File not exist";
        public static final String FOLDER_NOT_EXIST_CODE = "1";
        public static final String FOLDER_NOT_EXIST_MSG = "Folder not exist";
        public static final String InitBN = "Init BN";
        public static final String InitIS = "Init IS";
        public static final String InitOW = "Init OW";
        public static final String InitRV = "Init RV";
        public static final String InitiatingController = "Initiating Controller";
        public static final String KEY_DOES_NOT_EXIST = "key does not exist";
        public static final String NUM_OF_AD_UNITS_DO_NOT_EXIST = "Num Of Ad Units Do Not Exist";
        public static final String OS_VERSION_NOT_SUPPORTED = "OS version not supported";
        public static final String PATH_FILE_DOES_NOT_EXIST_ON_DISK = "path file does not exist on disk";
        public static final String PATH_KEY_DOES_NOT_EXIST = "path key does not exist";
        public static final String PRODUCT_TYPE_DOES_NOT_EXIST = "productType does not exist";
        public static final String STORE_ACTIVITY_FAILED_REASON_NO_ACTIVITY = "no activity to handle url";
        public static final String STORE_ACTIVITY_FAILED_REASON_UNSPECIFIED = "activity failed to open with unspecified reason";
        public static final String STORE_ACTIVITY_FAILED_UNKNOWN_URL = "unknown url";
        public static final String ShowOWCredits = "Show OW Credits";
        public static final String VALUE_DOES_NOT_EXIST = "value does not exist";
        public static final String WEB_VIEW_PERFORM_CLEANUP_FAILED = "performCleanup | could not destroy ISNAdView";

        public ErrorCodes() {
        }
    }

    public class ParametersKeys {
        public static final String ACTION = "action";
        public static final String ACTIVITY_THEME_TRANSLUCENT = "activityThemeTranslucent";
        public static final String ADM = "adm";
        public static final String AD_CONTAINER_ID = "adContainerId";
        public static final String AD_VIEW_ID = "adViewId";
        public static final String COLOR = "color";
        public static final String CREDITS = "credits";
        public static final String DATA = "data";
        public static final String DEMAND_SOURCE_ID = "demandSourceId";
        public static final String DEMAND_SOURCE_NAME = "demandSourceName";
        public static final String DISPLAY = "display";
        public static final String ERR_CODE = "errCode";
        public static final String ERR_MSG = "errMsg";
        public static final String EVENT_NAME = "eventName";
        public static final String EXTERNAL_BROWSER = "external_browser";
        public static final String EXTRA_DATA = "extData";
        public static final String FAILED = "failed";
        public static final String FILE = "file";
        public static final String FORCE_CLOSE = "forceClose";
        public static final String HEIGHT = "height";
        public static final String IMMERSIVE = "immersive";
        public static final String INTERSTITIAL = "Interstitial";
        public static final String IS_PACKAGE_INSTALLED = "isInstalled";
        public static final String IS_STANDALONE_VIEW = "standaloneView";
        public static final String IS_VIEWABLE = "isViewable";
        public static final String KEY = "key";
        public static final String LIFE_CYCLE_EVENT = "lifeCycleEvent";
        public static final String LOADED = "loaded";
        public static final String MAIN = "main";
        public static final String MAP_PATH = "path";
        public static final String METHOD = "method";
        public static final String NOTIFICATION_DEMAND_SOURCE_NAME = "dsName";
        public static final String OFFER_WALL = "OfferWall";
        public static final String ORIENTATION = "orientation";
        public static final String ORIENTATION_APPLICATION = "application";
        public static final String ORIENTATION_DEVICE = "device";
        public static final String ORIENTATION_LANDSCAPE = "landscape";
        public static final String ORIENTATION_NONE = "none";
        public static final String ORIENTATION_PORTRAIT = "portrait";
        public static final String ORIENTATION_SET_FLAG = "orientation_set_flag";
        public static final String PARAMS = "params";
        public static final String PATH = "path";
        public static final String POSITION = "position";
        public static final String PRODUCT_TYPE = "productType";
        public static final String READY = "ready";
        public static final String ROTATION_SET_FLAG = "rotation_set_flag";
        public static final String SEARCH_KEYS = "searchKeys";
        public static final String SECONDARY = "secondary";
        public static final String SECONDARY_CLOSE = "secondaryClose";
        public static final String STAGE = "stage";
        public static final String STATE = "state";
        public static final String STORE = "store";
        public static final String TOTAL = "total";
        public static final String TRANSPARENT = "transparent";
        public static final String URL = "url";
        public static final String URL_FOR_WEBVIEW = "urlForWebView";
        public static final String VALUE = "value";
        public static final String VIDEO_STATUS = "status";
        public static final String VIDEO_STATUS_ENDED = "ended";
        public static final String VIDEO_STATUS_PAUSED = "paused";
        public static final String VIDEO_STATUS_PLAYING = "playing";
        public static final String VIDEO_STATUS_STARTED = "started";
        public static final String VIDEO_STATUS_STOPPED = "stopped";
        public static final String WEB_VIEW = "webview";
        public static final String WIDTH = "width";

        public ParametersKeys() {
        }
    }

    public class ControllerParameters {
        public static final int GLOBAL_RUNTIME = 200000;
        public static final int LOAD_ATTEMPTS = 3;
        public static final int LOAD_RUNTIME = 50000;
        public static final int SECOND = 1000;

        public ControllerParameters() {
        }
    }

    public class FeaturesManager {
        public static final String DEBUG_MODE = "debugMode";
        public static final String MIN_OS_VERSION_SUPPORT = "minOSVersionSupport";
        public static final String NO_PACKAGES_INSTALLATION_POLLING = "noPackagesInstallationPolling";
        public static final String PULL_DEVICE_DATA = "pullDeviceData";
        public static final String WEB_VIEW_PER_AD_V1 = "webviewperad-v1";

        public FeaturesManager() {
        }
    }

    public class ControllerConfigurationKeys {
        public static final String ENABLE_LIFE_CYCLE_EVENT_LISTENRS_KEY = "enableLifeCycleListeners";
        public static final String NATIVE_FEATURES_KEY = "nativeFeatures";
        public static final String NETWORK_CONFIGURATION_KEY = "networkConfig";

        public ControllerConfigurationKeys() {
        }
    }

    public class AppPackageNames {
        public static final String ANDROID_VENDING = "com.android.vending";
        public static final String GOOGLE_MARKET = "com.google.market";

        public AppPackageNames() {
        }
    }
}
