package com.ironsource.mediationsdk.impressionData;

import com.facebook.appevents.UserDataStore;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ImpressionData {
    private final String IMPRESSION_DATA_KEY_ABTEST = "ab";
    private final String IMPRESSION_DATA_KEY_AD_NETWORK = "adNetwork";
    private final String IMPRESSION_DATA_KEY_AD_UNIT = "adUnit";
    private final String IMPRESSION_DATA_KEY_AUCTION_ID = "auctionId";
    private final String IMPRESSION_DATA_KEY_COUNTRY = UserDataStore.COUNTRY;
    private final String IMPRESSION_DATA_KEY_ENCRYPTED_CPM = "encryptedCPM";
    private final String IMPRESSION_DATA_KEY_INSTANCE_ID = "instanceId";
    private final String IMPRESSION_DATA_KEY_INSTANCE_NAME = Constants.CONVERT_INSTANCE_NAME;
    private final String IMPRESSION_DATA_KEY_LIFETIME_REVENUE = "lifetimeRevenue";
    private final String IMPRESSION_DATA_KEY_PLACEMENT = IronSourceConstants.EVENTS_PLACEMENT_NAME;
    private final String IMPRESSION_DATA_KEY_PRECISION = "precision";
    private final String IMPRESSION_DATA_KEY_REVENUE = "revenue";
    private final String IMPRESSION_DATA_KEY_SEGMENT_NAME = "segmentName";
    private String ab = null;
    private String adNetwork = null;
    private String adUnit = null;
    private JSONObject allData;
    private String auctionId = null;
    private String country = null;
    private DecimalFormat df = new DecimalFormat("#.#####");
    private String encryptedCPM = null;
    private String instanceId = null;
    private String instanceName = null;
    private Double lifetimeRevenue = null;
    private String placement = null;
    private String precision = null;
    private Double revenue = null;
    private String segmentName = null;

    public ImpressionData(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.allData = jSONObject;
                this.auctionId = jSONObject.optString("auctionId", null);
                this.adUnit = jSONObject.optString("adUnit", null);
                this.country = jSONObject.optString(UserDataStore.COUNTRY, null);
                this.ab = jSONObject.optString("ab", null);
                this.segmentName = jSONObject.optString("segmentName", null);
                this.placement = jSONObject.optString(IronSourceConstants.EVENTS_PLACEMENT_NAME, null);
                this.adNetwork = jSONObject.optString("adNetwork", null);
                this.instanceName = jSONObject.optString(Constants.CONVERT_INSTANCE_NAME, null);
                this.instanceId = jSONObject.optString("instanceId", null);
                this.precision = jSONObject.optString("precision", null);
                this.encryptedCPM = jSONObject.optString("encryptedCPM", null);
                double optDouble = jSONObject.optDouble("lifetimeRevenue");
                this.lifetimeRevenue = Double.isNaN(optDouble) ? null : Double.valueOf(optDouble);
                double optDouble2 = jSONObject.optDouble("revenue");
                this.revenue = Double.isNaN(optDouble2) ? null : Double.valueOf(optDouble2);
            } catch (Exception e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("error parsing impression " + e.getMessage());
            }
        }
    }

    public void replaceMacroForPlacementWithValue(String str, String str2) {
        String str3 = this.placement;
        if (str3 != null) {
            String replace = str3.replace(str, str2);
            this.placement = replace;
            JSONObject jSONObject = this.allData;
            if (jSONObject != null) {
                try {
                    jSONObject.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, replace);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ImpressionData{auctionId='");
        sb.append(this.auctionId);
        sb.append('\'');
        sb.append(", adUnit='");
        sb.append(this.adUnit);
        sb.append('\'');
        sb.append(", country='");
        sb.append(this.country);
        sb.append('\'');
        sb.append(", ab='");
        sb.append(this.ab);
        sb.append('\'');
        sb.append(", segmentName='");
        sb.append(this.segmentName);
        sb.append('\'');
        sb.append(", placement='");
        sb.append(this.placement);
        sb.append('\'');
        sb.append(", adNetwork='");
        sb.append(this.adNetwork);
        sb.append('\'');
        sb.append(", instanceName='");
        sb.append(this.instanceName);
        sb.append('\'');
        sb.append(", instanceId='");
        sb.append(this.instanceId);
        sb.append('\'');
        sb.append(", revenue=");
        Double d = this.revenue;
        String str2 = null;
        if (d == null) {
            str = null;
        } else {
            str = this.df.format(d);
        }
        sb.append(str);
        sb.append(", precision='");
        sb.append(this.precision);
        sb.append('\'');
        sb.append(", lifetimeRevenue=");
        Double d2 = this.lifetimeRevenue;
        if (d2 != null) {
            str2 = this.df.format(d2);
        }
        sb.append(str2);
        sb.append(", encryptedCPM='");
        sb.append(this.encryptedCPM);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getAuctionId() {
        return this.auctionId;
    }

    public String getAdUnit() {
        return this.adUnit;
    }

    public String getCountry() {
        return this.country;
    }

    public String getAb() {
        return this.ab;
    }

    public String getSegmentName() {
        return this.segmentName;
    }

    public String getPlacement() {
        return this.placement;
    }

    public String getAdNetwork() {
        return this.adNetwork;
    }

    public String getInstanceName() {
        return this.instanceName;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public Double getRevenue() {
        return this.revenue;
    }

    public String getPrecision() {
        return this.precision;
    }

    public Double getLifetimeRevenue() {
        return this.lifetimeRevenue;
    }

    public String getEncryptedCPM() {
        return this.encryptedCPM;
    }

    public JSONObject getAllData() {
        return this.allData;
    }
}
