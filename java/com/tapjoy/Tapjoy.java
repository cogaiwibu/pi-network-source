package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.er;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class Tapjoy {
    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public static String getVersion() {
        return er.a().b();
    }

    public static void setDebugEnabled(boolean z) {
        er.a().a(z);
    }

    public static boolean connect(Context context, String str) {
        return er.a().a(context, str);
    }

    public static boolean connect(Context context, String str, Hashtable hashtable) {
        return er.a().a(context, str, hashtable, (TJConnectListener) null);
    }

    public static synchronized boolean connect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = er.a().a(context, str, hashtable, tJConnectListener);
        }
        return a;
    }

    public static TJPlacement getPlacement(String str, TJPlacementListener tJPlacementListener) {
        return er.a().a(str, tJPlacementListener);
    }

    public static void setActivity(Activity activity) {
        er.a().a(activity);
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        er.a().a(tJGetCurrencyBalanceListener);
    }

    public static void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        er.a().a(i, tJSpendCurrencyListener);
    }

    public static void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        er.a().a(i, tJAwardCurrencyListener);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        er.a().a(tJEarnedCurrencyListener);
    }

    @Deprecated
    public static void setCurrencyMultiplier(float f) {
        er.a().a(f);
    }

    @Deprecated
    public static float getCurrencyMultiplier() {
        return er.a().c();
    }

    public static void trackPurchase(String str, String str2, double d, String str3) {
        er.a().a(str, str2, d, str3);
    }

    public static void trackPurchase(String str, String str2, String str3, String str4) {
        er.a().a(str, str2, str3, str4);
    }

    @Deprecated
    public static void trackPurchase(String str, String str2) {
        er.a().a(str, str2);
    }

    public static void trackEvent(String str) {
        er.a().a(str);
    }

    public static void trackEvent(String str, long j) {
        er.a().a(str, j);
    }

    public static void trackEvent(String str, String str2, long j) {
        er.a().a(str, str2, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4) {
        er.a().b(str, str2, str3, str4);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, long j) {
        er.a().a(str, str2, str3, str4, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j) {
        er.a().a(str, str2, str3, str4, str5, j);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2) {
        er.a().a(str, str2, str3, str4, str5, j, str6, j2);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        er.a().a(str, str2, str3, str4, str5, j, str6, j2, str7, j3);
    }

    public static void trackEvent(String str, String str2, String str3, String str4, Map map) {
        er.a().a(str, str2, str3, str4, map);
    }

    public static void startSession() {
        er.a().d();
    }

    public static void endSession() {
        er.a().e();
    }

    public static void onActivityStart(Activity activity) {
        er.a().b(activity);
    }

    public static void onActivityStop(Activity activity) {
        er.a().c(activity);
    }

    public static void setUserID(String str) {
        setUserID(str, null);
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        er.a().a(str, tJSetUserIDListener);
    }

    public static void setUserLevel(int i) {
        er.a().a(i);
    }

    public static void setUserFriendCount(int i) {
        er.a().b(i);
    }

    public static void setAppDataVersion(String str) {
        er.a().b(str);
    }

    public static void setUserCohortVariable(int i, String str) {
        er.a().a(i, str);
    }

    public static Set getUserTags() {
        return er.a().f();
    }

    public static void setUserTags(Set set) {
        er.a().a(set);
    }

    public static void clearUserTags() {
        er.a().g();
    }

    public static void addUserTag(String str) {
        er.a().c(str);
    }

    public static void removeUserTag(String str) {
        er.a().d(str);
    }

    public static void setVideoListener(TJVideoListener tJVideoListener) {
        er.a().a(tJVideoListener);
    }

    public static void actionComplete(String str) {
        er.a().e(str);
    }

    public static void setGcmSender(String str) {
        er.a().f(str);
    }

    public static void setDeviceToken(String str) {
        er.a().i(str);
    }

    public static void setReceiveRemoteNotification(Context context, Map map) {
        er.a().a(context, map);
    }

    public static boolean isPushNotificationDisabled() {
        return er.a().h();
    }

    public static void setPushNotificationDisabled(boolean z) {
        er.a().b(z);
    }

    public static void loadSharedLibrary() {
        try {
            System.loadLibrary("tapjoy");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        er.a().a(gLSurfaceView);
    }

    public static String getSupportURL() {
        return er.a().g(null);
    }

    public static String getSupportURL(String str) {
        return er.a().g(str);
    }

    public static String getUserToken() {
        return er.a().k();
    }

    public static boolean isConnected() {
        return er.a().i();
    }

    public static void subjectToGDPR(boolean z) {
        er.a().c(z);
    }

    public static void setUserConsent(String str) {
        er.a().h(str);
    }

    public static void belowConsentAge(boolean z) {
        er.a().d(z);
    }

    public static synchronized boolean limitedConnect(Context context, String str, TJConnectListener tJConnectListener) {
        boolean a;
        synchronized (Tapjoy.class) {
            a = er.a().a(context, str, tJConnectListener);
        }
        return a;
    }

    public static boolean isLimitedConnected() {
        return er.a().j();
    }

    public static TJPlacement getLimitedPlacement(String str, TJPlacementListener tJPlacementListener) {
        return er.a().b(str, tJPlacementListener);
    }

    public static void setCustomParameter(String str) {
        er.a().j(str);
    }

    public static String getCustomParameter() {
        return er.a().l();
    }
}
