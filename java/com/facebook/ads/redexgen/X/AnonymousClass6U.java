package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.6U  reason: invalid class name */
public final class AnonymousClass6U {
    public static final String A08 = AnonymousClass6U.class.getSimpleName();
    public final int A00;
    public final Context A01;
    public final C01725z A02;
    public final AnonymousClass6G A03 = new AnonymousClass6G();
    public final TY A04;
    public final TZ A05;
    public final C0735Ta A06;
    public final AnonymousClass71 A07;

    public AnonymousClass6U(Context context, C01725z r5) {
        AnonymousClass6X r2 = new AnonymousClass6X(context, new AnonymousClass6Y(new C01736a(context, r5)), r5);
        this.A01 = context;
        this.A05 = r2.A0B();
        this.A06 = r2.A0C();
        this.A04 = r2.A0A();
        this.A00 = r2.A09();
        this.A02 = r5;
        this.A03.A01(this.A04);
        this.A07 = r2.A0D();
        this.A07.A03();
    }

    /* JADX INFO: Multiple debug info for r0v7 java.util.List<com.facebook.ads.redexgen.X.6x>: [D('jsonArray' org.json.JSONArray), D('key' java.lang.Integer)] */
    @SuppressLint({"BadMethodUse-android.util.Log.e", "CatchGeneralException"})
    public static JSONObject A00() {
        JSONObject jsonSignalObject = new JSONObject();
        Map<Integer, AnonymousClass64<AbstractC01966x>> A032 = C01836k.A01().A03();
        if (A032 == null || A032.isEmpty()) {
            return jsonSignalObject;
        }
        try {
            for (Integer num : A032.keySet()) {
                List<AbstractC01966x> A042 = A032.get(num).A04();
                JSONArray jSONArray = new JSONArray();
                for (AbstractC01966x r1 : A042) {
                    jSONArray.put(r1.A0A(true));
                }
                jsonSignalObject.put(num.toString(), jSONArray);
            }
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
        return jsonSignalObject;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    private void A01(String str, EnumC01826j r14, EnumC01866n r15) {
        AnonymousClass69 A0Y = this.A02.A0Y();
        if (A0Y != null) {
            A0Y.A8I(AnonymousClass76.A05(), str, this.A00, r14.A03(), (int) (System.currentTimeMillis() / 1000), A00(), r15);
        }
        AnonymousClass76.A0C(this.A02, AnonymousClass66.A07.A02(), str);
    }

    public final void A02() {
        this.A03.A00();
    }

    public final void A03(EnumC01826j r3) {
        this.A04.A04(r3, this.A01);
    }

    public final void A04(EnumC01846l r2, EnumC01826j r3, @Nullable String str) {
        A05(r2, r3, str, EnumC01866n.A04);
    }

    public final void A05(EnumC01846l r2, EnumC01826j r3, @Nullable String str, EnumC01866n r5) {
        this.A05.A05(r3);
        if (r2 == EnumC01846l.A02) {
            this.A06.A04(r3);
            if (str != null) {
                A01(str, r3, r5);
            }
        }
    }

    public final boolean A06() {
        List<C01786f> A032 = this.A05.A03();
        return A032 != null && !A032.isEmpty();
    }
}
