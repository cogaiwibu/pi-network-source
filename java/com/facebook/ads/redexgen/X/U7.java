package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import java.util.HashMap;

public final class U7 extends AnonymousClass6Z {
    public final Context A00;
    public final ApplicationInfo A01;
    public final C01725z A02;
    public final AnonymousClass72 A03 = AnonymousClass72.A00(this.A00, this.A02.A0a(), this.A02.A0g());

    public U7(Context context, C01725z r5) {
        super(context, r5);
        this.A01 = context.getApplicationInfo();
        this.A00 = context;
        this.A02 = r5;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC01966x A05(HashMap<Integer, U6> hashMap) {
        return new WY(SystemClock.elapsedRealtime(), A03(), hashMap, EnumC01956w.A06);
    }

    public final AbstractC01816i A0H() {
        return new C0757Tw(this);
    }

    public final AbstractC01816i A0I() {
        return new C0755Tu(this);
    }

    public final AbstractC01816i A0J() {
        return new C0754Tt(this);
    }

    public final AbstractC01816i A0K() {
        return new C0750Tp(this);
    }

    public final AbstractC01816i A0L() {
        return new U1(this);
    }

    public final AbstractC01816i A0M() {
        return new U4(this);
    }

    public final AbstractC01816i A0N() {
        return new C0758Tx(this);
    }

    public final AbstractC01816i A0O() {
        return new C0759Ty(this);
    }

    public final AbstractC01816i A0P() {
        return new U2(this);
    }

    public final AbstractC01816i A0Q() {
        return new U5(this);
    }

    public final AbstractC01816i A0R() {
        return new U3(this);
    }

    public final AbstractC01816i A0S() {
        return new U0(this);
    }

    public final AbstractC01816i A0T() {
        return new C0760Tz(this);
    }

    public final AbstractC01816i A0U() {
        return new C0748Tn(this);
    }

    public final AbstractC01816i A0V() {
        return new C0749To(this);
    }

    public final AbstractC01816i A0W() {
        return new C0751Tq(this);
    }

    public final AbstractC01816i A0X() {
        return new C0752Tr(this);
    }

    public final AbstractC01816i A0Y() {
        return new C0753Ts(this);
    }

    public final AbstractC01816i A0Z() {
        return new C0756Tv(this);
    }
}
