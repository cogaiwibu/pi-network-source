package com.facebook.react.uimanager.layoutanimation;

/* access modifiers changed from: package-private */
public enum LayoutAnimationType {
    CREATE,
    UPDATE,
    DELETE;

    /* access modifiers changed from: package-private */
    /* renamed from: com.facebook.react.uimanager.layoutanimation.LayoutAnimationType$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationType[] r0 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType = r0
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationType r1 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationType r1 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.UPDATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.layoutanimation.LayoutAnimationType r1 = com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.DELETE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.layoutanimation.LayoutAnimationType.AnonymousClass1.<clinit>():void");
        }
    }

    public static String toString(LayoutAnimationType layoutAnimationType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[layoutAnimationType.ordinal()];
        if (i == 1) {
            return "create";
        }
        if (i == 2) {
            return "update";
        }
        if (i == 3) {
            return "delete";
        }
        throw new IllegalArgumentException("Unsupported LayoutAnimationType: " + layoutAnimationType);
    }
}
