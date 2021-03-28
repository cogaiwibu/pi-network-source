package com.tapjoy.internal;

public enum eg {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    final int e;

    private eg(int i) {
        this.e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.eg$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tapjoy.internal.eg[] r0 = com.tapjoy.internal.eg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.eg.AnonymousClass1.a = r0
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.eg.VARINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.eg.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.eg.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.tapjoy.internal.eg.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.eg.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.tapjoy.internal.eg.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.eg.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.eg.AnonymousClass1.<clinit>():void");
        }
    }

    public final ej a() {
        int i = AnonymousClass1.a[ordinal()];
        if (i == 1) {
            return ej.j;
        }
        if (i == 2) {
            return ej.g;
        }
        if (i == 3) {
            return ej.l;
        }
        if (i == 4) {
            return ej.q;
        }
        throw new AssertionError();
    }
}
