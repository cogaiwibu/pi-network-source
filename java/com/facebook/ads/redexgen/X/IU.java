package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.PriorityQueue;

public final class IU {
    public int A00 = Integer.MIN_VALUE;
    public final Object A01 = new Object();
    public final PriorityQueue<Integer> A02 = new PriorityQueue<>(10, Collections.reverseOrder());

    public final void A00(int i) {
        synchronized (this.A01) {
            this.A02.add(Integer.valueOf(i));
            this.A00 = Math.max(this.A00, i);
        }
    }

    public final void A01(int i) throws InterruptedException {
        synchronized (this.A01) {
            while (this.A00 != i) {
                this.A01.wait();
            }
        }
    }

    public final void A02(int i) throws IT {
        synchronized (this.A01) {
            if (this.A00 != i) {
                throw new IT(i, this.A00);
            }
        }
    }

    public final void A03(int i) {
        synchronized (this.A01) {
            this.A02.remove(Integer.valueOf(i));
            this.A00 = this.A02.isEmpty() ? Integer.MIN_VALUE : this.A02.peek().intValue();
            this.A01.notifyAll();
        }
    }
}
