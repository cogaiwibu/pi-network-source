package com.ironsource.sdk.ISNAdView;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.ISAdSize;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.SSAFactory;
import com.ironsource.sdk.WPAD.ISNAdViewProtocol;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import org.json.JSONException;
import org.json.JSONObject;

public class ISNAdView extends FrameLayout {
    private String TAG = ISNAdView.class.getSimpleName();
    private Activity mActivity;
    private ISAdSize mAdViewSize;
    private String mContainerIdentifier;
    private ISNAdViewLogic mIsnAdViewLogic;
    private WebView mWebView;

    public ISNAdView(Activity activity, String str, ISAdSize iSAdSize) {
        super(activity);
        this.mActivity = activity;
        this.mAdViewSize = iSAdSize;
        this.mContainerIdentifier = str;
        this.mIsnAdViewLogic = new ISNAdViewLogic();
    }

    public void setControllerDelegate(ISNAdViewDelegate iSNAdViewDelegate) {
        this.mIsnAdViewLogic.setControllerDelegate(iSNAdViewDelegate);
    }

    public void loadAd(JSONObject jSONObject) throws Exception {
        try {
            try {
                SSAFactory.getPublisherInstance(this.mActivity).loadBanner(this.mIsnAdViewLogic.buildDataForLoadingAd(jSONObject, this.mContainerIdentifier));
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void load(JSONObject jSONObject) throws Exception {
        try {
            try {
                IronSourceNetwork.loadBanner(this.mIsnAdViewLogic.buildDataForLoadingAd(jSONObject, this.mContainerIdentifier));
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void performCleanup() {
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.ISNAdView.ISNAdView.AnonymousClass1 */

            public void run() {
                try {
                    ISNAdView.this.mIsnAdViewLogic.reportAdContainerWasRemoved();
                    if (ISNAdView.this.mWebView != null) {
                        ISNAdView.this.mWebView.destroy();
                    }
                    ISNAdView.this.mActivity = null;
                    ISNAdView.this.mAdViewSize = null;
                    ISNAdView.this.mContainerIdentifier = null;
                    ISNAdView.this.mIsnAdViewLogic.destroy();
                    ISNAdView.this.mIsnAdViewLogic = null;
                } catch (Exception e) {
                    Log.e(ISNAdView.this.TAG, Constants.ErrorCodes.WEB_VIEW_PERFORM_CLEANUP_FAILED);
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        ISNAdViewLogic iSNAdViewLogic = this.mIsnAdViewLogic;
        if (iSNAdViewLogic != null) {
            iSNAdViewLogic.updateViewVisibilityParameters(ISNAdViewConstants.IS_VISIBLE_KEY, i, isShown());
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        ISNAdViewLogic iSNAdViewLogic = this.mIsnAdViewLogic;
        if (iSNAdViewLogic != null) {
            iSNAdViewLogic.updateViewVisibilityParameters(ISNAdViewConstants.IS_WINDOW_VISIBLE_KEY, i, isShown());
        }
    }

    public void loadUrlIntoWebView(final String str, final String str2, final String str3) {
        this.mActivity.runOnUiThread(new Runnable() {
            /* class com.ironsource.sdk.ISNAdView.ISNAdView.AnonymousClass2 */

            public void run() {
                try {
                    if (ISNAdView.this.mWebView == null) {
                        ISNAdView.this.createWebView(str2, str3);
                    }
                    ISNAdView.this.addView(ISNAdView.this.mWebView);
                    ISNAdView.this.mWebView.loadUrl(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    ISNAdView.this.mIsnAdViewLogic.sendErrorMessageToController(str3, e.getMessage());
                    ISNEventsTracker.logEvent(SDK5Events.adunitCouldNotLoadToWebViewBanners, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, e.getMessage()).getData());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createWebView(String str, final String str2) throws JSONException {
        WebView webView = new WebView(this.mActivity);
        this.mWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(new ISNAdViewWebViewJSInterface(this), ISNAdViewConstants.CONTAINER_MSG_HANDLER);
        this.mWebView.setWebViewClient(new ISNAdViewWebClient(new ISNAdViewProtocol.IErrorReportDelegate() {
            /* class com.ironsource.sdk.ISNAdView.ISNAdView.AnonymousClass3 */

            @Override // com.ironsource.sdk.WPAD.ISNAdViewProtocol.IErrorReportDelegate
            public void reportOnError(String str) {
                ISNAdView.this.mIsnAdViewLogic.sendErrorMessageToController(str2, str);
            }
        }));
        this.mWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mIsnAdViewLogic.setAdViewWebView(this.mWebView);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ParametersKeys.AD_VIEW_ID, this.mIsnAdViewLogic.getAdViewId());
        this.mIsnAdViewLogic.sendMessageToController(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void receiveMessageFromWebView(String str) {
        this.mIsnAdViewLogic.handleMessageFromWebView(str);
    }

    public void receiveMessageFromController(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.mIsnAdViewLogic == null) {
            ISNEventParams iSNEventParams = new ISNEventParams();
            iSNEventParams.addPair(Events.GENERAL_MSG, createErrorMessage("ISNAdViewLogic is NULL and method name %s and function parameters %s", str, jSONObject));
            ISNEventsTracker.logEvent(SDK5Events.bannerAlreadyDestroyed, iSNEventParams.getData());
            return;
        }
        try {
            if (str.equalsIgnoreCase(ISNAdViewConstants.LOAD_WITH_URL)) {
                String string = jSONObject.getString("urlForWebView");
                this.mIsnAdViewLogic.setAdViewId(jSONObject.getString(Constants.ParametersKeys.AD_VIEW_ID));
                loadUrlIntoWebView(string, str2, str3);
                return;
            }
            this.mIsnAdViewLogic.handleMessageFromController(str, jSONObject, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.mIsnAdViewLogic != null) {
                this.mIsnAdViewLogic.sendErrorMessageToController(str3, createErrorMessage("Could not handle message from controller: %s  with params: %s", str, jSONObject));
            }
        }
    }

    public ISAdSize getAdViewSize() {
        return this.mAdViewSize;
    }

    private String createErrorMessage(String str, String str2, JSONObject jSONObject) {
        Object[] objArr = new Object[2];
        objArr[0] = str2;
        objArr[1] = jSONObject != null ? jSONObject.toString() : " null";
        return String.format(str, objArr);
    }
}
