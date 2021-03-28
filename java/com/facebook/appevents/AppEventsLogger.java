package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import java.math.BigDecimal;
import java.util.Currency;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private AppEventsLoggerImpl loggerImpl;

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    public static void activateApp(Application application) {
        AppEventsLoggerImpl.activateApp(application, null);
    }

    public static void activateApp(Application application, String str) {
        AppEventsLoggerImpl.activateApp(application, str);
    }

    @Deprecated
    public static void activateApp(Context context) {
        activateApp((Application) null, (String) null);
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        AppEventsLoggerImpl.functionDEPRECATED("Please use activateApp(Application) or activateApp(Application, String)");
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        deactivateApp(null, null);
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        AppEventsLoggerImpl.functionDEPRECATED("deactivate app will be logged automatically");
    }

    public static void initializeLib(Context context, String str) {
        AppEventsLoggerImpl.initializeLib(context, str);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, null, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, null);
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.loggerImpl = new AppEventsLoggerImpl(context, str, accessToken);
    }

    public static FlushBehavior getFlushBehavior() {
        return AppEventsLoggerImpl.getFlushBehavior();
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior) {
        AppEventsLoggerImpl.setFlushBehavior(flushBehavior);
    }

    public void logEvent(String str) {
        this.loggerImpl.logEvent(str);
    }

    public void logEvent(String str, double d) {
        this.loggerImpl.logEvent(str, d);
    }

    public void logEvent(String str, Bundle bundle) {
        this.loggerImpl.logEvent(str, bundle);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        this.loggerImpl.logEvent(str, d, bundle);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        this.loggerImpl.logPurchase(bigDecimal, currency);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        this.loggerImpl.logPurchase(bigDecimal, currency, bundle);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        String str;
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. " + "Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases";
        } else {
            str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. " + "Please use logPurchase() function instead.";
        }
        Log.e(TAG, str);
    }

    public void logPushNotificationOpen(Bundle bundle) {
        this.loggerImpl.logPushNotificationOpen(bundle, null);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        this.loggerImpl.logPushNotificationOpen(bundle, str);
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        this.loggerImpl.logProductItem(str, productAvailability, productCondition, str2, str3, str4, str5, bigDecimal, currency, str6, str7, str8, bundle);
    }

    public void flush() {
        this.loggerImpl.flush();
    }

    public static void onContextStop() {
        AppEventsLoggerImpl.onContextStop();
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.loggerImpl.isValidForAccessToken(accessToken);
    }

    public static void setPushNotificationsRegistrationId(String str) {
        AppEventsLoggerImpl.setPushNotificationsRegistrationId(str);
    }

    public static void augmentWebView(WebView webView, Context context) {
        AppEventsLoggerImpl.augmentWebView(webView, context);
    }

    public static void setUserID(String str) {
        AnalyticsUserIDStore.setUserID(str);
    }

    public static String getUserID() {
        return AnalyticsUserIDStore.getUserID();
    }

    public static void clearUserID() {
        AnalyticsUserIDStore.setUserID(null);
    }

    @Deprecated
    public static void setUserData(Bundle bundle) {
        UserDataStore.setUserDataAndHash(bundle);
    }

    public static void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public static String getUserData() {
        return UserDataStore.getHashedUserData();
    }

    public static void clearUserData() {
        UserDataStore.clear();
    }

    public static void updateUserProperties(Bundle bundle, GraphRequest.Callback callback) {
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
    }

    public static void updateUserProperties(Bundle bundle, String str, GraphRequest.Callback callback) {
        AppEventsLoggerImpl.updateUserProperties(bundle, str, callback);
    }

    @Deprecated
    public void logSdkEvent(String str, Double d, Bundle bundle) {
        this.loggerImpl.logSdkEvent(str, d, bundle);
    }

    public String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        return AppEventsLoggerImpl.getAnonymousAppDeviceGUID(context);
    }

    public static void setInstallReferrer(String str) {
        AppEventsLoggerImpl.setInstallReferrer(str);
    }
}
