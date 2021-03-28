package com.facebook.react.views.scroll;

public enum ScrollEventType {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;

    /* access modifiers changed from: package-private */
    /* renamed from: com.facebook.react.views.scroll.ScrollEventType$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$scroll$ScrollEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.views.scroll.ScrollEventType[] r0 = com.facebook.react.views.scroll.ScrollEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType = r0
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.BEGIN_DRAG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.END_DRAG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.SCROLL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.MOMENTUM_BEGIN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.views.scroll.ScrollEventType r1 = com.facebook.react.views.scroll.ScrollEventType.MOMENTUM_END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ScrollEventType.AnonymousClass1.<clinit>():void");
        }
    }

    public static String getJSEventName(ScrollEventType scrollEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType[scrollEventType.ordinal()];
        if (i == 1) {
            return "topScrollBeginDrag";
        }
        if (i == 2) {
            return "topScrollEndDrag";
        }
        if (i == 3) {
            return "topScroll";
        }
        if (i == 4) {
            return "topMomentumScrollBegin";
        }
        if (i == 5) {
            return "topMomentumScrollEnd";
        }
        throw new IllegalArgumentException("Unsupported ScrollEventType: " + scrollEventType);
    }
}
