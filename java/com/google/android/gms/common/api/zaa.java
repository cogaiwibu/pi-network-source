package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaa implements PendingResult.StatusListener {
    private final /* synthetic */ Batch zabb;

    zaa(Batch batch) {
        this.zabb = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Status status2;
        synchronized (Batch.zaa(this.zabb)) {
            if (!this.zabb.isCanceled()) {
                if (status.isCanceled()) {
                    Batch.zaa(this.zabb, true);
                } else if (!status.isSuccess()) {
                    Batch.zab(this.zabb, true);
                }
                Batch.zab(this.zabb);
                if (Batch.zac(this.zabb) == 0) {
                    if (Batch.zad(this.zabb)) {
                        Batch.zae(this.zabb);
                    } else {
                        if (Batch.zaf(this.zabb)) {
                            status2 = new Status(13);
                        } else {
                            status2 = Status.RESULT_SUCCESS;
                        }
                        this.zabb.setResult(new BatchResult(status2, Batch.zag(this.zabb)));
                    }
                }
            }
        }
    }
}
