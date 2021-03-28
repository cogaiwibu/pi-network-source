package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class ProgSmash {
    protected Long expirationTimestamp = null;
    protected JSONObject mAdUnitSettings;
    protected AbstractAdapter mAdapter;
    protected AdapterConfig mAdapterConfig;
    protected String mDynamicDemandSourceId;
    private boolean mIsLoadCandidate;
    protected int mSessionDepth;

    public int getProgrammaticValue() {
        return 1;
    }

    ProgSmash(AdapterConfig adapterConfig, AbstractAdapter abstractAdapter) {
        this.mAdapterConfig = adapterConfig;
        this.mAdapter = abstractAdapter;
        this.mAdUnitSettings = adapterConfig.getAdUnitSetings();
    }

    public boolean isBidder() {
        return this.mAdapterConfig.isBidder();
    }

    public int getInstanceType() {
        return this.mAdapterConfig.getInstanceType();
    }

    public int getMaxAdsPerSession() {
        return this.mAdapterConfig.getMaxAdsPerSession();
    }

    public String getInstanceName() {
        return this.mAdapterConfig.getProviderName();
    }

    public String getNameForReflection() {
        return this.mAdapterConfig.getProviderNameForReflection();
    }

    public void setIsLoadCandidate(boolean z) {
        this.mIsLoadCandidate = z;
    }

    public boolean getIsLoadCandidate() {
        return this.mIsLoadCandidate;
    }

    public int getSessionDepth() {
        return this.mSessionDepth;
    }

    public Map<String, Object> getProviderEventData() {
        HashMap hashMap = new HashMap();
        try {
            String str = "";
            hashMap.put("providerAdapterVersion", this.mAdapter != null ? this.mAdapter.getVersion() : str);
            if (this.mAdapter != null) {
                str = this.mAdapter.getCoreSDKVersion();
            }
            hashMap.put("providerSDKVersion", str);
            hashMap.put("spId", this.mAdapterConfig.getSubProviderId());
            hashMap.put(IronSourceConstants.EVENTS_PROVIDER, this.mAdapterConfig.getAdSourceNameForEvents());
            hashMap.put(IronSourceConstants.EVENTS_INSTANCE_TYPE, Integer.valueOf(isBidder() ? 2 : 1));
            hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(getProgrammaticValue()));
            if (!TextUtils.isEmpty(this.mDynamicDemandSourceId)) {
                hashMap.put(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID, this.mDynamicDemandSourceId);
            }
        } catch (Exception e) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "getProviderEventData " + getInstanceName() + ")", e);
        }
        return hashMap;
    }

    public void setDynamicDemandSourceIdByServerData(String str) {
        this.mDynamicDemandSourceId = AuctionDataUtils.getInstance().getDynamicDemandSourceIdFromServerData(str);
    }

    public Long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }
}
