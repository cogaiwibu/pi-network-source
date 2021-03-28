package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(16)
public class SC extends AnonymousClass2X {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass2X
    public final View.AccessibilityDelegate A00(AnonymousClass2Y r2) {
        return new AnonymousClass2V(this, r2);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2X
    public final AnonymousClass3L A01(View.AccessibilityDelegate accessibilityDelegate, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AnonymousClass3L(accessibilityNodeProvider);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2X
    public final boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
    }
}
