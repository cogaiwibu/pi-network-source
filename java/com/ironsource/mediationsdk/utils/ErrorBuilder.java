package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;

public class ErrorBuilder {
    public static IronSourceError buildNoConfigurationAvailableError(String str) {
        return new IronSourceError(IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE, "" + str + " Init Fail - Unable to retrieve configurations from the server");
    }

    public static IronSourceError buildInvalidConfigurationError(String str) {
        return new IronSourceError(IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE, "" + str + " Init Fail - Configurations from the server are not valid");
    }

    public static IronSourceError buildUsingCachedConfigurationError(String str, String str2) {
        return new IronSourceError(IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION, "Mediation - Unable to retrieve configurations from IronSource server, using cached configurations with appKey:" + str + " and userId:" + str2);
    }

    public static IronSourceError buildKeyNotSetError(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return getGenericErrorForMissingParams();
        }
        return new IronSourceError(IronSourceError.ERROR_CODE_KEY_NOT_SET, str3 + " Mediation - " + str + " is not set for " + str2);
    }

    public static IronSourceError buildInvalidKeyValueError(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return getGenericErrorForMissingParams();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mediation - ");
        sb.append(str);
        sb.append(" value is not valid for ");
        sb.append(str2);
        if (!TextUtils.isEmpty(str3)) {
            str4 = " - " + str3;
        } else {
            str4 = "";
        }
        sb.append(str4);
        return new IronSourceError(IronSourceError.ERROR_CODE_INVALID_KEY_VALUE, sb.toString());
    }

    public static IronSourceError buildInvalidCredentialsError(String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("Init Fail - ");
        sb.append(str);
        sb.append(" value ");
        sb.append(str2);
        sb.append(" is not valid");
        if (!TextUtils.isEmpty(str3)) {
            str4 = " - " + str3;
        } else {
            str4 = "";
        }
        sb.append(str4);
        return new IronSourceError(IronSourceError.ERROR_CODE_INVALID_KEY_VALUE, sb.toString());
    }

    public static IronSourceError buildInitFailedError(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = str2 + " init failed due to an unknown error";
        } else {
            str3 = str2 + " - " + str;
        }
        return new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, str3);
    }

    public static IronSourceError buildNoAdsToShowError(String str) {
        return new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, str + " Show Fail - No ads to show");
    }

    public static IronSourceError buildShowFailedError(String str, String str2) {
        return new IronSourceError(IronSourceError.ERROR_CODE_NO_ADS_TO_SHOW, str + " Show Fail - " + str2);
    }

    public static IronSourceError buildLoadFailedError(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append(str4);
        sb.append(str);
        sb.append(" Load Fail");
        if (!TextUtils.isEmpty(str2)) {
            str4 = " " + str2;
        }
        sb.append(str4);
        sb.append(" - ");
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(str3)) {
            str3 = "unknown error";
        }
        return new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, sb2 + str3);
    }

    public static IronSourceError buildGenericError(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "An error occurred";
        }
        return new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, str);
    }

    public static IronSourceError buildNoInternetConnectionInitFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, "" + str + " Init Fail - No Internet connection");
    }

    public static IronSourceError buildNoInternetConnectionLoadFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, "" + str + " Load Fail - No Internet connection");
    }

    public static IronSourceError buildNoInternetConnectionShowFailError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NO_INTERNET_CONNECTION, "" + str + " Show Fail - No Internet connection");
    }

    public static IronSourceError buildCappedPerPlacementError(String str) {
        return new IronSourceError(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, str);
    }

    public static IronSourceError buildCappedPerSessionError(String str) {
        return new IronSourceError(IronSourceError.ERROR_CAPPED_PER_SESSION, str + " Show Fail - Networks have reached their cap per session");
    }

    public static IronSourceError buildNonExistentInstanceError(String str) {
        return new IronSourceError(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, str + " The requested instance does not exist");
    }

    private static IronSourceError getGenericErrorForMissingParams() {
        return buildGenericError("Mediation - wrong configuration");
    }

    public static IronSourceError buildLoadFailedError(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "Load failed due to an unknown error";
        } else {
            str2 = "Load failed - " + str;
        }
        return new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, str2);
    }

    public static IronSourceError unsupportedBannerSize(String str) {
        return new IronSourceError(IronSourceError.ERROR_BN_UNSUPPORTED_SIZE, str + " unsupported banner size");
    }
}
