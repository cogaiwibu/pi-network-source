package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.64  reason: invalid class name */
public final class AnonymousClass64<T> {
    public static String[] A02;
    public final int A00;
    public final LinkedBlockingDeque<T> A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"dOZKS2ZI7II", "H1g7gqR2EKn", "HfxVquxaUjpYbjJdoITajwkesDv6b5OP", "LKGrDWI4UhzaVgtHDOFVkFmAOkdfM3kS", "eoAuUQbCqIbnVyiqi6nAqoKpMgu8SE72", "BREsl3NjjeIkGT8YX46XMxY6QnBlFPku", "r0N9JiiALcRfLFwgFUe0Fbolf1MfiQ1h", "O05UPhpRrjuDMd"};
    }

    public AnonymousClass64(int i) {
        this.A01 = new LinkedBlockingDeque<>(i);
        this.A00 = i;
    }

    public final synchronized int A01() {
        int remainingCapacity;
        remainingCapacity = this.A01.remainingCapacity();
        if (A02[4].charAt(17) != 't') {
            String[] strArr = A02;
            strArr[4] = "R8iXUhs6Ry9t7OlTnDSaYaqPOUvaVcmE";
            strArr[4] = "R8iXUhs6Ry9t7OlTnDSaYaqPOUvaVcmE";
            return remainingCapacity;
        }
        throw new RuntimeException<>();
    }

    @Nullable
    public final synchronized T A02() {
        if (this.A01.isEmpty()) {
            return null;
        }
        return this.A01.peekFirst();
    }

    @Nullable
    public final synchronized T A03() {
        if (this.A01.isEmpty()) {
            return null;
        }
        return this.A01.peekLast();
    }

    public final synchronized List<T> A04() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        CircularBuffer<T> it = this.A01.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public final synchronized void A05(T t) {
        if (this.A00 > 0) {
            if (!this.A01.isEmpty() && A01() == 0) {
                this.A01.removeFirst();
            }
            this.A01.offer(t);
        }
    }
}
