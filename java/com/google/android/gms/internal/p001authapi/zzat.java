package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzat  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
final /* synthetic */ class zzat implements RemoteCall {
    private final zzao zzbr;
    private final GetSignInIntentRequest zzbt;

    zzat(zzao zzao, GetSignInIntentRequest getSignInIntentRequest) {
        this.zzbr = zzao;
        this.zzbt = getSignInIntentRequest;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzao zzao = this.zzbr;
        GetSignInIntentRequest getSignInIntentRequest = this.zzbt;
        ((zzai) ((zzaw) obj).getService()).zzc(new zzax(zzao, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.checkNotNull(getSignInIntentRequest));
    }
}
