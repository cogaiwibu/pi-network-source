package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class DemandOnlySmash {
    protected JSONObject mAdUnitSettings;
    protected AbstractAdapter mAdapter;
    protected AdapterConfig mAdapterConfig;
    protected String mAuctionId;
    protected List<String> mBUrl;
    protected String mDynamicDemandSourceId;
    protected JSONObject mGenericParams;
    int mLoadTimeoutSecs;
    private Timer mLoadTimer;
    private SMASH_STATE mState;
    private final Object mStateLock = new Object();
    private final Object mTimerLock = new Object();

    /* access modifiers changed from: protected */
    public enum SMASH_STATE {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public DemandOnlySmash(AdapterConfig adapterConfig, AbstractAdapter abstractAdapter) {
        this.mAdapterConfig = adapterConfig;
        this.mAdapter = abstractAdapter;
        this.mAdUnitSettings = adapterConfig.getAdUnitSetings();
        this.mState = SMASH_STATE.NOT_LOADED;
        this.mLoadTimer = null;
        this.mAuctionId = "";
        this.mGenericParams = null;
        this.mBUrl = new ArrayList();
    }

    public String getInstanceName() {
        return this.mAdapterConfig.getProviderName();
    }

    public int getInstanceType() {
        return this.mAdapterConfig.getInstanceType();
    }

    public String getSubProviderId() {
        return this.mAdapterConfig.getSubProviderId();
    }

    public String getAuctionId() {
        return this.mAuctionId;
    }

    public List<String> getbURL() {
        return this.mBUrl;
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
            hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            if (isBidder()) {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                hashMap.put(IronSourceConstants.EVENTS_INSTANCE_TYPE, 2);
                if (!TextUtils.isEmpty(this.mAuctionId)) {
                    hashMap.put("auctionId", this.mAuctionId);
                }
                if (this.mGenericParams != null && this.mGenericParams.length() > 0) {
                    hashMap.put("genericParams", this.mGenericParams);
                }
            } else {
                hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 0);
                hashMap.put(IronSourceConstants.EVENTS_INSTANCE_TYPE, 1);
            }
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

    /* access modifiers changed from: package-private */
    public boolean compareAndSetState(SMASH_STATE smash_state, SMASH_STATE smash_state2) {
        synchronized (this.mStateLock) {
            if (this.mState != smash_state) {
                return false;
            }
            setState(smash_state2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public SMASH_STATE compareAndSetState(SMASH_STATE[] smash_stateArr, SMASH_STATE smash_state) {
        SMASH_STATE smash_state2;
        synchronized (this.mStateLock) {
            smash_state2 = this.mState;
            if (Arrays.asList(smash_stateArr).contains(this.mState)) {
                setState(smash_state);
            }
        }
        return smash_state2;
    }

    /* access modifiers changed from: package-private */
    public void setState(SMASH_STATE smash_state) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlySmash " + this.mAdapterConfig.getProviderName() + ": current state=" + this.mState + ", new state=" + smash_state, 0);
        synchronized (this.mStateLock) {
            this.mState = smash_state;
        }
    }

    /* access modifiers changed from: package-private */
    public String getStateString() {
        SMASH_STATE smash_state = this.mState;
        return smash_state == null ? "null" : smash_state.toString();
    }

    /* access modifiers changed from: package-private */
    public void startTimer(TimerTask timerTask) {
        synchronized (this.mTimerLock) {
            stopTimer();
            Timer timer = new Timer();
            this.mLoadTimer = timer;
            timer.schedule(timerTask, (long) (this.mLoadTimeoutSecs * 1000));
        }
    }

    /* access modifiers changed from: package-private */
    public void stopTimer() {
        synchronized (this.mTimerLock) {
            if (this.mLoadTimer != null) {
                this.mLoadTimer.cancel();
                this.mLoadTimer = null;
            }
        }
    }

    public boolean isBidder() {
        return this.mAdapterConfig.isBidder();
    }

    public AdapterConfig getAdapterConfig() {
        return this.mAdapterConfig;
    }

    public void setDynamicDemandSourceIdByServerData(String str) {
        this.mDynamicDemandSourceId = AuctionDataUtils.getInstance().getDynamicDemandSourceIdFromServerData(str);
    }

    public void setAuctionId(String str) {
        this.mAuctionId = str;
    }

    public void setGenericParams(JSONObject jSONObject) {
        this.mGenericParams = jSONObject;
    }
}
