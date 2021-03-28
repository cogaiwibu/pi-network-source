package com.bytedance.sdk.openadsdk.core.d;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsResultAction */
public abstract class e {
    private static final String a = e.class.getSimpleName();
    private final Set<String> b = new HashSet(1);
    private Looper c = Looper.getMainLooper();

    public abstract void a();

    public abstract void a(String str);

    public synchronized boolean b(String str) {
        String str2 = a;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean a(String str, int i) {
        if (i == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.d.e$5  reason: invalid class name */
    /* compiled from: PermissionsResultAction */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bytedance.sdk.openadsdk.core.d.c[] r0 = com.bytedance.sdk.openadsdk.core.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass5.a = r0
                com.bytedance.sdk.openadsdk.core.d.c r1 = com.bytedance.sdk.openadsdk.core.d.c.GRANTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass5.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.openadsdk.core.d.c r1 = com.bytedance.sdk.openadsdk.core.d.c.DENIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass5.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.openadsdk.core.d.c r1 = com.bytedance.sdk.openadsdk.core.d.c.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean a(final String str, c cVar) {
        this.b.remove(str);
        int i = AnonymousClass5.a[cVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.c).post(new Runnable() {
                    /* class com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass2 */

                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            } else if (i == 3) {
                if (!b(str)) {
                    new Handler(this.c).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass4 */

                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                } else if (this.b.isEmpty()) {
                    new Handler(this.c).post(new Runnable() {
                        /* class com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass3 */

                        public void run() {
                            e.this.a();
                        }
                    });
                    return true;
                }
            }
        } else if (this.b.isEmpty()) {
            new Handler(this.c).post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.d.e.AnonymousClass1 */

                public void run() {
                    e.this.a();
                }
            });
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(String[] strArr) {
        Collections.addAll(this.b, strArr);
    }
}
