package com.onesignal;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.InAppMessageView;
import com.onesignal.OneSignal;
import com.tapjoy.TJAdUnitConstants;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class WebViewManager extends ActivityLifecycleHandler.ActivityAvailableListener {
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private static final int MARGIN_PX_SIZE = OSViewUtils.dpToPx(24);
    private static final String TAG = WebViewManager.class.getCanonicalName();
    protected static WebViewManager lastInstance = null;
    private Activity activity;
    private boolean firstShow = true;
    private OSInAppMessage message;
    private InAppMessageView messageView;
    private OSWebView webView;

    /* access modifiers changed from: package-private */
    public interface OneSignalGenericCallback {
        void onComplete();
    }

    /* renamed from: com.onesignal.WebViewManager$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$onesignal$WebViewManager$Position;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.onesignal.WebViewManager$Position[] r0 = com.onesignal.WebViewManager.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.onesignal.WebViewManager.AnonymousClass8.$SwitchMap$com$onesignal$WebViewManager$Position = r0
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.onesignal.WebViewManager.AnonymousClass8.$SwitchMap$com$onesignal$WebViewManager$Position     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.WebViewManager.AnonymousClass8.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public enum Position {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* access modifiers changed from: package-private */
        public boolean isBanner() {
            int i = AnonymousClass8.$SwitchMap$com$onesignal$WebViewManager$Position[ordinal()];
            return i == 1 || i == 2;
        }
    }

    protected WebViewManager(OSInAppMessage oSInAppMessage, Activity activity2) {
        this.message = oSInAppMessage;
        this.activity = activity2;
    }

    static void showHTMLString(final OSInAppMessage oSInAppMessage, final String str) {
        final Activity activity2 = ActivityLifecycleHandler.curActivity;
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "in app message showHTMLString on currentActivity: " + activity2);
        if (activity2 == null) {
            Looper.prepare();
            new Handler().postDelayed(new Runnable() {
                /* class com.onesignal.WebViewManager.AnonymousClass2 */

                public void run() {
                    WebViewManager.showHTMLString(OSInAppMessage.this, str);
                }
            }, 200);
        } else if (lastInstance == null || !oSInAppMessage.isPreview) {
            initInAppMessage(activity2, oSInAppMessage, str);
        } else {
            lastInstance.dismissAndAwaitNextMessage(new OneSignalGenericCallback() {
                /* class com.onesignal.WebViewManager.AnonymousClass1 */

                @Override // com.onesignal.WebViewManager.OneSignalGenericCallback
                public void onComplete() {
                    WebViewManager.lastInstance = null;
                    WebViewManager.initInAppMessage(activity2, oSInAppMessage, str);
                }
            });
        }
    }

    static void dismissCurrentInAppMessage() {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + lastInstance);
        WebViewManager webViewManager = lastInstance;
        if (webViewManager != null) {
            webViewManager.dismissAndAwaitNextMessage(null);
        }
    }

    /* access modifiers changed from: private */
    public static void initInAppMessage(final Activity activity2, OSInAppMessage oSInAppMessage, String str) {
        try {
            final String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 2);
            WebViewManager webViewManager = new WebViewManager(oSInAppMessage, activity2);
            lastInstance = webViewManager;
            OSUtils.runOnMainUIThread(new Runnable() {
                /* class com.onesignal.WebViewManager.AnonymousClass3 */

                public void run() {
                    WebViewManager.this.setupWebView(activity2, encodeToString);
                }
            });
        } catch (UnsupportedEncodingException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Catch on initInAppMessage: ", e);
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public class OSJavaScriptInterface {
        static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
        static final String EVENT_TYPE_KEY = "type";
        static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
        static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
        static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
        static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
        static final String JS_OBJ_NAME = "OSAndroid";

        OSJavaScriptInterface() {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            try {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level, "OSJavaScriptInterface:postMessage: " + str);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals(EVENT_TYPE_RENDERING_COMPLETE)) {
                    handleRenderComplete(jSONObject);
                } else if (string.equals(EVENT_TYPE_ACTION_TAKEN) && !WebViewManager.this.messageView.isDragging()) {
                    handleActionTaken(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void handleRenderComplete(JSONObject jSONObject) {
            Position displayLocation = getDisplayLocation(jSONObject);
            WebViewManager.this.createNewInAppMessageView(displayLocation, displayLocation == Position.FULL_SCREEN ? -1 : getPageHeightData(jSONObject));
        }

        private int getPageHeightData(JSONObject jSONObject) {
            try {
                return WebViewManager.pageRectToViewHeight(WebViewManager.this.activity, jSONObject.getJSONObject(IAM_PAGE_META_DATA_KEY));
            } catch (JSONException unused) {
                return -1;
            }
        }

        private Position getDisplayLocation(JSONObject jSONObject) {
            Position position = Position.FULL_SCREEN;
            try {
                if (!jSONObject.has(IAM_DISPLAY_LOCATION_KEY) || jSONObject.get(IAM_DISPLAY_LOCATION_KEY).equals("")) {
                    return position;
                }
                return Position.valueOf(jSONObject.optString(IAM_DISPLAY_LOCATION_KEY, "FULL_SCREEN").toUpperCase());
            } catch (JSONException e) {
                e.printStackTrace();
                return position;
            }
        }

        private void handleActionTaken(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = jSONObject.getJSONObject("body");
            String optString = jSONObject2.optString("id", null);
            if (WebViewManager.this.message.isPreview) {
                OneSignal.getInAppMessageController().onMessageActionOccurredOnPreview(WebViewManager.this.message, jSONObject2);
            } else if (optString != null) {
                OneSignal.getInAppMessageController().onMessageActionOccurredOnMessage(WebViewManager.this.message, jSONObject2);
            }
            if (jSONObject2.getBoolean(TJAdUnitConstants.String.CLOSE)) {
                WebViewManager.this.dismissAndAwaitNextMessage(null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int pageRectToViewHeight(Activity activity2, JSONObject jSONObject) {
        try {
            int dpToPx = OSViewUtils.dpToPx(jSONObject.getJSONObject("rect").getInt("height"));
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "getPageHeightData:pxHeight: " + dpToPx);
            int webViewMaxSizeY = getWebViewMaxSizeY(activity2);
            if (dpToPx <= webViewMaxSizeY) {
                return dpToPx;
            }
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level2, "getPageHeightData:pxHeight is over screen max: " + webViewMaxSizeY);
            return webViewMaxSizeY;
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "pageRectToViewHeight could not get page height", e);
            return -1;
        }
    }

    private void calculateHeightAndShowWebViewAfterNewActivity() {
        InAppMessageView inAppMessageView = this.messageView;
        if (inAppMessageView != null) {
            if (inAppMessageView.getDisplayPosition() == Position.FULL_SCREEN) {
                showMessageView(null);
                return;
            }
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "In app message new activity, calculate height and show ");
            OSViewUtils.decorViewReady(this.activity, new Runnable() {
                /* class com.onesignal.WebViewManager.AnonymousClass4 */

                public void run() {
                    WebViewManager webViewManager = WebViewManager.this;
                    webViewManager.setWebViewToMaxSize(webViewManager.activity);
                    WebViewManager.this.webView.evaluateJavascript("getPageMetaData()", new ValueCallback<String>() {
                        /* class com.onesignal.WebViewManager.AnonymousClass4.AnonymousClass1 */

                        public void onReceiveValue(String str) {
                            try {
                                WebViewManager.this.showMessageView(Integer.valueOf(WebViewManager.pageRectToViewHeight(WebViewManager.this.activity, new JSONObject(str))));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.ActivityLifecycleHandler.ActivityAvailableListener
    public void available(Activity activity2) {
        this.activity = activity2;
        if (this.firstShow) {
            showMessageView(null);
        } else {
            calculateHeightAndShowWebViewAfterNewActivity();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.ActivityLifecycleHandler.ActivityAvailableListener
    public void stopped() {
        InAppMessageView inAppMessageView = this.messageView;
        if (inAppMessageView != null) {
            inAppMessageView.removeAllViews();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.ActivityLifecycleHandler.ActivityAvailableListener
    public void lostFocus() {
        OneSignal.getInAppMessageController().messageWasDismissedByBackPress(this.message);
        removeActivityListener();
        this.messageView = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showMessageView(Integer num) {
        if (this.messageView == null) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "No messageView found to update a with a new height.");
            return;
        }
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "In app message, showing first one with height: " + num);
        this.messageView.setWebView(this.webView);
        if (num != null) {
            this.messageView.updateHeight(num.intValue());
        }
        this.messageView.showView(this.activity);
        this.messageView.checkIfShouldDismiss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupWebView(final Activity activity2, final String str) {
        enableWebViewRemoteDebugging();
        OSWebView oSWebView = new OSWebView(activity2);
        this.webView = oSWebView;
        oSWebView.setOverScrollMode(2);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new OSJavaScriptInterface(), "OSAndroid");
        blurryRenderingWebViewForKitKatWorkAround(this.webView);
        OSViewUtils.decorViewReady(activity2, new Runnable() {
            /* class com.onesignal.WebViewManager.AnonymousClass5 */

            public void run() {
                WebViewManager.this.setWebViewToMaxSize(activity2);
                WebViewManager.this.webView.loadData(str, "text/html; charset=utf-8", "base64");
            }
        });
    }

    private void blurryRenderingWebViewForKitKatWorkAround(WebView webView2) {
        if (Build.VERSION.SDK_INT == 19) {
            webView2.setLayerType(1, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWebViewToMaxSize(Activity activity2) {
        this.webView.layout(0, 0, getWebViewMaxSizeX(activity2), getWebViewMaxSizeY(activity2));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createNewInAppMessageView(Position position, int i) {
        InAppMessageView inAppMessageView = new InAppMessageView(this.webView, position, i, this.message.getDisplayDuration());
        this.messageView = inAppMessageView;
        inAppMessageView.setMessageController(new InAppMessageView.InAppMessageViewListener() {
            /* class com.onesignal.WebViewManager.AnonymousClass6 */

            @Override // com.onesignal.InAppMessageView.InAppMessageViewListener
            public void onMessageWasShown() {
                WebViewManager.this.firstShow = false;
                OneSignal.getInAppMessageController().onMessageWasShown(WebViewManager.this.message);
            }

            @Override // com.onesignal.InAppMessageView.InAppMessageViewListener
            public void onMessageWasDismissed() {
                OneSignal.getInAppMessageController().messageWasDismissed(WebViewManager.this.message);
                WebViewManager.this.removeActivityListener();
            }
        });
        ActivityLifecycleHandler.setActivityAvailableListener(TAG + this.message.messageId, this);
    }

    private static void enableWebViewRemoteDebugging() {
        if (Build.VERSION.SDK_INT >= 19 && OneSignal.atLogLevel(OneSignal.LOG_LEVEL.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private static int getWebViewMaxSizeX(Activity activity2) {
        return OSViewUtils.getWindowWidth(activity2) - (MARGIN_PX_SIZE * 2);
    }

    private static int getWebViewMaxSizeY(Activity activity2) {
        return OSViewUtils.getWindowHeight(activity2) - (MARGIN_PX_SIZE * 2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeActivityListener() {
        ActivityLifecycleHandler.removeActivityAvailableListener(TAG + this.message.messageId);
    }

    /* access modifiers changed from: protected */
    public void dismissAndAwaitNextMessage(final OneSignalGenericCallback oneSignalGenericCallback) {
        InAppMessageView inAppMessageView = this.messageView;
        if (inAppMessageView != null) {
            inAppMessageView.dismissAndAwaitNextMessage(new OneSignalGenericCallback() {
                /* class com.onesignal.WebViewManager.AnonymousClass7 */

                @Override // com.onesignal.WebViewManager.OneSignalGenericCallback
                public void onComplete() {
                    WebViewManager.this.messageView = null;
                    OneSignalGenericCallback oneSignalGenericCallback = oneSignalGenericCallback;
                    if (oneSignalGenericCallback != null) {
                        oneSignalGenericCallback.onComplete();
                    }
                }
            });
        } else if (oneSignalGenericCallback != null) {
            oneSignalGenericCallback.onComplete();
        }
    }
}
