package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

public interface HandlerExecutorService extends ScheduledExecutorService {
    boolean isHandlerThread();

    void quit();
}
