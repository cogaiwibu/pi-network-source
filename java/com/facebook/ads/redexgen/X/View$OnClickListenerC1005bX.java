package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.bX  reason: case insensitive filesystem */
public class View$OnClickListenerC1005bX implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, AnonymousClass8F {
    public static byte[] A02;
    public final C0820Wh A00;
    public final /* synthetic */ C1007bZ A01;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{43, 14, 74, 9, 11, 4, 4, 5, 30, 74, 8, 15, 74, 9, 6, 3, 9, 1, 15, 14, 74, 8, 15, 12, 5, 24, 15, 74, 3, 30, 74, 3, 25, 74, 28, 3, 15, 29, 15, 14, 68, 66, 109, 104, 98, 106, 114, 33, 105, 96, 113, 113, 100, 111, 100, 101, 33, 117, 110, 110, 33, 103, 96, 114, 117, 47, 20, 16, 19, 39, 54, 59, 55, 60, 49, 55, 28, 55, 38, 37, 61, 32, 57, 56, 25, 86, 2, 25, 3, 21, 30, 86, 18, 23, 2, 23, 86, 4, 19, 21, 25, 4, 18, 19, 18, 90, 86, 6, 26, 19, 23, 5, 19, 86, 19, 24, 5, 3, 4, 19, 86, 2, 25, 3, 21, 30, 86, 19, 0, 19, 24, 2, 5, 86, 4, 19, 23, 21, 30, 86, 2, 30, 19, 86, 23, 18, 86, 32, 31, 19, 1, 86, 20, 15, 86, 4, 19, 2, 3, 4, 24, 31, 24, 17, 86, 16, 23, 26, 5, 19, 86, 31, 16, 86, 15, 25, 3, 86, 31, 24, 2, 19, 4, 21, 19, 6, 2, 86, 2, 30, 19, 86, 19, 0, 19, 24, 2, 88, 33, 39, 60, 94, 68, 89};
    }

    public View$OnClickListenerC1005bX(C1007bZ bZVar, C0820Wh wh) {
        this.A01 = bZVar;
        this.A00 = wh;
    }

    public /* synthetic */ View$OnClickListenerC1005bX(C1007bZ bZVar, C0820Wh wh, C0999bQ bQVar) {
        this(bZVar, wh);
    }

    /* access modifiers changed from: private */
    public Map<String, String> A01() {
        Map<String, String> A06 = new NU().A04(this.A01.A0N).A03(this.A01.A0b).A06();
        if (this.A01.A0H != null) {
            A06.put(A00(201, 3, 11), String.valueOf(this.A01.A0H.A04()));
        }
        if (this.A01.A0S) {
            A06.put(A00(198, 3, 116), String.valueOf(this.A01.A0S));
        }
        return A06;
    }

    /* access modifiers changed from: private */
    public void A05(Map<String, String> map) {
        if (this.A01.A0W != null) {
            this.A01.A0W.A0Z(map);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8F
    public final C0820Wh A5G() {
        return this.A00;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                boolean A09 = this.A01.A0b.A09();
                String A002 = A00(66, 17, 105);
                if (!A09) {
                    Log.e(A002, A00(83, 115, 77));
                }
                int A0E = J8.A0E(this.A01.A0Y);
                if (A0E < 0 || this.A01.A0b.A04() >= ((long) A0E)) {
                    if (this.A01.A0b.A0A(this.A01.A0Y)) {
                        if (this.A01.A0W != null) {
                            this.A01.A0W.A0a(A01());
                        }
                    } else if (J8.A0z(this.A01.A0Y)) {
                        if (this.A01.A0W != null) {
                            this.A01.A0W.A0d(A01());
                        }
                        L9.A00(new JW(this), new JX(this), C0525Ks.A00());
                    } else {
                        A05(A01());
                    }
                } else if (!this.A01.A0b.A08()) {
                    Log.e(A002, A00(0, 41, 81));
                } else {
                    Log.e(A002, A00(41, 25, 58));
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }

    public final boolean onLongClick(View view) {
        if (this.A01.A03 == null || this.A01.A0K == null) {
            return false;
        }
        this.A01.A0K.setBounds(0, 0, this.A01.A03.getWidth(), this.A01.A03.getHeight());
        this.A01.A0K.A0E(!this.A01.A0K.A0F());
        return true;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A01.A0b.A07(motionEvent, this.A01.A03, view);
        return this.A01.A02 != null && this.A01.A02.onTouch(view, motionEvent);
    }
}
