package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Hi  reason: case insensitive filesystem */
public final class C0442Hi implements AbstractC0627Ot {
    public static String[] A0C;
    public int A00 = 2000;
    @Nullable
    public C0532Lb A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final Handler A05 = new Handler();
    public final K4 A06 = new AnonymousClass7q(this);
    public final AbstractC0506Jy A07 = new C02127r(this);
    public final AbstractC0494Jk A08 = new C02117p(this);
    public final AbstractC0464Ie A09 = new C02107o(this);
    public final IC A0A = new C02097n(this);
    public final List<PE> A0B = new ArrayList();

    static {
        A04();
    }

    public static void A04() {
        A0C = new String[]{"ua4Z1F3Vn1tdURaP0tTj5Z", "VlqKJtfjGqtNso0qX2A6lmnvOZsZ2xTE", "1pb0xsuTqC4ySw1JjiCpjHk6a0KK", "HW9a8amQa56v9usqS4J3KzzxMBRp7oUY", "lzg290ZQq0ECc78zj7A2Pt", "9JBQniCNh78hbF6UnJo6", "DIRAqcjzgSQz4x9q8OrEXdtc6Zce0V5V", "FPN1H6gS7aT4O5CCkRk249I"};
    }

    public C0442Hi(boolean z) {
        this.A02 = z;
    }

    /* access modifiers changed from: private */
    public void A03() {
        this.A05.removeCallbacksAndMessages(null);
        Iterator<PE> it = this.A0B.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "SzC94btdcN1119JNHgRanzsWdfoutew0";
            strArr[1] = "SzC94btdcN1119JNHgRanzsWdfoutew0";
            if (hasNext) {
                it.next().cancel();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void A07(boolean z, boolean z2) {
        for (PE pe : this.A0B) {
            if (A0C[2].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "qWrr7wKcnD6M25Nm7U3j0NNRElcnIA4d";
            strArr[1] = "qWrr7wKcnD6M25Nm7U3j0NNRElcnIA4d";
            pe.A3O(z, z2);
        }
    }

    /* access modifiers changed from: private */
    public boolean A0E(PD pd) {
        for (PE pe : this.A0B) {
            if (pe.A71() != pd) {
                return false;
            }
        }
        return true;
    }

    public final void A0F() {
        this.A0B.clear();
    }

    public final void A0G() {
        if (this.A02) {
            this.A05.removeCallbacksAndMessages(null);
            this.A02 = false;
        }
    }

    public final void A0H() {
        this.A04 = true;
        this.A03 = true;
        A07(false, false);
    }

    public final void A0I(int i) {
        this.A00 = i;
    }

    public final void A0J(PE pe) {
        this.A0B.add(pe);
    }

    public final boolean A0K() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void A7s(C0532Lb lb) {
        this.A01 = lb;
        lb.getEventBus().A04(this.A07, this.A0A, this.A08, this.A09, this.A06);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void ADa(C0532Lb lb) {
        A03();
        lb.getEventBus().A05(this.A06, this.A0A, this.A08, this.A09, this.A07);
        this.A01 = null;
    }
}
