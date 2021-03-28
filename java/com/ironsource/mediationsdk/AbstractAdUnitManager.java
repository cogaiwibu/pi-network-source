package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.BaseApi;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.CopyOnWriteArrayList;

abstract class AbstractAdUnitManager implements BaseApi {
    final String KEY_PLACEMENT = IronSourceConstants.EVENTS_PLACEMENT_NAME;
    final String KEY_PROVIDER_PRIORITY = "providerPriority";
    final String KEY_REASON = IronSourceConstants.EVENTS_ERROR_REASON;
    final String KEY_REWARD_AMOUNT = IronSourceConstants.EVENTS_REWARD_AMOUNT;
    final String KEY_REWARD_NAME = IronSourceConstants.EVENTS_REWARD_NAME;
    final String KEY_STATUS = "status";
    String mAppKey;
    boolean mBackFillInitStarted;
    private AbstractSmash mBackfillSmash;
    boolean mCanShowPremium = true;
    DailyCappingManager mDailyCappingManager = null;
    Boolean mLastMediationAvailabilityState;
    IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private AbstractSmash mPremiumSmash;
    boolean mShouldTrackNetworkState = false;
    int mSmartLoadAmount;
    final CopyOnWriteArrayList<AbstractSmash> mSmashArray = new CopyOnWriteArrayList<>();
    String mUserId;

    @Override // com.ironsource.mediationsdk.sdk.BaseApi
    public void setMediationSegment(String str) {
    }

    /* access modifiers changed from: package-private */
    public abstract void shouldTrackNetworkState(Context context, boolean z);

    AbstractAdUnitManager() {
    }

    /* access modifiers changed from: package-private */
    public void setSmartLoadAmount(int i) {
        this.mSmartLoadAmount = i;
    }

    /* access modifiers changed from: package-private */
    public void addSmashToArray(AbstractSmash abstractSmash) {
        this.mSmashArray.add(abstractSmash);
        DailyCappingManager dailyCappingManager = this.mDailyCappingManager;
        if (dailyCappingManager != null) {
            dailyCappingManager.addSmash(abstractSmash);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackfillSmash(AbstractSmash abstractSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, abstractSmash.getInstanceName() + " is set as backfill", 0);
        this.mBackfillSmash = abstractSmash;
    }

    /* access modifiers changed from: package-private */
    public void setPremiumSmash(AbstractSmash abstractSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        ironSourceLoggerManager.log(ironSourceTag, abstractSmash.getInstanceName() + " is set as premium", 0);
        this.mPremiumSmash = abstractSmash;
    }

    /* access modifiers changed from: package-private */
    public AbstractSmash getBackfillSmash() {
        return this.mBackfillSmash;
    }

    /* access modifiers changed from: package-private */
    public AbstractSmash getPremiumSmash() {
        return this.mPremiumSmash;
    }

    /* access modifiers changed from: package-private */
    public void setCustomParams(AbstractSmash abstractSmash) {
        try {
            String mediationSegment = IronSourceObject.getInstance().getMediationSegment();
            if (!TextUtils.isEmpty(mediationSegment)) {
                abstractSmash.setMediationSegment(mediationSegment);
            }
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                abstractSmash.setPluginData(pluginType, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
        } catch (Exception e) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, ":setCustomParams():" + e.toString(), 3);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean canShowPremium() {
        return this.mCanShowPremium;
    }

    /* access modifiers changed from: package-private */
    public synchronized void disablePremiumForCurrentSession() {
        this.mCanShowPremium = false;
    }
}
