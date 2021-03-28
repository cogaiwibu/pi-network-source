package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

public final class cu {
    public final cx a;
    final WebView b = null;
    public final List c;
    final String d;
    public final String e;
    public final cv f;

    private cu(cx cxVar, String str, List list, String str2) {
        cv cvVar;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = cxVar;
        this.d = str;
        if (list != null) {
            arrayList.addAll(list);
            cvVar = cv.NATIVE;
        } else {
            cvVar = cv.HTML;
        }
        this.f = cvVar;
        this.e = str2;
    }

    public static cu a(cx cxVar, String str, List list, String str2) {
        Cdo.a(cxVar, "Partner is null");
        Cdo.a((Object) str, "OM SDK JS script content is null");
        Cdo.a(list, "VerificationScriptResources is null");
        if (str2.length() <= 256) {
            return new cu(cxVar, str, list, str2);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
