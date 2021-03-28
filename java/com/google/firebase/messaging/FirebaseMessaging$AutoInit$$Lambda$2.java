package com.google.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessaging;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final /* synthetic */ class FirebaseMessaging$AutoInit$$Lambda$2 implements Runnable {
    private final FirebaseMessaging.AutoInit arg$1;

    FirebaseMessaging$AutoInit$$Lambda$2(FirebaseMessaging.AutoInit autoInit) {
        this.arg$1 = autoInit;
    }

    public final void run() {
        this.arg$1.lambda$initialize$0$FirebaseMessaging$AutoInit();
    }
}
