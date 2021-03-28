package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zak implements PendingResult.StatusListener {
    private final /* synthetic */ PendingResult zaph;
    private final /* synthetic */ TaskCompletionSource zapi;
    private final /* synthetic */ PendingResultUtil.ResultConverter zapj;
    private final /* synthetic */ PendingResultUtil.zaa zapk;

    zak(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaa) {
        this.zaph = pendingResult;
        this.zapi = taskCompletionSource;
        this.zapj = resultConverter;
        this.zapk = zaa;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            this.zapi.setResult(this.zapj.convert(this.zaph.await(0, TimeUnit.MILLISECONDS)));
            return;
        }
        this.zapi.setException(this.zapk.zaf(status));
    }
}
