package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgz;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
public class AppMeasurementSdk {
    private final zzag zza;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public static final class ConditionalUserProperty {
        public static final String ACTIVE = "active";
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        public static final String NAME = "name";
        public static final String ORIGIN = "origin";
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        public static final String TIME_TO_LIVE = "time_to_live";
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public interface EventInterceptor extends zzgw {
        @Override // com.google.android.gms.measurement.internal.zzgw
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
    public interface OnEventListener extends zzgz {
        @Override // com.google.android.gms.measurement.internal.zzgz
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzag.zza(context).zza();
    }

    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzag.zza(context, str, str2, str3, bundle).zza();
    }

    public AppMeasurementSdk(zzag zzag) {
        this.zza = zzag;
    }

    public void setMeasurementEnabled(boolean z) {
        this.zza.zza(Boolean.valueOf(z));
    }

    public void setMeasurementEnabled(Boolean bool) {
        this.zza.zza(bool);
    }

    public void setConsent(Bundle bundle) {
        this.zza.zzb(bundle);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zza(str, str2, obj, true);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zza(bundle);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzb(str, str2);
    }

    public String getCurrentScreenName() {
        return this.zza.zzf();
    }

    public String getCurrentScreenClass() {
        return this.zza.zzg();
    }

    public String getAppInstanceId() {
        return this.zza.zzd();
    }

    public String getGmpAppId() {
        return this.zza.zzc();
    }

    public long generateEventId() {
        return this.zza.zze();
    }

    public void beginAdUnitExposure(String str) {
        this.zza.zzb(str);
    }

    public void endAdUnitExposure(String str) {
        this.zza.zzc(str);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zza(eventInterceptor);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zza(onEventListener);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzb(onEventListener);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zza(bundle, true);
    }

    public void performAction(Bundle bundle) {
        this.zza.zza(bundle, false);
    }

    public int getMaxUserProperties(String str) {
        return this.zza.zzd(str);
    }

    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zza(activity, str, str2);
    }

    public String getAppIdOrigin() {
        return this.zza.zzi();
    }

    public final void zza(boolean z) {
        this.zza.zza(z);
    }
}
