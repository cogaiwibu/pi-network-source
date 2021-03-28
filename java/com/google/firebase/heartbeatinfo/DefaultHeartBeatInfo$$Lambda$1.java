package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* access modifiers changed from: package-private */
/* compiled from: DefaultHeartBeatInfo */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$1 implements Provider {
    private final Context arg$1;

    private DefaultHeartBeatInfo$$Lambda$1(Context context) {
        this.arg$1 = context;
    }

    public static Provider lambdaFactory$(Context context) {
        return new DefaultHeartBeatInfo$$Lambda$1(context);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return HeartBeatInfoStorage.getInstance(this.arg$1);
    }
}
