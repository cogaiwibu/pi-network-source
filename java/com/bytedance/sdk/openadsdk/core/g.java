package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.g.c;
import com.bytedance.sdk.openadsdk.g.h;
import com.bytedance.sdk.openadsdk.g.n;
import com.bytedance.sdk.openadsdk.g.q;
import com.bytedance.sdk.openadsdk.h.f;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: GlobalInfo */
public class g {
    private static final g p = new g();
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;
    private AtomicBoolean f = new AtomicBoolean(false);
    private int g = 0;
    private boolean h = true;
    private boolean i = false;
    private final HashSet<Integer> j;
    private boolean k;
    private Bitmap l;
    private int m;
    private int n;
    private f o;
    private com.bytedance.sdk.openadsdk.h.a.f q;

    private g() {
        HashSet<Integer> hashSet = new HashSet<>();
        this.j = hashSet;
        this.k = false;
        this.l = null;
        this.m = 0;
        this.n = 0;
        hashSet.add(4);
        if (j.a() != null && (j.a() instanceof Application)) {
            ((Application) j.a()).registerActivityLifecycleCallbacks(new a());
        } else if (j.a() != null && j.a().getApplicationContext() != null) {
            ((Application) j.a().getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }

    public f a() {
        f fVar = this.o;
        if (fVar != null) {
            return fVar;
        }
        f r = r();
        this.o = r;
        return r;
    }

    private f r() {
        return new f.a(j.a()).a(h.a(j.a())).a();
    }

    public static g b() {
        return p;
    }

    public void a(boolean z) {
        this.f.set(z);
    }

    public boolean c() {
        return this.f.get();
    }

    public String d() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", null);
        }
        return this.a;
    }

    public void a(String str) {
        e(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
        }
        this.a = str;
    }

    public String e() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", null);
        }
        return this.b;
    }

    public void b(String str) {
        f(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.b = str;
    }

    public void a(int i2) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", Integer.valueOf(i2));
        } else {
            q.a((String) null, j.a()).a("sdk_coppa", i2);
        }
        this.m = i2;
    }

    public int f() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", 0);
        }
        int b2 = q.a((String) null, j.a()).b("sdk_coppa", 0);
        this.m = b2;
        return b2;
    }

    public int g() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", -1);
        }
        return q.a((String) null, j.a()).b("tt_gdrp", -1);
    }

    public void b(int i2) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", Integer.valueOf(i2));
        } else {
            q.a((String) null, j.a()).a("tt_gdrp", i2);
        }
    }

    public void c(int i2) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", Integer.valueOf(i2));
        } else {
            q.a((String) null, j.a()).a("global_coppa", i2);
        }
        this.n = i2;
    }

    public int h() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", -99);
        }
        int b2 = q.a((String) null, j.a()).b("global_coppa", -99);
        this.n = b2;
        if (b2 == -99) {
            this.n = f();
        }
        return this.n;
    }

    public boolean i() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false);
        }
        return this.c;
    }

    public void b(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.c = z;
    }

    public String j() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", null);
        }
        return this.d;
    }

    public void c(String str) {
        g(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.d = str;
    }

    public String k() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", null);
        }
        return this.e;
    }

    public void d(String str) {
        h(str);
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.e = str;
    }

    public void d(int i2) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i2));
        }
        this.g = i2;
    }

    public int l() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0);
        }
        return this.g;
    }

    public void c(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.i = z;
    }

    public boolean m() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", false);
        }
        return this.i;
    }

    public void n() {
        e(this.a);
        f(this.b);
    }

    private static void e(String str) {
        n.a(str, "appid不能为空");
    }

    private static void f(String str) {
        n.a(str, "name不能为空");
    }

    private static void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            n.a(str.length() <= 1000, "keyword超长, 最长为1000");
        }
    }

    private static void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            n.a(str.length() <= 1000, "data超长, 最长为1000");
        }
    }

    public com.bytedance.sdk.openadsdk.h.a.f o() {
        if (this.q == null) {
            this.q = new com.bytedance.sdk.openadsdk.h.a.f(10, 5);
        }
        return this.q;
    }

    public boolean p() {
        if (b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false);
        }
        return this.k;
    }

    public void d(boolean z) {
        if (b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public Bitmap q() {
        if (b.b()) {
            return c.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", null));
        }
        return this.l;
    }
}
