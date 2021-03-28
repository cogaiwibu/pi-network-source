package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ThreadSafe
@SuppressLint({"StaticFieldLeak"})
/* renamed from: com.facebook.ads.redexgen.X.60  reason: invalid class name */
public final class AnonymousClass60 {
    public static EnumC01826j A06;
    public static byte[] A07;
    public static String[] A08;
    public static final AtomicReference<AnonymousClass60> A09 = new AtomicReference<>();
    public AnonymousClass62 A00;
    public AnonymousClass6U A01;
    public final Context A02;
    public final C01725z A03;
    public final AtomicReference<AnonymousClass6F> A04 = new AtomicReference<>();
    public final AtomicReference<TX> A05 = new AtomicReference<>();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{99, 101, 116, ByteCompanionObject.MAX_VALUE, 25, 20, 92, 90, 114, 109, 113};
    }

    public static void A02() {
        A08 = new String[]{"eZKmHpMMDfaoBqW8nqrxEoXtMavqlqNM", "AtFM24PyHDF8", "75v22abHTVt154frUD1Ye4KyqdVteY4i", "Q1X3dzo1KUJ0DHl8HY6jDpMlStfBjogW", "z2ZYiDayfErc", "35EgzrmLPkhoCqMLba9eqfKFMV7fawsP", "opJsobvHgIMCHkez4yG45JKspLs2PehX", "oVaFSOpmfGo5v5TJJzClDpDAWRdHWsbi"};
    }

    static {
        A02();
        A01();
    }

    public AnonymousClass60(Context context, C01725z r5, EnumC01826j r6) {
        this.A02 = context;
        this.A03 = r5;
        this.A01 = new AnonymousClass6U(this.A02, this.A03);
        if (this.A04.get() == null && AnonymousClass76.A0F(r6)) {
            A03(r6);
        }
    }

    private synchronized void A03(EnumC01826j r4) {
        if (this.A04.get() == null) {
            AnonymousClass6B.A03(this.A03.A0Z());
            TX tx = new TX(this.A03, this.A01);
            this.A05.set(tx);
            this.A00 = new AnonymousClass62();
            this.A00.A00(tx);
            if (this.A01.A06() && AnonymousClass76.A0F(r4)) {
                tx.A06(r4);
            }
            A06 = r4;
            this.A00.A01(r4);
            this.A04.set(AnonymousClass6F.A00(this.A02, this.A03));
        }
    }

    private boolean A04(EnumC01826j r5) {
        if (AnonymousClass76.A0F(r5)) {
            A03(r5);
        }
        if (r5.equals(A06)) {
            return false;
        }
        A06 = r5;
        AnonymousClass62 r0 = this.A00;
        if (r0 != null) {
            r0.A01(r5);
        }
        if (A08[0].charAt(4) != 't') {
            String[] strArr = A08;
            strArr[2] = "al3lqCaa3X6BhafyoLSdmdZ2qZ9PyUcx";
            strArr[2] = "al3lqCaa3X6BhafyoLSdmdZ2qZ9PyUcx";
            return true;
        }
        throw new RuntimeException();
    }

    private boolean A05(String str, EnumC01866n r5) {
        if (!AnonymousClass76.A0F(A06) || this.A04.get() == null) {
            return false;
        }
        AnonymousClass6U r2 = this.A01;
        if (r2 == null) {
            return true;
        }
        r2.A05(EnumC01846l.A02, A06, str, r5);
        return true;
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A06(MotionEvent motionEvent) {
        try {
            if (this.A04.get() != null) {
                this.A04.get().A06(motionEvent);
            }
        } catch (Throwable th) {
            AnonymousClass6B.A04(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final synchronized boolean A07(String str) {
        EnumC01866n r3;
        String string;
        boolean z = false;
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject(A00(0, 2, 69));
                    if (jSONObject == null) {
                        return false;
                    }
                    if (jSONObject.has(A00(6, 2, 106))) {
                        z = false | A04(EnumC01826j.A00(jSONObject.getInt(A00(6, 2, 106))));
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray(A00(2, 2, 83));
                    if (jSONObject.has(A00(8, 3, 69))) {
                        r3 = EnumC01866n.A00(jSONObject.getInt(A00(8, 3, 69)));
                    } else {
                        r3 = EnumC01866n.A04;
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(A00(4, 2, 52)) && (string = jSONObject2.getString(A00(4, 2, 52))) != null && !string.isEmpty()) {
                            AnonymousClass76.A0C(this.A03, AnonymousClass66.A04.A02(), string);
                            z |= A05(string, r3);
                        }
                    }
                    return z;
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    AnonymousClass6B.A04(th);
                }
            }
        }
        return false;
    }
}
