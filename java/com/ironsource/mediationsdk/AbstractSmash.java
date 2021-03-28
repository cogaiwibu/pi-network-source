package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BaseApi;
import java.util.HashSet;
import java.util.Timer;

public abstract class AbstractSmash implements BaseApi {
    public static final int MAX_ADS_PER_DAY_DEFAULT_VALUE = 99;
    final String MAX_ADS_PER_DAY_KEY = "maxAdsPerDay";
    final String MAX_ADS_PER_ITERATION_KEY = "maxAdsPerIteration";
    final String MAX_ADS_PER_SESSION_KEY = "maxAdsPerSession";
    protected Long adLoadSuccessTimeStamp;
    protected Long expirationTimestamp;
    String mAdSourceNameForEvents;
    AbstractAdapter mAdapter;
    ProviderSettings mAdapterConfigs;
    Timer mInitTimer;
    String mInstanceName;
    boolean mIsMultipleInstances;
    int mIterationShowCounter;
    Timer mLoadTimer;
    IronSourceLoggerManager mLoggerManager;
    int mMaxAdsPerDay;
    int mMaxAdsPerIteration;
    int mMaxAdsPerSession;
    MEDIATION_STATE mMediationState;
    String mNameForReflection;
    int mProviderPriority;
    int mSessionShowCounter;
    String mSpId;

    /* access modifiers changed from: package-private */
    public abstract void completeIteration();

    /* access modifiers changed from: protected */
    public abstract String getAdUnitString();

    /* access modifiers changed from: package-private */
    public abstract void startInitTimer();

    /* access modifiers changed from: package-private */
    public abstract void startLoadTimer();

    public enum MEDIATION_STATE {
        NOT_INITIATED(0),
        INIT_FAILED(1),
        INITIATED(2),
        AVAILABLE(3),
        NOT_AVAILABLE(4),
        EXHAUSTED(5),
        CAPPED_PER_SESSION(6),
        INIT_PENDING(7),
        LOAD_PENDING(8),
        CAPPED_PER_DAY(9),
        NEEDS_RELOAD(10);
        
        private int mValue;

        private MEDIATION_STATE(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    AbstractSmash(ProviderSettings providerSettings) {
        this.mNameForReflection = providerSettings.getProviderTypeForReflection();
        this.mInstanceName = providerSettings.getProviderInstanceName();
        this.mIsMultipleInstances = providerSettings.isMultipleInstances();
        this.mAdapterConfigs = providerSettings;
        this.mSpId = providerSettings.getSubProviderId();
        this.mAdSourceNameForEvents = providerSettings.getAdSourceNameForEvents();
        this.mIterationShowCounter = 0;
        this.mSessionShowCounter = 0;
        this.mMediationState = MEDIATION_STATE.NOT_INITIATED;
        this.mLoggerManager = IronSourceLoggerManager.getLogger();
        this.adLoadSuccessTimeStamp = null;
        this.expirationTimestamp = null;
    }

    /* access modifiers changed from: package-private */
    public void setAdapterForSmash(AbstractAdapter abstractAdapter) {
        this.mAdapter = abstractAdapter;
    }

    /* access modifiers changed from: package-private */
    public boolean isExhausted() {
        return this.mIterationShowCounter >= this.mMaxAdsPerIteration;
    }

    /* access modifiers changed from: package-private */
    public boolean isCappedPerSession() {
        return this.mSessionShowCounter >= this.mMaxAdsPerSession;
    }

    /* access modifiers changed from: package-private */
    public boolean isCappedPerDay() {
        return this.mMediationState == MEDIATION_STATE.CAPPED_PER_DAY;
    }

    /* access modifiers changed from: package-private */
    public boolean isMediationAvailable() {
        return !isExhausted() && !isCappedPerSession() && !isCappedPerDay();
    }

    /* access modifiers changed from: package-private */
    public void preShow() {
        this.mIterationShowCounter++;
        this.mSessionShowCounter++;
        if (isCappedPerSession()) {
            setMediationState(MEDIATION_STATE.CAPPED_PER_SESSION);
        } else if (isExhausted()) {
            setMediationState(MEDIATION_STATE.EXHAUSTED);
        }
    }

    /* access modifiers changed from: package-private */
    public void stopInitTimer() {
        try {
            if (this.mInitTimer != null) {
                this.mInitTimer.cancel();
            }
        } catch (Exception e) {
            logException("stopInitTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mInitTimer = null;
            throw th;
        }
        this.mInitTimer = null;
    }

    /* access modifiers changed from: package-private */
    public void stopLoadTimer() {
        try {
            if (this.mLoadTimer != null) {
                this.mLoadTimer.cancel();
            }
        } catch (Exception e) {
            logException("stopLoadTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mLoadTimer = null;
            throw th;
        }
        this.mLoadTimer = null;
    }

    /* access modifiers changed from: package-private */
    public void setPluginData(String str, String str2) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.setPluginData(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public MEDIATION_STATE getMediationState() {
        return this.mMediationState;
    }

    /* access modifiers changed from: package-private */
    public String getNameForReflection() {
        return this.mNameForReflection;
    }

    /* access modifiers changed from: package-private */
    public String getInstanceName() {
        return this.mInstanceName;
    }

    public String getName() {
        if (this.mIsMultipleInstances) {
            return this.mNameForReflection;
        }
        return this.mInstanceName;
    }

    public String getSubProviderId() {
        return this.mSpId;
    }

    public String getAdSourceNameForEvents() {
        if (!TextUtils.isEmpty(this.mAdSourceNameForEvents)) {
            return this.mAdSourceNameForEvents;
        }
        return getName();
    }

    /* access modifiers changed from: package-private */
    public int getMaxAdsPerSession() {
        return this.mMaxAdsPerSession;
    }

    /* access modifiers changed from: package-private */
    public int getMaxAdsPerIteration() {
        return this.mMaxAdsPerIteration;
    }

    public int getMaxAdsPerDay() {
        return this.mMaxAdsPerDay;
    }

    public AbstractAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getProviderPriority() {
        return this.mProviderPriority;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setMediationState(MEDIATION_STATE mediation_state) {
        if (this.mMediationState != mediation_state) {
            this.mMediationState = mediation_state;
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "Smart Loading - " + getInstanceName() + " state changed to " + mediation_state.toString(), 0);
            if (this.mAdapter != null && (mediation_state == MEDIATION_STATE.CAPPED_PER_SESSION || mediation_state == MEDIATION_STATE.CAPPED_PER_DAY)) {
                this.mAdapter.setMediationState(mediation_state, getAdUnitString());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BaseApi
    public void setMediationSegment(String str) {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag, getName() + ":setMediationSegment(segment:" + str + ")", 1);
            this.mAdapter.setMediationSegment(str);
        }
    }

    public HashSet<String> getAllSettingsForProvider(String str) {
        return IronSourceObject.getInstance().getAllSettingsForProvider(this.mNameForReflection, str);
    }

    /* access modifiers changed from: package-private */
    public void setProviderPriority(int i) {
        this.mProviderPriority = i;
    }

    /* access modifiers changed from: package-private */
    public void logException(String str, String str2) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, str + " exception: " + getInstanceName() + " | " + str2, 3);
    }

    public Long getAdLoadSuccessTimeStamp() {
        return this.adLoadSuccessTimeStamp;
    }

    public Long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }
}
