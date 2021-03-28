package com.facebook.common.logging;

public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(LoggingDelegate loggingDelegate) {
        if (loggingDelegate != null) {
            sHandler = loggingDelegate;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    public static void v(String str, String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, str2);
        }
    }

    public static void v(String str, String str2, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void v(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void v(Class<?> cls, String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str);
        }
    }

    public static void v(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (isLoggable(2)) {
            v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr));
        }
    }

    public static void v(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr), th);
        }
    }

    public static void v(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr));
        }
    }

    public static void v(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, str2, th);
        }
    }

    public static void v(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str, th);
        }
    }

    public static void d(String str, String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, str2);
        }
    }

    public static void d(String str, String str2, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void d(Class<?> cls, String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str);
        }
    }

    public static void d(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj));
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr));
        }
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr), th);
        }
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr));
        }
    }

    public static void d(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, str2, th);
        }
    }

    public static void d(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str, th);
        }
    }

    public static void i(String str, String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, str2);
        }
    }

    public static void i(String str, String str2, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void i(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void i(Class<?> cls, String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str);
        }
    }

    public static void i(Class<?> cls, String str, Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void i(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr));
        }
    }

    public static void i(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr), th);
        }
    }

    public static void i(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr));
        }
    }

    public static void i(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, str2, th);
        }
    }

    public static void i(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str, th);
        }
    }

    public static void w(String str, String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, str2);
        }
    }

    public static void w(Class<?> cls, String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr));
        }
    }

    public static void w(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr), th);
        }
    }

    public static void w(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), formatString(str, objArr));
        }
    }

    public static void w(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (isLoggable(5)) {
            w(cls, formatString(str, objArr), th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, str2, th);
        }
    }

    public static void w(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str, th);
        }
    }

    public static void e(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, str2);
        }
    }

    public static void e(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr));
        }
    }

    public static void e(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr), th);
        }
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr));
        }
    }

    public static void e(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, str2, th);
        }
    }

    public static void e(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(Class<?> cls, String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(String str, Throwable th, String str2, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(Class<?> cls, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(Class<?> cls, String str, Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static String getTag(Class<?> cls) {
        return cls.getSimpleName();
    }
}
