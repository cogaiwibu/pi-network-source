package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.anythink.reactnativejs.utils.Const;

public final class bj {
    public static final bi a = new bi() {
        /* class com.tapjoy.internal.bj.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            Point point = new Point();
            bnVar.h();
            while (bnVar.j()) {
                String l = bnVar.l();
                if (Const.X.equals(l)) {
                    point.x = bnVar.r();
                } else if (Const.Y.equals(l)) {
                    point.y = bnVar.r();
                } else {
                    bnVar.s();
                }
            }
            bnVar.i();
            return point;
        }
    };
    public static final bi b = new bi() {
        /* class com.tapjoy.internal.bj.AnonymousClass2 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            Rect rect = new Rect();
            int i = AnonymousClass3.a[bnVar.k().ordinal()];
            if (i == 1) {
                bnVar.f();
                rect.left = bnVar.r();
                rect.top = bnVar.r();
                rect.right = bnVar.r();
                rect.bottom = bnVar.r();
                while (bnVar.j()) {
                    bnVar.s();
                }
                bnVar.g();
            } else if (i == 2) {
                bnVar.h();
                while (bnVar.j()) {
                    String l = bnVar.l();
                    if ("left".equals(l)) {
                        rect.left = bnVar.r();
                    } else if ("top".equals(l)) {
                        rect.top = bnVar.r();
                    } else if ("right".equals(l)) {
                        rect.right = bnVar.r();
                    } else if ("bottom".equals(l)) {
                        rect.bottom = bnVar.r();
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else {
                throw new IllegalStateException("Unexpected token: " + bnVar.k());
            }
            return rect;
        }
    };

    /* renamed from: com.tapjoy.internal.bj$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tapjoy.internal.bs[] r0 = com.tapjoy.internal.bs.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.bj.AnonymousClass3.a = r0
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.bj.AnonymousClass3.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bs r1 = com.tapjoy.internal.bs.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bj.AnonymousClass3.<clinit>():void");
        }
    }
}
