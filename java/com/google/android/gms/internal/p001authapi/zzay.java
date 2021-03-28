package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api.zzay  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
public final class zzay {
    public static final Feature zzdc = new Feature("auth_api_credentials_begin_sign_in", 4);
    public static final Feature zzdd = new Feature("auth_api_credentials_sign_out", 2);
    private static final Feature zzde = new Feature("auth_api_credentials_authorize", 1);
    private static final Feature zzdf = new Feature("auth_api_credentials_revoke_access", 1);
    public static final Feature zzdg = new Feature("auth_api_credentials_save_password", 3);
    public static final Feature zzdh = new Feature("auth_api_credentials_get_sign_in_intent", 3);
    private static final Feature zzdi;
    public static final Feature[] zzdj;

    static {
        Feature feature = new Feature("auth_api_credentials_save_account_linking_token", 2);
        zzdi = feature;
        zzdj = new Feature[]{zzdc, zzdd, zzde, zzdf, zzdg, zzdh, feature};
    }
}
