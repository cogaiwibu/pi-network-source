package com.ironsource.sdk.WPAD;

import android.app.Activity;
import android.webkit.WebView;
import com.ironsource.sdk.ISNAdView.ISNAdViewDelegate;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.utils.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AdViewsManager {
    private static final String TAG = AdViewsManager.class.getSimpleName();
    private static AdViewsManager mInstance = null;
    Map<String, ISNAdViewProtocol> mAdViewsCollection = Collections.synchronizedMap(new HashMap());

    public static synchronized AdViewsManager getInstance() {
        AdViewsManager adViewsManager;
        synchronized (AdViewsManager.class) {
            if (mInstance == null) {
                mInstance = new AdViewsManager();
            }
            adViewsManager = mInstance;
        }
        return adViewsManager;
    }

    public String getAdViewId(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has(Constants.ParametersKeys.AD_VIEW_ID)) {
            return (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString(Constants.ParametersKeys.AD_VIEW_ID);
        }
        return jSONObject.getString(Constants.ParametersKeys.AD_VIEW_ID);
    }

    public void loadWithUrl(ISNAdViewDelegate iSNAdViewDelegate, JSONObject jSONObject, Activity activity, String str, String str2) throws Exception {
        String string = jSONObject.getString(Constants.ParametersKeys.AD_VIEW_ID);
        if (string.isEmpty()) {
            Logger.i(TAG, "loadWithUrl fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (!this.mAdViewsCollection.containsKey(string)) {
            ISNAdunitWebView iSNAdunitWebView = new ISNAdunitWebView(iSNAdViewDelegate, activity, string);
            this.mAdViewsCollection.put(string, iSNAdunitWebView);
            iSNAdunitWebView.loadWithUrl(jSONObject, str, str2);
        } else {
            Logger.i(TAG, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
    }

    public void sendMessageToAd(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString(Constants.ParametersKeys.AD_VIEW_ID);
        if (string.isEmpty()) {
            Logger.i(TAG, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.mAdViewsCollection.containsKey(string)) {
            this.mAdViewsCollection.get(string).sendMessageToAd(jSONObject, str, str2);
        } else {
            Logger.i(TAG, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public WebView getAdViewById(String str) {
        if (str.isEmpty() || !this.mAdViewsCollection.containsKey(str)) {
            return null;
        }
        return this.mAdViewsCollection.get(str).getViewToPresent();
    }

    public void sendIsExternalAdViewInitiated(JSONObject jSONObject, String str) throws Exception {
        String string = jSONObject.getString(Constants.ParametersKeys.AD_VIEW_ID);
        if (string.isEmpty()) {
            Logger.i(TAG, "sendIsExternalAdViewInitiated fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.mAdViewsCollection.containsKey(string)) {
            this.mAdViewsCollection.get(string).sendIsExternalAdViewInitiated(str);
        } else {
            Logger.i(TAG, "sendIsExternalAdViewInitiated fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }

    public void removeAdView(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString(Constants.ParametersKeys.AD_VIEW_ID);
        if (string.isEmpty()) {
            Logger.i(TAG, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        } else if (this.mAdViewsCollection.containsKey(string)) {
            this.mAdViewsCollection.remove(string);
            this.mAdViewsCollection.get(string).performCleanup(str, str2);
        } else {
            Logger.i(TAG, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
    }
}
