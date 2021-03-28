package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.2t  reason: invalid class name and case insensitive filesystem */
public class C00922t {
    public static Field A00;
    public static boolean A01 = false;
    public static Field A02;
    public static Field A03;
    public static boolean A04;
    public static boolean A05;
    public static byte[] A06;
    public static String[] A07;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 72);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{26, 54, 20, 20, 18, 4, 4, 30, 21, 30, 27, 30, 3, 14, 51, 18, 27, 18, 16, 22, 3, 18, 81, 113, 85, 82, 116, 89, 85, 91, 84, 72, 107, 75, 111, 104, 81, 111, 98, 114, 110, 14, 16, 23, 29, 22, 14};
    }

    public static void A03() {
        A07 = new String[]{"L3s3T89NtFpuDxLEKy", "cPbOOnF1boG888iUsBU9Kxy6grpVf", "WRFzwzYh2MAqPiUxzG9bo2kJfp2KHcHO", "9vcbGLR2T7yxWMobTpRq8bB9U", "SibURF26AGynrFSfxWD5QUR4x22xGZFQ", "yTrIgm3menGhBZg1uO8L6V5Q1", "HbZuQ189OK2eO85oLGeDxMojN", "ndmjFhTTq"};
    }

    static {
        A03();
        A02();
    }

    private final long A00() {
        return ValueAnimator.getFrameDelay();
    }

    public int A04(View view) {
        return 0;
    }

    public int A05(View view) {
        return 0;
    }

    public int A06(View view) {
        if (!A04) {
            try {
                A02 = View.class.getDeclaredField(A01(22, 10, 116));
                A02.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            A04 = true;
        }
        Field field = A02;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
            }
        }
        String[] strArr = A07;
        if (strArr[6].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "NCc6Jqv2GO376CQKGw1IxKfvH";
        strArr2[5] = "YVXHACGvNzaMPxLwmScJLLvmY";
        return 0;
    }

    public int A07(View view) {
        if (!A05) {
            try {
                A03 = View.class.getDeclaredField(A01(32, 9, 78));
                A03.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            A05 = true;
        }
        Field field = A03;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public Display A08(View view) {
        if (!A0J(view)) {
            return null;
        }
        Context context = view.getContext();
        String[] strArr = A07;
        if (strArr[4].charAt(26) != strArr[2].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "4a3eiuhXeUDn5EQ45doxduLNA";
        strArr2[5] = "KtzDkVpoyjscLRsaaF8xyCPTY";
        return ((WindowManager) context.getSystemService(A01(41, 6, 49))).getDefaultDisplay();
    }

    public AnonymousClass3B A09(View view, AnonymousClass3B r2) {
        return r2;
    }

    public AnonymousClass3B A0A(View view, AnonymousClass3B r2) {
        return r2;
    }

    public void A0B(View view) {
        view.postInvalidate();
    }

    public void A0C(View view) {
        if (view instanceof AbstractC00742b) {
            ((AbstractC00742b) view).stopNestedScroll();
        }
    }

    public void A0D(View view, int i) {
    }

    public final void A0E(View view, @Nullable AnonymousClass2Y r3) {
        View.AccessibilityDelegate A002;
        if (r3 == null) {
            A002 = null;
        } else {
            A002 = r3.A00();
        }
        view.setAccessibilityDelegate(A002);
    }

    public void A0F(View view, AbstractC00772e r2) {
    }

    public void A0G(View view, Runnable runnable) {
        view.postDelayed(runnable, A00());
    }

    public void A0H(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, A00() + j);
    }

    public boolean A0I(View view) {
        return false;
    }

    public boolean A0J(View view) {
        return view.getWindowToken() != null;
    }

    public final boolean A0K(View view) {
        if (A01) {
            return false;
        }
        if (A00 == null) {
            try {
                A00 = View.class.getDeclaredField(A01(0, 22, 63));
                A00.setAccessible(true);
            } catch (Throwable unused) {
                A01 = true;
                return false;
            }
        }
        try {
            if (A00.get(view) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused2) {
            A01 = true;
            return false;
        }
    }
}
