package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.OneSignalDbContract;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyReceiver;
import com.tapjoy.internal.ji;
import javax.annotation.Nullable;

public final class hb extends p {
    private static hb c;

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean c(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean d(String str) {
        return false;
    }

    public static synchronized hb b(Context context) {
        hb hbVar;
        synchronized (hb.class) {
            if (c == null) {
                c = new hb(context);
            }
            hbVar = c;
        }
        return hbVar;
    }

    private hb(Context context) {
        super(context, new r() {
            /* class com.tapjoy.internal.hb.AnonymousClass1 */

            @Override // com.tapjoy.internal.r
            public final String a(Context context) {
                return hj.a(context).b.getString("gcm.senderIds", "");
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context, String str) {
                n.a(hj.a(context).b, "gcm.senderIds", str);
            }

            @Override // com.tapjoy.internal.r
            public final String b(Context context) {
                return hj.a(context).b.getString("gcm.regId", "");
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context, String str) {
                n.a(hj.a(context).b, "gcm.regId", str);
            }

            @Override // com.tapjoy.internal.r
            public final boolean c(Context context) {
                return hj.a(context).b.getBoolean("gcm.stale", true);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context, boolean z) {
                n.a(hj.a(context).b, "gcm.stale", z);
            }

            @Override // com.tapjoy.internal.r
            public final int d(Context context) {
                return hj.a(context).b.getInt("gcm.appVersion", Integer.MIN_VALUE);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context, int i) {
                n.a(hj.a(context).b, "gcm.appVersion", i);
            }

            @Override // com.tapjoy.internal.r
            public final boolean e(Context context) {
                return hj.a(context).b.getBoolean("gcm.onServer", false);
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context, boolean z) {
                hj.a(context).a(z);
            }

            @Override // com.tapjoy.internal.r
            public final long f(Context context) {
                return hj.a(context).b.getLong("gcm.onServerExpirationTime", 0);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context, long j) {
                SharedPreferences.Editor edit = hj.a(context).b.edit();
                edit.putLong("gcm.onServerExpirationTime", j);
                edit.apply();
            }

            @Override // com.tapjoy.internal.r
            public final int g(Context context) {
                return hj.a(context).b.getInt("gcm.backoff", 0);
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context, int i) {
                n.a(hj.a(context).b, "gcm.backoff", i);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void e(String str) {
        if (str != null && str.length() > 0) {
            super.a(this.a);
            super.a(new String[]{str}[0]);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void a(Context context, String str) {
        gz.a(context).a(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void b(String str) {
        a();
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean a(Context context, Intent intent) {
        intent.getExtras();
        String stringExtra = intent.getStringExtra("fiverocks");
        if (stringExtra == null) {
            return false;
        }
        if (hc.a(context).f()) {
            gz.a(context).b(stringExtra);
            return true;
        }
        String stringExtra2 = intent.getStringExtra("title");
        String stringExtra3 = intent.getStringExtra("message");
        if (stringExtra3 != null) {
            Bundle extras = intent.getExtras();
            Object obj = extras.get("rich");
            Object obj2 = extras.get("sound");
            String string = extras.getString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            Object obj3 = extras.get(ReactScrollViewHelper.OVER_SCROLL_ALWAYS);
            boolean z = "true".equals(obj3) || Boolean.TRUE.equals(obj3);
            Object obj4 = extras.get("repeatable");
            boolean z2 = "true".equals(obj4) || Boolean.TRUE.equals(obj4);
            String string2 = extras.getString(IronSourceConstants.EVENTS_PLACEMENT_NAME);
            int b = b(extras.get("nid"));
            String string3 = extras.getString("channel_id");
            if (z || !gz.a(context).d()) {
                Notification a = a(context, stringExtra, jq.a(stringExtra2), stringExtra3, a(obj), a(obj2), string, string2, b, string3);
                if (gz.a(context).a(context, stringExtra, z2)) {
                    a(context, b, a);
                }
            }
        }
        return true;
    }

    public static boolean a(Object obj) {
        return Boolean.TRUE.equals(obj) || "true".equals(obj);
    }

    public static int b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void a(int i) {
        Integer.valueOf(i);
    }

    public static void a(Context context, int i, Notification notification) {
        ((NotificationManager) context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME)).notify(i, notification);
    }

    private static int a(Bundle bundle, String str, Context context) {
        if (bundle != null) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                try {
                    if ("drawable".equals(context.getResources().getResourceTypeName(intValue))) {
                        return intValue;
                    }
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (obj != null) {
                Object[] objArr = {str};
                if (gw.a) {
                    x.a(4, "Tapjoy", "meta-data of {} invalid", objArr);
                }
            }
        }
        return 0;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0058 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.text.Spanned] */
    @Nullable
    public static Notification a(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, int i, String str6) {
        Intent intent = new Intent(context.getApplicationContext(), TapjoyReceiver.class);
        intent.setAction("com.tapjoy.PUSH_CLICK");
        intent.putExtra("com.tapjoy.PUSH_ID", str);
        if (str4 != null) {
            intent.putExtra(Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD, str4);
        }
        if (str5 != null) {
            intent.putExtra("com.tapjoy.PUSH_PLACEMENT", str5);
        }
        int i2 = 134217728;
        if (Build.VERSION.SDK_INT == 19) {
            i2 = 268435456;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), i, intent, i2);
        String str7 = null;
        if (broadcast == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            int length = str2.length();
            Spanned spanned = str2;
            if (length == 0) {
                spanned = packageManager.getApplicationLabel(applicationInfo);
            } else if (z) {
                spanned = Html.fromHtml(str2);
            }
            if (z) {
                str3 = Html.fromHtml(str3);
            }
            int a = a(applicationInfo.metaData, "com.tapjoy.notification.icon", context);
            if (a == 0) {
                a = applicationInfo.icon != 0 ? applicationInfo.icon : 17301651;
            }
            int a2 = a(applicationInfo.metaData, "com.tapjoy.notification.icon.large", context);
            Bitmap decodeResource = a2 != 0 ? BitmapFactory.decodeResource(context.getResources(), a2) : null;
            if (str6 == null && applicationInfo.metaData != null) {
                str6 = applicationInfo.metaData.getString("com.tapjoy.notification.default_channel_id", "tapjoy");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
                if (str6 == null || notificationManager.getNotificationChannel(str6) == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("tapjoy", "Tapjoy", 3));
                    str7 = "tapjoy";
                } else {
                    str7 = str6;
                }
            }
            ji.c a3 = new ji.c(context, str7).a(a).c(spanned).a(spanned).b(str3).a(broadcast).a().c().a(new ji.b().a(spanned).b(str3));
            if (z2) {
                a3.b();
            }
            if (decodeResource != null) {
                a3.a(decodeResource);
            }
            return a3.d();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
