package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class SH extends AnonymousClass2Y {
    public static String[] A01;
    public final /* synthetic */ AnonymousClass38 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"qdMAGnvFuVn0ea0M3RnyzUUMgxm0S2Dt", "2PeyHnmE0bX58Ffgk0gx7OXrgxltyZLW", "2int", "nVrienaBQfkWnV6qIsNJmuY2fGTgVaBy", "EIAfoPo9YRxYx4hqHxVbjlkHHJjThpFm", "", "SPMlRY4DBSEQqdOiv1Q7wDslDeTbAa0F", "kfFOHzhabps7JVIWzUifit9US33gkwJk"};
    }

    public SH(AnonymousClass38 r1) {
        this.A00 = r1;
    }

    private boolean A01() {
        return this.A00.A01 != null && this.A00.A01.A05() > 1;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2Y
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(AnonymousClass38.class.getName());
        accessibilityEvent.setScrollable(A01());
        if (accessibilityEvent.getEventType() == 4096 && this.A00.A01 != null) {
            accessibilityEvent.setItemCount(this.A00.A01.A05());
            accessibilityEvent.setFromIndex(this.A00.A00);
            accessibilityEvent.setToIndex(this.A00.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2Y
    public final void A08(View view, AnonymousClass3J r4) {
        super.A08(view, r4);
        r4.A0P(AnonymousClass38.class.getName());
        r4.A0S(A01());
        if (this.A00.canScrollHorizontally(1)) {
            r4.A0O(4096);
        }
        if (this.A00.canScrollHorizontally(-1)) {
            r4.A0O(8192);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2Y
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            return true;
        }
        if (i == 4096) {
            AnonymousClass38 r4 = this.A00;
            String[] strArr = A01;
            if (strArr[3].charAt(13) != strArr[7].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
            strArr2[4] = "Vr8sNFSEZwclN9wLDYuYxTMloU2ohTqa";
            if (!r4.canScrollHorizontally(1)) {
                return false;
            }
            AnonymousClass38 r1 = this.A00;
            r1.setCurrentItem(r1.A00 + 1);
            return true;
        } else if (i != 8192 || !this.A00.canScrollHorizontally(-1)) {
            return false;
        } else {
            AnonymousClass38 r12 = this.A00;
            r12.setCurrentItem(r12.A00 - 1);
            return true;
        }
    }
}
