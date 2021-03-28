package com.tapjoy.internal;

import com.tapjoy.internal.ds;
import com.tapjoy.internal.dy;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class eb extends dx {
    public eb(dy.b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.dy
    /* renamed from: a */
    public final void onPostExecute(String str) {
        dd a = dd.a();
        if (a != null) {
            for (cz czVar : Collections.unmodifiableCollection(a.a)) {
                if (this.a.contains(czVar.f)) {
                    ds dsVar = czVar.c;
                    if (this.c >= dsVar.e && dsVar.d != ds.a.c) {
                        dsVar.d = ds.a.c;
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
        return this.b.toString();
    }
}
