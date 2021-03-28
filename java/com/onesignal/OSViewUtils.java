package com.onesignal;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.onesignal.ActivityLifecycleHandler;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public class OSViewUtils {
    private static final int MARGIN_ERROR_PX_SIZE = dpToPx(24);

    OSViewUtils() {
    }

    static boolean isKeyboardUp(WeakReference<Activity> weakReference) {
        View view;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Rect rect = new Rect();
        if (weakReference.get() != null) {
            Window window = weakReference.get().getWindow();
            view = window.getDecorView();
            view.getWindowVisibleDisplayFrame(rect);
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            view = null;
        }
        if (view == null || displayMetrics.heightPixels - rect.bottom <= MARGIN_ERROR_PX_SIZE) {
            return false;
        }
        return true;
    }

    static void decorViewReady(Activity activity, final Runnable runnable) {
        final String str = "decorViewReady:" + runnable;
        activity.getWindow().getDecorView().post(new Runnable() {
            /* class com.onesignal.OSViewUtils.AnonymousClass1 */

            public void run() {
                ActivityLifecycleHandler.setActivityAvailableListener(str, new ActivityLifecycleHandler.ActivityAvailableListener() {
                    /* class com.onesignal.OSViewUtils.AnonymousClass1.AnonymousClass1 */

                    /* access modifiers changed from: package-private */
                    @Override // com.onesignal.ActivityLifecycleHandler.ActivityAvailableListener
                    public void available(Activity activity) {
                        ActivityLifecycleHandler.removeActivityAvailableListener(str);
                        if (OSViewUtils.isActivityFullyReady(activity)) {
                            runnable.run();
                        } else {
                            OSViewUtils.decorViewReady(activity, runnable);
                        }
                    }
                });
            }
        });
    }

    private static Rect getWindowVisibleDisplayFrame(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    static int getWindowWidth(Activity activity) {
        return getWindowVisibleDisplayFrame(activity).width();
    }

    static int getWindowHeight(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            return getWindowHeightAPI23Plus(activity);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return getWindowHeightLollipop(activity);
        }
        return getDisplaySizeY(activity);
    }

    private static int getWindowHeightAPI23Plus(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return decorView.getHeight();
        }
        return (decorView.getHeight() - rootWindowInsets.getStableInsetBottom()) - rootWindowInsets.getStableInsetTop();
    }

    private static int getWindowHeightLollipop(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 2) {
            return getWindowVisibleDisplayFrame(activity).height();
        }
        return getDisplaySizeY(activity);
    }

    private static int getDisplaySizeY(Activity activity) {
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point.y;
    }

    static int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    static boolean isActivityFullyReady(Activity activity) {
        boolean z = activity.getWindow().getDecorView().getApplicationWindowToken() != null;
        if (Build.VERSION.SDK_INT < 23) {
            return z;
        }
        boolean z2 = activity.getWindow().getDecorView().getRootWindowInsets() != null;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
