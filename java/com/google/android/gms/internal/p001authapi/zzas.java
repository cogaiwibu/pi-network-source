package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.identity.zzl;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.auth-api.zzas  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
final class zzas extends Api.AbstractClientBuilder<zzaw, zzl> {
    zzas() {
    }

    /* Return type fixed from 'com.google.android.gms.common.api.Api$Client' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, java.lang.Object, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener] */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* synthetic */ zzaw buildClient(Context context, Looper looper, ClientSettings clientSettings, zzl zzl, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzaw(context, looper, zzl, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
