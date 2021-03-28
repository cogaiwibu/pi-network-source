package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* access modifiers changed from: package-private */
/* compiled from: DefaultHeartBeatInfo */
public final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$2 implements ComponentFactory {
    private static final DefaultHeartBeatInfo$$Lambda$2 instance = new DefaultHeartBeatInfo$$Lambda$2();

    private DefaultHeartBeatInfo$$Lambda$2() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.lambda$component$1(componentContainer);
    }
}
