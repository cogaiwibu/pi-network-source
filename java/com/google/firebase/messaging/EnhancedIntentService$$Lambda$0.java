package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final /* synthetic */ class EnhancedIntentService$$Lambda$0 implements Runnable {
    private final EnhancedIntentService arg$1;
    private final Intent arg$2;
    private final TaskCompletionSource arg$3;

    EnhancedIntentService$$Lambda$0(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.arg$1 = enhancedIntentService;
        this.arg$2 = intent;
        this.arg$3 = taskCompletionSource;
    }

    public final void run() {
        this.arg$1.lambda$processIntent$0$EnhancedIntentService(this.arg$2, this.arg$3);
    }
}
