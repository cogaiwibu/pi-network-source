package com.onesignal;

import com.onesignal.OneSignalRestClient;
import org.json.JSONObject;

class OneSignalRestClientWrapper implements OneSignalAPIClient {
    OneSignalRestClientWrapper() {
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void put(String str, JSONObject jSONObject, final OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        OneSignalRestClient.put(str, jSONObject, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass1 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        });
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void post(String str, JSONObject jSONObject, final OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        OneSignalRestClient.post(str, jSONObject, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass2 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        });
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void get(String str, final OneSignalApiResponseHandler oneSignalApiResponseHandler, String str2) {
        OneSignalRestClient.get(str, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass3 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        }, str2);
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void getSync(String str, final OneSignalApiResponseHandler oneSignalApiResponseHandler, String str2) {
        OneSignalRestClient.getSync(str, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass4 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        }, str2);
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void putSync(String str, JSONObject jSONObject, final OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        OneSignalRestClient.putSync(str, jSONObject, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass5 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        });
    }

    @Override // com.onesignal.OneSignalAPIClient
    public void postSync(String str, JSONObject jSONObject, final OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        OneSignalRestClient.postSync(str, jSONObject, new OneSignalRestClient.ResponseHandler() {
            /* class com.onesignal.OneSignalRestClientWrapper.AnonymousClass6 */

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onSuccess(String str) {
                oneSignalApiResponseHandler.onSuccess(str);
            }

            @Override // com.onesignal.OneSignalRestClient.ResponseHandler
            public void onFailure(int i, String str, Throwable th) {
                oneSignalApiResponseHandler.onFailure(i, str, th);
            }
        });
    }
}
