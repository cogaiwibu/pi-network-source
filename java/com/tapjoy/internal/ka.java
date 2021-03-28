package com.tapjoy.internal;

import com.ironsource.sdk.constants.Constants;
import com.tapjoy.internal.kf;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ka implements kf {
    private static final Logger a = Logger.getLogger(ka.class.getName());
    private final kf b = new kc() {
        /* class com.tapjoy.internal.ka.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.kc
        public final void a() {
            new Executor() {
                /* class com.tapjoy.internal.ka.AnonymousClass2 */

                public final void execute(Runnable runnable) {
                    new Thread(runnable, ka.this.getClass().getSimpleName()).start();
                }
            }.execute(new Runnable() {
                /* class com.tapjoy.internal.ka.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    try {
                        ka.this.b();
                        AnonymousClass1.this.c();
                        if (AnonymousClass1.this.f() == kf.a.RUNNING) {
                            try {
                                ka.this.d();
                            } catch (Throwable th) {
                                try {
                                    ka.this.c();
                                } catch (Exception e) {
                                    ka.a.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                                }
                                throw th;
                            }
                        }
                        ka.this.c();
                        AnonymousClass1.this.d();
                    } catch (Throwable th2) {
                        AnonymousClass1.this.a(th2);
                        throw jr.a(th2);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.kc
        public final void b() {
            ka.this.a();
        }
    };

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public abstract void d();

    public String toString() {
        return getClass().getSimpleName() + " [" + f() + Constants.RequestParameters.RIGHT_BRACKETS;
    }

    @Override // com.tapjoy.internal.kf
    public final ke e() {
        return this.b.e();
    }

    @Override // com.tapjoy.internal.kf
    public final kf.a f() {
        return this.b.f();
    }
}
