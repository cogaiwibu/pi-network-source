package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: com.facebook.ads.redexgen.X.2V  reason: invalid class name */
public class AnonymousClass2V extends View.AccessibilityDelegate {
    public static String[] A02;
    public final /* synthetic */ SC A00;
    public final /* synthetic */ AnonymousClass2Y A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"5TXwkxGOky4JO26BdMoLZorZ75Qh7TJ1", "TGpCIVKfg9q9VkptB3w2PfFUtUXuMPxH", "XWnogg3sW", "LoblWG2nky8IldTW7marNA4rqywTihhk", "", "za5KD6H2U", "Ka0OyPk3mlOgfUpq6xId3QQILfS23GTN", "DN7QTk2L5QCC7wBdOwuQ1Nom6iZb"};
    }

    public AnonymousClass2V(SC sc, AnonymousClass2Y r2) {
        this.A00 = sc;
        this.A01 = r2;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.A01.A05(view, accessibilityEvent);
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        AnonymousClass3L A012 = this.A01.A01(view);
        if (A012 == null) {
            return null;
        }
        Object A022 = A012.A02();
        String[] strArr = A02;
        if (strArr[0].charAt(14) != strArr[6].charAt(14)) {
            String[] strArr2 = A02;
            strArr2[1] = "uCvPJ7NUfrK1Xmg35VTgFJzpSrozRbu2";
            strArr2[1] = "uCvPJ7NUfrK1Xmg35VTgFJzpSrozRbu2";
            return (AccessibilityNodeProvider) A022;
        }
        throw new RuntimeException();
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.A01.A07(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        this.A01.A08(view, AnonymousClass3J.A01(accessibilityNodeInfo));
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.A01.A03(view, accessibilityEvent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.A01.A06(viewGroup, view, accessibilityEvent);
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.A01.A09(view, i, bundle);
    }

    public final void sendAccessibilityEvent(View view, int i) {
        this.A01.A02(view, i);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.A01.A04(view, accessibilityEvent);
    }
}
