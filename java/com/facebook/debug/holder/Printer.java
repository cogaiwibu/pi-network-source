package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public interface Printer {
    void logMessage(DebugOverlayTag debugOverlayTag, String str);

    void logMessage(DebugOverlayTag debugOverlayTag, String str, Object... objArr);

    boolean shouldDisplayLogMessage(DebugOverlayTag debugOverlayTag);
}
