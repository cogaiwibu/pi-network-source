package com.google.firebase.messaging;

import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final /* synthetic */ class FirebaseMessaging$$Lambda$0 implements Runnable {
    private final FirebaseMessaging arg$1;
    private final FirebaseInstanceId arg$2;

    FirebaseMessaging$$Lambda$0(FirebaseMessaging firebaseMessaging, FirebaseInstanceId firebaseInstanceId) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = firebaseInstanceId;
    }

    public final void run() {
        this.arg$1.lambda$new$0$FirebaseMessaging(this.arg$2);
    }
}
