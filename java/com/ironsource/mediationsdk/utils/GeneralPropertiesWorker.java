package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.environment.TokenConstants;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.GeneralProperties;
import com.ironsource.sdk.constants.Constants;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class GeneralPropertiesWorker implements Runnable {
    private static final int MAX_MINUTES_OFFSET = 840;
    private static final int MINUTES_OFFSET_STEP = 15;
    private static final int MIN_MINUTES_OFFSET = -720;
    public static final String SDK_VERSION = "sdkVersion";
    private final String ADVERTISING_ID = TokenConstants.ADVERTISING_ID;
    private final String ADVERTISING_ID_IS_LIMIT_TRACKING = "isLimitAdTrackingEnabled";
    private final String ADVERTISING_ID_TYPE = "advertisingIdType";
    private final String ANDROID_OS_VERSION = "osVersion";
    private final String APPLICATION_KEY = "appKey";
    private final String BATTERY_LEVEL = "battery";
    private final String BUNDLE_ID = "bundleId";
    private final String CONNECTION_TYPE = "connectionType";
    private final String DEVICE_MODEL = "deviceModel";
    private final String DEVICE_OEM = "deviceOEM";
    private final String DEVICE_OS = TokenConstants.DEVICE_OS;
    private final String EXTERNAL_FREE_MEMORY = "externalFreeMemory";
    private final String FIRST_SESSION = "firstSession";
    private final String GMT_MINUTES_OFFSET = "gmtMinutesOffset";
    private final String INTERNAL_FREE_MEMORY = "internalFreeMemory";
    private final String KEY_IS_ROOT = "jb";
    private final String KEY_PLUGIN_FW_VERSION = "plugin_fw_v";
    private final String KEY_PLUGIN_TYPE = "pluginType";
    private final String KEY_PLUGIN_VERSION = "pluginVersion";
    private final String KEY_SESSION_ID = TokenConstants.SESSION_ID;
    private final String LANGUAGE = "language";
    private final String MEDIATION_TYPE = "mt";
    private final String MOBILE_CARRIER = "mobileCarrier";
    private final String PUBLISHER_APP_VERSION = "appVersion";
    private final String TAG = getClass().getSimpleName();
    private Context mContext;

    private String getDeviceOS() {
        return Constants.JAVASCRIPT_INTERFACE_NAME;
    }

    private GeneralPropertiesWorker() {
    }

    public GeneralPropertiesWorker(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void run() {
        try {
            GeneralProperties.getProperties().putKeys(collectInformation());
            IronSourceUtils.saveGeneralProperties(this.mContext, GeneralProperties.getProperties().toJSON());
        } catch (Exception e) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "Thread name = " + getClass().getSimpleName(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x019c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> collectInformation() {
        /*
        // Method dump skipped, instructions count: 418
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.GeneralPropertiesWorker.collectInformation():java.util.Map");
    }

    private String getPluginType() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e);
            return "";
        }
    }

    private String getPluginVersion() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e);
            return "";
        }
    }

    private String getPluginFrameworkVersion() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e);
            return "";
        }
    }

    private String getBundleId() {
        try {
            return this.mContext.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private String getApplicationKey() {
        return IronSourceObject.getInstance().getIronSourceAppKey();
    }

    private String getAndroidVersion() {
        try {
            String str = Build.VERSION.RELEASE;
            int i = Build.VERSION.SDK_INT;
            return "" + i + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private String getSDKVersion() {
        return IronSourceUtils.getSDKVersion();
    }

    private String getLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private String getDeviceOEM() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private String getDeviceModel() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String getMobileCarrier() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (!networkOperatorName.equals("")) {
                return networkOperatorName;
            }
            return "";
        } catch (Exception e) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.TAG + ":getMobileCarrier()", e);
            return "";
        }
    }

    private boolean isExternalStorageAbvailable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    private long getInternalStorageFreeSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception unused) {
            return -1;
        }
    }

    private long getExternalStorageFreeSize() {
        if (!isExternalStorageAbvailable()) {
            return -1;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private int getBatteryLevel() {
        try {
            Intent registerReceiver = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i)) * 100.0f);
        } catch (Exception e) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.TAG + ":getBatteryLevel()", e);
            return -1;
        }
    }

    private int getGmtMinutesOffset() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round((float) (((timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15)) * 15;
        } catch (Exception e) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.TAG + ":getGmtMinutesOffset()", e);
            return 0;
        }
    }

    private boolean validateGmtMinutesOffset(int i) {
        return i <= MAX_MINUTES_OFFSET && i >= MIN_MINUTES_OFFSET && i % 15 == 0;
    }

    private String getMediationType() {
        return IronSourceObject.getInstance().getMediationType();
    }
}
