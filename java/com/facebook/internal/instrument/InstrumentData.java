package com.facebook.internal.instrument;

import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class InstrumentData {
    private static final String PARAM_APP_VERSION = "app_version";
    private static final String PARAM_CALLSTACK = "callstack";
    private static final String PARAM_DEVICE_MODEL = "device_model";
    private static final String PARAM_DEVICE_OS = "device_os_version";
    private static final String PARAM_REASON = "reason";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String PARAM_TYPE = "type";
    private String appVersion;
    private String cause;
    private String filename;
    private String stackTrace;
    private Long timestamp;
    private String type;

    /* access modifiers changed from: package-private */
    /* renamed from: com.facebook.internal.instrument.InstrumentData$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$internal$instrument$InstrumentData$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.internal.instrument.InstrumentData$Type[] r0 = com.facebook.internal.instrument.InstrumentData.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.internal.instrument.InstrumentData.AnonymousClass1.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type = r0
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.CrashReport     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.facebook.internal.instrument.InstrumentData.AnonymousClass1.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.CrashShield     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.facebook.internal.instrument.InstrumentData.AnonymousClass1.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.internal.instrument.InstrumentData$Type r1 = com.facebook.internal.instrument.InstrumentData.Type.ThreadCheck     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.instrument.InstrumentData.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        CrashReport,
        CrashShield,
        ThreadCheck;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$facebook$internal$instrument$InstrumentData$Type[ordinal()];
            if (i == 1) {
                return "CrashReport";
            }
            if (i != 2) {
                return i != 3 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ThreadCheck";
            }
            return "CrashShield";
        }
    }

    public InstrumentData(Throwable th, Type type2) {
        this.appVersion = Utility.getAppVersion();
        this.cause = InstrumentUtility.getCause(th);
        this.stackTrace = InstrumentUtility.getStackTrace(th);
        this.timestamp = Long.valueOf(System.currentTimeMillis() / 1000);
        this.type = type2.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(InstrumentUtility.CRASH_REPORT_PREFIX);
        stringBuffer.append(this.timestamp.toString());
        stringBuffer.append(".json");
        this.filename = stringBuffer.toString();
    }

    public InstrumentData(File file) {
        String name = file.getName();
        this.filename = name;
        JSONObject readFile = InstrumentUtility.readFile(name, true);
        if (readFile != null) {
            this.appVersion = readFile.optString("app_version", null);
            this.cause = readFile.optString("reason", null);
            this.stackTrace = readFile.optString(PARAM_CALLSTACK, null);
            this.timestamp = Long.valueOf(readFile.optLong("timestamp", 0));
            this.type = readFile.optString("type", null);
        }
    }

    public int compareTo(InstrumentData instrumentData) {
        Long l = this.timestamp;
        if (l == null) {
            return -1;
        }
        Long l2 = instrumentData.timestamp;
        if (l2 == null) {
            return 1;
        }
        return l2.compareTo(l);
    }

    public boolean isValid() {
        return (this.stackTrace == null || this.timestamp == null) ? false : true;
    }

    public void save() {
        if (isValid()) {
            InstrumentUtility.writeFile(this.filename, toString());
        }
    }

    public void clear() {
        InstrumentUtility.deleteFile(this.filename);
    }

    public String toString() {
        JSONObject parameters = getParameters();
        if (parameters == null) {
            return null;
        }
        return parameters.toString();
    }

    public JSONObject getParameters() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_DEVICE_OS, Build.VERSION.RELEASE);
            jSONObject.put(PARAM_DEVICE_MODEL, Build.MODEL);
            if (this.appVersion != null) {
                jSONObject.put("app_version", this.appVersion);
            }
            if (this.timestamp != null) {
                jSONObject.put("timestamp", this.timestamp);
            }
            if (this.cause != null) {
                jSONObject.put("reason", this.cause);
            }
            if (this.stackTrace != null) {
                jSONObject.put(PARAM_CALLSTACK, this.stackTrace);
            }
            if (this.type != null) {
                jSONObject.put("type", this.type);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
