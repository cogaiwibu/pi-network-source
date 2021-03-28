package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Sl  reason: case insensitive filesystem */
public abstract class AbstractC0720Sl extends AnonymousClass4B {
    public static String[] A01;
    public boolean A00 = true;

    static {
        A08();
    }

    public static void A08() {
        A01 = new String[]{"ufm8s7LRmOM7", "sIBwdoM05ajejE", "0NxvrnR7UZDHrBy4xVhLU5lsqzWJ5R3x", "FsILnIqpIa8iE3wffvJrO4tNlZdDmpUd", "wKnqjXSh8f61FKWyknAGi8xlXXoDdiLA", "lpMPMGmveEx5YZPPZgDkriuB4nzdouJK", "fQPzW90JHWOApVaaQbndX59CGXgCnXlm", "Pp9SKBa6RS3IfLIGXA9e4oeVKGHa5CsE"};
    }

    public abstract boolean A0U(AnonymousClass4X v);

    public abstract boolean A0V(AnonymousClass4X v);

    public abstract boolean A0W(AnonymousClass4X v, int i, int i2, int i3, int i4);

    public abstract boolean A0X(AnonymousClass4X v, AnonymousClass4X v2, int i, int i2, int i3, int i4);

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0H(@NonNull AnonymousClass4X r2) {
        return !this.A00 || r2.A0c();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0I(@NonNull AnonymousClass4X r8, @Nullable AnonymousClass4A r9, @NonNull AnonymousClass4A r10) {
        if (r9 == null || (r9.A01 == r10.A01 && r9.A03 == r10.A03)) {
            return A0U(r8);
        }
        return A0W(r8, r9.A01, r9.A03, r10.A01, r10.A03);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0J(@NonNull AnonymousClass4X r9, @NonNull AnonymousClass4A r10, @Nullable AnonymousClass4A r11) {
        int i;
        int newLeft;
        int i2 = r10.A01;
        int i3 = r10.A03;
        View view = r9.A0H;
        if (r11 == null) {
            i = view.getLeft();
        } else {
            i = r11.A01;
        }
        if (r11 == null) {
            newLeft = view.getTop();
        } else {
            newLeft = r11.A03;
        }
        if (r9.A0d() || (i2 == i && i3 == newLeft)) {
            return A0V(r9);
        }
        view.layout(i, newLeft, view.getWidth() + i, view.getHeight() + newLeft);
        return A0W(r9, i2, i3, i, newLeft);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0K(@NonNull AnonymousClass4X r8, @NonNull AnonymousClass4A r9, @NonNull AnonymousClass4A r10) {
        if (r9.A01 != r10.A01 || r9.A03 != r10.A03) {
            return A0W(r8, r9.A01, r9.A03, r10.A01, r10.A03);
        }
        A0O(r8);
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0L(@NonNull AnonymousClass4X r11, @NonNull AnonymousClass4X r12, @NonNull AnonymousClass4A r13, @NonNull AnonymousClass4A r14) {
        int fromTop;
        int toLeft;
        int i = r13.A01;
        int i2 = r13.A03;
        if (r12.A0i()) {
            fromTop = r13.A01;
            toLeft = r13.A03;
        } else {
            fromTop = r14.A01;
            toLeft = r14.A03;
        }
        if (A01[1].length() != 14) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "7F8ns227Orjao7";
        strArr[1] = "7F8ns227Orjao7";
        return A0X(r11, r12, i, i2, fromTop, toLeft);
    }

    public final void A0M(AnonymousClass4X r1) {
        A0B(r1);
    }

    public final void A0N(AnonymousClass4X r1) {
    }

    public final void A0O(AnonymousClass4X r1) {
        A0B(r1);
    }

    public final void A0P(AnonymousClass4X r1) {
    }

    public final void A0Q(AnonymousClass4X r1) {
        A0B(r1);
    }

    public final void A0R(AnonymousClass4X r1) {
    }

    public final void A0S(AnonymousClass4X r1, boolean z) {
        A0B(r1);
    }

    public final void A0T(AnonymousClass4X r1, boolean z) {
    }
}
