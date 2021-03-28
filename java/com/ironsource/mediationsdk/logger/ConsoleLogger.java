package com.ironsource.mediationsdk.logger;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.sdk.constants.Constants;

public class ConsoleLogger extends IronSourceLogger {
    public static final String CONSOLE_PREFIX = "ironSourceSDK: ";
    public static final String NAME = "console";

    private ConsoleLogger() {
        super(NAME);
    }

    public ConsoleLogger(int i) {
        super(NAME, i);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (i == 0) {
            Log.v(CONSOLE_PREFIX + ironSourceTag, str);
        } else if (i == 1) {
            Log.i(CONSOLE_PREFIX + ironSourceTag, str);
        } else if (i == 2) {
            Log.w(CONSOLE_PREFIX + ironSourceTag, str);
        } else if (i == 3) {
            Log.e(CONSOLE_PREFIX + ironSourceTag, str);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        log(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + Constants.RequestParameters.RIGHT_BRACKETS, 3);
    }
}
