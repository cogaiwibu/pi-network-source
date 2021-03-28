package com.onesignal;

import com.onesignal.OneSignal;

/* access modifiers changed from: package-private */
public abstract class OSInAppMessagePrompt {
    private boolean prompted = false;

    /* access modifiers changed from: package-private */
    public abstract String getPromptKey();

    /* access modifiers changed from: package-private */
    public abstract void handlePrompt(OneSignal.OSPromptActionCompletionCallback oSPromptActionCompletionCallback);

    OSInAppMessagePrompt() {
    }

    /* access modifiers changed from: package-private */
    public boolean hasPrompted() {
        return this.prompted;
    }

    /* access modifiers changed from: package-private */
    public void setPrompted(boolean z) {
        this.prompted = z;
    }

    public String toString() {
        return "OSInAppMessagePrompt{key=" + getPromptKey() + " prompted=" + this.prompted + '}';
    }
}
