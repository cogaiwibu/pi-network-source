package com.iab.omid.library.ironsrc.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ironsrc.a.c;
import com.iab.omid.library.ironsrc.a.d;
import com.iab.omid.library.ironsrc.a.e;
import com.iab.omid.library.ironsrc.adsession.a;
import com.iab.omid.library.ironsrc.b.b;
import com.iab.omid.library.ironsrc.walking.TreeWalker;

public class f implements c, b.a {
    private static f a;
    private float b = 0.0f;
    private final e c;
    private final com.iab.omid.library.ironsrc.a.b d;
    private d e;
    private a f;

    public f(e eVar, com.iab.omid.library.ironsrc.a.b bVar) {
        this.c = eVar;
        this.d = bVar;
    }

    public static f a() {
        if (a == null) {
            a = new f(new e(), new com.iab.omid.library.ironsrc.a.b());
        }
        return a;
    }

    private a e() {
        if (this.f == null) {
            this.f = a.a();
        }
        return this.f;
    }

    @Override // com.iab.omid.library.ironsrc.a.c
    public void a(float f2) {
        this.b = f2;
        for (a aVar : e().c()) {
            aVar.getAdSessionStatePublisher().a(f2);
        }
    }

    public void a(Context context) {
        this.e = this.c.a(new Handler(), context, this.d.a(), this);
    }

    public void b() {
        b.a().a(this);
        b.a().b();
        if (b.a().d()) {
            TreeWalker.getInstance().a();
        }
        this.e.a();
    }

    public void c() {
        TreeWalker.getInstance().b();
        b.a().c();
        this.e.b();
    }

    public float d() {
        return this.b;
    }
}
