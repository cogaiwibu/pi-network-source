package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

public abstract class at extends AbstractQueue implements ax {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() {
            /* class com.tapjoy.internal.at.AnonymousClass1 */
            private int b = 0;

            public final boolean hasNext() {
                return this.b < at.this.size();
            }

            @Override // java.util.Iterator
            public final Object next() {
                at atVar = at.this;
                int i = this.b;
                this.b = i + 1;
                return atVar.a(i);
            }

            public final void remove() {
                if (this.b == 1) {
                    at.this.b(1);
                    this.b = 0;
                    return;
                }
                throw new UnsupportedOperationException("For the first element only");
            }
        };
    }
}
