package com.tapjoy.internal;

public final class am implements ao {
    public final Object a;
    protected Object b = null;

    public am(Object obj) {
        this.a = obj;
    }

    @Override // com.tapjoy.internal.ao
    public final Object a() {
        return this.b;
    }

    @Override // com.tapjoy.internal.ao
    public final void a(Object obj) {
        this.b = obj;
    }
}
