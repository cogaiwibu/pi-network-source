package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zab {
    public static final Api<SignInOptions> API = new Api<>("SignIn.API", zapv, CLIENT_KEY);
    private static final Api.ClientKey<SignInClientImpl> CLIENT_KEY = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zapv = new zaa();
    private static final Scope zar = new Scope(Scopes.PROFILE);
    private static final Scope zas = new Scope("email");
    private static final Api.ClientKey<SignInClientImpl> zasj = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<SignInClientImpl, Object> zask = new zad();
    private static final Api<Object> zasl = new Api<>("SignIn.INTERNAL_API", zask, zasj);
}
