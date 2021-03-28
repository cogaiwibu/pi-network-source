package com.facebook.ads;

import android.text.TextUtils;
import java.util.Locale;

public class AdError {
    public static final AdError AD_ASSETS_UNSUPPORTED_TYPE_ERROR = new AdError(AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE, "unsupported type of ad assets");
    public static final int AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE = 6003;
    public static final AdError AD_PRESENTATION_ERROR = new AdError(AD_PRESENTATION_ERROR_CODE, "Ad could not be presented");
    public static final int AD_PRESENTATION_ERROR_CODE = 9001;
    public static final int API_NOT_SUPPORTED = 7006;
    public static final AdError BROKEN_MEDIA_ERROR = new AdError(2100, "Native ad failed to load its media");
    public static final int BROKEN_MEDIA_ERROR_CODE = 2100;
    public static final AdError CACHE_ERROR = new AdError(2002, "Cache Error");
    public static final int CACHE_ERROR_CODE = 2002;
    public static final int CLEAR_TEXT_SUPPORT_NOT_ALLOWED = 7003;
    public static final int ICONVIEW_MISSING_ERROR_CODE = 6002;
    public static final int INCORRECT_STATE_ERROR = 7004;
    public static final AdError INTERNAL_ERROR = new AdError(2001, "Internal Error");
    public static final int INTERNAL_ERROR_2003 = 2003;
    public static final int INTERNAL_ERROR_2004 = 2004;
    public static final int INTERNAL_ERROR_2006 = 2006;
    public static final int INTERNAL_ERROR_CODE = 2001;
    public static final int INTERSTITIAL_AD_TIMEOUT = 2009;
    public static final int LOAD_CALLED_WHILE_SHOWING_AD = 7002;
    public static final AdError LOAD_TOO_FREQUENTLY = new AdError(1002, "Ad was re-loaded too frequently");
    public static final int LOAD_TOO_FREQUENTLY_ERROR_CODE = 1002;
    public static final AdError MEDIATION_ERROR = new AdError(3001, "Mediation Error");
    public static final int MEDIATION_ERROR_CODE = 3001;
    public static final int MEDIAVIEW_MISSING_ERROR_CODE = 6001;
    public static final int MISSING_DEPENDENCIES_ERROR = 7005;
    @Deprecated
    public static final AdError MISSING_PROPERTIES = new AdError(2002, "Native ad failed to load due to missing properties");
    public static final int NATIVE_AD_IS_NOT_LOADED = 7007;
    public static final AdError NETWORK_ERROR = new AdError(1000, "Network Error");
    public static final int NETWORK_ERROR_CODE = 1000;
    public static final AdError NO_FILL = new AdError(1001, "No Fill");
    public static final int NO_FILL_ERROR_CODE = 1001;
    public static final int REMOTE_ADS_SERVICE_ERROR = 2008;
    public static final AdError SERVER_ERROR = new AdError(2000, "Server Error");
    public static final int SERVER_ERROR_CODE = 2000;
    public static final AdError SHOW_CALLED_BEFORE_LOAD_ERROR = new AdError(SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, "Ad not loaded. First call loadAd() and wait for onAdLoaded() to be invoked before executing show()");
    public static final int SHOW_CALLED_BEFORE_LOAD_ERROR_CODE = 7001;
    private final int errorCode;
    private final String errorMessage;

    public AdError(int i, String str) {
        str = TextUtils.isEmpty(str) ? "unknown error" : str;
        this.errorCode = i;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public static AdError internalError(int i) {
        return new AdError(i, String.format(Locale.US, "Internal error %d", Integer.valueOf(i)));
    }
}
