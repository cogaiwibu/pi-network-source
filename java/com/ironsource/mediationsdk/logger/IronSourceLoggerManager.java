package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;

public class IronSourceLoggerManager extends IronSourceLogger implements LogListener {
    private static IronSourceLoggerManager mInstance;
    private ArrayList<IronSourceLogger> mLoggers = new ArrayList<>();

    private IronSourceLoggerManager(String str) {
        super(str);
        initSubLoggers();
    }

    private IronSourceLoggerManager(String str, int i) {
        super(str, i);
        initSubLoggers();
    }

    private void initSubLoggers() {
        this.mLoggers.add(new ConsoleLogger(0));
    }

    public static synchronized IronSourceLoggerManager getLogger() {
        IronSourceLoggerManager ironSourceLoggerManager;
        synchronized (IronSourceLoggerManager.class) {
            if (mInstance == null) {
                mInstance = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
            }
            ironSourceLoggerManager = mInstance;
        }
        return ironSourceLoggerManager;
    }

    public static synchronized IronSourceLoggerManager getLogger(int i) {
        IronSourceLoggerManager ironSourceLoggerManager;
        synchronized (IronSourceLoggerManager.class) {
            if (mInstance == null) {
                mInstance = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
            } else {
                mInstance.mDebugLevel = i;
            }
            ironSourceLoggerManager = mInstance;
        }
        return ironSourceLoggerManager;
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.mLoggers.add(ironSourceLogger);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (i >= this.mDebugLevel) {
            Iterator<IronSourceLogger> it = this.mLoggers.iterator();
            while (it.hasNext()) {
                IronSourceLogger next = it.next();
                if (next.getDebugLevel() <= i) {
                    next.log(ironSourceTag, str, i);
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.logger.LogListener
    public synchronized void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        log(ironSourceTag, str, i);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.mLoggers.iterator();
            while (it.hasNext()) {
                it.next().log(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.mLoggers.iterator();
            while (it2.hasNext()) {
                it2.next().logException(ironSourceTag, str, th);
            }
        }
    }

    private IronSourceLogger findLoggerByName(String str) {
        Iterator<IronSourceLogger> it = this.mLoggers.iterator();
        while (it.hasNext()) {
            IronSourceLogger next = it.next();
            if (next.getLoggerName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void setLoggerDebugLevel(String str, int i) {
        if (str != null) {
            IronSourceLogger findLoggerByName = findLoggerByName(str);
            if (findLoggerByName == null) {
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                log(ironSourceTag, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
            } else if (i < 0 || i > 3) {
                this.mLoggers.remove(findLoggerByName);
            } else {
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                log(ironSourceTag2, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
                findLoggerByName.setDebugLevel(i);
            }
        }
    }
}
