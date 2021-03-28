package com.google.android.gms.measurement.internal;

import com.facebook.AccessToken;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzgx {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AccessToken.USER_ID_KEY, "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", TapjoyConstants.TJC_SESSION_ID};
    public static final String[] zzb = {Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    public static String zza(String str) {
        return zzig.zza(str, zza, zzb);
    }
}
