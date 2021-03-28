package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TapjoyConstants;
import java.sql.Timestamp;

public abstract class p extends q {
    public final Context a;
    public final r b;
    private boolean c = false;

    public p(Context context, r rVar) {
        this.a = context.getApplicationContext();
        this.b = rVar;
    }

    private boolean b() {
        boolean e = this.b.e(this.a);
        if (!e) {
            return e;
        }
        long f = this.b.f(this.a);
        if (f == 0 || System.currentTimeMillis() <= f) {
            return e;
        }
        new Timestamp(f);
        return false;
    }

    public final boolean a() {
        String a2 = this.b.a(this.a);
        if (jq.c(a2)) {
            return false;
        }
        a(a2);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        String b2 = this.b.b(this.a);
        if (b2.length() == 0) {
            e(str);
        } else if (!str.equals(this.b.a(this.a))) {
            e(str);
        } else {
            int d = this.b.d(this.a);
            int a2 = z.a(this.a);
            if (d != Integer.MIN_VALUE && d != a2) {
                Integer.valueOf(d);
                Integer.valueOf(a2);
                e(str);
            } else if (this.b.c(this.a)) {
                e(str);
            } else if (!b()) {
                a(this.a, b2);
            }
        }
    }

    private void e(String str) {
        this.b.a(this.a, str);
        this.b.a(this.a, true);
        if ((this.c || !b(this.a, str)) && c(this.a, str)) {
        }
    }

    private static boolean b(Context context, String str) {
        try {
            int b2 = z.b(context.getPackageManager(), "com.google.android.gms");
            if (b2 >= 3159130) {
                Integer.valueOf(b2);
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                b(context, intent);
                intent.putExtra("sender", str);
                if (context.startService(intent) != null) {
                    return true;
                }
                return false;
            }
            Integer.valueOf(b2);
            return false;
        } catch (RuntimeException unused) {
        }
    }

    private static boolean c(Context context, String str) {
        try {
            Integer.valueOf(z.b(context.getPackageManager(), "com.google.android.gsf"));
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gsf");
            b(context, intent);
            intent.putExtra("sender", str);
            if (context.startService(intent) != null) {
                return true;
            }
            return false;
        } catch (RuntimeException unused) {
        }
    }

    private static void b(Context context, Intent intent) {
        intent.putExtra(TapjoyConstants.TJC_APP_PLACEMENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    }

    /* access modifiers changed from: protected */
    public final void a(Context context) {
        this.b.b(context, 3000);
    }

    public final boolean a(Intent intent) {
        String str;
        String stringExtra;
        boolean z;
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra2 = intent.getStringExtra("registration_id");
            String stringExtra3 = intent.getStringExtra("unregistered");
            String stringExtra4 = intent.getStringExtra("error");
            if (stringExtra2 != null) {
                if (stringExtra2.length() > 0) {
                    if (stringExtra2.startsWith("|")) {
                        return false;
                    }
                    f(stringExtra2);
                    return false;
                } else if (stringExtra3 == null && stringExtra4 == null && !this.c) {
                    this.c = true;
                    a();
                    return true;
                }
            }
            if (stringExtra3 != null) {
                String b2 = this.b.b(this.a);
                a(this.a);
                this.b.b(this.a, false);
                this.b.b(this.a, "");
                this.b.a(this.a, true);
                b(b2);
                return false;
            } else if (stringExtra4 == null) {
                return false;
            } else {
                if ("SERVICE_NOT_AVAILABLE".equals(stringExtra4)) {
                    z = c(stringExtra4);
                } else if (!this.c) {
                    c(stringExtra4);
                    this.c = true;
                    a();
                    return true;
                } else {
                    z = d(stringExtra4);
                }
                if (z) {
                    int g = this.b.g(this.a);
                    Integer.valueOf(g);
                    Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                    intent2.setPackage(this.a.getPackageName());
                    ((AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + ((long) g), PendingIntent.getBroadcast(this.a, 0, intent2, 0));
                    if (g < 3600000) {
                        this.b.b(this.a, g * 2);
                    }
                }
                return true;
            }
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            String stringExtra5 = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            if (stringExtra5 == null) {
                return a(this.a, intent);
            }
            if (Constants.MessageTypes.DELETED.equals(stringExtra5) && (stringExtra = intent.getStringExtra("total_deleted")) != null) {
                try {
                    int parseInt = Integer.parseInt(stringExtra);
                    Integer.valueOf(parseInt);
                    a(parseInt);
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        } else if (!"com.google.android.gcm.intent.RETRY".equals(action) || (str = intent.getPackage()) == null || !str.equals(this.a.getPackageName())) {
            return false;
        } else {
            a();
            return true;
        }
    }

    private synchronized void f(String str) {
        a(this.a);
        this.b.a(this.a, false);
        this.b.a(this.a, z.a(this.a));
        if (!str.equals(this.b.b(this.a))) {
            this.b.b(this.a, false);
            this.b.b(this.a, str);
            a(this.a, str);
        } else if (!b()) {
            a(this.a, str);
        }
    }
}
