package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

/* access modifiers changed from: package-private */
public class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.request = graphRequest;
        this.callbackHandler = handler;
    }

    /* access modifiers changed from: package-private */
    public long getProgress() {
        return this.progress;
    }

    /* access modifiers changed from: package-private */
    public long getMaxProgress() {
        return this.maxProgress;
    }

    /* access modifiers changed from: package-private */
    public void addProgress(long j) {
        long j2 = this.progress + j;
        this.progress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportProgress();
        }
    }

    /* access modifiers changed from: package-private */
    public void addToMax(long j) {
        this.maxProgress += j;
    }

    /* access modifiers changed from: package-private */
    public void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            final long j = this.maxProgress;
            if (j > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                final long j2 = this.progress;
                final GraphRequest.OnProgressCallback onProgressCallback = (GraphRequest.OnProgressCallback) callback;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    onProgressCallback.onProgress(j2, j);
                } else {
                    handler.post(new Runnable() {
                        /* class com.facebook.RequestProgress.AnonymousClass1 */

                        public void run() {
                            onProgressCallback.onProgress(j2, j);
                        }
                    });
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
