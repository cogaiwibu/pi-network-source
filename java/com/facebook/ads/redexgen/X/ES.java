package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public class ES extends ViewGroup implements SD {
    public static byte[] A18;
    public static String[] A19;
    public static final Interpolator A1A = new AnonymousClass42();
    public static final boolean A1B;
    public static final boolean A1C;
    public static final boolean A1D;
    public static final boolean A1E;
    public static final boolean A1F;
    public static final boolean A1G;
    public static final int[] A1H = {16842987};
    public static final int[] A1I = {16843830};
    public static final Class<?>[] A1J = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    public SS A00;
    public C01003d A01;
    public ST A02;
    public RunnableC01133q A03;
    public AnonymousClass43 A04;
    public AnonymousClass4B A05;
    public AnonymousClass4F A06;
    public AnonymousClass4O A07;
    public AnonymousClass4W A08;
    public C0719Sk A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public float A0L;
    public float A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public int A0S;
    public int A0T;
    public int A0U;
    public int A0V;
    public int A0W;
    public int A0X;
    public VelocityTracker A0Y;
    public EdgeEffect A0Z;
    public EdgeEffect A0a;
    public EdgeEffect A0b;
    public EdgeEffect A0c;
    public C00752c A0d;
    public AnonymousClass46 A0e;
    public AnonymousClass49 A0f;
    public AnonymousClass4I A0g;
    public AnonymousClass4J A0h;
    public AnonymousClass4K A0i;
    public RecyclerView$SavedState A0j;
    public Runnable A0k;
    public List<RecyclerView.OnChildAttachStateChangeListener> A0l;
    public List<AnonymousClass4K> A0m;
    public boolean A0n;
    public boolean A0o;
    public final Rect A0p;
    public final RectF A0q;
    public final AnonymousClass4N A0r;
    public final AnonymousClass4U A0s;
    public final C01274f A0t;
    public final Runnable A0u;
    public final ArrayList<AnonymousClass4C> A0v;
    public final List<AnonymousClass4X> A0w;
    public final int A0x;
    public final int A0y;
    public final Rect A0z;
    public final AccessibilityManager A10;
    public final C0717Sg A11;
    public final AbstractC01264e A12;
    public final ArrayList<AnonymousClass4J> A13;
    public final int[] A14;
    public final int[] A15;
    public final int[] A16;
    public final int[] A17;

    public static String A0J(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A18, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A0X() {
        A18 = new byte[]{-74, -74, -96, -74, -20, -1, -5, 13, -74, -34, 5, 2, -6, -5, 8, -74, -56, -48, -100, -33, -35, -22, -22, -21, -16, -100, -34, -31, -100, -30, -21, -15, -22, -32, -100, -34, -15, -16, -100, -27, -16, -100, -27, -17, -100, -22, -31, -33, -31, -17, -17, -35, -18, -11, -100, -30, -21, -18, -100, 126, -57, -47, 126, -65, -54, -48, -61, -65, -62, -41, 126, -65, -46, -46, -65, -63, -58, -61, -62, 126, -46, -51, 126, -65, 126, -80, -61, -63, -41, -63, -54, -61, -48, -76, -57, -61, -43, -104, -12, 61, 71, -12, 66, 67, 72, -12, 53, -12, 56, 61, 70, 57, 55, 72, -12, 55, 60, 61, 64, 56, -12, 67, 58, -12, -93, -15, -14, -9, -93, -23, -14, -8, -15, -25, -79, -93, -57, -20, -25, -93, -28, -15, -4, -93, -48, -14, -9, -20, -14, -15, -56, -7, -24, -15, -9, -10, -93, -22, -24, -9, -93, -10, -18, -20, -13, -13, -24, -25, -62, -45, -57, 8, 11, 8, 23, 27, 12, 25, -31, -117, ByteCompanionObject.MAX_VALUE, -62, -50, -51, -45, -60, -41, -45, -103, -56, -68, 8, -3, 21, 11, 17, 16, -42, 9, -18, 67, 65, 55, 60, 53, -18, 50, 51, 52, 47, 67, 58, 66, -18, 68, 47, 58, 67, 51, -67, -37, -26, -26, -33, -34, -102, -20, -33, -25, -23, -16, -33, -66, -33, -18, -37, -35, -30, -33, -34, -48, -29, -33, -15, -102, -15, -29, -18, -30, -102, -37, -102, -16, -29, -33, -15, -102, -15, -30, -29, -35, -30, -102, -29, -19, -102, -24, -23, -18, -102, -32, -26, -37, -31, -31, -33, -34, -102, -37, -19, -102, -18, -25, -22, -102, -34, -33, -18, -37, -35, -30, -33, -34, -88, -80, -50, -37, -37, -36, -31, -115, -48, -50, -39, -39, -115, -31, -43, -42, -32, -115, -38, -46, -31, -43, -36, -47, -115, -42, -37, -115, -50, -115, -32, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -101, -115, -64, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -32, -115, -38, -42, -44, -43, -31, -49, -46, -115, -33, -30, -37, -115, -47, -30, -33, -42, -37, -44, -115, -50, -115, -38, -46, -50, -32, -30, -33, -46, -115, -109, -115, -39, -50, -26, -36, -30, -31, -115, -35, -50, -32, -32, -115, -28, -43, -46, -33, -46, -115, -26, -36, -30, -115, -48, -50, -37, -37, -36, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -47, -50, -31, -50, -101, -115, -82, -37, -26, -115, -38, -46, -31, -43, -36, -47, -115, -48, -50, -39, -39, -115, -31, -43, -50, -31, -115, -38, -42, -44, -43, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -115, -32, -31, -33, -30, -48, -31, -30, -33, -46, -36, -45, -115, -31, -43, -46, -115, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -36, -33, -115, -31, -43, -46, -115, -50, -47, -50, -35, -31, -46, -33, -115, -48, -36, -37, -31, -46, -37, -31, -32, -115, -32, -43, -36, -30, -39, -47, -115, -49, -46, -115, -35, -36, -32, -31, -35, -36, -37, -46, -47, -115, -31, -36, -31, -43, -46, -115, -37, -46, -27, -31, -115, -45, -33, -50, -38, -46, -101, -55, -25, -12, -12, -11, -6, -90, -23, -25, -14, -14, -90, -6, -18, -17, -7, -90, -13, -21, -6, -18, -11, -22, -90, -3, -18, -17, -14, -21, -90, -40, -21, -23, -1, -23, -14, -21, -8, -36, -17, -21, -3, -90, -17, -7, -90, -23, -11, -13, -10, -5, -6, -17, -12, -19, -90, -25, -90, -14, -25, -1, -11, -5, -6, -90, -11, -8, -90, -7, -23, -8, -11, -14, -14, -17, -12, -19, -28, 2, 15, 15, 16, 21, -63, 7, 13, 10, 15, 8, -63, 24, 10, 21, 9, 16, 22, 21, -63, 2, -63, -19, 2, 26, 16, 22, 21, -18, 2, 15, 2, 8, 6, 19, -63, 20, 6, 21, -49, -63, -28, 2, 13, 13, -63, 20, 6, 21, -19, 2, 26, 16, 22, 21, -18, 2, 15, 2, 8, 6, 19, -63, 24, 10, 21, 9, -63, 2, -63, 15, 16, 15, -50, 15, 22, 13, 13, -63, 2, 19, 8, 22, 14, 6, 15, 21, -49, -35, -5, 8, 8, 9, 14, -70, 13, -3, 12, 9, 6, 6, -70, 14, 9, -70, 10, 9, 13, 3, 14, 3, 9, 8, -70, -5, -70, -26, -5, 19, 9, 15, 14, -25, -5, 8, -5, 1, -1, 12, -70, 13, -1, 14, -56, -70, -35, -5, 6, 6, -70, 13, -1, 14, -26, -5, 19, 9, 15, 14, -25, -5, 8, -5, 1, -1, 12, -70, 17, 3, 14, 2, -70, -5, -70, 8, 9, 8, -57, 8, 15, 6, 6, -70, -5, 12, 1, 15, 7, -1, 8, 14, -56, -33, -3, 10, 10, 11, 16, -68, 15, -1, 14, 11, 8, 8, -68, 19, 5, 16, 4, 11, 17, 16, -68, -3, -68, -24, -3, 21, 11, 17, 16, -23, -3, 10, -3, 3, 1, 14, -68, 15, 1, 16, -54, -68, -33, -3, 8, 8, -68, 15, 1, 16, -24, -3, 21, 11, 17, 16, -23, -3, 10, -3, 3, 1, 14, -68, 19, 5, 16, 4, -68, -3, -68, 10, 11, 10, -55, 10, 17, 8, 8, -68, -3, 14, 3, 17, 9, 1, 10, 16, -54, -29, 1, 14, 14, 15, 20, -64, 19, 13, 15, 15, 20, 8, -64, 19, 3, 18, 15, 12, 12, -64, 23, 9, 20, 8, 15, 21, 20, -64, 1, -64, -20, 1, 25, 15, 21, 20, -19, 1, 14, 1, 7, 5, 18, -64, 19, 5, 20, -50, -64, -29, 1, 12, 12, -64, 19, 5, 20, -20, 1, 25, 15, 21, 20, -19, 1, 14, 1, 7, 5, 18, -64, 23, 9, 20, 8, -64, 1, -64, 14, 15, 14, -51, 14, 21, 12, 12, -64, 1, 18, 7, 21, 13, 5, 14, 20, -50, -18, 25, -54, 24, 25, 30, -54, 29, 15, 30, -10, 11, 35, 25, 31, 30, -16, 28, 25, 36, 15, 24, -54, 19, 24, -54, 22, 11, 35, 25, 31, 30, -54, 25, 28, -54, 29, 13, 28, 25, 22, 22, -52, -7, -7, -10, -7, -89, -9, -7, -10, -22, -20, -6, -6, -16, -11, -18, -89, -6, -22, -7, -10, -13, -13, -62, -89, -9, -10, -16, -11, -5, -20, -7, -89, -16, -11, -21, -20, -1, -89, -19, -10, -7, -89, -16, -21, -89, -7, 14, 38, 28, 34, 33, -6, 14, 27, 14, 20, 18, 31, -51, -53, -20, -99, -34, -31, -34, -19, -15, -30, -17, -99, -34, -15, -15, -34, -32, -27, -30, -31, -72, -99, -16, -24, -26, -19, -19, -26, -21, -28, -99, -23, -34, -10, -20, -14, -15, -52, -19, -98, -22, -33, -9, -19, -13, -14, -98, -21, -33, -20, -33, -27, -29, -16, -98, -33, -14, -14, -33, -31, -26, -29, -30, -71, -98, -15, -23, -25, -18, -18, -25, -20, -27, -98, -22, -33, -9, -19, -13, -14, -1, 33, 30, 17, 27, 20, 28, -49, 38, 23, 24, 27, 20, -49, 28, 16, 35, 18, 23, 24, 29, 22, -49, 18, 23, 16, 29, 22, 20, 19, -49, 37, 24, 20, 38, -49, 23, 30, 27, 19, 20, 33, 34, -49, 38, 24, 35, 23, -49, 35, 23, 20, -49, 29, 20, 38, 30, 29, 20, 34, -35, -49, 3, 23, 20, -49, 31, 33, 20, -36, 27, 16, 40, 30, 36, 35, -49, 24, 29, 21, 30, 33, 28, 16, 35, 24, 30, 29, -49, 21, 30, 33, -49, 35, 23, 20, -49, 18, 23, 16, 29, 22, 20, -49, 23, 30, 27, 19, 20, 33, -49, 5, 9, -45, -7, 40, 31, 31, -4, 33, 41, 20, 31, 28, 23, 20, 39, 24, -3, 1, -53, -6, 25, -9, 12, 36, 26, 32, 31, -7, -3, -57, -9, 8, 25, 27, 16, 8, 19, -16, 21, 29, 8, 19, 16, 11, 8, 27, 12, -14, -10, -64, -13, 3, 18, 15, 12, 12, -10, 9, 7, 29, 7, 16, 9, 22, -6, 13, 9, 27, 1, 20, 18, 40, 18, 27, 20, 33, 5, 24, 20, 38, -49, 19, 30, 20, 34, -49, 29, 30, 35, -49, 34, 36, 31, 31, 30, 33, 35, -49, 34, 18, 33, 30, 27, 27, 24, 29, 22, -49, 35, 30, -49, 16, 29, -49, 16, 17, 34, 30, 27, 36, 35, 20, -49, 31, 30, 34, 24, 35, 24, 30, 29, -35, -49, 4, 34, 20, -49, 34, 18, 33, 30, 27, 27, 3, 30, -1, 30, 34, 24, 35, 24, 30, 29, -49, 24, 29, 34, 35, 20, 16, 19, -72, -53, -55, -33, -55, -46, -53, -40, -68, -49, -53, -35, -122, -50, -57, -39, -122, -44, -43, -122, -78, -57, -33, -43, -37, -38, -77, -57, -44, -57, -51, -53, -40, 29, 64, 56, -23, 45, 50, 47, 47, 46, 59, 46, 55, 61, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, 60, -23, 49, 42, 63, 46, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 44, 49, 42, 55, 48, 46, -23, 18, 13, -9, -23, 29, 49, 50, 60, -23, 54, 50, 48, 49, 61, -23, 49, 42, 57, 57, 46, 55, -23, 45, 62, 46, -23, 61, 56, -23, 50, 55, 44, 56, 55, 60, 50, 60, 61, 46, 55, 61, -23, 10, 45, 42, 57, 61, 46, 59, -23, 62, 57, 45, 42, 61, 46, -23, 46, 63, 46, 55, 61, 60, -23, 56, 59, -23, 50, 47, -23, 61, 49, 46, -23, 21, 42, 66, 56, 62, 61, 22, 42, 55, 42, 48, 46, 59, -23, 53, 42, 66, 60, -23, 56, 62, 61, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 31, 50, 46, 64, -23, 54, 62, 53, 61, 50, 57, 53, 46, -23, 61, 50, 54, 46, 60, -9, -45, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, -23, -6, 3, -10, 25, 17, -62, 6, 11, 8, 8, 7, 20, 7, 16, 22, -62, -8, 11, 7, 25, -22, 17, 14, 6, 7, 20, 21, -62, 10, 3, 24, 7, -62, 22, 10, 7, -62, 21, 3, 15, 7, -62, 21, 22, 3, 4, 14, 7, -62, -21, -26, -48, -62, -11, 22, 3, 4, 14, 7, -62, -21, -26, 21, -62, 11, 16, -62, 27, 17, 23, 20, -62, 3, 6, 3, 18, 22, 7, 20, -62, -17, -9, -11, -10, -62, -28, -25, -62, 23, 16, 11, 19, 23, 7, -62, 3, 16, 6, -62, -11, -22, -15, -9, -18, -26, -62, -16, -15, -10, -62, 5, 10, 3, 16, 9, 7, -48, -84, -62, -8, 11, 7, 25, -22, 17, 14, 6, 7, 20, -62, -45, -36, -29, -10, -14, 4, -83, 7, 9, 9, 11, 25, 25, 15, 8, 15, 18, 15, 26, 31, 31, 36, 45, 32, 30, 47, 36, 42, 41, -37, 40, 48, 46, 47, -37, 29, 32, -37, 28, 29, 46, 42, 39, 48, 47, 32, -23, -37, 45, 32, 30, 32, 36, 49, 32, 31, -11, -38, -52, -37, -70, -54, -39, -42, -45, -45, -48, -43, -50, -69, -42, -36, -54, -49, -70, -45, -42, -41, -113, -112, -95, -121, -55, -56, -53, -121, -56, -39, -50, -36, -44, -52, -43, -37, -121, -54, -42, -43, -38, -37, -56, -43, -37, -121};
    }

    public static void A0Y() {
        A19 = new String[]{"EzQ8zede2M", "Jhjgeach8ubRdn89CHbftPIFCkhy8Cmz", "AI0RoC", "LwFgY3t3Qwi2PJUU36Pvm2", "gOCwMU1oDfpLVyXTNaTi7eQdHjis00sx", "GZYggCcl1OWg4VOzBYKk2kBvqjxmktta", "Te26Sy6xLG0KtVPzJaOHws0Kts3F9NRb", "K773CdyIAwEU"};
    }

    static {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        A0Y();
        A0X();
        if (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
            z = true;
        } else {
            z = false;
        }
        A1C = z;
        if (Build.VERSION.SDK_INT >= 23) {
            z2 = true;
        } else {
            z2 = false;
        }
        A1B = z2;
        if (Build.VERSION.SDK_INT >= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        A1D = z3;
        if (Build.VERSION.SDK_INT >= 21) {
            z4 = true;
        } else {
            z4 = false;
        }
        A1E = z4;
        if (Build.VERSION.SDK_INT <= 15) {
            z5 = true;
        } else {
            z5 = false;
        }
        A1F = z5;
        if (Build.VERSION.SDK_INT <= 15) {
            z6 = true;
        } else {
            z6 = false;
        }
        A1G = z6;
    }

    public ES(Context context) {
        this(context, null);
    }

    public ES(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ES(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ST st;
        this.A11 = new C0717Sg(this);
        this.A0r = new AnonymousClass4N(this);
        this.A0t = new C01274f();
        this.A0u = new AnonymousClass40(this);
        this.A0p = new Rect();
        this.A0z = new Rect();
        this.A0q = new RectF();
        this.A0v = new ArrayList<>();
        this.A13 = new ArrayList<>();
        boolean z = false;
        this.A0O = 0;
        this.A0C = false;
        this.A0U = 0;
        this.A0N = 0;
        this.A05 = new EV();
        this.A0W = 0;
        this.A0V = -1;
        this.A0L = Float.MIN_VALUE;
        this.A0M = Float.MIN_VALUE;
        this.A0o = true;
        this.A08 = new AnonymousClass4W(this);
        if (A1E) {
            st = new ST();
        } else {
            st = null;
        }
        this.A02 = st;
        this.A0s = new AnonymousClass4U();
        this.A0G = false;
        this.A0H = false;
        this.A0f = new C0714Sd(this);
        this.A0K = false;
        this.A14 = new int[2];
        this.A17 = new int[2];
        this.A16 = new int[2];
        this.A15 = new int[2];
        this.A0w = new ArrayList();
        this.A0k = new AnonymousClass41(this);
        this.A12 = new C0712Sa(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A1H, i, 0);
            this.A0B = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.A0B = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A0X = viewConfiguration.getScaledTouchSlop();
        this.A0L = C00932v.A00(viewConfiguration, context);
        this.A0M = C00932v.A01(viewConfiguration, context);
        this.A0y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A0x = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2 ? true : z);
        this.A05.A0A(this.A0f);
        A0g();
        A0P();
        if (AnonymousClass2u.A00(this) == 0) {
            AnonymousClass2u.A09(this, 1);
        }
        this.A10 = (AccessibilityManager) getContext().getSystemService(A0J(1831, 13, 81));
        setAccessibilityDelegateCompat(new C0719Sk(this));
        setDescendantFocusability(262144);
        setNestedScrollingEnabled(true);
    }

    private int A0B(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private final long A0C(AnonymousClass4X r3) {
        return this.A04.A0C() ? r3.A0L() : (long) r3.A03;
    }

    /* JADX INFO: Multiple debug info for r1v2 com.facebook.ads.redexgen.X.4X: [D('i' int), D('limit' int)] */
    private View A0D() {
        int i;
        AnonymousClass4X A0E2;
        if (this.A0s.A01 != -1) {
            i = this.A0s.A01;
        } else {
            i = 0;
        }
        int A032 = this.A0s.A03();
        for (int i2 = i; i2 < A032; i2++) {
            AnonymousClass4X A0E3 = A0E(i2);
            if (A0E3 == null) {
                break;
            } else if (A0E3.A0H.hasFocusable()) {
                return A0E3.A0H;
            }
        }
        int min = Math.min(A032, i) - 1;
        while (min >= 0 && (A0E2 = A0E(min)) != null) {
            if (A0E2.A0H.hasFocusable()) {
                return A0E2.A0H;
            }
            min--;
        }
        return null;
    }

    private final AnonymousClass4X A0E(int i) {
        if (this.A0C) {
            return null;
        }
        int A072 = this.A01.A07();
        AnonymousClass4X r1 = null;
        for (int i2 = 0; i2 < A072; i2++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i2));
            if (A0G2 != null && !A0G2.A0d() && A1E(A0G2) == i) {
                if (!this.A01.A0L(A0G2.A0H)) {
                    return A0G2;
                }
                r1 = A0G2;
            }
        }
        return r1;
    }

    private final AnonymousClass4X A0F(long j) {
        AnonymousClass43 r0 = this.A04;
        if (r0 == null || !r0.A0C()) {
            return null;
        }
        int A072 = this.A01.A07();
        AnonymousClass4X r8 = null;
        for (int i = 0; i < A072; i++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i));
            if (A0G2 != null && !A0G2.A0d()) {
                long A0L2 = A0G2.A0L();
                String[] strArr = A19;
                if (strArr[3].length() != strArr[0].length()) {
                    String[] strArr2 = A19;
                    strArr2[2] = "zZZE93";
                    strArr2[7] = "VhF552wVYFMR";
                    if (A0L2 != j) {
                        continue;
                    } else if (!this.A01.A0L(A0G2.A0H)) {
                        return A0G2;
                    } else {
                        r8 = A0G2;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return r8;
    }

    public static AnonymousClass4X A0G(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[6] = "BAOGG7B6SgQWpjs0haC4kmkQlPV7A4k9";
        strArr[4] = "PAhaNRNZ3VZ1U75Bha3wwWQKZTmx8jYI";
        return ((AnonymousClass4G) layoutParams).A00;
    }

    private final AnonymousClass4X A0H(View view) {
        View A1G2 = A1G(view);
        if (A1G2 == null) {
            return null;
        }
        return A1I(A1G2);
    }

    public static ES A0I(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        boolean z = view instanceof ES;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[1] = "St3OXKQiThZ0lO5vTnfaG6NXMltPJG5W";
        strArr[1] = "St3OXKQiThZ0lO5vTnfaG6NXMltPJG5W";
        if (z) {
            return (ES) view;
        }
        ViewGroup parent = (ViewGroup) view;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ES descendant = A0I(parent.getChildAt(i));
            if (descendant != null) {
                return descendant;
            }
        }
        return null;
    }

    private void A0K() {
        A0U();
        setScrollState(0);
    }

    private void A0L() {
        int i = this.A0P;
        this.A0P = 0;
        if (i != 0) {
            boolean A1t = A1t();
            String[] strArr = A19;
            if (strArr[2].length() != strArr[7].length()) {
                String[] strArr2 = A19;
                strArr2[3] = "eU2cwXbbXfV7oR8qPBCYPw";
                strArr2[0] = "cj1lHsGs8Y";
                if (A1t) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    AnonymousClass3D.A01(obtain, i);
                    sendAccessibilityEventUnchecked(obtain);
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Multiple debug info for r10v0 'this'  com.facebook.ads.redexgen.X.ES: [D('didStructureChange' boolean), D('count' int)] */
    /* JADX INFO: Multiple debug info for r0v33 android.view.View: [D('animationInfo' com.facebook.ads.redexgen.X.4A), D('child' android.view.View)] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0M() {
        /*
        // Method dump skipped, instructions count: 491
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.A0M():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0N() {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.A0N():void");
    }

    /* JADX INFO: Multiple debug info for r3v4 'i'  int: [D('i' int), D('holder' com.facebook.ads.redexgen.X.4X)] */
    /* JADX INFO: Multiple debug info for r0v31 long: [D('postInfo' com.facebook.ads.redexgen.X.4A), D('key' long)] */
    private void A0O() {
        this.A0s.A04(4);
        A1L();
        A1M();
        AnonymousClass4U r0 = this.A0s;
        r0.A04 = 1;
        if (r0.A0C) {
            int i = this.A01.A06() - 1;
            while (true) {
                if (i < 0) {
                    this.A0t.A0H(this.A12);
                    break;
                }
                AnonymousClass4X A0G2 = A0G(this.A01.A0A(i));
                if (!A0G2.A0i()) {
                    long key = A0C(A0G2);
                    AnonymousClass4A A072 = this.A05.A07(this.A0s, A0G2);
                    AnonymousClass4X A062 = this.A0t.A06(key);
                    if (A062 == null || A062.A0i()) {
                        this.A0t.A0F(A0G2, A072);
                    } else {
                        boolean A0I2 = this.A0t.A0I(A062);
                        C01274f r9 = this.A0t;
                        if (A19[5].charAt(2) != 'Y') {
                            break;
                        }
                        String[] strArr = A19;
                        strArr[1] = "oIS3LUWJBkP0D1bim3OID749wsN9UxnV";
                        strArr[1] = "oIS3LUWJBkP0D1bim3OID749wsN9UxnV";
                        boolean A0I3 = r9.A0I(A0G2);
                        if (!A0I2 || A062 != A0G2) {
                            AnonymousClass4A A052 = this.A0t.A05(A062);
                            this.A0t.A0F(A0G2, A072);
                            AnonymousClass4A A042 = this.A0t.A04(A0G2);
                            if (A052 == null) {
                                A0o(key, A0G2, A062);
                            } else {
                                A0v(A062, A0G2, A052, A042, A0I2, A0I3);
                            }
                        } else {
                            this.A0t.A0F(A0G2, A072);
                        }
                    }
                }
                i--;
            }
        }
        this.A06.A1H(this.A0r);
        AnonymousClass4U r1 = this.A0s;
        r1.A05 = r1.A03;
        this.A0C = false;
        AnonymousClass4U r02 = this.A0s;
        r02.A0C = false;
        r02.A0B = false;
        this.A06.A09 = false;
        if (this.A0r.A02 != null) {
            ArrayList<AnonymousClass4X> arrayList = this.A0r.A02;
            String[] strArr2 = A19;
            if (strArr2[3].length() != strArr2[0].length()) {
                String[] strArr3 = A19;
                strArr3[1] = "DxhhwSm2KO29M0snTVs4N8QFyNW6c8YZ";
                strArr3[1] = "DxhhwSm2KO29M0snTVs4N8QFyNW6c8YZ";
                arrayList.clear();
            }
            throw new RuntimeException();
        }
        if (this.A06.A08) {
            AnonymousClass4F r03 = this.A06;
            r03.A00 = 0;
            r03.A08 = false;
            this.A0r.A0P();
        }
        this.A06.A20(this.A0s);
        A1N();
        A1s(false);
        this.A0t.A07();
        int[] iArr = this.A14;
        if (A13(iArr[0], iArr[1])) {
            A1c(0, 0);
        }
        A0R();
        A0T();
    }

    private void A0P() {
        this.A01 = new C01003d(new Sb(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0Q() {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.A0Q():void");
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.ES: [D('focusTarget' com.facebook.ads.redexgen.X.4X), D('focusedChild' android.view.View)] */
    private void A0R() {
        View findViewById;
        if (this.A0o && this.A04 != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                boolean isFocused = isFocused();
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[5] = "GSYhD7ljhsNq0QcPBhSV8ATJlhol3xt1";
                strArr[5] = "GSYhD7ljhsNq0QcPBhSV8ATJlhol3xt1";
                if (!isFocused) {
                    View focusedChild = getFocusedChild();
                    if (!A1G || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.A01.A0L(focusedChild)) {
                            return;
                        }
                    } else if (this.A01.A06() == 0) {
                        requestFocus();
                        return;
                    }
                }
                AnonymousClass4X r6 = null;
                if (this.A0s.A08 != -1 && this.A04.A0C()) {
                    r6 = A0F(this.A0s.A08);
                }
                View view = null;
                if (r6 != null && !this.A01.A0L(r6.A0H) && r6.A0H.hasFocusable()) {
                    view = r6.A0H;
                } else if (this.A01.A06() > 0) {
                    view = A0D();
                }
                if (view != null) {
                    if (!(((long) this.A0s.A02) == -1 || (findViewById = view.findViewById(this.A0s.A02)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void A0S() {
        boolean z = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0c;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0b;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect4 = this.A0Z;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.A0Z.isFinished();
        }
        if (z) {
            AnonymousClass2u.A07(this);
        }
    }

    private void A0T() {
        AnonymousClass4U r2 = this.A0s;
        r2.A08 = -1;
        r2.A01 = -1;
        r2.A02 = -1;
    }

    private void A0U() {
        VelocityTracker velocityTracker = this.A0Y;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        A1Y(0);
        A0S();
    }

    private void A0V() {
        AnonymousClass4X A0H2;
        long j;
        int A0H3;
        View view = null;
        if (this.A0o && hasFocus() && this.A04 != null) {
            view = getFocusedChild();
        }
        if (view == null) {
            A0H2 = null;
        } else {
            A0H2 = A0H(view);
        }
        if (A0H2 == null) {
            A0T();
            return;
        }
        AnonymousClass4U r2 = this.A0s;
        if (this.A04.A0C()) {
            j = A0H2.A0L();
        } else {
            j = -1;
        }
        r2.A08 = j;
        AnonymousClass4U r1 = this.A0s;
        if (this.A0C) {
            A0H3 = -1;
        } else if (A0H2.A0d()) {
            A0H3 = A0H2.A01;
        } else {
            A0H3 = A0H2.A0H();
        }
        r1.A01 = A0H3;
        this.A0s.A02 = A0B(A0H2.A0H);
    }

    private void A0W() {
        this.A08.A09();
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            r0.A0y();
        }
    }

    private final void A0Z() {
        int A072 = this.A01.A07();
        for (int i = 0; i < A072; i++) {
            C01003d r5 = this.A01;
            String[] strArr = A19;
            if (strArr[3].length() != strArr[0].length()) {
                String[] strArr2 = A19;
                strArr2[3] = "VFyFJGthyduvDNyVUqu48D";
                strArr2[0] = "uBjdUWzzez";
                AnonymousClass4X A0G2 = A0G(r5.A0B(i));
                if (!A0G2.A0i()) {
                    A0G2.A0N();
                }
            } else {
                throw new RuntimeException();
            }
        }
        this.A0r.A0L();
    }

    private final void A0a() {
        AnonymousClass43 r4 = this.A04;
        String A0J2 = A0J(1370, 12, 79);
        if (r4 == null) {
            Log.e(A0J2, A0J(1123, 36, 40));
        } else if (this.A06 == null) {
            Log.e(A0J2, A0J(1159, 43, 41));
        } else {
            AnonymousClass4U r1 = this.A0s;
            r1.A0A = false;
            if (r1.A04 == 1) {
                A0M();
                this.A06.A1P(this);
                A0N();
            } else if (!this.A00.A0L() && this.A06.A0i() == getWidth() && this.A06.A0Y() == getHeight()) {
                this.A06.A1P(this);
            } else {
                this.A06.A1P(this);
                A0N();
            }
            A0O();
        }
    }

    private final void A0b() {
        int i;
        for (int size = this.A0w.size() - 1; size >= 0; size--) {
            AnonymousClass4X r3 = this.A0w.get(size);
            if (r3.A0H.getParent() == this && !r3.A0i() && (i = r3.A02) != -1) {
                AnonymousClass2u.A09(r3.A0H, i);
                r3.A02 = -1;
            }
        }
        this.A0w.clear();
    }

    private final void A0c() {
        if (this.A0Z == null) {
            this.A0Z = new EdgeEffect(getContext());
            if (this.A0B) {
                this.A0Z.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.A0Z.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private final void A0d() {
        if (this.A0a == null) {
            this.A0a = new EdgeEffect(getContext());
            if (this.A0B) {
                EdgeEffect edgeEffect = this.A0a;
                int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                int measuredWidth = getMeasuredWidth() - getPaddingLeft();
                String[] strArr = A19;
                if (strArr[2].length() != strArr[7].length()) {
                    String[] strArr2 = A19;
                    strArr2[6] = "GMHrLIeJxdXYoHZyaa7kSwSfzExGbrBL";
                    strArr2[4] = "0YT1HYXH3vPYSlLI8aOL6WZeFeHH6VHe";
                    edgeEffect.setSize(measuredHeight, measuredWidth - getPaddingRight());
                    return;
                }
                throw new RuntimeException();
            }
            this.A0a.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    private final void A0e() {
        if (this.A0b == null) {
            this.A0b = new EdgeEffect(getContext());
            if (this.A0B) {
                this.A0b.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.A0b.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    private final void A0f() {
        if (this.A0c == null) {
            this.A0c = new EdgeEffect(getContext());
            if (this.A0B) {
                this.A0c.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
                return;
            }
            EdgeEffect edgeEffect = this.A0c;
            int measuredWidth = getMeasuredWidth();
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "10JS50";
            strArr[7] = "NY78MD5eAiV9";
            edgeEffect.setSize(measuredWidth, getMeasuredHeight());
        }
    }

    private final void A0g() {
        this.A00 = new SS(new C0713Sc(this));
    }

    private final void A0h() {
        this.A0Z = null;
        this.A0c = null;
        this.A0b = null;
        this.A0a = null;
    }

    private final void A0i() {
        int A072 = this.A01.A07();
        for (int i = 0; i < A072; i++) {
            ((AnonymousClass4G) this.A01.A0B(i).getLayoutParams()).A01 = true;
        }
        this.A0r.A0N();
    }

    private final void A0j() {
        int A072 = this.A01.A07();
        for (int i = 0; i < A072; i++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i));
            if (A0G2 != null && !A0G2.A0i()) {
                A0G2.A0U(6);
            }
        }
        A0i();
        this.A0r.A0O();
    }

    private final void A0k() {
        int A072 = this.A01.A07();
        for (int i = 0; i < A072; i++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i));
            if (!A0G2.A0i()) {
                A0G2.A0S();
            }
        }
    }

    private void A0l(float f, float f2, float f3, float f4) {
        boolean z = false;
        if (f2 < 0.0f) {
            A0d();
            AnonymousClass3U.A00(this.A0a, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
            z = true;
        } else if (f2 > 0.0f) {
            A0e();
            AnonymousClass3U.A00(this.A0b, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
            z = true;
        }
        if (f4 < 0.0f) {
            A0f();
            AnonymousClass3U.A00(this.A0c, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
            z = true;
        } else if (f4 > 0.0f) {
            A0c();
            AnonymousClass3U.A00(this.A0Z, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
            z = true;
        }
        if (z || f2 != 0.0f || f4 != 0.0f) {
            AnonymousClass2u.A07(this);
        }
    }

    private final void A0m(int i) {
        AnonymousClass4F r0 = this.A06;
        AnonymousClass4K r02 = this.A0i;
        if (r02 != null) {
            r02.A0V(this, i);
        }
        List<AnonymousClass4K> list = this.A0m;
        String[] strArr = A19;
        if (strArr[2].length() != strArr[7].length()) {
            String[] strArr2 = A19;
            strArr2[2] = "mB2qLC";
            strArr2[7] = "mQXIqdAaLius";
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.A0m.get(size).A0V(this, i);
                }
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private final void A0n(int i, int i2, Interpolator interpolator) {
        AnonymousClass4F r4 = this.A06;
        if (r4 == null) {
            Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
            return;
        }
        boolean z = this.A0I;
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "pqK8Y9";
        strArr[7] = "UiASdGbGWO9v";
        if (!z) {
            if (!r4.A25()) {
                i = 0;
            }
            if (!this.A06.A26()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                this.A08.A0E(i, i2, interpolator);
            }
        }
    }

    private void A0o(long j, AnonymousClass4X other, AnonymousClass4X r11) {
        int A062 = this.A01.A06();
        for (int i = 0; i < A062; i++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0A(i));
            if (A0G2 != other && A0C(A0G2) == j) {
                AnonymousClass43 r3 = this.A04;
                String A0J2 = A0J(1, 17, 65);
                if (r3 == null || !r3.A0C()) {
                    throw new IllegalStateException(A0J(1508, 188, 116) + A0G2 + A0J2 + other + A1J());
                }
                throw new IllegalStateException(A0J(1696, 130, 77) + A0G2 + A0J2 + other + A1J());
            }
        }
        Log.e(A0J(1370, 12, 79), A0J(IronSourceConstants.RV_INSTANCE_SHOW_FAILED, 111, 90) + r11 + A0J(18, 41, 39) + other + A1J());
    }

    private void A0p(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A0V) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.A0V = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.A0S = x;
            this.A0Q = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.A0T = y;
            this.A0R = y;
        }
    }

    public static void A0q(View view, Rect insets) {
        AnonymousClass4G r6 = (AnonymousClass4G) view.getLayoutParams();
        Rect rect = r6.A03;
        insets.set((view.getLeft() - rect.left) - r6.leftMargin, (view.getTop() - rect.top) - r6.topMargin, view.getRight() + rect.right + r6.rightMargin, view.getBottom() + rect.bottom + r6.bottomMargin);
    }

    private void A0r(View view, View view2) {
        View view3;
        boolean z;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.A0p.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof AnonymousClass4G) {
            AnonymousClass4G r1 = (AnonymousClass4G) layoutParams;
            if (!r1.A01) {
                Rect rect = r1.A03;
                this.A0p.left -= rect.left;
                this.A0p.right += rect.right;
                this.A0p.top -= rect.top;
                this.A0p.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.A0p);
            offsetRectIntoDescendantCoords(view, this.A0p);
        }
        AnonymousClass4F r2 = this.A06;
        Rect rect2 = this.A0p;
        boolean z2 = !this.A0D;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        r2.A1f(this, view, rect2, z2, z);
    }

    private void A0s(AnonymousClass43 r6, boolean z, boolean z2) {
        AnonymousClass43 r4 = this.A04;
        if (r4 != null) {
            C0717Sg sg = this.A11;
            String[] strArr = A19;
            if (strArr[2].length() != strArr[7].length()) {
                String[] strArr2 = A19;
                strArr2[6] = "W0We85FJJqvSsXa60a6gd4EA7hDdiGkp";
                strArr2[4] = "7sp9VzUFxAlBM78ItapDbGKr6NkpOVCZ";
                r4.A0A(sg);
            } else {
                throw new RuntimeException();
            }
        }
        if (!z || z2) {
            A1P();
        }
        this.A00.A0J();
        AnonymousClass43 r2 = this.A04;
        this.A04 = r6;
        if (r6 != null) {
            r6.A09(this.A11);
        }
        AnonymousClass4F r0 = this.A06;
        this.A0r.A0Z(r2, this.A04, z);
        this.A0s.A0D = true;
        A1R();
    }

    private void A0t(AnonymousClass4X r7) {
        boolean z;
        View view = r7.A0H;
        if (view.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        this.A0r.A0d(A1I(view));
        if (r7.A0f()) {
            C01003d r5 = this.A01;
            String[] strArr = A19;
            if (strArr[3].length() != strArr[0].length()) {
                String[] strArr2 = A19;
                strArr2[6] = "yAMck033yUmsKAwrNaBuaPdrYuAtD8a4";
                strArr2[4] = "2F1g5meBaFaT8Ughfaz4Efd5BOFwzFG2";
                r5.A0I(view, -1, view.getLayoutParams(), true);
                return;
            }
            throw new RuntimeException();
        } else if (!z) {
            this.A01.A0K(view, true);
        } else {
            this.A01.A0F(view);
        }
    }

    public static void A0u(AnonymousClass4X r4) {
        if (r4.A09 != null) {
            WeakReference<ES> weakReference = r4.A09;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "Lp0Vudgnjyr9htx58aJuOXSG6zR0Rms0";
            strArr[4] = "QnOoNSP4qihOpTYseackLt73SA9jbFjz";
            ES es = weakReference.get();
            while (es != null) {
                if (es != r4.A0H) {
                    ViewParent parent = es.getParent();
                    if (parent instanceof View) {
                        es = (View) parent;
                    } else {
                        es = null;
                    }
                } else {
                    return;
                }
            }
            r4.A09 = null;
        }
    }

    private void A0v(AnonymousClass4X r3, AnonymousClass4X r4, AnonymousClass4A r5, AnonymousClass4A r6, boolean z, boolean z2) {
        r3.A0a(false);
        if (z) {
            A0t(r3);
        }
        if (r3 != r4) {
            if (z2) {
                A0t(r4);
            }
            r3.A06 = r4;
            A0t(r3);
            this.A0r.A0d(r3);
            r4.A0a(false);
            r4.A07 = r3;
        }
        if (this.A05.A0L(r3, r4, r5, r6)) {
            A1O();
        }
    }

    private void A0z(int[] iArr) {
        int minPositionPreLayout = this.A01.A06();
        if (minPositionPreLayout == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int pos = Integer.MAX_VALUE;
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < minPositionPreLayout; i2++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0A(i2));
            if (!A0G2.A0i()) {
                int A0J2 = A0G2.A0J();
                if (A0J2 < pos) {
                    pos = A0J2;
                }
                if (A0J2 > i) {
                    i = A0J2;
                }
            }
        }
        iArr[0] = pos;
        iArr[1] = i;
    }

    private boolean A10() {
        int A062 = this.A01.A06();
        for (int i = 0; i < A062; i++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0A(i));
            if (!(A0G2 == null || A0G2.A0i() || !A0G2.A0g())) {
                return true;
            }
        }
        return false;
    }

    private boolean A11() {
        return this.A05 != null && this.A06.A27();
    }

    private boolean A13(int i, int i2) {
        A0z(this.A14);
        int[] iArr = this.A14;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private final boolean A14(int nestedScrollAxis, int i) {
        boolean z;
        AnonymousClass4F r1 = this.A06;
        if (r1 == null) {
            Log.e(A0J(1370, 12, 79), A0J(651, 89, 76));
            return false;
        } else if (this.A0I) {
            return false;
        } else {
            boolean A25 = r1.A25();
            boolean A26 = this.A06.A26();
            if (!A25 || Math.abs(nestedScrollAxis) < this.A0y) {
                nestedScrollAxis = 0;
            }
            if (!A26 || Math.abs(i) < this.A0y) {
                i = 0;
            }
            if (!(nestedScrollAxis == 0 && i == 0) && !dispatchNestedPreFling((float) nestedScrollAxis, (float) i)) {
                if (A25 || A26) {
                    z = true;
                } else {
                    z = false;
                }
                dispatchNestedFling((float) nestedScrollAxis, (float) i, z);
                AnonymousClass4I r0 = this.A0g;
                if (r0 != null && r0.A0D(nestedScrollAxis, i)) {
                    return true;
                }
                if (z) {
                    int i2 = 0;
                    if (A25) {
                        i2 = 0 | 1;
                    }
                    if (A26) {
                        i2 |= 2;
                    }
                    A1x(i2, 1);
                    int i3 = this.A0x;
                    int max = Math.max(-i3, Math.min(nestedScrollAxis, i3));
                    int i4 = this.A0x;
                    this.A08.A0A(max, Math.max(-i4, Math.min(i, i4)));
                    return true;
                }
            }
            return false;
        }
    }

    private final boolean A15(int unconsumedY, int consumedX, MotionEvent motionEvent) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        A1K();
        if (this.A04 != null) {
            A1L();
            A1M();
            AnonymousClass2H.A01(A0J(1361, 9, 75));
            A1m(this.A0s);
            if (unconsumedY != 0) {
                i3 = this.A06.A1i(unconsumedY, this.A0r, this.A0s);
                i = unconsumedY - i3;
            }
            if (consumedX != 0) {
                i4 = this.A06.A1j(consumedX, this.A0r, this.A0s);
                i2 = consumedX - i4;
            }
            AnonymousClass2H.A00();
            A1Q();
            A1N();
            A1s(false);
        }
        if (!this.A0v.isEmpty()) {
            invalidate();
        }
        if (A1y(i3, i4, i, i2, this.A17, 0)) {
            int consumedY = this.A0S;
            int[] iArr = this.A17;
            this.A0S = consumedY - iArr[0];
            this.A0T -= iArr[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            }
            int[] iArr2 = this.A15;
            int i5 = iArr2[0];
            int[] iArr3 = this.A17;
            int i6 = i5 + iArr3[0];
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[1] = "TzjapWGLjdNwrlMHhQTvw0KTjubTnl9R";
            strArr2[1] = "TzjapWGLjdNwrlMHhQTvw0KTjubTnl9R";
            iArr2[0] = i6;
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !C00732a.A00(motionEvent, 8194)) {
                float x = motionEvent.getX();
                float f = (float) i;
                float y = motionEvent.getY();
                float f2 = (float) i2;
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A19;
                strArr3[1] = "Rb7Wd2rB1Bk4FJnk1H23iqiZozoKDKpI";
                strArr3[1] = "Rb7Wd2rB1Bk4FJnk1H23iqiZozoKDKpI";
                A0l(x, f, y, f2);
            }
            A1a(unconsumedY, consumedX);
        }
        if (!(i3 == 0 && i4 == 0)) {
            A1c(i3, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i3 == 0 && i4 == 0) {
            return false;
        }
        return true;
    }

    private boolean A16(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.A0h != null) {
            if (action == 0) {
                this.A0h = null;
            } else {
                if (action == 3 || action == 1) {
                    this.A0h = null;
                }
                return true;
            }
        }
        if (action == 0) {
            return false;
        }
        int size = this.A13.size();
        for (int i = 0; i < size; i++) {
            AnonymousClass4J r1 = this.A13.get(i);
            if (r1.onInterceptTouchEvent(this, motionEvent)) {
                this.A0h = r1;
                return true;
            }
        }
        return false;
    }

    private boolean A17(MotionEvent motionEvent) {
        int listenerCount = motionEvent.getAction();
        if (listenerCount == 3 || listenerCount == 0) {
            this.A0h = null;
        }
        int size = this.A13.size();
        for (int i = 0; i < size; i++) {
            AnonymousClass4J r1 = this.A13.get(i);
            if (r1.onInterceptTouchEvent(this, motionEvent) && listenerCount != 3) {
                this.A0h = r1;
                return true;
            }
        }
        return false;
    }

    private boolean A18(View view, View view2, int i) {
        boolean z;
        int i2;
        boolean z2 = false;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return A19(view, view2, i);
        }
        if (this.A06.A0b() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (i == 2) {
            z2 = true;
        }
        if (z2 ^ z) {
            i2 = 66;
        } else {
            i2 = 17;
        }
        if (A19(view, view2, i2)) {
            return true;
        }
        if (i == 2) {
            return A19(view, view2, 130);
        }
        return A19(view, view2, 33);
    }

    private boolean A19(View view, View view2, int i) {
        this.A0p.set(0, 0, view.getWidth(), view.getHeight());
        this.A0z.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.A0p);
        offsetDescendantRectToMyCoords(view2, this.A0z);
        if (i != 17) {
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[1] = "Yc6OUsH3chOpt4vkJfacRirYduge3wUm";
            strArr2[1] = "Yc6OUsH3chOpt4vkJfacRirYduge3wUm";
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException(A0J(1844, 37, 102) + i + A1J());
                    } else if ((this.A0p.top < this.A0z.top || this.A0p.bottom <= this.A0z.top) && this.A0p.bottom < this.A0z.bottom) {
                        return true;
                    } else {
                        return false;
                    }
                } else if ((this.A0p.left < this.A0z.left || this.A0p.right <= this.A0z.left) && this.A0p.right < this.A0z.right) {
                    return true;
                } else {
                    return false;
                }
            } else if ((this.A0p.bottom > this.A0z.bottom || this.A0p.top >= this.A0z.bottom) && this.A0p.top > this.A0z.top) {
                return true;
            } else {
                return false;
            }
        } else if ((this.A0p.right > this.A0z.right || this.A0p.left >= this.A0z.right) && this.A0p.left > this.A0z.left) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean A1A(AccessibilityEvent accessibilityEvent) {
        if (!A1v()) {
            return false;
        }
        int i = 0;
        if (accessibilityEvent != null) {
            i = AnonymousClass3D.A00(accessibilityEvent);
        }
        if (i == 0) {
            i = 0;
        }
        this.A0P |= i;
        return true;
    }

    public final int A1D(View view) {
        AnonymousClass4X A0G2 = A0G(view);
        if (A0G2 != null) {
            return A0G2.A0J();
        }
        return -1;
    }

    public final int A1E(AnonymousClass4X r5) {
        if (!r5.A0l(IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT) && r5.A0b()) {
            return this.A00.A0F(r5.A03);
        }
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "S0wUd1";
        strArr[7] = "zF1SY7WsjbFG";
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r3 != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Rect A1F(android.view.View r9) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.A1F(android.view.View):android.graphics.Rect");
    }

    public final View A1G(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final AnonymousClass4X A1H(int i, boolean z) {
        int A072 = this.A01.A07();
        AnonymousClass4X r1 = null;
        for (int i2 = 0; i2 < A072; i2++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i2));
            if (A0G2 != null && !A0G2.A0d()) {
                if (z) {
                    if (A0G2.A03 != i) {
                        continue;
                    }
                } else if (A0G2.A0J() != i) {
                    continue;
                }
                C01003d r7 = this.A01;
                View view = A0G2.A0H;
                String[] strArr = A19;
                if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A19;
                strArr2[6] = "j0pgcyCAMmCuelBFBaEKhw82BLWYdvOX";
                strArr2[4] = "bxiKg4TrHtXBSvyNTaSo7IOhyUGlGIW4";
                if (!r7.A0L(view)) {
                    return A0G2;
                }
                r1 = A0G2;
            }
        }
        return r1;
    }

    public final AnonymousClass4X A1I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return A0G(view);
        }
        throw new IllegalArgumentException(A0J(1826, 5, 56) + view + A0J(98, 26, 127) + this);
    }

    public final String A1J() {
        return A0J(0, 1, 65) + super.toString() + A0J(169, 10, 82) + this.A04 + A0J(189, 9, 71) + this.A06 + A0J(179, 10, 10) + getContext();
    }

    public final void A1K() {
        boolean z = this.A0D;
        String A0J2 = A0J(1313, 17, 94);
        if (!z || this.A0C) {
            AnonymousClass2H.A01(A0J2);
            A0a();
            AnonymousClass2H.A00();
        } else if (this.A00.A0K()) {
            if (this.A00.A0M(4)) {
                boolean A0M2 = this.A00.A0M(11);
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "e84NaKOnn7I9zpRn8aasqpcOMtbsg9mo";
                strArr[4] = "iuEMZhfSQYSf3gJ7Ya7A7FZe771rQXKi";
                if (!A0M2) {
                    AnonymousClass2H.A01(A0J(1341, 20, 82));
                    A1L();
                    A1M();
                    this.A00.A0I();
                    if (!this.A0J) {
                        if (A10()) {
                            A0a();
                        } else {
                            this.A00.A0G();
                        }
                    }
                    A1s(true);
                    A1N();
                    AnonymousClass2H.A00();
                    return;
                }
            }
            if (this.A00.A0K()) {
                AnonymousClass2H.A01(A0J2);
                A0a();
                AnonymousClass2H.A00();
            }
        }
    }

    public final void A1L() {
        this.A0O++;
        if (this.A0O == 1 && !this.A0I) {
            this.A0J = false;
        }
    }

    public final void A1M() {
        this.A0U++;
    }

    public final void A1N() {
        A1r(true);
    }

    public final void A1O() {
        if (!this.A0K && this.A0F) {
            AnonymousClass2u.A0C(this, this.A0k);
            this.A0K = true;
        }
    }

    public final void A1P() {
        AnonymousClass4B r0 = this.A05;
        if (r0 != null) {
            r0.A0C();
        }
        AnonymousClass4F r1 = this.A06;
        if (r1 != null) {
            r1.A1J(this.A0r);
            this.A06.A1H(this.A0r);
        }
        this.A0r.A0Q();
    }

    public final void A1Q() {
        int A062 = this.A01.A06();
        for (int i = 0; i < A062; i++) {
            View A0A2 = this.A01.A0A(i);
            AnonymousClass4X A1I2 = A1I(A0A2);
            if (!(A1I2 == null || A1I2.A07 == null)) {
                View view = A1I2.A07.A0H;
                int left = A0A2.getLeft();
                int top = A0A2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    int width = view.getWidth();
                    String[] strArr = A19;
                    if (strArr[2].length() != strArr[7].length()) {
                        String[] strArr2 = A19;
                        strArr2[3] = "Uubm7UlJXcXPQblsDCbwus";
                        strArr2[0] = "kvvVMTFBun";
                        view.layout(left, top, width + left, view.getHeight() + top);
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }

    public final void A1R() {
        this.A0C = true;
        A0j();
    }

    public final void A1S() {
        setScrollState(0);
        A0W();
    }

    public final void A1T(int i) {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            r0.A1u(i);
            awakenScrollBars();
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "0QEBPr";
            strArr[7] = "MYIDRbA0xlXg";
        }
    }

    public final void A1U(int i) {
        int A062 = this.A01.A06();
        for (int i2 = 0; i2 < A062; i2++) {
            this.A01.A0A(i2).offsetLeftAndRight(i);
        }
    }

    public final void A1V(int i) {
        int A062 = this.A01.A06();
        for (int i2 = 0; i2 < A062; i2++) {
            this.A01.A0A(i2).offsetTopAndBottom(i);
        }
    }

    public final void A1W(int i) {
        if (!this.A0I) {
            A1S();
            AnonymousClass4F r0 = this.A06;
            if (r0 == null) {
                String A0J2 = A0J(1370, 12, 79);
                String[] strArr = A19;
                if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A19;
                strArr2[6] = "bKq2dxkRCeugdKx9Xa6GvrcP2g1fh08B";
                strArr2[4] = "kU2aPHyT0THRQATybaGwdbwAtHBBu9qc";
                Log.e(A0J2, A0J(740, 94, 69));
                return;
            }
            r0.A1u(i);
            awakenScrollBars();
        }
    }

    public final void A1X(int i) {
        if (!this.A0I) {
            AnonymousClass4F r3 = this.A06;
            String[] strArr = A19;
            if (strArr[3].length() != strArr[0].length()) {
                String[] strArr2 = A19;
                strArr2[6] = "WdHf0lV4QkHUB6jMNa4hJVyYAF4qnaeC";
                strArr2[4] = "5gGhKJie0DBDDFfkhapEv4fZOrT4upMj";
                if (r3 == null) {
                    String[] strArr3 = A19;
                    if (strArr3[6].charAt(17) != strArr3[4].charAt(17)) {
                        String[] strArr4 = A19;
                        strArr4[6] = "tnW8WJDd0hyAXA7zkanproBVQy0r1bMC";
                        strArr4[4] = "4Fp0w8uFB0Hn5lDXLaIQvmhL07bdVyXH";
                        Log.e(A0J(1370, 10, 13), A0J(858, 46, 16));
                        return;
                    }
                    String[] strArr5 = A19;
                    strArr5[3] = "z3A7CLBHtBtrAEYqxn9jPo";
                    strArr5[0] = "loKczzo2gT";
                    Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
                    return;
                }
                r3.A22(this, this.A0s, i);
                return;
            }
            throw new RuntimeException();
        }
    }

    public final void A1Y(int i) {
        getScrollingChildHelper().A04(i);
    }

    public final void A1Z(int i, int i2) {
        if (i < 0) {
            A0d();
            this.A0a.onAbsorb(-i);
        } else if (i > 0) {
            A0e();
            this.A0b.onAbsorb(i);
        }
        if (i2 < 0) {
            A0f();
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[1] = "gyhAwDIMjNJoK3bJ2ki6wxmL7XFPannX";
            strArr[1] = "gyhAwDIMjNJoK3bJ2ki6wxmL7XFPannX";
            this.A0c.onAbsorb(-i2);
        } else if (i2 > 0) {
            A0c();
            this.A0Z.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            AnonymousClass2u.A07(this);
        }
    }

    public final void A1a(int i, int i2) {
        boolean z = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.A0a.onRelease();
            z = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0b;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.A0b.onRelease();
            z |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0c;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            EdgeEffect edgeEffect4 = this.A0c;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "CkvbraPTkuNHVjG6c5toq1";
            strArr[0] = "anwNoWvWLV";
            edgeEffect4.onRelease();
            z |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect5 = this.A0Z;
        if (edgeEffect5 != null && !edgeEffect5.isFinished() && i2 < 0) {
            this.A0Z.onRelease();
            z |= this.A0Z.isFinished();
        }
        if (z) {
            AnonymousClass2u.A07(this);
        }
    }

    public final void A1b(int i, int i2) {
        setMeasuredDimension(AnonymousClass4F.A00(i, getPaddingLeft() + getPaddingRight(), AnonymousClass2u.A03(this)), AnonymousClass4F.A00(i2, getPaddingTop() + getPaddingBottom(), AnonymousClass2u.A02(this)));
    }

    public final void A1c(int scrollY, int i) {
        this.A0N++;
        int scrollX = getScrollX();
        int scrollY2 = getScrollY();
        onScrollChanged(scrollX, scrollY2, scrollX, scrollY2);
        AnonymousClass4K r0 = this.A0i;
        if (r0 != null) {
            r0.A0W(this, scrollY, i);
        }
        List<AnonymousClass4K> list = this.A0m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A0m.get(size).A0W(this, scrollY, i);
            }
        }
        this.A0N--;
    }

    public final void A1d(int i, int i2) {
        int A072 = this.A01.A07();
        for (int i3 = 0; i3 < A072; i3++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i3));
            if (A0G2 != null && !A0G2.A0i()) {
                int i4 = A0G2.A03;
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[1] = "WfIl2QLxhpsV1cZ5bwDa0wyCBTSIuEWm";
                strArr[1] = "WfIl2QLxhpsV1cZ5bwDa0wyCBTSIuEWm";
                if (i4 >= i) {
                    A0G2.A0X(i2, false);
                    this.A0s.A0D = true;
                }
            }
        }
        this.A0r.A0S(i, i2);
        requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (r10 == r12) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        if (r10 == r12) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        r9.A0X(r4, false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A1e(int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.A1e(int, int):void");
    }

    public final void A1f(int i, int i2) {
        A0n(i, i2, null);
    }

    public final void A1g(int positionEnd, int i, Object obj) {
        int A072 = this.A01.A07();
        int i2 = positionEnd + i;
        for (int i3 = 0; i3 < A072; i3++) {
            View A0B2 = this.A01.A0B(i3);
            AnonymousClass4X A0G2 = A0G(A0B2);
            if (A0G2 != null && !A0G2.A0i()) {
                int i4 = A0G2.A03;
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[2] = "87XYbE";
                strArr[7] = "GV1T0vfadOcw";
                if (i4 >= positionEnd && A0G2.A03 < i2) {
                    A0G2.A0U(2);
                    A0G2.A0Z(obj);
                    ((AnonymousClass4G) A0B2.getLayoutParams()).A01 = true;
                }
            }
        }
        this.A0r.A0U(positionEnd, i);
    }

    public final void A1h(int childCount, int i, boolean z) {
        int i2 = childCount + i;
        int A072 = this.A01.A07();
        for (int i3 = 0; i3 < A072; i3++) {
            AnonymousClass4X A0G2 = A0G(this.A01.A0B(i3));
            if (A0G2 != null && !A0G2.A0i()) {
                if (A0G2.A03 >= i2) {
                    A0G2.A0X(-i, z);
                    this.A0s.A0D = true;
                } else if (A0G2.A03 >= childCount) {
                    A0G2.A0W(childCount - 1, -i, z);
                    if (A19[1].length() != 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A19;
                    strArr[2] = "dcjb0S";
                    strArr[7] = "CcIDXd599Ygw";
                    this.A0s.A0D = true;
                } else {
                    continue;
                }
            }
        }
        this.A0r.A0V(childCount, i, z);
        requestLayout();
    }

    public final void A1i(View view) {
        int i;
        A0G(view);
        AnonymousClass43 r0 = this.A04;
        List<RecyclerView.OnChildAttachStateChangeListener> list = this.A0l;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[5] = "qDYnzfveQxKkK3O0opuqDthRtcgsED9a";
        strArr[5] = "qDYnzfveQxKkK3O0opuqDthRtcgsED9a";
        if (list != null && list.size() - 1 >= 0) {
            this.A0l.get(i);
            throw null;
        }
    }

    public final void A1j(View view) {
        int i;
        A0G(view);
        AnonymousClass43 r0 = this.A04;
        List<RecyclerView.OnChildAttachStateChangeListener> list = this.A0l;
        if (list != null && list.size() - 1 >= 0) {
            this.A0l.get(i);
            throw null;
        }
    }

    public final void A1k(AnonymousClass4K r2) {
        if (this.A0m == null) {
            this.A0m = new ArrayList();
        }
        this.A0m.add(r2);
    }

    public final void A1l(AnonymousClass4K r2) {
        List<AnonymousClass4K> list = this.A0m;
        if (list != null) {
            list.remove(r2);
        }
    }

    public final void A1m(AnonymousClass4U r4) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A08.A01;
            r4.A06 = overScroller.getFinalX() - overScroller.getCurrX();
            r4.A07 = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        r4.A06 = 0;
        r4.A07 = 0;
    }

    public final void A1n(AnonymousClass4X r4, AnonymousClass4A r5) {
        r4.A0V(0, 8192);
        if (this.A0s.A0E && r4.A0g() && !r4.A0d() && !r4.A0i()) {
            this.A0t.A09(A0C(r4), r4);
        }
        this.A0t.A0G(r4, r5);
    }

    public final void A1o(AnonymousClass4X r2, AnonymousClass4A r3, AnonymousClass4A r4) {
        r2.A0a(false);
        if (this.A05.A0I(r2, r3, r4)) {
            A1O();
        }
    }

    public final void A1p(AnonymousClass4X r2, AnonymousClass4A r3, AnonymousClass4A r4) {
        A0t(r2);
        r2.A0a(false);
        if (this.A05.A0J(r2, r3, r4)) {
            A1O();
        }
    }

    public final void A1q(String str) {
        if (A1v()) {
            if (str == null) {
                throw new IllegalStateException(A0J(574, 77, 49) + A1J());
            }
            throw new IllegalStateException(str);
        } else if (this.A0N > 0) {
            Log.w(A0J(1370, 12, 79), A0J(294, 280, 24), new IllegalStateException(A0J(0, 0, 62) + A1J()));
        }
    }

    public final void A1r(boolean z) {
        this.A0U--;
        if (this.A0U < 1) {
            this.A0U = 0;
            if (z) {
                A0L();
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "clcdgLago0QzUCUQna9RqUvMnx3zufId";
                strArr[4] = "dGTmnJIudyc2xKqsUaVYnInX4VXDIHXZ";
                A0b();
            }
        }
    }

    public final void A1s(boolean z) {
        if (this.A0O < 1) {
            this.A0O = 1;
        }
        if (!z) {
            this.A0J = false;
        }
        if (this.A0O == 1) {
            if (z && this.A0J && !this.A0I && this.A06 != null && this.A04 != null) {
                A0a();
            }
            if (!this.A0I) {
                this.A0J = false;
            }
        }
        this.A0O--;
    }

    public final boolean A1t() {
        AccessibilityManager accessibilityManager = this.A10;
        if (accessibilityManager != null) {
            boolean isEnabled = accessibilityManager.isEnabled();
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[5] = "qqYNnQooq1iBe19qNxONRBmcR9jcXf5d";
            strArr2[5] = "qqYNnQooq1iBe19qNxONRBmcR9jcXf5d";
            if (isEnabled) {
                return true;
            }
        }
        return false;
    }

    public final boolean A1u() {
        return !this.A0D || this.A0C || this.A00.A0K();
    }

    public final boolean A1v() {
        return this.A0U > 0;
    }

    public final boolean A1w(int i) {
        return getScrollingChildHelper().A0A(i);
    }

    public final boolean A1x(int i, int i2) {
        return getScrollingChildHelper().A0C(i, i2);
    }

    public final boolean A1y(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().A0E(i, i2, i3, i4, iArr, i5);
    }

    public final boolean A1z(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().A0G(i, i2, iArr, iArr2, i3);
    }

    public final boolean A20(View view) {
        A1L();
        boolean A0M2 = this.A01.A0M(view);
        if (A0M2) {
            AnonymousClass4X A0G2 = A0G(view);
            this.A0r.A0d(A0G2);
            this.A0r.A0c(A0G2);
        }
        A1s(!A0M2);
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[3] = "2BT72D7B0XXfHPWJs3DbS8";
        strArr[0] = "RgGvPpmRJD";
        return A0M2;
    }

    public final boolean A21(AnonymousClass4X r3) {
        AnonymousClass4B r1 = this.A05;
        return r1 == null || r1.A0G(r3, r3.A0M());
    }

    public final boolean A22(AnonymousClass4X r2, int i) {
        if (A1v()) {
            r2.A02 = i;
            this.A0w.add(r2);
            return false;
        }
        AnonymousClass2u.A09(r2.A0H, i);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            boolean A1h = r0.A1h(this, arrayList, i, i2);
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "qzNrCd";
            strArr[7] = "bMAkXN6Kp1Dd";
            if (A1h) {
                return;
            }
        }
        super.addFocusables(arrayList, i, i2);
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof AnonymousClass4G) && this.A06.A1d((AnonymousClass4G) layoutParams);
    }

    public final int computeHorizontalScrollExtent() {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null && r0.A25()) {
            return this.A06.A1k(this.A0s);
        }
        return 0;
    }

    public final int computeHorizontalScrollOffset() {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null && r0.A25()) {
            return this.A06.A1l(this.A0s);
        }
        return 0;
    }

    public final int computeHorizontalScrollRange() {
        AnonymousClass4F r0 = this.A06;
        if (r0 == null) {
            return 0;
        }
        boolean A25 = r0.A25();
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[1] = "GzwOa56ahdwGOmec9vc3XIggLcxaXOnz";
        strArr[1] = "GzwOa56ahdwGOmec9vc3XIggLcxaXOnz";
        if (A25) {
            return this.A06.A1m(this.A0s);
        }
        return 0;
    }

    public final int computeVerticalScrollExtent() {
        AnonymousClass4F r0 = this.A06;
        if (r0 == null) {
            return 0;
        }
        boolean A26 = r0.A26();
        String[] strArr = A19;
        if (strArr[3].length() != strArr[0].length()) {
            String[] strArr2 = A19;
            strArr2[2] = "Wsbuah";
            strArr2[7] = "lDl9g1VSjrmk";
            if (!A26) {
                return 0;
            }
            AnonymousClass4F r3 = this.A06;
            String[] strArr3 = A19;
            if (strArr3[3].length() != strArr3[0].length()) {
                String[] strArr4 = A19;
                strArr4[5] = "sfYwg45p3roym5legx720iFNlg07mmUN";
                strArr4[5] = "sfYwg45p3roym5legx720iFNlg07mmUN";
                return r3.A1n(this.A0s);
            }
        }
        throw new RuntimeException();
    }

    public final int computeVerticalScrollOffset() {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null && r0.A26()) {
            return this.A06.A1o(this.A0s);
        }
        return 0;
    }

    public final int computeVerticalScrollRange() {
        AnonymousClass4F r0 = this.A06;
        if (r0 == null || !r0.A26()) {
            return 0;
        }
        AnonymousClass4F r3 = this.A06;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[6] = "NPPquBudgt65Kfhzva46C14iIBYgw5ng";
        strArr[4] = "gzaMlk0wrsXS1BjbnaI8sjsGlzE0u55w";
        return r3.A1p(this.A0s);
    }

    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().A09(f, f2, z);
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().A08(f, f2);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().A0F(i, i2, iArr, iArr2);
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().A0D(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012b, code lost:
        if (r3.A0F() != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0144, code lost:
        if (r3.A0F() != false) goto L_0x012d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r8) {
        /*
        // Method dump skipped, instructions count: 366
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.draw(android.graphics.Canvas):void");
    }

    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* JADX INFO: Multiple debug info for r5v0 android.view.FocusFinder: [D('rtl' boolean), D('absDir' int)] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View focusSearch(android.view.View r9, int r10) {
        /*
        // Method dump skipped, instructions count: 259
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.focusSearch(android.view.View, int):android.view.View");
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            return r0.A1t();
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AnonymousClass4F r1 = this.A06;
        if (r1 != null) {
            return r1.A0w(getContext(), attributeSet);
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            AnonymousClass4G A0x2 = r0.A0x(layoutParams);
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "4uZ9QAUZcjEo06EXHPHPN1";
            strArr[0] = "ePNmh1lbEA";
            return A0x2;
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    public AnonymousClass43 getAdapter() {
        return this.A04;
    }

    public int getBaseline() {
        AnonymousClass4F r0 = this.A06;
        if (r0 == null) {
            return super.getBaseline();
        }
        int A0W2 = r0.A0W();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[1] = "WUntfQVcja1qFzj09nDprclvV6sI7lKs";
        strArr[1] = "WUntfQVcja1qFzj09nDprclvV6sI7lKs";
        return A0W2;
    }

    public final int getChildDrawingOrder(int i, int i2) {
        AnonymousClass46 r0 = this.A0e;
        if (r0 == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return r0.onGetChildDrawingOrder(i, i2);
    }

    public boolean getClipToPadding() {
        return this.A0B;
    }

    public C0719Sk getCompatAccessibilityDelegate() {
        return this.A09;
    }

    public AnonymousClass4B getItemAnimator() {
        return this.A05;
    }

    public AnonymousClass4F getLayoutManager() {
        return this.A06;
    }

    public int getMaxFlingVelocity() {
        return this.A0x;
    }

    public int getMinFlingVelocity() {
        return this.A0y;
    }

    public long getNanoTime() {
        if (A1E) {
            return System.nanoTime();
        }
        return 0;
    }

    public AnonymousClass4I getOnFlingListener() {
        return this.A0g;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.A0o;
    }

    public AnonymousClass4M getRecycledViewPool() {
        return this.A0r.A0I();
    }

    public int getScrollState() {
        return this.A0W;
    }

    private C00752c getScrollingChildHelper() {
        if (this.A0d == null) {
            this.A0d = new C00752c(this);
        }
        return this.A0d;
    }

    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().A06();
    }

    public final boolean isAttachedToWindow() {
        return this.A0F;
    }

    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().A07();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0U = 0;
        boolean z = true;
        this.A0F = true;
        if (!this.A0D || isLayoutRequested()) {
            z = false;
        }
        this.A0D = z;
        AnonymousClass4F r0 = this.A06;
        if (r0 != null) {
            r0.A1O(this);
        }
        this.A0K = false;
        if (A1E) {
            this.A03 = RunnableC01133q.A07.get();
            if (this.A03 == null) {
                this.A03 = new RunnableC01133q();
                Display A042 = AnonymousClass2u.A04(this);
                float f = 60.0f;
                if (!isInEditMode() && A042 != null) {
                    float refreshRate = A042.getRefreshRate();
                    String[] strArr = A19;
                    if (strArr[2].length() != strArr[7].length()) {
                        String[] strArr2 = A19;
                        strArr2[3] = "HPKMSTrO6rgllPECADdom7";
                        strArr2[0] = "yPSN9KqlOS";
                        if (refreshRate >= 30.0f) {
                            f = refreshRate;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
                this.A03.A00 = (long) (1.0E9f / f);
                RunnableC01133q.A07.set(this.A03);
            }
            this.A03.A0A(this);
        }
    }

    public final void onDetachedFromWindow() {
        RunnableC01133q r0;
        super.onDetachedFromWindow();
        AnonymousClass4B r02 = this.A05;
        if (r02 != null) {
            r02.A0C();
        }
        A1S();
        this.A0F = false;
        AnonymousClass4F r1 = this.A06;
        if (r1 != null) {
            r1.A1V(this, this.A0r);
        }
        this.A0w.clear();
        removeCallbacks(this.A0k);
        this.A0t.A08();
        if (A1E && (r0 = this.A03) != null) {
            r0.A0B(this);
            this.A03 = null;
        }
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.A0v.size();
        for (int i = 0; i < size; i++) {
            this.A0v.get(i);
        }
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.ES: [D('axisScroll' float), D('vScroll' float)] */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        if ((r4 & 4194304) != 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a5, code lost:
        if ((r4 & 4194304) != 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        r0 = 0.0f;
        r1 = 0.0f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.A0I) {
            return false;
        }
        if (A17(motionEvent)) {
            A0K();
            return true;
        }
        AnonymousClass4F r0 = this.A06;
        if (r0 == null) {
            return false;
        }
        boolean A25 = r0.A25();
        boolean A26 = this.A06.A26();
        if (this.A0Y == null) {
            this.A0Y = VelocityTracker.obtain();
        }
        this.A0Y.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        String[] strArr = A19;
        if (strArr[2].length() != strArr[7].length()) {
            String[] strArr2 = A19;
            strArr2[3] = "Oz3Y31ex0QABqFtFM6aXix";
            strArr2[0] = "OpGO9pAa6R";
            if (actionMasked == 0) {
                if (this.A0n) {
                    this.A0n = false;
                }
                this.A0V = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.A0S = x;
                this.A0Q = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.A0T = y;
                this.A0R = y;
                if (this.A0W == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.A15;
                iArr[1] = 0;
                iArr[0] = 0;
                int nestedScrollAxis = 0;
                if (A25) {
                    nestedScrollAxis = 0 | 1;
                }
                if (A26) {
                    nestedScrollAxis |= 2;
                }
                A1x(nestedScrollAxis, 0);
            } else if (actionMasked == 1) {
                this.A0Y.clear();
                A1Y(0);
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.A0V);
                if (findPointerIndex < 0) {
                    Log.e(A0J(1370, 12, 79), A0J(1063, 46, 50) + this.A0V + A0J(124, 45, 46));
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.A0W != 1) {
                    int i = x2 - this.A0Q;
                    int i2 = y2 - this.A0R;
                    boolean z = false;
                    if (A25 && Math.abs(i) > this.A0X) {
                        this.A0S = x2;
                        z = true;
                    }
                    if (A26 && Math.abs(i2) > this.A0X) {
                        this.A0T = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
            } else if (actionMasked == 3) {
                A0K();
            } else if (actionMasked == 5) {
                this.A0V = motionEvent.getPointerId(actionIndex);
                int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.A0S = x3;
                this.A0Q = x3;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.A0T = y3;
                this.A0R = y3;
            } else if (actionMasked == 6) {
                A0p(motionEvent);
            }
            if (this.A0W == 1) {
                return true;
            }
            return false;
        }
        throw new RuntimeException();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AnonymousClass2H.A01(A0J(1330, 11, 86));
        A0a();
        AnonymousClass2H.A00();
        this.A0D = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r3 != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r3 != false) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
        // Method dump skipped, instructions count: 300
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ES.onMeasure(int, int):void");
    }

    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (A1v()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof RecyclerView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.A0j = (RecyclerView$SavedState) parcelable;
        super.onRestoreInstanceState(this.A0j.A02());
        if (this.A06 != null && this.A0j.A00 != null) {
            this.A06.A1x(this.A0j.A00);
        }
    }

    public final Parcelable onSaveInstanceState() {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(super.onSaveInstanceState());
        RecyclerView$SavedState recyclerView$SavedState2 = this.A0j;
        if (recyclerView$SavedState2 != null) {
            recyclerView$SavedState.A03(recyclerView$SavedState2);
        } else {
            AnonymousClass4F r0 = this.A06;
            if (r0 != null) {
                recyclerView$SavedState.A00 = r0.A1q();
            } else {
                recyclerView$SavedState.A00 = null;
            }
        }
        return recyclerView$SavedState;
    }

    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            A0h();
        }
    }

    /* JADX INFO: Multiple debug info for r7v6 int: [D('y' int), D('dy' int)] */
    /* JADX INFO: Multiple debug info for r1v19 int[]: [D('dy' int), D('index' int)] */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float xvel;
        float f;
        int x;
        int x2;
        int x3;
        int i = 0;
        if (this.A0I || this.A0n) {
            return false;
        }
        boolean A162 = A16(motionEvent);
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[5] = "8sYT0RnpvG2arPES2UJ12JYFoUL9IQDo";
        strArr[5] = "8sYT0RnpvG2arPES2UJ12JYFoUL9IQDo";
        if (A162) {
            A0K();
            return true;
        }
        AnonymousClass4F r0 = this.A06;
        if (r0 == null) {
            return false;
        }
        boolean A25 = r0.A25();
        boolean A26 = this.A06.A26();
        if (this.A0Y == null) {
            this.A0Y = VelocityTracker.obtain();
        }
        boolean z = false;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.A15;
            iArr[1] = 0;
            String[] strArr2 = A19;
            if (strArr2[2].length() != strArr2[7].length()) {
                String[] strArr3 = A19;
                strArr3[5] = "w9Y7A1oKaVmj8Ov6eZqRiF6tVMdmRve8";
                strArr3[5] = "w9Y7A1oKaVmj8Ov6eZqRiF6tVMdmRve8";
                iArr[0] = 0;
            } else {
                String[] strArr4 = A19;
                strArr4[6] = "DE62WFMw5Qbi4eBk1auhfUxeLGhnsE7e";
                strArr4[4] = "A6rUAAhMCRWi1Exz9agrYLVLW1oNRabf";
                iArr[0] = 0;
            }
        }
        int[] iArr2 = this.A15;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.A0V = motionEvent.getPointerId(0);
            int x4 = (int) (motionEvent.getX() + 0.5f);
            this.A0S = x4;
            this.A0Q = x4;
            int x5 = (int) (motionEvent.getY() + 0.5f);
            this.A0T = x5;
            this.A0R = x5;
            int x6 = 0;
            if (A25) {
                x6 = 0 | 1;
            }
            if (A26) {
                x6 |= 2;
            }
            A1x(x6, 0);
        } else if (actionMasked == 1) {
            this.A0Y.addMovement(obtain);
            z = true;
            this.A0Y.computeCurrentVelocity(1000, (float) this.A0x);
            if (A25) {
                VelocityTracker velocityTracker = this.A0Y;
                int dy = this.A0V;
                String[] strArr5 = A19;
                if (strArr5[2].length() != strArr5[7].length()) {
                    String[] strArr6 = A19;
                    strArr6[5] = "cvYQb2BcK3cjm46xX51a5wS3GdK3mOIc";
                    strArr6[5] = "cvYQb2BcK3cjm46xX51a5wS3GdK3mOIc";
                    xvel = -velocityTracker.getXVelocity(dy);
                } else {
                    String[] strArr7 = A19;
                    strArr7[2] = "HePLvk";
                    strArr7[7] = "sISGhSA4Sc4c";
                    xvel = -velocityTracker.getXVelocity(dy);
                }
            } else {
                xvel = 0.0f;
            }
            if (A26) {
                VelocityTracker velocityTracker2 = this.A0Y;
                int i2 = this.A0V;
                String[] strArr8 = A19;
                if (strArr8[6].charAt(17) != strArr8[4].charAt(17)) {
                    f = -velocityTracker2.getYVelocity(i2);
                } else {
                    String[] strArr9 = A19;
                    strArr9[5] = "lUYbAzGh0vj4LSfow0o2VnAou7QhBgLk";
                    strArr9[5] = "lUYbAzGh0vj4LSfow0o2VnAou7QhBgLk";
                    f = -velocityTracker2.getYVelocity(i2);
                }
            } else {
                f = 0.0f;
            }
            if ((xvel == 0.0f && f == 0.0f) || !A14((int) xvel, (int) f)) {
                setScrollState(0);
            }
            A0U();
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.A0V);
            if (findPointerIndex < 0) {
                Log.e(A0J(1370, 12, 79), A0J(1063, 46, 50) + this.A0V + A0J(124, 45, 46));
                return false;
            }
            int x7 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int dy2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i3 = this.A0S - x7;
            int dx = this.A0T - dy2;
            if (A1z(i3, dx, this.A16, this.A17, 0)) {
                int[] iArr3 = this.A16;
                i3 -= iArr3[0];
                dx -= iArr3[1];
                int[] iArr4 = this.A17;
                obtain.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                int[] iArr5 = this.A15;
                int index = iArr5[0];
                int[] iArr6 = this.A17;
                iArr5[0] = index + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.A0W != 1) {
                boolean z2 = false;
                if (A25 && Math.abs(i3) > (x3 = this.A0X)) {
                    if (i3 > 0) {
                        i3 -= x3;
                    } else {
                        i3 += x3;
                    }
                    z2 = true;
                }
                if (A26 && Math.abs(dx) > (x2 = this.A0X)) {
                    if (dx > 0) {
                        dx -= x2;
                    } else {
                        dx += x2;
                    }
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
            if (this.A0W == 1) {
                int[] iArr7 = this.A17;
                this.A0S = x7 - iArr7[0];
                this.A0T = dy2 - iArr7[1];
                if (A25) {
                    x = i3;
                } else {
                    x = 0;
                }
                if (A26) {
                    i = dx;
                }
                if (A15(x, i, obtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.A03 == null || (i3 == 0 && dx == 0))) {
                    this.A03.A0C(this, i3, dx);
                }
            }
        } else if (actionMasked == 3) {
            A0K();
        } else if (actionMasked == 5) {
            this.A0V = motionEvent.getPointerId(actionIndex);
            int actionIndex2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.A0S = actionIndex2;
            this.A0Q = actionIndex2;
            int actionIndex3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.A0T = actionIndex3;
            this.A0R = actionIndex3;
        } else if (actionMasked == 6) {
            A0p(motionEvent);
        }
        if (!z) {
            this.A0Y.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public final void removeDetachedView(View view, boolean z) {
        AnonymousClass4X A0G2 = A0G(view);
        if (A0G2 != null) {
            if (A0G2.A0f()) {
                A0G2.A0Q();
            } else if (!A0G2.A0i()) {
                throw new IllegalArgumentException(A0J(219, 75, 37) + A0G2 + A1J());
            }
        }
        view.clearAnimation();
        A1j(view);
        super.removeDetachedView(view, z);
    }

    public final void requestChildFocus(View view, View view2) {
        if (!this.A06.A1g(this, this.A0s, view, view2) && view2 != null) {
            A0r(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.A06.A1e(this, view, rect, z);
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.A13.size();
        for (int i = 0; i < size; i++) {
            this.A13.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public final void requestLayout() {
        if (this.A0O != 0 || this.A0I) {
            this.A0J = true;
        } else {
            super.requestLayout();
        }
    }

    public final void scrollBy(int i, int i2) {
        AnonymousClass4F r1 = this.A06;
        if (r1 == null) {
            Log.e(A0J(1370, 12, 79), A0J(834, 90, 71));
        } else if (!this.A0I) {
            boolean A25 = r1.A25();
            boolean A26 = this.A06.A26();
            if (A25 || A26) {
                int i3 = 0;
                if (!A25) {
                    i = 0;
                }
                if (A26) {
                    i3 = i2;
                }
                A15(i, i3, null);
            }
        }
    }

    public final void scrollTo(int i, int i2) {
        Log.w(A0J(1370, 12, 79), A0J(1382, 93, 90));
    }

    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!A1A(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(C0719Sk sk) {
        this.A09 = sk;
        AnonymousClass2u.A0A(this, this.A09);
    }

    public void setAdapter(AnonymousClass43 r3) {
        setLayoutFrozen(false);
        A0s(r3, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(AnonymousClass46 r2) {
        boolean z;
        if (r2 != this.A0e) {
            this.A0e = r2;
            if (this.A0e != null) {
                z = true;
            } else {
                z = false;
            }
            setChildrenDrawingOrderEnabled(z);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.A0B) {
            A0h();
        }
        this.A0B = z;
        super.setClipToPadding(z);
        if (this.A0D) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.A0E = z;
    }

    public void setItemAnimator(AnonymousClass4B r6) {
        AnonymousClass4B r0 = this.A05;
        if (r0 != null) {
            r0.A0C();
            this.A05.A0A(null);
        }
        this.A05 = r6;
        AnonymousClass4B r4 = this.A05;
        if (r4 != null) {
            AnonymousClass49 r3 = this.A0f;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "lbql160khUomfa8gG92Y7q";
            strArr[0] = "AtGY6u7EZb";
            r4.A0A(r3);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.A0r.A0R(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.A0I) {
            A1q(A0J(1021, 42, 85));
            if (!z) {
                this.A0I = false;
                if (!(!this.A0J || this.A06 == null || this.A04 == null)) {
                    requestLayout();
                }
                this.A0J = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.A0I = true;
            this.A0n = true;
            A1S();
        }
    }

    public void setLayoutManager(AnonymousClass4F r6) {
        if (r6 != this.A06) {
            A1S();
            if (this.A06 != null) {
                AnonymousClass4B r0 = this.A05;
                if (r0 != null) {
                    r0.A0C();
                }
                this.A06.A1J(this.A0r);
                this.A06.A1H(this.A0r);
                this.A0r.A0Q();
                if (this.A0F) {
                    this.A06.A1V(this, this.A0r);
                }
                this.A06.A1Q(null);
                this.A06 = null;
            } else {
                this.A0r.A0Q();
            }
            this.A01.A0C();
            this.A06 = r6;
            if (r6 != null) {
                ES es = r6.A03;
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "5zwSvF43vthb6lIFeaOoDRJ244Dq07FI";
                strArr[4] = "COyIsU8he0MLuT7wFa9x9SZ5A7LzgdfA";
                if (es == null) {
                    this.A06.A1Q(this);
                    if (this.A0F) {
                        this.A06.A1O(this);
                    }
                } else {
                    throw new IllegalArgumentException(A0J(1109, 14, 88) + r6 + A0J(59, 39, 9) + r6.A03.A1J());
                }
            }
            this.A0r.A0P();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().A05(z);
    }

    public void setOnFlingListener(AnonymousClass4I r1) {
        this.A0g = r1;
    }

    public void setOnScrollListener(AnonymousClass4K r1) {
        this.A0i = r1;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.A0o = z;
    }

    public void setRecycledViewPool(AnonymousClass4M r2) {
        this.A0r.A0a(r2);
    }

    public void setRecyclerListener(AnonymousClass4O r1) {
        this.A07 = r1;
    }

    public void setScrollState(int i) {
        if (i != this.A0W) {
            this.A0W = i;
            if (i != 2) {
                A0W();
            }
            A0m(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(A0J(1370, 12, 79), A0J(1881, 47, 18) + i + A0J(198, 21, 121));
            } else {
                this.A0X = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.A0X = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AnonymousClass4V r2) {
        this.A0r.A0b(r2);
    }

    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().A0B(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00742b
    public final void stopNestedScroll() {
        getScrollingChildHelper().A03();
    }
}
