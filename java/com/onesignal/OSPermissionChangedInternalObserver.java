package com.onesignal;

/* access modifiers changed from: package-private */
public class OSPermissionChangedInternalObserver {
    OSPermissionChangedInternalObserver() {
    }

    /* access modifiers changed from: package-private */
    public void changed(OSPermissionState oSPermissionState) {
        handleInternalChanges(oSPermissionState);
        fireChangesToPublicObserver(oSPermissionState);
    }

    static void handleInternalChanges(OSPermissionState oSPermissionState) {
        if (!oSPermissionState.getEnabled()) {
            BadgeCountUpdater.updateCount(0, OneSignal.appContext);
        }
        OneSignalStateSynchronizer.setPermission(OneSignal.areNotificationsEnabledForSubscribedState());
    }

    static void fireChangesToPublicObserver(OSPermissionState oSPermissionState) {
        OSPermissionStateChanges oSPermissionStateChanges = new OSPermissionStateChanges();
        oSPermissionStateChanges.from = OneSignal.lastPermissionState;
        oSPermissionStateChanges.to = (OSPermissionState) oSPermissionState.clone();
        if (OneSignal.getPermissionStateChangesObserver().notifyChange(oSPermissionStateChanges)) {
            OneSignal.lastPermissionState = (OSPermissionState) oSPermissionState.clone();
            OneSignal.lastPermissionState.persistAsFrom();
        }
    }
}
