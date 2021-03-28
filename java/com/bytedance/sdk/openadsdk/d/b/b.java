package com.bytedance.sdk.openadsdk.d.b;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.d.b.c;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LogStatsCache */
public class b {
    private static volatile b a;
    private Context b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static String a() {
        return "CREATE TABLE IF NOT EXISTS " + "logstats" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "value" + " TEXT ," + "gen_time" + " TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0" + ")";
    }

    public static b b() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
        c();
    }

    public void c() {
        if (!this.c.get() && j.a() != null) {
            this.b = j.a();
            this.c.set(true);
        }
    }

    public synchronized void a(c.a aVar) {
        if (!this.c.get()) {
            c();
        } else if (aVar != null && aVar.b != null && !TextUtils.isEmpty(aVar.a)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(aVar);
            a(linkedList);
        }
    }

    public synchronized void a(List<c.a> list) {
        if (!this.c.get()) {
            c();
        } else if (list != null && !list.isEmpty()) {
            for (c.a aVar : list) {
                if (aVar.b != null && !TextUtils.isEmpty(aVar.a)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", aVar.a);
                    contentValues.put("value", aVar.b.toString());
                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues.put(TapjoyConstants.TJC_RETRY, (Integer) 0);
                    a.a(this.b, "logstats", contentValues);
                }
            }
        }
    }

    public synchronized void b(c.a aVar) {
        if (!this.c.get()) {
            c();
        } else if (aVar != null && !TextUtils.isEmpty(aVar.a)) {
            a.a(this.b, "logstats", "id=?", new String[]{aVar.a});
        }
    }

    public synchronized void d() {
        if (!this.c.get()) {
            c();
            return;
        }
        try {
            a.a(this.b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
        } catch (Throwable unused) {
        }
    }

    public synchronized void c(c.a aVar) {
        if (!this.c.get()) {
            c();
        } else if (aVar.b != null && !TextUtils.isEmpty(aVar.a)) {
            a.a(this.b, "UPDATE " + "logstats" + " SET " + TapjoyConstants.TJC_RETRY + " = " + TapjoyConstants.TJC_RETRY + "+1" + " WHERE id='" + aVar.a + "'");
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c A[LOOP:0: B:9:0x003c->B:26:0x003c, LOOP_START, SYNTHETIC, Splitter:B:9:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.d.b.c.a> e() {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.d.b.b.e():java.util.List");
    }
}
