package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

public class JS implements View.OnTouchListener {
    public static String[] A01;
    public final /* synthetic */ C0998bP A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Jj6DPCpvRav0Dl4Hzko1ZYQ46cJHU9e3", "aRIYRX895b825x5MQHViVQuTPsX5EcgU", "WsB7SnaDyHBw", "ElhXrOblYWeIXKV5fK", "0U38eQ8bNMWMKT3qwHCBhGirZFomfBRA", "KG5ePHom1Hb0a65hRE12sPtgaad7Jk0V", "yn6apVjnupr8JkU7fdbub5PEYmvdUytV", "Qv1reMq3fGwFA"};
    }

    public JS(C0998bP bPVar) {
        this.A00 = bPVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A00.A04 != null) {
            int action = motionEvent.getAction();
            if (A01[6].charAt(0) != 'l') {
                String[] strArr = A01;
                strArr[1] = "gh2YpB8N5DvGnIVUwjzoCnzlhXQ6xZpi";
                strArr[4] = "c0aZKZ8jQy4nragOlR5MHbPn3w24MGfh";
                if (action == 1) {
                    this.A00.A04.A0j();
                }
            } else {
                throw new RuntimeException();
            }
        }
        return true;
    }
}
