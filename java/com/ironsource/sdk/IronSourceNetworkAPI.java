package com.ironsource.sdk;

import android.app.Activity;
import org.json.JSONObject;

public interface IronSourceNetworkAPI extends IronSourceNetworkAds {
    void onPause(Activity activity);

    void onResume(Activity activity);

    void release(Activity activity);

    void updateConsentInfo(JSONObject jSONObject);
}
