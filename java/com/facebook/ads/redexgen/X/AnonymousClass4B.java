package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.4B  reason: invalid class name */
public abstract class AnonymousClass4B {
    public static String[] A06;
    public long A00 = 120;
    public long A01 = 250;
    public long A02 = 250;
    public long A03 = 120;
    public AnonymousClass49 A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();

    static {
        A02();
    }

    public static void A02() {
        A06 = new String[]{"wCFFy4v0UHolBGzubHhtaTK0KlaK5TU8", "WXL", "veTi", "n3", "rW28yUWMMTgiQlEcIz6smwE3e87Fn5Ax", "QU5acghFPGL2KQJts4swUt9W5A9MK8iM", "qIZlYUWuFA6tmX766BSANKSPkXlWbMWT", "RhPzJuizv3JTUr3AZhw4zLdz5ZpO"};
    }

    public abstract void A0C();

    public abstract void A0D();

    public abstract void A0E(AnonymousClass4X v);

    public abstract boolean A0F();

    public abstract boolean A0I(@NonNull AnonymousClass4X v, @Nullable AnonymousClass4A v2, @NonNull AnonymousClass4A v3);

    public abstract boolean A0J(@NonNull AnonymousClass4X v, @NonNull AnonymousClass4A v2, @Nullable AnonymousClass4A v3);

    public abstract boolean A0K(@NonNull AnonymousClass4X v, @NonNull AnonymousClass4A v2, @NonNull AnonymousClass4A v3);

    public abstract boolean A0L(@NonNull AnonymousClass4X v, @NonNull AnonymousClass4X v2, @NonNull AnonymousClass4A v3, @NonNull AnonymousClass4A v4);

    public static int A00(AnonymousClass4X r7) {
        int pos = r7.A0C & 14;
        if (r7.A0c()) {
            return 4;
        }
        if ((pos & 4) != 0) {
            return pos;
        }
        int A0K = r7.A0K();
        int A0H = r7.A0H();
        String[] strArr = A06;
        if (strArr[3].length() != strArr[1].length()) {
            String[] strArr2 = A06;
            strArr2[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
            strArr2[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
            if (A0K == -1 || A0H == -1 || A0K == A0H) {
                return pos;
            }
            return pos | 2048;
        }
        throw new RuntimeException();
    }

    private final AnonymousClass4A A01() {
        return new AnonymousClass4A();
    }

    public final long A03() {
        return this.A00;
    }

    public final long A04() {
        return this.A01;
    }

    public final long A05() {
        return this.A02;
    }

    public final long A06() {
        return this.A03;
    }

    @NonNull
    public final AnonymousClass4A A07(@NonNull AnonymousClass4U r2, @NonNull AnonymousClass4X r3) {
        return A01().A01(r3);
    }

    @NonNull
    public final AnonymousClass4A A08(@NonNull AnonymousClass4U r2, @NonNull AnonymousClass4X r3, int i, @NonNull List<Object> list) {
        return A01().A01(r3);
    }

    public final void A09() {
        if (0 < this.A05.size()) {
            this.A05.get(0);
            throw null;
        } else {
            this.A05.clear();
        }
    }

    public final void A0A(AnonymousClass49 r1) {
        this.A04 = r1;
    }

    public final void A0B(AnonymousClass4X r2) {
        AnonymousClass49 r0 = this.A04;
        if (r0 != null) {
            r0.A8r(r2);
        }
    }

    public boolean A0G(@NonNull AnonymousClass4X r2, @NonNull List<Object> list) {
        return A0H(r2);
    }

    public boolean A0H(@NonNull AnonymousClass4X r2) {
        return true;
    }
}
