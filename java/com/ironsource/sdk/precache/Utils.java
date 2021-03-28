package com.ironsource.sdk.precache;

class Utils {
    Utils() {
    }

    public static String convertErrorCodeToMessage(int i) {
        String str = "not defined message for " + i;
        if (i != 404) {
            if (i == 1018) {
                return Constants.FILE_NOT_FOUND_EXCEPTION;
            }
            if (i == 1019) {
                return Constants.OUT_OF_MEMORY_EXCEPTION;
            }
            switch (i) {
                case 1004:
                    return Constants.MALFORMED_URL_EXCEPTION;
                case 1005:
                    break;
                case 1006:
                    return Constants.HTTP_EMPTY_RESPONSE;
                default:
                    switch (i) {
                        case 1008:
                            return Constants.SOCKET_TIMEOUT_EXCEPTION;
                        case 1009:
                            return Constants.IO_EXCEPTION;
                        case 1010:
                            return Constants.URI_SYNTAX_EXCEPTION;
                        case 1011:
                            return Constants.HTTP_ERROR_CODE;
                        default:
                            return str;
                    }
            }
        }
        return Constants.HTTP_NOT_FOUND;
    }
}
