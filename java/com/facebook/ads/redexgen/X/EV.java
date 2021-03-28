package com.facebook.ads.redexgen.X;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import com.facebook.ads.internal.androidx.support.v7.widget.DefaultItemAnimator;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class EV extends AbstractC0720Sl {
    public static TimeInterpolator A0B;
    public static String[] A0C;
    public ArrayList<AnonymousClass4X> A00 = new ArrayList<>();
    public ArrayList<ArrayList<AnonymousClass4X>> A01 = new ArrayList<>();
    public ArrayList<AnonymousClass4X> A02 = new ArrayList<>();
    public ArrayList<ArrayList<C01093m>> A03 = new ArrayList<>();
    public ArrayList<AnonymousClass4X> A04 = new ArrayList<>();
    public ArrayList<ArrayList<C01103n>> A05 = new ArrayList<>();
    public ArrayList<AnonymousClass4X> A06 = new ArrayList<>();
    public ArrayList<AnonymousClass4X> A07 = new ArrayList<>();
    public ArrayList<C01093m> A08 = new ArrayList<>();
    public ArrayList<C01103n> A09 = new ArrayList<>();
    public ArrayList<AnonymousClass4X> A0A = new ArrayList<>();

    static {
        A01();
    }

    public static void A01() {
        A0C = new String[]{"K3xavpXOVVnTPS8V8FmisIpuez1NdmFn", "QjoCrUVtXYT15qNhmppxWCsnlOvXMRWn", "HVYav4KnfeU3lAWSFDiSVAYelCZD7hW1", "SKhwmHHGUoQzTLK2kw5WKB1efbL3jYLm", "aZpNXGptJoOcjVlsPlgA0RFw1bcc4fI1", "y8DDj9eTKGlZyxtiH83YwnquX80t2qUq", "Eqht3urb", "PkOCx2w9GPXTa0iGANdHxOJetOGxrMw0"};
    }

    private void A02(C01093m r2) {
        if (r2.A05 != null) {
            A07(r2, r2.A05);
        }
        if (r2.A04 != null) {
            A07(r2, r2.A04);
        }
    }

    private void A03(AnonymousClass4X r5) {
        View view = r5.A0H;
        ViewPropertyAnimator animate = view.animate();
        this.A06.add(r5);
        animate.setDuration(A06()).alpha(0.0f).setListener(new C01043h(this, r5, animate, view)).start();
    }

    private void A04(AnonymousClass4X r3) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        r3.A0H.animate().setInterpolator(A0B);
        A0E(r3);
    }

    private final void A05(List<AnonymousClass4X> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A06(List<C01093m> list, AnonymousClass4X r5) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C01093m r1 = list.get(size);
            if (A07(r1, r5) && r1.A05 == null && r1.A04 == null) {
                list.remove(r1);
            }
        }
    }

    private boolean A07(C01093m r4, AnonymousClass4X r5) {
        boolean z = false;
        if (r4.A04 == r5) {
            r4.A04 = null;
        } else if (r4.A05 != r5) {
            return false;
        } else {
            r4.A05 = null;
            z = true;
        }
        r5.A0H.setAlpha(1.0f);
        r5.A0H.setTranslationX(0.0f);
        r5.A0H.setTranslationY(0.0f);
        A0S(r5, z);
        return true;
    }

    /* JADX INFO: Multiple debug info for r1v8 com.facebook.ads.redexgen.X.4X: [D('item' com.facebook.ads.redexgen.X.4X), D('view' android.view.View)] */
    /* JADX INFO: Multiple debug info for r1v10 com.facebook.ads.redexgen.X.3n: [D('j' int), D('moveInfo' com.facebook.ads.redexgen.X.3n)] */
    /* JADX INFO: Multiple debug info for r0v33 com.facebook.ads.redexgen.X.4X: [D('moves' java.util.ArrayList<com.facebook.ads.internal.androidx.support.v7.widget.DefaultItemAnimator$MoveInfo>), D('item' com.facebook.ads.redexgen.X.4X)] */
    /* JADX INFO: Multiple debug info for r0v34 android.view.View: [D('item' com.facebook.ads.redexgen.X.4X), D('view' android.view.View)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final void A0C() {
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            C01103n r1 = this.A09.get(size);
            View view = r1.A04.A0H;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            A0O(r1.A04);
            this.A09.remove(size);
        }
        for (int size2 = this.A0A.size() - 1; size2 >= 0; size2--) {
            A0Q(this.A0A.get(size2));
            this.A0A.remove(size2);
        }
        for (int size3 = this.A07.size() - 1; size3 >= 0; size3--) {
            AnonymousClass4X r12 = this.A07.get(size3);
            r12.A0H.setAlpha(1.0f);
            A0M(r12);
            this.A07.remove(size3);
        }
        for (int size4 = this.A08.size() - 1; size4 >= 0; size4--) {
            A02(this.A08.get(size4));
        }
        this.A08.clear();
        if (A0F()) {
            for (int size5 = this.A05.size() - 1; size5 >= 0; size5--) {
                ArrayList<C01103n> arrayList = this.A05.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C01103n moveInfo = arrayList.get(size6);
                    View view2 = moveInfo.A04.A0H;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    A0O(moveInfo.A04);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.A05.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.A01.size() - 1; size7 >= 0; size7--) {
                ArrayList<AnonymousClass4X> arrayList2 = this.A01.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    AnonymousClass4X item = arrayList2.get(size8);
                    item.A0H.setAlpha(1.0f);
                    A0M(item);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.A01.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.A03.size() - 1; size9 >= 0; size9--) {
                ArrayList<DefaultItemAnimator.ChangeInfo> changes = this.A03.get(size9);
                for (int size10 = changes.size() - 1; size10 >= 0; size10--) {
                    A02((C01093m) changes.get(size10));
                    if (changes.isEmpty()) {
                        this.A03.remove(changes);
                    }
                }
            }
            A05(this.A06);
            A05(this.A04);
            A05(this.A00);
            A05(this.A02);
            A09();
        }
    }

    /* JADX INFO: Multiple debug info for r0v24 android.view.View: [D('totalDelay' long), D('view' android.view.View)] */
    /* JADX INFO: Multiple debug info for r0v31 com.facebook.ads.redexgen.X.4X: [D('changes' java.util.ArrayList<com.facebook.ads.internal.androidx.support.v7.widget.DefaultItemAnimator$ChangeInfo>), D('holder' com.facebook.ads.redexgen.X.4X)] */
    /* JADX INFO: Multiple debug info for r0v41 com.facebook.ads.redexgen.X.4X: [D('changesPending' boolean), D('holder' com.facebook.ads.redexgen.X.4X)] */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final void A0D() {
        long j;
        long changeDuration;
        boolean additionsPending = !this.A0A.isEmpty();
        boolean z = !this.A09.isEmpty();
        boolean z2 = !this.A08.isEmpty();
        boolean z3 = !this.A07.isEmpty();
        if (additionsPending || z || z3 || z2) {
            Iterator<AnonymousClass4X> it = this.A0A.iterator();
            while (it.hasNext()) {
                A03(it.next());
            }
            this.A0A.clear();
            if (z) {
                DefaultItemAnimator.MoveInfo arrayList = new ArrayList();
                arrayList.addAll(this.A09);
                this.A05.add(arrayList);
                this.A09.clear();
                RunnableC01013e r3 = new RunnableC01013e(this, arrayList);
                if (additionsPending) {
                    AnonymousClass2u.A0D(arrayList.get(0).A04.A0H, r3, A06());
                } else {
                    r3.run();
                }
            }
            if (z2) {
                DefaultItemAnimator.ChangeInfo arrayList2 = new ArrayList();
                arrayList2.addAll(this.A08);
                this.A03.add(arrayList2);
                this.A08.clear();
                RunnableC01023f r32 = new RunnableC01023f(this, arrayList2);
                if (additionsPending) {
                    AnonymousClass2u.A0D(arrayList2.get(0).A05.A0H, r32, A06());
                } else {
                    r32.run();
                }
            }
            if (z3) {
                RecyclerView.ViewHolder arrayList3 = new ArrayList();
                arrayList3.addAll(this.A07);
                this.A01.add(arrayList3);
                this.A07.clear();
                RunnableC01033g r7 = new RunnableC01033g(this, arrayList3);
                if (additionsPending || z || z2) {
                    long j2 = 0;
                    if (A0C[0].charAt(3) != 'S') {
                        String[] strArr = A0C;
                        strArr[4] = "oGS3g0YSOogxL8fDiPQ9wWzcLRV8E0qu";
                        strArr[3] = "UwBhVdK7HoWqzQqehBBKiWd5H5AJwN9O";
                        if (additionsPending) {
                            j = A06();
                        } else {
                            j = 0;
                        }
                        if (z) {
                            changeDuration = A05();
                        } else {
                            changeDuration = 0;
                        }
                        if (z2) {
                            j2 = A04();
                        }
                        AnonymousClass2u.A0D(arrayList3.get(0).A0H, r7, Math.max(changeDuration, j2) + j);
                        return;
                    }
                    throw new RuntimeException();
                }
                r7.run();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final void A0E(AnonymousClass4X r10) {
        View view = r10.A0H;
        view.animate().cancel();
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            if (this.A09.get(size).A04 == r10) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                A0O(r10);
                this.A09.remove(size);
            }
        }
        A06(this.A08, r10);
        if (this.A0A.remove(r10)) {
            view.setAlpha(1.0f);
            A0Q(r10);
        }
        if (this.A07.remove(r10)) {
            view.setAlpha(1.0f);
            A0M(r10);
        }
        for (int size2 = this.A03.size() - 1; size2 >= 0; size2--) {
            ArrayList<DefaultItemAnimator.ChangeInfo> changes = this.A03.get(size2);
            A06(changes, r10);
            if (changes.isEmpty()) {
                this.A03.remove(size2);
            }
        }
        for (int size3 = this.A05.size() - 1; size3 >= 0; size3--) {
            ArrayList<C01103n> arrayList = this.A05.get(size3);
            int size4 = arrayList.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList.get(size4).A04 == r10) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    String[] strArr = A0C;
                    if (strArr[4].charAt(9) != strArr[3].charAt(9)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0C;
                    strArr2[1] = "ZnQkkSK02m4qlFQsfXGc8k1uWyp7aRL1";
                    strArr2[1] = "ZnQkkSK02m4qlFQsfXGc8k1uWyp7aRL1";
                    A0O(r10);
                    arrayList.remove(size4);
                    if (arrayList.isEmpty()) {
                        this.A05.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        int size5 = this.A01.size();
        if (A0C[0].charAt(3) != 'S') {
            String[] strArr3 = A0C;
            strArr3[7] = "NHib0yCpDtVNZGbvtAXjIsv6RzrfBwwf";
            strArr3[7] = "NHib0yCpDtVNZGbvtAXjIsv6RzrfBwwf";
            for (int i = size5 - 1; i >= 0; i--) {
                ArrayList<AnonymousClass4X> arrayList2 = this.A01.get(i);
                if (arrayList2.remove(r10)) {
                    view.setAlpha(1.0f);
                    A0M(r10);
                    if (arrayList2.isEmpty()) {
                        this.A01.remove(i);
                    }
                }
            }
            this.A06.remove(r10);
            this.A00.remove(r10);
            this.A02.remove(r10);
            this.A04.remove(r10);
            A0Y();
            return;
        }
        throw new RuntimeException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        if (r3 != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        if (r3 != false) goto L_0x0078;
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A0F() {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EV.A0F():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4B
    public final boolean A0G(@NonNull AnonymousClass4X r2, @NonNull List<Object> list) {
        return !list.isEmpty() || super.A0G(r2, list);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0720Sl
    public final boolean A0U(AnonymousClass4X r3) {
        A04(r3);
        r3.A0H.setAlpha(0.0f);
        this.A07.add(r3);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0720Sl
    public final boolean A0V(AnonymousClass4X r2) {
        A04(r2);
        this.A0A.add(r2);
        return true;
    }

    /* JADX INFO: Multiple debug info for r0v6 int: [D('fromY' int), D('deltaX' int)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC0720Sl
    public final boolean A0W(AnonymousClass4X r9, int i, int i2, int i3, int i4) {
        View view = r9.A0H;
        int deltaY = i + ((int) r9.A0H.getTranslationX());
        int translationY = i2 + ((int) r9.A0H.getTranslationY());
        A04(r9);
        int deltaX = i3 - deltaY;
        int i5 = i4 - translationY;
        if (deltaX == 0 && i5 == 0) {
            A0O(r9);
            return false;
        }
        if (deltaX != 0) {
            view.setTranslationX((float) (-deltaX));
        }
        if (i5 != 0) {
            view.setTranslationY((float) (-i5));
        }
        this.A09.add(new C01103n(r9, deltaY, translationY, i3, i4));
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0720Sl
    public final boolean A0X(AnonymousClass4X r14, AnonymousClass4X r15, int deltaX, int deltaY, int i, int i2) {
        if (r14 == r15) {
            return A0W(r14, deltaX, deltaY, i, i2);
        }
        float translationX = r14.A0H.getTranslationX();
        float translationY = r14.A0H.getTranslationY();
        float alpha = r14.A0H.getAlpha();
        A04(r14);
        int i3 = (int) (((float) (i - deltaX)) - translationX);
        int i4 = (int) (((float) (i2 - deltaY)) - translationY);
        r14.A0H.setTranslationX(translationX);
        r14.A0H.setTranslationY(translationY);
        r14.A0H.setAlpha(alpha);
        if (r15 != null) {
            A04(r15);
            r15.A0H.setTranslationX((float) (-i3));
            r15.A0H.setTranslationY((float) (-i4));
            r15.A0H.setAlpha(0.0f);
        }
        this.A08.add(new C01093m(r14, r15, deltaX, deltaY, i, i2));
        return true;
    }

    public final void A0Y() {
        if (!A0F()) {
            A09();
        }
    }

    public final void A0Z(C01093m r7) {
        View view;
        AnonymousClass4X r0 = r7.A05;
        View view2 = null;
        if (r0 == null) {
            view = null;
        } else {
            view = r0.A0H;
        }
        AnonymousClass4X r02 = r7.A04;
        if (r02 != null) {
            view2 = r02.A0H;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(A04());
            this.A02.add(r7.A05);
            duration.translationX((float) (r7.A02 - r7.A00));
            duration.translationY((float) (r7.A03 - r7.A01));
            duration.alpha(0.0f).setListener(new C01073k(this, r7, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.A02.add(r7.A04);
            animate.translationX(0.0f).translationY(0.0f).setDuration(A04()).alpha(1.0f).setListener(new C01083l(this, r7, animate, view2)).start();
        }
    }

    public final void A0a(AnonymousClass4X r6) {
        View view = r6.A0H;
        ViewPropertyAnimator animate = view.animate();
        this.A00.add(r6);
        animate.alpha(1.0f).setDuration(A03()).setListener(new C01053i(this, r6, view, animate)).start();
    }

    public final void A0b(AnonymousClass4X r9, int i, int i2, int i3, int deltaX) {
        View view = r9.A0H;
        int i4 = i3 - i;
        int deltaX2 = deltaX - i2;
        if (i4 != 0) {
            view.animate().translationX(0.0f);
        }
        if (deltaX2 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.A04.add(r9);
        animate.setDuration(A05()).setListener(new C01063j(this, r9, i4, view, deltaX2, animate)).start();
    }
}
