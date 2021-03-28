package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

/* access modifiers changed from: package-private */
public class SecureMessagingInterface {
    private boolean hasTokenBeenRequested = false;
    private SecureMessagingService mSecureMessagingService;

    SecureMessagingInterface(SecureMessagingService secureMessagingService) {
        this.mSecureMessagingService = secureMessagingService;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.hasTokenBeenRequested) {
            return "";
        }
        this.hasTokenBeenRequested = true;
        return this.mSecureMessagingService.getTokenForMessaging();
    }
}
