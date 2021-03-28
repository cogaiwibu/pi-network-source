package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
final /* synthetic */ class FirebaseInstanceId$$Lambda$2 implements OnCompleteListener {
    private final CountDownLatch arg$1;

    FirebaseInstanceId$$Lambda$2(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        FirebaseInstanceId.lambda$awaitTaskAllowOnMainThread$3$FirebaseInstanceId(this.arg$1, task);
    }
}
