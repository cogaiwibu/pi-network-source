package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

public final class au extends at implements ax, Closeable, Flushable {
    private final ax a;
    private final LinkedList b = new LinkedList();
    private final LinkedList c = new LinkedList();
    private int d;
    private boolean e;

    public static au a(ax axVar) {
        return new au(axVar);
    }

    private au(ax axVar) {
        this.a = axVar;
        int size = axVar.size();
        this.d = size;
        this.e = size == 0;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } finally {
            ax axVar = this.a;
            if (axVar instanceof Closeable) {
                ((Closeable) axVar).close();
            }
        }
    }

    @Override // java.io.Flushable
    public final void flush() {
        if (!this.c.isEmpty()) {
            this.a.addAll(this.c);
            if (this.e) {
                this.b.addAll(this.c);
            }
            this.c.clear();
        }
    }

    public final int size() {
        return this.d;
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        this.c.add(obj);
        this.d++;
        return true;
    }

    @Override // java.util.Queue
    public final Object poll() {
        Object obj;
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            obj = this.b.remove();
            this.a.b(1);
        } else if (this.e) {
            obj = this.c.remove();
        } else {
            obj = this.a.remove();
            if (this.d == this.c.size() + 1) {
                this.e = true;
            }
        }
        this.d--;
        return obj;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            return this.b.element();
        }
        if (this.e) {
            return this.c.element();
        }
        Object peek = this.a.peek();
        this.b.add(peek);
        if (this.d == this.b.size() + this.c.size()) {
            this.e = true;
        }
        return peek;
    }

    @Override // com.tapjoy.internal.ax
    public final Object a(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.b.size();
        if (i < size) {
            return this.b.get(i);
        }
        if (this.e) {
            return this.c.get(i - size);
        }
        if (i >= this.a.size()) {
            return this.c.get(i - this.a.size());
        }
        Object obj = null;
        while (size <= i) {
            obj = this.a.a(size);
            this.b.add(obj);
            size++;
        }
        if (i + 1 + this.c.size() == this.d) {
            this.e = true;
        }
        return obj;
    }

    @Override // com.tapjoy.internal.ax
    public final void b(int i) {
        if (i <= 0 || i > this.d) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.b.size()) {
            aw.a(this.b, i);
            this.a.b(i);
        } else {
            this.b.clear();
            int size = (this.c.size() + i) - this.d;
            if (size < 0) {
                this.a.b(i);
            } else {
                this.a.clear();
                this.e = true;
                if (size > 0) {
                    aw.a(this.c, size);
                }
            }
        }
        this.d -= i;
    }
}
