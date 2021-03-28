package com.ironsource.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.network.ConnectivityService;
import com.ironsource.sdk.constants.Events;
import java.io.DataOutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CrashReporter {
    private static final String CRASH_REPORTER_VERSION = "1.0.1";
    private String crashKeyword;
    private String crashReporterURL;
    private boolean isANR;
    private boolean isOptOutEnabled;
    private String mAdvertisingId;
    private String mAnrReport;
    private Context mContext;
    private JSONObject mCrashReport;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private String mSessionId;

    static List<ExceptionLog> getExceptions() {
        return null;
    }

    public String getCrashReporterVersion() {
        return CRASH_REPORTER_VERSION;
    }

    public static CrashReporter getInstance() {
        return CrashReporterHolder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static class CrashReporterHolder {
        static volatile CrashReporter INSTANCE = new CrashReporter();

        private CrashReporterHolder() {
        }
    }

    private CrashReporter() {
        this.mAnrReport = "";
        this.isANR = false;
        this.isOptOutEnabled = false;
        this.mCrashReport = new JSONObject();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.mDefaultHandler = defaultUncaughtExceptionHandler;
        this.crashKeyword = " ";
        this.crashReporterURL = "https://outcome-crash-report.supersonicads.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(defaultUncaughtExceptionHandler));
    }

    public void init(final Context context, HashSet<String> hashSet, String str, String str2, boolean z, final String str3, int i) {
        if (context != null) {
            Log.d("automation_log", "init ISCrashReporter");
            this.mContext = context;
            if (!TextUtils.isEmpty(str2)) {
                this.crashKeyword = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.crashReporterURL = str;
            }
            this.mSessionId = str3;
            if (z) {
                new ANRHandler(i).setANRListener(new ANRListener() {
                    /* class com.ironsource.environment.CrashReporter.AnonymousClass1 */

                    @Override // com.ironsource.environment.ANRListener
                    public void onANRHandlerDogGivingUp() {
                    }

                    @Override // com.ironsource.environment.ANRListener
                    public void onAppNotResponding(ANRError aNRError) {
                        CrashReporter.this.mAnrReport = aNRError.toString();
                        CrashReporter.this.isANR = true;
                    }
                }).start();
            }
            sendExceptions(context, hashSet);
            new Thread(new Runnable() {
                /* class com.ironsource.environment.CrashReporter.AnonymousClass2 */

                public void run() {
                    try {
                        String[] advertisingIdInfo = DeviceStatus.getAdvertisingIdInfo(context);
                        if (advertisingIdInfo.length == 2) {
                            if (!TextUtils.isEmpty(advertisingIdInfo[0])) {
                                CrashReporter.this.mAdvertisingId = advertisingIdInfo[0];
                            }
                            CrashReporter.this.isOptOutEnabled = Boolean.parseBoolean(advertisingIdInfo[1]);
                            SharedPreferences.Editor edit = context.getSharedPreferences("CRep", 0).edit();
                            edit.putString("String1", CrashReporter.this.mAdvertisingId);
                            edit.putString(TokenConstants.MINIMIZED_SESSION_ID, str3);
                            edit.apply();
                        }
                    } catch (Exception unused) {
                    }
                }
            }).start();
        }
    }

    private void sendExceptions(Context context, HashSet<String> hashSet) {
        String connectionType = getConnectionType(getContext());
        if (!connectionType.equals("none")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
            String string = sharedPreferences.getString("String1", this.mAdvertisingId);
            String string2 = sharedPreferences.getString(TokenConstants.MINIMIZED_SESSION_ID, this.mSessionId);
            new StringBuilder();
            for (ExceptionLog exceptionLog : DbHandler.getAllReports()) {
                String date = exceptionLog.getDate();
                String stacktrace = exceptionLog.getStacktrace();
                String str = this.isANR ? "ANR" : "Crash";
                String packageName = context.getPackageName();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crashDate", date);
                    jSONObject.put("stacktraceCrash", stacktrace);
                    jSONObject.put("crashType", str);
                    jSONObject.put("CrashReporterVersion", CRASH_REPORTER_VERSION);
                    jSONObject.put("SDKVersion", "7.1.1");
                    jSONObject.put("deviceLanguage", DeviceStatus.getDeviceLanguage(context));
                    jSONObject.put("appVersion", ApplicationContext.getPublisherApplicationVersion(context, packageName));
                    jSONObject.put("deviceOSVersion", DeviceStatus.getAndroidOsVersion());
                    jSONObject.put("network", connectionType);
                    jSONObject.put("deviceApiLevel", DeviceStatus.getAndroidAPIVersion());
                    jSONObject.put("deviceModel", DeviceStatus.getDeviceModel());
                    jSONObject.put(TokenConstants.DEVICE_OS, DeviceStatus.getDeviceOs());
                    jSONObject.put(TokenConstants.ADVERTISING_ID, string);
                    jSONObject.put("isLimitAdTrackingEnabled", this.isOptOutEnabled);
                    jSONObject.put("deviceOEM", DeviceStatus.getDeviceOEM());
                    jSONObject.put("systemProperties", System.getProperties());
                    jSONObject.put("bundleId", packageName);
                    jSONObject.put(TokenConstants.MINIMIZED_SESSION_ID, string2);
                    JSONObject jSONObject2 = new JSONObject();
                    if (hashSet != null && !hashSet.isEmpty()) {
                        Iterator<String> it = hashSet.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            try {
                                if (jSONObject.has(next)) {
                                    jSONObject2.put(next, jSONObject.opt(next));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        jSONObject = jSONObject2;
                    }
                    this.mCrashReport = jSONObject;
                } catch (Exception unused) {
                }
                if (this.mCrashReport.length() == 0) {
                    Log.d("ISCrashReport", " Is Empty");
                } else {
                    new Thread(new Runnable() {
                        /* class com.ironsource.environment.CrashReporter.AnonymousClass3 */

                        public void run() {
                            try {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(CrashReporter.getInstance().crashReporterURL).openConnection();
                                httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_POST);
                                httpURLConnection.setRequestProperty(Events.CONTENT_TYPE, "application/json;charset=UTF-8");
                                httpURLConnection.setRequestProperty("Accept", Events.APP_JSON);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                Log.i("JSON", CrashReporter.this.mCrashReport.toString());
                                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                dataOutputStream.writeBytes(CrashReporter.this.mCrashReport.toString());
                                dataOutputStream.flush();
                                dataOutputStream.close();
                                Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
                                Log.i("MSG", httpURLConnection.getResponseMessage());
                                httpURLConnection.disconnect();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    DbHandler.deleteAllReports();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public String getKeyword() {
        return this.crashKeyword;
    }

    private String getConnectionType(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1)) {
                return "wifi";
            }
            if (networkCapabilities.hasTransport(0)) {
                return ConnectivityService.NETWORK_TYPE_CELLULAR;
            }
            return "none";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return "wifi";
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return ConnectivityService.NETWORK_TYPE_CELLULAR;
            }
        }
        return "none";
    }
}
