package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.h.o;

/* compiled from: Md5FileNameGenerator */
public class e implements c {
    @Override // com.bytedance.sdk.openadsdk.h.a.c
    public String a(String str) {
        String b = b(str);
        String d = o.d(str);
        if (TextUtils.isEmpty(b)) {
            return d;
        }
        return d + "." + b;
    }

    private String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }
}
