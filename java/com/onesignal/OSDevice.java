package com.onesignal;

public class OSDevice {
    public boolean isNotificationEnabled() {
        return OneSignal.getPermissionSubscriptionState().permissionStatus.getEnabled();
    }

    public boolean isUserSubscribed() {
        return OneSignal.getPermissionSubscriptionState().subscriptionStatus.getUserSubscriptionSetting();
    }

    public boolean isSubscribed() {
        return OneSignal.getPermissionSubscriptionState().subscriptionStatus.getSubscribed();
    }

    public String getUserId() {
        return OneSignal.getPermissionSubscriptionState().subscriptionStatus.getUserId();
    }

    public String getPushToken() {
        return OneSignal.getPermissionSubscriptionState().subscriptionStatus.getPushToken();
    }

    public String getEmailUserId() {
        return OneSignal.getPermissionSubscriptionState().emailSubscriptionStatus.getEmailUserId();
    }

    public String getEmailAddress() {
        return OneSignal.getPermissionSubscriptionState().emailSubscriptionStatus.getEmailAddress();
    }
}
