package com.tapjoy.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class jt {
    static final jw a = new jw() {
        /* class com.tapjoy.internal.jt.AnonymousClass1 */

        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }
    };
    private static final Iterator b = new Iterator() {
        /* class com.tapjoy.internal.jt.AnonymousClass2 */

        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new IllegalStateException();
        }
    };

    public static Object a(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
