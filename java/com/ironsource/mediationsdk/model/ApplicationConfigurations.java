package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.TokenSettings;

public class ApplicationConfigurations {
    private ApplicationCrashReporterSettings mCrashReporter;
    private boolean mIsIntegration;
    private ApplicationLogger mLogger;
    private ServerSegmetData mSegmetData;
    private TokenSettings mTokenSettings;

    public ApplicationConfigurations() {
        this.mLogger = new ApplicationLogger();
    }

    public ApplicationConfigurations(ApplicationLogger applicationLogger, ServerSegmetData serverSegmetData, TokenSettings tokenSettings, boolean z, ApplicationCrashReporterSettings applicationCrashReporterSettings) {
        this.mLogger = applicationLogger;
        this.mSegmetData = serverSegmetData;
        this.mTokenSettings = tokenSettings;
        this.mIsIntegration = z;
        this.mCrashReporter = applicationCrashReporterSettings;
    }

    public ApplicationLogger getLoggerConfigurations() {
        return this.mLogger;
    }

    public ServerSegmetData getSegmetData() {
        return this.mSegmetData;
    }

    public TokenSettings getTokenSettings() {
        return this.mTokenSettings;
    }

    public boolean getIntegration() {
        return this.mIsIntegration;
    }

    public ApplicationCrashReporterSettings getCrashReporterSettings() {
        return this.mCrashReporter;
    }
}
