package com.facebook.react.uimanager.events;

public enum TouchEventType {
    START,
    END,
    MOVE,
    CANCEL;

    /* access modifiers changed from: package-private */
    /* renamed from: com.facebook.react.uimanager.events.TouchEventType$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.react.uimanager.events.TouchEventType[] r0 = com.facebook.react.uimanager.events.TouchEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.uimanager.events.TouchEventType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType = r0
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.facebook.react.uimanager.events.TouchEventType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.facebook.react.uimanager.events.TouchEventType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.MOVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.facebook.react.uimanager.events.TouchEventType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.TouchEventType.AnonymousClass1.<clinit>():void");
        }
    }

    public static String getJSEventName(TouchEventType touchEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[touchEventType.ordinal()];
        if (i == 1) {
            return "topTouchStart";
        }
        if (i == 2) {
            return TouchesHelper.TOP_TOUCH_END_KEY;
        }
        if (i == 3) {
            return "topTouchMove";
        }
        if (i == 4) {
            return TouchesHelper.TOP_TOUCH_CANCEL_KEY;
        }
        throw new IllegalArgumentException("Unexpected type " + touchEventType);
    }
}
