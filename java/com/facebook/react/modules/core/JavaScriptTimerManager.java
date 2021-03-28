package com.facebook.react.modules.core;

import com.facebook.react.bridge.WritableArray;

public interface JavaScriptTimerManager {
    void callIdleCallbacks(double d);

    void callTimers(WritableArray writableArray);

    void emitTimeDriftWarning(String str);
}
