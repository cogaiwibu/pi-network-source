package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.eu;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.fe;
import com.tapjoy.internal.fh;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

public final class hc {
    public static final String a = UUID.randomUUID().toString();
    private static hc d;
    public final fh.a b = new fh.a();
    public final hj c;
    private final fa.a e = new fa.a();
    private final eu.a f = new eu.a();
    private final Context g;

    public static synchronized hc a(Context context) {
        hc hcVar;
        synchronized (hc.class) {
            if (d == null) {
                d = new hc(context, hj.a(context));
            }
            hcVar = d;
        }
        return hcVar;
    }

    private hc(Context context, hj hjVar) {
        hn.a();
        this.e.p = "12.4.2/Android";
        this.e.g = Constants.JAVASCRIPT_INTERFACE_NAME;
        this.e.h = Build.VERSION.RELEASE;
        this.e.e = Build.MANUFACTURER;
        this.e.f = Build.MODEL;
        this.e.l = Locale.getDefault().toString();
        this.e.m = TimeZone.getDefault().getID();
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        fa.a aVar = this.e;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
        File file = new File(gz.c(applicationContext), "deviceid");
        String string = sharedPreferences.getString(TapjoyConstants.PREF_ANALYTICS_ID, null);
        if (jq.c(string)) {
            String b2 = file.exists() ? jq.b(bg.a(file)) : null;
            string = b2 == null ? UUID.randomUUID().toString() : b2;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(TapjoyConstants.PREF_ANALYTICS_ID, string);
            edit.apply();
        }
        aVar.d = string;
        if (!ga.b().a(TapjoyConnectFlag.DISABLE_ANDROID_ID_AS_ANALYTICS_ID, true)) {
            fa.a aVar2 = this.e;
            String string2 = Settings.Secure.getString(applicationContext.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            aVar2.t = !"9774d56d682e549c".equals(string2) ? jq.b(string2) : null;
        }
        PackageManager packageManager = applicationContext.getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        if (telephonyManager != null) {
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!jq.c(simCountryIso)) {
                this.e.q = simCountryIso.toUpperCase(Locale.US);
            }
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!jq.c(networkCountryIso)) {
                this.e.r = networkCountryIso.toUpperCase(Locale.US);
            }
        }
        String packageName = applicationContext.getPackageName();
        this.e.n = packageName;
        fa.a aVar3 = this.e;
        Signature[] e2 = z.e(packageManager, packageName);
        aVar3.o = jq.a((e2 == null || e2.length <= 0) ? null : Base64.encodeToString(ch.a(e2[0].toByteArray()), 2));
        this.f.c = z.a(packageManager, packageName);
        this.f.d = Integer.valueOf(z.b(packageManager, packageName));
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (!jq.c(installerPackageName)) {
            this.f.f = installerPackageName;
        }
        String a2 = a(packageManager, packageName);
        if (!jq.c(a2)) {
            this.f.g = a2;
        }
        a();
        this.c = hjVar;
        String a3 = hjVar.c.a();
        if (a3 != null && a3.length() > 0) {
            fa.a aVar4 = this.e;
            aVar4.p = a3 + " 12.4.2/Android";
        }
        String b3 = this.c.b();
        if (b3 != null) {
            this.b.d = b3;
        }
        fh.a aVar5 = this.b;
        hj hjVar2 = this.c;
        long j = hjVar2.b.getLong("it", 0);
        if (j == 0) {
            Context context2 = hjVar2.a;
            j = z.c(context2.getPackageManager(), context2.getPackageName());
            if (j == 0) {
                j = gz.d(hjVar2.a).lastModified();
                if (j == 0) {
                    Context context3 = hjVar2.a;
                    j = new File(z.d(context3.getPackageManager(), context3.getPackageName())).lastModified();
                    if (j == 0) {
                        j = System.currentTimeMillis();
                    }
                }
            }
            hjVar2.b.edit().putLong("it", j).apply();
        }
        aVar5.c = Long.valueOf(j);
        int b4 = this.c.f.b();
        this.b.e = Integer.valueOf(a(7, b4));
        this.b.f = Integer.valueOf(a(30, b4));
        int b5 = this.c.h.b();
        if (b5 > 0) {
            this.b.h = Integer.valueOf(b5);
        }
        long a4 = this.c.i.a();
        if (a4 > 0) {
            this.b.i = Long.valueOf(a4);
        }
        long a5 = this.c.j.a();
        if (a5 > 0) {
            this.b.j = Long.valueOf(a5);
        }
        long a6 = this.c.k.a();
        if (a6 > 0) {
            this.b.k = Long.valueOf(a6);
        }
        String a7 = this.c.l.a();
        if (a7 != null) {
            this.b.l = a7;
        }
        int b6 = this.c.m.b();
        if (b6 > 0) {
            this.b.m = Integer.valueOf(b6);
        }
        double a8 = this.c.n.a();
        if (a8 != 0.0d) {
            this.b.n = Double.valueOf(a8);
        }
        long a9 = this.c.o.a();
        if (a9 > 0) {
            this.b.o = Long.valueOf(a9);
        }
        double a10 = this.c.p.a();
        if (a10 != 0.0d) {
            this.b.p = Double.valueOf(a10);
        }
        String a11 = this.c.g.a();
        if (a11 != null) {
            try {
                byte[] decode = Base64.decode(a11, 2);
                this.b.g.clear();
                this.b.g.addAll(((ff) ff.c.a(decode)).d);
            } catch (IllegalArgumentException unused) {
                this.c.g.c();
            } catch (IOException unused2) {
                this.c.g.c();
            }
        }
        this.f.e = this.c.q.a();
        this.b.s = this.c.r.a();
        int intValue = this.c.s.a().intValue();
        this.b.t = intValue != -1 ? Integer.valueOf(intValue) : null;
        int intValue2 = this.c.t.a().intValue();
        this.b.u = intValue2 != -1 ? Integer.valueOf(intValue2) : null;
        this.b.v = this.c.u.a();
        this.b.w = this.c.v.a();
        this.b.x = this.c.w.a();
        this.b.y = this.c.x.a();
        this.b.z = this.c.y.a();
        String a12 = this.c.z.a();
        if (a12 != null) {
            try {
                byte[] decode2 = Base64.decode(a12, 2);
                this.b.A.clear();
                this.b.A.addAll(((fg) fg.c.a(decode2)).d);
            } catch (IllegalArgumentException unused3) {
                this.c.z.c();
            } catch (IOException unused4) {
                this.c.z.c();
            }
        }
        String a13 = this.c.A.a();
        boolean booleanValue = this.c.B.a().booleanValue();
        if (a13 != null) {
            this.b.q = a13;
            this.b.r = Boolean.valueOf(booleanValue);
        } else {
            this.b.q = null;
            this.b.r = null;
        }
        this.b.B = this.c.C.a();
    }

    private static String a(PackageManager packageManager, String str) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            if (bundle == null || (obj = bundle.get("com.tapjoy.appstore")) == null) {
                return null;
            }
            return obj.toString().trim();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            monitor-enter(r4)
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0057 }
            r0.<init>()     // Catch:{ Exception -> 0x0057 }
            android.content.Context r1 = r4.g     // Catch:{ Exception -> 0x0057 }
            java.lang.String r2 = "window"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0057 }
            android.view.WindowManager r1 = (android.view.WindowManager) r1     // Catch:{ Exception -> 0x0057 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ Exception -> 0x0057 }
            r1.getMetrics(r0)     // Catch:{ Exception -> 0x0057 }
            android.app.Activity r1 = com.tapjoy.internal.gr.a()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            android.view.Window r1 = r1.getWindow()     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x0036
            int r2 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            android.graphics.Rect r3 = new android.graphics.Rect     // Catch:{ Exception -> 0x0057 }
            r3.<init>()     // Catch:{ Exception -> 0x0057 }
            android.view.View r1 = r1.getDecorView()     // Catch:{ Exception -> 0x0057 }
            r1.getWindowVisibleDisplayFrame(r3)     // Catch:{ Exception -> 0x0057 }
            int r1 = r3.top     // Catch:{ Exception -> 0x0057 }
            int r2 = r2 - r1
            r0.heightPixels = r2     // Catch:{ Exception -> 0x0057 }
        L_0x0036:
            com.tapjoy.internal.fa$a r1 = r4.e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.densityDpi     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.i = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.e     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.widthPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0057 }
            r1.j = r2     // Catch:{ Exception -> 0x0057 }
            com.tapjoy.internal.fa$a r1 = r4.e     // Catch:{ Exception -> 0x0057 }
            int r0 = r0.heightPixels     // Catch:{ Exception -> 0x0057 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0057 }
            r1.k = r0     // Catch:{ Exception -> 0x0057 }
            goto L_0x0057
        L_0x0055:
            r0 = move-exception
            goto L_0x0059
        L_0x0057:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            return
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hc.a():void");
    }

    public final fb b() {
        fb fbVar;
        synchronized (this) {
            this.e.l = Locale.getDefault().toString();
            this.e.m = TimeZone.getDefault().getID();
            boolean z = false;
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            Iterator it = this.b.g.iterator();
            while (it.hasNext()) {
                if (((fe) it.next()).g.longValue() <= currentTimeMillis) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                g();
            }
            fbVar = new fb(this.e.b(), this.f.b(), this.b.b());
        }
        return fbVar;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        String a2;
        synchronized (this) {
            a2 = this.c.d.a();
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00dc  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tapjoy.internal.fc d() {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hc.d():com.tapjoy.internal.fc");
    }

    private static int a(int i, int i2) {
        return Integer.bitCount(((1 << i) - 1) & i2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(String str, long j, boolean z) {
        synchronized (this) {
            int size = this.b.g.size();
            for (int i = 0; i < size; i++) {
                fe feVar = (fe) this.b.g.get(i);
                if (feVar.f.equals(str)) {
                    if (!z) {
                        return false;
                    } else {
                        fe.a b2 = feVar.b();
                        b2.d = Long.valueOf(j);
                        this.b.g.set(i, b2.b());
                        return true;
                    }
                }
            }
            this.b.g.add(new fe(str, Long.valueOf(j)));
            g();
            return true;
        }
    }

    private void g() {
        this.c.g.a(Base64.encodeToString(ff.c.b(new ff(this.b.g)), 2));
    }

    public final boolean a(String str) {
        boolean z;
        synchronized (this) {
            this.c.q.a(str);
            z = true;
            if (str != null) {
                if (jo.a(this.f.e, str)) {
                    z = false;
                }
                this.f.e = str;
            } else {
                if (this.f.e == null) {
                    z = false;
                }
                this.f.e = null;
            }
        }
        return z;
    }

    public final boolean b(String str) {
        boolean z;
        synchronized (this) {
            this.c.r.a(str);
            z = !jo.a(this.b.s, str);
            if (z) {
                this.b.s = str;
            }
        }
        return z;
    }

    public final boolean a(Integer num) {
        boolean z;
        synchronized (this) {
            this.c.s.a(num);
            z = !jo.a(this.b.t, num);
            if (z) {
                this.b.t = num;
            }
        }
        return z;
    }

    public final boolean b(Integer num) {
        boolean z;
        synchronized (this) {
            this.c.t.a(num);
            z = !jo.a(this.b.u, num);
            if (z) {
                this.b.u = num;
            }
        }
        return z;
    }

    public final boolean a(int i, String str) {
        boolean z;
        synchronized (this) {
            z = false;
            if (i == 1) {
                this.c.u.a(str);
                z = !jo.a(this.b.v, str);
                if (z) {
                    this.b.v = str;
                }
            } else if (i == 2) {
                this.c.v.a(str);
                z = !jo.a(this.b.w, str);
                if (z) {
                    this.b.w = str;
                }
            } else if (i == 3) {
                this.c.w.a(str);
                z = !jo.a(this.b.x, str);
                if (z) {
                    this.b.x = str;
                }
            } else if (i == 4) {
                this.c.x.a(str);
                z = !jo.a(this.b.y, str);
                if (z) {
                    this.b.y = str;
                }
            } else if (i == 5) {
                this.c.y.a(str);
                z = !jo.a(this.b.z, str);
                if (z) {
                    this.b.z = str;
                }
            }
        }
        return z;
    }

    public final Set e() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.b.A);
        }
        return hashSet;
    }

    public final boolean c(String str) {
        synchronized (this) {
            for (int size = this.b.g.size() - 1; size >= 0; size--) {
                fe feVar = (fe) this.b.g.get(size);
                if (feVar.f.equals(str)) {
                    fe.a b2 = feVar.b();
                    b2.e = Long.valueOf(System.currentTimeMillis());
                    this.b.g.set(size, b2.b());
                    g();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean f() {
        return ((Boolean) jo.b(this.b.B, fh.r)).booleanValue();
    }

    public final boolean a(boolean z) {
        boolean z2;
        synchronized (this) {
            this.c.C.a(z);
            z2 = z != ((Boolean) jo.b(this.b.B, fh.r)).booleanValue();
            this.b.B = Boolean.valueOf(z);
        }
        return z2;
    }
}
