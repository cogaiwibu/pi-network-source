package com.bytedance.sdk.adnet.core;

import android.content.Context;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.b;
import java.io.File;

/* compiled from: QueueManager */
public class k {
    public static l a(Context context, IHttpStack iHttpStack) {
        if (iHttpStack == null) {
            iHttpStack = new h();
        }
        return a(context, new a(iHttpStack));
    }

    private static l a(Context context, b bVar) {
        l lVar = new l(new f(new File(a.a(context), "reqQueue")), bVar);
        lVar.a();
        return lVar;
    }
}
