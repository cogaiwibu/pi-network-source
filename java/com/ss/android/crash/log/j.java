package com.ss.android.crash.log;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.article.common.nativecrash.NativeCrashInit;
import java.util.Map;

/* compiled from: CrashManager */
public class j {
    private static volatile j a;
    private Context b;
    private volatile boolean c;
    private volatile h d;

    /* compiled from: CrashManager */
    public interface a {
        Map<String, Object> a();
    }

    public static j a(Application application) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(application);
                }
            }
        }
        return a;
    }

    private j(Context context) {
        if (context != null) {
            this.b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public void a(a aVar, boolean z, boolean z2, boolean z3) {
        if (!this.c) {
            if (aVar != null) {
                if (z) {
                    this.d = new h(this.b);
                }
                i.a(this.b, aVar);
                if (z3) {
                    g.a(this.b).a();
                }
                String b2 = l.b(this.b);
                if (z2 && !TextUtils.isEmpty(b2)) {
                    NativeCrashInit.registerForNativeCrash(this.b, "ss_native_crash_logs", "ss_native_crash-", b2);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("CommonParams must not be null");
        }
    }
}
