package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.AdapterConfig;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class LWSProgRvSmash extends ProgSmash implements RewardedVideoSmashListener {
    private String mAppKey;
    private String mAuctionFailReason;
    private String mAuctionId;
    private int mAuctionTrial;
    private long mClosedTime;
    private JSONObject mGenericParams;
    private LWSRvManagerListener mListener;
    private long mLoadStartTime;
    private int mLoadTimeoutSecs;
    private Placement mPlacement;
    private SMASH_STATE mState;
    private final Object mStateLock;
    private Timer mTimer;
    private final Object mTimerLock;
    private String mUserId;

    /* access modifiers changed from: protected */
    public enum SMASH_STATE {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    private boolean shouldAddAuctionParams(int i) {
        return i == 1001 || i == 1002 || i == 1200 || i == 1005 || i == 1203 || i == 1201 || i == 1202 || i == 1006 || i == 1010;
    }

    @Override // com.ironsource.mediationsdk.ProgSmash
    public int getProgrammaticValue() {
        return 2;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }

    public LWSProgRvSmash(String str, String str2, ProviderSettings providerSettings, LWSRvManagerListener lWSRvManagerListener, int i, AbstractAdapter abstractAdapter, int i2) {
        super(new AdapterConfig(providerSettings, providerSettings.getRewardedVideoSettings()), abstractAdapter);
        this.mStateLock = new Object();
        this.mTimerLock = new Object();
        this.mAppKey = str;
        this.mUserId = str2;
        this.mListener = lWSRvManagerListener;
        this.mTimer = null;
        this.mLoadTimeoutSecs = i;
        this.mAdapter.updateRewardedVideoListener(this);
        this.mSessionDepth = i2;
        this.mState = SMASH_STATE.NO_INIT;
        this.mClosedTime = 0;
        if (this.mAdapterConfig.isBidder()) {
            initForBidding();
        }
    }

    public LWSProgRvSmash(LWSProgRvSmash lWSProgRvSmash, LWSRvManagerListener lWSRvManagerListener, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2) {
        this(lWSProgRvSmash.mAppKey, lWSProgRvSmash.mUserId, lWSProgRvSmash.mAdapterConfig.getProviderSettings(), lWSRvManagerListener, lWSProgRvSmash.mLoadTimeoutSecs, abstractAdapter, i);
        this.mAuctionId = str;
        this.mGenericParams = jSONObject;
        this.mAuctionTrial = i2;
        this.mAuctionFailReason = str2;
    }

    public boolean isLoadingInProgress() {
        return this.mState == SMASH_STATE.INIT_IN_PROGRESS || this.mState == SMASH_STATE.LOAD_IN_PROGRESS;
    }

    public boolean isLoaded() {
        return this.mState == SMASH_STATE.LOADED;
    }

    public Map<String, Object> getBiddingData() {
        try {
            if (isBidder()) {
                return this.mAdapter.getRewardedVideoBiddingData(this.mAdUnitSettings);
            }
            return null;
        } catch (Throwable th) {
            logInternalError("getBiddingData exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_biddingDataException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    private void initForBidding() {
        logInternal("initForBidding()");
        setState(SMASH_STATE.INIT_IN_PROGRESS);
        setCustomParams();
        try {
            this.mAdapter.initRewardedVideoForBidding(this.mAppKey, this.mUserId, this.mAdUnitSettings, this);
        } catch (Throwable th) {
            logInternalError("initForBidding exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public boolean isRewardedVideoAvailable() {
        return this.mAdapter.isRewardedVideoAvailable(this.mAdUnitSettings);
    }

    public boolean isReadyToShow() {
        try {
            if (!isBidder()) {
                return isRewardedVideoAvailable();
            }
            if (this.mState != SMASH_STATE.LOADED || !isRewardedVideoAvailable()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            logInternalError("isReadyToShow exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_isReadyException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return false;
        }
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState() {
        return this.mAdapter.getLoadWhileShowSupportState(this.mAdUnitSettings);
    }

    public void loadVideo(String str) {
        SMASH_STATE smash_state;
        logInternal("loadVideo() auctionId: " + this.mAuctionId + " state: " + this.mState);
        this.expirationTimestamp = null;
        setIsLoadCandidate(false);
        synchronized (this.mStateLock) {
            smash_state = this.mState;
            if (!(this.mState == SMASH_STATE.LOAD_IN_PROGRESS || this.mState == SMASH_STATE.SHOW_IN_PROGRESS)) {
                setState(SMASH_STATE.LOAD_IN_PROGRESS);
            }
        }
        if (smash_state == SMASH_STATE.LOAD_IN_PROGRESS) {
            sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_loadInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during load"}});
        } else if (smash_state == SMASH_STATE.SHOW_IN_PROGRESS) {
            sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_showInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during show"}});
        } else {
            startLoadTimer();
            this.mLoadStartTime = new Date().getTime();
            sendProviderEvent(1001);
            try {
                if (isBidder()) {
                    this.mAdapter.loadRewardedVideoForBidding(this.mAdUnitSettings, this, str);
                    return;
                }
                setCustomParams();
                this.mAdapter.initRewardedVideo(this.mAppKey, this.mUserId, this.mAdUnitSettings, this);
            } catch (Throwable th) {
                logInternalError("loadVideo exception: " + th.getLocalizedMessage());
                th.printStackTrace();
                sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_loadException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            }
        }
    }

    public void reportShowChance(boolean z) {
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z ? "true" : "false";
        objArr[0] = objArr2;
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr);
    }

    public void showVideo(Placement placement) {
        stopLoadTimer();
        logInternal("showVideo()");
        this.mPlacement = placement;
        setState(SMASH_STATE.SHOW_IN_PROGRESS);
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_SHOW);
        try {
            this.mAdapter.showRewardedVideo(this.mAdUnitSettings, this);
        } catch (Throwable th) {
            logInternalError("showVideo exception: " + th.getLocalizedMessage());
            th.printStackTrace();
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public void setCappedPerSession() {
        this.mAdapter.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, IronSourceConstants.AD_UNIT_RV_MEDIATION_STATE);
        sendProviderEvent(IronSourceConstants.RV_CAP_SESSION);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setState(SMASH_STATE smash_state) {
        logInternal("current state=" + this.mState + ", new state=" + smash_state);
        synchronized (this.mStateLock) {
            this.mState = smash_state;
        }
    }

    private void setCustomParams() {
        try {
            String mediationSegment = IronSourceObject.getInstance().getMediationSegment();
            if (!TextUtils.isEmpty(mediationSegment)) {
                this.mAdapter.setMediationSegment(mediationSegment);
            }
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.mAdapter.setPluginData(pluginType, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
        } catch (Exception e) {
            logInternal("setCustomParams() " + e.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z) {
        boolean z2;
        logInternal("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.mState.name());
        synchronized (this.mStateLock) {
            if (this.mState == SMASH_STATE.LOAD_IN_PROGRESS) {
                setState(z ? SMASH_STATE.LOADED : SMASH_STATE.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            stopLoadTimer();
            sendProviderEvent(z ? 1002 : IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}});
            if (z) {
                this.mListener.onLoadSuccess(this);
            } else {
                this.mListener.onLoadError(this);
            }
        } else if (z) {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.mState.name()}});
        } else {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.mState.name()}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.expirationTimestamp = Long.valueOf(System.currentTimeMillis());
        }
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}});
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        logInternal("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        synchronized (this.mStateLock) {
            if (this.mState != SMASH_STATE.SHOW_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_showFailed)};
                sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showFailed: " + this.mState}});
                return;
            }
            setState(SMASH_STATE.ENDED);
            this.mListener.onRewardedVideoAdShowFailed(ironSourceError, this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
        logInternal("onRewardedVideoInitSuccess");
        synchronized (this.mStateLock) {
            if (this.mState != SMASH_STATE.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_initSuccess)};
                sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initSuccess: " + this.mState}});
                return;
            }
            setState(SMASH_STATE.NOT_LOADED);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        logInternal("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        stopLoadTimer();
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}});
        sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(getElapsedTime())}});
        synchronized (this.mStateLock) {
            if (this.mState != SMASH_STATE.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_initFailed)};
                sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initFailed: " + this.mState}});
                return;
            }
            setState(SMASH_STATE.NO_INIT);
            this.mListener.onLoadError(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        logInternal("onRewardedVideoAdOpened");
        this.mListener.onRewardedVideoAdOpened(this);
        sendProviderEventWithPlacement(1005);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        logInternal("onRewardedVideoAdStarted");
        this.mListener.onRewardedVideoAdStarted(this);
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_STARTED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        logInternal("onRewardedVideoAdVisible");
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_VISIBLE);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        logInternal("onRewardedVideoAdClosed");
        synchronized (this.mStateLock) {
            if (this.mState != SMASH_STATE.SHOW_IN_PROGRESS) {
                sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_CLOSED);
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf((int) IronSourceConstants.errorCode_adClosed)};
                sendProviderEvent(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "adClosed: " + this.mState}});
                return;
            }
            setState(SMASH_STATE.ENDED);
            this.mClosedTime = new Date().getTime();
            this.mListener.onRewardedVideoAdClosed(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        logInternal("onRewardedVideoAdEnded");
        this.mListener.onRewardedVideoAdEnded(this);
        sendProviderEventWithPlacement(IronSourceConstants.RV_INSTANCE_ENDED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        logInternal("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.mListener.onRewardedVideoAdRewarded(this, this.mPlacement);
        Map<String, Object> providerEventData = getProviderEventData();
        Placement placement = this.mPlacement;
        if (placement != null) {
            providerEventData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, placement.getPlacementName());
            providerEventData.put(IronSourceConstants.EVENTS_REWARD_NAME, this.mPlacement.getRewardName());
            providerEventData.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.mPlacement.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().getDynamicUserId())) {
            providerEventData.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceObject.getInstance().getDynamicUserId());
        }
        if (IronSourceObject.getInstance().getRvServerParams() != null) {
            for (String str : IronSourceObject.getInstance().getRvServerParams().keySet()) {
                providerEventData.put("custom_" + str, IronSourceObject.getInstance().getRvServerParams().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.mAuctionId)) {
            providerEventData.put("auctionId", this.mAuctionId);
        }
        JSONObject jSONObject = this.mGenericParams;
        if (jSONObject != null && jSONObject.length() > 0) {
            providerEventData.put("genericParams", this.mGenericParams);
        }
        if (shouldAddAuctionParams(1010)) {
            RewardedVideoEventsManager.getInstance().setEventAuctionParams(providerEventData, this.mAuctionTrial, this.mAuctionFailReason);
        }
        providerEventData.put("sessionDepth", Integer.valueOf(this.mSessionDepth));
        EventData eventData = new EventData(1010, new JSONObject(providerEventData));
        eventData.addToAdditionalData(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId("" + Long.toString(eventData.getTimeStamp()) + this.mAppKey + getInstanceName()));
        long j = this.mClosedTime;
        if (j != 0) {
            long j2 = time - j;
            logInternal("onRewardedVideoAdRewarded timeAfterClosed=" + j2);
            eventData.addToAdditionalData(IronSourceConstants.EVENTS_DURATION, Long.valueOf(j2));
        }
        RewardedVideoEventsManager.getInstance().log(eventData);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        logInternal("onRewardedVideoAdClicked");
        this.mListener.onRewardedVideoAdClicked(this, this.mPlacement);
        sendProviderEventWithPlacement(1006);
    }

    private void stopLoadTimer() {
        synchronized (this.mTimerLock) {
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long getElapsedTime() {
        return new Date().getTime() - this.mLoadStartTime;
    }

    private void startLoadTimer() {
        synchronized (this.mTimerLock) {
            Timer timer = new Timer();
            this.mTimer = timer;
            timer.schedule(new TimerTask() {
                /* class com.ironsource.mediationsdk.LWSProgRvSmash.AnonymousClass1 */

                public void run() {
                    boolean z;
                    int i;
                    String str = "Rewarded Video - load instance time out";
                    if (LWSProgRvSmash.this.mState == SMASH_STATE.LOAD_IN_PROGRESS || LWSProgRvSmash.this.mState == SMASH_STATE.INIT_IN_PROGRESS) {
                        if (LWSProgRvSmash.this.mState == SMASH_STATE.LOAD_IN_PROGRESS) {
                            i = 1025;
                        } else {
                            i = IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT;
                            str = "Rewarded Video - init instance time out";
                        }
                        LWSProgRvSmash.this.setState(SMASH_STATE.NOT_LOADED);
                        z = true;
                    } else {
                        i = IronSourceError.ERROR_CODE_GENERIC;
                        z = false;
                    }
                    LWSProgRvSmash.this.logInternal(str);
                    if (z) {
                        LWSProgRvSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(LWSProgRvSmash.this.getElapsedTime())}});
                        LWSProgRvSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(LWSProgRvSmash.this.getElapsedTime())}});
                        LWSProgRvSmash.this.mListener.onLoadError(LWSProgRvSmash.this);
                        return;
                    }
                    LWSProgRvSmash.this.sendProviderEvent(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{IronSourceConstants.EVENTS_DURATION, Long.valueOf(LWSProgRvSmash.this.getElapsedTime())}, new Object[]{IronSourceConstants.EVENTS_EXT1, LWSProgRvSmash.this.mState.name()}});
                }
            }, (long) (this.mLoadTimeoutSecs * 1000));
        }
    }

    public String getAuctionId() {
        return this.mAuctionId;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void logInternal(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + getInstanceName() + " " + hashCode() + "  : " + str, 0);
    }

    private void logInternalError(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvSmash " + getInstanceName() + " " + hashCode() + " : " + str, 3);
    }

    private void sendProviderEventWithPlacement(int i) {
        sendProviderEventWithPlacement(i, null);
    }

    public void sendProviderEventWithPlacement(int i, Object[][] objArr) {
        sendProviderEvent(i, objArr, true);
    }

    private void sendProviderEvent(int i) {
        sendProviderEvent(i, null, false);
    }

    public void sendProviderEvent(int i, Object[][] objArr) {
        sendProviderEvent(i, objArr, false);
    }

    private void sendProviderEvent(int i, Object[][] objArr, boolean z) {
        Placement placement;
        Map<String, Object> providerEventData = getProviderEventData();
        if (!TextUtils.isEmpty(this.mAuctionId)) {
            providerEventData.put("auctionId", this.mAuctionId);
        }
        JSONObject jSONObject = this.mGenericParams;
        if (jSONObject != null && jSONObject.length() > 0) {
            providerEventData.put("genericParams", this.mGenericParams);
        }
        if (z && (placement = this.mPlacement) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            providerEventData.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, this.mPlacement.getPlacementName());
        }
        if (shouldAddAuctionParams(i)) {
            RewardedVideoEventsManager.getInstance().setEventAuctionParams(providerEventData, this.mAuctionTrial, this.mAuctionFailReason);
        }
        providerEventData.put("sessionDepth", Integer.valueOf(this.mSessionDepth));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    providerEventData.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, getInstanceName() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        RewardedVideoEventsManager.getInstance().log(new EventData(i, new JSONObject(providerEventData)));
        if (i == 1203) {
            SessionDepthManager.getInstance().increaseSessionDepth(1);
        }
    }
}
