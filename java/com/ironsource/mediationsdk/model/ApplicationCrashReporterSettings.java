package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import java.util.HashSet;

public class ApplicationCrashReporterSettings {
    private int defaultAnrTimeout;
    private boolean isANRIncluded = false;
    private boolean isEnabled = false;
    private HashSet<String> keyParamsToIncludeInReporter = new HashSet<>();
    private String reporterKeyword;
    private String reporterURL;

    public HashSet<String> getKeyParamsToIncludeInReporter() {
        return this.keyParamsToIncludeInReporter;
    }

    public void setKeyParamsToIncludeInReporter(boolean z) {
        this.isEnabled = z;
    }

    public boolean isCrashReporterEnabled() {
        return this.isEnabled;
    }

    public void addKeyParamToInclude(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.keyParamsToIncludeInReporter.add(str);
        }
    }

    public String getReporterURL() {
        return this.reporterURL;
    }

    public void setReporterURL(String str) {
        this.reporterURL = str;
    }

    public String getReporterKeyword() {
        return this.reporterKeyword;
    }

    public void setReporterKeyword(String str) {
        this.reporterKeyword = str;
    }

    public boolean isANRIncluded() {
        return this.isANRIncluded;
    }

    public void shouldIncludeANR(boolean z) {
        this.isANRIncluded = z;
    }

    public int getDefaultAnrTimeout() {
        return this.defaultAnrTimeout;
    }

    public void setDefaultAnrTimeout(int i) {
        this.defaultAnrTimeout = i;
    }
}
