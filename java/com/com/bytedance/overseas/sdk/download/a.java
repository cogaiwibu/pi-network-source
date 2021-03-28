package com.com.bytedance.overseas.sdk.download;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.b;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import java.lang.ref.WeakReference;

/* compiled from: GPDownLoader */
public class a implements b {
    private WeakReference<Context> a;
    private b b;
    private g c;
    private String d;
    private boolean e = false;
    private boolean f = false;

    public a(Context context, g gVar, String str) {
        this.a = new WeakReference<>(context);
        this.c = gVar;
        l.c("GPDownLoader", gVar.C().toString());
        this.b = gVar.s();
        this.d = str;
        l.c("GPDownLoader", "====tag===" + str);
        if (this.b == null) {
            throw new RuntimeException("not a App type Ad !");
        } else if (j.a() == null) {
            j.a(context);
        }
    }

    @Override // com.com.bytedance.overseas.sdk.download.b
    public void a(boolean z) {
        this.f = z;
    }

    public boolean a(Context context, String str) {
        Intent launchIntentForPackage;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        l.c("GPDownLoader", "gotoGooglePlay :market://details?id=" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse("market://details?id=" + str);
        intent.setData(parse);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.equals("com.android.vending") && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending")) != null) {
                launchIntentForPackage.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                launchIntentForPackage.setData(parse);
                if (!(context instanceof Activity)) {
                    launchIntentForPackage.setFlags(268435456);
                }
                context.startActivity(launchIntentForPackage);
                return true;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        if (!(context instanceof Activity)) {
            intent2.setFlags(268435456);
        }
        context.startActivity(intent2);
        return true;
    }

    private Context e() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? j.a() : this.a.get();
    }

    @Override // com.com.bytedance.overseas.sdk.download.b
    public void a() {
        if (e() != null && this.b != null && !b() && !d()) {
            c();
        }
    }

    public boolean b() {
        if (this.c.t() == null) {
            return false;
        }
        String a2 = this.c.t().a();
        if (!TextUtils.isEmpty(a2)) {
            Uri parse = Uri.parse(a2);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (t.a(e(), intent)) {
                if (!(e() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                e().startActivity(intent);
                d.b(j.a(), this.c, this.d, "open_url_app");
                com.bytedance.sdk.openadsdk.b.j.a().a(this.c, this.d);
                return true;
            }
        }
        if (this.e) {
            return false;
        }
        this.e = true;
        d.b(e(), this.c, this.d, "open_fallback_url");
        return false;
    }

    @Override // com.com.bytedance.overseas.sdk.download.b
    public boolean c() {
        return a(e(), this.b.c());
    }

    @Override // com.com.bytedance.overseas.sdk.download.b
    public boolean d() {
        Intent a2;
        b bVar = this.b;
        if (bVar == null) {
            return false;
        }
        String c2 = bVar.c();
        if (TextUtils.isEmpty(c2) || !t.b(e(), c2) || (a2 = t.a(e(), c2)) == null) {
            return false;
        }
        a2.putExtra("START_ONLY_FOR_ANDROID", true);
        e().startActivity(a2);
        d.b(e(), this.c, this.d, "click_open");
        return true;
    }
}
