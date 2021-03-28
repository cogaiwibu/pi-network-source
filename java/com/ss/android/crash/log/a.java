package com.ss.android.crash.log;

import android.os.FileObserver;
import android.text.TextUtils;

/* compiled from: ANRFileObserver */
public class a extends FileObserver {
    private final c a;

    public a(c cVar, String str, int i) {
        super(str, i);
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.a = cVar;
    }

    public void onEvent(int i, String str) {
        c cVar;
        if (i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && (cVar = this.a) != null) {
            cVar.b(200, "/data/anr/" + str);
        }
    }
}
