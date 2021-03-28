package com.facebook.systrace;

import android.os.Build;
import android.os.Trace;

public class Systrace {
    public static final long TRACE_TAG_REACT_APPS = 0;
    public static final long TRACE_TAG_REACT_FRESCO = 0;
    public static final long TRACE_TAG_REACT_JAVA_BRIDGE = 0;
    public static final long TRACE_TAG_REACT_JS_VM_CALLS = 0;
    public static final long TRACE_TAG_REACT_VIEW = 0;

    public static void beginAsyncSection(long j, String str, int i) {
    }

    public static void beginAsyncSection(long j, String str, int i, long j2) {
    }

    public static void endAsyncFlow(long j, String str, int i) {
    }

    public static void endAsyncSection(long j, String str, int i) {
    }

    public static void endAsyncSection(long j, String str, int i, long j2) {
    }

    public static boolean isTracing(long j) {
        return false;
    }

    public static void registerListener(TraceListener traceListener) {
    }

    public static void startAsyncFlow(long j, String str, int i) {
    }

    public static void stepAsyncFlow(long j, String str, int i) {
    }

    public static void traceCounter(long j, String str, int i) {
    }

    public static void traceInstant(long j, String str, EventScope eventScope) {
    }

    public static void unregisterListener(TraceListener traceListener) {
    }

    public enum EventScope {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');
        
        private final char mCode;

        private EventScope(char c) {
            this.mCode = c;
        }

        public char getCode() {
            return this.mCode;
        }
    }

    public static void beginSection(long j, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection(long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
