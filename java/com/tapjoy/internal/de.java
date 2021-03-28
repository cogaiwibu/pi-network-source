package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.Collections;

public final class de {
    private static de f = new de();
    public Context a;
    public BroadcastReceiver b;
    public boolean c;
    public boolean d;
    public a e;

    public interface a {
        void a(boolean z);
    }

    private de() {
    }

    public static de a() {
        return f;
    }

    public final boolean b() {
        return !this.d;
    }

    public final void c() {
        boolean z = !this.d;
        for (cz czVar : Collections.unmodifiableCollection(dd.a().a)) {
            ds dsVar = czVar.c;
            if (dsVar.a.get() != null) {
                dg.a().a(dsVar.c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }

    static /* synthetic */ void a(de deVar, boolean z) {
        if (deVar.d != z) {
            deVar.d = z;
            if (deVar.c) {
                deVar.c();
                a aVar = deVar.e;
                if (aVar != null) {
                    aVar.a(deVar.b());
                }
            }
        }
    }
}
