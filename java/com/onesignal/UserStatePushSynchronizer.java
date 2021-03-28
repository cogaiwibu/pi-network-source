package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import com.onesignal.OneSignalStateSynchronizer;
import com.onesignal.UserStateSynchronizer;
import com.tapjoy.TapjoyConstants;
import io.invertase.firebase.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class UserStatePushSynchronizer extends UserStateSynchronizer {
    private static boolean serverSuccess;

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public void addOnSessionOrCreateExtras(JSONObject jSONObject) {
    }

    UserStatePushSynchronizer() {
        super(OneSignalStateSynchronizer.UserStateSynchronizerType.PUSH);
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public UserState newUserState(String str, boolean z) {
        return new UserStatePush(str, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public OneSignal.LOG_LEVEL getLogLevel() {
        return OneSignal.LOG_LEVEL.ERROR;
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public boolean getSubscribed() {
        return getToSyncUserState().isSubscribed();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public UserStateSynchronizer.GetTagsResult getTags(boolean z) {
        UserStateSynchronizer.GetTagsResult getTagsResult;
        if (z) {
            String userId = OneSignal.getUserId();
            String savedAppId = OneSignal.getSavedAppId();
            OneSignalRestClient.getSync("players/" + userId + "?app_id=" + savedAppId, new OneSignalRestClient.ResponseHandler() {
                /* class com.onesignal.UserStatePushSynchronizer.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                public void onSuccess(String str) {
                    boolean unused = UserStatePushSynchronizer.serverSuccess = true;
                    if (str == null || str.isEmpty()) {
                        str = BuildConfig.FIREBASE_JSON_RAW;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has(UserState.TAGS)) {
                            synchronized (UserStatePushSynchronizer.this.LOCK) {
                                JSONObject generateJsonDiff = UserStatePushSynchronizer.this.generateJsonDiff(UserStatePushSynchronizer.this.currentUserState.getSyncValues().optJSONObject(UserState.TAGS), UserStatePushSynchronizer.this.getToSyncUserState().getSyncValues().optJSONObject(UserState.TAGS), null, null);
                                UserStatePushSynchronizer.this.currentUserState.putOnSyncValues(UserState.TAGS, jSONObject.optJSONObject(UserState.TAGS));
                                UserStatePushSynchronizer.this.currentUserState.persistState();
                                UserStatePushSynchronizer.this.getToSyncUserState().mergeTags(jSONObject, generateJsonDiff);
                                UserStatePushSynchronizer.this.getToSyncUserState().persistState();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, "CACHE_KEY_GET_TAGS");
        }
        synchronized (this.LOCK) {
            getTagsResult = new UserStateSynchronizer.GetTagsResult(serverSuccess, JSONUtils.getJSONObjectWithoutBlankValues(this.toSyncUserState.getSyncValues(), UserState.TAGS));
        }
        return getTagsResult;
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public String getExternalId(boolean z) {
        String optString;
        synchronized (this.LOCK) {
            optString = this.toSyncUserState.getSyncValues().optString("external_user_id", null);
        }
        return optString;
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public void scheduleSyncToServer() {
        getNetworkHandlerThread(0).runNewJobDelayed();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public void updateState(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", jSONObject.optString("identifier", null));
            if (jSONObject.has(TapjoyConstants.TJC_DEVICE_TYPE_NAME)) {
                jSONObject2.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, jSONObject.optInt(TapjoyConstants.TJC_DEVICE_TYPE_NAME));
            }
            jSONObject2.putOpt("parent_player_id", jSONObject.optString("parent_player_id", null));
            getUserStateForModification().generateJsonDiffFromIntoSyncValued(jSONObject2, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject3.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject3.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            getUserStateForModification().generateJsonDiffFromIntoDependValues(jSONObject3, null);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void setEmail(String str, String str2) {
        try {
            UserState userStateForModification = getUserStateForModification();
            userStateForModification.putOnDependValues("email_auth_hash", str2);
            userStateForModification.generateJsonDiffFromIntoSyncValued(new JSONObject().put("email", str), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public void setSubscription(boolean z) {
        try {
            getUserStateForModification().putOnDependValues("userSubscribePref", Boolean.valueOf(z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.onesignal.UserStateSynchronizer
    public boolean getUserSubscribePreference() {
        return getToSyncUserState().getDependValues().optBoolean("userSubscribePref", true);
    }

    @Override // com.onesignal.UserStateSynchronizer
    public void setPermission(boolean z) {
        try {
            getUserStateForModification().putOnDependValues("androidPermission", Boolean.valueOf(z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public String getId() {
        return OneSignal.getUserId();
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public void updateIdDependents(String str) {
        OneSignal.updateUserIdDependents(str);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserStateSynchronizer
    public void logoutEmail() {
        try {
            getUserStateForModification().putOnDependValues("logoutEmail", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public void fireEventsForUpdateFailure(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            OneSignal.fireEmailUpdateFailure();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserStateSynchronizer
    public void onSuccessfulSync(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            OneSignal.fireEmailUpdateSuccess();
        }
        if (jSONObject.has("identifier")) {
            OneSignal.fireIdsAvailableCallback();
        }
    }
}
