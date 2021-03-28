package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public final /* synthetic */ class GmsRpc$$Lambda$0 implements Continuation {
    private final GmsRpc arg$1;

    GmsRpc$$Lambda$0(GmsRpc gmsRpc) {
        this.arg$1 = gmsRpc;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return this.arg$1.lambda$extractResponseWhenComplete$0$GmsRpc(task);
    }
}
