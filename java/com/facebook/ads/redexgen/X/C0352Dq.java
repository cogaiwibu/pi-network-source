package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Dq  reason: case insensitive filesystem */
public final class C0352Dq {
    public final String A00;
    public final boolean A01;

    public C0352Dq(String str, boolean z) {
        this.A00 = str;
        this.A01 = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != C0352Dq.class) {
            return false;
        }
        C0352Dq dq = (C0352Dq) obj;
        if (!TextUtils.equals(this.A00, dq.A00) || this.A01 != dq.A01) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int result;
        int result2;
        int i = 1 * 31;
        String str = this.A00;
        if (str == null) {
            result = 0;
        } else {
            result = str.hashCode();
        }
        int result3 = (i + result) * 31;
        if (this.A01) {
            result2 = 1231;
        } else {
            result2 = 1237;
        }
        return result3 + result2;
    }
}
