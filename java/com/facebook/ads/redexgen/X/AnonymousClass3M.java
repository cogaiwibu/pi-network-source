package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3M  reason: invalid class name */
public class AnonymousClass3M extends AccessibilityNodeProvider {
    public final /* synthetic */ AnonymousClass3N A00;

    public AnonymousClass3M(AnonymousClass3N r1) {
        this.A00 = r1;
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return (AccessibilityNodeInfo) this.A00.A4C(i);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<java.lang.Object>, java.util.List<android.view.accessibility.AccessibilityNodeInfo> */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        return this.A00.A55(str, i);
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.A00.ABb(i, i2, bundle);
    }
}
