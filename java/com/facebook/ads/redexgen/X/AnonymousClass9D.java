package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.9D  reason: invalid class name */
public class AnonymousClass9D implements Callable<Boolean> {
    public final /* synthetic */ SharedPreferences A00;
    public final /* synthetic */ AnonymousClass8H A01;
    public final /* synthetic */ String A02;

    public AnonymousClass9D(AnonymousClass8H r1, SharedPreferences sharedPreferences, String str) {
        this.A01 = r1;
        this.A00 = sharedPreferences;
        this.A02 = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final Boolean call() throws Exception {
        AnonymousClass8H r1 = this.A01;
        String unused = XJ.A03 = XJ.A02(r1, r1.getPackageName());
        this.A00.edit().putString(this.A02, XJ.A03).apply();
        XJ.A08.set(2);
        return true;
    }
}
