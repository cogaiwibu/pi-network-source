package com.iab.omid.library.ironsrc.b;

import android.content.Context;

public class b {
    private static b a = new b();
    private Context b;
    private boolean c;
    private boolean d;
    private a e;

    public interface a {
    }

    private b() {
    }

    public static b a() {
        return a;
    }

    private void e() {
        boolean z = !this.d;
        for (com.iab.omid.library.ironsrc.adsession.a aVar : a.a().b()) {
            aVar.getAdSessionStatePublisher().a(z);
        }
    }

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void b() {
        this.c = true;
        e();
    }

    public void c() {
        this.c = false;
        this.d = false;
        this.e = null;
    }

    public boolean d() {
        return !this.d;
    }
}
