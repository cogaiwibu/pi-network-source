package com.tapjoy.internal;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatExtras;
import androidx.core.app.NotificationManagerCompat;
import com.tapjoy.internal.ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public final class jj implements jh {
    final Notification.Builder a;
    final ji.c b;
    RemoteViews c;
    RemoteViews d;
    final List e = new ArrayList();
    final Bundle f = new Bundle();
    int g;
    RemoteViews h;

    jj(ji.c cVar) {
        this.b = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new Notification.Builder(cVar.a, cVar.H);
        } else {
            this.a = new Notification.Builder(cVar.a);
        }
        Notification notification = cVar.M;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.g).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.c).setContentText(cVar.d).setContentInfo(cVar.i).setContentIntent(cVar.e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f, (notification.flags & 128) != 0).setLargeIcon(cVar.h).setNumber(cVar.j).setProgress(cVar.q, cVar.r, cVar.s);
        if (Build.VERSION.SDK_INT < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setSubText(cVar.o).setUsesChronometer(cVar.m).setPriority(cVar.k);
            Iterator it = cVar.b.iterator();
            while (it.hasNext()) {
                a((ji.a) it.next());
            }
            if (cVar.A != null) {
                this.f.putAll(cVar.A);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.w) {
                    this.f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                if (cVar.t != null) {
                    this.f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, cVar.t);
                    if (cVar.u) {
                        this.f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                if (cVar.v != null) {
                    this.f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, cVar.v);
                }
            }
            this.c = cVar.E;
            this.d = cVar.F;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setShowWhen(cVar.l);
            if (Build.VERSION.SDK_INT < 21 && cVar.N != null && !cVar.N.isEmpty()) {
                this.f.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) cVar.N.toArray(new String[cVar.N.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.a.setLocalOnly(cVar.w).setGroup(cVar.t).setGroupSummary(cVar.u).setSortKey(cVar.v);
            this.g = cVar.L;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setCategory(cVar.z).setColor(cVar.B).setVisibility(cVar.C).setPublicVersion(cVar.D).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = cVar.N.iterator();
            while (it2.hasNext()) {
                this.a.addPerson((String) it2.next());
            }
            this.h = cVar.G;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.a.setExtras(cVar.A).setRemoteInputHistory(cVar.p);
            if (cVar.E != null) {
                this.a.setCustomContentView(cVar.E);
            }
            if (cVar.F != null) {
                this.a.setCustomBigContentView(cVar.F);
            }
            if (cVar.G != null) {
                this.a.setCustomHeadsUpContentView(cVar.G);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setBadgeIconType(cVar.I).setShortcutId(cVar.J).setTimeoutAfter(cVar.K).setGroupAlertBehavior(cVar.L);
            if (cVar.y) {
                this.a.setColorized(cVar.x);
            }
            if (!TextUtils.isEmpty(cVar.H)) {
                this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    @Override // com.tapjoy.internal.jh
    public final Notification.Builder a() {
        return this.a;
    }

    private void a(ji.a aVar) {
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.e, aVar.f, aVar.g);
            if (aVar.b != null) {
                for (RemoteInput remoteInput : jl.a(aVar.b)) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.a != null) {
                bundle = new Bundle(aVar.a);
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.d);
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.d);
            }
            builder.addExtras(bundle);
            this.a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.e.add(jk.a(this.a, aVar));
        }
    }

    static void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
