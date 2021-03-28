package com.ss.android.crash.log;

import android.content.Context;
import com.ss.android.crash.log.f;
import com.ss.android.crash.log.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: CrashInfoManager */
public class i implements f.a {
    private static volatile i a;
    private Context b;
    private f c = new f(this.b, this);
    private k d;
    private long e = System.currentTimeMillis();

    static i b() {
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("CrashInfoManager not inited");
    }

    static void a(Context context, j.a aVar) {
        if (a == null) {
            synchronized (i.class) {
                a = new i(context, aVar);
            }
        }
    }

    private i(Context context, j.a aVar) {
        this.b = context.getApplicationContext();
        this.d = new k(this.b, aVar);
    }

    public void a(JSONObject jSONObject) throws Throwable {
        f fVar;
        if (jSONObject != null && jSONObject.length() > 0 && this.d != null && (fVar = this.c) != null) {
            jSONObject.put("last_create_activity", fVar.b());
            jSONObject.put("last_resume_activity", this.c.c());
            jSONObject.put("app_start_time", this.e);
            jSONObject.put("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US).format(new Date(this.e)));
            jSONObject.put("alive_activities", this.c.a());
            jSONObject.put("running_task_info", this.c.d());
            this.d.a(jSONObject);
        }
    }

    @Override // com.ss.android.crash.log.f.a
    public void a() {
        k kVar = this.d;
        if (kVar != null) {
            kVar.a();
        }
    }
}
