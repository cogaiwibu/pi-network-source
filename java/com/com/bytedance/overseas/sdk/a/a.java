package com.com.bytedance.overseas.sdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* compiled from: AdvertisingIdHelper */
public class a {
    private static a d;
    private String a = "";
    private final ExecutorService b = Executors.newSingleThreadExecutor();
    private String c;

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private a() {
    }

    public String b() {
        if (TextUtils.isEmpty(this.c)) {
            a(j.a());
        }
        return this.c;
    }

    private void a(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            for (int i = 0; i < installedPackages.size(); i++) {
                PackageInfo packageInfo = installedPackages.get(i);
                if ("com.android.vending".equals(packageInfo.packageName)) {
                    this.c = "" + packageInfo.versionCode;
                    l.c("GPVersion", "versionCode:" + packageInfo.versionCode);
                }
            }
        } catch (Throwable th) {
            l.b("AdvertisingIdHelper", "initGPVersion error", th);
        }
    }

    public String c() {
        try {
            this.a = com.bytedance.sdk.openadsdk.multipro.d.a.b("name_gaid", "gaid", "");
            l.c("gaid-", "getGAIdTimeOut-mGAId=" + this.a);
            if (TextUtils.isEmpty(this.a)) {
                FutureTask futureTask = new FutureTask(new CallableC0010a());
                this.b.execute(futureTask);
                this.a = (String) futureTask.get(500000, TimeUnit.MICROSECONDS);
            }
        } catch (Throwable th) {
            l.b("AdvertisingIdHelper", "getGAIdTimeOut error", th);
        }
        return this.a;
    }

    public String d() {
        try {
            a(j.a());
            this.a = com.bytedance.sdk.openadsdk.multipro.d.a.b("name_gaid", "gaid", "");
            l.c("gaid-", "getGAIdTimeOut-mGAId=" + this.a);
            if (TextUtils.isEmpty(this.a)) {
                this.b.execute(new FutureTask(new CallableC0010a()));
            }
        } catch (Throwable th) {
            l.b("AdvertisingIdHelper", "initGAIdByAsyc error", th);
        }
        return this.a;
    }

    /* access modifiers changed from: private */
    /* renamed from: com.com.bytedance.overseas.sdk.a.a$a  reason: collision with other inner class name */
    /* compiled from: AdvertisingIdHelper */
    public class CallableC0010a implements Callable<String> {
        private CallableC0010a() {
        }

        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(j.a());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    l.b("gaid-", "getAdvertisingId: " + id);
                    a.b(id);
                }
            } catch (Throwable th) {
                l.b("AdvertisingIdHelper", "getAdvertisingIdInfo error", th);
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(j.a());
                if (advertisingIdInfo2 != null) {
                    a.this.a = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable th2) {
                l.b("AdvertisingIdHelper", "getAdvertisingIdInfo error", th2);
            }
            l.b("AdvertisingIdHelper", "mGAId:" + a.this.a + " , get gaid consume time :" + (System.currentTimeMillis() - currentTimeMillis));
            return a.this.a;
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("name_gaid", "gaid", str);
        }
    }
}
