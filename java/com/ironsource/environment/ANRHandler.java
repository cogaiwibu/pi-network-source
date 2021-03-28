package com.ironsource.environment;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ANRHandler extends Thread {
    private static final ANRListener DEFAULT_ANR_LISTENER = new ANRListener() {
        /* class com.ironsource.environment.ANRHandler.AnonymousClass1 */

        @Override // com.ironsource.environment.ANRListener
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }

        @Override // com.ironsource.environment.ANRListener
        public void onANRHandlerDogGivingUp() {
            throw new RuntimeException("ANRHandler has given up");
        }
    };
    private static final InterruptionListener DEFAULT_INTERRUPTION_LISTENER = new InterruptionListener() {
        /* class com.ironsource.environment.ANRHandler.AnonymousClass2 */

        @Override // com.ironsource.environment.InterruptionListener
        public void onInterrupted(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    };
    private static final int DEFAULT_NUM_TRIES = 1;
    private ANRListener _anrListener = DEFAULT_ANR_LISTENER;
    private boolean _ignoreDebugger = false;
    private InterruptionListener _interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
    private boolean _logThreadsWithoutStackTrace = false;
    private String _namePrefix = "";
    private volatile int _tick = 0;
    private final Runnable _ticker = new Runnable() {
        /* class com.ironsource.environment.ANRHandler.AnonymousClass3 */

        public void run() {
            ANRHandler aNRHandler = ANRHandler.this;
            aNRHandler._tick = (aNRHandler._tick + 1) % Integer.MAX_VALUE;
        }
    };
    private final int _timeoutInterval;
    private final Handler _uiHandler = new Handler(Looper.getMainLooper());
    private int triedCount = 0;
    private int tries = 1;

    public void setTries(int i) {
        this.tries = i;
    }

    public int getTries() {
        return this.tries;
    }

    public int getTriedCount() {
        return this.triedCount;
    }

    public ANRHandler(int i) {
        this._timeoutInterval = i;
    }

    public ANRHandler setANRListener(ANRListener aNRListener) {
        if (aNRListener == null) {
            this._anrListener = DEFAULT_ANR_LISTENER;
        } else {
            this._anrListener = aNRListener;
        }
        return this;
    }

    public ANRHandler setInterruptionListener(InterruptionListener interruptionListener) {
        if (interruptionListener == null) {
            this._interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
        } else {
            this._interruptionListener = interruptionListener;
        }
        return this;
    }

    public ANRHandler setReportThreadNamePrefix(String str) {
        if (str == null) {
            str = "";
        }
        this._namePrefix = str;
        return this;
    }

    public ANRHandler setReportMainThreadOnly() {
        this._namePrefix = null;
        return this;
    }

    public ANRHandler setLogThreadsWithoutStackTrace(boolean z) {
        this._logThreadsWithoutStackTrace = z;
        return this;
    }

    public ANRHandler setIgnoreDebugger(boolean z) {
        this._ignoreDebugger = z;
        return this;
    }

    public void run() {
        ANRError aNRError;
        setName("|ANR-ANRHandler|");
        int i = -1;
        while (!isInterrupted() && this.triedCount < this.tries) {
            int i2 = this._tick;
            this._uiHandler.post(this._ticker);
            try {
                Thread.sleep((long) this._timeoutInterval);
                if (this._tick != i2) {
                    this.triedCount = 0;
                } else if (this._ignoreDebugger || !Debug.isDebuggerConnected()) {
                    String str = this._namePrefix;
                    if (str != null) {
                        aNRError = ANRError.New(str, this._logThreadsWithoutStackTrace);
                    } else {
                        aNRError = ANRError.NewMainOnly();
                    }
                    this.triedCount++;
                    this._anrListener.onAppNotResponding(aNRError);
                    new ExceptionLog(aNRError.toString(), String.valueOf(System.currentTimeMillis())).Save();
                } else {
                    if (this._tick != i) {
                        Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i = this._tick;
                }
            } catch (InterruptedException e) {
                this._interruptionListener.onInterrupted(e);
                return;
            }
        }
        if (this.triedCount >= this.tries) {
            this._anrListener.onANRHandlerDogGivingUp();
        }
    }
}
