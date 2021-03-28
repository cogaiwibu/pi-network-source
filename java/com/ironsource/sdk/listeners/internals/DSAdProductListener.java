package com.ironsource.sdk.listeners.internals;

import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.ISNEnums;
import org.json.JSONObject;

public interface DSAdProductListener {
    void onAdProductClick(ISNEnums.ProductType productType, String str);

    void onAdProductClose(ISNEnums.ProductType productType, String str);

    void onAdProductEventNotificationReceived(ISNEnums.ProductType productType, String str, String str2, JSONObject jSONObject);

    void onAdProductInitFailed(ISNEnums.ProductType productType, String str, String str2);

    void onAdProductInitSuccess(ISNEnums.ProductType productType, String str, AdUnitsReady adUnitsReady);

    void onAdProductOpen(ISNEnums.ProductType productType, String str);
}
