package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.0c  reason: invalid class name and case insensitive filesystem */
public class C00230c extends AnonymousClass28 {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass3F, com.facebook.ads.redexgen.X.AnonymousClass28
    public final Object A00(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass3F, com.facebook.ads.redexgen.X.AnonymousClass28
    public final Object A01(int i, int i2, boolean z, int i3) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
    }
}
