package com.tapjoy.internal;

import android.os.AsyncTask;
import org.json.JSONObject;

public abstract class dy extends AsyncTask {
    a d;
    protected final b e;

    public interface a {
        void a();
    }

    public interface b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public dy(b bVar) {
        this.e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
