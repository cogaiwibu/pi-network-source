package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.u;

/* compiled from: VideoOnTouchLayout */
public class b {
    private final a a;
    private boolean b = false;
    private boolean c = false;
    private float d;
    private float e;
    private int f;
    private int g;
    private boolean h = true;
    private boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() {
        /* class com.bytedance.sdk.openadsdk.core.widget.b.AnonymousClass1 */

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!b.this.a.r()) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    b bVar = b.this;
                    bVar.k = bVar.a((b) motionEvent);
                    b.this.d = x;
                    b.this.e = y;
                    b.this.f = (int) x;
                    b.this.g = (int) y;
                    b.this.h = true;
                    if (b.this.a != null && b.this.c && !b.this.b) {
                        b.this.a.a(view, true);
                    }
                } else if (action == 1) {
                    if (Math.abs(x - ((float) b.this.f)) > 20.0f || Math.abs(y - ((float) b.this.g)) > 20.0f) {
                        b.this.h = false;
                    }
                    if (!b.this.b) {
                        b.this.h = true;
                    }
                    b.this.i = false;
                    b.this.d = 0.0f;
                    b.this.e = 0.0f;
                    b.this.f = 0;
                    if (b.this.a != null) {
                        b.this.a.a(view, b.this.h);
                    }
                    b.this.k = false;
                } else if (action != 2) {
                    if (action == 3) {
                        b.this.k = false;
                    }
                } else if (b.this.b && !b.this.k) {
                    float abs = Math.abs(x - b.this.d);
                    float abs2 = Math.abs(y - b.this.e);
                    if (!b.this.i) {
                        if (abs <= 20.0f && abs2 <= 20.0f) {
                            return true;
                        }
                        b.this.i = true;
                    }
                    if (b.this.a != null) {
                        b.this.a.q();
                    }
                    b.this.d = x;
                    b.this.e = y;
                }
                if (b.this.b || !b.this.c) {
                    return true;
                }
                return false;
            } else if (b.this.b || !b.this.c) {
                return true;
            } else {
                return false;
            }
        }
    };
    private boolean k;

    /* compiled from: VideoOnTouchLayout */
    public interface a {
        void a(View view, boolean z);

        void q();

        boolean r();
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int b2 = u.b(j.a().getApplicationContext());
        int c2 = u.c(j.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = (float) b2;
        if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
            float f3 = (float) c2;
            if (rawY <= 0.01f * f3 || rawY >= f3 * 0.99f) {
                return true;
            }
            return false;
        }
        return true;
    }
}
