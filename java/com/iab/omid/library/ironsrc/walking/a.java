package com.iab.omid.library.ironsrc.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.ironsrc.b.c;
import com.iab.omid.library.ironsrc.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class a {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, C0019a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private boolean h;

    /* renamed from: com.iab.omid.library.ironsrc.walking.a$a  reason: collision with other inner class name */
    public static class C0019a {
        private final c a;
        private final ArrayList<String> b = new ArrayList<>();

        public C0019a(c cVar, String str) {
            this.a = cVar;
            a(str);
        }

        public c a() {
            return this.a;
        }

        public void a(String str) {
            this.b.add(str);
        }

        public ArrayList<String> b() {
            return this.b;
        }
    }

    private void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        for (c cVar : aVar.a()) {
            a(cVar, aVar);
        }
    }

    private void a(c cVar, com.iab.omid.library.ironsrc.adsession.a aVar) {
        View view = (View) cVar.a().get();
        if (view != null) {
            C0019a aVar2 = this.b.get(view);
            if (aVar2 != null) {
                aVar2.a(aVar.getAdSessionId());
            } else {
                this.b.put(view, new C0019a(cVar, aVar.getAdSessionId()));
            }
        }
    }

    private String d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String e2 = f.e(view);
            if (e2 != null) {
                return e2;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.d.addAll(hashSet);
        return null;
    }

    public String a(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public String a(String str) {
        return this.g.get(str);
    }

    public HashSet<String> a() {
        return this.e;
    }

    public View b(String str) {
        return this.c.get(str);
    }

    public C0019a b(View view) {
        C0019a aVar = this.b.get(view);
        if (aVar != null) {
            this.b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> b() {
        return this.f;
    }

    public c c(View view) {
        return this.d.contains(view) ? c.PARENT_VIEW : this.h ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void c() {
        com.iab.omid.library.ironsrc.b.a a2 = com.iab.omid.library.ironsrc.b.a.a();
        if (a2 != null) {
            for (com.iab.omid.library.ironsrc.adsession.a aVar : a2.c()) {
                View d2 = aVar.d();
                if (aVar.e()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (d2 != null) {
                        String d3 = d(d2);
                        if (d3 == null) {
                            this.e.add(adSessionId);
                            this.a.put(d2, adSessionId);
                            a(aVar);
                        } else {
                            this.f.add(adSessionId);
                            this.c.put(adSessionId, d2);
                            this.g.put(adSessionId, d3);
                        }
                    } else {
                        this.f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h = false;
    }

    public void e() {
        this.h = true;
    }
}
