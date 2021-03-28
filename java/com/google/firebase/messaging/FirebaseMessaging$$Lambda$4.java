package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final /* synthetic */ class FirebaseMessaging$$Lambda$4 implements SuccessContinuation {
    private final String arg$1;

    FirebaseMessaging$$Lambda$4(String str) {
        this.arg$1 = str;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        return FirebaseMessaging.lambda$subscribeToTopic$4$FirebaseMessaging(this.arg$1, (TopicsSubscriber) obj);
    }
}
