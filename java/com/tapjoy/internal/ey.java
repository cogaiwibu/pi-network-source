package com.tapjoy.internal;

public enum ey implements em {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);
    
    public static final ej ADAPTER = new a();
    private final int a;

    private ey(int i) {
        this.a = i;
    }

    public static ey a(int i) {
        if (i == 0) {
            return APP;
        }
        if (i == 1) {
            return CAMPAIGN;
        }
        if (i == 2) {
            return CUSTOM;
        }
        if (i != 3) {
            return null;
        }
        return USAGES;
    }

    @Override // com.tapjoy.internal.em
    public final int a() {
        return this.a;
    }

    static final class a extends ef {
        a() {
            super(ey.class);
        }

        /* access modifiers changed from: protected */
        @Override // com.tapjoy.internal.ef
        public final /* bridge */ /* synthetic */ em a(int i) {
            return ey.a(i);
        }
    }
}
