package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativePushNotificationManagerIOSSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    @ReactMethod
    public abstract void abandonPermissions();

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void cancelAllLocalNotifications();

    @ReactMethod
    public abstract void cancelLocalNotifications(ReadableMap readableMap);

    @ReactMethod
    public abstract void checkPermissions(Callback callback);

    @ReactMethod
    public abstract void getApplicationIconBadgeNumber(Callback callback);

    @ReactMethod
    public abstract void getDeliveredNotifications(Callback callback);

    @ReactMethod
    public abstract void getInitialNotification(Promise promise);

    @ReactMethod
    public abstract void getScheduledLocalNotifications(Callback callback);

    @ReactMethod
    public abstract void onFinishRemoteNotification(String str, String str2);

    @ReactMethod
    public abstract void presentLocalNotification(ReadableMap readableMap);

    @ReactMethod
    public abstract void removeAllDeliveredNotifications();

    @ReactMethod
    public abstract void removeDeliveredNotifications(ReadableArray readableArray);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void requestPermissions(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void scheduleLocalNotification(ReadableMap readableMap);

    @ReactMethod
    public abstract void setApplicationIconBadgeNumber(double d);

    public NativePushNotificationManagerIOSSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
