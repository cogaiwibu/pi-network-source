package com.ironsource.sdk.controller;

/* access modifiers changed from: package-private */
public interface ControllerEventListener {
    void handleControllerFailed(String str);

    void handleControllerLoaded();

    void handleControllerReady();
}
