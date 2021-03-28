package com.ironsource.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TokenConstants {
    public static final String ADVERTISING_ID = "advertisingId";
    public static final String ADVERTISING_ID_TYPE = "advIdType";
    public static final String AID = "AID";
    public static final String APPLICATION_KEY = "applicationKey";
    public static final String APPLICATION_USER_AGE = "applicationUserAge";
    public static final String APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
    public static final String APPLICATION_USER_GENDER = "applicationUserGender";
    public static final String APPLICATION_USER_ID = "applicationUserId";
    public static final String APPLICATION_VERSION_NAME = "appVersion";
    public static final String APP_ORIENTATION = "appOrientation";
    public static final String APP_ORIENTATION_MINIMIZED = "appOr";
    public static final String BATTERY_LEVEL = "batteryLevel";
    private static final String BLACKLISTED_CAMPAIGNS = "blacklistedCampaigns";
    public static final String BUNDLE_ID = "bundleId";
    public static final String CELLULAR_NETWORK_TYPE = "cellularNetworkType";
    public static final String CELLULAR_NETWORK_TYPE_MINIMIZED = "cellNetT";
    public static final String CHINA_CDN = "chinaCDN";
    public static final String CHINA_CDN_MINIMIZED = "cnaCDN";
    public static final String CLIENT_TIMESTAMP = "clientTimestamp";
    public static final String CONNECTION_TYPE = "connectionType";
    public static final String CONSENT = "consent";
    public static final String DEVICE_API_LEVEL = "deviceApiLevel";
    public static final String DEVICE_DATA_AIRPLANE_MODE = "airplaneMode";
    public static final String DEVICE_DATA_AIRPLANE_MODE_MINIMIZED = "airM";
    public static final String DEVICE_DATA_CHARGING_TYPE = "chargingType";
    public static final String DEVICE_DATA_CHARGING_TYPE_MINIMIZED = "chargeT";
    public static final String DEVICE_DATA_IS_CHARGING = "isCharging";
    public static final String DEVICE_DATA_IS_CHARGING_MINIMIZED = "isCharge";
    public static final String DEVICE_DATA_SD_CARD_AVAILABLE = "sdCardAvailable";
    public static final String DEVICE_DATA_SD_CARD_AVAILABLE_MINIMIZED = "sdCrdAvail";
    public static final String DEVICE_DATA_STAY_ON_WHEN_PLUGGED_IN = "stayOnWhenPluggedIn";
    public static final String DEVICE_DATA_STAY_ON_WHEN_PLUGGED_IN_MINIMIZED = "onWhnPlugIn";
    public static final String DEVICE_DATA_TOTAL_DEVICE_RAM = "totalDeviceRAM";
    public static final String DEVICE_DATA_TOTAL_DEVICE_RAM_MINIMIZED = "dRAM";
    public static final String DEVICE_HEIGHT = "deviceHeight";
    public static final String DEVICE_IDS = "deviceIds[AID]";
    public static final String DEVICE_LANGUAGE = "deviceLanguage";
    public static final String DEVICE_MAKE = "deviceMake";
    public static final String DEVICE_MODEL = "deviceModel";
    public static final String DEVICE_OEM = "deviceOEM";
    public static final String DEVICE_OS = "deviceOS";
    public static final String DEVICE_OS_VERSION = "deviceOSVersion";
    public static final String DEVICE_OS_VERSION_FULL = "deviceOSVersionFull";
    public static final String DEVICE_Os = "deviceOs";
    public static final String DEVICE_SCREEN_SCALE = "deviceScreenScale";
    public static final String DEVICE_SCREEN_SCALE_MINIMIZED = "dScrenScle";
    public static final String DEVICE_VOLUME = "deviceVolume";
    public static final String DEVICE_VOLUME_MINIMIZED = "dVol";
    public static final String DEVICE_WIDTH = "deviceWidth";
    public static final String DISK_FREE_SIZE = "diskFreeSize";
    public static final String DISPLAY_SIZE_HEIGHT = "displaySizeHeight";
    public static final String DISPLAY_SIZE_HEIGHT_MINIMIZED = "dSizeH";
    public static final String DISPLAY_SIZE_WIDTH = "displaySizeWidth";
    public static final String DISPLAY_SIZE_WIDTH_MINIMIZED = "dSizeW";
    public static final String FIRST_INSTALL_TIME = "firstInstallTime";
    public static final String FIRST_INSTALL_TIME_MINIMIZED = "fInstallT";
    private static final String GOOGLE_PLAY_INSTALLED = "Gpi";
    public static final String HAS_VPN = "hasVPN";
    public static final String HAS_VPN_MINIMIZED = "vpn";
    public static final String IMMERSIVE = "immersiveMode";
    public static final String IMMERSIVE_MINIMIZED = "imm";
    public static final String INSTALLER_PACKAGE_NAME = "installerPackageName";
    public static final String INSTALLER_PACKAGE_NAME_MINIMIZED = "iPckgN";
    private static final String IS_IMPRESSIONS_COUNT_BIDDING = "biddingISImpressions";
    public static final String IS_LIMITED_AD_TRACKING = "isLimitAdTrackingEnabled";
    public static final String IS_ROOT_DEVICE = "unLocked";
    public static final String LAST_UPDATE_TIME = "lastUpdateTime";
    public static final String LAST_UPDATE_TIME_MINIMIZED = "lUpdateT";
    public static final String LOCAL_TIME = "localTime";
    public static final String MEDIATION_SDK_VERSION = "MedSDKVersion";
    public static final String METADATA_KEY_PREFIX = "metadata_";
    public static final String META_DATA = "metadata";
    public static final String MINIMIZED_ADVERTISING_ID = "advId";
    public static final String MINIMIZED_ADVERTISING_ID_TYPE = "advType";
    public static final String MINIMIZED_APPLICATION_KEY = "appKey";
    public static final String MINIMIZED_APPLICATION_USER_AGE = "uAge";
    public static final String MINIMIZED_APPLICATION_USER_GENDER = "uGen";
    public static final String MINIMIZED_APPLICATION_USER_ID = "usId";
    public static final String MINIMIZED_APPLICATION_VERSION = "appV";
    public static final String MINIMIZED_BATTERY_LEVEL = "bat";
    public static final String MINIMIZED_BUNDLE_ID = "bId";
    public static final String MINIMIZED_CLIENT_TIMESTAMP = "cTime";
    public static final String MINIMIZED_CONNECTION_TYPE = "connT";
    public static final String MINIMIZED_DEVICE_API_LEVEL = "dAPI";
    public static final String MINIMIZED_DEVICE_HEIGHT = "dHeight";
    public static final String MINIMIZED_DEVICE_LANGUAGE = "dLang";
    public static final String MINIMIZED_DEVICE_MAKE = "dMake";
    public static final String MINIMIZED_DEVICE_MODEL = "dModel";
    public static final String MINIMIZED_DEVICE_OS = "dOS";
    public static final String MINIMIZED_DEVICE_OS_VERSION = "dOSV";
    public static final String MINIMIZED_DEVICE_OS_VERSION_FULL = "dOSVF";
    public static final String MINIMIZED_DEVICE_WIDTH = "dWidth";
    public static final String MINIMIZED_DISK_FREE_SIZE = "diskFS";
    public static final String MINIMIZED_IS_LIMITED_AD_TRACKING = "isLAT";
    public static final String MINIMIZED_IS_ROOT_DEVICE = "root";
    public static final String MINIMIZED_MEDIATION_SDK_VERSION = "medV";
    public static final String MINIMIZED_META_DATA = "MD";
    public static final String MINIMIZED_MOBILE_CARRIER = "mCar";
    public static final String MINIMIZED_SDK_PLUGIN_TYPE = "plType";
    public static final String MINIMIZED_SESSION_DEPTH_IS = "sDepIS";
    public static final String MINIMIZED_SESSION_DEPTH_RV = "sDepRV";
    public static final String MINIMIZED_SESSION_ID = "sId";
    public static final String MOBILE_CARRIER = "mobileCarrier";
    public static final String NETWORK_MCC = "mcc";
    public static final String NETWORK_MNC = "mnc";
    public static final String OMID_PARTNER_VERSION_PROPERTY_NAME = "omidPartnerVersion";
    public static final String OMID_PARTNER_VERSION_PROPERTY_NAME_MINIMIZED = "omidPV";
    public static final String OMID_VERSION_PROPERTY_NAME = "omidVersion";
    public static final String OMID_VERSION_PROPERTY_NAME_MINIMIZED = "omidV";
    public static final String PHONE_TYPE = "phoneType";
    public static final String PHONE_TYPE_MINIMIZED = "pType";
    private static final String RV_IMPRESSIONS_COUNT_BIDDING = "biddingRVImpressions";
    public static final String SDK_PLUGIN_TYPE = "SDKPluginType";
    public static final String SDK_VERSION = "SDKVersion";
    public static final String SDK_VERSION_MINIMIZED = "sdkV";
    public static final String SESSION_DEPTH_IS = "sessionDepthIS";
    public static final String SESSION_DEPTH_RV = "sessionDepthRV";
    public static final String SESSION_ID = "sessionId";
    public static final String SIM_OPERATOR = "simOperator";
    public static final String SIM_OPERATOR_MINIMIZED = "simOp";
    public static final String TIMEZONE_OFFSET = "timezoneOffset";
    public static final String TIMEZONE_OFFSET_MINIMIZED = "tzOff";
    private static final String TOTAL_IMPRESSIONS_SESSION_IS = "totalISSessionImpressions";
    private static final String TOTAL_IMPRESSIONS_SESSION_RV = "totalRVSessionImpressions";
    public static final ArrayList<String> defaultNativeTokenKeysToInclude = new ArrayList<>(Arrays.asList(APPLICATION_USER_AGE_GROUP, MINIMIZED_APPLICATION_USER_AGE, MINIMIZED_ADVERTISING_ID, "appKey", MINIMIZED_MOBILE_CARRIER, MINIMIZED_MEDIATION_SDK_VERSION, MINIMIZED_CONNECTION_TYPE, MINIMIZED_DEVICE_WIDTH, MINIMIZED_DEVICE_HEIGHT, MINIMIZED_DEVICE_MODEL, MINIMIZED_CLIENT_TIMESTAMP, MINIMIZED_SESSION_DEPTH_RV, MINIMIZED_SESSION_DEPTH_IS, MINIMIZED_SESSION_ID, MINIMIZED_SDK_PLUGIN_TYPE, MINIMIZED_DEVICE_OS_VERSION, MINIMIZED_DEVICE_OS_VERSION_FULL, MINIMIZED_DEVICE_OS, MINIMIZED_DEVICE_MAKE, MINIMIZED_DEVICE_API_LEVEL, MINIMIZED_BUNDLE_ID, MINIMIZED_APPLICATION_VERSION, MINIMIZED_APPLICATION_USER_ID, MINIMIZED_BATTERY_LEVEL, MINIMIZED_IS_ROOT_DEVICE, MINIMIZED_DISK_FREE_SIZE, MINIMIZED_DEVICE_LANGUAGE, MINIMIZED_META_DATA, MINIMIZED_APPLICATION_USER_GENDER, MINIMIZED_ADVERTISING_ID_TYPE, MINIMIZED_IS_LIMITED_AD_TRACKING, DEVICE_VOLUME_MINIMIZED, "consent", MINIMIZED_DEVICE_HEIGHT, MINIMIZED_DEVICE_WIDTH, DEVICE_SCREEN_SCALE_MINIMIZED));
    public static final HashMap<String, String> minimizedTokenKeyNames = new HashMap<String, String>() {
        /* class com.ironsource.environment.TokenConstants.AnonymousClass1 */

        {
            put("omidVersion", TokenConstants.OMID_VERSION_PROPERTY_NAME_MINIMIZED);
            put("omidPartnerVersion", TokenConstants.OMID_PARTNER_VERSION_PROPERTY_NAME_MINIMIZED);
            put("immersiveMode", TokenConstants.IMMERSIVE_MINIMIZED);
            put("appOrientation", TokenConstants.APP_ORIENTATION_MINIMIZED);
            put("SDKVersion", TokenConstants.SDK_VERSION_MINIMIZED);
            put("deviceScreenScale", TokenConstants.DEVICE_SCREEN_SCALE_MINIMIZED);
            put("phoneType", TokenConstants.PHONE_TYPE_MINIMIZED);
            put("simOperator", TokenConstants.SIM_OPERATOR_MINIMIZED);
            put("lastUpdateTime", TokenConstants.LAST_UPDATE_TIME_MINIMIZED);
            put("firstInstallTime", TokenConstants.FIRST_INSTALL_TIME_MINIMIZED);
            put("displaySizeWidth", TokenConstants.MINIMIZED_DEVICE_WIDTH);
            put("displaySizeHeight", TokenConstants.MINIMIZED_DEVICE_HEIGHT);
            put(TokenConstants.CELLULAR_NETWORK_TYPE, TokenConstants.CELLULAR_NETWORK_TYPE_MINIMIZED);
            put("hasVPN", "vpn");
            put("deviceVolume", TokenConstants.DEVICE_VOLUME_MINIMIZED);
            put("sdCardAvailable", TokenConstants.DEVICE_DATA_SD_CARD_AVAILABLE_MINIMIZED);
            put("isCharging", TokenConstants.DEVICE_DATA_IS_CHARGING_MINIMIZED);
            put("chargingType", TokenConstants.DEVICE_DATA_CHARGING_TYPE_MINIMIZED);
            put("airplaneMode", TokenConstants.DEVICE_DATA_AIRPLANE_MODE_MINIMIZED);
            put("stayOnWhenPluggedIn", TokenConstants.DEVICE_DATA_STAY_ON_WHEN_PLUGGED_IN_MINIMIZED);
            put("totalDeviceRAM", TokenConstants.DEVICE_DATA_TOTAL_DEVICE_RAM_MINIMIZED);
            put("installerPackageName", TokenConstants.INSTALLER_PACKAGE_NAME_MINIMIZED);
            put("timezoneOffset", TokenConstants.TIMEZONE_OFFSET_MINIMIZED);
            put(TokenConstants.CHINA_CDN, TokenConstants.CHINA_CDN_MINIMIZED);
            put("deviceOs", TokenConstants.MINIMIZED_DEVICE_OS);
            put("localTime", TokenConstants.MINIMIZED_CLIENT_TIMESTAMP);
            put(TokenConstants.DEVICE_IDS, TokenConstants.MINIMIZED_ADVERTISING_ID);
            put(TokenConstants.APPLICATION_USER_AGE, TokenConstants.MINIMIZED_APPLICATION_USER_AGE);
            put(TokenConstants.ADVERTISING_ID, TokenConstants.MINIMIZED_ADVERTISING_ID);
            put(TokenConstants.ADVERTISING_ID_TYPE, TokenConstants.MINIMIZED_ADVERTISING_ID_TYPE);
            put(TokenConstants.DEVICE_WIDTH, TokenConstants.MINIMIZED_DEVICE_WIDTH);
            put(TokenConstants.DEVICE_HEIGHT, TokenConstants.MINIMIZED_DEVICE_HEIGHT);
            put(TokenConstants.DEVICE_OS, TokenConstants.MINIMIZED_DEVICE_OS);
            put(TokenConstants.CLIENT_TIMESTAMP, TokenConstants.MINIMIZED_CLIENT_TIMESTAMP);
            put(TokenConstants.SESSION_DEPTH_RV, TokenConstants.MINIMIZED_SESSION_DEPTH_RV);
            put(TokenConstants.SESSION_DEPTH_IS, TokenConstants.MINIMIZED_SESSION_DEPTH_IS);
            put(TokenConstants.SESSION_ID, TokenConstants.MINIMIZED_SESSION_ID);
            put(TokenConstants.MEDIATION_SDK_VERSION, TokenConstants.MINIMIZED_MEDIATION_SDK_VERSION);
            put(TokenConstants.DEVICE_MAKE, TokenConstants.MINIMIZED_DEVICE_MAKE);
            put(TokenConstants.APPLICATION_USER_GENDER, TokenConstants.MINIMIZED_APPLICATION_USER_GENDER);
            put("batteryLevel", TokenConstants.MINIMIZED_BATTERY_LEVEL);
            put("unLocked", TokenConstants.MINIMIZED_IS_ROOT_DEVICE);
            put("deviceOSVersion", TokenConstants.MINIMIZED_DEVICE_OS_VERSION);
            put("bundleId", TokenConstants.MINIMIZED_BUNDLE_ID);
            put("mobileCarrier", TokenConstants.MINIMIZED_MOBILE_CARRIER);
            put("connectionType", TokenConstants.MINIMIZED_CONNECTION_TYPE);
            put("appVersion", TokenConstants.MINIMIZED_APPLICATION_VERSION);
            put("applicationKey", "appKey");
            put("applicationUserId", TokenConstants.MINIMIZED_APPLICATION_USER_ID);
            put("isLimitAdTrackingEnabled", TokenConstants.MINIMIZED_IS_LIMITED_AD_TRACKING);
            put(TokenConstants.META_DATA, TokenConstants.MINIMIZED_META_DATA);
            put("deviceModel", TokenConstants.MINIMIZED_DEVICE_MODEL);
            put(TokenConstants.SDK_PLUGIN_TYPE, TokenConstants.MINIMIZED_SDK_PLUGIN_TYPE);
            put("deviceApiLevel", TokenConstants.MINIMIZED_DEVICE_API_LEVEL);
            put("diskFreeSize", TokenConstants.MINIMIZED_DISK_FREE_SIZE);
            put("deviceLanguage", TokenConstants.MINIMIZED_DEVICE_LANGUAGE);
            put("deviceOEM", TokenConstants.MINIMIZED_DEVICE_MAKE);
            put("deviceOSVersionFull", TokenConstants.MINIMIZED_DEVICE_OS_VERSION_FULL);
        }
    };
}
