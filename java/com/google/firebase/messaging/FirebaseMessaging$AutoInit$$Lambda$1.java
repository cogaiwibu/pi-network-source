package com.google.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final /* synthetic */ class FirebaseMessaging$AutoInit$$Lambda$1 implements Runnable {
    private final FirebaseMessaging.AutoInit arg$1;

    FirebaseMessaging$AutoInit$$Lambda$1(FirebaseMessaging.AutoInit autoInit) {
        this.arg$1 = autoInit;
    }

    public final void run() {
        this.arg$1.lambda$setEnabled$2$FirebaseMessaging$AutoInit();
    }
}
