package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;

/* renamed from: com.facebook.ads.redexgen.X.6P  reason: invalid class name */
public final class AnonymousClass6P {
    public static String[] A03;
    public final Context A00;
    public final AnonymousClass6J A01;
    public final EnumC01856m A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"COmePc5O6jQNBThxNrU00eLA0sP62Ofb", "1OlTUJms59QGnZv6uedBszpwZ8CEYVJ", "oD0bBsFyrWHU6", "C7a4pm2tyO8SrXv1cdlxK2sPFdgwB5ae", "g8qGNC4JJd68o", "wdv0nL8gPgDp5YXIgWNDO16SJnt", "h7h0bvqqYit4L8HKMEE", "ho5Id5lQMxy9uaRyjuF"};
    }

    public AnonymousClass6P(Context context, AnonymousClass6J r2, EnumC01856m r3) {
        this.A01 = r2;
        this.A00 = context;
        this.A02 = r3;
    }

    /* JADX INFO: Multiple debug info for r0v8 com.facebook.ads.redexgen.X.6v: [D('actionIndex' int), D('toolTypeMove' int)] */
    /* JADX INFO: Multiple debug info for r5v2 int: [D('pointerId' int), D('touchSignalValueType' com.facebook.ads.redexgen.X.Wb)] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void A01(MotionEvent motionEvent) {
        String packageName;
        C01946v r0;
        int i;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Context context = this.A00;
        if (context == null) {
            packageName = "";
        } else {
            packageName = context.getPackageName();
        }
        EnumC01856m r6 = this.A02;
        EnumC01856m r4 = EnumC01856m.A0G;
        if (A03[7].length() != 16) {
            String[] strArr = A03;
            strArr[6] = "q52vtyV4o3lWIqbyVHb";
            strArr[6] = "q52vtyV4o3lWIqbyVHb";
            if (r6 == r4) {
                r0 = null;
            } else {
                r0 = new C01946v(packageName);
            }
            float f = 1.0f;
            char c = 1;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 1:
                case 3:
                case 5:
                case 6:
                    int pointerId = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(pointerId);
                    if (Build.VERSION.SDK_INT >= 14) {
                        i = motionEvent.getToolType(pointerId);
                    } else {
                        i = -1;
                    }
                    this.A01.A02(new C0814Wb(elapsedRealtime, r0, new AnonymousClass6T(motionEvent.getActionMasked(), pointerId2, i, new float[]{motionEvent.getRawX(), motionEvent.getRawY()}, motionEvent.getSize(pointerId), Math.min(motionEvent.getPressure(pointerId), 1.0f), motionEvent.getOrientation(pointerId))), AnonymousClass6I.A0E);
                    return;
                case 2:
                case 4:
                    int i3 = 0;
                    while (i3 < motionEvent.getPointerCount()) {
                        int pointerId3 = motionEvent.getPointerId(i3);
                        String[] strArr2 = A03;
                        if (strArr2[2].length() != strArr2[4].length()) {
                            break;
                        } else {
                            String[] strArr3 = A03;
                            strArr3[1] = "FtxLtPKiBWyCq8d2bMsvLwchXj4m1FL";
                            strArr3[5] = "2ZHjPJSTqIAuT8ks3iUv9R1XL7D";
                            if (Build.VERSION.SDK_INT >= 14) {
                                i2 = motionEvent.getToolType(i3);
                            } else {
                                i2 = -1;
                            }
                            int actionMasked = motionEvent.getActionMasked();
                            float[] fArr = new float[2];
                            fArr[0] = motionEvent.getRawX();
                            fArr[c] = motionEvent.getRawY();
                            this.A01.A02(new C0814Wb(elapsedRealtime, r0, new AnonymousClass6T(actionMasked, pointerId3, i2, fArr, motionEvent.getSize(i3), Math.min(motionEvent.getPressure(i3), f), motionEvent.getOrientation(i3))), AnonymousClass6I.A0E);
                            i3++;
                            f = 1.0f;
                            c = 1;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException();
    }
}
