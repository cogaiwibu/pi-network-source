package com.tapjoy.internal;

import android.view.ViewGroup;
import java.util.Iterator;

public final class ac {
    public static Iterable a(ViewGroup viewGroup) {
        final a aVar = new a(viewGroup);
        return new Iterable() {
            /* class com.tapjoy.internal.ac.AnonymousClass1 */

            @Override // java.lang.Iterable
            public final Iterator iterator() {
                return aVar;
            }
        };
    }

    static class a implements Iterator {
        private final ViewGroup a;
        private int b;
        private int c = 0;

        public a(ViewGroup viewGroup) {
            this.a = viewGroup;
            this.b = viewGroup.getChildCount();
        }

        public final boolean hasNext() {
            return this.c < this.b;
        }

        public final void remove() {
            this.a.removeViewAt(this.c - 1);
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            ViewGroup viewGroup = this.a;
            int i = this.c;
            this.c = i + 1;
            return viewGroup.getChildAt(i);
        }
    }
}
