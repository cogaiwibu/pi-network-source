package com.ironsource.mediationsdk.model;

public class ApplicationLogger {
    private int mConsole;
    private int mPublisher;
    private int mServer;

    public ApplicationLogger() {
    }

    public ApplicationLogger(int i, int i2, int i3) {
        this.mServer = i;
        this.mPublisher = i2;
        this.mConsole = i3;
    }

    public int getServerLoggerLevel() {
        return this.mServer;
    }

    public int getPublisherLoggerLevel() {
        return this.mPublisher;
    }

    public int getConsoleLoggerLevel() {
        return this.mConsole;
    }
}
