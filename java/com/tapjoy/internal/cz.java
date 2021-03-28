package com.tapjoy.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public final class cz extends cs {
    public final ct a;
    public final List b = new ArrayList();
    public ds c;
    public boolean d = false;
    public boolean e = false;
    public String f;
    boolean g;
    private final cu h;
    private dq i;

    private void b(View view) {
        this.i = new dq(view);
    }

    public final View c() {
        return (View) this.i.get();
    }

    public final boolean d() {
        return this.d && !this.e;
    }

    cz(ct ctVar, cu cuVar) {
        this.a = ctVar;
        this.h = cuVar;
        this.f = UUID.randomUUID().toString();
        b(null);
        if (cuVar.f == cv.HTML) {
            this.c = new dt(cuVar.b);
        } else {
            this.c = new du(Collections.unmodifiableList(cuVar.c), cuVar.d);
        }
        this.c.a();
        dd.a().a.add(this);
        ds dsVar = this.c;
        dg a2 = dg.a();
        WebView c2 = dsVar.c();
        JSONObject jSONObject = new JSONObject();
        dm.a(jSONObject, "impressionOwner", ctVar.a);
        dm.a(jSONObject, "videoEventsOwner", ctVar.b);
        dm.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(ctVar.c));
        a2.a(c2, "init", jSONObject);
    }

    @Override // com.tapjoy.internal.cs
    public final void a() {
        if (!this.d) {
            this.d = true;
            dd a2 = dd.a();
            boolean b2 = a2.b();
            a2.b.add(this);
            if (!b2) {
                dh a3 = dh.a();
                de.a().e = a3;
                de a4 = de.a();
                a4.b = new BroadcastReceiver() {
                    /* class com.tapjoy.internal.de.AnonymousClass1 */

                    public final void onReceive(Context context, Intent intent) {
                        KeyguardManager keyguardManager;
                        if (intent != null) {
                            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                                de.a(de.this, true);
                            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                                de.a(de.this, false);
                            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                de.a(de.this, false);
                            }
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                a4.a.registerReceiver(a4.b, intentFilter);
                a4.c = true;
                a4.c();
                if (de.a().b()) {
                    dv.a();
                    dv.b();
                }
                cp cpVar = a3.b;
                cpVar.b = cpVar.a();
                cpVar.b();
                cpVar.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, cpVar);
            }
            this.c.a(dh.a().a);
            this.c.a(this, this.h);
        }
    }

    @Override // com.tapjoy.internal.cs
    public final void a(View view) {
        if (!this.e) {
            Cdo.a(view, "AdView is null");
            if (c() != view) {
                b(view);
                this.c.d();
                Collection<cz> unmodifiableCollection = Collections.unmodifiableCollection(dd.a().a);
                if (unmodifiableCollection != null && unmodifiableCollection.size() > 0) {
                    for (cz czVar : unmodifiableCollection) {
                        if (czVar != this && czVar.c() == view) {
                            czVar.i.clear();
                        }
                    }
                }
            }
        }
    }

    @Override // com.tapjoy.internal.cs
    public final void b() {
        if (!this.e) {
            this.i.clear();
            if (!this.e) {
                this.b.clear();
            }
            this.e = true;
            dg.a().a(this.c.c(), "finishSession", new Object[0]);
            dd a2 = dd.a();
            boolean b2 = a2.b();
            a2.a.remove(this);
            a2.b.remove(this);
            if (b2 && !a2.b()) {
                dh a3 = dh.a();
                dv a4 = dv.a();
                dv.c();
                a4.b.clear();
                dv.a.post(new Runnable() {
                    /* class com.tapjoy.internal.dv.AnonymousClass1 */

                    public final void run() {
                        dv.this.h.b();
                    }
                });
                de a5 = de.a();
                if (!(a5.a == null || a5.b == null)) {
                    a5.a.unregisterReceiver(a5.b);
                    a5.b = null;
                }
                a5.c = false;
                a5.d = false;
                a5.e = null;
                cp cpVar = a3.b;
                cpVar.a.getContentResolver().unregisterContentObserver(cpVar);
            }
            this.c.b();
            this.c = null;
        }
    }
}
