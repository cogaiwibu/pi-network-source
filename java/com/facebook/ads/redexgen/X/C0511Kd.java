package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.atomic.AtomicBoolean;

@NoAutoExceptionHandling
@SuppressLint({"EmptyCatchBlock", "CatchGeneralException", "WrongCall", "RethrownThrowableArgument"})
/* renamed from: com.facebook.ads.redexgen.X.Kd  reason: case insensitive filesystem */
public final class C0511Kd extends View {
    public static String[] A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static void A00() {
        A00 = new String[]{"kAVfBRgsuHAPyLthoP", "", "t17O26GbxI", "rw", "AAEx162laq7qeqX9thcQ", "HAXhrl7a7PCZ9u3oTFWkwwhVB4A5", "GFzV2eDHhD", "HOPUDh1leN9OTkJ3x1a"};
    }

    static {
        A00();
    }

    private final void A01() {
        super.onAttachedToWindow();
    }

    private final void A02() {
        super.onDetachedFromWindow();
    }

    private final void A03() {
        super.onFinishInflate();
    }

    private final void A04(int i) {
        super.onWindowVisibilityChanged(i);
    }

    private final void A05(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private final void A06(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private final void A07(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void A08(Throwable th) {
        C0517Kj.A00().A7t(IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, th);
    }

    public static void A09(boolean z) {
        A01.set(z);
    }

    private final void A0A(boolean z) {
        super.onWindowFocusChanged(z);
    }

    private final void A0B(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private final void A0C(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    private final boolean A0D() {
        return super.performClick();
    }

    private final boolean A0E(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private final boolean A0F(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    private final boolean A0G(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private final boolean A0H(MotionEvent motionEvent) {
        return super.onTrackballEvent(motionEvent);
    }

    public final void onAttachedToWindow() {
        try {
            A01();
        } catch (Throwable th) {
            String[] strArr = A00;
            if (strArr[6].length() != strArr[1].length()) {
                String[] strArr2 = A00;
                strArr2[7] = "rnq1MXg";
                strArr2[7] = "rnq1MXg";
                if (A01.get()) {
                    A08(th);
                    super.onAttachedToWindow();
                    return;
                }
                throw th;
            }
            throw new RuntimeException();
        }
    }

    public final void onDetachedFromWindow() {
        try {
            A02();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onDetachedFromWindow();
                return;
            }
            throw th;
        }
    }

    public final void onDraw(Canvas canvas) {
        try {
            A07(canvas);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onDraw(canvas);
                return;
            }
            throw th;
        }
    }

    public final void onFinishInflate() {
        try {
            A03();
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onFinishInflate();
                return;
            }
            throw th;
        }
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            A0C(z, i, rect);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onFocusChanged(z, i, rect);
                return;
            }
            throw th;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return A0E(i, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                boolean onKeyDown = super.onKeyDown(i, keyEvent);
                String[] strArr = A00;
                if (strArr[6].length() != strArr[1].length()) {
                    String[] strArr2 = A00;
                    strArr2[6] = "5DVI70tdQk";
                    strArr2[1] = "";
                    return onKeyDown;
                }
                throw new RuntimeException();
            }
            throw th;
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return A0F(i, keyEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onKeyUp(i, keyEvent);
            }
            throw th;
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            A0B(z, i, i2, i3, i4);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    public final void onMeasure(int i, int i2) {
        try {
            A05(i, i2);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onMeasure(i, i2);
                return;
            }
            throw th;
        }
    }

    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        try {
            A06(i, i2, i3, i4);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                super.onSizeChanged(i, i2, i3, i4);
                return;
            }
            throw th;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return A0G(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onTouchEvent(motionEvent);
            }
            throw th;
        }
    }

    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            return A0H(motionEvent);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                return super.onTrackballEvent(motionEvent);
            }
            throw th;
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        try {
            A0A(z);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                if (A00[5].length() != 25) {
                    String[] strArr = A00;
                    strArr[0] = "0jBFwaBL8FA97JJQoE8VdUJeS";
                    strArr[0] = "0jBFwaBL8FA97JJQoE8VdUJeS";
                    super.onWindowFocusChanged(z);
                    return;
                }
                throw new RuntimeException();
            }
            throw th;
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        try {
            A04(i);
        } catch (Throwable th) {
            if (A01.get()) {
                A08(th);
                if (A00[0].length() != 7) {
                    String[] strArr = A00;
                    strArr[5] = "8Ha1wZjMuo1MUnpr2KcgLPpAJB";
                    strArr[5] = "8Ha1wZjMuo1MUnpr2KcgLPpAJB";
                    super.onWindowVisibilityChanged(i);
                    return;
                }
                throw new RuntimeException();
            }
            throw th;
        }
    }

    public final boolean performClick() {
        try {
            return A0D();
        } catch (Throwable th) {
            AtomicBoolean atomicBoolean = A01;
            if (A00[7].length() != 24) {
                String[] strArr = A00;
                strArr[7] = "LfZZ0wz91OrvOK";
                strArr[7] = "LfZZ0wz91OrvOK";
                if (atomicBoolean.get()) {
                    A08(th);
                    return super.performClick();
                }
                throw th;
            }
            throw new RuntimeException();
        }
    }
}
