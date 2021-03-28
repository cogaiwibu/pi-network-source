package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

public final class AuthProxy {
    public static final Api<AuthProxyOptions> API;
    public static final ProxyApi ProxyApi = new zzar();
    private static final Api.ClientKey<zzak> zzah = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> zzai;

    static {
        zza zza = new zza();
        zzai = zza;
        API = new Api<>("Auth.PROXY_API", zza, zzah);
    }
}
