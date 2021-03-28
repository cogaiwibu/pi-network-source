package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final /* synthetic */ class zabx implements RemoteCall {
    private final RegistrationMethods.Builder zaki;

    zabx(RegistrationMethods.Builder builder) {
        this.zaki = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zaki.zaa((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
