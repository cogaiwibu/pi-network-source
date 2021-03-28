package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;

public enum IronLog {
    API(IronSourceLogger.IronSourceTag.API),
    CALLBACK(IronSourceLogger.IronSourceTag.CALLBACK),
    ADAPTER_API(IronSourceLogger.IronSourceTag.ADAPTER_API),
    ADAPTER_CALLBACK(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK),
    NETWORK(IronSourceLogger.IronSourceTag.NETWORK),
    INTERNAL(IronSourceLogger.IronSourceTag.INTERNAL),
    NATIVE(IronSourceLogger.IronSourceTag.NATIVE),
    EVENT(IronSourceLogger.IronSourceTag.EVENT);
    
    IronSourceLogger.IronSourceTag mTag;

    private IronLog(IronSourceLogger.IronSourceTag ironSourceTag) {
        this.mTag = ironSourceTag;
    }

    public void verbose(String str) {
        IronSourceLoggerManager.getLogger().log(this.mTag, createLogMessage(str), 0);
    }

    public void info(String str) {
        IronSourceLoggerManager.getLogger().log(this.mTag, createLogMessage(str), 1);
    }

    public void warning(String str) {
        IronSourceLoggerManager.getLogger().log(this.mTag, createLogMessage(str), 2);
    }

    public void error(String str) {
        IronSourceLoggerManager.getLogger().log(this.mTag, createLogMessage(str), 3);
    }

    private String createLogMessage(String str) {
        if (str.isEmpty()) {
            return getLogPrefix();
        }
        return String.format("%s - %s", getLogPrefix(), str);
    }

    private String getLogPrefix() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return String.format("%s %s", getClassName(stackTrace, 5), getMethodName(stackTrace, 5));
    }

    private String getClassName(StackTraceElement[] stackTraceElementArr, int i) {
        String[] split = stackTraceElementArr[i].getClassName().split("\\.");
        String str = split[split.length - 1];
        return str.contains("$") ? str.split("\\$")[0] : str;
    }

    private String getMethodName(StackTraceElement[] stackTraceElementArr, int i) {
        String[] split = stackTraceElementArr[i].getClassName().split("\\.");
        String str = split[split.length - 1];
        if (str.contains("$")) {
            String[] split2 = str.split("\\$");
            return split2[1] + "." + stackTraceElementArr[i].getMethodName();
        } else if (!stackTraceElementArr[i].getMethodName().contains("$")) {
            return stackTraceElementArr[i].getMethodName();
        } else {
            int i2 = i + 1;
            String[] split3 = stackTraceElementArr[i2].getClassName().split("\\$");
            if (split3.length <= 1) {
                return stackTraceElementArr[i2].getMethodName();
            }
            return split3[1] + "." + stackTraceElementArr[i2].getMethodName();
        }
    }
}
