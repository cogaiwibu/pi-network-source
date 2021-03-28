package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class TransportImpl$$Lambda$1 implements TransportScheduleCallback {
    private static final TransportImpl$$Lambda$1 instance = new TransportImpl$$Lambda$1();

    private TransportImpl$$Lambda$1() {
    }

    public static TransportScheduleCallback lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.datatransport.TransportScheduleCallback
    public void onSchedule(Exception exc) {
        TransportImpl.lambda$send$0(exc);
    }
}
