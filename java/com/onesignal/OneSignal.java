package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.onesignal.LocationController;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationAction;
import com.onesignal.OSSessionManager;
import com.onesignal.OneSignalDbContract;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.OneSignalRestClient;
import com.onesignal.PushRegistrator;
import com.onesignal.UserStateSynchronizer;
import com.onesignal.influence.OSTrackerFactory;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.outcomes.OSOutcomeEventsFactory;
import com.tapjoy.TapjoyConstants;
import io.invertase.firebase.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OneSignal {
    static final long MIN_ON_SESSION_TIME_MILLIS = 30000;
    public static final String VERSION = "031506";
    private static AdvertisingIdentifierProvider adIdProvider;
    private static OneSignalAPIClient apiClient = new OneSignalRestClientWrapper();
    static Context appContext;
    private static AppEntryAction appEntryState = AppEntryAction.APP_CLOSE;
    static String appId;
    private static OSEmailSubscriptionState currentEmailSubscriptionState;
    private static OSPermissionState currentPermissionState;
    private static OSSubscriptionState currentSubscriptionState;
    static DelayedConsentInitializationParameters delayedInitParams;
    private static String emailId = null;
    private static EmailUpdateHandler emailLogoutHandler;
    private static OSObservable<OSEmailSubscriptionObserver, OSEmailSubscriptionStateChanges> emailSubscriptionStateChangesObserver;
    private static EmailUpdateHandler emailUpdateHandler;
    private static boolean foreground;
    private static boolean getTagsCall;
    private static IAPUpdateJob iapUpdateJob;
    private static IdsAvailableHandler idsAvailableHandler;
    private static OSInAppMessageControllerFactory inAppMessageControllerFactory = new OSInAppMessageControllerFactory();
    private static boolean initDone;
    static OSEmailSubscriptionState lastEmailSubscriptionState;
    private static LocationController.LocationPoint lastLocationPoint;
    static OSPermissionState lastPermissionState;
    private static String lastRegistrationId;
    static OSSubscriptionState lastSubscriptionState;
    static AtomicLong lastTaskId = new AtomicLong();
    private static boolean locationFired;
    private static LOG_LEVEL logCatLevel = LOG_LEVEL.WARN;
    private static OSLogger logger = new OSLogWrapper();
    private static String mGoogleProjectNumber;
    static Builder mInitBuilder = new Builder();
    private static PushRegistrator mPushRegistrator;
    private static OSUtils osUtils = new OSUtils();
    private static OSOutcomeEventsController outcomeEventsController;
    private static OSOutcomeEventsFactory outcomeEventsFactory;
    private static ArrayList<GetTagsHandler> pendingGetTagsHandlers = new ArrayList<>();
    static ExecutorService pendingTaskExecutor;
    private static OSObservable<OSPermissionObserver, OSPermissionStateChanges> permissionStateChangesObserver;
    private static HashSet<String> postedOpenedNotifIds = new HashSet<>();
    private static OSSharedPreferences preferences;
    private static boolean promptedLocation;
    private static boolean registerForPushFired;
    static OneSignalRemoteParams.Params remoteParams;
    static boolean requiresUserPrivacyConsent = false;
    public static String sdkType = "native";
    private static OSSessionManager.SessionListener sessionListener = new OSSessionManager.SessionListener() {
        /* class com.onesignal.OneSignal.AnonymousClass1 */

        @Override // com.onesignal.OSSessionManager.SessionListener
        public void onSessionEnding(List<OSInfluence> list) {
            if (OneSignal.outcomeEventsController == null) {
                OneSignal.Log(LOG_LEVEL.WARN, "OneSignal onSessionEnding called before init!");
            }
            if (OneSignal.outcomeEventsController != null) {
                OneSignal.outcomeEventsController.cleanOutcomes();
            }
            FocusTimeController.getInstance().onSessionEnded(list);
        }
    };
    private static OSSessionManager sessionManager;
    static boolean shareLocation = true;
    private static int subscribableStatus;
    private static OSObservable<OSSubscriptionObserver, OSSubscriptionStateChanges> subscriptionStateChangesObserver;
    public static ConcurrentLinkedQueue<Runnable> taskQueueWaitingForInit = new ConcurrentLinkedQueue<>();
    private static TrackAmazonPurchase trackAmazonPurchase;
    private static TrackFirebaseAnalytics trackFirebaseAnalytics;
    private static TrackGooglePurchase trackGooglePurchase;
    private static OSTrackerFactory trackerFactory;
    private static Collection<JSONArray> unprocessedOpenedNotifis = new ArrayList();
    private static OSDevice userDevice;
    private static String userId = null;
    private static LOG_LEVEL visualLogLevel = LOG_LEVEL.NONE;
    private static boolean waitingToPostStateSync;

    public interface ChangeTagsUpdateHandler {
        void onFailure(SendTagsError sendTagsError);

        void onSuccess(JSONObject jSONObject);
    }

    public enum EmailErrorType {
        VALIDATION,
        REQUIRES_EMAIL_AUTH,
        INVALID_OPERATION,
        NETWORK
    }

    public interface EmailUpdateHandler {
        void onFailure(EmailUpdateError emailUpdateError);

        void onSuccess();
    }

    public interface GetTagsHandler {
        void tagsAvailable(JSONObject jSONObject);
    }

    public interface IdsAvailableHandler {
        void idsAvailable(String str, String str2);
    }

    public interface InAppMessageClickHandler {
        void inAppMessageClicked(OSInAppMessageAction oSInAppMessageAction);
    }

    public enum LOG_LEVEL {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface NotificationOpenedHandler {
        void notificationOpened(OSNotificationOpenResult oSNotificationOpenResult);
    }

    public interface NotificationReceivedHandler {
        void notificationReceived(OSNotification oSNotification);
    }

    public interface OSExternalUserIdUpdateCompletionHandler {
        void onComplete(JSONObject jSONObject);
    }

    public enum OSInFocusDisplayOption {
        None,
        InAppAlert,
        Notification
    }

    interface OSInternalExternalUserIdUpdateCompletionHandler {
        void onComplete(String str, boolean z);
    }

    /* access modifiers changed from: package-private */
    public interface OSPromptActionCompletionCallback {
        void onCompleted(PromptActionResult promptActionResult);
    }

    public interface OutcomeCallback {
        void onSuccess(OutcomeEvent outcomeEvent);
    }

    public interface PostNotificationResponseHandler {
        void onFailure(JSONObject jSONObject);

        void onSuccess(JSONObject jSONObject);
    }

    /* access modifiers changed from: package-private */
    public enum PromptActionResult {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR
    }

    /* access modifiers changed from: private */
    public static boolean pushStatusRuntimeError(int i) {
        return i < -6;
    }

    public enum AppEntryAction {
        NOTIFICATION_CLICK,
        APP_OPEN,
        APP_CLOSE;

        public boolean isNotificationClick() {
            return equals(NOTIFICATION_CLICK);
        }

        public boolean isAppOpen() {
            return equals(APP_OPEN);
        }

        public boolean isAppClose() {
            return equals(APP_CLOSE);
        }
    }

    public static class SendTagsError {
        private int code;
        private String message;

        SendTagsError(int i, String str) {
            this.message = str;
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static class EmailUpdateError {
        private String message;
        private EmailErrorType type;

        EmailUpdateError(EmailErrorType emailErrorType, String str) {
            this.type = emailErrorType;
            this.message = str;
        }

        public EmailErrorType getType() {
            return this.type;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static class Builder {
        Context mContext;
        boolean mDisableGmsMissingPrompt;
        OSInFocusDisplayOption mDisplayOption;
        boolean mDisplayOptionCarryOver;
        boolean mFilterOtherGCMReceivers;
        InAppMessageClickHandler mInAppMessageClickHandler;
        NotificationOpenedHandler mNotificationOpenedHandler;
        NotificationReceivedHandler mNotificationReceivedHandler;
        boolean mPromptLocation;
        boolean mUnsubscribeWhenNotificationsAreDisabled;

        private Builder() {
            this.mDisplayOption = OSInFocusDisplayOption.InAppAlert;
        }

        private Builder(Context context) {
            this.mDisplayOption = OSInFocusDisplayOption.InAppAlert;
            this.mContext = context;
        }

        private void setDisplayOptionCarryOver(boolean z) {
            this.mDisplayOptionCarryOver = z;
        }

        public Builder setNotificationOpenedHandler(NotificationOpenedHandler notificationOpenedHandler) {
            this.mNotificationOpenedHandler = notificationOpenedHandler;
            return this;
        }

        public Builder setNotificationReceivedHandler(NotificationReceivedHandler notificationReceivedHandler) {
            this.mNotificationReceivedHandler = notificationReceivedHandler;
            return this;
        }

        public Builder setInAppMessageClickHandler(InAppMessageClickHandler inAppMessageClickHandler) {
            this.mInAppMessageClickHandler = inAppMessageClickHandler;
            return this;
        }

        public Builder autoPromptLocation(boolean z) {
            this.mPromptLocation = z;
            return this;
        }

        public Builder disableGmsMissingPrompt(boolean z) {
            this.mDisableGmsMissingPrompt = z;
            return this;
        }

        public Builder inFocusDisplaying(OSInFocusDisplayOption oSInFocusDisplayOption) {
            this.mDisplayOptionCarryOver = false;
            this.mDisplayOption = oSInFocusDisplayOption;
            return this;
        }

        public Builder unsubscribeWhenNotificationsAreDisabled(boolean z) {
            this.mUnsubscribeWhenNotificationsAreDisabled = z;
            return this;
        }

        public Builder filterOtherGCMReceivers(boolean z) {
            this.mFilterOtherGCMReceivers = z;
            return this;
        }

        public void init() {
            OneSignal.init(this);
        }
    }

    static {
        OSSharedPreferencesWrapper oSSharedPreferencesWrapper = new OSSharedPreferencesWrapper();
        preferences = oSSharedPreferencesWrapper;
        OSTrackerFactory oSTrackerFactory = new OSTrackerFactory(oSSharedPreferencesWrapper, logger);
        trackerFactory = oSTrackerFactory;
        sessionManager = new OSSessionManager(sessionListener, oSTrackerFactory, logger);
    }

    static boolean isInitDone() {
        return initDone;
    }

    static boolean isForeground() {
        return foreground;
    }

    static AppEntryAction getAppEntryState() {
        return appEntryState;
    }

    static OSInAppMessageController getInAppMessageController() {
        return inAppMessageControllerFactory.getController(getDBHelperInstance());
    }

    private static synchronized AdvertisingIdentifierProvider getAdIdProvider() {
        AdvertisingIdentifierProvider advertisingIdentifierProvider;
        synchronized (OneSignal.class) {
            if (adIdProvider == null && OSUtils.isAndroidDeviceType()) {
                adIdProvider = new AdvertisingIdProviderGPS();
            }
            advertisingIdentifierProvider = adIdProvider;
        }
        return advertisingIdentifierProvider;
    }

    private static OSPermissionState getCurrentPermissionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentPermissionState == null) {
            OSPermissionState oSPermissionState = new OSPermissionState(false);
            currentPermissionState = oSPermissionState;
            oSPermissionState.observable.addObserverStrong(new OSPermissionChangedInternalObserver());
        }
        return currentPermissionState;
    }

    private static OSPermissionState getLastPermissionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastPermissionState == null) {
            lastPermissionState = new OSPermissionState(true);
        }
        return lastPermissionState;
    }

    static OSObservable<OSPermissionObserver, OSPermissionStateChanges> getPermissionStateChangesObserver() {
        if (permissionStateChangesObserver == null) {
            permissionStateChangesObserver = new OSObservable<>("onOSPermissionChanged", true);
        }
        return permissionStateChangesObserver;
    }

    /* access modifiers changed from: private */
    public static OSSubscriptionState getCurrentSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentSubscriptionState == null) {
            currentSubscriptionState = new OSSubscriptionState(false, getCurrentPermissionState(context).getEnabled());
            getCurrentPermissionState(context).observable.addObserver(currentSubscriptionState);
            currentSubscriptionState.observable.addObserverStrong(new OSSubscriptionChangedInternalObserver());
        }
        return currentSubscriptionState;
    }

    private static OSSubscriptionState getLastSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastSubscriptionState == null) {
            lastSubscriptionState = new OSSubscriptionState(true, false);
        }
        return lastSubscriptionState;
    }

    static OSObservable<OSSubscriptionObserver, OSSubscriptionStateChanges> getSubscriptionStateChangesObserver() {
        if (subscriptionStateChangesObserver == null) {
            subscriptionStateChangesObserver = new OSObservable<>("onOSSubscriptionChanged", true);
        }
        return subscriptionStateChangesObserver;
    }

    /* access modifiers changed from: private */
    public static OSEmailSubscriptionState getCurrentEmailSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (currentEmailSubscriptionState == null) {
            OSEmailSubscriptionState oSEmailSubscriptionState = new OSEmailSubscriptionState(false);
            currentEmailSubscriptionState = oSEmailSubscriptionState;
            oSEmailSubscriptionState.observable.addObserverStrong(new OSEmailSubscriptionChangedInternalObserver());
        }
        return currentEmailSubscriptionState;
    }

    private static OSEmailSubscriptionState getLastEmailSubscriptionState(Context context) {
        if (context == null) {
            return null;
        }
        if (lastEmailSubscriptionState == null) {
            lastEmailSubscriptionState = new OSEmailSubscriptionState(true);
        }
        return lastEmailSubscriptionState;
    }

    static OSObservable<OSEmailSubscriptionObserver, OSEmailSubscriptionStateChanges> getEmailSubscriptionStateChangesObserver() {
        if (emailSubscriptionStateChangesObserver == null) {
            emailSubscriptionStateChangesObserver = new OSObservable<>("onOSEmailSubscriptionChanged", true);
        }
        return emailSubscriptionStateChangesObserver;
    }

    public static OSDevice getUserDevice() {
        if (userDevice == null) {
            userDevice = new OSDevice();
        }
        return userDevice;
    }

    /* access modifiers changed from: private */
    public static class IAPUpdateJob {
        boolean newAsExisting;
        OneSignalRestClient.ResponseHandler restResponseHandler;
        JSONArray toReport;

        IAPUpdateJob(JSONArray jSONArray) {
            this.toReport = jSONArray;
        }
    }

    public static Builder getCurrentOrNewInitBuilder() {
        return mInitBuilder;
    }

    public static void setAppContext(Context context) {
        if (context == null) {
            Log(LOG_LEVEL.WARN, "setAppContext(null) is not valid, ignoring!");
            return;
        }
        boolean z = appContext == null;
        Context applicationContext = context.getApplicationContext();
        appContext = applicationContext;
        ActivityLifecycleListener.registerActivityLifecycleCallbacks((Application) applicationContext);
        if (z) {
            if (outcomeEventsFactory == null) {
                outcomeEventsFactory = new OSOutcomeEventsFactory(logger, apiClient, getDBHelperInstance(), preferences);
            }
            sessionManager.initSessionFromCache();
            outcomeEventsController = new OSOutcomeEventsController(sessionManager, outcomeEventsFactory);
            OneSignalPrefs.startDelayedWrite();
            OneSignalCacheCleaner.cleanOldCachedData(context);
        }
    }

    static OneSignalDbHelper getDBHelperInstance() {
        return OneSignalDbHelper.getInstance(appContext);
    }

    public static Builder startInit(Context context) {
        return new Builder(context);
    }

    /* access modifiers changed from: private */
    public static void init(Builder builder) {
        if (mInitBuilder.mDisplayOptionCarryOver) {
            builder.mDisplayOption = mInitBuilder.mDisplayOption;
        }
        mInitBuilder = builder;
        Context context = builder.mContext;
        mInitBuilder.mContext = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            String string = bundle.getString("onesignal_google_project_number");
            if (string != null && string.length() > 4) {
                string = string.substring(4);
            }
            init(context, string, bundle.getString("onesignal_app_id"), mInitBuilder.mNotificationOpenedHandler, mInitBuilder.mNotificationReceivedHandler);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void init(Context context, String str, String str2) {
        init(context, str, str2, null, null);
    }

    public static void init(Context context, String str, String str2, NotificationOpenedHandler notificationOpenedHandler) {
        init(context, str, str2, notificationOpenedHandler, null);
    }

    public static void init(Context context, String str, String str2, NotificationOpenedHandler notificationOpenedHandler, NotificationReceivedHandler notificationReceivedHandler) {
        mInitBuilder = createInitBuilder(notificationOpenedHandler, notificationReceivedHandler);
        setAppContext(context);
        setupPrivacyConsent(context);
        if (requiresUserPrivacyConsent()) {
            Log(LOG_LEVEL.VERBOSE, "OneSignal SDK initialization delayed, user privacy consent is set to required for this application.");
            delayedInitParams = new DelayedConsentInitializationParameters(context, str, str2, notificationOpenedHandler, notificationReceivedHandler);
            return;
        }
        mInitBuilder = createInitBuilder(notificationOpenedHandler, notificationReceivedHandler);
        if (!isGoogleProjectNumberRemote()) {
            mGoogleProjectNumber = str;
        }
        subscribableStatus = osUtils.initializationChecker(context, str2);
        if (!isSubscriptionStatusUninitializable()) {
            String str3 = appId;
            if (str3 != null && !str3.equals(str2)) {
                initDone = false;
            }
            if (!initDone) {
                appId = str2;
                saveFilterOtherGCMReceivers(mInitBuilder.mFilterOtherGCMReceivers);
                handleActivityLifecycleHandler(context);
                OneSignalStateSynchronizer.initUserState();
                handleAmazonPurchase();
                handleAppIdChange();
                OSPermissionChangedInternalObserver.handleInternalChanges(getCurrentPermissionState(appContext));
                doSessionInit();
                if (mInitBuilder.mNotificationOpenedHandler != null) {
                    fireCallbackForOpenedNotifications();
                }
                if (TrackGooglePurchase.CanTrack(appContext)) {
                    trackGooglePurchase = new TrackGooglePurchase(appContext);
                }
                if (TrackFirebaseAnalytics.CanTrack()) {
                    trackFirebaseAnalytics = new TrackFirebaseAnalytics(appContext);
                }
                PushRegistratorFCM.disableFirebaseInstanceIdService(appContext);
                initDone = true;
                outcomeEventsController.sendSavedOutcomes();
                startPendingTasks();
            } else if (mInitBuilder.mNotificationOpenedHandler != null) {
                fireCallbackForOpenedNotifications();
            }
        }
    }

    private static void setupPrivacyConsent(Context context) {
        try {
            setRequiresUserPrivacyConsent("ENABLE".equalsIgnoreCase(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.onesignal.PrivacyConsent")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static Builder createInitBuilder(NotificationOpenedHandler notificationOpenedHandler, NotificationReceivedHandler notificationReceivedHandler) {
        mInitBuilder.mDisplayOptionCarryOver = false;
        mInitBuilder.mNotificationOpenedHandler = notificationOpenedHandler;
        mInitBuilder.mNotificationReceivedHandler = notificationReceivedHandler;
        return mInitBuilder;
    }

    private static void handleAppIdChange() {
        String savedAppId = getSavedAppId();
        if (savedAppId == null) {
            BadgeCountUpdater.updateCount(0, appContext);
            saveAppId(appId);
        } else if (!savedAppId.equals(appId)) {
            Log(LOG_LEVEL.DEBUG, "APP ID changed, clearing user id as it is no longer valid.");
            saveAppId(appId);
            OneSignalStateSynchronizer.resetCurrentState();
            remoteParams = null;
        }
    }

    public static boolean userProvidedPrivacyConsent() {
        return getSavedUserConsentStatus();
    }

    private static boolean isGoogleProjectNumberRemote() {
        OneSignalRemoteParams.Params params = remoteParams;
        return (params == null || params.googleProjectNumber == null) ? false : true;
    }

    private static boolean isSubscriptionStatusUninitializable() {
        return subscribableStatus == -999;
    }

    private static void handleActivityLifecycleHandler(Context context) {
        boolean isContextActivity = isContextActivity(context);
        foreground = isContextActivity;
        if (isContextActivity) {
            ActivityLifecycleHandler.curActivity = (Activity) context;
            NotificationRestorer.asyncRestore(appContext);
            FocusTimeController.getInstance().appForegrounded();
            return;
        }
        ActivityLifecycleHandler.nextResumeIsFirstActivity = true;
    }

    private static void handleAmazonPurchase() {
        try {
            Class.forName("com.amazon.device.iap.PurchasingListener");
            trackAmazonPurchase = new TrackAmazonPurchase(appContext);
        } catch (ClassNotFoundException unused) {
        }
    }

    private static void doSessionInit() {
        if (isPastOnSessionTime()) {
            onesignalLog(LOG_LEVEL.DEBUG, "Starting new session");
            OneSignalStateSynchronizer.setNewSession();
            if (foreground) {
                outcomeEventsController.cleanOutcomes();
                sessionManager.restartSessionIfNeeded(getAppEntryState());
                getInAppMessageController().resetSessionLaunchTime();
            }
        } else if (foreground) {
            onesignalLog(LOG_LEVEL.DEBUG, "Continue on same session");
            sessionManager.attemptSessionUpgrade(getAppEntryState());
        }
        getInAppMessageController().initWithCachedInAppMessages();
        if (foreground || !hasUserId()) {
            setLastSessionTime(System.currentTimeMillis());
            startRegistrationOrOnSession();
        }
    }

    private static boolean isContextActivity(Context context) {
        return context instanceof Activity;
    }

    /* access modifiers changed from: private */
    public static void onTaskRan(long j) {
        if (lastTaskId.get() == j) {
            Log(LOG_LEVEL.INFO, "Last Pending Task has ran, shutting down");
            pendingTaskExecutor.shutdown();
        }
    }

    /* access modifiers changed from: private */
    public static class PendingTaskRunnable implements Runnable {
        private Runnable innerTask;
        private long taskId;

        PendingTaskRunnable(Runnable runnable) {
            this.innerTask = runnable;
        }

        public void run() {
            this.innerTask.run();
            OneSignal.onTaskRan(this.taskId);
        }
    }

    private static void startPendingTasks() {
        if (!taskQueueWaitingForInit.isEmpty()) {
            pendingTaskExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
                /* class com.onesignal.OneSignal.AnonymousClass2 */

                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("OS_PENDING_EXECUTOR_" + thread.getId());
                    return thread;
                }
            });
            while (!taskQueueWaitingForInit.isEmpty()) {
                pendingTaskExecutor.submit(taskQueueWaitingForInit.poll());
            }
        }
    }

    private static void addTaskToQueue(PendingTaskRunnable pendingTaskRunnable) {
        pendingTaskRunnable.taskId = lastTaskId.incrementAndGet();
        ExecutorService executorService = pendingTaskExecutor;
        if (executorService == null) {
            LOG_LEVEL log_level = LOG_LEVEL.INFO;
            Log(log_level, "Adding a task to the pending queue with ID: " + pendingTaskRunnable.taskId);
            taskQueueWaitingForInit.add(pendingTaskRunnable);
        } else if (!executorService.isShutdown()) {
            LOG_LEVEL log_level2 = LOG_LEVEL.INFO;
            Log(log_level2, "Executor is still running, add to the executor with ID: " + pendingTaskRunnable.taskId);
            try {
                pendingTaskExecutor.submit(pendingTaskRunnable);
            } catch (RejectedExecutionException e) {
                LOG_LEVEL log_level3 = LOG_LEVEL.INFO;
                Log(log_level3, "Executor is shutdown, running task manually with ID: " + pendingTaskRunnable.taskId);
                pendingTaskRunnable.run();
                e.printStackTrace();
            }
        }
    }

    private static boolean shouldRunTaskThroughQueue() {
        if (initDone && pendingTaskExecutor == null) {
            return false;
        }
        if (!initDone && pendingTaskExecutor == null) {
            return true;
        }
        ExecutorService executorService = pendingTaskExecutor;
        if (executorService == null || executorService.isShutdown()) {
            return false;
        }
        return true;
    }

    private static void startRegistrationOrOnSession() {
        if (!waitingToPostStateSync) {
            waitingToPostStateSync = true;
            if (OneSignalStateSynchronizer.getSyncAsNewSession()) {
                locationFired = false;
            }
            startLocationUpdate();
            registerForPushFired = false;
            makeAndroidParamsRequest();
        }
    }

    private static void startLocationUpdate() {
        AnonymousClass3 r0 = new LocationController.LocationHandler() {
            /* class com.onesignal.OneSignal.AnonymousClass3 */

            @Override // com.onesignal.LocationController.LocationHandler
            public LocationController.PermissionType getType() {
                return LocationController.PermissionType.STARTUP;
            }

            @Override // com.onesignal.LocationController.LocationHandler
            public void onComplete(LocationController.LocationPoint locationPoint) {
                LocationController.LocationPoint unused = OneSignal.lastLocationPoint = locationPoint;
                boolean unused2 = OneSignal.locationFired = true;
                OneSignal.registerUser();
            }
        };
        boolean z = true;
        boolean z2 = mInitBuilder.mPromptLocation && !promptedLocation;
        if (!promptedLocation && !mInitBuilder.mPromptLocation) {
            z = false;
        }
        promptedLocation = z;
        LocationController.getLocation(appContext, z2, false, r0);
    }

    private static PushRegistrator getPushRegistrator() {
        PushRegistrator pushRegistrator = mPushRegistrator;
        if (pushRegistrator != null) {
            return pushRegistrator;
        }
        if (OSUtils.isFireOSDeviceType()) {
            mPushRegistrator = new PushRegistratorADM();
        } else if (!OSUtils.isAndroidDeviceType()) {
            mPushRegistrator = new PushRegistratorHMS();
        } else if (OSUtils.hasFCMLibrary()) {
            mPushRegistrator = new PushRegistratorFCM();
        } else {
            mPushRegistrator = new PushRegistratorGCM();
        }
        return mPushRegistrator;
    }

    /* access modifiers changed from: private */
    public static void registerForPushToken() {
        getPushRegistrator().registerForPush(appContext, mGoogleProjectNumber, new PushRegistrator.RegisteredHandler() {
            /* class com.onesignal.OneSignal.AnonymousClass4 */

            @Override // com.onesignal.PushRegistrator.RegisteredHandler
            public void complete(String str, int i) {
                if (i < 1) {
                    if (OneSignalStateSynchronizer.getRegistrationId() == null && (OneSignal.subscribableStatus == 1 || OneSignal.pushStatusRuntimeError(OneSignal.subscribableStatus))) {
                        int unused = OneSignal.subscribableStatus = i;
                    }
                } else if (OneSignal.pushStatusRuntimeError(OneSignal.subscribableStatus)) {
                    int unused2 = OneSignal.subscribableStatus = i;
                }
                String unused3 = OneSignal.lastRegistrationId = str;
                boolean unused4 = OneSignal.registerForPushFired = true;
                OneSignal.getCurrentSubscriptionState(OneSignal.appContext).setPushToken(str);
                OneSignal.registerUser();
            }
        });
    }

    private static void makeAndroidParamsRequest() {
        if (remoteParams != null) {
            registerForPushToken();
        } else {
            OneSignalRemoteParams.makeAndroidParamsRequest(new OneSignalRemoteParams.CallBack() {
                /* class com.onesignal.OneSignal.AnonymousClass5 */

                @Override // com.onesignal.OneSignalRemoteParams.CallBack
                public void complete(OneSignalRemoteParams.Params params) {
                    OneSignal.remoteParams = params;
                    if (OneSignal.remoteParams.googleProjectNumber != null) {
                        String unused = OneSignal.mGoogleProjectNumber = OneSignal.remoteParams.googleProjectNumber;
                    }
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_FIREBASE_TRACKING_ENABLED, OneSignal.remoteParams.firebaseAnalytics);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RESTORE_TTL_FILTER, OneSignal.remoteParams.restoreTTLFilter);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLEAR_GROUP_SUMMARY_CLICK, OneSignal.remoteParams.clearGroupOnSummaryClick);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RECEIVE_RECEIPTS_ENABLED, OneSignal.remoteParams.receiveReceiptEnabled);
                    OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignal.preferences.getOutcomesV2KeyName(), params.influenceParams.outcomesV2ServiceEnabled);
                    OSLogger oSLogger = OneSignal.logger;
                    oSLogger.debug("OneSignal saveInfluenceParams: " + params.influenceParams.toString());
                    OneSignal.trackerFactory.saveInfluenceParams(params.influenceParams);
                    NotificationChannelManager.processChannelList(OneSignal.appContext, params.notificationChannels);
                    OneSignal.registerForPushToken();
                }
            });
        }
    }

    private static void fireCallbackForOpenedNotifications() {
        for (JSONArray jSONArray : unprocessedOpenedNotifis) {
            runNotificationOpenedCallback(jSONArray, true, false);
        }
        unprocessedOpenedNotifis.clear();
    }

    public static void onesignalLog(LOG_LEVEL log_level, String str) {
        Log(log_level, str);
    }

    public static void provideUserConsent(boolean z) {
        DelayedConsentInitializationParameters delayedConsentInitializationParameters;
        boolean userProvidedPrivacyConsent = userProvidedPrivacyConsent();
        saveUserConsentStatus(z);
        if (!userProvidedPrivacyConsent && z && (delayedConsentInitializationParameters = delayedInitParams) != null) {
            init(delayedConsentInitializationParameters.context, delayedInitParams.googleProjectNumber, delayedInitParams.appId, delayedInitParams.openedHandler, delayedInitParams.receivedHandler);
            delayedInitParams = null;
        }
    }

    public static void setRequiresUserPrivacyConsent(boolean z) {
        if (!requiresUserPrivacyConsent || z) {
            requiresUserPrivacyConsent = z;
        } else {
            Log(LOG_LEVEL.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    public static boolean requiresUserPrivacyConsent() {
        return requiresUserPrivacyConsent && !userProvidedPrivacyConsent();
    }

    static boolean shouldLogUserPrivacyConsentErrorMessageForMethodName(String str) {
        if (!requiresUserPrivacyConsent()) {
            return false;
        }
        if (str == null) {
            return true;
        }
        LOG_LEVEL log_level = LOG_LEVEL.WARN;
        Log(log_level, "Method " + str + " was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
        return true;
    }

    public static void setLogLevel(LOG_LEVEL log_level, LOG_LEVEL log_level2) {
        logCatLevel = log_level;
        visualLogLevel = log_level2;
    }

    public static void setLogLevel(int i, int i2) {
        setLogLevel(getLogLevel(i), getLogLevel(i2));
    }

    private static LOG_LEVEL getLogLevel(int i) {
        switch (i) {
            case 0:
                return LOG_LEVEL.NONE;
            case 1:
                return LOG_LEVEL.FATAL;
            case 2:
                return LOG_LEVEL.ERROR;
            case 3:
                return LOG_LEVEL.WARN;
            case 4:
                return LOG_LEVEL.INFO;
            case 5:
                return LOG_LEVEL.DEBUG;
            case 6:
                return LOG_LEVEL.VERBOSE;
            default:
                if (i < 0) {
                    return LOG_LEVEL.NONE;
                }
                return LOG_LEVEL.VERBOSE;
        }
    }

    static boolean atLogLevel(LOG_LEVEL log_level) {
        return log_level.compareTo(visualLogLevel) < 1 || log_level.compareTo(logCatLevel) < 1;
    }

    static void Log(LOG_LEVEL log_level, String str) {
        Log(log_level, str, null);
    }

    static void Log(final LOG_LEVEL log_level, String str, Throwable th) {
        if (log_level.compareTo((Enum) logCatLevel) < 1) {
            if (log_level == LOG_LEVEL.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.INFO) {
                Log.i("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.WARN) {
                Log.w("OneSignal", str, th);
            } else if (log_level == LOG_LEVEL.ERROR || log_level == LOG_LEVEL.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (log_level.compareTo((Enum) visualLogLevel) < 1 && ActivityLifecycleHandler.curActivity != null) {
            try {
                final String str2 = str + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = (str2 + th.getMessage()) + stringWriter.toString();
                }
                OSUtils.runOnMainUIThread(new Runnable() {
                    /* class com.onesignal.OneSignal.AnonymousClass6 */

                    public void run() {
                        if (ActivityLifecycleHandler.curActivity != null) {
                            new AlertDialog.Builder(ActivityLifecycleHandler.curActivity).setTitle(LOG_LEVEL.this.toString()).setMessage(str2).show();
                        }
                    }
                });
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
    }

    static void logHttpError(String str, int i, Throwable th, String str2) {
        String str3;
        if (str2 == null || !atLogLevel(LOG_LEVEL.INFO)) {
            str3 = "";
        } else {
            str3 = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + str2 + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        Log(LOG_LEVEL.WARN, "HTTP code: " + i + " " + str + str3, th);
    }

    static void onAppLostFocus() {
        Log(LOG_LEVEL.DEBUG, "Application lost focus");
        foreground = false;
        appEntryState = AppEntryAction.APP_CLOSE;
        setLastSessionTime(System.currentTimeMillis());
        LocationController.onFocusChange();
        if (initDone) {
            TrackAmazonPurchase trackAmazonPurchase2 = trackAmazonPurchase;
            if (trackAmazonPurchase2 != null) {
                trackAmazonPurchase2.checkListener();
            }
            if (appContext == null) {
                Log(LOG_LEVEL.ERROR, "Android Context not found, please call OneSignal.init when your app starts.");
                return;
            }
            FocusTimeController.getInstance().appBackgrounded();
            scheduleSyncService();
        }
    }

    private static boolean scheduleSyncService() {
        boolean persist = OneSignalStateSynchronizer.persist();
        if (persist) {
            OneSignalSyncServiceUtils.scheduleSyncTask(appContext);
        }
        return LocationController.scheduleUpdate(appContext) || persist;
    }

    static void onAppFocus() {
        Log(LOG_LEVEL.DEBUG, "Application on focus");
        foreground = true;
        if (!appEntryState.equals(AppEntryAction.NOTIFICATION_CLICK)) {
            appEntryState = AppEntryAction.APP_OPEN;
        }
        LocationController.onFocusChange();
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("onAppFocus") && !OSUtils.shouldLogMissingAppIdError(appId)) {
            FocusTimeController.getInstance().appForegrounded();
            doSessionInit();
            TrackGooglePurchase trackGooglePurchase2 = trackGooglePurchase;
            if (trackGooglePurchase2 != null) {
                trackGooglePurchase2.trackIAP();
            }
            NotificationRestorer.asyncRestore(appContext);
            getCurrentPermissionState(appContext).refreshAsTo();
            if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
                trackFirebaseAnalytics.trackInfluenceOpenEvent();
            }
            OneSignalSyncServiceUtils.cancelSyncTask(appContext);
        }
    }

    static void addNetType(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", osUtils.getNetType());
        } catch (Throwable unused) {
        }
    }

    private static int getTimeZoneOffset() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    /* access modifiers changed from: private */
    public static void registerUser() {
        LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
        Log(log_level, "registerUser:registerForPushFired:" + registerForPushFired + ", locationFired: " + locationFired + ", remoteParams: " + remoteParams + ", appId: " + appId);
        if (registerForPushFired && locationFired && remoteParams != null && appId != null) {
            new Thread(new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass7 */

                public void run() {
                    try {
                        OneSignal.registerUserTask();
                        OneSignalChromeTabAndroidFrame.setup(OneSignal.appId, OneSignal.userId, AdvertisingIdProviderGPS.getLastValue());
                    } catch (JSONException e) {
                        OneSignal.Log(LOG_LEVEL.FATAL, "FATAL Error registering device!", e);
                    }
                }
            }, "OS_REG_USER").start();
        }
    }

    /* access modifiers changed from: private */
    public static void registerUserTask() throws JSONException {
        LocationController.LocationPoint locationPoint;
        String identifier;
        String packageName = appContext.getPackageName();
        PackageManager packageManager = appContext.getPackageManager();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", getSavedAppId());
        if (!(getAdIdProvider() == null || (identifier = getAdIdProvider().getIdentifier(appContext)) == null)) {
            jSONObject.put("ad_id", identifier);
        }
        jSONObject.put("device_os", Build.VERSION.RELEASE);
        jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, getTimeZoneOffset());
        jSONObject.put("language", OSUtils.getCorrectedLanguage());
        jSONObject.put("sdk", VERSION);
        jSONObject.put(TapjoyConstants.TJC_SDK_TYPE, sdkType);
        jSONObject.put("android_package", packageName);
        jSONObject.put("device_model", Build.MODEL);
        try {
            jSONObject.put("game_version", packageManager.getPackageInfo(packageName, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONObject.put("net_type", osUtils.getNetType());
        jSONObject.put("carrier", osUtils.getCarrierName());
        jSONObject.put("rooted", RootToolsInternalMethods.isRooted());
        OneSignalStateSynchronizer.updateDeviceInfo(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", lastRegistrationId);
        jSONObject2.put("subscribableStatus", subscribableStatus);
        jSONObject2.put("androidPermission", areNotificationsEnabledForSubscribedState());
        jSONObject2.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, osUtils.getDeviceType());
        OneSignalStateSynchronizer.updatePushState(jSONObject2);
        if (shareLocation && (locationPoint = lastLocationPoint) != null) {
            OneSignalStateSynchronizer.updateLocation(locationPoint);
        }
        OneSignalStateSynchronizer.readyToUpdate(true);
        waitingToPostStateSync = false;
    }

    @Deprecated
    public static void syncHashedEmail(final String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("SyncHashedEmail()") && OSUtils.isValidEmail(str)) {
            AnonymousClass8 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass8 */

                public void run() {
                    OneSignalStateSynchronizer.syncHashedEmail(str.trim().toLowerCase());
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling syncHashedEmail! Moving this operation to a pending task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void setEmail(String str, EmailUpdateHandler emailUpdateHandler2) {
        setEmail(str, null, emailUpdateHandler2);
    }

    public static void setEmail(String str) {
        setEmail(str, null, null);
    }

    public static void setEmail(String str, String str2) {
        setEmail(str, str2, null);
    }

    public static void setEmail(final String str, final String str2, EmailUpdateHandler emailUpdateHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setEmail()")) {
            if (!OSUtils.isValidEmail(str)) {
                if (emailUpdateHandler2 != null) {
                    emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.VALIDATION, "Email is invalid"));
                }
                Log(LOG_LEVEL.ERROR, "Email is invalid");
                return;
            }
            OneSignalRemoteParams.Params params = remoteParams;
            if (params == null || !params.useEmailAuth || !(str2 == null || str2.length() == 0)) {
                emailUpdateHandler = emailUpdateHandler2;
                AnonymousClass9 r3 = new Runnable() {
                    /* class com.onesignal.OneSignal.AnonymousClass9 */

                    public void run() {
                        String trim = str.trim();
                        String str = str2;
                        if (str != null) {
                            str.toLowerCase();
                        }
                        OneSignal.getCurrentEmailSubscriptionState(OneSignal.appContext).setEmailAddress(trim);
                        OneSignalStateSynchronizer.setEmail(trim.toLowerCase(), str);
                    }
                };
                if (appContext == null || shouldRunTaskThroughQueue()) {
                    Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling setEmail! Moving this operation to a pending task queue.");
                    addTaskToQueue(new PendingTaskRunnable(r3));
                    return;
                }
                r3.run();
                return;
            }
            if (emailUpdateHandler2 != null) {
                emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.REQUIRES_EMAIL_AUTH, "Email authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard."));
            }
            Log(LOG_LEVEL.ERROR, "Email authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard.");
        }
    }

    public static void logoutEmail() {
        logoutEmail(null);
    }

    public static void logoutEmail(EmailUpdateHandler emailUpdateHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("logoutEmail()")) {
            if (getEmailId() == null) {
                if (emailUpdateHandler2 != null) {
                    emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.INVALID_OPERATION, "logoutEmail not valid as email was not set or already logged out!"));
                }
                Log(LOG_LEVEL.ERROR, "logoutEmail not valid as email was not set or already logged out!");
                return;
            }
            emailLogoutHandler = emailUpdateHandler2;
            AnonymousClass10 r3 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass10 */

                public void run() {
                    OneSignalStateSynchronizer.logoutEmail();
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You should initialize OneSignal before calling logoutEmail! Moving this operation to a pending task queue.");
                addTaskToQueue(new PendingTaskRunnable(r3));
                return;
            }
            r3.run();
        }
    }

    public static void setExternalUserId(String str) {
        setExternalUserId(str, null, null);
    }

    public static void setExternalUserId(String str, OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) {
        setExternalUserId(str, null, oSExternalUserIdUpdateCompletionHandler);
    }

    public static void setExternalUserId(String str, String str2) {
        setExternalUserId(str, str2, null);
    }

    public static void setExternalUserId(final String str, final String str2, final OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setExternalUserId()")) {
            AnonymousClass11 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass11 */

                public void run() {
                    String str;
                    String str2 = str;
                    if (str2 == null) {
                        OneSignal.Log(LOG_LEVEL.WARN, "External id can't be null, set an empty string to remove an external id");
                    } else if (str2.length() <= 0 || OneSignal.remoteParams == null || !OneSignal.remoteParams.useUserIdAuth || !((str = str2) == null || str.length() == 0)) {
                        String str3 = str2;
                        if (str3 != null) {
                            str3 = str3.toLowerCase();
                        }
                        try {
                            OneSignalStateSynchronizer.setExternalUserId(str, str3, oSExternalUserIdUpdateCompletionHandler);
                        } catch (JSONException e) {
                            String str4 = str.equals("") ? "remove" : "set";
                            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                            OneSignal.onesignalLog(log_level, "Attempted to " + str4 + " external ID but encountered a JSON exception");
                            e.printStackTrace();
                        }
                    } else {
                        OneSignal.Log(LOG_LEVEL.ERROR, "External Id authentication (auth token) is set to REQUIRED for this application. Please provide an auth token from your backend server or change the setting in the OneSignal dashboard.");
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                addTaskToQueue(new PendingTaskRunnable(r0));
            } else {
                r0.run();
            }
        }
    }

    public static void removeExternalUserId() {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("removeExternalUserId()")) {
            removeExternalUserId(null);
        }
    }

    public static void removeExternalUserId(OSExternalUserIdUpdateCompletionHandler oSExternalUserIdUpdateCompletionHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("removeExternalUserId()")) {
            setExternalUserId("", oSExternalUserIdUpdateCompletionHandler);
        }
    }

    public static void sendTag(String str, String str2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendTag()")) {
            try {
                sendTags(new JSONObject().put(str, str2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendTags(String str) {
        try {
            sendTags(new JSONObject(str));
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "Generating JSONObject for sendTags failed!", e);
        }
    }

    public static void sendTags(JSONObject jSONObject) {
        sendTags(jSONObject, null);
    }

    public static void sendTags(final JSONObject jSONObject, final ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendTags()")) {
            AnonymousClass12 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass12 */

                public void run() {
                    if (jSONObject == null) {
                        ChangeTagsUpdateHandler changeTagsUpdateHandler = changeTagsUpdateHandler;
                        if (changeTagsUpdateHandler != null) {
                            changeTagsUpdateHandler.onFailure(new SendTagsError(-1, "Attempted to send null tags"));
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject = OneSignalStateSynchronizer.getTags(false).result;
                    JSONObject jSONObject2 = new JSONObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            Object opt = jSONObject.opt(next);
                            if (!(opt instanceof JSONArray)) {
                                if (!(opt instanceof JSONObject)) {
                                    if (!jSONObject.isNull(next) && !"".equals(opt)) {
                                        jSONObject2.put(next, opt.toString());
                                    } else if (jSONObject != null && jSONObject.has(next)) {
                                        jSONObject2.put(next, "");
                                    }
                                }
                            }
                            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                            OneSignal.Log(log_level, "Omitting key '" + next + "'! sendTags DO NOT supported nested values!");
                        } catch (Throwable unused) {
                        }
                    }
                    if (!jSONObject2.toString().equals(BuildConfig.FIREBASE_JSON_RAW)) {
                        OneSignalStateSynchronizer.sendTags(jSONObject2, changeTagsUpdateHandler);
                        return;
                    }
                    ChangeTagsUpdateHandler changeTagsUpdateHandler2 = changeTagsUpdateHandler;
                    if (changeTagsUpdateHandler2 != null) {
                        changeTagsUpdateHandler2.onSuccess(jSONObject);
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue.");
                if (changeTagsUpdateHandler != null) {
                    changeTagsUpdateHandler.onFailure(new SendTagsError(-1, "You must initialize OneSignal before modifying tags!Moving this operation to a pending task queue."));
                }
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void postNotification(String str, PostNotificationResponseHandler postNotificationResponseHandler) {
        try {
            postNotification(new JSONObject(str), postNotificationResponseHandler);
        } catch (JSONException unused) {
            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
            Log(log_level, "Invalid postNotification JSON format: " + str);
        }
    }

    public static void postNotification(JSONObject jSONObject, final PostNotificationResponseHandler postNotificationResponseHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("postNotification()")) {
            try {
                if (!jSONObject.has("app_id")) {
                    jSONObject.put("app_id", getSavedAppId());
                }
                if (jSONObject.has("app_id")) {
                    OneSignalRestClient.post("notifications/", jSONObject, new OneSignalRestClient.ResponseHandler() {
                        /* class com.onesignal.OneSignal.AnonymousClass13 */

                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onSuccess(String str) {
                            LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("HTTP create notification success: ");
                            sb.append(str != null ? str : "null");
                            OneSignal.Log(log_level, sb.toString());
                            if (PostNotificationResponseHandler.this != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("errors")) {
                                        PostNotificationResponseHandler.this.onFailure(jSONObject);
                                    } else {
                                        PostNotificationResponseHandler.this.onSuccess(new JSONObject(str));
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }

                        /* access modifiers changed from: package-private */
                        /* JADX WARNING: Can't wrap try/catch for region: R(6:(1:3)|4|5|6|7|13) */
                        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
                            r2 = move-exception;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                            r2.printStackTrace();
                         */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0018 */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onFailure(int r2, java.lang.String r3, java.lang.Throwable r4) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "create notification failed"
                                com.onesignal.OneSignal.logHttpError(r0, r2, r4, r3)
                                com.onesignal.OneSignal$PostNotificationResponseHandler r4 = com.onesignal.OneSignal.PostNotificationResponseHandler.this
                                if (r4 == 0) goto L_0x0029
                                if (r2 != 0) goto L_0x000d
                                java.lang.String r3 = "{\"error\": \"HTTP no response error\"}"
                            L_0x000d:
                                com.onesignal.OneSignal$PostNotificationResponseHandler r2 = com.onesignal.OneSignal.PostNotificationResponseHandler.this     // Catch:{ all -> 0x0018 }
                                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0018 }
                                r4.<init>(r3)     // Catch:{ all -> 0x0018 }
                                r2.onFailure(r4)     // Catch:{ all -> 0x0018 }
                                goto L_0x0029
                            L_0x0018:
                                com.onesignal.OneSignal$PostNotificationResponseHandler r2 = com.onesignal.OneSignal.PostNotificationResponseHandler.this     // Catch:{ JSONException -> 0x0025 }
                                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0025 }
                                java.lang.String r4 = "{\"error\": \"Unknown response!\"}"
                                r3.<init>(r4)     // Catch:{ JSONException -> 0x0025 }
                                r2.onFailure(r3)     // Catch:{ JSONException -> 0x0025 }
                                goto L_0x0029
                            L_0x0025:
                                r2 = move-exception
                                r2.printStackTrace()
                            L_0x0029:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.AnonymousClass13.onFailure(int, java.lang.String, java.lang.Throwable):void");
                        }
                    });
                } else if (postNotificationResponseHandler != null) {
                    postNotificationResponseHandler.onFailure(new JSONObject().put("error", "Missing app_id"));
                }
            } catch (JSONException e) {
                Log(LOG_LEVEL.ERROR, "HTTP create notification json exception!", e);
                if (postNotificationResponseHandler != null) {
                    try {
                        postNotificationResponseHandler.onFailure(new JSONObject("{'error': 'HTTP create notification json exception!'}"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void getTags(final GetTagsHandler getTagsHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("getTags()")) {
            if (getTagsHandler == null) {
                Log(LOG_LEVEL.ERROR, "getTagsHandler is null!");
            } else {
                new Thread(new Runnable() {
                    /* class com.onesignal.OneSignal.AnonymousClass14 */

                    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
                        com.onesignal.OneSignal.Log(com.onesignal.OneSignal.LOG_LEVEL.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                        com.onesignal.OneSignal.taskQueueWaitingForInit.add(new com.onesignal.OneSignal.AnonymousClass14.AnonymousClass1(r3));
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
                        com.onesignal.OneSignal.runGetTags();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
                        if (com.onesignal.OneSignal.appContext != null) goto L_0x0032;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            java.util.ArrayList r0 = com.onesignal.OneSignal.access$2200()
                            monitor-enter(r0)
                            java.util.ArrayList r1 = com.onesignal.OneSignal.access$2200()     // Catch:{ all -> 0x0036 }
                            com.onesignal.OneSignal$GetTagsHandler r2 = com.onesignal.OneSignal.GetTagsHandler.this     // Catch:{ all -> 0x0036 }
                            r1.add(r2)     // Catch:{ all -> 0x0036 }
                            java.util.ArrayList r1 = com.onesignal.OneSignal.access$2200()     // Catch:{ all -> 0x0036 }
                            int r1 = r1.size()     // Catch:{ all -> 0x0036 }
                            r2 = 1
                            if (r1 <= r2) goto L_0x001b
                            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                            return
                        L_0x001b:
                            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
                            android.content.Context r0 = com.onesignal.OneSignal.appContext
                            if (r0 != 0) goto L_0x0032
                            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
                            java.lang.String r1 = "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue."
                            com.onesignal.OneSignal.Log(r0, r1)
                            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = com.onesignal.OneSignal.taskQueueWaitingForInit
                            com.onesignal.OneSignal$14$1 r1 = new com.onesignal.OneSignal$14$1
                            r1.<init>()
                            r0.add(r1)
                            return
                        L_0x0032:
                            com.onesignal.OneSignal.access$2300()
                            return
                        L_0x0036:
                            r1 = move-exception
                            monitor-exit(r0)
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignal.AnonymousClass14.run():void");
                    }
                }, "OS_GETTAGS").start();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void runGetTags() {
        if (getUserId() != null) {
            internalFireGetTagsCallbacks();
        }
    }

    private static void internalFireGetTagsCallbacks() {
        synchronized (pendingGetTagsHandlers) {
            if (pendingGetTagsHandlers.size() != 0) {
                new Thread(new Runnable() {
                    /* class com.onesignal.OneSignal.AnonymousClass15 */

                    public void run() {
                        JSONObject jSONObject;
                        UserStateSynchronizer.GetTagsResult tags = OneSignalStateSynchronizer.getTags(!OneSignal.getTagsCall);
                        if (tags.serverSuccess) {
                            boolean unused = OneSignal.getTagsCall = true;
                        }
                        synchronized (OneSignal.pendingGetTagsHandlers) {
                            Iterator it = OneSignal.pendingGetTagsHandlers.iterator();
                            while (it.hasNext()) {
                                GetTagsHandler getTagsHandler = (GetTagsHandler) it.next();
                                if (tags.result != null) {
                                    if (!tags.toString().equals(BuildConfig.FIREBASE_JSON_RAW)) {
                                        jSONObject = tags.result;
                                        getTagsHandler.tagsAvailable(jSONObject);
                                    }
                                }
                                jSONObject = null;
                                getTagsHandler.tagsAvailable(jSONObject);
                            }
                            OneSignal.pendingGetTagsHandlers.clear();
                        }
                    }
                }, "OS_GETTAGS_CALLBACK").start();
            }
        }
    }

    public static void deleteTag(String str) {
        deleteTag(str, null);
    }

    public static void deleteTag(String str, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTag()")) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            deleteTags(arrayList, changeTagsUpdateHandler);
        }
    }

    public static void deleteTags(Collection<String> collection) {
        deleteTags(collection, (ChangeTagsUpdateHandler) null);
    }

    public static void deleteTags(Collection<String> collection, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str : collection) {
                    jSONObject.put(str, "");
                }
                sendTags(jSONObject, changeTagsUpdateHandler);
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    public static void deleteTags(String str) {
        deleteTags(str, (ChangeTagsUpdateHandler) null);
    }

    public static void deleteTags(String str, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        try {
            deleteTags(new JSONArray(str), changeTagsUpdateHandler);
        } catch (Throwable th) {
            Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
        }
    }

    public static void deleteTags(JSONArray jSONArray, ChangeTagsUpdateHandler changeTagsUpdateHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("deleteTags()")) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONObject.put(jSONArray.getString(i), "");
                }
                sendTags(jSONObject, changeTagsUpdateHandler);
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for deleteTags.", th);
            }
        }
    }

    public static void idsAvailable(IdsAvailableHandler idsAvailableHandler2) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("idsAvailable()")) {
            idsAvailableHandler = idsAvailableHandler2;
            AnonymousClass16 r2 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass16 */

                public void run() {
                    if (OneSignal.getUserId() != null) {
                        OSUtils.runOnMainUIThread(new Runnable() {
                            /* class com.onesignal.OneSignal.AnonymousClass16.AnonymousClass1 */

                            public void run() {
                                OneSignal.internalFireIdsAvailableCallback();
                            }
                        });
                    }
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "You must initialize OneSignal before getting tags! Moving this tag operation to a pending queue.");
                addTaskToQueue(new PendingTaskRunnable(r2));
                return;
            }
            r2.run();
        }
    }

    static void fireIdsAvailableCallback() {
        if (idsAvailableHandler != null) {
            OSUtils.runOnMainUIThread(new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass17 */

                public void run() {
                    OneSignal.internalFireIdsAvailableCallback();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void internalFireIdsAvailableCallback() {
        synchronized (OneSignal.class) {
            if (idsAvailableHandler != null) {
                String registrationId = OneSignalStateSynchronizer.getRegistrationId();
                if (!OneSignalStateSynchronizer.getSubscribed()) {
                    registrationId = null;
                }
                String userId2 = getUserId();
                if (userId2 != null) {
                    idsAvailableHandler.idsAvailable(userId2, registrationId);
                    if (registrationId != null) {
                        idsAvailableHandler = null;
                    }
                }
            }
        }
    }

    static void sendPurchases(JSONArray jSONArray, boolean z, OneSignalRestClient.ResponseHandler responseHandler) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("sendPurchases()")) {
            if (getUserId() == null) {
                IAPUpdateJob iAPUpdateJob = new IAPUpdateJob(jSONArray);
                iapUpdateJob = iAPUpdateJob;
                iAPUpdateJob.newAsExisting = z;
                iapUpdateJob.restResponseHandler = responseHandler;
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_id", getSavedAppId());
                if (z) {
                    jSONObject.put("existing", true);
                }
                jSONObject.put("purchases", jSONArray);
                OneSignalRestClient.post("players/" + getUserId() + "/on_purchase", jSONObject, responseHandler);
                if (getEmailId() != null) {
                    OneSignalRestClient.post("players/" + getEmailId() + "/on_purchase", jSONObject, null);
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON for sendPurchases.", th);
            }
        }
    }

    private static boolean openURLFromNotification(Context context, JSONArray jSONArray) {
        String optString;
        if (shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            return false;
        }
        int length = jSONArray.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
                    if (jSONObject2.has("u") && (optString = jSONObject2.optString("u", null)) != null) {
                        OSUtils.openURLInBrowser(optString);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                Log(log_level, "Error parsing JSON item " + i + "/" + length + " for launching a web URL.", th);
            }
        }
        return z;
    }

    private static void runNotificationOpenedCallback(JSONArray jSONArray, boolean z, boolean z2) {
        Builder builder = mInitBuilder;
        if (builder == null || builder.mNotificationOpenedHandler == null) {
            unprocessedOpenedNotifis.add(jSONArray);
        } else {
            fireNotificationOpenedHandler(generateOsNotificationOpenResult(jSONArray, z, z2));
        }
    }

    private static OSNotificationOpenResult generateOsNotificationOpenResult(JSONArray jSONArray, boolean z, boolean z2) {
        int length = jSONArray.length();
        OSNotificationOpenResult oSNotificationOpenResult = new OSNotificationOpenResult();
        OSNotification oSNotification = new OSNotification();
        oSNotification.isAppInFocus = isAppActive();
        oSNotification.shown = z;
        oSNotification.androidNotificationId = jSONArray.optJSONObject(0).optInt(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
        boolean z3 = true;
        String str = null;
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                oSNotification.payload = NotificationBundleProcessor.OSNotificationPayloadFrom(jSONObject);
                if (str == null && jSONObject.has(GenerateNotification.BUNDLE_KEY_ACTION_ID)) {
                    str = jSONObject.optString(GenerateNotification.BUNDLE_KEY_ACTION_ID, null);
                }
                if (z3) {
                    z3 = false;
                } else {
                    if (oSNotification.groupedNotifications == null) {
                        oSNotification.groupedNotifications = new ArrayList();
                    }
                    oSNotification.groupedNotifications.add(oSNotification.payload);
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Error parsing JSON item " + i + "/" + length + " for callback.", th);
            }
        }
        oSNotificationOpenResult.notification = oSNotification;
        oSNotificationOpenResult.action = new OSNotificationAction();
        oSNotificationOpenResult.action.actionID = str;
        oSNotificationOpenResult.action.type = str != null ? OSNotificationAction.ActionType.ActionTaken : OSNotificationAction.ActionType.Opened;
        if (z2) {
            oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.InAppAlert;
        } else {
            oSNotificationOpenResult.notification.displayType = OSNotification.DisplayType.Notification;
        }
        return oSNotificationOpenResult;
    }

    private static void fireNotificationOpenedHandler(final OSNotificationOpenResult oSNotificationOpenResult) {
        OSUtils.runOnMainUIThread(new Runnable() {
            /* class com.onesignal.OneSignal.AnonymousClass18 */

            public void run() {
                OneSignal.mInitBuilder.mNotificationOpenedHandler.notificationOpened(OSNotificationOpenResult.this);
            }
        });
    }

    static void handleNotificationReceived(JSONArray jSONArray, boolean z, boolean z2) {
        OSNotificationOpenResult generateOsNotificationOpenResult = generateOsNotificationOpenResult(jSONArray, z, z2);
        if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
            trackFirebaseAnalytics.trackReceivedEvent(generateOsNotificationOpenResult);
        }
        Builder builder = mInitBuilder;
        if (builder != null && builder.mNotificationReceivedHandler != null) {
            mInitBuilder.mNotificationReceivedHandler.notificationReceived(generateOsNotificationOpenResult.notification);
        }
    }

    public static void handleNotificationOpen(Context context, JSONArray jSONArray, boolean z, String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            notificationOpenedRESTCall(context, jSONArray);
            if (trackFirebaseAnalytics != null && getFirebaseAnalyticsEnabled()) {
                trackFirebaseAnalytics.trackOpenedEvent(generateOsNotificationOpenResult(jSONArray, true, z));
            }
            boolean z2 = false;
            boolean equals = "DISABLE".equals(OSUtils.getManifestMeta(context, "com.onesignal.NotificationOpened.DEFAULT"));
            if (!equals) {
                z2 = openURLFromNotification(context, jSONArray);
            }
            if (shouldInitDirectSessionFromNotificationOpen(context, z, z2, equals)) {
                AppEntryAction appEntryAction = AppEntryAction.NOTIFICATION_CLICK;
                appEntryState = appEntryAction;
                sessionManager.onDirectInfluenceFromNotificationOpen(appEntryAction, str);
            }
            runNotificationOpenedCallback(jSONArray, true, z);
        }
    }

    static boolean startOrResumeApp(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return false;
        }
        launchIntentForPackage.setFlags(268566528);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    private static boolean shouldInitDirectSessionFromNotificationOpen(Context context, boolean z, boolean z2, boolean z3) {
        return !z && !z2 && !z3 && !foreground && startOrResumeApp(context);
    }

    private static void notificationOpenedRESTCall(Context context, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i).optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, null)).optString("i", null);
                if (!postedOpenedNotifIds.contains(optString)) {
                    postedOpenedNotifIds.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", getSavedAppId(context));
                    jSONObject.put("player_id", getSavedUserId(context));
                    jSONObject.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, true);
                    jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, osUtils.getDeviceType());
                    OneSignalRestClient.put("notifications/" + optString, jSONObject, new OneSignalRestClient.ResponseHandler() {
                        /* class com.onesignal.OneSignal.AnonymousClass19 */

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onFailure(int i, String str, Throwable th) {
                            OneSignal.logHttpError("sending Notification Opened Failed", i, th, str);
                        }
                    });
                }
            } catch (Throwable th) {
                Log(LOG_LEVEL.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    private static void saveAppId(String str) {
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_APP_ID, str);
        }
    }

    static String getSavedAppId() {
        return getSavedAppId(appContext);
    }

    private static String getSavedAppId(Context context) {
        if (context == null) {
            return null;
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_APP_ID, null);
    }

    static boolean getSavedUserConsentStatus() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_USER_PROVIDED_CONSENT, false);
    }

    static void saveUserConsentStatus(boolean z) {
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_USER_PROVIDED_CONSENT, z);
    }

    private static String getSavedUserId(Context context) {
        if (context == null) {
            return null;
        }
        return OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_PLAYER_ID, null);
    }

    static boolean hasUserId() {
        return getUserId() != null;
    }

    static String getUserId() {
        Context context;
        if (userId == null && (context = appContext) != null) {
            userId = getSavedUserId(context);
        }
        return userId;
    }

    static void saveUserId(String str) {
        userId = str;
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_PLAYER_ID, userId);
        }
    }

    static boolean hasEmailId() {
        return !TextUtils.isEmpty(emailId);
    }

    static String getEmailId() {
        if (TextUtils.isEmpty(emailId) && appContext != null) {
            emailId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_EMAIL_ID, null);
        }
        return emailId;
    }

    static void saveEmailId(String str) {
        emailId = str;
        if (appContext != null) {
            OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_EMAIL_ID, "".equals(emailId) ? null : emailId);
        }
    }

    static boolean getFilterOtherGCMReceivers(Context context) {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_FILTER_OTHER_GCM_RECEIVERS, false);
    }

    static void saveFilterOtherGCMReceivers(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_FILTER_OTHER_GCM_RECEIVERS, z);
        }
    }

    static void updateUserIdDependents(String str) {
        saveUserId(str);
        fireIdsAvailableCallback();
        internalFireGetTagsCallbacks();
        getCurrentSubscriptionState(appContext).setUserId(str);
        IAPUpdateJob iAPUpdateJob = iapUpdateJob;
        if (iAPUpdateJob != null) {
            sendPurchases(iAPUpdateJob.toReport, iapUpdateJob.newAsExisting, iapUpdateJob.restResponseHandler);
            iapUpdateJob = null;
        }
        OneSignalStateSynchronizer.refreshEmailState();
        OneSignalChromeTabAndroidFrame.setup(appId, str, AdvertisingIdProviderGPS.getLastValue());
    }

    static void updateEmailIdDependents(String str) {
        saveEmailId(str);
        getCurrentEmailSubscriptionState(appContext).setEmailUserId(str);
        try {
            OneSignalStateSynchronizer.updatePushState(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static boolean getFirebaseAnalyticsEnabled() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_FIREBASE_TRACKING_ENABLED, false);
    }

    static boolean getClearGroupSummaryClick() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLEAR_GROUP_SUMMARY_CLICK, true);
    }

    public static void enableVibrate(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_VIBRATE_ENABLED, z);
        }
    }

    static boolean getVibrate() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_VIBRATE_ENABLED, true);
    }

    public static void enableSound(boolean z) {
        if (appContext != null) {
            OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_SOUND_ENABLED, z);
        }
    }

    static boolean getSoundEnabled() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_GT_SOUND_ENABLED, true);
    }

    static void setLastSessionTime(long j) {
        OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_LAST_SESSION_TIME, j);
    }

    private static long getLastSessionTime() {
        return OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_LAST_SESSION_TIME, -31000);
    }

    public static void setInFocusDisplaying(OSInFocusDisplayOption oSInFocusDisplayOption) {
        mInitBuilder.mDisplayOptionCarryOver = true;
        mInitBuilder.mDisplayOption = oSInFocusDisplayOption;
    }

    public static void setInFocusDisplaying(int i) {
        setInFocusDisplaying(getInFocusDisplaying(i));
    }

    public static OSInFocusDisplayOption currentInFocusDisplayOption() {
        return mInitBuilder.mDisplayOption;
    }

    private static OSInFocusDisplayOption getInFocusDisplaying(int i) {
        if (i == 0) {
            return OSInFocusDisplayOption.None;
        }
        if (i == 1) {
            return OSInFocusDisplayOption.InAppAlert;
        }
        if (i == 2) {
            return OSInFocusDisplayOption.Notification;
        }
        if (i < 0) {
            return OSInFocusDisplayOption.None;
        }
        return OSInFocusDisplayOption.Notification;
    }

    static boolean getNotificationsWhenActiveEnabled() {
        Builder builder = mInitBuilder;
        if (builder == null || builder.mDisplayOption == OSInFocusDisplayOption.Notification) {
            return true;
        }
        return false;
    }

    static boolean getInAppAlertNotificationEnabled() {
        Builder builder = mInitBuilder;
        if (builder != null && builder.mDisplayOption == OSInFocusDisplayOption.InAppAlert) {
            return true;
        }
        return false;
    }

    public static void setSubscription(final boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setSubscription()")) {
            AnonymousClass20 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass20 */

                public void run() {
                    OneSignal.getCurrentSubscriptionState(OneSignal.appContext).setUserSubscriptionSetting(z);
                    OneSignalStateSynchronizer.setSubscription(z);
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Moving subscription action to a waiting task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void setLocationShared(boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("setLocationShared()")) {
            shareLocation = z;
            if (!z) {
                OneSignalStateSynchronizer.clearLocation();
            }
            LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
            Log(log_level, "shareLocation:" + shareLocation);
        }
    }

    public static void promptLocation() {
        promptLocation(null, false);
    }

    static void promptLocation(final OSPromptActionCompletionCallback oSPromptActionCompletionCallback, final boolean z) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("promptLocation()")) {
            AnonymousClass21 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass21 */

                public void run() {
                    LocationController.getLocation(OneSignal.appContext, true, z, new LocationController.LocationPromptCompletionHandler() {
                        /* class com.onesignal.OneSignal.AnonymousClass21.AnonymousClass1 */

                        @Override // com.onesignal.LocationController.LocationHandler
                        public LocationController.PermissionType getType() {
                            return LocationController.PermissionType.PROMPT_LOCATION;
                        }

                        @Override // com.onesignal.LocationController.LocationHandler
                        public void onComplete(LocationController.LocationPoint locationPoint) {
                            if (!OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName("promptLocation()") && locationPoint != null) {
                                OneSignalStateSynchronizer.updateLocation(locationPoint);
                            }
                        }

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.LocationController.LocationPromptCompletionHandler
                        public void onAnswered(PromptActionResult promptActionResult) {
                            super.onAnswered(promptActionResult);
                            if (OSPromptActionCompletionCallback.this != null) {
                                OSPromptActionCompletionCallback.this.onCompleted(promptActionResult);
                            }
                        }
                    });
                    boolean unused = OneSignal.promptedLocation = true;
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not prompt for location at this time - moving this operation to awaiting queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void clearOneSignalNotifications() {
        AnonymousClass22 r0 = new Runnable() {
            /* class com.onesignal.OneSignal.AnonymousClass22 */

            public void run() {
                NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(OneSignal.appContext);
                OneSignalDbHelper instance = OneSignalDbHelper.getInstance(OneSignal.appContext);
                Cursor query = instance.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, "dismissed = 0 AND opened = 0", null, null, null, null);
                if (query.moveToFirst()) {
                    do {
                        notificationManager.cancel(query.getInt(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID)));
                    } while (query.moveToNext());
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", (Integer) 1);
                instance.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "opened = 0", null);
                BadgeCountUpdater.updateCount(0, OneSignal.appContext);
                query.close();
            }
        };
        if (appContext == null || shouldRunTaskThroughQueue()) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not clear notifications at this time - moving this operation toa waiting task queue.");
            addTaskToQueue(new PendingTaskRunnable(r0));
            return;
        }
        r0.run();
    }

    public static void cancelNotification(final int i) {
        AnonymousClass23 r0 = new Runnable() {
            /* class com.onesignal.OneSignal.AnonymousClass23 */

            public void run() {
                OneSignalDbHelper instance = OneSignalDbHelper.getInstance(OneSignal.appContext);
                String str = "android_notification_id = " + i + " AND " + OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED + " = 0 AND " + "dismissed" + " = 0";
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", (Integer) 1);
                if (instance.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, str, null) > 0) {
                    NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss(OneSignal.appContext, instance, i);
                }
                BadgeCountUpdater.update(instance, OneSignal.appContext);
                OneSignalNotificationManager.getNotificationManager(OneSignal.appContext).cancel(i);
            }
        };
        if (appContext == null || shouldRunTaskThroughQueue()) {
            LOG_LEVEL log_level = LOG_LEVEL.ERROR;
            Log(log_level, "OneSignal.init has not been called. Could not clear notification id: " + i + " at this time - movingthis operation to a waiting task queue. The notification will still be canceledfrom NotificationManager at this time.");
            taskQueueWaitingForInit.add(r0);
            return;
        }
        r0.run();
    }

    public static void cancelGroupedNotifications(final String str) {
        if (!shouldLogUserPrivacyConsentErrorMessageForMethodName("cancelGroupedNotifications()")) {
            AnonymousClass24 r0 = new Runnable() {
                /* class com.onesignal.OneSignal.AnonymousClass24 */

                public void run() {
                    NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(OneSignal.appContext);
                    OneSignalDbHelper instance = OneSignalDbHelper.getInstance(OneSignal.appContext);
                    String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID};
                    String[] strArr2 = {str};
                    Cursor query = instance.query(OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, "group_id = ? AND dismissed = 0 AND opened = 0", strArr2, null, null, null);
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                        if (i != -1) {
                            notificationManager.cancel(i);
                        }
                    }
                    query.close();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("dismissed", (Integer) 1);
                    instance.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "group_id = ? AND opened = 0 AND dismissed = 0", strArr2);
                    BadgeCountUpdater.update(instance, OneSignal.appContext);
                }
            };
            if (appContext == null || shouldRunTaskThroughQueue()) {
                LOG_LEVEL log_level = LOG_LEVEL.ERROR;
                Log(log_level, "OneSignal.init has not been called. Could not clear notifications part of group " + str + " - movingthis operation to a waiting task queue.");
                addTaskToQueue(new PendingTaskRunnable(r0));
                return;
            }
            r0.run();
        }
    }

    public static void removeNotificationOpenedHandler() {
        mInitBuilder.mNotificationOpenedHandler = null;
    }

    public static void removeInAppMessageClickHandler() {
        mInitBuilder.mInAppMessageClickHandler = null;
    }

    public static void removeNotificationReceivedHandler() {
        mInitBuilder.mNotificationReceivedHandler = null;
    }

    public static void addPermissionObserver(OSPermissionObserver oSPermissionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add permission observer");
            return;
        }
        getPermissionStateChangesObserver().addObserver(oSPermissionObserver);
        if (getCurrentPermissionState(appContext).compare(getLastPermissionState(appContext))) {
            OSPermissionChangedInternalObserver.fireChangesToPublicObserver(getCurrentPermissionState(appContext));
        }
    }

    public static void removePermissionObserver(OSPermissionObserver oSPermissionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify permission observer");
        } else {
            getPermissionStateChangesObserver().removeObserver(oSPermissionObserver);
        }
    }

    public static void addSubscriptionObserver(OSSubscriptionObserver oSSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add subscription observer");
            return;
        }
        getSubscriptionStateChangesObserver().addObserver(oSSubscriptionObserver);
        if (getCurrentSubscriptionState(appContext).compare(getLastSubscriptionState(appContext))) {
            OSSubscriptionChangedInternalObserver.fireChangesToPublicObserver(getCurrentSubscriptionState(appContext));
        }
    }

    public static void removeSubscriptionObserver(OSSubscriptionObserver oSSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify subscription observer");
        } else {
            getSubscriptionStateChangesObserver().removeObserver(oSSubscriptionObserver);
        }
    }

    public static void addEmailSubscriptionObserver(OSEmailSubscriptionObserver oSEmailSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not add email subscription observer");
            return;
        }
        getEmailSubscriptionStateChangesObserver().addObserver(oSEmailSubscriptionObserver);
        if (getCurrentEmailSubscriptionState(appContext).compare(getLastEmailSubscriptionState(appContext))) {
            OSEmailSubscriptionChangedInternalObserver.fireChangesToPublicObserver(getCurrentEmailSubscriptionState(appContext));
        }
    }

    public static void removeEmailSubscriptionObserver(OSEmailSubscriptionObserver oSEmailSubscriptionObserver) {
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not modify email subscription observer");
        } else {
            getEmailSubscriptionStateChangesObserver().removeObserver(oSEmailSubscriptionObserver);
        }
    }

    public static OSPermissionSubscriptionState getPermissionSubscriptionState() {
        if (shouldLogUserPrivacyConsentErrorMessageForMethodName("getPermissionSubscriptionState()")) {
            return null;
        }
        if (appContext == null) {
            Log(LOG_LEVEL.ERROR, "OneSignal.init has not been called. Could not get OSPermissionSubscriptionState");
            return null;
        }
        OSPermissionSubscriptionState oSPermissionSubscriptionState = new OSPermissionSubscriptionState();
        oSPermissionSubscriptionState.subscriptionStatus = getCurrentSubscriptionState(appContext);
        oSPermissionSubscriptionState.permissionStatus = getCurrentPermissionState(appContext);
        oSPermissionSubscriptionState.emailSubscriptionStatus = getCurrentEmailSubscriptionState(appContext);
        return oSPermissionSubscriptionState;
    }

    public static void addTriggers(Map<String, Object> map) {
        getInAppMessageController().addTriggers(map);
    }

    public static void addTriggersFromJsonString(String str) {
        try {
            addTriggers(JSONUtils.jsonObjectToMap(new JSONObject(str)));
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "addTriggersFromJsonString, invalid json", e);
        }
    }

    public static void addTrigger(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        getInAppMessageController().addTriggers(hashMap);
    }

    public static void removeTriggersForKeys(Collection<String> collection) {
        getInAppMessageController().removeTriggersForKeys(collection);
    }

    public static void removeTriggersForKeysFromJsonArrayString(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            Collection<String> extractStringsFromCollection = OSUtils.extractStringsFromCollection(JSONUtils.jsonArrayToList(jSONArray));
            if (jSONArray.length() != extractStringsFromCollection.size()) {
                Log(LOG_LEVEL.WARN, "removeTriggersForKeysFromJsonArrayString: Skipped removing non-String type keys ");
            }
            getInAppMessageController().removeTriggersForKeys(extractStringsFromCollection);
        } catch (JSONException e) {
            Log(LOG_LEVEL.ERROR, "removeTriggersForKeysFromJsonArrayString, invalid json", e);
        }
    }

    public static void removeTriggerForKey(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        getInAppMessageController().removeTriggersForKeys(arrayList);
    }

    public static Object getTriggerValueForKey(String str) {
        return getInAppMessageController().getTriggerValue(str);
    }

    public static void pauseInAppMessages(boolean z) {
        getInAppMessageController().setInAppMessagingEnabled(!z);
    }

    private static boolean isDuplicateNotification(String str, Context context) {
        if (str != null && !"".equals(str)) {
            Cursor query = OneSignalDbHelper.getInstance(context).query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, null, null, null);
            boolean moveToFirst = query.moveToFirst();
            query.close();
            if (moveToFirst) {
                LOG_LEVEL log_level = LOG_LEVEL.DEBUG;
                Log(log_level, "Duplicate GCM message received, skip processing of " + str);
                return true;
            }
        }
        return false;
    }

    static boolean notValidOrDuplicated(Context context, JSONObject jSONObject) {
        String oSNotificationIdFromJson = OSNotificationFormatHelper.getOSNotificationIdFromJson(jSONObject);
        return oSNotificationIdFromJson == null || isDuplicateNotification(oSNotificationIdFromJson, context);
    }

    private static String getNotificationIdFromGCMJsonPayload(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM)).optString("i", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean isAppActive() {
        return initDone && isForeground();
    }

    private static boolean isPastOnSessionTime() {
        return System.currentTimeMillis() - getLastSessionTime() >= MIN_ON_SESSION_TIME_MILLIS;
    }

    static boolean areNotificationsEnabledForSubscribedState() {
        if (mInitBuilder.mUnsubscribeWhenNotificationsAreDisabled) {
            return OSUtils.areNotificationsEnabled(appContext);
        }
        return true;
    }

    static void handleSuccessfulEmailLogout() {
        EmailUpdateHandler emailUpdateHandler2 = emailLogoutHandler;
        if (emailUpdateHandler2 != null) {
            emailUpdateHandler2.onSuccess();
            emailLogoutHandler = null;
        }
    }

    static void handleFailedEmailLogout() {
        EmailUpdateHandler emailUpdateHandler2 = emailLogoutHandler;
        if (emailUpdateHandler2 != null) {
            emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            emailLogoutHandler = null;
        }
    }

    static void fireEmailUpdateSuccess() {
        EmailUpdateHandler emailUpdateHandler2 = emailUpdateHandler;
        if (emailUpdateHandler2 != null) {
            emailUpdateHandler2.onSuccess();
            emailUpdateHandler = null;
        }
    }

    static void fireEmailUpdateFailure() {
        EmailUpdateHandler emailUpdateHandler2 = emailUpdateHandler;
        if (emailUpdateHandler2 != null) {
            emailUpdateHandler2.onFailure(new EmailUpdateError(EmailErrorType.NETWORK, "Failed due to network failure. Will retry on next sync."));
            emailUpdateHandler = null;
        }
    }

    static void setTrackerFactory(OSTrackerFactory oSTrackerFactory) {
        trackerFactory = oSTrackerFactory;
    }

    static void setSessionManager(OSSessionManager oSSessionManager) {
        sessionManager = oSSessionManager;
    }

    static void setSharedPreferences(OSSharedPreferences oSSharedPreferences) {
        preferences = oSSharedPreferences;
    }

    static OSSessionManager.SessionListener getSessionListener() {
        return sessionListener;
    }

    static OSSessionManager getSessionManager() {
        return sessionManager;
    }

    static void sendClickActionOutcomes(List<OSInAppMessageOutcome> list) {
        OSOutcomeEventsController oSOutcomeEventsController = outcomeEventsController;
        if (oSOutcomeEventsController == null) {
            Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
        } else {
            oSOutcomeEventsController.sendClickActionOutcomes(list);
        }
    }

    public static void sendOutcome(String str) {
        sendOutcome(str, null);
    }

    public static void sendOutcome(String str, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str)) {
            OSOutcomeEventsController oSOutcomeEventsController = outcomeEventsController;
            if (oSOutcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                oSOutcomeEventsController.sendOutcomeEvent(str, outcomeCallback);
            }
        }
    }

    public static void sendUniqueOutcome(String str) {
        sendUniqueOutcome(str, null);
    }

    public static void sendUniqueOutcome(String str, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str)) {
            OSOutcomeEventsController oSOutcomeEventsController = outcomeEventsController;
            if (oSOutcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                oSOutcomeEventsController.sendUniqueOutcomeEvent(str, outcomeCallback);
            }
        }
    }

    public static void sendOutcomeWithValue(String str, float f) {
        sendOutcomeWithValue(str, f, null);
    }

    public static void sendOutcomeWithValue(String str, float f, OutcomeCallback outcomeCallback) {
        if (isValidOutcomeEntry(str) && isValidOutcomeValue(f)) {
            OSOutcomeEventsController oSOutcomeEventsController = outcomeEventsController;
            if (oSOutcomeEventsController == null) {
                Log(LOG_LEVEL.ERROR, "Make sure OneSignal.init is called first");
            } else {
                oSOutcomeEventsController.sendOutcomeEventWithValue(str, f, outcomeCallback);
            }
        }
    }

    private static boolean isValidOutcomeValue(float f) {
        if (f > 0.0f) {
            return true;
        }
        Log(LOG_LEVEL.ERROR, "Outcome value must be greater than 0");
        return false;
    }

    private static boolean isValidOutcomeEntry(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        Log(LOG_LEVEL.ERROR, "Outcome name must not be empty");
        return false;
    }
}
