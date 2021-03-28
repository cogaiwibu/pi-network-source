package com.tapjoy.internal;

import com.tapjoy.internal.ij;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class hh implements cf {
    public final gz a;
    Set b = null;
    private final Map c = Collections.synchronizedMap(new HashMap());
    private final Map d = ju.a();

    public hh(gz gzVar) {
        this.a = gzVar;
    }

    /* access modifiers changed from: private */
    public void a(ca caVar, ij.a aVar) {
        if (caVar instanceof ij) {
            if (aVar.b != null) {
                List list = aVar.b;
                synchronized (this) {
                    this.b = list instanceof Collection ? new HashSet(js.a(list)) : jv.a(list.iterator());
                }
            }
            ij ijVar = (ij) caVar;
            String str = ijVar.c;
            boolean z = ijVar.d;
            this.d.remove(str);
            if (!z) {
                this.c.put(str, aVar.a);
            }
            hg hgVar = aVar.a;
            ha haVar = this.a.p;
            if (hgVar instanceof hf) {
                gw.a("No content for \"{}\"", str);
                haVar.a(str);
                return;
            }
            gw.a("New content for \"{}\" is ready", str);
            if (z) {
                hgVar.a(haVar, new fw());
            } else {
                haVar.b(str);
            }
        } else {
            throw new IllegalStateException(caVar.getClass().getName());
        }
    }

    @Override // com.tapjoy.internal.cf
    public final void a(ca caVar) {
        a(caVar, new ij.a(new hf(), null));
    }
}
