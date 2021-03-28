package com.ironsource.environment;

import android.os.Build;
import java.lang.Thread;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mBaseHandler;

    CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mBaseHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (Build.VERSION.SDK_INT >= 19) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append(th.toString());
            sb.append(System.lineSeparator());
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append(";" + System.lineSeparator());
                if (stackTraceElement.toString().contains(CrashReporter.getInstance().getKeyword())) {
                    z = true;
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                sb.append("--CAUSE");
                sb.append(System.lineSeparator());
                sb.append(cause.toString());
                sb.append(System.lineSeparator());
                StackTraceElement[] stackTrace2 = cause.getStackTrace();
                for (StackTraceElement stackTraceElement2 : stackTrace2) {
                    sb.append(stackTraceElement2.toString());
                    sb.append(";" + System.lineSeparator());
                    if (stackTraceElement2.toString().contains(CrashReporter.getInstance().getKeyword())) {
                        z = true;
                    }
                }
            }
            if (z) {
                new ExceptionLog(sb.toString(), "" + System.currentTimeMillis()).Save();
            }
            this.mBaseHandler.uncaughtException(thread, th);
        }
    }
}
