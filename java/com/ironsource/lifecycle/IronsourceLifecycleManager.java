package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ironsource.lifecycle.IronsourceLifecycleFragment;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class IronsourceLifecycleManager implements Application.ActivityLifecycleCallbacks {
    static final long TIMEOUT_MS = 700;
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);
    private static IronsourceLifecycleManager sInstance = new IronsourceLifecycleManager();
    private String TAG = "IronsourceLifecycleManager";
    private Activity mCurrentActivity;
    private Runnable mDelayedPauseRunnable = new Runnable() {
        /* class com.ironsource.lifecycle.IronsourceLifecycleManager.AnonymousClass1 */

        public void run() {
            IronsourceLifecycleManager.this.dispatchPauseIfNeeded();
            IronsourceLifecycleManager.this.dispatchStopIfNeeded();
        }
    };
    private Handler mHandler;
    private IronsourceLifecycleFragment.ActivityInitializationListener mInitializationListener = new IronsourceLifecycleFragment.ActivityInitializationListener() {
        /* class com.ironsource.lifecycle.IronsourceLifecycleManager.AnonymousClass2 */

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.ActivityInitializationListener
        public void onCreate(Activity activity) {
        }

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.ActivityInitializationListener
        public void onStart(Activity activity) {
            IronsourceLifecycleManager.this.activityStarted(activity);
        }

        @Override // com.ironsource.lifecycle.IronsourceLifecycleFragment.ActivityInitializationListener
        public void onResume(Activity activity) {
            IronsourceLifecycleManager.this.activityResumed(activity);
        }
    };
    private List<IronsourceLifecycleListener> mObservers = new CopyOnWriteArrayList();
    private boolean mPauseSent = true;
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private IronsourceLifecycleState mState = IronsourceLifecycleState.NONE;
    private boolean mStopSent = true;

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public static IronsourceLifecycleManager getInstance() {
        return sInstance;
    }

    public void addObserver(IronsourceLifecycleListener ironsourceLifecycleListener) {
        if (IronsourceLifecycleProvider.isCreated() && ironsourceLifecycleListener != null && !this.mObservers.contains(ironsourceLifecycleListener)) {
            this.mObservers.add(ironsourceLifecycleListener);
        }
    }

    public void removeObserver(IronsourceLifecycleListener ironsourceLifecycleListener) {
        if (this.mObservers.contains(ironsourceLifecycleListener)) {
            this.mObservers.remove(ironsourceLifecycleListener);
        }
    }

    public IronsourceLifecycleState getCurrentState() {
        return this.mState;
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public boolean isAppInBackground() {
        return this.mState == IronsourceLifecycleState.STOPPED;
    }

    /* access modifiers changed from: package-private */
    public void init(Context context) {
        if (sInitialized.compareAndSet(false, true)) {
            this.mHandler = new Handler(Looper.getMainLooper());
            Application application = (Application) context.getApplicationContext();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(this);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        IronsourceLifecycleFragment.injectIfNeededIn(activity);
        IronsourceLifecycleFragment ironsourceLifecycleFragment = IronsourceLifecycleFragment.get(activity);
        if (ironsourceLifecycleFragment != null) {
            ironsourceLifecycleFragment.setProcessListener(this.mInitializationListener);
        }
    }

    public void onActivityPaused(Activity activity) {
        activityPaused(activity);
    }

    public void onActivityStopped(Activity activity) {
        activityStopped(activity);
    }

    /* access modifiers changed from: package-private */
    public void activityStarted(Activity activity) {
        this.mCurrentActivity = activity;
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            for (IronsourceLifecycleListener ironsourceLifecycleListener : this.mObservers) {
                ironsourceLifecycleListener.appStarted();
            }
            this.mStopSent = false;
            this.mState = IronsourceLifecycleState.STARTED;
        }
    }

    /* access modifiers changed from: package-private */
    public void activityResumed(Activity activity) {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i != 1) {
            return;
        }
        if (this.mPauseSent) {
            for (IronsourceLifecycleListener ironsourceLifecycleListener : this.mObservers) {
                ironsourceLifecycleListener.appResumed();
            }
            this.mPauseSent = false;
            this.mState = IronsourceLifecycleState.RESUMED;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    /* access modifiers changed from: package-private */
    public void activityPaused(Activity activity) {
        int i = this.mResumedCounter - 1;
        this.mResumedCounter = i;
        if (i == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, TIMEOUT_MS);
        }
    }

    /* access modifiers changed from: package-private */
    public void activityStopped(Activity activity) {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            for (IronsourceLifecycleListener ironsourceLifecycleListener : this.mObservers) {
                ironsourceLifecycleListener.appPaused();
            }
            this.mState = IronsourceLifecycleState.PAUSED;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            for (IronsourceLifecycleListener ironsourceLifecycleListener : this.mObservers) {
                ironsourceLifecycleListener.appStopped();
            }
            this.mCurrentActivity = null;
            this.mStopSent = true;
            this.mState = IronsourceLifecycleState.STOPPED;
        }
    }
}
