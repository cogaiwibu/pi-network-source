package com.facebook.systrace;

public interface TraceListener {
    void onTraceStarted();

    void onTraceStopped();
}
