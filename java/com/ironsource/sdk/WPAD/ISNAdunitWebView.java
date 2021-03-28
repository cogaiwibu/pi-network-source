package com.ironsource.sdk.WPAD;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.ISNAdView.ISNAdViewConstants;
import com.ironsource.sdk.ISNAdView.ISNAdViewDelegate;
import com.ironsource.sdk.ISNAdView.ISNAdViewLogic;
import com.ironsource.sdk.ISNAdView.ISNAdViewWebClient;
import com.ironsource.sdk.WPAD.ISNAdViewProtocol;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.WebViewUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ISNAdunitWebView implements ISNAdViewProtocol {
    private static final String FILE_PREFIX = "file://";
    private static String WEBVIEW_IS_NOT_NULL = "loadWithUrl | webView is not null";
    private String TAG = ISNAdunitWebView.class.getSimpleName();
    private Activity mActivity;
    private String mAdViewId;
    private String mCacheDirectory;
    private ISNAdViewLogic mIsnAdViewLogic;
    private WebView mWebView;

    public ISNAdunitWebView(ISNAdViewDelegate iSNAdViewDelegate, Activity activity, String str) {
        this.mActivity = activity;
        ISNAdViewLogic iSNAdViewLogic = new ISNAdViewLogic();
        this.mIsnAdViewLogic = iSNAdViewLogic;
        iSNAdViewLogic.setAdViewId(str);
        this.mCacheDirectory = initializeCacheDirectory(activity.getApplicationContext());
        this.mAdViewId = str;
        this.mIsnAdViewLogic.setControllerDelegate(iSNAdViewDelegate);
    }

    /* access modifiers changed from: package-private */
    public String initializeCacheDirectory(Context context) {
        return IronSourceStorageUtils.initializeCacheDirectory(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createWebView(final String str) {
        Logger.i(this.TAG, "createWebView");
        WebView webView = new WebView(this.mActivity);
        this.mWebView = webView;
        webView.addJavascriptInterface(new ISNAdViewJSInterface(this), ISNAdViewConstants.CONTAINER_MSG_HANDLER);
        this.mWebView.setWebViewClient(new ISNAdViewWebClient(new ISNAdViewProtocol.IErrorReportDelegate() {
            /* class com.ironsource.sdk.WPAD.ISNAdunitWebView.AnonymousClass1 */

            @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol.IErrorReportDelegate
            public void reportOnError(String str) {
                Logger.i(ISNAdunitWebView.this.TAG, "createWebView failed!");
                ISNAdunitWebView.this.mIsnAdViewLogic.sendErrorMessageToController(str, str);
            }
        }));
        WebViewUtils.setWebViewSettings(this.mWebView);
        this.mIsnAdViewLogic.setAdViewWebView(this.mWebView);
        this.mIsnAdViewLogic.setAdViewIdentifier(this.mAdViewId);
    }

    @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol
    public WebView getViewToPresent() {
        return this.mWebView;
    }

    @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol
    public void loadWithUrl(final JSONObject jSONObject, final String str, final String str2) {
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.WPAD.ISNAdunitWebView.AnonymousClass2 */

            public void run() {
                if (ISNAdunitWebView.this.mWebView != null) {
                    ISNEventsTracker.logEvent(SDK5Events.adunitCouldNotLoadToWebView, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, ISNAdunitWebView.WEBVIEW_IS_NOT_NULL).getData());
                }
                try {
                    ISNAdunitWebView.this.createWebView(str2);
                    ISNAdunitWebView.this.mWebView.loadUrl(ISNAdunitWebView.this.createAdunitUrl(jSONObject.getString("urlForWebView")));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, ISNAdunitWebView.this.mAdViewId);
                    ISNAdunitWebView.this.mIsnAdViewLogic.sendMessageToController(str, jSONObject);
                } catch (Exception e) {
                    ISNAdunitWebView.this.mIsnAdViewLogic.sendErrorMessageToController(str2, e.getMessage());
                    ISNEventsTracker.logEvent(SDK5Events.adunitCouldNotLoadToWebView, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).getData());
                }
            }
        });
    }

    @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol
    public void sendIsExternalAdViewInitiated(final String str) {
        try {
            this.mWebView.post(new Runnable() {
                /* class com.ironsource.sdk.WPAD.ISNAdunitWebView.AnonymousClass3 */

                public void run() {
                    ISNAdunitWebView.this.mIsnAdViewLogic.sendIsExternalAdViewInitiated(str);
                }
            });
        } catch (Exception e) {
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String createAdunitUrl(String str) {
        if (!isRelativePath(str)) {
            return str;
        }
        return FILE_PREFIX + this.mCacheDirectory + removePreFixOfRelativePath(str);
    }

    private String removePreFixOfRelativePath(String str) {
        String substring = str.substring(str.indexOf("/") + 1);
        return substring.substring(substring.indexOf("/"));
    }

    private boolean isRelativePath(String str) {
        return str.startsWith(".");
    }

    @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol
    public void sendMessageToAd(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.mIsnAdViewLogic.sendMessageToAdunit(jSONObject.getString("params"), str, str2);
        } catch (Exception e) {
            String str3 = this.TAG;
            Logger.i(str3, "sendMessageToAd fail message: " + e.getMessage());
            throw e;
        }
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        try {
            this.mIsnAdViewLogic.handleMessageFromWebView(str);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol
    public synchronized void performCleanup(final String str, final String str2) {
        if (this.mActivity != null) {
            this.mActivity.runOnUiThread(new Runnable() {
                /* class com.ironsource.sdk.WPAD.ISNAdunitWebView.AnonymousClass4 */

                public void run() {
                    Logger.i(ISNAdunitWebView.this.TAG, "perforemCleanup");
                    try {
                        if (ISNAdunitWebView.this.mWebView != null) {
                            ISNAdunitWebView.this.mWebView.destroy();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, ISNAdunitWebView.this.mAdViewId);
                        ISNAdunitWebView.this.mIsnAdViewLogic.sendMessageToController(str, jSONObject);
                        ISNAdunitWebView.this.mIsnAdViewLogic.destroy();
                        ISNAdunitWebView.this.mIsnAdViewLogic = null;
                        ISNAdunitWebView.this.mActivity = null;
                    } catch (Exception e) {
                        String str = ISNAdunitWebView.this.TAG;
                        Log.e(str, "performCleanup | could not destroy ISNAdView webView ID: " + ISNAdunitWebView.this.mAdViewId);
                        ISNEventsTracker.logEvent(SDK5Events.webViewCleanUpFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).getData());
                        if (ISNAdunitWebView.this.mIsnAdViewLogic != null) {
                            ISNAdunitWebView.this.mIsnAdViewLogic.sendErrorMessageToController(str2, e.getMessage());
                        }
                    }
                }
            });
        }
    }
}
