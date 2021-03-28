package com.tapjoy.internal;

public final class jf {
    public static jf a = new jf(null);
    public String b;
    public Throwable c;
    private Object[] d;

    public jf(String str) {
        this(str, null, null);
    }

    public jf(String str, Object[] objArr, Throwable th) {
        this.b = str;
        this.c = th;
        if (th == null) {
            this.d = objArr;
        } else if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            this.d = objArr2;
        }
    }
}
