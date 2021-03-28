package com.bytedance.sdk.openadsdk.d.b;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* compiled from: LogUploaderImpl */
public class c implements a {
    private final b a = b.b();
    private final List<a> b = Collections.synchronizedList(new LinkedList());
    private final ExecutorService c = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: protected */
    public int b() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.d.b.a
    public void a() {
        this.c.execute(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.d.b.c.AnonymousClass1 */

            public void run() {
                List<a> e = c.this.a.e();
                if (e != null) {
                    c.this.b.addAll(e);
                }
                c.this.a.d();
            }
        });
    }

    public void a(com.bytedance.sdk.openadsdk.d.a.a aVar) {
        if (aVar != null) {
            new b(new a(UUID.randomUUID().toString(), aVar.a())).executeOnExecutor(this.c, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LogUploaderImpl */
    public class b extends AsyncTask<Void, Void, Void> {
        a a;

        b(a aVar) {
            this.a = aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            c.this.b.add(0, this.a);
            c.this.a.a(this.a);
            if (!m.a(j.a())) {
                return null;
            }
            int b2 = c.this.b();
            Iterator it = c.this.b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.b != null && !TextUtils.isEmpty(aVar.a)) {
                    if (j.c().a(aVar.b, b2)) {
                        it.remove();
                        c.this.a.b(aVar);
                    } else {
                        c.this.a.c(aVar);
                        c.this.a.d();
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: LogUploaderImpl */
    public static class a {
        public final String a;
        public final JSONObject b;

        public a(String str, JSONObject jSONObject) {
            this.a = str;
            this.b = jSONObject;
        }
    }
}
