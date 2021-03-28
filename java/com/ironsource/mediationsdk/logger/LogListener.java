package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;

public interface LogListener {
    void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i);
}
