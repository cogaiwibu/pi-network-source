package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final /* synthetic */ class zaci implements RemoteCall {
    private final BiConsumer zakj;

    zaci(BiConsumer biConsumer) {
        this.zakj = biConsumer;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zakj.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
