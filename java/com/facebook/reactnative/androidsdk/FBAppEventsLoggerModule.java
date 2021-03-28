package com.facebook.reactnative.androidsdk;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.math.BigDecimal;
import java.util.Currency;

@ReactModule(name = FBAppEventsLoggerModule.NAME)
public class FBAppEventsLoggerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppEventsLogger";
    private AppEventsLogger mAppEventLogger;
    private ReactApplicationContext mReactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public FBAppEventsLoggerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.mAppEventLogger = AppEventsLogger.newLogger(this.mReactContext);
    }

    @ReactMethod
    public void setFlushBehavior(String str) {
        AppEventsLogger.setFlushBehavior(AppEventsLogger.FlushBehavior.valueOf(str.toUpperCase()));
    }

    @ReactMethod
    public void logEvent(String str, double d, ReadableMap readableMap) {
        this.mAppEventLogger.logEvent(str, d, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPurchase(double d, String str, ReadableMap readableMap) {
        this.mAppEventLogger.logPurchase(BigDecimal.valueOf(d), Currency.getInstance(str), Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPushNotificationOpen(ReadableMap readableMap) {
        this.mAppEventLogger.logPushNotificationOpen(Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void setUserID(String str) {
        AppEventsLogger.setUserID(str);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getUserID() {
        return AppEventsLogger.getUserID();
    }

    @ReactMethod
    public void updateUserProperties(ReadableMap readableMap) {
        AppEventsLogger.updateUserProperties(Arguments.toBundle(readableMap), null);
    }

    private String getNullableString(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    @ReactMethod
    public void setUserData(ReadableMap readableMap) {
        AppEventsLogger.setUserData(getNullableString(readableMap, "email"), getNullableString(readableMap, "firstName"), getNullableString(readableMap, "lastName"), getNullableString(readableMap, "phone"), getNullableString(readableMap, "dateOfBirth"), getNullableString(readableMap, "gender"), getNullableString(readableMap, "city"), getNullableString(readableMap, "state"), getNullableString(readableMap, "zip"), getNullableString(readableMap, UserDataStore.COUNTRY));
    }

    @ReactMethod
    public void flush() {
        this.mAppEventLogger.flush();
    }

    @ReactMethod
    public void setPushNotificationsRegistrationId(String str) {
        AppEventsLogger.setPushNotificationsRegistrationId(str);
    }
}
