package com.ironsource.mediationsdk;

import com.facebook.appevents.AppEventsConstants;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.utilities.IronsourceJsonUtilities;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AuctionResponseItem {
    private List<String> mBurls;
    private ImpressionData mImpressionData;
    private String mInstanceName;
    private boolean mIsValid;
    private List<String> mLurls;
    private List<String> mNurls;
    private String mPrice;
    private String mServerData;

    public AuctionResponseItem(String str) {
        this.mInstanceName = str;
        this.mServerData = "";
        this.mPrice = "";
        this.mBurls = new ArrayList();
        this.mLurls = new ArrayList();
        this.mNurls = new ArrayList();
        this.mIsValid = true;
        this.mImpressionData = null;
    }

    public AuctionResponseItem(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mIsValid = false;
        try {
            if (jSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_INSTANCE)) {
                this.mInstanceName = jSONObject.getString(AuctionDataUtils.AUCTION_RESPONSE_KEY_INSTANCE);
            }
            if (jSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_AD_MARKUP)) {
                this.mServerData = jSONObject.getString(AuctionDataUtils.AUCTION_RESPONSE_KEY_AD_MARKUP);
            } else if (jSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_SERVER_DATA)) {
                this.mServerData = jSONObject.getString(AuctionDataUtils.AUCTION_RESPONSE_KEY_SERVER_DATA);
            } else {
                this.mServerData = "";
            }
            if (jSONObject.has("price")) {
                this.mPrice = jSONObject.getString("price");
            } else {
                this.mPrice = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            this.mBurls = new ArrayList();
            this.mLurls = new ArrayList();
            this.mNurls = new ArrayList();
            if (jSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_NOTIFICATIONS)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(AuctionDataUtils.AUCTION_RESPONSE_KEY_NOTIFICATIONS);
                if (optJSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_BURL)) {
                    JSONArray jSONArray = optJSONObject.getJSONArray(AuctionDataUtils.AUCTION_RESPONSE_KEY_BURL);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.mBurls.add(jSONArray.getString(i));
                    }
                }
                if (optJSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_LURL)) {
                    JSONArray jSONArray2 = optJSONObject.getJSONArray(AuctionDataUtils.AUCTION_RESPONSE_KEY_LURL);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.mLurls.add(jSONArray2.getString(i2));
                    }
                }
                if (optJSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_NURL)) {
                    JSONArray jSONArray3 = optJSONObject.getJSONArray(AuctionDataUtils.AUCTION_RESPONSE_KEY_NURL);
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        this.mNurls.add(jSONArray3.getString(i3));
                    }
                }
            }
            this.mImpressionData = new ImpressionData(IronsourceJsonUtilities.mergeJsonObjects(jSONObject2, jSONObject.has(AuctionDataUtils.AUCTION_RESPONSE_KEY_IMPRESSION_DATA) ? jSONObject.optJSONObject(AuctionDataUtils.AUCTION_RESPONSE_KEY_IMPRESSION_DATA) : null));
            this.mIsValid = true;
        } catch (Exception unused) {
        }
    }

    public AuctionResponseItem(JSONObject jSONObject) {
        this(jSONObject, null);
    }

    public String getInstanceName() {
        return this.mInstanceName;
    }

    public String getServerData() {
        return this.mServerData;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public List<String> getBurls() {
        return this.mBurls;
    }

    public List<String> getLurls() {
        return this.mLurls;
    }

    public List<String> getNurls() {
        return this.mNurls;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public ImpressionData getImpressionData(String str) {
        ImpressionData impressionData = this.mImpressionData;
        if (impressionData != null) {
            impressionData.replaceMacroForPlacementWithValue(AuctionDataUtils.PLACEMENT_NAME_MACRO, str);
        }
        return this.mImpressionData;
    }
}
