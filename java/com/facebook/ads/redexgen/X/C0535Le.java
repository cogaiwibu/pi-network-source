package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.redexgen.X.Le  reason: case insensitive filesystem */
public final class C0535Le {
    public static byte[] A00;
    public static final float A01 = A02.density;
    public static final DisplayMetrics A02 = Resources.getSystem().getDisplayMetrics();
    public static final int A03 = AnonymousClass2G.A01(ViewCompat.MEASURED_STATE_MASK, 115);
    public static final int A04 = AnonymousClass2G.A01(-1, 0);
    public static final ConcurrentHashMap<Integer, Integer> A05 = new ConcurrentHashMap<>();
    public static final AtomicInteger A06 = new AtomicInteger(1);

    public static String A0F(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A0G() {
        A00 = new byte[]{-8, -26, -13, -8, -78, -8, -22, -9, -18, -21, -78, -14, -22, -23, -18, -6, -14};
    }

    static {
        A0G();
    }

    public static int A00() {
        int newValue;
        int i;
        do {
            newValue = A06.get();
            i = newValue + 1;
            if (i > 16777215) {
                i = 1;
            }
        } while (!A06.compareAndSet(newValue, i));
        return newValue;
    }

    public static int A01(int i) {
        return (int) TypedValue.applyDimension(2, (float) i, A02);
    }

    public static int A02(int i) {
        if (A0e(i)) {
            return AnonymousClass2G.A02(i, -1, 0.4f);
        }
        return AnonymousClass2G.A02(i, ViewCompat.MEASURED_STATE_MASK, 0.2f);
    }

    public static int A03(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Multiple debug info for r0v7 double: [D('charsInFirstLine' double), D('lines' int)] */
    public static int A04(TextView textView) {
        Layout layout;
        int lines;
        if (textView == null || textView.getLayout() == null || (lines = (layout = textView.getLayout()).getLineCount()) <= 0) {
            return 0;
        }
        double ellipsisCount = (double) layout.getEllipsisCount(lines - 1);
        return (int) Math.ceil(ellipsisCount / (((double) textView.getText().length()) - ellipsisCount));
    }

    public static int A05(TextView textView, int lines) {
        int lineHeightTitle = A04(textView);
        int i = 0;
        int lineHeight = textView.getLineHeight();
        while (lines > lineHeight && i < lineHeightTitle) {
            i++;
            lines -= lineHeight;
        }
        return i;
    }

    public static Drawable A06(int i, int i2) {
        return A09(i, A02(i), i2);
    }

    public static Drawable A07(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius((float) i2);
        return gradientDrawable;
    }

    public static Drawable A08(int i, int i2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, (float) i2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static Drawable A09(int i, int i2, int i3) {
        return A0A(i, i2, i, i3);
    }

    public static Drawable A0A(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(ColorStateList.valueOf(i2), A07(i, i4), A08(i3, i4));
        }
        return A0C(i, i2, i4);
    }

    public static Drawable A0B(int i, float[] fArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public static StateListDrawable A0C(int i, int i2, int i3) {
        return A0D(new int[][]{new int[]{16842919}, new int[0]}, new int[]{i2, i}, i3);
    }

    public static StateListDrawable A0D(int[][] iArr, int[] iArr2, int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr2[i2]);
            gradientDrawable.setCornerRadius((float) i);
            stateListDrawable.addState(iArr[i2], gradientDrawable);
        }
        return stateListDrawable;
    }

    @Nullable
    public static TextView A0E(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                A0E((ViewGroup) childAt);
            }
        }
        return null;
    }

    public static void A0H(int i, float f, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration((long) (i / 2));
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    public static void A0I(int i, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration((long) (i / 3));
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((long) ((i / 3) * 2));
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new C0916a3(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    public static void A0J(int i, View view) {
        Integer num = A05.get(Integer.valueOf(i));
        if (num != null) {
            view.setId(num.intValue());
        } else {
            A0N(view);
        }
    }

    public static void A0K(@Nullable View view) {
        A0Q(view, 8);
    }

    public static void A0L(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            A0X((ViewGroup) parent);
        }
    }

    public static void A0M(@Nullable View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }

    public static void A0N(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setId(View.generateViewId());
        } else {
            view.setId(A00());
        }
    }

    public static void A0O(@Nullable View view) {
        A0Q(view, 0);
    }

    public static void A0P(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(new ColorDrawable(i));
        } else {
            view.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    public static void A0Q(@Nullable View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static void A0R(View view, int i, int i2) {
        A0W(view, A07(i, i2));
    }

    public static void A0S(View view, int i, int i2) {
        A0W(view, A09(i, A02(i), i2));
    }

    public static void A0T(View view, int i, int i2, int i3) {
        A0W(view, A0A(i, A02(i), i2, i3));
    }

    public static void A0U(View view, int i, float[] fArr) {
        A0W(view, A0B(i, fArr));
    }

    public static void A0V(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A04, A03});
        gradientDrawable.setCornerRadius(0.0f);
        A0W(view, gradientDrawable);
    }

    public static void A0W(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void A0X(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT > 19) {
            A0Y(viewGroup, 200);
        }
    }

    public static void A0Y(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT > 19) {
            A0a(viewGroup, new AutoTransition(), i);
        }
    }

    public static void A0Z(ViewGroup viewGroup, Transition transition) {
        if (Build.VERSION.SDK_INT > 19) {
            A0a(viewGroup, transition, 200);
        }
    }

    @TargetApi(19)
    public static void A0a(ViewGroup viewGroup, Transition transition, int i) {
        transition.setDuration((long) i);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    public static void A0b(TextView textView, boolean z, int i) {
        Typeface create;
        if (!z) {
            create = Typeface.create(Typeface.SANS_SERIF, 0);
        } else if (Build.VERSION.SDK_INT >= 21) {
            create = Typeface.create(A0F(0, 17, 46), 0);
        } else {
            create = Typeface.create(Typeface.SANS_SERIF, 1);
        }
        textView.setTypeface(create);
        textView.setTextSize(2, (float) i);
    }

    public static void A0c(@Nullable Toast toast, String str, int i, int i2, int i3) {
        if (toast != null) {
            toast.setGravity(i, i2, i3);
            TextView toastTextView = A0E((ViewGroup) toast.getView());
            if (toastTextView != null) {
                toastTextView.setText(str);
                toastTextView.setGravity(17);
            }
        }
    }

    public static void A0d(View... viewArr) {
        for (View view : viewArr) {
            A0M(view);
        }
    }

    public static boolean A0e(int i) {
        return AnonymousClass2G.A00(i) < 0.5d;
    }
}
