package com.ironsource.environment;

import android.os.Looper;
import com.ironsource.environment.ANRError$$;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ANRError extends Error {
    private static final long serialVersionUID = 1;

    private ANRError(ANRError$$._Thread _thread) {
        super("Application Not Responding", _thread);
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    static ANRError New(String str, boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() {
            /* class com.ironsource.environment.ANRError.AnonymousClass1 */

            public int compare(Thread thread, Thread thread2) {
                if (thread == thread2) {
                    return 0;
                }
                Thread thread3 = thread;
                if (thread == thread3) {
                    return 1;
                }
                if (thread2 == thread3) {
                    return -1;
                }
                return thread2.getName().compareTo(thread.getName());
            }
        });
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        ANRError$$._Thread _thread = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue());
            aNRError$$.getClass();
            _thread = new ANRError$$._Thread(_thread);
        }
        return new ANRError(_thread);
    }

    static ANRError NewMainOnly() {
        Thread thread = Looper.getMainLooper().getThread();
        ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(thread), thread.getStackTrace());
        aNRError$$.getClass();
        return new ANRError(new ANRError$$._Thread(null));
    }

    private static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }
}
