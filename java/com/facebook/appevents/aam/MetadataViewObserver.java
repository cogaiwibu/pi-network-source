package com.facebook.appevents.aam;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.EditText;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
public final class MetadataViewObserver implements ViewTreeObserver.OnGlobalFocusChangeListener {
    private static final int MAX_TEXT_LENGTH = 100;
    private static final String TAG = MetadataViewObserver.class.getCanonicalName();
    private static final Map<Integer, MetadataViewObserver> observers = new HashMap();
    private WeakReference<Activity> activityWeakReference;
    private AtomicBoolean isTracking;
    private final Set<String> processedText = new HashSet();
    private final Handler uiThreadHandler;

    private MetadataViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    static void startTrackingActivity(Activity activity) {
        MetadataViewObserver metadataViewObserver;
        int hashCode = activity.hashCode();
        if (!observers.containsKey(Integer.valueOf(hashCode))) {
            metadataViewObserver = new MetadataViewObserver(activity);
            observers.put(Integer.valueOf(activity.hashCode()), metadataViewObserver);
        } else {
            metadataViewObserver = observers.get(Integer.valueOf(hashCode));
        }
        metadataViewObserver.startTracking();
    }

    static void stopTrackingActivity(Activity activity) {
        int hashCode = activity.hashCode();
        if (observers.containsKey(Integer.valueOf(hashCode))) {
            observers.remove(Integer.valueOf(hashCode));
            observers.get(Integer.valueOf(activity.hashCode())).stopTracking();
        }
    }

    private void startTracking() {
        View rootView;
        if (!this.isTracking.getAndSet(true) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalFocusChangeListener(this);
            }
        }
    }

    private void stopTracking() {
        View rootView;
        if (this.isTracking.getAndSet(false) && (rootView = getRootView()) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalFocusChangeListener(this);
            }
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (view != null) {
            process(view);
        }
        if (view2 != null) {
            process(view2);
        }
    }

    private void process(final View view) {
        runOnUIThread(new Runnable() {
            /* class com.facebook.appevents.aam.MetadataViewObserver.AnonymousClass1 */

            public void run() {
                View view = view;
                if (view instanceof EditText) {
                    MetadataViewObserver.this.processEditText(view);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void processEditText(View view) {
        String trim = ((EditText) view).getText().toString().trim();
        if (!(trim.isEmpty() || this.processedText.contains(trim) || trim.length() > 100)) {
            this.processedText.add(trim);
            HashMap hashMap = new HashMap();
            List<String> list = null;
            ArrayList arrayList = null;
            for (MetadataRule metadataRule : MetadataRule.getRules()) {
                if (MetadataMatcher.matchValue(trim, metadataRule.getValRule())) {
                    if (list == null) {
                        list = MetadataMatcher.getCurrentViewIndicators(view);
                    }
                    if (MetadataMatcher.matchIndicator(list, metadataRule.getKeyRules())) {
                        hashMap.put(metadataRule.getName(), trim);
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
                            if (parentOfView != null) {
                                for (View view2 : ViewHierarchy.getChildrenOfView(parentOfView)) {
                                    if (view != view2) {
                                        arrayList.addAll(MetadataMatcher.getTextIndicators(view2));
                                    }
                                }
                            }
                        }
                        if (MetadataMatcher.matchIndicator(arrayList, metadataRule.getKeyRules())) {
                            hashMap.put(metadataRule.getName(), trim);
                        }
                    }
                }
            }
            InternalAppEventsLogger.setInternalUserData(hashMap);
        }
    }

    private void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.uiThreadHandler.post(runnable);
        }
    }

    private View getRootView() {
        Window window;
        Activity activity = this.activityWeakReference.get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }
}
