package com.ironsource.lifecycle;

public interface IronsourceLifecycleListener {
    void appPaused();

    void appResumed();

    void appStarted();

    void appStopped();
}
