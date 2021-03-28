package com.geektime.rnonesignalandroid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.onesignal.OSEmailSubscriptionState;
import com.onesignal.OSInAppMessageAction;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OSPermissionState;
import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OSSubscriptionState;
import com.onesignal.OneSignal;
import com.onesignal.OutcomeEvent;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RNOneSignal extends ReactContextBaseJavaModule implements LifecycleEventListener, OneSignal.NotificationReceivedHandler, OneSignal.NotificationOpenedHandler, OneSignal.InAppMessageClickHandler {
    public static final String HIDDEN_MESSAGE_KEY = "hidden";
    private OSNotificationOpenResult coldStartNotificationResult;
    private boolean hasSetInAppClickedHandler = false;
    private boolean hasSetNotificationOpenedHandler = false;
    private boolean hasSetRequiresPrivacyConsent = false;
    private OSInAppMessageAction inAppMessageActionResult;
    private ReactApplicationContext mReactApplicationContext;
    private ReactContext mReactContext;
    private boolean oneSignalInitDone;
    private Callback pendingGetTagsCallback;
    private boolean registeredEvents = false;
    private boolean waitingForUserPrivacyConsent = false;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "OneSignal";
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    public RNOneSignal(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        initOneSignal();
    }

    private String appIdFromManifest(ReactApplicationContext reactApplicationContext) {
        try {
            PackageManager packageManager = reactApplicationContext.getPackageManager();
            String packageName = reactApplicationContext.getPackageName();
            reactApplicationContext.getPackageManager();
            return packageManager.getApplicationInfo(packageName, 128).metaData.getString("onesignal_app_id");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void initOneSignal() {
        OneSignal.sdkType = "react";
        String appIdFromManifest = appIdFromManifest(this.mReactApplicationContext);
        if (appIdFromManifest != null && appIdFromManifest.length() > 0) {
            init(appIdFromManifest);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject jsonFromErrorMessageString(String str) throws JSONException {
        return new JSONObject().put("error", str);
    }

    @ReactMethod
    public void init(String str) {
        Context currentActivity = this.mReactApplicationContext.getCurrentActivity();
        if (this.oneSignalInitDone) {
            Log.e("onesignal", "Already initialized the OneSignal React-Native SDK");
            return;
        }
        this.oneSignalInitDone = true;
        OneSignal.sdkType = "react";
        if (currentActivity == null) {
            currentActivity = this.mReactApplicationContext.getApplicationContext();
        }
        OneSignal.getCurrentOrNewInitBuilder().setInAppMessageClickHandler(this);
        OneSignal.init(currentActivity, null, str, this, this);
        if (this.hasSetRequiresPrivacyConsent) {
            this.waitingForUserPrivacyConsent = true;
        }
    }

    @ReactMethod
    public void sendTag(String str, String str2) {
        OneSignal.sendTag(str, str2);
    }

    @ReactMethod
    public void sendTags(ReadableMap readableMap) {
        OneSignal.sendTags(RNUtils.readableMapToJson(readableMap));
    }

    @ReactMethod
    public void getTags(Callback callback) {
        if (this.pendingGetTagsCallback == null) {
            this.pendingGetTagsCallback = callback;
        }
        OneSignal.getTags(new OneSignal.GetTagsHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass1 */

            @Override // com.onesignal.OneSignal.GetTagsHandler
            public void tagsAvailable(JSONObject jSONObject) {
                if (RNOneSignal.this.pendingGetTagsCallback != null) {
                    RNOneSignal.this.pendingGetTagsCallback.invoke(RNUtils.jsonToWritableMap(jSONObject));
                }
                RNOneSignal.this.pendingGetTagsCallback = null;
            }
        });
    }

    @ReactMethod
    public void setEmail(String str, String str2, final Callback callback) {
        OneSignal.setEmail(str, str2, new OneSignal.EmailUpdateHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass2 */

            @Override // com.onesignal.OneSignal.EmailUpdateHandler
            public void onSuccess() {
                callback.invoke(new Object[0]);
            }

            @Override // com.onesignal.OneSignal.EmailUpdateHandler
            public void onFailure(OneSignal.EmailUpdateError emailUpdateError) {
                try {
                    callback.invoke(RNUtils.jsonToWritableMap(RNOneSignal.this.jsonFromErrorMessageString(emailUpdateError.getMessage())));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void logoutEmail(final Callback callback) {
        OneSignal.logoutEmail(new OneSignal.EmailUpdateHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass3 */

            @Override // com.onesignal.OneSignal.EmailUpdateHandler
            public void onSuccess() {
                callback.invoke(new Object[0]);
            }

            @Override // com.onesignal.OneSignal.EmailUpdateHandler
            public void onFailure(OneSignal.EmailUpdateError emailUpdateError) {
                try {
                    callback.invoke(RNUtils.jsonToWritableMap(RNOneSignal.this.jsonFromErrorMessageString(emailUpdateError.getMessage())));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void idsAvailable() {
        OneSignal.idsAvailable(new OneSignal.IdsAvailableHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass4 */

            @Override // com.onesignal.OneSignal.IdsAvailableHandler
            public void idsAvailable(String str, String str2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("userId", str);
                createMap.putString("pushToken", str2);
                RNOneSignal.this.sendEvent("OneSignal-idsAvailable", createMap);
            }
        });
    }

    @ReactMethod
    public void getPermissionSubscriptionState(Callback callback) {
        OSPermissionSubscriptionState permissionSubscriptionState = OneSignal.getPermissionSubscriptionState();
        if (permissionSubscriptionState != null) {
            OSPermissionState permissionStatus = permissionSubscriptionState.getPermissionStatus();
            OSSubscriptionState subscriptionStatus = permissionSubscriptionState.getSubscriptionStatus();
            OSEmailSubscriptionState emailSubscriptionStatus = permissionSubscriptionState.getEmailSubscriptionStatus();
            boolean enabled = permissionStatus.getEnabled();
            boolean subscribed = subscriptionStatus.getSubscribed();
            boolean userSubscriptionSetting = subscriptionStatus.getUserSubscriptionSetting();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("notificationsEnabled", enabled).put("subscriptionEnabled", subscribed).put("userSubscriptionEnabled", userSubscriptionSetting).put("pushToken", subscriptionStatus.getPushToken()).put("userId", subscriptionStatus.getUserId()).put("emailUserId", emailSubscriptionStatus.getEmailUserId()).put("emailAddress", emailSubscriptionStatus.getEmailAddress());
                Log.d("onesignal", "permission subscription state: " + jSONObject.toString());
                callback.invoke(RNUtils.jsonToWritableMap(jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @ReactMethod
    public void inFocusDisplaying(int i) {
        OneSignal.setInFocusDisplaying(i);
    }

    @ReactMethod
    public void deleteTag(String str) {
        OneSignal.deleteTag(str);
    }

    @ReactMethod
    public void enableVibrate(Boolean bool) {
        OneSignal.enableVibrate(bool.booleanValue());
    }

    @ReactMethod
    public void enableSound(Boolean bool) {
        OneSignal.enableSound(bool.booleanValue());
    }

    @ReactMethod
    public void setSubscription(Boolean bool) {
        OneSignal.setSubscription(bool.booleanValue());
    }

    @ReactMethod
    public void promptLocation() {
        OneSignal.promptLocation();
    }

    @ReactMethod
    public void syncHashedEmail(String str) {
        OneSignal.syncHashedEmail(str);
    }

    @ReactMethod
    public void setLogLevel(int i, int i2) {
        OneSignal.setLogLevel(i, i2);
    }

    @ReactMethod
    public void setLocationShared(Boolean bool) {
        OneSignal.setLocationShared(bool.booleanValue());
    }

    @ReactMethod
    public void postNotification(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("contents", new JSONObject(str));
            if (str3 != null) {
                jSONObject.put("include_player_ids", new JSONArray(str3));
            }
            if (str2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("p2p_notification", new JSONObject(str2));
                jSONObject.put("data", jSONObject2);
            }
            if (str4 != null && !str4.trim().isEmpty()) {
                JSONObject jSONObject3 = new JSONObject(str4.trim());
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject3.get(next));
                }
                if (jSONObject3.has("hidden") && jSONObject3.getBoolean("hidden")) {
                    jSONObject.getJSONObject("data").put("hidden", true);
                }
            }
            OneSignal.postNotification(jSONObject, new OneSignal.PostNotificationResponseHandler() {
                /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass5 */

                @Override // com.onesignal.OneSignal.PostNotificationResponseHandler
                public void onSuccess(JSONObject jSONObject) {
                    Log.i("OneSignal", "postNotification Success: " + jSONObject.toString());
                }

                @Override // com.onesignal.OneSignal.PostNotificationResponseHandler
                public void onFailure(JSONObject jSONObject) {
                    Log.e("OneSignal", "postNotification Failure: " + jSONObject.toString());
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void clearOneSignalNotifications() {
        OneSignal.clearOneSignalNotifications();
    }

    @ReactMethod
    public void cancelNotification(int i) {
        OneSignal.cancelNotification(i);
    }

    @ReactMethod
    public void setRequiresUserPrivacyConsent(Boolean bool) {
        OneSignal.setRequiresUserPrivacyConsent(bool.booleanValue());
    }

    @ReactMethod
    public void provideUserConsent(Boolean bool) {
        OneSignal.provideUserConsent(bool.booleanValue());
    }

    @ReactMethod
    public void userProvidedPrivacyConsent(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.userProvidedPrivacyConsent()));
    }

    @ReactMethod
    public void setExternalUserId(final String str, String str2, final Callback callback) {
        OneSignal.setExternalUserId(str, str2, new OneSignal.OSExternalUserIdUpdateCompletionHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass6 */

            @Override // com.onesignal.OneSignal.OSExternalUserIdUpdateCompletionHandler
            public void onComplete(JSONObject jSONObject) {
                Log.i("OneSignal", "Completed setting external user id: " + str + "with results: " + jSONObject.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(RNUtils.jsonToWritableMap(jSONObject));
                }
            }
        });
    }

    @ReactMethod
    public void removeExternalUserId(final Callback callback) {
        OneSignal.removeExternalUserId(new OneSignal.OSExternalUserIdUpdateCompletionHandler() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass7 */

            @Override // com.onesignal.OneSignal.OSExternalUserIdUpdateCompletionHandler
            public void onComplete(JSONObject jSONObject) {
                Log.i("OneSignal", "Completed removing external user id with results: " + jSONObject.toString());
                Callback callback = callback;
                if (callback != null) {
                    callback.invoke(RNUtils.jsonToWritableMap(jSONObject));
                }
            }
        });
    }

    @ReactMethod
    public void initNotificationOpenedHandlerParams() {
        this.hasSetNotificationOpenedHandler = true;
        OSNotificationOpenResult oSNotificationOpenResult = this.coldStartNotificationResult;
        if (oSNotificationOpenResult != null) {
            notificationOpened(oSNotificationOpenResult);
            this.coldStartNotificationResult = null;
        }
    }

    @Override // com.onesignal.OneSignal.NotificationReceivedHandler
    public void notificationReceived(OSNotification oSNotification) {
        sendEvent("OneSignal-remoteNotificationReceived", RNUtils.jsonToWritableMap(oSNotification.toJSONObject()));
    }

    @Override // com.onesignal.OneSignal.NotificationOpenedHandler
    public void notificationOpened(OSNotificationOpenResult oSNotificationOpenResult) {
        if (!this.hasSetNotificationOpenedHandler) {
            this.coldStartNotificationResult = oSNotificationOpenResult;
        } else {
            sendEvent("OneSignal-remoteNotificationOpened", RNUtils.jsonToWritableMap(oSNotificationOpenResult.toJSONObject()));
        }
    }

    @ReactMethod
    public void addTrigger(String str, Object obj) {
        OneSignal.addTrigger(str, obj);
    }

    @ReactMethod
    public void addTriggers(ReadableMap readableMap) {
        OneSignal.addTriggers(readableMap.toHashMap());
    }

    @ReactMethod
    public void removeTriggerForKey(String str) {
        OneSignal.removeTriggerForKey(str);
    }

    @ReactMethod
    public void removeTriggersForKeys(ReadableArray readableArray) {
        OneSignal.removeTriggersForKeys(RNUtils.convertReableArrayIntoStringCollection(readableArray));
    }

    @ReactMethod
    public void getTriggerValueForKey(String str, Promise promise) {
        promise.resolve(OneSignal.getTriggerValueForKey(str));
    }

    @ReactMethod
    public void pauseInAppMessages(Boolean bool) {
        OneSignal.pauseInAppMessages(bool.booleanValue());
    }

    @ReactMethod
    public void initInAppMessageClickHandlerParams() {
        this.hasSetInAppClickedHandler = true;
        OSInAppMessageAction oSInAppMessageAction = this.inAppMessageActionResult;
        if (oSInAppMessageAction != null) {
            inAppMessageClicked(oSInAppMessageAction);
            this.inAppMessageActionResult = null;
        }
    }

    @Override // com.onesignal.OneSignal.InAppMessageClickHandler
    public void inAppMessageClicked(OSInAppMessageAction oSInAppMessageAction) {
        if (!this.hasSetInAppClickedHandler) {
            this.inAppMessageActionResult = oSInAppMessageAction;
        } else {
            sendEvent("OneSignal-inAppMessageClicked", RNUtils.jsonToWritableMap(oSInAppMessageAction.toJSONObject()));
        }
    }

    @ReactMethod
    public void sendOutcome(final String str, final Callback callback) {
        OneSignal.sendOutcome(str, new OneSignal.OutcomeCallback() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass8 */

            @Override // com.onesignal.OneSignal.OutcomeCallback
            public void onSuccess(OutcomeEvent outcomeEvent) {
                if (outcomeEvent == null) {
                    callback.invoke(new WritableNativeMap());
                    return;
                }
                try {
                    callback.invoke(RNUtils.jsonToWritableMap(outcomeEvent.toJSONObject()));
                } catch (JSONException e) {
                    Log.e("OneSignal", "sendOutcome with name: " + str + ", failed with message: " + e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void sendUniqueOutcome(final String str, final Callback callback) {
        OneSignal.sendUniqueOutcome(str, new OneSignal.OutcomeCallback() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass9 */

            @Override // com.onesignal.OneSignal.OutcomeCallback
            public void onSuccess(OutcomeEvent outcomeEvent) {
                if (outcomeEvent == null) {
                    callback.invoke(new WritableNativeMap());
                    return;
                }
                try {
                    callback.invoke(RNUtils.jsonToWritableMap(outcomeEvent.toJSONObject()));
                } catch (JSONException e) {
                    Log.e("OneSignal", "sendUniqueOutcome with name: " + str + ", failed with message: " + e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void sendOutcomeWithValue(final String str, final float f, final Callback callback) {
        OneSignal.sendOutcomeWithValue(str, f, new OneSignal.OutcomeCallback() {
            /* class com.geektime.rnonesignalandroid.RNOneSignal.AnonymousClass10 */

            @Override // com.onesignal.OneSignal.OutcomeCallback
            public void onSuccess(OutcomeEvent outcomeEvent) {
                if (outcomeEvent == null) {
                    callback.invoke(new WritableNativeMap());
                    return;
                }
                try {
                    callback.invoke(RNUtils.jsonToWritableMap(outcomeEvent.toJSONObject()));
                } catch (JSONException e) {
                    Log.e("OneSignal", "sendOutcomeWithValue with name: " + str + " and value: " + f + ", failed with message: " + e.getMessage());
                }
            }
        });
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        initOneSignal();
    }
}
