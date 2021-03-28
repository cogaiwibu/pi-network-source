package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class IronsourceLifecycleFragment extends Fragment {
    private static final String REPORT_FRAGMENT_TAG = "com.ironsource.lifecycle.IronsourceLifecycleFragment";
    private ActivityInitializationListener mProcessListener;

    /* access modifiers changed from: package-private */
    public interface ActivityInitializationListener {
        void onCreate(Activity activity);

        void onResume(Activity activity);

        void onStart(Activity activity);
    }

    static IronsourceLifecycleFragment get(Activity activity) {
        return (IronsourceLifecycleFragment) activity.getFragmentManager().findFragmentByTag(REPORT_FRAGMENT_TAG);
    }

    static void injectIfNeededIn(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager != null && fragmentManager.findFragmentByTag(REPORT_FRAGMENT_TAG) == null) {
            fragmentManager.beginTransaction().add(new IronsourceLifecycleFragment(), REPORT_FRAGMENT_TAG).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: package-private */
    public void setProcessListener(ActivityInitializationListener activityInitializationListener) {
        this.mProcessListener = activityInitializationListener;
    }

    private void dispatchCreate(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate(getActivity());
        }
    }

    private void dispatchStart(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart(getActivity());
        }
    }

    private void dispatchResume(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume(getActivity());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatchCreate(this.mProcessListener);
    }

    public void onStart() {
        super.onStart();
        dispatchStart(this.mProcessListener);
    }

    public void onResume() {
        super.onResume();
        dispatchResume(this.mProcessListener);
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mProcessListener = null;
    }
}
