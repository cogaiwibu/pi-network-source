package com.ss.android.crash.log;

import android.app.ActivityManager;
import android.os.Build;

/* compiled from: JellyBeanV16Compat */
public class o {
    static final a a;

    /* access modifiers changed from: private */
    /* compiled from: JellyBeanV16Compat */
    public static class a {
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return 0;
        }

        private a() {
        }
    }

    /* compiled from: JellyBeanV16Compat */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.ss.android.crash.log.o.a
        public long a(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static long a(ActivityManager.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }
}
