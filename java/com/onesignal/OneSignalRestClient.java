package com.onesignal;

import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.sdk.precache.DownloadManager;
import java.io.IOException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OneSignalRestClient {
    private static final String BASE_URL = "https://api.onesignal.com/";
    static final String CACHE_KEY_GET_TAGS = "CACHE_KEY_GET_TAGS";
    static final String CACHE_KEY_REMOTE_PARAMS = "CACHE_KEY_REMOTE_PARAMS";
    private static final int GET_TIMEOUT = 60000;
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    private static final int TIMEOUT = 120000;

    private static int getThreadTimeout(int i) {
        return i + DownloadManager.OPERATION_TIMEOUT;
    }

    /* access modifiers changed from: package-private */
    public static abstract class ResponseHandler {
        /* access modifiers changed from: package-private */
        public void onFailure(int i, String str, Throwable th) {
        }

        /* access modifiers changed from: package-private */
        public void onSuccess(String str) {
        }

        ResponseHandler() {
        }
    }

    OneSignalRestClient() {
    }

    public static void put(final String str, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable() {
            /* class com.onesignal.OneSignalRestClient.AnonymousClass1 */

            public void run() {
                OneSignalRestClient.makeRequest(str, "PUT", jSONObject, responseHandler, OneSignalRestClient.TIMEOUT, null);
            }
        }, "OS_REST_ASYNC_PUT").start();
    }

    public static void post(final String str, final JSONObject jSONObject, final ResponseHandler responseHandler) {
        new Thread(new Runnable() {
            /* class com.onesignal.OneSignalRestClient.AnonymousClass2 */

            public void run() {
                OneSignalRestClient.makeRequest(str, NativeEventsConstants.HTTP_METHOD_POST, jSONObject, responseHandler, OneSignalRestClient.TIMEOUT, null);
            }
        }, "OS_REST_ASYNC_POST").start();
    }

    public static void get(final String str, final ResponseHandler responseHandler, final String str2) {
        new Thread(new Runnable() {
            /* class com.onesignal.OneSignalRestClient.AnonymousClass3 */

            public void run() {
                OneSignalRestClient.makeRequest(str, null, null, responseHandler, OneSignalRestClient.GET_TIMEOUT, str2);
            }
        }, "OS_REST_ASYNC_GET").start();
    }

    public static void getSync(String str, ResponseHandler responseHandler, String str2) {
        makeRequest(str, null, null, responseHandler, GET_TIMEOUT, str2);
    }

    public static void putSync(String str, JSONObject jSONObject, ResponseHandler responseHandler) {
        makeRequest(str, "PUT", jSONObject, responseHandler, TIMEOUT, null);
    }

    public static void postSync(String str, JSONObject jSONObject, ResponseHandler responseHandler) {
        makeRequest(str, NativeEventsConstants.HTTP_METHOD_POST, jSONObject, responseHandler, TIMEOUT, null);
    }

    /* access modifiers changed from: private */
    public static void makeRequest(final String str, final String str2, final JSONObject jSONObject, final ResponseHandler responseHandler, final int i, final String str3) {
        if (OSUtils.isRunningOnMainThread()) {
            throw new OneSignalNetworkCallException("Method: " + str2 + " was called from the Main Thread!");
        } else if (str2 == null || !OneSignal.shouldLogUserPrivacyConsentErrorMessageForMethodName(null)) {
            final Thread[] threadArr = new Thread[1];
            Thread thread = new Thread(new Runnable() {
                /* class com.onesignal.OneSignalRestClient.AnonymousClass4 */

                public void run() {
                    threadArr[0] = OneSignalRestClient.startHTTPConnection(str, str2, jSONObject, responseHandler, i, str3);
                }
            }, "OS_HTTPConnection");
            thread.start();
            try {
                thread.join((long) getThreadTimeout(i));
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.interrupt();
                }
                if (threadArr[0] != null) {
                    threadArr[0].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0250, code lost:
        if (r8 != null) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0252, code lost:
        r8.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02a8, code lost:
        if (r8 == null) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02ab, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0266 A[Catch:{ all -> 0x02ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Thread startHTTPConnection(java.lang.String r16, java.lang.String r17, org.json.JSONObject r18, com.onesignal.OneSignalRestClient.ResponseHandler r19, int r20, java.lang.String r21) {
        /*
        // Method dump skipped, instructions count: 693
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalRestClient.startHTTPConnection(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.OneSignalRestClient$ResponseHandler, int, java.lang.String):java.lang.Thread");
    }

    private static Thread callResponseHandlerOnSuccess(final ResponseHandler responseHandler, final String str) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            /* class com.onesignal.OneSignalRestClient.AnonymousClass5 */

            public void run() {
                ResponseHandler.this.onSuccess(str);
            }
        }, "OS_REST_SUCCESS_CALLBACK");
        thread.start();
        return thread;
    }

    private static Thread callResponseHandlerOnFailure(final ResponseHandler responseHandler, final int i, final String str, final Throwable th) {
        if (responseHandler == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            /* class com.onesignal.OneSignalRestClient.AnonymousClass6 */

            public void run() {
                ResponseHandler.this.onFailure(i, str, th);
            }
        }, "OS_REST_FAILURE_CALLBACK");
        thread.start();
        return thread;
    }

    private static HttpURLConnection newHttpURLConnection(String str) throws IOException {
        return (HttpURLConnection) new URL(BASE_URL + str).openConnection();
    }

    /* access modifiers changed from: private */
    public static class OneSignalNetworkCallException extends RuntimeException {
        public OneSignalNetworkCallException(String str) {
            super(str);
        }
    }
}
