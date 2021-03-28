package com.ironsource.mediationsdk;

import android.os.AsyncTask;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.TokenConstants;
import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuctionDataUtils {
    private static final String ADVERTISING_ID = "advId";
    private static final String ADVERTISING_ID_TYPE = "advIdType";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION_NAME = "appVersion";
    private static final String AUCTION_DATA = "auctionData";
    public static final String AUCTION_LOSS_MACRO = "${AUCTION_LOSS}";
    public static final String AUCTION_MBR_MACRO = "${AUCTION_MBR}";
    public static final String AUCTION_PRICE_MACRO = "${AUCTION_PRICE}";
    public static final String AUCTION_RESPONSE_KEY_AD_MARKUP = "adMarkup";
    public static final String AUCTION_RESPONSE_KEY_AUCTION_ID = "auctionId";
    public static final String AUCTION_RESPONSE_KEY_BURL = "burl";
    public static final String AUCTION_RESPONSE_KEY_GENERIC_PARAMS = "genericParams";
    public static final String AUCTION_RESPONSE_KEY_IMPRESSION_DATA = "armData";
    public static final String AUCTION_RESPONSE_KEY_INSTANCE = "instance";
    public static final String AUCTION_RESPONSE_KEY_LURL = "lurl";
    public static final String AUCTION_RESPONSE_KEY_NOTIFICATIONS = "notifications";
    public static final String AUCTION_RESPONSE_KEY_NURL = "nurl";
    public static final String AUCTION_RESPONSE_KEY_PRICE = "price";
    public static final String AUCTION_RESPONSE_KEY_SERVER_DATA = "serverData";
    public static final String AUCTION_RESPONSE_KEY_SETTINGS = "settings";
    public static final String AUCTION_RESPONSE_KEY_WATERFALL = "waterfall";
    private static final String AUCTION_RESPONSE_SERVER_DATA_ADM_KEY = "adMarkup";
    private static final String AUCTION_RESPONSE_SERVER_DATA_MARKET_PLACE_DEMAND_TYPE_KEY = "dynamicDemandSource";
    private static final String AUCTION_RESPONSE_SERVER_DATA_PARAMS_KEY = "params";
    private static final String BANNER_HEIGHT = "bannerHeight";
    private static final String BANNER_SIZE = "bannerSize";
    private static final String BANNER_WIDTH = "bannerWidth";
    private static final String BIDDING_ADDITIONAL_DATA = "biddingAdditionalData";
    private static final String BROWSER_UER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CLIENT_PARAMS = "clientParams";
    private static final String CLIENT_TIMESTAMP = "clientTimestamp";
    private static final String CONNECTION_TYPE = "connectionType";
    private static final String CONSENT = "consent";
    private static final String DEVICE_HEIGHT = "deviceHeight";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "deviceMake";
    private static final String DEVICE_MODEL = "deviceModel";
    private static final String DEVICE_OS = "deviceOS";
    private static final String DEVICE_OS_VERSION = "deviceOSVersion";
    private static final String DEVICE_TYPE = "deviceType";
    private static final String DEVICE_WIDTH = "deviceWidth";
    public static final String DYNAMIC_DEMAND_SOURCE_MACRO = "${DYNAMIC_DEMAND_SOURCE}";
    private static final String FIRST_SESSION = "fs";
    private static final String INSTANCES = "instances";
    public static final String INSTANCE_NAME_MACRO = "${INSTANCE}";
    private static final String INSTANCE_TYPE = "instanceType";
    public static final String INSTANCE_TYPE_MACRO = "${INSTANCE_TYPE}";
    private static final String LIMITED_AD_TRACKING = "isLimitAdTrackingEnabled";
    private static final String META_DATA = "metaData";
    private static final String MOBILE_CARRIER = "mobileCarrier";
    private static final String PERFORMANCE = "performance";
    public static final String PLACEMENT_NAME_MACRO = "${PLACEMENT_NAME}";
    private static final String SDK_VERSION = "SDKVersion";
    private static final String SECURE = "secure";
    private static final String SESSION_DEPTH = "sessionDepth";
    private static final String SESSION_ID = "sessionId";
    private static final String TAG = "AuctionDataUtils";
    private static AuctionDataUtils sInstance = new AuctionDataUtils();

    /* access modifiers changed from: private */
    public enum SecureFlag {
        NOT_SECURE,
        SECURE
    }

    public static AuctionDataUtils getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    public AuctionData getAuctionDataFromResponse(JSONObject jSONObject) throws JSONException {
        AuctionData auctionData = new AuctionData();
        auctionData.mAuctionId = jSONObject.getString("auctionId");
        JSONObject jSONObject2 = null;
        if (jSONObject.has(AUCTION_RESPONSE_KEY_SETTINGS)) {
            JSONObject jSONObject3 = jSONObject.getJSONObject(AUCTION_RESPONSE_KEY_SETTINGS);
            auctionData.mGenericNotifications = new AuctionResponseItem(jSONObject3);
            if (jSONObject3.has(AUCTION_RESPONSE_KEY_IMPRESSION_DATA)) {
                jSONObject2 = jSONObject3.optJSONObject(AUCTION_RESPONSE_KEY_IMPRESSION_DATA);
            }
            if (jSONObject3.has("genericParams")) {
                auctionData.mGenericParams = jSONObject3.optJSONObject("genericParams");
            }
        }
        auctionData.mWaterfall = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(AUCTION_RESPONSE_KEY_WATERFALL);
        for (int i = 0; i < jSONArray.length(); i++) {
            AuctionResponseItem auctionResponseItem = new AuctionResponseItem(jSONArray.getJSONObject(i), jSONObject2);
            if (auctionResponseItem.isValid()) {
                auctionData.mWaterfall.add(auctionResponseItem);
            } else {
                auctionData.mErrorCode = 1002;
                auctionData.mErrorMessage = "waterfall " + i;
                throw new JSONException("invalid response");
            }
        }
        return auctionData;
    }

    private String getDeviceType() {
        return DeviceStatus.getIsTablet(ContextProvider.getInstance().getCurrentActiveActivity()) ? "Tablet" : "Phone";
    }

    private String getDeviceLang() {
        String language = Locale.getDefault().getLanguage();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("lang = " + language);
        return language;
    }

    private SecureFlag getAuctionSecureFlag() {
        SecureFlag secureFlag;
        SecureFlag secureFlag2 = SecureFlag.SECURE;
        if (Build.VERSION.SDK_INT >= 28) {
            secureFlag = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? SecureFlag.NOT_SECURE : SecureFlag.SECURE;
        } else if (Build.VERSION.SDK_INT >= 23) {
            secureFlag = (ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & 134217728) != 0 ? SecureFlag.NOT_SECURE : SecureFlag.SECURE;
        } else {
            secureFlag = SecureFlag.NOT_SECURE;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("secureFlag = " + secureFlag);
        return secureFlag;
    }

    public AuctionResponseItem getAuctionResponseItem(String str, List<AuctionResponseItem> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getInstanceName().equals(str)) {
                return list.get(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject enrichToken(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13, java.util.List<java.lang.String> r14, com.ironsource.mediationsdk.AuctionHistory r15, int r16, java.lang.String r17, com.ironsource.mediationsdk.utils.AuctionSettings r18, com.ironsource.mediationsdk.ISBannerSize r19) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 590
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.AuctionDataUtils.enrichToken(android.content.Context, java.util.Map, java.util.List, com.ironsource.mediationsdk.AuctionHistory, int, java.lang.String, com.ironsource.mediationsdk.utils.AuctionSettings, com.ironsource.mediationsdk.ISBannerSize):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public String getModifiedKeyForToken(JSONObject jSONObject, String str) {
        if (!jSONObject.has(str)) {
            return str;
        }
        int i = 0;
        String str2 = str;
        while (jSONObject.has(str2)) {
            i++;
            str2 = str + "_" + i;
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void mergeNewParametersToToken(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(getModifiedKeyForToken(jSONObject, next), jSONObject2.opt(next));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject createToken(JSONObject jSONObject, JSONObject jSONObject2, List<String> list) {
        JSONObject fetchNativeKeysListFromMinimizedToken = fetchNativeKeysListFromMinimizedToken(TokenDataService.getInstance().getTokenData(), list);
        mergeNewParametersToToken(fetchNativeKeysListFromMinimizedToken, getPlayerTokenWithMinimizedKeyParams(jSONObject, list));
        mergeNewParametersToToken(fetchNativeKeysListFromMinimizedToken, getGenericTokenWithMinimizedKeyParams(jSONObject2, list));
        return fetchNativeKeysListFromMinimizedToken;
    }

    /* access modifiers changed from: package-private */
    public String getMinimizedKeyParamFromMap(HashMap<String, String> hashMap, String str) {
        return hashMap.containsKey(str) ? hashMap.get(str) : str;
    }

    private JSONObject getTokenParamsAccordingToKeysList(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (list.contains(next)) {
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    private JSONObject getPlayerTokenWithMinimizedKeyParams(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    String minimizedKeyParamFromMap = getMinimizedKeyParamFromMap(TokenConstants.minimizedTokenKeyNames, next);
                    if ((list.isEmpty() && !TokenConstants.defaultNativeTokenKeysToInclude.contains(minimizedKeyParamFromMap) && !minimizedKeyParamFromMap.startsWith(TokenConstants.METADATA_KEY_PREFIX)) || list.contains(minimizedKeyParamFromMap)) {
                        jSONObject2.put(minimizedKeyParamFromMap, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    private JSONObject getGenericTokenWithMinimizedKeyParams(JSONObject jSONObject, List<String> list) {
        if (list.isEmpty()) {
            return jSONObject;
        }
        return getTokenParamsAccordingToKeysList(jSONObject, list);
    }

    private JSONObject fetchNativeKeysListFromMinimizedToken(JSONObject jSONObject, List<String> list) {
        if (list.isEmpty()) {
            list = TokenConstants.defaultNativeTokenKeysToInclude;
        }
        return getTokenParamsAccordingToKeysList(jSONObject, list);
    }

    /* access modifiers changed from: package-private */
    public String encryptToken(JSONObject jSONObject) {
        return IronSourceAES.encode(IronSourceUtils.KEY, jSONObject.toString());
    }

    /* access modifiers changed from: package-private */
    public JSONObject decodeAdmResponse(String str) {
        try {
            return new JSONObject(IronSourceAES.decode(IronSourceUtils.KEY, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public String enrichNotificationURL(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        return str.replace(AUCTION_PRICE_MACRO, str4).replace(AUCTION_LOSS_MACRO, str6).replace(AUCTION_MBR_MACRO, str5).replace(INSTANCE_NAME_MACRO, str2).replace(INSTANCE_TYPE_MACRO, Integer.toString(i)).replace(DYNAMIC_DEMAND_SOURCE_MACRO, str3).replace(PLACEMENT_NAME_MACRO, str7);
    }

    public String enrichNotificationURL(String str, int i, AuctionResponseItem auctionResponseItem, String str2, String str3, String str4) {
        String price = auctionResponseItem.getPrice();
        return enrichNotificationURL(str, auctionResponseItem.getInstanceName(), i, getInstance().getDynamicDemandSourceIdFromServerData(auctionResponseItem.getServerData()), price, getInstance().getBidRatio(price, str2), str3, str4);
    }

    /* access modifiers changed from: package-private */
    public void sendResponse(String str, String str2, String str3) {
        new ImpressionHttpTask(str, str2, str3).execute(str3);
    }

    public static class AuctionData {
        private String mAuctionId;
        private int mErrorCode;
        private String mErrorMessage;
        private AuctionResponseItem mGenericNotifications;
        private JSONObject mGenericParams;
        private List<AuctionResponseItem> mWaterfall;

        public String getAuctionId() {
            return this.mAuctionId;
        }

        public List<AuctionResponseItem> getWaterfall() {
            return this.mWaterfall;
        }

        public AuctionResponseItem getGenericNotifications() {
            return this.mGenericNotifications;
        }

        public JSONObject getGenericParams() {
            return this.mGenericParams;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public String getErrorMessage() {
            return this.mErrorMessage;
        }
    }

    static class ImpressionHttpTask extends AsyncTask<String, Void, Boolean> {
        private static final int SERVER_REQUEST_TIMEOUT = 15000;
        private String mInstanceName;
        private String mMethodName;
        private String mURL;

        public ImpressionHttpTask(String str, String str2, String str3) {
            this.mMethodName = str;
            this.mInstanceName = str2;
            this.mURL = str3;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_GET);
                httpURLConnection.setReadTimeout(SERVER_REQUEST_TIMEOUT);
                httpURLConnection.setConnectTimeout(SERVER_REQUEST_TIMEOUT);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                return Boolean.valueOf(responseCode == 200);
            } catch (Exception unused) {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
                    jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                    jSONObject.put(IronSourceConstants.EVENTS_EXT1, this.mMethodName + ";" + this.mInstanceName + ";" + this.mURL);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().log(new EventData(IronSourceConstants.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, jSONObject));
            }
        }
    }

    public Map<String, String> getAuctionResponseServerDataParams(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public String getAdmFromServerData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException unused) {
            return str;
        }
    }

    public String getDynamicDemandSourceIdFromServerData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            if (jSONObject2.has("dynamicDemandSource")) {
                return jSONObject2.getString("dynamicDemandSource");
            }
            return "";
        } catch (JSONException unused) {
            return "";
        }
    }

    private String getBidRatio(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double parseDouble = Double.parseDouble(str);
        double parseDouble2 = Double.parseDouble(str2);
        if (parseDouble2 == 0.0d) {
            return "";
        }
        double round = (double) Math.round((parseDouble / parseDouble2) * 1000.0d);
        Double.isNaN(round);
        return String.valueOf(round / 1000.0d);
    }
}
