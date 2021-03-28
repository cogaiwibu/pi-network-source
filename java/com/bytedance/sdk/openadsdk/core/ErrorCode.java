package com.bytedance.sdk.openadsdk.core;

public class ErrorCode {
    public static final int ADSLOT_EMPTY = 40004;
    public static final int ADSLOT_ID_ERROR = 40006;
    public static final int ADSLOT_SIZE_EMPTY = 40005;
    public static final int AD_DATA_ERROR = -4;
    public static final int APP_EMPTY = 40002;
    public static final int BANNER_AD_LOAD_IMAGE_ERROR = -5;
    public static final int CONTENT_TYPE = 40000;
    public static final int ERROR_ACCESS_METHOD_API_SDK = 40017;
    public static final int ERROR_ACCESS_METHOD_PASS = 40012;
    public static final int ERROR_ADTYPE_DIFFER = 40019;
    public static final int ERROR_AD_TYPE = 40011;
    public static final int ERROR_APK_SIGN_CHECK_ERROR = 40021;
    public static final int ERROR_CODE_ADCOUNT_ERROR = 40007;
    public static final int ERROR_CODE_CLICK_EVENT_ERROR = 60002;
    public static final int ERROR_IMAGE_SIZE = 40008;
    public static final int ERROR_MEDIA_ID = 40009;
    public static final int ERROR_MEDIA_TYPE = 40010;
    public static final int ERROR_NEW_REGISTER_LIMIT = 40020;
    public static final int ERROR_ORIGIN_AD_ERROR = 40022;
    public static final int ERROR_PACKAGE_NAME = 40018;
    public static final int ERROR_REDIRECT = 40014;
    public static final int ERROR_REQUEST_INVALID = 40015;
    public static final int ERROR_SLOT_ID_APP_ID_DIFFER = 40016;
    public static final int ERROR_SPLASH_AD_TYPE = 40013;
    public static final int ERROR_UNION_OS_ERROR = 40023;
    public static final int ERROR_UNION_SDK_TOO_OLD = 40024;
    public static final int ERROR_VERIFY_REWARD = 60007;
    public static final int FREQUENT_CALL_ERROE = -8;
    public static final int INSERT_AD_LOAD_IMAGE_ERROR = -6;
    public static final int NET_ERROR = -2;
    public static final int NO_AD = 20001;
    public static final int NO_AD_PARSE = -3;
    public static final int OK = 20000;
    public static final int PARSE_FAIL = -1;
    public static final int REQUEST_BODY_ERROR = -9;
    public static final int REQUEST_PB_ERROR = 40001;
    public static final int ROR_CODE_SHOW_EVENT_ERROR = 60001;
    public static final int SPLASH_AD_LOAD_IMAGE_ERROR = -7;
    public static final int SPLASH_CACHE_EXPIRED_ERROR = -11;
    public static final int SPLASH_CACHE_PARSE_ERROR = -10;
    public static final int SPLASH_NOT_HAVE_CACHE_ERROR = -12;
    public static final int SYS_ERROR = 50001;
    public static final int VD_ERR_LOST_PARAMS = -1;
    public static final int VD_ERR_RESULT_ERROR = -2;
    public static final int VD_ERR_RESULT_SUCCESS = -3;
    public static final int WAP_EMPTY = 40003;

    public static String message(int i) {
        if (i == 20001) {
            return "no ad";
        }
        if (i == 50001) {
            return "Server Error";
        }
        if (i == 60007) {
            return "Server abnormity or failure of rewarded video ad rewards ";
        }
        switch (i) {
            case SPLASH_NOT_HAVE_CACHE_ERROR /*{ENCODED_INT: -12}*/:
                return "No splash ad in the cache";
            case SPLASH_CACHE_EXPIRED_ERROR /*{ENCODED_INT: -11}*/:
                return "Cache expired";
            case SPLASH_CACHE_PARSE_ERROR /*{ENCODED_INT: -10}*/:
                return "Cache parsing failed";
            case REQUEST_BODY_ERROR /*{ENCODED_INT: -9}*/:
                return "Request entity is empty";
            case FREQUENT_CALL_ERROE /*{ENCODED_INT: -8}*/:
                return "Frequent request ";
            case SPLASH_AD_LOAD_IMAGE_ERROR /*{ENCODED_INT: -7}*/:
                return "Splash ad image failed to load";
            case INSERT_AD_LOAD_IMAGE_ERROR /*{ENCODED_INT: -6}*/:
                return "Interstitial ad image failed to load";
            case BANNER_AD_LOAD_IMAGE_ERROR /*{ENCODED_INT: -5}*/:
                return "bannerAd image failed to load";
            case -4:
                return "Return data is missing the necessary fields";
            case -3:
                return "Parsing data without ad";
            case -2:
                return "Network Error";
            case -1:
                return "Data parsing failed";
            default:
                switch (i) {
                    case CONTENT_TYPE /*{ENCODED_INT: 40000}*/:
                        return "http content type error";
                    case REQUEST_PB_ERROR /*{ENCODED_INT: 40001}*/:
                        return "http request pb error";
                    case APP_EMPTY /*{ENCODED_INT: 40002}*/:
                        return "request app can't be empty ";
                    case WAP_EMPTY /*{ENCODED_INT: 40003}*/:
                        return "request wap cannot be empty";
                    case ADSLOT_EMPTY /*{ENCODED_INT: 40004}*/:
                        return "Ad slot cannot be empty";
                    case ADSLOT_SIZE_EMPTY /*{ENCODED_INT: 40005}*/:
                        return "Ad slot size cannot be empty ";
                    case ADSLOT_ID_ERROR /*{ENCODED_INT: 40006}*/:
                        return "Illegal ad ID";
                    case ERROR_CODE_ADCOUNT_ERROR /*{ENCODED_INT: 40007}*/:
                        return "Incorrect number of ads ";
                    case ERROR_IMAGE_SIZE /*{ENCODED_INT: 40008}*/:
                        return "Image size error";
                    case ERROR_MEDIA_ID /*{ENCODED_INT: 40009}*/:
                        return "Media ID is illegal ";
                    case ERROR_MEDIA_TYPE /*{ENCODED_INT: 40010}*/:
                        return "Media type is illegal";
                    case ERROR_AD_TYPE /*{ENCODED_INT: 40011}*/:
                        return "Ad type is illegal ";
                    case ERROR_ACCESS_METHOD_PASS /*{ENCODED_INT: 40012}*/:
                    case ERROR_ACCESS_METHOD_API_SDK /*{ENCODED_INT: 40017}*/:
                        return "Media access type is not legal API/SDK";
                    case ERROR_SPLASH_AD_TYPE /*{ENCODED_INT: 40013}*/:
                        return "code bit id is less than 900 million, but adType is not splash ad";
                    case ERROR_REDIRECT /*{ENCODED_INT: 40014}*/:
                        return "The redirect parameter is incorrect";
                    case ERROR_REQUEST_INVALID /*{ENCODED_INT: 40015}*/:
                        return "Media rectification exceeds deadline, request illegal";
                    case ERROR_SLOT_ID_APP_ID_DIFFER /*{ENCODED_INT: 40016}*/:
                        return "The relationship between slot_id and app_id is invalid. ";
                    case ERROR_PACKAGE_NAME /*{ENCODED_INT: 40018}*/:
                        return "Media package name is inconsistent with entry";
                    case ERROR_ADTYPE_DIFFER /*{ENCODED_INT: 40019}*/:
                        return " Media configuration ad type is inconsistent with request";
                    case ERROR_NEW_REGISTER_LIMIT /*{ENCODED_INT: 40020}*/:
                        return "The ad space registered by developers exceeds daily request limit";
                    case ERROR_APK_SIGN_CHECK_ERROR /*{ENCODED_INT: 40021}*/:
                        return "Apk signature sha1 value is inconsistent with media platform entry";
                    case ERROR_ORIGIN_AD_ERROR /*{ENCODED_INT: 40022}*/:
                        return " Whether the media request material is inconsistent with the media platform entry";
                    case ERROR_UNION_OS_ERROR /*{ENCODED_INT: 40023}*/:
                        return "the value of param os is wrong";
                    case ERROR_UNION_SDK_TOO_OLD /*{ENCODED_INT: 40024}*/:
                        return "the version of sdk is too old";
                    default:
                        switch (i) {
                            case ROR_CODE_SHOW_EVENT_ERROR /*{ENCODED_INT: 60001}*/:
                                return "Show event processing error";
                            case ERROR_CODE_CLICK_EVENT_ERROR /*{ENCODED_INT: 60002}*/:
                                return "Click event processing error";
                            default:
                                return "unKnow error";
                        }
                }
        }
    }
}
