package com.ironsource.mediationsdk.events;

import android.os.Handler;
import android.os.HandlerThread;
import com.ironsource.mediationsdk.logger.ThreadExceptionHandler;

public class SuperLooper extends Thread {
    private static SuperLooper mInstance;
    private SupersonicSdkThread mSdkThread;

    private SuperLooper() {
        SupersonicSdkThread supersonicSdkThread = new SupersonicSdkThread(getClass().getSimpleName());
        this.mSdkThread = supersonicSdkThread;
        supersonicSdkThread.start();
        this.mSdkThread.prepareHandler();
    }

    public static synchronized SuperLooper getLooper() {
        SuperLooper superLooper;
        synchronized (SuperLooper.class) {
            if (mInstance == null) {
                mInstance = new SuperLooper();
            }
            superLooper = mInstance;
        }
        return superLooper;
    }

    public synchronized void post(Runnable runnable) {
        if (this.mSdkThread != null) {
            Handler callbackHandler = this.mSdkThread.getCallbackHandler();
            if (callbackHandler != null) {
                callbackHandler.post(runnable);
            }
        }
    }

    /* access modifiers changed from: private */
    public class SupersonicSdkThread extends HandlerThread {
        private Handler mHandler;

        SupersonicSdkThread(String str) {
            super(str);
            setUncaughtExceptionHandler(new ThreadExceptionHandler());
        }

        /* access modifiers changed from: package-private */
        public void prepareHandler() {
            this.mHandler = new Handler(getLooper());
        }

        /* access modifiers changed from: package-private */
        public Handler getCallbackHandler() {
            return this.mHandler;
        }
    }
}
