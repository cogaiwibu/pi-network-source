package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.71  reason: invalid class name */
public final class AnonymousClass71 {
    public int A00;
    public final Context A01;
    public final C01725z A02;
    public final AbstractC01976y A03;
    public final AbstractC01986z A04;
    public final Set<C01786f> A05 = new HashSet();

    public AnonymousClass71(Context context, C01725z r3) {
        this.A02 = r3;
        this.A01 = context;
        this.A04 = r3.A0c();
        this.A03 = r3.A0b();
    }

    @Nullable
    private C01946v A00() {
        String packageName;
        if (this.A02.A0a() == EnumC01856m.A0G) {
            return null;
        }
        Context context = this.A01;
        if (context == null) {
            packageName = "";
        } else {
            packageName = context.getPackageName();
        }
        return new C01946v(packageName);
    }

    @SuppressLint({"CatchGeneralException"})
    private void A01(long j) {
        AbstractC01966x signalValueTypeDef;
        try {
            JSONObject jSONObject = new JSONObject();
            for (C01786f r7 : this.A05) {
                AbstractC01816i A012 = r7.A01();
                if (A012 == null) {
                    signalValueTypeDef = new WS(SystemClock.elapsedRealtime(), A00(), new C01936u(EnumC01926t.A04));
                } else {
                    try {
                        signalValueTypeDef = A012.A50();
                    } catch (Throwable th) {
                        signalValueTypeDef = AnonymousClass76.A04(this.A01.getPackageName(), th);
                    }
                }
                jSONObject.put(Integer.toString(r7.A00()), signalValueTypeDef.A0A(false));
            }
            throw null;
        } catch (Throwable t) {
            AnonymousClass6B.A04(t);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private void A02(long j) {
        try {
            this.A02.A0j().schedule(new AnonymousClass70(this), j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public final void A03() {
        if (this.A02.A0W() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.A04.getLastPeriodicCollectionTimeMs() >= this.A02.A0W()) {
                A01(currentTimeMillis);
                A02(this.A02.A0W());
                return;
            }
            A02(Math.abs(currentTimeMillis - (this.A04.getLastPeriodicCollectionTimeMs() + this.A02.A0W())));
        }
    }

    public final void A04(int i) {
        this.A00 = i;
    }

    public final void A05(C01786f r2) {
        this.A05.add(r2);
    }
}
