package co.squaretwo.ironsource;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.ironsource.mediationsdk.logger.IronSourceError;
import javax.annotation.Nullable;

final class Utility {
    Utility() {
    }

    static WritableMap formatIronSourceError(IronSourceError ironSourceError, @Nullable String str) {
        WritableMap createMap = Arguments.createMap();
        String valueOf = String.valueOf(ironSourceError.getErrorCode());
        if (str == null) {
            str = ironSourceError.getErrorMessage();
        }
        createMap.putString(valueOf, str);
        return createMap;
    }

    static WritableMap formatIronSourceError(IronSourceError ironSourceError) {
        return formatIronSourceError(ironSourceError, null);
    }
}
