package com.facebook.react.modules.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.ironsource.sdk.constants.Constants;

public class AsyncStorageErrorUtil {
    static WritableMap getError(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", str2);
        if (str != null) {
            createMap.putString(Constants.ParametersKeys.KEY, str);
        }
        return createMap;
    }

    static WritableMap getInvalidKeyError(String str) {
        return getError(str, "Invalid key");
    }

    static WritableMap getInvalidValueError(String str) {
        return getError(str, "Invalid Value");
    }

    static WritableMap getDBError(String str) {
        return getError(str, "Database Error");
    }
}
