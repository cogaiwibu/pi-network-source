package com.onesignal;

import com.onesignal.OneSignal;

/* access modifiers changed from: package-private */
public class OSInAppMessageLocationPrompt extends OSInAppMessagePrompt {
    static final String LOCATION_PROMPT_KEY = "location";

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.OSInAppMessagePrompt
    public String getPromptKey() {
        return "location";
    }

    OSInAppMessageLocationPrompt() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.OSInAppMessagePrompt
    public void handlePrompt(OneSignal.OSPromptActionCompletionCallback oSPromptActionCompletionCallback) {
        OneSignal.promptLocation(oSPromptActionCompletionCallback, true);
    }
}
