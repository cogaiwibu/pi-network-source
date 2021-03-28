package com.tapjoy.internal;

import java.util.ArrayList;

public final class dd {
    private static dd c = new dd();
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();

    private dd() {
    }

    public static dd a() {
        return c;
    }

    public final boolean b() {
        return this.b.size() > 0;
    }
}
