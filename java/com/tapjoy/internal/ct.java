package com.tapjoy.internal;

public final class ct {
    public final cw a;
    public final cw b;
    public final boolean c;

    private ct(cw cwVar, cw cwVar2) {
        this.a = cwVar;
        if (cwVar2 == null) {
            this.b = cw.NONE;
        } else {
            this.b = cwVar2;
        }
        this.c = false;
    }

    public static ct a(cw cwVar, cw cwVar2) {
        Cdo.a(cwVar, "Impression owner is null");
        if (!cwVar.equals(cw.NONE)) {
            return new ct(cwVar, cwVar2);
        }
        throw new IllegalArgumentException("Impression owner is none");
    }
}
