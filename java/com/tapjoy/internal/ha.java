package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

public class ha implements go {
    private static final ha a = new ha() {
        /* class com.tapjoy.internal.ha.AnonymousClass1 */

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void a(String str) {
        }

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void a(String str, gl glVar) {
        }

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void a(String str, String str2, gl glVar) {
        }

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void b(String str) {
        }

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void c(String str) {
        }

        @Override // com.tapjoy.internal.ha, com.tapjoy.internal.go
        public final void d(String str) {
        }
    };
    private final go b;
    private final ba c;

    /* synthetic */ ha(byte b2) {
        this();
    }

    public static ha a(go goVar) {
        if (!(!(goVar instanceof ha))) {
            throw new IllegalArgumentException();
        } else if (goVar != null) {
            return new ha(goVar);
        } else {
            return a;
        }
    }

    private ha() {
        this.b = null;
        this.c = null;
    }

    private ha(go goVar) {
        Handler handler;
        this.b = goVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            jp.a(myLooper);
            handler = myLooper == Looper.getMainLooper() ? u.a() : new Handler(myLooper);
        } else {
            handler = null;
        }
        if (handler != null) {
            this.c = u.a(handler);
            handler.getLooper();
        } else if (Thread.currentThread() == gr.b()) {
            this.c = gr.a;
        } else {
            this.c = u.a(u.a());
        }
    }

    @Override // com.tapjoy.internal.go
    public void a(final String str) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass2 */

            public final void run() {
                ha.this.b.a(str);
            }
        });
    }

    @Override // com.tapjoy.internal.go
    public void b(final String str) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass3 */

            public final void run() {
                ha.this.b.b(str);
            }
        });
    }

    @Override // com.tapjoy.internal.go
    public void c(final String str) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass4 */

            public final void run() {
                ha.this.b.c(str);
            }
        });
    }

    @Override // com.tapjoy.internal.go
    public void d(final String str) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass5 */

            public final void run() {
                ha.this.b.d(str);
            }
        });
    }

    @Override // com.tapjoy.internal.go
    public void a(final String str, final gl glVar) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass6 */

            public final void run() {
                ha.this.b.a(str, glVar);
            }
        });
    }

    @Override // com.tapjoy.internal.go
    public void a(final String str, final String str2, final gl glVar) {
        this.c.a(new Runnable() {
            /* class com.tapjoy.internal.ha.AnonymousClass7 */

            public final void run() {
                ha.this.b.a(str, str2, glVar);
            }
        });
    }
}
