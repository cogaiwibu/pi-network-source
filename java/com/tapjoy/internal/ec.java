package com.tapjoy.internal;

import android.text.TextUtils;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class ec extends dx {
    public ec(dy.b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.dy
    /* renamed from: a */
    public final void onPostExecute(String str) {
        dd a;
        if (!TextUtils.isEmpty(str) && (a = dd.a()) != null) {
            for (cz czVar : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(czVar.f)) {
                    ds dsVar = czVar.c;
                    if (this.c >= dsVar.e) {
                        dsVar.d = ds.a.b;
                        dg.a().b(dsVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (dm.b(this.b, this.e.a())) {
            return null;
        }
        this.e.a(this.b);
        return this.b.toString();
    }
}
