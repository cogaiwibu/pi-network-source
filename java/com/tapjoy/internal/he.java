package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.WindowManager;
import com.tapjoy.TJContentActivity;

public class he extends hg {
    private static final String h = he.class.getSimpleName();
    private static he i;
    final String a;
    final hu b;
    private final gz j;
    private c k;
    private boolean l;
    private long m;
    private Context n;
    private boolean o = false;

    public static void a() {
        he heVar = i;
        if (heVar != null) {
            heVar.e();
        }
    }

    public he(gz gzVar, String str, hu huVar, Context context) {
        this.j = gzVar;
        this.a = str;
        this.b = huVar;
        this.n = context;
    }

    @Override // com.tapjoy.internal.hg
    public final void b() {
        hu huVar = this.b;
        if (huVar.a != null) {
            huVar.a.b();
        }
        if (huVar.b != null) {
            huVar.b.b();
        }
        huVar.c.b();
        if (huVar.e != null) {
            huVar.e.b();
        }
        if (huVar.f != null) {
            huVar.f.b();
        }
        if (huVar.m != null && huVar.m.a != null) {
            huVar.m.a.b();
        }
    }

    @Override // com.tapjoy.internal.hg
    public final boolean c() {
        hu huVar = this.b;
        if (huVar.c == null || huVar.c.b == null) {
            return false;
        }
        if (huVar.m != null && huVar.m.a != null && huVar.m.a.b == null) {
            return false;
        }
        if (huVar.b == null || huVar.f == null || huVar.b.b == null || huVar.f.b == null) {
            return (huVar.a == null || huVar.e == null || huVar.a.b == null || huVar.e.b == null) ? false : true;
        }
        return true;
    }

    @Override // com.tapjoy.internal.hg
    public final void a(final ha haVar, final fw fwVar) {
        Activity a2 = a.a(this.n);
        if (a2 != null && !a2.isFinishing()) {
            try {
                a(a2, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a3 = gr.a();
        try {
            TJContentActivity.start(gz.a().e, new TJContentActivity.AbstractContentProducer() {
                /* class com.tapjoy.internal.he.AnonymousClass1 */

                @Override // com.tapjoy.TJContentActivity.ContentProducer
                public final void show(Activity activity) {
                    try {
                        he.this.a(activity, haVar, fwVar);
                    } catch (WindowManager.BadTokenException unused) {
                        gw.b("Failed to show the content for \"{}\" caused by invalid activity", he.this.a);
                        haVar.a(he.this.a, he.this.f, null);
                    }
                }

                @Override // com.tapjoy.TJContentActivity.ContentProducer, com.tapjoy.TJContentActivity.AbstractContentProducer
                public final void dismiss(Activity activity) {
                    he.this.e();
                }
            }, (a3 == null || (a3.getWindow().getAttributes().flags & 1024) == 0) ? false : true);
        } catch (ActivityNotFoundException unused2) {
            if (a3 != null && !a3.isFinishing()) {
                try {
                    a(a3, haVar, fwVar);
                    return;
                } catch (WindowManager.BadTokenException unused3) {
                    gw.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
                    haVar.a(this.a, this.f, null);
                }
            }
            gw.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.a);
            haVar.a(this.a, this.f, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final android.app.Activity r13, final com.tapjoy.internal.ha r14, com.tapjoy.internal.fw r15) {
        /*
        // Method dump skipped, instructions count: 466
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.he.a(android.app.Activity, com.tapjoy.internal.ha, com.tapjoy.internal.fw):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        c cVar = this.k;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    private static Boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get("tapjoy:hardwareAccelerated");
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
