package com.bytedance.sdk.openadsdk.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.j;
import org.json.JSONObject;

/* compiled from: UIUtils */
public class u {
    private static float a = -1.0f;
    private static int b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;

    private static boolean a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    static {
        a(j.a());
    }

    private static boolean a() {
        return a < 0.0f || b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static void a(Context context) {
        if (context == null) {
            context = j.a();
        }
        if (context != null && a()) {
            String b2 = d.a(context).b("ui_display_metrics_info", (String) null);
            if (!TextUtils.isEmpty(b2)) {
                try {
                    JSONObject jSONObject = new JSONObject(b2);
                    a = Double.valueOf(jSONObject.optDouble("d", -1.0d)).floatValue();
                    b = jSONObject.optInt("d_dpi", -1);
                    c = Double.valueOf(jSONObject.optDouble("s_dpi", -1.0d)).floatValue();
                    d = jSONObject.optInt("w", -1);
                    e = jSONObject.optInt("h", -1);
                } catch (Throwable unused) {
                    c = -1.0f;
                    a = -1.0f;
                    e = -1;
                    d = -1;
                    b = -1;
                }
            }
            if (a()) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                a = displayMetrics.density;
                b = displayMetrics.densityDpi;
                c = displayMetrics.scaledDensity;
                d = displayMetrics.widthPixels;
                e = displayMetrics.heightPixels;
                if (!a()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("d", Float.valueOf(a).doubleValue());
                        jSONObject2.put("d_dpi", b);
                        jSONObject2.put("s_dpi", Float.valueOf(c).doubleValue());
                        jSONObject2.put("w", d);
                        jSONObject2.put("h", e);
                        d.a(context).a("ui_display_metrics_info", jSONObject2.toString());
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static float a(Context context, float f) {
        a(context);
        return (f * d(context)) + 0.5f;
    }

    public static int b(Context context) {
        a(context);
        return d;
    }

    public static int c(Context context) {
        a(context);
        return e;
    }

    public static float d(Context context) {
        a(context);
        return a;
    }

    public static int e(Context context) {
        a(context);
        return b;
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        return new int[]{view.getWidth(), view.getHeight()};
    }

    public static void a(View view, int i) {
        if (view != null && view.getVisibility() != i && a(i)) {
            view.setVisibility(i);
        }
    }

    public static boolean c(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
        }
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view != null && marginLayoutParams != null) {
            if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.rightMargin != i3 || marginLayoutParams.bottomMargin != i4) {
                if (i != -3) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -3) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -3) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -3) {
                    marginLayoutParams.bottomMargin = i4;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public static boolean a(Context context, View view, int i) {
        if (view == null) {
            l.a("adView is null.");
            return false;
        } else if (view.getParent() == null) {
            l.a("adView has no parent.");
            return false;
        } else if (view.getWindowVisibility() != 0) {
            l.a("adView window is not set to VISIBLE.");
            return false;
        } else if (view.getVisibility() != 0) {
            l.a("adView is not set to VISIBLE.");
            return false;
        } else {
            if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
                l.a("adView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            } else if (Build.VERSION.SDK_INT < 11 || view.getAlpha() >= 0.9f) {
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                try {
                    view.getLocationOnScreen(iArr);
                    int b2 = b(context);
                    int c2 = c(context);
                    if (iArr[0] < 0 || b2 - iArr[0] < width) {
                        l.a("adView is not fully on screen horizontally.");
                    } else {
                        double d2 = (double) height;
                        double d3 = (double) i;
                        Double.isNaN(d3);
                        Double.isNaN(d2);
                        int i2 = (int) ((d2 * (100.0d - d3)) / 100.0d);
                        if (iArr[1] < 0 && Math.abs(iArr[1]) > i2) {
                            l.a("adView is not visible from the top.");
                            return false;
                        } else if ((height + iArr[1]) - c2 > i2) {
                            l.a("adView is not visible from the bottom.");
                            return false;
                        } else {
                            l.a("adView is visible.");
                            return f(context);
                        }
                    }
                } catch (Exception unused) {
                    l.a("Cannot get location on screen.");
                    return false;
                }
            } else {
                l.a("adView is transparent.");
                return false;
            }
            return false;
        }
    }

    public static boolean f(Context context) {
        KeyguardManager keyguardManager;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null && powerManager.isScreenOn() && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            l.a("adView exception:" + e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }

    public static void d(final View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                /* class com.bytedance.sdk.openadsdk.g.u.AnonymousClass1 */

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    u.a(view, 8);
                    ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
                }
            });
            ofFloat.setDuration(800L);
            ofFloat.start();
        }
    }

    public static void e(View view) {
        if (view != null) {
            a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() {
                /* class com.bytedance.sdk.openadsdk.g.u.AnonymousClass2 */

                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }
}
