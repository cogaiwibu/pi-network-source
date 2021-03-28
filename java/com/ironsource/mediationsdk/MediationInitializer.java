package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.environment.CrashReporter;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.NetworkStateReceiverListener;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.config.ConfigValidationResult;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ApplicationCrashReporterSettings;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.mediationsdk.sdk.GeneralProperties;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public class MediationInitializer implements NetworkStateReceiverListener {
    private static MediationInitializer sInstance;
    private final String GENERAL_PROPERTIES_APP_KEY = "appKey";
    private final String TAG = getClass().getSimpleName();
    private InitRunnable initRunnable = new InitRunnable() {
        /* class com.ironsource.mediationsdk.MediationInitializer.AnonymousClass1 */

        public void run() {
            ServerSegmetData segmetData;
            try {
                IronSourceObject instance = IronSourceObject.getInstance();
                TokenDataService.getInstance().collectAdvertisingData();
                if (MediationInitializer.this.validateUserId(MediationInitializer.this.mUserId).isValid()) {
                    MediationInitializer.this.mUserIdType = IronSourceConstants.TYPE_USER_GENERATED;
                } else {
                    MediationInitializer.this.mUserId = instance.getAdvertiserId(ContextProvider.getInstance().getApplicationContext());
                    if (!TextUtils.isEmpty(MediationInitializer.this.mUserId)) {
                        MediationInitializer.this.mUserIdType = IronSourceConstants.TYPE_GAID;
                    } else {
                        MediationInitializer.this.mUserId = DeviceStatus.getOrGenerateOnceUniqueIdentifier(ContextProvider.getInstance().getApplicationContext());
                        if (!TextUtils.isEmpty(MediationInitializer.this.mUserId)) {
                            MediationInitializer.this.mUserIdType = IronSourceConstants.TYPE_UUID;
                        } else {
                            MediationInitializer.this.mUserId = "";
                        }
                    }
                    instance.setIronSourceUserId(MediationInitializer.this.mUserId, false);
                }
                GeneralProperties.getProperties().putKey(GeneralProperties.USER_ID_TYPE, MediationInitializer.this.mUserIdType);
                if (!TextUtils.isEmpty(MediationInitializer.this.mUserId)) {
                    GeneralProperties.getProperties().putKey("userId", MediationInitializer.this.mUserId);
                }
                if (!TextUtils.isEmpty(MediationInitializer.this.mAppKey)) {
                    GeneralProperties.getProperties().putKey("appKey", MediationInitializer.this.mAppKey);
                }
                MediationInitializer.this.mInitStartTime = new Date().getTime();
                MediationInitializer.this.mServerResponseWrapper = instance.getServerResponse(ContextProvider.getInstance().getApplicationContext(), MediationInitializer.this.mUserId, this.listener);
                if (MediationInitializer.this.mServerResponseWrapper != null) {
                    MediationInitializer.this.mHandler.removeCallbacks(this);
                    if (MediationInitializer.this.mServerResponseWrapper.isValidResponse()) {
                        MediationInitializer.this.setInitStatus(EInitStatus.INITIATED);
                        instance.sendInitCompletedEvent(new Date().getTime() - MediationInitializer.this.mInitStartTime);
                        if (MediationInitializer.this.mServerResponseWrapper.getConfigurations().getApplicationConfigurations().getIntegration() && ContextProvider.getInstance().getCurrentActiveActivity() != null) {
                            IntegrationHelper.validateIntegration(ContextProvider.getInstance().getCurrentActiveActivity());
                        }
                        List<IronSource.AD_UNIT> initiatedAdUnits = MediationInitializer.this.mServerResponseWrapper.getInitiatedAdUnits();
                        for (OnMediationInitializationListener onMediationInitializationListener : MediationInitializer.this.mOnMediationInitializationListeners) {
                            onMediationInitializationListener.onInitSuccess(initiatedAdUnits, MediationInitializer.this.wasInitRevived());
                        }
                        if (!(MediationInitializer.this.mSegmentListener == null || (segmetData = MediationInitializer.this.mServerResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData()) == null || TextUtils.isEmpty(segmetData.getSegmentName()))) {
                            MediationInitializer.this.mSegmentListener.onSegmentReceived(segmetData.getSegmentName());
                        }
                        ApplicationCrashReporterSettings crashReporterSettings = MediationInitializer.this.mServerResponseWrapper.getConfigurations().getApplicationConfigurations().getCrashReporterSettings();
                        if (crashReporterSettings.isCrashReporterEnabled()) {
                            CrashReporter.getInstance().init(ContextProvider.getInstance().getApplicationContext(), crashReporterSettings.getKeyParamsToIncludeInReporter(), crashReporterSettings.getReporterURL(), crashReporterSettings.getReporterKeyword(), crashReporterSettings.isANRIncluded(), IronSourceUtils.getSessionId(), crashReporterSettings.getDefaultAnrTimeout());
                        }
                    } else if (!MediationInitializer.this.mDidReportInitialAvailability) {
                        MediationInitializer.this.setInitStatus(EInitStatus.INIT_FAILED);
                        MediationInitializer.this.mDidReportInitialAvailability = true;
                        for (OnMediationInitializationListener onMediationInitializationListener2 : MediationInitializer.this.mOnMediationInitializationListeners) {
                            onMediationInitializationListener2.onInitFailed(IronSourceConstants.FALSE_AVAILABILITY_REASON_SERVER_RESPONSE_IS_NOT_VALID);
                        }
                    }
                } else {
                    if (MediationInitializer.this.mRetryCounter == 3) {
                        MediationInitializer.this.mIsInProgressMoreThan15Secs = true;
                        for (OnMediationInitializationListener onMediationInitializationListener3 : MediationInitializer.this.mOnMediationInitializationListeners) {
                            onMediationInitializationListener3.onStillInProgressAfter15Secs();
                        }
                    }
                    if (this.isRecoverable && MediationInitializer.this.mRetryCounter < MediationInitializer.this.mRetryLimit) {
                        MediationInitializer.this.mIsRevived = true;
                        MediationInitializer.this.mHandler.postDelayed(this, (long) (MediationInitializer.this.mRetryDelay * 1000));
                        if (MediationInitializer.this.mRetryCounter < MediationInitializer.this.mRetryGrowLimit) {
                            MediationInitializer.this.mRetryDelay *= 2;
                        }
                    }
                    if ((!this.isRecoverable || MediationInitializer.this.mRetryCounter == MediationInitializer.this.mRetryAvailabilityLimit) && !MediationInitializer.this.mDidReportInitialAvailability) {
                        MediationInitializer.this.mDidReportInitialAvailability = true;
                        if (TextUtils.isEmpty(this.reason)) {
                            this.reason = IronSourceConstants.FALSE_AVAILABILITY_REASON_NO_SERVER_RESPONSE;
                        }
                        for (OnMediationInitializationListener onMediationInitializationListener4 : MediationInitializer.this.mOnMediationInitializationListeners) {
                            onMediationInitializationListener4.onInitFailed(this.reason);
                        }
                        MediationInitializer.this.setInitStatus(EInitStatus.INIT_FAILED);
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                    }
                    MediationInitializer.access$1208(MediationInitializer.this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private String mAppKey;
    private AtomicBoolean mAtomicShouldPerformInit;
    private CountDownTimer mCountDownTimer;
    private boolean mDidReportInitialAvailability = false;
    private Handler mHandler;
    private HandlerThread mHandlerThread = null;
    private long mInitStartTime;
    private EInitStatus mInitStatus = EInitStatus.NOT_INIT;
    private boolean mIsInProgressMoreThan15Secs;
    private boolean mIsRevived;
    private boolean mListenForInit = false;
    private NetworkStateReceiver mNetworkStateReceiver;
    private List<OnMediationInitializationListener> mOnMediationInitializationListeners = new ArrayList();
    private int mRetryAvailabilityLimit;
    private int mRetryCounter;
    private int mRetryDelay;
    private int mRetryGrowLimit;
    private int mRetryLimit;
    private SegmentListener mSegmentListener;
    private ServerResponseWrapper mServerResponseWrapper;
    private String mUserId;
    private String mUserIdType;

    /* access modifiers changed from: package-private */
    public enum EInitStatus {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    /* access modifiers changed from: package-private */
    public interface OnMediationInitializationListener {
        void onInitFailed(String str);

        void onInitSuccess(List<IronSource.AD_UNIT> list, boolean z);

        void onStillInProgressAfter15Secs();
    }

    static /* synthetic */ int access$1208(MediationInitializer mediationInitializer) {
        int i = mediationInitializer.mRetryCounter;
        mediationInitializer.mRetryCounter = i + 1;
        return i;
    }

    /* access modifiers changed from: package-private */
    public abstract class InitRunnable implements Runnable {
        boolean isRecoverable = true;
        protected IronSourceObject.IResponseListener listener = new IronSourceObject.IResponseListener() {
            /* class com.ironsource.mediationsdk.MediationInitializer.InitRunnable.AnonymousClass1 */

            @Override // com.ironsource.mediationsdk.IronSourceObject.IResponseListener
            public void onUnrecoverableError(String str) {
                InitRunnable.this.isRecoverable = false;
                InitRunnable.this.reason = str;
            }
        };
        String reason;

        InitRunnable() {
        }
    }

    public static synchronized MediationInitializer getInstance() {
        MediationInitializer mediationInitializer;
        synchronized (MediationInitializer.class) {
            if (sInstance == null) {
                sInstance = new MediationInitializer();
            }
            mediationInitializer = sInstance;
        }
        return mediationInitializer;
    }

    private MediationInitializer() {
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mRetryDelay = 1;
        this.mRetryCounter = 0;
        this.mRetryLimit = 62;
        this.mRetryGrowLimit = 12;
        this.mRetryAvailabilityLimit = 5;
        this.mAtomicShouldPerformInit = new AtomicBoolean(true);
        this.mIsRevived = false;
        this.mIsInProgressMoreThan15Secs = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void setInitStatus(EInitStatus eInitStatus) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "setInitStatus(old status: " + this.mInitStatus + ", new status: " + eInitStatus + ")", 0);
        this.mInitStatus = eInitStatus;
    }

    public synchronized void init(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            if (this.mAtomicShouldPerformInit == null || !this.mAtomicShouldPerformInit.compareAndSet(true, false)) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                logger.log(ironSourceTag, this.TAG + ": Multiple calls to init are not allowed", 2);
            } else {
                setInitStatus(EInitStatus.INIT_IN_PROGRESS);
                this.mUserId = str2;
                this.mAppKey = str;
                if (IronSourceUtils.isNetworkConnected(context)) {
                    this.mHandler.post(this.initRunnable);
                } else {
                    this.mListenForInit = true;
                    if (this.mNetworkStateReceiver == null) {
                        this.mNetworkStateReceiver = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.ironsource.mediationsdk.MediationInitializer.AnonymousClass2 */

                        public void run() {
                            MediationInitializer.this.mCountDownTimer = new CountDownTimer(60000, 15000) {
                                /* class com.ironsource.mediationsdk.MediationInitializer.AnonymousClass2.AnonymousClass1 */

                                public void onTick(long j) {
                                    if (j <= 45000) {
                                        MediationInitializer.this.mIsInProgressMoreThan15Secs = true;
                                        for (OnMediationInitializationListener onMediationInitializationListener : MediationInitializer.this.mOnMediationInitializationListeners) {
                                            onMediationInitializationListener.onStillInProgressAfter15Secs();
                                        }
                                    }
                                }

                                public void onFinish() {
                                    if (!MediationInitializer.this.mDidReportInitialAvailability) {
                                        MediationInitializer.this.mDidReportInitialAvailability = true;
                                        for (OnMediationInitializationListener onMediationInitializationListener : MediationInitializer.this.mOnMediationInitializationListeners) {
                                            onMediationInitializationListener.onInitFailed(IronSourceConstants.FALSE_AVAILABILITY_REASON_NO_INTERNET);
                                        }
                                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
                                    }
                                }
                            }.start();
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    @Override // com.ironsource.environment.NetworkStateReceiverListener
    public void onNetworkAvailabilityChanged(boolean z) {
        if (this.mListenForInit && z) {
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.mListenForInit = false;
            this.mIsRevived = true;
            this.mHandler.post(this.initRunnable);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean wasInitRevived() {
        return this.mIsRevived;
    }

    public synchronized EInitStatus getCurrentInitStatus() {
        return this.mInitStatus;
    }

    /* access modifiers changed from: package-private */
    public void setInitStatusFailed() {
        setInitStatus(EInitStatus.INIT_FAILED);
    }

    public synchronized boolean isInProgressMoreThan15Secs() {
        return this.mIsInProgressMoreThan15Secs;
    }

    public void addMediationInitializationListener(OnMediationInitializationListener onMediationInitializationListener) {
        if (onMediationInitializationListener != null) {
            this.mOnMediationInitializationListeners.add(onMediationInitializationListener);
        }
    }

    public void removeMediationInitializationListener(OnMediationInitializationListener onMediationInitializationListener) {
        if (onMediationInitializationListener != null && this.mOnMediationInitializationListeners.size() != 0) {
            this.mOnMediationInitializationListeners.remove(onMediationInitializationListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSegmentListener(SegmentListener segmentListener) {
        this.mSegmentListener = segmentListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ConfigValidationResult validateUserId(String str) {
        ConfigValidationResult configValidationResult = new ConfigValidationResult();
        if (str == null) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("userId", str, "it's missing"));
        } else if (!validateLength(str, 1, 64)) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("userId", str, null));
        }
        return configValidationResult;
    }

    private boolean validateLength(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }
}
