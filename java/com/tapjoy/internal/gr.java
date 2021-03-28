package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;

public final class gr {
    public static final ba a = new ba() {
        /* class com.tapjoy.internal.gr.AnonymousClass1 */

        @Override // com.tapjoy.internal.ba
        public final boolean a(Runnable runnable) {
            GLSurfaceView gLSurfaceView = (GLSurfaceView) gr.c.a();
            if (gLSurfaceView == null) {
                return false;
            }
            gLSurfaceView.queueEvent(runnable);
            return true;
        }
    };
    private static Activity b;
    private static final by c = new by();
    private static final by d = new by();

    static void a(GLSurfaceView gLSurfaceView) {
        c.a(gLSurfaceView);
        gLSurfaceView.queueEvent(new Runnable() {
            /* class com.tapjoy.internal.gr.AnonymousClass2 */

            public final void run() {
                gr.d.a(Thread.currentThread());
            }
        });
    }

    public static Activity a() {
        Activity activity = b;
        return activity == null ? b.a() : activity;
    }

    public static Thread b() {
        return (Thread) d.a();
    }
}
