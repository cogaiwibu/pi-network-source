package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;
import com.bytedance.sdk.openadsdk.g.u;
import java.lang.reflect.Method;

/* compiled from: VisibilityChecker */
public class t {
    private static boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.hasWindowFocus()) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        long height = ((long) rect.height()) * ((long) rect.width());
        long height2 = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height2 <= 0 || height * 100 < ((long) i) * height2) {
            return false;
        }
        return true;
    }

    private static boolean a(Context context) throws Exception {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
        return ((Boolean) (method != null ? method.invoke(powerManager, new Object[0]) : false)).booleanValue();
    }

    private static boolean a(View view) {
        return view != null && view.isShown();
    }

    private static boolean b(View view, int i) {
        return view.getWidth() >= c(view, i) && view.getHeight() >= d(view, i);
    }

    private static int c(View view, int i) {
        if (i != 3) {
            return 50;
        }
        double b = (double) u.b(view.getContext().getApplicationContext());
        Double.isNaN(b);
        return (int) (b * 0.7d);
    }

    private static int d(View view, int i) {
        if (i == 3) {
            return u.c(view.getContext().getApplicationContext()) / 2;
        }
        return 50;
    }

    private static int b(View view, int i, int i2) throws Exception {
        if (!a(view.getContext())) {
            return 4;
        }
        if (!a(view)) {
            return 1;
        }
        if (!b(view, i2)) {
            return 6;
        }
        return !a(view, i) ? 3 : 0;
    }

    public static boolean a(View view, int i, int i2) {
        try {
            return b(view, i, i2) == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
