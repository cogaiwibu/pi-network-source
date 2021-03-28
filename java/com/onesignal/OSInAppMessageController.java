package com.onesignal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.onesignal.OSDynamicTriggerController;
import com.onesignal.OSInAppMessageAction;
import com.onesignal.OSSystemConditionController;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSInAppMessageController implements OSDynamicTriggerController.OSDynamicTriggerControllerObserver, OSSystemConditionController.OSSystemConditionObserver {
    public static final String IN_APP_MESSAGES_JSON_KEY = "in_app_messages";
    private static final Object LOCK = new Object();
    private static final String OS_SAVE_IN_APP_MESSAGE = "OS_SAVE_IN_APP_MESSAGE";
    private static ArrayList<String> PREFERRED_VARIANT_ORDER = new ArrayList<String>() {
        /* class com.onesignal.OSInAppMessageController.AnonymousClass1 */

        {
            add("android");
            add(TapjoyConstants.TJC_APP_PLACEMENT);
            add("all");
        }
    };
    private final Set<String> clickedClickIds = OSUtils.newConcurrentSet();
    private OSInAppMessagePrompt currentPrompt = null;
    private final Set<String> dismissedMessages = OSUtils.newConcurrentSet();
    private int htmlNetworkRequestAttemptCount = 0;
    private final Set<String> impressionedMessages = OSUtils.newConcurrentSet();
    private OSInAppMessageRepository inAppMessageRepository;
    private boolean inAppMessageShowing = false;
    private boolean inAppMessagingEnabled = true;
    Date lastTimeInAppDismissed = null;
    private final ArrayList<OSInAppMessage> messageDisplayQueue = new ArrayList<>();
    private ArrayList<OSInAppMessage> messages = new ArrayList<>();
    private List<OSInAppMessage> redisplayedInAppMessages;
    private OSSystemConditionController systemConditionController = new OSSystemConditionController(this);
    OSTriggerController triggerController = new OSTriggerController(this);

    static /* synthetic */ int access$908(OSInAppMessageController oSInAppMessageController) {
        int i = oSInAppMessageController.htmlNetworkRequestAttemptCount;
        oSInAppMessageController.htmlNetworkRequestAttemptCount = i + 1;
        return i;
    }

    protected OSInAppMessageController(OneSignalDbHelper oneSignalDbHelper) {
        Set<String> stringSet = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_DISMISSED_IAMS, null);
        if (stringSet != null) {
            this.dismissedMessages.addAll(stringSet);
        }
        Set<String> stringSet2 = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_IMPRESSIONED_IAMS, null);
        if (stringSet2 != null) {
            this.impressionedMessages.addAll(stringSet2);
        }
        Set<String> stringSet3 = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLICKED_CLICK_IDS_IAMS, null);
        if (stringSet3 != null) {
            this.clickedClickIds.addAll(stringSet3);
        }
        initRedisplayData(oneSignalDbHelper);
    }

    /* access modifiers changed from: package-private */
    public OSInAppMessageRepository getInAppMessageRepository(OneSignalDbHelper oneSignalDbHelper) {
        if (this.inAppMessageRepository == null) {
            this.inAppMessageRepository = new OSInAppMessageRepository(oneSignalDbHelper);
        }
        return this.inAppMessageRepository;
    }

    /* access modifiers changed from: protected */
    public void initRedisplayData(OneSignalDbHelper oneSignalDbHelper) {
        OSInAppMessageRepository inAppMessageRepository2 = getInAppMessageRepository(oneSignalDbHelper);
        this.inAppMessageRepository = inAppMessageRepository2;
        this.redisplayedInAppMessages = inAppMessageRepository2.getCachedInAppMessages();
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "redisplayedInAppMessages: " + this.redisplayedInAppMessages.toString());
    }

    /* access modifiers changed from: package-private */
    public void resetSessionLaunchTime() {
        OSDynamicTriggerController.resetSessionLaunchTime();
    }

    /* access modifiers changed from: package-private */
    public void initWithCachedInAppMessages() {
        if (!this.messages.isEmpty()) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level, "initWithCachedInAppMessages with already in memory messages: " + this.messages);
            return;
        }
        String string = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CACHED_IAMS, null);
        OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level2, "initWithCachedInAppMessages: " + string);
        if (string != null && !string.isEmpty()) {
            synchronized (LOCK) {
                try {
                    if (this.messages.isEmpty()) {
                        processInAppMessageJson(new JSONArray(string));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void receivedInAppMessageJson(JSONArray jSONArray) throws JSONException {
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CACHED_IAMS, jSONArray.toString());
        resetRedisplayMessagesBySession();
        processInAppMessageJson(jSONArray);
    }

    private void resetRedisplayMessagesBySession() {
        for (OSInAppMessage oSInAppMessage : this.redisplayedInAppMessages) {
            oSInAppMessage.setDisplayedInSession(false);
        }
    }

    private void processInAppMessageJson(JSONArray jSONArray) throws JSONException {
        synchronized (LOCK) {
            ArrayList<OSInAppMessage> arrayList = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new OSInAppMessage(jSONArray.getJSONObject(i)));
            }
            this.messages = arrayList;
        }
        evaluateInAppMessages();
    }

    private void evaluateInAppMessages() {
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Starting evaluateInAppMessages");
        Iterator<OSInAppMessage> it = this.messages.iterator();
        while (it.hasNext()) {
            OSInAppMessage next = it.next();
            if (this.triggerController.evaluateMessageTriggers(next)) {
                setDataForRedisplay(next);
                if (!this.dismissedMessages.contains(next.messageId)) {
                    queueMessageForDisplay(next);
                }
            }
        }
    }

    private static String variantIdForMessage(OSInAppMessage oSInAppMessage) {
        String correctedLanguage = OSUtils.getCorrectedLanguage();
        Iterator<String> it = PREFERRED_VARIANT_ORDER.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (oSInAppMessage.variants.containsKey(next)) {
                HashMap<String, String> hashMap = oSInAppMessage.variants.get(next);
                if (hashMap.containsKey(correctedLanguage)) {
                    return hashMap.get(correctedLanguage);
                }
                return hashMap.get("default");
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void printHttpSuccessForInAppMessageRequest(String str, String str2) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "Successful post for in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: private */
    public static void printHttpErrorForInAppMessageRequest(String str, int i, String str2) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
        OneSignal.onesignalLog(log_level, "Encountered a " + i + " error while attempting in-app message " + str + " request: " + str2);
    }

    /* access modifiers changed from: package-private */
    public void onMessageWasShown(final OSInAppMessage oSInAppMessage) {
        if (!oSInAppMessage.isPreview && !this.impressionedMessages.contains(oSInAppMessage.messageId)) {
            this.impressionedMessages.add(oSInAppMessage.messageId);
            final String variantIdForMessage = variantIdForMessage(oSInAppMessage);
            if (variantIdForMessage != null) {
                try {
                    AnonymousClass2 r1 = new JSONObject() {
                        /* class com.onesignal.OSInAppMessageController.AnonymousClass2 */

                        {
                            put("app_id", OneSignal.appId);
                            put("player_id", OneSignal.getUserId());
                            put("variant_id", variantIdForMessage);
                            put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new OSUtils().getDeviceType());
                            put("first_impression", true);
                        }
                    };
                    OneSignalRestClient.post("in_app_messages/" + oSInAppMessage.messageId + "/impression", r1, new OneSignalRestClient.ResponseHandler() {
                        /* class com.onesignal.OSInAppMessageController.AnonymousClass3 */

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onSuccess(String str) {
                            OSInAppMessageController.printHttpSuccessForInAppMessageRequest("impression", str);
                            OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_IMPRESSIONED_IAMS, OSInAppMessageController.this.impressionedMessages);
                        }

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onFailure(int i, String str, Throwable th) {
                            OSInAppMessageController.printHttpErrorForInAppMessageRequest("impression", i, str);
                            OSInAppMessageController.this.impressionedMessages.remove(oSInAppMessage.messageId);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.ERROR, "Unable to execute in-app message impression HTTP request due to invalid JSON");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onMessageActionOccurredOnMessage(OSInAppMessage oSInAppMessage, JSONObject jSONObject) throws JSONException {
        OSInAppMessageAction oSInAppMessageAction = new OSInAppMessageAction(jSONObject);
        oSInAppMessageAction.firstClick = oSInAppMessage.takeActionAsUnique();
        firePublicClickHandler(oSInAppMessage.messageId, oSInAppMessageAction);
        beginProcessingPrompts(oSInAppMessage, oSInAppMessageAction.prompts);
        fireClickAction(oSInAppMessageAction);
        fireRESTCallForClick(oSInAppMessage, oSInAppMessageAction);
        fireTagCallForClick(oSInAppMessageAction);
        fireOutcomesForClick(oSInAppMessage.messageId, oSInAppMessageAction.outcomes);
    }

    /* access modifiers changed from: package-private */
    public void onMessageActionOccurredOnPreview(OSInAppMessage oSInAppMessage, JSONObject jSONObject) throws JSONException {
        OSInAppMessageAction oSInAppMessageAction = new OSInAppMessageAction(jSONObject);
        oSInAppMessageAction.firstClick = oSInAppMessage.takeActionAsUnique();
        firePublicClickHandler(oSInAppMessage.messageId, oSInAppMessageAction);
        beginProcessingPrompts(oSInAppMessage, oSInAppMessageAction.prompts);
        fireClickAction(oSInAppMessageAction);
        logInAppMessagePreviewActions(oSInAppMessageAction);
    }

    private void logInAppMessagePreviewActions(OSInAppMessageAction oSInAppMessageAction) {
        if (oSInAppMessageAction.tags != null) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + oSInAppMessageAction.tags.toString());
        }
        if (oSInAppMessageAction.outcomes.size() > 0) {
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level2, "Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + oSInAppMessageAction.outcomes.toString());
        }
    }

    private void beginProcessingPrompts(OSInAppMessage oSInAppMessage, List<OSInAppMessagePrompt> list) {
        if (list.size() > 0) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "IAM showing prompts from IAM: " + oSInAppMessage.toString());
            WebViewManager.dismissCurrentInAppMessage();
            showMultiplePrompts(oSInAppMessage, list);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showMultiplePrompts(final OSInAppMessage oSInAppMessage, final List<OSInAppMessagePrompt> list) {
        Iterator<OSInAppMessagePrompt> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            OSInAppMessagePrompt next = it.next();
            if (!next.hasPrompted()) {
                this.currentPrompt = next;
                break;
            }
        }
        if (this.currentPrompt != null) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "IAM prompt to handle: " + this.currentPrompt.toString());
            this.currentPrompt.setPrompted(true);
            this.currentPrompt.handlePrompt(new OneSignal.OSPromptActionCompletionCallback() {
                /* class com.onesignal.OSInAppMessageController.AnonymousClass4 */

                @Override // com.onesignal.OneSignal.OSPromptActionCompletionCallback
                public void onCompleted(OneSignal.PromptActionResult promptActionResult) {
                    OSInAppMessageController.this.currentPrompt = null;
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                    OneSignal.onesignalLog(log_level, "IAM prompt to handle finished with result: " + promptActionResult);
                    if (!oSInAppMessage.isPreview || promptActionResult != OneSignal.PromptActionResult.LOCATION_PERMISSIONS_MISSING_MANIFEST) {
                        OSInAppMessageController.this.showMultiplePrompts(oSInAppMessage, list);
                    } else {
                        OSInAppMessageController.this.showAlertDialogMessage(oSInAppMessage, list);
                    }
                }
            });
            return;
        }
        OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level2, "No IAM prompt to handle, dismiss message: " + oSInAppMessage.messageId);
        messageWasDismissed(oSInAppMessage);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showAlertDialogMessage(final OSInAppMessage oSInAppMessage, final List<OSInAppMessagePrompt> list) {
        String string = OneSignal.appContext.getString(R.string.location_not_available_title);
        new AlertDialog.Builder(ActivityLifecycleHandler.curActivity).setTitle(string).setMessage(OneSignal.appContext.getString(R.string.location_not_available_message)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class com.onesignal.OSInAppMessageController.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                OSInAppMessageController.this.showMultiplePrompts(oSInAppMessage, list);
            }
        }).show();
    }

    private void fireOutcomesForClick(String str, List<OSInAppMessageOutcome> list) {
        OneSignal.getSessionManager().onDirectInfluenceFromIAMClick(str);
        OneSignal.sendClickActionOutcomes(list);
    }

    private void fireTagCallForClick(OSInAppMessageAction oSInAppMessageAction) {
        if (oSInAppMessageAction.tags != null) {
            OSInAppMessageTag oSInAppMessageTag = oSInAppMessageAction.tags;
            if (oSInAppMessageTag.getTagsToAdd() != null) {
                OneSignal.sendTags(oSInAppMessageTag.getTagsToAdd());
            }
            if (oSInAppMessageTag.getTagsToRemove() != null) {
                OneSignal.deleteTags(oSInAppMessageTag.getTagsToRemove(), (OneSignal.ChangeTagsUpdateHandler) null);
            }
        }
    }

    private void firePublicClickHandler(final String str, final OSInAppMessageAction oSInAppMessageAction) {
        if (OneSignal.mInitBuilder.mInAppMessageClickHandler != null) {
            OSUtils.runOnMainUIThread(new Runnable() {
                /* class com.onesignal.OSInAppMessageController.AnonymousClass6 */

                public void run() {
                    OneSignal.getSessionManager().onDirectInfluenceFromIAMClick(str);
                    OneSignal.mInitBuilder.mInAppMessageClickHandler.inAppMessageClicked(oSInAppMessageAction);
                }
            });
        }
    }

    private void fireClickAction(OSInAppMessageAction oSInAppMessageAction) {
        if (oSInAppMessageAction.clickUrl != null && !oSInAppMessageAction.clickUrl.isEmpty()) {
            if (oSInAppMessageAction.urlTarget == OSInAppMessageAction.OSInAppMessageActionUrlType.BROWSER) {
                OSUtils.openURLInBrowser(oSInAppMessageAction.clickUrl);
            } else if (oSInAppMessageAction.urlTarget == OSInAppMessageAction.OSInAppMessageActionUrlType.IN_APP_WEBVIEW) {
                OneSignalChromeTab.open(oSInAppMessageAction.clickUrl, true);
            }
        }
    }

    private void fireRESTCallForClick(OSInAppMessage oSInAppMessage, final OSInAppMessageAction oSInAppMessageAction) {
        final String variantIdForMessage = variantIdForMessage(oSInAppMessage);
        if (variantIdForMessage != null) {
            final String str = oSInAppMessageAction.clickId;
            if ((oSInAppMessage.getRedisplayStats().isRedisplayEnabled() && oSInAppMessage.isClickAvailable(str)) || !this.clickedClickIds.contains(str)) {
                this.clickedClickIds.add(str);
                oSInAppMessage.addClickId(str);
                try {
                    AnonymousClass7 r2 = new JSONObject() {
                        /* class com.onesignal.OSInAppMessageController.AnonymousClass7 */

                        {
                            put("app_id", OneSignal.getSavedAppId());
                            put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, new OSUtils().getDeviceType());
                            put("player_id", OneSignal.getUserId());
                            put("click_id", str);
                            put("variant_id", variantIdForMessage);
                            if (oSInAppMessageAction.firstClick) {
                                put("first_click", true);
                            }
                        }
                    };
                    OneSignalRestClient.post("in_app_messages/" + oSInAppMessage.messageId + "/click", r2, new OneSignalRestClient.ResponseHandler() {
                        /* class com.onesignal.OSInAppMessageController.AnonymousClass8 */

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onSuccess(String str) {
                            OSInAppMessageController.printHttpSuccessForInAppMessageRequest("engagement", str);
                            OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLICKED_CLICK_IDS_IAMS, OSInAppMessageController.this.clickedClickIds);
                        }

                        /* access modifiers changed from: package-private */
                        @Override // com.onesignal.OneSignalRestClient.ResponseHandler
                        public void onFailure(int i, String str, Throwable th) {
                            OSInAppMessageController.printHttpErrorForInAppMessageRequest("engagement", i, str);
                            OSInAppMessageController.this.clickedClickIds.remove(oSInAppMessageAction.clickId);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.ERROR, "Unable to execute in-app message action HTTP request due to invalid JSON");
                }
            }
        }
    }

    private void setDataForRedisplay(OSInAppMessage oSInAppMessage) {
        boolean contains = this.dismissedMessages.contains(oSInAppMessage.messageId);
        int indexOf = this.redisplayedInAppMessages.indexOf(oSInAppMessage);
        if (contains && indexOf != -1) {
            OSInAppMessage oSInAppMessage2 = this.redisplayedInAppMessages.get(indexOf);
            oSInAppMessage.getRedisplayStats().setDisplayStats(oSInAppMessage2.getRedisplayStats());
            boolean z = oSInAppMessage.isTriggerChanged() || (!oSInAppMessage2.isDisplayedInSession() && oSInAppMessage.triggers.isEmpty());
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "setDataForRedisplay: " + oSInAppMessage.toString() + " triggerHasChanged: " + z);
            if (z && oSInAppMessage.getRedisplayStats().isDelayTimeSatisfied() && oSInAppMessage.getRedisplayStats().shouldDisplayAgain()) {
                OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level2, "setDataForRedisplay message available for redisplay: " + oSInAppMessage.messageId);
                this.dismissedMessages.remove(oSInAppMessage.messageId);
                this.impressionedMessages.remove(oSInAppMessage.messageId);
                oSInAppMessage.clearClickIds();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void queueMessageForDisplay(OSInAppMessage oSInAppMessage) {
        synchronized (this.messageDisplayQueue) {
            if (!this.messageDisplayQueue.contains(oSInAppMessage)) {
                this.messageDisplayQueue.add(oSInAppMessage);
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level, "In app message with id, " + oSInAppMessage.messageId + ", added to the queue");
            }
            attemptToShowInAppMessage();
        }
    }

    private void attemptToShowInAppMessage() {
        synchronized (this.messageDisplayQueue) {
            if (!this.systemConditionController.systemConditionsAvailable()) {
                OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "In app message not showing due to system condition not correct");
                return;
            }
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "displayFirstIAMOnQueue: " + this.messageDisplayQueue);
            if (this.messageDisplayQueue.size() <= 0 || isInAppMessageShowing()) {
                OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "In app message is currently showing or there are no IAMs left in the queue!");
                return;
            }
            OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "No IAM showing currently, showing first item in the queue!");
            displayMessage(this.messageDisplayQueue.get(0));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isInAppMessageShowing() {
        return this.inAppMessageShowing;
    }

    /* access modifiers changed from: package-private */
    public OSInAppMessage getCurrentDisplayedInAppMessage() {
        if (this.inAppMessageShowing) {
            return this.messageDisplayQueue.get(0);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void messageWasDismissed(OSInAppMessage oSInAppMessage) {
        messageWasDismissed(oSInAppMessage, false);
    }

    /* access modifiers changed from: package-private */
    public void messageWasDismissed(OSInAppMessage oSInAppMessage, boolean z) {
        if (!oSInAppMessage.isPreview) {
            this.dismissedMessages.add(oSInAppMessage.messageId);
            if (!z) {
                OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_DISMISSED_IAMS, this.dismissedMessages);
                this.lastTimeInAppDismissed = new Date();
                persistInAppMessage(oSInAppMessage);
            }
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "OSInAppMessageController messageWasDismissed dismissedMessages: " + this.dismissedMessages.toString());
        }
        dismissCurrentMessage(oSInAppMessage);
    }

    /* access modifiers changed from: package-private */
    public void messageWasDismissedByBackPress(OSInAppMessage oSInAppMessage) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "OSInAppMessageController messageWasDismissed by back press: " + oSInAppMessage.toString());
        dismissCurrentMessage(oSInAppMessage);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissCurrentMessage(OSInAppMessage oSInAppMessage) {
        OneSignal.getSessionManager().onDirectInfluenceFromIAMClickFinished();
        if (this.currentPrompt != null) {
            OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "Stop evaluateMessageDisplayQueue because prompt is currently displayed");
            return;
        }
        this.inAppMessageShowing = false;
        synchronized (this.messageDisplayQueue) {
            if (this.messageDisplayQueue.size() > 0) {
                if (oSInAppMessage == null || this.messageDisplayQueue.contains(oSInAppMessage)) {
                    String str = this.messageDisplayQueue.remove(0).messageId;
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                    OneSignal.onesignalLog(log_level, "In app message with id, " + str + ", dismissed (removed) from the queue!");
                } else {
                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "Message already removed from the queue!");
                    return;
                }
            }
            if (this.messageDisplayQueue.size() > 0) {
                OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level2, "In app message on queue available: " + this.messageDisplayQueue.get(0).messageId);
                displayMessage(this.messageDisplayQueue.get(0));
            } else {
                OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "In app message dismissed evaluating messages");
                evaluateInAppMessages();
            }
        }
    }

    private void persistInAppMessage(final OSInAppMessage oSInAppMessage) {
        oSInAppMessage.getRedisplayStats().setLastDisplayTime(System.currentTimeMillis() / 1000);
        oSInAppMessage.getRedisplayStats().incrementDisplayQuantity();
        oSInAppMessage.setTriggerChanged(false);
        oSInAppMessage.setDisplayedInSession(true);
        new Thread(new Runnable() {
            /* class com.onesignal.OSInAppMessageController.AnonymousClass9 */

            public void run() {
                Thread.currentThread().setPriority(10);
                OSInAppMessageController.this.inAppMessageRepository.saveInAppMessage(oSInAppMessage);
            }
        }, OS_SAVE_IN_APP_MESSAGE).start();
        int indexOf = this.redisplayedInAppMessages.indexOf(oSInAppMessage);
        if (indexOf != -1) {
            this.redisplayedInAppMessages.set(indexOf, oSInAppMessage);
        } else {
            this.redisplayedInAppMessages.add(oSInAppMessage);
        }
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "persistInAppMessageForRedisplay: " + oSInAppMessage.toString() + " with msg array data: " + this.redisplayedInAppMessages.toString());
    }

    private static String htmlPathForMessage(OSInAppMessage oSInAppMessage) {
        String variantIdForMessage = variantIdForMessage(oSInAppMessage);
        if (variantIdForMessage == null) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
            OneSignal.onesignalLog(log_level, "Unable to find a variant for in-app message " + oSInAppMessage.messageId);
            return null;
        }
        return "in_app_messages/" + oSInAppMessage.messageId + "/variants/" + variantIdForMessage + "/html?app_id=" + OneSignal.appId;
    }

    private void displayMessage(final OSInAppMessage oSInAppMessage) {
        if (!this.inAppMessagingEnabled) {
            OneSignal.onesignalLog(OneSignal.LOG_LEVEL.VERBOSE, "In app messaging is currently paused, iam will not be shown!");
            return;
        }
        this.inAppMessageShowing = true;
        OneSignalRestClient.get(htmlPathForMessage(oSInAppMessage), new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OSInAppMessageController.AnonymousClass10 */

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                OSInAppMessageController.this.inAppMessageShowing = false;
                OSInAppMessageController.printHttpErrorForInAppMessageRequest(TJAdUnitConstants.String.HTML, i, str);
                if (!OSUtils.shouldRetryNetworkRequest(i) || OSInAppMessageController.this.htmlNetworkRequestAttemptCount >= OSUtils.MAX_NETWORK_REQUEST_ATTEMPT_COUNT) {
                    OSInAppMessageController.this.htmlNetworkRequestAttemptCount = 0;
                    OSInAppMessageController.this.messageWasDismissed(oSInAppMessage, true);
                    return;
                }
                OSInAppMessageController.access$908(OSInAppMessageController.this);
                OSInAppMessageController.this.queueMessageForDisplay(oSInAppMessage);
            }

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                OSInAppMessageController.this.htmlNetworkRequestAttemptCount = 0;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString(TJAdUnitConstants.String.HTML);
                    oSInAppMessage.setDisplayDuration(jSONObject.optDouble("display_duration"));
                    OneSignal.getSessionManager().onInAppMessageReceived(oSInAppMessage.messageId);
                    WebViewManager.showHTMLString(oSInAppMessage, string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, null);
    }

    /* access modifiers changed from: package-private */
    public void displayPreviewMessage(String str) {
        this.inAppMessageShowing = true;
        OneSignalRestClient.get("in_app_messages/device_preview?preview_id=" + str + "&app_id=" + OneSignal.appId, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OSInAppMessageController.AnonymousClass11 */

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                OSInAppMessageController.printHttpErrorForInAppMessageRequest(TJAdUnitConstants.String.HTML, i, str);
                OSInAppMessageController.this.dismissCurrentMessage(null);
            }

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString(TJAdUnitConstants.String.HTML);
                    OSInAppMessage oSInAppMessage = new OSInAppMessage(true);
                    oSInAppMessage.setDisplayDuration(jSONObject.optDouble("display_duration"));
                    WebViewManager.showHTMLString(oSInAppMessage, string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, null);
    }

    @Override // com.onesignal.OSDynamicTriggerController.OSDynamicTriggerControllerObserver
    public void messageDynamicTriggerCompleted(String str) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "messageDynamicTriggerCompleted called with triggerId: " + str);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        makeRedisplayMessagesAvailableWithTriggers(hashSet);
    }

    @Override // com.onesignal.OSDynamicTriggerController.OSDynamicTriggerControllerObserver
    public void messageTriggerConditionChanged() {
        OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "messageTriggerConditionChanged called");
        evaluateInAppMessages();
    }

    @Override // com.onesignal.OSSystemConditionController.OSSystemConditionObserver
    public void systemConditionChanged() {
        attemptToShowInAppMessage();
    }

    private void makeRedisplayMessagesAvailableWithTriggers(Collection<String> collection) {
        Iterator<OSInAppMessage> it = this.messages.iterator();
        while (it.hasNext()) {
            OSInAppMessage next = it.next();
            if (!next.isTriggerChanged() && this.redisplayedInAppMessages.contains(next) && this.triggerController.isTriggerOnMessage(next, collection)) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level, "Trigger changed for message: " + next.toString());
                next.setTriggerChanged(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addTriggers(Map<String, Object> map) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "Add trigger called with: " + map.toString());
        this.triggerController.addTriggers(map);
        makeRedisplayMessagesAvailableWithTriggers(map.keySet());
        evaluateInAppMessages();
    }

    /* access modifiers changed from: package-private */
    public void removeTriggersForKeys(Collection<String> collection) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "Remove trigger called with keys: " + collection);
        this.triggerController.removeTriggersForKeys(collection);
        makeRedisplayMessagesAvailableWithTriggers(collection);
        evaluateInAppMessages();
    }

    /* access modifiers changed from: package-private */
    public void setInAppMessagingEnabled(boolean z) {
        this.inAppMessagingEnabled = z;
        if (z) {
            evaluateInAppMessages();
        }
    }

    /* access modifiers changed from: package-private */
    public Object getTriggerValue(String str) {
        return this.triggerController.getTriggerValue(str);
    }

    public ArrayList<OSInAppMessage> getInAppMessageDisplayQueue() {
        return this.messageDisplayQueue;
    }

    public List<OSInAppMessage> getRedisplayedInAppMessages() {
        return this.redisplayedInAppMessages;
    }
}
