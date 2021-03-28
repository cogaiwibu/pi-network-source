package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Wo  reason: case insensitive filesystem */
public final class View$OnClickListenerC0827Wo extends C0585Nd implements View.OnClickListener {
    @Nullable
    public String A00;
    @Nullable
    public String A01;
    public final C0583Nb A02;
    public final Map<String, String> A03 = new HashMap();

    public View$OnClickListenerC0827Wo(C0820Wh wh, String str, AnonymousClass1H r10, JE je, M6 m6, C0641Ph ph, LX lx) {
        super(wh, r10);
        this.A02 = new C0583Nb(wh, str, ph, lx, je, m6);
        setOnClickListener(this);
        C0535Le.A0J(1001, this);
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (TextUtils.isEmpty(this.A00)) {
                    return;
                }
                if (!TextUtils.isEmpty(this.A01)) {
                    this.A02.A08(this.A00, this.A01, this.A03);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }

    public void setCta(AnonymousClass1I r2, String str, Map<String, String> map) {
        setCta(r2, str, map, null);
    }

    public void setCta(AnonymousClass1I r3, String str, Map<String, String> map, @Nullable AbstractC0582Na na) {
        this.A00 = str;
        this.A01 = r3.A04();
        this.A03.putAll(map);
        this.A02.A07(na);
        String A032 = r3.A03();
        if (TextUtils.isEmpty(A032) || TextUtils.isEmpty(this.A01)) {
            setVisibility(8);
        } else {
            setText(A032);
        }
    }

    public void setIsInAppBrowser(boolean z) {
        this.A02.A09(z);
    }
}
