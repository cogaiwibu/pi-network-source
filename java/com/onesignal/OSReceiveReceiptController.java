package com.onesignal;

import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;

/* access modifiers changed from: package-private */
public class OSReceiveReceiptController {
    private static OSReceiveReceiptController sInstance;
    private final OSReceiveReceiptRepository repository = new OSReceiveReceiptRepository();

    private OSReceiveReceiptController() {
    }

    public static synchronized OSReceiveReceiptController getInstance() {
        OSReceiveReceiptController oSReceiveReceiptController;
        synchronized (OSReceiveReceiptController.class) {
            if (sInstance == null) {
                sInstance = new OSReceiveReceiptController();
            }
            oSReceiveReceiptController = sInstance;
        }
        return oSReceiveReceiptController;
    }

    /* access modifiers changed from: package-private */
    public void sendReceiveReceipt(final String str) {
        String savedAppId = (OneSignal.appId == null || OneSignal.appId.isEmpty()) ? OneSignal.getSavedAppId() : OneSignal.appId;
        String userId = OneSignal.getUserId();
        if (!isReceiveReceiptEnabled()) {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "sendReceiveReceipt disable");
            return;
        }
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "sendReceiveReceipt appId: " + savedAppId + " playerId: " + userId + " notificationId: " + str);
        this.repository.sendReceiveReceipt(savedAppId, userId, str, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OSReceiveReceiptController.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.Log(log_level, "Receive receipt sent for notificationID: " + str);
            }

            /* access modifiers changed from: package-private */
            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.Log(log_level, "Receive receipt failed with statusCode: " + i + " response: " + str);
            }
        });
    }

    private boolean isReceiveReceiptEnabled() {
        return OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RECEIVE_RECEIPTS_ENABLED, false);
    }
}
