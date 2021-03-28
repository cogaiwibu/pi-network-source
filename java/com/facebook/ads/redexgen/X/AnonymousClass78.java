package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;

/* renamed from: com.facebook.ads.redexgen.X.78  reason: invalid class name */
public final class AnonymousClass78 implements Runnable {
    public static String[] A01;
    public final Runnable A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"z7DaAYMF8mD5H3Qw6B0df8iWMA5TwaAo", "i1Wz58ppkDzwzyk3vUo3iJD7WEPTUBrQ", "4oPzuaqB78YGGa8PxFst9tbpOvboFZdU", "DouWW69VsyGxi7cZQAT3hM5mkvCiYUWz", "5sMQ3NVw4qAuaNcVNLKcvGJPjeyRgc94", "cawbZ6x1RsnaWkC6S2Mb4x7gKiXWIBBw", "BT64P8yXTg3gcHo3v2kn4U06ifDkl76a", "4iKgaC96n3YCvkeVNFuu4kvW5LMIVzNy"};
    }

    public AnonymousClass78(Runnable runnable) {
        this.A00 = runnable;
    }

    @SuppressLint({"CatchGeneralException"})
    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.run();
            } catch (Throwable th) {
                if (A01[0].charAt(29) != 'a') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "SMPhcSCea3djEKnuzKFzvQw1eCBqlauj";
                strArr[0] = "SMPhcSCea3djEKnuzKFzvQw1eCBqlauj";
                KU.A00(th, this);
            }
        }
    }
}
