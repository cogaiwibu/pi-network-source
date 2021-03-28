package com.onesignal;

/* access modifiers changed from: package-private */
public class OSEmailSubscriptionChangedInternalObserver {
    OSEmailSubscriptionChangedInternalObserver() {
    }

    /* access modifiers changed from: package-private */
    public void changed(OSEmailSubscriptionState oSEmailSubscriptionState) {
        fireChangesToPublicObserver(oSEmailSubscriptionState);
    }

    static void fireChangesToPublicObserver(OSEmailSubscriptionState oSEmailSubscriptionState) {
        OSEmailSubscriptionStateChanges oSEmailSubscriptionStateChanges = new OSEmailSubscriptionStateChanges();
        oSEmailSubscriptionStateChanges.from = OneSignal.lastEmailSubscriptionState;
        oSEmailSubscriptionStateChanges.to = (OSEmailSubscriptionState) oSEmailSubscriptionState.clone();
        if (OneSignal.getEmailSubscriptionStateChangesObserver().notifyChange(oSEmailSubscriptionStateChanges)) {
            OneSignal.lastEmailSubscriptionState = (OSEmailSubscriptionState) oSEmailSubscriptionState.clone();
            OneSignal.lastEmailSubscriptionState.persistAsFrom();
        }
    }
}
