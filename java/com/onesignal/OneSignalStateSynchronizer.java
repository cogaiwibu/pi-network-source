package com.onesignal;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.onesignal.LocationController;
import com.onesignal.OneSignal;
import com.onesignal.UserStateSynchronizer;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OneSignalStateSynchronizer {
    private static HashMap<UserStateSynchronizerType, UserStateSynchronizer> userStateSynchronizers = new HashMap<>();

    OneSignalStateSynchronizer() {
    }

    /* access modifiers changed from: package-private */
    public enum UserStateSynchronizerType {
        PUSH,
        EMAIL;

        public boolean isPush() {
            return equals(PUSH);
        }

        public boolean isEmail() {
            return equals(EMAIL);
        }
    }

    static UserStatePushSynchronizer getPushStateSynchronizer() {
        if (!userStateSynchronizers.containsKey(UserStateSynchronizerType.PUSH) || userStateSynchronizers.get(UserStateSynchronizerType.PUSH) == null) {
            userStateSynchronizers.put(UserStateSynchronizerType.PUSH, new UserStatePushSynchronizer());
        }
        return (UserStatePushSynchronizer) userStateSynchronizers.get(UserStateSynchronizerType.PUSH);
    }

    static UserStateEmailSynchronizer getEmailStateSynchronizer() {
        if (!userStateSynchronizers.containsKey(UserStateSynchronizerType.EMAIL) || userStateSynchronizers.get(UserStateSynchronizerType.EMAIL) == null) {
            userStateSynchronizers.put(UserStateSynchronizerType.EMAIL, new UserStateEmailSynchronizer());
        }
        return (UserStateEmailSynchronizer) userStateSynchronizers.get(UserStateSynchronizerType.EMAIL);
    }

    static boolean persist() {
        boolean persist = getPushStateSynchronizer().persist();
        boolean persist2 = getEmailStateSynchronizer().persist();
        if (persist2) {
            persist2 = getEmailStateSynchronizer().getRegistrationId() != null;
        }
        if (persist || persist2) {
            return true;
        }
        return false;
    }

    static void clearLocation() {
        getPushStateSynchronizer().clearLocation();
        getEmailStateSynchronizer().clearLocation();
    }

    static void initUserState() {
        getPushStateSynchronizer().initUserState();
        getEmailStateSynchronizer().initUserState();
    }

    static void syncUserState(boolean z) {
        getPushStateSynchronizer().syncUserState(z);
        getEmailStateSynchronizer().syncUserState(z);
    }

    static void sendTags(JSONObject jSONObject, OneSignal.ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        try {
            JSONObject put = new JSONObject().put(UserState.TAGS, jSONObject);
            getPushStateSynchronizer().sendTags(put, changeTagsUpdateHandler);
            getEmailStateSynchronizer().sendTags(put, changeTagsUpdateHandler);
        } catch (JSONException e) {
            if (changeTagsUpdateHandler != null) {
                changeTagsUpdateHandler.onFailure(new OneSignal.SendTagsError(-1, "Encountered an error attempting to serialize your tags into JSON: " + e.getMessage() + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + e.getStackTrace()));
            }
            e.printStackTrace();
        }
    }

    static void syncHashedEmail(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("em_m", OSUtils.hexDigest(str, "MD5"));
            jSONObject.put("em_s", OSUtils.hexDigest(str, "SHA-1"));
            getPushStateSynchronizer().syncHashedEmail(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void setEmail(String str, String str2) {
        getPushStateSynchronizer().setEmail(str, str2);
        getEmailStateSynchronizer().setEmail(str, str2);
    }

    static void setSubscription(boolean z) {
        getPushStateSynchronizer().setSubscription(z);
    }

    static boolean getUserSubscribePreference() {
        return getPushStateSynchronizer().getUserSubscribePreference();
    }

    static void setPermission(boolean z) {
        getPushStateSynchronizer().setPermission(z);
    }

    static void updateLocation(LocationController.LocationPoint locationPoint) {
        getPushStateSynchronizer().updateLocation(locationPoint);
        getEmailStateSynchronizer().updateLocation(locationPoint);
    }

    static boolean getSubscribed() {
        return getPushStateSynchronizer().getSubscribed();
    }

    static String getRegistrationId() {
        return getPushStateSynchronizer().getRegistrationId();
    }

    static UserStateSynchronizer.GetTagsResult getTags(boolean z) {
        return getPushStateSynchronizer().getTags(z);
    }

    static void resetCurrentState() {
        getPushStateSynchronizer().resetCurrentState();
        getEmailStateSynchronizer().resetCurrentState();
        OneSignal.saveUserId(null);
        OneSignal.saveEmailId(null);
        OneSignal.setLastSessionTime(-3660);
    }

    static void updateDeviceInfo(JSONObject jSONObject) {
        getPushStateSynchronizer().updateDeviceInfo(jSONObject);
        getEmailStateSynchronizer().updateDeviceInfo(jSONObject);
    }

    static void updatePushState(JSONObject jSONObject) {
        getPushStateSynchronizer().updateState(jSONObject);
    }

    static void refreshEmailState() {
        getEmailStateSynchronizer().refresh();
    }

    static void setNewSession() {
        getPushStateSynchronizer().setNewSession();
        getEmailStateSynchronizer().setNewSession();
    }

    static boolean getSyncAsNewSession() {
        return getPushStateSynchronizer().getSyncAsNewSession() || getEmailStateSynchronizer().getSyncAsNewSession();
    }

    static void setNewSessionForEmail() {
        getEmailStateSynchronizer().setNewSession();
    }

    static void logoutEmail() {
        getPushStateSynchronizer().logoutEmail();
        getEmailStateSynchronizer().logoutEmail();
    }

    static void setExternalUserId(String str, String str2, final OneSignal.OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        AnonymousClass1 r1 = new OneSignal.OSInternalExternalUserIdUpdateCompletionHandler() {
            /* class com.onesignal.OneSignalStateSynchronizer.AnonymousClass1 */

            @Override // com.onesignal.OneSignal.OSInternalExternalUserIdUpdateCompletionHandler
            public void onComplete(String str, boolean z) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
                OneSignal.onesignalLog(log_level, "Completed request to update external user id for channel: " + str + " and success: " + z);
                try {
                    jSONObject.put(str, new JSONObject().put("success", z));
                } catch (JSONException e) {
                    OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.ERROR;
                    OneSignal.onesignalLog(log_level2, "Error while adding the success status of external id for channel: " + str);
                    e.printStackTrace();
                }
                for (UserStateSynchronizer userStateSynchronizer : OneSignalStateSynchronizer.userStateSynchronizers.values()) {
                    if (userStateSynchronizer.hasQueuedHandlers()) {
                        OneSignal.LOG_LEVEL log_level3 = OneSignal.LOG_LEVEL.VERBOSE;
                        OneSignal.onesignalLog(log_level3, "External user id handlers are still being processed for channel: " + userStateSynchronizer.getChannelString() + " , wait until finished before proceeding");
                        return;
                    }
                }
                OSUtils.runOnMainUIThread(new Runnable() {
                    /* class com.onesignal.OneSignalStateSynchronizer.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        if (oSExternalUserIdUpdateCompletionHandler != null) {
                            oSExternalUserIdUpdateCompletionHandler.onComplete(jSONObject);
                        }
                    }
                });
            }
        };
        getPushStateSynchronizer().setExternalUserId(str, str2, r1);
        if (OneSignal.hasEmailId()) {
            getEmailStateSynchronizer().setExternalUserId(str, str2, r1);
        }
    }

    static void readyToUpdate(boolean z) {
        getPushStateSynchronizer().readyToUpdate(z);
        getEmailStateSynchronizer().readyToUpdate(z);
    }
}
