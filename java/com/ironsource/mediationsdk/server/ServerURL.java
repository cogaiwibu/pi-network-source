package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.mediationsdk.IronsourceObjectPublisherDataHolder;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.metadata.MetaDataConstants;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static String BASE_URL_PREFIX = "https://init.supersonicads.com/sdk/v";
    private static String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String IMPRESSION = "impression";
    private static final String MEDIATION_TYPE = "mt";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";

    public static String getCPVProvidersURL(Context context, String str, String str2, String str3, String str4, Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Vector vector2 = new Vector();
        vector2.add(new Pair("platform", "android"));
        vector2.add(new Pair("applicationKey", str));
        vector2.add(new Pair("applicationUserId", str2));
        vector2.add(new Pair("sdkVersion", IronSourceUtils.getSDKVersion()));
        if (IronSourceUtils.getSerr() == 0) {
            vector2.add(new Pair(SERR, String.valueOf(IronSourceUtils.getSerr())));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            vector2.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            vector2.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            vector2.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            vector2.add(new Pair("advId", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            vector2.add(new Pair(MEDIATION_TYPE, str4));
        }
        String publisherApplicationVersion = ApplicationContext.getPublisherApplicationVersion(context, context.getPackageName());
        if (!TextUtils.isEmpty(publisherApplicationVersion)) {
            vector2.add(new Pair(APPLICATION_VERSION, publisherApplicationVersion));
        }
        vector2.add(new Pair(OS_VERSION, Build.VERSION.SDK_INT + ""));
        vector2.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        vector2.add(new Pair(DEVICE_MODEL, Build.MODEL));
        vector2.add(new Pair(FIRST_SESSION, (IronSourceUtils.getFirstSession(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> mediationMetaData = IronsourceObjectPublisherDataHolder.getInstance().getMediationMetaData();
        if (mediationMetaData.containsKey(MetaDataConstants.META_DATA_COPPA_KEY)) {
            vector2.add(new Pair(COPPA, mediationMetaData.get(MetaDataConstants.META_DATA_COPPA_KEY).get(0)));
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            vector2.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        if (vector != null) {
            vector2.addAll(vector);
        }
        String browserUserAgent = IronSourceUtils.getInstance().getBrowserUserAgent();
        if (browserUserAgent.length() != 0) {
            vector2.add(new Pair(BROWSER_USER_AGENT, browserUserAgent));
        }
        String str5 = null;
        try {
            str5 = DeviceStatus.getDeviceLanguage(context) + "-" + DeviceStatus.getDeviceLocalCountry(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(str5 == null || str5.length() == 0)) {
            vector2.add(new Pair(DEVICE_LANG, str5));
        }
        if (context != null) {
            vector2.add(new Pair("bundleId", context.getPackageName()));
        }
        return getBaseUrl(IronSourceUtils.getSDKVersion()) + URLEncoder.encode(IronSourceAES.encode(IronSourceUtils.KEY, createURLParams(vector2)), "UTF-8");
    }

    public static String getRequestURL(String str, boolean z, int i) throws UnsupportedEncodingException {
        Vector vector = new Vector();
        vector.add(new Pair(IMPRESSION, Boolean.toString(z)));
        vector.add(new Pair("placementId", Integer.toString(i)));
        String createURLParams = createURLParams(vector);
        return str + "&" + createURLParams;
    }

    private static String createURLParams(Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Iterator<Pair<String, String>> it = vector.iterator();
        String str = "";
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) next.first) + "=" + URLEncoder.encode((String) next.second, "UTF-8");
        }
        return str;
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }
}
