package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.internal.di;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class dk implements di {
    private final di a;

    public dk(di diVar) {
        this.a = diVar;
    }

    @Override // com.tapjoy.internal.di
    public final JSONObject a(View view) {
        return dm.a(0, 0, 0, 0);
    }

    @Override // com.tapjoy.internal.di
    public final void a(View view, JSONObject jSONObject, di.a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        dd a2 = dd.a();
        if (a2 != null) {
            Collection<cz> unmodifiableCollection = Collections.unmodifiableCollection(a2.b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (cz czVar : unmodifiableCollection) {
                View c = czVar.c();
                if (c != null && dp.b(c) && (rootView = c.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a3 = dp.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && dp.a((View) arrayList.get(size - 1)) > a3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar.a((View) it.next(), this.a, jSONObject);
        }
    }
}
