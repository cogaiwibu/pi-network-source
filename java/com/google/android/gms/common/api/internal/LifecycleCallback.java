package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class LifecycleCallback {
    protected final LifecycleFragment mLifecycleFragment;

    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    protected static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.isSupport()) {
            return zzd.zza(lifecycleActivity.asFragmentActivity());
        }
        if (lifecycleActivity.zzh()) {
            return zza.zza(lifecycleActivity.asActivity());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static LifecycleFragment getFragment(Activity activity) {
        return getFragment(new LifecycleActivity(activity));
    }

    public static LifecycleFragment getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    public Activity getActivity() {
        return this.mLifecycleFragment.getLifecycleActivity();
    }
}
