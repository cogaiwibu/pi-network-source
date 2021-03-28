package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public final class fl {
    private static final fl a = new fl();
    private Application b;
    private Application.ActivityLifecycleCallbacks c;
    private final HashSet d = new HashSet();

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT >= 14 && context != null) {
            fl flVar = a;
            Context applicationContext = context.getApplicationContext();
            if (flVar.b == null) {
                try {
                    if (applicationContext instanceof Application) {
                        flVar.b = (Application) applicationContext;
                    } else {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        TapjoyUtil.runOnMainThread(new Runnable() {
                            /* class com.tapjoy.internal.fl.AnonymousClass1 */

                            public final void run() {
                                try {
                                    fl.this.b = fl.b();
                                } catch (Exception e) {
                                    TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                                } catch (Throwable th) {
                                    countDownLatch.countDown();
                                    throw th;
                                }
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                    }
                } catch (Exception e) {
                    TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
                }
                if (flVar.b == null) {
                    return;
                }
            }
            synchronized (flVar) {
                if (flVar.c == null) {
                    Activity c2 = b.c();
                    if (c2 != null) {
                        flVar.d.add(b(c2));
                    }
                    final HashSet hashSet = flVar.d;
                    AnonymousClass2 r1 = new Application.ActivityLifecycleCallbacks() {
                        /* class com.tapjoy.internal.fl.AnonymousClass2 */

                        public final void onActivityCreated(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityDestroyed(Activity activity) {
                        }

                        public final void onActivityPaused(Activity activity) {
                        }

                        public final void onActivityResumed(Activity activity) {
                        }

                        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        public final void onActivityStarted(Activity activity) {
                            hashSet.add(fl.b(activity));
                            if (hashSet.size() == 1) {
                                gn.a();
                            }
                            b.a(activity);
                        }

                        public final void onActivityStopped(Activity activity) {
                            hashSet.remove(fl.b(activity));
                            if (hashSet.size() <= 0) {
                                gn.b();
                            }
                        }
                    };
                    flVar.c = r1;
                    flVar.b.registerActivityLifecycleCallbacks(r1);
                    gn.a();
                }
            }
        }
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 14) {
            fl flVar = a;
            if (flVar.b != null) {
                synchronized (flVar) {
                    if (flVar.c != null) {
                        flVar.b.unregisterActivityLifecycleCallbacks(flVar.c);
                        flVar.c = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String b(Activity activity) {
        return activity.getClass().getName() + "@" + System.identityHashCode(activity);
    }

    static /* synthetic */ Application b() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }
}
