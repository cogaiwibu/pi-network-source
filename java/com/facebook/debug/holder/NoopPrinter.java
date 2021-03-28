package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public class NoopPrinter implements Printer {
    public static final NoopPrinter INSTANCE = new NoopPrinter();

    @Override // com.facebook.debug.holder.Printer
    public void logMessage(DebugOverlayTag debugOverlayTag, String str) {
    }

    @Override // com.facebook.debug.holder.Printer
    public void logMessage(DebugOverlayTag debugOverlayTag, String str, Object... objArr) {
    }

    @Override // com.facebook.debug.holder.Printer
    public boolean shouldDisplayLogMessage(DebugOverlayTag debugOverlayTag) {
        return false;
    }

    private NoopPrinter() {
    }
}
