package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

public class AdapterConfig {
    private JSONObject mAdUnitSettings;
    private int mInstanceType;
    private boolean mIsBidder;
    private int mMaxAdsPerSession;
    private ProviderSettings mProviderSettings;

    public AdapterConfig(ProviderSettings providerSettings, JSONObject jSONObject) {
        this.mProviderSettings = providerSettings;
        this.mAdUnitSettings = jSONObject;
        int optInt = jSONObject.optInt(IronSourceConstants.EVENTS_INSTANCE_TYPE);
        this.mInstanceType = optInt;
        this.mIsBidder = optInt == 2;
        this.mMaxAdsPerSession = jSONObject.optInt("maxAdsPerSession", 99);
    }

    public JSONObject getAdUnitSetings() {
        return this.mAdUnitSettings;
    }

    public boolean isBidder() {
        return this.mIsBidder;
    }

    public int getInstanceType() {
        return this.mInstanceType;
    }

    public int getMaxAdsPerSession() {
        return this.mMaxAdsPerSession;
    }

    public String getProviderName() {
        return this.mProviderSettings.getProviderName();
    }

    public String getSubProviderId() {
        return this.mProviderSettings.getSubProviderId();
    }

    public String getAdSourceNameForEvents() {
        return this.mProviderSettings.getAdSourceNameForEvents();
    }

    public String getProviderNameForReflection() {
        return this.mProviderSettings.getProviderTypeForReflection();
    }

    public ProviderSettings getProviderSettings() {
        return this.mProviderSettings;
    }
}
