package com.ss.android.crash.log;

import android.os.Build;
import android.os.Debug;

/* compiled from: DebugMemInfoCompat */
public class m {
    static final a a;

    /* access modifiers changed from: private */
    /* compiled from: DebugMemInfoCompat */
    public static class a {
        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        private a() {
        }
    }

    /* compiled from: DebugMemInfoCompat */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.ss.android.crash.log.m.a
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.ss.android.crash.log.m.a
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.ss.android.crash.log.m.a
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
