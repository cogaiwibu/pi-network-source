package com.ironsource.mediationsdk.logger;

public class IronSourceError {
    public static final int AUCTION_ERROR_DECOMPRESSION = 1008;
    public static final int AUCTION_ERROR_DECRYPTION = 1003;
    public static final int AUCTION_ERROR_EMPTY_WATERFALL = 1004;
    public static final int AUCTION_ERROR_NO_CANDIDATES = 1005;
    public static final int AUCTION_ERROR_PARSE = 1002;
    public static final int AUCTION_ERROR_REQUEST = 1000;
    public static final int AUCTION_ERROR_RESPONSE_NOT_200 = 1001;
    public static final int AUCTION_ERROR_TIMED_OUT = 1006;
    public static final int AUCTION_REQUEST_ERROR_MISSING_PARAMS = 1007;
    public static final int ERROR_BN_INIT_FAILED_AFTER_LOAD = 602;
    public static final int ERROR_BN_INSTANCE_INIT_ERROR = 612;
    public static final int ERROR_BN_INSTANCE_INIT_TIMEOUT = 607;
    public static final int ERROR_BN_INSTANCE_LOAD_EMPTY_ADAPTER = 611;
    public static final int ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER = 610;
    public static final int ERROR_BN_INSTANCE_LOAD_TIMEOUT = 608;
    public static final int ERROR_BN_INSTANCE_RELOAD_TIMEOUT = 609;
    public static final int ERROR_BN_LOAD_AFTER_INIT_FAILED = 600;
    public static final int ERROR_BN_LOAD_AFTER_LONG_INITIATION = 601;
    public static final int ERROR_BN_LOAD_EXCEPTION = 605;
    public static final int ERROR_BN_LOAD_NO_CONFIG = 615;
    public static final int ERROR_BN_LOAD_NO_FILL = 606;
    public static final int ERROR_BN_LOAD_PLACEMENT_CAPPED = 604;
    public static final int ERROR_BN_LOAD_WHILE_LONG_INITIATION = 603;
    public static final int ERROR_BN_RELOAD_SKIP_BACKGROUND = 614;
    public static final int ERROR_BN_RELOAD_SKIP_INVISIBLE = 613;
    public static final int ERROR_BN_UNSUPPORTED_SIZE = 616;
    public static final int ERROR_CAPPED_PER_SESSION = 526;
    public static final int ERROR_CODE_DECRYPT_FAILED = 1;
    public static final int ERROR_CODE_GENERIC = 510;
    public static final int ERROR_CODE_INIT_FAILED = 508;
    public static final int ERROR_CODE_INVALID_KEY_VALUE = 506;
    public static final int ERROR_CODE_KEY_NOT_SET = 505;
    public static final int ERROR_CODE_NO_ADS_TO_SHOW = 509;
    public static final int ERROR_CODE_NO_CONFIGURATION_AVAILABLE = 501;
    public static final int ERROR_CODE_USING_CACHED_CONFIGURATION = 502;
    public static final int ERROR_DO_IS_CALL_LOAD_BEFORE_SHOW = 1051;
    public static final int ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS = 1050;
    public static final int ERROR_DO_IS_LOAD_MISSING_ACTIVITY = 1061;
    public static final int ERROR_DO_IS_LOAD_TIMED_OUT = 1052;
    public static final int ERROR_DO_RV_CALL_LOAD_BEFORE_SHOW = 1054;
    public static final int ERROR_DO_RV_LOAD_ALREADY_IN_PROGRESS = 1053;
    public static final int ERROR_DO_RV_LOAD_DURING_SHOW = 1056;
    public static final int ERROR_DO_RV_LOAD_MISSING_ACTIVITY = 1060;
    public static final int ERROR_DO_RV_LOAD_TIMED_OUT = 1055;
    public static final int ERROR_IS_EMPTY_DEFAULT_PLACEMENT = 1020;
    public static final int ERROR_IS_INIT_EXCEPTION = 1041;
    public static final int ERROR_IS_LOAD_DURING_SHOW = 1037;
    public static final int ERROR_IS_LOAD_FAILED_NO_CANDIDATES = 1035;
    public static final int ERROR_IS_LOAD_NO_FILL = 1158;
    public static final int ERROR_IS_SHOW_CALLED_DURING_SHOW = 1036;
    public static final int ERROR_IS_SHOW_EXCEPTION = 1039;
    public static final int ERROR_NON_EXISTENT_INSTANCE = 527;
    public static final int ERROR_NO_INTERNET_CONNECTION = 520;
    public static final int ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT = 524;
    public static final int ERROR_RV_EMPTY_DEFAULT_PLACEMENT = 1021;
    public static final int ERROR_RV_EXPIRED_ADS = 1057;
    public static final int ERROR_RV_INIT_EXCEPTION = 1040;
    public static final int ERROR_RV_INIT_FAILED_TIMEOUT = 1032;
    public static final int ERROR_RV_LOAD_DURING_LOAD = 1026;
    public static final int ERROR_RV_LOAD_DURING_SHOW = 1027;
    public static final int ERROR_RV_LOAD_FAILED_NO_CANDIDATES = 1024;
    public static final int ERROR_RV_LOAD_FAILED_TIMEOUT = 1025;
    public static final int ERROR_RV_LOAD_FAIL_DUE_TO_INIT = 1033;
    public static final int ERROR_RV_LOAD_FAIL_UNEXPECTED = 1030;
    public static final int ERROR_RV_LOAD_FAIL_WRONG_AUCTION_ID = 1031;
    public static final int ERROR_RV_LOAD_NO_FILL = 1058;
    public static final int ERROR_RV_LOAD_SUCCESS_UNEXPECTED = 1028;
    public static final int ERROR_RV_LOAD_SUCCESS_WRONG_AUCTION_ID = 1029;
    public static final int ERROR_RV_LOAD_UNEXPECTED_CALLBACK = 1034;
    public static final int ERROR_RV_SHOW_CALLED_DURING_SHOW = 1022;
    public static final int ERROR_RV_SHOW_CALLED_WRONG_STATE = 1023;
    public static final int ERROR_RV_SHOW_EXCEPTION = 1038;
    public static final int INIT_ERROR_NO_ADAPTERS_LOADED = 1010;
    private int mErrorCode;
    private String mErrorMsg;

    public IronSourceError(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMsg = str == null ? "" : str;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMsg;
    }

    public String toString() {
        return "errorCode:" + this.mErrorCode + ", errorMessage:" + this.mErrorMsg;
    }
}
