package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zac;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O> {
    private final Api.AbstractClientBuilder<? extends zac, SignInOptions> zacf;
    private final ClientSettings zafa;
    private final Api.Client zafj;
    private final zap zafk;

    public zaw(Context context, Api<O> api, Looper looper, Api.Client client, zap zap, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zac, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.zafj = client;
        this.zafk = zap;
        this.zafa = clientSettings;
        this.zacf = abstractClientBuilder;
        this.zabo.zaa(this);
    }

    public final Api.Client zaad() {
        return this.zafj;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaa) {
        this.zafk.zaa(zaa);
        return this.zafj;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zace zaa(Context context, Handler handler) {
        return new zace(context, handler, this.zafa, this.zacf);
    }
}
