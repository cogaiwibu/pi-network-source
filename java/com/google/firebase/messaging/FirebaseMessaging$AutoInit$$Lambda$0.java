package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final /* synthetic */ class FirebaseMessaging$AutoInit$$Lambda$0 implements EventHandler {
    private final FirebaseMessaging.AutoInit arg$1;

    FirebaseMessaging$AutoInit$$Lambda$0(FirebaseMessaging.AutoInit autoInit) {
        this.arg$1 = autoInit;
    }

    @Override // com.google.firebase.events.EventHandler
    public final void handle(Event event) {
        this.arg$1.lambda$initialize$1$FirebaseMessaging$AutoInit(event);
    }
}
