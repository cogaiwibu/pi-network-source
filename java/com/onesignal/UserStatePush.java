package com.onesignal;

import org.json.JSONException;

class UserStatePush extends UserState {
    UserStatePush(String str, boolean z) {
        super(str, z);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserState
    public UserState newInstance(String str) {
        return new UserStatePush(str, false);
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserState
    public void addDependFields() {
        try {
            putOnSyncValues("notification_types", Integer.valueOf(getNotificationTypes()));
        } catch (JSONException unused) {
        }
    }

    private int getNotificationTypes() {
        int optInt = getDependValues().optInt("subscribableStatus", 1);
        if (optInt < -2) {
            return optInt;
        }
        if (!getDependValues().optBoolean("androidPermission", true)) {
            return 0;
        }
        return !getDependValues().optBoolean("userSubscribePref", true) ? -2 : 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserState
    public boolean isSubscribed() {
        return getNotificationTypes() > 0;
    }
}
