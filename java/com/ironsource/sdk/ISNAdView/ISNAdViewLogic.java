package com.ironsource.sdk.ISNAdView;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import org.json.JSONException;
import org.json.JSONObject;

public class ISNAdViewLogic {
    private static Handler mUIThreadHandler;
    private String TAG = ISNAdViewLogic.class.getSimpleName();
    private String[] commandsToHandleInAdView = {ISNAdViewConstants.HANDLE_GET_VIEW_VISIBILITY};
    private JSONObject mAdViewConfiguration = null;
    private String mAdViewId;
    private ViewVisibilityParameters mAdViewVisibilityParameters = new ViewVisibilityParameters();
    private ISNAdViewDelegate mDelegate;
    private WebView mWebView;
    private final String[] supportedCommandsFromController = {ISNAdViewConstants.LOAD_WITH_URL, ISNAdViewConstants.UPDATE_AD, "isExternalAdViewInitiated", ISNAdViewConstants.HANDLE_GET_VIEW_VISIBILITY, ISNAdViewConstants.SEND_MESSAGE};

    public void setAdViewId(String str) {
        this.mAdViewId = str;
    }

    public void setControllerDelegate(ISNAdViewDelegate iSNAdViewDelegate) {
        this.mDelegate = iSNAdViewDelegate;
    }

    public String getAdViewId() {
        return this.mAdViewId;
    }

    private Handler getUIThreadHandler() {
        try {
            if (mUIThreadHandler == null) {
                mUIThreadHandler = new Handler(Looper.getMainLooper());
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error while trying execute method getUIThreadHandler");
            e.printStackTrace();
        }
        return mUIThreadHandler;
    }

    public void setAdViewWebView(WebView webView) {
        this.mWebView = webView;
    }

    public void setAdViewIdentifier(String str) {
        JSONObject jSONObject = new JSONObject();
        this.mAdViewConfiguration = jSONObject;
        try {
            jSONObject.put(ISNAdViewConstants.EXTERNAL_AD_VIEW_ID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        this.mAdViewConfiguration = null;
        this.mDelegate = null;
        this.mAdViewVisibilityParameters = null;
        mUIThreadHandler = null;
    }

    /* access modifiers changed from: package-private */
    public JSONObject buildDataForLoadingAd(JSONObject jSONObject, String str) throws Exception {
        try {
            boolean isInReload = isInReload();
            if (this.mAdViewConfiguration == null) {
                this.mAdViewConfiguration = new JSONObject(jSONObject.toString());
            }
            this.mAdViewConfiguration.put(ISNAdViewConstants.EXTERNAL_AD_VIEW_ID, str);
            this.mAdViewConfiguration.put(ISNAdViewConstants.IS_IN_RELOAD, isInReload);
            return this.mAdViewConfiguration;
        } catch (Exception unused) {
            throw new Exception("ISNAdViewLogic | buildDataForLoadingAd | Could not build load parameters");
        }
    }

    private boolean isInReload() {
        return this.mAdViewConfiguration != null;
    }

    public void sendMessageToController(String str, JSONObject jSONObject) {
        ISNAdViewDelegate iSNAdViewDelegate = this.mDelegate;
        if (iSNAdViewDelegate != null) {
            iSNAdViewDelegate.sendMessageToController(str, jSONObject);
        }
    }

    public void sendErrorMessageToController(String str, String str2) {
        ISNAdViewDelegate iSNAdViewDelegate = this.mDelegate;
        if (iSNAdViewDelegate != null) {
            iSNAdViewDelegate.sendErrorMessageToController(str, str2, this.mAdViewId);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleMessageFromController(final String str, final JSONObject jSONObject, final String str2, final String str3) {
        if (this.mDelegate == null) {
            ISNEventsTracker.logEvent(SDK5Events.bannerAlreadyDestroyed, new ISNEventParams().addPair(Events.GENERAL_MSG, "mDelegate is null").getData());
        } else {
            getUIThreadHandler().post(new Runnable() {
                /* class com.ironsource.sdk.ISNAdView.ISNAdViewLogic.AnonymousClass1 */

                public void run() {
                    try {
                        if (!ISNAdViewLogic.this.canHandleCommandFromController(str)) {
                            String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + str;
                            Log.e(ISNAdViewLogic.this.TAG, str);
                            ISNAdViewLogic.this.sendErrorMessageToController(str3, str);
                        } else if (str.equalsIgnoreCase("isExternalAdViewInitiated")) {
                            ISNAdViewLogic.this.sendIsExternalAdViewInitiated(str2);
                        } else if (str.equalsIgnoreCase(ISNAdViewConstants.HANDLE_GET_VIEW_VISIBILITY)) {
                            ISNAdViewLogic.this.sendHandleGetViewVisibilityParams(str2);
                        } else if (str.equalsIgnoreCase(ISNAdViewConstants.SEND_MESSAGE) || str.equalsIgnoreCase(ISNAdViewConstants.UPDATE_AD)) {
                            ISNAdViewLogic.this.sendMessageToAdunit(jSONObject.getString("params"), str2, str3);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + str;
                        Log.e(ISNAdViewLogic.this.TAG, str2);
                        ISNAdViewLogic.this.sendErrorMessageToController(str3, str2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean canHandleCommandFromController(String str) {
        int i = 0;
        boolean z = false;
        while (true) {
            String[] strArr = this.supportedCommandsFromController;
            if (i >= strArr.length || z) {
                return z;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public void updateViewVisibilityParameters(String str, int i, boolean z) {
        this.mAdViewVisibilityParameters.updateViewVisibilityParameters(str, i, z);
        if (shouldReportVisibilityToController(str)) {
            reportAdContainerIsVisible();
        }
    }

    private boolean shouldReportVisibilityToController(String str) {
        if (Build.VERSION.SDK_INT <= 22) {
            return str.equalsIgnoreCase(ISNAdViewConstants.IS_WINDOW_VISIBLE_KEY);
        }
        return str.equalsIgnoreCase(ISNAdViewConstants.IS_VISIBLE_KEY);
    }

    private void reportAdContainerIsVisible() {
        if (this.mDelegate != null && this.mAdViewVisibilityParameters != null) {
            sendMessageToController(ISNAdViewConstants.CONTAINER_IMPRESSION_MESSAGE, buildParamsObjectForAdViewVisibility());
        }
    }

    public void reportAdContainerWasRemoved() {
        if (this.mDelegate != null && this.mAdViewVisibilityParameters != null) {
            sendMessageToController(ISNAdViewConstants.CONTAINER_DESTRUCTION_MESSAGE, buildParamsObjectForAdViewVisibility());
        }
    }

    private JSONObject buildParamsObjectForAdViewVisibility() {
        return new JSONObject() {
            /* class com.ironsource.sdk.ISNAdView.ISNAdViewLogic.AnonymousClass2 */

            {
                try {
                    put(ISNAdViewConstants.CONFIGS, ISNAdViewLogic.this.extendConfigurationWithVisibilityParams(ISNAdViewLogic.this.mAdViewConfiguration, ISNAdViewLogic.this.mAdViewVisibilityParameters.collectVisibilityParameters()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private JSONObject extendConfigurationWithVisibilityParams(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
            jSONObject3.put(ISNAdViewConstants.VISIBILITY_PARAMS_KEY, jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void sendIsExternalAdViewInitiated(String str) {
        try {
            boolean z = (this.mWebView == null || this.mWebView.getUrl() == null) ? false : true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isExternalAdViewInitiated", z);
            jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, this.mAdViewId);
            sendMessageToController(str, jSONObject);
        } catch (Exception e) {
            Log.e(this.TAG, "Error while trying execute method sendIsExternalAdViewInitiated");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendHandleGetViewVisibilityParams(String str) throws JSONException {
        JSONObject collectVisibilityParameters = this.mAdViewVisibilityParameters.collectVisibilityParameters();
        collectVisibilityParameters.put(Constants.ParametersKeys.AD_VIEW_ID, this.mAdViewId);
        sendMessageToController(str, collectVisibilityParameters);
    }

    public void sendMessageToAdunit(String str, String str2, String str3) throws JSONException {
        if (this.mWebView == null) {
            String str4 = "No external adunit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.TAG, str4);
            this.mDelegate.sendErrorMessageToController(str3, str4, this.mAdViewId);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
            str = "\"" + str + "\"";
        }
        final String buildCommandForWebView = buildCommandForWebView(str);
        getUIThreadHandler().post(new Runnable() {
            /* class com.ironsource.sdk.ISNAdView.ISNAdViewLogic.AnonymousClass3 */

            public void run() {
                ISNAdViewLogic.this.injectJavaScriptIntoWebView(buildCommandForWebView);
            }
        });
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, this.mAdViewId);
        sendMessageToController(str2, jSONObject);
    }

    private String buildCommandForWebView(String str) {
        return String.format(ISNAdViewConstants.ADUNIT_MESSAGE_FORMAT, str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void injectJavaScriptIntoWebView(String str) {
        try {
            String str2 = "javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}";
            if (Build.VERSION.SDK_INT >= 19) {
                this.mWebView.evaluateJavascript(str2, null);
            } else {
                this.mWebView.loadUrl(str2);
            }
        } catch (Throwable th) {
            Log.e(this.TAG, "injectJavaScriptIntoWebView | Error while trying inject JS into external adunit: " + str + "Android API level: " + Build.VERSION.SDK_INT);
            th.printStackTrace();
        }
    }

    public void handleMessageFromWebView(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            if (TextUtils.isEmpty(optString) || !shouldHandleMessageInContainer(optString)) {
                sendMessageToController(ISNAdViewConstants.CONTAINER_SEND_MESSAGE, jSONObject);
            } else if (optString.equalsIgnoreCase(ISNAdViewConstants.HANDLE_GET_VIEW_VISIBILITY)) {
                sendHandleGetViewVisibilityParamsForWebView(jSONObject);
            }
        } catch (JSONException e) {
            String str2 = this.TAG;
            Log.e(str2, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            e.printStackTrace();
        }
    }

    private boolean shouldHandleMessageInContainer(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.commandsToHandleInAdView;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                return true;
            }
            i++;
        }
    }

    private void sendHandleGetViewVisibilityParamsForWebView(JSONObject jSONObject) throws JSONException {
        sendMessageToAdunit(buildVisibilityMessageForAdunit(jSONObject).toString(), null, null);
    }

    private JSONObject buildVisibilityMessageForAdunit(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put("data", this.mAdViewVisibilityParameters.collectVisibilityParameters());
        } catch (Exception e) {
            String str = this.TAG;
            Log.e(str, "Error while trying execute method buildVisibilityMessageForAdunit | params: " + jSONObject);
            e.printStackTrace();
        }
        return jSONObject2;
    }
}
