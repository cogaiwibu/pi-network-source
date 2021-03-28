package com.google.firebase.messaging;

import android.content.Context;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.iid.Metadata;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class TopicsSubscriber$$Lambda$0 implements Callable {
    private final Context arg$1;
    private final ScheduledExecutorService arg$2;
    private final FirebaseInstanceId arg$3;
    private final Metadata arg$4;
    private final GmsRpc arg$5;

    TopicsSubscriber$$Lambda$0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, Metadata metadata, GmsRpc gmsRpc) {
        this.arg$1 = context;
        this.arg$2 = scheduledExecutorService;
        this.arg$3 = firebaseInstanceId;
        this.arg$4 = metadata;
        this.arg$5 = gmsRpc;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0$TopicsSubscriber(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
    }
}
