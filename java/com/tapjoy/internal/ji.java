package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompatExtras;
import java.util.ArrayList;

public final class ji {

    public static class a {
        final Bundle a;
        final jl[] b;
        final jl[] c;
        boolean d;
        public int e;
        public CharSequence f;
        public PendingIntent g;
    }

    public static class c {
        Bundle A;
        int B = 0;
        int C = 0;
        Notification D;
        RemoteViews E;
        RemoteViews F;
        RemoteViews G;
        String H;
        int I = 0;
        String J;
        long K;
        int L = 0;
        Notification M;
        @Deprecated
        public ArrayList N;
        public Context a;
        public ArrayList b = new ArrayList();
        CharSequence c;
        CharSequence d;
        PendingIntent e;
        PendingIntent f;
        RemoteViews g;
        Bitmap h;
        CharSequence i;
        int j;
        int k;
        boolean l = true;
        boolean m;
        d n;
        CharSequence o;
        CharSequence[] p;
        int q;
        int r;
        boolean s;
        String t;
        boolean u;
        String v;
        boolean w = false;
        boolean x;
        boolean y;
        String z;

        public c(Context context, String str) {
            Notification notification = new Notification();
            this.M = notification;
            this.a = context;
            this.H = str;
            notification.when = System.currentTimeMillis();
            this.M.audioStreamType = -1;
            this.k = 0;
            this.N = new ArrayList();
        }

        public final c a(int i2) {
            this.M.icon = i2;
            return this;
        }

        public final c a(CharSequence charSequence) {
            this.c = d(charSequence);
            return this;
        }

        public final c b(CharSequence charSequence) {
            this.d = d(charSequence);
            return this;
        }

        public final c a(PendingIntent pendingIntent) {
            this.e = pendingIntent;
            return this;
        }

        public final c c(CharSequence charSequence) {
            this.M.tickerText = d(charSequence);
            return this;
        }

        public final c a(Bitmap bitmap) {
            this.h = bitmap;
            return this;
        }

        public final c b() {
            this.M.defaults = 1;
            return this;
        }

        public final c c() {
            this.k = 0;
            return this;
        }

        public final c a(d dVar) {
            if (this.n != dVar) {
                this.n = dVar;
                if (dVar != null) {
                    dVar.a(this);
                }
            }
            return this;
        }

        public final Notification d() {
            Notification notification;
            jj jjVar = new jj(this);
            d dVar = jjVar.b.n;
            if (dVar != null) {
                dVar.a(jjVar);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                notification = jjVar.a.build();
            } else if (Build.VERSION.SDK_INT >= 24) {
                notification = jjVar.a.build();
                if (jjVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.g != 2)) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                jjVar.a.setExtras(jjVar.f);
                notification = jjVar.a.build();
                if (jjVar.c != null) {
                    notification.contentView = jjVar.c;
                }
                if (jjVar.d != null) {
                    notification.bigContentView = jjVar.d;
                }
                if (jjVar.h != null) {
                    notification.headsUpContentView = jjVar.h;
                }
                if (jjVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.g != 2)) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 20) {
                jjVar.a.setExtras(jjVar.f);
                notification = jjVar.a.build();
                if (jjVar.c != null) {
                    notification.contentView = jjVar.c;
                }
                if (jjVar.d != null) {
                    notification.bigContentView = jjVar.d;
                }
                if (jjVar.g != 0) {
                    if (!(notification.getGroup() == null || (notification.flags & 512) == 0 || jjVar.g != 2)) {
                        jj.a(notification);
                    }
                    if (notification.getGroup() != null && (notification.flags & 512) == 0 && jjVar.g == 1) {
                        jj.a(notification);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 19) {
                SparseArray<? extends Parcelable> a2 = jk.a(jjVar.e);
                if (a2 != null) {
                    jjVar.f.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a2);
                }
                jjVar.a.setExtras(jjVar.f);
                notification = jjVar.a.build();
                if (jjVar.c != null) {
                    notification.contentView = jjVar.c;
                }
                if (jjVar.d != null) {
                    notification.bigContentView = jjVar.d;
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                notification = jjVar.a.build();
                Bundle a3 = ji.a(notification);
                Bundle bundle = new Bundle(jjVar.f);
                for (String str : jjVar.f.keySet()) {
                    if (a3.containsKey(str)) {
                        bundle.remove(str);
                    }
                }
                a3.putAll(bundle);
                SparseArray<? extends Parcelable> a4 = jk.a(jjVar.e);
                if (a4 != null) {
                    ji.a(notification).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a4);
                }
                if (jjVar.c != null) {
                    notification.contentView = jjVar.c;
                }
                if (jjVar.d != null) {
                    notification.bigContentView = jjVar.d;
                }
            } else {
                notification = jjVar.a.getNotification();
            }
            if (jjVar.b.E != null) {
                notification.contentView = jjVar.b.E;
            }
            int i2 = Build.VERSION.SDK_INT;
            int i3 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 16 && dVar != null) {
                ji.a(notification);
            }
            return notification;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public final c a() {
            this.M.flags |= 16;
            return this;
        }
    }

    public static abstract class d {
        protected c a;
        CharSequence b;
        CharSequence c;
        boolean d = false;

        public void a(jh jhVar) {
        }

        public final void a(c cVar) {
            if (this.a != cVar) {
                this.a = cVar;
                if (cVar != null) {
                    cVar.a(this);
                }
            }
        }
    }

    public static class b extends d {
        private CharSequence e;

        public final b a(CharSequence charSequence) {
            this.b = c.d(charSequence);
            return this;
        }

        public final b b(CharSequence charSequence) {
            this.e = c.d(charSequence);
            return this;
        }

        @Override // com.tapjoy.internal.ji.d
        public final void a(jh jhVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(jhVar.a()).setBigContentTitle(this.b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.c);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return jk.a(notification);
        }
        return null;
    }
}
